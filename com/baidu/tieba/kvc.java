package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.immessagecenter.im.dispatcher.PersonalMsgSettingDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BotReplyUserInfo;
/* loaded from: classes7.dex */
public class kvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BotReplyUserInfo botReplyUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, botReplyUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, PersonalMsgSettingDispatcher.PERSONAL_PORTRAIT_URL, botReplyUserInfo.portrait_url);
            ktc.a(jSONObject, "name", botReplyUserInfo.name);
            ktc.a(jSONObject, "icon_url", botReplyUserInfo.icon_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
