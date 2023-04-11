package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class kt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(a9 a9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, a9Var, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return a9Var.getString(R.string.pic_str);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(a9 a9Var, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String content;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, a9Var, chatMessage)) == null) {
            int msgType = chatMessage.getMsgType();
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 30) {
                            if (msgType != 37) {
                                if (msgType != 32) {
                                    if (msgType != 33) {
                                        content = "";
                                    } else {
                                        content = a9Var.getString(R.string.last_msg_forum_share);
                                    }
                                } else {
                                    content = a9Var.getString(R.string.last_msg_thread_share);
                                }
                            } else {
                                content = a9Var.getString(R.string.last_msg_chatroom_share);
                            }
                        }
                    } else {
                        content = a9Var.getString(R.string.voice_str);
                    }
                } else {
                    content = a(a9Var, chatMessage.getContent());
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = a9Var.getString(R.string.private_message_report_person);
                    } else {
                        string = a9Var.getString(R.string.private_message_is_report_name);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + a9Var.getString(R.string.private_message_report_content) + content;
                }
                return a9Var.getString(R.string.private_message_is_report_name);
            }
            content = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return a9Var.getString(R.string.private_message_is_report_name);
        }
        return (String) invokeLL.objValue;
    }
}
