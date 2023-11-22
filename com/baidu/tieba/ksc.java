package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedForumInfo;
/* loaded from: classes7.dex */
public class ksc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedForumInfo feedForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_id", feedForumInfo.forum_id);
            qoc.a(jSONObject, "forum_name", feedForumInfo.forum_name);
            qoc.a(jSONObject, "member_count", feedForumInfo.member_count);
            qoc.a(jSONObject, "post_num", feedForumInfo.post_num);
            qoc.a(jSONObject, "avatar", feedForumInfo.avatar);
            qoc.a(jSONObject, "reason", feedForumInfo.reason);
            qoc.a(jSONObject, "pos", feedForumInfo.pos);
            qoc.a(jSONObject, "is_like", feedForumInfo.is_like);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
