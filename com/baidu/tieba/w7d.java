package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Rpgoldicon;
/* loaded from: classes8.dex */
public class w7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Rpgoldicon rpgoldicon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rpgoldicon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "key", rpgoldicon.key);
            ktc.a(jSONObject, "value", rpgoldicon.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
