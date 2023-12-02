package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class t9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "common_color", themeElement.common_color);
            ktc.a(jSONObject, "dark_color", themeElement.dark_color);
            ktc.a(jSONObject, "light_color", themeElement.light_color);
            ktc.a(jSONObject, "pattern_image", themeElement.pattern_image);
            ktc.a(jSONObject, "font_color", themeElement.font_color);
            ktc.a(jSONObject, "pattern_image_height", themeElement.pattern_image_height);
            ktc.a(jSONObject, "pattern_image_width", themeElement.pattern_image_width);
            ktc.a(jSONObject, "pattern_text", themeElement.pattern_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
