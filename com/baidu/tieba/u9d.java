package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class u9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "common_color", themeElement.common_color);
            ltc.a(jSONObject, "dark_color", themeElement.dark_color);
            ltc.a(jSONObject, "light_color", themeElement.light_color);
            ltc.a(jSONObject, "pattern_image", themeElement.pattern_image);
            ltc.a(jSONObject, "font_color", themeElement.font_color);
            ltc.a(jSONObject, "pattern_image_height", themeElement.pattern_image_height);
            ltc.a(jSONObject, "pattern_image_width", themeElement.pattern_image_width);
            ltc.a(jSONObject, "pattern_text", themeElement.pattern_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
