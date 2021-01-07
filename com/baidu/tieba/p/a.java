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
    private int mWF;
    private int mWG;
    private int mWH;
    private int mWI;
    private boolean mWJ;
    private boolean mWK;
    private boolean mWL;
    private boolean mWN;
    private boolean mWO;
    private boolean mWP;
    private boolean mWQ;
    CustomMessageListener mWR;
    private CustomMessageListener mWS;
    private CustomMessageListener mWT;
    private boolean mWw;
    private boolean mWx;
    private boolean mWy;
    private boolean mWz;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dGA() {
        return this.mWw;
    }

    public boolean dGB() {
        return this.mWx;
    }

    public boolean dGC() {
        return this.mWB;
    }

    public boolean dGD() {
        return this.mWC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0837a {
        private static final a mWV = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mWw = false;
        this.mWx = false;
        this.mWy = false;
        this.mWz = false;
        this.mWA = false;
        this.mWB = false;
        this.mWC = false;
        this.mWD = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mWE = false;
        this.mWF = 0;
        this.mWG = 0;
        this.mWH = 0;
        this.mWI = 0;
        this.mWJ = false;
        this.mHasNewVersion = false;
        this.mWK = false;
        this.mWL = false;
        this.mWN = false;
        this.mWO = false;
        this.mWP = false;
        this.mWQ = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mWR = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mWI >= responseUnreadPointNum.getNum()) {
                        a.this.mWI = responseUnreadPointNum.getNum();
                        a.this.mWJ = false;
                    } else {
                        a.this.mWJ = true;
                        a.this.mWz = a.this.mWJ ? true : a.this.mWz;
                        a.this.mWI = responseUnreadPointNum.getNum();
                        a.this.dGI();
                    }
                    a.this.dGH();
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
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mWD = booleanValue;
                    a.this.mWQ = booleanValue;
                    a.this.dGI();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mWO = booleanValue;
                    a.this.mWB = booleanValue;
                    a.this.dGI();
                }
            }
        };
        this.mWS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mWA = a.this.mHasNewVersion ? true : a.this.mWA;
                    a.this.dGI();
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
                        a.this.dGK();
                        if (a.this.mWE) {
                            TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_locate", 1));
                            a.this.mWE = false;
                        }
                    }
                }
            }
        };
        this.mWT = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dGM();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mWC = true;
                            a.this.mWP = true;
                            a.this.dGI();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dGE() {
        return C0837a.mWV;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mWR);
        MessageManager.getInstance().registerListener(this.mWS);
        MessageManager.getInstance().registerListener(this.mWT);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jZT);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dGF() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mWA = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.kmx = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dGG() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mWA)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mWN = newsNotifyMessage.getMsgBookmark() > this.mWH;
            this.mWK = newsNotifyMessage.getMsgFans() > this.mWF;
            this.mWL = newsNotifyMessage.getMsgGiftNum() > this.mWG;
            this.mWH = newsNotifyMessage.getMsgBookmark();
            this.mWF = newsNotifyMessage.getMsgFans();
            this.mWG = newsNotifyMessage.getMsgGiftNum();
            if (this.mWN || this.mWK || this.mWL || this.mHasNewVersion) {
                this.mWw = this.mWK ? true : this.mWw;
                this.mWx = this.mWN ? true : this.mWx;
                this.mWy = this.mWL ? true : this.mWy;
                this.mWA = this.mHasNewVersion ? true : this.mWA;
                dGI();
            }
        }
    }

    public void dGH() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mWJ);
    }

    public void xu(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGI() {
        SparseArray sparseArray = new SparseArray();
        if (this.mWJ) {
            sparseArray.append(4, new b.a(this.mWz, this.mWI));
        }
        if (this.mWK) {
            sparseArray.append(2, new b.a(this.mWw, this.mWF));
        }
        if (this.mWL) {
            sparseArray.append(1, new b.a(this.mWy, this.mWG));
        }
        if (this.mWN) {
            sparseArray.append(3, new b.a(this.mWx, this.mWH));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mWA, 0));
        }
        if (this.mWO) {
            sparseArray.append(7, new b.a(this.mWB, 0));
        }
        if (this.mWP) {
            sparseArray.append(9, new b.a(this.mWC, 0));
        }
        if (this.mWQ) {
            sparseArray.append(10, new b.a(this.mWD, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dGJ();
    }

    public void xv(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mWz, this.mWI));
            sparseArray.append(2, new b.a(this.mWw, this.mWF));
            sparseArray.append(1, new b.a(this.mWy, this.mWG));
            sparseArray.append(3, new b.a(this.mWx, this.mWH));
            sparseArray.append(5, new b.a(this.mWA, 0));
            sparseArray.append(7, new b.a(this.mWB, 0));
            sparseArray.append(9, new b.a(this.mWC, 0));
            sparseArray.append(10, new b.a(this.mWD, 0));
            sparseArray.append(11, new b.a(this.mWE, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dGJ() {
        if (((this.mWF > 0 && this.mWK) || (this.mWH > 0 && this.mWN) || this.mHasNewVersion || this.mWP || this.mWQ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mWQ) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dGK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mWy = z;
                    break;
                case 2:
                    this.mWw = z;
                    break;
                case 3:
                    this.mWx = z;
                    break;
                case 4:
                    this.mWz = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mWA = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mWB = z;
                    break;
                case 9:
                    this.mWC = z;
                    com.baidu.tbadk.core.sharedPref.b.bvr().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mWD = z;
                    break;
                case 11:
                    this.mWE = z;
                    break;
            }
            xv(true);
            dGL();
        }
    }

    private void dGL() {
        boolean z = this.mWy || this.mWx || this.mWw || this.mWz || this.mWA || this.mWB || this.mWC || this.mWE;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dGM() {
        this.mWw = false;
        this.mWx = false;
        this.mWy = false;
        this.mWz = false;
        this.mWA = false;
        this.mWB = false;
        this.mWC = false;
        this.mWF = 0;
        this.mWG = 0;
        this.mWH = 0;
        this.mWI = 0;
        this.mWJ = false;
        this.mHasNewVersion = false;
        this.mWK = false;
        this.mWL = false;
        this.mWN = false;
        this.mWO = false;
        this.mWP = false;
        dGF();
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kmx) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dGG();
    }
}
