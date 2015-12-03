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
import com.baidu.tieba.personInfo.aw;
/* loaded from: classes.dex */
public class ad {
    private com.baidu.tieba.personInfo.d cLT;
    private aw cMT;
    private boolean cNe;
    private boolean isPrimary;
    private BaseFragmentActivity mActivity;
    private SparseArray<a> cMS = new SparseArray<>();
    private int cMU = 0;
    private int cMV = 0;
    private int cMW = 0;
    private int cMX = 0;
    private int cMY = 0;
    private boolean cMZ = false;
    private boolean mHasNewVersion = false;
    private boolean cNa = false;
    private boolean cNb = false;
    private boolean cNc = false;
    private boolean cNd = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener cNf = new ae(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener cNg = new af(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public ad(com.baidu.tieba.personInfo.d dVar) {
        this.cLT = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.cMT = this.cLT.aoE();
        this.mActivity.registerListener(this.cNf);
        this.mActivity.registerListener(this.cNg);
    }

    public void aob() {
        if (this.cMZ) {
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

    public void aoc() {
        this.cMZ = false;
        this.cMY = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.cNe = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new ag(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.cMS.put(i, aVar);
        }
    }

    public void fF(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.cMX;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.cMU;
            if (!z || !z2) {
                this.cNc = newsNotifyMessage.getMsgBookmark() > this.cMX;
                this.cNa = newsNotifyMessage.getMsgFans() > this.cMU ? true : this.cNa;
                this.cMX = newsNotifyMessage.getMsgBookmark();
                this.cMU = newsNotifyMessage.getMsgFans();
                this.cMV = newsNotifyMessage.getMsgGiftNum();
                this.cMW = newsNotifyMessage.getMsgLiveVip();
                if (this.cMU <= 0) {
                    this.cNa = false;
                }
                if (this.cMX <= 0) {
                    this.cNc = false;
                }
                if (this.cMU > 0 && this.cNa) {
                    this.cMT.bh(msgFans);
                    c(true, 2);
                    aod();
                }
                if (this.cNc) {
                    c(true, 1);
                    aod();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aod() {
        boolean z = (this.cMU > 0 && this.cNa) || (this.cMY > 0 && this.cMZ) || ((this.cMX > 0 && this.cNc) || this.mHasNewVersion);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void c(boolean z, int i) {
        a aVar;
        if (this.cMS.size() > 0 && (aVar = this.cMS.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aoe() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void fG(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }
}
