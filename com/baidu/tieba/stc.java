package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrequentlyForumInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class stc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrequentlyForumInfo frequentlyForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frequentlyForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_id", frequentlyForumInfo.forum_id);
            qoc.a(jSONObject, "new_thread_num", frequentlyForumInfo.new_thread_num);
            if (frequentlyForumInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frequentlyForumInfo.user_list) {
                    jSONArray.put(n5d.b(user));
                }
                qoc.a(jSONObject, "user_list", jSONArray);
            }
            qoc.a(jSONObject, "last_access_time", frequentlyForumInfo.last_access_time);
            qoc.a(jSONObject, "forum_name", frequentlyForumInfo.forum_name);
            qoc.a(jSONObject, "avatar", frequentlyForumInfo.avatar);
            qoc.a(jSONObject, "level_id", frequentlyForumInfo.level_id);
            qoc.a(jSONObject, "forum_state", frequentlyForumInfo.forum_state);
            qoc.a(jSONObject, "access_flag", frequentlyForumInfo.access_flag);
            qoc.a(jSONObject, "is_sign", frequentlyForumInfo.is_sign);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
