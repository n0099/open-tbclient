package com.baidu.tieba.screenlocknotify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.r;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    private static i feg;
    public r fei;
    public int fej;
    public int fek;
    public int fel;
    public int fem;
    public int fen;
    public boolean feo;
    private List<s> eTy = new LinkedList();
    private s feh = null;
    public boolean fep = false;
    public Handler mHandler = new j(this);
    private CustomMessageListener cMx = new k(this, 0);
    private CustomMessageListener mCustomMessageListener = new l(this, 0);
    private CustomMessageListener dhc = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener feq = new n(this, CmdConfigCustom.CMD_SCREEN_DIALOG);
    private final Context apX = TbadkApplication.getInst().getApp();

    public static i aZv() {
        if (feg == null) {
            feg = new i();
        }
        return feg;
    }

    public void release() {
        this.eTy.clear();
        this.feh = null;
    }

    private i() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cMx);
        MessageManager.getInstance().registerListener(this.dhc);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.feq);
        this.fej = 0;
        this.fek = 0;
        this.fel = 0;
        this.fem = 0;
        this.fen = 0;
        this.feo = true;
        this.fei = new r();
    }

    public static boolean aZw() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            s sVar = new s();
            sVar.feB = 0;
            sVar.msgType = 4;
            sVar.groupId = "-1";
            sVar.customGroupType = 4;
            sVar.groupName = remindRecommendMessage.name;
            sVar.userName = remindRecommendMessage.name;
            sVar.title = remindRecommendMessage.title;
            sVar.pic = remindRecommendMessage.picture;
            sVar.url = remindRecommendMessage.url;
            sVar.lastTime = System.currentTimeMillis();
            sVar.isAcceptNotify = true;
            sVar.eDv = true;
            sVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                sVar.stat = "2";
            } else {
                sVar.stat = "1";
            }
            c(sVar);
            aZz();
            TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.apX, new ao(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.apX, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.apX, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ao aoVar, String str) {
        if (context == null || aoVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/") || str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("id", substring);
        } else if (str.startsWith("pb:")) {
            String substring2 = str.substring(str.lastIndexOf(":") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("id", substring2);
        } else if (str.startsWith("web:")) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent.putExtra("class", 29);
            intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
        } else if (str.startsWith("pk_before:")) {
            intent.putExtra("class", 6);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra("class", 7);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent.putExtra("class", 8);
        } else if (str.startsWith("twzb:")) {
            intent.putExtra("class", 31);
            String substring3 = str.substring(str.lastIndexOf("twzb:") + 5);
            String str2 = "";
            if (substring3.startsWith("pid=")) {
                str2 = substring3.substring(substring3.lastIndexOf("pid=") + 4);
            } else if (substring3.startsWith("http://")) {
                str2 = substring3.substring(substring3.lastIndexOf("p/") + 2);
            }
            if (StringUtils.isNull(str2)) {
                return null;
            }
            intent.putExtra("tid", str2);
        } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return null;
        } else {
            intent.putExtra("class", 0);
            intent.putExtra("url", str);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra("link", str);
        intent.putExtra("message_id", aoVar.qr());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, aoVar.getTaskId());
        if (!TextUtils.isEmpty(aoVar.getStat())) {
            intent.putExtra("stat", aoVar.getStat());
        }
        return intent;
    }

    public List<s> aZx() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.eTy);
        return linkedList;
    }

    public s aZy() {
        return this.feh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> processServerMsg(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
            int customType = groupMsgData.getGroupInfo().getCustomType();
            if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(groupMsgData.getListMessage());
            q(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void q(List<ChatMessage> list, int i) {
        s b;
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && C(chatMessage) && (b = b(chatMessage, i)) != null && b.feB >= 0) {
                    if (!b.isAcceptNotify) {
                        d(b);
                    } else {
                        if (i == 4) {
                            c(b);
                        } else {
                            this.feh = b;
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                aZz();
            }
        }
    }

    public void c(s sVar) {
        if (this.eTy != null) {
            this.eTy.add(sVar);
        }
    }

    public boolean C(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return false;
        }
        switch (chatMessage.getMsgType()) {
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 22:
            case 23:
                return false;
            default:
                return (StringUtils.isNull(chatMessage.getContent()) || StringUtils.isNull(chatMessage.getUserInfo().getUserName()) || chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkApplication.getCurrentAccountName())) ? false : true;
        }
    }

    public s b(ChatMessage chatMessage, int i) {
        r.a aVar;
        s sVar = new s();
        sVar.feB = 0;
        sVar.msgType = chatMessage.getMsgType();
        sVar.customGroupType = i;
        sVar.userName = chatMessage.getUserInfo().getUserName();
        sVar.feD = chatMessage.getRecordId();
        sVar.msgId = chatMessage.getMsgId();
        sVar.isAcceptNotify = true;
        sVar.eDv = true;
        sVar.taskId = chatMessage.getStatTaskId();
        if (sVar.customGroupType == 1) {
            ImMessageCenterPojo Z = com.baidu.tieba.im.memorycache.b.apX().Z(chatMessage.getGroupId(), 1);
            if (Z != null) {
                sVar.groupName = Z.getGroup_name();
                sVar.feB = Z.getUnread_count();
                sVar.lastTime = Z.getLast_content_time();
            }
            sVar.content = String.valueOf(sVar.userName) + ":" + com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            sVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zg()) {
                sVar.isAcceptNotify = false;
            } else {
                sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.arr().bg(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
            }
        } else if (sVar.customGroupType == 2) {
            sVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo Z2 = com.baidu.tieba.im.memorycache.b.apX().Z(sVar.groupId, 2);
            if (Z2 != null) {
                sVar.feB = Z2.getUnread_count();
                sVar.lastTime = Z2.getLast_content_time();
                sVar.eDv = Z2.getIsFriend() == 1;
            }
            sVar.groupName = chatMessage.getUserInfo().getUserName();
            sVar.content = com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            if (sVar.eDv) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ()) {
                    sVar.isAcceptNotify = false;
                } else {
                    sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aru().bg(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ()) {
                sVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yV()) {
                sVar.isAcceptNotify = false;
            } else {
                sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aru().bg(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
            }
        } else if (sVar.customGroupType == 4) {
            sVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(sVar.groupId) && !"2807977073".equals(sVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo Z3 = com.baidu.tieba.im.memorycache.b.apX().Z(sVar.groupId, 4);
            if (Z3 != null) {
                sVar.feB = Z3.getUnread_count();
                sVar.lastTime = Z3.getLast_content_time();
                sVar.eDv = Z3.getIsFriend() == 1;
            }
            sVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<r.a> b = com.baidu.tieba.im.chat.officialBar.r.b(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (b != null && b.size() > 0 && (aVar = b.get(0)) != null) {
                    sVar.title = aVar.title;
                    sVar.content = aVar.text;
                    sVar.pic = aVar.src;
                    sVar.url = aVar.url;
                }
            } else {
                sVar.content = com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zl()) {
                sVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                sVar.isAcceptNotify = false;
            }
        }
        return sVar;
    }

    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(r(data));
        }
    }

    public void d(s sVar) {
        if (sVar != null) {
            this.eTy.remove(sVar);
        }
    }

    public s r(ImMessageCenterPojo imMessageCenterPojo) {
        s sVar = new s();
        if (imMessageCenterPojo != null) {
            sVar.feB = imMessageCenterPojo.getUnread_count();
            sVar.groupId = imMessageCenterPojo.getGid();
            sVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            sVar.groupName = imMessageCenterPojo.getGroup_name();
            sVar.userName = imMessageCenterPojo.getLast_user_name();
            sVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (sVar.customGroupType == 1) {
                sVar.content = String.valueOf(sVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                sVar.content = imMessageCenterPojo.getLast_content();
            }
            sVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return sVar;
    }

    public void aZz() {
        s sVar;
        if (com.baidu.adp.lib.b.e.eZ().Y("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yR().yT() && com.baidu.tbadk.coreExtra.messageCenter.c.yR().zi()) {
            if ((this.eTy != null && this.eTy.size() != 0) || this.feh != null) {
                if (!this.fei.isScreenOn() || this.fel == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.apX)));
                    this.mHandler.postDelayed(new o(this), 1000L);
                    if (this.eTy != null && this.eTy.size() > 0 && (sVar = this.eTy.get(0)) != null) {
                        TiebaStatic.logPagePV(new as("c11702").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId));
                    }
                }
            }
        }
    }
}
