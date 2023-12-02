package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkModule;
import tbclient.TopicModule;
/* loaded from: classes6.dex */
public class kad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopicModule topicModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topicModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "topic_id", topicModule.topic_id);
            ktc.a(jSONObject, "topic_name", topicModule.topic_name);
            ktc.a(jSONObject, "topic_desc", topicModule.topic_desc);
            ktc.a(jSONObject, "discuss_num", topicModule.discuss_num);
            ktc.a(jSONObject, "topic_image", topicModule.topic_image);
            PkModule pkModule = topicModule.pk_module;
            if (pkModule != null) {
                ktc.a(jSONObject, "pk_module", k6d.b(pkModule));
            }
            ktc.a(jSONObject, "topic_avatar", topicModule.topic_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
