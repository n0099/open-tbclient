package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class t9d extends ltc {
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
                ltc.a(jSONObject, "day", u9d.b(themeElement));
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                ltc.a(jSONObject, "night", u9d.b(themeElement2));
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                ltc.a(jSONObject, "dark", u9d.b(themeElement3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
