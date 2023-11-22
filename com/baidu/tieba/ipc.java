package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AigcFeedbackInfo;
import tbclient.Toast;
/* loaded from: classes6.dex */
public class ipc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aigcFeedbackInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "aigc_chat_id", aigcFeedbackInfo.aigc_chat_id);
            qoc.a(jSONObject, "feedback_fold", aigcFeedbackInfo.feedback_fold);
            qoc.a(jSONObject, "feedback_fold_tip", aigcFeedbackInfo.feedback_fold_tip);
            qoc.a(jSONObject, "positive_text", aigcFeedbackInfo.positive_text);
            qoc.a(jSONObject, "negative_text", aigcFeedbackInfo.negative_text);
            qoc.a(jSONObject, "feedback_url", aigcFeedbackInfo.feedback_url);
            Toast toast = aigcFeedbackInfo.feedback_toast;
            if (toast != null) {
                qoc.a(jSONObject, "feedback_toast", f5d.b(toast));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
