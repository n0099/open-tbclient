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
    private static f bMn;
    public s bMs;
    public int bMt;
    public int bMu;
    public int bMv;
    public int bMw;
    public int bMx;
    public boolean bMy;
    private List<t> bMp = new LinkedList();
    private List<t> bMq = new LinkedList();
    private HashMap<String, LinkedList<t>> bMr = new HashMap<>();
    public Handler mHandler = new g(this);
    private CustomMessageListener aSs = new h(this, 0);
    private CustomMessageListener mCustomMessageListener = new i(this, 0);
    private CustomMessageListener bMz = new j(this, 2005016);
    private final Context QR = TbadkApplication.getInst().getApp();
    private KeyguardManager bMo = (KeyguardManager) this.QR.getSystemService("keyguard");

    public static f acd() {
        if (bMn == null) {
            bMn = new f();
        }
        return bMn;
    }

    private f() {
        MessageManager.getInstance().registerListener(2016003, this.aSs);
        MessageManager.getInstance().registerListener(this.bMz);
        MessageManager.getInstance().registerListener(2013005, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2013001, this.mCustomMessageListener);
        this.bMt = 0;
        this.bMu = 0;
        this.bMv = 0;
        this.bMw = 0;
        this.bMx = 0;
        this.bMy = true;
        this.bMs = new s();
    }

    public List<t> ace() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bMp);
        return linkedList;
    }

    public List<t> acf() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.bMq);
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
                    if (a != null && a.bMK > 0) {
                        if (!a.isAcceptNotify) {
                            c(a);
                        } else {
                            a(a, this.bMq);
                            b(a);
                            z = true;
                        }
                    }
                }
            }
            acg();
            if (z) {
                aci();
            }
        }
    }

    public void acg() {
        if (this.bMp != null && this.bMq != null) {
            this.bMp.clear();
            if (this.bMq.size() > 1) {
                this.bMp.addAll(this.bMq);
            } else if (this.bMq.size() == 1) {
                this.bMp.addAll(this.bMr.get(this.bMq.get(0).groupId));
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
        tVar.bMK = 0;
        tVar.msgType = chatMessage.getMsgType();
        tVar.customGroupType = i;
        tVar.userName = chatMessage.getUserInfo().getUserName();
        tVar.bMM = chatMessage.getRecordId();
        tVar.isAcceptNotify = true;
        tVar.bMN = true;
        if (tVar.customGroupType == 1) {
            ImMessageCenterPojo H = com.baidu.tieba.im.memorycache.c.Qs().H(chatMessage.getGroupId(), 1);
            if (H != null) {
                tVar.groupName = H.getGroup_name();
                tVar.bMK = H.getUnread_count();
                tVar.IK = H.getLast_content_time();
            }
            tVar.content = String.valueOf(tVar.userName) + ":" + com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            tVar.groupId = chatMessage.getGroupId();
            if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                tVar.isAcceptNotify = false;
            } else {
                tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.c.SV().aE(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
            }
        } else if (tVar.customGroupType == 2) {
            tVar.groupId = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo H2 = com.baidu.tieba.im.memorycache.c.Qs().H(tVar.groupId, 2);
            if (H2 != null) {
                tVar.bMK = H2.getUnread_count();
                tVar.IK = H2.getLast_content_time();
                tVar.bMN = H2.getIsFriend() == 1;
            }
            tVar.groupName = chatMessage.getUserInfo().getUserName();
            tVar.content = com.baidu.tieba.im.util.i.w(chatMessage.getMsgType(), chatMessage.getContent());
            if (tVar.bMN) {
                if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                    tVar.isAcceptNotify = false;
                } else {
                    tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.SY().aE(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
                }
            } else if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                tVar.isAcceptNotify = false;
            } else if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                tVar.isAcceptNotify = false;
            } else {
                tVar.isAcceptNotify = com.baidu.tieba.im.settingcache.j.SY().aE(TbadkCoreApplication.getCurrentAccount(), tVar.groupId);
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
            LinkedList<t> linkedList = this.bMr.get(tVar.groupId);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                linkedList.add(tVar);
            } else {
                a(linkedList, tVar);
                linkedList.add(tVar);
            }
            this.bMr.put(tVar.groupId, linkedList);
        }
    }

    public void a(LinkedList<t> linkedList, t tVar) {
        if (linkedList != null && !linkedList.isEmpty() && tVar != null) {
            Iterator<t> it = linkedList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.bMM == tVar.bMM) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public void c(t tVar) {
        if (tVar != null && this.bMr != null && this.bMr.size() != 0) {
            this.bMr.remove(tVar.groupId);
            if (this.bMq != null && this.bMq.size() != 0) {
                b(tVar, this.bMq);
                acg();
            }
        }
    }

    public void ach() {
        if (this.bMq != null) {
            this.bMq.clear();
        }
        if (this.bMp != null) {
            this.bMp.clear();
        }
        if (this.bMr != null) {
            this.bMr.clear();
        }
    }

    public t w(ImMessageCenterPojo imMessageCenterPojo) {
        t tVar = new t();
        if (imMessageCenterPojo != null) {
            tVar.bMK = imMessageCenterPojo.getUnread_count();
            tVar.groupId = imMessageCenterPojo.getGid();
            tVar.customGroupType = imMessageCenterPojo.getCustomGroupType();
            tVar.groupName = imMessageCenterPojo.getGroup_name();
            tVar.userName = imMessageCenterPojo.getLast_user_name();
            tVar.IK = imMessageCenterPojo.getLast_content_time();
            if (tVar.customGroupType == 1) {
                tVar.content = String.valueOf(tVar.userName) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                tVar.content = imMessageCenterPojo.getLast_content();
            }
        }
        return tVar;
    }

    public void aci() {
        if (com.baidu.adp.lib.b.f.dc().Z("android_im_window_open") != 0 && TbadkCoreApplication.m255getInst().isMsgRemindOn() && TbadkApplication.getInst().getScreenLock() && this.bMp != null && this.bMp.size() != 0 && this.bMq != null && this.bMq.size() != 0) {
            if (this.bMy) {
                if (this.bMo.inKeyguardRestrictedInputMode()) {
                    BdLog.i("----------------系统判断。。。你目前处于加锁状态，需要展示弹窗!");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.QR)));
                    this.mHandler.postDelayed(new k(this), 1000L);
                    return;
                }
                BdLog.i("----------------系统判断。。。你目前处于已解锁状态，不需要展示弹窗!");
            } else if (this.bMt == 0 && this.bMv == 1) {
                BdLog.i("标志位判断。。。你目前处于已解锁状态，但是弹框处于上方，需要展示弹窗!");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.QR)));
                this.mHandler.postDelayed(new l(this), 1000L);
            } else if (this.bMt == 1) {
                BdLog.i("标志位判断。。。你目前处于加锁状态，需要展示弹窗!");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.QR)));
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
