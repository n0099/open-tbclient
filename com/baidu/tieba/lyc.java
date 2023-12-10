package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumPresentInfo;
import tbclient.UserRankPresentInfo;
/* loaded from: classes7.dex */
public class lyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumPresentInfo forumPresentInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumPresentInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (forumPresentInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (UserRankPresentInfo userRankPresentInfo : forumPresentInfo.user_list) {
                    jSONArray.put(tad.b(userRankPresentInfo));
                }
                ltc.a(jSONObject, "user_list", jSONArray);
            }
            ltc.a(jSONObject, "content", forumPresentInfo.content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
