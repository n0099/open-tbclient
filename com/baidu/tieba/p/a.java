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
    private boolean jEY;
    private CustomMessageListener jsn;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private boolean mwA;
    private boolean mwB;
    private boolean mwC;
    private boolean mwD;
    private boolean mwE;
    private boolean mwF;
    private boolean mwG;
    private boolean mwH;
    private int mwI;
    private int mwJ;
    private int mwK;
    private int mwL;
    private boolean mwM;
    private boolean mwN;
    private boolean mwO;
    private boolean mwP;
    private boolean mwQ;
    private boolean mwR;
    private boolean mwS;
    CustomMessageListener mwT;
    private CustomMessageListener mwU;
    private CustomMessageListener mwV;
    private boolean mwz;
    private CustomMessageListener syncFinishListener;

    public boolean dzs() {
        return this.mwz;
    }

    public boolean dzt() {
        return this.mwA;
    }

    public boolean dzu() {
        return this.mwE;
    }

    public boolean dzv() {
        return this.mwF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0787a {
        private static final a mwX = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mwz = false;
        this.mwA = false;
        this.mwB = false;
        this.mwC = false;
        this.mwD = false;
        this.mwE = false;
        this.mwF = false;
        this.mwG = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mwH = false;
        this.mwI = 0;
        this.mwJ = 0;
        this.mwK = 0;
        this.mwL = 0;
        this.mwM = false;
        this.mHasNewVersion = false;
        this.mwN = false;
        this.mwO = false;
        this.mwP = false;
        this.mwQ = false;
        this.mwR = false;
        this.mwS = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mwT = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mwL >= responseUnreadPointNum.getNum()) {
                        a.this.mwL = responseUnreadPointNum.getNum();
                        a.this.mwM = false;
                    } else {
                        a.this.mwM = true;
                        a.this.mwC = a.this.mwM ? true : a.this.mwC;
                        a.this.mwL = responseUnreadPointNum.getNum();
                        a.this.dzA();
                    }
                    a.this.dzz();
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
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mwG = booleanValue;
                    a.this.mwS = booleanValue;
                    a.this.dzA();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mwQ = booleanValue;
                    a.this.mwE = booleanValue;
                    a.this.dzA();
                }
            }
        };
        this.mwU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mwD = a.this.mHasNewVersion ? true : a.this.mwD;
                    a.this.dzA();
                }
            }
        };
        this.jsn = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dzC();
                        if (a.this.mwH) {
                            TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_locate", 1));
                            a.this.mwH = false;
                        }
                    }
                }
            }
        };
        this.mwV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dzE();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mwF = true;
                            a.this.mwR = true;
                            a.this.dzA();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dzw() {
        return C0787a.mwX;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mwT);
        MessageManager.getInstance().registerListener(this.mwU);
        MessageManager.getInstance().registerListener(this.mwV);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jsn);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dzx() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mwD = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jEY = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dzy() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mwD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mwP = newsNotifyMessage.getMsgBookmark() > this.mwK;
            this.mwN = newsNotifyMessage.getMsgFans() > this.mwI;
            this.mwO = newsNotifyMessage.getMsgGiftNum() > this.mwJ;
            this.mwK = newsNotifyMessage.getMsgBookmark();
            this.mwI = newsNotifyMessage.getMsgFans();
            this.mwJ = newsNotifyMessage.getMsgGiftNum();
            if (this.mwP || this.mwN || this.mwO || this.mHasNewVersion) {
                this.mwz = this.mwN ? true : this.mwz;
                this.mwA = this.mwP ? true : this.mwA;
                this.mwB = this.mwO ? true : this.mwB;
                this.mwD = this.mHasNewVersion ? true : this.mwD;
                dzA();
            }
        }
    }

    public void dzz() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mwM);
    }

    public void wD(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzA() {
        SparseArray sparseArray = new SparseArray();
        if (this.mwM) {
            sparseArray.append(4, new b.a(this.mwC, this.mwL));
        }
        if (this.mwN) {
            sparseArray.append(2, new b.a(this.mwz, this.mwI));
        }
        if (this.mwO) {
            sparseArray.append(1, new b.a(this.mwB, this.mwJ));
        }
        if (this.mwP) {
            sparseArray.append(3, new b.a(this.mwA, this.mwK));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mwD, 0));
        }
        if (this.mwQ) {
            sparseArray.append(7, new b.a(this.mwE, 0));
        }
        if (this.mwR) {
            sparseArray.append(9, new b.a(this.mwF, 0));
        }
        if (this.mwS) {
            sparseArray.append(10, new b.a(this.mwG, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dzB();
    }

    public void wE(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mwC, this.mwL));
            sparseArray.append(2, new b.a(this.mwz, this.mwI));
            sparseArray.append(1, new b.a(this.mwB, this.mwJ));
            sparseArray.append(3, new b.a(this.mwA, this.mwK));
            sparseArray.append(5, new b.a(this.mwD, 0));
            sparseArray.append(7, new b.a(this.mwE, 0));
            sparseArray.append(9, new b.a(this.mwF, 0));
            sparseArray.append(10, new b.a(this.mwG, 0));
            sparseArray.append(11, new b.a(this.mwH, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dzB() {
        if (((this.mwI > 0 && this.mwN) || (this.mwK > 0 && this.mwP) || this.mHasNewVersion || this.mwR || this.mwS) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mwS) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dzC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mwB = z;
                    break;
                case 2:
                    this.mwz = z;
                    break;
                case 3:
                    this.mwA = z;
                    break;
                case 4:
                    this.mwC = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mwD = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mwE = z;
                    break;
                case 9:
                    this.mwF = z;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mwG = z;
                    break;
                case 11:
                    this.mwH = z;
                    break;
            }
            wE(true);
            dzD();
        }
    }

    private void dzD() {
        boolean z = this.mwB || this.mwA || this.mwz || this.mwC || this.mwD || this.mwE || this.mwF || this.mwH;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dzE() {
        this.mwz = false;
        this.mwA = false;
        this.mwB = false;
        this.mwC = false;
        this.mwD = false;
        this.mwE = false;
        this.mwF = false;
        this.mwI = 0;
        this.mwJ = 0;
        this.mwK = 0;
        this.mwL = 0;
        this.mwM = false;
        this.mHasNewVersion = false;
        this.mwN = false;
        this.mwO = false;
        this.mwP = false;
        this.mwQ = false;
        this.mwR = false;
        dzx();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jEY) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dzy();
    }
}
