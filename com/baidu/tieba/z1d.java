package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Forum;
import tbclient.FrsPage.RankInfo;
import tbclient.FrsPage.SignForum;
/* loaded from: classes9.dex */
public class z1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignForum signForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_on", signForum.is_on);
            ltc.a(jSONObject, "is_filter", signForum.is_filter);
            Forum forum = signForum.forum_info;
            if (forum != null) {
                ltc.a(jSONObject, "forum_info", e0d.b(forum));
            }
            RankInfo rankInfo = signForum.current_rank_info;
            if (rankInfo != null) {
                ltc.a(jSONObject, "current_rank_info", q1d.b(rankInfo));
            }
            RankInfo rankInfo2 = signForum.yesterday_rank_info;
            if (rankInfo2 != null) {
                ltc.a(jSONObject, "yesterday_rank_info", q1d.b(rankInfo2));
            }
            RankInfo rankInfo3 = signForum.weekly_rank_info;
            if (rankInfo3 != null) {
                ltc.a(jSONObject, "weekly_rank_info", q1d.b(rankInfo3));
            }
            ltc.a(jSONObject, "level1_dir_name", signForum.level1_dir_name);
            ltc.a(jSONObject, "level2_dir_name", signForum.level2_dir_name);
            RankInfo rankInfo4 = signForum.monthly_rank_info;
            if (rankInfo4 != null) {
                ltc.a(jSONObject, "monthly_rank_info", q1d.b(rankInfo4));
            }
            ltc.a(jSONObject, "forum_id", signForum.forum_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
