package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumToolPerm;
/* loaded from: classes7.dex */
public class oyc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumToolPerm forumToolPerm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumToolPerm)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "perm", forumToolPerm.perm);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
