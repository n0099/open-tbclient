package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Global;
/* loaded from: classes7.dex */
public class nyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Global global) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, global)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tbmall_newprops", global.tbmall_newprops);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
