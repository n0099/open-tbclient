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
import com.baidu.tbadk.core.data.ai;
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
    private static f fcH;
    public o fcL;
    public int fcM;
    public int fcN;
    public int fcO;
    public int fcP;
    public int fcQ;
    public boolean fcR;
    private List<p> eWJ = new LinkedList();
    private List<p> fcJ = new LinkedList();
    private HashMap<String, LinkedList<p>> fcK = new HashMap<>();
    public boolean fcS = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener cWe = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener dtq = new j(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fcT = new k(this, CmdConfigCustom.CMD_SCREEN_DIALOG);
    private final Context akY = TbadkApplication.getInst().getApp();
    private KeyguardManager fcI = (KeyguardManager) this.akY.getSystemService("keyguard");

    public static f bbM() {
        if (fcH == null) {
            fcH = new f();
        }
        return fcH;
    }

    private f() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cWe);
        MessageManager.getInstance().registerListener(this.dtq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.fcT);
        this.fcM = 0;
        this.fcN = 0;
        this.fcO = 0;
        this.fcP = 0;
        this.fcQ = 0;
        this.fcR = true;
        this.fcL = new o();
    }

    public static boolean bbN() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage != null) {
            p pVar = new p();
            pVar.fdj = 0;
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
            pVar.eIs = true;
            if (remindRecommendMessage.isLocal) {
                pVar.stat = "2";
            } else {
                pVar.stat = "1";
            }
            a(pVar, this.fcJ, true);
            b(pVar);
            bbQ();
            bbS();
            TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage != null && (str = remindRecommendMessage.url) != null && str.length() > 0) {
            Intent a = a(this.akY, new ai(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, ""), str);
            if (a != null) {
                NotificationHelper.showNotification(this.akY, 2000, remindRecommendMessage.name, remindRecommendMessage.title, remindRecommendMessage.title, PendingIntent.getService(this.akY, 0, a, 134217728), false);
                TbadkSettings.getInst().saveString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            }
        }
    }

    public final Intent a(Context context, ai aiVar, String str) {
        if (context == null || aiVar == null || TextUtils.isEmpty(str)) {
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
        intent.putExtra("message_id", aiVar.qk());
        intent.putExtra(InterviewLiveActivityConfig.KEY_TASK_ID, aiVar.getTaskId());
        if (!TextUtils.isEmpty(aiVar.getStat())) {
            intent.putExtra("stat", aiVar.getStat());
        }
        return intent;
    }

    public List<p> bbO() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.eWJ);
        return linkedList;
    }

    public List<p> bbP() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fcJ);
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
            q(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void q(List<ChatMessage> list, int i) {
        p a;
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && C(chatMessage) && (a = a(chatMessage, i)) != null && a.fdj > 0) {
                    if (!a.isAcceptNotify) {
                        c(a);
                    } else {
                        if (i == 4) {
                            a(a, this.fcJ, true);
                        } else {
                            a(a, this.fcJ, false);
                        }
                        b(a);
                        z = true;
                    }
                }
            }
            bbQ();
            if (z) {
                bbS();
            }
        }
    }

    public void bbQ() {
        if (this.eWJ != null && this.fcJ != null) {
            this.eWJ.clear();
            if (this.fcJ.size() > 1) {
                this.eWJ.addAll(this.fcJ);
            } else if (this.fcJ.size() == 1) {
                this.eWJ.addAll(this.fcK.get(this.fcJ.get(0).groupId));
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
        pVar.fdj = 0;
        pVar.msgType = chatMessage.getMsgType();
        pVar.customGroupType = i;
        pVar.userName = chatMessage.getUserInfo().getUserName();
        pVar.fdl = chatMessage.getRecordId();
        pVar.isAcceptNotify = true;
        pVar.eIs = true;
        if (pVar.customGroupType == 1) {
            ImMessageCenterPojo ah = com.baidu.tieba.im.memorycache.b.auN().ah(chatMessage.getGroupId(), 1);
            if (ah != null) {
                pVar.groupName = ah.getGroup_name();
                pVar.fdj = ah.getUnread_count();
                pVar.lastTime = ah.getLast_content_time();
            }
            pVar.content = String.valueOf(pVar.userName) + ":" + com.baidu.tieba.im.util.h.A(chatMessage.getMsgType(), chatMessage.getContent());
            pVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zm()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.awh().bi(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 2) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo ah2 = com.baidu.tieba.im.memorycache.b.auN().ah(pVar.groupId, 2);
            if (ah2 != null) {
                pVar.fdj = ah2.getUnread_count();
                pVar.lastTime = ah2.getLast_content_time();
                pVar.eIs = ah2.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            pVar.content = com.baidu.tieba.im.util.h.A(chatMessage.getMsgType(), chatMessage.getContent());
            if (pVar.eIs) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf()) {
                    pVar.isAcceptNotify = false;
                } else {
                    pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.awk().bi(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf()) {
                pVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zb()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.awk().bi(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 4) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(pVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo ah3 = com.baidu.tieba.im.memorycache.b.auN().ah(pVar.groupId, 4);
            if (ah3 != null) {
                pVar.fdj = ah3.getUnread_count();
                pVar.lastTime = ah3.getLast_content_time();
                pVar.eIs = ah3.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<r.a> ba = r.ba(chatMessage.getContent(), null);
                if (ba != null && ba.size() > 0 && (aVar = ba.get(0)) != null) {
                    pVar.title = aVar.title;
                    pVar.content = aVar.text;
                    pVar.pic = aVar.src;
                }
            } else {
                pVar.content = com.baidu.tieba.im.util.h.A(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zs()) {
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
            LinkedList<p> linkedList = this.fcK.get(pVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(pVar);
            } else {
                a(linkedList, pVar);
                linkedList.add(pVar);
            }
            this.fcK.put(pVar.groupId, linkedList);
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
                if (next != null && next.fdl == pVar.fdl) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(p pVar) {
        if (pVar != null && this.fcK != null && this.fcK.size() != 0) {
            this.fcK.remove(pVar.groupId);
            if (this.fcJ != null && this.fcJ.size() != 0) {
                a(pVar, this.fcJ);
                bbQ();
            }
        }
    }

    public void bbR() {
        if (this.fcJ != null) {
            this.fcJ.clear();
        }
        if (this.eWJ != null) {
            this.eWJ.clear();
        }
        if (this.fcK != null) {
            this.fcK.clear();
        }
    }

    public p y(ImMessageCenterPojo imMessageCenterPojo) {
        p pVar = new p();
        if (imMessageCenterPojo != null) {
            pVar.fdj = imMessageCenterPojo.getUnread_count();
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

    public void bbS() {
        if (com.baidu.adp.lib.c.e.dN().ac("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yX().yZ() && com.baidu.tbadk.coreExtra.messageCenter.c.yX().zp() && this.eWJ != null && this.eWJ.size() != 0 && this.fcJ != null && this.fcJ.size() != 0) {
            if (!this.fcL.isScreenOn() || this.fcO == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.akY)));
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

    public boolean bbT() {
        if (this.eWJ == null || this.eWJ.size() == 0) {
            return false;
        }
        p pVar = this.eWJ.get(this.eWJ.size() - 1);
        return pVar != null && pVar.customGroupType == 4;
    }
}
