package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.CommonDistance;
import tbclient.FrsPage.CommonForum;
import tbclient.FrsPage.PostInfo;
import tbclient.FrsPage.RecomUserInfo;
import tbclient.FrsPage.UserInfo;
/* loaded from: classes8.dex */
public class swc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomUserInfo recomUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            UserInfo userInfo = recomUserInfo.user_info;
            if (userInfo != null) {
                poc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, qxc.b(userInfo));
            }
            if (recomUserInfo.common_forum != null) {
                JSONArray jSONArray = new JSONArray();
                for (CommonForum commonForum : recomUserInfo.common_forum) {
                    jSONArray.put(uuc.b(commonForum));
                }
                poc.a(jSONObject, "common_forum", jSONArray);
            }
            if (recomUserInfo.post_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    jSONArray2.put(iwc.b(postInfo));
                }
                poc.a(jSONObject, "post_info", jSONArray2);
            }
            poc.a(jSONObject, "pos_name", recomUserInfo.pos_name);
            poc.a(jSONObject, "message", recomUserInfo.message);
            CommonDistance commonDistance = recomUserInfo.distanceinfo;
            if (commonDistance != null) {
                poc.a(jSONObject, "distanceinfo", tuc.b(commonDistance));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
