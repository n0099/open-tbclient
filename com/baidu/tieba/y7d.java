package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SdkTopicThread;
/* loaded from: classes9.dex */
public class y7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SdkTopicThread sdkTopicThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sdkTopicThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pic_url", sdkTopicThread.pic_url);
            ktc.a(jSONObject, "title", sdkTopicThread.title);
            ktc.a(jSONObject, "post_num", sdkTopicThread.post_num);
            ktc.a(jSONObject, "zan_num", sdkTopicThread.zan_num);
            ktc.a(jSONObject, "tid", sdkTopicThread.tid);
            ktc.a(jSONObject, "need_topic", sdkTopicThread.need_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
