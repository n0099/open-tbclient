package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes5.dex */
public class PayData implements NoProguard {

    /* loaded from: classes5.dex */
    public static class BaseDiscount implements Serializable {
        public static final int ENABLE = 1;
        public static final int SELECTED_N = 0;
        public static final int SELECTED_Y = 1;
        public static final long serialVersionUID = 7733945479094020566L;
        public String description;
        public String discount_amount;
        public String discount_msg;
        public String icon_url;
        public String id;
        public String select_state_desc;
        public int selectable;
        public int selected;

        public boolean getEnable() {
            return this.selectable == 1;
        }

        public boolean getSelected() {
            return this.selected == 1;
        }

        public String getSelectedString() {
            return this.selected == 1 ? String.valueOf(1) : String.valueOf(0);
        }

        public void setSelected(boolean z) {
            if (z) {
                this.selected = 1;
            } else {
                this.selected = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ChannelDiscountMap implements Serializable {
        public String card_no;
        public String description;
        public String id;
        public String pay_type;
    }

    /* loaded from: classes5.dex */
    public static class Composite extends CalcPaymentResponse implements Serializable {
        public static final long serialVersionUID = -3143405575033566246L;
    }

    /* loaded from: classes5.dex */
    public static class Coupon extends BaseDiscount implements Serializable {
        public static final long serialVersionUID = -7652331651512403394L;
        public String expire_time;
    }

    /* loaded from: classes5.dex */
    public static class CreditInfo implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String available_credit;
        public InstalmentPlan[] instalment_plan;
        public String repayment_date;
    }

    /* loaded from: classes5.dex */
    public static class CreditPay implements NoProguard, Serializable {
        public static final String CREDITPAY_AVAILABLE = "1";
        public static final String CREDITPAY_DISABLE = "2";
        public static final long serialVersionUID = 1;
        public CreditInfo credit_info;
        public String disable_msg;
        public String display_name;
        public String is_recommended;
        public String need_pay_password;
        public Map<String, String> post_info;
        public String status = "2";
    }

    /* loaded from: classes5.dex */
    public static class Detainment implements Serializable {
        public static final long serialVersionUID = 1;
        public String desc;
    }

    /* loaded from: classes5.dex */
    public static class DirectPayBalance implements Serializable {
        public static final long serialVersionUID = -663973664201929790L;
        public String balance_amount;
        public String balance_jump_url;
        public String balance_trans_amount;
        public String disabled_msg;
        public int enough;
        public String is_recommended;
        public int need_sms_code;
        public Map<String, String> post_info;
        public int status;

        public String getService() {
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
    }

    /* loaded from: classes5.dex */
    public static class DirectPayPay implements NoProguard, Serializable {
        public static final long serialVersionUID = 7929986508919633280L;
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

        public boolean hasRecommendPaytype() {
            return TextUtils.equals(this.recommend_flag, "1");
        }
    }

    /* loaded from: classes5.dex */
    public static class Discount extends BaseDiscount implements Serializable {
        public static final long serialVersionUID = -7652331651512403394L;
        public int type;

        public boolean isCommonDiscount() {
            return this.type != 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class EasyPay implements NoProguard, Serializable {
        public static final long serialVersionUID = -3341431684992819463L;
        public String bank_card_detect_enabled;
        public CardData.BondCard[] bind_card_arr;
        public String can_bind_card_flag = "0";
        public String disabled_cardtype_msg;
        public int no_bind_bank;
        public Map<String, String> post_info;
        public String single_amount_limit;
        public int status;
        public String total_amount;

        public void decrypt() {
            CardData.BondCard[] bondCardArr = this.bind_card_arr;
            if (bondCardArr == null || bondCardArr.length <= 0) {
                return;
            }
            for (CardData.BondCard bondCard : bondCardArr) {
                bondCard.decrypt();
            }
        }

        public String getAmount() {
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

        public String getBuyerUserId() {
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

        public String getHdTag() {
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

        public String getService() {
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
    }

    /* loaded from: classes5.dex */
    public static class InstalmentPlan implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String amount;
        public String fee_amount;
        public String instalment;
        public String rate;
    }

    /* loaded from: classes5.dex */
    public static class RandomDiscount implements Serializable {
        public String msg;
        public String[] paytype;
    }
}
