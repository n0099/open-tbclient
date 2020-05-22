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
    private CustomMessageListener hYH;
    private boolean ihS;
    private boolean isPrimary;
    private boolean kRA;
    private boolean kRB;
    private boolean kRC;
    private boolean kRD;
    private boolean kRE;
    private boolean kRF;
    private boolean kRG;
    private int kRH;
    private int kRI;
    private int kRJ;
    private int kRK;
    private boolean kRL;
    private boolean kRM;
    private boolean kRN;
    private boolean kRO;
    private boolean kRP;
    private boolean kRQ;
    private boolean kRR;
    CustomMessageListener kRS;
    private CustomMessageListener kRT;
    private CustomMessageListener kRU;
    private boolean kRy;
    private boolean kRz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cVH() {
        return this.kRy;
    }

    public boolean cVI() {
        return this.kRz;
    }

    public boolean cVJ() {
        return this.kRD;
    }

    public boolean cVK() {
        return this.kRE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0677a {
        private static final a kRW = new a();
    }

    private a() {
        this.isPrimary = false;
        this.kRy = false;
        this.kRz = false;
        this.kRA = false;
        this.kRB = false;
        this.kRC = false;
        this.kRD = false;
        this.kRE = false;
        this.kRF = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.kRG = false;
        this.kRH = 0;
        this.kRI = 0;
        this.kRJ = 0;
        this.kRK = 0;
        this.kRL = false;
        this.mHasNewVersion = false;
        this.kRM = false;
        this.kRN = false;
        this.kRO = false;
        this.kRP = false;
        this.kRQ = false;
        this.kRR = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.kRS = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.kRK >= responseUnreadPointNum.getNum()) {
                        a.this.kRK = responseUnreadPointNum.getNum();
                        a.this.kRL = false;
                    } else {
                        a.this.kRL = true;
                        a.this.kRB = a.this.kRL ? true : a.this.kRB;
                        a.this.kRK = responseUnreadPointNum.getNum();
                        a.this.cVP();
                    }
                    a.this.cVO();
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
                    a.this.kRF = booleanValue;
                    a.this.kRR = booleanValue;
                    a.this.cVP();
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
                    a.this.kRP = booleanValue;
                    a.this.kRD = booleanValue;
                    a.this.cVP();
                }
            }
        };
        this.kRT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.kRC = a.this.mHasNewVersion ? true : a.this.kRC;
                    a.this.cVP();
                }
            }
        };
        this.hYH = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cVR();
                        if (a.this.kRG) {
                            TiebaStatic.log(new an("c13688").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_locate", 1));
                            a.this.kRG = false;
                        }
                    }
                }
            }
        };
        this.kRU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cVT();
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
                            a.this.kRE = true;
                            a.this.kRQ = true;
                            a.this.cVP();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cVL() {
        return C0677a.kRW;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.kRS);
        MessageManager.getInstance().registerListener(this.kRT);
        MessageManager.getInstance().registerListener(this.kRU);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.hYH);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cVM() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.kRC = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.ihS = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cVN() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.kRC)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.kRO = newsNotifyMessage.getMsgBookmark() > this.kRJ;
            this.kRM = newsNotifyMessage.getMsgFans() > this.kRH;
            this.kRN = newsNotifyMessage.getMsgGiftNum() > this.kRI;
            this.kRJ = newsNotifyMessage.getMsgBookmark();
            this.kRH = newsNotifyMessage.getMsgFans();
            this.kRI = newsNotifyMessage.getMsgGiftNum();
            if (this.kRO || this.kRM || this.kRN || this.mHasNewVersion) {
                this.kRy = this.kRM ? true : this.kRy;
                this.kRz = this.kRO ? true : this.kRz;
                this.kRA = this.kRN ? true : this.kRA;
                this.kRC = this.mHasNewVersion ? true : this.kRC;
                cVP();
            }
        }
    }

    public void cVO() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.kRL);
    }

    public void tN(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        SparseArray sparseArray = new SparseArray();
        if (this.kRL) {
            sparseArray.append(4, new b.a(this.kRB, this.kRK));
        }
        if (this.kRM) {
            sparseArray.append(2, new b.a(this.kRy, this.kRH));
        }
        if (this.kRN) {
            sparseArray.append(1, new b.a(this.kRA, this.kRI));
        }
        if (this.kRO) {
            sparseArray.append(3, new b.a(this.kRz, this.kRJ));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.kRC, 0));
        }
        if (this.kRP) {
            sparseArray.append(7, new b.a(this.kRD, 0));
        }
        if (this.kRQ) {
            sparseArray.append(9, new b.a(this.kRE, 0));
        }
        if (this.kRR) {
            sparseArray.append(10, new b.a(this.kRF, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cVQ();
    }

    public void tO(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.kRB, this.kRK));
            sparseArray.append(2, new b.a(this.kRy, this.kRH));
            sparseArray.append(1, new b.a(this.kRA, this.kRI));
            sparseArray.append(3, new b.a(this.kRz, this.kRJ));
            sparseArray.append(5, new b.a(this.kRC, 0));
            sparseArray.append(7, new b.a(this.kRD, 0));
            sparseArray.append(9, new b.a(this.kRE, 0));
            sparseArray.append(10, new b.a(this.kRF, 0));
            sparseArray.append(11, new b.a(this.kRG, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cVQ() {
        if (((this.kRH > 0 && this.kRM) || (this.kRJ > 0 && this.kRO) || this.mHasNewVersion || this.kRQ || this.kRR) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.kRR) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cVR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.kRA = z;
                    break;
                case 2:
                    this.kRy = z;
                    break;
                case 3:
                    this.kRz = z;
                    break;
                case 4:
                    this.kRB = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.kRC = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.kRD = z;
                    break;
                case 9:
                    this.kRE = z;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.kRF = z;
                    break;
                case 11:
                    this.kRG = z;
                    break;
            }
            tO(true);
            cVS();
        }
    }

    private void cVS() {
        boolean z = this.kRA || this.kRz || this.kRy || this.kRB || this.kRC || this.kRD || this.kRE || this.kRG;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cVT() {
        this.kRy = false;
        this.kRz = false;
        this.kRA = false;
        this.kRB = false;
        this.kRC = false;
        this.kRD = false;
        this.kRE = false;
        this.kRH = 0;
        this.kRI = 0;
        this.kRJ = 0;
        this.kRK = 0;
        this.kRL = false;
        this.mHasNewVersion = false;
        this.kRM = false;
        this.kRN = false;
        this.kRO = false;
        this.kRP = false;
        this.kRQ = false;
        cVM();
        e.ld().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ihS) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cVN();
    }
}
