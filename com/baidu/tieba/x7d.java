package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes9.dex */
public class x7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SchoolRecomUserInfo schoolRecomUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, schoolRecomUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "uid", schoolRecomUserInfo.uid);
            ktc.a(jSONObject, "uname", schoolRecomUserInfo.uname);
            ktc.a(jSONObject, "portrait", schoolRecomUserInfo.portrait);
            ktc.a(jSONObject, "institute", schoolRecomUserInfo.institute);
            ktc.a(jSONObject, "is_liked", schoolRecomUserInfo.is_liked);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
