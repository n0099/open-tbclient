package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AwardUser;
/* loaded from: classes9.dex */
public class yuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AwardUser awardUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, awardUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", awardUser.user_id);
            ltc.a(jSONObject, "user_name", awardUser.user_name);
            ltc.a(jSONObject, "award_name", awardUser.award_name);
            ltc.a(jSONObject, "award_time", awardUser.award_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
