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
import com.baidu.tieba.personInfo.bf;
/* loaded from: classes.dex */
public class al {
    private BaseFragmentActivity cZG;
    private com.baidu.tieba.personInfo.f cZH;
    private bf dbl;
    private boolean dbw;
    private boolean isPrimary;
    private SparseArray<a> dbk = new SparseArray<>();
    private int dbm = 0;
    private int dbn = 0;
    private int dbo = 0;
    private int dbp = 0;
    private int dbq = 0;
    private boolean dbr = false;
    private boolean mHasNewVersion = false;
    private boolean dbs = false;
    private boolean dbt = false;
    private boolean dbu = false;
    private boolean dbv = false;
    private Handler mHandler = new Handler();
    private final CustomMessageListener dbx = new am(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    CustomMessageListener dby = new an(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);

    public al(com.baidu.tieba.personInfo.f fVar) {
        this.cZH = fVar;
        this.cZG = fVar.getBaseFragmentActivity();
        this.dbl = this.cZH.avb();
        fVar.registerListener(this.dbx);
        fVar.registerListener(this.dby);
    }

    public void aud() {
        if (this.dbr) {
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

    public void aue() {
        this.dbr = false;
        this.dbq = 0;
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        this.dbw = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
        this.mHandler.post(new ao(this));
    }

    public void a(int i, a aVar) {
        if (aVar != null) {
            this.dbk.put(i, aVar);
        }
    }

    public void fT(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            boolean z = newsNotifyMessage.getMsgBookmark() == this.dbp;
            boolean z2 = newsNotifyMessage.getMsgFans() == this.dbm;
            if (!z || !z2) {
                this.dbu = newsNotifyMessage.getMsgBookmark() > this.dbp;
                this.dbs = newsNotifyMessage.getMsgFans() > this.dbm ? true : this.dbs;
                this.dbp = newsNotifyMessage.getMsgBookmark();
                this.dbm = newsNotifyMessage.getMsgFans();
                this.dbn = newsNotifyMessage.getMsgGiftNum();
                this.dbo = newsNotifyMessage.getMsgLiveVip();
                if (this.dbm <= 0) {
                    this.dbs = false;
                }
                if (this.dbp <= 0) {
                    this.dbu = false;
                }
                if (this.dbm > 0 && this.dbs) {
                    this.dbl.bq(msgFans);
                    f(true, 2);
                    a aVar = this.dbk.get(2);
                    if (aVar != null) {
                        aVar.e(true, msgFans);
                    }
                    auf();
                }
                if (this.dbu) {
                    f(true, 1);
                    auf();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auf() {
        boolean z = (this.dbm > 0 && this.dbs) || (this.dbq > 0 && this.dbr) || ((this.dbp > 0 && this.dbu) || this.mHasNewVersion);
        if (z && !this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z)));
        }
    }

    public void f(boolean z, int i) {
        a aVar;
        if (this.dbk.size() > 0 && (aVar = this.dbk.get(i)) != null) {
            aVar.setRedTipShow(z);
        }
    }

    public void aug() {
        if (this.isPrimary) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
        }
    }

    public void fU(boolean z) {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m411getInst();
        inst.saveBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), z);
    }

    public void onDestroy() {
        this.dbk.clear();
    }
}
