package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public class rxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedKV feedKV) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedKV)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "key", feedKV.key);
            ktc.a(jSONObject, "value", feedKV.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
