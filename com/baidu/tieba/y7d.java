package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes9.dex */
public class y7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SchoolRecomUserInfo schoolRecomUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, schoolRecomUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "uid", schoolRecomUserInfo.uid);
            ltc.a(jSONObject, "uname", schoolRecomUserInfo.uname);
            ltc.a(jSONObject, "portrait", schoolRecomUserInfo.portrait);
            ltc.a(jSONObject, "institute", schoolRecomUserInfo.institute);
            ltc.a(jSONObject, "is_liked", schoolRecomUserInfo.is_liked);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
