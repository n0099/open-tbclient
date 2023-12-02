package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Equipment;
/* loaded from: classes8.dex */
public class swc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Equipment equipment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, equipment)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", equipment.name);
            ktc.a(jSONObject, "portrait", equipment.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
