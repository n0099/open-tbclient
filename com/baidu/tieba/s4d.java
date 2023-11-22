package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeMyTab;
/* loaded from: classes8.dex */
public class s4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeMyTab themeMyTab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeMyTab)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "url", themeMyTab.url);
            qoc.a(jSONObject, "dynamic_url", themeMyTab.dynamic_url);
            qoc.a(jSONObject, "button_color", themeMyTab.button_color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
