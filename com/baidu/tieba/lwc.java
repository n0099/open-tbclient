package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PrivateForumShareinfo;
/* loaded from: classes7.dex */
public class lwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivateForumShareinfo privateForumShareinfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privateForumShareinfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "create_time", privateForumShareinfo.create_time);
            poc.a(jSONObject, "share_url", privateForumShareinfo.share_url);
            poc.a(jSONObject, "manager_user_name", privateForumShareinfo.manager_user_name);
            poc.a(jSONObject, "manager_portrait", privateForumShareinfo.manager_portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
