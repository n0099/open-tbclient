package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BotReplyContent;
import tbclient.StyleConfExtra;
/* loaded from: classes9.dex */
public class x8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StyleConfExtra styleConfExtra) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, styleConfExtra)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "first_post_guide", styleConfExtra.first_post_guide);
            ktc.a(jSONObject, "guide", styleConfExtra.guide);
            ktc.a(jSONObject, "bot_name", styleConfExtra.bot_name);
            ktc.a(jSONObject, "bot_portrait", styleConfExtra.bot_portrait);
            ktc.a(jSONObject, "bot_reply_content", styleConfExtra.bot_reply_content);
            ktc.a(jSONObject, "bot_loading_content", styleConfExtra.bot_loading_content);
            ktc.a(jSONObject, "guide_content", styleConfExtra.guide_content);
            ktc.a(jSONObject, "guide_icon", styleConfExtra.guide_icon);
            ktc.a(jSONObject, "bot_loading_toast", styleConfExtra.bot_loading_toast);
            ktc.a(jSONObject, "bot_timeout_content", styleConfExtra.bot_timeout_content);
            if (styleConfExtra.bot_reply_content_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (BotReplyContent botReplyContent : styleConfExtra.bot_reply_content_list) {
                    jSONArray.put(jvc.b(botReplyContent));
                }
                ktc.a(jSONObject, "bot_reply_content_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
