package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AtMsgBase;
import tbclient.ChatRoomAtInfo;
/* loaded from: classes8.dex */
public class wqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatRoomAtInfo chatRoomAtInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatRoomAtInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "at_count_all", chatRoomAtInfo.at_count_all);
            poc.a(jSONObject, "at_all_msg_count", chatRoomAtInfo.at_all_msg_count);
            poc.a(jSONObject, "at_single_msg_count", chatRoomAtInfo.at_single_msg_count);
            if (chatRoomAtInfo.at_all_msg_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (AtMsgBase atMsgBase : chatRoomAtInfo.at_all_msg_list) {
                    jSONArray.put(wpc.b(atMsgBase));
                }
                poc.a(jSONObject, "at_all_msg_list", jSONArray);
            }
            if (chatRoomAtInfo.at_single_msg_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AtMsgBase atMsgBase2 : chatRoomAtInfo.at_single_msg_list) {
                    jSONArray2.put(wpc.b(atMsgBase2));
                }
                poc.a(jSONObject, "at_single_msg_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
