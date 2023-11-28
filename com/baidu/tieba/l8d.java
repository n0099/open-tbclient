package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SimpleUser;
/* loaded from: classes7.dex */
public class l8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleUser simpleUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", simpleUser.user_id);
            ltc.a(jSONObject, "user_status", simpleUser.user_status);
            ltc.a(jSONObject, "secureemail", simpleUser.secureemail);
            ltc.a(jSONObject, "securemobil", simpleUser.securemobil);
            ltc.a(jSONObject, "user_name", simpleUser.user_name);
            ltc.a(jSONObject, "user_nickname", simpleUser.user_nickname);
            ltc.a(jSONObject, "incomplete_user", simpleUser.incomplete_user);
            ltc.a(jSONObject, "portrait", simpleUser.portrait);
            ltc.a(jSONObject, "agree_type", simpleUser.agree_type);
            ltc.a(jSONObject, "ahead_url", simpleUser.ahead_url);
            ltc.a(jSONObject, "block_msg", simpleUser.block_msg);
            ltc.a(jSONObject, "show_onlyme", simpleUser.show_onlyme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
