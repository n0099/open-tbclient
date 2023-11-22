package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Position;
/* loaded from: classes7.dex */
public class o1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Position position) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, position)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "frs", position.frs);
            qoc.a(jSONObject, "pb", position.pb);
            qoc.a(jSONObject, "home", position.home);
            qoc.a(jSONObject, "card", position.card);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
