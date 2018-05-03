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
    private CustomMessageListener dCj;
    private boolean geA;
    private boolean geB;
    private boolean geC;
    private boolean geD;
    private boolean geE;
    private boolean geF;
    private boolean geG;
    private boolean geH;
    private final CustomMessageListener geI;
    CustomMessageListener geJ;
    private CustomMessageListener geK;
    private CustomMessageListener geL;
    private CustomMessageListener geM;
    private CustomMessageListener geN;
    private CustomMessageListener geO;
    private boolean gen;
    private boolean gep;
    private boolean geq;
    private boolean ger;
    private boolean ges;
    private boolean get;
    private boolean geu;
    private boolean gev;
    private int gew;
    private int gex;
    private int gey;
    private int gez;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0184a {
        private static final a geQ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gen = false;
        this.gep = false;
        this.geq = false;
        this.ger = false;
        this.ges = false;
        this.get = false;
        this.geu = false;
        this.gev = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gew = 0;
        this.gex = 0;
        this.gey = 0;
        this.gez = 0;
        this.geA = false;
        this.mHasNewVersion = false;
        this.geB = false;
        this.geC = false;
        this.geD = false;
        this.geE = false;
        this.geF = false;
        this.geG = false;
        this.geI = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.n.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.geJ = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.n.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gez >= responseUnreadPointNum.getNum()) {
                        a.this.gez = responseUnreadPointNum.getNum();
                        a.this.geA = false;
                    } else {
                        a.this.geA = true;
                        a.this.ger = a.this.geA ? true : a.this.ger;
                        a.this.gez = responseUnreadPointNum.getNum();
                        a.this.bkx();
                    }
                    a.this.bkw();
                }
            }
        };
        this.geK = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.n.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gev = booleanValue;
                    a.this.geG = booleanValue;
                    a.this.bkx();
                }
            }
        };
        this.geL = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.n.a.4
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
                    a.this.geE = booleanValue;
                    a.this.get = booleanValue;
                    a.this.bkx();
                }
            }
        };
        this.geM = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.n.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ges = a.this.mHasNewVersion ? true : a.this.ges;
                    a.this.bkx();
                }
            }
        };
        this.dCj = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.n.a.6
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
        this.geN = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.n.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bkB();
                }
            }
        };
        this.geO = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.n.a.8
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
                            a.this.geu = true;
                            a.this.geF = true;
                            a.this.bkx();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bkt() {
        return C0184a.geQ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.geI);
        MessageManager.getInstance().registerListener(this.geJ);
        MessageManager.getInstance().registerListener(this.geM);
        MessageManager.getInstance().registerListener(this.geN);
        MessageManager.getInstance().registerListener(this.geL);
        MessageManager.getInstance().registerListener(this.dCj);
        MessageManager.getInstance().registerListener(this.geK);
        MessageManager.getInstance().registerListener(this.geO);
    }

    private void bku() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ges = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.geH = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bkv() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.ges)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.geD = newsNotifyMessage.getMsgBookmark() > this.gey;
            this.geB = newsNotifyMessage.getMsgFans() > this.gew;
            this.geC = newsNotifyMessage.getMsgGiftNum() > this.gex;
            this.gey = newsNotifyMessage.getMsgBookmark();
            this.gew = newsNotifyMessage.getMsgFans();
            this.gex = newsNotifyMessage.getMsgGiftNum();
            if (this.geD || this.geB || this.geC || this.mHasNewVersion) {
                this.gen = this.geB ? true : this.gen;
                this.gep = this.geD ? true : this.gep;
                this.geq = this.geC ? true : this.geq;
                this.ges = this.mHasNewVersion ? true : this.ges;
                bkx();
            }
        }
    }

    public void bkw() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.geA);
    }

    public void lI(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkx() {
        SparseArray sparseArray = new SparseArray();
        if (this.geA) {
            sparseArray.append(4, new b.a(this.ger, this.gez));
        }
        if (this.geB) {
            sparseArray.append(2, new b.a(this.gen, this.gew));
        }
        if (this.geC) {
            sparseArray.append(1, new b.a(this.geq, this.gex));
        }
        if (this.geD) {
            sparseArray.append(3, new b.a(this.gep, this.gey));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ges, 0));
        }
        if (this.geE) {
            sparseArray.append(7, new b.a(this.get, 0));
        }
        if (this.geF) {
            sparseArray.append(9, new b.a(this.geu, 0));
        }
        if (this.geG) {
            sparseArray.append(10, new b.a(this.gev, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bky();
    }

    public void lJ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ger, this.gez));
            sparseArray.append(2, new b.a(this.gen, this.gew));
            sparseArray.append(1, new b.a(this.geq, this.gex));
            sparseArray.append(3, new b.a(this.gep, this.gey));
            sparseArray.append(5, new b.a(this.ges, 0));
            sparseArray.append(7, new b.a(this.get, 0));
            sparseArray.append(9, new b.a(this.geu, 0));
            sparseArray.append(10, new b.a(this.gev, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bky() {
        if (((this.gew > 0 && this.geB) || (this.gey > 0 && this.geD) || this.mHasNewVersion || this.geF || this.geG) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.geG) {
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
                    this.geq = z;
                    break;
                case 2:
                    this.gen = z;
                    break;
                case 3:
                    this.gep = z;
                    break;
                case 4:
                    this.ger = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.ges = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.get = z;
                    break;
                case 9:
                    this.geu = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().ya());
                    break;
                case 10:
                    this.gev = z;
                    break;
            }
            lJ(true);
            bkA();
        }
    }

    private void bkA() {
        boolean z = this.geq || this.gep || this.gen || this.ger || this.ges || this.get || this.geu;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkB() {
        this.gen = false;
        this.gep = false;
        this.geq = false;
        this.ger = false;
        this.ges = false;
        this.get = false;
        this.geu = false;
        this.gew = 0;
        this.gex = 0;
        this.gey = 0;
        this.gez = 0;
        this.geA = false;
        this.mHasNewVersion = false;
        this.geB = false;
        this.geC = false;
        this.geD = false;
        this.geE = false;
        this.geF = false;
        bku();
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.n.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.geH) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bkv();
    }
}
