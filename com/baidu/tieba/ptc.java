package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
/* loaded from: classes7.dex */
public class ptc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActBtn actBtn) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actBtn)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", actBtn.type);
            ltc.a(jSONObject, "url", actBtn.url);
            ltc.a(jSONObject, "text", actBtn.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
