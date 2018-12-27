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
    private CustomMessageListener evP;
    private boolean gVV;
    private boolean gVW;
    private boolean gVX;
    private boolean gVY;
    private boolean gVZ;
    private boolean gWa;
    private boolean gWb;
    private boolean gWc;
    private int gWd;
    private int gWe;
    private int gWf;
    private int gWg;
    private boolean gWh;
    private boolean gWi;
    private boolean gWj;
    private boolean gWk;
    private boolean gWl;
    private boolean gWm;
    private boolean gWn;
    private boolean gWo;
    private final CustomMessageListener gWp;
    CustomMessageListener gWq;
    private CustomMessageListener gWr;
    private CustomMessageListener gWs;
    private CustomMessageListener gWt;
    private CustomMessageListener gWu;
    private CustomMessageListener gWv;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0274a {
        private static final a gWx = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gVV = false;
        this.gVW = false;
        this.gVX = false;
        this.gVY = false;
        this.gVZ = false;
        this.gWa = false;
        this.gWb = false;
        this.gWc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gWd = 0;
        this.gWe = 0;
        this.gWf = 0;
        this.gWg = 0;
        this.gWh = false;
        this.mHasNewVersion = false;
        this.gWi = false;
        this.gWj = false;
        this.gWk = false;
        this.gWl = false;
        this.gWm = false;
        this.gWn = false;
        this.gWp = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gWq = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gWg >= responseUnreadPointNum.getNum()) {
                        a.this.gWg = responseUnreadPointNum.getNum();
                        a.this.gWh = false;
                    } else {
                        a.this.gWh = true;
                        a.this.gVY = a.this.gWh ? true : a.this.gVY;
                        a.this.gWg = responseUnreadPointNum.getNum();
                        a.this.bwA();
                    }
                    a.this.bwz();
                }
            }
        };
        this.gWr = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gWc = booleanValue;
                    a.this.gWn = booleanValue;
                    a.this.bwA();
                }
            }
        };
        this.gWs = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gWl = booleanValue;
                    a.this.gWa = booleanValue;
                    a.this.bwA();
                }
            }
        };
        this.gWt = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gVZ = a.this.mHasNewVersion ? true : a.this.gVZ;
                    a.this.bwA();
                }
            }
        };
        this.evP = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bwC();
                    }
                }
            }
        };
        this.gWu = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bwE();
                }
            }
        };
        this.gWv = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Gi()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Gn = activityPrizeData.Gn();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Gn) && !Gn.equals(string)) {
                            a.this.gWb = true;
                            a.this.gWm = true;
                            a.this.bwA();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bww() {
        return C0274a.gWx;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gWp);
        MessageManager.getInstance().registerListener(this.gWq);
        MessageManager.getInstance().registerListener(this.gWt);
        MessageManager.getInstance().registerListener(this.gWu);
        MessageManager.getInstance().registerListener(this.gWs);
        MessageManager.getInstance().registerListener(this.evP);
        MessageManager.getInstance().registerListener(this.gWr);
        MessageManager.getInstance().registerListener(this.gWv);
    }

    private void bwx() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gVZ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gWo = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bwy() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gVZ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gWk = newsNotifyMessage.getMsgBookmark() > this.gWf;
            this.gWi = newsNotifyMessage.getMsgFans() > this.gWd;
            this.gWj = newsNotifyMessage.getMsgGiftNum() > this.gWe;
            this.gWf = newsNotifyMessage.getMsgBookmark();
            this.gWd = newsNotifyMessage.getMsgFans();
            this.gWe = newsNotifyMessage.getMsgGiftNum();
            if (this.gWk || this.gWi || this.gWj || this.mHasNewVersion) {
                this.gVV = this.gWi ? true : this.gVV;
                this.gVW = this.gWk ? true : this.gVW;
                this.gVX = this.gWj ? true : this.gVX;
                this.gVZ = this.mHasNewVersion ? true : this.gVZ;
                bwA();
            }
        }
    }

    public void bwz() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gWh);
    }

    public void mS(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwA() {
        SparseArray sparseArray = new SparseArray();
        if (this.gWh) {
            sparseArray.append(4, new b.a(this.gVY, this.gWg));
        }
        if (this.gWi) {
            sparseArray.append(2, new b.a(this.gVV, this.gWd));
        }
        if (this.gWj) {
            sparseArray.append(1, new b.a(this.gVX, this.gWe));
        }
        if (this.gWk) {
            sparseArray.append(3, new b.a(this.gVW, this.gWf));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gVZ, 0));
        }
        if (this.gWl) {
            sparseArray.append(7, new b.a(this.gWa, 0));
        }
        if (this.gWm) {
            sparseArray.append(9, new b.a(this.gWb, 0));
        }
        if (this.gWn) {
            sparseArray.append(10, new b.a(this.gWc, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bwB();
    }

    public void mT(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gVY, this.gWg));
            sparseArray.append(2, new b.a(this.gVV, this.gWd));
            sparseArray.append(1, new b.a(this.gVX, this.gWe));
            sparseArray.append(3, new b.a(this.gVW, this.gWf));
            sparseArray.append(5, new b.a(this.gVZ, 0));
            sparseArray.append(7, new b.a(this.gWa, 0));
            sparseArray.append(9, new b.a(this.gWb, 0));
            sparseArray.append(10, new b.a(this.gWc, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bwB() {
        if (((this.gWd > 0 && this.gWi) || (this.gWf > 0 && this.gWk) || this.mHasNewVersion || this.gWm || this.gWn) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gWn) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bwC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gVX = z;
                    break;
                case 2:
                    this.gVV = z;
                    break;
                case 3:
                    this.gVW = z;
                    break;
                case 4:
                    this.gVY = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gVZ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gWa = z;
                    break;
                case 9:
                    this.gWb = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Gn());
                    break;
                case 10:
                    this.gWc = z;
                    break;
            }
            mT(true);
            bwD();
        }
    }

    private void bwD() {
        boolean z = this.gVX || this.gVW || this.gVV || this.gVY || this.gVZ || this.gWa || this.gWb;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bwE() {
        this.gVV = false;
        this.gVW = false;
        this.gVX = false;
        this.gVY = false;
        this.gVZ = false;
        this.gWa = false;
        this.gWb = false;
        this.gWd = 0;
        this.gWe = 0;
        this.gWf = 0;
        this.gWg = 0;
        this.gWh = false;
        this.mHasNewVersion = false;
        this.gWi = false;
        this.gWj = false;
        this.gWk = false;
        this.gWl = false;
        this.gWm = false;
        bwx();
        e.jG().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gWo) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bwy();
    }
}
