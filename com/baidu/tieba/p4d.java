package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class p4d extends poc {
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
                poc.a(jSONObject, "day", q4d.b(themeElement));
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                poc.a(jSONObject, "night", q4d.b(themeElement2));
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                poc.a(jSONObject, "dark", q4d.b(themeElement3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
