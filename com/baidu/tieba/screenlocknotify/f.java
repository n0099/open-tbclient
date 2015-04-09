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
    private static f bYH;
    public q bYM;
    public int bYN;
    public int bYO;
    public int bYP;
    public int bYQ;
    public int bYR;
    public boolean bYS;
    private List<r> bYJ = new LinkedList();
    private List<r> bYK = new LinkedList();
    private HashMap<String, LinkedList<r>> bYL = new HashMap<>();
    public boolean bYT = false;
    public Handler mHandler = new g(this);
    private CustomMessageListener aZS = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener bYU = new j(this, 2005016);
    private final Context abo = TbadkApplication.getInst().getApp();
    private KeyguardManager bYI = (KeyguardManager) this.abo.getSystemService("keyguard");

    public static f agc() {
        if (bYH == null) {
            bYH = new f();
        }
        return bYH;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016003, this.aZS);
        MessageManager.getInstance().registerListener(this.bYU);
        MessageManager.getInstance().registerListener(2013005, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013001, this.mCustomMessageListener);
        this.bYN = 0;
        this.bYO = 0;
        this.bYP = 0;
        this.bYQ = 0;
        this.bYR = 0;
        this.bYS = true;
        this.bYM = new q();
    }

    public List<r> agd() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bYJ);
        return linkedList;
    }

    public List<r> age() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bYK);
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
                    if (a != null && a.bZf > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.bYK);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            agf();
            if (z) {
                agh();
            }
        }
    }

    public void agf() {
        if (this.bYJ != null && this.bYK != null) {
            this.bYJ.clear();
            if (this.bYK.size() > 1) {
                this.bYJ.addAll(this.bYK);
            } else if (this.bYK.size() == 1) {
                this.bYJ.addAll(this.bYL.get(this.bYK.get(0).groupId));
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
        rVar.bZf = 0;
        rVar.msgType = chatMessage.getMsgType();
        rVar.customGroupType = i;
        rVar.userName = chatMessage.getUserInfo().getUserName();
        rVar.bZh = chatMessage.getRecordId();
        rVar.isAcceptNotify = true;
        rVar.bZi = true;
        if (rVar.customGroupType == 1) {
            ImMessageCenterPojo D = com.baidu.tieba.im.memorycache.c.Sq().D(chatMessage.getGroupId(), 1);
            if (D != null) {
                rVar.groupName = D.getGroup_name();
                rVar.bZf = D.getUnread_count();
                rVar.Uy = D.getLast_content_time();
            }
            rVar.content = String.valueOf(rVar.userName) + ":" + com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent());
            rVar.groupId = chatMessage.getGroupId();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.TA().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
            }
        } else if (rVar.customGroupType == 2) {
            rVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo D2 = com.baidu.tieba.im.memorycache.c.Sq().D(rVar.groupId, 2);
            if (D2 != null) {
                rVar.bZf = D2.getUnread_count();
                rVar.Uy = D2.getLast_content_time();
                rVar.bZi = D2.getIsFriend() == 1;
            }
            rVar.groupName = chatMessage.getUserInfo().getUserName();
            rVar.content = com.baidu.tieba.im.util.i.v(chatMessage.getMsgType(), chatMessage.getContent());
            if (rVar.bZi) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
                    rVar.isAcceptNotify = false;
                } else {
                    rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.TD().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
                }
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
                rVar.isAcceptNotify = false;
            } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA()) {
                rVar.isAcceptNotify = false;
            } else {
                rVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.TD().aF(TbadkCoreApplication.getCurrentAccount(), rVar.groupId);
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
            LinkedList<r> linkedList = this.bYL.get(rVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(rVar);
            } else {
                a(linkedList, rVar);
                linkedList.add(rVar);
            }
            this.bYL.put(rVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<r> linkedList, r rVar) {
        if (linkedList != null && !linkedList.isEmpty() && rVar != null) {
            Iterator<r> it = linkedList.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next != null && next.bZh == rVar.bZh) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(r rVar) {
        if (rVar != null && this.bYL != null && this.bYL.size() != 0) {
            this.bYL.remove(rVar.groupId);
            if (this.bYK != null && this.bYK.size() != 0) {
                b(rVar, this.bYK);
                agf();
            }
        }
    }

    public void agg() {
        if (this.bYK != null) {
            this.bYK.clear();
        }
        if (this.bYJ != null) {
            this.bYJ.clear();
        }
        if (this.bYL != null) {
            this.bYL.clear();
        }
    }

    public r y(ImMessageCenterPojo imMessageCenterPojo) {
        r rVar = new r();
        if (imMessageCenterPojo != null) {
            rVar.bZf = imMessageCenterPojo.getUnread_count();
            rVar.groupId = imMessageCenterPojo.getGid();
            rVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            rVar.groupName = imMessageCenterPojo.getGroup_name();
            rVar.userName = imMessageCenterPojo.getLast_user_name();
            rVar.Uy = imMessageCenterPojo.getLast_content_time();
            if (rVar.customGroupType == 1) {
                rVar.content = String.valueOf(rVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                rVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return rVar;
    }

    public void agh() {
        if (com.baidu.adp.lib.b.f.gz().ag("android_im_window_open") != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vy() && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vO() && this.bYJ != null && this.bYJ.size() != 0 && this.bYK != null && this.bYK.size() != 0) {
            if (!this.bYM.isScreenOn() || this.bYP == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.abo)));
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
