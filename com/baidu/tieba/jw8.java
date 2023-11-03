package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.data.GamePlaySendCardMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.ImCommonShareInfo;
import protobuf.ImShareChatroomInfo;
import protobuf.MsgInfo;
/* loaded from: classes6.dex */
public class jw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897822, "Lcom/baidu/tieba/jw8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897822, "Lcom/baidu/tieba/jw8;");
                return;
            }
        }
        Pattern.compile("(#\\([^#\\)\\(]+\\))");
    }

    public static boolean A(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatMessage)) == null) {
            try {
                if (chatMessage.getMsgType() != 11 && TbadkCoreApplication.isLogin()) {
                    if (chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static GamePlaySendCardMsgData c(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 40) {
                if (chatMessage.getObjContent() != null) {
                    return (GamePlaySendCardMsgData) chatMessage.getObjContent();
                }
                GamePlaySendCardMsgData gamePlaySendCardMsgData = (GamePlaySendCardMsgData) OrmObject.objectWithJsonStr(chatMessage.getContent(), GamePlaySendCardMsgData.class);
                chatMessage.setObjContent(gamePlaySendCardMsgData);
                return gamePlaySendCardMsgData;
            }
            return null;
        }
        return (GamePlaySendCardMsgData) invokeL.objValue;
    }

    public static kq8 p(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (split = str.split("_")) != null && split.length == 2) {
                kq8 kq8Var = new kq8();
                kq8Var.a = split[0];
                kq8Var.b = split[1];
                return kq8Var;
            }
            return null;
        }
        return (kq8) invokeL.objValue;
    }

    public static kq8 q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    return p(jSONArray.getJSONObject(0).optString("msg_src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return (kq8) invokeL.objValue;
    }

    public static boolean z(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return true;
            }
            String content = chatMessage.getContent();
            if (!StringUtils.isJSONArray(content)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(content);
                if (jSONArray.length() <= 0) {
                    return true;
                }
                if (((JSONObject) jSONArray.get(0)).optInt("switch", -1) == 0) {
                    return true;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean B(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean C(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean D(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean E(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String G(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return "";
            }
            return F(chatMessage.getMsgType(), chatMessage.getContent());
        }
        return (String) invokeL.objValue;
    }

    public static MsgCacheData n(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, chatMessage)) == null) {
            try {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setRich_content(null);
                return msgCacheData;
            } catch (Exception unused) {
                return null;
            }
        }
        return (MsgCacheData) invokeL.objValue;
    }

    public static kq8 o(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, commonMsgPojo)) == null) {
            if (commonMsgPojo == null || commonMsgPojo.getMsg_type() != 7) {
                return null;
            }
            return q(commonMsgPojo.getContent());
        }
        return (kq8) invokeL.objValue;
    }

    public static long r(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return -1L;
            }
            if (JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), -1L) == chatMessage.getUserId()) {
                return chatMessage.getToUserId();
            }
            return chatMessage.getUserId();
        }
        return invokeL.longValue;
    }

    public static String F(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, str)) == null) {
            ImShareCardCommonData imShareCardCommonData = null;
            r6 = null;
            ShareChatroomMsgData shareChatroomMsgData = null;
            imShareCardCommonData = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = 0;
            if (i != 1 && i != 30) {
                if (i == 2) {
                    if (DataExt.toMapList(str).get(0).get(EmotionUbcHelper.MEME_ID) != null) {
                        i3 = 1;
                    }
                    Application app = TbadkCoreApplication.getInst().getApp();
                    if (i3 != 0) {
                        i2 = R.string.last_msg_emotion;
                    } else {
                        i2 = R.string.last_msg_pic;
                    }
                    return app.getString(i2);
                } else if (i == 3) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_voice);
                } else {
                    if (i == 32) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_thread_share);
                    }
                    if (i == 33) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_forum_share);
                    }
                    if (i == 37) {
                        if (!StringUtils.isNull(str)) {
                            try {
                                shareChatroomMsgData = (ShareChatroomMsgData) DataExt.toEntity(str, ShareChatroomMsgData.class);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_chatroom_share);
                        if (shareChatroomMsgData != null) {
                            return string + shareChatroomMsgData.getName();
                        }
                        return string;
                    }
                    String str3 = "";
                    if (i == 38) {
                        if (!StringUtils.isNull(str)) {
                            try {
                                imShareCardCommonData = (ImShareCardCommonData) DataExt.toEntity(str, ImShareCardCommonData.class);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (imShareCardCommonData == null) {
                            return "";
                        }
                        if (imShareCardCommonData.getType() == 1) {
                            str3 = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_topic_share);
                        } else if (imShareCardCommonData.getType() == 2) {
                            str3 = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_compilation_share);
                        }
                        return str3 + imShareCardCommonData.getTitle();
                    } else if (i == 11) {
                        return a(str);
                    } else {
                        if (i == 23) {
                            return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_reply_card);
                        }
                        if (i == 4) {
                            try {
                                JSONArray jSONArray = new JSONArray(str);
                                if (jSONArray.length() > 0) {
                                    String optString = jSONArray.getJSONObject(0).optString("face_name");
                                    if (optString != null && optString.startsWith(SmallTailInfo.EMOTION_PREFIX) && optString.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        return PreferencesUtil.LEFT_MOUNT + optString.substring(2, optString.length() - 1) + PreferencesUtil.RIGHT_MOUNT;
                                    }
                                    return optString;
                                }
                                return null;
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                                try {
                                    String optString2 = new JSONObject(str).optString("face_name");
                                    if (optString2 != null && optString2.startsWith(SmallTailInfo.EMOTION_PREFIX) && optString2.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        return PreferencesUtil.LEFT_MOUNT + optString2.substring(2, optString2.length() - 1) + PreferencesUtil.RIGHT_MOUNT;
                                    }
                                    return optString2;
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        } else if (i == 5) {
                            return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_invite);
                        } else {
                            if (i == 6) {
                                try {
                                    return new JSONObject(str).optString(TbEnum.SystemMessage.KEY_USER_MSG);
                                } catch (JSONException e5) {
                                    e5.printStackTrace();
                                    return "";
                                }
                            } else if (i == 7) {
                                String string2 = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_pic_text);
                                if (TextUtils.isEmpty(str)) {
                                    return string2;
                                }
                                try {
                                    JSONArray jSONArray2 = new JSONArray(str);
                                    if (jSONArray2.length() > 0) {
                                        while (i3 < jSONArray2.length()) {
                                            String string3 = ((JSONObject) jSONArray2.get(i3)).getString("text");
                                            if (!TextUtils.isEmpty(string3)) {
                                                return string3;
                                            }
                                            i3++;
                                        }
                                    }
                                    return string2;
                                } catch (JSONException e6) {
                                    e6.printStackTrace();
                                    return string2;
                                }
                            } else if (i == 35) {
                                String string4 = TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_pic_text);
                                if (TextUtils.isEmpty(str)) {
                                    return string4;
                                }
                                try {
                                    JSONArray jSONArray3 = new JSONArray(str);
                                    if (jSONArray3.length() > 0) {
                                        while (i3 < jSONArray3.length()) {
                                            String string5 = ((JSONObject) jSONArray3.get(i3)).getString("title");
                                            if (!TextUtils.isEmpty(string5)) {
                                                return string5;
                                            }
                                            i3++;
                                        }
                                    }
                                    return string4;
                                } catch (JSONException e7) {
                                    e7.printStackTrace();
                                    return string4;
                                }
                            } else if (i == 25) {
                                if (TextUtils.isEmpty(str)) {
                                    return TbadkCoreApplication.getInst().getApp().getString(R.string.great_call_notify_default);
                                }
                                try {
                                    JSONArray jSONArray4 = new JSONArray(str);
                                    if (jSONArray4.length() <= 0) {
                                        return "";
                                    }
                                    JSONObject optJSONObject = jSONArray4.optJSONObject(0);
                                    String optString3 = optJSONObject.optString("nick_name");
                                    String optString4 = optJSONObject.optString("caller_content");
                                    int optInt = optJSONObject.optInt("remind_count");
                                    int optInt2 = optJSONObject.optInt("msg_type");
                                    if (optInt2 == 1) {
                                        return String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.great_call_notify_msg), optString3, optString4);
                                    }
                                    if (optInt2 == 3) {
                                        return String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.urge_times_notify_default), Integer.valueOf(optInt));
                                    }
                                    return optString4;
                                } catch (JSONException e8) {
                                    e8.printStackTrace();
                                    return TbadkCoreApplication.getInst().getApp().getString(R.string.great_call_notify_default);
                                }
                            } else if (i == 9) {
                                return k(str);
                            } else {
                                if (i == 34) {
                                    GamePlayOrderMsgData gamePlayOrderMsgData = (GamePlayOrderMsgData) OrmObject.objectWithJsonStr(str, GamePlayOrderMsgData.class);
                                    if (gamePlayOrderMsgData != null && !StringUtils.isNull(gamePlayOrderMsgData.getTitle())) {
                                        return gamePlayOrderMsgData.getTitle();
                                    }
                                    return "[游戏组队消息]";
                                } else if (i == 40) {
                                    return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_play_send_card);
                                } else {
                                    return TbadkCoreApplication.getInst().getApp().getString(R.string.last_msg_nonsupport_share);
                                }
                            }
                        }
                    }
                }
            } else {
                if (str.length() > 1 && str.charAt(0) == '[') {
                    str2 = h(str);
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                if (str == null) {
                    return null;
                }
                return str;
            }
        } else {
            return (String) invokeIL.objValue;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventId");
                String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_FAKE)) {
                    return optString2;
                }
                if (optJSONObject == null) {
                    return null;
                }
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_COMMON)) {
                    return optString2;
                }
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_STRANGER_FIRST_MSG)) {
                }
                return optString2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static GamePlayOrderMsgData b(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 34) {
                if (chatMessage.getObjContent() != null) {
                    return (GamePlayOrderMsgData) chatMessage.getObjContent();
                }
                GamePlayOrderMsgData gamePlayOrderMsgData = (GamePlayOrderMsgData) OrmObject.objectWithJsonStr(chatMessage.getContent(), GamePlayOrderMsgData.class);
                if (gamePlayOrderMsgData != null) {
                    gamePlayOrderMsgData.setLast(!"expired".equals(chatMessage.getExtra()));
                    chatMessage.setEncodeContent(gamePlayOrderMsgData.toEncodeContent());
                }
                chatMessage.setObjContent(gamePlayOrderMsgData);
                return gamePlayOrderMsgData;
            }
            return null;
        }
        return (GamePlayOrderMsgData) invokeL.objValue;
    }

    @Nullable
    public static ImShareCardCommonData d(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, chatMessage)) == null) {
            ImShareCardCommonData imShareCardCommonData = null;
            if (chatMessage != null && chatMessage.getMsgType() == 38) {
                if (chatMessage.getObjContent() instanceof ImShareCardCommonData) {
                    return (ImShareCardCommonData) chatMessage.getObjContent();
                }
                try {
                    imShareCardCommonData = (ImShareCardCommonData) DataExt.toEntity(chatMessage.getContent(), ImShareCardCommonData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (imShareCardCommonData != null) {
                    chatMessage.setEncodeContent(imShareCardCommonData.toEncodeContent());
                    chatMessage.setObjContent(imShareCardCommonData);
                }
            }
            return imShareCardCommonData;
        }
        return (ImShareCardCommonData) invokeL.objValue;
    }

    @Nullable
    public static ShareChatroomMsgData e(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, chatMessage)) == null) {
            ShareChatroomMsgData shareChatroomMsgData = null;
            if (chatMessage != null && chatMessage.getMsgType() == 37) {
                if (chatMessage.getObjContent() instanceof ShareChatroomMsgData) {
                    return (ShareChatroomMsgData) chatMessage.getObjContent();
                }
                try {
                    shareChatroomMsgData = (ShareChatroomMsgData) DataExt.toEntity(chatMessage.getContent(), ShareChatroomMsgData.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (shareChatroomMsgData != null) {
                    chatMessage.setEncodeContent(shareChatroomMsgData.toEncodeContent());
                }
                chatMessage.setObjContent(shareChatroomMsgData);
            }
            return shareChatroomMsgData;
        }
        return (ShareChatroomMsgData) invokeL.objValue;
    }

    @Nullable
    public static ShareForumMsgData f(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 33) {
                if (chatMessage.getObjContent() != null) {
                    return (ShareForumMsgData) chatMessage.getObjContent();
                }
                ShareForumMsgData shareForumMsgData = (ShareForumMsgData) OrmObject.objectWithJsonStr(chatMessage.getContent(), ShareForumMsgData.class);
                if (shareForumMsgData != null) {
                    chatMessage.setEncodeContent(shareForumMsgData.toEncodeContent());
                }
                chatMessage.setObjContent(shareForumMsgData);
                return shareForumMsgData;
            }
            return null;
        }
        return (ShareForumMsgData) invokeL.objValue;
    }

    @Nullable
    public static ShareThreadMsgData g(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 32) {
                if (chatMessage.getObjContent() != null) {
                    return (ShareThreadMsgData) chatMessage.getObjContent();
                }
                ShareThreadMsgData shareThreadMsgData = (ShareThreadMsgData) OrmObject.objectWithJsonStr(chatMessage.getContent(), ShareThreadMsgData.class);
                if (shareThreadMsgData != null) {
                    chatMessage.setEncodeContent(shareThreadMsgData.toEncodeContent());
                }
                chatMessage.setObjContent(shareThreadMsgData);
                return shareThreadMsgData;
            }
            return null;
        }
        return (ShareThreadMsgData) invokeL.objValue;
    }

    public static final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() >= 2) {
                    String optString = jSONArray.optString(0);
                    if (1 == jSONArray.optInt(1)) {
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.last_msg_extra_share));
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
        return (String) invokeL.objValue;
    }

    public static final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
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
                            sb.append(SmallTailInfo.EMOTION_PREFIX);
                            sb.append(optJSONObject.opt("c"));
                            sb.append(SmallTailInfo.EMOTION_SUFFIX);
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
        return (String) invokeL.objValue;
    }

    public static String i(ChatMessage chatMessage) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return null;
            }
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserName())) {
                str = chatMessage.getUserInfo().getUserName();
            } else {
                str = "";
            }
            if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserId()) && userInfo.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return G(chatMessage);
            }
            if (chatMessage.getMsgType() == 11) {
                return G(chatMessage);
            }
            if (chatMessage.getToUserId() != 0) {
                return G(chatMessage);
            }
            if (!TextUtils.isEmpty(str)) {
                return str + ":" + G(chatMessage);
            }
            return G(chatMessage);
        }
        return (String) invokeL.objValue;
    }

    public static VoiceMsgData s(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, chatMessage)) == null) {
            VoiceMsgData voiceMsgData = null;
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
                if (jSONArray.length() <= 0) {
                    return null;
                }
                if (jSONArray.length() > 0) {
                    try {
                        voiceMsgData = (VoiceMsgData) OrmObject.objectWithJson(jSONArray.getJSONObject(0), VoiceMsgData.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                chatMessage.setObjContent(voiceMsgData);
                return voiceMsgData;
            } catch (Exception unused) {
                return voiceMsgData;
            }
        }
        return (VoiceMsgData) invokeL.objValue;
    }

    public static int j(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, context, i)) == null) {
            return context.getResources().getDimensionPixelSize(i);
        }
        return invokeLI.intValue;
    }

    public static String l(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65555, null, str, z)) == null) {
            if (str == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
                if (z) {
                    str2 = "big_src";
                } else {
                    str2 = "src";
                }
                return jSONObject.optString(str2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String m(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65556, null, jSONObject, z)) == null) {
            if (z) {
                str = "big_src";
            } else {
                str = "src";
            }
            return jSONObject.optString(str);
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean t(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ImCommonShareInfo imCommonShareInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 38 || (imCommonShareInfo = msgInfo.shareInfo) == null) {
                return false;
            }
            ImShareCardCommonData b = ImShareCardCommonData.Companion.b(imCommonShareInfo);
            b.setHasRead(A(chatMessage) ? 1 : 0);
            chatMessage.setContent(OrmObject.jsonStrWithObject(b));
            chatMessage.setObjContent(b);
            chatMessage.setEncodeContent(b.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean w(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ImShareChatroomInfo imShareChatroomInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 37 || (imShareChatroomInfo = msgInfo.shareChatroomInfo) == null) {
                return false;
            }
            ShareChatroomMsgData b = ShareChatroomMsgData.Companion.b(imShareChatroomInfo);
            b.setHasRead(A(chatMessage) ? 1 : 0);
            chatMessage.setContent(OrmObject.jsonStrWithObject(b));
            chatMessage.setObjContent(b);
            chatMessage.setEncodeContent(b.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean u(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo, @Nullable boolean z) {
        InterceptResult invokeLLZ;
        GamePlayOrderMsgData parseFromMsgInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65564, null, chatMessage, msgInfo, z)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 34 || (parseFromMsgInfo = GamePlayOrderMsgData.parseFromMsgInfo(msgInfo, z)) == null) {
                return false;
            }
            parseFromMsgInfo.setHasRead(A(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(parseFromMsgInfo));
            chatMessage.setObjContent(parseFromMsgInfo);
            chatMessage.setEncodeContent(parseFromMsgInfo.toEncodeContent());
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean v(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        GamePlaySendCardMsgData parseFromMsgInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 40 || (parseFromMsgInfo = GamePlaySendCardMsgData.parseFromMsgInfo(msgInfo)) == null) {
                return false;
            }
            chatMessage.setContent(OrmObject.jsonStrWithObject(parseFromMsgInfo));
            chatMessage.setObjContent(parseFromMsgInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean x(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ShareForumMsgData ofImForumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 33 || (ofImForumInfo = ShareForumMsgData.ofImForumInfo(msgInfo.forumInfo)) == null) {
                return false;
            }
            ofImForumInfo.setHasRead(A(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(ofImForumInfo));
            chatMessage.setObjContent(ofImForumInfo);
            chatMessage.setEncodeContent(ofImForumInfo.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean y(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ShareThreadMsgData ofImShareThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 32 || (ofImShareThreadInfo = ShareThreadMsgData.ofImShareThreadInfo(msgInfo.threadInfo)) == null) {
                return false;
            }
            ofImShareThreadInfo.setHasRead(A(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(ofImShareThreadInfo));
            chatMessage.setObjContent(ofImShareThreadInfo);
            chatMessage.setEncodeContent(ofImShareThreadInfo.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
