package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecreationRankInfo;
/* loaded from: classes9.dex */
public class x1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecreationRankInfo recreationRankInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recreationRankInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", recreationRankInfo.icon);
            ltc.a(jSONObject, "rank_name", recreationRankInfo.rank_name);
            ltc.a(jSONObject, "rank_score", recreationRankInfo.rank_score);
            ltc.a(jSONObject, "rank_link", recreationRankInfo.rank_link);
            ltc.a(jSONObject, "rank_icon", recreationRankInfo.rank_icon);
            ltc.a(jSONObject, "rank_color", recreationRankInfo.rank_color);
            ltc.a(jSONObject, "show_type", recreationRankInfo.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
