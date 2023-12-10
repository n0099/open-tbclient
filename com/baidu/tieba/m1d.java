package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostTopic;
/* loaded from: classes7.dex */
public class m1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostTopic postTopic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postTopic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title_topic", postTopic.title_topic);
            ltc.a(jSONObject, "content_topic", postTopic.content_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
