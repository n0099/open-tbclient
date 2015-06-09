package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
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
    private static f ccU;
    public q ccY;
    public int ccZ;
    public int cda;
    public int cdb;
    public int cdc;
    public int cdd;
    public boolean cde;
    private List<r> bXh = new LinkedList();
    private List<r> ccW = new LinkedList();
    private HashMap<String, LinkedList<r>> ccX = new HashMap<>();
    public boolean cdf = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener bcA = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener cdg = new j(this, 2005016);
    private final Context acs = TbadkApplication.getInst().getApp();
    private KeyguardManager ccV = (KeyguardManager) this.acs.getSystemService("keyguard");

    public static f ahQ() {
        if (ccU == null) {
            ccU = new f();
        }
        return ccU;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016004, this.bcA);
        MessageManager.getInstance().registerListener(this.cdg);
        MessageManager.getInstance().registerListener(2013006, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013002, this.mCustomMessageListener);
        this.ccZ = 0;
        this.cda = 0;
        this.cdb = 0;
        this.cdc = 0;
        this.cdd = 0;
        this.cde = true;
        this.ccY = new q();
    }

    public List<r> ahR() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bXh);
        return linkedList;
    }

    public List<r> ahS() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.ccW);
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
            f(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void f(List<ChatMessage> list, int i) {
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && B(chatMessage)) {
                    new r();
                    r a = a(chatMessage, i);
                    if (a != null && a.cdr > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.ccW);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            ahT();
            if (z) {
                ahV();
            }
        }
    }

    public void ahT() {
        if (this.bXh != null && this.ccW != null) {
            this.bXh.clear();
            if (this.ccW.size() > 1) {
                this.bXh.addAll(this.ccW);
            } else if (this.ccW.size() == 1) {
                this.bXh.addAll(this.ccX.get(this.ccW.get(0).groupId));
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

    public r a(ChatMessage chatMessage, int i) {
        r rVar = new r();
        rVar.cdr = 0;
        rVar.msgType = chatMessage.getMsgType();
        rVar.customGroupType = i;
        rVar.userName = chatMessage.getUserInfo().getUserName();
        rVar.cdu = chatMessage.getRecordId();
        rVar.isAcceptNotify = true;
        rVar.cdv = true;
        if (rVar.customGroupType == 1) {
            ImMessageCenterPojo D = com.baidu.tieba.im.memorycache.c.TE().D(chatMessage.getGroupId(), 1);
            if (D != null) {
                rVar.groupName = D.getGroup_name();
                rVar.cdr = D.getUnread_count();
                rVar.cdt = D.getLast_content_time();
            }
            rVar.content = String.valueOf(rVar.userName) + ":" + com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            rVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.UO().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
            }
        } else if (rVar.customGroupType == 2) {
            rVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo D2 = com.baidu.tieba.im.memorycache.c.TE().D(rVar.groupId, 2);
            if (D2 != null) {
                rVar.cdr = D2.getUnread_count();
                rVar.cdt = D2.getLast_content_time();
                rVar.cdv = D2.getIsFriend() == 1;
            }
            rVar.groupName = chatMessage.getUserInfo().getUserName();
            rVar.content = com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            if (rVar.cdv) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                    rVar.isAcceptNotify = false;
                } else {
                    rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.UR().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                rVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.UR().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
            }
        }
        if (StringUtils.isNull(rVar.content)) {
            return null;
        }
        return rVar;
    }

    public void a(r rVar, List<r> list) {
        if (rVar != null && list != null) {
            b(rVar, list);
            list.add(rVar);
        }
    }

    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            c(y(data));
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            LinkedList<r> linkedList = this.ccX.get(rVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(rVar);
            } else {
                a(linkedList, rVar);
                linkedList.add(rVar);
            }
            this.ccX.put(rVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<r> linkedList, r rVar) {
        if (linkedList != null && !linkedList.isEmpty() && rVar != null) {
            Iterator<r> it = linkedList.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next != null && next.cdu == rVar.cdu) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(r rVar) {
        if (rVar != null && this.ccX != null && this.ccX.size() != 0) {
            this.ccX.remove(rVar.groupId);
            if (this.ccW != null && this.ccW.size() != 0) {
                b(rVar, this.ccW);
                ahT();
            }
        }
    }

    public void ahU() {
        if (this.ccW != null) {
            this.ccW.clear();
        }
        if (this.bXh != null) {
            this.bXh.clear();
        }
        if (this.ccX != null) {
            this.ccX.clear();
        }
    }

    public r y(ImMessageCenterPojo imMessageCenterPojo) {
        r rVar = new r();
        if (imMessageCenterPojo != null) {
            rVar.cdr = imMessageCenterPojo.getUnread_count();
            rVar.groupId = imMessageCenterPojo.getGid();
            rVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            rVar.groupName = imMessageCenterPojo.getGroup_name();
            rVar.userName = imMessageCenterPojo.getLast_user_name();
            rVar.cdt = imMessageCenterPojo.getLast_content_time();
            if (rVar.customGroupType == 1) {
                rVar.content = String.valueOf(rVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                rVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return rVar;
    }

    public void ahV() {
        if (com.baidu.adp.lib.b.f.gD().ai("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi() && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wy() && this.bXh != null && this.bXh.size() != 0 && this.ccW != null && this.ccW.size() != 0) {
            if (!this.ccY.isScreenOn() || this.cdb == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.acs)));
                this.mHandler.postDelayed(new k(this), 1000L);
            }
        }
    }

    private void b(r rVar, List<r> list) {
        if (rVar != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                r rVar2 = list.get(i);
                if (rVar2 != null && !StringUtils.isNull(rVar2.groupId) && rVar2.groupId.equals(rVar.groupId) && rVar2.customGroupType == rVar.customGroupType) {
                    list.remove(i);
                    return;
                }
            }
        }
    }
}
