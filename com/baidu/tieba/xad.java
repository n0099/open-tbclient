package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserVipInfo;
/* loaded from: classes9.dex */
public class xad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserVipInfo userVipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userVipInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "v_status", userVipInfo.v_status);
            ltc.a(jSONObject, "s_time", userVipInfo.s_time);
            ltc.a(jSONObject, "e_time", userVipInfo.e_time);
            ltc.a(jSONObject, "ext_score", userVipInfo.ext_score);
            ltc.a(jSONObject, "v_level", userVipInfo.v_level);
            ltc.a(jSONObject, "a_score", userVipInfo.a_score);
            ltc.a(jSONObject, "n_score", userVipInfo.n_score);
            ltc.a(jSONObject, "icon_url", userVipInfo.icon_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
