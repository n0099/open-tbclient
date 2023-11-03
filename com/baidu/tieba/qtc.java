package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumToolPerm;
/* loaded from: classes8.dex */
public class qtc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumToolPerm forumToolPerm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumToolPerm)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "perm", forumToolPerm.perm);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
