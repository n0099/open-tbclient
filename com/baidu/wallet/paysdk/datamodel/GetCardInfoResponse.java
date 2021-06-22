package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.wallet.base.datamodel.PayData;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes5.dex */
public class GetCardInfoResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -7267923736947733889L;
    public Algorithm algorithm_check_info;
    public BindCardInfo bind_card_info;
    public CardInfo card_info;
    public Map<String, String> cashdesk;
    public ChannelInfo channel_info;
    public ProtocolInfo protocol_info;
    public SpInfo sp_info;

    /* loaded from: classes5.dex */
    public static class Algorithm implements Serializable {
        public static final long serialVersionUID = -1246105472340646254L;
        public int code;
        public String msg;
    }

    /* loaded from: classes5.dex */
    public static class BindCardInfo implements Serializable {
        public static final long serialVersionUID = 424736973323730942L;
        public String bind_card_desc;
    }

    /* loaded from: classes5.dex */
    public static class CalcPaymentResponseImpl extends CalcPaymentResponse implements Serializable {
        public static final long serialVersionUID = 1;
        public String card_no;
    }

    /* loaded from: classes5.dex */
    public static class CardInfo implements Serializable {
        public static final long serialVersionUID = 4241463573323730942L;
        public String bank_logourl;
        public String bank_name;
        public String bank_no;
        public int card_type;
        public String desc;
        public String easypay_amount;
    }

    /* loaded from: classes5.dex */
    public static class CardItemRequired implements Serializable {
        public static final String IS_REQUIRED = "1";
        public static final String NOT_REQUIRED = "0";
        public static final long serialVersionUID = -7604429898684469632L;
        public String certificate_code;
        public String certificate_type;
        public String mobile;
        public String true_name;
        public String valid_code;
        public String valid_date;
    }

    /* loaded from: classes5.dex */
    public static class CertificateTypeInfo implements Serializable {
        public static final String HONG_KONG_AND_MACAO_PASS = "4";
        public static final String ID_CARD = "1";
        public static final String OFFICER = "2";
        public static final String PASSPORT = "3";
        public static final long serialVersionUID = 2006299127113478802L;
        public String description;
        public boolean isDisplay = false;
        public String type;

        public com.baidu.wallet.paysdk.a getValidator() {
            long j = "1".equals(this.type) ? 2L : 1L;
            if ("2".equals(this.type)) {
                j = 16;
            }
            if ("3".equals(this.type)) {
                j = 4;
            }
            if ("4".equals(this.type)) {
                j = 8;
            }
            return new com.baidu.wallet.paysdk.a(j);
        }

        public boolean isDisplay() {
            return this.isDisplay;
        }

        public void setDisplay(boolean z) {
            this.isDisplay = z;
        }

        public String toString() {
            return "CertificateTypeInfo [type=" + this.type + ", description=" + this.description + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    /* loaded from: classes5.dex */
    public static class ChannelInfo implements Serializable {
        public static final long serialVersionUID = -1655363585956229526L;
        public CardItemRequired card_item_required;
        public CertificateTypeInfo[] certificate_type_info;
        public String channel_no;
        public int is_simplify_page;
        public CalcPaymentResponseImpl mkt_info;
        public String need_pay_one_cent;
        public String need_pay_one_cent_desc;
        public int need_send_sms;

        public boolean isNeedSendSms() {
            return this.need_send_sms == 1;
        }

        public boolean updatePhoneOnly() {
            return this.is_simplify_page == 1;
        }
    }

    /* loaded from: classes5.dex */
    public static class ProtocolInfo implements Serializable {
        public static final long serialVersionUID = -4330766379370170338L;
        public String is_agreement_checked;
        public String last_separator;
        public ProtocolItem[] list;
        public String prefix;
        public String separator;
        public String suffix;

        public boolean isProtocolCheckedDefault() {
            return "1".equals(this.is_agreement_checked);
        }
    }

    /* loaded from: classes5.dex */
    public static class ProtocolItem implements Serializable {
        public static final long serialVersionUID = -1246105472340646254L;
        public String title;
        public String url;
    }

    /* loaded from: classes5.dex */
    public static class SpInfo implements Serializable {
        public static final long serialVersionUID = 4241462876393730942L;
        public String order_no;
        public String sp_no;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return (this.card_info == null || this.channel_info == null) ? false : true;
    }

    public String getCardInfoCouponDesc() {
        CalcPaymentResponseImpl calcPaymentResponseImpl;
        PayData.ChannelDiscountMap[] channelDiscountMapArr;
        ChannelInfo channelInfo = this.channel_info;
        if (channelInfo == null || (calcPaymentResponseImpl = channelInfo.mkt_info) == null || TextUtils.isEmpty(calcPaymentResponseImpl.card_no) || (channelDiscountMapArr = this.channel_info.mkt_info.activity_map) == null || channelDiscountMapArr.length <= 0) {
            return "";
        }
        int i2 = 0;
        while (true) {
            CalcPaymentResponseImpl calcPaymentResponseImpl2 = this.channel_info.mkt_info;
            PayData.ChannelDiscountMap[] channelDiscountMapArr2 = calcPaymentResponseImpl2.activity_map;
            if (i2 >= channelDiscountMapArr2.length) {
                return "";
            }
            if (calcPaymentResponseImpl2.card_no.equals(channelDiscountMapArr2[i2].card_no)) {
                return this.channel_info.mkt_info.activity_map[i2].description;
            }
            i2++;
        }
    }

    public String getOneCentsDesc() {
        ChannelInfo channelInfo = this.channel_info;
        return (channelInfo == null || TextUtils.isEmpty(channelInfo.need_pay_one_cent_desc)) ? "" : this.channel_info.need_pay_one_cent_desc;
    }

    public boolean isOneCentsBusiness() {
        ChannelInfo channelInfo = this.channel_info;
        return (channelInfo == null || TextUtils.isEmpty(channelInfo.need_pay_one_cent) || !"1".equals(this.channel_info.need_pay_one_cent)) ? false : true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
