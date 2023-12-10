package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedForumInfo;
/* loaded from: classes6.dex */
public class ixc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedForumInfo feedForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_id", feedForumInfo.forum_id);
            ltc.a(jSONObject, "forum_name", feedForumInfo.forum_name);
            ltc.a(jSONObject, "member_count", feedForumInfo.member_count);
            ltc.a(jSONObject, "post_num", feedForumInfo.post_num);
            ltc.a(jSONObject, "avatar", feedForumInfo.avatar);
            ltc.a(jSONObject, "reason", feedForumInfo.reason);
            ltc.a(jSONObject, "pos", feedForumInfo.pos);
            ltc.a(jSONObject, "is_like", feedForumInfo.is_like);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
