package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.f97;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class l97 {
    public static /* synthetic */ Interceptable $ic;
    public static l97 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements f97.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.f97.c
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

    public l97() {
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

    public static synchronized l97 b() {
        InterceptResult invokeV;
        l97 l97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (l97.class) {
                if (a == null) {
                    a = new l97();
                }
                l97Var = a;
            }
            return l97Var;
        }
        return (l97) invokeV.objValue;
    }

    public static void d(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, f97.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            f97.d(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
        }
    }

    public long[] a(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, groupMsgData)) == null) {
            if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                long j = 0;
                long groupId = groupMsgData.getGroupInfo().getGroupId();
                Iterator it = groupMsgData.getListMessage().iterator();
                while (it.hasNext()) {
                    ChatMessage chatMessage = (ChatMessage) it.next();
                    if (chatMessage.getMsgId() > j) {
                        j = chatMessage.getMsgId();
                    }
                }
                return new long[]{groupId, j};
            }
            return null;
        }
        return (long[]) invokeL.objValue;
    }

    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            return inst.loadLong("tb_group_msg_" + j, -1L);
        }
        return invokeJ.longValue;
    }

    public void e(GroupMsgData groupMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, groupMsgData) == null) && groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            Iterator it = groupMsgData.getListMessage().iterator();
            while (it.hasNext()) {
                ChatMessage chatMessage = (ChatMessage) it.next();
                if (!TextUtils.isEmpty(chatMessage.getStat())) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_noti:" + chatMessage.getStat(), "taskId:" + chatMessage.getTaskId() + ";link:" + chatMessage.getLink() + ";uid:" + TbadkCoreApplication.getCurrentAccount());
                }
                if (!TextUtils.isEmpty(chatMessage.getLink()) && !TextUtils.isEmpty(chatMessage.getStat())) {
                    TiebaStatic.pushMsg(chatMessage.getMsgId(), 1, chatMessage.getLink(), chatMessage.getStat());
                }
                CustomMessage customMessage = new CustomMessage(2012100);
                customMessage.setData(new zs4(chatMessage.getMsgId(), chatMessage.getTaskId(), chatMessage.getLink(), chatMessage.getContent(), chatMessage.getStat(), chatMessage.getServiceId()));
                MessageManager.getInstance().sendMessage(customMessage);
            }
            if (groupMsgData.getListMessage().size() > 0) {
                TiebaStatic.saveAndUploadMsg();
            }
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) && !TextUtils.isEmpty(str) && j > 0) {
            TbadkSettings inst = TbadkSettings.getInst();
            inst.saveLong("tb_group_msg_" + str, j);
        }
    }
}
