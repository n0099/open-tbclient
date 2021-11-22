package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.j;
import com.baidu.wallet.paysdk.beans.m;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardCheckSmsResponse;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardSendSmsResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class d implements ISmsController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f60843a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f60844b;

    /* renamed from: c  reason: collision with root package name */
    public BindFastRequest f60845c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f60846d;

    /* renamed from: e  reason: collision with root package name */
    public m f60847e;

    /* renamed from: f  reason: collision with root package name */
    public j f60848f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f60849g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60850h;

    public d() {
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
        this.f60850h = false;
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
            if (this.f60850h) {
                PasswordController.getPassWordInstance().clearSetPwdListener();
            }
            this.f60843a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticManager.onEvent("clickInputVcode");
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
            bundle.putSerializable("mBindRequest", this.f60845c);
            bundle.putSerializable("mPayRequest", this.f60846d);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 != 522) {
                if (i2 == 523) {
                    WalletGlobalUtils.safeDismissDialog(this.f60843a, 0);
                    if (i3 == 5003) {
                        AccountManager.getInstance(this.f60843a).logout();
                        WalletLoginHelper.getInstance().logout(false);
                    }
                    SmsVerifyHandler smsVerifyHandler = this.f60849g;
                    if (smsVerifyHandler != null) {
                        smsVerifyHandler.onSmsVerifyFailure(i3, str);
                    }
                    return true;
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f60843a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f60843a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f60843a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler2 = this.f60849g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsSendFailure(i3, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f60844b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.doStopCountDown();
            }
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
                WalletGlobalUtils.safeDismissDialog(this.f60843a, 0);
                FindPWDFromOldCardSendSmsResponse findPWDFromOldCardSendSmsResponse = (FindPWDFromOldCardSendSmsResponse) obj;
                if (findPWDFromOldCardSendSmsResponse.checkResponseValidity()) {
                    findPWDFromOldCardSendSmsResponse.decrypt();
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f60844b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(findPWDFromOldCardSendSmsResponse.sms_length, findPWDFromOldCardSendSmsResponse.sms_type);
                }
                SmsVerifyHandler smsVerifyHandler = this.f60849g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
                return true;
            } else if (i2 == 523 && (obj instanceof FindPWDFromOldCardCheckSmsResponse)) {
                WalletGlobalUtils.safeDismissDialog(this.f60843a, 0);
                FindPWDFromOldCardCheckSmsResponse findPWDFromOldCardCheckSmsResponse = (FindPWDFromOldCardCheckSmsResponse) obj;
                if (findPWDFromOldCardCheckSmsResponse.checkResponseValidity() && (bindFastRequest = this.f60845c) != null) {
                    bindFastRequest.setSmsToken(findPWDFromOldCardCheckSmsResponse.sms_token);
                    a();
                }
                SmsVerifyHandler smsVerifyHandler2 = this.f60849g;
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
            String string = ResUtils.getString(this.f60843a, "dxm_ebpay_pay_next");
            String sendSmsphone = !TextUtils.isEmpty(this.f60845c.getSendSmsphone()) ? this.f60845c.getSendSmsphone() : "";
            SmsUpdateUiInterface smsUpdateUiInterface = this.f60844b;
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
                this.f60845c = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Pwd.name());
                this.f60846d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            } else {
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f60845c = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f60846d = (PayRequest) serializable2;
                }
            }
            if (this.f60845c != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f60845c.getRequestId(), this.f60845c);
                if (this.f60845c.isRealPay() && (payRequest = this.f60846d) != null && payRequest.checkRequestValidity()) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f60846d.getRequestId(), this.f60846d);
                    return true;
                }
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f60843a, "SmsControllerForFindPWD.onCreateCheckInvalide().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            StatHelper.statServiceEvent("thirdNext");
            this.f60845c.mSmsVCode = str;
            a(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f60843a, 0, "");
            if (this.f60847e == null) {
                this.f60847e = (m) PayBeanFactory.getInstance().getBean((Context) this.f60843a, 522, ISmsController.BEAN_TAG);
            }
            this.f60847e.a((BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.BindCategory.Pwd));
            this.f60847e.setResponseCallback(this.f60843a);
            this.f60847e.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f60843a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f60844b = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f60849g = smsVerifyHandler;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.f60843a, 0, "");
            j jVar = (j) PayBeanFactory.getInstance().getBean((Context) this.f60843a, 523, ISmsController.BEAN_TAG);
            this.f60848f = jVar;
            jVar.setResponseCallback(this.f60843a);
            this.f60848f.execBean();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PasswordController.getPassWordInstance().setPwd(this.f60843a, false, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f60851a;

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
                    this.f60851a = this;
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (this.f60851a.f60844b != null) {
                            this.f60851a.f60844b.clearSmsEditText();
                            this.f60851a.f60844b.doStopCountDown();
                        }
                        if (this.f60851a.f60845c == null || this.f60851a.f60845c.mBindFrom != 5) {
                            return;
                        }
                        PasswordController.getPassWordInstance().setPassByUserFail(str);
                    }
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                        if (this.f60851a.f60845c == null || this.f60851a.f60845c.mBindFrom != 5) {
                            if (this.f60851a.f60845c == null || this.f60851a.f60845c.mBindFrom != 4) {
                                return;
                            }
                            PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                            return;
                        }
                        PasswordController.getPassWordInstance().setPassByUserSucceed(str);
                    }
                }
            }, PayRequestCache.BindCategory.Pwd);
            this.f60850h = true;
        }
    }
}
