package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedbackReason;
/* loaded from: classes6.dex */
public class itc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedbackReason feedbackReason) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedbackReason)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "reason", feedbackReason.reason);
            poc.a(jSONObject, "id", feedbackReason.id);
            poc.a(jSONObject, "extra", feedbackReason.extra);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
