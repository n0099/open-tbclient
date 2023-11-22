package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes8.dex */
public class rwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecmForumInfo recmForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recmForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_name", recmForumInfo.forum_name);
            qoc.a(jSONObject, "forum_id", recmForumInfo.forum_id);
            qoc.a(jSONObject, "member_count", recmForumInfo.member_count);
            qoc.a(jSONObject, "post_num", recmForumInfo.post_num);
            qoc.a(jSONObject, "avatar", recmForumInfo.avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
