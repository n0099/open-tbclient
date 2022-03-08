package com.baidu.titan.sdk.verifier;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SignatureVerifier {
    public static final String TAG = "SigVerifier";
    public Context mContext;
    public File mPatchFile;
    public SignaturePolicy mSignaturePolicy = SignaturePolicy.V2_ONLY;
    public final HashSet<String> mAllowedSigs = new HashSet<>();

    /* renamed from: com.baidu.titan.sdk.verifier.SignatureVerifier$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy;

        static {
            int[] iArr = new int[SignaturePolicy.values().length];
            $SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy = iArr;
            try {
                iArr[SignaturePolicy.V2_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy[SignaturePolicy.V2_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy[SignaturePolicy.V1_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy[SignaturePolicy.NO_SIGNATURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SignatureVerifier(Context context, File file) {
        this.mContext = context;
        this.mPatchFile = file;
        initSignatures();
    }

    private boolean compareSignature(Certificate[] certificateArr) throws CertificateEncodingException {
        HashSet hashSet = new HashSet();
        for (Certificate certificate : certificateArr) {
            hashSet.add(EncodeUtils.bytesToHex(EncodeUtils.sha1(new Signature(certificate.getEncoded()).toByteArray())));
        }
        return this.mAllowedSigs.equals(hashSet);
    }

    private boolean hasSignatureSchemeV2() throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(this.mPatchFile);
    }

    private void initSignatures() {
        String assetFileContent = Files.getAssetFileContent(this.mContext, TitanConstant.VERIFY_CONFIG_ASSETS_PATH);
        if (TextUtils.isEmpty(assetFileContent)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(assetFileContent);
            try {
                this.mSignaturePolicy = SignaturePolicy.valueOf(jSONObject.getString("signaturePolicy"));
            } catch (Exception unused) {
                this.mSignaturePolicy = SignaturePolicy.V2_ONLY;
            }
            if (this.mSignaturePolicy != SignaturePolicy.NO_SIGNATURE) {
                JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.mAllowedSigs.add(jSONArray.getString(i2));
                }
            }
        } catch (Exception unused2) {
        }
    }

    private boolean verifySignatureSchemeV1() {
        System.currentTimeMillis();
        try {
            Certificate[] verify = ApkSignatureSchemeV1Verifier.verify(this.mPatchFile);
            if (verify != null) {
                return compareSignature(verify);
            }
            return false;
        } catch (CertificateEncodingException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean verifySignatureSchemeV2() {
        X509Certificate[][] verify;
        System.currentTimeMillis();
        try {
            for (X509Certificate[] x509CertificateArr : ApkSignatureSchemeV2Verifier.verify(this.mPatchFile)) {
                if (x509CertificateArr != null && compareSignature(x509CertificateArr)) {
                    return true;
                }
            }
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (SecurityException e4) {
            e4.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public int verifySignature() {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy[this.mSignaturePolicy.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i2 != 3 ? i2 != 4 ? -5 : 0 : !verifySignatureSchemeV1() ? -5 : 0 : !verifySignatureSchemeV2() ? -5 : 0;
        }
        try {
            if (hasSignatureSchemeV2()) {
                if (!verifySignatureSchemeV2()) {
                    return -5;
                }
            } else if (!verifySignatureSchemeV1()) {
                return -5;
            }
            return 0;
        } catch (IOException unused) {
            return -5;
        }
    }
}
