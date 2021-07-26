package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public transient Map<String, q> handlers;
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

        public q getAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (NOTICE.equals(this.type)) {
                    return new q<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f26183a;

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
                            this.f26183a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.q
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                            }
                        }
                    };
                }
                if (CALL_UP.equals(this.type)) {
                    return new q<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f26184a;

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
                            this.f26184a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.q
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
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
                    return new q<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f26185a;

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
                            this.f26185a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.q
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
                                PayCallBackManager.callBackClientPaying(context);
                            }
                        }
                    };
                }
                if (HELP_CENTER.equals(this.type)) {
                    return new q<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f26186a;

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
                            this.f26186a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.q
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) || context == null || operations == null || TextUtils.isEmpty(operations.jump_uri)) {
                                return;
                            }
                            BaiduWalletDelegate.getInstance().openH5Module(context, this.f26186a.jump_uri, false);
                            if ("1".equals(this.f26186a.need_close)) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_PAY_TIMEOUT_GUIDANCE_TO_ORDER_DETAIL, PayDataCache.getInstance().getInsideTransOrder());
                                new Handler().postDelayed(new Runnable(this, context) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ Context f26187a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass4 f26188b;

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
                                        this.f26188b = this;
                                        this.f26187a = context;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            PayCallBackManager.callBackClientPaying(this.f26187a);
                                        }
                                    }
                                }, 20L);
                            }
                        }
                    };
                }
                if (FIND_PWD.equals(this.type)) {
                    return new q<Operations, Context>(this) { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Operations f26189a;

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
                            this.f26189a = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.wallet.paysdk.beans.q
                        public void a(Operations operations, Context context) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, operations, context) == null) {
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
            return (q) invokeV.objValue;
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

        public void registerActionHandler(String str, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, qVar) == null) {
                this.handlers.put(str, qVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Verify implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String VERIFY_CARD_NO = "card_no";
        public static final String VERIFY_CETIFICATE_CODE = "certificate_code";
        public static final String VERIFY_CVV2 = "verify_code";
        public static final long serialVersionUID = 1747811045878020816L;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] card_item_required;
        public String card_item_required_msg;
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
