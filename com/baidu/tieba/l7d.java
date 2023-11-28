package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RecomTagInfo;
/* loaded from: classes7.dex */
public class l7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTagInfo recomTagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", recomTagInfo.id);
            ltc.a(jSONObject, "name", recomTagInfo.name);
            ltc.a(jSONObject, pic.f, recomTagInfo.pic);
            ltc.a(jSONObject, "first_class", recomTagInfo.first_class);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
