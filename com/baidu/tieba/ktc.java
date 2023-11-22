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
/* loaded from: classes7.dex */
public class ktc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FestivalTipData festivalTipData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, festivalTipData)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", festivalTipData.text);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, festivalTipData.jump_url);
            ThemeColorInfo themeColorInfo = festivalTipData.background_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "background_color", q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = festivalTipData.font_color;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "font_color", q4d.b(themeColorInfo2));
            }
            IconUrlInfo iconUrlInfo = festivalTipData.icon_url;
            if (iconUrlInfo != null) {
                qoc.a(jSONObject, "icon_url", xyc.b(iconUrlInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
