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
public class qyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrequentlyForumInfo frequentlyForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frequentlyForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_id", frequentlyForumInfo.forum_id);
            ltc.a(jSONObject, "new_thread_num", frequentlyForumInfo.new_thread_num);
            if (frequentlyForumInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frequentlyForumInfo.user_list) {
                    jSONArray.put(qad.b(user));
                }
                ltc.a(jSONObject, "user_list", jSONArray);
            }
            ltc.a(jSONObject, "last_access_time", frequentlyForumInfo.last_access_time);
            ltc.a(jSONObject, "forum_name", frequentlyForumInfo.forum_name);
            ltc.a(jSONObject, "avatar", frequentlyForumInfo.avatar);
            ltc.a(jSONObject, "level_id", frequentlyForumInfo.level_id);
            ltc.a(jSONObject, "forum_state", frequentlyForumInfo.forum_state);
            ltc.a(jSONObject, "access_flag", frequentlyForumInfo.access_flag);
            ltc.a(jSONObject, "is_sign", frequentlyForumInfo.is_sign);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
