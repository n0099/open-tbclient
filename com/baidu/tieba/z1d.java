package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PushType;
/* loaded from: classes9.dex */
public class z1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushType pushType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushType)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", pushType.type);
            poc.a(jSONObject, "name", pushType.name);
            poc.a(jSONObject, "icon", pushType.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
