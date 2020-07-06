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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private CustomMessageListener inV;
    private boolean isPrimary;
    private boolean izJ;
    private boolean lmA;
    private boolean lmB;
    private boolean lmC;
    private boolean lmD;
    private boolean lmE;
    private boolean lmF;
    private boolean lmG;
    private boolean lmH;
    private int lmI;
    private int lmJ;
    private int lmK;
    private int lmL;
    private boolean lmM;
    private boolean lmN;
    private boolean lmO;
    private boolean lmP;
    private boolean lmQ;
    private boolean lmR;
    private boolean lmS;
    CustomMessageListener lmT;
    private CustomMessageListener lmU;
    private CustomMessageListener lmV;
    private boolean lmz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dan() {
        return this.lmz;
    }

    public boolean dao() {
        return this.lmA;
    }

    public boolean dap() {
        return this.lmE;
    }

    public boolean daq() {
        return this.lmF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0694a {
        private static final a lmX = new a();
    }

    private a() {
        this.isPrimary = false;
        this.lmz = false;
        this.lmA = false;
        this.lmB = false;
        this.lmC = false;
        this.lmD = false;
        this.lmE = false;
        this.lmF = false;
        this.lmG = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.lmH = false;
        this.lmI = 0;
        this.lmJ = 0;
        this.lmK = 0;
        this.lmL = 0;
        this.lmM = false;
        this.mHasNewVersion = false;
        this.lmN = false;
        this.lmO = false;
        this.lmP = false;
        this.lmQ = false;
        this.lmR = false;
        this.lmS = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lmT = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.lmL >= responseUnreadPointNum.getNum()) {
                        a.this.lmL = responseUnreadPointNum.getNum();
                        a.this.lmM = false;
                    } else {
                        a.this.lmM = true;
                        a.this.lmC = a.this.lmM ? true : a.this.lmC;
                        a.this.lmL = responseUnreadPointNum.getNum();
                        a.this.dav();
                    }
                    a.this.dau();
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
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.lmG = booleanValue;
                    a.this.lmS = booleanValue;
                    a.this.dav();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.lmQ = booleanValue;
                    a.this.lmE = booleanValue;
                    a.this.dav();
                }
            }
        };
        this.lmU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.lmD = a.this.mHasNewVersion ? true : a.this.lmD;
                    a.this.dav();
                }
            }
        };
        this.inV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dax();
                        if (a.this.lmH) {
                            TiebaStatic.log(new ao("c13688").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_locate", 1));
                            a.this.lmH = false;
                        }
                    }
                }
            }
        };
        this.lmV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.daz();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.lmF = true;
                            a.this.lmR = true;
                            a.this.dav();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dar() {
        return C0694a.lmX;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lmT);
        MessageManager.getInstance().registerListener(this.lmU);
        MessageManager.getInstance().registerListener(this.lmV);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.inV);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void das() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.lmD = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.izJ = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dat() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.lmD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lmP = newsNotifyMessage.getMsgBookmark() > this.lmK;
            this.lmN = newsNotifyMessage.getMsgFans() > this.lmI;
            this.lmO = newsNotifyMessage.getMsgGiftNum() > this.lmJ;
            this.lmK = newsNotifyMessage.getMsgBookmark();
            this.lmI = newsNotifyMessage.getMsgFans();
            this.lmJ = newsNotifyMessage.getMsgGiftNum();
            if (this.lmP || this.lmN || this.lmO || this.mHasNewVersion) {
                this.lmz = this.lmN ? true : this.lmz;
                this.lmA = this.lmP ? true : this.lmA;
                this.lmB = this.lmO ? true : this.lmB;
                this.lmD = this.mHasNewVersion ? true : this.lmD;
                dav();
            }
        }
    }

    public void dau() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.lmM);
    }

    public void uc(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dav() {
        SparseArray sparseArray = new SparseArray();
        if (this.lmM) {
            sparseArray.append(4, new b.a(this.lmC, this.lmL));
        }
        if (this.lmN) {
            sparseArray.append(2, new b.a(this.lmz, this.lmI));
        }
        if (this.lmO) {
            sparseArray.append(1, new b.a(this.lmB, this.lmJ));
        }
        if (this.lmP) {
            sparseArray.append(3, new b.a(this.lmA, this.lmK));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.lmD, 0));
        }
        if (this.lmQ) {
            sparseArray.append(7, new b.a(this.lmE, 0));
        }
        if (this.lmR) {
            sparseArray.append(9, new b.a(this.lmF, 0));
        }
        if (this.lmS) {
            sparseArray.append(10, new b.a(this.lmG, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        daw();
    }

    public void ud(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.lmC, this.lmL));
            sparseArray.append(2, new b.a(this.lmz, this.lmI));
            sparseArray.append(1, new b.a(this.lmB, this.lmJ));
            sparseArray.append(3, new b.a(this.lmA, this.lmK));
            sparseArray.append(5, new b.a(this.lmD, 0));
            sparseArray.append(7, new b.a(this.lmE, 0));
            sparseArray.append(9, new b.a(this.lmF, 0));
            sparseArray.append(10, new b.a(this.lmG, 0));
            sparseArray.append(11, new b.a(this.lmH, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void daw() {
        if (((this.lmI > 0 && this.lmN) || (this.lmK > 0 && this.lmP) || this.mHasNewVersion || this.lmR || this.lmS) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.lmS) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dax() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.lmB = z;
                    break;
                case 2:
                    this.lmz = z;
                    break;
                case 3:
                    this.lmA = z;
                    break;
                case 4:
                    this.lmC = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.lmD = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.lmE = z;
                    break;
                case 9:
                    this.lmF = z;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.lmG = z;
                    break;
                case 11:
                    this.lmH = z;
                    break;
            }
            ud(true);
            day();
        }
    }

    private void day() {
        boolean z = this.lmB || this.lmA || this.lmz || this.lmC || this.lmD || this.lmE || this.lmF || this.lmH;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void daz() {
        this.lmz = false;
        this.lmA = false;
        this.lmB = false;
        this.lmC = false;
        this.lmD = false;
        this.lmE = false;
        this.lmF = false;
        this.lmI = 0;
        this.lmJ = 0;
        this.lmK = 0;
        this.lmL = 0;
        this.lmM = false;
        this.mHasNewVersion = false;
        this.lmN = false;
        this.lmO = false;
        this.lmP = false;
        this.lmQ = false;
        this.lmR = false;
        das();
        e.lt().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.izJ) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dat();
    }
}
