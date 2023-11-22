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
public class n3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteBubble spriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "scene", spriteBubble.scene);
            qoc.a(jSONObject, "text", spriteBubble.text);
            qoc.a(jSONObject, "need_send", spriteBubble.need_send);
            qoc.a(jSONObject, "send_text", spriteBubble.send_text);
            qoc.a(jSONObject, "version", spriteBubble.version);
            PbContent pbContent = spriteBubble.struct_data;
            if (pbContent != null) {
                qoc.a(jSONObject, "struct_data", x0d.b(pbContent));
            }
            ThemeColorInfo themeColorInfo = spriteBubble.text_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = spriteBubble.icon_url;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "icon_url", q4d.b(themeColorInfo2));
            }
            qoc.a(jSONObject, "sprite_text", spriteBubble.sprite_text);
            SpriteButton spriteButton = spriteBubble.button_info;
            if (spriteButton != null) {
                qoc.a(jSONObject, "button_info", o3d.b(spriteButton));
            }
            qoc.a(jSONObject, "speech_type", spriteBubble.speech_type);
            qoc.a(jSONObject, "disappear_seconds", spriteBubble.disappear_seconds);
            qoc.a(jSONObject, "title", spriteBubble.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
