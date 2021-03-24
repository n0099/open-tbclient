package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.O2OPayResultItemInfo;
import com.baidu.wallet.paysdk.datamodel.O2OTransInfo;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.baidu.wallet.paysdk.datamodel.ScanCodeLimitPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PwdPayPresenterForScancode extends PwdPayContract.Presenter {
    public boolean isQuerying;
    public boolean mCheckSMS;
    public O2OTransInfo mOrderInfo;
    public PayQueryRequest mQueryRequest;

    public PwdPayPresenterForScancode(PwdPayActivity pwdPayActivity, Intent intent) {
        super(pwdPayActivity);
        this.mCheckSMS = false;
        this.isQuerying = false;
        if (intent != null) {
            this.mOrderInfo = (O2OTransInfo) intent.getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
            this.mCheckSMS = intent.getBooleanExtra("checkSms", false);
        }
    }

    private void scancodePay() {
        LocalRouter.getInstance(this.mActivity).route(this.mActivity, new RouterRequest().provider("scancode").action("getLimitPayBean"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.presenter.PwdPayPresenterForScancode.1
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i != 0 || hashMap == null || hashMap.get("data") == null) {
                    if (i == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "scancode");
                        hashMap2.put("action", "getLimitPayBean");
                        StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                        return;
                    }
                    return;
                }
                Object obj = hashMap.get("data");
                if (obj == null || !(obj instanceof BaseBean)) {
                    return;
                }
                BaseBean baseBean = (BaseBean) obj;
                baseBean.setBeanParams(PwdPayPresenterForScancode.this.mOrderInfo.sp_no, PwdPayPresenterForScancode.this.mOrderInfo.order_no, PwdPayPresenterForScancode.this.mOrderInfo.pay_code, "");
                baseBean.setResponseCallback(PwdPayPresenterForScancode.this);
                baseBean.execBean();
            }
        });
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean directQuit() {
        WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i, int i2, String str) {
        this.mActivity.dismissLoading(-1);
        if (i == 594) {
            this.mActivity.showPWdInputView(true);
            clearPayPwdCache(i2);
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mActivity, "fp_get_data_fail");
            }
            if (i2 == 5003) {
                AccountManager.getInstance(this.mActivity).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i2 == 15414 || i2 == 15432 || i2 == 100015) {
                this.mActivity.showPassError(str);
            } else if (i2 == 100018) {
                this.mActivity.showPassError(str);
            }
            if (i2 == 65235) {
                this.mActivity.showPassError(str);
                return;
            } else {
                this.mActivity.showPassError(str);
                return;
            }
        }
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i, Object obj, String str) {
        if (i == 257) {
            StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, 0);
            if (this.mCheckSMS) {
                this.mActivity.dismissLoading(-1);
                this.mActivity.showPWdInputView(true);
                triggleSmsPay();
                return;
            }
            scancodePay();
        } else if (i != 594) {
            if (i == 12) {
                if (this.mOrderInfo == null) {
                    return;
                }
                PayRequest payRequest = new PayRequest();
                payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                payRequest.mGoodName = this.mOrderInfo.goods_name;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                return;
            }
            super.handleResponse(i, obj, str);
        } else {
            this.isQuerying = false;
            ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
            if (scanCodeLimitPayResponse.checkResponseValidity()) {
                O2OTransInfo o2OTransInfo = this.mOrderInfo;
                o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                    if (this.mQueryRequest == null) {
                        this.mQueryRequest = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.mQueryRequest;
                    payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                    payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                    PayRequestCache.getInstance().addBeanRequestToCache(this.mQueryRequest.getRequestId(), this.mQueryRequest);
                    this.mActivity.queryPayResult();
                } else if (scanCodeLimitPayResponse == null && this.mOrderInfo == null) {
                } else {
                    PayRequest payRequest2 = new PayRequest();
                    payRequest2.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                    payRequest2.mGoodName = this.mOrderInfo.goods_name;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest2.getRequestId(), payRequest2);
                    this.mOrderInfo.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    PayResultContent payResultContent = new PayResultContent();
                    payResultContent.notify = scanCodeLimitPayResponse.notify;
                    payResultContent.score_tip = scanCodeLimitPayResponse.score_tip;
                    payResultContent.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    O2OPayResultItemInfo o2OPayResultItemInfo = scanCodeLimitPayResponse.pay_result;
                    if (o2OPayResultItemInfo != null) {
                        payResultContent.coupon_msg = o2OPayResultItemInfo.coupon_msg;
                        payResultContent.coupon_find_prompt = o2OPayResultItemInfo.coupon_find_prompt;
                        String str2 = o2OPayResultItemInfo.cash_amount;
                        payResultContent.cash_amount = str2;
                        payResultContent.total_amount = o2OPayResultItemInfo.total_amount;
                        payResultContent.discount_amount = o2OPayResultItemInfo.discount_amount;
                        payResultContent.pay_detail_info = o2OPayResultItemInfo.pay_detail_info;
                        payResultContent.paytype_info = o2OPayResultItemInfo.paytype_info;
                        payResultContent.discount_prefix = o2OPayResultItemInfo.discount_prefix;
                        payResultContent.order_prefix = o2OPayResultItemInfo.order_prefix;
                        payResultContent.redirect_sp_succpage_remain_time = o2OPayResultItemInfo.redirect_sp_succpage_remain_time;
                        StatHelper.cachePayAmount(Double.valueOf(str2).doubleValue());
                    }
                    this.mActivity.showPaySuccessPage(true, payResultContent, 1);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        clearPayPwdCache(i2);
        return false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mOrderInfo = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
            this.mCheckSMS = bundle.getBoolean("checkSms", false);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckCancel() {
        this.mActivity.finish();
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
        bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
        bundle.putSerializable("checkSms", Boolean.valueOf(this.mCheckSMS));
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void pwdAndFpTypeChange() {
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void triggleSmsPay() {
        StatisticManager.onEvent(StatServiceEvent.TRIGGLESMSVERIFY);
        Intent intent = new Intent();
        intent.setClass(this.mActivity, WalletSmsActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 10);
        intent.putExtra(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
        this.mActivity.startActivityWithoutAnim(intent);
    }
}
