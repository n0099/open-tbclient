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
    private CustomMessageListener gZh;
    private boolean hhS;
    private boolean isPrimary;
    private boolean jOD;
    private boolean jOE;
    private boolean jOF;
    private boolean jOG;
    private boolean jOH;
    private boolean jOI;
    private boolean jOJ;
    private boolean jOK;
    private int jOL;
    private int jOM;
    private int jON;
    private int jOO;
    private boolean jOP;
    private boolean jOQ;
    private boolean jOR;
    private boolean jOS;
    private boolean jOT;
    private boolean jOU;
    private boolean jOV;
    CustomMessageListener jOW;
    private CustomMessageListener jOX;
    private CustomMessageListener jOY;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cDM() {
        return this.jOD;
    }

    public boolean cDN() {
        return this.jOE;
    }

    public boolean cDO() {
        return this.jOI;
    }

    public boolean cDP() {
        return this.jOJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0564a {
        private static final a jPa = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jOD = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        this.jOH = false;
        this.jOI = false;
        this.jOJ = false;
        this.jOK = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jOL = 0;
        this.jOM = 0;
        this.jON = 0;
        this.jOO = 0;
        this.jOP = false;
        this.mHasNewVersion = false;
        this.jOQ = false;
        this.jOR = false;
        this.jOS = false;
        this.jOT = false;
        this.jOU = false;
        this.jOV = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jOW = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jOO >= responseUnreadPointNum.getNum()) {
                        a.this.jOO = responseUnreadPointNum.getNum();
                        a.this.jOP = false;
                    } else {
                        a.this.jOP = true;
                        a.this.jOG = a.this.jOP ? true : a.this.jOG;
                        a.this.jOO = responseUnreadPointNum.getNum();
                        a.this.cDU();
                    }
                    a.this.cDT();
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
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jOK = booleanValue;
                    a.this.jOV = booleanValue;
                    a.this.cDU();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.jOT = booleanValue;
                    a.this.jOI = booleanValue;
                    a.this.cDU();
                }
            }
        };
        this.jOX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jOH = a.this.mHasNewVersion ? true : a.this.jOH;
                    a.this.cDU();
                }
            }
        };
        this.gZh = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cDW();
                    }
                }
            }
        };
        this.jOY = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cDY();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.jOJ = true;
                            a.this.jOU = true;
                            a.this.cDU();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cDQ() {
        return C0564a.jPa;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.jOW);
        MessageManager.getInstance().registerListener(this.jOX);
        MessageManager.getInstance().registerListener(this.jOY);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.gZh);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cDR() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jOH = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hhS = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cDS() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jOH)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jOS = newsNotifyMessage.getMsgBookmark() > this.jON;
            this.jOQ = newsNotifyMessage.getMsgFans() > this.jOL;
            this.jOR = newsNotifyMessage.getMsgGiftNum() > this.jOM;
            this.jON = newsNotifyMessage.getMsgBookmark();
            this.jOL = newsNotifyMessage.getMsgFans();
            this.jOM = newsNotifyMessage.getMsgGiftNum();
            if (this.jOS || this.jOQ || this.jOR || this.mHasNewVersion) {
                this.jOD = this.jOQ ? true : this.jOD;
                this.jOE = this.jOS ? true : this.jOE;
                this.jOF = this.jOR ? true : this.jOF;
                this.jOH = this.mHasNewVersion ? true : this.jOH;
                cDU();
            }
        }
    }

    public void cDT() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jOP);
    }

    public void si(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDU() {
        SparseArray sparseArray = new SparseArray();
        if (this.jOP) {
            sparseArray.append(4, new b.a(this.jOG, this.jOO));
        }
        if (this.jOQ) {
            sparseArray.append(2, new b.a(this.jOD, this.jOL));
        }
        if (this.jOR) {
            sparseArray.append(1, new b.a(this.jOF, this.jOM));
        }
        if (this.jOS) {
            sparseArray.append(3, new b.a(this.jOE, this.jON));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jOH, 0));
        }
        if (this.jOT) {
            sparseArray.append(7, new b.a(this.jOI, 0));
        }
        if (this.jOU) {
            sparseArray.append(9, new b.a(this.jOJ, 0));
        }
        if (this.jOV) {
            sparseArray.append(10, new b.a(this.jOK, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cDV();
    }

    public void sj(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jOG, this.jOO));
            sparseArray.append(2, new b.a(this.jOD, this.jOL));
            sparseArray.append(1, new b.a(this.jOF, this.jOM));
            sparseArray.append(3, new b.a(this.jOE, this.jON));
            sparseArray.append(5, new b.a(this.jOH, 0));
            sparseArray.append(7, new b.a(this.jOI, 0));
            sparseArray.append(9, new b.a(this.jOJ, 0));
            sparseArray.append(10, new b.a(this.jOK, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cDV() {
        if (((this.jOL > 0 && this.jOQ) || (this.jON > 0 && this.jOS) || this.mHasNewVersion || this.jOU || this.jOV) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jOV) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cDW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jOF = z;
                    break;
                case 2:
                    this.jOD = z;
                    break;
                case 3:
                    this.jOE = z;
                    break;
                case 4:
                    this.jOG = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jOH = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jOI = z;
                    break;
                case 9:
                    this.jOJ = z;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jOK = z;
                    break;
            }
            sj(true);
            cDX();
        }
    }

    private void cDX() {
        boolean z = this.jOF || this.jOE || this.jOD || this.jOG || this.jOH || this.jOI || this.jOJ;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cDY() {
        this.jOD = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        this.jOH = false;
        this.jOI = false;
        this.jOJ = false;
        this.jOL = 0;
        this.jOM = 0;
        this.jON = 0;
        this.jOO = 0;
        this.jOP = false;
        this.mHasNewVersion = false;
        this.jOQ = false;
        this.jOR = false;
        this.jOS = false;
        this.jOT = false;
        this.jOU = false;
        cDR();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hhS) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cDS();
    }
}
