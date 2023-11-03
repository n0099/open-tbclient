package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CommonDistance;
/* loaded from: classes8.dex */
public class tuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CommonDistance commonDistance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, commonDistance)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "distance", commonDistance.distance);
            poc.a(jSONObject, "time", commonDistance.time);
            poc.a(jSONObject, "is_hide", commonDistance.is_hide);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
