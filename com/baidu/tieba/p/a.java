package com.baidu.tieba.p;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private boolean isPrimary;
    private CustomMessageListener jZT;
    private boolean kmx;
    private boolean mHasNewVersion;
    private boolean mWA;
    private boolean mWB;
    private boolean mWC;
    private boolean mWD;
    private boolean mWE;
    private boolean mWF;
    private int mWG;
    private int mWH;
    private int mWI;
    private int mWJ;
    private boolean mWK;
    private boolean mWL;
    private boolean mWN;
    private boolean mWO;
    private boolean mWP;
    private boolean mWQ;
    private boolean mWR;
    CustomMessageListener mWS;
    private CustomMessageListener mWT;
    private CustomMessageListener mWU;
    private boolean mWx;
    private boolean mWy;
    private boolean mWz;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dGz() {
        return this.mWx;
    }

    public boolean dGA() {
        return this.mWy;
    }

    public boolean dGB() {
        return this.mWC;
    }

    public boolean dGC() {
        return this.mWD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0803a {
        private static final a mWW = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mWx = false;
        this.mWy = false;
        this.mWz = false;
        this.mWA = false;
        this.mWB = false;
        this.mWC = false;
        this.mWD = false;
        this.mWE = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mWF = false;
        this.mWG = 0;
        this.mWH = 0;
        this.mWI = 0;
        this.mWJ = 0;
        this.mWK = false;
        this.mHasNewVersion = false;
        this.mWL = false;
        this.mWN = false;
        this.mWO = false;
        this.mWP = false;
        this.mWQ = false;
        this.mWR = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mWS = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mWJ >= responseUnreadPointNum.getNum()) {
                        a.this.mWJ = responseUnreadPointNum.getNum();
                        a.this.mWK = false;
                    } else {
                        a.this.mWK = true;
                        a.this.mWA = a.this.mWK ? true : a.this.mWA;
                        a.this.mWJ = responseUnreadPointNum.getNum();
                        a.this.dGH();
                    }
                    a.this.dGG();
                }
            }
        };
        this.feedBackRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.p.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mWE = booleanValue;
                    a.this.mWR = booleanValue;
                    a.this.dGH();
                }
            }
        };
        this.memberCenterRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.p.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mWP = booleanValue;
                    a.this.mWC = booleanValue;
                    a.this.dGH();
                }
            }
        };
        this.mWT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mWB = a.this.mHasNewVersion ? true : a.this.mWB;
                    a.this.dGH();
                }
            }
        };
        this.jZT = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dGJ();
                        if (a.this.mWF) {
                            TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_locate", 1));
                            a.this.mWF = false;
                        }
                    }
                }
            }
        };
        this.mWU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dGL();
                }
            }
        };
        this.syncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.p.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mWD = true;
                            a.this.mWQ = true;
                            a.this.dGH();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dGD() {
        return C0803a.mWW;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mWS);
        MessageManager.getInstance().registerListener(this.mWT);
        MessageManager.getInstance().registerListener(this.mWU);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jZT);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dGE() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mWB = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.kmx = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dGF() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mWB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mWO = newsNotifyMessage.getMsgBookmark() > this.mWI;
            this.mWL = newsNotifyMessage.getMsgFans() > this.mWG;
            this.mWN = newsNotifyMessage.getMsgGiftNum() > this.mWH;
            this.mWI = newsNotifyMessage.getMsgBookmark();
            this.mWG = newsNotifyMessage.getMsgFans();
            this.mWH = newsNotifyMessage.getMsgGiftNum();
            if (this.mWO || this.mWL || this.mWN || this.mHasNewVersion) {
                this.mWx = this.mWL ? true : this.mWx;
                this.mWy = this.mWO ? true : this.mWy;
                this.mWz = this.mWN ? true : this.mWz;
                this.mWB = this.mHasNewVersion ? true : this.mWB;
                dGH();
            }
        }
    }

    public void dGG() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mWK);
    }

    public void xu(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGH() {
        SparseArray sparseArray = new SparseArray();
        if (this.mWK) {
            sparseArray.append(4, new b.a(this.mWA, this.mWJ));
        }
        if (this.mWL) {
            sparseArray.append(2, new b.a(this.mWx, this.mWG));
        }
        if (this.mWN) {
            sparseArray.append(1, new b.a(this.mWz, this.mWH));
        }
        if (this.mWO) {
            sparseArray.append(3, new b.a(this.mWy, this.mWI));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mWB, 0));
        }
        if (this.mWP) {
            sparseArray.append(7, new b.a(this.mWC, 0));
        }
        if (this.mWQ) {
            sparseArray.append(9, new b.a(this.mWD, 0));
        }
        if (this.mWR) {
            sparseArray.append(10, new b.a(this.mWE, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dGI();
    }

    public void xv(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mWA, this.mWJ));
            sparseArray.append(2, new b.a(this.mWx, this.mWG));
            sparseArray.append(1, new b.a(this.mWz, this.mWH));
            sparseArray.append(3, new b.a(this.mWy, this.mWI));
            sparseArray.append(5, new b.a(this.mWB, 0));
            sparseArray.append(7, new b.a(this.mWC, 0));
            sparseArray.append(9, new b.a(this.mWD, 0));
            sparseArray.append(10, new b.a(this.mWE, 0));
            sparseArray.append(11, new b.a(this.mWF, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dGI() {
        if (((this.mWG > 0 && this.mWL) || (this.mWI > 0 && this.mWO) || this.mHasNewVersion || this.mWQ || this.mWR) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mWR) {
                com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dGJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mWz = z;
                    break;
                case 2:
                    this.mWx = z;
                    break;
                case 3:
                    this.mWy = z;
                    break;
                case 4:
                    this.mWA = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mWB = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mWC = z;
                    break;
                case 9:
                    this.mWD = z;
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mWE = z;
                    break;
                case 11:
                    this.mWF = z;
                    break;
            }
            xv(true);
            dGK();
        }
    }

    private void dGK() {
        boolean z = this.mWz || this.mWy || this.mWx || this.mWA || this.mWB || this.mWC || this.mWD || this.mWF;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dGL() {
        this.mWx = false;
        this.mWy = false;
        this.mWz = false;
        this.mWA = false;
        this.mWB = false;
        this.mWC = false;
        this.mWD = false;
        this.mWG = 0;
        this.mWH = 0;
        this.mWI = 0;
        this.mWJ = 0;
        this.mWK = false;
        this.mHasNewVersion = false;
        this.mWL = false;
        this.mWN = false;
        this.mWO = false;
        this.mWP = false;
        this.mWQ = false;
        dGE();
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kmx) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dGF();
    }
}
