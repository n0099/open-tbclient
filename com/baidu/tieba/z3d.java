package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.IconUrlInfo;
/* loaded from: classes9.dex */
public class z3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull IconUrlInfo iconUrlInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iconUrlInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "day", iconUrlInfo.day);
            ktc.a(jSONObject, "night", iconUrlInfo.night);
            ktc.a(jSONObject, "dark", iconUrlInfo.dark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
