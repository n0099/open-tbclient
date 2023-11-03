package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Identify;
/* loaded from: classes8.dex */
public class tvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Identify identify) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, identify)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_identify", identify.is_identify);
            poc.a(jSONObject, "id", identify.id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
