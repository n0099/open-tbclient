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
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UnbindCardBean;
import com.baidu.wallet.paysdk.beans.o;
import com.baidu.wallet.paysdk.datamodel.UnBindSmSResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes8.dex */
public class f implements ISmsController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f62750a;

    /* renamed from: b  reason: collision with root package name */
    public String f62751b;

    /* renamed from: c  reason: collision with root package name */
    public String f62752c;

    /* renamed from: d  reason: collision with root package name */
    public SmsUpdateUiInterface f62753d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62754e;

    /* renamed from: f  reason: collision with root package name */
    public SmsVerifyHandler f62755f;

    public f() {
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
        this.f62754e = false;
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
            this.f62750a = null;
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
            bundle.putString("card_no", this.f62751b);
            bundle.putString("phone_no", this.f62752c);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 == 514) {
                WalletGlobalUtils.safeDismissDialog(this.f62750a, 0);
                this.f62754e = false;
                if (!TextUtils.isEmpty(str)) {
                    GlobalUtils.toast(this.f62750a, str);
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f62753d;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.clearSmsEditText();
                    this.f62753d.doStopCountDown();
                }
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.f62750a, "ebpay_send_fail");
                }
                SmsVerifyHandler smsVerifyHandler = this.f62755f;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendFailure(i3, str);
                }
            } else if (i2 != 516) {
                return false;
            } else {
                WalletGlobalUtils.safeDismissDialog(this.f62750a, 0);
                SmsVerifyHandler smsVerifyHandler2 = this.f62755f;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifyFailure(i3, str);
                }
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        SmsUpdateUiInterface smsUpdateUiInterface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, obj, str)) == null) {
            if (i2 == 514) {
                this.f62754e = false;
                WalletGlobalUtils.safeDismissDialog(this.f62750a, 0);
                PayBaseActivity payBaseActivity = this.f62750a;
                GlobalUtils.toast(payBaseActivity, ResUtils.getString(payBaseActivity, "ebpay_sms_sent"));
                if (obj != null && (obj instanceof UnBindSmSResponse) && (smsUpdateUiInterface = this.f62753d) != null) {
                    UnBindSmSResponse unBindSmSResponse = (UnBindSmSResponse) obj;
                    smsUpdateUiInterface.upDateSafeKeyBoradView(unBindSmSResponse.sms_length, unBindSmSResponse.sms_type);
                }
                SmsVerifyHandler smsVerifyHandler = this.f62755f;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
            } else if (i2 != 516) {
                return false;
            } else {
                WalletGlobalUtils.safeDismissDialog(this.f62750a, 0);
                SmsVerifyHandler smsVerifyHandler2 = this.f62755f;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifySuccess();
                }
                this.f62750a.finish();
            }
            return true;
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (payBaseActivity = this.f62750a) == null) {
            return;
        }
        this.f62753d.initSMSActivityView("dxm_wallet_base_verify_phone_no", "", ResUtils.getString(payBaseActivity, "wallet_base_unbind_tip"), this.f62752c, false);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.f62754e = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (bundle == null) {
                PayBaseActivity payBaseActivity = this.f62750a;
                if (payBaseActivity == null) {
                    return false;
                }
                this.f62751b = payBaseActivity.getIntent().getStringExtra(BeanConstants.EXTRA_CARD_NO);
                this.f62752c = this.f62750a.getIntent().getStringExtra(BeanConstants.EXTRA_PHONE_NO);
            } else {
                this.f62751b = bundle.getString("card_no");
                this.f62752c = bundle.getString("phone_no");
            }
            com.baidu.wallet.paysdk.datamodel.b bVar = new com.baidu.wallet.paysdk.datamodel.b();
            bVar.f62481b = this.f62751b;
            bVar.f62480a = this.f62752c;
            if (bVar.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(bVar.getRequestId(), bVar);
            }
            return bVar.checkRequestValidity();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            UnbindCardBean unbindCardBean = (UnbindCardBean) PayBeanFactory.getInstance().getBean((Context) this.f62750a, 516, ISmsController.BEAN_TAG);
            unbindCardBean.setCardNo(this.f62751b);
            unbindCardBean.setPhoneNo(this.f62752c);
            unbindCardBean.setUsePass(false);
            unbindCardBean.setValue(str);
            unbindCardBean.setResponseCallback(this.f62750a);
            unbindCardBean.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f62754e && (payBaseActivity = this.f62750a) != null) {
                WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
            }
            o oVar = (o) PayBeanFactory.getInstance().getBean((Context) this.f62750a, 514, ISmsController.BEAN_TAG);
            oVar.setResponseCallback(this.f62750a);
            oVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f62750a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f62753d = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f62755f = smsVerifyHandler;
        }
    }
}
