package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public class usc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedKV feedKV) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedKV)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "key", feedKV.key);
            qoc.a(jSONObject, "value", feedKV.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
