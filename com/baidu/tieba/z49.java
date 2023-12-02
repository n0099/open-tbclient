package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z49() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(@NonNull ChatRoomInfo chatRoomInfo, @NonNull ChatMsg chatMsg) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, chatRoomInfo, chatMsg) != null) || TextUtils.isEmpty(chatMsg.getMsgContent())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            JSONObject optJSONObject = jSONObject.optJSONObject("service_info");
            if (optJSONObject == null) {
                return;
            }
            String str2 = "";
            if (!optJSONObject.has("msg_from_baidu_uk")) {
                str = "";
            } else {
                str = BIMManager.getBdUidFromBdUK(optJSONObject.optString("msg_from_baidu_uk"));
            }
            if (str.equals(TbadkCoreApplication.getCurrentAccount()) && optJSONObject.has("react_type") && optJSONObject.optInt("react_type") == 1) {
                ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
                if (newMessage == null) {
                    newMessage = new ChatNewMessage();
                    chatRoomInfo.setNewMessage(newMessage);
                }
                if (optInt != 20000 || ChatNewMessage.getSpecialMsgPriority(newMessage.getSpecialType()) > ChatNewMessage.getSpecialMsgPriority(ChatNewMessage.TYPE_EMOJI_MSG)) {
                    return;
                }
                newMessage.setSpecialType(ChatNewMessage.TYPE_EMOJI_MSG);
                newMessage.setSpecialMsg(ChatNewMessage.TYPE_EMOJI_MSG_CONTENT);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_visible", 1);
                jSONObject2.put("is_countable", 0);
                if (!StringUtils.isNull(newMessage.getFromName())) {
                    str2 = newMessage.getFromName() + ": ";
                }
                jSONObject2.put("show_content", str2 + newMessage.getContent());
                optJSONObject.put("msg_conf", jSONObject2);
                chatMsg.setMsgContent(jSONObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull ChatRoomInfo chatRoomInfo, @NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, chatRoomInfo, chatMsg) != null) || TextUtils.isEmpty(chatMsg.getMsgContent())) {
            return;
        }
        try {
            int optInt = new JSONObject(chatMsg.getMsgContent()).optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
            if (newMessage == null) {
                newMessage = new ChatNewMessage();
                chatRoomInfo.setNewMessage(newMessage);
            }
            if (optInt != 7001) {
                if (optInt != 7022 || ChatNewMessage.getSpecialMsgPriority(newMessage.getSpecialType()) > ChatNewMessage.getSpecialMsgPriority("activity")) {
                    return;
                }
                newMessage.setSpecialType("activity");
                newMessage.setSpecialMsg(ChatNewMessage.TYPE_ACTIVITY_MSG_CONTENT);
            } else if (ChatNewMessage.getSpecialMsgPriority(newMessage.getSpecialType()) > ChatNewMessage.getSpecialMsgPriority("notice")) {
            } else {
                newMessage.setSpecialType("notice");
                newMessage.setSpecialMsg(ChatNewMessage.TYPE_NOTICE_MSG_CONTENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void c(@NonNull ChatRoomInfo chatRoomInfo, @NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, chatRoomInfo, chatMsg) == null) {
            int notifyCmd = chatMsg.getNotifyCmd();
            if (notifyCmd == 110) {
                a(chatRoomInfo, chatMsg);
            } else if (notifyCmd == 109) {
                b(chatRoomInfo, chatMsg);
            }
        }
    }

    @Nullable
    public TbBaseMsg f(long j, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, chatMsg)) == null) {
            if (TextUtils.isEmpty(chatMsg.getChatRoomContentExt())) {
                return null;
            }
            return d(chatMsg);
        }
        return (TbBaseMsg) invokeJL.objValue;
    }

    public static long h(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMsg)) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                return System.currentTimeMillis();
            }
            return millis;
        }
        return invokeL.longValue;
    }

    public final TbBaseMsg d(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMsg)) == null) {
            uv8<?, ?> a = cv8.c.a(chatMsg.getClass());
            if (a == null) {
                return null;
            }
            return (TbBaseMsg) aw8.b(a, mv8.a, chatMsg);
        }
        return (TbBaseMsg) invokeL.objValue;
    }

    public boolean e(ChatMsg chatMsg) {
        InterceptResult invokeL;
        TbSysMsg g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg)) == null) {
            if (chatMsg == null || (g = g(chatMsg)) == null || g.getMsgConf() == null || !g.getMsgConf().isVisible()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public TbSysMsg g(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, chatMsg)) == null) {
            if (TextUtils.isEmpty(chatMsg.getMsgContent())) {
                return null;
            }
            try {
                TbSysMsg tbSysMsg = (TbSysMsg) d(chatMsg);
                if (tbSysMsg != null && tbSysMsg.getMsgConf() != null) {
                    if (tbSysMsg.getMsgConf().isVisible()) {
                        return tbSysMsg;
                    }
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return (TbSysMsg) invokeL.objValue;
    }
}
