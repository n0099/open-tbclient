package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkConf;
/* loaded from: classes8.dex */
public class s4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkConf linkConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "url", linkConf.url);
            ltc.a(jSONObject, "text", linkConf.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
