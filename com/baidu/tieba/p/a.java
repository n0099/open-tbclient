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
    private CustomMessageListener iQV;
    private boolean isPrimary;
    private boolean jdz;
    private int lUA;
    private int lUB;
    private int lUC;
    private int lUD;
    private boolean lUE;
    private boolean lUF;
    private boolean lUG;
    private boolean lUH;
    private boolean lUI;
    private boolean lUJ;
    private boolean lUK;
    CustomMessageListener lUL;
    private CustomMessageListener lUM;
    private CustomMessageListener lUN;
    private boolean lUr;
    private boolean lUs;
    private boolean lUt;
    private boolean lUu;
    private boolean lUv;
    private boolean lUw;
    private boolean lUx;
    private boolean lUy;
    private boolean lUz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dsz() {
        return this.lUr;
    }

    public boolean dsA() {
        return this.lUs;
    }

    public boolean dsB() {
        return this.lUw;
    }

    public boolean dsC() {
        return this.lUx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0754a {
        private static final a lUP = new a();
    }

    private a() {
        this.isPrimary = false;
        this.lUr = false;
        this.lUs = false;
        this.lUt = false;
        this.lUu = false;
        this.lUv = false;
        this.lUw = false;
        this.lUx = false;
        this.lUy = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.lUz = false;
        this.lUA = 0;
        this.lUB = 0;
        this.lUC = 0;
        this.lUD = 0;
        this.lUE = false;
        this.mHasNewVersion = false;
        this.lUF = false;
        this.lUG = false;
        this.lUH = false;
        this.lUI = false;
        this.lUJ = false;
        this.lUK = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lUL = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.lUD >= responseUnreadPointNum.getNum()) {
                        a.this.lUD = responseUnreadPointNum.getNum();
                        a.this.lUE = false;
                    } else {
                        a.this.lUE = true;
                        a.this.lUu = a.this.lUE ? true : a.this.lUu;
                        a.this.lUD = responseUnreadPointNum.getNum();
                        a.this.dsH();
                    }
                    a.this.dsG();
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
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.lUy = booleanValue;
                    a.this.lUK = booleanValue;
                    a.this.dsH();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.lUI = booleanValue;
                    a.this.lUw = booleanValue;
                    a.this.dsH();
                }
            }
        };
        this.lUM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.lUv = a.this.mHasNewVersion ? true : a.this.lUv;
                    a.this.dsH();
                }
            }
        };
        this.iQV = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dsJ();
                        if (a.this.lUz) {
                            TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_locate", 1));
                            a.this.lUz = false;
                        }
                    }
                }
            }
        };
        this.lUN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dsL();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.lUx = true;
                            a.this.lUJ = true;
                            a.this.dsH();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dsD() {
        return C0754a.lUP;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lUL);
        MessageManager.getInstance().registerListener(this.lUM);
        MessageManager.getInstance().registerListener(this.lUN);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.iQV);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dsE() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.lUv = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jdz = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dsF() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.lUv)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lUH = newsNotifyMessage.getMsgBookmark() > this.lUC;
            this.lUF = newsNotifyMessage.getMsgFans() > this.lUA;
            this.lUG = newsNotifyMessage.getMsgGiftNum() > this.lUB;
            this.lUC = newsNotifyMessage.getMsgBookmark();
            this.lUA = newsNotifyMessage.getMsgFans();
            this.lUB = newsNotifyMessage.getMsgGiftNum();
            if (this.lUH || this.lUF || this.lUG || this.mHasNewVersion) {
                this.lUr = this.lUF ? true : this.lUr;
                this.lUs = this.lUH ? true : this.lUs;
                this.lUt = this.lUG ? true : this.lUt;
                this.lUv = this.mHasNewVersion ? true : this.lUv;
                dsH();
            }
        }
    }

    public void dsG() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.lUE);
    }

    public void vF(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsH() {
        SparseArray sparseArray = new SparseArray();
        if (this.lUE) {
            sparseArray.append(4, new b.a(this.lUu, this.lUD));
        }
        if (this.lUF) {
            sparseArray.append(2, new b.a(this.lUr, this.lUA));
        }
        if (this.lUG) {
            sparseArray.append(1, new b.a(this.lUt, this.lUB));
        }
        if (this.lUH) {
            sparseArray.append(3, new b.a(this.lUs, this.lUC));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.lUv, 0));
        }
        if (this.lUI) {
            sparseArray.append(7, new b.a(this.lUw, 0));
        }
        if (this.lUJ) {
            sparseArray.append(9, new b.a(this.lUx, 0));
        }
        if (this.lUK) {
            sparseArray.append(10, new b.a(this.lUy, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dsI();
    }

    public void vG(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.lUu, this.lUD));
            sparseArray.append(2, new b.a(this.lUr, this.lUA));
            sparseArray.append(1, new b.a(this.lUt, this.lUB));
            sparseArray.append(3, new b.a(this.lUs, this.lUC));
            sparseArray.append(5, new b.a(this.lUv, 0));
            sparseArray.append(7, new b.a(this.lUw, 0));
            sparseArray.append(9, new b.a(this.lUx, 0));
            sparseArray.append(10, new b.a(this.lUy, 0));
            sparseArray.append(11, new b.a(this.lUz, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dsI() {
        if (((this.lUA > 0 && this.lUF) || (this.lUC > 0 && this.lUH) || this.mHasNewVersion || this.lUJ || this.lUK) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.lUK) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dsJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.lUt = z;
                    break;
                case 2:
                    this.lUr = z;
                    break;
                case 3:
                    this.lUs = z;
                    break;
                case 4:
                    this.lUu = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.lUv = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.lUw = z;
                    break;
                case 9:
                    this.lUx = z;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.lUy = z;
                    break;
                case 11:
                    this.lUz = z;
                    break;
            }
            vG(true);
            dsK();
        }
    }

    private void dsK() {
        boolean z = this.lUt || this.lUs || this.lUr || this.lUu || this.lUv || this.lUw || this.lUx || this.lUz;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dsL() {
        this.lUr = false;
        this.lUs = false;
        this.lUt = false;
        this.lUu = false;
        this.lUv = false;
        this.lUw = false;
        this.lUx = false;
        this.lUA = 0;
        this.lUB = 0;
        this.lUC = 0;
        this.lUD = 0;
        this.lUE = false;
        this.mHasNewVersion = false;
        this.lUF = false;
        this.lUG = false;
        this.lUH = false;
        this.lUI = false;
        this.lUJ = false;
        dsE();
        e.mX().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jdz) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dsF();
    }
}
