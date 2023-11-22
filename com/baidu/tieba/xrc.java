package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EsportInfo;
/* loaded from: classes9.dex */
public class xrc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportInfo esportInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "intro", esportInfo.intro);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
