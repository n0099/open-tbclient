package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.l;
import com.baidu.wallet.paysdk.beans.o;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardCheckSmsResponse;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardSendSmsResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class e implements ISmsController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f26180a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f26181b;

    /* renamed from: c  reason: collision with root package name */
    public BindFastRequest f26182c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f26183d;

    /* renamed from: e  reason: collision with root package name */
    public o f26184e;

    /* renamed from: f  reason: collision with root package name */
    public l f26185f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f26186g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26187h;

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
        this.f26187h = false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f26187h) {
                PasswordController.getPassWordInstance().clearSetPwdListener();
            }
            this.f26180a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, dialog)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            bundle.putSerializable("mBindRequest", this.f26182c);
            bundle.putSerializable("mPayRequest", this.f26183d);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 != 522) {
                if (i2 == 523) {
                    WalletGlobalUtils.safeDismissDialog(this.f26180a, 0);
                    if (i3 == 5003) {
                        AccountManager.getInstance(this.f26180a).logout();
                        WalletLoginHelper.getInstance().logout(false);
                    }
                    SmsVerifyHandler smsVerifyHandler = this.f26186g;
                    if (smsVerifyHandler != null) {
                        smsVerifyHandler.onSmsVerifyFailure(i3, str);
                    }
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS, i3);
                    return true;
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f26180a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f26180a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f26180a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler2 = this.f26186g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsSendFailure(i3, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26181b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.doStopCountDown();
            }
            PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS, i3);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, obj, str)) == null) {
            if (i2 == 522 && (obj instanceof FindPWDFromOldCardSendSmsResponse)) {
                WalletGlobalUtils.safeDismissDialog(this.f26180a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS, 0);
                FindPWDFromOldCardSendSmsResponse findPWDFromOldCardSendSmsResponse = (FindPWDFromOldCardSendSmsResponse) obj;
                if (findPWDFromOldCardSendSmsResponse.checkResponseValidity()) {
                    findPWDFromOldCardSendSmsResponse.decrypt();
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f26181b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(findPWDFromOldCardSendSmsResponse.sms_length, findPWDFromOldCardSendSmsResponse.sms_type);
                }
                SmsVerifyHandler smsVerifyHandler = this.f26186g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
                return true;
            } else if (i2 == 523 && (obj instanceof FindPWDFromOldCardCheckSmsResponse)) {
                WalletGlobalUtils.safeDismissDialog(this.f26180a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS, 0);
                FindPWDFromOldCardCheckSmsResponse findPWDFromOldCardCheckSmsResponse = (FindPWDFromOldCardCheckSmsResponse) obj;
                if (findPWDFromOldCardCheckSmsResponse.checkResponseValidity() && (bindFastRequest = this.f26182c) != null) {
                    bindFastRequest.setSmsToken(findPWDFromOldCardCheckSmsResponse.sms_token);
                    a();
                }
                SmsVerifyHandler smsVerifyHandler2 = this.f26186g;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifySuccess();
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String string = ResUtils.getString(this.f26180a, "ebpay_pay_next");
            String sendSmsphone = !TextUtils.isEmpty(this.f26182c.getSendSmsphone()) ? this.f26182c.getSendSmsphone() : "";
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26181b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", string, sendSmsphone, true);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (bundle == null) {
                this.f26182c = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Pwd.name());
                this.f26183d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            } else {
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f26182c = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f26183d = (PayRequest) serializable2;
                }
            }
            if (this.f26182c != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26182c.getRequestId(), this.f26182c);
                if (this.f26182c.isRealPay() && (payRequest = this.f26183d) != null && payRequest.checkRequestValidity()) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f26183d.getRequestId(), this.f26183d);
                    return true;
                }
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f26180a, "SmsControllerForFindPWD.onCreateCheckInvalide().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.NEXT_THIRD);
            this.f26182c.mSmsVCode = str;
            a(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f26180a, 0, "");
            if (this.f26184e == null) {
                this.f26184e = (o) PayBeanFactory.getInstance().getBean((Context) this.f26180a, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS, ISmsController.BEAN_TAG);
            }
            this.f26184e.a((BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.BindCategory.Pwd));
            PayStatisticsUtil.onEventStart(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS);
            this.f26184e.setResponseCallback(this.f26180a);
            this.f26184e.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f26180a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f26181b = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f26186g = smsVerifyHandler;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.f26180a, 0, "");
            PayStatisticsUtil.onEventStart(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS);
            l lVar = (l) PayBeanFactory.getInstance().getBean((Context) this.f26180a, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS, ISmsController.BEAN_TAG);
            this.f26185f = lVar;
            lVar.setResponseCallback(this.f26180a);
            this.f26185f.execBean();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PasswordController.getPassWordInstance().setPwd(this.f26180a, false, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f26188a;

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
                    this.f26188a = this;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (this.f26188a.f26181b != null) {
                            this.f26188a.f26181b.clearSmsEditText();
                            this.f26188a.f26181b.doStopCountDown();
                        }
                        if (this.f26188a.f26182c == null || this.f26188a.f26182c.mBindFrom != 5) {
                            return;
                        }
                        PasswordController.getPassWordInstance().setPassByUserFail(str);
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        if (this.f26188a.f26182c == null || this.f26188a.f26182c.mBindFrom != 5) {
                            if (this.f26188a.f26182c == null || this.f26188a.f26182c.mBindFrom != 4) {
                                return;
                            }
                            PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                            return;
                        }
                        PasswordController.getPassWordInstance().setPassByUserSucceed(str);
                    }
                }
            }, PayRequestCache.BindCategory.Pwd);
            this.f26187h = true;
        }
    }
}
