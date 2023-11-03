package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserPics;
/* loaded from: classes7.dex */
public class o5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserPics userPics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userPics)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "big", userPics.big);
            poc.a(jSONObject, "small", userPics.small);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
