package com.baidu.tieba.o;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.o.b;
/* loaded from: classes5.dex */
public class a {
    private CustomMessageListener esY;
    private CustomMessageListener gTA;
    private boolean gTa;
    private boolean gTb;
    private boolean gTc;
    private boolean gTd;
    private boolean gTe;
    private boolean gTf;
    private boolean gTg;
    private boolean gTh;
    private int gTi;
    private int gTj;
    private int gTk;
    private int gTl;
    private boolean gTm;
    private boolean gTn;
    private boolean gTo;
    private boolean gTp;
    private boolean gTq;
    private boolean gTr;
    private boolean gTs;
    private boolean gTt;
    private final CustomMessageListener gTu;
    CustomMessageListener gTv;
    private CustomMessageListener gTw;
    private CustomMessageListener gTx;
    private CustomMessageListener gTy;
    private CustomMessageListener gTz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0274a {
        private static final a gTC = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gTa = false;
        this.gTb = false;
        this.gTc = false;
        this.gTd = false;
        this.gTe = false;
        this.gTf = false;
        this.gTg = false;
        this.gTh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gTi = 0;
        this.gTj = 0;
        this.gTk = 0;
        this.gTl = 0;
        this.gTm = false;
        this.mHasNewVersion = false;
        this.gTn = false;
        this.gTo = false;
        this.gTp = false;
        this.gTq = false;
        this.gTr = false;
        this.gTs = false;
        this.gTu = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gTv = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gTl >= responseUnreadPointNum.getNum()) {
                        a.this.gTl = responseUnreadPointNum.getNum();
                        a.this.gTm = false;
                    } else {
                        a.this.gTm = true;
                        a.this.gTd = a.this.gTm ? true : a.this.gTd;
                        a.this.gTl = responseUnreadPointNum.getNum();
                        a.this.bvN();
                    }
                    a.this.bvM();
                }
            }
        };
        this.gTw = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gTh = booleanValue;
                    a.this.gTs = booleanValue;
                    a.this.bvN();
                }
            }
        };
        this.gTx = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gTq = booleanValue;
                    a.this.gTf = booleanValue;
                    a.this.bvN();
                }
            }
        };
        this.gTy = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gTe = a.this.mHasNewVersion ? true : a.this.gTe;
                    a.this.bvN();
                }
            }
        };
        this.esY = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bvP();
                    }
                }
            }
        };
        this.gTz = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bvR();
                }
            }
        };
        this.gTA = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Gh()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Gm = activityPrizeData.Gm();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Gm) && !Gm.equals(string)) {
                            a.this.gTg = true;
                            a.this.gTr = true;
                            a.this.bvN();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bvJ() {
        return C0274a.gTC;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gTu);
        MessageManager.getInstance().registerListener(this.gTv);
        MessageManager.getInstance().registerListener(this.gTy);
        MessageManager.getInstance().registerListener(this.gTz);
        MessageManager.getInstance().registerListener(this.gTx);
        MessageManager.getInstance().registerListener(this.esY);
        MessageManager.getInstance().registerListener(this.gTw);
        MessageManager.getInstance().registerListener(this.gTA);
    }

    private void bvK() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gTe = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gTt = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bvL() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gTe)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gTp = newsNotifyMessage.getMsgBookmark() > this.gTk;
            this.gTn = newsNotifyMessage.getMsgFans() > this.gTi;
            this.gTo = newsNotifyMessage.getMsgGiftNum() > this.gTj;
            this.gTk = newsNotifyMessage.getMsgBookmark();
            this.gTi = newsNotifyMessage.getMsgFans();
            this.gTj = newsNotifyMessage.getMsgGiftNum();
            if (this.gTp || this.gTn || this.gTo || this.mHasNewVersion) {
                this.gTa = this.gTn ? true : this.gTa;
                this.gTb = this.gTp ? true : this.gTb;
                this.gTc = this.gTo ? true : this.gTc;
                this.gTe = this.mHasNewVersion ? true : this.gTe;
                bvN();
            }
        }
    }

    public void bvM() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gTm);
    }

    public void mP(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvN() {
        SparseArray sparseArray = new SparseArray();
        if (this.gTm) {
            sparseArray.append(4, new b.a(this.gTd, this.gTl));
        }
        if (this.gTn) {
            sparseArray.append(2, new b.a(this.gTa, this.gTi));
        }
        if (this.gTo) {
            sparseArray.append(1, new b.a(this.gTc, this.gTj));
        }
        if (this.gTp) {
            sparseArray.append(3, new b.a(this.gTb, this.gTk));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gTe, 0));
        }
        if (this.gTq) {
            sparseArray.append(7, new b.a(this.gTf, 0));
        }
        if (this.gTr) {
            sparseArray.append(9, new b.a(this.gTg, 0));
        }
        if (this.gTs) {
            sparseArray.append(10, new b.a(this.gTh, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bvO();
    }

    public void mQ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gTd, this.gTl));
            sparseArray.append(2, new b.a(this.gTa, this.gTi));
            sparseArray.append(1, new b.a(this.gTc, this.gTj));
            sparseArray.append(3, new b.a(this.gTb, this.gTk));
            sparseArray.append(5, new b.a(this.gTe, 0));
            sparseArray.append(7, new b.a(this.gTf, 0));
            sparseArray.append(9, new b.a(this.gTg, 0));
            sparseArray.append(10, new b.a(this.gTh, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bvO() {
        if (((this.gTi > 0 && this.gTn) || (this.gTk > 0 && this.gTp) || this.mHasNewVersion || this.gTr || this.gTs) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gTs) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bvP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gTc = z;
                    break;
                case 2:
                    this.gTa = z;
                    break;
                case 3:
                    this.gTb = z;
                    break;
                case 4:
                    this.gTd = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gTe = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gTf = z;
                    break;
                case 9:
                    this.gTg = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Gm());
                    break;
                case 10:
                    this.gTh = z;
                    break;
            }
            mQ(true);
            bvQ();
        }
    }

    private void bvQ() {
        boolean z = this.gTc || this.gTb || this.gTa || this.gTd || this.gTe || this.gTf || this.gTg;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bvR() {
        this.gTa = false;
        this.gTb = false;
        this.gTc = false;
        this.gTd = false;
        this.gTe = false;
        this.gTf = false;
        this.gTg = false;
        this.gTi = 0;
        this.gTj = 0;
        this.gTk = 0;
        this.gTl = 0;
        this.gTm = false;
        this.mHasNewVersion = false;
        this.gTn = false;
        this.gTo = false;
        this.gTp = false;
        this.gTq = false;
        this.gTr = false;
        bvK();
        e.jG().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gTt) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bvL();
    }
}
