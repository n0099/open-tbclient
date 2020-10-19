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
    private CustomMessageListener jfP;
    private boolean jsy;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private boolean mjY;
    private boolean mjZ;
    private boolean mka;
    private boolean mkb;
    private boolean mkc;
    private boolean mkd;
    private boolean mke;
    private boolean mkf;
    private boolean mkg;
    private int mkh;
    private int mki;
    private int mkj;
    private int mkk;
    private boolean mkl;
    private boolean mkm;
    private boolean mkn;
    private boolean mko;
    private boolean mkp;
    private boolean mkq;
    private boolean mkr;
    CustomMessageListener mks;
    private CustomMessageListener mkt;
    private CustomMessageListener mku;
    private CustomMessageListener syncFinishListener;

    public boolean dwk() {
        return this.mjY;
    }

    public boolean dwl() {
        return this.mjZ;
    }

    public boolean dwm() {
        return this.mkd;
    }

    public boolean dwn() {
        return this.mke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0772a {
        private static final a mkw = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mjY = false;
        this.mjZ = false;
        this.mka = false;
        this.mkb = false;
        this.mkc = false;
        this.mkd = false;
        this.mke = false;
        this.mkf = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mkg = false;
        this.mkh = 0;
        this.mki = 0;
        this.mkj = 0;
        this.mkk = 0;
        this.mkl = false;
        this.mHasNewVersion = false;
        this.mkm = false;
        this.mkn = false;
        this.mko = false;
        this.mkp = false;
        this.mkq = false;
        this.mkr = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mks = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mkk >= responseUnreadPointNum.getNum()) {
                        a.this.mkk = responseUnreadPointNum.getNum();
                        a.this.mkl = false;
                    } else {
                        a.this.mkl = true;
                        a.this.mkb = a.this.mkl ? true : a.this.mkb;
                        a.this.mkk = responseUnreadPointNum.getNum();
                        a.this.dws();
                    }
                    a.this.dwr();
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
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mkf = booleanValue;
                    a.this.mkr = booleanValue;
                    a.this.dws();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mkp = booleanValue;
                    a.this.mkd = booleanValue;
                    a.this.dws();
                }
            }
        };
        this.mkt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mkc = a.this.mHasNewVersion ? true : a.this.mkc;
                    a.this.dws();
                }
            }
        };
        this.jfP = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dwu();
                        if (a.this.mkg) {
                            TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_locate", 1));
                            a.this.mkg = false;
                        }
                    }
                }
            }
        };
        this.mku = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dww();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mke = true;
                            a.this.mkq = true;
                            a.this.dws();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dwo() {
        return C0772a.mkw;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mks);
        MessageManager.getInstance().registerListener(this.mkt);
        MessageManager.getInstance().registerListener(this.mku);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jfP);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dwp() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mkc = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.jsy = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dwq() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mkc)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mko = newsNotifyMessage.getMsgBookmark() > this.mkj;
            this.mkm = newsNotifyMessage.getMsgFans() > this.mkh;
            this.mkn = newsNotifyMessage.getMsgGiftNum() > this.mki;
            this.mkj = newsNotifyMessage.getMsgBookmark();
            this.mkh = newsNotifyMessage.getMsgFans();
            this.mki = newsNotifyMessage.getMsgGiftNum();
            if (this.mko || this.mkm || this.mkn || this.mHasNewVersion) {
                this.mjY = this.mkm ? true : this.mjY;
                this.mjZ = this.mko ? true : this.mjZ;
                this.mka = this.mkn ? true : this.mka;
                this.mkc = this.mHasNewVersion ? true : this.mkc;
                dws();
            }
        }
    }

    public void dwr() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mkl);
    }

    public void wm(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dws() {
        SparseArray sparseArray = new SparseArray();
        if (this.mkl) {
            sparseArray.append(4, new b.a(this.mkb, this.mkk));
        }
        if (this.mkm) {
            sparseArray.append(2, new b.a(this.mjY, this.mkh));
        }
        if (this.mkn) {
            sparseArray.append(1, new b.a(this.mka, this.mki));
        }
        if (this.mko) {
            sparseArray.append(3, new b.a(this.mjZ, this.mkj));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mkc, 0));
        }
        if (this.mkp) {
            sparseArray.append(7, new b.a(this.mkd, 0));
        }
        if (this.mkq) {
            sparseArray.append(9, new b.a(this.mke, 0));
        }
        if (this.mkr) {
            sparseArray.append(10, new b.a(this.mkf, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dwt();
    }

    public void wn(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mkb, this.mkk));
            sparseArray.append(2, new b.a(this.mjY, this.mkh));
            sparseArray.append(1, new b.a(this.mka, this.mki));
            sparseArray.append(3, new b.a(this.mjZ, this.mkj));
            sparseArray.append(5, new b.a(this.mkc, 0));
            sparseArray.append(7, new b.a(this.mkd, 0));
            sparseArray.append(9, new b.a(this.mke, 0));
            sparseArray.append(10, new b.a(this.mkf, 0));
            sparseArray.append(11, new b.a(this.mkg, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dwt() {
        if (((this.mkh > 0 && this.mkm) || (this.mkj > 0 && this.mko) || this.mHasNewVersion || this.mkq || this.mkr) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mkr) {
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dwu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mka = z;
                    break;
                case 2:
                    this.mjY = z;
                    break;
                case 3:
                    this.mjZ = z;
                    break;
                case 4:
                    this.mkb = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mkc = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mkd = z;
                    break;
                case 9:
                    this.mke = z;
                    com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mkf = z;
                    break;
                case 11:
                    this.mkg = z;
                    break;
            }
            wn(true);
            dwv();
        }
    }

    private void dwv() {
        boolean z = this.mka || this.mjZ || this.mjY || this.mkb || this.mkc || this.mkd || this.mke || this.mkg;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dww() {
        this.mjY = false;
        this.mjZ = false;
        this.mka = false;
        this.mkb = false;
        this.mkc = false;
        this.mkd = false;
        this.mke = false;
        this.mkh = 0;
        this.mki = 0;
        this.mkj = 0;
        this.mkk = 0;
        this.mkl = false;
        this.mHasNewVersion = false;
        this.mkm = false;
        this.mkn = false;
        this.mko = false;
        this.mkp = false;
        this.mkq = false;
        dwp();
        e.mY().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.jsy) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dwq();
    }
}
