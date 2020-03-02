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
    private CustomMessageListener gYV;
    private boolean hhG;
    private boolean isPrimary;
    private int jOA;
    private int jOB;
    private int jOC;
    private boolean jOD;
    private boolean jOE;
    private boolean jOF;
    private boolean jOG;
    private boolean jOH;
    private boolean jOI;
    private boolean jOJ;
    CustomMessageListener jOK;
    private CustomMessageListener jOL;
    private CustomMessageListener jOM;
    private boolean jOr;
    private boolean jOs;
    private boolean jOt;
    private boolean jOu;
    private boolean jOv;
    private boolean jOw;
    private boolean jOx;
    private boolean jOy;
    private int jOz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cDL() {
        return this.jOr;
    }

    public boolean cDM() {
        return this.jOs;
    }

    public boolean cDN() {
        return this.jOw;
    }

    public boolean cDO() {
        return this.jOx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0564a {
        private static final a jOO = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jOr = false;
        this.jOs = false;
        this.jOt = false;
        this.jOu = false;
        this.jOv = false;
        this.jOw = false;
        this.jOx = false;
        this.jOy = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jOz = 0;
        this.jOA = 0;
        this.jOB = 0;
        this.jOC = 0;
        this.jOD = false;
        this.mHasNewVersion = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        this.jOH = false;
        this.jOI = false;
        this.jOJ = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jOK = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jOC >= responseUnreadPointNum.getNum()) {
                        a.this.jOC = responseUnreadPointNum.getNum();
                        a.this.jOD = false;
                    } else {
                        a.this.jOD = true;
                        a.this.jOu = a.this.jOD ? true : a.this.jOu;
                        a.this.jOC = responseUnreadPointNum.getNum();
                        a.this.cDT();
                    }
                    a.this.cDS();
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
                    a.this.jOy = booleanValue;
                    a.this.jOJ = booleanValue;
                    a.this.cDT();
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
                    a.this.jOH = booleanValue;
                    a.this.jOw = booleanValue;
                    a.this.cDT();
                }
            }
        };
        this.jOL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jOv = a.this.mHasNewVersion ? true : a.this.jOv;
                    a.this.cDT();
                }
            }
        };
        this.gYV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cDV();
                    }
                }
            }
        };
        this.jOM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cDX();
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
                            a.this.jOx = true;
                            a.this.jOI = true;
                            a.this.cDT();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cDP() {
        return C0564a.jOO;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.jOK);
        MessageManager.getInstance().registerListener(this.jOL);
        MessageManager.getInstance().registerListener(this.jOM);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.gYV);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cDQ() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jOv = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hhG = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cDR() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jOv)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jOG = newsNotifyMessage.getMsgBookmark() > this.jOB;
            this.jOE = newsNotifyMessage.getMsgFans() > this.jOz;
            this.jOF = newsNotifyMessage.getMsgGiftNum() > this.jOA;
            this.jOB = newsNotifyMessage.getMsgBookmark();
            this.jOz = newsNotifyMessage.getMsgFans();
            this.jOA = newsNotifyMessage.getMsgGiftNum();
            if (this.jOG || this.jOE || this.jOF || this.mHasNewVersion) {
                this.jOr = this.jOE ? true : this.jOr;
                this.jOs = this.jOG ? true : this.jOs;
                this.jOt = this.jOF ? true : this.jOt;
                this.jOv = this.mHasNewVersion ? true : this.jOv;
                cDT();
            }
        }
    }

    public void cDS() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jOD);
    }

    public void si(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDT() {
        SparseArray sparseArray = new SparseArray();
        if (this.jOD) {
            sparseArray.append(4, new b.a(this.jOu, this.jOC));
        }
        if (this.jOE) {
            sparseArray.append(2, new b.a(this.jOr, this.jOz));
        }
        if (this.jOF) {
            sparseArray.append(1, new b.a(this.jOt, this.jOA));
        }
        if (this.jOG) {
            sparseArray.append(3, new b.a(this.jOs, this.jOB));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jOv, 0));
        }
        if (this.jOH) {
            sparseArray.append(7, new b.a(this.jOw, 0));
        }
        if (this.jOI) {
            sparseArray.append(9, new b.a(this.jOx, 0));
        }
        if (this.jOJ) {
            sparseArray.append(10, new b.a(this.jOy, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cDU();
    }

    public void sj(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jOu, this.jOC));
            sparseArray.append(2, new b.a(this.jOr, this.jOz));
            sparseArray.append(1, new b.a(this.jOt, this.jOA));
            sparseArray.append(3, new b.a(this.jOs, this.jOB));
            sparseArray.append(5, new b.a(this.jOv, 0));
            sparseArray.append(7, new b.a(this.jOw, 0));
            sparseArray.append(9, new b.a(this.jOx, 0));
            sparseArray.append(10, new b.a(this.jOy, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cDU() {
        if (((this.jOz > 0 && this.jOE) || (this.jOB > 0 && this.jOG) || this.mHasNewVersion || this.jOI || this.jOJ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jOJ) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cDV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jOt = z;
                    break;
                case 2:
                    this.jOr = z;
                    break;
                case 3:
                    this.jOs = z;
                    break;
                case 4:
                    this.jOu = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jOv = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jOw = z;
                    break;
                case 9:
                    this.jOx = z;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jOy = z;
                    break;
            }
            sj(true);
            cDW();
        }
    }

    private void cDW() {
        boolean z = this.jOt || this.jOs || this.jOr || this.jOu || this.jOv || this.jOw || this.jOx;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cDX() {
        this.jOr = false;
        this.jOs = false;
        this.jOt = false;
        this.jOu = false;
        this.jOv = false;
        this.jOw = false;
        this.jOx = false;
        this.jOz = 0;
        this.jOA = 0;
        this.jOB = 0;
        this.jOC = 0;
        this.jOD = false;
        this.mHasNewVersion = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        this.jOH = false;
        this.jOI = false;
        cDQ();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hhG) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cDR();
    }
}
