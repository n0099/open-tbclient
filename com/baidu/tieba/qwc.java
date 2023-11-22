package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RealTime;
/* loaded from: classes8.dex */
public class qwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RealTime realTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, realTime)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "task_id", realTime.task_id);
            qoc.a(jSONObject, "icon", realTime.icon);
            qoc.a(jSONObject, "url", realTime.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
