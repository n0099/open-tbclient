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
import com.baidu.tieba.personInfo.bg;
/* loaded from: classes.dex */
public class as {
    private BaseFragmentActivity cSp;
    private com.baidu.tieba.personInfo.f dxd;
    private bg dyP;
    private boolean dza;
    private boolean isPrimary;
    private SparseArray<a> dyO = new SparseArray<>();
    private int dyQ = 0;
    private int dyR = 0;
    private int dyS = 0;
    private int dyT = 0;
    private int dyU = 0;
    private boolean dyV = false;
    private boolean mHasNewVersion = false;
    private boolean dyW = false;
    private boolean dyX = false;
    private boolean dyY = false;
    private boolean dyZ = false;
    private boolean dzb = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener dzc = new at(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener dzd = new au(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public as(com.baidu.tieba.personInfo.f fVar) {
        this.dxd = fVar;
        this.cSp = fVar.getBaseFragmentActivity();
        this.dyP = this.dxd.aDe();
        fVar.registerListener(this.dzc);
        fVar.registerListener(this.dzd);
        aCc();
    }

    private void aCc() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("member_close_ad_mine_clicked", false) && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.dzb = true;
            aCf();
        }
    }

    public void aCd() {
        if (this.dyV) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m11getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m11getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void aCe() {
        this.dyV = false;
        this.dyU = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m11getInst();
        this.dza = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new av(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.dyO.put(i, aVar);
        }
    }

    public void hm(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.dyT;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.dyQ;
            if (!z || !z2) {
                this.dyY = newsNotifyMessage.getMsgBookmark() > this.dyT;
                this.dyW = newsNotifyMessage.getMsgFans() > this.dyQ ? true : this.dyW;
                this.dyT = newsNotifyMessage.getMsgBookmark();
                this.dyQ = newsNotifyMessage.getMsgFans();
                this.dyR = newsNotifyMessage.getMsgGiftNum();
                this.dyS = newsNotifyMessage.getMsgLiveVip();
                if (this.dyQ <= 0) {
                    this.dyW = false;
                }
                if (this.dyT <= 0) {
                    this.dyY = false;
                }
                if (this.dyQ > 0 && this.dyW) {
                    this.dyP.bH(msgFans);
                    j(true, 2);
                    a aVar = this.dyO.get(2);
                    if (aVar != null) {
                        aVar.i(true, msgFans);
                    }
                    aCf();
                }
                if (this.dyY) {
                    j(true, 1);
                    aCf();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCf() {
        boolean z = (this.dyQ > 0 && this.dyW) || (this.dyU > 0 && this.dyV) || ((this.dyT > 0 && this.dyY) || this.mHasNewVersion || this.dzb);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void j(boolean z, int i) {
        a aVar;
        if (this.dyO.size() > 0 && (aVar = this.dyO.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aCg() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void hn(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m11getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.dyO.clear();
    }
}
