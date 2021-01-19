package com.baidu.tieba.im.util;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes.dex */
public class MessageUtils {
    public static void createPersonalChatMessage(int i, String str, long j, String str2, String str3, String str4) {
        createPersonalChatMessage(com.baidu.tieba.im.memorycache.b.cUG().bw(String.valueOf(j), 2), i, str, j, str2, str3, str4);
    }

    public static void createPersonalChatMessage(long j, int i, String str, long j2, String str2, String str3, String str4) {
        if (!StringUtils.isNull(str)) {
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
            long j3 = 0;
            try {
                j3 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception e) {
            }
            personalChatMessage.setUserId(j3);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            personalChatMessage.setLocalData(msgLocalData);
            com.baidu.tieba.im.sendmessage.a.cVQ().m(personalChatMessage);
        }
    }

    public static void createGroupChatMessage(int i, String str, long j) {
        createGroupChatMessage(com.baidu.tieba.im.memorycache.b.cUG().bw(String.valueOf(j), 1), i, str, j);
    }

    public static void createGroupChatMessage(long j, int i, String str, long j2) {
        long j3;
        if (!StringUtils.isNull(str)) {
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
                j3 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception e) {
                j3 = 0;
            }
            groupChatMessage.setUserId(j3);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            groupChatMessage.setLocalData(msgLocalData);
            com.baidu.tieba.im.sendmessage.a.cVQ().m(groupChatMessage);
        }
    }

    public static void sendHasReadMessage(String str, int i) {
        ImMessageCenterPojo bs;
        if (!StringUtils.isNull(str) && i == 2 && (bs = com.baidu.tieba.im.memorycache.b.cUG().bs(str, 2)) != null) {
            long pulled_msgId = bs.getPulled_msgId();
            if (pulled_msgId > bs.getSent_msgId()) {
                RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(b.gZ(pulled_msgId), Long.parseLong(str));
                if (!MessageManager.getInstance().getSocketClient().a(requestPersonalMsgReadMessage)) {
                    MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
                }
            }
        }
    }

    public static GroupMsgData obtainGroupData(int i) {
        GroupMsgData groupMsgData = null;
        switch (i) {
            case 1:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD);
                groupMsgData.getGroupInfo().setCustomType(-2);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(1);
                break;
            case 6:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(-1);
                break;
            case 8:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD);
                groupMsgData.getGroupInfo().setCustomType(5);
                break;
            case 10:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(6);
                break;
            case 11:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(7);
                break;
            case 12:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_YY_CMD);
                groupMsgData.getGroupInfo().setCustomType(8);
                break;
            case 30:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD);
                groupMsgData.getGroupInfo().setCustomType(-9);
                break;
        }
        if (groupMsgData != null) {
            groupMsgData.getGroupInfo().setGroupType(i);
        }
        return groupMsgData;
    }

    public static ChatMessage obtainMessage(int i) {
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
            case 8:
                return new NotifyChatMessage();
            case 10:
            case 11:
            case 12:
                return new YYMessage();
            case 30:
                return new OfficialChatMessage();
            default:
                return null;
        }
    }

    public static void assignChatMessage(List<GroupMsgData> list, LinkedList<ChatMessage> linkedList, HashMap<String, GroupMsgData> hashMap, HashMap<String, GroupMsgData> hashMap2, ChatMessage chatMessage, MsgInfo msgInfo, GroupMsgData groupMsgData, Long l) {
        long longValue;
        long longValue2;
        int i;
        VoiceMsgData u;
        if (list != null && linkedList != null && hashMap != null && hashMap2 != null && chatMessage != null && msgInfo != null) {
            long gY = b.gY(msgInfo.msgId.longValue());
            chatMessage.setMsgId(gY);
            chatMessage.setSid(msgInfo.sid.longValue());
            chatMessage.setGroupId(String.valueOf(msgInfo.groupId));
            chatMessage.setMsgType(msgInfo.msgType.intValue());
            long longValue3 = msgInfo.userId.longValue();
            chatMessage.setUserId(longValue3);
            if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                chatMessage.setRecordId(msgInfo.recordId.longValue());
            } else {
                chatMessage.setRecordId(gY);
            }
            UserData userData = new UserData();
            chatMessage.setUserInfo(userData);
            UserInfo userInfo = msgInfo.userInfo;
            if (userInfo != null) {
                List<TshowInfo> list2 = userInfo.tshowIcon;
                if (list2 != null) {
                    ArrayList<IconData> arrayList = new ArrayList<>();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list2.size()) {
                            break;
                        }
                        TshowInfo tshowInfo = list2.get(i3);
                        arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                        i2 = i3 + 1;
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
            if (msgInfo.msgType.intValue() == 3 && (u = c.u(chatMessage)) != null) {
                if (c.r(chatMessage)) {
                    u.setHas_read(1);
                } else {
                    u.setHas_read(0);
                }
                chatMessage.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
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
                    if (jSONArray != null && jSONArray.length() >= 2) {
                        String optString = jSONArray.optString(0);
                        int optInt = jSONArray.optInt(1);
                        if (1 != optInt && 4 != optInt) {
                            chatMessage.setMsgType(1);
                            chatMessage.setContent(optString);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (chatMessage instanceof OfficialChatMessage) {
                long j = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (j != msgInfo.userId.longValue()) {
                    longValue2 = msgInfo.userId.longValue();
                } else {
                    longValue2 = msgInfo.toUid.longValue();
                }
                if (msgInfo == null || msgInfo.userInfo == null) {
                    i = 1;
                } else if (j != msgInfo.userId.longValue()) {
                    i = msgInfo.userInfo.userType.intValue();
                } else {
                    i = msgInfo.toUserInfo.userType.intValue();
                }
                if (i == 4) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null && l != null) {
                        groupMsgData.getGroupInfo().setGroupId(l.longValue());
                    }
                    if (!com.baidu.tieba.im.push.c.cVu().gU(chatMessage.getMsgId())) {
                        long gid = com.baidu.tieba.im.push.c.cVu().getGid();
                        if (msgInfo.groupId != null) {
                            if (gid == 0 || msgInfo.groupId.longValue() == com.baidu.tieba.im.push.c.cVu().getGid()) {
                                Long cVv = com.baidu.tieba.im.push.c.cVu().cVv();
                                if (cVv == null || msgInfo.msgId == null || cVv.longValue() < msgInfo.msgId.longValue()) {
                                    chatMessage.setIsPushForOperateAccount(true);
                                    com.baidu.tieba.im.push.c.cVu().E(msgInfo.groupId.longValue(), chatMessage.getMsgId());
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (longValue2 != 0) {
                    if (linkedList.size() == 0) {
                        linkedList.add(chatMessage);
                    } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                        linkedList.remove(0);
                        linkedList.add(chatMessage);
                    }
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(4)) {
                        if (hashMap2.get(String.valueOf(longValue2)) == null) {
                            GroupMsgData groupMsgData2 = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD);
                            groupMsgData2.getGroupInfo().setUserType(i);
                            groupMsgData2.getGroupInfo().setCustomType(4);
                            groupMsgData2.getGroupInfo().setGroupId(longValue2);
                            list.add(groupMsgData2);
                            groupMsgData2.setListMessageData(new LinkedList<>());
                            hashMap2.put(String.valueOf(longValue2), groupMsgData2);
                            aq aqVar = new aq("official_message_receive");
                            aqVar.w("msg_id", msgInfo.msgId.longValue());
                            aqVar.w("official_id", msgInfo.userId.longValue());
                            if (msgInfo.userInfo != null) {
                                aqVar.an("official_type", msgInfo.userInfo.userType.intValue());
                            }
                            aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                            aqVar.w("task_id", getTaskId(msgInfo));
                            TiebaStatic.log(aqVar);
                        }
                        hashMap2.get(String.valueOf(longValue2)).getListMessage().add(chatMessage);
                    }
                }
            } else if (chatMessage instanceof PersonalChatMessage) {
                if (com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(2)) {
                        if (hashMap.get(String.valueOf(longValue)) == null) {
                            GroupMsgData groupMsgData3 = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD);
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
    }

    public static long getTaskId(MsgInfo msgInfo) {
        if (msgInfo == null) {
            return 0L;
        }
        if (!TextUtils.isEmpty(msgInfo.content)) {
            try {
                JSONArray jSONArray = new JSONArray(msgInfo.content);
                if (jSONArray.length() > 0) {
                    long j = com.baidu.adp.lib.f.b.toLong(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                    if (j > 0) {
                        return j;
                    }
                }
            } catch (Exception e) {
            }
        }
        return msgInfo.taskId.longValue();
    }

    public static void updateGroupNotExist(Bundle bundle) {
        if (bundle != null && bundle.containsKey(TbEnum.SystemMessage.KEY_GROUP_ID) && bundle.containsKey("type")) {
            long j = bundle.getLong(TbEnum.SystemMessage.KEY_GROUP_ID);
            int i = bundle.getInt("type");
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            if (bundle.containsKey("lastMid")) {
                imMessageCenterPojo.setPulled_msgId(b.gY(bundle.getLong("lastMid") - 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(GroupMsgData groupMsgData) {
        LinkedList<ChatMessage> listMessage;
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
            return null;
        }
        return makeNewpushGroupRepair(groupMsgData.getGroupInfo().getGroupId(), groupMsgData.getGroupInfo().getUserType(), listMessage.get(0).getSid() - 1, 0L, listMessage.get(0).getMsgId());
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

    public static NewpushRepair makeNewpushRepair(LongSparseArray<Long> longSparseArray) {
        if (longSparseArray == null || longSparseArray.size() == 0) {
            return null;
        }
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        for (int i = 0; i < longSparseArray.size(); i++) {
            NewpushGroupRepair gS = com.baidu.tieba.im.push.a.cVs().gS(longSparseArray.keyAt(i));
            if (gS != null) {
                if (builder.groups == null) {
                    builder.groups = new ArrayList();
                }
                builder.groups.add(gS);
            }
        }
        if (builder.groups == null || builder.groups.size() <= 0) {
            return null;
        }
        return builder.build(false);
    }

    public static av generatePushNotifyData(MsgInfo msgInfo) {
        String str;
        if (msgInfo == null || at.isEmpty(msgInfo.content)) {
            return null;
        }
        String str2 = "";
        String str3 = "";
        try {
            JSONArray jSONArray = new JSONArray(msgInfo.content);
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                str2 = jSONObject.optString("title", null);
                str3 = jSONObject.optString("url", null);
            }
            str = str3;
        } catch (Exception e) {
            BdLog.e(e);
            str = "";
        }
        String str4 = (msgInfo.userInfo == null || at.isEmpty(msgInfo.userInfo.userName)) ? str2 : TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{msgInfo.userInfo.userName}) + " : " + str2;
        if (at.isEmpty(str4) || at.isEmpty(str)) {
            return null;
        }
        return new av(0L, msgInfo.taskId.longValue(), str, str4, msgInfo.stat, msgInfo.serviceId.longValue());
    }

    public static void generatePushData(List<GroupMsgData> list, int i, List<MsgInfo> list2, Long l) {
        if (list2 != null && list2.size() != 0) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            GroupMsgData obtainGroupData = obtainGroupData(i);
            if (obtainGroupData != null) {
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(obtainGroupData.getGroupInfo().getCustomType())) {
                    list.add(obtainGroupData);
                    LinkedList<ChatMessage> linkedList = new LinkedList<>();
                    obtainGroupData.setListMessageData(linkedList);
                    int size = list2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MsgInfo msgInfo = list2.get(i2);
                        if (msgInfo != null) {
                            try {
                                ChatMessage obtainMessage = obtainMessage(i);
                                if (obtainMessage != null) {
                                    assignChatMessage(list, linkedList, hashMap, hashMap2, obtainMessage, msgInfo, obtainGroupData, l);
                                }
                            } catch (Exception e) {
                                BdLog.e(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void makeNewTaskId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        if (imMessageCenterPojo != null && list != null && list.size() != 0) {
            String taskId = imMessageCenterPojo.getTaskId();
            StringBuffer stringBuffer = new StringBuffer();
            for (CommonMsgPojo commonMsgPojo : list) {
                stringBuffer.append(commonMsgPojo.getTaskId()).append(",");
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            if (taskId == null || taskId.length() == 0) {
                imMessageCenterPojo.setTaskId(stringBuffer.toString());
                return;
            }
            String str = (taskId + ",") + stringBuffer.toString();
            String[] split = str.split(",");
            if (split == null || split.length == 0) {
                imMessageCenterPojo.setTaskId("");
            } else if (split.length <= 25) {
                imMessageCenterPojo.setTaskId(str);
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int length = split.length - 25; length < split.length; length++) {
                    stringBuffer2.append(split[length]).append(",");
                }
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                imMessageCenterPojo.setTaskId(stringBuffer2.toString());
            }
        }
    }

    public static void makeNewServiceId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        if (imMessageCenterPojo != null && list != null && list.size() != 0) {
            String serviceId = imMessageCenterPojo.getServiceId();
            StringBuffer stringBuffer = new StringBuffer();
            for (CommonMsgPojo commonMsgPojo : list) {
                stringBuffer.append(commonMsgPojo.getTaskId()).append(",");
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            if (serviceId == null || serviceId.length() == 0) {
                imMessageCenterPojo.setServiceId(stringBuffer.toString());
                return;
            }
            String str = (serviceId + ",") + stringBuffer.toString();
            String[] split = str.split(",");
            if (split == null || split.length == 0) {
                imMessageCenterPojo.setTaskId("");
            } else if (split.length <= 25) {
                imMessageCenterPojo.setServiceId(str);
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int length = split.length - 25; length < split.length; length++) {
                    stringBuffer2.append(split[length]).append(",");
                }
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                imMessageCenterPojo.setServiceId(stringBuffer2.toString());
            }
        }
    }
}
