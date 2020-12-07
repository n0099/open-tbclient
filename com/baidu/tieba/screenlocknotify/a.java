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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.ScreenLockSyncSwitch;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.tieba.im.util.e;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes21.dex */
public class a {
    private static a mRH;
    public final com.baidu.tieba.w.b mRJ;
    public int mRK;
    public int mRL;
    public int mRM;
    public int mRN;
    public int mRO;
    public boolean mRP;
    private List<d> mAX = new LinkedList();
    private d mRI = null;
    public boolean mRQ = false;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.screenlocknotify.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };
    private CustomMessageListener kne = new CustomMessageListener(0) { // from class: com.baidu.tieba.screenlocknotify.a.2
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
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.screenlocknotify.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.release();
            }
        }
    };
    private CustomMessageListener mRR = new CustomMessageListener(CmdConfigCustom.CMD_SCREEN_DIALOG) { // from class: com.baidu.tieba.screenlocknotify.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.dHa()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.mRJ.dTA()) {
                        a.this.b(remindRecommendMessage);
                    } else {
                        a.this.a(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new ar("c10316").al("obj_type", 2).al("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new ar("c10316").al("obj_type", 1).al("obj_locate", 1));
                    }
                }
            }
        }
    };
    private final Context appContext = TbadkApplication.getInst().getApp();

    public static a dGZ() {
        if (mRH == null) {
            mRH = new a();
        }
        return mRH;
    }

    public void release() {
        this.mAX.clear();
        this.mRI = null;
    }

    private a() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kne);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.mRR);
        this.mRK = 0;
        this.mRL = 0;
        this.mRM = 0;
        this.mRN = 0;
        this.mRO = 0;
        this.mRP = true;
        this.mRJ = new com.baidu.tieba.w.b();
    }

    public static boolean dHa() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append(SharedPrefConfig.REMIND_RECOMMEND_SERVER_SWITCH).toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            d dVar = new d();
            dVar.mRY = 0;
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
            dVar.mrk = true;
            dVar.followStatus = 1;
            dVar.taskId = 0L;
            if (remindRecommendMessage.isLocal) {
                dVar.stat = "2";
            } else {
                dVar.stat = "1";
            }
            c(dVar);
            dHe();
            TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_RECOMMEND_INFO, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a2 = a(this.appContext, new av(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
            if (a2 != null) {
                NotificationHelper.showNotification(this.appContext, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.appContext, 0, a2, 134217728), false);
                TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_RECOMMEND_INFO, "");
            }
        }
    }

    public final Intent a(Context context, av avVar, String str) {
        if (context == null || avVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        if (str.startsWith("http://tieba.baidu.com/p/") || str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
            String substring2 = str.substring(str.lastIndexOf(":") + 1);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("key_start_from", 7);
            intent.putExtra("id", substring2);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
            if (!str.contains("ftid=")) {
                return null;
            }
            intent.putExtra(DealIntentService.KEY_CLASS, 29);
            intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
        } else if (str.startsWith("pk_before:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 6);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("pk_after:")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 7);
            intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
        } else if (str.startsWith("vote")) {
            intent.putExtra(DealIntentService.KEY_CLASS, 8);
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
            intent.putExtra(DealIntentService.KEY_CLASS, 31);
            String substring3 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
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
        intent.putExtra("link", str);
        intent.putExtra("message_id", avVar.getMessageID());
        intent.putExtra("task_id", avVar.getTaskId());
        if (!TextUtils.isEmpty(avVar.getStat())) {
            intent.putExtra("stat", avVar.getStat());
        }
        return intent;
    }

    public List<d> dHb() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mAX);
        return linkedList;
    }

    public d dHc() {
        return this.mRI;
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
            u(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void u(List<ChatMessage> list, int i) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            boolean z2 = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null) {
                    if (A(chatMessage)) {
                        d b = b(chatMessage, i);
                        if (b != null && b.mRY > 0) {
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
                                    this.mRI = b;
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
                dHe();
            }
        }
    }

    private boolean a(ChatMessage chatMessage, d dVar) {
        if (dVar == null || StringUtils.isNull(dVar.url) || !dHd()) {
            return false;
        }
        Map<String, String> paramPair = bf.getParamPair(bf.getParamStr(dVar.url));
        if (paramPair == null || com.baidu.adp.lib.f.b.toInt(paramPair.get("lockWindow"), 0) != 1) {
            return false;
        }
        long j = dVar.taskId;
        String SA = SA(dVar.url);
        if (j == 0 || StringUtils.isNull(SA)) {
            return false;
        }
        if (UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
            return false;
        }
        if (!this.mRJ.dTA()) {
            Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
            if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                currentActivity.finish();
            }
            chatMessage.setHasRead(true);
            NotificationHelper.cancelNotification(this.appContext, 19);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushDialogActivityConfig(this.appContext, j, SA)));
        }
        TiebaStatic.log(new ar("c13196").al("obj_type", 1).al("obj_source", 2).dY("tid", SA));
        return true;
    }

    public boolean dHd() {
        return com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzD() && com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzn() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1;
    }

    private String SA(String str) {
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
        if (this.mAX != null) {
            this.mAX.add(dVar);
        }
    }

    public boolean A(ChatMessage chatMessage) {
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
            default:
                return (StringUtils.isNull(chatMessage.getContent()) || StringUtils.isNull(chatMessage.getUserInfo().getUserName()) || chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkApplication.getCurrentAccountName())) ? false : true;
        }
    }

    public d b(ChatMessage chatMessage, int i) {
        a.C0782a c0782a;
        d dVar = new d();
        dVar.mRY = 0;
        dVar.msgType = chatMessage.getMsgType();
        dVar.customGroupType = i;
        dVar.userName = chatMessage.getUserInfo().getUserName();
        dVar.nameShow = chatMessage.getUserInfo().getName_show();
        dVar.mSa = chatMessage.getRecordId();
        dVar.msgId = chatMessage.getMsgId();
        dVar.isAcceptNotify = true;
        dVar.mrk = true;
        dVar.followStatus = 1;
        dVar.taskId = chatMessage.getStatTaskId();
        dVar.serviceId = chatMessage.getStatisticsServiceId();
        if (dVar.customGroupType == 1) {
            ImMessageCenterPojo bl = com.baidu.tieba.im.memorycache.b.cYC().bl(chatMessage.getGroupId(), 1);
            if (bl != null) {
                dVar.groupName = bl.getGroup_name();
                dVar.mRY = bl.getUnread_count();
                dVar.lastTime = bl.getLast_content_time();
            }
            dVar.content = dVar.userName + ":" + e.by(chatMessage.getMsgType(), chatMessage.getContent());
            dVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzB()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.b.cZW().fy(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 2) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo bl2 = com.baidu.tieba.im.memorycache.b.cYC().bl(dVar.groupId, 2);
            if (bl2 != null) {
                dVar.mRY = bl2.getUnread_count();
                dVar.lastTime = bl2.getLast_content_time();
                dVar.mrk = bl2.getIsFriend() == 1;
                dVar.followStatus = bl2.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            dVar.content = e.by(chatMessage.getMsgType(), chatMessage.getContent());
            if (dVar.mrk) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt()) {
                    dVar.isAcceptNotify = false;
                } else {
                    dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.cZZ().fy(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt()) {
                dVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzp()) {
                dVar.isAcceptNotify = false;
            } else {
                dVar.isAcceptNotify = com.baidu.tieba.im.settingcache.e.cZZ().fy(TbadkCoreApplication.getCurrentAccount(), dVar.groupId);
            }
        } else if (dVar.customGroupType == 4) {
            dVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!TbConfig.IM_USER_ID_TBJX.equals(dVar.groupId) && !"2807977073".equals(dVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo bl3 = com.baidu.tieba.im.memorycache.b.cYC().bl(dVar.groupId, 4);
            if (bl3 != null) {
                dVar.mRY = bl3.getUnread_count();
                dVar.lastTime = bl3.getLast_content_time();
                dVar.mrk = bl3.getIsFriend() == 1;
                dVar.followStatus = bl3.getFollowStatus();
            }
            dVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<a.C0782a> c = com.baidu.tieba.im.message.chat.a.c(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (c != null && c.size() > 0 && (c0782a = c.get(0)) != null) {
                    dVar.title = c0782a.title;
                    dVar.content = c0782a.text;
                    dVar.pic = c0782a.src;
                    dVar.url = c0782a.url;
                    dVar.taskId = c0782a.taskId;
                    dVar.serviceId = c0782a.serviceId;
                }
            } else {
                dVar.content = e.by(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF()) {
                dVar.isAcceptNotify = false;
            }
        }
        return dVar;
    }

    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            d(s(data));
        }
    }

    public void d(d dVar) {
        if (dVar != null) {
            this.mAX.remove(dVar);
        }
    }

    public d s(ImMessageCenterPojo imMessageCenterPojo) {
        d dVar = new d();
        if (imMessageCenterPojo != null) {
            dVar.mRY = imMessageCenterPojo.getUnread_count();
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
            dVar.taskId = com.baidu.adp.lib.f.b.toLong(imMessageCenterPojo.getTaskId(), 0L);
        }
        return dVar;
    }

    public void dHe() {
        d dVar;
        if (dHd()) {
            if ((this.mAX != null && this.mAX.size() != 0) || this.mRI != null) {
                if (!this.mRJ.dTA() || this.mRM == 1) {
                    Activity currentActivity = com.baidu.adp.base.a.lg().currentActivity();
                    if (currentActivity != null && currentActivity.getClass() != null && currentActivity.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                        currentActivity.finish();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.appContext)));
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.screenlocknotify.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.mRJ.dTy();
                        }
                    }, 1000L);
                    if (this.mAX != null && this.mAX.size() > 0 && (dVar = this.mAX.get(0)) != null) {
                        TiebaStatic.logPagePV(new ar("c11702").w("msg_id", dVar.msgId / 100).w("task_id", dVar.taskId));
                    }
                }
            }
        }
    }
}
