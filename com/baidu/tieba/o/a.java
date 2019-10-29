package com.baidu.tieba.o;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.o.b;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener ggO;
    private boolean gpr;
    CustomMessageListener iQA;
    private CustomMessageListener iQB;
    private CustomMessageListener iQC;
    private CustomMessageListener iQD;
    private CustomMessageListener iQE;
    private CustomMessageListener iQF;
    private boolean iQg;
    private boolean iQh;
    private boolean iQi;
    private boolean iQj;
    private boolean iQk;
    private boolean iQl;
    private boolean iQm;
    private boolean iQn;
    private int iQo;
    private int iQp;
    private int iQq;
    private int iQr;
    private boolean iQs;
    private boolean iQt;
    private boolean iQu;
    private boolean iQv;
    private boolean iQw;
    private boolean iQx;
    private boolean iQy;
    private final CustomMessageListener iQz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0472a {
        private static final a iQH = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iQg = false;
        this.iQh = false;
        this.iQi = false;
        this.iQj = false;
        this.iQk = false;
        this.iQl = false;
        this.iQm = false;
        this.iQn = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.iQo = 0;
        this.iQp = 0;
        this.iQq = 0;
        this.iQr = 0;
        this.iQs = false;
        this.mHasNewVersion = false;
        this.iQt = false;
        this.iQu = false;
        this.iQv = false;
        this.iQw = false;
        this.iQx = false;
        this.iQy = false;
        this.iQz = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iQA = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iQr >= responseUnreadPointNum.getNum()) {
                        a.this.iQr = responseUnreadPointNum.getNum();
                        a.this.iQs = false;
                    } else {
                        a.this.iQs = true;
                        a.this.iQj = a.this.iQs ? true : a.this.iQj;
                        a.this.iQr = responseUnreadPointNum.getNum();
                        a.this.chh();
                    }
                    a.this.chg();
                }
            }
        };
        this.iQB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.iQn = booleanValue;
                    a.this.iQy = booleanValue;
                    a.this.chh();
                }
            }
        };
        this.iQC = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iQw = booleanValue;
                    a.this.iQl = booleanValue;
                    a.this.chh();
                }
            }
        };
        this.iQD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iQk = a.this.mHasNewVersion ? true : a.this.iQk;
                    a.this.chh();
                }
            }
        };
        this.ggO = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.chj();
                    }
                }
            }
        };
        this.iQE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.chl();
                }
            }
        };
        this.iQF = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.iQm = true;
                            a.this.iQx = true;
                            a.this.chh();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a chd() {
        return C0472a.iQH;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iQz);
        MessageManager.getInstance().registerListener(this.iQA);
        MessageManager.getInstance().registerListener(this.iQD);
        MessageManager.getInstance().registerListener(this.iQE);
        MessageManager.getInstance().registerListener(this.iQC);
        MessageManager.getInstance().registerListener(this.ggO);
        MessageManager.getInstance().registerListener(this.iQB);
        MessageManager.getInstance().registerListener(this.iQF);
    }

    private void che() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iQk = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.gpr = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void chf() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.iQk)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iQv = newsNotifyMessage.getMsgBookmark() > this.iQq;
            this.iQt = newsNotifyMessage.getMsgFans() > this.iQo;
            this.iQu = newsNotifyMessage.getMsgGiftNum() > this.iQp;
            this.iQq = newsNotifyMessage.getMsgBookmark();
            this.iQo = newsNotifyMessage.getMsgFans();
            this.iQp = newsNotifyMessage.getMsgGiftNum();
            if (this.iQv || this.iQt || this.iQu || this.mHasNewVersion) {
                this.iQg = this.iQt ? true : this.iQg;
                this.iQh = this.iQv ? true : this.iQh;
                this.iQi = this.iQu ? true : this.iQi;
                this.iQk = this.mHasNewVersion ? true : this.iQk;
                chh();
            }
        }
    }

    public void chg() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iQs);
    }

    public void qk(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chh() {
        SparseArray sparseArray = new SparseArray();
        if (this.iQs) {
            sparseArray.append(4, new b.a(this.iQj, this.iQr));
        }
        if (this.iQt) {
            sparseArray.append(2, new b.a(this.iQg, this.iQo));
        }
        if (this.iQu) {
            sparseArray.append(1, new b.a(this.iQi, this.iQp));
        }
        if (this.iQv) {
            sparseArray.append(3, new b.a(this.iQh, this.iQq));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iQk, 0));
        }
        if (this.iQw) {
            sparseArray.append(7, new b.a(this.iQl, 0));
        }
        if (this.iQx) {
            sparseArray.append(9, new b.a(this.iQm, 0));
        }
        if (this.iQy) {
            sparseArray.append(10, new b.a(this.iQn, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        chi();
    }

    public void ql(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iQj, this.iQr));
            sparseArray.append(2, new b.a(this.iQg, this.iQo));
            sparseArray.append(1, new b.a(this.iQi, this.iQp));
            sparseArray.append(3, new b.a(this.iQh, this.iQq));
            sparseArray.append(5, new b.a(this.iQk, 0));
            sparseArray.append(7, new b.a(this.iQl, 0));
            sparseArray.append(9, new b.a(this.iQm, 0));
            sparseArray.append(10, new b.a(this.iQn, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void chi() {
        if (((this.iQo > 0 && this.iQt) || (this.iQq > 0 && this.iQv) || this.mHasNewVersion || this.iQx || this.iQy) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iQy) {
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void chj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void e(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iQi = z;
                    break;
                case 2:
                    this.iQg = z;
                    break;
                case 3:
                    this.iQh = z;
                    break;
                case 4:
                    this.iQj = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.iQk = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iQl = z;
                    break;
                case 9:
                    this.iQm = z;
                    com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.iQn = z;
                    break;
            }
            ql(true);
            chk();
        }
    }

    private void chk() {
        boolean z = this.iQi || this.iQh || this.iQg || this.iQj || this.iQk || this.iQl || this.iQm;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void chl() {
        this.iQg = false;
        this.iQh = false;
        this.iQi = false;
        this.iQj = false;
        this.iQk = false;
        this.iQl = false;
        this.iQm = false;
        this.iQo = 0;
        this.iQp = 0;
        this.iQq = 0;
        this.iQr = 0;
        this.iQs = false;
        this.mHasNewVersion = false;
        this.iQt = false;
        this.iQu = false;
        this.iQv = false;
        this.iQw = false;
        this.iQx = false;
        che();
        e.fZ().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gpr) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        chf();
    }
}
