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
    private CustomMessageListener jMF;
    private boolean jZm;
    private boolean mHasNewVersion;
    private boolean mQX;
    private boolean mQY;
    private boolean mQZ;
    private boolean mRa;
    private boolean mRb;
    private boolean mRc;
    private boolean mRd;
    private boolean mRe;
    private boolean mRf;
    private int mRg;
    private int mRh;
    private int mRi;
    private int mRj;
    private boolean mRk;
    private boolean mRl;
    private boolean mRm;
    private boolean mRn;
    private boolean mRo;
    private boolean mRp;
    private boolean mRq;
    CustomMessageListener mRr;
    private CustomMessageListener mRs;
    private CustomMessageListener mRt;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dGK() {
        return this.mQX;
    }

    public boolean dGL() {
        return this.mQY;
    }

    public boolean dGM() {
        return this.mRc;
    }

    public boolean dGN() {
        return this.mRd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0848a {
        private static final a mRv = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mQX = false;
        this.mQY = false;
        this.mQZ = false;
        this.mRa = false;
        this.mRb = false;
        this.mRc = false;
        this.mRd = false;
        this.mRe = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mRf = false;
        this.mRg = 0;
        this.mRh = 0;
        this.mRi = 0;
        this.mRj = 0;
        this.mRk = false;
        this.mHasNewVersion = false;
        this.mRl = false;
        this.mRm = false;
        this.mRn = false;
        this.mRo = false;
        this.mRp = false;
        this.mRq = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.q.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mRr = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.q.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mRj >= responseUnreadPointNum.getNum()) {
                        a.this.mRj = responseUnreadPointNum.getNum();
                        a.this.mRk = false;
                    } else {
                        a.this.mRk = true;
                        a.this.mRa = a.this.mRk ? true : a.this.mRa;
                        a.this.mRj = responseUnreadPointNum.getNum();
                        a.this.dGS();
                    }
                    a.this.dGR();
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
                    a.this.mRe = booleanValue;
                    a.this.mRq = booleanValue;
                    a.this.dGS();
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
                    a.this.mRo = booleanValue;
                    a.this.mRc = booleanValue;
                    a.this.dGS();
                }
            }
        };
        this.mRs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.q.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mRb = a.this.mHasNewVersion ? true : a.this.mRb;
                    a.this.dGS();
                }
            }
        };
        this.jMF = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.q.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dGU();
                        if (a.this.mRf) {
                            TiebaStatic.log(new ar("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_locate", 1));
                            a.this.mRf = false;
                        }
                    }
                }
            }
        };
        this.mRt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.q.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dGW();
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
                            a.this.mRd = true;
                            a.this.mRp = true;
                            a.this.dGS();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dGO() {
        return C0848a.mRv;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mRr);
        MessageManager.getInstance().registerListener(this.mRs);
        MessageManager.getInstance().registerListener(this.mRt);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jMF);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dGP() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mRb = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jZm = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dGQ() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mRb)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mRn = newsNotifyMessage.getMsgBookmark() > this.mRi;
            this.mRl = newsNotifyMessage.getMsgFans() > this.mRg;
            this.mRm = newsNotifyMessage.getMsgGiftNum() > this.mRh;
            this.mRi = newsNotifyMessage.getMsgBookmark();
            this.mRg = newsNotifyMessage.getMsgFans();
            this.mRh = newsNotifyMessage.getMsgGiftNum();
            if (this.mRn || this.mRl || this.mRm || this.mHasNewVersion) {
                this.mQX = this.mRl ? true : this.mQX;
                this.mQY = this.mRn ? true : this.mQY;
                this.mQZ = this.mRm ? true : this.mQZ;
                this.mRb = this.mHasNewVersion ? true : this.mRb;
                dGS();
            }
        }
    }

    public void dGR() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mRk);
    }

    public void xt(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGS() {
        SparseArray sparseArray = new SparseArray();
        if (this.mRk) {
            sparseArray.append(4, new b.a(this.mRa, this.mRj));
        }
        if (this.mRl) {
            sparseArray.append(2, new b.a(this.mQX, this.mRg));
        }
        if (this.mRm) {
            sparseArray.append(1, new b.a(this.mQZ, this.mRh));
        }
        if (this.mRn) {
            sparseArray.append(3, new b.a(this.mQY, this.mRi));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mRb, 0));
        }
        if (this.mRo) {
            sparseArray.append(7, new b.a(this.mRc, 0));
        }
        if (this.mRp) {
            sparseArray.append(9, new b.a(this.mRd, 0));
        }
        if (this.mRq) {
            sparseArray.append(10, new b.a(this.mRe, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dGT();
    }

    public void xu(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mRa, this.mRj));
            sparseArray.append(2, new b.a(this.mQX, this.mRg));
            sparseArray.append(1, new b.a(this.mQZ, this.mRh));
            sparseArray.append(3, new b.a(this.mQY, this.mRi));
            sparseArray.append(5, new b.a(this.mRb, 0));
            sparseArray.append(7, new b.a(this.mRc, 0));
            sparseArray.append(9, new b.a(this.mRd, 0));
            sparseArray.append(10, new b.a(this.mRe, 0));
            sparseArray.append(11, new b.a(this.mRf, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dGT() {
        if (((this.mRg > 0 && this.mRl) || (this.mRi > 0 && this.mRn) || this.mHasNewVersion || this.mRp || this.mRq) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mRq) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dGU() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mQZ = z;
                    break;
                case 2:
                    this.mQX = z;
                    break;
                case 3:
                    this.mQY = z;
                    break;
                case 4:
                    this.mRa = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mRb = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mRc = z;
                    break;
                case 9:
                    this.mRd = z;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mRe = z;
                    break;
                case 11:
                    this.mRf = z;
                    break;
            }
            xu(true);
            dGV();
        }
    }

    private void dGV() {
        boolean z = this.mQZ || this.mQY || this.mQX || this.mRa || this.mRb || this.mRc || this.mRd || this.mRf;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dGW() {
        this.mQX = false;
        this.mQY = false;
        this.mQZ = false;
        this.mRa = false;
        this.mRb = false;
        this.mRc = false;
        this.mRd = false;
        this.mRg = 0;
        this.mRh = 0;
        this.mRi = 0;
        this.mRj = 0;
        this.mRk = false;
        this.mHasNewVersion = false;
        this.mRl = false;
        this.mRm = false;
        this.mRn = false;
        this.mRo = false;
        this.mRp = false;
        dGP();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.q.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jZm) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dGQ();
    }
}
