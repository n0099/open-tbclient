package com.baidu.wallet.personal.controllers;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface;
import com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.personal.beans.TransferGetSmsBean;
import com.baidu.wallet.personal.beans.TransferSmsVerifyBean;
import com.baidu.wallet.personal.datamodel.TransfRecvRequest;
import com.baidu.wallet.personal.datamodel.TransferRecvSmSResponse;
/* loaded from: classes5.dex */
public class a implements ISmsController {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f26312a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f26313b;

    /* renamed from: c  reason: collision with root package name */
    public TransfRecvRequest f26314c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26315d = true;

    /* renamed from: e  reason: collision with root package name */
    public TransferGetSmsBean f26316e;

    /* renamed from: f  reason: collision with root package name */
    public TransferSmsVerifyBean f26317f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f26318g;

    private void a(String str) {
        WalletGlobalUtils.safeShowDialog(this.f26312a, 0, "");
        PayStatisticsUtil.onEventStart(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS);
        this.f26314c.sms_code = str;
        if (this.f26317f == null) {
            this.f26317f = (TransferSmsVerifyBean) PayBeanFactory.getInstance().getBean((Context) this.f26312a, 19, ISmsController.BEAN_TAG);
        }
        this.f26317f.setResponseCallback(this.f26312a);
        this.f26317f.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        this.f26312a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("request_data", this.f26314c);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 == 19) {
            WalletGlobalUtils.safeDismissDialog(this.f26312a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS, i3);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f26312a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            SmsVerifyHandler smsVerifyHandler = this.f26318g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifyFailure(i3, str);
            }
            return true;
        } else if (i2 == 18) {
            WalletGlobalUtils.safeDismissDialog(this.f26312a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS, i3);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f26312a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            if (this.f26315d) {
                this.f26315d = false;
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f26312a, "ebpay_send_fail");
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26313b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.doStopCountDown();
            }
            SmsVerifyHandler smsVerifyHandler2 = this.f26318g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsSendFailure(i3, str);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        if (i2 == 19) {
            WalletGlobalUtils.safeDismissDialog(this.f26312a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS, 0);
            this.f26314c.isGatheringSuccess = true;
            SmsVerifyHandler smsVerifyHandler = this.f26318g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifySuccess();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, 3);
            this.f26312a.startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
            this.f26312a.finish();
            return true;
        } else if (i2 == 18) {
            WalletGlobalUtils.safeDismissDialog(this.f26312a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS, 0);
            TransferRecvSmSResponse transferRecvSmSResponse = null;
            if (obj != null && (obj instanceof TransferRecvSmSResponse)) {
                transferRecvSmSResponse = (TransferRecvSmSResponse) obj;
            }
            if (this.f26315d && transferRecvSmSResponse != null) {
                this.f26315d = false;
                this.f26313b.upDateSafeKeyBoradView(transferRecvSmSResponse.sms_length, transferRecvSmSResponse.sms_type);
            }
            SmsVerifyHandler smsVerifyHandler2 = this.f26318g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsSendSuccess();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f26312a, "ebpay_pay_next");
        TransfRecvRequest transfRecvRequest = this.f26314c;
        String str = (transfRecvRequest == null || TextUtils.isEmpty(transfRecvRequest.phone)) ? "" : this.f26314c.phone;
        SmsUpdateUiInterface smsUpdateUiInterface = this.f26313b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("bd_wallet_trans_detail", "", string, str, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle == null) {
            this.f26314c = (TransfRecvRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_TRANSFER_RECV);
        } else {
            this.f26314c = (TransfRecvRequest) bundle.getSerializable("request_data");
        }
        this.f26315d = true;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        a(str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        if (this.f26315d && (payBaseActivity = this.f26312a) != null) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        PayStatisticsUtil.onEventStart(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS);
        if (this.f26316e == null) {
            this.f26316e = (TransferGetSmsBean) PayBeanFactory.getInstance().getBean((Context) this.f26312a, 18, ISmsController.BEAN_TAG);
        }
        this.f26316e.setResponseCallback(this.f26312a);
        this.f26316e.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f26312a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f26313b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f26318g = smsVerifyHandler;
    }
}
