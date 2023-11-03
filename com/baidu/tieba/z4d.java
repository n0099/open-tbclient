package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TiebaPlusAd;
/* loaded from: classes9.dex */
public class z4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusAd tiebaPlusAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusAd)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "cost_url", tiebaPlusAd.cost_url);
            poc.a(jSONObject, "show_url", tiebaPlusAd.show_url);
            poc.a(jSONObject, "ad_source", tiebaPlusAd.ad_source);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
