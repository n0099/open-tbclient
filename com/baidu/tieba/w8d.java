package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StateInfo;
/* loaded from: classes8.dex */
public class w8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StateInfo stateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, stateInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", stateInfo.icon);
            ltc.a(jSONObject, "text", stateInfo.text);
            ltc.a(jSONObject, "icon_type", stateInfo.icon_type);
            ltc.a(jSONObject, "icon_pid", stateInfo.icon_pid);
            ltc.a(jSONObject, "icon_pid_new", stateInfo.icon_pid_new);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
