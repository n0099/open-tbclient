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
import com.baidu.tbadk.core.data.ae;
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
    private static f eHt;
    public int eHA;
    public int eHB;
    public int eHC;
    public boolean eHD;
    public o eHx;
    public int eHy;
    public int eHz;
    private List<p> eDQ = new LinkedList();
    private List<p> eHv = new LinkedList();
    private HashMap<String, LinkedList<p>> eHw = new HashMap<>();
    public boolean eHE = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener cHK = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener deN = new j(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener eHF = new k(this, CmdConfigCustom.CMD_SCREEN_DIALOG);
    private final Context ahf = TbadkApplication.getInst().getApp();
    private KeyguardManager eHu = (KeyguardManager) this.ahf.getSystemService("keyguard");

    public static f aUX() {
        if (eHt == null) {
            eHt = new f();
        }
        return eHt;
    }

    private f() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cHK);
        MessageManager.getInstance().registerListener(this.deN);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.eHF);
        this.eHy = 0;
        this.eHz = 0;
        this.eHA = 0;
        this.eHB = 0;
        this.eHC = 0;
        this.eHD = true;
        this.eHx = new o();
    }

    public static boolean aUY() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            p pVar = new p();
            pVar.eHV = 0;
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
            pVar.eHY = true;
            if (remindRecommendMessage.isLocal) {
                pVar.stat = "2";
            } else {
                pVar.stat = "1";
            }
            a(pVar, this.eHv, true);
            b(pVar);
            aVb();
            aVd();
            TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.ahf, new ae(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.ahf, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.ahf, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ae aeVar, String str) {
        if (context == null || aeVar == null || TextUtils.isEmpty(str)) {
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
        intent.putExtra("message_id", aeVar.py());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, aeVar.getTaskId());
        if (!TextUtils.isEmpty(aeVar.getStat())) {
            intent.putExtra("stat", aeVar.getStat());
        }
        return intent;
    }

    public List<p> aUZ() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.eDQ);
        return linkedList;
    }

    public List<p> aVa() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.eHv);
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
            o(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void o(List<ChatMessage> list, int i) {
        p a;
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && C(chatMessage) && (a = a(chatMessage, i)) != null && a.eHV > 0) {
                    if (!a.isAcceptNotify) {
                        c(a);
                    } else {
                        if (i == 4) {
                            a(a, this.eHv, true);
                        } else {
                            a(a, this.eHv, false);
                        }
                        b(a);
                        z = true;
                    }
                }
            }
            aVb();
            if (z) {
                aVd();
            }
        }
    }

    public void aVb() {
        if (this.eDQ != null && this.eHv != null) {
            this.eDQ.clear();
            if (this.eHv.size() > 1) {
                this.eDQ.addAll(this.eHv);
            } else if (this.eHv.size() == 1) {
                this.eDQ.addAll(this.eHw.get(this.eHv.get(0).groupId));
            }
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

    public p a(ChatMessage chatMessage, int i) {
        r.a aVar;
        p pVar = new p();
        pVar.eHV = 0;
        pVar.msgType = chatMessage.getMsgType();
        pVar.customGroupType = i;
        pVar.userName = chatMessage.getUserInfo().getUserName();
        pVar.eHX = chatMessage.getRecordId();
        pVar.isAcceptNotify = true;
        pVar.eHY = true;
        if (pVar.customGroupType == 1) {
            ImMessageCenterPojo ah = com.baidu.tieba.im.memorycache.b.apn().ah(chatMessage.getGroupId(), 1);
            if (ah != null) {
                pVar.groupName = ah.getGroup_name();
                pVar.eHV = ah.getUnread_count();
                pVar.lastTime = ah.getLast_content_time();
            }
            pVar.content = String.valueOf(pVar.userName) + ":" + com.baidu.tieba.im.util.h.B(chatMessage.getMsgType(), chatMessage.getContent());
            pVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xZ()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.aqH().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 2) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo ah2 = com.baidu.tieba.im.memorycache.b.apn().ah(pVar.groupId, 2);
            if (ah2 != null) {
                pVar.eHV = ah2.getUnread_count();
                pVar.lastTime = ah2.getLast_content_time();
                pVar.eHY = ah2.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            pVar.content = com.baidu.tieba.im.util.h.B(chatMessage.getMsgType(), chatMessage.getContent());
            if (pVar.eHY) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
                    pVar.isAcceptNotify = false;
                } else {
                    pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aqK().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
                pVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xO()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.aqK().bg(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 4) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(pVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo ah3 = com.baidu.tieba.im.memorycache.b.apn().ah(pVar.groupId, 4);
            if (ah3 != null) {
                pVar.eHV = ah3.getUnread_count();
                pVar.lastTime = ah3.getLast_content_time();
                pVar.eHY = ah3.getIsFriend() == 1;
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
                pVar.content = com.baidu.tieba.im.util.h.B(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                pVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
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
            LinkedList<p> linkedList = this.eHw.get(pVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(pVar);
            } else {
                a(linkedList, pVar);
                linkedList.add(pVar);
            }
            this.eHw.put(pVar.groupId, linkedList);
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
                if (next != null && next.eHX == pVar.eHX) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(p pVar) {
        if (pVar != null && this.eHw != null && this.eHw.size() != 0) {
            this.eHw.remove(pVar.groupId);
            if (this.eHv != null && this.eHv.size() != 0) {
                a(pVar, this.eHv);
                aVb();
            }
        }
    }

    public void aVc() {
        if (this.eHv != null) {
            this.eHv.clear();
        }
        if (this.eDQ != null) {
            this.eDQ.clear();
        }
        if (this.eHw != null) {
            this.eHw.clear();
        }
    }

    public p y(ImMessageCenterPojo imMessageCenterPojo) {
        p pVar = new p();
        if (imMessageCenterPojo != null) {
            pVar.eHV = imMessageCenterPojo.getUnread_count();
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

    public void aVd() {
        if (com.baidu.adp.lib.c.e.cT().Z("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xM() && com.baidu.tbadk.coreExtra.messageCenter.c.xK().yc() && this.eDQ != null && this.eDQ.size() != 0 && this.eHv != null && this.eHv.size() != 0) {
            if (!this.eHx.isScreenOn() || this.eHA == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.ahf)));
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

    public boolean aVe() {
        if (this.eDQ == null || this.eDQ.size() == 0) {
            return false;
        }
        p pVar = this.eDQ.get(this.eDQ.size() - 1);
        return pVar != null && pVar.customGroupType == 4;
    }
}
