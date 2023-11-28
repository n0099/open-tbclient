package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Manager;
/* loaded from: classes9.dex */
public class y0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Manager manager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, manager)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", manager.id);
            ltc.a(jSONObject, "name", manager.name);
            ltc.a(jSONObject, "show_name", manager.show_name);
            ltc.a(jSONObject, "portrait", manager.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
