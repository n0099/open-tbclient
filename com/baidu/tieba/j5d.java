package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TwAnchorProfitItem;
/* loaded from: classes6.dex */
public class j5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TwAnchorProfitItem twAnchorProfitItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, twAnchorProfitItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", twAnchorProfitItem.id);
            poc.a(jSONObject, "available_anchor_level", twAnchorProfitItem.available_anchor_level);
            poc.a(jSONObject, "name", twAnchorProfitItem.name);
            poc.a(jSONObject, "icon_unlock_url", twAnchorProfitItem.icon_unlock_url);
            poc.a(jSONObject, "icon_lock_url", twAnchorProfitItem.icon_lock_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
