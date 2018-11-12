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
    private CustomMessageListener emd;
    private boolean gMA;
    private boolean gMB;
    private boolean gMC;
    private boolean gMD;
    private final CustomMessageListener gME;
    CustomMessageListener gMF;
    private CustomMessageListener gMG;
    private CustomMessageListener gMH;
    private CustomMessageListener gMI;
    private CustomMessageListener gMJ;
    private CustomMessageListener gMK;
    private boolean gMk;
    private boolean gMl;
    private boolean gMm;
    private boolean gMn;
    private boolean gMo;
    private boolean gMp;
    private boolean gMq;
    private boolean gMr;
    private int gMs;
    private int gMt;
    private int gMu;
    private int gMv;
    private boolean gMw;
    private boolean gMx;
    private boolean gMy;
    private boolean gMz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0263a {
        private static final a gMM = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gMk = false;
        this.gMl = false;
        this.gMm = false;
        this.gMn = false;
        this.gMo = false;
        this.gMp = false;
        this.gMq = false;
        this.gMr = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gMs = 0;
        this.gMt = 0;
        this.gMu = 0;
        this.gMv = 0;
        this.gMw = false;
        this.mHasNewVersion = false;
        this.gMx = false;
        this.gMy = false;
        this.gMz = false;
        this.gMA = false;
        this.gMB = false;
        this.gMC = false;
        this.gME = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gMF = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gMv >= responseUnreadPointNum.getNum()) {
                        a.this.gMv = responseUnreadPointNum.getNum();
                        a.this.gMw = false;
                    } else {
                        a.this.gMw = true;
                        a.this.gMn = a.this.gMw ? true : a.this.gMn;
                        a.this.gMv = responseUnreadPointNum.getNum();
                        a.this.btU();
                    }
                    a.this.btT();
                }
            }
        };
        this.gMG = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gMr = booleanValue;
                    a.this.gMC = booleanValue;
                    a.this.btU();
                }
            }
        };
        this.gMH = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gMA = booleanValue;
                    a.this.gMp = booleanValue;
                    a.this.btU();
                }
            }
        };
        this.gMI = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gMo = a.this.mHasNewVersion ? true : a.this.gMo;
                    a.this.btU();
                }
            }
        };
        this.emd = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.btW();
                    }
                }
            }
        };
        this.gMJ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.btY();
                }
            }
        };
        this.gMK = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Fd()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Fi = activityPrizeData.Fi();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Fi) && !Fi.equals(string)) {
                            a.this.gMq = true;
                            a.this.gMB = true;
                            a.this.btU();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a btQ() {
        return C0263a.gMM;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gME);
        MessageManager.getInstance().registerListener(this.gMF);
        MessageManager.getInstance().registerListener(this.gMI);
        MessageManager.getInstance().registerListener(this.gMJ);
        MessageManager.getInstance().registerListener(this.gMH);
        MessageManager.getInstance().registerListener(this.emd);
        MessageManager.getInstance().registerListener(this.gMG);
        MessageManager.getInstance().registerListener(this.gMK);
    }

    private void btR() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gMo = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gMD = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void btS() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gMo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gMz = newsNotifyMessage.getMsgBookmark() > this.gMu;
            this.gMx = newsNotifyMessage.getMsgFans() > this.gMs;
            this.gMy = newsNotifyMessage.getMsgGiftNum() > this.gMt;
            this.gMu = newsNotifyMessage.getMsgBookmark();
            this.gMs = newsNotifyMessage.getMsgFans();
            this.gMt = newsNotifyMessage.getMsgGiftNum();
            if (this.gMz || this.gMx || this.gMy || this.mHasNewVersion) {
                this.gMk = this.gMx ? true : this.gMk;
                this.gMl = this.gMz ? true : this.gMl;
                this.gMm = this.gMy ? true : this.gMm;
                this.gMo = this.mHasNewVersion ? true : this.gMo;
                btU();
            }
        }
    }

    public void btT() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gMw);
    }

    public void mM(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btU() {
        SparseArray sparseArray = new SparseArray();
        if (this.gMw) {
            sparseArray.append(4, new b.a(this.gMn, this.gMv));
        }
        if (this.gMx) {
            sparseArray.append(2, new b.a(this.gMk, this.gMs));
        }
        if (this.gMy) {
            sparseArray.append(1, new b.a(this.gMm, this.gMt));
        }
        if (this.gMz) {
            sparseArray.append(3, new b.a(this.gMl, this.gMu));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gMo, 0));
        }
        if (this.gMA) {
            sparseArray.append(7, new b.a(this.gMp, 0));
        }
        if (this.gMB) {
            sparseArray.append(9, new b.a(this.gMq, 0));
        }
        if (this.gMC) {
            sparseArray.append(10, new b.a(this.gMr, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        btV();
    }

    public void mN(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gMn, this.gMv));
            sparseArray.append(2, new b.a(this.gMk, this.gMs));
            sparseArray.append(1, new b.a(this.gMm, this.gMt));
            sparseArray.append(3, new b.a(this.gMl, this.gMu));
            sparseArray.append(5, new b.a(this.gMo, 0));
            sparseArray.append(7, new b.a(this.gMp, 0));
            sparseArray.append(9, new b.a(this.gMq, 0));
            sparseArray.append(10, new b.a(this.gMr, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void btV() {
        if (((this.gMs > 0 && this.gMx) || (this.gMu > 0 && this.gMz) || this.mHasNewVersion || this.gMB || this.gMC) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gMC) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void btW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gMm = z;
                    break;
                case 2:
                    this.gMk = z;
                    break;
                case 3:
                    this.gMl = z;
                    break;
                case 4:
                    this.gMn = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gMo = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gMp = z;
                    break;
                case 9:
                    this.gMq = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Fi());
                    break;
                case 10:
                    this.gMr = z;
                    break;
            }
            mN(true);
            btX();
        }
    }

    private void btX() {
        boolean z = this.gMm || this.gMl || this.gMk || this.gMn || this.gMo || this.gMp || this.gMq;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void btY() {
        this.gMk = false;
        this.gMl = false;
        this.gMm = false;
        this.gMn = false;
        this.gMo = false;
        this.gMp = false;
        this.gMq = false;
        this.gMs = 0;
        this.gMt = 0;
        this.gMu = 0;
        this.gMv = 0;
        this.gMw = false;
        this.mHasNewVersion = false;
        this.gMx = false;
        this.gMy = false;
        this.gMz = false;
        this.gMA = false;
        this.gMB = false;
        btR();
        e.jG().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gMD) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        btS();
    }
}
