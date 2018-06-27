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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a gvw;
    public int gvA;
    public int gvB;
    public int gvC;
    public int gvD;
    public boolean gvE;
    public d gvy;
    public int gvz;
    private List<e> ghG = new LinkedList();
    private e gvx = null;
    public boolean gvF = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener ejw = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener bwT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener gvG = new CustomMessageListener(2001355) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.bqf()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.gvy.isScreenOn()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new an("c10316").r("obj_type", 2).r("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new an("c10316").r("obj_type", 1).r("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context aDy = TbadkApplication.getInst().getApp();

    public static a bqe() {
        if (gvw == null) {
            gvw = new a();
        }
        return gvw;
    }

    public void release() {
        this.ghG.clear();
        this.gvx = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(2016004, this.ejw);
        MessageManager.getInstance().registerListener(this.bwT);
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012121, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.gvG);
        this.gvz = 0;
        this.gvA = 0;
        this.gvB = 0;
        this.gvC = 0;
        this.gvD = 0;
        this.gvE = true;
        this.gvy = new d();
    }

    public static boolean bqf() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            e eVar = new e();
            eVar.gvR = 0;
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
            eVar.gac = true;
            eVar.followStatus = 1;
            eVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                eVar.stat = "2";
            } else {
                eVar.stat = "1";
            }
            c(eVar);
            bqi();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.aDy, new ak(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.aDy, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.aDy, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ak akVar, String str) {
        if (context == null || akVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/") || str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra("class", 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring);
        } else if (str.startsWith("pb:")) {
            String substring2 = str.substring(str.lastIndexOf(SystemInfoUtil.COLON) + 1);
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
            intent.putExtra("value", str.substring(str.lastIndexOf(SystemInfoUtil.COLON) + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra("class", 7);
            intent.putExtra("value", str.substring(str.lastIndexOf(SystemInfoUtil.COLON) + 1));
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
        } else if (!str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return null;
        } else {
            intent.putExtra("class", 0);
            intent.putExtra("url", str);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra("link", str);
        intent.putExtra("message_id", akVar.uy());
        intent.putExtra("task_id", akVar.getTaskId());
        if (!TextUtils.isEmpty(akVar.getStat())) {
            intent.putExtra("stat", akVar.getStat());
        }
        return intent;
    }

    public List<e> bqg() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.ghG);
        return linkedList;
    }

    public e bqh() {
        return this.gvx;
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
                    if (F(chatMessage)) {
                        e b = b(chatMessage, i);
                        if (b != null && b.gvR > 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    c(b);
                                } else {
                                    this.gvx = b;
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
                bqi();
            }
        }
    }

    public void c(e eVar) {
        if (this.ghG != null) {
            this.ghG.add(eVar);
        }
    }

    public boolean F(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return false;
        }
        switch (chatMessage.getMsgType()) {
            case 6:
            case 10:
            case 11:
            case 12:
            case 22:
            case 23:
                return false;
            case 1:
                if (chatMessage.getType() != null && chatMessage.getType().getId() == ChatMessage.TYPE_MSG_TEXT_OFFICAL_NOTIFICATION.getId()) {
                    return false;
                }
                break;
        }
        return (StringUtils.isNull(chatMessage.getContent()) || StringUtils.isNull(chatMessage.getUserInfo().getUserName()) || chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkApplication.getCurrentAccountName())) ? false : true;
    }

    public e b(ChatMessage chatMessage, int i) {
        c.a aVar;
        e eVar = new e();
        eVar.gvR = 0;
        eVar.msgType = chatMessage.getMsgType();
        eVar.customGroupType = i;
        eVar.userName = chatMessage.getUserInfo().getUserName();
        eVar.nameShow = chatMessage.getUserInfo().getName_show();
        eVar.gvT = chatMessage.getRecordId();
        eVar.msgId = chatMessage.getMsgId();
        eVar.isAcceptNotify = true;
        eVar.gac = true;
        eVar.followStatus = 1;
        eVar.taskId = chatMessage.getStatTaskId();
        if (eVar.customGroupType == 1) {
            ImMessageCenterPojo ar = com.baidu.tieba.im.memorycache.b.aKX().ar(chatMessage.getGroupId(), 1);
            if (ar != null) {
                eVar.groupName = ar.getGroup_name();
                eVar.gvR = ar.getUnread_count();
                eVar.lastTime = ar.getLast_content_time();
            }
            eVar.content = eVar.userName + SystemInfoUtil.COLON + com.baidu.tieba.im.util.e.U(chatMessage.getMsgType(), chatMessage.getContent());
            eVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DW().El()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aMt().bv(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 2) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo ar2 = com.baidu.tieba.im.memorycache.b.aKX().ar(eVar.groupId, 2);
            if (ar2 != null) {
                eVar.gvR = ar2.getUnread_count();
                eVar.lastTime = ar2.getLast_content_time();
                eVar.gac = ar2.getIsFriend() == 1;
                eVar.followStatus = ar2.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            eVar.content = com.baidu.tieba.im.util.e.U(chatMessage.getMsgType(), chatMessage.getContent());
            if (eVar.gac) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ee()) {
                    eVar.isAcceptNotify = false;
                } else {
                    eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aMw().bv(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ee()) {
                eVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ea()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aMw().bv(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 4) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!TbConfig.IM_USER_ID_TBJX.equals(eVar.groupId) && !"2807977073".equals(eVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo ar3 = com.baidu.tieba.im.memorycache.b.aKX().ar(eVar.groupId, 4);
            if (ar3 != null) {
                eVar.gvR = ar3.getUnread_count();
                eVar.lastTime = ar3.getLast_content_time();
                eVar.gac = ar3.getIsFriend() == 1;
                eVar.followStatus = ar3.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<c.a> a = com.baidu.tieba.im.chat.officialBar.c.a(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (a != null && a.size() > 0 && (aVar = a.get(0)) != null) {
                    eVar.title = aVar.title;
                    eVar.content = aVar.text;
                    eVar.pic = aVar.src;
                    eVar.url = aVar.url;
                }
            } else {
                eVar.content = com.baidu.tieba.im.util.e.U(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ep()) {
                eVar.isAcceptNotify = false;
            }
        }
        return eVar;
    }

    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(v(data));
        }
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.ghG.remove(eVar);
        }
    }

    public e v(ImMessageCenterPojo imMessageCenterPojo) {
        e eVar = new e();
        if (imMessageCenterPojo != null) {
            eVar.gvR = imMessageCenterPojo.getUnread_count();
            eVar.groupId = imMessageCenterPojo.getGid();
            eVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            eVar.groupName = imMessageCenterPojo.getGroup_name();
            eVar.userName = imMessageCenterPojo.getLast_user_name();
            eVar.nameShow = imMessageCenterPojo.getNameShow();
            eVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (eVar.customGroupType == 1) {
                eVar.content = eVar.userName + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
            } else {
                eVar.content = imMessageCenterPojo.getLast_content();
            }
            eVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return eVar;
    }

    public void bqi() {
        e eVar;
        if (com.baidu.adp.lib.b.d.hv().aw("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.DW().DY() && com.baidu.tbadk.coreExtra.messageCenter.c.DW().En()) {
            if ((this.ghG != null && this.ghG.size() != 0) || this.gvx != null) {
                if (!this.gvy.isScreenOn() || this.gvB == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.aDy)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.gvy.bqk();
                        }
                    }, 1000L);
                    if (this.ghG != null && this.ghG.size() > 0 && (eVar = this.ghG.get(0)) != null) {
                        TiebaStatic.logPagePV(new an("c11702").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId));
                    }
                }
            }
        }
    }
}
