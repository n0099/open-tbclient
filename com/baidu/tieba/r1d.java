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
public class r1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostList postList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postList)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", postList.id);
            User user = postList.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            if (postList._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : postList._abstract) {
                    jSONArray.put(toc.b(r3));
                }
                qoc.a(jSONObject, "abstract", jSONArray);
            }
            if (postList.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : postList.media) {
                    jSONArray2.put(zzc.b(media));
                }
                qoc.a(jSONObject, "media", jSONArray2);
            }
            if (postList.media_num != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (MediaNum mediaNum : postList.media_num) {
                    jSONArray3.put(a0d.b(mediaNum));
                }
                qoc.a(jSONObject, "media_num", jSONArray3);
            }
            if (postList.voice_info != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Voice voice : postList.voice_info) {
                    jSONArray4.put(f6d.b(voice));
                }
                qoc.a(jSONObject, "voice_info", jSONArray4);
            }
            qoc.a(jSONObject, "author_id", postList.author_id);
            Agree agree = postList.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
