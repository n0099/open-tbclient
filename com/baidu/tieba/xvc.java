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
/* loaded from: classes9.dex */
public class xvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomList chatroomList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "room_id", chatroomList.room_id);
            ChatroomInfoBasic chatroomInfoBasic = chatroomList.room_info;
            if (chatroomInfoBasic != null) {
                ltc.a(jSONObject, "room_info", wvc.b(chatroomInfoBasic));
            }
            ChatroomMEMsgInfo chatroomMEMsgInfo = chatroomList.msg_info;
            if (chatroomMEMsgInfo != null) {
                ltc.a(jSONObject, "msg_info", yvc.b(chatroomMEMsgInfo));
            }
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, chatroomList.jump_url);
            ChatRoomAtInfo chatRoomAtInfo = chatroomList.at_info;
            if (chatRoomAtInfo != null) {
                ltc.a(jSONObject, "at_info", vvc.b(chatRoomAtInfo));
            }
            ltc.a(jSONObject, TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, chatroomList.is_subscribe);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
