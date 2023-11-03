package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.Post;
/* loaded from: classes9.dex */
public class yvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MatchPlayerInfo matchPlayerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, matchPlayerInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", matchPlayerInfo.name);
            poc.a(jSONObject, "avatar", matchPlayerInfo.avatar);
            poc.a(jSONObject, "score", matchPlayerInfo.score);
            poc.a(jSONObject, "score_cnt", matchPlayerInfo.score_cnt);
            Post post = matchPlayerInfo.hot_post;
            if (post != null) {
                poc.a(jSONObject, "hot_post", p1d.b(post));
            }
            poc.a(jSONObject, "sub_avatar", matchPlayerInfo.sub_avatar);
            poc.a(jSONObject, "sub_text", matchPlayerInfo.sub_text);
            poc.a(jSONObject, "score_self", matchPlayerInfo.score_self);
            poc.a(jSONObject, "score_link", matchPlayerInfo.score_link);
            poc.a(jSONObject, "match_id", matchPlayerInfo.match_id);
            poc.a(jSONObject, "match_index", matchPlayerInfo.match_index);
            poc.a(jSONObject, "player_id", matchPlayerInfo.player_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
