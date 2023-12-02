package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class k8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleUser simpleUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", simpleUser.user_id);
            ktc.a(jSONObject, "user_status", simpleUser.user_status);
            ktc.a(jSONObject, "secureemail", simpleUser.secureemail);
            ktc.a(jSONObject, "securemobil", simpleUser.securemobil);
            ktc.a(jSONObject, "user_name", simpleUser.user_name);
            ktc.a(jSONObject, "user_nickname", simpleUser.user_nickname);
            ktc.a(jSONObject, "incomplete_user", simpleUser.incomplete_user);
            ktc.a(jSONObject, "portrait", simpleUser.portrait);
            ktc.a(jSONObject, "agree_type", simpleUser.agree_type);
            ktc.a(jSONObject, "ahead_url", simpleUser.ahead_url);
            ktc.a(jSONObject, "block_msg", simpleUser.block_msg);
            ktc.a(jSONObject, "show_onlyme", simpleUser.show_onlyme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
