package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RealTime;
/* loaded from: classes7.dex */
public class pwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RealTime realTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, realTime)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "task_id", realTime.task_id);
            poc.a(jSONObject, "icon", realTime.icon);
            poc.a(jSONObject, "url", realTime.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
