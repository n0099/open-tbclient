package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.utils.StringUtils;
import java.io.Serializable;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class GetBindMobileResponse implements IBeanResponse, Serializable {
    public static final String HUODONG_PRICE_NO = "0";
    public static final String HUODONG_PRICE_YES = "1";
    public static final long serialVersionUID = 4241463573323731942L;
    public String email;
    public BottomItem help_page;
    public String mobile;
    public BottomItem mobile_business_hall;
    public PriceInfo[] price_info;
    public FastPayFacePromotionInfoResponse[] promotion_info;
    public String total_mobile_msg;
    public String operator = "";
    public String area = "";
    public String area_operator = "";
    public String is_huodong_price = "";
    public String pay_desc = "";

    /* loaded from: classes5.dex */
    public static class BottomItem implements Serializable {
        public String title;
        public String url;
    }

    private void initDiscount() {
        PriceInfo[] priceInfoArr = this.price_info;
        if (priceInfoArr == null) {
            return;
        }
        int length = priceInfoArr.length;
        for (int i = 0; i < length; i++) {
            BigDecimal multiply = new BigDecimal(this.price_info[i].sell_price).multiply(BigDecimal.TEN);
            this.price_info[i].discount = multiply.divide(new BigDecimal(this.price_info[i].face), 2, 6).toString();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        initDiscount();
        return true;
    }

    public String getExpressMobile() {
        if (TextUtils.isEmpty(this.mobile)) {
            return "";
        }
        String decryptProxy = SafePay.getInstance().decryptProxy(this.mobile);
        if (TextUtils.isEmpty(decryptProxy)) {
            return "";
        }
        String unicodeDecode = SafePay.unicodeDecode(decryptProxy);
        return TextUtils.isEmpty(unicodeDecode) ? "" : StringUtils.formatPhoneNumber(unicodeDecode);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
