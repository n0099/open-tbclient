package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import java.security.KeyStoreException;
/* loaded from: classes5.dex */
public class WalletFingerprint implements NoProguard {
    public static int SUPPORT_API_LEVEL = 23;

    /* renamed from: a  reason: collision with root package name */
    public static WalletFingerprint f25619a;

    /* renamed from: b  reason: collision with root package name */
    public IFingerprintPay f25620b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a.a f25621c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25622d;

    /* renamed from: e  reason: collision with root package name */
    public PhoneSupportStatus f25623e = PhoneSupportStatus.UNSUPPORT;

    /* loaded from: classes5.dex */
    public enum FpType {
        SYSTEM_FINGERPRINT,
        FIDO_FINGERPRINT
    }

    /* loaded from: classes5.dex */
    public enum PhoneSupportStatus {
        UNSUPPORT,
        SUPPORT_SYS
    }

    public WalletFingerprint(Context context) {
        this.f25622d = context.getApplicationContext();
    }

    private void a() {
        if (SecurityUtils.isRoot()) {
            this.f25623e = PhoneSupportStatus.UNSUPPORT;
        } else if (b()) {
            LogUtil.d("WalletFingerprint", "Only support system!");
            this.f25623e = PhoneSupportStatus.SUPPORT_SYS;
        } else {
            LogUtil.d("WalletFingerprint", "None support!");
            this.f25623e = PhoneSupportStatus.UNSUPPORT;
        }
    }

    @TargetApi(23)
    private boolean b() {
        if (PermissionManager.checkCallingPermission(this.f25622d, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= SUPPORT_API_LEVEL) {
            FingerprintManager fingerprintManager = (FingerprintManager) this.f25622d.getSystemService(FingerprintManager.class);
            try {
                a a2 = a.a(this.f25622d);
                return a2 != null && a2.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected();
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static WalletFingerprint getInstance(Context context) {
        if (f25619a == null) {
            synchronized (WalletFingerprint.class) {
                if (f25619a == null) {
                    f25619a = new WalletFingerprint(context);
                }
            }
        }
        return f25619a;
    }

    public static String getKeyStoreAlise(Context context) {
        String ppKey = PayPreferenceManager.getPpKey(context.getApplicationContext());
        return a.f25624b + "_" + ppKey + "_" + BeanConstants.CHANNEL_ID;
    }

    public static String getKeyStoreNewAlise(Context context) {
        String newPpKey = PayPreferenceManager.getNewPpKey(context.getApplicationContext());
        return a.f25624b + "_" + newPpKey + "_" + BeanConstants.CHANNEL_ID;
    }

    @TargetApi(23)
    public void cancleListening() {
        LogUtil.d("WalletFingerprint", "WalletFingerprint.cancleListening");
        com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f25621c;
        if (aVar != null) {
            aVar.a();
            this.f25621c.d();
            this.f25621c = null;
        }
    }

    public void clearOTPToken() {
        LogUtil.d("WalletFingerprint", "clearOTPToken");
        SharedPreferencesUtils.setParam(this.f25622d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getPpKey(this.f25622d), "");
        SharedPreferencesUtils.setParam(this.f25622d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f25622d), "");
    }

    public void close(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.f25620b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, "");
        } else {
            fingerprintPay.close(activity, fingerprintCallback);
        }
    }

    public String generateOTPKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String safeSavedDataByUnionId = OtpTokenUtils.getSafeSavedDataByUnionId(str, this.f25622d);
        LogUtil.d("WalletFingerprint", "generateDynamickey tokeninfo=" + safeSavedDataByUnionId);
        String[] split = safeSavedDataByUnionId.split("\\|");
        if (split.length == 9) {
            int i = 6;
            int i2 = 1;
            try {
                i = Integer.valueOf(split[5].substring(split[5].length() - 1, split[5].length())).intValue();
                i2 = Integer.valueOf(split[7]).intValue();
            } catch (Exception unused) {
            }
            LogUtil.d("WalletFingerprint", "generateDynamicKey() key.length=" + i + "&& timeStep=" + i2);
            return OtpTokenUtils.getEncryptTOtpCode(this.f25622d, i2, safeSavedDataByUnionId.split("\\|")[3], i);
        }
        return null;
    }

    public IFingerprintPay getFingerprintPay() {
        a();
        if (this.f25623e == PhoneSupportStatus.SUPPORT_SYS) {
            return new SysFingerprintPay();
        }
        return null;
    }

    public String getSN() {
        String[] split = new String(Base64.decode((String) SharedPreferencesUtils.getParam(this.f25622d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f25622d), ""), 0)).split("\\|");
        if (split.length == 3) {
            return SafePay.getInstance().localDecrypt1(split[2]);
        }
        return null;
    }

    public boolean hasEnrollFingerprint() {
        if (PermissionManager.checkCallingPermission(this.f25622d, "android.permission.USE_FINGERPRINT") && isDevicesSupport()) {
            return a(this.f25622d);
        }
        return false;
    }

    public boolean hasOTPToken() {
        return !TextUtils.isEmpty((String) SharedPreferencesUtils.getParam(this.f25622d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f25622d), ""));
    }

    public boolean isDevicesSupport() {
        if (PermissionManager.checkCallingPermission(this.f25622d, "android.permission.USE_FINGERPRINT")) {
            a();
            return this.f25623e != PhoneSupportStatus.UNSUPPORT;
        }
        return false;
    }

    public void open(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.f25620b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, "");
        } else {
            fingerprintPay.open(activity, fingerprintCallback);
        }
    }

    @TargetApi(23)
    public void startListening(b bVar) {
        this.f25620b = getFingerprintPay(FpType.SYSTEM_FINGERPRINT);
        try {
            this.f25621c = new com.baidu.wallet.paysdk.fingerprint.a.a(this.f25622d);
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
        }
        com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f25621c;
        if (aVar != null && this.f25620b != null) {
            aVar.a(bVar);
            this.f25621c.a(2);
            return;
        }
        bVar.a(-1, "");
    }

    public void verify(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
        this.f25620b = fingerprintPay;
        if (fingerprintPay == null) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, "");
        } else {
            fingerprintPay.verify(activity, fingerprintCallback);
        }
    }

    public IFingerprintPay getFingerprintPay(FpType fpType) {
        a();
        PhoneSupportStatus phoneSupportStatus = this.f25623e;
        if (phoneSupportStatus != PhoneSupportStatus.UNSUPPORT && fpType == FpType.SYSTEM_FINGERPRINT && phoneSupportStatus == PhoneSupportStatus.SUPPORT_SYS) {
            return new SysFingerprintPay();
        }
        return null;
    }

    @TargetApi(23)
    private boolean a(Context context) {
        FingerprintManager fingerprintManager;
        return PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= 23 && (fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class)) != null && fingerprintManager.hasEnrolledFingerprints();
    }
}
