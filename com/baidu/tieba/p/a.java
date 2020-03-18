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
    private CustomMessageListener hap;
    private boolean hjt;
    private boolean isPrimary;
    private CustomMessageListener jQA;
    private boolean jQf;
    private boolean jQg;
    private boolean jQh;
    private boolean jQi;
    private boolean jQj;
    private boolean jQk;
    private boolean jQl;
    private boolean jQm;
    private int jQn;
    private int jQo;
    private int jQp;
    private int jQq;
    private boolean jQr;
    private boolean jQs;
    private boolean jQt;
    private boolean jQu;
    private boolean jQv;
    private boolean jQw;
    private boolean jQx;
    CustomMessageListener jQy;
    private CustomMessageListener jQz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean cEg() {
        return this.jQf;
    }

    public boolean cEh() {
        return this.jQg;
    }

    public boolean cEi() {
        return this.jQk;
    }

    public boolean cEj() {
        return this.jQl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0565a {
        private static final a jQC = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jQf = false;
        this.jQg = false;
        this.jQh = false;
        this.jQi = false;
        this.jQj = false;
        this.jQk = false;
        this.jQl = false;
        this.jQm = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jQn = 0;
        this.jQo = 0;
        this.jQp = 0;
        this.jQq = 0;
        this.jQr = false;
        this.mHasNewVersion = false;
        this.jQs = false;
        this.jQt = false;
        this.jQu = false;
        this.jQv = false;
        this.jQw = false;
        this.jQx = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jQy = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jQq >= responseUnreadPointNum.getNum()) {
                        a.this.jQq = responseUnreadPointNum.getNum();
                        a.this.jQr = false;
                    } else {
                        a.this.jQr = true;
                        a.this.jQi = a.this.jQr ? true : a.this.jQi;
                        a.this.jQq = responseUnreadPointNum.getNum();
                        a.this.cEo();
                    }
                    a.this.cEn();
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
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jQm = booleanValue;
                    a.this.jQx = booleanValue;
                    a.this.cEo();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.jQv = booleanValue;
                    a.this.jQk = booleanValue;
                    a.this.cEo();
                }
            }
        };
        this.jQz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jQj = a.this.mHasNewVersion ? true : a.this.jQj;
                    a.this.cEo();
                }
            }
        };
        this.hap = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cEq();
                    }
                }
            }
        };
        this.jQA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cEs();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.jQl = true;
                            a.this.jQw = true;
                            a.this.cEo();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cEk() {
        return C0565a.jQC;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.jQy);
        MessageManager.getInstance().registerListener(this.jQz);
        MessageManager.getInstance().registerListener(this.jQA);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.hap);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void cEl() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jQj = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hjt = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cEm() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jQj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jQu = newsNotifyMessage.getMsgBookmark() > this.jQp;
            this.jQs = newsNotifyMessage.getMsgFans() > this.jQn;
            this.jQt = newsNotifyMessage.getMsgGiftNum() > this.jQo;
            this.jQp = newsNotifyMessage.getMsgBookmark();
            this.jQn = newsNotifyMessage.getMsgFans();
            this.jQo = newsNotifyMessage.getMsgGiftNum();
            if (this.jQu || this.jQs || this.jQt || this.mHasNewVersion) {
                this.jQf = this.jQs ? true : this.jQf;
                this.jQg = this.jQu ? true : this.jQg;
                this.jQh = this.jQt ? true : this.jQh;
                this.jQj = this.mHasNewVersion ? true : this.jQj;
                cEo();
            }
        }
    }

    public void cEn() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jQr);
    }

    public void so(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEo() {
        SparseArray sparseArray = new SparseArray();
        if (this.jQr) {
            sparseArray.append(4, new b.a(this.jQi, this.jQq));
        }
        if (this.jQs) {
            sparseArray.append(2, new b.a(this.jQf, this.jQn));
        }
        if (this.jQt) {
            sparseArray.append(1, new b.a(this.jQh, this.jQo));
        }
        if (this.jQu) {
            sparseArray.append(3, new b.a(this.jQg, this.jQp));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jQj, 0));
        }
        if (this.jQv) {
            sparseArray.append(7, new b.a(this.jQk, 0));
        }
        if (this.jQw) {
            sparseArray.append(9, new b.a(this.jQl, 0));
        }
        if (this.jQx) {
            sparseArray.append(10, new b.a(this.jQm, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cEp();
    }

    public void sp(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jQi, this.jQq));
            sparseArray.append(2, new b.a(this.jQf, this.jQn));
            sparseArray.append(1, new b.a(this.jQh, this.jQo));
            sparseArray.append(3, new b.a(this.jQg, this.jQp));
            sparseArray.append(5, new b.a(this.jQj, 0));
            sparseArray.append(7, new b.a(this.jQk, 0));
            sparseArray.append(9, new b.a(this.jQl, 0));
            sparseArray.append(10, new b.a(this.jQm, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cEp() {
        if (((this.jQn > 0 && this.jQs) || (this.jQp > 0 && this.jQu) || this.mHasNewVersion || this.jQw || this.jQx) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jQx) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cEq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jQh = z;
                    break;
                case 2:
                    this.jQf = z;
                    break;
                case 3:
                    this.jQg = z;
                    break;
                case 4:
                    this.jQi = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jQj = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jQk = z;
                    break;
                case 9:
                    this.jQl = z;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jQm = z;
                    break;
            }
            sp(true);
            cEr();
        }
    }

    private void cEr() {
        boolean z = this.jQh || this.jQg || this.jQf || this.jQi || this.jQj || this.jQk || this.jQl;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cEs() {
        this.jQf = false;
        this.jQg = false;
        this.jQh = false;
        this.jQi = false;
        this.jQj = false;
        this.jQk = false;
        this.jQl = false;
        this.jQn = 0;
        this.jQo = 0;
        this.jQp = 0;
        this.jQq = 0;
        this.jQr = false;
        this.mHasNewVersion = false;
        this.jQs = false;
        this.jQt = false;
        this.jQu = false;
        this.jQv = false;
        this.jQw = false;
        cEl();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hjt) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cEm();
    }
}
