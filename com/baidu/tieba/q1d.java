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
/* loaded from: classes7.dex */
public class q1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostList postList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postList)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", postList.id);
            User user = postList.author;
            if (user != null) {
                poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, m5d.b(user));
            }
            if (postList._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : postList._abstract) {
                    jSONArray.put(soc.b(r3));
                }
                poc.a(jSONObject, "abstract", jSONArray);
            }
            if (postList.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : postList.media) {
                    jSONArray2.put(yzc.b(media));
                }
                poc.a(jSONObject, "media", jSONArray2);
            }
            if (postList.media_num != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (MediaNum mediaNum : postList.media_num) {
                    jSONArray3.put(zzc.b(mediaNum));
                }
                poc.a(jSONObject, "media_num", jSONArray3);
            }
            if (postList.voice_info != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Voice voice : postList.voice_info) {
                    jSONArray4.put(e6d.b(voice));
                }
                poc.a(jSONObject, "voice_info", jSONArray4);
            }
            poc.a(jSONObject, "author_id", postList.author_id);
            Agree agree = postList.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
