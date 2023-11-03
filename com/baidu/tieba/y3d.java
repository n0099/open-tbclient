package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.Lbs;
import tbclient.PbContent;
import tbclient.SubPostList;
import tbclient.User;
/* loaded from: classes9.dex */
public class y3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPostList subPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", subPostList.id);
            if (subPostList.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : subPostList.content) {
                    jSONArray.put(w0d.b(pbContent));
                }
                poc.a(jSONObject, "content", jSONArray);
            }
            poc.a(jSONObject, "time", subPostList.time);
            poc.a(jSONObject, "author_id", subPostList.author_id);
            poc.a(jSONObject, "title", subPostList.title);
            poc.a(jSONObject, "floor", subPostList.floor);
            User user = subPostList.author;
            if (user != null) {
                poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, m5d.b(user));
            }
            poc.a(jSONObject, "is_giftpost", subPostList.is_giftpost);
            Agree agree = subPostList.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            Lbs lbs = subPostList.location;
            if (lbs != null) {
                poc.a(jSONObject, "location", lzc.b(lbs));
            }
            poc.a(jSONObject, "is_fake_top", subPostList.is_fake_top);
            poc.a(jSONObject, "is_author_view", subPostList.is_author_view);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
