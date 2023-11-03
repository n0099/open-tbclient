package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class q4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "common_color", themeElement.common_color);
            poc.a(jSONObject, "dark_color", themeElement.dark_color);
            poc.a(jSONObject, "light_color", themeElement.light_color);
            poc.a(jSONObject, "pattern_image", themeElement.pattern_image);
            poc.a(jSONObject, "font_color", themeElement.font_color);
            poc.a(jSONObject, "pattern_image_height", themeElement.pattern_image_height);
            poc.a(jSONObject, "pattern_image_width", themeElement.pattern_image_width);
            poc.a(jSONObject, "pattern_text", themeElement.pattern_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
