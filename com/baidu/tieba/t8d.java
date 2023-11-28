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
/* loaded from: classes8.dex */
public class t8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpritePBGuide spritePBGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spritePBGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, GuildActivityConfig.GUIDE_TYPE, spritePBGuide.guide_type);
            ltc.a(jSONObject, "guide_text", spritePBGuide.guide_text);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, spritePBGuide.button_text);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, spritePBGuide.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
