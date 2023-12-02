package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkConf;
/* loaded from: classes8.dex */
public class r4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkConf linkConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "url", linkConf.url);
            ktc.a(jSONObject, "text", linkConf.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
