package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Media;
import tbclient.RecomTopicList;
/* loaded from: classes7.dex */
public class m7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTopicList recomTopicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTopicList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "topic_id", recomTopicList.topic_id);
            ktc.a(jSONObject, "topic_name", recomTopicList.topic_name);
            ktc.a(jSONObject, "type", recomTopicList.type);
            ktc.a(jSONObject, "discuss_num", recomTopicList.discuss_num);
            ktc.a(jSONObject, "tag", recomTopicList.tag);
            ktc.a(jSONObject, "topic_desc", recomTopicList.topic_desc);
            ktc.a(jSONObject, "topic_pic", recomTopicList.topic_pic);
            ktc.a(jSONObject, "update_time", recomTopicList.update_time);
            ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, recomTopicList.author);
            if (recomTopicList.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : recomTopicList.media) {
                    jSONArray.put(b5d.b(media));
                }
                ktc.a(jSONObject, "media", jSONArray);
            }
            ktc.a(jSONObject, "is_video_topic", recomTopicList.is_video_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
