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
    private CustomMessageListener jMD;
    private boolean jZk;
    private boolean mHasNewVersion;
    private boolean mQV;
    private boolean mQW;
    private boolean mQX;
    private boolean mQY;
    private boolean mQZ;
    private boolean mRa;
    private boolean mRb;
    private boolean mRc;
    private boolean mRd;
    private int mRe;
    private int mRf;
    private int mRg;
    private int mRh;
    private boolean mRi;
    private boolean mRj;
    private boolean mRk;
    private boolean mRl;
    private boolean mRm;
    private boolean mRn;
    private boolean mRo;
    CustomMessageListener mRp;
    private CustomMessageListener mRq;
    private CustomMessageListener mRr;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dGJ() {
        return this.mQV;
    }

    public boolean dGK() {
        return this.mQW;
    }

    public boolean dGL() {
        return this.mRa;
    }

    public boolean dGM() {
        return this.mRb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0848a {
        private static final a mRt = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mQV = false;
        this.mQW = false;
        this.mQX = false;
        this.mQY = false;
        this.mQZ = false;
        this.mRa = false;
        this.mRb = false;
        this.mRc = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mRd = false;
        this.mRe = 0;
        this.mRf = 0;
        this.mRg = 0;
        this.mRh = 0;
        this.mRi = false;
        this.mHasNewVersion = false;
        this.mRj = false;
        this.mRk = false;
        this.mRl = false;
        this.mRm = false;
        this.mRn = false;
        this.mRo = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.q.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mRp = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.q.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mRh >= responseUnreadPointNum.getNum()) {
                        a.this.mRh = responseUnreadPointNum.getNum();
                        a.this.mRi = false;
                    } else {
                        a.this.mRi = true;
                        a.this.mQY = a.this.mRi ? true : a.this.mQY;
                        a.this.mRh = responseUnreadPointNum.getNum();
                        a.this.dGR();
                    }
                    a.this.dGQ();
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
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mRc = booleanValue;
                    a.this.mRo = booleanValue;
                    a.this.dGR();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mRm = booleanValue;
                    a.this.mRa = booleanValue;
                    a.this.dGR();
                }
            }
        };
        this.mRq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.q.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mQZ = a.this.mHasNewVersion ? true : a.this.mQZ;
                    a.this.dGR();
                }
            }
        };
        this.jMD = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.q.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dGT();
                        if (a.this.mRd) {
                            TiebaStatic.log(new ar("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_locate", 1));
                            a.this.mRd = false;
                        }
                    }
                }
            }
        };
        this.mRr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.q.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dGV();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mRb = true;
                            a.this.mRn = true;
                            a.this.dGR();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dGN() {
        return C0848a.mRt;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mRp);
        MessageManager.getInstance().registerListener(this.mRq);
        MessageManager.getInstance().registerListener(this.mRr);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jMD);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dGO() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mQZ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jZk = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dGP() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mQZ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mRl = newsNotifyMessage.getMsgBookmark() > this.mRg;
            this.mRj = newsNotifyMessage.getMsgFans() > this.mRe;
            this.mRk = newsNotifyMessage.getMsgGiftNum() > this.mRf;
            this.mRg = newsNotifyMessage.getMsgBookmark();
            this.mRe = newsNotifyMessage.getMsgFans();
            this.mRf = newsNotifyMessage.getMsgGiftNum();
            if (this.mRl || this.mRj || this.mRk || this.mHasNewVersion) {
                this.mQV = this.mRj ? true : this.mQV;
                this.mQW = this.mRl ? true : this.mQW;
                this.mQX = this.mRk ? true : this.mQX;
                this.mQZ = this.mHasNewVersion ? true : this.mQZ;
                dGR();
            }
        }
    }

    public void dGQ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mRi);
    }

    public void xt(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGR() {
        SparseArray sparseArray = new SparseArray();
        if (this.mRi) {
            sparseArray.append(4, new b.a(this.mQY, this.mRh));
        }
        if (this.mRj) {
            sparseArray.append(2, new b.a(this.mQV, this.mRe));
        }
        if (this.mRk) {
            sparseArray.append(1, new b.a(this.mQX, this.mRf));
        }
        if (this.mRl) {
            sparseArray.append(3, new b.a(this.mQW, this.mRg));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mQZ, 0));
        }
        if (this.mRm) {
            sparseArray.append(7, new b.a(this.mRa, 0));
        }
        if (this.mRn) {
            sparseArray.append(9, new b.a(this.mRb, 0));
        }
        if (this.mRo) {
            sparseArray.append(10, new b.a(this.mRc, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dGS();
    }

    public void xu(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mQY, this.mRh));
            sparseArray.append(2, new b.a(this.mQV, this.mRe));
            sparseArray.append(1, new b.a(this.mQX, this.mRf));
            sparseArray.append(3, new b.a(this.mQW, this.mRg));
            sparseArray.append(5, new b.a(this.mQZ, 0));
            sparseArray.append(7, new b.a(this.mRa, 0));
            sparseArray.append(9, new b.a(this.mRb, 0));
            sparseArray.append(10, new b.a(this.mRc, 0));
            sparseArray.append(11, new b.a(this.mRd, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dGS() {
        if (((this.mRe > 0 && this.mRj) || (this.mRg > 0 && this.mRl) || this.mHasNewVersion || this.mRn || this.mRo) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mRo) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dGT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mQX = z;
                    break;
                case 2:
                    this.mQV = z;
                    break;
                case 3:
                    this.mQW = z;
                    break;
                case 4:
                    this.mQY = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mQZ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mRa = z;
                    break;
                case 9:
                    this.mRb = z;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mRc = z;
                    break;
                case 11:
                    this.mRd = z;
                    break;
            }
            xu(true);
            dGU();
        }
    }

    private void dGU() {
        boolean z = this.mQX || this.mQW || this.mQV || this.mQY || this.mQZ || this.mRa || this.mRb || this.mRd;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dGV() {
        this.mQV = false;
        this.mQW = false;
        this.mQX = false;
        this.mQY = false;
        this.mQZ = false;
        this.mRa = false;
        this.mRb = false;
        this.mRe = 0;
        this.mRf = 0;
        this.mRg = 0;
        this.mRh = 0;
        this.mRi = false;
        this.mHasNewVersion = false;
        this.mRj = false;
        this.mRk = false;
        this.mRl = false;
        this.mRm = false;
        this.mRn = false;
        dGO();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.q.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jZk) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dGP();
    }
}
