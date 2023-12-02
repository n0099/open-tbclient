package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.Post;
/* loaded from: classes9.dex */
public class z0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MatchPlayerInfo matchPlayerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, matchPlayerInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", matchPlayerInfo.name);
            ktc.a(jSONObject, "avatar", matchPlayerInfo.avatar);
            ktc.a(jSONObject, "score", matchPlayerInfo.score);
            ktc.a(jSONObject, "score_cnt", matchPlayerInfo.score_cnt);
            Post post = matchPlayerInfo.hot_post;
            if (post != null) {
                ktc.a(jSONObject, "hot_post", s6d.b(post));
            }
            ktc.a(jSONObject, "sub_avatar", matchPlayerInfo.sub_avatar);
            ktc.a(jSONObject, "sub_text", matchPlayerInfo.sub_text);
            ktc.a(jSONObject, "score_self", matchPlayerInfo.score_self);
            ktc.a(jSONObject, "score_link", matchPlayerInfo.score_link);
            ktc.a(jSONObject, "match_id", matchPlayerInfo.match_id);
            ktc.a(jSONObject, "match_index", matchPlayerInfo.match_index);
            ktc.a(jSONObject, "player_id", matchPlayerInfo.player_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
