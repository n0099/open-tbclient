package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Fans;
/* loaded from: classes9.dex */
public class yzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Fans fans) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fans)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "start_time", fans.start_time);
            ltc.a(jSONObject, "left_time", fans.left_time);
            ltc.a(jSONObject, "open", fans.open);
            ltc.a(jSONObject, "is_get", fans.is_get);
            ltc.a(jSONObject, "num", fans.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
