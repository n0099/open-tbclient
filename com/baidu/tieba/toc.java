package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes8.dex */
public class toc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Abstract r4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r4)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", r4.type);
            qoc.a(jSONObject, "text", r4.text);
            qoc.a(jSONObject, "link", r4.link);
            qoc.a(jSONObject, "src", r4.src);
            qoc.a(jSONObject, "un", r4.un);
            qoc.a(jSONObject, "during_time", r4.during_time);
            qoc.a(jSONObject, "voice_md5", r4.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
