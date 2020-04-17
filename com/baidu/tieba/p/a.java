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
    private CustomMessageListener hKe;
    private boolean hTc;
    private boolean isPrimary;
    private boolean kzA;
    private int kzB;
    private int kzC;
    private int kzD;
    private int kzE;
    private boolean kzF;
    private boolean kzG;
    private boolean kzH;
    private boolean kzI;
    private boolean kzJ;
    private boolean kzK;
    private boolean kzL;
    CustomMessageListener kzM;
    private CustomMessageListener kzN;
    private CustomMessageListener kzO;
    private boolean kzt;
    private boolean kzu;
    private boolean kzv;
    private boolean kzw;
    private boolean kzx;
    private boolean kzy;
    private boolean kzz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cOH() {
        return this.kzt;
    }

    public boolean cOI() {
        return this.kzu;
    }

    public boolean cOJ() {
        return this.kzy;
    }

    public boolean cOK() {
        return this.kzz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0603a {
        private static final a kzQ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.kzt = false;
        this.kzu = false;
        this.kzv = false;
        this.kzw = false;
        this.kzx = false;
        this.kzy = false;
        this.kzz = false;
        this.kzA = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.kzB = 0;
        this.kzC = 0;
        this.kzD = 0;
        this.kzE = 0;
        this.kzF = false;
        this.mHasNewVersion = false;
        this.kzG = false;
        this.kzH = false;
        this.kzI = false;
        this.kzJ = false;
        this.kzK = false;
        this.kzL = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.kzM = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.kzE >= responseUnreadPointNum.getNum()) {
                        a.this.kzE = responseUnreadPointNum.getNum();
                        a.this.kzF = false;
                    } else {
                        a.this.kzF = true;
                        a.this.kzw = a.this.kzF ? true : a.this.kzw;
                        a.this.kzE = responseUnreadPointNum.getNum();
                        a.this.cOP();
                    }
                    a.this.cOO();
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
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.kzA = booleanValue;
                    a.this.kzL = booleanValue;
                    a.this.cOP();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.kzJ = booleanValue;
                    a.this.kzy = booleanValue;
                    a.this.cOP();
                }
            }
        };
        this.kzN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.kzx = a.this.mHasNewVersion ? true : a.this.kzx;
                    a.this.cOP();
                }
            }
        };
        this.hKe = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cOR();
                    }
                }
            }
        };
        this.kzO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cOT();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.kzz = true;
                            a.this.kzK = true;
                            a.this.cOP();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cOL() {
        return C0603a.kzQ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.kzM);
        MessageManager.getInstance().registerListener(this.kzN);
        MessageManager.getInstance().registerListener(this.kzO);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.hKe);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cOM() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.kzx = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hTc = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cON() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.kzx)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.kzI = newsNotifyMessage.getMsgBookmark() > this.kzD;
            this.kzG = newsNotifyMessage.getMsgFans() > this.kzB;
            this.kzH = newsNotifyMessage.getMsgGiftNum() > this.kzC;
            this.kzD = newsNotifyMessage.getMsgBookmark();
            this.kzB = newsNotifyMessage.getMsgFans();
            this.kzC = newsNotifyMessage.getMsgGiftNum();
            if (this.kzI || this.kzG || this.kzH || this.mHasNewVersion) {
                this.kzt = this.kzG ? true : this.kzt;
                this.kzu = this.kzI ? true : this.kzu;
                this.kzv = this.kzH ? true : this.kzv;
                this.kzx = this.mHasNewVersion ? true : this.kzx;
                cOP();
            }
        }
    }

    public void cOO() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.kzF);
    }

    public void tp(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOP() {
        SparseArray sparseArray = new SparseArray();
        if (this.kzF) {
            sparseArray.append(4, new b.a(this.kzw, this.kzE));
        }
        if (this.kzG) {
            sparseArray.append(2, new b.a(this.kzt, this.kzB));
        }
        if (this.kzH) {
            sparseArray.append(1, new b.a(this.kzv, this.kzC));
        }
        if (this.kzI) {
            sparseArray.append(3, new b.a(this.kzu, this.kzD));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.kzx, 0));
        }
        if (this.kzJ) {
            sparseArray.append(7, new b.a(this.kzy, 0));
        }
        if (this.kzK) {
            sparseArray.append(9, new b.a(this.kzz, 0));
        }
        if (this.kzL) {
            sparseArray.append(10, new b.a(this.kzA, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cOQ();
    }

    public void tq(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.kzw, this.kzE));
            sparseArray.append(2, new b.a(this.kzt, this.kzB));
            sparseArray.append(1, new b.a(this.kzv, this.kzC));
            sparseArray.append(3, new b.a(this.kzu, this.kzD));
            sparseArray.append(5, new b.a(this.kzx, 0));
            sparseArray.append(7, new b.a(this.kzy, 0));
            sparseArray.append(9, new b.a(this.kzz, 0));
            sparseArray.append(10, new b.a(this.kzA, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cOQ() {
        if (((this.kzB > 0 && this.kzG) || (this.kzD > 0 && this.kzI) || this.mHasNewVersion || this.kzK || this.kzL) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.kzL) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cOR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.kzv = z;
                    break;
                case 2:
                    this.kzt = z;
                    break;
                case 3:
                    this.kzu = z;
                    break;
                case 4:
                    this.kzw = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.kzx = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.kzy = z;
                    break;
                case 9:
                    this.kzz = z;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.kzA = z;
                    break;
            }
            tq(true);
            cOS();
        }
    }

    private void cOS() {
        boolean z = this.kzv || this.kzu || this.kzt || this.kzw || this.kzx || this.kzy || this.kzz;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cOT() {
        this.kzt = false;
        this.kzu = false;
        this.kzv = false;
        this.kzw = false;
        this.kzx = false;
        this.kzy = false;
        this.kzz = false;
        this.kzB = 0;
        this.kzC = 0;
        this.kzD = 0;
        this.kzE = 0;
        this.kzF = false;
        this.mHasNewVersion = false;
        this.kzG = false;
        this.kzH = false;
        this.kzI = false;
        this.kzJ = false;
        this.kzK = false;
        cOM();
        e.lb().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hTc) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cON();
    }
}
