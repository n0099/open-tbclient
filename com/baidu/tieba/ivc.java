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
public class ivc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBannerHeader frsBannerHeader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBannerHeader)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon_url", frsBannerHeader.icon_url);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT1, frsBannerHeader.content1);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_CONTENT2, frsBannerHeader.content2);
            ThemeColorInfo themeColorInfo = frsBannerHeader.content1_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "content1_color", p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = frsBannerHeader.content2_color;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "content2_color", p4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = frsBannerHeader.jump_tips_color;
            if (themeColorInfo3 != null) {
                poc.a(jSONObject, "jump_tips_color", p4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = frsBannerHeader.background_color;
            if (themeColorInfo4 != null) {
                poc.a(jSONObject, "background_color", p4d.b(themeColorInfo4));
            }
            poc.a(jSONObject, "jump_tips", frsBannerHeader.jump_tips);
            poc.a(jSONObject, "jump_link", frsBannerHeader.jump_link);
            poc.a(jSONObject, "type", frsBannerHeader.type);
            IconUrlInfo iconUrlInfo = frsBannerHeader.jump_tips_icon;
            if (iconUrlInfo != null) {
                poc.a(jSONObject, "jump_tips_icon", wyc.b(iconUrlInfo));
            }
            IconUrlInfo iconUrlInfo2 = frsBannerHeader.brand_icon;
            if (iconUrlInfo2 != null) {
                poc.a(jSONObject, "brand_icon", wyc.b(iconUrlInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
