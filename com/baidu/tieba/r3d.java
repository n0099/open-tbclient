package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StarVoice;
/* loaded from: classes8.dex */
public class r3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarVoice starVoice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starVoice)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "avatar", starVoice.avatar);
            poc.a(jSONObject, "title", starVoice.title);
            poc.a(jSONObject, "desc", starVoice.desc);
            poc.a(jSONObject, "voice_md5", starVoice.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
