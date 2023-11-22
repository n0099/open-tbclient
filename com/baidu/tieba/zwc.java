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
public class zwc extends qoc {
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
                qoc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, axc.b(signUser));
            }
            SignForum signForum = signInfo.forum_info;
            if (signForum != null) {
                qoc.a(jSONObject, "forum_info", ywc.b(signForum));
            }
            qoc.a(jSONObject, "has_chatroom_sign", signInfo.has_chatroom_sign);
            ChatroomSignInfo chatroomSignInfo = signInfo.chatroom_sign_info;
            if (chatroomSignInfo != null) {
                qoc.a(jSONObject, "chatroom_sign_info", brc.b(chatroomSignInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
