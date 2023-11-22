package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes6.dex */
public class j2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTopicInfo recomTopicInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTopicInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "recom_title", recomTopicInfo.recom_title);
            if (recomTopicInfo.topic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                    jSONArray.put(k2d.b(recomTopicList));
                }
                qoc.a(jSONObject, "topic_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
