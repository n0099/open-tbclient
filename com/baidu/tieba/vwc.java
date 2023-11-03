package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecreationRankInfo;
/* loaded from: classes8.dex */
public class vwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecreationRankInfo recreationRankInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recreationRankInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", recreationRankInfo.icon);
            poc.a(jSONObject, "rank_name", recreationRankInfo.rank_name);
            poc.a(jSONObject, "rank_score", recreationRankInfo.rank_score);
            poc.a(jSONObject, "rank_link", recreationRankInfo.rank_link);
            poc.a(jSONObject, "rank_icon", recreationRankInfo.rank_icon);
            poc.a(jSONObject, "rank_color", recreationRankInfo.rank_color);
            poc.a(jSONObject, "show_type", recreationRankInfo.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
