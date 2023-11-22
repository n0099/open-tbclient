package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StarVoice;
/* loaded from: classes8.dex */
public class s3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarVoice starVoice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starVoice)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "avatar", starVoice.avatar);
            qoc.a(jSONObject, "title", starVoice.title);
            qoc.a(jSONObject, "desc", starVoice.desc);
            qoc.a(jSONObject, "voice_md5", starVoice.voice_md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
