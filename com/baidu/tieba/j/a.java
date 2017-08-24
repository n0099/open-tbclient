package com.baidu.tieba.j;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.j.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener cTk;
    private boolean fLM;
    private boolean fLN;
    private boolean fLO;
    private boolean fLP;
    private boolean fLQ;
    private boolean fLR;
    private boolean fLS;
    private int fLT;
    private int fLU;
    private int fLV;
    private int fLW;
    private int fLX;
    private boolean fLY;
    private boolean fLZ;
    private boolean fMa;
    private boolean fMb;
    private boolean fMc;
    private boolean fMd;
    private boolean fMe;
    private boolean fMf;
    private boolean fMg;
    private final CustomMessageListener fMh;
    CustomMessageListener fMi;
    private CustomMessageListener fMj;
    private CustomMessageListener fMk;
    private CustomMessageListener fMl;
    private CustomMessageListener fMm;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0103a {
        private static final a fMo = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fLM = false;
        this.fLN = false;
        this.fLO = false;
        this.fLP = false;
        this.fLQ = false;
        this.fLR = false;
        this.fLS = false;
        this.fLT = 0;
        this.fLU = 0;
        this.fLV = 0;
        this.fLW = 0;
        this.fLX = 0;
        this.fLY = false;
        this.mHasNewVersion = false;
        this.fLZ = false;
        this.fMa = false;
        this.fMb = false;
        this.fMc = false;
        this.fMd = false;
        this.fMe = false;
        this.fMg = false;
        this.fMh = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fMi = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fLX >= responseUnreadPointNum.getNum()) {
                        a.this.fLX = responseUnreadPointNum.getNum();
                        a.this.fLY = false;
                    } else {
                        a.this.fLY = true;
                        a.this.fLP = a.this.fLY ? true : a.this.fLP;
                        a.this.fLX = responseUnreadPointNum.getNum();
                        a.this.bjd();
                    }
                    a.this.bjc();
                }
            }
        };
        this.fMj = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.fMd = true;
                    a.this.fLS = booleanValue;
                    a.this.bjd();
                }
            }
        };
        this.fMk = new CustomMessageListener(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.getInst().getLastUpdateThemeTime()) {
                    a.this.fLZ = true;
                    a.this.fLR = a.this.fLZ ? true : a.this.fLR;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                    a.this.bjd();
                }
            }
        };
        this.fMl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fLQ = a.this.mHasNewVersion ? true : a.this.fLQ;
                    a.this.bjd();
                }
            }
        };
        this.cTk = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bjg();
                    }
                }
            }
        };
        this.fMm = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bjm();
                }
            }
        };
        initListener();
    }

    public static final a biZ() {
        return C0103a.fMo;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fMh);
        MessageManager.getInstance().registerListener(this.fMi);
        MessageManager.getInstance().registerListener(this.fMk);
        MessageManager.getInstance().registerListener(this.fMl);
        MessageManager.getInstance().registerListener(this.fMm);
        MessageManager.getInstance().registerListener(this.fMj);
        MessageManager.getInstance().registerListener(this.cTk);
    }

    private void bja() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fLQ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fMf = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bjb() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fLQ || this.fLR)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fMc = newsNotifyMessage.getMsgBookmark() > this.fLW;
            this.fMa = newsNotifyMessage.getMsgFans() > this.fLT;
            this.fMb = newsNotifyMessage.getMsgGiftNum() > this.fLU;
            this.fLW = newsNotifyMessage.getMsgBookmark();
            this.fLT = newsNotifyMessage.getMsgFans();
            this.fLU = newsNotifyMessage.getMsgGiftNum();
            this.fLV = newsNotifyMessage.getMsgLiveVip();
            if (this.fMc || this.fMa || this.fMb || this.mHasNewVersion) {
                this.fLM = this.fMa ? true : this.fLM;
                this.fLN = this.fMc ? true : this.fLN;
                this.fLO = this.fMb ? true : this.fLO;
                this.fLQ = this.mHasNewVersion ? true : this.fLQ;
                bjd();
            }
        }
    }

    public void bjc() {
        if (this.fLY) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder append2 = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst2.saveBoolean(append2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjd() {
        SparseArray sparseArray = new SparseArray();
        if (this.fLY) {
            sparseArray.append(4, new b.a(this.fLP, this.fLX));
        }
        if (this.fMa) {
            sparseArray.append(2, new b.a(this.fLM, this.fLT));
        }
        if (this.fMb) {
            sparseArray.append(1, new b.a(this.fLO, this.fLU));
        }
        if (this.fMc) {
            sparseArray.append(3, new b.a(this.fLN, this.fLW));
        }
        if (this.fLZ) {
            sparseArray.append(6, new b.a(this.fLR, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fLQ, 0));
        }
        if (this.fMd) {
            sparseArray.append(7, new b.a(this.fLS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bjf();
    }

    public void bje() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new b.a(this.fLP, this.fLX));
        sparseArray.append(2, new b.a(this.fLM, this.fLT));
        sparseArray.append(1, new b.a(this.fLO, this.fLU));
        sparseArray.append(3, new b.a(this.fLN, this.fLW));
        sparseArray.append(6, new b.a(this.fLR, 0));
        sparseArray.append(5, new b.a(this.fLQ, 0));
        sparseArray.append(7, new b.a(this.fLS, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
    }

    private void bjf() {
        boolean z = (this.fLT > 0 && this.fMa) || (this.fLX > 0 && this.fLY) || ((this.fLW > 0 && this.fMc) || this.mHasNewVersion || this.fLZ || this.fMd);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bjg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fLO = z;
                break;
            case 2:
                this.fLM = z;
                break;
            case 3:
                this.fLN = z;
                break;
            case 4:
                this.fLP = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fMg = true;
                this.fLQ = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fLR = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                this.fLS = z;
                break;
        }
        bje();
        bjh();
    }

    private void bjh() {
        boolean z = this.fLO || this.fLN || this.fLM || this.fLP || this.fLQ || this.fLR || this.fLS;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean bji() {
        return this.fLM;
    }

    public boolean bjj() {
        return this.fLN;
    }

    public boolean bjk() {
        return this.fLP;
    }

    public boolean bjl() {
        return this.fLO;
    }

    public void bjm() {
        this.fLM = false;
        this.fLN = false;
        this.fLO = false;
        this.fLP = false;
        this.fLQ = false;
        this.fLR = false;
        this.fLS = false;
        this.fLT = 0;
        this.fLU = 0;
        this.fLV = 0;
        this.fLW = 0;
        this.fLX = 0;
        this.fLY = false;
        this.mHasNewVersion = false;
        this.fMa = false;
        this.fMb = false;
        this.fMc = false;
        this.fMe = false;
        this.fMd = false;
        bja();
        e.ga().post(new Runnable() { // from class: com.baidu.tieba.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fMf) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bjb();
    }
}
