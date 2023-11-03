package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
/* loaded from: classes8.dex */
public class toc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActBtn actBtn) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actBtn)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", actBtn.type);
            poc.a(jSONObject, "url", actBtn.url);
            poc.a(jSONObject, "text", actBtn.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
