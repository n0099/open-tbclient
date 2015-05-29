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
    private static f ccT;
    public q ccX;
    public int ccY;
    public int ccZ;
    public int cda;
    public int cdb;
    public int cdc;
    public boolean cdd;
    private List<r> bXg = new LinkedList();
    private List<r> ccV = new LinkedList();
    private HashMap<String, LinkedList<r>> ccW = new HashMap<>();
    public boolean cde = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener bcz = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener cdf = new j(this, 2005016);
    private final Context acs = TbadkApplication.getInst().getApp();
    private KeyguardManager ccU = (KeyguardManager) this.acs.getSystemService("keyguard");

    public static f ahP() {
        if (ccT == null) {
            ccT = new f();
        }
        return ccT;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016004, this.bcz);
        MessageManager.getInstance().registerListener(this.cdf);
        MessageManager.getInstance().registerListener(2013006, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013002, this.mCustomMessageListener);
        this.ccY = 0;
        this.ccZ = 0;
        this.cda = 0;
        this.cdb = 0;
        this.cdc = 0;
        this.cdd = true;
        this.ccX = new q();
    }

    public List<r> ahQ() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bXg);
        return linkedList;
    }

    public List<r> ahR() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.ccV);
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
                    if (a != null && a.cdq > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.ccV);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            ahS();
            if (z) {
                ahU();
            }
        }
    }

    public void ahS() {
        if (this.bXg != null && this.ccV != null) {
            this.bXg.clear();
            if (this.ccV.size() > 1) {
                this.bXg.addAll(this.ccV);
            } else if (this.ccV.size() == 1) {
                this.bXg.addAll(this.ccW.get(this.ccV.get(0).groupId));
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
        rVar.cdq = 0;
        rVar.msgType = chatMessage.getMsgType();
        rVar.customGroupType = i;
        rVar.userName = chatMessage.getUserInfo().getUserName();
        rVar.cdt = chatMessage.getRecordId();
        rVar.isAcceptNotify = true;
        rVar.cdu = true;
        if (rVar.customGroupType == 1) {
            ImMessageCenterPojo D = com.baidu.tieba.im.memorycache.c.TD().D(chatMessage.getGroupId(), 1);
            if (D != null) {
                rVar.groupName = D.getGroup_name();
                rVar.cdq = D.getUnread_count();
                rVar.cds = D.getLast_content_time();
            }
            rVar.content = String.valueOf(rVar.userName) + ":" + com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            rVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.UN().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
            }
        } else if (rVar.customGroupType == 2) {
            rVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo D2 = com.baidu.tieba.im.memorycache.c.TD().D(rVar.groupId, 2);
            if (D2 != null) {
                rVar.cdq = D2.getUnread_count();
                rVar.cds = D2.getLast_content_time();
                rVar.cdu = D2.getIsFriend() == 1;
            }
            rVar.groupName = chatMessage.getUserInfo().getUserName();
            rVar.content = com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            if (rVar.cdu) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                    rVar.isAcceptNotify = false;
                } else {
                    rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.UQ().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                rVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.UQ().aK(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
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
            LinkedList<r> linkedList = this.ccW.get(rVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(rVar);
            } else {
                a(linkedList, rVar);
                linkedList.add(rVar);
            }
            this.ccW.put(rVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<r> linkedList, r rVar) {
        if (linkedList != null && !linkedList.isEmpty() && rVar != null) {
            Iterator<r> it = linkedList.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next != null && next.cdt == rVar.cdt) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(r rVar) {
        if (rVar != null && this.ccW != null && this.ccW.size() != 0) {
            this.ccW.remove(rVar.groupId);
            if (this.ccV != null && this.ccV.size() != 0) {
                b(rVar, this.ccV);
                ahS();
            }
        }
    }

    public void ahT() {
        if (this.ccV != null) {
            this.ccV.clear();
        }
        if (this.bXg != null) {
            this.bXg.clear();
        }
        if (this.ccW != null) {
            this.ccW.clear();
        }
    }

    public r y(ImMessageCenterPojo imMessageCenterPojo) {
        r rVar = new r();
        if (imMessageCenterPojo != null) {
            rVar.cdq = imMessageCenterPojo.getUnread_count();
            rVar.groupId = imMessageCenterPojo.getGid();
            rVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            rVar.groupName = imMessageCenterPojo.getGroup_name();
            rVar.userName = imMessageCenterPojo.getLast_user_name();
            rVar.cds = imMessageCenterPojo.getLast_content_time();
            if (rVar.customGroupType == 1) {
                rVar.content = String.valueOf(rVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                rVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return rVar;
    }

    public void ahU() {
        if (com.baidu.adp.lib.b.f.gD().ai("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi() && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wy() && this.bXg != null && this.bXg.size() != 0 && this.ccV != null && this.ccV.size() != 0) {
            if (!this.ccX.isScreenOn() || this.cda == 1) {
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
