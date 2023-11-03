package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class z2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShortUserInfo shortUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, shortUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", shortUserInfo.user_id);
            poc.a(jSONObject, "portrait", shortUserInfo.portrait);
            poc.a(jSONObject, "user_name", shortUserInfo.user_name);
            poc.a(jSONObject, "gender", shortUserInfo.gender);
            poc.a(jSONObject, "intro", shortUserInfo.intro);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
