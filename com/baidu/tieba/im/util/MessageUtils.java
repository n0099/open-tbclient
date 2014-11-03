package com.baidu.tieba.im.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class MessageUtils {
    public static void createChatMessage(int i, String str, int i2) {
    }

    public static void createPersonalChatMessage(int i, String str, long j, String str2, String str3) {
        createPersonalChatMessage(com.baidu.tieba.im.memorycache.c.PN().G(String.valueOf(j), 2), i, str, j, str2, str3);
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
            userData2.setUserName(TbadkApplication.getCurrentAccountName());
            userData2.setUserId(TbadkApplication.getCurrentAccount());
            userData2.setPortrait(com.baidu.tieba.im.c.Jj());
            personalChatMessage.setUserInfo(userData2);
            try {
                j3 = com.baidu.adp.lib.g.c.a(TbadkApplication.getCurrentAccount(), 0L);
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
            w.Js().f(personalChatMessage);
        }
    }

    public static void createGroupChatMessage(int i, String str, long j) {
        createGroupChatMessage(com.baidu.tieba.im.memorycache.c.PN().G(String.valueOf(j), 1), i, str, j);
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
            userData.setUserName(TbadkApplication.getCurrentAccountName());
            userData.setUserId(TbadkApplication.getCurrentAccount());
            userData.setPortrait(com.baidu.tieba.im.c.Jj());
            groupChatMessage.setUserInfo(userData);
            try {
                j3 = com.baidu.adp.lib.g.c.a(TbadkApplication.getCurrentAccount(), 0L);
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
            w.Js().f(groupChatMessage);
        }
    }
}
