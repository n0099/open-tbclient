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
import com.baidu.tieba.j.i;
/* loaded from: classes.dex */
public class a {
    private boolean flA;
    private boolean flB;
    private final CustomMessageListener flC;
    CustomMessageListener flD;
    private CustomMessageListener flE;
    private CustomMessageListener flF;
    private CustomMessageListener flG;
    private CustomMessageListener flH;
    private boolean fle;
    private boolean flf;
    private boolean flg;
    private boolean flh;
    private boolean fli;
    private boolean flj;
    private boolean flk;
    private boolean fll;
    private int flm;
    private int fln;
    private int flo;
    private int flp;
    private int flq;
    private int flr;
    private boolean fls;
    private boolean flt;
    private boolean flu;
    private boolean flv;
    private boolean flw;
    private boolean flx;
    private boolean fly;
    private boolean flz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a {
        private static final a flJ = new a(null);
    }

    private a() {
        this.isPrimary = false;
        this.fle = false;
        this.flf = false;
        this.flg = false;
        this.flh = false;
        this.fli = false;
        this.flj = false;
        this.flk = false;
        this.fll = false;
        this.flm = 0;
        this.fln = 0;
        this.flo = 0;
        this.flp = 0;
        this.flq = 0;
        this.flr = 0;
        this.fls = false;
        this.mHasNewVersion = false;
        this.flt = false;
        this.flu = false;
        this.flv = false;
        this.flw = false;
        this.flx = false;
        this.fly = false;
        this.flz = false;
        this.flB = false;
        this.flC = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.flD = new c(this, CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        this.flE = new d(this, CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP);
        this.flF = new e(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
        this.flG = new f(this, CmdConfigCustom.CMD_UPDATE_VERSION_MSG);
        this.flH = new g(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        initListener();
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    public static final a baD() {
        return C0068a.flJ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.flC);
        MessageManager.getInstance().registerListener(this.flD);
        MessageManager.getInstance().registerListener(this.flF);
        MessageManager.getInstance().registerListener(this.flG);
        MessageManager.getInstance().registerListener(this.flH);
        MessageManager.getInstance().registerListener(this.flE);
    }

    private void baE() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fli = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder sb = new StringBuilder("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.m9getInst();
        this.flA = inst.loadBoolean(sb.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void baF() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fli || this.flj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.flw = newsNotifyMessage.getMsgBookmark() > this.flp;
            this.flu = newsNotifyMessage.getMsgFans() > this.flm;
            this.flv = newsNotifyMessage.getMsgGiftNum() > this.fln;
            this.flz = a(newsNotifyMessage) > this.flr;
            this.flp = newsNotifyMessage.getMsgBookmark();
            this.flm = newsNotifyMessage.getMsgFans();
            this.fln = newsNotifyMessage.getMsgGiftNum();
            this.flo = newsNotifyMessage.getMsgLiveVip();
            this.flr = a(newsNotifyMessage);
            if (this.flw || this.flu || this.flv || this.mHasNewVersion || this.flz) {
                this.fle = this.flu ? true : this.fle;
                this.flf = this.flw ? true : this.flf;
                this.flg = this.flv ? true : this.flg;
                this.fli = this.mHasNewVersion ? true : this.fli;
                this.fll = this.flz ? true : this.fll;
                baH();
            }
        }
    }

    private int a(NewsNotifyMessage newsNotifyMessage) {
        int i;
        int i2;
        if (newsNotifyMessage == null) {
            return 0;
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS() && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yZ()) {
            i2 = newsNotifyMessage.getMsgChat();
            i = newsNotifyMessage.getMsgStrangerChat();
        } else {
            i = 0;
            i2 = 0;
        }
        int msgAtme = ((com.baidu.tbadk.coreExtra.messageCenter.c.yK().yP() ? newsNotifyMessage.getMsgAtme() : 0) + (i2 + (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yR() ? newsNotifyMessage.getMsgReplyme() : 0))) - i;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().ze()) {
            msgAtme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgAtme;
    }

    public void baG() {
        if (this.fls) {
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
    public void baH() {
        SparseArray sparseArray = new SparseArray();
        if (this.fls) {
            sparseArray.append(4, new i.a(this.flh, this.flq));
        }
        if (this.flu) {
            sparseArray.append(2, new i.a(this.fle, this.flm));
        }
        if (this.flv) {
            sparseArray.append(1, new i.a(this.flg, this.fln));
        }
        if (this.flw) {
            sparseArray.append(3, new i.a(this.flf, this.flp));
        }
        if (this.flt) {
            sparseArray.append(6, new i.a(this.flj, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new i.a(this.fli, 0));
        }
        if (this.flx) {
            sparseArray.append(7, new i.a(this.flk, 0));
        }
        if (this.flz) {
            sparseArray.append(8, new i.a(this.fll, this.flr));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
        baJ();
    }

    public void baI() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new i.a(this.flh, this.flq));
        sparseArray.append(2, new i.a(this.fle, this.flm));
        sparseArray.append(1, new i.a(this.flg, this.fln));
        sparseArray.append(3, new i.a(this.flf, this.flp));
        sparseArray.append(6, new i.a(this.flj, 0));
        sparseArray.append(5, new i.a(this.fli, 0));
        sparseArray.append(7, new i.a(this.flk, 0));
        sparseArray.append(8, new i.a(this.fll, this.flr));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new i(sparseArray)));
    }

    private void baJ() {
        boolean z = (this.flm > 0 && this.flu) || (this.flq > 0 && this.fls) || ((this.flp > 0 && this.flw) || this.mHasNewVersion || this.flt || this.flx || this.flz);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, this.flr)));
        }
    }

    public void C(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.flg = z;
                break;
            case 2:
                this.fle = z;
                break;
            case 3:
                this.flf = z;
                break;
            case 4:
                this.flh = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.flB = true;
                this.fli = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.flj = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                this.flk = z;
                break;
            case 8:
                this.fll = z;
                break;
        }
        baI();
        baK();
    }

    private void baK() {
        boolean z = this.flg || this.flf || this.fle || this.flh || this.fli || this.flj || this.flk || this.fll;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, this.fll ? 0 : this.flr)));
        }
    }

    public void baL() {
        this.fle = false;
        this.flf = false;
        this.flg = false;
        this.flh = false;
        this.fli = false;
        this.flj = false;
        this.flk = false;
        this.fll = false;
        this.flm = 0;
        this.fln = 0;
        this.flo = 0;
        this.flp = 0;
        this.flq = 0;
        this.flr = 0;
        this.fls = false;
        this.mHasNewVersion = false;
        this.flu = false;
        this.flv = false;
        this.flw = false;
        this.fly = false;
        this.flx = false;
        this.flz = false;
        baE();
        com.baidu.adp.lib.g.h.fS().post(new h(this));
        baF();
    }
}
