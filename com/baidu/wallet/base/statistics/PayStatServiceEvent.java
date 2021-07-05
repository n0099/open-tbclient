package com.baidu.wallet.base.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PayStatServiceEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIND_CARD_PASS_AGREE = "bind_card_pass_agree";
    public static final String BIND_CARD_PASS_ENTER = "bind_card_pass_enter";
    public static final String BIND_CARD_PASS_FAILED = "bind_card_pass_failed";
    public static final String CALL_INTERFACE = "call_interface";
    public static final String ENTER_BIND_CARD_ACTIVITY = "enter_bind_card_activity";
    public static final String FAST_DOUBLE_CLICK_CHANGE_PAY_METHOD = "fastDoubleClickChangePayMethod";
    public static final String FAST_DOUBLE_CLICK_DO_PAY = "fastDoubleClickDoPay";
    public static final String FAST_DOUBLE_CLICK_DO_POLYMER_PAY = "fastDoubleClickDoPolymerPay";
    public static final String FAST_DOUBLE_CLICK_GET_PAY_METHOD = "fastDoubleClickGetPayMethod";
    public static final String FAST_DOUBLE_CLICK_PRE_ORDER_PAY = "fastDoubleClickPreOrderPay";
    public static final String INITIVATIVE_BIND_CARD_ENTER = "initiative_bind_card_enter";
    public static final String INITIVATIVE_BIND_CARD_FAILED = "initiative_bind_card_failed";
    public static final String INITIVATIVE_BIND_CARD_SUCCESS = "initiative_bind_card_success";
    public static final String LBS_PAY_CHANNEL = "lbs_pay_channel";
    public static final String LBS_PAY_ENTER = "lbs_pay_enter";
    public static final String LBS_PAY_RESULT_CANCEL = "lbs_pay_result_cancel";
    public static final String LBS_PAY_RESULT_ERROR = "lbs_pay_result_error";
    public static final String LBS_PAY_RESULT_PAYING = "lbs_pay_result_paying";
    public static final String LBS_PAY_RESULT_SUCCESS = "lbs_pay_result_success";
    public static final String LCL_LOGIN_ENTER = "lcl_login_enter";
    public static final String LCL_OPENBDUSS_RESULT = "lcl_openbduss_result";
    public static final String LCL_PASS_RESULT = "lcl_pass_result";
    public static final String LCL_PAY_ENTER = "lcl_pay_enter";
    public static final String PAY_BIND_CARD_ENTER = "pay_bind_card_enter";
    public static final String PAY_BIND_CARD_FAILED = "pay_bind_card_failed";
    public static final String PAY_BIND_CARD_SUCCESS = "pay_bind_card_success";
    public static final String PAY_GUIDANCE_ENTER = "pay_guidance_enter";
    public static final String PAY_ORDER_COLLATION = "PAY_ORDER_COLLATION";
    public static final String PAY_RESULT_RNAUTH_ENTER = "pay_result_rnauth_enter";
    public static final String PAY_RESULT_RNAUTH_RESULT = "pay_result_rnauth_result";
    public static final String PAY_RNAUTH_ENTER = "pay_rnauth_enter";
    public static final String PAY_RNAUTH_RESULT = "pay_rnauth_result";
    public static final String PAY_SECURITY_RNAUTH_ENTER = "pay_security_rnauth_enter";
    public static final String PAY_SECURITY_RNAUTH_RESULT = "pay_security_rnauth_result";
    public static final String PAY_SMS_ENTER = "pay_sms_enter";
    public static final String PERCASHIER_OPENBDUSS_RESULT = "percashier_openbduss_result";
    public static final String PERCASHIER_PASS_RESULT = "percashier_pass_result";
    public static final String PERCASHIER_PAY = "percashier_pay";
    public static final String PERCASHIER_PAY_ENTER = "percashier_pay_enter";
    public static final String PERCASHIER_PAY_FAILED = "percashier_pay_failed";
    public static final String PERCASHIER_PAY_LOGIN = "percashier_pay_login";
    public static final String PERCASHIER_PAY_ORDER = "percashier_pay_order";
    public static final String PERCASHIER_PAY_REORDER = "percashier_pay_reorder";
    public static final String PERCASHIER_PAY_SUCCESS = "percashier_pay_success";
    public static final String RMT_LOGIN_ENTER = "rmt_login_enter";
    public static final String RMT_OPENBDUSS_RESULT = "rmt_openbduss_result";
    public static final String RMT_PASS_RESULT = "rmt_pass_result";
    public static final String RMT_PAY_ACCEPT = "rmt_pay_accept";
    public static final String SENSOR_PLATFORM_KEY_DURATION = "duration";
    public static final String STD_PAY = "std_pay";
    public static final String STD_PAY_CANCEL = "std_pay_cancel";
    public static final String STD_PAY_ENTER = "std_pay_enter";
    public static final String STD_PAY_FAILED = "std_pay_failed";
    public static final String STD_PAY_NOT_LOGIN = "std_pay_not_login";
    public static final String STD_PAY_ORDER = "std_pay_order";
    public static final String STD_PAY_REORDER = "std_pay_reorder";
    public static final String STD_PAY_SUCCESS = "std_pay_success";
    public transient /* synthetic */ FieldHolder $fh;

    public PayStatServiceEvent() {
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
}
