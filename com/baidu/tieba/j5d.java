package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TshowInfo;
/* loaded from: classes6.dex */
public class j5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TshowInfo tshowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tshowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", tshowInfo.icon);
            qoc.a(jSONObject, "name", tshowInfo.name);
            qoc.a(jSONObject, "url", tshowInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
