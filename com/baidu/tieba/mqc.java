package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BotReplyContent;
import tbclient.BotReplyUserInfo;
/* loaded from: classes7.dex */
public class mqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BotReplyContent botReplyContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, botReplyContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", botReplyContent.text);
            BotReplyUserInfo botReplyUserInfo = botReplyContent.user_info;
            if (botReplyUserInfo != null) {
                poc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, nqc.b(botReplyUserInfo));
            }
            poc.a(jSONObject, "target_scheme", botReplyContent.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
