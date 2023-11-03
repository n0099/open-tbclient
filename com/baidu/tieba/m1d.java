package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Portrait;
/* loaded from: classes7.dex */
public class m1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Portrait portrait) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, portrait)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "props_id", portrait.props_id);
            poc.a(jSONObject, "end_time", portrait.end_time);
            poc.a(jSONObject, "url", portrait.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
