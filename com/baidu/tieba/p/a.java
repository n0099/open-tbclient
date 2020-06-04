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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private CustomMessageListener hZu;
    private boolean iiF;
    private boolean isPrimary;
    private boolean kSH;
    private boolean kSI;
    private boolean kSJ;
    private boolean kSK;
    private boolean kSL;
    private boolean kSM;
    private boolean kSN;
    private boolean kSO;
    private boolean kSP;
    private int kSQ;
    private int kSR;
    private int kSS;
    private int kST;
    private boolean kSU;
    private boolean kSV;
    private boolean kSW;
    private boolean kSX;
    private boolean kSY;
    private boolean kSZ;
    private boolean kTa;
    CustomMessageListener kTb;
    private CustomMessageListener kTc;
    private CustomMessageListener kTd;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cVX() {
        return this.kSH;
    }

    public boolean cVY() {
        return this.kSI;
    }

    public boolean cVZ() {
        return this.kSM;
    }

    public boolean cWa() {
        return this.kSN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0678a {
        private static final a kTf = new a();
    }

    private a() {
        this.isPrimary = false;
        this.kSH = false;
        this.kSI = false;
        this.kSJ = false;
        this.kSK = false;
        this.kSL = false;
        this.kSM = false;
        this.kSN = false;
        this.kSO = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.kSP = false;
        this.kSQ = 0;
        this.kSR = 0;
        this.kSS = 0;
        this.kST = 0;
        this.kSU = false;
        this.mHasNewVersion = false;
        this.kSV = false;
        this.kSW = false;
        this.kSX = false;
        this.kSY = false;
        this.kSZ = false;
        this.kTa = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.kTb = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.kST >= responseUnreadPointNum.getNum()) {
                        a.this.kST = responseUnreadPointNum.getNum();
                        a.this.kSU = false;
                    } else {
                        a.this.kSU = true;
                        a.this.kSK = a.this.kSU ? true : a.this.kSK;
                        a.this.kST = responseUnreadPointNum.getNum();
                        a.this.cWf();
                    }
                    a.this.cWe();
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
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.kSO = booleanValue;
                    a.this.kTa = booleanValue;
                    a.this.cWf();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.kSY = booleanValue;
                    a.this.kSM = booleanValue;
                    a.this.cWf();
                }
            }
        };
        this.kTc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.kSL = a.this.mHasNewVersion ? true : a.this.kSL;
                    a.this.cWf();
                }
            }
        };
        this.hZu = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cWh();
                        if (a.this.kSP) {
                            TiebaStatic.log(new an("c13688").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_locate", 1));
                            a.this.kSP = false;
                        }
                    }
                }
            }
        };
        this.kTd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cWj();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.kSN = true;
                            a.this.kSZ = true;
                            a.this.cWf();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cWb() {
        return C0678a.kTf;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.kTb);
        MessageManager.getInstance().registerListener(this.kTc);
        MessageManager.getInstance().registerListener(this.kTd);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.hZu);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cWc() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.kSL = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.iiF = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cWd() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.kSL)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.kSX = newsNotifyMessage.getMsgBookmark() > this.kSS;
            this.kSV = newsNotifyMessage.getMsgFans() > this.kSQ;
            this.kSW = newsNotifyMessage.getMsgGiftNum() > this.kSR;
            this.kSS = newsNotifyMessage.getMsgBookmark();
            this.kSQ = newsNotifyMessage.getMsgFans();
            this.kSR = newsNotifyMessage.getMsgGiftNum();
            if (this.kSX || this.kSV || this.kSW || this.mHasNewVersion) {
                this.kSH = this.kSV ? true : this.kSH;
                this.kSI = this.kSX ? true : this.kSI;
                this.kSJ = this.kSW ? true : this.kSJ;
                this.kSL = this.mHasNewVersion ? true : this.kSL;
                cWf();
            }
        }
    }

    public void cWe() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.kSU);
    }

    public void tN(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWf() {
        SparseArray sparseArray = new SparseArray();
        if (this.kSU) {
            sparseArray.append(4, new b.a(this.kSK, this.kST));
        }
        if (this.kSV) {
            sparseArray.append(2, new b.a(this.kSH, this.kSQ));
        }
        if (this.kSW) {
            sparseArray.append(1, new b.a(this.kSJ, this.kSR));
        }
        if (this.kSX) {
            sparseArray.append(3, new b.a(this.kSI, this.kSS));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.kSL, 0));
        }
        if (this.kSY) {
            sparseArray.append(7, new b.a(this.kSM, 0));
        }
        if (this.kSZ) {
            sparseArray.append(9, new b.a(this.kSN, 0));
        }
        if (this.kTa) {
            sparseArray.append(10, new b.a(this.kSO, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cWg();
    }

    public void tO(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.kSK, this.kST));
            sparseArray.append(2, new b.a(this.kSH, this.kSQ));
            sparseArray.append(1, new b.a(this.kSJ, this.kSR));
            sparseArray.append(3, new b.a(this.kSI, this.kSS));
            sparseArray.append(5, new b.a(this.kSL, 0));
            sparseArray.append(7, new b.a(this.kSM, 0));
            sparseArray.append(9, new b.a(this.kSN, 0));
            sparseArray.append(10, new b.a(this.kSO, 0));
            sparseArray.append(11, new b.a(this.kSP, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cWg() {
        if (((this.kSQ > 0 && this.kSV) || (this.kSS > 0 && this.kSX) || this.mHasNewVersion || this.kSZ || this.kTa) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.kTa) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cWh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.kSJ = z;
                    break;
                case 2:
                    this.kSH = z;
                    break;
                case 3:
                    this.kSI = z;
                    break;
                case 4:
                    this.kSK = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.kSL = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.kSM = z;
                    break;
                case 9:
                    this.kSN = z;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.kSO = z;
                    break;
                case 11:
                    this.kSP = z;
                    break;
            }
            tO(true);
            cWi();
        }
    }

    private void cWi() {
        boolean z = this.kSJ || this.kSI || this.kSH || this.kSK || this.kSL || this.kSM || this.kSN || this.kSP;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cWj() {
        this.kSH = false;
        this.kSI = false;
        this.kSJ = false;
        this.kSK = false;
        this.kSL = false;
        this.kSM = false;
        this.kSN = false;
        this.kSQ = 0;
        this.kSR = 0;
        this.kSS = 0;
        this.kST = 0;
        this.kSU = false;
        this.mHasNewVersion = false;
        this.kSV = false;
        this.kSW = false;
        this.kSX = false;
        this.kSY = false;
        this.kSZ = false;
        cWc();
        e.ld().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iiF) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cWd();
    }
}
