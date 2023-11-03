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
public class rtc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrequentlyForumInfo frequentlyForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frequentlyForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "forum_id", frequentlyForumInfo.forum_id);
            poc.a(jSONObject, "new_thread_num", frequentlyForumInfo.new_thread_num);
            if (frequentlyForumInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frequentlyForumInfo.user_list) {
                    jSONArray.put(m5d.b(user));
                }
                poc.a(jSONObject, "user_list", jSONArray);
            }
            poc.a(jSONObject, "last_access_time", frequentlyForumInfo.last_access_time);
            poc.a(jSONObject, "forum_name", frequentlyForumInfo.forum_name);
            poc.a(jSONObject, "avatar", frequentlyForumInfo.avatar);
            poc.a(jSONObject, "level_id", frequentlyForumInfo.level_id);
            poc.a(jSONObject, "forum_state", frequentlyForumInfo.forum_state);
            poc.a(jSONObject, "access_flag", frequentlyForumInfo.access_flag);
            poc.a(jSONObject, "is_sign", frequentlyForumInfo.is_sign);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
