package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ac;
import com.baidu.wallet.paysdk.beans.ai;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponseForNoPwd;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
/* loaded from: classes5.dex */
public class c implements ISmsController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f26424a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26425b;

    /* renamed from: c  reason: collision with root package name */
    public ai f26426c;

    /* renamed from: d  reason: collision with root package name */
    public SmsVerifyHandler f26427d;

    /* renamed from: e  reason: collision with root package name */
    public SmsUpdateUiInterface f26428e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26429f;

    /* renamed from: g  reason: collision with root package name */
    public String f26430g;

    /* renamed from: h  reason: collision with root package name */
    public String f26431h;

    public c() {
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
        this.f26425b = false;
    }

    private void a(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
            ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) this.f26424a, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, ISmsController.BEAN_TAG);
            String seed = PasswordController.getSeed();
            acVar.a(PasswordController.handlePwd(str, seed), SafePay.getInstance().encryptProxy(seed), z ? "1" : "2", "20000");
            acVar.setResponseCallback((WalletSmsActivity) this.f26424a);
            acVar.a(str2, str3);
            acVar.execBean();
            WalletGlobalUtils.safeShowDialog(this.f26424a, 0, "");
        }
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? i2 == 68000 || i2 == 38510 || i2 == 38601 : invokeI.booleanValue;
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
            this.f26424a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 != 10) {
                if (i2 == 576) {
                    WalletGlobalUtils.safeDismissDialog(this.f26424a, 0);
                    if (a(i3)) {
                        GlobalUtils.toast(this.f26424a, str);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(PaySettingActivity.APPLY_SUCCESS, false);
                    this.f26424a.setResult(-1, intent);
                    this.f26424a.finish();
                    return true;
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f26424a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f26424a.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            if (this.f26425b) {
                this.f26425b = false;
            }
            if (TextUtils.isEmpty(str)) {
                PayBaseActivity payBaseActivity = this.f26424a;
                str = payBaseActivity.getString(ResUtils.string(payBaseActivity, "ebpay_send_fail"));
            }
            SmsVerifyHandler smsVerifyHandler = this.f26427d;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i3, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26428e;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.clearSmsEditText();
                this.f26428e.doStopCountDown();
                return true;
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, obj, str)) == null) {
            if (i2 != 10) {
                if (i2 == 576) {
                    WalletGlobalUtils.safeDismissDialog(this.f26424a, 0);
                    Intent intent = new Intent();
                    intent.putExtra(PaySettingActivity.APPLY_SUCCESS, true);
                    this.f26424a.setResult(-1, intent);
                    this.f26424a.finish();
                    return true;
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f26424a, 0);
            if (obj instanceof VerifyCodeResponseForNoPwd) {
                VerifyCodeResponseForNoPwd verifyCodeResponseForNoPwd = (VerifyCodeResponseForNoPwd) obj;
                SmsUpdateUiInterface smsUpdateUiInterface = this.f26428e;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponseForNoPwd.sms_length, verifyCodeResponseForNoPwd.sms_type);
                }
            }
            if (this.f26425b) {
                this.f26425b = false;
            }
            SmsVerifyHandler smsVerifyHandler = this.f26427d;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifySuccess();
                return true;
            }
            return true;
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (payBaseActivity = this.f26424a) == null) {
            return;
        }
        this.f26428e.initSMSActivityView("wallet_base_verify_phone_no", "", payBaseActivity.getString(ResUtils.string(payBaseActivity, "wallet_base_next_step")), this.f26431h, false);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            this.f26425b = isSendSmsOnCreate();
            com.baidu.wallet.paysdk.datamodel.e eVar = new com.baidu.wallet.paysdk.datamodel.e();
            if (eVar.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(eVar.getRequestId(), eVar);
            }
            return eVar.checkRequestValidity();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            a(this.f26429f, this.f26430g, this.f26431h, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f26425b && (payBaseActivity = this.f26424a) != null) {
                WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
            }
            if (this.f26426c == null) {
                this.f26426c = (ai) PayBeanFactory.getInstance().getBean((Context) this.f26424a, 10, ISmsController.BEAN_TAG);
            }
            this.f26426c.setResponseCallback(this.f26424a);
            this.f26426c.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f26424a = payBaseActivity;
            this.f26429f = payBaseActivity.getIntent().getBooleanExtra(PaySettingActivity.OPENED, true);
            this.f26430g = this.f26424a.getIntent().getStringExtra(PaySettingActivity.PWD);
            this.f26431h = this.f26424a.getIntent().getStringExtra("phone");
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f26428e = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f26427d = smsVerifyHandler;
        }
    }
}
