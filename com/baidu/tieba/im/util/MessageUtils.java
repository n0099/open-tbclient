package com.baidu.tieba.im.util;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tieba.R;
import com.baidu.tieba.c48;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.baidu.tieba.j05;
import com.baidu.tieba.k38;
import com.baidu.tieba.pg;
import com.baidu.tieba.qi;
import com.baidu.tieba.s58;
import com.baidu.tieba.t58;
import com.baidu.tieba.u38;
import com.baidu.tieba.w38;
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
/* loaded from: classes6.dex */
public class MessageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void assignChatMessage(List<GroupMsgData> list, LinkedList<ChatMessage> linkedList, HashMap<String, GroupMsgData> hashMap, HashMap<String, GroupMsgData> hashMap2, ChatMessage chatMessage, MsgInfo msgInfo, GroupMsgData groupMsgData, Long l) {
        ImShareCardCommonData c;
        long longValue;
        long longValue2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{list, linkedList, hashMap, hashMap2, chatMessage, msgInfo, groupMsgData, l}) == null) && list != null && linkedList != null && hashMap != null && hashMap2 != null && chatMessage != null && msgInfo != null) {
            long a = s58.a(msgInfo.msgId.longValue());
            chatMessage.setMsgId(a);
            chatMessage.setSid(msgInfo.sid.longValue());
            chatMessage.setGroupId(String.valueOf(msgInfo.groupId));
            chatMessage.setMsgType(msgInfo.msgType.intValue());
            long longValue3 = msgInfo.userId.longValue();
            chatMessage.setUserId(longValue3);
            if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                chatMessage.setRecordId(msgInfo.recordId.longValue());
            } else {
                chatMessage.setRecordId(a);
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
            if (msgInfo.msgType.intValue() == 3) {
                VoiceMsgData r = t58.r(chatMessage);
                if (r != null) {
                    if (t58.y(chatMessage)) {
                        r.setHas_read(1);
                    } else {
                        r.setHas_read(0);
                    }
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(r);
                    chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                }
            } else if (msgInfo.msgType.intValue() == 33) {
                ShareForumMsgData e = t58.e(chatMessage);
                if (e != null) {
                    e.setHasRead(t58.y(chatMessage));
                    chatMessage.setContent(OrmObject.jsonStrWithObject(e));
                    chatMessage.setEncodeContent(e.toEncodeContent());
                }
            } else if (msgInfo.msgType.intValue() == 32) {
                ShareThreadMsgData f = t58.f(chatMessage);
                if (f != null) {
                    f.setHasRead(t58.y(chatMessage));
                    chatMessage.setContent(OrmObject.jsonStrWithObject(f));
                    chatMessage.setEncodeContent(f.toEncodeContent());
                }
            } else if (msgInfo.msgType.intValue() == 37) {
                ShareChatroomMsgData d = t58.d(chatMessage);
                if (d != null) {
                    d.setHasRead(t58.y(chatMessage) ? 1 : 0);
                    chatMessage.setContent(OrmObject.jsonStrWithObject(d));
                    chatMessage.setEncodeContent(d.toEncodeContent());
                }
            } else if (msgInfo.msgType.intValue() == 38 && (c = t58.c(chatMessage)) != null) {
                c.setHasRead(t58.y(chatMessage) ? 1 : 0);
                chatMessage.setContent(OrmObject.jsonStrWithObject(c));
                chatMessage.setEncodeContent(c.toEncodeContent());
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
                long g = pg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (g != msgInfo.userId.longValue()) {
                    longValue2 = msgInfo.userId.longValue();
                } else {
                    longValue2 = msgInfo.toUid.longValue();
                }
                long j = longValue2;
                if (msgInfo != null && msgInfo.userInfo != null) {
                    if (g != msgInfo.userId.longValue()) {
                        i = msgInfo.userInfo.userType.intValue();
                    } else {
                        i = msgInfo.toUserInfo.userType.intValue();
                    }
                } else {
                    i = 1;
                }
                if (i == 4) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null && l != null) {
                        groupMsgData.getGroupInfo().setGroupId(l.longValue());
                    }
                    if (w38.e().c(chatMessage.getMsgId())) {
                        return;
                    }
                    long d2 = w38.e().d();
                    Long l2 = msgInfo.groupId;
                    if (l2 != null) {
                        if (d2 == 0 || l2.longValue() == w38.e().d()) {
                            Long f2 = w38.e().f();
                            if (f2 != null && msgInfo.msgId != null && f2.longValue() >= msgInfo.msgId.longValue()) {
                                return;
                            }
                            chatMessage.setIsPushForOperateAccount(true);
                            w38.e().a(msgInfo.groupId.longValue(), chatMessage.getMsgId());
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j != 0) {
                    if (linkedList.size() == 0) {
                        linkedList.add(chatMessage);
                    } else if (linkedList.get(0).getMsgId() < chatMessage.getMsgId()) {
                        linkedList.remove(0);
                        linkedList.add(chatMessage);
                    }
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
            } else if (chatMessage instanceof PersonalChatMessage) {
                if (pg.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
            } else {
                linkedList.add(chatMessage);
            }
        }
    }

    public static void createAndSendPersonalCommonCardChatMessage(@Nullable ShareIMCommonCardData shareIMCommonCardData, long j, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{shareIMCommonCardData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)}) != null) || shareIMCommonCardData == null) {
            return;
        }
        ChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str, str2, str3, z);
        ImShareCardCommonData a = ImShareCardCommonData.Companion.a(shareIMCommonCardData);
        createPersonalChatMessageByToUser.setContent(OrmObject.jsonStrWithObject(a));
        createPersonalChatMessageByToUser.setObjContent(a);
        createPersonalChatMessageByToUser.setMsgType(38);
        createPersonalChatMessageByToUser.setEncodeContent(a.toEncodeContent());
        c48.k().t(createPersonalChatMessageByToUser);
    }

    public static void createAndSendPersonalGroupChatMessage(@Nullable GroupInfoData groupInfoData, long j, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{groupInfoData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)}) != null) || groupInfoData == null) {
            return;
        }
        ChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str, str2, str3, z);
        ShareChatroomMsgData a = ShareChatroomMsgData.Companion.a(groupInfoData);
        createPersonalChatMessageByToUser.setContent(OrmObject.jsonStrWithObject(a));
        createPersonalChatMessageByToUser.setObjContent(a);
        createPersonalChatMessageByToUser.setMsgType(37);
        createPersonalChatMessageByToUser.setEncodeContent(a.toEncodeContent());
        c48.k().t(createPersonalChatMessageByToUser);
    }

    public static long createAndSendPersonalText(@Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str) || j == -1) {
                return -1L;
            }
            PersonalChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str2, str3, str4, z);
            createPersonalChatMessageByToUser.setContent(str);
            createPersonalChatMessageByToUser.setMsgType(1);
            c48.k().t(createPersonalChatMessageByToUser);
            return createPersonalChatMessageByToUser.getMsgId();
        }
        return invokeCommon.longValue;
    }

    public static void createAndSendPersonalTextChatMessage(@Nullable String str, long j, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        PersonalChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str2, str3, str4, z);
        createPersonalChatMessageByToUser.setContent(str);
        createPersonalChatMessageByToUser.setMsgType(1);
        c48.k().t(createPersonalChatMessageByToUser);
    }

    public static void createAndSendPersonalThreadChatMessage(@Nullable ThreadData threadData, long j, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{threadData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)}) != null) || threadData == null) {
            return;
        }
        ChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str, str2, str3, z);
        ShareThreadMsgData ofThreadData = ShareThreadMsgData.ofThreadData(threadData);
        createPersonalChatMessageByToUser.setContent(OrmObject.jsonStrWithObject(ofThreadData));
        createPersonalChatMessageByToUser.setObjContent(ofThreadData);
        createPersonalChatMessageByToUser.setMsgType(32);
        createPersonalChatMessageByToUser.setEncodeContent(ofThreadData.toEncodeContent());
        c48.k().t(createPersonalChatMessageByToUser);
    }

    public static void createPersonalChatMessage(int i, String str, long j, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2, str3, str4}) == null) {
            createPersonalChatMessage(k38.n().s(String.valueOf(j), 2), i, str, j, str2, str3, str4);
        }
    }

    public static void createAndSendPersonalForumChatMessage(@Nullable ForumData forumData, long j, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{forumData, Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)}) == null) && forumData != null && !TextUtils.isEmpty(forumData.getId())) {
            ChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str, str2, str3, z);
            ShareForumMsgData ofForumData = ShareForumMsgData.ofForumData(forumData);
            createPersonalChatMessageByToUser.setContent(OrmObject.jsonStrWithObject(ofForumData));
            createPersonalChatMessageByToUser.setObjContent(ofForumData);
            createPersonalChatMessageByToUser.setMsgType(33);
            createPersonalChatMessageByToUser.setEncodeContent(ofForumData.toEncodeContent());
            c48.k().t(createPersonalChatMessageByToUser);
        }
    }

    public static void createAndSendPersonalPicChatMessage(@Nullable String str, String str2, int i, int i2, @Nullable String str3, long j, String str4, String str5, String str6, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, Long.valueOf(j), str4, str5, str6, Boolean.valueOf(z)}) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (i <= 0) {
            i = 100;
        }
        if (i2 <= 0) {
            i2 = 100;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(EmotionUbcHelper.MEME_ID, str);
            hashMap.put("meme_type", str3);
        }
        PersonalChatMessage createPersonalChatMessageByToUser = createPersonalChatMessageByToUser(j, str4, str5, str6, z);
        createPersonalChatMessageByToUser.setContent(c48.g(str2, str2, i, i2, hashMap));
        createPersonalChatMessageByToUser.setMsgType(2);
        c48.k().t(createPersonalChatMessageByToUser);
    }

    public static void createAndSendPersonalReactionsPicChatMessage(@Nullable String str, String str2, int i, int i2, long j, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str3, str4, str5, Boolean.valueOf(z)}) == null) {
            createAndSendPersonalPicChatMessage(str, str2, i, i2, "5", j, str3, str4, str5, z);
        }
    }

    public static void createPersonalChatMessage(long j, int i, String str, long j2, String str2, String str3, String str4) {
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2), str2, str3, str4}) != null) || StringUtils.isNull(str)) {
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
            j3 = pg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
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
        c48.k().t(personalChatMessage);
    }

    public static PersonalChatMessage createPersonalChatMessageByToUser(long j, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), str, str2, str3, Boolean.valueOf(z)})) == null) {
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            long s = k38.n().s(String.valueOf(j), 2);
            personalChatMessage.setRecordId(s);
            personalChatMessage.setMsgId(s);
            personalChatMessage.setBornTime(System.currentTimeMillis());
            personalChatMessage.setTime(System.currentTimeMillis() / 1000);
            UserData userData = new UserData();
            userData.setUserId(String.valueOf(j));
            userData.setUserName(str);
            userData.setName_show(str2);
            userData.setPortrait(str3);
            personalChatMessage.setToUserInfo(userData);
            personalChatMessage.setToUserId(j);
            personalChatMessage.setIsFriend(z ? 1 : 0);
            personalChatMessage.setCustomGroupType(2);
            UserData userData2 = new UserData();
            userData2.setUserName(TbadkCoreApplication.getCurrentAccountName());
            userData2.setUserId(TbadkCoreApplication.getCurrentAccount());
            userData2.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            personalChatMessage.setUserInfo(userData2);
            personalChatMessage.setUserId(pg.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            personalChatMessage.setLocalData(msgLocalData);
            return personalChatMessage;
        }
        return (PersonalChatMessage) invokeCommon.objValue;
    }

    public static void generatePushData(List<GroupMsgData> list, int i, List<MsgInfo> list2, Long l) {
        int i2;
        ChatMessage obtainMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65548, null, list, i, list2, l) == null) && list2 != null && list2.size() != 0) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            GroupMsgData obtainGroupData = obtainGroupData(i);
            if (obtainGroupData == null) {
                return;
            }
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
                    } catch (Exception e) {
                        e = e;
                        i2 = i3;
                    }
                    if (obtainMessage != null) {
                        i2 = i3;
                        try {
                            assignChatMessage(list, linkedList, hashMap, hashMap2, obtainMessage, msgInfo, obtainGroupData, l);
                        } catch (Exception e2) {
                            e = e2;
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

    public static j05 generatePushNotifyData(MsgInfo msgInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        UserInfo userInfo;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, msgInfo)) == null) {
            String str5 = "";
            if (msgInfo != null && !qi.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() != 1) {
                        str4 = "";
                    } else {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        str = jSONObject.optString("title", null);
                        try {
                            str4 = jSONObject.optString("url", null);
                            str5 = str;
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e);
                            str2 = "";
                            str5 = str;
                            userInfo = msgInfo.userInfo;
                            if (userInfo != null) {
                                str5 = TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{msgInfo.userInfo.userName}) + ZeusCrashHandler.NAME_SEPERATOR + str5;
                            }
                            str3 = str5;
                            if (!qi.isEmpty(str3)) {
                                return new j05(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
                            }
                            return null;
                        }
                    }
                    str2 = str4;
                } catch (Exception e2) {
                    e = e2;
                    str = "";
                }
                userInfo = msgInfo.userInfo;
                if (userInfo != null && !qi.isEmpty(userInfo.userName)) {
                    str5 = TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{msgInfo.userInfo.userName}) + ZeusCrashHandler.NAME_SEPERATOR + str5;
                }
                str3 = str5;
                if (!qi.isEmpty(str3) && !qi.isEmpty(str2)) {
                    return new j05(0L, msgInfo.taskId.longValue(), str2, str3, msgInfo.stat, msgInfo.serviceId.longValue());
                }
            }
            return null;
        }
        return (j05) invokeL.objValue;
    }

    public static GroupMsgData obtainGroupData(int i) {
        InterceptResult invokeI;
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            if (i != 1) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 30) {
                            switch (i) {
                                case 10:
                                    GroupMsgData groupMsgData2 = new GroupMsgData(2012126);
                                    groupMsgData2.getGroupInfo().setCustomType(6);
                                    groupMsgData = groupMsgData2;
                                    break;
                                case 11:
                                    groupMsgData = new GroupMsgData(2012126);
                                    groupMsgData.getGroupInfo().setCustomType(7);
                                    break;
                                case 12:
                                    groupMsgData = new GroupMsgData(2012126);
                                    groupMsgData.getGroupInfo().setCustomType(8);
                                    break;
                                default:
                                    groupMsgData = null;
                                    break;
                            }
                        } else {
                            groupMsgData = new GroupMsgData(2012129);
                            groupMsgData.getGroupInfo().setCustomType(-9);
                        }
                    } else {
                        groupMsgData = new GroupMsgData(2012124);
                        groupMsgData.getGroupInfo().setCustomType(5);
                    }
                } else {
                    groupMsgData = new GroupMsgData(2012128);
                    groupMsgData.getGroupInfo().setCustomType(-1);
                }
            } else {
                groupMsgData = new GroupMsgData(2012120);
                groupMsgData.getGroupInfo().setCustomType(-2);
            }
            if (groupMsgData != null) {
                groupMsgData.getGroupInfo().setGroupType(i);
            }
            return groupMsgData;
        }
        return (GroupMsgData) invokeI.objValue;
    }

    public static long getTaskId(MsgInfo msgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, msgInfo)) == null) {
            if (msgInfo == null) {
                return 0L;
            }
            if (!TextUtils.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() > 0) {
                        long g = pg.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                        if (g > 0) {
                            return g;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return msgInfo.taskId.longValue();
        }
        return invokeL.longValue;
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, groupMsgData)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, longSparseArray)) == null) {
            if (longSparseArray != null && longSparseArray.size() != 0) {
                NewpushRepair.Builder builder = new NewpushRepair.Builder();
                for (int i = 0; i < longSparseArray.size(); i++) {
                    NewpushGroupRepair j = u38.i().j(longSparseArray.keyAt(i));
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
        return (NewpushRepair) invokeL.objValue;
    }

    public static ChatMessage obtainMessage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            if (i != 1) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 30) {
                            switch (i) {
                                case 10:
                                case 11:
                                case 12:
                                    return new YYMessage();
                                default:
                                    return null;
                            }
                        }
                        return new OfficialChatMessage();
                    }
                    return new NotifyChatMessage();
                }
                return new PersonalChatMessage();
            }
            return new SystemMessage();
        }
        return (ChatMessage) invokeI.objValue;
    }

    public static void updateGroupNotExist(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, bundle) == null) && bundle != null && bundle.containsKey(TbEnum.SystemMessage.KEY_GROUP_ID) && bundle.containsKey("type")) {
            long j = bundle.getLong(TbEnum.SystemMessage.KEY_GROUP_ID);
            int i = bundle.getInt("type");
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            if (bundle.containsKey("lastMid")) {
                imMessageCenterPojo.setPulled_msgId(s58.a(bundle.getLong("lastMid") - 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public static void makeNewServiceId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null && list.size() != 0) {
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
    }

    public static void makeNewTaskId(ImMessageCenterPojo imMessageCenterPojo, List<CommonMsgPojo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null && list.size() != 0) {
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
    }

    public static NewpushGroupRepair makeNewpushGroupRepair(long j, int i, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
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
        return (NewpushGroupRepair) invokeCommon.objValue;
    }

    public static void sendHasReadMessage(String str, int i) {
        ImMessageCenterPojo h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65558, null, str, i) != null) || StringUtils.isNull(str) || i != 2 || (h = k38.n().h(str, 2)) == null) {
            return;
        }
        long pulled_msgId = h.getPulled_msgId();
        if (pulled_msgId > h.getSent_msgId()) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(s58.c(pulled_msgId), Long.parseLong(str));
            if (MessageManager.getInstance().getSocketClient().n(requestPersonalMsgReadMessage)) {
                return;
            }
            MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
        }
    }
}
