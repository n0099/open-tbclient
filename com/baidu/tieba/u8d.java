package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StarVoice;
/* loaded from: classes8.dex */
public class u8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarVoice starVoice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starVoice)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "avatar", starVoice.avatar);
            ktc.a(jSONObject, "title", starVoice.title);
            ktc.a(jSONObject, "desc", starVoice.desc);
            ktc.a(jSONObject, "voice_md5", starVoice.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
