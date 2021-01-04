package com.baidu.yuyinala.privatemessage.model.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static String TAG = a.class.getSimpleName();
    private static volatile a pcs = new a();

    public static a eoe() {
        a aVar = pcs;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = pcs;
                if (aVar == null) {
                    aVar = new a();
                    pcs = aVar;
                }
            }
        }
        return aVar;
    }

    public boolean E(Context context, String str, String str2) {
        TextMsg textMsg = new TextMsg();
        textMsg.setContacter(ChatInfo.mContacter);
        textMsg.setFromUser(ChatInfo.oTJ);
        textMsg.setText(str);
        textMsg.setStatus(1);
        textMsg.setSenderUid(com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(context) != null ? com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(context) : "0");
        if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C) {
            textMsg.setCategory(0);
            textMsg.setChatType(0);
            textMsg.setContacterBduid(ChatInfo.mUid + "");
        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
            textMsg.setCategory(1);
            textMsg.setChatType(3);
            textMsg.setContacterBduid(ChatInfo.mUid + "");
        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
            textMsg.setCategory(0);
            textMsg.setChatType(7);
            textMsg.setContacterBduid(ChatInfo.mUid + "");
        }
        textMsg.setMsgTime(System.currentTimeMillis() / 1000);
        c(context, textMsg);
        c Yu = d.emC().Yu(str2);
        if (Yu != null) {
            Yu.h(textMsg);
        }
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0139 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: org.json.JSONObject */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x018d -> B:57:0x014d). Please submit an issue!!! */
    public void c(Context context, ChatMsg chatMsg) {
        JSONObject jSONObject;
        long j = 0;
        if (ChatInfo.oTM == 2) {
            try {
                j = Long.valueOf(com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(context)).longValue();
            } catch (Exception e) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(TAG, "transfer build to long value exception");
            }
            String d = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().d(context, String.valueOf(ChatInfo.mContacter), j);
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(TAG, "nickname " + d + " " + ChatInfo.mContacter + " " + j);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("sex", ChatInfo.oTN);
                jSONObject2.put("portrait", ChatInfo.oTK);
                if (!TextUtils.isEmpty(d)) {
                    jSONObject2.put("name", d);
                } else if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                    jSONObject2.put("name", ChatInfo.nickname);
                } else {
                    jSONObject2.put("name", ChatInfo.displayname);
                }
                jSONObject2.put("isVip", ChatInfo.vip);
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(ChatInfo.oTO)) {
                    jSONArray.put(ChatInfo.oTO);
                }
                if (!TextUtils.isEmpty(ChatInfo.oTP)) {
                    jSONArray.put(ChatInfo.oTP);
                }
                if (jSONArray.length() > 0) {
                    jSONObject2.put(CommandMessage.TYPE_TAGS, jSONArray);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            chatMsg.setStarContentExtra(jSONObject2.toString());
            chatMsg.setChatType(4);
        } else if (ChatInfo.oTM == 1) {
            try {
                j = Long.valueOf(com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(context)).longValue();
            } catch (Exception e3) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e(TAG, "transfer build to long value exception");
            }
            String d2 = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().d(context, String.valueOf(ChatInfo.mContacter), j);
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(TAG, "nickname " + d2 + " " + ChatInfo.mContacter + " " + j);
            ?? jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("portrait", ChatInfo.oTK);
                if (!TextUtils.isEmpty(d2)) {
                    jSONObject3.put("name", d2);
                    jSONObject = jSONObject3;
                } else if (!TextUtils.isEmpty(ChatInfo.nickname)) {
                    jSONObject3.put("name", ChatInfo.nickname);
                    jSONObject = jSONObject3;
                } else {
                    jSONObject3.put("name", ChatInfo.displayname);
                    jSONObject = jSONObject3;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
                jSONObject = jSONObject3;
            }
            try {
                JSONObject jSONObject4 = new JSONObject(chatMsg.getJsonContent());
                jSONObject3 = jSONObject.toString();
                jSONObject4.put("mvgroupext", (Object) jSONObject3);
                chatMsg.setMsgContent(jSONObject4.toString());
                chatMsg.setChatType(3);
            } catch (Exception e5) {
            }
        }
    }
}
