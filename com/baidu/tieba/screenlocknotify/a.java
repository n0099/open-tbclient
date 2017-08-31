package com.baidu.tieba.screenlocknotify;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.g;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static a fKB;
    public d fKD;
    public int fKE;
    public int fKF;
    public int fKG;
    public int fKH;
    public int fKI;
    public boolean fKJ;
    private List<e> fBi = new LinkedList();
    private e fKC = null;
    public boolean fKK = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener dss = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                a.this.e(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2012125 || customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                    a.this.processServerMsg(customResponsedMessage);
                }
            }
        }
    };
    private CustomMessageListener dMO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener fKL = new CustomMessageListener(CmdConfigCustom.CMD_SCREEN_DIALOG) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zT() && a.biq()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.fKD.isScreenOn()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new ak("c10316").r("obj_type", 2).r("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new ak("c10316").r("obj_type", 1).r("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context asA = TbadkApplication.getInst().getApp();

    public static a bip() {
        if (fKB == null) {
            fKB = new a();
        }
        return fKB;
    }

    public void release() {
        this.fBi.clear();
        this.fKC = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dss);
        MessageManager.getInstance().registerListener(this.dMO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.fKL);
        this.fKE = 0;
        this.fKF = 0;
        this.fKG = 0;
        this.fKH = 0;
        this.fKI = 0;
        this.fKJ = true;
        this.fKD = new d();
    }

    public static boolean biq() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            e eVar = new e();
            eVar.fKW = 0;
            eVar.msgType = 4;
            eVar.groupId = "-1";
            eVar.customGroupType = 4;
            eVar.groupName = remindRecommendMessage.name;
            eVar.userName = remindRecommendMessage.name;
            eVar.title = remindRecommendMessage.title;
            eVar.pic = remindRecommendMessage.picture;
            eVar.url = remindRecommendMessage.url;
            eVar.lastTime = System.currentTimeMillis();
            eVar.isAcceptNotify = true;
            eVar.fjV = true;
            eVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                eVar.stat = "2";
            } else {
                eVar.stat = "1";
            }
            c(eVar);
            bit();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.asA, new ap(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.asA, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.asA, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ap apVar, String str) {
        if (context == null || apVar == null || TextUtils.isEmpty(str)) {
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
        intent.putExtra("message_id", apVar.qt());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, apVar.getTaskId());
        if (!TextUtils.isEmpty(apVar.getStat())) {
            intent.putExtra("stat", apVar.getStat());
        }
        return intent;
    }

    public List<e> bir() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fBi);
        return linkedList;
    }

    public e bis() {
        return this.fKC;
    }

    protected List<ChatMessage> processServerMsg(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
            int customType = groupMsgData.getGroupInfo().getCustomType();
            if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(groupMsgData.getListMessage());
            o(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void o(List<ChatMessage> list, int i) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            boolean z2 = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null) {
                    if (D(chatMessage)) {
                        e b = b(chatMessage, i);
                        if (b != null && b.fKW >= 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    c(b);
                                } else {
                                    this.fKC = b;
                                }
                                z = true;
                            }
                        }
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
            if (z2) {
                bit();
            }
        }
    }

    public void c(e eVar) {
        if (this.fBi != null) {
            this.fBi.add(eVar);
        }
    }

    public boolean D(ChatMessage chatMessage) {
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

    public e b(ChatMessage chatMessage, int i) {
        g.a aVar;
        e eVar = new e();
        eVar.fKW = 0;
        eVar.msgType = chatMessage.getMsgType();
        eVar.customGroupType = i;
        eVar.userName = chatMessage.getUserInfo().getUserName();
        eVar.fKY = chatMessage.getRecordId();
        eVar.msgId = chatMessage.getMsgId();
        eVar.isAcceptNotify = true;
        eVar.fjV = true;
        eVar.taskId = chatMessage.getStatTaskId();
        if (eVar.customGroupType == 1) {
            ImMessageCenterPojo aa = com.baidu.tieba.im.memorycache.b.ayP().aa(chatMessage.getGroupId(), 1);
            if (aa != null) {
                eVar.groupName = aa.getGroup_name();
                eVar.fKW = aa.getUnread_count();
                eVar.lastTime = aa.getLast_content_time();
            }
            eVar.content = eVar.userName + ":" + com.baidu.tieba.im.util.e.G(chatMessage.getMsgType(), chatMessage.getContent());
            eVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zP()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aAf().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 2) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo aa2 = com.baidu.tieba.im.memorycache.b.ayP().aa(eVar.groupId, 2);
            if (aa2 != null) {
                eVar.fKW = aa2.getUnread_count();
                eVar.lastTime = aa2.getLast_content_time();
                eVar.fjV = aa2.getIsFriend() == 1;
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            eVar.content = com.baidu.tieba.im.util.e.G(chatMessage.getMsgType(), chatMessage.getContent());
            if (eVar.fjV) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zI()) {
                    eVar.isAcceptNotify = false;
                } else {
                    eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aAi().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zI()) {
                eVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zE()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aAi().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 4) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(eVar.groupId) && !"2807977073".equals(eVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo aa3 = com.baidu.tieba.im.memorycache.b.ayP().aa(eVar.groupId, 4);
            if (aa3 != null) {
                eVar.fKW = aa3.getUnread_count();
                eVar.lastTime = aa3.getLast_content_time();
                eVar.fjV = aa3.getIsFriend() == 1;
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<g.a> c = g.c(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (c != null && c.size() > 0 && (aVar = c.get(0)) != null) {
                    eVar.title = aVar.title;
                    eVar.content = aVar.text;
                    eVar.pic = aVar.src;
                    eVar.url = aVar.url;
                }
            } else {
                eVar.content = com.baidu.tieba.im.util.e.G(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zU()) {
                eVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                eVar.isAcceptNotify = false;
            }
        }
        return eVar;
    }

    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(r(data));
        }
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.fBi.remove(eVar);
        }
    }

    public e r(ImMessageCenterPojo imMessageCenterPojo) {
        e eVar = new e();
        if (imMessageCenterPojo != null) {
            eVar.fKW = imMessageCenterPojo.getUnread_count();
            eVar.groupId = imMessageCenterPojo.getGid();
            eVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            eVar.groupName = imMessageCenterPojo.getGroup_name();
            eVar.userName = imMessageCenterPojo.getLast_user_name();
            eVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (eVar.customGroupType == 1) {
                eVar.content = eVar.userName + ":" + imMessageCenterPojo.getLast_content();
            } else {
                eVar.content = imMessageCenterPojo.getLast_content();
            }
            eVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return eVar;
    }

    public void bit() {
        e eVar;
        if (com.baidu.adp.lib.b.d.eW().af("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zC() && com.baidu.tbadk.coreExtra.messageCenter.b.zA().zR()) {
            if ((this.fBi != null && this.fBi.size() != 0) || this.fKC != null) {
                if (!this.fKD.isScreenOn() || this.fKG == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.asA)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.fKD.biv();
                        }
                    }, 1000L);
                    if (this.fBi != null && this.fBi.size() > 0 && (eVar = this.fBi.get(0)) != null) {
                        TiebaStatic.logPagePV(new ak("c11702").f(PbActivityConfig.KEY_MSG_ID, eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId));
                    }
                }
            }
        }
    }
}
