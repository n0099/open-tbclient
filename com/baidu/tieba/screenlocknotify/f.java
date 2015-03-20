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
    private static f bYs;
    public int bYA;
    public int bYB;
    public int bYC;
    public boolean bYD;
    public q bYx;
    public int bYy;
    public int bYz;
    private List<r> bYu = new LinkedList();
    private List<r> bYv = new LinkedList();
    private HashMap<String, LinkedList<r>> bYw = new HashMap<>();
    public boolean bYE = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener aZC = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener bYF = new j(this, 2005016);
    private final Context abg = TbadkApplication.getInst().getApp();
    private KeyguardManager bYt = (KeyguardManager) this.abg.getSystemService("keyguard");

    public static f afN() {
        if (bYs == null) {
            bYs = new f();
        }
        return bYs;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016003, this.aZC);
        MessageManager.getInstance().registerListener(this.bYF);
        MessageManager.getInstance().registerListener(2013005, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013001, this.mCustomMessageListener);
        this.bYy = 0;
        this.bYz = 0;
        this.bYA = 0;
        this.bYB = 0;
        this.bYC = 0;
        this.bYD = true;
        this.bYx = new q();
    }

    public List<r> afO() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bYu);
        return linkedList;
    }

    public List<r> afP() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bYv);
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
                    if (a != null && a.bYQ > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.bYv);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            afQ();
            if (z) {
                afS();
            }
        }
    }

    public void afQ() {
        if (this.bYu != null && this.bYv != null) {
            this.bYu.clear();
            if (this.bYv.size() > 1) {
                this.bYu.addAll(this.bYv);
            } else if (this.bYv.size() == 1) {
                this.bYu.addAll(this.bYw.get(this.bYv.get(0).groupId));
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
        rVar.bYQ = 0;
        rVar.msgType = chatMessage.getMsgType();
        rVar.customGroupType = i;
        rVar.userName = chatMessage.getUserInfo().getUserName();
        rVar.bYS = chatMessage.getRecordId();
        rVar.isAcceptNotify = true;
        rVar.bYT = true;
        if (rVar.customGroupType == 1) {
            ImMessageCenterPojo D = com.baidu.tieba.im.memorycache.c.Sd().D(chatMessage.getGroupId(), 1);
            if (D != null) {
                rVar.groupName = D.getGroup_name();
                rVar.bYQ = D.getUnread_count();
                rVar.Uw = D.getLast_content_time();
            }
            rVar.content = String.valueOf(rVar.userName) + ":" + com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent());
            rVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.Tn().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
            }
        } else if (rVar.customGroupType == 2) {
            rVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo D2 = com.baidu.tieba.im.memorycache.c.Sd().D(rVar.groupId, 2);
            if (D2 != null) {
                rVar.bYQ = D2.getUnread_count();
                rVar.Uw = D2.getLast_content_time();
                rVar.bYT = D2.getIsFriend() == 1;
            }
            rVar.groupName = chatMessage.getUserInfo().getUserName();
            rVar.content = com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent());
            if (rVar.bYT) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
                    rVar.isAcceptNotify = false;
                } else {
                    rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Tq().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
                rVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Tq().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
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
            LinkedList<r> linkedList = this.bYw.get(rVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(rVar);
            } else {
                a(linkedList, rVar);
                linkedList.add(rVar);
            }
            this.bYw.put(rVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<r> linkedList, r rVar) {
        if (linkedList != null && !linkedList.isEmpty() && rVar != null) {
            Iterator<r> it = linkedList.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next != null && next.bYS == rVar.bYS) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(r rVar) {
        if (rVar != null && this.bYw != null && this.bYw.size() != 0) {
            this.bYw.remove(rVar.groupId);
            if (this.bYv != null && this.bYv.size() != 0) {
                b(rVar, this.bYv);
                afQ();
            }
        }
    }

    public void afR() {
        if (this.bYv != null) {
            this.bYv.clear();
        }
        if (this.bYu != null) {
            this.bYu.clear();
        }
        if (this.bYw != null) {
            this.bYw.clear();
        }
    }

    public r y(ImMessageCenterPojo imMessageCenterPojo) {
        r rVar = new r();
        if (imMessageCenterPojo != null) {
            rVar.bYQ = imMessageCenterPojo.getUnread_count();
            rVar.groupId = imMessageCenterPojo.getGid();
            rVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            rVar.groupName = imMessageCenterPojo.getGroup_name();
            rVar.userName = imMessageCenterPojo.getLast_user_name();
            rVar.Uw = imMessageCenterPojo.getLast_content_time();
            if (rVar.customGroupType == 1) {
                rVar.content = String.valueOf(rVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                rVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return rVar;
    }

    public void afS() {
        if (com.baidu.adp.lib.b.f.gz().ag("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs() && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vI() && this.bYu != null && this.bYu.size() != 0 && this.bYv != null && this.bYv.size() != 0) {
            if (!this.bYx.isScreenOn() || this.bYA == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.abg)));
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
