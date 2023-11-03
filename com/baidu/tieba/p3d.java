package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SpritePBGuide;
/* loaded from: classes7.dex */
public class p3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpritePBGuide spritePBGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spritePBGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, GuildActivityConfig.GUIDE_TYPE, spritePBGuide.guide_type);
            poc.a(jSONObject, "guide_text", spritePBGuide.guide_text);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, spritePBGuide.button_text);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, spritePBGuide.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
