package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FestivalTipData;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class jtc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FestivalTipData festivalTipData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, festivalTipData)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", festivalTipData.text);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, festivalTipData.jump_url);
            ThemeColorInfo themeColorInfo = festivalTipData.background_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "background_color", p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = festivalTipData.font_color;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "font_color", p4d.b(themeColorInfo2));
            }
            IconUrlInfo iconUrlInfo = festivalTipData.icon_url;
            if (iconUrlInfo != null) {
                poc.a(jSONObject, "icon_url", wyc.b(iconUrlInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
