package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BotReplyContent;
import tbclient.StyleConfExtra;
/* loaded from: classes8.dex */
public class v3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StyleConfExtra styleConfExtra) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, styleConfExtra)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "first_post_guide", styleConfExtra.first_post_guide);
            qoc.a(jSONObject, "guide", styleConfExtra.guide);
            qoc.a(jSONObject, "bot_name", styleConfExtra.bot_name);
            qoc.a(jSONObject, "bot_portrait", styleConfExtra.bot_portrait);
            qoc.a(jSONObject, "bot_reply_content", styleConfExtra.bot_reply_content);
            qoc.a(jSONObject, "bot_loading_content", styleConfExtra.bot_loading_content);
            qoc.a(jSONObject, "guide_content", styleConfExtra.guide_content);
            qoc.a(jSONObject, "guide_icon", styleConfExtra.guide_icon);
            qoc.a(jSONObject, "bot_loading_toast", styleConfExtra.bot_loading_toast);
            qoc.a(jSONObject, "bot_timeout_content", styleConfExtra.bot_timeout_content);
            if (styleConfExtra.bot_reply_content_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (BotReplyContent botReplyContent : styleConfExtra.bot_reply_content_list) {
                    jSONArray.put(nqc.b(botReplyContent));
                }
                qoc.a(jSONObject, "bot_reply_content_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
