package com.baidu.tieba.j;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.j.j;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener cHn;
    private boolean fvA;
    private boolean fvB;
    private int fvC;
    private int fvD;
    private int fvE;
    private int fvF;
    private int fvG;
    private boolean fvH;
    private boolean fvI;
    private boolean fvJ;
    private boolean fvK;
    private boolean fvL;
    private boolean fvM;
    private boolean fvN;
    private boolean fvO;
    private boolean fvP;
    private final CustomMessageListener fvQ;
    CustomMessageListener fvR;
    private CustomMessageListener fvS;
    private CustomMessageListener fvT;
    private CustomMessageListener fvU;
    private CustomMessageListener fvV;
    private boolean fvv;
    private boolean fvw;
    private boolean fvx;
    private boolean fvy;
    private boolean fvz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a {
        private static final a fvX = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fvv = false;
        this.fvw = false;
        this.fvx = false;
        this.fvy = false;
        this.fvz = false;
        this.fvA = false;
        this.fvB = false;
        this.fvC = 0;
        this.fvD = 0;
        this.fvE = 0;
        this.fvF = 0;
        this.fvG = 0;
        this.fvH = false;
        this.mHasNewVersion = false;
        this.fvI = false;
        this.fvJ = false;
        this.fvK = false;
        this.fvL = false;
        this.fvM = false;
        this.fvN = false;
        this.fvP = false;
        this.fvQ = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.fvR = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.fvS = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.fvT = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.fvU = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.cHn = new g(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
        this.fvV = new h(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        initListener();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a beN() {
        return C0071a.fvX;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fvQ);
        MessageManager.getInstance().registerListener(this.fvR);
        MessageManager.getInstance().registerListener(this.fvT);
        MessageManager.getInstance().registerListener(this.fvU);
        MessageManager.getInstance().registerListener(this.fvV);
        MessageManager.getInstance().registerListener(this.fvS);
        MessageManager.getInstance().registerListener(this.cHn);
    }

    private void beO() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fvz = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.fvO = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void beP() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fvz || this.fvA)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fvL = newsNotifyMessage.getMsgBookmark() > this.fvF;
            this.fvJ = newsNotifyMessage.getMsgFans() > this.fvC;
            this.fvK = newsNotifyMessage.getMsgGiftNum() > this.fvD;
            this.fvF = newsNotifyMessage.getMsgBookmark();
            this.fvC = newsNotifyMessage.getMsgFans();
            this.fvD = newsNotifyMessage.getMsgGiftNum();
            this.fvE = newsNotifyMessage.getMsgLiveVip();
            if (this.fvL || this.fvJ || this.fvK || this.mHasNewVersion) {
                this.fvv = this.fvJ ? true : this.fvv;
                this.fvw = this.fvL ? true : this.fvw;
                this.fvx = this.fvK ? true : this.fvx;
                this.fvz = this.mHasNewVersion ? true : this.fvz;
                beR();
            }
        }
    }

    public void beQ() {
        if (this.fvH) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void beR() {
        SparseArray sparseArray = new SparseArray();
        if (this.fvH) {
            sparseArray.append(4, new j.a(this.fvy, this.fvG));
        }
        if (this.fvJ) {
            sparseArray.append(2, new j.a(this.fvv, this.fvC));
        }
        if (this.fvK) {
            sparseArray.append(1, new j.a(this.fvx, this.fvD));
        }
        if (this.fvL) {
            sparseArray.append(3, new j.a(this.fvw, this.fvF));
        }
        if (this.fvI) {
            sparseArray.append(6, new j.a(this.fvA, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new j.a(this.fvz, 0));
        }
        if (this.fvM) {
            sparseArray.append(7, new j.a(this.fvB, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new j(sparseArray)));
        beT();
    }

    public void beS() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new j.a(this.fvy, this.fvG));
        sparseArray.append(2, new j.a(this.fvv, this.fvC));
        sparseArray.append(1, new j.a(this.fvx, this.fvD));
        sparseArray.append(3, new j.a(this.fvw, this.fvF));
        sparseArray.append(6, new j.a(this.fvA, 0));
        sparseArray.append(5, new j.a(this.fvz, 0));
        sparseArray.append(7, new j.a(this.fvB, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new j(sparseArray)));
    }

    private void beT() {
        boolean z = (this.fvC > 0 && this.fvJ) || (this.fvG > 0 && this.fvH) || ((this.fvF > 0 && this.fvL) || this.mHasNewVersion || this.fvI || this.fvM);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void beU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void C(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fvx = z;
                break;
            case 2:
                this.fvv = z;
                break;
            case 3:
                this.fvw = z;
                break;
            case 4:
                this.fvy = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fvP = true;
                this.fvz = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fvA = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.fvB = z;
                break;
        }
        beS();
        beV();
    }

    private void beV() {
        boolean z = this.fvx || this.fvw || this.fvv || this.fvy || this.fvz || this.fvA || this.fvB;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean beW() {
        return this.fvv;
    }

    public boolean beX() {
        return this.fvw;
    }

    public boolean beY() {
        return this.fvy;
    }

    public boolean beZ() {
        return this.fvx;
    }

    public void bfa() {
        this.fvv = false;
        this.fvw = false;
        this.fvx = false;
        this.fvy = false;
        this.fvz = false;
        this.fvA = false;
        this.fvB = false;
        this.fvC = 0;
        this.fvD = 0;
        this.fvE = 0;
        this.fvF = 0;
        this.fvG = 0;
        this.fvH = false;
        this.mHasNewVersion = false;
        this.fvJ = false;
        this.fvK = false;
        this.fvL = false;
        this.fvN = false;
        this.fvM = false;
        beO();
        com.baidu.adp.lib.g.h.fR().post(new i(this));
        beP();
    }
}
