package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.MatchCardInfo;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class y0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MatchCardInfo matchCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, matchCardInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", matchCardInfo.name);
            ktc.a(jSONObject, "status", matchCardInfo.status);
            ktc.a(jSONObject, "card_title", matchCardInfo.card_title);
            ktc.a(jSONObject, "topic_id", matchCardInfo.topic_id);
            ktc.a(jSONObject, "team_name_a", matchCardInfo.team_name_a);
            ktc.a(jSONObject, "team_name_b", matchCardInfo.team_name_b);
            ktc.a(jSONObject, "team_icon_a", matchCardInfo.team_icon_a);
            ktc.a(jSONObject, "team_icon_b", matchCardInfo.team_icon_b);
            ktc.a(jSONObject, "start_desc", matchCardInfo.start_desc);
            ktc.a(jSONObject, "team_score_a", matchCardInfo.team_score_a);
            ktc.a(jSONObject, "team_score_b", matchCardInfo.team_score_b);
            if (matchCardInfo.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : matchCardInfo.thread_list) {
                    jSONArray.put(x9d.b(threadInfo));
                }
                ktc.a(jSONObject, "thread_list", jSONArray);
            }
            ktc.a(jSONObject, "icon_text", matchCardInfo.icon_text);
            if (matchCardInfo.team_player_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (MatchPlayerInfo matchPlayerInfo : matchCardInfo.team_player_list) {
                    jSONArray2.put(z0d.b(matchPlayerInfo));
                }
                ktc.a(jSONObject, "team_player_list", jSONArray2);
            }
            ktc.a(jSONObject, "match_link", matchCardInfo.match_link);
            ktc.a(jSONObject, "schedule_link", matchCardInfo.schedule_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
