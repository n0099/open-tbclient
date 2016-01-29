package com.baidu.tieba.im.util;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.c.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import protobuf.MsgInfo;
import protobuf.NewpushGroupRepair;
import protobuf.NewpushRepair;
import protobuf.TshowInfo;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class MessageUtils {
    public static void createPersonalChatMessage(int i, String str, long j, String str2, String str3) {
        createPersonalChatMessage(b.ady().U(String.valueOf(j), 2), i, str, j, str2, str3);
    }

    public static void createPersonalChatMessage(long j, int i, String str, long j2, String str2, String str3) {
        long j3;
        if (!StringUtils.isNull(str)) {
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            personalChatMessage.setBornTime(System.currentTimeMillis());
            personalChatMessage.setToUserId(j2);
            UserData userData = new UserData();
            userData.setUserId(String.valueOf(j2));
            userData.setUserName(str2);
            userData.setPortrait(str3);
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
                j3 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception e) {
                j3 = 0;
            }
            personalChatMessage.setUserId(j3);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            personalChatMessage.setLocalData(msgLocalData);
            a.aeO().n(personalChatMessage);
        }
    }

    public static void createGroupChatMessage(int i, String str, long j) {
        createGroupChatMessage(b.ady().U(String.valueOf(j), 1), i, str, j);
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
                j3 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
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
            a.aeO().n(groupChatMessage);
        }
    }

    public static void sendHasReadMessage(String str, int i) {
        ImMessageCenterPojo P;
        if (!StringUtils.isNull(str) && i == 2 && (P = b.ady().P(str, 2)) != null) {
            long pulled_msgId = P.getPulled_msgId();
            if (pulled_msgId > P.getSent_msgId()) {
                RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(g.bf(pulled_msgId), Long.parseLong(str));
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
            case 7:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD);
                groupMsgData.getGroupInfo().setCustomType(3);
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
            case 21:
                groupMsgData = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD);
                groupMsgData.getGroupInfo().setCustomType(9);
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
            case 7:
                return new SnapChatMessage();
            case 8:
                return new NotifyChatMessage();
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
            default:
                return null;
            case 10:
            case 11:
            case 12:
                return new YYMessage();
            case 21:
                return new GroupChatMessage();
            case 30:
                return new OfficialChatMessage();
        }
    }

    public static void assignChatMessage(List<GroupMsgData> list, LinkedList<ChatMessage> linkedList, HashMap<String, GroupMsgData> hashMap, HashMap<String, GroupMsgData> hashMap2, ChatMessage chatMessage, MsgInfo msgInfo, GroupMsgData groupMsgData, Long l) {
        long longValue;
        long longValue2;
        int i;
        VoiceMsgData v;
        if (list != null && linkedList != null && hashMap != null && hashMap2 != null && chatMessage != null && msgInfo != null) {
            BdLog.e("enter");
            long be = g.be(msgInfo.msgId.longValue());
            chatMessage.setMsgId(be);
            chatMessage.setSid(msgInfo.sid.longValue());
            chatMessage.setGroupId(String.valueOf(msgInfo.groupId));
            chatMessage.setMsgType(msgInfo.msgType.intValue());
            long longValue3 = msgInfo.userId.longValue();
            chatMessage.setUserId(longValue3);
            if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                chatMessage.setRecordId(msgInfo.recordId.longValue());
            } else {
                chatMessage.setRecordId(be);
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
                chatMessage.getToUserInfo().setPortrait(userInfo2.portrait);
                chatMessage.getToUserInfo().setSex(userInfo2.sex.intValue());
                chatMessage.getToUserInfo().setUserType(userInfo2.userType.intValue());
            }
            chatMessage.setToUserId(msgInfo.toUid.longValue());
            chatMessage.setContent(msgInfo.content);
            if (msgInfo.msgType.intValue() == 3 && (v = h.v(chatMessage)) != null) {
                if (h.s(chatMessage)) {
                    v.setHas_read(1);
                } else {
                    v.setHas_read(0);
                }
                chatMessage.setContent("[" + i.jsonStrWithObject(v) + "]");
            }
            chatMessage.setTime(msgInfo.createTime.intValue());
            BdLog.e("msg.createTime " + msgInfo.createTime);
            chatMessage.setIsFriend(msgInfo.isFriend.intValue());
            chatMessage.setLink(msgInfo.link);
            chatMessage.setStat(msgInfo.stat);
            chatMessage.setTaskId(msgInfo.taskId.longValue());
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
                long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                BdLog.e("selfId " + c + ", msg.userId " + msgInfo.userId);
                if (c != msgInfo.userId.longValue()) {
                    longValue2 = msgInfo.userId.longValue();
                } else {
                    longValue2 = msgInfo.toUid.longValue();
                }
                if (msgInfo == null || msgInfo.userInfo == null) {
                    i = 1;
                } else if (c != msgInfo.userId.longValue()) {
                    i = msgInfo.userInfo.userType.intValue();
                } else {
                    i = msgInfo.toUserInfo.userType.intValue();
                }
                if (i == 4) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null && l != null) {
                        groupMsgData.getGroupInfo().setGroupId(l.longValue());
                    }
                    if (!com.baidu.tieba.im.push.f.aev().bb(chatMessage.getMsgId())) {
                        int gid = com.baidu.tieba.im.push.f.aev().getGid();
                        if (msgInfo.groupId != null) {
                            if (gid == 0 || msgInfo.groupId.intValue() == com.baidu.tieba.im.push.f.aev().getGid()) {
                                Long aew = com.baidu.tieba.im.push.f.aev().aew();
                                if (aew == null || msgInfo.msgId == null || aew.longValue() < msgInfo.msgId.longValue()) {
                                    chatMessage.setIsPushForOperateAccount(true);
                                    com.baidu.tieba.im.push.f.aev().g(msgInfo.groupId.intValue(), chatMessage.getMsgId());
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
                BdLog.e("fid is " + longValue2);
                if (longValue2 != 0) {
                    if (linkedList.size() == 0) {
                        linkedList.add(chatMessage);
                    } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                        linkedList.remove(0);
                        linkedList.add(chatMessage);
                    }
                    if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().bv(4)) {
                        if (hashMap2.get(String.valueOf(longValue2)) == null) {
                            GroupMsgData groupMsgData2 = new GroupMsgData(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD);
                            groupMsgData2.getGroupInfo().setUserType(i);
                            BdLog.e("userType " + i);
                            groupMsgData2.getGroupInfo().setCustomType(4);
                            groupMsgData2.getGroupInfo().setGroupId(longValue2);
                            list.add(groupMsgData2);
                            groupMsgData2.setListMessageData(new LinkedList<>());
                            hashMap2.put(String.valueOf(longValue2), groupMsgData2);
                        }
                        hashMap2.get(String.valueOf(longValue2)).getListMessage().add(chatMessage);
                    }
                }
            } else if (chatMessage instanceof PersonalChatMessage) {
                if (com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                    if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().bv(2)) {
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

    public static void updateGroupNotExist(Bundle bundle) {
        if (bundle != null && bundle.containsKey("groupId") && bundle.containsKey("type")) {
            long j = bundle.getLong("groupId");
            int i = bundle.getInt("type");
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            if (bundle.containsKey("lastMid")) {
                imMessageCenterPojo.setPulled_msgId(g.be(bundle.getLong("lastMid") - 1));
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
        builder.gid = Integer.valueOf((int) j);
        builder.gtype = Integer.valueOf(i);
        builder.startSid = Long.valueOf(j2);
        builder.endSid = Long.valueOf(j3);
        builder.fromUid = Long.valueOf(j);
        builder.fromUType = Integer.valueOf(i);
        builder.lastMid = Long.valueOf(j4);
        BdLog.e("fromUid " + builder.fromUid + ", fromUType " + builder.fromUType);
        return builder.build(false);
    }

    public static NewpushRepair makeNewpushRepair(SparseArray<Long> sparseArray) {
        if (sparseArray == null || sparseArray.size() == 0) {
            BdLog.e("pullMsgIds == null");
            return null;
        }
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        for (int i = 0; i < sparseArray.size(); i++) {
            NewpushGroupRepair aZ = com.baidu.tieba.im.push.a.aet().aZ(sparseArray.keyAt(i));
            if (aZ != null) {
                if (builder.groups == null) {
                    builder.groups = new ArrayList();
                }
                BdLog.e("gid " + aZ.gid + " gtype " + aZ.gtype + " startSid " + aZ.startSid + " endSid " + aZ.endSid + " fromUid " + aZ.fromUid + " fromUType " + aZ.fromUType);
                builder.groups.add(aZ);
            }
        }
        if (builder.groups == null || builder.groups.size() <= 0) {
            return null;
        }
        return builder.build(false);
    }

    public static void generatePushData(List<GroupMsgData> list, int i, List<MsgInfo> list2, Long l) {
        if (list2 == null || list2.size() == 0) {
            BdLog.e("msgInfo null");
            return;
        }
        BdLog.e("enter");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        GroupMsgData obtainGroupData = obtainGroupData(i);
        if (obtainGroupData == null) {
            BdLog.e("obtainGroupData == null !!!!");
        } else if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().bv(obtainGroupData.getGroupInfo().getCustomType())) {
            list.add(obtainGroupData);
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            obtainGroupData.setListMessageData(linkedList);
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                MsgInfo msgInfo = list2.get(i2);
                if (msgInfo != null) {
                    BdLog.e("mi.taskId " + msgInfo.taskId);
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
            String str = String.valueOf(String.valueOf(taskId) + ",") + stringBuffer.toString();
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
}
