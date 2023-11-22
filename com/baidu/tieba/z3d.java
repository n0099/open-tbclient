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
public class z3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPostList subPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", subPostList.id);
            if (subPostList.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : subPostList.content) {
                    jSONArray.put(x0d.b(pbContent));
                }
                qoc.a(jSONObject, "content", jSONArray);
            }
            qoc.a(jSONObject, "time", subPostList.time);
            qoc.a(jSONObject, "author_id", subPostList.author_id);
            qoc.a(jSONObject, "title", subPostList.title);
            qoc.a(jSONObject, "floor", subPostList.floor);
            User user = subPostList.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            qoc.a(jSONObject, "is_giftpost", subPostList.is_giftpost);
            Agree agree = subPostList.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            Lbs lbs = subPostList.location;
            if (lbs != null) {
                qoc.a(jSONObject, "location", mzc.b(lbs));
            }
            qoc.a(jSONObject, "is_fake_top", subPostList.is_fake_top);
            qoc.a(jSONObject, "is_author_view", subPostList.is_author_view);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
