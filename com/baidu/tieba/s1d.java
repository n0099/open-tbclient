package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes8.dex */
public class s1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecmForumInfo recmForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recmForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_name", recmForumInfo.forum_name);
            ltc.a(jSONObject, "forum_id", recmForumInfo.forum_id);
            ltc.a(jSONObject, "member_count", recmForumInfo.member_count);
            ltc.a(jSONObject, "post_num", recmForumInfo.post_num);
            ltc.a(jSONObject, "avatar", recmForumInfo.avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
