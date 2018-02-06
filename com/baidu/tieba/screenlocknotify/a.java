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
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.aj;
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
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static a gKh;
    public d gKj;
    public int gKk;
    public int gKl;
    public int gKm;
    public int gKn;
    public int gKo;
    public boolean gKp;
    private List<e> gwz = new LinkedList();
    private e gKi = null;
    public boolean gKq = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener eyF = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener cdn = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener gKr = new CustomMessageListener(2001355) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.bpA()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.gKj.isScreenOn()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new ak("c10316").s("obj_type", 2).s("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new ak("c10316").s("obj_type", 1).s("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context biY = TbadkApplication.getInst().getApp();

    public static a bpz() {
        if (gKh == null) {
            gKh = new a();
        }
        return gKh;
    }

    public void release() {
        this.gwz.clear();
        this.gKi = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(2016004, this.eyF);
        MessageManager.getInstance().registerListener(this.cdn);
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012121, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.gKr);
        this.gKk = 0;
        this.gKl = 0;
        this.gKm = 0;
        this.gKn = 0;
        this.gKo = 0;
        this.gKp = true;
        this.gKj = new d();
    }

    public static boolean bpA() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            e eVar = new e();
            eVar.gKC = 0;
            eVar.msgType = 4;
            eVar.groupId = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            eVar.customGroupType = 4;
            eVar.groupName = remindRecommendMessage.name;
            eVar.userName = remindRecommendMessage.name;
            eVar.title = remindRecommendMessage.title;
            eVar.pic = remindRecommendMessage.picture;
            eVar.url = remindRecommendMessage.url;
            eVar.dUc = System.currentTimeMillis();
            eVar.isAcceptNotify = true;
            eVar.gpg = true;
            eVar.followStatus = 1;
            eVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                eVar.stat = "2";
            } else {
                eVar.stat = "1";
            }
            c(eVar);
            bpD();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.biY, new aj(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.biY, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.biY, 0, a, 134217728), false);
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
        intent.putExtra("message_id", ajVar.yp());
        intent.putExtra("task_id", ajVar.getTaskId());
        if (!TextUtils.isEmpty(ajVar.getStat())) {
            intent.putExtra("stat", ajVar.getStat());
        }
        return intent;
    }

    public List<e> bpB() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.gwz);
        return linkedList;
    }

    public e bpC() {
        return this.gKi;
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
            q(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void q(List<ChatMessage> list, int i) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            boolean z2 = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null) {
                    if (F(chatMessage)) {
                        e b = b(chatMessage, i);
                        if (b != null && b.gKC > 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    c(b);
                                } else {
                                    this.gKi = b;
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
                bpD();
            }
        }
    }

    public void c(e eVar) {
        if (this.gwz != null) {
            this.gwz.add(eVar);
        }
    }

    public boolean F(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return false;
        }
        switch (chatMessage.getMsgType()) {
            case 1:
            case 6:
            case 10:
            case 11:
            case 12:
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
        eVar.gKC = 0;
        eVar.msgType = chatMessage.getMsgType();
        eVar.customGroupType = i;
        eVar.userName = chatMessage.getUserInfo().getUserName();
        eVar.gKE = chatMessage.getRecordId();
        eVar.msgId = chatMessage.getMsgId();
        eVar.isAcceptNotify = true;
        eVar.gpg = true;
        eVar.followStatus = 1;
        eVar.taskId = chatMessage.getStatTaskId();
        if (eVar.customGroupType == 1) {
            ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aKB().an(chatMessage.getGroupId(), 1);
            if (an != null) {
                eVar.groupName = an.getGroup_name();
                eVar.gKC = an.getUnread_count();
                eVar.dUc = an.getLast_content_time();
            }
            eVar.content = eVar.userName + ":" + com.baidu.tieba.im.util.e.O(chatMessage.getMsgType(), chatMessage.getContent());
            eVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aLU().bk(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 2) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo an2 = com.baidu.tieba.im.memorycache.b.aKB().an(eVar.groupId, 2);
            if (an2 != null) {
                eVar.gKC = an2.getUnread_count();
                eVar.dUc = an2.getLast_content_time();
                eVar.gpg = an2.getIsFriend() == 1;
                eVar.followStatus = an2.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            eVar.content = com.baidu.tieba.im.util.e.O(chatMessage.getMsgType(), chatMessage.getContent());
            if (eVar.gpg) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy()) {
                    eVar.isAcceptNotify = false;
                } else {
                    eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aLX().bk(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy()) {
                eVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hu()) {
                eVar.isAcceptNotify = false;
            } else {
                eVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aLX().bk(TbadkCoreApplication.getCurrentAccount(), eVar.groupId);
            }
        } else if (eVar.customGroupType == 4) {
            eVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(eVar.groupId) && !"2807977073".equals(eVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo an3 = com.baidu.tieba.im.memorycache.b.aKB().an(eVar.groupId, 4);
            if (an3 != null) {
                eVar.gKC = an3.getUnread_count();
                eVar.dUc = an3.getLast_content_time();
                eVar.gpg = an3.getIsFriend() == 1;
                eVar.followStatus = an3.getFollowStatus();
            }
            eVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<g.a> a = g.a(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (a != null && a.size() > 0 && (aVar = a.get(0)) != null) {
                    eVar.title = aVar.title;
                    eVar.content = aVar.text;
                    eVar.pic = aVar.src;
                    eVar.url = aVar.url;
                }
            } else {
                eVar.content = com.baidu.tieba.im.util.e.O(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HJ()) {
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
            d(v(data));
        }
    }

    public void d(e eVar) {
        if (eVar != null) {
            this.gwz.remove(eVar);
        }
    }

    public e v(ImMessageCenterPojo imMessageCenterPojo) {
        e eVar = new e();
        if (imMessageCenterPojo != null) {
            eVar.gKC = imMessageCenterPojo.getUnread_count();
            eVar.groupId = imMessageCenterPojo.getGid();
            eVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            eVar.groupName = imMessageCenterPojo.getGroup_name();
            eVar.userName = imMessageCenterPojo.getLast_user_name();
            eVar.dUc = imMessageCenterPojo.getLast_content_time();
            if (eVar.customGroupType == 1) {
                eVar.content = eVar.userName + ":" + imMessageCenterPojo.getLast_content();
            } else {
                eVar.content = imMessageCenterPojo.getLast_content();
            }
            eVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return eVar;
    }

    public void bpD() {
        e eVar;
        if (com.baidu.adp.lib.b.d.mA().an("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hs() && com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HH()) {
            if ((this.gwz != null && this.gwz.size() != 0) || this.gKi != null) {
                if (!this.gKj.isScreenOn() || this.gKm == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.biY)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.gKj.bpF();
                        }
                    }, 1000L);
                    if (this.gwz != null && this.gwz.size() > 0 && (eVar = this.gwz.get(0)) != null) {
                        TiebaStatic.logPagePV(new ak("c11702").f("msg_id", eVar.msgId / 100).f("task_id", eVar.taskId));
                    }
                }
            }
        }
    }
}
