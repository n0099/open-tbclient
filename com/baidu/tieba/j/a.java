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
    private boolean fLL;
    private boolean fLM;
    private boolean fLN;
    private boolean fLO;
    private boolean fLP;
    private boolean fLQ;
    private boolean fLR;
    private int fLS;
    private int fLT;
    private int fLU;
    private int fLV;
    private int fLW;
    private boolean fLX;
    private boolean fLY;
    private boolean fLZ;
    private boolean fMa;
    private boolean fMb;
    private boolean fMc;
    private boolean fMd;
    private boolean fMe;
    private boolean fMf;
    private final CustomMessageListener fMg;
    CustomMessageListener fMh;
    private CustomMessageListener fMi;
    private CustomMessageListener fMj;
    private CustomMessageListener fMk;
    private CustomMessageListener fMl;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0103a {
        private static final a fMn = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fLL = false;
        this.fLM = false;
        this.fLN = false;
        this.fLO = false;
        this.fLP = false;
        this.fLQ = false;
        this.fLR = false;
        this.fLS = 0;
        this.fLT = 0;
        this.fLU = 0;
        this.fLV = 0;
        this.fLW = 0;
        this.fLX = false;
        this.mHasNewVersion = false;
        this.fLY = false;
        this.fLZ = false;
        this.fMa = false;
        this.fMb = false;
        this.fMc = false;
        this.fMd = false;
        this.fMf = false;
        this.fMg = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fMh = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fLW >= responseUnreadPointNum.getNum()) {
                        a.this.fLW = responseUnreadPointNum.getNum();
                        a.this.fLX = false;
                    } else {
                        a.this.fLX = true;
                        a.this.fLO = a.this.fLX ? true : a.this.fLO;
                        a.this.fLW = responseUnreadPointNum.getNum();
                        a.this.bji();
                    }
                    a.this.bjh();
                }
            }
        };
        this.fMi = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fMc = true;
                    a.this.fLR = booleanValue;
                    a.this.bji();
                }
            }
        };
        this.fMj = new CustomMessageListener(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.getInst().getLastUpdateThemeTime()) {
                    a.this.fLY = true;
                    a.this.fLQ = a.this.fLY ? true : a.this.fLQ;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                    a.this.bji();
                }
            }
        };
        this.fMk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fLP = a.this.mHasNewVersion ? true : a.this.fLP;
                    a.this.bji();
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
                        a.this.bjl();
                    }
                }
            }
        };
        this.fMl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bjr();
                }
            }
        };
        initListener();
    }

    public static final a bje() {
        return C0103a.fMn;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fMg);
        MessageManager.getInstance().registerListener(this.fMh);
        MessageManager.getInstance().registerListener(this.fMj);
        MessageManager.getInstance().registerListener(this.fMk);
        MessageManager.getInstance().registerListener(this.fMl);
        MessageManager.getInstance().registerListener(this.fMi);
        MessageManager.getInstance().registerListener(this.cTk);
    }

    private void bjf() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fLP = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fMe = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bjg() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fLP || this.fLQ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fMb = newsNotifyMessage.getMsgBookmark() > this.fLV;
            this.fLZ = newsNotifyMessage.getMsgFans() > this.fLS;
            this.fMa = newsNotifyMessage.getMsgGiftNum() > this.fLT;
            this.fLV = newsNotifyMessage.getMsgBookmark();
            this.fLS = newsNotifyMessage.getMsgFans();
            this.fLT = newsNotifyMessage.getMsgGiftNum();
            this.fLU = newsNotifyMessage.getMsgLiveVip();
            if (this.fMb || this.fLZ || this.fMa || this.mHasNewVersion) {
                this.fLL = this.fLZ ? true : this.fLL;
                this.fLM = this.fMb ? true : this.fLM;
                this.fLN = this.fMa ? true : this.fLN;
                this.fLP = this.mHasNewVersion ? true : this.fLP;
                bji();
            }
        }
    }

    public void bjh() {
        if (this.fLX) {
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
    public void bji() {
        SparseArray sparseArray = new SparseArray();
        if (this.fLX) {
            sparseArray.append(4, new b.a(this.fLO, this.fLW));
        }
        if (this.fLZ) {
            sparseArray.append(2, new b.a(this.fLL, this.fLS));
        }
        if (this.fMa) {
            sparseArray.append(1, new b.a(this.fLN, this.fLT));
        }
        if (this.fMb) {
            sparseArray.append(3, new b.a(this.fLM, this.fLV));
        }
        if (this.fLY) {
            sparseArray.append(6, new b.a(this.fLQ, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fLP, 0));
        }
        if (this.fMc) {
            sparseArray.append(7, new b.a(this.fLR, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bjk();
    }

    public void bjj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new b.a(this.fLO, this.fLW));
        sparseArray.append(2, new b.a(this.fLL, this.fLS));
        sparseArray.append(1, new b.a(this.fLN, this.fLT));
        sparseArray.append(3, new b.a(this.fLM, this.fLV));
        sparseArray.append(6, new b.a(this.fLQ, 0));
        sparseArray.append(5, new b.a(this.fLP, 0));
        sparseArray.append(7, new b.a(this.fLR, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
    }

    private void bjk() {
        boolean z = (this.fLS > 0 && this.fLZ) || (this.fLW > 0 && this.fLX) || ((this.fLV > 0 && this.fMb) || this.mHasNewVersion || this.fLY || this.fMc);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bjl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fLN = z;
                break;
            case 2:
                this.fLL = z;
                break;
            case 3:
                this.fLM = z;
                break;
            case 4:
                this.fLO = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fMf = true;
                this.fLP = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fLQ = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                this.fLR = z;
                break;
        }
        bjj();
        bjm();
    }

    private void bjm() {
        boolean z = this.fLN || this.fLM || this.fLL || this.fLO || this.fLP || this.fLQ || this.fLR;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean bjn() {
        return this.fLL;
    }

    public boolean bjo() {
        return this.fLM;
    }

    public boolean bjp() {
        return this.fLO;
    }

    public boolean bjq() {
        return this.fLN;
    }

    public void bjr() {
        this.fLL = false;
        this.fLM = false;
        this.fLN = false;
        this.fLO = false;
        this.fLP = false;
        this.fLQ = false;
        this.fLR = false;
        this.fLS = 0;
        this.fLT = 0;
        this.fLU = 0;
        this.fLV = 0;
        this.fLW = 0;
        this.fLX = false;
        this.mHasNewVersion = false;
        this.fLZ = false;
        this.fMa = false;
        this.fMb = false;
        this.fMd = false;
        this.fMc = false;
        bjf();
        e.ga().post(new Runnable() { // from class: com.baidu.tieba.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fMe) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bjg();
    }
}
