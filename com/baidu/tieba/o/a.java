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
    private CustomMessageListener fZJ;
    private boolean ggU;
    private boolean iHA;
    private boolean iHB;
    private boolean iHC;
    private boolean iHD;
    private boolean iHE;
    private final CustomMessageListener iHF;
    CustomMessageListener iHG;
    private CustomMessageListener iHH;
    private CustomMessageListener iHI;
    private CustomMessageListener iHJ;
    private CustomMessageListener iHK;
    private CustomMessageListener iHL;
    private boolean iHm;
    private boolean iHn;
    private boolean iHo;
    private boolean iHp;
    private boolean iHq;
    private boolean iHr;
    private boolean iHs;
    private boolean iHt;
    private int iHu;
    private int iHv;
    private int iHw;
    private int iHx;
    private boolean iHy;
    private boolean iHz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0362a {
        private static final a iHN = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iHm = false;
        this.iHn = false;
        this.iHo = false;
        this.iHp = false;
        this.iHq = false;
        this.iHr = false;
        this.iHs = false;
        this.iHt = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_feedback_tip_show", false);
        this.iHu = 0;
        this.iHv = 0;
        this.iHw = 0;
        this.iHx = 0;
        this.iHy = false;
        this.mHasNewVersion = false;
        this.iHz = false;
        this.iHA = false;
        this.iHB = false;
        this.iHC = false;
        this.iHD = false;
        this.iHE = false;
        this.iHF = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iHG = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iHx >= responseUnreadPointNum.getNum()) {
                        a.this.iHx = responseUnreadPointNum.getNum();
                        a.this.iHy = false;
                    } else {
                        a.this.iHy = true;
                        a.this.iHp = a.this.iHy ? true : a.this.iHp;
                        a.this.iHx = responseUnreadPointNum.getNum();
                        a.this.cgd();
                    }
                    a.this.cgc();
                }
            }
        };
        this.iHH = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iHt = booleanValue;
                    a.this.iHE = booleanValue;
                    a.this.cgd();
                }
            }
        };
        this.iHI = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.iHC = booleanValue;
                    a.this.iHr = booleanValue;
                    a.this.cgd();
                }
            }
        };
        this.iHJ = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iHq = a.this.mHasNewVersion ? true : a.this.iHq;
                    a.this.cgd();
                }
            }
        };
        this.fZJ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cgf();
                    }
                }
            }
        };
        this.iHK = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cgh();
                }
            }
        };
        this.iHL = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
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
                            a.this.iHs = true;
                            a.this.iHD = true;
                            a.this.cgd();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cfZ() {
        return C0362a.iHN;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iHF);
        MessageManager.getInstance().registerListener(this.iHG);
        MessageManager.getInstance().registerListener(this.iHJ);
        MessageManager.getInstance().registerListener(this.iHK);
        MessageManager.getInstance().registerListener(this.iHI);
        MessageManager.getInstance().registerListener(this.fZJ);
        MessageManager.getInstance().registerListener(this.iHH);
        MessageManager.getInstance().registerListener(this.iHL);
    }

    private void cga() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iHq = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.ggU = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cgb() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iHq)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iHB = newsNotifyMessage.getMsgBookmark() > this.iHw;
            this.iHz = newsNotifyMessage.getMsgFans() > this.iHu;
            this.iHA = newsNotifyMessage.getMsgGiftNum() > this.iHv;
            this.iHw = newsNotifyMessage.getMsgBookmark();
            this.iHu = newsNotifyMessage.getMsgFans();
            this.iHv = newsNotifyMessage.getMsgGiftNum();
            if (this.iHB || this.iHz || this.iHA || this.mHasNewVersion) {
                this.iHm = this.iHz ? true : this.iHm;
                this.iHn = this.iHB ? true : this.iHn;
                this.iHo = this.iHA ? true : this.iHo;
                this.iHq = this.mHasNewVersion ? true : this.iHq;
                cgd();
            }
        }
    }

    public void cgc() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iHy);
    }

    public void qh(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgd() {
        SparseArray sparseArray = new SparseArray();
        if (this.iHy) {
            sparseArray.append(4, new b.a(this.iHp, this.iHx));
        }
        if (this.iHz) {
            sparseArray.append(2, new b.a(this.iHm, this.iHu));
        }
        if (this.iHA) {
            sparseArray.append(1, new b.a(this.iHo, this.iHv));
        }
        if (this.iHB) {
            sparseArray.append(3, new b.a(this.iHn, this.iHw));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iHq, 0));
        }
        if (this.iHC) {
            sparseArray.append(7, new b.a(this.iHr, 0));
        }
        if (this.iHD) {
            sparseArray.append(9, new b.a(this.iHs, 0));
        }
        if (this.iHE) {
            sparseArray.append(10, new b.a(this.iHt, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        cge();
    }

    public void qi(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iHp, this.iHx));
            sparseArray.append(2, new b.a(this.iHm, this.iHu));
            sparseArray.append(1, new b.a(this.iHo, this.iHv));
            sparseArray.append(3, new b.a(this.iHn, this.iHw));
            sparseArray.append(5, new b.a(this.iHq, 0));
            sparseArray.append(7, new b.a(this.iHr, 0));
            sparseArray.append(9, new b.a(this.iHs, 0));
            sparseArray.append(10, new b.a(this.iHt, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void cge() {
        if (((this.iHu > 0 && this.iHz) || (this.iHw > 0 && this.iHB) || this.mHasNewVersion || this.iHD || this.iHE) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iHE) {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cgf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iHo = z;
                    break;
                case 2:
                    this.iHm = z;
                    break;
                case 3:
                    this.iHn = z;
                    break;
                case 4:
                    this.iHp = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iHq = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iHr = z;
                    break;
                case 9:
                    this.iHs = z;
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().akQ());
                    break;
                case 10:
                    this.iHt = z;
                    break;
            }
            qi(true);
            cgg();
        }
    }

    private void cgg() {
        boolean z = this.iHo || this.iHn || this.iHm || this.iHp || this.iHq || this.iHr || this.iHs;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cgh() {
        this.iHm = false;
        this.iHn = false;
        this.iHo = false;
        this.iHp = false;
        this.iHq = false;
        this.iHr = false;
        this.iHs = false;
        this.iHu = 0;
        this.iHv = 0;
        this.iHw = 0;
        this.iHx = 0;
        this.iHy = false;
        this.mHasNewVersion = false;
        this.iHz = false;
        this.iHA = false;
        this.iHB = false;
        this.iHC = false;
        this.iHD = false;
        cga();
        e.iB().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ggU) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cgb();
    }
}
