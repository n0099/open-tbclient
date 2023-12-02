package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EsportStatic;
/* loaded from: classes8.dex */
public class wwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportStatic esportStatic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportStatic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "img", esportStatic.img);
            ktc.a(jSONObject, "url", esportStatic.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
