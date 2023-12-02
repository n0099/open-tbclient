package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Fans;
/* loaded from: classes9.dex */
public class xzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Fans fans) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fans)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "start_time", fans.start_time);
            ktc.a(jSONObject, "left_time", fans.left_time);
            ktc.a(jSONObject, "open", fans.open);
            ktc.a(jSONObject, "is_get", fans.is_get);
            ktc.a(jSONObject, "num", fans.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
