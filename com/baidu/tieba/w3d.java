package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SubBottomMenu;
/* loaded from: classes8.dex */
public class w3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubBottomMenu subBottomMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subBottomMenu)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", subBottomMenu.name);
            poc.a(jSONObject, "url", subBottomMenu.url);
            poc.a(jSONObject, "type", subBottomMenu.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
