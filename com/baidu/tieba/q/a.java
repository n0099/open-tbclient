package com.baidu.tieba.q;

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.q.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private boolean isPrimary;
    private boolean jLH;
    private CustomMessageListener jzb;
    private boolean mCU;
    private boolean mCV;
    private boolean mCW;
    private boolean mCX;
    private boolean mCY;
    private boolean mCZ;
    private boolean mDa;
    private boolean mDc;
    private boolean mDd;
    private int mDe;
    private int mDf;
    private int mDg;
    private int mDh;
    private boolean mDi;
    private boolean mDj;
    private boolean mDk;
    private boolean mDl;
    private boolean mDm;
    private boolean mDn;
    private boolean mDo;
    CustomMessageListener mDp;
    private CustomMessageListener mDq;
    private CustomMessageListener mDr;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dBy() {
        return this.mCU;
    }

    public boolean dBz() {
        return this.mCV;
    }

    public boolean dBA() {
        return this.mCZ;
    }

    public boolean dBB() {
        return this.mDa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0832a {
        private static final a mDt = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mCU = false;
        this.mCV = false;
        this.mCW = false;
        this.mCX = false;
        this.mCY = false;
        this.mCZ = false;
        this.mDa = false;
        this.mDc = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mDd = false;
        this.mDe = 0;
        this.mDf = 0;
        this.mDg = 0;
        this.mDh = 0;
        this.mDi = false;
        this.mHasNewVersion = false;
        this.mDj = false;
        this.mDk = false;
        this.mDl = false;
        this.mDm = false;
        this.mDn = false;
        this.mDo = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.q.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mDp = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.q.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mDh >= responseUnreadPointNum.getNum()) {
                        a.this.mDh = responseUnreadPointNum.getNum();
                        a.this.mDi = false;
                    } else {
                        a.this.mDi = true;
                        a.this.mCX = a.this.mDi ? true : a.this.mCX;
                        a.this.mDh = responseUnreadPointNum.getNum();
                        a.this.dBG();
                    }
                    a.this.dBF();
                }
            }
        };
        this.feedBackRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.q.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mDc = booleanValue;
                    a.this.mDo = booleanValue;
                    a.this.dBG();
                }
            }
        };
        this.memberCenterRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.q.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mDm = booleanValue;
                    a.this.mCZ = booleanValue;
                    a.this.dBG();
                }
            }
        };
        this.mDq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.q.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mCY = a.this.mHasNewVersion ? true : a.this.mCY;
                    a.this.dBG();
                }
            }
        };
        this.jzb = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.q.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dBI();
                        if (a.this.mDd) {
                            TiebaStatic.log(new ar("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).ak("obj_locate", 1));
                            a.this.mDd = false;
                        }
                    }
                }
            }
        };
        this.mDr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.q.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dBK();
                }
            }
        };
        this.syncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.q.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mDa = true;
                            a.this.mDn = true;
                            a.this.dBG();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dBC() {
        return C0832a.mDt;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mDp);
        MessageManager.getInstance().registerListener(this.mDq);
        MessageManager.getInstance().registerListener(this.mDr);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jzb);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dBD() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mCY = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jLH = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dBE() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mCY)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mDl = newsNotifyMessage.getMsgBookmark() > this.mDg;
            this.mDj = newsNotifyMessage.getMsgFans() > this.mDe;
            this.mDk = newsNotifyMessage.getMsgGiftNum() > this.mDf;
            this.mDg = newsNotifyMessage.getMsgBookmark();
            this.mDe = newsNotifyMessage.getMsgFans();
            this.mDf = newsNotifyMessage.getMsgGiftNum();
            if (this.mDl || this.mDj || this.mDk || this.mHasNewVersion) {
                this.mCU = this.mDj ? true : this.mCU;
                this.mCV = this.mDl ? true : this.mCV;
                this.mCW = this.mDk ? true : this.mCW;
                this.mCY = this.mHasNewVersion ? true : this.mCY;
                dBG();
            }
        }
    }

    public void dBF() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mDi);
    }

    public void wP(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBG() {
        SparseArray sparseArray = new SparseArray();
        if (this.mDi) {
            sparseArray.append(4, new b.a(this.mCX, this.mDh));
        }
        if (this.mDj) {
            sparseArray.append(2, new b.a(this.mCU, this.mDe));
        }
        if (this.mDk) {
            sparseArray.append(1, new b.a(this.mCW, this.mDf));
        }
        if (this.mDl) {
            sparseArray.append(3, new b.a(this.mCV, this.mDg));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mCY, 0));
        }
        if (this.mDm) {
            sparseArray.append(7, new b.a(this.mCZ, 0));
        }
        if (this.mDn) {
            sparseArray.append(9, new b.a(this.mDa, 0));
        }
        if (this.mDo) {
            sparseArray.append(10, new b.a(this.mDc, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dBH();
    }

    public void wQ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mCX, this.mDh));
            sparseArray.append(2, new b.a(this.mCU, this.mDe));
            sparseArray.append(1, new b.a(this.mCW, this.mDf));
            sparseArray.append(3, new b.a(this.mCV, this.mDg));
            sparseArray.append(5, new b.a(this.mCY, 0));
            sparseArray.append(7, new b.a(this.mCZ, 0));
            sparseArray.append(9, new b.a(this.mDa, 0));
            sparseArray.append(10, new b.a(this.mDc, 0));
            sparseArray.append(11, new b.a(this.mDd, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dBH() {
        if (((this.mDe > 0 && this.mDj) || (this.mDg > 0 && this.mDl) || this.mHasNewVersion || this.mDn || this.mDo) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mDo) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dBI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mCW = z;
                    break;
                case 2:
                    this.mCU = z;
                    break;
                case 3:
                    this.mCV = z;
                    break;
                case 4:
                    this.mCX = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mCY = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mCZ = z;
                    break;
                case 9:
                    this.mDa = z;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mDc = z;
                    break;
                case 11:
                    this.mDd = z;
                    break;
            }
            wQ(true);
            dBJ();
        }
    }

    private void dBJ() {
        boolean z = this.mCW || this.mCV || this.mCU || this.mCX || this.mCY || this.mCZ || this.mDa || this.mDd;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dBK() {
        this.mCU = false;
        this.mCV = false;
        this.mCW = false;
        this.mCX = false;
        this.mCY = false;
        this.mCZ = false;
        this.mDa = false;
        this.mDe = 0;
        this.mDf = 0;
        this.mDg = 0;
        this.mDh = 0;
        this.mDi = false;
        this.mHasNewVersion = false;
        this.mDj = false;
        this.mDk = false;
        this.mDl = false;
        this.mDm = false;
        this.mDn = false;
        dBD();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.q.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jLH) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dBE();
    }
}
