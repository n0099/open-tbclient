package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecomTopicList;
import tbclient.VideoTags;
import tbclient.WorksInfo;
/* loaded from: classes7.dex */
public class qbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorksInfo worksInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worksInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_works", worksInfo.is_works);
            if (worksInfo.topic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecomTopicList recomTopicList : worksInfo.topic_list) {
                    jSONArray.put(n7d.b(recomTopicList));
                }
                ltc.a(jSONObject, "topic_list", jSONArray);
            }
            VideoTags videoTags = worksInfo.tag_list;
            if (videoTags != null) {
                ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_LIST, ebd.b(videoTags));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
