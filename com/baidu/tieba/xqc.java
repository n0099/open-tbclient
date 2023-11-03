package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomInfoBasic;
/* loaded from: classes9.dex */
public class xqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatroomInfoBasic chatroomInfoBasic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatroomInfoBasic)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "forum_id", chatroomInfoBasic.forum_id);
            poc.a(jSONObject, "forum_name", chatroomInfoBasic.forum_name);
            poc.a(jSONObject, "avatar", chatroomInfoBasic.avatar);
            poc.a(jSONObject, "name", chatroomInfoBasic.name);
            poc.a(jSONObject, "unread_num", chatroomInfoBasic.unread_num);
            poc.a(jSONObject, "btn_type", chatroomInfoBasic.btn_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
