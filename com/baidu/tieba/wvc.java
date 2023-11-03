package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Manager;
/* loaded from: classes8.dex */
public class wvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Manager manager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, manager)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", manager.id);
            poc.a(jSONObject, "name", manager.name);
            poc.a(jSONObject, "show_name", manager.show_name);
            poc.a(jSONObject, "portrait", manager.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
