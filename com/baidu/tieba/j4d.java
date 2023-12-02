package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemThemeColor;
import tbclient.ItemThemeColorElement;
/* loaded from: classes6.dex */
public class j4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemThemeColor itemThemeColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemThemeColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            ItemThemeColorElement itemThemeColorElement = itemThemeColor.day;
            if (itemThemeColorElement != null) {
                ktc.a(jSONObject, "day", i4d.b(itemThemeColorElement));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
