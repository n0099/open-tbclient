package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Avatar;
/* loaded from: classes8.dex */
public class uuc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Avatar avatar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, avatar)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pic", avatar.pic);
            ktc.a(jSONObject, "pos", avatar.pos);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
