package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
    private static f bNX;
    public s bOc;
    public int bOd;
    public int bOe;
    public int bOf;
    public int bOg;
    public int bOh;
    public boolean bOi;
    private List<t> bNZ = new LinkedList();
    private List<t> bOa = new LinkedList();
    private HashMap<String, LinkedList<t>> bOb = new HashMap<>();
    public Handler mHandler = new g(this);
    private CustomMessageListener aTC = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener bOj = new j(this, 2005016);
    private final Context Ru = TbadkApplication.getInst().getApp();
    private KeyguardManager bNY = (KeyguardManager) this.Ru.getSystemService("keyguard");

    public static f acG() {
        if (bNX == null) {
            bNX = new f();
        }
        return bNX;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016003, this.aTC);
        MessageManager.getInstance().registerListener(this.bOj);
        MessageManager.getInstance().registerListener(2013005, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013001, this.mCustomMessageListener);
        this.bOd = 0;
        this.bOe = 0;
        this.bOf = 0;
        this.bOg = 0;
        this.bOh = 0;
        this.bOi = true;
        this.bOc = new s();
    }

    public List<t> acH() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bNZ);
        return linkedList;
    }

    public List<t> acI() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bOa);
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
            e(linkedList, customType);
            return linkedList;
        }
        return null;
    }

    public void e(List<ChatMessage> list, int i) {
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && A(chatMessage)) {
                    new t();
                    t a = a(chatMessage, i);
                    if (a != null && a.bOu > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.bOa);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            acJ();
            if (z) {
                acL();
            }
        }
    }

    public void acJ() {
        if (this.bNZ != null && this.bOa != null) {
            this.bNZ.clear();
            if (this.bOa.size() > 1) {
                this.bNZ.addAll(this.bOa);
            } else if (this.bOa.size() == 1) {
                this.bNZ.addAll(this.bOb.get(this.bOa.get(0).groupId));
            }
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
            case 13:
            case 22:
            case 23:
                return false;
            default:
                return (StringUtils.isNull(chatMessage.getContent()) || StringUtils.isNull(chatMessage.getUserInfo().getUserName()) || chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkApplication.getCurrentAccountName())) ? false : true;
        }
    }

    public t a(ChatMessage chatMessage, int i) {
        t tVar = new t();
        tVar.bOu = 0;
        tVar.msgType = chatMessage.getMsgType();
        tVar.customGroupType = i;
        tVar.userName = chatMessage.getUserInfo().getUserName();
        tVar.bOw = chatMessage.getRecordId();
        tVar.isAcceptNotify = true;
        tVar.bOx = true;
        if (tVar.customGroupType == 1) {
            ImMessageCenterPojo H = com.baidu.tieba.im.memorycache.c.QO().H(chatMessage.getGroupId(), 1);
            if (H != null) {
                tVar.groupName = H.getGroup_name();
                tVar.bOu = H.getUnread_count();
                tVar.IU = H.getLast_content_time();
            }
            tVar.content = String.valueOf(tVar.userName) + ":" + com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            tVar.groupId = chatMessage.getGroupId();
            if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                tVar.isAcceptNotify = false;
            } else {
                tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.Tr().aH(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
            }
        } else if (tVar.customGroupType == 2) {
            tVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo H2 = com.baidu.tieba.im.memorycache.c.QO().H(tVar.groupId, 2);
            if (H2 != null) {
                tVar.bOu = H2.getUnread_count();
                tVar.IU = H2.getLast_content_time();
                tVar.bOx = H2.getIsFriend() == 1;
            }
            tVar.groupName = chatMessage.getUserInfo().getUserName();
            tVar.content = com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            if (tVar.bOx) {
                if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                    tVar.isAcceptNotify = false;
                } else {
                    tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Tu().aH(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
                }
            } else if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                tVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                tVar.isAcceptNotify = false;
            } else {
                tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.Tu().aH(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
            }
        }
        if (StringUtils.isNull(tVar.content)) {
            return null;
        }
        return tVar;
    }

    public void a(t tVar, List<t> list) {
        if (tVar != null && list != null) {
            b(tVar, list);
            list.add(tVar);
        }
    }

    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            c(w(data));
        }
    }

    public void b(t tVar) {
        if (tVar != null) {
            LinkedList<t> linkedList = this.bOb.get(tVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(tVar);
            } else {
                a(linkedList, tVar);
                linkedList.add(tVar);
            }
            this.bOb.put(tVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<t> linkedList, t tVar) {
        if (linkedList != null && !linkedList.isEmpty() && tVar != null) {
            Iterator<t> it = linkedList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.bOw == tVar.bOw) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(t tVar) {
        if (tVar != null && this.bOb != null && this.bOb.size() != 0) {
            this.bOb.remove(tVar.groupId);
            if (this.bOa != null && this.bOa.size() != 0) {
                b(tVar, this.bOa);
                acJ();
            }
        }
    }

    public void acK() {
        if (this.bOa != null) {
            this.bOa.clear();
        }
        if (this.bNZ != null) {
            this.bNZ.clear();
        }
        if (this.bOb != null) {
            this.bOb.clear();
        }
    }

    public t w(ImMessageCenterPojo imMessageCenterPojo) {
        t tVar = new t();
        if (imMessageCenterPojo != null) {
            tVar.bOu = imMessageCenterPojo.getUnread_count();
            tVar.groupId = imMessageCenterPojo.getGid();
            tVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            tVar.groupName = imMessageCenterPojo.getGroup_name();
            tVar.userName = imMessageCenterPojo.getLast_user_name();
            tVar.IU = imMessageCenterPojo.getLast_content_time();
            if (tVar.customGroupType == 1) {
                tVar.content = String.valueOf(tVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                tVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return tVar;
    }

    public void acL() {
        if (com.baidu.adp.lib.b.f.da().Z("android_im_window_open") != 0 && TbadkCoreApplication.m255getInst().isMsgRemindOn() && TbadkApplication.getInst().getScreenLock() && this.bNZ != null && this.bNZ.size() != 0 && this.bOa != null && this.bOa.size() != 0) {
            if (this.bOi) {
                if (this.bNY.inKeyguardRestrictedInputMode()) {
                    BdLog.i("----------------系统判断。。。你目前处于加锁状态，需要展示弹窗!");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.Ru)));
                    this.mHandler.postDelayed(new k(this), 1000L);
                    return;
                }
                BdLog.i("----------------系统判断。。。你目前处于已解锁状态，不需要展示弹窗!");
            } else if (this.bOd == 0 && this.bOf == 1) {
                BdLog.i("标志位判断。。。你目前处于已解锁状态，但是弹框处于上方，需要展示弹窗!");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.Ru)));
                this.mHandler.postDelayed(new l(this), 1000L);
            } else if (this.bOd == 1) {
                BdLog.i("标志位判断。。。你目前处于加锁状态，需要展示弹窗!");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.Ru)));
                this.mHandler.postDelayed(new m(this), 1000L);
            }
        }
    }

    private void b(t tVar, List<t> list) {
        if (tVar != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                t tVar2 = list.get(i);
                if (tVar2 != null && !StringUtils.isNull(tVar2.groupId) && tVar2.groupId.equals(tVar.groupId) && tVar2.customGroupType == tVar.customGroupType) {
                    list.remove(i);
                    return;
                }
            }
        }
    }
}
