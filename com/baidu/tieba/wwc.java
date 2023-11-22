package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecreationRankInfo;
/* loaded from: classes9.dex */
public class wwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecreationRankInfo recreationRankInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recreationRankInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", recreationRankInfo.icon);
            qoc.a(jSONObject, "rank_name", recreationRankInfo.rank_name);
            qoc.a(jSONObject, "rank_score", recreationRankInfo.rank_score);
            qoc.a(jSONObject, "rank_link", recreationRankInfo.rank_link);
            qoc.a(jSONObject, "rank_icon", recreationRankInfo.rank_icon);
            qoc.a(jSONObject, "rank_color", recreationRankInfo.rank_color);
            qoc.a(jSONObject, "show_type", recreationRankInfo.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
