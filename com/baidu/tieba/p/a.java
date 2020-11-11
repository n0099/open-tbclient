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
    private boolean jKW;
    private CustomMessageListener jyk;
    private boolean mCA;
    private boolean mCB;
    private boolean mCC;
    private boolean mCD;
    private boolean mCE;
    private boolean mCF;
    private int mCG;
    private int mCH;
    private int mCI;
    private int mCJ;
    private boolean mCK;
    private boolean mCL;
    private boolean mCM;
    private boolean mCN;
    private boolean mCO;
    private boolean mCP;
    private boolean mCQ;
    CustomMessageListener mCR;
    private CustomMessageListener mCS;
    private CustomMessageListener mCT;
    private boolean mCx;
    private boolean mCy;
    private boolean mCz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dBU() {
        return this.mCx;
    }

    public boolean dBV() {
        return this.mCy;
    }

    public boolean dBW() {
        return this.mCC;
    }

    public boolean dBX() {
        return this.mCD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0802a {
        private static final a mCV = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mCx = false;
        this.mCy = false;
        this.mCz = false;
        this.mCA = false;
        this.mCB = false;
        this.mCC = false;
        this.mCD = false;
        this.mCE = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mCF = false;
        this.mCG = 0;
        this.mCH = 0;
        this.mCI = 0;
        this.mCJ = 0;
        this.mCK = false;
        this.mHasNewVersion = false;
        this.mCL = false;
        this.mCM = false;
        this.mCN = false;
        this.mCO = false;
        this.mCP = false;
        this.mCQ = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mCR = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mCJ >= responseUnreadPointNum.getNum()) {
                        a.this.mCJ = responseUnreadPointNum.getNum();
                        a.this.mCK = false;
                    } else {
                        a.this.mCK = true;
                        a.this.mCA = a.this.mCK ? true : a.this.mCA;
                        a.this.mCJ = responseUnreadPointNum.getNum();
                        a.this.dCc();
                    }
                    a.this.dCb();
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
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mCE = booleanValue;
                    a.this.mCQ = booleanValue;
                    a.this.dCc();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mCO = booleanValue;
                    a.this.mCC = booleanValue;
                    a.this.dCc();
                }
            }
        };
        this.mCS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mCB = a.this.mHasNewVersion ? true : a.this.mCB;
                    a.this.dCc();
                }
            }
        };
        this.jyk = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dCe();
                        if (a.this.mCF) {
                            TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_locate", 1));
                            a.this.mCF = false;
                        }
                    }
                }
            }
        };
        this.mCT = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dCg();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mCD = true;
                            a.this.mCP = true;
                            a.this.dCc();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dBY() {
        return C0802a.mCV;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mCR);
        MessageManager.getInstance().registerListener(this.mCS);
        MessageManager.getInstance().registerListener(this.mCT);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jyk);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dBZ() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mCB = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jKW = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dCa() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mCB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mCN = newsNotifyMessage.getMsgBookmark() > this.mCI;
            this.mCL = newsNotifyMessage.getMsgFans() > this.mCG;
            this.mCM = newsNotifyMessage.getMsgGiftNum() > this.mCH;
            this.mCI = newsNotifyMessage.getMsgBookmark();
            this.mCG = newsNotifyMessage.getMsgFans();
            this.mCH = newsNotifyMessage.getMsgGiftNum();
            if (this.mCN || this.mCL || this.mCM || this.mHasNewVersion) {
                this.mCx = this.mCL ? true : this.mCx;
                this.mCy = this.mCN ? true : this.mCy;
                this.mCz = this.mCM ? true : this.mCz;
                this.mCB = this.mHasNewVersion ? true : this.mCB;
                dCc();
            }
        }
    }

    public void dCb() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mCK);
    }

    public void wM(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCc() {
        SparseArray sparseArray = new SparseArray();
        if (this.mCK) {
            sparseArray.append(4, new b.a(this.mCA, this.mCJ));
        }
        if (this.mCL) {
            sparseArray.append(2, new b.a(this.mCx, this.mCG));
        }
        if (this.mCM) {
            sparseArray.append(1, new b.a(this.mCz, this.mCH));
        }
        if (this.mCN) {
            sparseArray.append(3, new b.a(this.mCy, this.mCI));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mCB, 0));
        }
        if (this.mCO) {
            sparseArray.append(7, new b.a(this.mCC, 0));
        }
        if (this.mCP) {
            sparseArray.append(9, new b.a(this.mCD, 0));
        }
        if (this.mCQ) {
            sparseArray.append(10, new b.a(this.mCE, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dCd();
    }

    public void wN(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mCA, this.mCJ));
            sparseArray.append(2, new b.a(this.mCx, this.mCG));
            sparseArray.append(1, new b.a(this.mCz, this.mCH));
            sparseArray.append(3, new b.a(this.mCy, this.mCI));
            sparseArray.append(5, new b.a(this.mCB, 0));
            sparseArray.append(7, new b.a(this.mCC, 0));
            sparseArray.append(9, new b.a(this.mCD, 0));
            sparseArray.append(10, new b.a(this.mCE, 0));
            sparseArray.append(11, new b.a(this.mCF, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dCd() {
        if (((this.mCG > 0 && this.mCL) || (this.mCI > 0 && this.mCN) || this.mHasNewVersion || this.mCP || this.mCQ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mCQ) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dCe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mCz = z;
                    break;
                case 2:
                    this.mCx = z;
                    break;
                case 3:
                    this.mCy = z;
                    break;
                case 4:
                    this.mCA = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mCB = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mCC = z;
                    break;
                case 9:
                    this.mCD = z;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mCE = z;
                    break;
                case 11:
                    this.mCF = z;
                    break;
            }
            wN(true);
            dCf();
        }
    }

    private void dCf() {
        boolean z = this.mCz || this.mCy || this.mCx || this.mCA || this.mCB || this.mCC || this.mCD || this.mCF;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dCg() {
        this.mCx = false;
        this.mCy = false;
        this.mCz = false;
        this.mCA = false;
        this.mCB = false;
        this.mCC = false;
        this.mCD = false;
        this.mCG = 0;
        this.mCH = 0;
        this.mCI = 0;
        this.mCJ = 0;
        this.mCK = false;
        this.mHasNewVersion = false;
        this.mCL = false;
        this.mCM = false;
        this.mCN = false;
        this.mCO = false;
        this.mCP = false;
        dBZ();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jKW) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dCa();
    }
}
