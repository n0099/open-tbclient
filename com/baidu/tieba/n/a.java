package com.baidu.tieba.n;

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
import com.baidu.tieba.n.b;
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener dCm;
    private int geA;
    private int geB;
    private int geC;
    private boolean geD;
    private boolean geE;
    private boolean geF;
    private boolean geG;
    private boolean geH;
    private boolean geI;
    private boolean geJ;
    private boolean geK;
    private final CustomMessageListener geL;
    CustomMessageListener geM;
    private CustomMessageListener geN;
    private CustomMessageListener geO;
    private CustomMessageListener geP;
    private CustomMessageListener geQ;
    private CustomMessageListener geR;
    private boolean ger;
    private boolean ges;
    private boolean get;
    private boolean geu;
    private boolean gev;
    private boolean gew;
    private boolean gex;
    private boolean gey;
    private int gez;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0184a {
        private static final a geT = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ger = false;
        this.ges = false;
        this.get = false;
        this.geu = false;
        this.gev = false;
        this.gew = false;
        this.gex = false;
        this.gey = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gez = 0;
        this.geA = 0;
        this.geB = 0;
        this.geC = 0;
        this.geD = false;
        this.mHasNewVersion = false;
        this.geE = false;
        this.geF = false;
        this.geG = false;
        this.geH = false;
        this.geI = false;
        this.geJ = false;
        this.geL = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.n.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.geM = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.n.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.geC >= responseUnreadPointNum.getNum()) {
                        a.this.geC = responseUnreadPointNum.getNum();
                        a.this.geD = false;
                    } else {
                        a.this.geD = true;
                        a.this.geu = a.this.geD ? true : a.this.geu;
                        a.this.geC = responseUnreadPointNum.getNum();
                        a.this.bkx();
                    }
                    a.this.bkw();
                }
            }
        };
        this.geN = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.n.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gey = booleanValue;
                    a.this.geJ = booleanValue;
                    a.this.bkx();
                }
            }
        };
        this.geO = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.n.a.4
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
                    a.this.geH = booleanValue;
                    a.this.gew = booleanValue;
                    a.this.bkx();
                }
            }
        };
        this.geP = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.n.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gev = a.this.mHasNewVersion ? true : a.this.gev;
                    a.this.bkx();
                }
            }
        };
        this.dCm = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.n.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bkz();
                    }
                }
            }
        };
        this.geQ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.n.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bkB();
                }
            }
        };
        this.geR = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.n.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xV()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String ya = activityPrizeData.ya();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(ya) && !ya.equals(string)) {
                            a.this.gex = true;
                            a.this.geI = true;
                            a.this.bkx();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bkt() {
        return C0184a.geT;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.geL);
        MessageManager.getInstance().registerListener(this.geM);
        MessageManager.getInstance().registerListener(this.geP);
        MessageManager.getInstance().registerListener(this.geQ);
        MessageManager.getInstance().registerListener(this.geO);
        MessageManager.getInstance().registerListener(this.dCm);
        MessageManager.getInstance().registerListener(this.geN);
        MessageManager.getInstance().registerListener(this.geR);
    }

    private void bku() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gev = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.geK = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bkv() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gev)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.geG = newsNotifyMessage.getMsgBookmark() > this.geB;
            this.geE = newsNotifyMessage.getMsgFans() > this.gez;
            this.geF = newsNotifyMessage.getMsgGiftNum() > this.geA;
            this.geB = newsNotifyMessage.getMsgBookmark();
            this.gez = newsNotifyMessage.getMsgFans();
            this.geA = newsNotifyMessage.getMsgGiftNum();
            if (this.geG || this.geE || this.geF || this.mHasNewVersion) {
                this.ger = this.geE ? true : this.ger;
                this.ges = this.geG ? true : this.ges;
                this.get = this.geF ? true : this.get;
                this.gev = this.mHasNewVersion ? true : this.gev;
                bkx();
            }
        }
    }

    public void bkw() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.geD);
    }

    public void lI(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkx() {
        SparseArray sparseArray = new SparseArray();
        if (this.geD) {
            sparseArray.append(4, new b.a(this.geu, this.geC));
        }
        if (this.geE) {
            sparseArray.append(2, new b.a(this.ger, this.gez));
        }
        if (this.geF) {
            sparseArray.append(1, new b.a(this.get, this.geA));
        }
        if (this.geG) {
            sparseArray.append(3, new b.a(this.ges, this.geB));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gev, 0));
        }
        if (this.geH) {
            sparseArray.append(7, new b.a(this.gew, 0));
        }
        if (this.geI) {
            sparseArray.append(9, new b.a(this.gex, 0));
        }
        if (this.geJ) {
            sparseArray.append(10, new b.a(this.gey, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bky();
    }

    public void lJ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.geu, this.geC));
            sparseArray.append(2, new b.a(this.ger, this.gez));
            sparseArray.append(1, new b.a(this.get, this.geA));
            sparseArray.append(3, new b.a(this.ges, this.geB));
            sparseArray.append(5, new b.a(this.gev, 0));
            sparseArray.append(7, new b.a(this.gew, 0));
            sparseArray.append(9, new b.a(this.gex, 0));
            sparseArray.append(10, new b.a(this.gey, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bky() {
        if (((this.gez > 0 && this.geE) || (this.geB > 0 && this.geG) || this.mHasNewVersion || this.geI || this.geJ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.geJ) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bkz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.get = z;
                    break;
                case 2:
                    this.ger = z;
                    break;
                case 3:
                    this.ges = z;
                    break;
                case 4:
                    this.geu = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gev = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gew = z;
                    break;
                case 9:
                    this.gex = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().ya());
                    break;
                case 10:
                    this.gey = z;
                    break;
            }
            lJ(true);
            bkA();
        }
    }

    private void bkA() {
        boolean z = this.get || this.ges || this.ger || this.geu || this.gev || this.gew || this.gex;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkB() {
        this.ger = false;
        this.ges = false;
        this.get = false;
        this.geu = false;
        this.gev = false;
        this.gew = false;
        this.gex = false;
        this.gez = 0;
        this.geA = 0;
        this.geB = 0;
        this.geC = 0;
        this.geD = false;
        this.mHasNewVersion = false;
        this.geE = false;
        this.geF = false;
        this.geG = false;
        this.geH = false;
        this.geI = false;
        bku();
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.n.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.geK) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bkv();
    }
}
