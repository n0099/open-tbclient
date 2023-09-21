package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class vsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(BdPageContext bdPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bdPageContext, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    sb.append(jSONArray.optJSONObject(i).optString("src"));
                }
                return sb.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return bdPageContext.getString(R.string.pic_str);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(BdPageContext bdPageContext, ChatMessage chatMessage) {
        InterceptResult invokeLL;
        String string;
        ImShareCardCommonData d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bdPageContext, chatMessage)) == null) {
            int msgType = chatMessage.getMsgType();
            String str = "";
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 30) {
                            if (msgType != 32) {
                                if (msgType != 33) {
                                    if (msgType != 37) {
                                        if (msgType == 38 && (d = bp8.d(chatMessage)) != null) {
                                            if (d.getType() == 1) {
                                                str = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_topic_share);
                                            } else if (d.getType() == 2) {
                                                str = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_compilation_share);
                                            } else if (d.getType() == 3) {
                                                str = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_active_share);
                                            }
                                        }
                                    } else {
                                        str = bdPageContext.getString(R.string.last_msg_chatroom_share);
                                    }
                                } else {
                                    str = bdPageContext.getString(R.string.last_msg_forum_share);
                                }
                            } else {
                                str = bdPageContext.getString(R.string.last_msg_thread_share);
                            }
                        }
                    } else {
                        str = bdPageContext.getString(R.string.voice_str);
                    }
                } else {
                    str = a(bdPageContext, chatMessage.getContent());
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = bdPageContext.getString(R.string.private_message_report_person);
                    } else {
                        string = bdPageContext.getString(R.string.private_message_is_report_name);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + bdPageContext.getString(R.string.private_message_report_content) + str;
                }
                return bdPageContext.getString(R.string.private_message_is_report_name);
            }
            str = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return bdPageContext.getString(R.string.private_message_is_report_name);
        }
        return (String) invokeLL.objValue;
    }
}
