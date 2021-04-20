package com.baidu.tieba.im.util;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.b.c.e.p.k;
import d.b.h0.r.q.x0;
import d.b.i0.e1.o.a;
import d.b.i0.e1.w.b;
import d.b.i0.e1.w.c;
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
/* loaded from: classes4.dex */
public class MessageUtils {
    public static void assignChatMessage(List<GroupMsgData> list, LinkedList<ChatMessage> linkedList, HashMap<String, GroupMsgData> hashMap, HashMap<String, GroupMsgData> hashMap2, ChatMessage chatMessage, MsgInfo msgInfo, GroupMsgData groupMsgData, Long l) {
        long longValue;
        long longValue2;
        int i;
        VoiceMsgData n;
        if (list == null || linkedList == null || hashMap == null || hashMap2 == null || chatMessage == null || msgInfo == null) {
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
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    TshowInfo tshowInfo = list2.get(i2);
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
            chatMessage.setContent("[" + jsonStrWithObject + "]");
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
            long f2 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (f2 != msgInfo.userId.longValue()) {
                longValue2 = msgInfo.userId.longValue();
            } else {
                longValue2 = msgInfo.toUid.longValue();
            }
            long j = longValue2;
            if (msgInfo == null || msgInfo.userInfo == null) {
                i = 1;
            } else if (f2 != msgInfo.userId.longValue()) {
                i = msgInfo.userInfo.userType.intValue();
            } else {
                i = msgInfo.toUserInfo.userType.intValue();
            }
            if (i == 4) {
                if (groupMsgData != null && groupMsgData.getGroupInfo() != null && l != null) {
                    groupMsgData.getGroupInfo().setGroupId(l.longValue());
                }
                if (d.b.i0.e1.o.c.e().c(chatMessage.getMsgId())) {
                    return;
                }
                long d2 = d.b.i0.e1.o.c.e().d();
                Long l2 = msgInfo.groupId;
                if (l2 == null) {
                    return;
                }
                if (d2 != 0 && l2.longValue() != d.b.i0.e1.o.c.e().d()) {
                    return;
                }
                Long f3 = d.b.i0.e1.o.c.e().f();
                if (f3 != null && msgInfo.msgId != null && f3.longValue() >= msgInfo.msgId.longValue()) {
                    return;
                }
                chatMessage.setIsPushForOperateAccount(true);
                d.b.i0.e1.o.c.e().a(msgInfo.groupId.longValue(), chatMessage.getMsgId());
            }
            if (j != 0) {
                if (linkedList.size() == 0) {
                    linkedList.add(chatMessage);
                } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                    linkedList.remove(0);
                    linkedList.add(chatMessage);
                }
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(4)) {
                    if (hashMap2.get(String.valueOf(j)) == null) {
                        GroupMsgData groupMsgData2 = new GroupMsgData(2012123);
                        groupMsgData2.getGroupInfo().setUserType(i);
                        groupMsgData2.getGroupInfo().setCustomType(4);
                        groupMsgData2.getGroupInfo().setGroupId(j);
                        list.add(groupMsgData2);
                        groupMsgData2.setListMessageData(new LinkedList<>());
                        hashMap2.put(String.valueOf(j), groupMsgData2);
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
                    hashMap2.get(String.valueOf(j)).getListMessage().add(chatMessage);
                }
            }
        } else if (chatMessage instanceof PersonalChatMessage) {
            if (d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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

    public static void createGroupChatMessage(int i, String str, long j) {
        createGroupChatMessage(d.b.i0.e1.k.b.o().t(String.valueOf(j), 1), i, str, j);
    }

    public static void createPersonalChatMessage(int i, String str, long j, String str2, String str3, String str4) {
        createPersonalChatMessage(d.b.i0.e1.k.b.o().t(String.valueOf(j), 2), i, str, j, str2, str3, str4);
    }

    public static void generatePushData(List<GroupMsgData> list, int i, List<MsgInfo> list2, Long l) {
        int i2;
        ChatMessage obtainMessage;
        if (list2 == null || list2.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        GroupMsgData obtainGroupData = obtainGroupData(i);
        if (obtainGroupData == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(obtainGroupData.getGroupInfo().getCustomType())) {
            list.add(obtainGroupData);
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            obtainGroupData.setListMessageData(linkedList);
            int size = list2.size();
            int i3 = 0;
            while (i3 < size) {
                MsgInfo msgInfo = list2.get(i3);
                if (msgInfo != null) {
                    try {
                        obtainMessage = obtainMessage(i);
                    } catch (Exception e2) {
                        e = e2;
                        i2 = i3;
                    }
                    if (obtainMessage != null) {
                        i2 = i3;
                        try {
                            assignChatMessage(list, linkedList, hashMap, hashMap2, obtainMessage, msgInfo, obtainGroupData, l);
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.e(e);
                            i3 = i2 + 1;
                        }
                        i3 = i2 + 1;
                    }
                }
                i2 = i3;
                i3 = i2 + 1;
            }
        }
    }

    public static x0 generatePushNotifyData(MsgInfo msgInfo) {
        String str;
        String str2;
        UserInfo userInfo;
        String str3;
        String str4;
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
                            return new x0(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
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
                return new x0(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
            }
        }
        return null;
    }

    public static long getTaskId(MsgInfo msgInfo) {
        if (msgInfo == null) {
            return 0L;
        }
        if (!TextUtils.isEmpty(msgInfo.content)) {
            try {
                JSONArray jSONArray = new JSONArray(msgInfo.content);
                if (jSONArray.length() > 0) {
                    long f2 = d.b.c.e.m.b.f(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                    if (f2 > 0) {
                        return f2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return msgInfo.taskId.longValue();
    }

    public static void makeNewServiceId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        if (imMessageCenterPojo == null || list == null || list.size() == 0) {
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
        if (imMessageCenterPojo == null || list == null || list.size() == 0) {
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
        LinkedList<ChatMessage> listMessage;
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
            return null;
        }
        return makeNewpushGroupRepair(groupMsgData.getGroupInfo().getGroupId(), groupMsgData.getGroupInfo().getUserType(), listMessage.get(0).getSid() - 1, 0L, listMessage.get(0).getMsgId());
    }

    public static NewpushRepair makeNewpushRepair(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray != null && longSparseArray.size() != 0) {
            NewpushRepair.Builder builder = new NewpushRepair.Builder();
            for (int i = 0; i < longSparseArray.size(); i++) {
                NewpushGroupRepair j = a.i().j(longSparseArray.keyAt(i));
                if (j != null) {
                    if (builder.groups == null) {
                        builder.groups = new ArrayList();
                    }
                    builder.groups.add(j);
                }
            }
            List<NewpushGroupRepair> list = builder.groups;
            if (list != null && list.size() > 0) {
                return builder.build(false);
            }
        }
        return null;
    }

    public static GroupMsgData obtainGroupData(int i) {
        GroupMsgData groupMsgData;
        if (i == 8) {
            groupMsgData = new GroupMsgData(2012124);
            groupMsgData.getGroupInfo().setCustomType(5);
        } else if (i != 30) {
            switch (i) {
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
                    switch (i) {
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
            groupMsgData.getGroupInfo().setGroupType(i);
        }
        return groupMsgData;
    }

    public static ChatMessage obtainMessage(int i) {
        if (i != 8) {
            if (i != 30) {
                switch (i) {
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
                        switch (i) {
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

    public static void sendHasReadMessage(String str, int i) {
        ImMessageCenterPojo i2;
        if (StringUtils.isNull(str) || i != 2 || (i2 = d.b.i0.e1.k.b.o().i(str, 2)) == null) {
            return;
        }
        long pulled_msgId = i2.getPulled_msgId();
        if (pulled_msgId > i2.getSent_msgId()) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(b.c(pulled_msgId), Long.parseLong(str));
            if (MessageManager.getInstance().getSocketClient().o(requestPersonalMsgReadMessage)) {
                return;
            }
            MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
        }
    }

    public static void updateGroupNotExist(Bundle bundle) {
        if (bundle != null && bundle.containsKey(TbEnum.SystemMessage.KEY_GROUP_ID) && bundle.containsKey("type")) {
            long j = bundle.getLong(TbEnum.SystemMessage.KEY_GROUP_ID);
            int i = bundle.getInt("type");
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            if (bundle.containsKey("lastMid")) {
                imMessageCenterPojo.setPulled_msgId(b.a(bundle.getLong("lastMid") - 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public static void createGroupChatMessage(long j, int i, String str, long j2) {
        long j3;
        if (StringUtils.isNull(str)) {
            return;
        }
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        groupChatMessage.setGroupId(String.valueOf(j2));
        groupChatMessage.setMsgType(i);
        groupChatMessage.setContent(str);
        groupChatMessage.setCustomGroupType(1);
        groupChatMessage.setRecordId(j);
        groupChatMessage.setMsgId(j);
        groupChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        groupChatMessage.setUserInfo(userData);
        try {
            j3 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception unused) {
            j3 = 0;
        }
        groupChatMessage.setUserId(j3);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        groupChatMessage.setLocalData(msgLocalData);
        d.b.i0.e1.s.a.j().t(groupChatMessage);
    }

    public static void createPersonalChatMessage(long j, int i, String str, long j2, String str2, String str3, String str4) {
        long j3;
        if (StringUtils.isNull(str)) {
            return;
        }
        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
        personalChatMessage.setBornTime(System.currentTimeMillis());
        personalChatMessage.setToUserId(j2);
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(j2));
        userData.setUserName(str2);
        userData.setName_show(str3);
        userData.setPortrait(str4);
        personalChatMessage.setToUserInfo(userData);
        personalChatMessage.setIsFriend(1);
        personalChatMessage.setMsgType(i);
        personalChatMessage.setContent(str);
        personalChatMessage.setCustomGroupType(2);
        personalChatMessage.setRecordId(j);
        personalChatMessage.setMsgId(j);
        personalChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData2 = new UserData();
        userData2.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData2.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData2.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        personalChatMessage.setUserInfo(userData2);
        try {
            j3 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception unused) {
            j3 = 0;
        }
        personalChatMessage.setUserId(j3);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        personalChatMessage.setLocalData(msgLocalData);
        d.b.i0.e1.s.a.j().t(personalChatMessage);
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(long j, int i, long j2, long j3, long j4) {
        NewpushGroupRepair.Builder builder = new NewpushGroupRepair.Builder();
        builder.gid = Long.valueOf(j);
        builder.gtype = Integer.valueOf(i);
        builder.startSid = Long.valueOf(j2);
        builder.endSid = Long.valueOf(j3);
        builder.fromUid = Long.valueOf(j);
        builder.fromUType = Integer.valueOf(i);
        builder.lastMid = Long.valueOf(j4);
        return builder.build(false);
    }
}
