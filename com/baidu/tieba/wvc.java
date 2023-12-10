package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomInfoBasic;
/* loaded from: classes8.dex */
public class wvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomInfoBasic chatroomInfoBasic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomInfoBasic)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_id", chatroomInfoBasic.forum_id);
            ltc.a(jSONObject, "forum_name", chatroomInfoBasic.forum_name);
            ltc.a(jSONObject, "avatar", chatroomInfoBasic.avatar);
            ltc.a(jSONObject, "name", chatroomInfoBasic.name);
            ltc.a(jSONObject, "unread_num", chatroomInfoBasic.unread_num);
            ltc.a(jSONObject, "btn_type", chatroomInfoBasic.btn_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
