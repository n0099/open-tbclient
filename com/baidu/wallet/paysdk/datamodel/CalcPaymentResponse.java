package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CalcPaymentResponse implements IBeanResponse, NoProguard, Serializable {
    public static final int SELECTION_NO_CHANGE = -1;
    public static final long serialVersionUID = 2906317784498976013L;
    public PayData.Discount[] activity_list;
    public PayData.ChannelDiscountMap[] activity_map;
    public String balance_amount;
    public String balance_jump_url;
    public String balance_select_desc;
    public String balance_trans_amount;
    public PayData.Coupon[] coupon_list;
    public String credit_amount;
    public String credit_select_desc;
    public String credit_trans_amount;
    public String easypay_amount;
    public String easypay_select_desc;
    public String easypay_trans_amount;
    public String total_discount_amount;
    public String total_discount_msg;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public String getActivitiesJsonParams(int i2, String str) {
        PayData.Discount[] discountArr = this.activity_list;
        if (discountArr == null || discountArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        while (true) {
            PayData.Discount[] discountArr2 = this.activity_list;
            if (i3 < discountArr2.length) {
                PayData.Discount discount = discountArr2[i3];
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", discount.id);
                    if (i3 == i2) {
                        jSONObject.put("selected", str);
                    } else {
                        jSONObject.put("selected", discount.getSelectedString());
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i3++;
            } else {
                return jSONArray.toString();
            }
        }
    }

    public String getCouponJsonParams(int i2, String str) {
        PayData.Coupon[] couponArr = this.coupon_list;
        if (couponArr == null || couponArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        while (true) {
            PayData.Coupon[] couponArr2 = this.coupon_list;
            if (i3 < couponArr2.length) {
                PayData.Coupon coupon = couponArr2[i3];
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", coupon.id);
                    if (i3 == i2) {
                        jSONObject.put("selected", str);
                    } else {
                        jSONObject.put("selected", coupon.getSelectedString());
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i3++;
            } else {
                return jSONArray.toString();
            }
        }
    }

    public String getDiscountMapJsonParams() {
        PayData.ChannelDiscountMap[] channelDiscountMapArr = this.activity_map;
        if (channelDiscountMapArr == null || channelDiscountMapArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        while (true) {
            PayData.ChannelDiscountMap[] channelDiscountMapArr2 = this.activity_map;
            if (i2 < channelDiscountMapArr2.length) {
                PayData.ChannelDiscountMap channelDiscountMap = channelDiscountMapArr2[i2];
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("card_no", channelDiscountMap.card_no);
                    jSONObject.put("id", channelDiscountMap.id);
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i2++;
            } else {
                return jSONArray.toString();
            }
        }
    }

    public String getSelectedCouponIds() {
        return getSelectedCouponIds(this.coupon_list);
    }

    public String getSelectedDiscountIds() {
        return getSelectedDiscountIds(this.activity_list);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public String getSelectedCouponIds(PayData.Coupon[] couponArr) {
        if (couponArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (PayData.Coupon coupon : couponArr) {
            if (coupon.getSelected()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(coupon.id);
            }
        }
        return sb.toString();
    }

    public String getSelectedDiscountIds(PayData.Discount[] discountArr) {
        if (discountArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (PayData.Discount discount : discountArr) {
            if (discount.getSelected()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(discount.id);
            }
        }
        return sb.toString();
    }

    public String getActivitiesJsonParams() {
        return getActivitiesJsonParams(-1, null);
    }

    public String getCouponJsonParams() {
        return getCouponJsonParams(-1, null);
    }
}
