package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomMEMsgInfo;
/* loaded from: classes9.dex */
public class zqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomMEMsgInfo chatroomMEMsgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomMEMsgInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "from_uid", chatroomMEMsgInfo.from_uid);
            poc.a(jSONObject, "from_name", chatroomMEMsgInfo.from_name);
            poc.a(jSONObject, "content", chatroomMEMsgInfo.content);
            poc.a(jSONObject, "msg_id", chatroomMEMsgInfo.msg_id);
            poc.a(jSONObject, "special_msg", chatroomMEMsgInfo.special_msg);
            poc.a(jSONObject, "special_msg_type", chatroomMEMsgInfo.special_msg_type);
            poc.a(jSONObject, "msg_time", chatroomMEMsgInfo.msg_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
