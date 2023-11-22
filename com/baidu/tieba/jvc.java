package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class jvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBannerHeader frsBannerHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBannerHeader)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon_url", frsBannerHeader.icon_url);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, frsBannerHeader.content1);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, frsBannerHeader.content2);
            ThemeColorInfo themeColorInfo = frsBannerHeader.content1_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "content1_color", q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = frsBannerHeader.content2_color;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "content2_color", q4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = frsBannerHeader.jump_tips_color;
            if (themeColorInfo3 != null) {
                qoc.a(jSONObject, "jump_tips_color", q4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = frsBannerHeader.background_color;
            if (themeColorInfo4 != null) {
                qoc.a(jSONObject, "background_color", q4d.b(themeColorInfo4));
            }
            qoc.a(jSONObject, "jump_tips", frsBannerHeader.jump_tips);
            qoc.a(jSONObject, "jump_link", frsBannerHeader.jump_link);
            qoc.a(jSONObject, "type", frsBannerHeader.type);
            IconUrlInfo iconUrlInfo = frsBannerHeader.jump_tips_icon;
            if (iconUrlInfo != null) {
                qoc.a(jSONObject, "jump_tips_icon", xyc.b(iconUrlInfo));
            }
            IconUrlInfo iconUrlInfo2 = frsBannerHeader.brand_icon;
            if (iconUrlInfo2 != null) {
                qoc.a(jSONObject, "brand_icon", xyc.b(iconUrlInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
