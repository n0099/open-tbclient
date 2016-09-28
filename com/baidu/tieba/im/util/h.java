package com.baidu.tieba.im.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.data.e;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private static Pattern pattern = Pattern.compile("(#\\([^#\\)\\(]+\\))");

    public static String H(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        try {
            str2 = new JSONArray(str).getJSONObject(0).optString(z ? "big_src" : "src");
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    public static long p(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return -1L;
        }
        if (b.c(TbadkCoreApplication.getCurrentAccount(), -1L) == chatMessage.getUserId()) {
            return chatMessage.getToUserId();
        }
        return chatMessage.getUserId();
    }

    public static String a(JSONObject jSONObject, boolean z) {
        return jSONObject.optString(z ? "big_src" : "src");
    }

    public static boolean q(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 2;
    }

    public static boolean r(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 4;
    }

    public static boolean s(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 3;
    }

    public static boolean t(ChatMessage chatMessage) {
        try {
            if (chatMessage.getMsgType() != 11 && TbadkCoreApplication.isLogin()) {
                return chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean u(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 6;
    }

    public static MsgCacheData v(ChatMessage chatMessage) {
        try {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setRich_content(null);
            return msgCacheData;
        } catch (Exception e) {
            return null;
        }
    }

    public static VoiceMsgData w(ChatMessage chatMessage) {
        VoiceMsgData voiceMsgData;
        if (chatMessage == null || chatMessage.getMsgType() != 3) {
            return null;
        }
        if (chatMessage.getObjContent() != null) {
            return (VoiceMsgData) chatMessage.getObjContent();
        }
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            VoiceMsgData voiceMsgData2 = new VoiceMsgData();
            chatMessage.setObjContent(voiceMsgData2);
            return voiceMsgData2;
        }
        try {
            JSONArray jSONArray = new JSONArray(content);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            try {
                if (0 < jSONArray.length()) {
                    try {
                        voiceMsgData = (VoiceMsgData) i.objectWithJson(jSONArray.getJSONObject(0), VoiceMsgData.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    chatMessage.setObjContent(voiceMsgData);
                    return voiceMsgData;
                }
                chatMessage.setObjContent(voiceMsgData);
                return voiceMsgData;
            } catch (Exception e2) {
                return voiceMsgData;
            }
            voiceMsgData = null;
        } catch (Exception e3) {
            return null;
        }
    }

    private static final String mh(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && !optJSONObject.isNull("type")) {
                    int optInt = optJSONObject.optInt("type");
                    if (optInt == 0) {
                        sb.append(optJSONObject.opt("text"));
                    } else if (optInt == 2) {
                        sb.append("#(");
                        sb.append(optJSONObject.opt("c"));
                        sb.append(")");
                    }
                }
            }
        } catch (Error e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    private static final String mi(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() >= 2) {
                String optString = jSONArray.optString(0);
                if (1 == jSONArray.optInt(1)) {
                    sb.append(TbadkCoreApplication.m9getInst().getString(r.j.last_msg_extra_share));
                }
                if (optString != null) {
                    sb.append(optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String x(ChatMessage chatMessage) {
        return chatMessage == null ? "" : A(chatMessage.getMsgType(), chatMessage.getContent());
    }

    public static String A(int i, String str) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == 1) {
            String mh = (str.length() <= 1 || str.charAt(0) != '[') ? null : mh(str);
            if (TextUtils.isEmpty(mh)) {
                mh = str;
            }
            if (mh == null) {
                return null;
            }
            Matcher matcher = pattern.matcher(mh);
            while (matcher.find()) {
                String group = matcher.group();
                mh = mh.replace(group, group.replace("#(", "[").replace(")", "]"));
            }
            return mh;
        } else if (i == 2) {
            return TbadkCoreApplication.m9getInst().getApp().getString(r.j.last_msg_pic);
        } else {
            if (i == 3) {
                return TbadkCoreApplication.m9getInst().getApp().getString(r.j.last_msg_voice);
            }
            if (i == 11) {
                return mj(str);
            }
            if (i == 23) {
                return TbadkCoreApplication.m9getInst().getApp().getString(r.j.last_msg_reply_card);
            }
            if (i == 4) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() > 0) {
                        String optString = jSONArray.getJSONObject(0).optString("face_name");
                        if (optString != null && optString.startsWith("#(") && optString.endsWith(")")) {
                            return "[" + optString.substring(2, optString.length() - 1) + "]";
                        }
                        return optString;
                    }
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    try {
                        String optString2 = new JSONObject(str).optString("face_name");
                        if (optString2 != null && optString2.startsWith("#(") && optString2.endsWith(")")) {
                            return "[" + optString2.substring(2, optString2.length() - 1) + "]";
                        }
                        return optString2;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (i == 5) {
                return TbadkCoreApplication.m9getInst().getApp().getString(r.j.last_msg_invite);
            } else {
                if (i == 6) {
                    try {
                        return new JSONObject(str).optString("userMsg");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return "";
                    }
                } else if (i == 7) {
                    String string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.last_msg_pic_text);
                    if (TextUtils.isEmpty(str)) {
                        return string;
                    }
                    try {
                        JSONArray jSONArray2 = new JSONArray(str);
                        if (jSONArray2.length() > 0) {
                            while (true) {
                                int i3 = i2;
                                if (i3 >= jSONArray2.length()) {
                                    break;
                                }
                                String string2 = ((JSONObject) jSONArray2.get(i3)).getString(VrPlayerActivityConfig.TITLE);
                                if (TextUtils.isEmpty(string2)) {
                                    i2 = i3 + 1;
                                } else {
                                    return string2;
                                }
                            }
                        }
                        return string;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        return string;
                    }
                } else if (i == 25) {
                    if (TextUtils.isEmpty(str)) {
                        return TbadkCoreApplication.m9getInst().getApp().getString(r.j.great_call_notify_default);
                    }
                    try {
                        String str2 = "";
                        JSONArray jSONArray3 = new JSONArray(str);
                        if (jSONArray3.length() > 0) {
                            JSONObject optJSONObject = jSONArray3.optJSONObject(0);
                            String optString3 = optJSONObject.optString("nick_name");
                            str2 = optJSONObject.optString("caller_content");
                            int optInt = optJSONObject.optInt("remind_count");
                            int optInt2 = optJSONObject.optInt("msg_type");
                            if (optInt2 == 1) {
                                str2 = String.format(TbadkCoreApplication.m9getInst().getApp().getString(r.j.great_call_notify_msg), optString3, str2);
                            } else if (optInt2 == 3) {
                                str2 = String.format(TbadkCoreApplication.m9getInst().getApp().getString(r.j.urge_times_notify_default), Integer.valueOf(optInt));
                            }
                        }
                        return str2;
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                        return TbadkCoreApplication.m9getInst().getApp().getString(r.j.great_call_notify_default);
                    }
                } else if (i == 9) {
                    return mi(str);
                } else {
                    return null;
                }
            }
        }
    }

    public static String y(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return null;
        }
        String str = "";
        UserData userInfo = chatMessage.getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserName())) {
            str = chatMessage.getUserInfo().getUserName();
        }
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserId()) && userInfo.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return x(chatMessage);
        }
        if (chatMessage.getMsgType() == 11) {
            return x(chatMessage);
        }
        if (chatMessage.getToUserId() != 0) {
            return x(chatMessage);
        }
        if (!TextUtils.isEmpty(str)) {
            return String.valueOf(str) + ":" + x(chatMessage);
        }
        return x(chatMessage);
    }

    private static String mj(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventId");
                String optString2 = jSONObject.optString("userMsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (!TextUtils.isEmpty(optString)) {
                    if (optString.equals("-10001")) {
                        str2 = optString2;
                    } else if (optJSONObject != null) {
                        if (optString.equals("003")) {
                            str2 = TbadkCoreApplication.m9getInst().getApp().getString(r.j.kick_out_myself);
                        } else if (optString.equals("122") || optString.equals("121")) {
                            str2 = optString2;
                        } else if (optString.equals("105")) {
                            String optString3 = optJSONObject.optString("userId");
                            String optString4 = optJSONObject.optString("userName");
                            if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                                str2 = TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group_myself);
                            } else {
                                str2 = String.valueOf(optString4) + TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group);
                            }
                        } else if (optString.equals("106")) {
                            str2 = optJSONObject.optString("userId").equals(TbadkCoreApplication.getCurrentAccount()) ? TbadkCoreApplication.m9getInst().getApp().getString(r.j.kick_out_myself) : optString2;
                        } else if (optString.equals("002")) {
                            str2 = TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group_myself);
                        } else if (optString.equals("109")) {
                            str2 = optString2;
                        } else if (optString.equals("110")) {
                            str2 = optString2;
                        } else if (optString.equals("202")) {
                            str2 = String.valueOf(optJSONObject.optString("userName")) + TbadkCoreApplication.m9getInst().getApp().getString(r.j.snap_group_chat_exit);
                        } else if (optString.equals("123")) {
                            str2 = optString2;
                        } else if (optString.equals("304")) {
                            str2 = optString2;
                        } else {
                            str2 = optString.equals("305") ? optString2 : optString2;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static SystemMsgData z(ChatMessage chatMessage) {
        if (chatMessage == null || chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(chatMessage.getContent());
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                return null;
            }
            if (optString.equals("003")) {
                SystemMsgData systemMsgData = new SystemMsgData();
                systemMsgData.setIsSelf(true);
                systemMsgData.setContent(TbadkCoreApplication.m9getInst().getApp().getString(r.j.kick_out_myself));
                return systemMsgData;
            } else if (optString.equals("122") || optString.equals("121")) {
                SystemMsgData systemMsgData2 = new SystemMsgData();
                systemMsgData2.setIsSelf(true);
                systemMsgData2.setContent(optString2);
                return systemMsgData2;
            } else if (optString.equals("105")) {
                String optString3 = optJSONObject.optString("userId");
                String optString4 = optJSONObject.optString("userName");
                SystemMsgData systemMsgData3 = new SystemMsgData();
                if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    systemMsgData3.setIsSelf(true);
                    systemMsgData3.setContent(TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group_myself));
                } else {
                    systemMsgData3.setIsSelf(false);
                    systemMsgData3.setContent(String.valueOf(optString4) + TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group));
                }
                return systemMsgData3;
            } else if (optString.equals("106")) {
                String optString5 = optJSONObject.optString("userId");
                SystemMsgData systemMsgData4 = new SystemMsgData();
                if (optString5.equals(TbadkCoreApplication.getCurrentAccount())) {
                    systemMsgData4.setIsSelf(true);
                    systemMsgData4.setContent(TbadkCoreApplication.m9getInst().getApp().getString(r.j.kick_out_myself));
                } else {
                    systemMsgData4.setIsSelf(false);
                    systemMsgData4.setContent(optString2);
                }
                return systemMsgData4;
            } else if (optString.equals("002")) {
                SystemMsgData systemMsgData5 = new SystemMsgData();
                systemMsgData5.setIsSelf(true);
                systemMsgData5.setContent(TbadkCoreApplication.m9getInst().getApp().getString(r.j.join_group_myself));
                return null;
            } else if (optString.equals("123")) {
                SystemMsgData systemMsgData6 = new SystemMsgData();
                systemMsgData6.setIsSelf(true);
                systemMsgData6.setContent(optString2);
                return systemMsgData6;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int n(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static e a(CommonMsgPojo commonMsgPojo) {
        if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 7) {
            return mk(commonMsgPojo.getContent());
        }
        return null;
    }

    public static e mk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                return ml(jSONArray.getJSONObject(0).optString("msg_src"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static e ml(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length != 2) {
            return null;
        }
        e eVar = new e();
        eVar.daq = split[0];
        eVar.taskId = split[1];
        return eVar;
    }
}
