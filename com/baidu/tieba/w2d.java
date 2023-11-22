package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SdkTopicThread;
/* loaded from: classes8.dex */
public class w2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SdkTopicThread sdkTopicThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sdkTopicThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pic_url", sdkTopicThread.pic_url);
            qoc.a(jSONObject, "title", sdkTopicThread.title);
            qoc.a(jSONObject, "post_num", sdkTopicThread.post_num);
            qoc.a(jSONObject, "zan_num", sdkTopicThread.zan_num);
            qoc.a(jSONObject, "tid", sdkTopicThread.tid);
            qoc.a(jSONObject, "need_topic", sdkTopicThread.need_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
