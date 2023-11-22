package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class r4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "common_color", themeElement.common_color);
            qoc.a(jSONObject, "dark_color", themeElement.dark_color);
            qoc.a(jSONObject, "light_color", themeElement.light_color);
            qoc.a(jSONObject, "pattern_image", themeElement.pattern_image);
            qoc.a(jSONObject, "font_color", themeElement.font_color);
            qoc.a(jSONObject, "pattern_image_height", themeElement.pattern_image_height);
            qoc.a(jSONObject, "pattern_image_width", themeElement.pattern_image_width);
            qoc.a(jSONObject, "pattern_text", themeElement.pattern_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
