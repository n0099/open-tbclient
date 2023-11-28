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
public class q8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteBubble spriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "scene", spriteBubble.scene);
            ltc.a(jSONObject, "text", spriteBubble.text);
            ltc.a(jSONObject, "need_send", spriteBubble.need_send);
            ltc.a(jSONObject, "send_text", spriteBubble.send_text);
            ltc.a(jSONObject, "version", spriteBubble.version);
            PbContent pbContent = spriteBubble.struct_data;
            if (pbContent != null) {
                ltc.a(jSONObject, "struct_data", a6d.b(pbContent));
            }
            ThemeColorInfo themeColorInfo = spriteBubble.text_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, t9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = spriteBubble.icon_url;
            if (themeColorInfo2 != null) {
                ltc.a(jSONObject, "icon_url", t9d.b(themeColorInfo2));
            }
            ltc.a(jSONObject, "sprite_text", spriteBubble.sprite_text);
            SpriteButton spriteButton = spriteBubble.button_info;
            if (spriteButton != null) {
                ltc.a(jSONObject, "button_info", r8d.b(spriteButton));
            }
            ltc.a(jSONObject, "speech_type", spriteBubble.speech_type);
            ltc.a(jSONObject, "disappear_seconds", spriteBubble.disappear_seconds);
            ltc.a(jSONObject, "title", spriteBubble.title);
            ltc.a(jSONObject, "type", spriteBubble.type);
            ThemeColorInfo themeColorInfo3 = spriteBubble.img;
            if (themeColorInfo3 != null) {
                ltc.a(jSONObject, "img", t9d.b(themeColorInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
