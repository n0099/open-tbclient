package com.baidu.tieba.im.util;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.o0.s.q.z0;
import c.a.p0.j1.o.a;
import c.a.p0.j1.w.b;
import c.a.p0.j1.w.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import protobuf.MsgInfo;
import protobuf.NewpushGroupRepair;
import protobuf.NewpushRepair;
import protobuf.TshowInfo;
import protobuf.UserInfo;
/* loaded from: classes7.dex */
public class MessageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void assignChatMessage(List<GroupMsgData> list, LinkedList<ChatMessage> linkedList, HashMap<String, GroupMsgData> hashMap, HashMap<String, GroupMsgData> hashMap2, ChatMessage chatMessage, MsgInfo msgInfo, GroupMsgData groupMsgData, Long l) {
        long longValue;
        long longValue2;
        int i2;
        VoiceMsgData n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{list, linkedList, hashMap, hashMap2, chatMessage, msgInfo, groupMsgData, l}) == null) || list == null || linkedList == null || hashMap == null || hashMap2 == null || chatMessage == null || msgInfo == null) {
            return;
        }
        long a2 = b.a(msgInfo.msgId.longValue());
        chatMessage.setMsgId(a2);
        chatMessage.setSid(msgInfo.sid.longValue());
        chatMessage.setGroupId(String.valueOf(msgInfo.groupId));
        chatMessage.setMsgType(msgInfo.msgType.intValue());
        long longValue3 = msgInfo.userId.longValue();
        chatMessage.setUserId(longValue3);
        if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
            chatMessage.setRecordId(msgInfo.recordId.longValue());
        } else {
            chatMessage.setRecordId(a2);
        }
        UserData userData = new UserData();
        chatMessage.setUserInfo(userData);
        UserInfo userInfo = msgInfo.userInfo;
        if (userInfo != null) {
            List<TshowInfo> list2 = userInfo.tshowIcon;
            if (list2 != null) {
                ArrayList<IconData> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    TshowInfo tshowInfo = list2.get(i3);
                    arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                }
                userData.setTShowInfo(arrayList);
            }
            chatMessage.getUserInfo().setUserId(String.valueOf(userInfo.userId));
            chatMessage.getUserInfo().setUserName(userInfo.userName);
            chatMessage.getUserInfo().setPortrait(userInfo.portrait);
            chatMessage.getUserInfo().setSex(userInfo.sex.intValue());
            chatMessage.getUserInfo().setUserType(userInfo.userType.intValue());
        }
        chatMessage.setToUserInfo(new UserData());
        UserInfo userInfo2 = msgInfo.toUserInfo;
        if (userInfo2 != null) {
            chatMessage.getToUserInfo().setUserId(String.valueOf(userInfo2.userId));
            chatMessage.getToUserInfo().setUserName(userInfo2.userName);
            chatMessage.getToUserInfo().setName_show(userInfo2.userNameShow);
            chatMessage.getToUserInfo().setPortrait(userInfo2.portrait);
            chatMessage.getToUserInfo().setSex(userInfo2.sex.intValue());
            chatMessage.getToUserInfo().setUserType(userInfo2.userType.intValue());
        }
        chatMessage.setToUserId(msgInfo.toUid.longValue());
        chatMessage.setContent(msgInfo.content);
        if (msgInfo.msgType.intValue() == 3 && (n = c.n(chatMessage)) != null) {
            if (c.p(chatMessage)) {
                n.setHas_read(1);
            } else {
                n.setHas_read(0);
            }
            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
            chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
        }
        chatMessage.setTime(msgInfo.createTime.intValue());
        chatMessage.setIsFriend(msgInfo.isFriend.intValue());
        chatMessage.setFollowStatus(msgInfo.isFriend.intValue());
        chatMessage.setLink(msgInfo.link);
        chatMessage.setStat(msgInfo.stat);
        chatMessage.setTaskId(msgInfo.taskId.longValue());
        chatMessage.setServiceId(msgInfo.serviceId.longValue());
        if (chatMessage.getMsgType() == 9 && chatMessage.getContent() != null) {
            try {
                JSONArray jSONArray = new JSONArray(chatMessage.getContent());
                if (jSONArray.length() >= 2) {
                    String optString = jSONArray.optString(0);
                    int optInt = jSONArray.optInt(1);
                    if (1 != optInt && 4 != optInt) {
                        chatMessage.setMsgType(1);
                        chatMessage.setContent(optString);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        if (chatMessage instanceof OfficialChatMessage) {
            long f2 = c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (f2 != msgInfo.userId.longValue()) {
                longValue2 = msgInfo.userId.longValue();
            } else {
                longValue2 = msgInfo.toUid.longValue();
            }
            long j2 = longValue2;
            if (msgInfo == null || msgInfo.userInfo == null) {
                i2 = 1;
            } else if (f2 != msgInfo.userId.longValue()) {
                i2 = msgInfo.userInfo.userType.intValue();
            } else {
                i2 = msgInfo.toUserInfo.userType.intValue();
            }
            if (i2 == 4) {
                if (groupMsgData != null && groupMsgData.getGroupInfo() != null && l != null) {
                    groupMsgData.getGroupInfo().setGroupId(l.longValue());
                }
                if (c.a.p0.j1.o.c.e().c(chatMessage.getMsgId())) {
                    return;
                }
                long d2 = c.a.p0.j1.o.c.e().d();
                Long l2 = msgInfo.groupId;
                if (l2 == null) {
                    return;
                }
                if (d2 != 0 && l2.longValue() != c.a.p0.j1.o.c.e().d()) {
                    return;
                }
                Long f3 = c.a.p0.j1.o.c.e().f();
                if (f3 != null && msgInfo.msgId != null && f3.longValue() >= msgInfo.msgId.longValue()) {
                    return;
                }
                chatMessage.setIsPushForOperateAccount(true);
                c.a.p0.j1.o.c.e().a(msgInfo.groupId.longValue(), chatMessage.getMsgId());
            }
            if (j2 != 0) {
                if (linkedList.size() == 0) {
                    linkedList.add(chatMessage);
                } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                    linkedList.remove(0);
                    linkedList.add(chatMessage);
                }
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(4)) {
                    if (hashMap2.get(String.valueOf(j2)) == null) {
                        GroupMsgData groupMsgData2 = new GroupMsgData(2012123);
                        groupMsgData2.getGroupInfo().setUserType(i2);
                        groupMsgData2.getGroupInfo().setCustomType(4);
                        groupMsgData2.getGroupInfo().setGroupId(j2);
                        list.add(groupMsgData2);
                        groupMsgData2.setListMessageData(new LinkedList<>());
                        hashMap2.put(String.valueOf(j2), groupMsgData2);
                        StatisticItem statisticItem = new StatisticItem("official_message_receive");
                        statisticItem.param("msg_id", msgInfo.msgId.longValue());
                        statisticItem.param("official_id", msgInfo.userId.longValue());
                        UserInfo userInfo3 = msgInfo.userInfo;
                        if (userInfo3 != null) {
                            statisticItem.param("official_type", userInfo3.userType.intValue());
                        }
                        statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                        statisticItem.param("task_id", getTaskId(msgInfo));
                        TiebaStatic.log(statisticItem);
                    }
                    hashMap2.get(String.valueOf(j2)).getListMessage().add(chatMessage);
                }
            }
        } else if (chatMessage instanceof PersonalChatMessage) {
            if (c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                longValue = msgInfo.userId.longValue();
            } else {
                longValue = msgInfo.toUid.longValue();
            }
            if (longValue != 0) {
                if (linkedList.size() == 0) {
                    linkedList.add(chatMessage);
                } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                    linkedList.remove(0);
                    linkedList.add(chatMessage);
                }
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(2)) {
                    if (hashMap.get(String.valueOf(longValue)) == null) {
                        GroupMsgData groupMsgData3 = new GroupMsgData(2012121);
                        groupMsgData3.getGroupInfo().setCustomType(2);
                        groupMsgData3.getGroupInfo().setGroupId(longValue);
                        list.add(groupMsgData3);
                        groupMsgData3.setListMessageData(new LinkedList<>());
                        hashMap.put(String.valueOf(longValue), groupMsgData3);
                    }
                    hashMap.get(String.valueOf(longValue)).getListMessage().add(chatMessage);
                }
            }
        } else {
            linkedList.add(chatMessage);
        }
    }

    public static void createGroupChatMessage(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            createGroupChatMessage(c.a.p0.j1.k.b.o().t(String.valueOf(j2), 1), i2, str, j2);
        }
    }

    public static void createPersonalChatMessage(int i2, String str, long j2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2, str3, str4}) == null) {
            createPersonalChatMessage(c.a.p0.j1.k.b.o().t(String.valueOf(j2), 2), i2, str, j2, str2, str3, str4);
        }
    }

    public static void generatePushData(List<GroupMsgData> list, int i2, List<MsgInfo> list2, Long l) {
        int i3;
        ChatMessage obtainMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(AdIconUtil.AD_TEXT_ID, null, list, i2, list2, l) == null) || list2 == null || list2.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        GroupMsgData obtainGroupData = obtainGroupData(i2);
        if (obtainGroupData == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(obtainGroupData.getGroupInfo().getCustomType())) {
            list.add(obtainGroupData);
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            obtainGroupData.setListMessageData(linkedList);
            int size = list2.size();
            int i4 = 0;
            while (i4 < size) {
                MsgInfo msgInfo = list2.get(i4);
                if (msgInfo != null) {
                    try {
                        obtainMessage = obtainMessage(i2);
                    } catch (Exception e2) {
                        e = e2;
                        i3 = i4;
                    }
                    if (obtainMessage != null) {
                        i3 = i4;
                        try {
                            assignChatMessage(list, linkedList, hashMap, hashMap2, obtainMessage, msgInfo, obtainGroupData, l);
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.e(e);
                            i4 = i3 + 1;
                        }
                        i4 = i3 + 1;
                    }
                }
                i3 = i4;
                i4 = i3 + 1;
            }
        }
    }

    public static z0 generatePushNotifyData(MsgInfo msgInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        UserInfo userInfo;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, msgInfo)) == null) {
            String str5 = "";
            if (msgInfo != null && !k.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() == 1) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        str = jSONObject.optString("title", null);
                        try {
                            str4 = jSONObject.optString("url", null);
                            str5 = str;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            str2 = "";
                            str5 = str;
                            userInfo = msgInfo.userInfo;
                            if (userInfo != null) {
                                str5 = TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{msgInfo.userInfo.userName}) + ZeusCrashHandler.NAME_SEPERATOR + str5;
                            }
                            str3 = str5;
                            if (!k.isEmpty(str3)) {
                                return new z0(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
                            }
                            return null;
                        }
                    } else {
                        str4 = "";
                    }
                    str2 = str4;
                } catch (Exception e3) {
                    e = e3;
                    str = "";
                }
                userInfo = msgInfo.userInfo;
                if (userInfo != null && !k.isEmpty(userInfo.userName)) {
                    str5 = TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{msgInfo.userInfo.userName}) + ZeusCrashHandler.NAME_SEPERATOR + str5;
                }
                str3 = str5;
                if (!k.isEmpty(str3) && !k.isEmpty(str2)) {
                    return new z0(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
                }
            }
            return null;
        }
        return (z0) invokeL.objValue;
    }

    public static long getTaskId(MsgInfo msgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, msgInfo)) == null) {
            if (msgInfo == null) {
                return 0L;
            }
            if (!TextUtils.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() > 0) {
                        long f2 = c.a.e.e.m.b.f(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                        if (f2 > 0) {
                            return f2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return msgInfo.taskId.longValue();
        }
        return invokeL.longValue;
    }

    public static void makeNewServiceId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null || list.size() == 0) {
            return;
        }
        String serviceId = imMessageCenterPojo.getServiceId();
        StringBuffer stringBuffer = new StringBuffer();
        for (CommonMsgPojo commonMsgPojo : list) {
            stringBuffer.append(commonMsgPojo.getTaskId());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (serviceId != null && serviceId.length() != 0) {
            String str = (serviceId + ",") + stringBuffer.toString();
            String[] split = str.split(",");
            if (split != null && split.length != 0) {
                if (split.length <= 25) {
                    imMessageCenterPojo.setServiceId(str);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int length = split.length - 25; length < split.length; length++) {
                    stringBuffer2.append(split[length]);
                    stringBuffer2.append(",");
                }
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                imMessageCenterPojo.setServiceId(stringBuffer2.toString());
                return;
            }
            imMessageCenterPojo.setTaskId("");
            return;
        }
        imMessageCenterPojo.setServiceId(stringBuffer.toString());
    }

    public static void makeNewTaskId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null || list.size() == 0) {
            return;
        }
        String taskId = imMessageCenterPojo.getTaskId();
        StringBuffer stringBuffer = new StringBuffer();
        for (CommonMsgPojo commonMsgPojo : list) {
            stringBuffer.append(commonMsgPojo.getTaskId());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (taskId != null && taskId.length() != 0) {
            String str = (taskId + ",") + stringBuffer.toString();
            String[] split = str.split(",");
            if (split != null && split.length != 0) {
                if (split.length <= 25) {
                    imMessageCenterPojo.setTaskId(str);
                    return;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int length = split.length - 25; length < split.length; length++) {
                    stringBuffer2.append(split[length]);
                    stringBuffer2.append(",");
                }
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                imMessageCenterPojo.setTaskId(stringBuffer2.toString());
                return;
            }
            imMessageCenterPojo.setTaskId("");
            return;
        }
        imMessageCenterPojo.setTaskId(stringBuffer.toString());
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, groupMsgData)) == null) {
            if (groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
                return null;
            }
            return makeNewpushGroupRepair(groupMsgData.getGroupInfo().getGroupId(), groupMsgData.getGroupInfo().getUserType(), listMessage.get(0).getSid() - 1, 0L, listMessage.get(0).getMsgId());
        }
        return (NewpushGroupRepair) invokeL.objValue;
    }

    public static NewpushRepair makeNewpushRepair(LongSparseArray<Long> longSparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, longSparseArray)) == null) {
            if (longSparseArray != null && longSparseArray.size() != 0) {
                NewpushRepair.Builder builder = new NewpushRepair.Builder();
                for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                    NewpushGroupRepair j2 = a.i().j(longSparseArray.keyAt(i2));
                    if (j2 != null) {
                        if (builder.groups == null) {
                            builder.groups = new ArrayList();
                        }
                        builder.groups.add(j2);
                    }
                }
                List<NewpushGroupRepair> list = builder.groups;
                if (list != null && list.size() > 0) {
                    return builder.build(false);
                }
            }
            return null;
        }
        return (NewpushRepair) invokeL.objValue;
    }

    public static GroupMsgData obtainGroupData(int i2) {
        InterceptResult invokeI;
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            if (i2 == 8) {
                groupMsgData = new GroupMsgData(2012124);
                groupMsgData.getGroupInfo().setCustomType(5);
            } else if (i2 != 30) {
                switch (i2) {
                    case 1:
                        groupMsgData = new GroupMsgData(2012120);
                        groupMsgData.getGroupInfo().setCustomType(-2);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        groupMsgData = new GroupMsgData(2012125);
                        groupMsgData.getGroupInfo().setCustomType(1);
                        break;
                    case 6:
                        groupMsgData = new GroupMsgData(2012128);
                        groupMsgData.getGroupInfo().setCustomType(-1);
                        break;
                    default:
                        switch (i2) {
                            case 10:
                                groupMsgData = new GroupMsgData(2012126);
                                groupMsgData.getGroupInfo().setCustomType(6);
                                break;
                            case 11:
                                groupMsgData = new GroupMsgData(2012126);
                                groupMsgData.getGroupInfo().setCustomType(7);
                                break;
                            case 12:
                                GroupMsgData groupMsgData2 = new GroupMsgData(2012126);
                                groupMsgData2.getGroupInfo().setCustomType(8);
                                groupMsgData = groupMsgData2;
                                break;
                            default:
                                groupMsgData = null;
                                break;
                        }
                }
            } else {
                groupMsgData = new GroupMsgData(2012129);
                groupMsgData.getGroupInfo().setCustomType(-9);
            }
            if (groupMsgData != null) {
                groupMsgData.getGroupInfo().setGroupType(i2);
            }
            return groupMsgData;
        }
        return (GroupMsgData) invokeI.objValue;
    }

    public static ChatMessage obtainMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) {
            if (i2 != 8) {
                if (i2 != 30) {
                    switch (i2) {
                        case 1:
                            return new SystemMessage();
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            return new GroupChatMessage();
                        case 6:
                            return new PersonalChatMessage();
                        default:
                            switch (i2) {
                                case 10:
                                case 11:
                                case 12:
                                    return new YYMessage();
                                default:
                                    return null;
                            }
                    }
                }
                return new OfficialChatMessage();
            }
            return new NotifyChatMessage();
        }
        return (ChatMessage) invokeI.objValue;
    }

    public static void sendHasReadMessage(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65551, null, str, i2) == null) || StringUtils.isNull(str) || i2 != 2 || (i3 = c.a.p0.j1.k.b.o().i(str, 2)) == null) {
            return;
        }
        long pulled_msgId = i3.getPulled_msgId();
        if (pulled_msgId > i3.getSent_msgId()) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(b.c(pulled_msgId), Long.parseLong(str));
            if (MessageManager.getInstance().getSocketClient().o(requestPersonalMsgReadMessage)) {
                return;
            }
            MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
        }
    }

    public static void updateGroupNotExist(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, bundle) == null) && bundle != null && bundle.containsKey(TbEnum.SystemMessage.KEY_GROUP_ID) && bundle.containsKey("type")) {
            long j2 = bundle.getLong(TbEnum.SystemMessage.KEY_GROUP_ID);
            int i2 = bundle.getInt("type");
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i2);
            imMessageCenterPojo.setGid(String.valueOf(j2));
            if (bundle.containsKey("lastMid")) {
                imMessageCenterPojo.setPulled_msgId(b.a(bundle.getLong("lastMid") - 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public static void createGroupChatMessage(long j2, int i2, String str, long j3) {
        long j4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str, Long.valueOf(j3)}) == null) || StringUtils.isNull(str)) {
            return;
        }
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        groupChatMessage.setGroupId(String.valueOf(j3));
        groupChatMessage.setMsgType(i2);
        groupChatMessage.setContent(str);
        groupChatMessage.setCustomGroupType(1);
        groupChatMessage.setRecordId(j2);
        groupChatMessage.setMsgId(j2);
        groupChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        groupChatMessage.setUserInfo(userData);
        try {
            j4 = c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception unused) {
            j4 = 0;
        }
        groupChatMessage.setUserId(j4);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        groupChatMessage.setLocalData(msgLocalData);
        c.a.p0.j1.s.a.j().t(groupChatMessage);
    }

    public static void createPersonalChatMessage(long j2, int i2, String str, long j3, String str2, String str3, String str4) {
        long j4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str, Long.valueOf(j3), str2, str3, str4}) == null) || StringUtils.isNull(str)) {
            return;
        }
        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
        personalChatMessage.setBornTime(System.currentTimeMillis());
        personalChatMessage.setToUserId(j3);
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(j3));
        userData.setUserName(str2);
        userData.setName_show(str3);
        userData.setPortrait(str4);
        personalChatMessage.setToUserInfo(userData);
        personalChatMessage.setIsFriend(1);
        personalChatMessage.setMsgType(i2);
        personalChatMessage.setContent(str);
        personalChatMessage.setCustomGroupType(2);
        personalChatMessage.setRecordId(j2);
        personalChatMessage.setMsgId(j2);
        personalChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData2 = new UserData();
        userData2.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData2.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData2.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        personalChatMessage.setUserInfo(userData2);
        try {
            j4 = c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception unused) {
            j4 = 0;
        }
        personalChatMessage.setUserId(j4);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        personalChatMessage.setLocalData(msgLocalData);
        c.a.p0.j1.s.a.j().t(personalChatMessage);
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(long j2, int i2, long j3, long j4, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})) == null) {
            NewpushGroupRepair.Builder builder = new NewpushGroupRepair.Builder();
            builder.gid = Long.valueOf(j2);
            builder.gtype = Integer.valueOf(i2);
            builder.startSid = Long.valueOf(j3);
            builder.endSid = Long.valueOf(j4);
            builder.fromUid = Long.valueOf(j2);
            builder.fromUType = Integer.valueOf(i2);
            builder.lastMid = Long.valueOf(j5);
            return builder.build(false);
        }
        return (NewpushGroupRepair) invokeCommon.objValue;
    }
}
