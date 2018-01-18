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
    private CustomMessageListener ecV;
    private int gGA;
    private int gGB;
    private boolean gGC;
    private boolean gGD;
    private boolean gGE;
    private boolean gGF;
    private boolean gGG;
    private boolean gGH;
    private boolean gGI;
    private boolean gGJ;
    private final CustomMessageListener gGK;
    CustomMessageListener gGL;
    private CustomMessageListener gGM;
    private CustomMessageListener gGN;
    private CustomMessageListener gGO;
    private CustomMessageListener gGP;
    private CustomMessageListener gGQ;
    private boolean gGq;
    private boolean gGr;
    private boolean gGs;
    private boolean gGt;
    private boolean gGu;
    private boolean gGv;
    private boolean gGw;
    private boolean gGx;
    private int gGy;
    private int gGz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0132a {
        private static final a gGS = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gGq = false;
        this.gGr = false;
        this.gGs = false;
        this.gGt = false;
        this.gGu = false;
        this.gGv = false;
        this.gGw = false;
        this.gGx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gGy = 0;
        this.gGz = 0;
        this.gGA = 0;
        this.gGB = 0;
        this.gGC = false;
        this.mHasNewVersion = false;
        this.gGD = false;
        this.gGE = false;
        this.gGF = false;
        this.gGG = false;
        this.gGH = false;
        this.gGI = false;
        this.gGK = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gGL = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gGB >= responseUnreadPointNum.getNum()) {
                        a.this.gGB = responseUnreadPointNum.getNum();
                        a.this.gGC = false;
                    } else {
                        a.this.gGC = true;
                        a.this.gGt = a.this.gGC ? true : a.this.gGt;
                        a.this.gGB = responseUnreadPointNum.getNum();
                        a.this.bnS();
                    }
                    a.this.bnR();
                }
            }
        };
        this.gGM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gGx = booleanValue;
                    a.this.gGI = booleanValue;
                    a.this.bnS();
                }
            }
        };
        this.gGN = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.4
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
                    a.this.gGG = booleanValue;
                    a.this.gGv = booleanValue;
                    a.this.bnS();
                }
            }
        };
        this.gGO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gGu = a.this.mHasNewVersion ? true : a.this.gGu;
                    a.this.bnS();
                }
            }
        };
        this.ecV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bnU();
                    }
                }
            }
        };
        this.gGP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bnW();
                }
            }
        };
        this.gGQ = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.EL()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String EQ = activityPrizeData.EQ();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(EQ) && !EQ.equals(string)) {
                            a.this.gGw = true;
                            a.this.gGH = true;
                            a.this.bnS();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bnO() {
        return C0132a.gGS;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gGK);
        MessageManager.getInstance().registerListener(this.gGL);
        MessageManager.getInstance().registerListener(this.gGO);
        MessageManager.getInstance().registerListener(this.gGP);
        MessageManager.getInstance().registerListener(this.gGN);
        MessageManager.getInstance().registerListener(this.ecV);
        MessageManager.getInstance().registerListener(this.gGM);
        MessageManager.getInstance().registerListener(this.gGQ);
    }

    private void bnP() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gGu = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gGJ = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bnQ() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gGu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gGF = newsNotifyMessage.getMsgBookmark() > this.gGA;
            this.gGD = newsNotifyMessage.getMsgFans() > this.gGy;
            this.gGE = newsNotifyMessage.getMsgGiftNum() > this.gGz;
            this.gGA = newsNotifyMessage.getMsgBookmark();
            this.gGy = newsNotifyMessage.getMsgFans();
            this.gGz = newsNotifyMessage.getMsgGiftNum();
            if (this.gGF || this.gGD || this.gGE || this.mHasNewVersion) {
                this.gGq = this.gGD ? true : this.gGq;
                this.gGr = this.gGF ? true : this.gGr;
                this.gGs = this.gGE ? true : this.gGs;
                this.gGu = this.mHasNewVersion ? true : this.gGu;
                bnS();
            }
        }
    }

    public void bnR() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gGC);
    }

    public void lS(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnS() {
        SparseArray sparseArray = new SparseArray();
        if (this.gGC) {
            sparseArray.append(4, new b.a(this.gGt, this.gGB));
        }
        if (this.gGD) {
            sparseArray.append(2, new b.a(this.gGq, this.gGy));
        }
        if (this.gGE) {
            sparseArray.append(1, new b.a(this.gGs, this.gGz));
        }
        if (this.gGF) {
            sparseArray.append(3, new b.a(this.gGr, this.gGA));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gGu, 0));
        }
        if (this.gGG) {
            sparseArray.append(7, new b.a(this.gGv, 0));
        }
        if (this.gGH) {
            sparseArray.append(9, new b.a(this.gGw, 0));
        }
        if (this.gGI) {
            sparseArray.append(10, new b.a(this.gGx, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bnT();
    }

    public void lT(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gGt, this.gGB));
            sparseArray.append(2, new b.a(this.gGq, this.gGy));
            sparseArray.append(1, new b.a(this.gGs, this.gGz));
            sparseArray.append(3, new b.a(this.gGr, this.gGA));
            sparseArray.append(5, new b.a(this.gGu, 0));
            sparseArray.append(7, new b.a(this.gGv, 0));
            sparseArray.append(9, new b.a(this.gGw, 0));
            sparseArray.append(10, new b.a(this.gGx, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bnT() {
        if (((this.gGy > 0 && this.gGD) || (this.gGA > 0 && this.gGF) || this.mHasNewVersion || this.gGH || this.gGI) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gGI) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bnU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gGs = z;
                    break;
                case 2:
                    this.gGq = z;
                    break;
                case 3:
                    this.gGr = z;
                    break;
                case 4:
                    this.gGt = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gGu = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gGv = z;
                    break;
                case 9:
                    this.gGw = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().EQ());
                    break;
                case 10:
                    this.gGx = z;
                    break;
            }
            lT(true);
            bnV();
        }
    }

    private void bnV() {
        boolean z = this.gGs || this.gGr || this.gGq || this.gGt || this.gGu || this.gGv || this.gGw;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bnW() {
        this.gGq = false;
        this.gGr = false;
        this.gGs = false;
        this.gGt = false;
        this.gGu = false;
        this.gGv = false;
        this.gGw = false;
        this.gGy = 0;
        this.gGz = 0;
        this.gGA = 0;
        this.gGB = 0;
        this.gGC = false;
        this.mHasNewVersion = false;
        this.gGD = false;
        this.gGE = false;
        this.gGF = false;
        this.gGG = false;
        this.gGH = false;
        bnP();
        e.nr().post(new Runnable() { // from class: com.baidu.tieba.m.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gGJ) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bnQ();
    }
}
