package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.Post;
/* loaded from: classes9.dex */
public class zvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MatchPlayerInfo matchPlayerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, matchPlayerInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", matchPlayerInfo.name);
            qoc.a(jSONObject, "avatar", matchPlayerInfo.avatar);
            qoc.a(jSONObject, "score", matchPlayerInfo.score);
            qoc.a(jSONObject, "score_cnt", matchPlayerInfo.score_cnt);
            Post post = matchPlayerInfo.hot_post;
            if (post != null) {
                qoc.a(jSONObject, "hot_post", q1d.b(post));
            }
            qoc.a(jSONObject, "sub_avatar", matchPlayerInfo.sub_avatar);
            qoc.a(jSONObject, "sub_text", matchPlayerInfo.sub_text);
            qoc.a(jSONObject, "score_self", matchPlayerInfo.score_self);
            qoc.a(jSONObject, "score_link", matchPlayerInfo.score_link);
            qoc.a(jSONObject, "match_id", matchPlayerInfo.match_id);
            qoc.a(jSONObject, "match_index", matchPlayerInfo.match_index);
            qoc.a(jSONObject, "player_id", matchPlayerInfo.player_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
