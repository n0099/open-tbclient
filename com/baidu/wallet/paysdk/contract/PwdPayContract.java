package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.x;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
/* loaded from: classes5.dex */
public interface PwdPayContract {

    /* loaded from: classes5.dex */
    public static abstract class Presenter extends NetWorkPresenter {
        public String TAG;
        public PwdPayActivity mActivity;
        public PayRequest mPayRequest;

        public Presenter(PwdPayActivity pwdPayActivity) {
            super(pwdPayActivity);
            this.TAG = toString();
            this.mActivity = pwdPayActivity;
            pwdPayActivity.setPresenter(this);
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }

        public void clearPayPwdCache(int i) {
            PwdRequest pwdRequest;
            if ((100015 == i || 100018 == i) && (pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD)) != null) {
                pwdRequest.mPayPass = null;
            }
        }

        public boolean dialogNevigateOper_QuitCashDesk() {
            return false;
        }

        public boolean dialogNevigateOper_QuitCurrentPage() {
            return false;
        }

        public abstract boolean directQuit();

        public final void doCheckPwd(String str) {
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.mPayPass = str;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            x xVar = (x) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 257, this.TAG);
            this.mActivity.showLoading(-1);
            xVar.setResponseCallback(this);
            xVar.execBean();
            StatisticManager.onEventStart(StatServiceEvent.CHECK_PASSWORD);
        }

        public void handleActivityError() {
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleFailure(int i, int i2, String str) {
            this.mActivity.dismissLoading(-1);
            if (i == 257) {
                StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, i2);
                this.mActivity.showPWdInputView(true);
                clearPayPwdCache(i2);
                if (i2 == 100015) {
                    this.mActivity.showPassError(str);
                    return;
                } else if (i2 == 100018) {
                    this.mActivity.setErrorTips(false, null);
                    PwdPayActivity pwdPayActivity = this.mActivity;
                    pwdPayActivity.mDialogMsg = str;
                    pwdPayActivity.mPayErrorCode = i2;
                    pwdPayActivity.mBeanId = i;
                    WalletGlobalUtils.safeShowDialog(pwdPayActivity, 17, "");
                    return;
                } else if (i2 == -8) {
                    WalletGlobalUtils.safeShowDialog(this.mActivity, 11, "");
                    return;
                } else if (i2 == 60500) {
                    PwdPayActivity pwdPayActivity2 = this.mActivity;
                    pwdPayActivity2.mDialogMsg = str;
                    pwdPayActivity2.mPayErrorCode = i2;
                    pwdPayActivity2.mBeanId = i;
                    WalletGlobalUtils.safeShowDialog(pwdPayActivity2, 37, "");
                    return;
                } else if (65312 == i2) {
                    PwdPayActivity pwdPayActivity3 = this.mActivity;
                    GlobalUtils.toast(pwdPayActivity3, ResUtils.getString(pwdPayActivity3, "bd_wallet_fingerprint_auth_failed"));
                    String str2 = this.TAG;
                    LogUtil.d(str2, "指纹验证失败, 切到密码输入模式   , wireless-pay接口请求失败 错误码是  : " + i2);
                    this.mActivity.turntoPwdPay(true, null);
                    return;
                } else {
                    PwdPayActivity pwdPayActivity4 = this.mActivity;
                    if (TextUtils.isEmpty(str)) {
                        str = ResUtils.getString(this.mActivity, "fp_get_data_fail");
                    }
                    pwdPayActivity4.mDialogMsg = str;
                    WalletGlobalUtils.safeShowDialog(this.mActivity, 12, "");
                    return;
                }
            }
            this.mActivity.handleFailure(i, i2, str);
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleResponse(int i, Object obj, String str) {
            this.mActivity.handleResponse(i, obj, str);
        }

        public boolean isGatewaySignPay() {
            return this.mActivity.isGatewaySignPay();
        }

        public protocolModel needshowProtocolContainer() {
            return null;
        }

        public boolean onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
            clearPayPwdCache(i2);
            return false;
        }

        public abstract void onFPCheckCancel();

        public abstract void onFPCheckOK(String str);

        public abstract void onPwdChanged(String str);

        public void onTurntoPwdPay(boolean z) {
        }

        public abstract void pwdAndFpTypeChange();

        public boolean showSucAnim() {
            return true;
        }

        public void triggleSmsPay() {
            StatisticManager.onEvent(StatServiceEvent.TRIGGLESMSVERIFY);
            Intent intent = new Intent();
            intent.setClass(this.mActivity, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
            intent.putExtra("pay_by_smscode", true);
            this.mActivity.startActivityWithoutAnim(intent);
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void onProtocolClicked(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class protocolModel implements NoProguard, Serializable {
        public boolean checked;
        public a iClickCallback;
        public String passfree_protocol_msg;
        public String passfree_protocol_prefix;
        public String passfree_protocol_url;
    }
}
