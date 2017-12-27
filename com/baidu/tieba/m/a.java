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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.m.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener ebK;
    private boolean gRA;
    private final CustomMessageListener gRB;
    CustomMessageListener gRC;
    private CustomMessageListener gRD;
    private CustomMessageListener gRE;
    private CustomMessageListener gRF;
    private CustomMessageListener gRG;
    private CustomMessageListener gRH;
    private boolean gRh;
    private boolean gRi;
    private boolean gRj;
    private boolean gRk;
    private boolean gRl;
    private boolean gRm;
    private boolean gRn;
    private boolean gRo;
    private int gRp;
    private int gRq;
    private int gRr;
    private int gRs;
    private boolean gRt;
    private boolean gRu;
    private boolean gRv;
    private boolean gRw;
    private boolean gRx;
    private boolean gRy;
    private boolean gRz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0133a {
        private static final a gRJ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gRh = false;
        this.gRi = false;
        this.gRj = false;
        this.gRk = false;
        this.gRl = false;
        this.gRm = false;
        this.gRn = false;
        this.gRo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gRp = 0;
        this.gRq = 0;
        this.gRr = 0;
        this.gRs = 0;
        this.gRt = false;
        this.mHasNewVersion = false;
        this.gRu = false;
        this.gRv = false;
        this.gRw = false;
        this.gRx = false;
        this.gRy = false;
        this.gRz = false;
        this.gRB = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gRC = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gRs >= responseUnreadPointNum.getNum()) {
                        a.this.gRs = responseUnreadPointNum.getNum();
                        a.this.gRt = false;
                    } else {
                        a.this.gRt = true;
                        a.this.gRk = a.this.gRt ? true : a.this.gRk;
                        a.this.gRs = responseUnreadPointNum.getNum();
                        a.this.buz();
                    }
                    a.this.buy();
                }
            }
        };
        this.gRD = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gRo = booleanValue;
                    a.this.gRz = booleanValue;
                    a.this.buz();
                }
            }
        };
        this.gRE = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.4
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
                    a.this.gRx = booleanValue;
                    a.this.gRm = booleanValue;
                    a.this.buz();
                }
            }
        };
        this.gRF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gRl = a.this.mHasNewVersion ? true : a.this.gRl;
                    a.this.buz();
                }
            }
        };
        this.ebK = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.buB();
                    }
                }
            }
        };
        this.gRG = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.buD();
                }
            }
        };
        this.gRH = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.EU()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String EZ = activityPrizeData.EZ();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(EZ) && !EZ.equals(string)) {
                            a.this.gRn = true;
                            a.this.gRy = true;
                            a.this.buz();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a buv() {
        return C0133a.gRJ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gRB);
        MessageManager.getInstance().registerListener(this.gRC);
        MessageManager.getInstance().registerListener(this.gRF);
        MessageManager.getInstance().registerListener(this.gRG);
        MessageManager.getInstance().registerListener(this.gRE);
        MessageManager.getInstance().registerListener(this.ebK);
        MessageManager.getInstance().registerListener(this.gRD);
        MessageManager.getInstance().registerListener(this.gRH);
    }

    private void buw() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gRl = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gRA = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bux() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gRl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gRw = newsNotifyMessage.getMsgBookmark() > this.gRr;
            this.gRu = newsNotifyMessage.getMsgFans() > this.gRp;
            this.gRv = newsNotifyMessage.getMsgGiftNum() > this.gRq;
            this.gRr = newsNotifyMessage.getMsgBookmark();
            this.gRp = newsNotifyMessage.getMsgFans();
            this.gRq = newsNotifyMessage.getMsgGiftNum();
            if (this.gRw || this.gRu || this.gRv || this.mHasNewVersion) {
                this.gRh = this.gRu ? true : this.gRh;
                this.gRi = this.gRw ? true : this.gRi;
                this.gRj = this.gRv ? true : this.gRj;
                this.gRl = this.mHasNewVersion ? true : this.gRl;
                buz();
            }
        }
    }

    public void buy() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gRt);
    }

    public void mQ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buz() {
        SparseArray sparseArray = new SparseArray();
        if (this.gRt) {
            sparseArray.append(4, new b.a(this.gRk, this.gRs));
        }
        if (this.gRu) {
            sparseArray.append(2, new b.a(this.gRh, this.gRp));
        }
        if (this.gRv) {
            sparseArray.append(1, new b.a(this.gRj, this.gRq));
        }
        if (this.gRw) {
            sparseArray.append(3, new b.a(this.gRi, this.gRr));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gRl, 0));
        }
        if (this.gRx) {
            sparseArray.append(7, new b.a(this.gRm, 0));
        }
        if (this.gRy) {
            sparseArray.append(9, new b.a(this.gRn, 0));
        }
        if (this.gRz) {
            sparseArray.append(10, new b.a(this.gRo, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        buA();
    }

    public void mR(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gRk, this.gRs));
            sparseArray.append(2, new b.a(this.gRh, this.gRp));
            sparseArray.append(1, new b.a(this.gRj, this.gRq));
            sparseArray.append(3, new b.a(this.gRi, this.gRr));
            sparseArray.append(5, new b.a(this.gRl, 0));
            sparseArray.append(7, new b.a(this.gRm, 0));
            sparseArray.append(9, new b.a(this.gRn, 0));
            sparseArray.append(10, new b.a(this.gRo, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void buA() {
        if (((this.gRp > 0 && this.gRu) || (this.gRr > 0 && this.gRw) || this.mHasNewVersion || this.gRy || this.gRz) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gRz) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void buB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gRj = z;
                    break;
                case 2:
                    this.gRh = z;
                    break;
                case 3:
                    this.gRi = z;
                    break;
                case 4:
                    this.gRk = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gRl = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gRm = z;
                    break;
                case 9:
                    this.gRn = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().EZ());
                    break;
                case 10:
                    this.gRo = z;
                    break;
            }
            mR(true);
            buC();
        }
    }

    private void buC() {
        boolean z = this.gRj || this.gRi || this.gRh || this.gRk || this.gRl || this.gRm || this.gRn;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void buD() {
        this.gRh = false;
        this.gRi = false;
        this.gRj = false;
        this.gRk = false;
        this.gRl = false;
        this.gRm = false;
        this.gRn = false;
        this.gRp = 0;
        this.gRq = 0;
        this.gRr = 0;
        this.gRs = 0;
        this.gRt = false;
        this.mHasNewVersion = false;
        this.gRu = false;
        this.gRv = false;
        this.gRw = false;
        this.gRx = false;
        this.gRy = false;
        buw();
        e.nr().post(new Runnable() { // from class: com.baidu.tieba.m.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gRA) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bux();
    }
}
