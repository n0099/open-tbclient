package com.baidu.tieba.m;

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
import com.baidu.tieba.m.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener ehG;
    private int gJA;
    private int gJB;
    private int gJC;
    private boolean gJD;
    private boolean gJE;
    private boolean gJF;
    private boolean gJG;
    private boolean gJH;
    private boolean gJI;
    private boolean gJJ;
    private boolean gJK;
    private final CustomMessageListener gJL;
    CustomMessageListener gJM;
    private CustomMessageListener gJN;
    private CustomMessageListener gJO;
    private CustomMessageListener gJP;
    private CustomMessageListener gJQ;
    private CustomMessageListener gJR;
    private boolean gJr;
    private boolean gJs;
    private boolean gJt;
    private boolean gJu;
    private boolean gJv;
    private boolean gJw;
    private boolean gJx;
    private boolean gJy;
    private int gJz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0196a {
        private static final a gJT = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gJr = false;
        this.gJs = false;
        this.gJt = false;
        this.gJu = false;
        this.gJv = false;
        this.gJw = false;
        this.gJx = false;
        this.gJy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gJz = 0;
        this.gJA = 0;
        this.gJB = 0;
        this.gJC = 0;
        this.gJD = false;
        this.mHasNewVersion = false;
        this.gJE = false;
        this.gJF = false;
        this.gJG = false;
        this.gJH = false;
        this.gJI = false;
        this.gJJ = false;
        this.gJL = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gJM = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gJC >= responseUnreadPointNum.getNum()) {
                        a.this.gJC = responseUnreadPointNum.getNum();
                        a.this.gJD = false;
                    } else {
                        a.this.gJD = true;
                        a.this.gJu = a.this.gJD ? true : a.this.gJu;
                        a.this.gJC = responseUnreadPointNum.getNum();
                        a.this.bpq();
                    }
                    a.this.bpp();
                }
            }
        };
        this.gJN = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gJy = booleanValue;
                    a.this.gJJ = booleanValue;
                    a.this.bpq();
                }
            }
        };
        this.gJO = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.m.a.4
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
                    a.this.gJH = booleanValue;
                    a.this.gJw = booleanValue;
                    a.this.bpq();
                }
            }
        };
        this.gJP = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gJv = a.this.mHasNewVersion ? true : a.this.gJv;
                    a.this.bpq();
                }
            }
        };
        this.ehG = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bps();
                    }
                }
            }
        };
        this.gJQ = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bpu();
                }
            }
        };
        this.gJR = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.m.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Fi()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Fn = activityPrizeData.Fn();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Fn) && !Fn.equals(string)) {
                            a.this.gJx = true;
                            a.this.gJI = true;
                            a.this.bpq();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bpm() {
        return C0196a.gJT;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gJL);
        MessageManager.getInstance().registerListener(this.gJM);
        MessageManager.getInstance().registerListener(this.gJP);
        MessageManager.getInstance().registerListener(this.gJQ);
        MessageManager.getInstance().registerListener(this.gJO);
        MessageManager.getInstance().registerListener(this.ehG);
        MessageManager.getInstance().registerListener(this.gJN);
        MessageManager.getInstance().registerListener(this.gJR);
    }

    private void bpn() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gJv = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gJK = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bpo() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gJv)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gJG = newsNotifyMessage.getMsgBookmark() > this.gJB;
            this.gJE = newsNotifyMessage.getMsgFans() > this.gJz;
            this.gJF = newsNotifyMessage.getMsgGiftNum() > this.gJA;
            this.gJB = newsNotifyMessage.getMsgBookmark();
            this.gJz = newsNotifyMessage.getMsgFans();
            this.gJA = newsNotifyMessage.getMsgGiftNum();
            if (this.gJG || this.gJE || this.gJF || this.mHasNewVersion) {
                this.gJr = this.gJE ? true : this.gJr;
                this.gJs = this.gJG ? true : this.gJs;
                this.gJt = this.gJF ? true : this.gJt;
                this.gJv = this.mHasNewVersion ? true : this.gJv;
                bpq();
            }
        }
    }

    public void bpp() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gJD);
    }

    public void mh(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpq() {
        SparseArray sparseArray = new SparseArray();
        if (this.gJD) {
            sparseArray.append(4, new b.a(this.gJu, this.gJC));
        }
        if (this.gJE) {
            sparseArray.append(2, new b.a(this.gJr, this.gJz));
        }
        if (this.gJF) {
            sparseArray.append(1, new b.a(this.gJt, this.gJA));
        }
        if (this.gJG) {
            sparseArray.append(3, new b.a(this.gJs, this.gJB));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gJv, 0));
        }
        if (this.gJH) {
            sparseArray.append(7, new b.a(this.gJw, 0));
        }
        if (this.gJI) {
            sparseArray.append(9, new b.a(this.gJx, 0));
        }
        if (this.gJJ) {
            sparseArray.append(10, new b.a(this.gJy, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bpr();
    }

    public void mi(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gJu, this.gJC));
            sparseArray.append(2, new b.a(this.gJr, this.gJz));
            sparseArray.append(1, new b.a(this.gJt, this.gJA));
            sparseArray.append(3, new b.a(this.gJs, this.gJB));
            sparseArray.append(5, new b.a(this.gJv, 0));
            sparseArray.append(7, new b.a(this.gJw, 0));
            sparseArray.append(9, new b.a(this.gJx, 0));
            sparseArray.append(10, new b.a(this.gJy, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bpr() {
        if (((this.gJz > 0 && this.gJE) || (this.gJB > 0 && this.gJG) || this.mHasNewVersion || this.gJI || this.gJJ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gJJ) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bps() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gJt = z;
                    break;
                case 2:
                    this.gJr = z;
                    break;
                case 3:
                    this.gJs = z;
                    break;
                case 4:
                    this.gJu = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gJv = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gJw = z;
                    break;
                case 9:
                    this.gJx = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Fn());
                    break;
                case 10:
                    this.gJy = z;
                    break;
            }
            mi(true);
            bpt();
        }
    }

    private void bpt() {
        boolean z = this.gJt || this.gJs || this.gJr || this.gJu || this.gJv || this.gJw || this.gJx;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bpu() {
        this.gJr = false;
        this.gJs = false;
        this.gJt = false;
        this.gJu = false;
        this.gJv = false;
        this.gJw = false;
        this.gJx = false;
        this.gJz = 0;
        this.gJA = 0;
        this.gJB = 0;
        this.gJC = 0;
        this.gJD = false;
        this.mHasNewVersion = false;
        this.gJE = false;
        this.gJF = false;
        this.gJG = false;
        this.gJH = false;
        this.gJI = false;
        bpn();
        e.ns().post(new Runnable() { // from class: com.baidu.tieba.m.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gJK) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bpo();
    }
}
