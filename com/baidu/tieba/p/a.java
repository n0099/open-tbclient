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
/* loaded from: classes2.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private CustomMessageListener iIo;
    private boolean iUN;
    private boolean isPrimary;
    private boolean lLA;
    private boolean lLB;
    private boolean lLC;
    private boolean lLD;
    CustomMessageListener lLE;
    private CustomMessageListener lLF;
    private CustomMessageListener lLG;
    private boolean lLk;
    private boolean lLl;
    private boolean lLm;
    private boolean lLn;
    private boolean lLo;
    private boolean lLp;
    private boolean lLq;
    private boolean lLr;
    private boolean lLs;
    private int lLt;
    private int lLu;
    private int lLv;
    private int lLw;
    private boolean lLx;
    private boolean lLy;
    private boolean lLz;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean doM() {
        return this.lLk;
    }

    public boolean doN() {
        return this.lLl;
    }

    public boolean doO() {
        return this.lLp;
    }

    public boolean doP() {
        return this.lLq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0757a {
        private static final a lLI = new a();
    }

    private a() {
        this.isPrimary = false;
        this.lLk = false;
        this.lLl = false;
        this.lLm = false;
        this.lLn = false;
        this.lLo = false;
        this.lLp = false;
        this.lLq = false;
        this.lLr = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.lLs = false;
        this.lLt = 0;
        this.lLu = 0;
        this.lLv = 0;
        this.lLw = 0;
        this.lLx = false;
        this.mHasNewVersion = false;
        this.lLy = false;
        this.lLz = false;
        this.lLA = false;
        this.lLB = false;
        this.lLC = false;
        this.lLD = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lLE = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.lLw >= responseUnreadPointNum.getNum()) {
                        a.this.lLw = responseUnreadPointNum.getNum();
                        a.this.lLx = false;
                    } else {
                        a.this.lLx = true;
                        a.this.lLn = a.this.lLx ? true : a.this.lLn;
                        a.this.lLw = responseUnreadPointNum.getNum();
                        a.this.doU();
                    }
                    a.this.doT();
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
                    a.this.lLr = booleanValue;
                    a.this.lLD = booleanValue;
                    a.this.doU();
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
                    a.this.lLB = booleanValue;
                    a.this.lLp = booleanValue;
                    a.this.doU();
                }
            }
        };
        this.lLF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.lLo = a.this.mHasNewVersion ? true : a.this.lLo;
                    a.this.doU();
                }
            }
        };
        this.iIo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.doW();
                        if (a.this.lLs) {
                            TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_locate", 1));
                            a.this.lLs = false;
                        }
                    }
                }
            }
        };
        this.lLG = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.doY();
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
                            a.this.lLq = true;
                            a.this.lLC = true;
                            a.this.doU();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a doQ() {
        return C0757a.lLI;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lLE);
        MessageManager.getInstance().registerListener(this.lLF);
        MessageManager.getInstance().registerListener(this.lLG);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.iIo);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void doR() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.lLo = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.iUN = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void doS() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.lLo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lLA = newsNotifyMessage.getMsgBookmark() > this.lLv;
            this.lLy = newsNotifyMessage.getMsgFans() > this.lLt;
            this.lLz = newsNotifyMessage.getMsgGiftNum() > this.lLu;
            this.lLv = newsNotifyMessage.getMsgBookmark();
            this.lLt = newsNotifyMessage.getMsgFans();
            this.lLu = newsNotifyMessage.getMsgGiftNum();
            if (this.lLA || this.lLy || this.lLz || this.mHasNewVersion) {
                this.lLk = this.lLy ? true : this.lLk;
                this.lLl = this.lLA ? true : this.lLl;
                this.lLm = this.lLz ? true : this.lLm;
                this.lLo = this.mHasNewVersion ? true : this.lLo;
                doU();
            }
        }
    }

    public void doT() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.lLx);
    }

    public void vv(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doU() {
        SparseArray sparseArray = new SparseArray();
        if (this.lLx) {
            sparseArray.append(4, new b.a(this.lLn, this.lLw));
        }
        if (this.lLy) {
            sparseArray.append(2, new b.a(this.lLk, this.lLt));
        }
        if (this.lLz) {
            sparseArray.append(1, new b.a(this.lLm, this.lLu));
        }
        if (this.lLA) {
            sparseArray.append(3, new b.a(this.lLl, this.lLv));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.lLo, 0));
        }
        if (this.lLB) {
            sparseArray.append(7, new b.a(this.lLp, 0));
        }
        if (this.lLC) {
            sparseArray.append(9, new b.a(this.lLq, 0));
        }
        if (this.lLD) {
            sparseArray.append(10, new b.a(this.lLr, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        doV();
    }

    public void vw(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.lLn, this.lLw));
            sparseArray.append(2, new b.a(this.lLk, this.lLt));
            sparseArray.append(1, new b.a(this.lLm, this.lLu));
            sparseArray.append(3, new b.a(this.lLl, this.lLv));
            sparseArray.append(5, new b.a(this.lLo, 0));
            sparseArray.append(7, new b.a(this.lLp, 0));
            sparseArray.append(9, new b.a(this.lLq, 0));
            sparseArray.append(10, new b.a(this.lLr, 0));
            sparseArray.append(11, new b.a(this.lLs, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void doV() {
        if (((this.lLt > 0 && this.lLy) || (this.lLv > 0 && this.lLA) || this.mHasNewVersion || this.lLC || this.lLD) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.lLD) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void doW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.lLm = z;
                    break;
                case 2:
                    this.lLk = z;
                    break;
                case 3:
                    this.lLl = z;
                    break;
                case 4:
                    this.lLn = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.lLo = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.lLp = z;
                    break;
                case 9:
                    this.lLq = z;
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.lLr = z;
                    break;
                case 11:
                    this.lLs = z;
                    break;
            }
            vw(true);
            doX();
        }
    }

    private void doX() {
        boolean z = this.lLm || this.lLl || this.lLk || this.lLn || this.lLo || this.lLp || this.lLq || this.lLs;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void doY() {
        this.lLk = false;
        this.lLl = false;
        this.lLm = false;
        this.lLn = false;
        this.lLo = false;
        this.lLp = false;
        this.lLq = false;
        this.lLt = 0;
        this.lLu = 0;
        this.lLv = 0;
        this.lLw = 0;
        this.lLx = false;
        this.mHasNewVersion = false;
        this.lLy = false;
        this.lLz = false;
        this.lLA = false;
        this.lLB = false;
        this.lLC = false;
        doR();
        e.mS().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iUN) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        doS();
    }
}
