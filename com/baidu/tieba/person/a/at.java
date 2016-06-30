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
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.personInfo.f;
/* loaded from: classes.dex */
public class at {
    private BaseFragmentActivity bfw;
    private f efz;
    private boolean ehE;
    private bp eht;
    private boolean isPrimary;
    private SparseArray<a> ehs = new SparseArray<>();
    private int ehu = 0;
    private int ehv = 0;
    private int ehw = 0;
    private int ehx = 0;
    private int ehy = 0;
    private boolean ehz = false;
    private boolean mHasNewVersion = false;
    private boolean ehA = false;
    private boolean ehB = false;
    private boolean ehC = false;
    private boolean ehD = false;
    private boolean ehF = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener ehG = new au(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener ehH = new av(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public at(f fVar) {
        this.efz = fVar;
        this.bfw = fVar.getBaseFragmentActivity();
        this.eht = this.efz.aLZ();
        fVar.registerListener(this.ehG);
        fVar.registerListener(this.ehH);
        aKV();
    }

    private void aKV() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("member_close_ad_mine_clicked", false) && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ehF = true;
            aKY();
        }
    }

    public void aKW() {
        if (this.ehz) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.m9getInst();
            inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder sb2 = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        inst2.saveBoolean(sb2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void aKX() {
        this.ehz = false;
        this.ehy = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.ehE = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new aw(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.ehs.put(i, aVar);
        }
    }

    public void ih(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.ehx;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.ehu;
            if (!z || !z2) {
                this.ehC = newsNotifyMessage.getMsgBookmark() > this.ehx;
                this.ehA = newsNotifyMessage.getMsgFans() > this.ehu ? true : this.ehA;
                this.ehx = newsNotifyMessage.getMsgBookmark();
                this.ehu = newsNotifyMessage.getMsgFans();
                this.ehv = newsNotifyMessage.getMsgGiftNum();
                this.ehw = newsNotifyMessage.getMsgLiveVip();
                if (this.ehu <= 0) {
                    this.ehA = false;
                }
                if (this.ehx <= 0) {
                    this.ehC = false;
                }
                if (this.ehu > 0 && this.ehA) {
                    this.eht.cr(msgFans);
                    m(true, 2);
                    a aVar = this.ehs.get(2);
                    if (aVar != null) {
                        aVar.l(true, msgFans);
                    }
                    aKY();
                }
                if (this.ehC) {
                    m(true, 1);
                    aKY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKY() {
        boolean z = (this.ehu > 0 && this.ehA) || (this.ehy > 0 && this.ehz) || ((this.ehx > 0 && this.ehC) || this.mHasNewVersion || this.ehF);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void m(boolean z, int i) {
        a aVar;
        if (this.ehs.size() > 0 && (aVar = this.ehs.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aKZ() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void ii(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.ehs.clear();
    }
}
