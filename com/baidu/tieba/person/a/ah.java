package com.baidu.tieba.person.a;

import android.os.Handler;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.personInfo.bb;
/* loaded from: classes.dex */
public class ah {
    private com.baidu.tieba.personInfo.d cQj;
    private boolean cRI;
    private bb cRx;
    private boolean isPrimary;
    private BaseFragmentActivity mActivity;
    private SparseArray<a> cRw = new SparseArray<>();
    private int cRy = 0;
    private int cRz = 0;
    private int cRA = 0;
    private int cRB = 0;
    private int cRC = 0;
    private boolean cRD = false;
    private boolean mHasNewVersion = false;
    private boolean cRE = false;
    private boolean cRF = false;
    private boolean cRG = false;
    private boolean cRH = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener cRJ = new ai(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener cRK = new aj(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public ah(com.baidu.tieba.personInfo.d dVar) {
        this.cQj = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.cRx = this.cQj.apO();
        dVar.registerListener(this.cRJ);
        dVar.registerListener(this.cRK);
    }

    public void apl() {
        if (this.cRD) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m411getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void apm() {
        this.cRD = false;
        this.cRC = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cRI = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new ak(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.cRw.put(i, aVar);
        }
    }

    public void fE(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.cRB;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.cRy;
            if (!z || !z2) {
                this.cRG = newsNotifyMessage.getMsgBookmark() > this.cRB;
                this.cRE = newsNotifyMessage.getMsgFans() > this.cRy ? true : this.cRE;
                this.cRB = newsNotifyMessage.getMsgBookmark();
                this.cRy = newsNotifyMessage.getMsgFans();
                this.cRz = newsNotifyMessage.getMsgGiftNum();
                this.cRA = newsNotifyMessage.getMsgLiveVip();
                if (this.cRy <= 0) {
                    this.cRE = false;
                }
                if (this.cRB <= 0) {
                    this.cRG = false;
                }
                if (this.cRy > 0 && this.cRE) {
                    this.cRx.bn(msgFans);
                    c(true, 2);
                    apn();
                }
                if (this.cRG) {
                    c(true, 1);
                    apn();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apn() {
        boolean z = (this.cRy > 0 && this.cRE) || (this.cRC > 0 && this.cRD) || ((this.cRB > 0 && this.cRG) || this.mHasNewVersion);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void c(boolean z, int i) {
        a aVar;
        if (this.cRw.size() > 0 && (aVar = this.cRw.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void apo() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void fF(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.cRw.clear();
    }
}
