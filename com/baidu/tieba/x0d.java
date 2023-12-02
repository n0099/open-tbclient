package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Manager;
/* loaded from: classes9.dex */
public class x0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Manager manager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, manager)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", manager.id);
            ktc.a(jSONObject, "name", manager.name);
            ktc.a(jSONObject, "show_name", manager.show_name);
            ktc.a(jSONObject, "portrait", manager.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
