package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Bottle;
/* loaded from: classes6.dex */
public class iuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Bottle bottle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bottle)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "has_enter_display", bottle.has_enter_display);
            poc.a(jSONObject, "tid", bottle.tid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
