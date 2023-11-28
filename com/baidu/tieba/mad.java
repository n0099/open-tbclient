package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TshowInfo;
/* loaded from: classes7.dex */
public class mad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TshowInfo tshowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tshowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", tshowInfo.icon);
            ltc.a(jSONObject, "name", tshowInfo.name);
            ltc.a(jSONObject, "url", tshowInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
