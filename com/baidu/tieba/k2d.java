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
public class k2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTopicList recomTopicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTopicList)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "topic_id", recomTopicList.topic_id);
            qoc.a(jSONObject, "topic_name", recomTopicList.topic_name);
            qoc.a(jSONObject, "type", recomTopicList.type);
            qoc.a(jSONObject, "discuss_num", recomTopicList.discuss_num);
            qoc.a(jSONObject, "tag", recomTopicList.tag);
            qoc.a(jSONObject, "topic_desc", recomTopicList.topic_desc);
            qoc.a(jSONObject, "topic_pic", recomTopicList.topic_pic);
            qoc.a(jSONObject, "update_time", recomTopicList.update_time);
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, recomTopicList.author);
            if (recomTopicList.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : recomTopicList.media) {
                    jSONArray.put(zzc.b(media));
                }
                qoc.a(jSONObject, "media", jSONArray);
            }
            qoc.a(jSONObject, "is_video_topic", recomTopicList.is_video_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
