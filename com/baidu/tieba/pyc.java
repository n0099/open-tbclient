package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrequentlyForumInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class pyc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrequentlyForumInfo frequentlyForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frequentlyForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum_id", frequentlyForumInfo.forum_id);
            ktc.a(jSONObject, "new_thread_num", frequentlyForumInfo.new_thread_num);
            if (frequentlyForumInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frequentlyForumInfo.user_list) {
                    jSONArray.put(pad.b(user));
                }
                ktc.a(jSONObject, "user_list", jSONArray);
            }
            ktc.a(jSONObject, "last_access_time", frequentlyForumInfo.last_access_time);
            ktc.a(jSONObject, "forum_name", frequentlyForumInfo.forum_name);
            ktc.a(jSONObject, "avatar", frequentlyForumInfo.avatar);
            ktc.a(jSONObject, "level_id", frequentlyForumInfo.level_id);
            ktc.a(jSONObject, "forum_state", frequentlyForumInfo.forum_state);
            ktc.a(jSONObject, "access_flag", frequentlyForumInfo.access_flag);
            ktc.a(jSONObject, "is_sign", frequentlyForumInfo.is_sign);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
