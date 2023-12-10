package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes7.dex */
public class otc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Abstract r4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r4)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", r4.type);
            ltc.a(jSONObject, "text", r4.text);
            ltc.a(jSONObject, "link", r4.link);
            ltc.a(jSONObject, "src", r4.src);
            ltc.a(jSONObject, "un", r4.un);
            ltc.a(jSONObject, "during_time", r4.during_time);
            ltc.a(jSONObject, "voice_md5", r4.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
