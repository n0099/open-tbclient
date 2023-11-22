package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
/* loaded from: classes8.dex */
public class uoc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActBtn actBtn) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actBtn)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", actBtn.type);
            qoc.a(jSONObject, "url", actBtn.url);
            qoc.a(jSONObject, "text", actBtn.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
