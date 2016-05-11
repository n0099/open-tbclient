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
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.im.chat.officialBar.r;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f ecN;
    public o ecR;
    public int ecS;
    public int ecT;
    public int ecU;
    public int ecV;
    public int ecW;
    public boolean ecX;
    private List<p> dUu = new LinkedList();
    private List<p> ecP = new LinkedList();
    private HashMap<String, LinkedList<p>> ecQ = new HashMap<>();
    public boolean ecY = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener cco = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener czq = new j(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener ecZ = new k(this, CmdConfigCustom.CMD_SCREEN_DIALOG);
    private final Context agB = TbadkApplication.getInst().getApp();
    private KeyguardManager ecO = (KeyguardManager) this.agB.getSystemService("keyguard");

    public static f aMP() {
        if (ecN == null) {
            ecN = new f();
        }
        return ecN;
    }

    private f() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cco);
        MessageManager.getInstance().registerListener(this.czq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.ecZ);
        this.ecS = 0;
        this.ecT = 0;
        this.ecU = 0;
        this.ecV = 0;
        this.ecW = 0;
        this.ecX = true;
        this.ecR = new o();
    }

    public static boolean aMQ() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            p pVar = new p();
            pVar.edp = 0;
            pVar.msgType = 4;
            pVar.groupId = "-1";
            pVar.customGroupType = 4;
            pVar.groupName = remindRecommendMessage.name;
            pVar.userName = remindRecommendMessage.name;
            pVar.title = remindRecommendMessage.title;
            pVar.pic = remindRecommendMessage.picture;
            pVar.url = remindRecommendMessage.url;
            pVar.lastTime = System.currentTimeMillis();
            pVar.isAcceptNotify = true;
            pVar.eds = true;
            if (remindRecommendMessage.isLocal) {
                pVar.stat = "2";
            } else {
                pVar.stat = "1";
            }
            a(pVar, this.ecP, true);
            b(pVar);
            aMT();
            aMV();
            TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.agB, new ac(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.agB, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.agB, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ac acVar, String str) {
        if (context == null || acVar == null || TextUtils.isEmpty(str)) {
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
        intent.putExtra("message_id", acVar.pE());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, acVar.getTaskId());
        if (!TextUtils.isEmpty(acVar.getStat())) {
            intent.putExtra("stat", acVar.getStat());
        }
        return intent;
    }

    public List<p> aMR() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.dUu);
        return linkedList;
    }

    public List<p> aMS() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.ecP);
        return linkedList;
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
            n(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void n(List<ChatMessage> list, int i) {
        p a;
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && B(chatMessage) && (a = a(chatMessage, i)) != null && a.edp > 0) {
                    if (!a.isAcceptNotify) {
                        c(a);
                    } else {
                        if (i == 4) {
                            a(a, this.ecP, true);
                        } else {
                            a(a, this.ecP, false);
                        }
                        b(a);
                        z = true;
                    }
                }
            }
            aMT();
            if (z) {
                aMV();
            }
        }
    }

    public void aMT() {
        if (this.dUu != null && this.ecP != null) {
            this.dUu.clear();
            if (this.ecP.size() > 1) {
                this.dUu.addAll(this.ecP);
            } else if (this.ecP.size() == 1) {
                this.dUu.addAll(this.ecQ.get(this.ecP.get(0).groupId));
            }
        }
    }

    public boolean B(ChatMessage chatMessage) {
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

    public p a(ChatMessage chatMessage, int i) {
        r.a aVar;
        p pVar = new p();
        pVar.edp = 0;
        pVar.msgType = chatMessage.getMsgType();
        pVar.customGroupType = i;
        pVar.userName = chatMessage.getUserInfo().getUserName();
        pVar.edr = chatMessage.getRecordId();
        pVar.isAcceptNotify = true;
        pVar.eds = true;
        if (pVar.customGroupType == 1) {
            ImMessageCenterPojo aa = com.baidu.tieba.im.memorycache.b.agY().aa(chatMessage.getGroupId(), 1);
            if (aa != null) {
                pVar.groupName = aa.getGroup_name();
                pVar.edp = aa.getUnread_count();
                pVar.lastTime = aa.getLast_content_time();
            }
            pVar.content = String.valueOf(pVar.userName) + ":" + com.baidu.tieba.im.util.h.x(chatMessage.getMsgType(), chatMessage.getContent());
            pVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xU()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.air().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 2) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo aa2 = com.baidu.tieba.im.memorycache.b.agY().aa(pVar.groupId, 2);
            if (aa2 != null) {
                pVar.edp = aa2.getUnread_count();
                pVar.lastTime = aa2.getLast_content_time();
                pVar.eds = aa2.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            pVar.content = com.baidu.tieba.im.util.h.x(chatMessage.getMsgType(), chatMessage.getContent());
            if (pVar.eds) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xN()) {
                    pVar.isAcceptNotify = false;
                } else {
                    pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aiu().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xN()) {
                pVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().xJ()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aiu().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 4) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(pVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo aa3 = com.baidu.tieba.im.memorycache.b.agY().aa(pVar.groupId, 4);
            if (aa3 != null) {
                pVar.edp = aa3.getUnread_count();
                pVar.lastTime = aa3.getLast_content_time();
                pVar.eds = aa3.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<r.a> aY = r.aY(chatMessage.getContent(), null);
                if (aY != null && aY.size() > 0 && (aVar = aY.get(0)) != null) {
                    pVar.title = aVar.title;
                    pVar.content = aVar.text;
                    pVar.pic = aVar.src;
                }
            } else {
                pVar.content = com.baidu.tieba.im.util.h.x(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().ya()) {
                pVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m11getInst().isPromotedMessageOn()) {
                pVar.isAcceptNotify = false;
            }
        }
        return pVar;
    }

    public void a(p pVar, List<p> list, boolean z) {
        if (pVar != null && list != null) {
            a(pVar, list);
            if (z || list.size() == 0) {
                list.add(pVar);
            } else {
                list.add(0, pVar);
            }
        }
    }

    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            c(y(data));
        }
    }

    public void b(p pVar) {
        if (pVar != null) {
            LinkedList<p> linkedList = this.ecQ.get(pVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(pVar);
            } else {
                a(linkedList, pVar);
                linkedList.add(pVar);
            }
            this.ecQ.put(pVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<p> linkedList, p pVar) {
        if (linkedList != null && !linkedList.isEmpty() && pVar != null) {
            if (pVar.customGroupType == 4) {
                linkedList.clear();
                return;
            }
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.edr == pVar.edr) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(p pVar) {
        if (pVar != null && this.ecQ != null && this.ecQ.size() != 0) {
            this.ecQ.remove(pVar.groupId);
            if (this.ecP != null && this.ecP.size() != 0) {
                a(pVar, this.ecP);
                aMT();
            }
        }
    }

    public void aMU() {
        if (this.ecP != null) {
            this.ecP.clear();
        }
        if (this.dUu != null) {
            this.dUu.clear();
        }
        if (this.ecQ != null) {
            this.ecQ.clear();
        }
    }

    public p y(ImMessageCenterPojo imMessageCenterPojo) {
        p pVar = new p();
        if (imMessageCenterPojo != null) {
            pVar.edp = imMessageCenterPojo.getUnread_count();
            pVar.groupId = imMessageCenterPojo.getGid();
            pVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            pVar.groupName = imMessageCenterPojo.getGroup_name();
            pVar.userName = imMessageCenterPojo.getLast_user_name();
            pVar.lastTime = imMessageCenterPojo.getLast_content_time();
            if (pVar.customGroupType == 1) {
                pVar.content = String.valueOf(pVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                pVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return pVar;
    }

    public void aMV() {
        if (com.baidu.adp.lib.c.e.cS().Z("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xH() && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xX() && this.dUu != null && this.dUu.size() != 0 && this.ecP != null && this.ecP.size() != 0) {
            if (!this.ecR.isScreenOn() || this.ecU == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.agB)));
                this.mHandler.postDelayed(new l(this), 1000L);
            }
        }
    }

    private void a(p pVar, List<p> list) {
        if (pVar != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                p pVar2 = list.get(i);
                if (pVar2 != null && !StringUtils.isNull(pVar2.groupId) && pVar2.groupId.equals(pVar.groupId) && pVar2.customGroupType == pVar.customGroupType) {
                    list.remove(i);
                    return;
                }
            }
        }
    }

    public boolean aMW() {
        if (this.dUu == null || this.dUu.size() == 0) {
            return false;
        }
        p pVar = this.dUu.get(this.dUu.size() - 1);
        return pVar != null && pVar.customGroupType == 4;
    }
}
