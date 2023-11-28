package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DealAuthInfo;
import tbclient.DealInfo;
import tbclient.DealMedia;
/* loaded from: classes6.dex */
public class iwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealInfo dealInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", dealInfo.title);
            ltc.a(jSONObject, "des", dealInfo.des);
            ltc.a(jSONObject, "stock", dealInfo.stock);
            ltc.a(jSONObject, "sales", dealInfo.sales);
            ltc.a(jSONObject, "expire_time", dealInfo.expire_time);
            ltc.a(jSONObject, "unit_price", dealInfo.unit_price);
            ltc.a(jSONObject, "product_id", dealInfo.product_id);
            ltc.a(jSONObject, "seller_address", dealInfo.seller_address);
            ltc.a(jSONObject, "recommendations", dealInfo.recommendations);
            ltc.a(jSONObject, "has_recommend", dealInfo.has_recommend);
            ltc.a(jSONObject, "status", dealInfo.status);
            if (dealInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (DealMedia dealMedia : dealInfo.media) {
                    jSONArray.put(jwc.b(dealMedia));
                }
                ltc.a(jSONObject, "media", jSONArray);
            }
            if (dealInfo.auth_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DealAuthInfo dealAuthInfo : dealInfo.auth_info) {
                    jSONArray2.put(hwc.b(dealAuthInfo));
                }
                ltc.a(jSONObject, "auth_info", jSONArray2);
            }
            ltc.a(jSONObject, "ship_fee", dealInfo.ship_fee);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
