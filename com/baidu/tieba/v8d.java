package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StarVoice;
/* loaded from: classes8.dex */
public class v8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarVoice starVoice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starVoice)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "avatar", starVoice.avatar);
            ltc.a(jSONObject, "title", starVoice.title);
            ltc.a(jSONObject, "desc", starVoice.desc);
            ltc.a(jSONObject, "voice_md5", starVoice.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
