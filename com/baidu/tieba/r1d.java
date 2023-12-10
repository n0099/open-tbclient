package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RealTime;
/* loaded from: classes8.dex */
public class r1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RealTime realTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, realTime)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "task_id", realTime.task_id);
            ltc.a(jSONObject, "icon", realTime.icon);
            ltc.a(jSONObject, "url", realTime.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
