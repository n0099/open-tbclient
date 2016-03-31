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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.personInfo.bf;
/* loaded from: classes.dex */
public class al {
    private BaseFragmentActivity duj;
    private com.baidu.tieba.personInfo.f duk;
    private bf dvN;
    private boolean dvY;
    private boolean isPrimary;
    private SparseArray<a> dvM = new SparseArray<>();
    private int dvO = 0;
    private int dvP = 0;
    private int dvQ = 0;
    private int dvR = 0;
    private int dvS = 0;
    private boolean dvT = false;
    private boolean mHasNewVersion = false;
    private boolean dvU = false;
    private boolean dvV = false;
    private boolean dvW = false;
    private boolean dvX = false;
    private boolean dvZ = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener dwa = new am(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener dwb = new an(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public al(com.baidu.tieba.personInfo.f fVar) {
        this.duk = fVar;
        this.duj = fVar.getBaseFragmentActivity();
        this.dvN = this.duk.aCH();
        fVar.registerListener(this.dwa);
        fVar.registerListener(this.dwb);
        aBI();
    }

    private void aBI() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("member_close_ad_mine_clicked", false) && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.dvZ = true;
            aBL();
        }
    }

    public void aBJ() {
        if (this.dvT) {
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

    public void aBK() {
        this.dvT = false;
        this.dvS = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.dvY = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new ao(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.dvM.put(i, aVar);
        }
    }

    public void gG(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.dvR;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.dvO;
            if (!z || !z2) {
                this.dvW = newsNotifyMessage.getMsgBookmark() > this.dvR;
                this.dvU = newsNotifyMessage.getMsgFans() > this.dvO ? true : this.dvU;
                this.dvR = newsNotifyMessage.getMsgBookmark();
                this.dvO = newsNotifyMessage.getMsgFans();
                this.dvP = newsNotifyMessage.getMsgGiftNum();
                this.dvQ = newsNotifyMessage.getMsgLiveVip();
                if (this.dvO <= 0) {
                    this.dvU = false;
                }
                if (this.dvR <= 0) {
                    this.dvW = false;
                }
                if (this.dvO > 0 && this.dvU) {
                    this.dvN.bH(msgFans);
                    h(true, 2);
                    a aVar = this.dvM.get(2);
                    if (aVar != null) {
                        aVar.g(true, msgFans);
                    }
                    aBL();
                }
                if (this.dvW) {
                    h(true, 1);
                    aBL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBL() {
        boolean z = (this.dvO > 0 && this.dvU) || (this.dvS > 0 && this.dvT) || ((this.dvR > 0 && this.dvW) || this.mHasNewVersion || this.dvZ);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void h(boolean z, int i) {
        a aVar;
        if (this.dvM.size() > 0 && (aVar = this.dvM.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aBM() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void gH(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.dvM.clear();
    }
}
