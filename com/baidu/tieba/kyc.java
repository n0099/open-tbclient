package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumFriendWatchingInfo;
/* loaded from: classes7.dex */
public class kyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumFriendWatchingInfo forumFriendWatchingInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumFriendWatchingInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_avatar", forumFriendWatchingInfo.forum_avatar);
            ltc.a(jSONObject, "forum_name", forumFriendWatchingInfo.forum_name);
            ltc.a(jSONObject, "show_num", forumFriendWatchingInfo.show_num);
            ltc.a(jSONObject, "show_type", forumFriendWatchingInfo.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
