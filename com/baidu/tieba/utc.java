package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsBottomActivityTime;
/* loaded from: classes8.dex */
public class utc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomActivityTime frsBottomActivityTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomActivityTime)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "start_time", frsBottomActivityTime.start_time);
            poc.a(jSONObject, "end_time", frsBottomActivityTime.end_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
