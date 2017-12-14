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
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.aj;
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
    private static a gdT;
    public d gdV;
    public int gdW;
    public int gdX;
    public int gdY;
    public int gdZ;
    public int gea;
    public boolean geb;
    private List<e> fRC = new LinkedList();
    private e gdU = null;
    public boolean gec = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener dGr = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                a.this.g(customResponsedMessage);
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
    private CustomMessageListener cXg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener ged = new CustomMessageListener(CmdConfigCustom.CMD_SCREEN_DIALOG) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zD() && a.bnb()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.gdV.isScreenOn()) {
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
    private final Context asq = TbadkApplication.getInst().getApp();

    public static a bna() {
        if (gdT == null) {
            gdT = new a();
        }
        return gdT;
    }

    public void release() {
        this.fRC.clear();
        this.gdU = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGr);
        MessageManager.getInstance().registerListener(this.cXg);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.ged);
        this.gdW = 0;
        this.gdX = 0;
        this.gdY = 0;
        this.gdZ = 0;
        this.gea = 0;
        this.geb = true;
        this.gdV = new d();
    }

    public static boolean bnb() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            e eVar = new e();
            eVar.gep = 0;
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
            eVar.fyy = true;
            eVar.followStatus = 1;
            eVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                eVar.stat = "2";
            } else {
                eVar.stat = "1";
            }
            c(eVar);
            bne();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.asq, new aj(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.asq, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.asq, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, aj ajVar, String str) {
        if (context == null || ajVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/") || str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring);
        } else if (str.startsWith("pb:")) {
            String substring2 = str.substring(str.lastIndexOf(":") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("key_start_from", 7);
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
        intent.putExtra("message_id", ajVar.qm());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, ajVar.getTaskId());
        if (!TextUtils.isEmpty(ajVar.getStat())) {
            intent.putExtra("stat", ajVar.getStat());
        }
        return intent;
    }

    public List<e> bnc() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fRC);
        return linkedList;
    }

    public e bnd() {
        return this.gdU;
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
                    if (E(chatMessage)) {
                        e b = b(chatMessage, i);
                        if (b != null && b.gep > 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    c(b);
                                } else {
                                    this.gdU = b;
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
                bne();
            }
        }
    }

    public void c(e eVar) {
        if (this.fRC != null) {
            this.fRC.add(eVar);
        }
    }

    public boolean E(ChatMessage chatMessage) {
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
        eVar.gep = 0;
        eVar.msgType = chatMessage.getMsgType();
        eVar.customGroupType = i;
        eVar.userName = chatMessage.getUserInfo().getUserName();
        eVar.ger = chatMessage.getRecordId();
        eVar.msgId = chatMessage.getMsgId();
        eVar.isAcceptNotify = true;
        eVar.fyy = true;
        eVar.followStatus = 1;
        eVar.taskId = chatMessage.getStatTaskId();
        if (eVar.customGroupType == 1) {
            ImMessageCenterPojo ai = com.baidu.tieba.im.memorycache.b.aBP().ai(chatMessage.getGroupId(), 1);
            if (ai != null) {
                eVar.groupName = ai.getGroup_name();
                eVar.gep = ai.getUnread_count();
                eVar.lastTime = ai.getLast_content_time();
            }
            eVar.content = eVar.userName + ":" + com.baidu.tieba.im.util.e.K(chatMessage.getMsgType(), chatMessage.getContent());
            eVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zz()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aDg().bj(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 2) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo ai2 = com.baidu.tieba.im.memorycache.b.aBP().ai(eVar.groupId, 2);
            if (ai2 != null) {
                eVar.gep = ai2.getUnread_count();
                eVar.lastTime = ai2.getLast_content_time();
                eVar.fyy = ai2.getIsFriend() == 1;
                eVar.followStatus = ai2.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            eVar.content = com.baidu.tieba.im.util.e.K(chatMessage.getMsgType(), chatMessage.getContent());
            if (eVar.fyy) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zs()) {
                    eVar.isAcceptNotify = false;
                } else {
                    eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aDj().bj(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zs()) {
                eVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zo()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aDj().bj(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 4) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(eVar.groupId) && !"2807977073".equals(eVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo ai3 = com.baidu.tieba.im.memorycache.b.aBP().ai(eVar.groupId, 4);
            if (ai3 != null) {
                eVar.gep = ai3.getUnread_count();
                eVar.lastTime = ai3.getLast_content_time();
                eVar.fyy = ai3.getIsFriend() == 1;
                eVar.followStatus = ai3.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<g.a> b = g.b(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (b != null && b.size() > 0 && (aVar = b.get(0)) != null) {
                    eVar.title = aVar.title;
                    eVar.content = aVar.text;
                    eVar.pic = aVar.src;
                    eVar.url = aVar.url;
                }
            } else {
                eVar.content = com.baidu.tieba.im.util.e.K(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zE()) {
                eVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                eVar.isAcceptNotify = false;
            }
        }
        return eVar;
    }

    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(r(data));
        }
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.fRC.remove(eVar);
        }
    }

    public e r(ImMessageCenterPojo imMessageCenterPojo) {
        e eVar = new e();
        if (imMessageCenterPojo != null) {
            eVar.gep = imMessageCenterPojo.getUnread_count();
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

    public void bne() {
        e eVar;
        if (com.baidu.adp.lib.b.d.eV().af("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zm() && com.baidu.tbadk.coreExtra.messageCenter.b.zk().zB()) {
            if ((this.fRC != null && this.fRC.size() != 0) || this.gdU != null) {
                if (!this.gdV.isScreenOn() || this.gdY == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.asq)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.gdV.bng();
                        }
                    }, 1000L);
                    if (this.fRC != null && this.fRC.size() > 0 && (eVar = this.fRC.get(0)) != null) {
                        TiebaStatic.logPagePV(new ak("c11702").f("msg_id", eVar.msgId / 100).f(InterviewLiveActivityConfig.KEY_TASK_ID, eVar.taskId));
                    }
                }
            }
        }
    }
}
