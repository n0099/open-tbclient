package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.ft8;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class it8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ft8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.ft8.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                boolean isOpen = ChatStatusManager.getInst().getIsOpen(0);
                String curId = ChatStatusManager.getInst().getCurId(0);
                if (TextUtils.isEmpty(str) || !isOpen || !str.equals(curId)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ft8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.ft8.a
        public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMessage, imMessageCenterPojo)) == null) {
                if (chatMessage != null && chatMessage.getMsgType() == 22) {
                    if (rz8.A(chatMessage)) {
                        return true;
                    }
                    long a = it8.a(chatMessage);
                    if (a > imMessageCenterPojo.getRead_msgId()) {
                        imMessageCenterPojo.setRead_msgId(a);
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public static long a(ChatMessage chatMessage) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatMessage)) == null) {
            if (chatMessage == null) {
                return -1L;
            }
            if (chatMessage.getMsgType() == 22) {
                try {
                    String content = chatMessage.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return -1L;
                    }
                    JSONObject jSONObject = new JSONObject(content);
                    String optString = jSONObject.optString("eventId");
                    if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM)) == null || optJSONObject.optLong("groupId") != tw8.j.longValue()) {
                        return -1L;
                    }
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return qz8.a(optJSONObject.optLong("readMsgId"));
        }
        return invokeL.longValue;
    }

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, ft8.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            ft8.e(groupMsgData, imMessageCenterPojo, bVar, new a(), ChatStatusManager.getInst().getIsOpen(5), new b());
        }
    }

    public static void c(GroupMsgData groupMsgData) {
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, groupMsgData) != null) || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
            return;
        }
        for (int i = 0; i < listMessage.size(); i++) {
            try {
                if (new JSONObject(listMessage.get(i).getContent()).optString("eventId").equals(TbEnum.SystemMessage.EVENT_ID_CYBER_VIOLENCE)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_CYBER_VIOLENCE_MESSAGE_RECEIVER_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            } catch (Exception unused) {
            }
        }
    }
}
