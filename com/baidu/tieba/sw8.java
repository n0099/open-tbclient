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
public class sw8 {
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
                return r9Var.getString(R.string.obfuscated_res_0x7f0f0ec9);
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
                            if (msgType != 32) {
                                if (msgType != 33) {
                                    content = "";
                                } else {
                                    content = r9Var.getString(R.string.obfuscated_res_0x7f0f09f9);
                                }
                            } else {
                                content = r9Var.getString(R.string.obfuscated_res_0x7f0f09fe);
                            }
                        }
                    } else {
                        content = r9Var.getString(R.string.obfuscated_res_0x7f0f15dd);
                    }
                } else {
                    content = a(r9Var, chatMessage.getContent());
                }
                if (chatMessage == null && chatMessage.getToUserInfo() != null) {
                    if (TextUtils.equals(chatMessage.getToUserInfo().getUserId(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                        string = r9Var.getString(R.string.obfuscated_res_0x7f0f0f62);
                    } else {
                        string = r9Var.getString(R.string.obfuscated_res_0x7f0f0f5f);
                    }
                    return string + chatMessage.getToUserInfo().getUserName() + r9Var.getString(R.string.obfuscated_res_0x7f0f0f60) + content;
                }
                return r9Var.getString(R.string.obfuscated_res_0x7f0f0f5f);
            }
            content = chatMessage.getContent();
            if (chatMessage == null) {
            }
            return r9Var.getString(R.string.obfuscated_res_0x7f0f0f5f);
        }
        return (String) invokeLL.objValue;
    }
}
