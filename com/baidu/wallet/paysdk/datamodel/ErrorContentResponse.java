package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ErrorContentResponse implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NEED_UPDATE = "1";
    public static final String PAY_BY_SMS_DISABLE = "0";
    public static final String PAY_BY_SMS_ENABLE = "1";
    public static final long serialVersionUID = 1572006194091664237L;
    public transient /* synthetic */ FieldHolder $fh;
    public GetCardInfoResponse.CardItemRequired card_item_required;
    public GetCardInfoResponse.CertificateTypeInfo[] certificate_type_info;
    public Guidance guidance;
    public String hint_sms;
    public LivingParam living_param;
    public MktSolution mkt_solution;
    public String need_cvv2;
    public String need_identity_code;
    public String need_identity_type;
    public String need_other_pay_method;
    public String need_phone_num;
    public String need_send_sms;
    public String need_valid_date;
    public String order_amount;
    public String use_vcode_to_pay;
    public Verify verify;

    /* loaded from: classes8.dex */
    public static class CardInfoCheck implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String card_no;
        public String certicicate_code;
        public String verify_code;

        public CardInfoCheck() {
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

    /* loaded from: classes8.dex */
    public static class Guidance implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Operations[] operations;
        public String prompt_body;
        public String prompt_head;

        public Guidance() {
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

        public boolean isGuidanceAvilable() {
            InterceptResult invokeV;
            Operations[] operationsArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean z = (TextUtils.isEmpty(this.prompt_body) || (operationsArr = this.operations) == null || operationsArr.length <= 0) ? false : true;
                if (z) {
                    for (Operations operations : this.operations) {
                        z = operations.isOperationAvilable();
                        if (!z) {
                            break;
                        }
                    }
                    return z;
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class LivingParam implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String sp_params;
        public String user_display_name;
        public String usertoken;

        public LivingParam() {
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

    /* loaded from: classes8.dex */
    public static class MktSolution implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public PayData.Discount[] activity_list;
        public String balance_amount;
        public PayData.Coupon[] coupon_list;
        public String easypay_amount;

        public MktSolution() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "& easypay_amount = " + this.easypay_amount;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class Operations implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BIND_OTHER_CARDS = "bind_other_cards";
        public static final String CALL_UP = "call_up";
        public static final String CASHDESK_CLOSE = "cashdesk_close";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String FIND_PWD = "find_pwd";
        public static final String HELP_CENTER = "help_center";
        public static final String LIVING_AGAIN = "living_again";
        public static final String NOTICE = "notice";
        public static final String RETRY_PAY = "retry_pay";
        public static final String SEND_SMS = "send_sms";
        public transient /* synthetic */ FieldHolder $fh;
        public transient Map<String, n> handlers;
        public String hint;
        public String jump_uri;
        public String mobile;
        public String need_close;
        public String type;

        public Operations() {
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
            this.handlers = new HashMap();
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Operations) && TextUtils.equals(((Operations) obj).type, this.type) : invokeL.booleanValue;
        }

        public n getAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (NOTICE.equals(this.type)) {
                    return new n<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f62269a;

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
                            this.f62269a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.n
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, this.f62269a.type);
                            }
                        }
                    };
                }
                if (CALL_UP.equals(this.type)) {
                    return new n<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f62270a;

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
                            this.f62270a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.n
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, this.f62270a.type);
                                try {
                                    String str = operations.mobile;
                                    context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    };
                }
                if (CASHDESK_CLOSE.equals(this.type)) {
                    return new n<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f62271a;

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
                            this.f62271a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.n
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, this.f62271a.type);
                                PayCallBackManager.callBackClientPaying(context);
                            }
                        }
                    };
                }
                if (HELP_CENTER.equals(this.type)) {
                    return new n<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f62272a;

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
                            this.f62272a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.n
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, this.f62272a.type);
                                if (context == null || operations == null || TextUtils.isEmpty(operations.jump_uri)) {
                                    return;
                                }
                                BaiduWalletDelegate.getInstance().openH5Module(context, this.f62272a.jump_uri, false);
                                if ("1".equals(this.f62272a.need_close)) {
                                    StatisticManager.onEvent("payTimeoutGuideToOrderDetail", PayDataCache.getInstance().getInsideTransOrder());
                                    new Handler().postDelayed(new Runnable(this, context) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ Context f62273a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass4 f62274b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, context};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f62274b = this;
                                            this.f62273a = context;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                PayCallBackManager.callBackClientPaying(this.f62273a);
                                            }
                                        }
                                    }, 20L);
                                }
                            }
                        }
                    };
                }
                if (FIND_PWD.equals(this.type)) {
                    return new n<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f62275a;

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
                            this.f62275a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.n
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, this.f62275a.type);
                                if (context instanceof PwdPayActivity) {
                                    ((PwdPayActivity) context).forgetPassword();
                                } else if (context instanceof PwdCheckActivity) {
                                    ((PwdCheckActivity) context).forgetPasswd(PayRequestCache.BindCategory.Other.name());
                                }
                            }
                        }
                    };
                }
                return this.handlers.get(this.type);
            }
            return (n) invokeV.objValue;
        }

        public String getActionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hint : (String) invokeV.objValue;
        }

        public boolean isOperationAvilable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.hint)) ? false : true : invokeV.booleanValue;
        }

        public void registerActionHandler(String str, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, nVar) == null) {
                this.handlers.put(str, nVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Verify implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String VERIFY_CARD_NO = "card_no";
        public static final String VERIFY_CETIFICATE_CODE = "certificate_code";
        public static final String VERIFY_CVV2 = "verify_code";
        public static final long serialVersionUID = 1747811045878020816L;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] card_item_required;
        public String card_item_required_msg;
        public LivingParam living_param;
        public String mobile_ec;
        public String sms_length;
        public String sms_pattern;
        public String sms_type;
        public String type;
        public String voice_msg;

        public Verify() {
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

        public String getVerifyMobile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mobile_ec : (String) invokeV.objValue;
        }

        public String getVerifyType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (String) invokeV.objValue;
        }

        public String getVoiceMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.voice_msg : (String) invokeV.objValue;
        }
    }

    public ErrorContentResponse() {
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
        this.need_other_pay_method = "0";
    }

    public boolean isNeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? needUpdate(this.need_identity_code) : invokeV.booleanValue;
    }

    public boolean isNeedPhoneNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? needUpdate(this.need_phone_num) : invokeV.booleanValue;
    }

    public boolean isNeedSendSms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? needUpdate(this.need_send_sms) : invokeV.booleanValue;
    }

    public boolean isNeedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? needUpdate(this.need_identity_type) : invokeV.booleanValue;
    }

    public boolean isNeedValidCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? needUpdate(this.need_cvv2) : invokeV.booleanValue;
    }

    public boolean isNeedValidDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? needUpdate(this.need_valid_date) : invokeV.booleanValue;
    }

    public boolean needUpdate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? !TextUtils.isEmpty(str) && "1".equals(str) : invokeL.booleanValue;
    }
}
