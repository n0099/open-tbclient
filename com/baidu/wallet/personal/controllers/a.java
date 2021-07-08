package com.baidu.wallet.personal.controllers;

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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f27079a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f27080b;

    /* renamed from: c  reason: collision with root package name */
    public TransfRecvRequest f27081c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27082d;

    /* renamed from: e  reason: collision with root package name */
    public TransferGetSmsBean f27083e;

    /* renamed from: f  reason: collision with root package name */
    public TransferSmsVerifyBean f27084f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f27085g;

    public a() {
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
        this.f27082d = true;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.f27079a, 0, "");
            PayStatisticsUtil.onEventStart(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS);
            this.f27081c.sms_code = str;
            if (this.f27084f == null) {
                this.f27084f = (TransferSmsVerifyBean) PayBeanFactory.getInstance().getBean((Context) this.f27079a, 19, ISmsController.BEAN_TAG);
            }
            this.f27084f.setResponseCallback(this.f27079a);
            this.f27084f.execBean();
        }
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
            this.f27079a = null;
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
            bundle.putSerializable("request_data", this.f27081c);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 == 19) {
                WalletGlobalUtils.safeDismissDialog(this.f27079a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS, i3);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f27079a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                SmsVerifyHandler smsVerifyHandler = this.f27085g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i3, str);
                }
                return true;
            } else if (i2 == 18) {
                WalletGlobalUtils.safeDismissDialog(this.f27079a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS, i3);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f27079a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                if (this.f27082d) {
                    this.f27082d = false;
                }
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.f27079a, "ebpay_send_fail");
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f27080b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.doStopCountDown();
                }
                SmsVerifyHandler smsVerifyHandler2 = this.f27085g;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsSendFailure(i3, str);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, obj, str)) == null) {
            if (i2 == 19) {
                WalletGlobalUtils.safeDismissDialog(this.f27079a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_CHECKSMS, 0);
                this.f27081c.isGatheringSuccess = true;
                SmsVerifyHandler smsVerifyHandler = this.f27085g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifySuccess();
                }
                Bundle bundle = new Bundle();
                bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, 3);
                this.f27079a.startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
                this.f27079a.finish();
                return true;
            } else if (i2 == 18) {
                WalletGlobalUtils.safeDismissDialog(this.f27079a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS, 0);
                TransferRecvSmSResponse transferRecvSmSResponse = null;
                if (obj != null && (obj instanceof TransferRecvSmSResponse)) {
                    transferRecvSmSResponse = (TransferRecvSmSResponse) obj;
                }
                if (this.f27082d && transferRecvSmSResponse != null) {
                    this.f27082d = false;
                    this.f27080b.upDateSafeKeyBoradView(transferRecvSmSResponse.sms_length, transferRecvSmSResponse.sms_type);
                }
                SmsVerifyHandler smsVerifyHandler2 = this.f27085g;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsSendSuccess();
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
            String string = ResUtils.getString(this.f27079a, "ebpay_pay_next");
            TransfRecvRequest transfRecvRequest = this.f27081c;
            String str = (transfRecvRequest == null || TextUtils.isEmpty(transfRecvRequest.phone)) ? "" : this.f27081c.phone;
            SmsUpdateUiInterface smsUpdateUiInterface = this.f27080b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.initSMSActivityView("bd_wallet_trans_detail", "", string, str, true);
            }
        }
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
                this.f27081c = (TransfRecvRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_TRANSFER_RECV);
            } else {
                this.f27081c = (TransfRecvRequest) bundle.getSerializable("request_data");
            }
            this.f27082d = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            a(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f27082d && (payBaseActivity = this.f27079a) != null) {
                WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.ENVENT_RECV_SMS_SENDSMS);
            if (this.f27083e == null) {
                this.f27083e = (TransferGetSmsBean) PayBeanFactory.getInstance().getBean((Context) this.f27079a, 18, ISmsController.BEAN_TAG);
            }
            this.f27083e.setResponseCallback(this.f27079a);
            this.f27083e.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f27079a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f27080b = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f27085g = smsVerifyHandler;
        }
    }
}
