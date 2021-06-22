package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.math.BigDecimal;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class QueryLocationResponse implements IBeanResponse {
    public static final String HUODONG_PRICE_NO = "0";
    public static final String HUODONG_PRICE_YES = "1";
    public String mobile_msg;
    public PriceInfo[] price_info;
    public FastPayFacePromotionInfoResponse[] promotion_info;
    public String operator = "";
    public String area = "";
    public String area_operator = "";
    public String is_huodong_price = "";

    private void a() {
        PriceInfo[] priceInfoArr = this.price_info;
        if (priceInfoArr == null) {
            return;
        }
        int length = priceInfoArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            BigDecimal multiply = new BigDecimal(this.price_info[i2].sell_price).multiply(BigDecimal.TEN);
            this.price_info[i2].discount = multiply.divide(new BigDecimal(this.price_info[i2].face), 2, 6).toString();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        a();
        return this.price_info != null;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public String toString() {
        return "QueryLocationResult [operator=" + this.operator + ", area=" + this.area + ", area_operator=" + this.area_operator + ", is_huodong_price=" + this.is_huodong_price + ", price_info=" + Arrays.toString(this.price_info) + PreferencesUtil.RIGHT_MOUNT;
    }
}
