package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SpriteMemeInfo;
/* loaded from: classes8.dex */
public class r8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteMemeInfo spriteMemeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteMemeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, EmotionUbcHelper.MEME_ID, spriteMemeInfo.meme_id);
            ktc.a(jSONObject, "query", spriteMemeInfo.query);
            ktc.a(jSONObject, "icon", spriteMemeInfo.icon);
            ktc.a(jSONObject, "use_same_guide", spriteMemeInfo.use_same_guide);
            ktc.a(jSONObject, "use_same_text", spriteMemeInfo.use_same_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
