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
    private CustomMessageListener gYT;
    private boolean hhE;
    private boolean isPrimary;
    private int jOA;
    private boolean jOB;
    private boolean jOC;
    private boolean jOD;
    private boolean jOE;
    private boolean jOF;
    private boolean jOG;
    private boolean jOH;
    CustomMessageListener jOI;
    private CustomMessageListener jOJ;
    private CustomMessageListener jOK;
    private boolean jOp;
    private boolean jOq;
    private boolean jOr;
    private boolean jOs;
    private boolean jOt;
    private boolean jOu;
    private boolean jOv;
    private boolean jOw;
    private int jOx;
    private int jOy;
    private int jOz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cDJ() {
        return this.jOp;
    }

    public boolean cDK() {
        return this.jOq;
    }

    public boolean cDL() {
        return this.jOu;
    }

    public boolean cDM() {
        return this.jOv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0564a {
        private static final a jOM = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jOp = false;
        this.jOq = false;
        this.jOr = false;
        this.jOs = false;
        this.jOt = false;
        this.jOu = false;
        this.jOv = false;
        this.jOw = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jOx = 0;
        this.jOy = 0;
        this.jOz = 0;
        this.jOA = 0;
        this.jOB = false;
        this.mHasNewVersion = false;
        this.jOC = false;
        this.jOD = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        this.jOH = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jOI = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jOA >= responseUnreadPointNum.getNum()) {
                        a.this.jOA = responseUnreadPointNum.getNum();
                        a.this.jOB = false;
                    } else {
                        a.this.jOB = true;
                        a.this.jOs = a.this.jOB ? true : a.this.jOs;
                        a.this.jOA = responseUnreadPointNum.getNum();
                        a.this.cDR();
                    }
                    a.this.cDQ();
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
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jOw = booleanValue;
                    a.this.jOH = booleanValue;
                    a.this.cDR();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.jOF = booleanValue;
                    a.this.jOu = booleanValue;
                    a.this.cDR();
                }
            }
        };
        this.jOJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jOt = a.this.mHasNewVersion ? true : a.this.jOt;
                    a.this.cDR();
                }
            }
        };
        this.gYT = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cDT();
                    }
                }
            }
        };
        this.jOK = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cDV();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.jOv = true;
                            a.this.jOG = true;
                            a.this.cDR();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cDN() {
        return C0564a.jOM;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.jOI);
        MessageManager.getInstance().registerListener(this.jOJ);
        MessageManager.getInstance().registerListener(this.jOK);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.gYT);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cDO() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jOt = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hhE = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cDP() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jOt)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jOE = newsNotifyMessage.getMsgBookmark() > this.jOz;
            this.jOC = newsNotifyMessage.getMsgFans() > this.jOx;
            this.jOD = newsNotifyMessage.getMsgGiftNum() > this.jOy;
            this.jOz = newsNotifyMessage.getMsgBookmark();
            this.jOx = newsNotifyMessage.getMsgFans();
            this.jOy = newsNotifyMessage.getMsgGiftNum();
            if (this.jOE || this.jOC || this.jOD || this.mHasNewVersion) {
                this.jOp = this.jOC ? true : this.jOp;
                this.jOq = this.jOE ? true : this.jOq;
                this.jOr = this.jOD ? true : this.jOr;
                this.jOt = this.mHasNewVersion ? true : this.jOt;
                cDR();
            }
        }
    }

    public void cDQ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jOB);
    }

    public void si(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDR() {
        SparseArray sparseArray = new SparseArray();
        if (this.jOB) {
            sparseArray.append(4, new b.a(this.jOs, this.jOA));
        }
        if (this.jOC) {
            sparseArray.append(2, new b.a(this.jOp, this.jOx));
        }
        if (this.jOD) {
            sparseArray.append(1, new b.a(this.jOr, this.jOy));
        }
        if (this.jOE) {
            sparseArray.append(3, new b.a(this.jOq, this.jOz));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jOt, 0));
        }
        if (this.jOF) {
            sparseArray.append(7, new b.a(this.jOu, 0));
        }
        if (this.jOG) {
            sparseArray.append(9, new b.a(this.jOv, 0));
        }
        if (this.jOH) {
            sparseArray.append(10, new b.a(this.jOw, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cDS();
    }

    public void sj(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jOs, this.jOA));
            sparseArray.append(2, new b.a(this.jOp, this.jOx));
            sparseArray.append(1, new b.a(this.jOr, this.jOy));
            sparseArray.append(3, new b.a(this.jOq, this.jOz));
            sparseArray.append(5, new b.a(this.jOt, 0));
            sparseArray.append(7, new b.a(this.jOu, 0));
            sparseArray.append(9, new b.a(this.jOv, 0));
            sparseArray.append(10, new b.a(this.jOw, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cDS() {
        if (((this.jOx > 0 && this.jOC) || (this.jOz > 0 && this.jOE) || this.mHasNewVersion || this.jOG || this.jOH) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jOH) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cDT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jOr = z;
                    break;
                case 2:
                    this.jOp = z;
                    break;
                case 3:
                    this.jOq = z;
                    break;
                case 4:
                    this.jOs = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jOt = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jOu = z;
                    break;
                case 9:
                    this.jOv = z;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jOw = z;
                    break;
            }
            sj(true);
            cDU();
        }
    }

    private void cDU() {
        boolean z = this.jOr || this.jOq || this.jOp || this.jOs || this.jOt || this.jOu || this.jOv;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cDV() {
        this.jOp = false;
        this.jOq = false;
        this.jOr = false;
        this.jOs = false;
        this.jOt = false;
        this.jOu = false;
        this.jOv = false;
        this.jOx = 0;
        this.jOy = 0;
        this.jOz = 0;
        this.jOA = 0;
        this.jOB = false;
        this.mHasNewVersion = false;
        this.jOC = false;
        this.jOD = false;
        this.jOE = false;
        this.jOF = false;
        this.jOG = false;
        cDO();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hhE) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cDP();
    }
}
