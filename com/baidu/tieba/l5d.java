package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes7.dex */
public class l5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "status", newGodInfo.status);
            ltc.a(jSONObject, "field_id", newGodInfo.field_id);
            ltc.a(jSONObject, "field_name", newGodInfo.field_name);
            ltc.a(jSONObject, "type", newGodInfo.type);
            ltc.a(jSONObject, "type_name", newGodInfo.type_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
