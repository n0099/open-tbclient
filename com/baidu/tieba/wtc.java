package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsBottomSmartBgColor;
/* loaded from: classes8.dex */
public class wtc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomSmartBgColor frsBottomSmartBgColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomSmartBgColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "theme_color", frsBottomSmartBgColor.theme_color);
            poc.a(jSONObject, "ball_bg_color", frsBottomSmartBgColor.ball_bg_color);
            poc.a(jSONObject, "tab_line_color", frsBottomSmartBgColor.tab_line_color);
            poc.a(jSONObject, "tag_color", frsBottomSmartBgColor.tag_color);
            poc.a(jSONObject, "post_button_color", frsBottomSmartBgColor.post_button_color);
            poc.a(jSONObject, "post_button_shadow_color", frsBottomSmartBgColor.post_button_shadow_color);
            poc.a(jSONObject, "module1_bg_color", frsBottomSmartBgColor.module1_bg_color);
            poc.a(jSONObject, "module2_bg_color", frsBottomSmartBgColor.module2_bg_color);
            poc.a(jSONObject, "module3_bg_color", frsBottomSmartBgColor.module3_bg_color);
            poc.a(jSONObject, "module4_bg_color", frsBottomSmartBgColor.module4_bg_color);
            poc.a(jSONObject, "at_font_color", frsBottomSmartBgColor.at_font_color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
