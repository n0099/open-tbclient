package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ab;
import com.baidu.wallet.paysdk.beans.ac;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardData.BondCard a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f52176b;

    /* renamed from: c  reason: collision with root package name */
    public PayBaseActivity f52177c;

    /* renamed from: d  reason: collision with root package name */
    public SmsUpdateUiInterface f52178d;

    /* renamed from: e  reason: collision with root package name */
    public ErrorContentResponse f52179e;

    /* renamed from: f  reason: collision with root package name */
    public String f52180f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f52181g;

    /* renamed from: h  reason: collision with root package name */
    public PwdRequest f52182h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.g f52183i;

    /* renamed from: j  reason: collision with root package name */
    public w f52184j;
    public boolean k;
    public String l;
    public ac m;
    public boolean n;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = "";
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) this.f52177c, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
            abVar.setResponseCallback(this.f52177c);
            abVar.execBean();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.f52183i == null) {
                this.f52183i = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f52177c, 5, ISmsController.BEAN_TAG);
            }
            if (PayRequestCache.getInstance().isBondPay()) {
                this.f52183i.a();
            }
            this.f52183i.a(PayRequestCache.getBindRequest(this.f52177c.getActivity()));
            this.f52183i.setResponseCallback(this.f52177c);
            this.f52183i.execBean();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.baidu.wallet.paysdk.beans.i iVar = (com.baidu.wallet.paysdk.beans.i) PayBeanFactory.getInstance().getBean((Context) this.f52177c, PayBeanFactory.BEAN_ID_CREDIT_PAY, ISmsController.BEAN_TAG);
            iVar.setResponseCallback(this.f52177c);
            iVar.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.f52177c, 14, ISmsController.BEAN_TAG);
            aVar.setResponseCallback(this.f52177c);
            aVar.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            StatHelper.statServiceEvent(this.n ? StatServiceEvent.EVENT_CONFIRM_PAY_FROM_SMS_VERIFY : StatServiceEvent.EVENT_CONFIRM_PAY_BY_SMS);
            if (this.f52184j == null) {
                this.f52184j = (w) PayBeanFactory.getInstance().getBean((Context) this.f52177c, 13, ISmsController.BEAN_TAG);
            }
            this.f52184j.setResponseCallback(this.f52177c);
            if (PayRequestCache.getInstance().isBondPay()) {
                this.f52184j.a(true);
            }
            this.f52184j.b(this.f52177c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
            this.f52184j.execBean();
        }
    }

    private String h() {
        InterceptResult invokeV;
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (TextUtils.isEmpty(this.f52180f)) {
                if (PayRequestCache.getInstance().isBondPay() && (bondCard = this.a) != null) {
                    return bondCard.mobile;
                }
                return ((BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name())).getSendSmsphone();
            }
            return SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.f52180f));
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            PayRequest payRequest = this.f52176b;
            if (payRequest != null) {
                if (payRequest.mMktSolution != null) {
                    return String.format(ResUtils.getString(this.f52177c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f52176b.mMktSolution.easypay_amount));
                }
                return String.format(ResUtils.getString(this.f52177c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f52176b.getFinalPayAmount()));
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && 5320 == this.f52177c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) && this.f52178d != null) {
            ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f52177c.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            this.f52178d.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
                if (i3 == 15500 && obj != null && (obj instanceof ErrorContentResponse)) {
                    this.l = str;
                    PayBaseActivity payBaseActivity = this.f52177c;
                    payBaseActivity.mPayErrorCode = i3;
                    payBaseActivity.mBeanId = i2;
                    this.f52179e = (ErrorContentResponse) obj;
                    WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                    WalletGlobalUtils.safeShowDialog(this.f52177c, 65316, "");
                    return true;
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
            PayDataCache.getInstance().cleanDetainmentDesc();
            if (obj instanceof ErrorContentResponse) {
                this.f52179e = (ErrorContentResponse) obj;
                if (!TextUtils.isEmpty(str)) {
                    this.l = str;
                    PayBaseActivity payBaseActivity2 = this.f52177c;
                    payBaseActivity2.mPayErrorCode = i3;
                    payBaseActivity2.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CANNOT_DISCOUNT, "");
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 65315) {
                return new PromptMultiBtnDialog(this.f52177c.getActivity());
            }
            if (i2 == 65316) {
                return new PromptMultiBtnDialog(this.f52177c.getActivity());
            }
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f52177c = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticManager.onEvent("clickInputVcode");
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, dialog)) == null) {
            switch (i2) {
                case ISmsController.DIALOG_CANNOT_DISCOUNT /* 65315 */:
                    return b((PromptMultiBtnDialog) dialog);
                case 65316:
                    return a((PromptMultiBtnDialog) dialog);
                case ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH /* 65317 */:
                    return a((PromptDialog) dialog);
                default:
                    return false;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            bundle.putSerializable("mPwdRequest", this.f52182h);
            bundle.putSerializable("mPayRequest", this.f52176b);
            bundle.putBoolean("mPayBySmsCode", this.n);
            bundle.putSerializable("mCardInfoUpdateContent", this.f52179e);
            bundle.putString("phone_no", this.f52180f);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, str)) == null) {
            if (i2 == 5) {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f52177c.getActivity()).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                a(i3, str);
                return true;
            } else if (i2 != 13 && i2 != 14 && i2 != 263) {
                if (i2 == 9 || i2 == 264) {
                    a(i3, str);
                    return true;
                }
                return false;
            } else {
                WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f52177c.getActivity()).logout();
                    WalletLoginHelper.getInstance().logout(false);
                } else if (i3 == 60500) {
                    this.l = str;
                    PayBaseActivity payBaseActivity2 = this.f52177c;
                    payBaseActivity2.mPayErrorCode = i3;
                    payBaseActivity2.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH, "");
                } else if (65312 == i3) {
                    StatisticManager.onEvent("fp_sys_65312_on_smsact");
                    if (this.f52176b != null && (payBaseActivity = this.f52177c) != null) {
                        GlobalUtils.toast(payBaseActivity, ResUtils.getString(payBaseActivity, "bd_wallet_fingerprint_auth_failed"));
                    }
                    PayBaseActivity payBaseActivity3 = this.f52177c;
                    if (payBaseActivity3 != null) {
                        payBaseActivity3.finish();
                    }
                } else {
                    SmsVerifyHandler smsVerifyHandler = this.f52181g;
                    if (smsVerifyHandler != null) {
                        smsVerifyHandler.onSmsVerifyFailure(i3, str);
                    }
                }
                StatisticManager.onEventWithValue("onekeyPayAcceptFail", String.valueOf(i3));
                return true;
            }
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, obj, str)) == null) {
            if (i2 == 5) {
                WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
                return e(obj);
            } else if (i2 == 13) {
                SmsVerifyHandler smsVerifyHandler = this.f52181g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifySuccess();
                }
                return false;
            } else if (i2 == 9) {
                WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
                return d(obj);
            } else if (i2 == 14) {
                WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
                return c(obj);
            } else if (i2 == 263) {
                SmsVerifyHandler smsVerifyHandler2 = this.f52181g;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifySuccess();
                }
                return false;
            } else if (i2 == 264) {
                WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
                return b(obj);
            } else if (i2 == 15) {
                return a(obj);
            } else {
                return false;
            }
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String string = ResUtils.getString(this.f52177c, "ebpay_submit_pay");
            PayRequest payRequest = this.f52176b;
            if (payRequest != null) {
                if (payRequest.mMktSolution != null) {
                    string = String.format(ResUtils.getString(this.f52177c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f52176b.mMktSolution.easypay_amount));
                } else {
                    string = String.format(ResUtils.getString(this.f52177c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f52176b.getFinalPayAmount()));
                }
            }
            String str = string;
            PayRequest payRequest2 = this.f52176b;
            if (payRequest2 != null) {
                this.a = payRequest2.mBondCard;
                if (this.f52178d != null) {
                    this.f52178d.initSMSActivityView("ebpay_sms_title_tip_security_check", this.n ? ResUtils.getString(this.f52177c, "ebpay_sms_pwd_error_tip") : "", str, h(), true);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j();
            return 5320 != this.f52177c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) {
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("mPwdRequest");
                if (serializable != null && (serializable instanceof PwdRequest)) {
                    this.f52182h = (PwdRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f52176b = (PayRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("payBySmsCode");
                if (serializable3 != null && (serializable3 instanceof Boolean)) {
                    this.n = ((Boolean) serializable3).booleanValue();
                }
                Serializable serializable4 = bundle.getSerializable("mCardInfoUpdateContent");
                if (serializable4 != null && (serializable4 instanceof ErrorContentResponse)) {
                    this.f52179e = (ErrorContentResponse) serializable4;
                }
                this.f52180f = bundle.getString("phone_no");
            } else {
                this.f52182h = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                this.f52176b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                this.n = this.f52177c.getIntent().getBooleanExtra("pay_by_smscode", false);
                Serializable serializableExtra = this.f52177c.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
                if (serializableExtra != null) {
                    this.f52180f = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
                }
            }
            if (this.f52176b != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f52176b.getRequestId(), this.f52176b);
                if (this.f52182h != null) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f52182h.getRequestId(), this.f52182h);
                }
                this.k = isSendSmsOnCreate();
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f52177c, "SmsControllerForPaySMS.onCreateCheckInvalide().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            if (bindFastRequest != null) {
                bindFastRequest.mSmsVCode = str;
            }
            PayRequest payRequest = this.f52176b;
            if (payRequest != null) {
                payRequest.mSmsCode = str;
            }
            WalletGlobalUtils.safeShowDialog(this.f52177c, 0, "");
            PayRequest.PayPrice.PayType b2 = b();
            if (b2 == PayRequest.PayPrice.PayType.BANKCARD) {
                g();
            } else if (b2 == PayRequest.PayPrice.PayType.BALANCE) {
                f();
            } else if (b2 == PayRequest.PayPrice.PayType.CREIDT) {
                e();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (payBaseActivity = this.f52177c) == null) {
            return;
        }
        if (this.k) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f52177c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            c();
            return;
        }
        PayRequest.PayPrice.PayType b2 = b();
        if (b2 == PayRequest.PayPrice.PayType.BANKCARD) {
            d();
        } else if (b2 == PayRequest.PayPrice.PayType.BALANCE || b2 == PayRequest.PayPrice.PayType.CREIDT) {
            a(b2);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, payBaseActivity) == null) {
            this.f52177c = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, smsUpdateUiInterface) == null) {
            this.f52178d = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, smsVerifyHandler) == null) {
            this.f52181g = smsVerifyHandler;
        }
    }

    private String b(PayRequest.PayPrice.PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, payType)) == null) {
            ArrayList arrayList = new ArrayList();
            if (payType == PayRequest.PayPrice.PayType.BALANCE) {
                arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
            } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                arrayList.addAll(PayDataCache.getInstance().getCreditPayPostInfo());
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if ("pay_type".equals(((RestNameValuePair) arrayList.get(i2)).getName())) {
                    return ((RestNameValuePair) arrayList.get(i2)).getValue();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    private void a(PayRequest.PayPrice.PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, payType) == null) {
            String str = this.f52180f;
            PayRequest payRequest = this.f52176b;
            com.baidu.wallet.paysdk.datamodel.c cVar = new com.baidu.wallet.paysdk.datamodel.c(str, payRequest.mSpNO, payRequest.mOrderNo, b(payType));
            PayRequestCache.getInstance().addBeanRequestToCache(cVar.getRequestId(), cVar);
            if (this.m == null) {
                this.m = (ac) PayBeanFactory.getInstance().getBean((Context) this.f52177c, 9, ISmsController.BEAN_TAG);
            }
            this.m.setResponseCallback(this.f52177c);
            this.m.execBean();
        }
    }

    private boolean c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, obj)) == null) {
            SmsVerifyHandler smsVerifyHandler = this.f52181g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifySuccess();
            }
            if (obj != null && (obj instanceof BalancePayResponse)) {
                BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
                PayResultContent payResultContent = new PayResultContent();
                payResultContent.notify = balancePayResponse.notify;
                payResultContent.paytype_desc = balancePayResponse.paytype_desc;
                payResultContent.coupon_msg = balancePayResponse.coupon_msg;
                BalancePayResponse.Business business = balancePayResponse.business;
                if (business != null) {
                    String str = business.stream_recharge_msg;
                    if (str != null) {
                        payResultContent.stream_recharge_msg = str;
                    }
                    String str2 = balancePayResponse.business.expected_time;
                    if (str2 != null) {
                        payResultContent.expected_time = str2;
                    }
                }
                payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
                payResultContent.total_amount = balancePayResponse.total_amount;
                payResultContent.cash_amount = balancePayResponse.cash_amount;
                payResultContent.discount_amount = balancePayResponse.discount_amount;
                payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
                payResultContent.paytype_info = balancePayResponse.paytype_info;
                payResultContent.order_no = balancePayResponse.order_no;
                AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
                payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
                payResultContent.order_prefix = balancePayResponse.order_prefix;
                payResultContent.discount_prefix = balancePayResponse.discount_prefix;
                payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
                payResultContent.feedback_info = balancePayResponse.feedback_info;
                payResultContent.trans_no = balancePayResponse.trans_no;
                payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
                payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
                payResultContent.compliance = balancePayResponse.compliance;
                StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
                a(1);
                if (balancePayResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
                }
                PayController.getInstance().paySucess(this.f52177c, payResultContent, 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean e(Object obj) {
        InterceptResult invokeL;
        CheckCardInfoResponse checkCardInfoResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, obj)) == null) {
            if (obj == null || !(obj instanceof CheckCardInfoResponse)) {
                checkCardInfoResponse = null;
            } else {
                checkCardInfoResponse = (CheckCardInfoResponse) obj;
                PayRequest payRequest = this.f52176b;
                if (payRequest != null) {
                    payRequest.mChannelNo = checkCardInfoResponse.channel_no;
                }
            }
            this.k = false;
            SmsUpdateUiInterface smsUpdateUiInterface = this.f52178d;
            if (smsUpdateUiInterface != null && checkCardInfoResponse != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
                this.f52178d.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
            }
            SmsVerifyHandler smsVerifyHandler = this.f52181g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, obj)) == null) {
            VerifyCodeResponse verifyCodeResponse = obj instanceof VerifyCodeResponse ? (VerifyCodeResponse) obj : null;
            if (this.k) {
                this.k = false;
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f52178d;
            if (smsUpdateUiInterface != null && verifyCodeResponse != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponse.sms_length, verifyCodeResponse.sms_type);
            }
            SmsVerifyHandler smsVerifyHandler = this.f52181g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, obj)) == null) {
            VerifyByBankResponse verifyByBankResponse = obj instanceof VerifyByBankResponse ? (VerifyByBankResponse) obj : null;
            if (this.k) {
                this.k = false;
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f52178d;
            if (smsUpdateUiInterface != null && verifyByBankResponse != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(verifyByBankResponse.sms_length, verifyByBankResponse.sms_type);
            }
            SmsVerifyHandler smsVerifyHandler = this.f52181g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, obj)) == null) {
            if (obj instanceof GetCardInfoResponse) {
                this.f52177c.finishWithoutAnim();
                PayController.getInstance().completeCardPay(this.f52177c, this.f52176b.mBondCard, (GetCardInfoResponse) obj);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            StatHelper.cachePayType(i2);
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS);
                return;
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS);
        }
    }

    private boolean b(PromptMultiBtnDialog promptMultiBtnDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, promptMultiBtnDialog)) == null) {
            StatisticManager.onEvent("showOrigPriceAlert");
            promptMultiBtnDialog.setMessage(this.l);
            promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this.f52177c, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                        StatisticManager.onEvent("origPriceFromAlert");
                        e eVar = this.a;
                        ErrorContentResponse errorContentResponse = eVar.f52179e;
                        if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                            return;
                        }
                        if (eVar.f52183i == null) {
                            this.a.f52183i = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.a.f52177c, 5, ISmsController.BEAN_TAG);
                        }
                        ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(this.a.f52179e.mkt_solution);
                        if (PayRequestCache.getInstance().isBondPay()) {
                            this.a.f52183i.a();
                        }
                        this.a.f52183i.setResponseCallback(this.a.f52177c);
                        this.a.f52183i.execBean();
                        WalletGlobalUtils.safeShowDialog(this.a.f52177c, 0, "");
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                        e eVar2 = this.a;
                        if (eVar2.f52178d != null) {
                            String i2 = eVar2.i();
                            if (!TextUtils.isEmpty(i2)) {
                                this.a.f52178d.updateButtonTip(i2);
                            }
                        }
                        SmsUpdateUiInterface smsUpdateUiInterface = this.a.f52178d;
                        if (smsUpdateUiInterface != null) {
                            smsUpdateUiInterface.clearSmsEditText();
                            this.a.f52178d.doStartCountDown();
                        }
                    }
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this.f52177c, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                        PayController.getInstance().gotoPayTypePage(this.a.f52177c, false);
                        this.a.f52177c.finish();
                    }
                }
            });
            promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.f52177c.addDoPayorCheckCardStatistics("取消");
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f52177c, 0);
            if (this.k) {
                this.k = false;
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f52177c.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.f52181g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i2, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f52178d;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.clearSmsEditText();
                this.f52178d.doStopCountDown();
            }
        }
    }

    public PayRequest.PayPrice.PayType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52176b.getPayPrice().payType : (PayRequest.PayPrice.PayType) invokeV.objValue;
    }

    private boolean a(PromptMultiBtnDialog promptMultiBtnDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, promptMultiBtnDialog)) == null) {
            StatisticManager.onEvent("showCardOverDue");
            promptMultiBtnDialog.setMessage(this.l);
            promptMultiBtnDialog.setFirstBtn(ResUtils.string(this.f52177c, "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                        StatisticManager.onEvent("continueFromCardOverdue");
                        BindFastRequest bindFastRequest = new BindFastRequest();
                        bindFastRequest.mBindFrom = 2;
                        PayRequest payRequest = this.a.f52176b;
                        if (payRequest != null) {
                            bindFastRequest.mBondCard = payRequest.mBondCard;
                        }
                        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, 65316);
                        PayController payController = PayController.getInstance();
                        e eVar = this.a;
                        payController.updateCardInfoPay(eVar.f52177c, eVar.f52179e);
                        this.a.f52177c.finishWithoutAnim();
                    }
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.string(this.f52177c, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                        if (payRequest != null) {
                            payRequest.clearMktSolution();
                        }
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, 65316);
                        PayController.getInstance().gotoPayTypePage(this.a.f52177c, false);
                        this.a.f52177c.finishWithoutAnim();
                    }
                }
            });
            promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.f52177c.addDoPayorCheckCardStatistics("取消");
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, 65316);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean a(PromptDialog promptDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, promptDialog)) == null) {
            promptDialog.setMessage(this.l);
            promptDialog.setNegativeBtn(ResUtils.getString(this.f52177c, "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "dxm_ebpay_know"));
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
                    }
                }
            });
            promptDialog.setPositiveBtn(ResUtils.getString(this.f52177c, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayBaseActivity payBaseActivity = this.a.f52177c;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                        WalletGlobalUtils.safeDismissDialog(this.a.f52177c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
                        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                        if (payRequest != null) {
                            payRequest.clearMktSolution();
                        }
                        PayController.getInstance().gotoPayTypePage(this.a.f52177c, false);
                        this.a.f52177c.finish();
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = (q) PayBeanFactory.getInstance().getBean((Context) this.f52177c, 15, ISmsController.BEAN_TAG);
            qVar.setResponseCallback(this.f52177c);
            WalletGlobalUtils.safeShowDialog(this.f52177c, 0, "");
            qVar.execBean();
        }
    }
}
