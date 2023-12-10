package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.JNews;
/* loaded from: classes7.dex */
public class l4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull JNews jNews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jNews)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "jid", jNews.jid);
            ltc.a(jSONObject, "url", jNews.url);
            ltc.a(jSONObject, "from", jNews.from);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
