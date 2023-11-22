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
/* loaded from: classes7.dex */
public class krc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealInfo dealInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", dealInfo.title);
            qoc.a(jSONObject, "des", dealInfo.des);
            qoc.a(jSONObject, "stock", dealInfo.stock);
            qoc.a(jSONObject, "sales", dealInfo.sales);
            qoc.a(jSONObject, "expire_time", dealInfo.expire_time);
            qoc.a(jSONObject, "unit_price", dealInfo.unit_price);
            qoc.a(jSONObject, "product_id", dealInfo.product_id);
            qoc.a(jSONObject, "seller_address", dealInfo.seller_address);
            qoc.a(jSONObject, "recommendations", dealInfo.recommendations);
            qoc.a(jSONObject, "has_recommend", dealInfo.has_recommend);
            qoc.a(jSONObject, "status", dealInfo.status);
            if (dealInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (DealMedia dealMedia : dealInfo.media) {
                    jSONArray.put(lrc.b(dealMedia));
                }
                qoc.a(jSONObject, "media", jSONArray);
            }
            if (dealInfo.auth_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DealAuthInfo dealAuthInfo : dealInfo.auth_info) {
                    jSONArray2.put(jrc.b(dealAuthInfo));
                }
                qoc.a(jSONObject, "auth_info", jSONArray2);
            }
            qoc.a(jSONObject, "ship_fee", dealInfo.ship_fee);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
