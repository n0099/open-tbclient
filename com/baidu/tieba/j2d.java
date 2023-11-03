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
/* loaded from: classes6.dex */
public class j2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTopicList recomTopicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTopicList)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "topic_id", recomTopicList.topic_id);
            poc.a(jSONObject, "topic_name", recomTopicList.topic_name);
            poc.a(jSONObject, "type", recomTopicList.type);
            poc.a(jSONObject, "discuss_num", recomTopicList.discuss_num);
            poc.a(jSONObject, "tag", recomTopicList.tag);
            poc.a(jSONObject, "topic_desc", recomTopicList.topic_desc);
            poc.a(jSONObject, "topic_pic", recomTopicList.topic_pic);
            poc.a(jSONObject, "update_time", recomTopicList.update_time);
            poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, recomTopicList.author);
            if (recomTopicList.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : recomTopicList.media) {
                    jSONArray.put(yzc.b(media));
                }
                poc.a(jSONObject, "media", jSONArray);
            }
            poc.a(jSONObject, "is_video_topic", recomTopicList.is_video_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
