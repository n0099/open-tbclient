package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserPics;
/* loaded from: classes8.dex */
public class rad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserPics userPics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userPics)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "big", userPics.big);
            ktc.a(jSONObject, "small", userPics.small);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
