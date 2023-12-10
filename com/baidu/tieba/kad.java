package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes7.dex */
public class kad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Topic topic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_lpost", topic.is_lpost);
            ltc.a(jSONObject, TiebaStatic.Params.TOPIC_TYPE, topic.topic_type);
            ltc.a(jSONObject, "link", topic.link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
