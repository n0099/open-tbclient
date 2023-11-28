package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TwAnchorProfitItem;
/* loaded from: classes7.dex */
public class nad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TwAnchorProfitItem twAnchorProfitItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, twAnchorProfitItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", twAnchorProfitItem.id);
            ltc.a(jSONObject, "available_anchor_level", twAnchorProfitItem.available_anchor_level);
            ltc.a(jSONObject, "name", twAnchorProfitItem.name);
            ltc.a(jSONObject, "icon_unlock_url", twAnchorProfitItem.icon_unlock_url);
            ltc.a(jSONObject, "icon_lock_url", twAnchorProfitItem.icon_lock_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
