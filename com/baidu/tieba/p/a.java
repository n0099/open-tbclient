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
    private CustomMessageListener iIu;
    private boolean iUT;
    private boolean isPrimary;
    private boolean lLA;
    private boolean lLB;
    private boolean lLC;
    private boolean lLD;
    private boolean lLE;
    private boolean lLF;
    private int lLG;
    private int lLH;
    private int lLI;
    private int lLJ;
    private boolean lLK;
    private boolean lLL;
    private boolean lLM;
    private boolean lLN;
    private boolean lLO;
    private boolean lLP;
    private boolean lLQ;
    CustomMessageListener lLR;
    private CustomMessageListener lLS;
    private CustomMessageListener lLT;
    private boolean lLx;
    private boolean lLy;
    private boolean lLz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean doP() {
        return this.lLx;
    }

    public boolean doQ() {
        return this.lLy;
    }

    public boolean doR() {
        return this.lLC;
    }

    public boolean doS() {
        return this.lLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0757a {
        private static final a lLV = new a();
    }

    private a() {
        this.isPrimary = false;
        this.lLx = false;
        this.lLy = false;
        this.lLz = false;
        this.lLA = false;
        this.lLB = false;
        this.lLC = false;
        this.lLD = false;
        this.lLE = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.lLF = false;
        this.lLG = 0;
        this.lLH = 0;
        this.lLI = 0;
        this.lLJ = 0;
        this.lLK = false;
        this.mHasNewVersion = false;
        this.lLL = false;
        this.lLM = false;
        this.lLN = false;
        this.lLO = false;
        this.lLP = false;
        this.lLQ = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lLR = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.lLJ >= responseUnreadPointNum.getNum()) {
                        a.this.lLJ = responseUnreadPointNum.getNum();
                        a.this.lLK = false;
                    } else {
                        a.this.lLK = true;
                        a.this.lLA = a.this.lLK ? true : a.this.lLA;
                        a.this.lLJ = responseUnreadPointNum.getNum();
                        a.this.doX();
                    }
                    a.this.doW();
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
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.lLE = booleanValue;
                    a.this.lLQ = booleanValue;
                    a.this.doX();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.lLO = booleanValue;
                    a.this.lLC = booleanValue;
                    a.this.doX();
                }
            }
        };
        this.lLS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.lLB = a.this.mHasNewVersion ? true : a.this.lLB;
                    a.this.doX();
                }
            }
        };
        this.iIu = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.doZ();
                        if (a.this.lLF) {
                            TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_locate", 1));
                            a.this.lLF = false;
                        }
                    }
                }
            }
        };
        this.lLT = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dpb();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.lLD = true;
                            a.this.lLP = true;
                            a.this.doX();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a doT() {
        return C0757a.lLV;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lLR);
        MessageManager.getInstance().registerListener(this.lLS);
        MessageManager.getInstance().registerListener(this.lLT);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.iIu);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void doU() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.lLB = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.iUT = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void doV() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.lLB)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lLN = newsNotifyMessage.getMsgBookmark() > this.lLI;
            this.lLL = newsNotifyMessage.getMsgFans() > this.lLG;
            this.lLM = newsNotifyMessage.getMsgGiftNum() > this.lLH;
            this.lLI = newsNotifyMessage.getMsgBookmark();
            this.lLG = newsNotifyMessage.getMsgFans();
            this.lLH = newsNotifyMessage.getMsgGiftNum();
            if (this.lLN || this.lLL || this.lLM || this.mHasNewVersion) {
                this.lLx = this.lLL ? true : this.lLx;
                this.lLy = this.lLN ? true : this.lLy;
                this.lLz = this.lLM ? true : this.lLz;
                this.lLB = this.mHasNewVersion ? true : this.lLB;
                doX();
            }
        }
    }

    public void doW() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.lLK);
    }

    public void vx(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doX() {
        SparseArray sparseArray = new SparseArray();
        if (this.lLK) {
            sparseArray.append(4, new b.a(this.lLA, this.lLJ));
        }
        if (this.lLL) {
            sparseArray.append(2, new b.a(this.lLx, this.lLG));
        }
        if (this.lLM) {
            sparseArray.append(1, new b.a(this.lLz, this.lLH));
        }
        if (this.lLN) {
            sparseArray.append(3, new b.a(this.lLy, this.lLI));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.lLB, 0));
        }
        if (this.lLO) {
            sparseArray.append(7, new b.a(this.lLC, 0));
        }
        if (this.lLP) {
            sparseArray.append(9, new b.a(this.lLD, 0));
        }
        if (this.lLQ) {
            sparseArray.append(10, new b.a(this.lLE, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        doY();
    }

    public void vy(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.lLA, this.lLJ));
            sparseArray.append(2, new b.a(this.lLx, this.lLG));
            sparseArray.append(1, new b.a(this.lLz, this.lLH));
            sparseArray.append(3, new b.a(this.lLy, this.lLI));
            sparseArray.append(5, new b.a(this.lLB, 0));
            sparseArray.append(7, new b.a(this.lLC, 0));
            sparseArray.append(9, new b.a(this.lLD, 0));
            sparseArray.append(10, new b.a(this.lLE, 0));
            sparseArray.append(11, new b.a(this.lLF, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void doY() {
        if (((this.lLG > 0 && this.lLL) || (this.lLI > 0 && this.lLN) || this.mHasNewVersion || this.lLP || this.lLQ) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.lLQ) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void doZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.lLz = z;
                    break;
                case 2:
                    this.lLx = z;
                    break;
                case 3:
                    this.lLy = z;
                    break;
                case 4:
                    this.lLA = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.lLB = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.lLC = z;
                    break;
                case 9:
                    this.lLD = z;
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.lLE = z;
                    break;
                case 11:
                    this.lLF = z;
                    break;
            }
            vy(true);
            dpa();
        }
    }

    private void dpa() {
        boolean z = this.lLz || this.lLy || this.lLx || this.lLA || this.lLB || this.lLC || this.lLD || this.lLF;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dpb() {
        this.lLx = false;
        this.lLy = false;
        this.lLz = false;
        this.lLA = false;
        this.lLB = false;
        this.lLC = false;
        this.lLD = false;
        this.lLG = 0;
        this.lLH = 0;
        this.lLI = 0;
        this.lLJ = 0;
        this.lLK = false;
        this.mHasNewVersion = false;
        this.lLL = false;
        this.lLM = false;
        this.lLN = false;
        this.lLO = false;
        this.lLP = false;
        doU();
        e.mS().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iUT) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        doV();
    }
}
