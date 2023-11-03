package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PrivateForumInfo;
/* loaded from: classes8.dex */
public class s1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivateForumInfo privateForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privateForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "private_forum_status", privateForumInfo.private_forum_status);
            poc.a(jSONObject, "private_forum_audit_status", privateForumInfo.private_forum_audit_status);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
