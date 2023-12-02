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
public class z1d extends ktc {
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
                ktc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, a2d.b(signUser));
            }
            SignForum signForum = signInfo.forum_info;
            if (signForum != null) {
                ktc.a(jSONObject, "forum_info", y1d.b(signForum));
            }
            ktc.a(jSONObject, "has_chatroom_sign", signInfo.has_chatroom_sign);
            ChatroomSignInfo chatroomSignInfo = signInfo.chatroom_sign_info;
            if (chatroomSignInfo != null) {
                ktc.a(jSONObject, "chatroom_sign_info", yvc.b(chatroomSignInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
