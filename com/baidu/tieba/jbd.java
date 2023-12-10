package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes6.dex */
public class jbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Voice voice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voice)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", voice.type);
            ltc.a(jSONObject, "during_time", voice.during_time);
            ltc.a(jSONObject, "voice_md5", voice.voice_md5);
            ltc.a(jSONObject, "voice_url", voice.voice_url);
            ltc.a(jSONObject, "uid", voice.uid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
