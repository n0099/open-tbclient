package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SdkTopicThread;
/* loaded from: classes8.dex */
public class v2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SdkTopicThread sdkTopicThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sdkTopicThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pic_url", sdkTopicThread.pic_url);
            poc.a(jSONObject, "title", sdkTopicThread.title);
            poc.a(jSONObject, "post_num", sdkTopicThread.post_num);
            poc.a(jSONObject, "zan_num", sdkTopicThread.zan_num);
            poc.a(jSONObject, "tid", sdkTopicThread.tid);
            poc.a(jSONObject, "need_topic", sdkTopicThread.need_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
