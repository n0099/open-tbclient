package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.PbContent;
import tbclient.SpriteBubble;
import tbclient.SpriteButton;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class p8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteBubble spriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "scene", spriteBubble.scene);
            ktc.a(jSONObject, "text", spriteBubble.text);
            ktc.a(jSONObject, "need_send", spriteBubble.need_send);
            ktc.a(jSONObject, "send_text", spriteBubble.send_text);
            ktc.a(jSONObject, "version", spriteBubble.version);
            PbContent pbContent = spriteBubble.struct_data;
            if (pbContent != null) {
                ktc.a(jSONObject, "struct_data", z5d.b(pbContent));
            }
            ThemeColorInfo themeColorInfo = spriteBubble.text_color;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, s9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = spriteBubble.icon_url;
            if (themeColorInfo2 != null) {
                ktc.a(jSONObject, "icon_url", s9d.b(themeColorInfo2));
            }
            ktc.a(jSONObject, "sprite_text", spriteBubble.sprite_text);
            SpriteButton spriteButton = spriteBubble.button_info;
            if (spriteButton != null) {
                ktc.a(jSONObject, "button_info", q8d.b(spriteButton));
            }
            ktc.a(jSONObject, "speech_type", spriteBubble.speech_type);
            ktc.a(jSONObject, "disappear_seconds", spriteBubble.disappear_seconds);
            ktc.a(jSONObject, "title", spriteBubble.title);
            ktc.a(jSONObject, "type", spriteBubble.type);
            ThemeColorInfo themeColorInfo3 = spriteBubble.img;
            if (themeColorInfo3 != null) {
                ktc.a(jSONObject, "img", s9d.b(themeColorInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
