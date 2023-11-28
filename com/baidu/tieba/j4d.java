package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemThemeColorElement;
/* loaded from: classes6.dex */
public class j4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemThemeColorElement itemThemeColorElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemThemeColorElement)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "top_color", itemThemeColorElement.top_color);
            ltc.a(jSONObject, "bottom_color", itemThemeColorElement.bottom_color);
            ltc.a(jSONObject, "edit_button_color", itemThemeColorElement.edit_button_color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
