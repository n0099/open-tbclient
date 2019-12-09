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
    private CustomMessageListener gfX;
    private boolean goA;
    private int iPA;
    private boolean iPB;
    private boolean iPC;
    private boolean iPD;
    private boolean iPE;
    private boolean iPF;
    private boolean iPG;
    private boolean iPH;
    private final CustomMessageListener iPI;
    CustomMessageListener iPJ;
    private CustomMessageListener iPK;
    private CustomMessageListener iPL;
    private CustomMessageListener iPM;
    private CustomMessageListener iPN;
    private CustomMessageListener iPO;
    private boolean iPp;
    private boolean iPq;
    private boolean iPr;
    private boolean iPs;
    private boolean iPt;
    private boolean iPu;
    private boolean iPv;
    private boolean iPw;
    private int iPx;
    private int iPy;
    private int iPz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0467a {
        private static final a iPQ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iPp = false;
        this.iPq = false;
        this.iPr = false;
        this.iPs = false;
        this.iPt = false;
        this.iPu = false;
        this.iPv = false;
        this.iPw = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.iPx = 0;
        this.iPy = 0;
        this.iPz = 0;
        this.iPA = 0;
        this.iPB = false;
        this.mHasNewVersion = false;
        this.iPC = false;
        this.iPD = false;
        this.iPE = false;
        this.iPF = false;
        this.iPG = false;
        this.iPH = false;
        this.iPI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iPJ = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iPA >= responseUnreadPointNum.getNum()) {
                        a.this.iPA = responseUnreadPointNum.getNum();
                        a.this.iPB = false;
                    } else {
                        a.this.iPB = true;
                        a.this.iPs = a.this.iPB ? true : a.this.iPs;
                        a.this.iPA = responseUnreadPointNum.getNum();
                        a.this.chf();
                    }
                    a.this.che();
                }
            }
        };
        this.iPK = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.iPw = booleanValue;
                    a.this.iPH = booleanValue;
                    a.this.chf();
                }
            }
        };
        this.iPL = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iPF = booleanValue;
                    a.this.iPu = booleanValue;
                    a.this.chf();
                }
            }
        };
        this.iPM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iPt = a.this.mHasNewVersion ? true : a.this.iPt;
                    a.this.chf();
                }
            }
        };
        this.gfX = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.chh();
                    }
                }
            }
        };
        this.iPN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.chj();
                }
            }
        };
        this.iPO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.iPv = true;
                            a.this.iPG = true;
                            a.this.chf();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a chb() {
        return C0467a.iPQ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iPI);
        MessageManager.getInstance().registerListener(this.iPJ);
        MessageManager.getInstance().registerListener(this.iPM);
        MessageManager.getInstance().registerListener(this.iPN);
        MessageManager.getInstance().registerListener(this.iPL);
        MessageManager.getInstance().registerListener(this.gfX);
        MessageManager.getInstance().registerListener(this.iPK);
        MessageManager.getInstance().registerListener(this.iPO);
    }

    private void chc() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iPt = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.goA = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void chd() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.iPt)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iPE = newsNotifyMessage.getMsgBookmark() > this.iPz;
            this.iPC = newsNotifyMessage.getMsgFans() > this.iPx;
            this.iPD = newsNotifyMessage.getMsgGiftNum() > this.iPy;
            this.iPz = newsNotifyMessage.getMsgBookmark();
            this.iPx = newsNotifyMessage.getMsgFans();
            this.iPy = newsNotifyMessage.getMsgGiftNum();
            if (this.iPE || this.iPC || this.iPD || this.mHasNewVersion) {
                this.iPp = this.iPC ? true : this.iPp;
                this.iPq = this.iPE ? true : this.iPq;
                this.iPr = this.iPD ? true : this.iPr;
                this.iPt = this.mHasNewVersion ? true : this.iPt;
                chf();
            }
        }
    }

    public void che() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iPB);
    }

    public void qk(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        SparseArray sparseArray = new SparseArray();
        if (this.iPB) {
            sparseArray.append(4, new b.a(this.iPs, this.iPA));
        }
        if (this.iPC) {
            sparseArray.append(2, new b.a(this.iPp, this.iPx));
        }
        if (this.iPD) {
            sparseArray.append(1, new b.a(this.iPr, this.iPy));
        }
        if (this.iPE) {
            sparseArray.append(3, new b.a(this.iPq, this.iPz));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iPt, 0));
        }
        if (this.iPF) {
            sparseArray.append(7, new b.a(this.iPu, 0));
        }
        if (this.iPG) {
            sparseArray.append(9, new b.a(this.iPv, 0));
        }
        if (this.iPH) {
            sparseArray.append(10, new b.a(this.iPw, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        chg();
    }

    public void ql(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iPs, this.iPA));
            sparseArray.append(2, new b.a(this.iPp, this.iPx));
            sparseArray.append(1, new b.a(this.iPr, this.iPy));
            sparseArray.append(3, new b.a(this.iPq, this.iPz));
            sparseArray.append(5, new b.a(this.iPt, 0));
            sparseArray.append(7, new b.a(this.iPu, 0));
            sparseArray.append(9, new b.a(this.iPv, 0));
            sparseArray.append(10, new b.a(this.iPw, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void chg() {
        if (((this.iPx > 0 && this.iPC) || (this.iPz > 0 && this.iPE) || this.mHasNewVersion || this.iPG || this.iPH) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iPH) {
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void chh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void e(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iPr = z;
                    break;
                case 2:
                    this.iPp = z;
                    break;
                case 3:
                    this.iPq = z;
                    break;
                case 4:
                    this.iPs = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.iPt = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iPu = z;
                    break;
                case 9:
                    this.iPv = z;
                    com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.iPw = z;
                    break;
            }
            ql(true);
            chi();
        }
    }

    private void chi() {
        boolean z = this.iPr || this.iPq || this.iPp || this.iPs || this.iPt || this.iPu || this.iPv;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void chj() {
        this.iPp = false;
        this.iPq = false;
        this.iPr = false;
        this.iPs = false;
        this.iPt = false;
        this.iPu = false;
        this.iPv = false;
        this.iPx = 0;
        this.iPy = 0;
        this.iPz = 0;
        this.iPA = 0;
        this.iPB = false;
        this.mHasNewVersion = false;
        this.iPC = false;
        this.iPD = false;
        this.iPE = false;
        this.iPF = false;
        this.iPG = false;
        chc();
        e.fZ().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.goA) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        chd();
    }
}
