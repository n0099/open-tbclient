package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostTopic;
/* loaded from: classes7.dex */
public class l1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostTopic postTopic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postTopic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title_topic", postTopic.title_topic);
            ktc.a(jSONObject, "content_topic", postTopic.content_topic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
