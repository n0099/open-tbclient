package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedFeedback;
import tbclient.FeedbackReason;
/* loaded from: classes6.dex */
public class jsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedFeedback feedFeedback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedFeedback)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", feedFeedback.type);
            qoc.a(jSONObject, "title", feedFeedback.title);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, feedFeedback.button_text);
            qoc.a(jSONObject, "common_id", feedFeedback.common_id);
            if (feedFeedback.dislike != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedbackReason feedbackReason : feedFeedback.dislike) {
                    jSONArray.put(jtc.b(feedbackReason));
                }
                qoc.a(jSONObject, "dislike", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
