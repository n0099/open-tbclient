package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Agree;
import tbclient.Media;
import tbclient.MediaNum;
import tbclient.PostList;
import tbclient.User;
import tbclient.Voice;
/* loaded from: classes8.dex */
public class u6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostList postList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", postList.id);
            User user = postList.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            if (postList._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : postList._abstract) {
                    jSONArray.put(otc.b(r3));
                }
                ltc.a(jSONObject, "abstract", jSONArray);
            }
            if (postList.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : postList.media) {
                    jSONArray2.put(c5d.b(media));
                }
                ltc.a(jSONObject, "media", jSONArray2);
            }
            if (postList.media_num != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (MediaNum mediaNum : postList.media_num) {
                    jSONArray3.put(d5d.b(mediaNum));
                }
                ltc.a(jSONObject, "media_num", jSONArray3);
            }
            if (postList.voice_info != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Voice voice : postList.voice_info) {
                    jSONArray4.put(jbd.b(voice));
                }
                ltc.a(jSONObject, "voice_info", jSONArray4);
            }
            ltc.a(jSONObject, "author_id", postList.author_id);
            Agree agree = postList.agree;
            if (agree != null) {
                ltc.a(jSONObject, "agree", cuc.b(agree));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
