package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.IconUrlInfo;
/* loaded from: classes8.dex */
public class wyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull IconUrlInfo iconUrlInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iconUrlInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "day", iconUrlInfo.day);
            poc.a(jSONObject, "night", iconUrlInfo.night);
            poc.a(jSONObject, "dark", iconUrlInfo.dark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
