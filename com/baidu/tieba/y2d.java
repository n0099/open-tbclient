package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ShakeAdSwitch;
/* loaded from: classes9.dex */
public class y2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShakeAdSwitch shakeAdSwitch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, shakeAdSwitch)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_show", shakeAdSwitch.is_show);
            poc.a(jSONObject, "title", shakeAdSwitch.title);
            poc.a(jSONObject, "desc", shakeAdSwitch.desc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
