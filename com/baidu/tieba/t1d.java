package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecomPostTopic;
/* loaded from: classes8.dex */
public class t1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomPostTopic recomPostTopic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomPostTopic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "recom_title", recomPostTopic.recom_title);
            ltc.a(jSONObject, "recom_topic", recomPostTopic.recom_topic);
            ltc.a(jSONObject, "uniq_topicid", recomPostTopic.uniq_topicid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
