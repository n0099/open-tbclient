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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class g {
    private static g cus;
    public int cuA;
    public int cuB;
    public boolean cuC;
    public o cuw;
    public int cux;
    public int cuy;
    public int cuz;
    private List<p> coa = new LinkedList();
    private List<p> cuu = new LinkedList();
    private HashMap<String, LinkedList<p>> cuv = new HashMap<>();
    public boolean cuD = false;
    public Handler mHandler = new h(this);
    private CustomMessageListener bqu = new i(this, 0);
    private CustomMessageListener mCustomMessageListener = new j(this, 0);
    private CustomMessageListener cuE = new k(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final Context ahC = TbadkApplication.getInst().getApp();
    private KeyguardManager cut = (KeyguardManager) this.ahC.getSystemService("keyguard");

    public static g akd() {
        if (cus == null) {
            cus = new g();
        }
        return cus;
    }

    private g() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bqu);
        MessageManager.getInstance().registerListener(this.cuE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        this.cux = 0;
        this.cuy = 0;
        this.cuz = 0;
        this.cuA = 0;
        this.cuB = 0;
        this.cuC = true;
        this.cuw = new o();
    }

    public List<p> ake() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.coa);
        return linkedList;
    }

    public List<p> akf() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.cuu);
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
                    new p();
                    p a = a(chatMessage, i);
                    if (a != null && a.cuU > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            if (i == 4) {
                                a(a, this.cuu, true);
                            } else {
                                a(a, this.cuu, false);
                            }
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            akg();
            if (z) {
                aki();
            }
        }
    }

    public void akg() {
        if (this.coa != null && this.cuu != null) {
            this.coa.clear();
            if (this.cuu.size() > 1) {
                this.coa.addAll(this.cuu);
            } else if (this.cuu.size() == 1) {
                this.coa.addAll(this.cuv.get(this.cuu.get(0).groupId));
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
        pVar.cuU = 0;
        pVar.msgType = chatMessage.getMsgType();
        pVar.customGroupType = i;
        pVar.userName = chatMessage.getUserInfo().getUserName();
        pVar.cuW = chatMessage.getRecordId();
        pVar.isAcceptNotify = true;
        pVar.cuX = true;
        if (pVar.customGroupType == 1) {
            ImMessageCenterPojo G = com.baidu.tieba.im.memorycache.b.Vl().G(chatMessage.getGroupId(), 1);
            if (G != null) {
                pVar.groupName = G.getGroup_name();
                pVar.cuU = G.getUnread_count();
                pVar.csY = G.getLast_content_time();
            }
            pVar.content = String.valueOf(pVar.userName) + ":" + com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            pVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.Wv().aK(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 2) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo G2 = com.baidu.tieba.im.memorycache.b.Vl().G(pVar.groupId, 2);
            if (G2 != null) {
                pVar.cuU = G2.getUnread_count();
                pVar.csY = G2.getLast_content_time();
                pVar.cuX = G2.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            pVar.content = com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            if (pVar.cuX) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
                    pVar.isAcceptNotify = false;
                } else {
                    pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Wy().aK(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
                pVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xu()) {
                pVar.isAcceptNotify = false;
            } else {
                pVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Wy().aK(TbadkCoreApplication.getCurrentAccount(), pVar.groupId);
            }
        } else if (pVar.customGroupType == 4) {
            pVar.groupId = chatMessage.getUserInfo().getUserId();
            if (!"1501754229".equals(pVar.groupId)) {
                return null;
            }
            ImMessageCenterPojo G3 = com.baidu.tieba.im.memorycache.b.Vl().G(pVar.groupId, 4);
            if (G3 != null) {
                pVar.cuU = G3.getUnread_count();
                pVar.csY = G3.getLast_content_time();
                pVar.cuX = G3.getIsFriend() == 1;
            }
            pVar.groupName = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<r.a> aC = r.aC(chatMessage.getContent(), null);
                if (aC != null && aC.size() > 0 && (aVar = aC.get(0)) != null) {
                    pVar.title = aVar.title;
                    pVar.content = aVar.text;
                    pVar.pic = aVar.src;
                }
            } else {
                pVar.content = com.baidu.tieba.im.util.h.D(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
                pVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
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
            LinkedList<p> linkedList = this.cuv.get(pVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(pVar);
            } else {
                a(linkedList, pVar);
                linkedList.add(pVar);
            }
            this.cuv.put(pVar.groupId, linkedList);
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
                if (next != null && next.cuW == pVar.cuW) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(p pVar) {
        if (pVar != null && this.cuv != null && this.cuv.size() != 0) {
            this.cuv.remove(pVar.groupId);
            if (this.cuu != null && this.cuu.size() != 0) {
                a(pVar, this.cuu);
                akg();
            }
        }
    }

    public void akh() {
        if (this.cuu != null) {
            this.cuu.clear();
        }
        if (this.coa != null) {
            this.coa.clear();
        }
        if (this.cuv != null) {
            this.cuv.clear();
        }
    }

    public p y(ImMessageCenterPojo imMessageCenterPojo) {
        p pVar = new p();
        if (imMessageCenterPojo != null) {
            pVar.cuU = imMessageCenterPojo.getUnread_count();
            pVar.groupId = imMessageCenterPojo.getGid();
            pVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            pVar.groupName = imMessageCenterPojo.getGroup_name();
            pVar.userName = imMessageCenterPojo.getLast_user_name();
            pVar.csY = imMessageCenterPojo.getLast_content_time();
            if (pVar.customGroupType == 1) {
                pVar.content = String.valueOf(pVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                pVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return pVar;
    }

    public void aki() {
        if (com.baidu.adp.lib.b.e.gy().ah("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xs() && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xI() && this.coa != null && this.coa.size() != 0 && this.cuu != null && this.cuu.size() != 0) {
            if (!this.cuw.isScreenOn() || this.cuz == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ScreenLockActivityConfig(this.ahC)));
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

    public boolean akj() {
        if (this.coa == null || this.coa.size() == 0) {
            return false;
        }
        p pVar = this.coa.get(this.coa.size() - 1);
        return pVar != null && pVar.customGroupType == 4;
    }
}
