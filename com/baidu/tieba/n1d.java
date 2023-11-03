package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Position;
/* loaded from: classes7.dex */
public class n1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Position position) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, position)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "frs", position.frs);
            poc.a(jSONObject, "pb", position.pb);
            poc.a(jSONObject, "home", position.home);
            poc.a(jSONObject, "card", position.card);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
