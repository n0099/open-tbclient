package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.r;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i fmF;
    public r fmI;
    public int fmJ;
    public int fmK;
    public int fmL;
    public int fmM;
    public int fmN;
    public boolean fmO;
    private List<s> fgM = new LinkedList();
    private s fmH = null;
    public boolean fmP = false;
    public Handler mHandler = new j(this);
    private CustomMessageListener ddn = new k(this, 0);
    private CustomMessageListener mCustomMessageListener = new l(this, 0);
    private CustomMessageListener dAs = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fmQ = new n(this, CmdConfigCustom.CMD_SCREEN_DIALOG);
    private final Context alz = TbadkApplication.getInst().getApp();
    private KeyguardManager fmG = (KeyguardManager) this.alz.getSystemService("keyguard");

    public static i beX() {
        if (fmF == null) {
            fmF = new i();
        }
        return fmF;
    }

    public void release() {
        this.fgM.clear();
        this.fmH = null;
    }

    private i() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ddn);
        MessageManager.getInstance().registerListener(this.dAs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.fmQ);
        this.fmJ = 0;
        this.fmK = 0;
        this.fmL = 0;
        this.fmM = 0;
        this.fmN = 0;
        this.fmO = true;
        this.fmI = new r();
    }

    public static boolean beY() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            s sVar = new s();
            sVar.fna = 0;
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
            sVar.eQU = true;
            sVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                sVar.stat = "2";
            } else {
                sVar.stat = "1";
            }
            c(sVar);
            bfb();
            TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.alz, new am(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.alz, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.alz, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, am amVar, String str) {
        if (context == null || amVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/")) {
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
        intent.putExtra("message_id", amVar.qx());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, amVar.getTaskId());
        if (!TextUtils.isEmpty(amVar.getStat())) {
            intent.putExtra("stat", amVar.getStat());
        }
        return intent;
    }

    public List<s> beZ() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fgM);
        return linkedList;
    }

    public s bfa() {
        return this.fmH;
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
            r(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void r(List<ChatMessage> list, int i) {
        s a;
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && C(chatMessage) && (a = a(chatMessage, i)) != null && a.fna > 0) {
                    if (!a.isAcceptNotify) {
                        d(a);
                    } else {
                        if (i == 4) {
                            c(a);
                        } else {
                            this.fmH = a;
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                bfb();
            }
        }
    }

    public void c(s sVar) {
        if (this.fgM != null) {
            this.fgM.add(sVar);
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

    public s a(ChatMessage chatMessage, int i) {
        r.a aVar;
        s sVar = new s();
        sVar.fna = 0;
        sVar.msgType = chatMessage.getMsgType();
        sVar.customGroupType = i;
        sVar.userName = chatMessage.getUserInfo().getUserName();
        sVar.fnc = chatMessage.getRecordId();
        sVar.msgId = chatMessage.getMsgId();
        sVar.isAcceptNotify = true;
        sVar.eQU = true;
        sVar.taskId = chatMessage.getStatTaskId();
        if (sVar.customGroupType == 1) {
            ImMessageCenterPojo ah = com.baidu.tieba.im.memorycache.b.axj().ah(chatMessage.getGroupId(), 1);
            if (ah != null) {
                sVar.groupName = ah.getGroup_name();
                sVar.fna = ah.getUnread_count();
                sVar.lastTime = ah.getLast_content_time();
            }
            sVar.content = String.valueOf(sVar.userName) + ":" + com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent());
            sVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zw()) {
                sVar.isAcceptNotify = false;
            } else {
                sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.ayD().bk(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
            }
        } else if (sVar.customGroupType == 2) {
            sVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo ah2 = com.baidu.tieba.im.memorycache.b.axj().ah(sVar.groupId, 2);
            if (ah2 != null) {
                sVar.fna = ah2.getUnread_count();
                sVar.lastTime = ah2.getLast_content_time();
                sVar.eQU = ah2.getIsFriend() == 1;
            }
            sVar.groupName = chatMessage.getUserInfo().getUserName();
            sVar.content = com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent());
            if (sVar.eQU) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp()) {
                    sVar.isAcceptNotify = false;
                } else {
                    sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.ayG().bk(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp()) {
                sVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zl()) {
                sVar.isAcceptNotify = false;
            } else {
                sVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.ayG().bk(TbadkCoreApplication.getCurrentAccount(), sVar.groupId);
            }
        } else if (sVar.customGroupType == 4) {
            sVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(sVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo ah3 = com.baidu.tieba.im.memorycache.b.axj().ah(sVar.groupId, 4);
            if (ah3 != null) {
                sVar.fna = ah3.getUnread_count();
                sVar.lastTime = ah3.getLast_content_time();
                sVar.eQU = ah3.getIsFriend() == 1;
            }
            sVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<r.a> b = com.baidu.tieba.im.chat.officialBar.r.b(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (b != null && b.size() > 0 && (aVar = b.get(0)) != null) {
                    sVar.title = aVar.title;
                    sVar.content = aVar.text;
                    sVar.pic = aVar.src;
                }
            } else {
                sVar.content = com.baidu.tieba.im.util.h.y(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                sVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                sVar.isAcceptNotify = false;
            }
        }
        return sVar;
    }

    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(y(data));
        }
    }

    public void d(s sVar) {
        if (sVar != null) {
            this.fgM.remove(sVar);
        }
    }

    public s y(ImMessageCenterPojo imMessageCenterPojo) {
        s sVar = new s();
        if (imMessageCenterPojo != null) {
            sVar.fna = imMessageCenterPojo.getUnread_count();
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
            sVar.taskId = com.baidu.adp.lib.h.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return sVar;
    }

    public void bfb() {
        s sVar;
        if (com.baidu.adp.lib.c.e.dN().ac("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zj() && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zz()) {
            if ((this.fgM != null && this.fgM.size() != 0) || this.fmH != null) {
                if (!this.fmI.isScreenOn() || this.fmL == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.alz)));
                    this.mHandler.postDelayed(new o(this), 1000L);
                    if (this.fgM != null && this.fgM.size() > 0 && (sVar = this.fgM.get(0)) != null) {
                        TiebaStatic.logPagePV(new av("c11702").g(PbActivityConfig.KEY_MSG_ID, sVar.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, sVar.taskId));
                    }
                }
            }
        }
    }
}
