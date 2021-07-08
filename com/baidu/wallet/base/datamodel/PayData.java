package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes5.dex */
public class PayData implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class BaseDiscount implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ENABLE = 1;
        public static final int SELECTED_N = 0;
        public static final int SELECTED_Y = 1;
        public static final long serialVersionUID = 7733945479094020566L;
        public transient /* synthetic */ FieldHolder $fh;
        public String description;
        public String discount_amount;
        public String discount_msg;
        public String icon_url;
        public String id;
        public String select_state_desc;
        public int selectable;
        public int selected;

        public BaseDiscount() {
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

        public boolean getEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.selectable == 1 : invokeV.booleanValue;
        }

        public boolean getSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.selected == 1 : invokeV.booleanValue;
        }

        public String getSelectedString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.selected == 1 ? String.valueOf(1) : String.valueOf(0) : (String) invokeV.objValue;
        }

        public void setSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (z) {
                    this.selected = 1;
                } else {
                    this.selected = 0;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ChannelDiscountMap implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String card_no;
        public String description;
        public String id;
        public String pay_type;

        public ChannelDiscountMap() {
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
    public static class Composite extends CalcPaymentResponse implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3143405575033566246L;
        public transient /* synthetic */ FieldHolder $fh;

        public Composite() {
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
    public static class Coupon extends BaseDiscount implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7652331651512403394L;
        public transient /* synthetic */ FieldHolder $fh;
        public String expire_time;

        public Coupon() {
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
    public static class CreditInfo implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String available_credit;
        public InstalmentPlan[] instalment_plan;
        public String repayment_date;

        public CreditInfo() {
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
    public static class CreditPay implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String CREDITPAY_AVAILABLE = "1";
        public static final String CREDITPAY_DISABLE = "2";
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public CreditInfo credit_info;
        public String disable_msg;
        public String display_name;
        public String is_recommended;
        public String need_pay_password;
        public Map<String, String> post_info;
        public String status;

        public CreditPay() {
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
            this.status = "2";
        }
    }

    /* loaded from: classes5.dex */
    public static class Detainment implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String desc;

        public Detainment() {
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
    public static class DirectPayBalance implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -663973664201929790L;
        public transient /* synthetic */ FieldHolder $fh;
        public String balance_amount;
        public String balance_jump_url;
        public String balance_trans_amount;
        public String disabled_msg;
        public int enough;
        public String is_recommended;
        public int need_sms_code;
        public Map<String, String> post_info;
        public int status;

        public DirectPayBalance() {
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

        public String getService() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Map<String, String> map = this.post_info;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if ("service".equals(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class DirectPayPay implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7929986508919633280L;
        public transient /* synthetic */ FieldHolder $fh;
        public DirectPayBalance balance;
        public Composite composite;
        public CreditPay credit_pay;
        public String default_pay_type_display;
        public Detainment detainment;
        public String disabled_cardtype_msg;
        public EasyPay easypay;
        public RandomDiscount random_discount;
        public String recommend_flag;
        public String selected_card_no;
        public String session_info;

        public DirectPayPay() {
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

        public boolean hasRecommendPaytype() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.equals(this.recommend_flag, "1") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class Discount extends BaseDiscount implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7652331651512403394L;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        public Discount() {
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

        public boolean isCommonDiscount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type != 3 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class EasyPay implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3341431684992819463L;
        public transient /* synthetic */ FieldHolder $fh;
        public String bank_card_detect_enabled;
        public CardData.BondCard[] bind_card_arr;
        public String can_bind_card_flag;
        public String disabled_cardtype_msg;
        public int no_bind_bank;
        public Map<String, String> post_info;
        public String single_amount_limit;
        public int status;
        public String total_amount;

        public EasyPay() {
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
            this.can_bind_card_flag = "0";
        }

        public void decrypt() {
            CardData.BondCard[] bondCardArr;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bondCardArr = this.bind_card_arr) == null || bondCardArr.length <= 0) {
                return;
            }
            for (CardData.BondCard bondCard : bondCardArr) {
                bondCard.decrypt();
            }
        }

        public String getAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Map<String, String> map = this.post_info;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (PayUiEventContent.AMOUNT.equals(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public String getBuyerUserId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Map<String, String> map = this.post_info;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if ("buyer_user_id".equals(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public String getHdTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Map<String, String> map = this.post_info;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if ("hd_tag".equals(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public String getService() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Map<String, String> map = this.post_info;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if ("service".equals(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return "";
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class InstalmentPlan implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String amount;
        public String fee_amount;
        public String instalment;
        public String rate;

        public InstalmentPlan() {
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
    public static class RandomDiscount implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String msg;
        public String[] paytype;

        public RandomDiscount() {
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

    public PayData() {
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
