package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RankingParam;
/* loaded from: classes6.dex */
public class j7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RankingParam rankingParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rankingParam)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "rank_type", rankingParam.rank_type);
            ltc.a(jSONObject, "rank_code", rankingParam.rank_code);
            ltc.a(jSONObject, "sort_type", rankingParam.sort_type);
            ltc.a(jSONObject, "tab_id", rankingParam.tab_id);
            ltc.a(jSONObject, "pn", rankingParam.pn);
            ltc.a(jSONObject, "rn", rankingParam.rn);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
