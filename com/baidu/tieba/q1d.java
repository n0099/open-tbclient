package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RealTime;
/* loaded from: classes7.dex */
public class q1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RealTime realTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, realTime)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "task_id", realTime.task_id);
            ktc.a(jSONObject, "icon", realTime.icon);
            ktc.a(jSONObject, "url", realTime.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
