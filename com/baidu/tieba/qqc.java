package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CallFansInfo;
/* loaded from: classes8.dex */
public class qqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CallFansInfo callFansInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, callFansInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "can_call", callFansInfo.can_call);
            poc.a(jSONObject, "thread_id", callFansInfo.thread_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
