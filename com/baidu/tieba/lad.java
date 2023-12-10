package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkModule;
import tbclient.TopicModule;
/* loaded from: classes7.dex */
public class lad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopicModule topicModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topicModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "topic_id", topicModule.topic_id);
            ltc.a(jSONObject, "topic_name", topicModule.topic_name);
            ltc.a(jSONObject, "topic_desc", topicModule.topic_desc);
            ltc.a(jSONObject, "discuss_num", topicModule.discuss_num);
            ltc.a(jSONObject, "topic_image", topicModule.topic_image);
            PkModule pkModule = topicModule.pk_module;
            if (pkModule != null) {
                ltc.a(jSONObject, "pk_module", l6d.b(pkModule));
            }
            ltc.a(jSONObject, "topic_avatar", topicModule.topic_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
