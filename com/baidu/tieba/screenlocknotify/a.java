package com.baidu.tieba.screenlocknotify;

import android.app.Activity;
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
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.e;
import com.baidu.ubc.UBC;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {
    private static a iOx;
    public int iOA;
    public int iOB;
    public int iOC;
    public int iOD;
    public int iOE;
    public boolean iOF;
    public final com.baidu.tieba.t.b iOz;
    private List<d> izw = new LinkedList();
    private d iOy = null;
    public boolean iOG = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener gBv = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener iOH = new CustomMessageListener(2001355) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.cje()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.iOz.ctx()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new an("c10316").P("obj_type", 2).P("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new an("c10316").P("obj_type", 1).P("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context appContext = TbadkApplication.getInst().getApp();

    public static a cjd() {
        if (iOx == null) {
            iOx = new a();
        }
        return iOx;
    }

    public void release() {
        this.izw.clear();
        this.iOy = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(2016004, this.gBv);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012121, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.iOH);
        this.iOA = 0;
        this.iOB = 0;
        this.iOC = 0;
        this.iOD = 0;
        this.iOE = 0;
        this.iOF = true;
        this.iOz = new com.baidu.tieba.t.b();
    }

    public static boolean cje() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            d dVar = new d();
            dVar.iOO = 0;
            dVar.msgType = 4;
            dVar.groupId = LivenessStat.TYPE_STRING_DEFAULT;
            dVar.customGroupType = 4;
            dVar.groupName = remindRecommendMessage.name;
            dVar.userName = remindRecommendMessage.name;
            dVar.title = remindRecommendMessage.title;
            dVar.pic = remindRecommendMessage.picture;
            dVar.url = remindRecommendMessage.url;
            dVar.lastTime = System.currentTimeMillis();
            dVar.isAcceptNotify = true;
            dVar.iqr = true;
            dVar.followStatus = 1;
            dVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                dVar.stat = "2";
            } else {
                dVar.stat = "1";
            }
            c(dVar);
            cji();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.appContext, new al(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.appContext, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.appContext, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, al alVar, String str) {
        if (context == null || alVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/") || str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring);
        } else if (str.startsWith("pb:")) {
            String substring2 = str.substring(str.lastIndexOf(":") + 1);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring2);
        } else if (str.startsWith("web:")) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 29);
            intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
        } else if (str.startsWith("pk_before:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 6);
            intent.putExtra(UBC.CONTENT_KEY_VALUE, str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 7);
            intent.putExtra(UBC.CONTENT_KEY_VALUE, str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 8);
        } else if (str.startsWith("twzb:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 31);
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
            intent.putExtra(DealIntentService.KEY_CLASS, 0);
            intent.putExtra("url", str);
        }
        intent.putExtra("is_notify", true);
        intent.putExtra(SelectForumActivityConfig.KEY_SHARE_LINK, str);
        intent.putExtra(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, alVar.adk());
        intent.putExtra("task_id", alVar.getTaskId());
        if (!TextUtils.isEmpty(alVar.getStat())) {
            intent.putExtra("stat", alVar.getStat());
        }
        return intent;
    }

    public List<d> cjf() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.izw);
        return linkedList;
    }

    public d cjg() {
        return this.iOy;
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
                        d b = b(chatMessage, i);
                        if (b != null && b.iOO > 0) {
                            if (!b.isAcceptNotify) {
                                d(b);
                            } else {
                                if (i == 4) {
                                    if (!a(chatMessage, b)) {
                                        c(b);
                                    } else {
                                        return;
                                    }
                                } else {
                                    this.iOy = b;
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
                cji();
            }
        }
    }

    private boolean a(ChatMessage chatMessage, d dVar) {
        if (dVar == null || StringUtils.isNull(dVar.url) || !cjh()) {
            return false;
        }
        Map<String, String> oo = bb.oo(bb.op(dVar.url));
        if (oo == null || com.baidu.adp.lib.g.b.f(oo.get("lockWindow"), 0) != 1) {
            return false;
        }
        long j = dVar.taskId;
        String Ee = Ee(dVar.url);
        if (j == 0 || StringUtils.isNull(Ee)) {
            return false;
        }
        if (UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
            return false;
        }
        if (!this.iOz.ctx()) {
            Activity eU = com.baidu.adp.base.a.eT().eU();
            if (eU != null && eU.getClass() != null && eU.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                eU.finish();
            }
            chatMessage.setHasRead(true);
            NotificationHelper.cancelNotification(this.appContext, 19);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.appContext, j, Ee)));
        }
        TiebaStatic.log(new an("c13196").P("obj_type", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).bT("tid", Ee));
        return true;
    }

    public boolean cjh() {
        return com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoC() && com.baidu.tbadk.coreExtra.messageCenter.d.aok().aom() && com.baidu.adp.lib.b.d.hS().az("android_im_window_open") == 1;
    }

    private String Ee(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public void c(d dVar) {
        if (this.izw != null) {
            this.izw.add(dVar);
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

    public d b(ChatMessage chatMessage, int i) {
        c.a aVar;
        d dVar = new d();
        dVar.iOO = 0;
        dVar.msgType = chatMessage.getMsgType();
        dVar.customGroupType = i;
        dVar.userName = chatMessage.getUserInfo().getUserName();
        dVar.nameShow = chatMessage.getUserInfo().getName_show();
        dVar.iOQ = chatMessage.getRecordId();
        dVar.msgId = chatMessage.getMsgId();
        dVar.isAcceptNotify = true;
        dVar.iqr = true;
        dVar.followStatus = 1;
        dVar.taskId = chatMessage.getStatTaskId();
        if (dVar.customGroupType == 1) {
            ImMessageCenterPojo aQ = com.baidu.tieba.im.memorycache.b.bEZ().aQ(chatMessage.getGroupId(), 1);
            if (aQ != null) {
                dVar.groupName = aQ.getGroup_name();
                dVar.iOO = aQ.getUnread_count();
                dVar.lastTime = aQ.getLast_content_time();
            }
            dVar.content = dVar.userName + ":" + e.aq(chatMessage.getMsgType(), chatMessage.getContent());
            dVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoA()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.bGq().dp(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 2) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo aQ2 = com.baidu.tieba.im.memorycache.b.bEZ().aQ(dVar.groupId, 2);
            if (aQ2 != null) {
                dVar.iOO = aQ2.getUnread_count();
                dVar.lastTime = aQ2.getLast_content_time();
                dVar.iqr = aQ2.getIsFriend() == 1;
                dVar.followStatus = aQ2.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            dVar.content = e.aq(chatMessage.getMsgType(), chatMessage.getContent());
            if (dVar.iqr) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.d.aok().aos()) {
                    dVar.isAcceptNotify = false;
                } else {
                    dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.bGt().dp(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.aok().aos()) {
                dVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoo()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.bGt().dp(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 4) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!TbConfig.IM_USER_ID_TBJX.equals(dVar.groupId) && !"2807977073".equals(dVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo aQ3 = com.baidu.tieba.im.memorycache.b.bEZ().aQ(dVar.groupId, 4);
            if (aQ3 != null) {
                dVar.iOO = aQ3.getUnread_count();
                dVar.lastTime = aQ3.getLast_content_time();
                dVar.iqr = aQ3.getIsFriend() == 1;
                dVar.followStatus = aQ3.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<c.a> h = com.baidu.tieba.im.chat.officialBar.c.h(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (h != null && h.size() > 0 && (aVar = h.get(0)) != null) {
                    dVar.title = aVar.title;
                    dVar.content = aVar.text;
                    dVar.pic = aVar.src;
                    dVar.url = aVar.url;
                    dVar.taskId = aVar.taskId;
                }
            } else {
                dVar.content = e.aq(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoE()) {
                dVar.isAcceptNotify = false;
            }
        }
        return dVar;
    }

    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(v(data));
        }
    }

    public void d(d dVar) {
        if (dVar != null) {
            this.izw.remove(dVar);
        }
    }

    public d v(ImMessageCenterPojo imMessageCenterPojo) {
        d dVar = new d();
        if (imMessageCenterPojo != null) {
            dVar.iOO = imMessageCenterPojo.getUnread_count();
            dVar.groupId = imMessageCenterPojo.getGid();
            dVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            dVar.groupName = imMessageCenterPojo.getGroup_name();
            dVar.userName = imMessageCenterPojo.getLast_user_name();
            dVar.nameShow = imMessageCenterPojo.getNameShow();
            dVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (dVar.customGroupType == 1) {
                dVar.content = dVar.userName + ":" + imMessageCenterPojo.getLast_content();
            } else {
                dVar.content = imMessageCenterPojo.getLast_content();
            }
            dVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return dVar;
    }

    public void cji() {
        d dVar;
        if (cjh()) {
            if ((this.izw != null && this.izw.size() != 0) || this.iOy != null) {
                if (!this.iOz.ctx() || this.iOC == 1) {
                    Activity eU = com.baidu.adp.base.a.eT().eU();
                    if (eU != null && eU.getClass() != null && eU.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        eU.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.appContext)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.iOz.ctv();
                        }
                    }, 1000L);
                    if (this.izw != null && this.izw.size() > 0 && (dVar = this.izw.get(0)) != null) {
                        TiebaStatic.logPagePV(new an("c11702").l("msg_id", dVar.msgId / 100).l("task_id", dVar.taskId));
                    }
                }
            }
        }
    }
}
