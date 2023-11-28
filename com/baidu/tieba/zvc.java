package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomSignInfo;
/* loaded from: classes9.dex */
public class zvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomSignInfo chatroomSignInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomSignInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "chatroom_id", chatroomSignInfo.chatroom_id);
            ltc.a(jSONObject, "jump_scheme", chatroomSignInfo.jump_scheme);
            ltc.a(jSONObject, "guide_text", chatroomSignInfo.guide_text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
