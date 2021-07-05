package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CalcPaymentResponse implements IBeanResponse, NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SELECTION_NO_CHANGE = -1;
    public static final long serialVersionUID = 2906317784498976013L;
    public transient /* synthetic */ FieldHolder $fh;
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

    public CalcPaymentResponse() {
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

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getActivitiesJsonParams(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str)) != null) {
            return (String) invokeIL.objValue;
        }
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
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(1048580, this, i2, str)) != null) {
            return (String) invokeIL.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return (String) invokeV.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getSelectedCouponIds(this.coupon_list) : (String) invokeV.objValue;
    }

    public String getSelectedDiscountIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getSelectedDiscountIds(this.activity_list) : (String) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
        }
    }

    public String getSelectedCouponIds(PayData.Coupon[] couponArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, couponArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getSelectedDiscountIds(PayData.Discount[] discountArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, discountArr)) == null) {
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
        return (String) invokeL.objValue;
    }

    public String getActivitiesJsonParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getActivitiesJsonParams(-1, null) : (String) invokeV.objValue;
    }

    public String getCouponJsonParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getCouponJsonParams(-1, null) : (String) invokeV.objValue;
    }
}
