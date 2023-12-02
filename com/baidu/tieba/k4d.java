package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.JNews;
/* loaded from: classes6.dex */
public class k4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull JNews jNews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jNews)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "jid", jNews.jid);
            ktc.a(jSONObject, "url", jNews.url);
            ktc.a(jSONObject, "from", jNews.from);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
