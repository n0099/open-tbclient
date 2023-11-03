package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomSignInfo;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
/* loaded from: classes9.dex */
public class ywc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignInfo signInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            SignUser signUser = signInfo.user_info;
            if (signUser != null) {
                poc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, zwc.b(signUser));
            }
            SignForum signForum = signInfo.forum_info;
            if (signForum != null) {
                poc.a(jSONObject, "forum_info", xwc.b(signForum));
            }
            poc.a(jSONObject, "has_chatroom_sign", signInfo.has_chatroom_sign);
            ChatroomSignInfo chatroomSignInfo = signInfo.chatroom_sign_info;
            if (chatroomSignInfo != null) {
                poc.a(jSONObject, "chatroom_sign_info", arc.b(chatroomSignInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
