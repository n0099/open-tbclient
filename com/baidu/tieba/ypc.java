package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Avatar;
/* loaded from: classes9.dex */
public class ypc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Avatar avatar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, avatar)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pic", avatar.pic);
            qoc.a(jSONObject, "pos", avatar.pos);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
