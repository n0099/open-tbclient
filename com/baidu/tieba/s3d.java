package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StateInfo;
/* loaded from: classes8.dex */
public class s3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StateInfo stateInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, stateInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", stateInfo.icon);
            poc.a(jSONObject, "text", stateInfo.text);
            poc.a(jSONObject, "icon_type", stateInfo.icon_type);
            poc.a(jSONObject, "icon_pid", stateInfo.icon_pid);
            poc.a(jSONObject, "icon_pid_new", stateInfo.icon_pid_new);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
