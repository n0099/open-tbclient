package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes6.dex */
public class k5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "status", newGodInfo.status);
            ktc.a(jSONObject, "field_id", newGodInfo.field_id);
            ktc.a(jSONObject, "field_name", newGodInfo.field_name);
            ktc.a(jSONObject, "type", newGodInfo.type);
            ktc.a(jSONObject, "type_name", newGodInfo.type_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
