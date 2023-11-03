package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.SignUser;
/* loaded from: classes9.dex */
public class zwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignUser signUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", signUser.user_id);
            poc.a(jSONObject, "is_sign_in", signUser.is_sign_in);
            poc.a(jSONObject, "user_sign_rank", signUser.user_sign_rank);
            poc.a(jSONObject, "sign_time", signUser.sign_time);
            poc.a(jSONObject, "cont_sign_num", signUser.cont_sign_num);
            poc.a(jSONObject, "cout_total_sign_num", signUser.cout_total_sign_num);
            poc.a(jSONObject, "is_org_disabled", signUser.is_org_disabled);
            poc.a(jSONObject, "c_sign_num", signUser.c_sign_num);
            poc.a(jSONObject, "hun_sign_num", signUser.hun_sign_num);
            poc.a(jSONObject, "total_resign_num", signUser.total_resign_num);
            poc.a(jSONObject, "miss_sign_num", signUser.miss_sign_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
