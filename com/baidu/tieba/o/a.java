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
    private CustomMessageListener ewz;
    private CustomMessageListener gXA;
    private CustomMessageListener gXB;
    private boolean gXb;
    private boolean gXc;
    private boolean gXd;
    private boolean gXe;
    private boolean gXf;
    private boolean gXg;
    private boolean gXh;
    private boolean gXi;
    private int gXj;
    private int gXk;
    private int gXl;
    private int gXm;
    private boolean gXn;
    private boolean gXo;
    private boolean gXp;
    private boolean gXq;
    private boolean gXr;
    private boolean gXs;
    private boolean gXt;
    private boolean gXu;
    private final CustomMessageListener gXv;
    CustomMessageListener gXw;
    private CustomMessageListener gXx;
    private CustomMessageListener gXy;
    private CustomMessageListener gXz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0274a {
        private static final a gXD = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gXb = false;
        this.gXc = false;
        this.gXd = false;
        this.gXe = false;
        this.gXf = false;
        this.gXg = false;
        this.gXh = false;
        this.gXi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gXj = 0;
        this.gXk = 0;
        this.gXl = 0;
        this.gXm = 0;
        this.gXn = false;
        this.mHasNewVersion = false;
        this.gXo = false;
        this.gXp = false;
        this.gXq = false;
        this.gXr = false;
        this.gXs = false;
        this.gXt = false;
        this.gXv = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gXw = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gXm >= responseUnreadPointNum.getNum()) {
                        a.this.gXm = responseUnreadPointNum.getNum();
                        a.this.gXn = false;
                    } else {
                        a.this.gXn = true;
                        a.this.gXe = a.this.gXn ? true : a.this.gXe;
                        a.this.gXm = responseUnreadPointNum.getNum();
                        a.this.bxj();
                    }
                    a.this.bxi();
                }
            }
        };
        this.gXx = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gXi = booleanValue;
                    a.this.gXt = booleanValue;
                    a.this.bxj();
                }
            }
        };
        this.gXy = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gXr = booleanValue;
                    a.this.gXg = booleanValue;
                    a.this.bxj();
                }
            }
        };
        this.gXz = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gXf = a.this.mHasNewVersion ? true : a.this.gXf;
                    a.this.bxj();
                }
            }
        };
        this.ewz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bxl();
                    }
                }
            }
        };
        this.gXA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bxn();
                }
            }
        };
        this.gXB = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Gv()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String GA = activityPrizeData.GA();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(GA) && !GA.equals(string)) {
                            a.this.gXh = true;
                            a.this.gXs = true;
                            a.this.bxj();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bxf() {
        return C0274a.gXD;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gXv);
        MessageManager.getInstance().registerListener(this.gXw);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.gXA);
        MessageManager.getInstance().registerListener(this.gXy);
        MessageManager.getInstance().registerListener(this.ewz);
        MessageManager.getInstance().registerListener(this.gXx);
        MessageManager.getInstance().registerListener(this.gXB);
    }

    private void bxg() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gXf = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gXu = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bxh() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gXf)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gXq = newsNotifyMessage.getMsgBookmark() > this.gXl;
            this.gXo = newsNotifyMessage.getMsgFans() > this.gXj;
            this.gXp = newsNotifyMessage.getMsgGiftNum() > this.gXk;
            this.gXl = newsNotifyMessage.getMsgBookmark();
            this.gXj = newsNotifyMessage.getMsgFans();
            this.gXk = newsNotifyMessage.getMsgGiftNum();
            if (this.gXq || this.gXo || this.gXp || this.mHasNewVersion) {
                this.gXb = this.gXo ? true : this.gXb;
                this.gXc = this.gXq ? true : this.gXc;
                this.gXd = this.gXp ? true : this.gXd;
                this.gXf = this.mHasNewVersion ? true : this.gXf;
                bxj();
            }
        }
    }

    public void bxi() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gXn);
    }

    public void mT(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxj() {
        SparseArray sparseArray = new SparseArray();
        if (this.gXn) {
            sparseArray.append(4, new b.a(this.gXe, this.gXm));
        }
        if (this.gXo) {
            sparseArray.append(2, new b.a(this.gXb, this.gXj));
        }
        if (this.gXp) {
            sparseArray.append(1, new b.a(this.gXd, this.gXk));
        }
        if (this.gXq) {
            sparseArray.append(3, new b.a(this.gXc, this.gXl));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gXf, 0));
        }
        if (this.gXr) {
            sparseArray.append(7, new b.a(this.gXg, 0));
        }
        if (this.gXs) {
            sparseArray.append(9, new b.a(this.gXh, 0));
        }
        if (this.gXt) {
            sparseArray.append(10, new b.a(this.gXi, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bxk();
    }

    public void mU(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gXe, this.gXm));
            sparseArray.append(2, new b.a(this.gXb, this.gXj));
            sparseArray.append(1, new b.a(this.gXd, this.gXk));
            sparseArray.append(3, new b.a(this.gXc, this.gXl));
            sparseArray.append(5, new b.a(this.gXf, 0));
            sparseArray.append(7, new b.a(this.gXg, 0));
            sparseArray.append(9, new b.a(this.gXh, 0));
            sparseArray.append(10, new b.a(this.gXi, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bxk() {
        if (((this.gXj > 0 && this.gXo) || (this.gXl > 0 && this.gXq) || this.mHasNewVersion || this.gXs || this.gXt) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gXt) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bxl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gXd = z;
                    break;
                case 2:
                    this.gXb = z;
                    break;
                case 3:
                    this.gXc = z;
                    break;
                case 4:
                    this.gXe = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gXf = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gXg = z;
                    break;
                case 9:
                    this.gXh = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().GA());
                    break;
                case 10:
                    this.gXi = z;
                    break;
            }
            mU(true);
            bxm();
        }
    }

    private void bxm() {
        boolean z = this.gXd || this.gXc || this.gXb || this.gXe || this.gXf || this.gXg || this.gXh;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bxn() {
        this.gXb = false;
        this.gXc = false;
        this.gXd = false;
        this.gXe = false;
        this.gXf = false;
        this.gXg = false;
        this.gXh = false;
        this.gXj = 0;
        this.gXk = 0;
        this.gXl = 0;
        this.gXm = 0;
        this.gXn = false;
        this.mHasNewVersion = false;
        this.gXo = false;
        this.gXp = false;
        this.gXq = false;
        this.gXr = false;
        this.gXs = false;
        bxg();
        e.jG().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gXu) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bxh();
    }
}
