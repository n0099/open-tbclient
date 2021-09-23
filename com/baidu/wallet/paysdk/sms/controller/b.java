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
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.O2OPayResultItemInfo;
import com.baidu.wallet.paysdk.datamodel.O2OScancodeSendSMSRsp;
import com.baidu.wallet.paysdk.datamodel.O2OTransInfo;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.baidu.wallet.paysdk.datamodel.ScanCodeLimitPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes8.dex */
public class b implements ISmsController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f62999a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f63000b;

    /* renamed from: c  reason: collision with root package name */
    public SmsVerifyHandler f63001c;

    /* renamed from: d  reason: collision with root package name */
    public O2OTransInfo f63002d;

    /* renamed from: e  reason: collision with root package name */
    public PayQueryRequest f63003e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(ScanCodeLimitPayResponse scanCodeLimitPayResponse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, scanCodeLimitPayResponse) == null) || scanCodeLimitPayResponse == null || this.f63002d == null) {
            return;
        }
        PayRequest payRequest = new PayRequest();
        payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
        payRequest.mGoodName = this.f63002d.goods_name;
        PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
        PayResultContent payResultContent = new PayResultContent();
        payResultContent.notify = scanCodeLimitPayResponse.notify;
        payResultContent.score_tip = scanCodeLimitPayResponse.score_tip;
        payResultContent.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
        O2OPayResultItemInfo o2OPayResultItemInfo = scanCodeLimitPayResponse.pay_result;
        if (o2OPayResultItemInfo != null) {
            payResultContent.coupon_msg = o2OPayResultItemInfo.coupon_msg;
            payResultContent.coupon_find_prompt = o2OPayResultItemInfo.coupon_find_prompt;
            String str = o2OPayResultItemInfo.cash_amount;
            payResultContent.cash_amount = str;
            payResultContent.total_amount = o2OPayResultItemInfo.total_amount;
            payResultContent.discount_amount = o2OPayResultItemInfo.discount_amount;
            payResultContent.pay_detail_info = o2OPayResultItemInfo.pay_detail_info;
            payResultContent.paytype_info = o2OPayResultItemInfo.paytype_info;
            payResultContent.discount_prefix = o2OPayResultItemInfo.discount_prefix;
            payResultContent.order_prefix = o2OPayResultItemInfo.order_prefix;
            StatHelper.cachePayAmount(Double.valueOf(str).doubleValue());
        }
        PayController.getInstance().paySucess(this.f62999a, payResultContent, 1);
        this.f62999a.finishWithoutAnim();
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
            BeanManager.getInstance().removeAllBeans(ISmsController.BEAN_TAG);
            this.f62999a = null;
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
            bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.f63002d);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, str)) == null) {
            if (i2 == 595) {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.f62999a.getActivity(), "ebpay_send_fail");
                }
                SmsVerifyHandler smsVerifyHandler = this.f63001c;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendFailure(i3, str);
                }
                return true;
            }
            if (i2 == 594) {
                WalletGlobalUtils.safeDismissDialog(this.f62999a, 0);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f62999a.getActivity()).logout();
                    WalletLoginHelper.getInstance().logout(false);
                } else if (i3 == 15414 || i3 == 15432 || i3 == 69563) {
                    GlobalUtils.toast(this.f62999a, str);
                    return true;
                } else if (i3 == 100018) {
                    GlobalUtils.toast(this.f62999a, str);
                    return true;
                }
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, obj, str)) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f62999a, 0);
            if (i2 == 595) {
                if (obj instanceof O2OScancodeSendSMSRsp) {
                    O2OScancodeSendSMSRsp o2OScancodeSendSMSRsp = (O2OScancodeSendSMSRsp) obj;
                    SmsUpdateUiInterface smsUpdateUiInterface = this.f63000b;
                    if (smsUpdateUiInterface != null) {
                        smsUpdateUiInterface.upDateSafeKeyBoradView(o2OScancodeSendSMSRsp.sms_length, o2OScancodeSendSMSRsp.sms_type);
                    }
                }
                SmsVerifyHandler smsVerifyHandler = this.f63001c;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
                return true;
            } else if (i2 != 594 || !(obj instanceof ScanCodeLimitPayResponse)) {
                if (i2 == 12) {
                    PayRequest payRequest = new PayRequest();
                    payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                    payRequest.mGoodName = this.f63002d.goods_name;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                }
                return false;
            } else {
                ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
                if (scanCodeLimitPayResponse.checkResponseValidity()) {
                    O2OTransInfo o2OTransInfo = this.f63002d;
                    o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                    o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                    if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                        if (this.f63003e == null) {
                            this.f63003e = new PayQueryRequest();
                        }
                        PayQueryRequest payQueryRequest = this.f63003e;
                        payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                        payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                        PayRequestCache.getInstance().addBeanRequestToCache(this.f63003e.getRequestId(), this.f63003e);
                        this.f62999a.queryPayResult();
                    } else {
                        this.f63002d.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                        a(scanCodeLimitPayResponse);
                    }
                }
                return true;
            }
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String string = ResUtils.getString(this.f62999a, "dxm_ebpay_pay_next");
            SmsUpdateUiInterface smsUpdateUiInterface = this.f63000b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", string, this.f63002d.mobile, true);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (bundle == null) {
                this.f63002d = (O2OTransInfo) this.f62999a.getIntent().getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
                return true;
            }
            this.f63002d = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.f62999a, 0, "");
            BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f62999a, PayBeanFactory.BEAN_ID_SCANCODE_PAY, ISmsController.BEAN_TAG);
            if (bean != null) {
                O2OTransInfo o2OTransInfo = this.f63002d;
                bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, str);
                bean.setResponseCallback((WalletSmsActivity) this.f62999a);
                bean.execBean();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f62999a, 0, "");
            BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f62999a, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, ISmsController.BEAN_TAG);
            if (bean != null) {
                O2OTransInfo o2OTransInfo = this.f63002d;
                bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, o2OTransInfo.mobile);
                bean.setResponseCallback((WalletSmsActivity) this.f62999a);
                bean.execBean();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, payBaseActivity) == null) {
            this.f62999a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smsUpdateUiInterface) == null) {
            this.f63000b = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, smsVerifyHandler) == null) {
            this.f63001c = smsVerifyHandler;
        }
    }
}
