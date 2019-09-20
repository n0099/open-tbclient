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
    private CustomMessageListener ghq;
    private boolean gpS;
    private boolean iRA;
    private final CustomMessageListener iRB;
    CustomMessageListener iRC;
    private CustomMessageListener iRD;
    private CustomMessageListener iRE;
    private CustomMessageListener iRF;
    private CustomMessageListener iRG;
    private CustomMessageListener iRH;
    private boolean iRi;
    private boolean iRj;
    private boolean iRk;
    private boolean iRl;
    private boolean iRm;
    private boolean iRn;
    private boolean iRo;
    private boolean iRp;
    private int iRq;
    private int iRr;
    private int iRs;
    private int iRt;
    private boolean iRu;
    private boolean iRv;
    private boolean iRw;
    private boolean iRx;
    private boolean iRy;
    private boolean iRz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0378a {
        private static final a iRJ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iRi = false;
        this.iRj = false;
        this.iRk = false;
        this.iRl = false;
        this.iRm = false;
        this.iRn = false;
        this.iRo = false;
        this.iRp = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_feedback_tip_show", false);
        this.iRq = 0;
        this.iRr = 0;
        this.iRs = 0;
        this.iRt = 0;
        this.iRu = false;
        this.mHasNewVersion = false;
        this.iRv = false;
        this.iRw = false;
        this.iRx = false;
        this.iRy = false;
        this.iRz = false;
        this.iRA = false;
        this.iRB = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iRC = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iRt >= responseUnreadPointNum.getNum()) {
                        a.this.iRt = responseUnreadPointNum.getNum();
                        a.this.iRu = false;
                    } else {
                        a.this.iRu = true;
                        a.this.iRl = a.this.iRu ? true : a.this.iRl;
                        a.this.iRt = responseUnreadPointNum.getNum();
                        a.this.cjZ();
                    }
                    a.this.cjY();
                }
            }
        };
        this.iRD = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iRp = booleanValue;
                    a.this.iRA = booleanValue;
                    a.this.cjZ();
                }
            }
        };
        this.iRE = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.ahU().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iRy = booleanValue;
                    a.this.iRn = booleanValue;
                    a.this.cjZ();
                }
            }
        };
        this.iRF = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iRm = a.this.mHasNewVersion ? true : a.this.iRm;
                    a.this.cjZ();
                }
            }
        };
        this.ghq = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.ckb();
                    }
                }
            }
        };
        this.iRG = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.ckd();
                }
            }
        };
        this.iRH = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.ame()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String amj = activityPrizeData.amj();
                        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(amj) && !amj.equals(string)) {
                            a.this.iRo = true;
                            a.this.iRz = true;
                            a.this.cjZ();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cjV() {
        return C0378a.iRJ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iRB);
        MessageManager.getInstance().registerListener(this.iRC);
        MessageManager.getInstance().registerListener(this.iRF);
        MessageManager.getInstance().registerListener(this.iRG);
        MessageManager.getInstance().registerListener(this.iRE);
        MessageManager.getInstance().registerListener(this.ghq);
        MessageManager.getInstance().registerListener(this.iRD);
        MessageManager.getInstance().registerListener(this.iRH);
    }

    private void cjW() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iRm = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gpS = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cjX() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iRm)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iRx = newsNotifyMessage.getMsgBookmark() > this.iRs;
            this.iRv = newsNotifyMessage.getMsgFans() > this.iRq;
            this.iRw = newsNotifyMessage.getMsgGiftNum() > this.iRr;
            this.iRs = newsNotifyMessage.getMsgBookmark();
            this.iRq = newsNotifyMessage.getMsgFans();
            this.iRr = newsNotifyMessage.getMsgGiftNum();
            if (this.iRx || this.iRv || this.iRw || this.mHasNewVersion) {
                this.iRi = this.iRv ? true : this.iRi;
                this.iRj = this.iRx ? true : this.iRj;
                this.iRk = this.iRw ? true : this.iRk;
                this.iRm = this.mHasNewVersion ? true : this.iRm;
                cjZ();
            }
        }
    }

    public void cjY() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iRu);
    }

    public void qB(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        SparseArray sparseArray = new SparseArray();
        if (this.iRu) {
            sparseArray.append(4, new b.a(this.iRl, this.iRt));
        }
        if (this.iRv) {
            sparseArray.append(2, new b.a(this.iRi, this.iRq));
        }
        if (this.iRw) {
            sparseArray.append(1, new b.a(this.iRk, this.iRr));
        }
        if (this.iRx) {
            sparseArray.append(3, new b.a(this.iRj, this.iRs));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iRm, 0));
        }
        if (this.iRy) {
            sparseArray.append(7, new b.a(this.iRn, 0));
        }
        if (this.iRz) {
            sparseArray.append(9, new b.a(this.iRo, 0));
        }
        if (this.iRA) {
            sparseArray.append(10, new b.a(this.iRp, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        cka();
    }

    public void qC(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iRl, this.iRt));
            sparseArray.append(2, new b.a(this.iRi, this.iRq));
            sparseArray.append(1, new b.a(this.iRk, this.iRr));
            sparseArray.append(3, new b.a(this.iRj, this.iRs));
            sparseArray.append(5, new b.a(this.iRm, 0));
            sparseArray.append(7, new b.a(this.iRn, 0));
            sparseArray.append(9, new b.a(this.iRo, 0));
            sparseArray.append(10, new b.a(this.iRp, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void cka() {
        if (((this.iRq > 0 && this.iRv) || (this.iRs > 0 && this.iRx) || this.mHasNewVersion || this.iRz || this.iRA) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iRA) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void ckb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void e(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iRk = z;
                    break;
                case 2:
                    this.iRi = z;
                    break;
                case 3:
                    this.iRj = z;
                    break;
                case 4:
                    this.iRl = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iRm = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahU().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iRn = z;
                    break;
                case 9:
                    this.iRo = z;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().amj());
                    break;
                case 10:
                    this.iRp = z;
                    break;
            }
            qC(true);
            ckc();
        }
    }

    private void ckc() {
        boolean z = this.iRk || this.iRj || this.iRi || this.iRl || this.iRm || this.iRn || this.iRo;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void ckd() {
        this.iRi = false;
        this.iRj = false;
        this.iRk = false;
        this.iRl = false;
        this.iRm = false;
        this.iRn = false;
        this.iRo = false;
        this.iRq = 0;
        this.iRr = 0;
        this.iRs = 0;
        this.iRt = 0;
        this.iRu = false;
        this.mHasNewVersion = false;
        this.iRv = false;
        this.iRw = false;
        this.iRx = false;
        this.iRy = false;
        this.iRz = false;
        cjW();
        e.iK().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gpS) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cjX();
    }
}
