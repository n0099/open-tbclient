package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SpringVirtualUser;
/* loaded from: classes7.dex */
public class p8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpringVirtualUser springVirtualUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, springVirtualUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_virtual", springVirtualUser.is_virtual);
            ltc.a(jSONObject, "url", springVirtualUser.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
