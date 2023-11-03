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
public class jrc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealInfo dealInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", dealInfo.title);
            poc.a(jSONObject, "des", dealInfo.des);
            poc.a(jSONObject, "stock", dealInfo.stock);
            poc.a(jSONObject, "sales", dealInfo.sales);
            poc.a(jSONObject, "expire_time", dealInfo.expire_time);
            poc.a(jSONObject, "unit_price", dealInfo.unit_price);
            poc.a(jSONObject, "product_id", dealInfo.product_id);
            poc.a(jSONObject, "seller_address", dealInfo.seller_address);
            poc.a(jSONObject, "recommendations", dealInfo.recommendations);
            poc.a(jSONObject, "has_recommend", dealInfo.has_recommend);
            poc.a(jSONObject, "status", dealInfo.status);
            if (dealInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (DealMedia dealMedia : dealInfo.media) {
                    jSONArray.put(krc.b(dealMedia));
                }
                poc.a(jSONObject, "media", jSONArray);
            }
            if (dealInfo.auth_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DealAuthInfo dealAuthInfo : dealInfo.auth_info) {
                    jSONArray2.put(irc.b(dealAuthInfo));
                }
                poc.a(jSONObject, "auth_info", jSONArray2);
            }
            poc.a(jSONObject, "ship_fee", dealInfo.ship_fee);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
