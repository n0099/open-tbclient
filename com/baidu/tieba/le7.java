package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.MsgInfo;
/* loaded from: classes4.dex */
public class le7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947940075, "Lcom/baidu/tieba/le7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947940075, "Lcom/baidu/tieba/le7;");
                return;
            }
        }
        Pattern.compile("(#\\([^#\\)\\(]+\\))");
    }

    public static String A(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = 0;
            if (i != 1 && i != 30) {
                if (i == 2) {
                    if (DataExt.toMapList(str).get(0).get("meme_id") != null) {
                        i3 = 1;
                    }
                    Application app = TbadkCoreApplication.getInst().getApp();
                    if (i3 != 0) {
                        i2 = R.string.obfuscated_res_0x7f0f09f5;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f09f9;
                    }
                    return app.getString(i2);
                } else if (i == 3) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09fd);
                } else {
                    if (i == 32) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09fc);
                    }
                    if (i == 33) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09f7);
                    }
                    if (i == 11) {
                        return a(str);
                    }
                    if (i == 23) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09fb);
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
                        } catch (JSONException e) {
                            e.printStackTrace();
                            try {
                                String optString2 = new JSONObject(str).optString("face_name");
                                if (optString2 != null && optString2.startsWith(SmallTailInfo.EMOTION_PREFIX) && optString2.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                    return PreferencesUtil.LEFT_MOUNT + optString2.substring(2, optString2.length() - 1) + PreferencesUtil.RIGHT_MOUNT;
                                }
                                return optString2;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (i == 5) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09f8);
                    } else {
                        if (i == 6) {
                            try {
                                return new JSONObject(str).optString(TbEnum.SystemMessage.KEY_USER_MSG);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                                return "";
                            }
                        } else if (i == 7) {
                            String string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09fa);
                            if (TextUtils.isEmpty(str)) {
                                return string;
                            }
                            try {
                                JSONArray jSONArray2 = new JSONArray(str);
                                if (jSONArray2.length() > 0) {
                                    while (i3 < jSONArray2.length()) {
                                        String string2 = ((JSONObject) jSONArray2.get(i3)).getString("text");
                                        if (!TextUtils.isEmpty(string2)) {
                                            return string2;
                                        }
                                        i3++;
                                    }
                                }
                                return string;
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                                return string;
                            }
                        } else if (i == 35) {
                            String string3 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09fa);
                            if (TextUtils.isEmpty(str)) {
                                return string3;
                            }
                            try {
                                JSONArray jSONArray3 = new JSONArray(str);
                                if (jSONArray3.length() > 0) {
                                    while (i3 < jSONArray3.length()) {
                                        String string4 = ((JSONObject) jSONArray3.get(i3)).getString("title");
                                        if (!TextUtils.isEmpty(string4)) {
                                            return string4;
                                        }
                                        i3++;
                                    }
                                }
                                return string3;
                            } catch (JSONException e5) {
                                e5.printStackTrace();
                                return string3;
                            }
                        } else if (i == 25) {
                            if (TextUtils.isEmpty(str)) {
                                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f081e);
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
                                    return String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f081f), optString3, optString4);
                                }
                                if (optInt2 == 3) {
                                    return String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f152e), Integer.valueOf(optInt));
                                }
                                return optString4;
                            } catch (JSONException e6) {
                                e6.printStackTrace();
                                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f081e);
                            }
                        } else if (i == 9) {
                            return h(str);
                        } else {
                            if (i != 34) {
                                return null;
                            }
                            GamePlayOrderMsgData gamePlayOrderMsgData = (GamePlayOrderMsgData) OrmObject.objectWithJsonStr(str, GamePlayOrderMsgData.class);
                            if (gamePlayOrderMsgData != null && !StringUtils.isNull(gamePlayOrderMsgData.getTitle())) {
                                return gamePlayOrderMsgData.getTitle();
                            }
                            return "[游戏组队消息]";
                        }
                    }
                }
            } else {
                if (str.length() > 1 && str.charAt(0) == '[') {
                    str2 = e(str);
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

    public static String B(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return "";
            }
            return A(chatMessage.getMsgType(), chatMessage.getContent());
        }
        return (String) invokeL.objValue;
    }

    public static MsgCacheData k(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, chatMessage)) == null) {
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

    public static db7 l(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, commonMsgPojo)) == null) {
            if (commonMsgPojo == null || commonMsgPojo.getMsg_type() != 7) {
                return null;
            }
            return n(commonMsgPojo.getContent());
        }
        return (db7) invokeL.objValue;
    }

    public static long p(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return -1L;
            }
            if (wg.g(TbadkCoreApplication.getCurrentAccount(), -1L) == chatMessage.getUserId()) {
                return chatMessage.getToUserId();
            }
            return chatMessage.getUserId();
        }
        return invokeL.longValue;
    }

    public static boolean w(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean x(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean y(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, chatMessage)) == null) {
            if (chatMessage != null && chatMessage.getMsgType() == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
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
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT)) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cf);
                }
                if (!optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP) && !optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN)) {
                    if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN)) {
                        String optString3 = optJSONObject.optString("userId");
                        String optString4 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cb);
                        }
                        return optString4 + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09ca);
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT)) {
                        if (optJSONObject.optString("userId").equals(TbadkCoreApplication.getCurrentAccount())) {
                            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cf);
                        }
                        return optString2;
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_SUC)) {
                        return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cb);
                    } else {
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP)) {
                            return optString2;
                        }
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_COMMON)) {
                            return optString2;
                        }
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_STRANGER_FIRST_MSG)) {
                            return optString2;
                        }
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT)) {
                        }
                    }
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMessage)) == null) {
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
    public static ShareForumMsgData c(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, chatMessage)) == null) {
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
    public static ShareThreadMsgData d(@Nullable ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, chatMessage)) == null) {
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

    public static final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() >= 2) {
                    String optString = jSONArray.optString(0);
                    if (1 == jSONArray.optInt(1)) {
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f6));
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

    public static final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
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

    public static String f(ChatMessage chatMessage) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, chatMessage)) == null) {
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
                return B(chatMessage);
            }
            if (chatMessage.getMsgType() == 11) {
                return B(chatMessage);
            }
            if (chatMessage.getToUserId() != 0) {
                return B(chatMessage);
            }
            if (!TextUtils.isEmpty(str)) {
                return str + ":" + B(chatMessage);
            }
            return B(chatMessage);
        }
        return (String) invokeL.objValue;
    }

    public static VoiceMsgData q(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, chatMessage)) == null) {
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

    public static int g(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            return context.getResources().getDimensionPixelSize(i);
        }
        return invokeLI.intValue;
    }

    public static String i(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, str, z)) == null) {
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

    public static String j(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, jSONObject, z)) == null) {
            if (z) {
                str = "big_src";
            } else {
                str = "src";
            }
            return jSONObject.optString(str);
        }
        return (String) invokeLZ.objValue;
    }

    public static db7 m(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (split = str.split("_")) != null && split.length == 2) {
                db7 db7Var = new db7();
                db7Var.a = split[0];
                db7Var.b = split[1];
                return db7Var;
            }
            return null;
        }
        return (db7) invokeL.objValue;
    }

    public static db7 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    return m(jSONArray.getJSONObject(0).optString("msg_src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return (db7) invokeL.objValue;
    }

    public static boolean u(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, chatMessage)) == null) {
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
                if (((JSONObject) jSONArray.get(0)).optInt(SetImageWatermarkTypeReqMsg.SWITCH, -1) == 0) {
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

    public static boolean v(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, chatMessage)) == null) {
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

    public static SystemMsgData o(ChatMessage chatMessage) {
        InterceptResult invokeL;
        String optString;
        String optString2;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, chatMessage)) == null) {
            if (chatMessage == null || chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(chatMessage.getContent());
                optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
                optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                if (optString.equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT)) {
                    SystemMsgData systemMsgData = new SystemMsgData();
                    systemMsgData.setIsSelf(true);
                    systemMsgData.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cf));
                    return systemMsgData;
                }
                if (!optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP) && !optString.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN)) {
                    if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN)) {
                        String optString3 = optJSONObject.optString("userId");
                        String optString4 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                        SystemMsgData systemMsgData2 = new SystemMsgData();
                        if (optString3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            systemMsgData2.setIsSelf(true);
                            systemMsgData2.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cb));
                        } else {
                            systemMsgData2.setIsSelf(false);
                            systemMsgData2.setContent(optString4 + TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09ca));
                        }
                        return systemMsgData2;
                    } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT)) {
                        String optString5 = optJSONObject.optString("userId");
                        SystemMsgData systemMsgData3 = new SystemMsgData();
                        if (optString5.equals(TbadkCoreApplication.getCurrentAccount())) {
                            systemMsgData3.setIsSelf(true);
                            systemMsgData3.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cf));
                        } else {
                            systemMsgData3.setIsSelf(false);
                            systemMsgData3.setContent(optString2);
                        }
                        return systemMsgData3;
                    } else {
                        if (optString.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_SUC)) {
                            SystemMsgData systemMsgData4 = new SystemMsgData();
                            systemMsgData4.setIsSelf(true);
                            systemMsgData4.setContent(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f09cb));
                        } else if (optString.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT)) {
                            SystemMsgData systemMsgData5 = new SystemMsgData();
                            systemMsgData5.setIsSelf(true);
                            systemMsgData5.setContent(optString2);
                            return systemMsgData5;
                        }
                        return null;
                    }
                }
                SystemMsgData systemMsgData6 = new SystemMsgData();
                systemMsgData6.setIsSelf(true);
                systemMsgData6.setContent(optString2);
                return systemMsgData6;
            }
            return null;
        }
        return (SystemMsgData) invokeL.objValue;
    }

    public static boolean r(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo, @Nullable boolean z) {
        InterceptResult invokeLLZ;
        GamePlayOrderMsgData parseFromMsgInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65556, null, chatMessage, msgInfo, z)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 34 || (parseFromMsgInfo = GamePlayOrderMsgData.parseFromMsgInfo(msgInfo, z)) == null) {
                return false;
            }
            parseFromMsgInfo.setHasRead(v(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(parseFromMsgInfo));
            chatMessage.setObjContent(parseFromMsgInfo);
            chatMessage.setEncodeContent(parseFromMsgInfo.toEncodeContent());
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean s(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ShareForumMsgData ofImForumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 33 || (ofImForumInfo = ShareForumMsgData.ofImForumInfo(msgInfo.forumInfo)) == null) {
                return false;
            }
            ofImForumInfo.setHasRead(v(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(ofImForumInfo));
            chatMessage.setObjContent(ofImForumInfo);
            chatMessage.setEncodeContent(ofImForumInfo.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean t(@Nullable ChatMessage chatMessage, @Nullable MsgInfo msgInfo) {
        InterceptResult invokeLL;
        ShareThreadMsgData ofImShareThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, chatMessage, msgInfo)) == null) {
            if (chatMessage == null || msgInfo == null || chatMessage.getMsgType() != 32 || (ofImShareThreadInfo = ShareThreadMsgData.ofImShareThreadInfo(msgInfo.threadInfo)) == null) {
                return false;
            }
            ofImShareThreadInfo.setHasRead(v(chatMessage));
            chatMessage.setContent(OrmObject.jsonStrWithObject(ofImShareThreadInfo));
            chatMessage.setObjContent(ofImShareThreadInfo);
            chatMessage.setEncodeContent(ofImShareThreadInfo.toEncodeContent());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
