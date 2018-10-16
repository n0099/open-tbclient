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
    private CustomMessageListener ekJ;
    private boolean gKK;
    private boolean gKL;
    private boolean gKM;
    private boolean gKN;
    private boolean gKO;
    private boolean gKP;
    private boolean gKQ;
    private boolean gKR;
    private int gKS;
    private int gKT;
    private int gKU;
    private int gKV;
    private boolean gKW;
    private boolean gKX;
    private boolean gKY;
    private boolean gKZ;
    private boolean gLa;
    private boolean gLb;
    private boolean gLc;
    private boolean gLd;
    private final CustomMessageListener gLe;
    CustomMessageListener gLf;
    private CustomMessageListener gLg;
    private CustomMessageListener gLh;
    private CustomMessageListener gLi;
    private CustomMessageListener gLj;
    private CustomMessageListener gLk;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0237a {
        private static final a gLm = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gKK = false;
        this.gKL = false;
        this.gKM = false;
        this.gKN = false;
        this.gKO = false;
        this.gKP = false;
        this.gKQ = false;
        this.gKR = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gKS = 0;
        this.gKT = 0;
        this.gKU = 0;
        this.gKV = 0;
        this.gKW = false;
        this.mHasNewVersion = false;
        this.gKX = false;
        this.gKY = false;
        this.gKZ = false;
        this.gLa = false;
        this.gLb = false;
        this.gLc = false;
        this.gLe = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gLf = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gKV >= responseUnreadPointNum.getNum()) {
                        a.this.gKV = responseUnreadPointNum.getNum();
                        a.this.gKW = false;
                    } else {
                        a.this.gKW = true;
                        a.this.gKN = a.this.gKW ? true : a.this.gKN;
                        a.this.gKV = responseUnreadPointNum.getNum();
                        a.this.buy();
                    }
                    a.this.bux();
                }
            }
        };
        this.gLg = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gKR = booleanValue;
                    a.this.gLc = booleanValue;
                    a.this.buy();
                }
            }
        };
        this.gLh = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gLa = booleanValue;
                    a.this.gKP = booleanValue;
                    a.this.buy();
                }
            }
        };
        this.gLi = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gKO = a.this.mHasNewVersion ? true : a.this.gKO;
                    a.this.buy();
                }
            }
        };
        this.ekJ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.buA();
                    }
                }
            }
        };
        this.gLj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.buC();
                }
            }
        };
        this.gLk = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.ES()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String EX = activityPrizeData.EX();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(EX) && !EX.equals(string)) {
                            a.this.gKQ = true;
                            a.this.gLb = true;
                            a.this.buy();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a buu() {
        return C0237a.gLm;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gLe);
        MessageManager.getInstance().registerListener(this.gLf);
        MessageManager.getInstance().registerListener(this.gLi);
        MessageManager.getInstance().registerListener(this.gLj);
        MessageManager.getInstance().registerListener(this.gLh);
        MessageManager.getInstance().registerListener(this.ekJ);
        MessageManager.getInstance().registerListener(this.gLg);
        MessageManager.getInstance().registerListener(this.gLk);
    }

    private void buv() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gKO = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gLd = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void buw() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gKO)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gKZ = newsNotifyMessage.getMsgBookmark() > this.gKU;
            this.gKX = newsNotifyMessage.getMsgFans() > this.gKS;
            this.gKY = newsNotifyMessage.getMsgGiftNum() > this.gKT;
            this.gKU = newsNotifyMessage.getMsgBookmark();
            this.gKS = newsNotifyMessage.getMsgFans();
            this.gKT = newsNotifyMessage.getMsgGiftNum();
            if (this.gKZ || this.gKX || this.gKY || this.mHasNewVersion) {
                this.gKK = this.gKX ? true : this.gKK;
                this.gKL = this.gKZ ? true : this.gKL;
                this.gKM = this.gKY ? true : this.gKM;
                this.gKO = this.mHasNewVersion ? true : this.gKO;
                buy();
            }
        }
    }

    public void bux() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gKW);
    }

    public void mB(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buy() {
        SparseArray sparseArray = new SparseArray();
        if (this.gKW) {
            sparseArray.append(4, new b.a(this.gKN, this.gKV));
        }
        if (this.gKX) {
            sparseArray.append(2, new b.a(this.gKK, this.gKS));
        }
        if (this.gKY) {
            sparseArray.append(1, new b.a(this.gKM, this.gKT));
        }
        if (this.gKZ) {
            sparseArray.append(3, new b.a(this.gKL, this.gKU));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gKO, 0));
        }
        if (this.gLa) {
            sparseArray.append(7, new b.a(this.gKP, 0));
        }
        if (this.gLb) {
            sparseArray.append(9, new b.a(this.gKQ, 0));
        }
        if (this.gLc) {
            sparseArray.append(10, new b.a(this.gKR, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        buz();
    }

    public void mC(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gKN, this.gKV));
            sparseArray.append(2, new b.a(this.gKK, this.gKS));
            sparseArray.append(1, new b.a(this.gKM, this.gKT));
            sparseArray.append(3, new b.a(this.gKL, this.gKU));
            sparseArray.append(5, new b.a(this.gKO, 0));
            sparseArray.append(7, new b.a(this.gKP, 0));
            sparseArray.append(9, new b.a(this.gKQ, 0));
            sparseArray.append(10, new b.a(this.gKR, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void buz() {
        if (((this.gKS > 0 && this.gKX) || (this.gKU > 0 && this.gKZ) || this.mHasNewVersion || this.gLb || this.gLc) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gLc) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void buA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gKM = z;
                    break;
                case 2:
                    this.gKK = z;
                    break;
                case 3:
                    this.gKL = z;
                    break;
                case 4:
                    this.gKN = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gKO = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gKP = z;
                    break;
                case 9:
                    this.gKQ = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().EX());
                    break;
                case 10:
                    this.gKR = z;
                    break;
            }
            mC(true);
            buB();
        }
    }

    private void buB() {
        boolean z = this.gKM || this.gKL || this.gKK || this.gKN || this.gKO || this.gKP || this.gKQ;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void buC() {
        this.gKK = false;
        this.gKL = false;
        this.gKM = false;
        this.gKN = false;
        this.gKO = false;
        this.gKP = false;
        this.gKQ = false;
        this.gKS = 0;
        this.gKT = 0;
        this.gKU = 0;
        this.gKV = 0;
        this.gKW = false;
        this.mHasNewVersion = false;
        this.gKX = false;
        this.gKY = false;
        this.gKZ = false;
        this.gLa = false;
        this.gLb = false;
        buv();
        e.jI().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gLd) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        buw();
    }
}
