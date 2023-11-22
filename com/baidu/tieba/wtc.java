package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ChatroomList;
import tbclient.FrsBottomChatroomBase;
/* loaded from: classes8.dex */
public class wtc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomChatroomBase frsBottomChatroomBase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomChatroomBase)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (frsBottomChatroomBase.room_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ChatroomList chatroomList : frsBottomChatroomBase.room_list) {
                    jSONArray.put(zqc.b(chatroomList));
                }
                qoc.a(jSONObject, "room_list", jSONArray);
            }
            qoc.a(jSONObject, "mid_group_id", frsBottomChatroomBase.mid_group_id);
            qoc.a(jSONObject, "display_chatroom_count", frsBottomChatroomBase.display_chatroom_count);
            qoc.a(jSONObject, "online_nums", frsBottomChatroomBase.online_nums);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
