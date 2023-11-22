package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class q4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeColorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                qoc.a(jSONObject, "day", r4d.b(themeElement));
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                qoc.a(jSONObject, "night", r4d.b(themeElement2));
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                qoc.a(jSONObject, "dark", r4d.b(themeElement3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
