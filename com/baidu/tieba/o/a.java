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
    private CustomMessageListener ekK;
    private boolean gKL;
    private boolean gKM;
    private boolean gKN;
    private boolean gKO;
    private boolean gKP;
    private boolean gKQ;
    private boolean gKR;
    private boolean gKS;
    private int gKT;
    private int gKU;
    private int gKV;
    private int gKW;
    private boolean gKX;
    private boolean gKY;
    private boolean gKZ;
    private boolean gLa;
    private boolean gLb;
    private boolean gLc;
    private boolean gLd;
    private boolean gLe;
    private final CustomMessageListener gLf;
    CustomMessageListener gLg;
    private CustomMessageListener gLh;
    private CustomMessageListener gLi;
    private CustomMessageListener gLj;
    private CustomMessageListener gLk;
    private CustomMessageListener gLl;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0237a {
        private static final a gLn = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gKL = false;
        this.gKM = false;
        this.gKN = false;
        this.gKO = false;
        this.gKP = false;
        this.gKQ = false;
        this.gKR = false;
        this.gKS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gKT = 0;
        this.gKU = 0;
        this.gKV = 0;
        this.gKW = 0;
        this.gKX = false;
        this.mHasNewVersion = false;
        this.gKY = false;
        this.gKZ = false;
        this.gLa = false;
        this.gLb = false;
        this.gLc = false;
        this.gLd = false;
        this.gLf = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gLg = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gKW >= responseUnreadPointNum.getNum()) {
                        a.this.gKW = responseUnreadPointNum.getNum();
                        a.this.gKX = false;
                    } else {
                        a.this.gKX = true;
                        a.this.gKO = a.this.gKX ? true : a.this.gKO;
                        a.this.gKW = responseUnreadPointNum.getNum();
                        a.this.buy();
                    }
                    a.this.bux();
                }
            }
        };
        this.gLh = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gKS = booleanValue;
                    a.this.gLd = booleanValue;
                    a.this.buy();
                }
            }
        };
        this.gLi = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gLb = booleanValue;
                    a.this.gKQ = booleanValue;
                    a.this.buy();
                }
            }
        };
        this.gLj = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gKP = a.this.mHasNewVersion ? true : a.this.gKP;
                    a.this.buy();
                }
            }
        };
        this.ekK = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
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
        this.gLk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.buC();
                }
            }
        };
        this.gLl = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
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
                            a.this.gKR = true;
                            a.this.gLc = true;
                            a.this.buy();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a buu() {
        return C0237a.gLn;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gLf);
        MessageManager.getInstance().registerListener(this.gLg);
        MessageManager.getInstance().registerListener(this.gLj);
        MessageManager.getInstance().registerListener(this.gLk);
        MessageManager.getInstance().registerListener(this.gLi);
        MessageManager.getInstance().registerListener(this.ekK);
        MessageManager.getInstance().registerListener(this.gLh);
        MessageManager.getInstance().registerListener(this.gLl);
    }

    private void buv() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gKP = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gLe = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void buw() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gKP)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gLa = newsNotifyMessage.getMsgBookmark() > this.gKV;
            this.gKY = newsNotifyMessage.getMsgFans() > this.gKT;
            this.gKZ = newsNotifyMessage.getMsgGiftNum() > this.gKU;
            this.gKV = newsNotifyMessage.getMsgBookmark();
            this.gKT = newsNotifyMessage.getMsgFans();
            this.gKU = newsNotifyMessage.getMsgGiftNum();
            if (this.gLa || this.gKY || this.gKZ || this.mHasNewVersion) {
                this.gKL = this.gKY ? true : this.gKL;
                this.gKM = this.gLa ? true : this.gKM;
                this.gKN = this.gKZ ? true : this.gKN;
                this.gKP = this.mHasNewVersion ? true : this.gKP;
                buy();
            }
        }
    }

    public void bux() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gKX);
    }

    public void mB(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buy() {
        SparseArray sparseArray = new SparseArray();
        if (this.gKX) {
            sparseArray.append(4, new b.a(this.gKO, this.gKW));
        }
        if (this.gKY) {
            sparseArray.append(2, new b.a(this.gKL, this.gKT));
        }
        if (this.gKZ) {
            sparseArray.append(1, new b.a(this.gKN, this.gKU));
        }
        if (this.gLa) {
            sparseArray.append(3, new b.a(this.gKM, this.gKV));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gKP, 0));
        }
        if (this.gLb) {
            sparseArray.append(7, new b.a(this.gKQ, 0));
        }
        if (this.gLc) {
            sparseArray.append(9, new b.a(this.gKR, 0));
        }
        if (this.gLd) {
            sparseArray.append(10, new b.a(this.gKS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        buz();
    }

    public void mC(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gKO, this.gKW));
            sparseArray.append(2, new b.a(this.gKL, this.gKT));
            sparseArray.append(1, new b.a(this.gKN, this.gKU));
            sparseArray.append(3, new b.a(this.gKM, this.gKV));
            sparseArray.append(5, new b.a(this.gKP, 0));
            sparseArray.append(7, new b.a(this.gKQ, 0));
            sparseArray.append(9, new b.a(this.gKR, 0));
            sparseArray.append(10, new b.a(this.gKS, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void buz() {
        if (((this.gKT > 0 && this.gKY) || (this.gKV > 0 && this.gLa) || this.mHasNewVersion || this.gLc || this.gLd) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gLd) {
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
                    this.gKN = z;
                    break;
                case 2:
                    this.gKL = z;
                    break;
                case 3:
                    this.gKM = z;
                    break;
                case 4:
                    this.gKO = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gKP = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gKQ = z;
                    break;
                case 9:
                    this.gKR = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().EX());
                    break;
                case 10:
                    this.gKS = z;
                    break;
            }
            mC(true);
            buB();
        }
    }

    private void buB() {
        boolean z = this.gKN || this.gKM || this.gKL || this.gKO || this.gKP || this.gKQ || this.gKR;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void buC() {
        this.gKL = false;
        this.gKM = false;
        this.gKN = false;
        this.gKO = false;
        this.gKP = false;
        this.gKQ = false;
        this.gKR = false;
        this.gKT = 0;
        this.gKU = 0;
        this.gKV = 0;
        this.gKW = 0;
        this.gKX = false;
        this.mHasNewVersion = false;
        this.gKY = false;
        this.gKZ = false;
        this.gLa = false;
        this.gLb = false;
        this.gLc = false;
        buv();
        e.jI().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gLe) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        buw();
    }
}
