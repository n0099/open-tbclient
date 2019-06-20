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
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener fZL;
    private boolean ggW;
    private int iHA;
    private int iHB;
    private boolean iHC;
    private boolean iHD;
    private boolean iHE;
    private boolean iHF;
    private boolean iHG;
    private boolean iHH;
    private boolean iHI;
    private final CustomMessageListener iHJ;
    CustomMessageListener iHK;
    private CustomMessageListener iHL;
    private CustomMessageListener iHM;
    private CustomMessageListener iHN;
    private CustomMessageListener iHO;
    private CustomMessageListener iHP;
    private boolean iHq;
    private boolean iHr;
    private boolean iHs;
    private boolean iHt;
    private boolean iHu;
    private boolean iHv;
    private boolean iHw;
    private boolean iHx;
    private int iHy;
    private int iHz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0362a {
        private static final a iHR = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iHq = false;
        this.iHr = false;
        this.iHs = false;
        this.iHt = false;
        this.iHu = false;
        this.iHv = false;
        this.iHw = false;
        this.iHx = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_feedback_tip_show", false);
        this.iHy = 0;
        this.iHz = 0;
        this.iHA = 0;
        this.iHB = 0;
        this.iHC = false;
        this.mHasNewVersion = false;
        this.iHD = false;
        this.iHE = false;
        this.iHF = false;
        this.iHG = false;
        this.iHH = false;
        this.iHI = false;
        this.iHJ = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iHK = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iHB >= responseUnreadPointNum.getNum()) {
                        a.this.iHB = responseUnreadPointNum.getNum();
                        a.this.iHC = false;
                    } else {
                        a.this.iHC = true;
                        a.this.iHt = a.this.iHC ? true : a.this.iHt;
                        a.this.iHB = responseUnreadPointNum.getNum();
                        a.this.cge();
                    }
                    a.this.cgd();
                }
            }
        };
        this.iHL = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iHx = booleanValue;
                    a.this.iHI = booleanValue;
                    a.this.cge();
                }
            }
        };
        this.iHM = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.agM().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iHG = booleanValue;
                    a.this.iHv = booleanValue;
                    a.this.cge();
                }
            }
        };
        this.iHN = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iHu = a.this.mHasNewVersion ? true : a.this.iHu;
                    a.this.cge();
                }
            }
        };
        this.fZL = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cgg();
                    }
                }
            }
        };
        this.iHO = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cgi();
                }
            }
        };
        this.iHP = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.akL()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String akQ = activityPrizeData.akQ();
                        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(akQ) && !akQ.equals(string)) {
                            a.this.iHw = true;
                            a.this.iHH = true;
                            a.this.cge();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cga() {
        return C0362a.iHR;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iHJ);
        MessageManager.getInstance().registerListener(this.iHK);
        MessageManager.getInstance().registerListener(this.iHN);
        MessageManager.getInstance().registerListener(this.iHO);
        MessageManager.getInstance().registerListener(this.iHM);
        MessageManager.getInstance().registerListener(this.fZL);
        MessageManager.getInstance().registerListener(this.iHL);
        MessageManager.getInstance().registerListener(this.iHP);
    }

    private void cgb() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iHu = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.ggW = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cgc() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iHu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iHF = newsNotifyMessage.getMsgBookmark() > this.iHA;
            this.iHD = newsNotifyMessage.getMsgFans() > this.iHy;
            this.iHE = newsNotifyMessage.getMsgGiftNum() > this.iHz;
            this.iHA = newsNotifyMessage.getMsgBookmark();
            this.iHy = newsNotifyMessage.getMsgFans();
            this.iHz = newsNotifyMessage.getMsgGiftNum();
            if (this.iHF || this.iHD || this.iHE || this.mHasNewVersion) {
                this.iHq = this.iHD ? true : this.iHq;
                this.iHr = this.iHF ? true : this.iHr;
                this.iHs = this.iHE ? true : this.iHs;
                this.iHu = this.mHasNewVersion ? true : this.iHu;
                cge();
            }
        }
    }

    public void cgd() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iHC);
    }

    public void qi(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cge() {
        SparseArray sparseArray = new SparseArray();
        if (this.iHC) {
            sparseArray.append(4, new b.a(this.iHt, this.iHB));
        }
        if (this.iHD) {
            sparseArray.append(2, new b.a(this.iHq, this.iHy));
        }
        if (this.iHE) {
            sparseArray.append(1, new b.a(this.iHs, this.iHz));
        }
        if (this.iHF) {
            sparseArray.append(3, new b.a(this.iHr, this.iHA));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iHu, 0));
        }
        if (this.iHG) {
            sparseArray.append(7, new b.a(this.iHv, 0));
        }
        if (this.iHH) {
            sparseArray.append(9, new b.a(this.iHw, 0));
        }
        if (this.iHI) {
            sparseArray.append(10, new b.a(this.iHx, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        cgf();
    }

    public void qj(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iHt, this.iHB));
            sparseArray.append(2, new b.a(this.iHq, this.iHy));
            sparseArray.append(1, new b.a(this.iHs, this.iHz));
            sparseArray.append(3, new b.a(this.iHr, this.iHA));
            sparseArray.append(5, new b.a(this.iHu, 0));
            sparseArray.append(7, new b.a(this.iHv, 0));
            sparseArray.append(9, new b.a(this.iHw, 0));
            sparseArray.append(10, new b.a(this.iHx, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void cgf() {
        if (((this.iHy > 0 && this.iHD) || (this.iHA > 0 && this.iHF) || this.mHasNewVersion || this.iHH || this.iHI) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iHI) {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cgg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iHs = z;
                    break;
                case 2:
                    this.iHq = z;
                    break;
                case 3:
                    this.iHr = z;
                    break;
                case 4:
                    this.iHt = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iHu = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iHv = z;
                    break;
                case 9:
                    this.iHw = z;
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().akQ());
                    break;
                case 10:
                    this.iHx = z;
                    break;
            }
            qj(true);
            cgh();
        }
    }

    private void cgh() {
        boolean z = this.iHs || this.iHr || this.iHq || this.iHt || this.iHu || this.iHv || this.iHw;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cgi() {
        this.iHq = false;
        this.iHr = false;
        this.iHs = false;
        this.iHt = false;
        this.iHu = false;
        this.iHv = false;
        this.iHw = false;
        this.iHy = 0;
        this.iHz = 0;
        this.iHA = 0;
        this.iHB = 0;
        this.iHC = false;
        this.mHasNewVersion = false;
        this.iHD = false;
        this.iHE = false;
        this.iHF = false;
        this.iHG = false;
        this.iHH = false;
        cgb();
        e.iB().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ggW) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cgc();
    }
}
