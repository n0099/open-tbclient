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
    private CustomMessageListener ecQ;
    private boolean gDA;
    private boolean gDB;
    private boolean gDC;
    private boolean gDD;
    private boolean gDE;
    private boolean gDF;
    private final CustomMessageListener gDG;
    CustomMessageListener gDH;
    private CustomMessageListener gDI;
    private CustomMessageListener gDJ;
    private CustomMessageListener gDK;
    private CustomMessageListener gDL;
    private CustomMessageListener gDM;
    private boolean gDm;
    private boolean gDn;
    private boolean gDo;
    private boolean gDp;
    private boolean gDq;
    private boolean gDr;
    private boolean gDs;
    private boolean gDt;
    private int gDu;
    private int gDv;
    private int gDw;
    private int gDx;
    private boolean gDy;
    private boolean gDz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0203a {
        private static final a gDO = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gDm = false;
        this.gDn = false;
        this.gDo = false;
        this.gDp = false;
        this.gDq = false;
        this.gDr = false;
        this.gDs = false;
        this.gDt = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gDu = 0;
        this.gDv = 0;
        this.gDw = 0;
        this.gDx = 0;
        this.gDy = false;
        this.mHasNewVersion = false;
        this.gDz = false;
        this.gDA = false;
        this.gDB = false;
        this.gDC = false;
        this.gDD = false;
        this.gDE = false;
        this.gDG = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gDH = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gDx >= responseUnreadPointNum.getNum()) {
                        a.this.gDx = responseUnreadPointNum.getNum();
                        a.this.gDy = false;
                    } else {
                        a.this.gDy = true;
                        a.this.gDp = a.this.gDy ? true : a.this.gDp;
                        a.this.gDx = responseUnreadPointNum.getNum();
                        a.this.brj();
                    }
                    a.this.bri();
                }
            }
        };
        this.gDI = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gDt = booleanValue;
                    a.this.gDE = booleanValue;
                    a.this.brj();
                }
            }
        };
        this.gDJ = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gDC = booleanValue;
                    a.this.gDr = booleanValue;
                    a.this.brj();
                }
            }
        };
        this.gDK = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gDq = a.this.mHasNewVersion ? true : a.this.gDq;
                    a.this.brj();
                }
            }
        };
        this.ecQ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.brl();
                    }
                }
            }
        };
        this.gDL = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.brn();
                }
            }
        };
        this.gDM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.CO()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String CT = activityPrizeData.CT();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(CT) && !CT.equals(string)) {
                            a.this.gDs = true;
                            a.this.gDD = true;
                            a.this.brj();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a brf() {
        return C0203a.gDO;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gDG);
        MessageManager.getInstance().registerListener(this.gDH);
        MessageManager.getInstance().registerListener(this.gDK);
        MessageManager.getInstance().registerListener(this.gDL);
        MessageManager.getInstance().registerListener(this.gDJ);
        MessageManager.getInstance().registerListener(this.ecQ);
        MessageManager.getInstance().registerListener(this.gDI);
        MessageManager.getInstance().registerListener(this.gDM);
    }

    private void brg() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gDq = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gDF = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void brh() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gDq)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gDB = newsNotifyMessage.getMsgBookmark() > this.gDw;
            this.gDz = newsNotifyMessage.getMsgFans() > this.gDu;
            this.gDA = newsNotifyMessage.getMsgGiftNum() > this.gDv;
            this.gDw = newsNotifyMessage.getMsgBookmark();
            this.gDu = newsNotifyMessage.getMsgFans();
            this.gDv = newsNotifyMessage.getMsgGiftNum();
            if (this.gDB || this.gDz || this.gDA || this.mHasNewVersion) {
                this.gDm = this.gDz ? true : this.gDm;
                this.gDn = this.gDB ? true : this.gDn;
                this.gDo = this.gDA ? true : this.gDo;
                this.gDq = this.mHasNewVersion ? true : this.gDq;
                brj();
            }
        }
    }

    public void bri() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gDy);
    }

    public void mj(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brj() {
        SparseArray sparseArray = new SparseArray();
        if (this.gDy) {
            sparseArray.append(4, new b.a(this.gDp, this.gDx));
        }
        if (this.gDz) {
            sparseArray.append(2, new b.a(this.gDm, this.gDu));
        }
        if (this.gDA) {
            sparseArray.append(1, new b.a(this.gDo, this.gDv));
        }
        if (this.gDB) {
            sparseArray.append(3, new b.a(this.gDn, this.gDw));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gDq, 0));
        }
        if (this.gDC) {
            sparseArray.append(7, new b.a(this.gDr, 0));
        }
        if (this.gDD) {
            sparseArray.append(9, new b.a(this.gDs, 0));
        }
        if (this.gDE) {
            sparseArray.append(10, new b.a(this.gDt, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        brk();
    }

    public void mk(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gDp, this.gDx));
            sparseArray.append(2, new b.a(this.gDm, this.gDu));
            sparseArray.append(1, new b.a(this.gDo, this.gDv));
            sparseArray.append(3, new b.a(this.gDn, this.gDw));
            sparseArray.append(5, new b.a(this.gDq, 0));
            sparseArray.append(7, new b.a(this.gDr, 0));
            sparseArray.append(9, new b.a(this.gDs, 0));
            sparseArray.append(10, new b.a(this.gDt, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void brk() {
        if (((this.gDu > 0 && this.gDz) || (this.gDw > 0 && this.gDB) || this.mHasNewVersion || this.gDD || this.gDE) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gDE) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void brl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gDo = z;
                    break;
                case 2:
                    this.gDm = z;
                    break;
                case 3:
                    this.gDn = z;
                    break;
                case 4:
                    this.gDp = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gDq = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gDr = z;
                    break;
                case 9:
                    this.gDs = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().CT());
                    break;
                case 10:
                    this.gDt = z;
                    break;
            }
            mk(true);
            brm();
        }
    }

    private void brm() {
        boolean z = this.gDo || this.gDn || this.gDm || this.gDp || this.gDq || this.gDr || this.gDs;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void brn() {
        this.gDm = false;
        this.gDn = false;
        this.gDo = false;
        this.gDp = false;
        this.gDq = false;
        this.gDr = false;
        this.gDs = false;
        this.gDu = 0;
        this.gDv = 0;
        this.gDw = 0;
        this.gDx = 0;
        this.gDy = false;
        this.mHasNewVersion = false;
        this.gDz = false;
        this.gDA = false;
        this.gDB = false;
        this.gDC = false;
        this.gDD = false;
        brg();
        e.jt().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gDF) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        brh();
    }
}
