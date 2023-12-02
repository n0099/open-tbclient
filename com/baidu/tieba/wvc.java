package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatRoomAtInfo;
import tbclient.ChatroomInfoBasic;
import tbclient.ChatroomList;
import tbclient.ChatroomMEMsgInfo;
/* loaded from: classes8.dex */
public class wvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomList chatroomList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "room_id", chatroomList.room_id);
            ChatroomInfoBasic chatroomInfoBasic = chatroomList.room_info;
            if (chatroomInfoBasic != null) {
                ktc.a(jSONObject, "room_info", vvc.b(chatroomInfoBasic));
            }
            ChatroomMEMsgInfo chatroomMEMsgInfo = chatroomList.msg_info;
            if (chatroomMEMsgInfo != null) {
                ktc.a(jSONObject, "msg_info", xvc.b(chatroomMEMsgInfo));
            }
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, chatroomList.jump_url);
            ChatRoomAtInfo chatRoomAtInfo = chatroomList.at_info;
            if (chatRoomAtInfo != null) {
                ktc.a(jSONObject, "at_info", uvc.b(chatRoomAtInfo));
            }
            ktc.a(jSONObject, TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, chatroomList.is_subscribe);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
