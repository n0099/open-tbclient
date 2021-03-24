package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.datamodel.OpenFingerprintResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
import java.security.KeyStoreException;
@TargetApi(23)
/* loaded from: classes5.dex */
public class SysFingerprintPay implements IFingerprintPay {
    public static final int MSG_DISMISS_LOADING_DIALOG = 4097;
    public static final int MSG_SHOW_LOADING_DIALOG = 4096;
    public static final String TAG = SysFingerprintPay.class.getSimpleName();
    public FingerprintHandler mSysFpHander = new FingerprintHandler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class FingerprintHandler extends Handler implements Serializable {
        public FingerprintHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 4096) {
                WalletGlobalUtils.showLoadingDialog((Activity) message.obj);
            } else if (i == 4097) {
                WalletGlobalUtils.DismissLoadingDialog();
            } else {
                super.handleMessage(message);
            }
        }
    }

    private boolean checkFingerprintAvailable(Context context) {
        if (PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT")) {
            a aVar = null;
            FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
            try {
                aVar = a.a(context);
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
            }
            return aVar != null && aVar.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints();
        }
        return false;
    }

    private boolean isNonePayingProcess(Activity activity) {
        return activity instanceof NonePayingProcess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOTPTokenByFingerprint(Activity activity, String str, FingerprintCallback fingerprintCallback) {
        try {
            com.baidu.wallet.paysdk.fingerprint.ui.a a2 = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 1, str, fingerprintCallback);
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(a2, "FingerprintPayDialog");
            beginTransaction.commitAllowingStateLoss();
        } catch (KeyStoreException unused) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void close(final Activity activity, final FingerprintCallback fingerprintCallback) {
        String sn = WalletFingerprint.getInstance(activity.getApplicationContext()).getSN();
        com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) activity, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, TAG);
        WalletGlobalUtils.showLoadingDialog(activity);
        aVar.a(sn);
        aVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i, int i2, final String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                SysFingerprintPay.this.mSysFpHander.post(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, str);
                    }
                });
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i, Object obj, String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                WalletFingerprint.getInstance(activity).clearOTPToken();
                SysFingerprintPay.this.mSysFpHander.post(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 0, "");
                    }
                });
            }
        });
        aVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void destory() {
        FingerprintHandler fingerprintHandler = this.mSysFpHander;
        if (fingerprintHandler != null) {
            fingerprintHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void open(final Activity activity, final FingerprintCallback fingerprintCallback) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (!isNonePayingProcess(activity)) {
            if (payRequest.FP_Guide_Strategy > 0) {
                register(activity, fingerprintCallback);
                return;
            }
            return;
        }
        PasswordController.getPassWordInstance().checkPwd(activity, BeanConstants.FROM_FINGERPRINT_PAY, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.1
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i, String str) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, str);
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                ((PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD)).mPayPass = str;
                SysFingerprintPay.this.register(activity, fingerprintCallback);
            }
        });
    }

    public void register(final Activity activity, final FingerprintCallback fingerprintCallback) {
        Context applicationContext = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_sys_too_low"));
        } else if (!checkFingerprintAvailable(activity)) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_unsupport_cancle_open"));
        } else {
            try {
                try {
                    a.a(activity).a(WalletFingerprint.getKeyStoreNewAlise(activity));
                    Message.obtain(this.mSysFpHander, 4096, activity).sendToTarget();
                    final com.baidu.wallet.paysdk.fingerprint.bean.b bVar = (com.baidu.wallet.paysdk.fingerprint.bean.b) FingerprintBeanFactory.getInstance().getBean(applicationContext, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, TAG);
                    bVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3
                        @Override // com.baidu.apollon.beans.IBeanResponseCallback
                        public void onBeanExecFailure(int i, int i2, String str) {
                            bVar.destroyBean();
                            SysFingerprintPay.this.mSysFpHander.sendEmptyMessage(4097);
                            SysFingerprintPay.this.mSysFpHander.post(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_open_failed"));
                                }
                            });
                        }

                        @Override // com.baidu.apollon.beans.IBeanResponseCallback
                        public void onBeanExecSuccess(int i, Object obj, String str) {
                            bVar.destroyBean();
                            SysFingerprintPay.this.mSysFpHander.sendEmptyMessage(4097);
                            OpenFingerprintResponse openFingerprintResponse = (obj == null || !(obj instanceof OpenFingerprintResponse)) ? null : (OpenFingerprintResponse) obj;
                            if (openFingerprintResponse == null || TextUtils.isEmpty(openFingerprintResponse.token_info)) {
                                SysFingerprintPay.this.mSysFpHander.post(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, ResUtils.getString(activity, "wallet_fp_open_failed"));
                                    }
                                });
                                return;
                            }
                            String safeSavedDataByUnionId = OtpTokenUtils.toSafeSavedDataByUnionId(SafePay.getInstance().decryptProxy(openFingerprintResponse.token_info), activity.getApplicationContext());
                            String localEncrypt1 = SafePay.getInstance().localEncrypt1(OtpTokenUtils.getSN(openFingerprintResponse.token_info));
                            SysFingerprintPay.this.saveOTPTokenByFingerprint(activity, localEncrypt1 + FieldBuilder.SE + safeSavedDataByUnionId, fingerprintCallback);
                        }
                    });
                    bVar.execBean();
                } catch (Exception unused) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GENERATEKEY_FAILED);
                    fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
                }
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 1, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.IFingerprintPay
    public void verify(Activity activity, FingerprintCallback fingerprintCallback) {
        try {
            com.baidu.wallet.paysdk.fingerprint.ui.a a2 = com.baidu.wallet.paysdk.fingerprint.ui.a.a(activity, 2, null, fingerprintCallback);
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(a2, "FingerprintPayDialog");
            beginTransaction.commitAllowingStateLoss();
        } catch (KeyStoreException unused) {
            fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, ResUtils.getString(activity, "wallet_fp_keystore_failed"));
        }
    }
}
