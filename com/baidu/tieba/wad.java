package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserVipInfo;
/* loaded from: classes8.dex */
public class wad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserVipInfo userVipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userVipInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "v_status", userVipInfo.v_status);
            ktc.a(jSONObject, "s_time", userVipInfo.s_time);
            ktc.a(jSONObject, "e_time", userVipInfo.e_time);
            ktc.a(jSONObject, "ext_score", userVipInfo.ext_score);
            ktc.a(jSONObject, "v_level", userVipInfo.v_level);
            ktc.a(jSONObject, "a_score", userVipInfo.a_score);
            ktc.a(jSONObject, "n_score", userVipInfo.n_score);
            ktc.a(jSONObject, "icon_url", userVipInfo.icon_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
