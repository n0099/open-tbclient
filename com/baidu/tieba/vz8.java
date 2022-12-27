package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class vz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(r9 r9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, r9Var, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return r9Var.getString(R.string.pic_str);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(r9 r9Var, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String content;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, r9Var, chatMessage)) == null) {
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
                                        content = r9Var.getString(R.string.last_msg_forum_share);
                                    }
                                } else {
                                    content = r9Var.getString(R.string.last_msg_thread_share);
                                }
                            } else {
                                content = r9Var.getString(R.string.last_msg_chatroom_share);
                            }
                        }
                    } else {
                        content = r9Var.getString(R.string.voice_str);
                    }
                } else {
                    content = a(r9Var, chatMessage.getContent());
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = r9Var.getString(R.string.private_message_report_person);
                    } else {
                        string = r9Var.getString(R.string.private_message_is_report_name);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + r9Var.getString(R.string.private_message_report_content) + content;
                }
                return r9Var.getString(R.string.private_message_is_report_name);
            }
            content = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return r9Var.getString(R.string.private_message_is_report_name);
        }
        return (String) invokeLL.objValue;
    }
}
