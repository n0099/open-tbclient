package com.baidu.wallet.base.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CardData implements NoProguard {

    /* loaded from: classes5.dex */
    public static class BondCard implements NoProguard, Serializable {
        public static final int UNBIND_CARD_DISABLE_BAIDU_FINANCE = 0;
        public static final long serialVersionUID = -7665566829025394683L;
        public String account_bank_code;
        public String account_no;
        public String account_no_head_tail;
        public String background_url;
        public String bank_card_msg;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public String bind_time;
        public String card_hint_msg;
        public String card_hint_url;
        public String card_required_msg;
        public int card_type;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public GetCardInfoResponse.CertificateTypeInfo[] certificate_type_info;
        public String channelDiscountDesc;
        public ChannelQuota channel_quota;
        public String icon;
        public int is_need_repaired;
        public String is_recommended;
        public int is_sign_jump_bank;
        public String mobile;
        public String mobile_ec;
        public String need_cvv2;
        public String need_identity_code;
        public String need_identity_type;
        public String need_phone_num;
        public String need_sms_code;
        public String need_true_name;
        public String need_valid_date;
        public String quota_show_msg;
        public GetCardInfoResponse.CardItemRequired required_card_items;
        public String single_quota;
        public String status;
        public String true_name;
        public String type_name;
        public String unbund_card_desc;
        public int unbund_card_enabled;
        public String unsupport_find_pwd_msg;
        public String valid_date;
        public String verify_code;
        public int pay_need_sms_code = 1;
        public String card_state = "1";
        public String find_pwd_by_sms = "1";
        public boolean isCheckPass = false;
        public boolean hideSMSDialog = false;

        /* loaded from: classes5.dex */
        public static class ChannelQuota implements NoProguard, Serializable {
            public static final long serialVersionUID = -3143189382088186302L;
            public String day_limit;
            public String month_limit;
            public String show_msg;
            public String single_limit;

            public String getChannelQuotaMsg() {
                return !TextUtils.isEmpty(this.show_msg) ? this.show_msg : "";
            }
        }

        public void decrypt() {
            try {
                if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                    this.certificate_code = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                }
                if (TextUtils.isEmpty(this.mobile_ec)) {
                    return;
                }
                this.mobile = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.mobile_ec));
            } catch (Exception e2) {
                if (BeanConstants.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || BondCard.class != obj.getClass()) {
                return false;
            }
            return this.account_no.equals(((BondCard) obj).account_no);
        }

        public boolean getCanFindPWDBySms() {
            return TextUtils.isEmpty(this.find_pwd_by_sms) || !this.find_pwd_by_sms.equals("0");
        }

        public String getCardDesc(Context context, boolean z) {
            return getCardDesc(this.bank_name, this.account_no, getCardType(context), z);
        }

        public String getCardDescShort() {
            String substring;
            if (TextUtils.isEmpty(this.account_no)) {
                substring = "";
            } else {
                int length = this.account_no.length();
                substring = length > 3 ? this.account_no.substring(length - 4) : this.account_no;
            }
            return "(" + this.bank_name + substring + SmallTailInfo.EMOTION_SUFFIX;
        }

        public String getCardType(Context context) {
            if (!TextUtils.isEmpty(this.type_name)) {
                return this.type_name;
            }
            String str = "wallet_base_mode_debit";
            if (1 == this.card_type) {
                str = "wallet_base_mode_credit";
            }
            return ResUtils.getString(context, str);
        }

        public String getLast4Num() {
            if (TextUtils.isEmpty(this.account_no) || this.account_no.length() <= 4) {
                return "";
            }
            String str = this.account_no;
            return str.substring(str.length() - 4);
        }

        public boolean hasCvv() {
            return !"1".equals(this.need_cvv2);
        }

        public boolean hasDate() {
            return !"1".equals(this.need_valid_date);
        }

        public boolean hasId() {
            return !"1".equals(this.need_identity_code);
        }

        public boolean hasIdType() {
            return !"1".equals(this.need_identity_type);
        }

        public boolean hasMobile() {
            return !"1".equals(this.need_phone_num);
        }

        public boolean hasName() {
            return !"1".equals(this.need_true_name);
        }

        public int hashCode() {
            return this.account_no.hashCode();
        }

        public boolean isCompled() {
            return this.is_need_repaired != 1;
        }

        public boolean isNeedSendSms() {
            return this.pay_need_sms_code == 1;
        }

        public String toString() {
            return "BondCard Info [\nbank_code = " + this.bank_code + "\naccount_no = " + this.account_no + "\ncard_type = " + this.card_type + "\nmobile = " + this.mobile + "\naccount_no_head_tail = " + this.account_no_head_tail + "\nbank_name = " + this.bank_name + "\nbank_url = " + this.bank_url + "\nbankground_url = " + this.background_url + "\nbind_time = " + this.bind_time + "\npay_need_sms_code = " + this.pay_need_sms_code + "\nbank_card_msg = " + this.bank_card_msg + "\n" + PreferencesUtil.RIGHT_MOUNT;
        }

        public static String getCardDesc(String str, String str2, String str3, boolean z) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (z) {
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                if (z) {
                    sb.append(" ");
                }
                int length = str2.length();
                sb.append("(");
                if (length > 3) {
                    str2 = str2.substring(length - 4);
                }
                sb.append(str2);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            return sb.toString();
        }
    }
}
