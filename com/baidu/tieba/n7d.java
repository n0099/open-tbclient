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
public class n7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTopicList recomTopicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTopicList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "topic_id", recomTopicList.topic_id);
            ltc.a(jSONObject, "topic_name", recomTopicList.topic_name);
            ltc.a(jSONObject, "type", recomTopicList.type);
            ltc.a(jSONObject, "discuss_num", recomTopicList.discuss_num);
            ltc.a(jSONObject, "tag", recomTopicList.tag);
            ltc.a(jSONObject, "topic_desc", recomTopicList.topic_desc);
            ltc.a(jSONObject, "topic_pic", recomTopicList.topic_pic);
            ltc.a(jSONObject, "update_time", recomTopicList.update_time);
            ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, recomTopicList.author);
            if (recomTopicList.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : recomTopicList.media) {
                    jSONArray.put(c5d.b(media));
                }
                ltc.a(jSONObject, "media", jSONArray);
            }
            ltc.a(jSONObject, "is_video_topic", recomTopicList.is_video_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
