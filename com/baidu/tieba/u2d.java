package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes8.dex */
public class u2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SchoolRecomUserInfo schoolRecomUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, schoolRecomUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "uid", schoolRecomUserInfo.uid);
            poc.a(jSONObject, "uname", schoolRecomUserInfo.uname);
            poc.a(jSONObject, "portrait", schoolRecomUserInfo.portrait);
            poc.a(jSONObject, "institute", schoolRecomUserInfo.institute);
            poc.a(jSONObject, "is_liked", schoolRecomUserInfo.is_liked);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
