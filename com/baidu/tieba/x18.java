package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ChatMsg a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", 1);
                jSONObject.put("from", "android");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str);
                jSONObject.put("content", jSONObject2);
                TextMsg textMsg = new TextMsg();
                textMsg.setMsgId(0L);
                textMsg.setMsgKey(String.valueOf(System.currentTimeMillis()));
                textMsg.setContentExtra(jSONObject.toString());
                textMsg.setText(str);
                return textMsg;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ChatMsg) invokeL.objValue;
    }

    @Nullable
    public static ChatMsg b(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj instanceof l08) {
                try {
                    l08 l08Var = (l08) obj;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", 1);
                    jSONObject.put("from", "android");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("text", l08Var.a());
                    jSONObject.put("content", jSONObject2);
                    TextMsg textMsg = new TextMsg();
                    textMsg.setText(l08Var.a());
                    textMsg.setSenderUid(BIMManager.getBdUidFromBdUK(String.valueOf(q18.k.a())));
                    textMsg.setContentExtra(jSONObject.toString());
                    return textMsg;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (obj instanceof i08) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", Integer.MAX_VALUE);
                    jSONObject3.put("from", "android");
                    jSONObject3.put("isSelf", false);
                    TextMsg textMsg2 = new TextMsg();
                    textMsg2.setMsgId(Long.MAX_VALUE);
                    textMsg2.setMsgKey(String.valueOf(System.currentTimeMillis()));
                    textMsg2.setSenderUid(BIMManager.getBdUidFromBdUK(String.valueOf(q18.k.a())));
                    textMsg2.setContentExtra(jSONObject3.toString());
                    return textMsg2;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        }
        return (ChatMsg) invokeL.objValue;
    }

    @Nullable
    public static k08<Object> c(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            k08<Object> k08Var = new k08<>();
            if (chatMsg instanceof TextMsg) {
                String text = ((TextMsg) chatMsg).getText();
                l08 l08Var = new l08();
                if (text == null) {
                    text = "";
                }
                l08Var.b(text);
                k08Var.h(l08Var);
            }
            k08Var.c(chatMsg.getMsgId());
            k08Var.d(chatMsg.getMsgKey());
            k08Var.e().l(chatMsg.getContacterUk());
            k08Var.e().k(q7a.c(chatMsg.getSenderUid(), 0L));
            k08Var.e().i(chatMsg.getStatus());
            k08Var.i(chatMsg);
            boolean isSelf = chatMsg.isSelf(TbadkApplication.getInst());
            k08Var.e().h(isSelf);
            if (!isSelf) {
                k08Var.e().g(TbSingleton.getInstance().getFunnySpriteAvatar());
                k08Var.e().f(TbSingleton.getInstance().getFunnySpriteName());
            } else {
                k08Var.e().g(TbadkCoreApplication.getCurrentPortrait());
                k08Var.e().f(TbadkCoreApplication.getCurrentAccountNameShow());
            }
            String contentExtra = chatMsg.getContentExtra();
            if (!StringUtils.isNull(contentExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(contentExtra);
                    k08Var.e().j(jSONObject.optInt("type"));
                    k08Var.e().e(jSONObject.optString("from"));
                    if (k08Var.e().getType() == Integer.MAX_VALUE) {
                        k08Var.h(new i08());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return k08Var;
        }
        return (k08) invokeL.objValue;
    }
}
