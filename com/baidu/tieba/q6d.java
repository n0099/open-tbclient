package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Position;
/* loaded from: classes7.dex */
public class q6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Position position) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, position)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "frs", position.frs);
            ktc.a(jSONObject, "pb", position.pb);
            ktc.a(jSONObject, "home", position.home);
            ktc.a(jSONObject, "card", position.card);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
