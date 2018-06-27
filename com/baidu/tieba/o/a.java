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
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener dRQ;
    private boolean guF;
    private boolean guG;
    private boolean guH;
    private boolean guI;
    private boolean guJ;
    private boolean guK;
    private boolean guL;
    private boolean guM;
    private int guN;
    private int guO;
    private int guP;
    private int guQ;
    private boolean guR;
    private boolean guS;
    private boolean guT;
    private boolean guU;
    private boolean guV;
    private boolean guW;
    private boolean guX;
    private boolean guY;
    private final CustomMessageListener guZ;
    CustomMessageListener gva;
    private CustomMessageListener gvb;
    private CustomMessageListener gvc;
    private CustomMessageListener gvd;
    private CustomMessageListener gve;
    private CustomMessageListener gvf;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0202a {
        private static final a gvh = new a();
    }

    private a() {
        this.isPrimary = false;
        this.guF = false;
        this.guG = false;
        this.guH = false;
        this.guI = false;
        this.guJ = false;
        this.guK = false;
        this.guL = false;
        this.guM = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.guN = 0;
        this.guO = 0;
        this.guP = 0;
        this.guQ = 0;
        this.guR = false;
        this.mHasNewVersion = false;
        this.guS = false;
        this.guT = false;
        this.guU = false;
        this.guV = false;
        this.guW = false;
        this.guX = false;
        this.guZ = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gva = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.guQ >= responseUnreadPointNum.getNum()) {
                        a.this.guQ = responseUnreadPointNum.getNum();
                        a.this.guR = false;
                    } else {
                        a.this.guR = true;
                        a.this.guI = a.this.guR ? true : a.this.guI;
                        a.this.guQ = responseUnreadPointNum.getNum();
                        a.this.bpV();
                    }
                    a.this.bpU();
                }
            }
        };
        this.gvb = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.guM = booleanValue;
                    a.this.guX = booleanValue;
                    a.this.bpV();
                }
            }
        };
        this.gvc = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.guV = booleanValue;
                    a.this.guK = booleanValue;
                    a.this.bpV();
                }
            }
        };
        this.gvd = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.guJ = a.this.mHasNewVersion ? true : a.this.guJ;
                    a.this.bpV();
                }
            }
        };
        this.dRQ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bpX();
                    }
                }
            }
        };
        this.gve = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bpZ();
                }
            }
        };
        this.gvf = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.BL()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String BQ = activityPrizeData.BQ();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(BQ) && !BQ.equals(string)) {
                            a.this.guL = true;
                            a.this.guW = true;
                            a.this.bpV();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bpR() {
        return C0202a.gvh;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.guZ);
        MessageManager.getInstance().registerListener(this.gva);
        MessageManager.getInstance().registerListener(this.gvd);
        MessageManager.getInstance().registerListener(this.gve);
        MessageManager.getInstance().registerListener(this.gvc);
        MessageManager.getInstance().registerListener(this.dRQ);
        MessageManager.getInstance().registerListener(this.gvb);
        MessageManager.getInstance().registerListener(this.gvf);
    }

    private void bpS() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.guJ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.guY = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bpT() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.guJ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.guU = newsNotifyMessage.getMsgBookmark() > this.guP;
            this.guS = newsNotifyMessage.getMsgFans() > this.guN;
            this.guT = newsNotifyMessage.getMsgGiftNum() > this.guO;
            this.guP = newsNotifyMessage.getMsgBookmark();
            this.guN = newsNotifyMessage.getMsgFans();
            this.guO = newsNotifyMessage.getMsgGiftNum();
            if (this.guU || this.guS || this.guT || this.mHasNewVersion) {
                this.guF = this.guS ? true : this.guF;
                this.guG = this.guU ? true : this.guG;
                this.guH = this.guT ? true : this.guH;
                this.guJ = this.mHasNewVersion ? true : this.guJ;
                bpV();
            }
        }
    }

    public void bpU() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.guR);
    }

    public void lZ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpV() {
        SparseArray sparseArray = new SparseArray();
        if (this.guR) {
            sparseArray.append(4, new b.a(this.guI, this.guQ));
        }
        if (this.guS) {
            sparseArray.append(2, new b.a(this.guF, this.guN));
        }
        if (this.guT) {
            sparseArray.append(1, new b.a(this.guH, this.guO));
        }
        if (this.guU) {
            sparseArray.append(3, new b.a(this.guG, this.guP));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.guJ, 0));
        }
        if (this.guV) {
            sparseArray.append(7, new b.a(this.guK, 0));
        }
        if (this.guW) {
            sparseArray.append(9, new b.a(this.guL, 0));
        }
        if (this.guX) {
            sparseArray.append(10, new b.a(this.guM, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bpW();
    }

    public void ma(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.guI, this.guQ));
            sparseArray.append(2, new b.a(this.guF, this.guN));
            sparseArray.append(1, new b.a(this.guH, this.guO));
            sparseArray.append(3, new b.a(this.guG, this.guP));
            sparseArray.append(5, new b.a(this.guJ, 0));
            sparseArray.append(7, new b.a(this.guK, 0));
            sparseArray.append(9, new b.a(this.guL, 0));
            sparseArray.append(10, new b.a(this.guM, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bpW() {
        if (((this.guN > 0 && this.guS) || (this.guP > 0 && this.guU) || this.mHasNewVersion || this.guW || this.guX) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.guX) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bpX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.guH = z;
                    break;
                case 2:
                    this.guF = z;
                    break;
                case 3:
                    this.guG = z;
                    break;
                case 4:
                    this.guI = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.guJ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.guK = z;
                    break;
                case 9:
                    this.guL = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().BQ());
                    break;
                case 10:
                    this.guM = z;
                    break;
            }
            ma(true);
            bpY();
        }
    }

    private void bpY() {
        boolean z = this.guH || this.guG || this.guF || this.guI || this.guJ || this.guK || this.guL;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bpZ() {
        this.guF = false;
        this.guG = false;
        this.guH = false;
        this.guI = false;
        this.guJ = false;
        this.guK = false;
        this.guL = false;
        this.guN = 0;
        this.guO = 0;
        this.guP = 0;
        this.guQ = 0;
        this.guR = false;
        this.mHasNewVersion = false;
        this.guS = false;
        this.guT = false;
        this.guU = false;
        this.guV = false;
        this.guW = false;
        bpS();
        e.im().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.guY) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bpT();
    }
}
