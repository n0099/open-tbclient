package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RankInfo;
/* loaded from: classes7.dex */
public class p1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RankInfo rankInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rankInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "sign_count", rankInfo.sign_count);
            ktc.a(jSONObject, "sign_rank", rankInfo.sign_rank);
            ktc.a(jSONObject, "member_count", rankInfo.member_count);
            ktc.a(jSONObject, "dir_rate", rankInfo.dir_rate);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
