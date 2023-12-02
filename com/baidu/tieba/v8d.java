package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StateInfo;
/* loaded from: classes8.dex */
public class v8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StateInfo stateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, stateInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", stateInfo.icon);
            ktc.a(jSONObject, "text", stateInfo.text);
            ktc.a(jSONObject, "icon_type", stateInfo.icon_type);
            ktc.a(jSONObject, "icon_pid", stateInfo.icon_pid);
            ktc.a(jSONObject, "icon_pid_new", stateInfo.icon_pid_new);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
