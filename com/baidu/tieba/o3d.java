package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SpriteMemeInfo;
/* loaded from: classes7.dex */
public class o3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteMemeInfo spriteMemeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteMemeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, EmotionUbcHelper.MEME_ID, spriteMemeInfo.meme_id);
            poc.a(jSONObject, "query", spriteMemeInfo.query);
            poc.a(jSONObject, "icon", spriteMemeInfo.icon);
            poc.a(jSONObject, "use_same_guide", spriteMemeInfo.use_same_guide);
            poc.a(jSONObject, "use_same_text", spriteMemeInfo.use_same_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
