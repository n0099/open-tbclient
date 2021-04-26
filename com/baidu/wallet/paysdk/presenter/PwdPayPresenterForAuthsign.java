package com.baidu.wallet.paysdk.presenter;

import android.os.Bundle;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes5.dex */
public class PwdPayPresenterForAuthsign extends PwdPayContract.Presenter {
    public PwdPayPresenterForAuthsign(PwdPayActivity pwdPayActivity) {
        super(pwdPayActivity);
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean directQuit() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i2, int i3, String str) {
        super.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 257) {
            StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, 0);
            BaiduPay.getInstance().bindCardAuth(this.mActivity, false);
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
            this.mActivity.finishWithoutAnim();
            return;
        }
        super.handleResponse(i2, obj, str);
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        PwdPayActivity pwdPayActivity = this.mActivity;
        pwdPayActivity.setTitleText(ResUtils.getString(pwdPayActivity, "ebpay_please_input_pwd2"));
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckCancel() {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckOK(String str) {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onPwdChanged(String str) {
        doCheckPwd(str);
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void pwdAndFpTypeChange() {
    }
}
