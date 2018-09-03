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
import com.baidu.ar.util.SystemInfoUtil;
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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.e;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {
    private static a gwL;
    public final com.baidu.tieba.t.a gwN;
    public int gwO;
    public int gwP;
    public int gwQ;
    public int gwR;
    public int gwS;
    public boolean gwT;
    private List<d> gig = new LinkedList();
    private d gwM = null;
    public boolean gwU = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener enk = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener gwV = new CustomMessageListener(2001355) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.boL()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.gwN.isScreenOn()) {
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
    private final Context aDx = TbadkApplication.getInst().getApp();

    public static a boK() {
        if (gwL == null) {
            gwL = new a();
        }
        return gwL;
    }

    public void release() {
        this.gig.clear();
        this.gwM = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(2016004, this.enk);
        MessageManager.getInstance().registerListener(this.bxA);
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012121, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.gwV);
        this.gwO = 0;
        this.gwP = 0;
        this.gwQ = 0;
        this.gwR = 0;
        this.gwS = 0;
        this.gwT = true;
        this.gwN = new com.baidu.tieba.t.a();
    }

    public static boolean boL() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            d dVar = new d();
            dVar.gxc = 0;
            dVar.msgType = 4;
            dVar.groupId = "-1";
            dVar.customGroupType = 4;
            dVar.groupName = remindRecommendMessage.name;
            dVar.userName = remindRecommendMessage.name;
            dVar.title = remindRecommendMessage.title;
            dVar.pic = remindRecommendMessage.picture;
            dVar.url = remindRecommendMessage.url;
            dVar.lastTime = System.currentTimeMillis();
            dVar.isAcceptNotify = true;
            dVar.gat = true;
            dVar.followStatus = 1;
            dVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                dVar.stat = "2";
            } else {
                dVar.stat = "1";
            }
            c(dVar);
            boP();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.aDx, new aj(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.aDx, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.aDx, 0, a, 134217728), false);
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
        intent.putExtra("message_id", ajVar.uk());
        intent.putExtra("task_id", ajVar.getTaskId());
        if (!TextUtils.isEmpty(ajVar.getStat())) {
            intent.putExtra("stat", ajVar.getStat());
        }
        return intent;
    }

    public List<d> boM() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.gig);
        return linkedList;
    }

    public d boN() {
        return this.gwM;
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
                        if (b != null && b.gxc > 0) {
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
                                    this.gwM = b;
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
                boP();
            }
        }
    }

    private boolean a(ChatMessage chatMessage, d dVar) {
        if (dVar == null || StringUtils.isNull(dVar.url) || !boO()) {
            return false;
        }
        Map<String, String> eP = az.eP(az.eQ(dVar.url));
        if (eP == null || com.baidu.adp.lib.g.b.g(eP.get("lockWindow"), 0) != 1) {
            return false;
        }
        long j = dVar.taskId;
        String ti = ti(dVar.url);
        if (j == 0 || StringUtils.isNull(ti)) {
            return false;
        }
        if (UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
            return false;
        }
        if (!this.gwN.isScreenOn()) {
            Activity ex = com.baidu.adp.base.a.ew().ex();
            if (ex != null && ex.getClass() != null && ex.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                ex.finish();
            }
            chatMessage.setHasRead(true);
            NotificationHelper.cancelNotification(this.aDx, 19);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.aDx, j, ti)));
        }
        TiebaStatic.log(new an("c13196").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).ae("tid", ti));
        return true;
    }

    public boolean boO() {
        return com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ej() && com.baidu.tbadk.coreExtra.messageCenter.c.DS().DU() && com.baidu.adp.lib.b.d.hv().ax("android_im_window_open") == 1;
    }

    private String ti(String str) {
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
        if (this.gig != null) {
            this.gig.add(dVar);
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
        dVar.gxc = 0;
        dVar.msgType = chatMessage.getMsgType();
        dVar.customGroupType = i;
        dVar.userName = chatMessage.getUserInfo().getUserName();
        dVar.nameShow = chatMessage.getUserInfo().getName_show();
        dVar.gxe = chatMessage.getRecordId();
        dVar.msgId = chatMessage.getMsgId();
        dVar.isAcceptNotify = true;
        dVar.gat = true;
        dVar.followStatus = 1;
        dVar.taskId = chatMessage.getStatTaskId();
        if (dVar.customGroupType == 1) {
            ImMessageCenterPojo an = com.baidu.tieba.im.memorycache.b.aLV().an(chatMessage.getGroupId(), 1);
            if (an != null) {
                dVar.groupName = an.getGroup_name();
                dVar.gxc = an.getUnread_count();
                dVar.lastTime = an.getLast_content_time();
            }
            dVar.content = dVar.userName + SystemInfoUtil.COLON + e.W(chatMessage.getMsgType(), chatMessage.getContent());
            dVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.aNq().bt(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 2) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo an2 = com.baidu.tieba.im.memorycache.b.aLV().an(dVar.groupId, 2);
            if (an2 != null) {
                dVar.gxc = an2.getUnread_count();
                dVar.lastTime = an2.getLast_content_time();
                dVar.gat = an2.getIsFriend() == 1;
                dVar.followStatus = an2.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            dVar.content = e.W(chatMessage.getMsgType(), chatMessage.getContent());
            if (dVar.gat) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
                    dVar.isAcceptNotify = false;
                } else {
                    dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aNt().bt(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
                dVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DW()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.aNt().bt(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 4) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!TbConfig.IM_USER_ID_TBJX.equals(dVar.groupId) && !"2807977073".equals(dVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo an3 = com.baidu.tieba.im.memorycache.b.aLV().an(dVar.groupId, 4);
            if (an3 != null) {
                dVar.gxc = an3.getUnread_count();
                dVar.lastTime = an3.getLast_content_time();
                dVar.gat = an3.getIsFriend() == 1;
                dVar.followStatus = an3.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<c.a> a = com.baidu.tieba.im.chat.officialBar.c.a(chatMessage.getContent(), null, chatMessage.getStatTaskId());
                if (a != null && a.size() > 0 && (aVar = a.get(0)) != null) {
                    dVar.title = aVar.title;
                    dVar.content = aVar.text;
                    dVar.pic = aVar.src;
                    dVar.url = aVar.url;
                    dVar.taskId = aVar.taskId;
                }
            } else {
                dVar.content = e.W(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().El()) {
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
            this.gig.remove(dVar);
        }
    }

    public d v(ImMessageCenterPojo imMessageCenterPojo) {
        d dVar = new d();
        if (imMessageCenterPojo != null) {
            dVar.gxc = imMessageCenterPojo.getUnread_count();
            dVar.groupId = imMessageCenterPojo.getGid();
            dVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            dVar.groupName = imMessageCenterPojo.getGroup_name();
            dVar.userName = imMessageCenterPojo.getLast_user_name();
            dVar.nameShow = imMessageCenterPojo.getNameShow();
            dVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (dVar.customGroupType == 1) {
                dVar.content = dVar.userName + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
            } else {
                dVar.content = imMessageCenterPojo.getLast_content();
            }
            dVar.taskId = com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getTaskId(), 0L);
        }
        return dVar;
    }

    public void boP() {
        d dVar;
        if (boO()) {
            if ((this.gig != null && this.gig.size() != 0) || this.gwM != null) {
                if (!this.gwN.isScreenOn() || this.gwQ == 1) {
                    Activity ex = com.baidu.adp.base.a.ew().ex();
                    if (ex != null && ex.getClass() != null && ex.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        ex.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.aDx)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.gwN.bAc();
                        }
                    }, 1000L);
                    if (this.gig != null && this.gig.size() > 0 && (dVar = this.gig.get(0)) != null) {
                        TiebaStatic.logPagePV(new an("c11702").f("msg_id", dVar.msgId / 100).f("task_id", dVar.taskId));
                    }
                }
            }
        }
    }
}
