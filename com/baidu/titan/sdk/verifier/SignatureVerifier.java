package com.baidu.titan.sdk.verifier;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
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
    public final HashSet mAllowedSigs = new HashSet();

    /* renamed from: com.baidu.titan.sdk.verifier.SignatureVerifier$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class AnonymousClass1 {
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
        if (!this.mAllowedSigs.equals(hashSet)) {
            return false;
        }
        return true;
    }

    private boolean hasSignatureSchemeV2() throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(this.mPatchFile);
    }

    private boolean verifySignatureSchemeV1() {
        System.currentTimeMillis();
        try {
            Certificate[] verify = ApkSignatureSchemeV1Verifier.verify(this.mPatchFile);
            if (verify != null) {
                if (compareSignature(verify)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
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
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        } catch (CertificateEncodingException e4) {
            e4.printStackTrace();
        }
        return false;
    }

    private void initSignatures() {
        String assetFileContent = Files.getAssetFileContent(this.mContext, TitanConstant.VERIFY_CONFIG_ASSETS_PATH);
        if (TextUtils.isEmpty(assetFileContent)) {
            Log.e("SigVerifier", "cannot find sig-config");
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
                for (int i = 0; i < length; i++) {
                    this.mAllowedSigs.add(jSONArray.getString(i));
                }
            }
        } catch (Exception unused2) {
        }
    }

    public int verifySignature() {
        int i = AnonymousClass1.$SwitchMap$com$baidu$titan$sdk$verifier$SignaturePolicy[this.mSignaturePolicy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return -5;
                    }
                    return 0;
                } else if (!verifySignatureSchemeV1()) {
                    return -5;
                } else {
                    return 0;
                }
            } else if (!verifySignatureSchemeV2()) {
                return -5;
            } else {
                return 0;
            }
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
