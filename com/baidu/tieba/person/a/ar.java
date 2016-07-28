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
import com.baidu.tieba.personInfo.bn;
import com.baidu.tieba.personInfo.h;
/* loaded from: classes.dex */
public class ar {
    private BaseFragmentActivity bgI;
    private h epz;
    private boolean erD;
    private bn ers;
    private boolean isPrimary;
    private SparseArray<a> err = new SparseArray<>();
    private int ert = 0;
    private int eru = 0;
    private int erv = 0;
    private int erw = 0;
    private int erx = 0;
    private boolean ery = false;
    private boolean mHasNewVersion = false;
    private boolean erz = false;
    private boolean erA = false;
    private boolean erB = false;
    private boolean erC = false;
    private boolean erE = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener erF = new as(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener erG = new at(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public ar(h hVar) {
        this.epz = hVar;
        this.bgI = hVar.getBaseFragmentActivity();
        this.ers = this.epz.aPe();
        hVar.registerListener(this.erF);
        hVar.registerListener(this.erG);
        aNy();
    }

    private void aNy() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("member_close_ad_mine_clicked", false) && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.erE = true;
            aNB();
        }
    }

    public void aNz() {
        if (this.ery) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m10getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m10getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void aNA() {
        this.ery = false;
        this.erx = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m10getInst();
        this.erD = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new au(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.err.put(i, aVar);
        }
    }

    public void iq(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.erw;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.ert;
            if (!z || !z2) {
                this.erB = newsNotifyMessage.getMsgBookmark() > this.erw;
                this.erz = newsNotifyMessage.getMsgFans() > this.ert ? true : this.erz;
                this.erw = newsNotifyMessage.getMsgBookmark();
                this.ert = newsNotifyMessage.getMsgFans();
                this.eru = newsNotifyMessage.getMsgGiftNum();
                this.erv = newsNotifyMessage.getMsgLiveVip();
                if (this.ert <= 0) {
                    this.erz = false;
                }
                if (this.erw <= 0) {
                    this.erB = false;
                }
                if (this.ert > 0 && this.erz) {
                    this.ers.co(msgFans);
                    n(true, 2);
                    a aVar = this.err.get(2);
                    if (aVar != null) {
                        aVar.m(true, msgFans);
                    }
                    aNB();
                }
                if (this.erB) {
                    n(true, 1);
                    aNB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNB() {
        boolean z = (this.ert > 0 && this.erz) || (this.erx > 0 && this.ery) || ((this.erw > 0 && this.erB) || this.mHasNewVersion || this.erE);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void n(boolean z, int i) {
        a aVar;
        if (this.err.size() > 0 && (aVar = this.err.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aNC() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void ir(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m10getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.err.clear();
    }
}
