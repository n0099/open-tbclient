package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.BrandBook;
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class j0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBannerHeader frsBannerHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBannerHeader)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon_url", frsBannerHeader.icon_url);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, frsBannerHeader.content1);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, frsBannerHeader.content2);
            ThemeColorInfo themeColorInfo = frsBannerHeader.content1_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, "content1_color", t9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = frsBannerHeader.content2_color;
            if (themeColorInfo2 != null) {
                ltc.a(jSONObject, "content2_color", t9d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = frsBannerHeader.jump_tips_color;
            if (themeColorInfo3 != null) {
                ltc.a(jSONObject, "jump_tips_color", t9d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = frsBannerHeader.background_color;
            if (themeColorInfo4 != null) {
                ltc.a(jSONObject, "background_color", t9d.b(themeColorInfo4));
            }
            ltc.a(jSONObject, "jump_tips", frsBannerHeader.jump_tips);
            ltc.a(jSONObject, "jump_link", frsBannerHeader.jump_link);
            ltc.a(jSONObject, "type", frsBannerHeader.type);
            IconUrlInfo iconUrlInfo = frsBannerHeader.jump_tips_icon;
            if (iconUrlInfo != null) {
                ltc.a(jSONObject, "jump_tips_icon", a4d.b(iconUrlInfo));
            }
            IconUrlInfo iconUrlInfo2 = frsBannerHeader.brand_icon;
            if (iconUrlInfo2 != null) {
                ltc.a(jSONObject, "brand_icon", a4d.b(iconUrlInfo2));
            }
            ltc.a(jSONObject, "card_type", frsBannerHeader.card_type);
            ltc.a(jSONObject, "btn_text", frsBannerHeader.btn_text);
            ltc.a(jSONObject, "btn_text_after", frsBannerHeader.btn_text_after);
            ltc.a(jSONObject, "background_img", frsBannerHeader.background_img);
            BrandBook brandBook = frsBannerHeader.book;
            if (brandBook != null) {
                ltc.a(jSONObject, "book", kzc.b(brandBook));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
