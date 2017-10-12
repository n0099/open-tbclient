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
    private CustomMessageListener cXl;
    private int fHA;
    private boolean fHB;
    private boolean fHC;
    private boolean fHD;
    private boolean fHE;
    private boolean fHF;
    private boolean fHG;
    private boolean fHH;
    private boolean fHI;
    private final CustomMessageListener fHJ;
    CustomMessageListener fHK;
    private CustomMessageListener fHL;
    private CustomMessageListener fHM;
    private CustomMessageListener fHN;
    private boolean fHq;
    private boolean fHr;
    private boolean fHs;
    private boolean fHt;
    private boolean fHu;
    private boolean fHv;
    private int fHw;
    private int fHx;
    private int fHy;
    private int fHz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104a {
        private static final a fHP = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fHq = false;
        this.fHr = false;
        this.fHs = false;
        this.fHt = false;
        this.fHu = false;
        this.fHv = false;
        this.fHw = 0;
        this.fHx = 0;
        this.fHy = 0;
        this.fHz = 0;
        this.fHA = 0;
        this.fHB = false;
        this.mHasNewVersion = false;
        this.fHC = false;
        this.fHD = false;
        this.fHE = false;
        this.fHF = false;
        this.fHG = false;
        this.fHI = false;
        this.fHJ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fHK = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fHA >= responseUnreadPointNum.getNum()) {
                        a.this.fHA = responseUnreadPointNum.getNum();
                        a.this.fHB = false;
                    } else {
                        a.this.fHB = true;
                        a.this.fHt = a.this.fHB ? true : a.this.fHt;
                        a.this.fHA = responseUnreadPointNum.getNum();
                        a.this.bgS();
                    }
                    a.this.bgR();
                }
            }
        };
        this.fHL = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fHF = booleanValue;
                    a.this.fHv = booleanValue;
                    a.this.bgS();
                }
            }
        };
        this.fHM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fHu = a.this.mHasNewVersion ? true : a.this.fHu;
                    a.this.bgS();
                }
            }
        };
        this.cXl = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bgU();
                    }
                }
            }
        };
        this.fHN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bgW();
                }
            }
        };
        initListener();
    }

    public static final a bgO() {
        return C0104a.fHP;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fHJ);
        MessageManager.getInstance().registerListener(this.fHK);
        MessageManager.getInstance().registerListener(this.fHM);
        MessageManager.getInstance().registerListener(this.fHN);
        MessageManager.getInstance().registerListener(this.fHL);
        MessageManager.getInstance().registerListener(this.cXl);
    }

    private void bgP() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fHu = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fHH = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bgQ() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fHu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fHE = newsNotifyMessage.getMsgBookmark() > this.fHz;
            this.fHC = newsNotifyMessage.getMsgFans() > this.fHw;
            this.fHD = newsNotifyMessage.getMsgGiftNum() > this.fHx;
            this.fHz = newsNotifyMessage.getMsgBookmark();
            this.fHw = newsNotifyMessage.getMsgFans();
            this.fHx = newsNotifyMessage.getMsgGiftNum();
            this.fHy = newsNotifyMessage.getMsgLiveVip();
            if (this.fHE || this.fHC || this.fHD || this.mHasNewVersion) {
                this.fHq = this.fHC ? true : this.fHq;
                this.fHr = this.fHE ? true : this.fHr;
                this.fHs = this.fHD ? true : this.fHs;
                this.fHu = this.mHasNewVersion ? true : this.fHu;
                bgS();
            }
        }
    }

    public void bgR() {
        if (this.fHB) {
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

    public void lI(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgS() {
        SparseArray sparseArray = new SparseArray();
        if (this.fHB) {
            sparseArray.append(4, new b.a(this.fHt, this.fHA));
        }
        if (this.fHC) {
            sparseArray.append(2, new b.a(this.fHq, this.fHw));
        }
        if (this.fHD) {
            sparseArray.append(1, new b.a(this.fHs, this.fHx));
        }
        if (this.fHE) {
            sparseArray.append(3, new b.a(this.fHr, this.fHz));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fHu, 0));
        }
        if (this.fHF) {
            sparseArray.append(7, new b.a(this.fHv, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bgT();
    }

    public void lJ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fHt, this.fHA));
            sparseArray.append(2, new b.a(this.fHq, this.fHw));
            sparseArray.append(1, new b.a(this.fHs, this.fHx));
            sparseArray.append(3, new b.a(this.fHr, this.fHz));
            sparseArray.append(5, new b.a(this.fHu, 0));
            sparseArray.append(7, new b.a(this.fHv, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bgT() {
        boolean z = (this.fHw > 0 && this.fHC) || (this.fHz > 0 && this.fHE) || this.mHasNewVersion;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bgU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fHs = z;
                    break;
                case 2:
                    this.fHq = z;
                    break;
                case 3:
                    this.fHr = z;
                    break;
                case 4:
                    this.fHt = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fHI = true;
                    this.fHu = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fHv = z;
                    break;
            }
            lJ(z2);
            bgV();
        }
    }

    private void bgV() {
        boolean z = this.fHs || this.fHr || this.fHq || this.fHt || this.fHu || this.fHv;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bgW() {
        this.fHq = false;
        this.fHr = false;
        this.fHs = false;
        this.fHt = false;
        this.fHu = false;
        this.fHv = false;
        this.fHw = 0;
        this.fHx = 0;
        this.fHy = 0;
        this.fHz = 0;
        this.fHA = 0;
        this.fHB = false;
        this.mHasNewVersion = false;
        this.fHC = false;
        this.fHD = false;
        this.fHE = false;
        this.fHG = false;
        this.fHF = false;
        bgP();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fHH) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bgQ();
    }
}
