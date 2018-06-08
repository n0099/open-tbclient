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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a grF;
    public d grH;
    public int grI;
    public int grJ;
    public int grK;
    public int grL;
    public int grM;
    public boolean grN;
    private List<e> gdF = new LinkedList();
    private e grG = null;
    public boolean grO = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener efD = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener bvy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener grP = new CustomMessageListener(2001355) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.bpE()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.grH.isScreenOn()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new am("c10316").r("obj_type", 2).r("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new am("c10316").r("obj_type", 1).r("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context aCE = TbadkApplication.getInst().getApp();

    public static a bpD() {
        if (grF == null) {
            grF = new a();
        }
        return grF;
    }

    public void release() {
        this.gdF.clear();
        this.grG = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(2016004, this.efD);
        MessageManager.getInstance().registerListener(this.bvy);
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012121, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.grP);
        this.grI = 0;
        this.grJ = 0;
        this.grK = 0;
        this.grL = 0;
        this.grM = 0;
        this.grN = true;
        this.grH = new d();
    }

    public static boolean bpE() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            e eVar = new e();
            eVar.gsa = 0;
            eVar.msgType = 4;
            eVar.groupId = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            eVar.customGroupType = 4;
            eVar.groupName = remindRecommendMessage.name;
            eVar.userName = remindRecommendMessage.name;
            eVar.title = remindRecommendMessage.title;
            eVar.pic = remindRecommendMessage.picture;
            eVar.url = remindRecommendMessage.url;
            eVar.dyC = System.currentTimeMillis();
            eVar.isAcceptNotify = true;
            eVar.fWc = true;
            eVar.followStatus = 1;
            eVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                eVar.stat = "2";
            } else {
                eVar.stat = "1";
            }
            c(eVar);
            bpH();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.aCE, new ak(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.aCE, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.aCE, 0, a, 134217728), false);
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
        } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return null;
        } else {
            intent.putExtra("class", 0);
            intent.putExtra("url", str);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra("link", str);
        intent.putExtra("message_id", akVar.uq());
        intent.putExtra("task_id", akVar.getTaskId());
        if (!TextUtils.isEmpty(akVar.getStat())) {
            intent.putExtra("stat", akVar.getStat());
        }
        return intent;
    }

    public List<e> bpF() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.gdF);
        return linkedList;
    }

    public e bpG() {
        return this.grG;
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
            n(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void n(List<ChatMessage> list, int i) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            boolean z2 = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null) {
                    if (F(chatMessage)) {
                        e b = b(chatMessage, i);
                        if (b != null && b.gsa > 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    c(b);
                                } else {
                                    this.grG = b;
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
                bpH();
            }
        }
    }

    public void c(e eVar) {
        if (this.gdF != null) {
            this.gdF.add(eVar);
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
        eVar.gsa = 0;
        eVar.msgType = chatMessage.getMsgType();
        eVar.customGroupType = i;
        eVar.userName = chatMessage.getUserInfo().getUserName();
        eVar.nameShow = chatMessage.getUserInfo().getName_show();
        eVar.gsc = chatMessage.getRecordId();
        eVar.msgId = chatMessage.getMsgId();
        eVar.isAcceptNotify = true;
        eVar.fWc = true;
        eVar.followStatus = 1;
        eVar.taskId = chatMessage.getStatTaskId();
        if (eVar.customGroupType == 1) {
            ImMessageCenterPojo as = com.baidu.tieba.im.memorycache.b.aKr().as(chatMessage.getGroupId(), 1);
            if (as != null) {
                eVar.groupName = as.getGroup_name();
                eVar.gsa = as.getUnread_count();
                eVar.dyC = as.getLast_content_time();
            }
            eVar.content = eVar.userName + SystemInfoUtil.COLON + com.baidu.tieba.im.util.e.X(chatMessage.getMsgType(), chatMessage.getContent());
            eVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DT()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aLN().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 2) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo as2 = com.baidu.tieba.im.memorycache.b.aKr().as(eVar.groupId, 2);
            if (as2 != null) {
                eVar.gsa = as2.getUnread_count();
                eVar.dyC = as2.getLast_content_time();
                eVar.fWc = as2.getIsFriend() == 1;
                eVar.followStatus = as2.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            eVar.content = com.baidu.tieba.im.util.e.X(chatMessage.getMsgType(), chatMessage.getContent());
            if (eVar.fWc) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM()) {
                    eVar.isAcceptNotify = false;
                } else {
                    eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aLQ().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM()) {
                eVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DI()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aLQ().br(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 4) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!TbConfig.IM_USER_ID_TBJX.equals(eVar.groupId) && !"2807977073".equals(eVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo as3 = com.baidu.tieba.im.memorycache.b.aKr().as(eVar.groupId, 4);
            if (as3 != null) {
                eVar.gsa = as3.getUnread_count();
                eVar.dyC = as3.getLast_content_time();
                eVar.fWc = as3.getIsFriend() == 1;
                eVar.followStatus = as3.getFollowStatus();
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
                eVar.content = com.baidu.tieba.im.util.e.X(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DX()) {
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
            this.gdF.remove(eVar);
        }
    }

    public e v(ImMessageCenterPojo imMessageCenterPojo) {
        e eVar = new e();
        if (imMessageCenterPojo != null) {
            eVar.gsa = imMessageCenterPojo.getUnread_count();
            eVar.groupId = imMessageCenterPojo.getGid();
            eVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            eVar.groupName = imMessageCenterPojo.getGroup_name();
            eVar.userName = imMessageCenterPojo.getLast_user_name();
            eVar.nameShow = imMessageCenterPojo.getNameShow();
            eVar.dyC = imMessageCenterPojo.getLast_content_time();
            if (eVar.customGroupType == 1) {
                eVar.content = eVar.userName + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
            } else {
                eVar.content = imMessageCenterPojo.getLast_content();
            }
            eVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return eVar;
    }

    public void bpH() {
        e eVar;
        if (com.baidu.adp.lib.b.d.hv().aw("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.DE().DG() && com.baidu.tbadk.coreExtra.messageCenter.c.DE().DV()) {
            if ((this.gdF != null && this.gdF.size() != 0) || this.grG != null) {
                if (!this.grH.isScreenOn() || this.grK == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.aCE)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.grH.bpJ();
                        }
                    }, 1000L);
                    if (this.gdF != null && this.gdF.size() > 0 && (eVar = this.gdF.get(0)) != null) {
                        TiebaStatic.logPagePV(new am("c11702").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId));
                    }
                }
            }
        }
    }
}
