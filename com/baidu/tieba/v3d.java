package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.HeadItem;
/* loaded from: classes8.dex */
public class v3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeadItem headItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", headItem.name);
            ltc.a(jSONObject, "content", headItem.content);
            ltc.a(jSONObject, "type", headItem.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
