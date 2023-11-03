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
public class m3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteBubble spriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "scene", spriteBubble.scene);
            poc.a(jSONObject, "text", spriteBubble.text);
            poc.a(jSONObject, "need_send", spriteBubble.need_send);
            poc.a(jSONObject, "send_text", spriteBubble.send_text);
            poc.a(jSONObject, "version", spriteBubble.version);
            PbContent pbContent = spriteBubble.struct_data;
            if (pbContent != null) {
                poc.a(jSONObject, "struct_data", w0d.b(pbContent));
            }
            ThemeColorInfo themeColorInfo = spriteBubble.text_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = spriteBubble.icon_url;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "icon_url", p4d.b(themeColorInfo2));
            }
            poc.a(jSONObject, "sprite_text", spriteBubble.sprite_text);
            SpriteButton spriteButton = spriteBubble.button_info;
            if (spriteButton != null) {
                poc.a(jSONObject, "button_info", n3d.b(spriteButton));
            }
            poc.a(jSONObject, "speech_type", spriteBubble.speech_type);
            poc.a(jSONObject, "disappear_seconds", spriteBubble.disappear_seconds);
            poc.a(jSONObject, "title", spriteBubble.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
