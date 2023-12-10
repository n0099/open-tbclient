package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Position;
/* loaded from: classes8.dex */
public class r6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Position position) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, position)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "frs", position.frs);
            ltc.a(jSONObject, "pb", position.pb);
            ltc.a(jSONObject, "home", position.home);
            ltc.a(jSONObject, "card", position.card);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
