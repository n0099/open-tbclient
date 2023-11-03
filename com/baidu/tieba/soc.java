package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes8.dex */
public class soc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Abstract r4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r4)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", r4.type);
            poc.a(jSONObject, "text", r4.text);
            poc.a(jSONObject, "link", r4.link);
            poc.a(jSONObject, "src", r4.src);
            poc.a(jSONObject, "un", r4.un);
            poc.a(jSONObject, "during_time", r4.during_time);
            poc.a(jSONObject, "voice_md5", r4.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
