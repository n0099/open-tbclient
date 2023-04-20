package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.ky7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ky7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ky7.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

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
    }

    public static GroupNewsPojo a(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatMessage)) == null) {
            String content = chatMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                if (content.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                    return null;
                }
                String optString = new JSONObject(content).optString("eventId");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
                groupNewsPojo.setOriginalPushMsg(chatMessage);
                return groupNewsPojo;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (GroupNewsPojo) invokeL.objValue;
    }

    public static LinkedList<GroupNewsPojo> b(LinkedList<ChatMessage> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, linkedList)) == null) {
            if (linkedList != null && linkedList.size() != 0) {
                LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
                Iterator<ChatMessage> it = linkedList.iterator();
                while (it.hasNext()) {
                    GroupNewsPojo a2 = a(it.next());
                    if (a2 != null) {
                        linkedList2.add(a2);
                    }
                }
                return linkedList2;
            }
            return null;
        }
        return (LinkedList) invokeL.objValue;
    }

    public static void c(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, ky7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            ky7.d(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
        }
    }

    public static void d(GroupMsgData groupMsgData) {
        LinkedList<GroupNewsPojo> b;
        PushMessage newInstance;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, groupMsgData) == null) && (b = b(groupMsgData.getListMessage())) != null && !b.isEmpty()) {
            long j = 0;
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = b.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    if (parseLong > j) {
                        j = parseLong;
                    }
                }
            }
            cz7.c().i(linkedList);
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
            imMessageCenterPojo.setIs_hidden(1);
            imMessageCenterPojo.setCustomGroupType(-2);
            imMessageCenterPojo.setPulled_msgId(j);
            iz7.f().k(imMessageCenterPojo);
            Iterator<GroupNewsPojo> it2 = b.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null && (newInstance = PushMessage.newInstance(next2)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
                }
            }
        }
    }
}
