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
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private CustomMessageListener hKk;
    private boolean hTi;
    private boolean isPrimary;
    private boolean kzA;
    private boolean kzB;
    private boolean kzC;
    private boolean kzD;
    private boolean kzE;
    private int kzF;
    private int kzG;
    private int kzH;
    private int kzI;
    private boolean kzJ;
    private boolean kzK;
    private boolean kzL;
    private boolean kzM;
    private boolean kzN;
    private boolean kzO;
    private boolean kzP;
    CustomMessageListener kzQ;
    private CustomMessageListener kzR;
    private CustomMessageListener kzS;
    private boolean kzx;
    private boolean kzy;
    private boolean kzz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cOF() {
        return this.kzx;
    }

    public boolean cOG() {
        return this.kzy;
    }

    public boolean cOH() {
        return this.kzC;
    }

    public boolean cOI() {
        return this.kzD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0624a {
        private static final a kzU = new a();
    }

    private a() {
        this.isPrimary = false;
        this.kzx = false;
        this.kzy = false;
        this.kzz = false;
        this.kzA = false;
        this.kzB = false;
        this.kzC = false;
        this.kzD = false;
        this.kzE = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.kzF = 0;
        this.kzG = 0;
        this.kzH = 0;
        this.kzI = 0;
        this.kzJ = false;
        this.mHasNewVersion = false;
        this.kzK = false;
        this.kzL = false;
        this.kzM = false;
        this.kzN = false;
        this.kzO = false;
        this.kzP = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.kzQ = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.kzI >= responseUnreadPointNum.getNum()) {
                        a.this.kzI = responseUnreadPointNum.getNum();
                        a.this.kzJ = false;
                    } else {
                        a.this.kzJ = true;
                        a.this.kzA = a.this.kzJ ? true : a.this.kzA;
                        a.this.kzI = responseUnreadPointNum.getNum();
                        a.this.cON();
                    }
                    a.this.cOM();
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
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.kzE = booleanValue;
                    a.this.kzP = booleanValue;
                    a.this.cON();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.kzN = booleanValue;
                    a.this.kzC = booleanValue;
                    a.this.cON();
                }
            }
        };
        this.kzR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.kzB = a.this.mHasNewVersion ? true : a.this.kzB;
                    a.this.cON();
                }
            }
        };
        this.hKk = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cOP();
                    }
                }
            }
        };
        this.kzS = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cOR();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.kzD = true;
                            a.this.kzO = true;
                            a.this.cON();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cOJ() {
        return C0624a.kzU;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.kzQ);
        MessageManager.getInstance().registerListener(this.kzR);
        MessageManager.getInstance().registerListener(this.kzS);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.hKk);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cOK() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.kzB = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hTi = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cOL() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.kzB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.kzM = newsNotifyMessage.getMsgBookmark() > this.kzH;
            this.kzK = newsNotifyMessage.getMsgFans() > this.kzF;
            this.kzL = newsNotifyMessage.getMsgGiftNum() > this.kzG;
            this.kzH = newsNotifyMessage.getMsgBookmark();
            this.kzF = newsNotifyMessage.getMsgFans();
            this.kzG = newsNotifyMessage.getMsgGiftNum();
            if (this.kzM || this.kzK || this.kzL || this.mHasNewVersion) {
                this.kzx = this.kzK ? true : this.kzx;
                this.kzy = this.kzM ? true : this.kzy;
                this.kzz = this.kzL ? true : this.kzz;
                this.kzB = this.mHasNewVersion ? true : this.kzB;
                cON();
            }
        }
    }

    public void cOM() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.kzJ);
    }

    public void tp(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cON() {
        SparseArray sparseArray = new SparseArray();
        if (this.kzJ) {
            sparseArray.append(4, new b.a(this.kzA, this.kzI));
        }
        if (this.kzK) {
            sparseArray.append(2, new b.a(this.kzx, this.kzF));
        }
        if (this.kzL) {
            sparseArray.append(1, new b.a(this.kzz, this.kzG));
        }
        if (this.kzM) {
            sparseArray.append(3, new b.a(this.kzy, this.kzH));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.kzB, 0));
        }
        if (this.kzN) {
            sparseArray.append(7, new b.a(this.kzC, 0));
        }
        if (this.kzO) {
            sparseArray.append(9, new b.a(this.kzD, 0));
        }
        if (this.kzP) {
            sparseArray.append(10, new b.a(this.kzE, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cOO();
    }

    public void tq(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.kzA, this.kzI));
            sparseArray.append(2, new b.a(this.kzx, this.kzF));
            sparseArray.append(1, new b.a(this.kzz, this.kzG));
            sparseArray.append(3, new b.a(this.kzy, this.kzH));
            sparseArray.append(5, new b.a(this.kzB, 0));
            sparseArray.append(7, new b.a(this.kzC, 0));
            sparseArray.append(9, new b.a(this.kzD, 0));
            sparseArray.append(10, new b.a(this.kzE, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cOO() {
        if (((this.kzF > 0 && this.kzK) || (this.kzH > 0 && this.kzM) || this.mHasNewVersion || this.kzO || this.kzP) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.kzP) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cOP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.kzz = z;
                    break;
                case 2:
                    this.kzx = z;
                    break;
                case 3:
                    this.kzy = z;
                    break;
                case 4:
                    this.kzA = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.kzB = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.kzC = z;
                    break;
                case 9:
                    this.kzD = z;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.kzE = z;
                    break;
            }
            tq(true);
            cOQ();
        }
    }

    private void cOQ() {
        boolean z = this.kzz || this.kzy || this.kzx || this.kzA || this.kzB || this.kzC || this.kzD;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cOR() {
        this.kzx = false;
        this.kzy = false;
        this.kzz = false;
        this.kzA = false;
        this.kzB = false;
        this.kzC = false;
        this.kzD = false;
        this.kzF = 0;
        this.kzG = 0;
        this.kzH = 0;
        this.kzI = 0;
        this.kzJ = false;
        this.mHasNewVersion = false;
        this.kzK = false;
        this.kzL = false;
        this.kzM = false;
        this.kzN = false;
        this.kzO = false;
        cOK();
        e.lb().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hTi) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cOL();
    }
}
