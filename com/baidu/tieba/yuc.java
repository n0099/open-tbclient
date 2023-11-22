package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Fans;
/* loaded from: classes9.dex */
public class yuc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Fans fans) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fans)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "start_time", fans.start_time);
            qoc.a(jSONObject, "left_time", fans.left_time);
            qoc.a(jSONObject, "open", fans.open);
            qoc.a(jSONObject, "is_get", fans.is_get);
            qoc.a(jSONObject, "num", fans.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
