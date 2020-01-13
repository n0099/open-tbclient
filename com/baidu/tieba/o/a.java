package com.baidu.tieba.o;

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
import com.baidu.tieba.o.b;
/* loaded from: classes7.dex */
public class a {
    private CustomMessageListener gWS;
    private boolean hfE;
    private boolean isPrimary;
    private boolean jNA;
    private boolean jNB;
    private boolean jNC;
    private final CustomMessageListener jND;
    CustomMessageListener jNE;
    private CustomMessageListener jNF;
    private CustomMessageListener jNG;
    private CustomMessageListener jNH;
    private CustomMessageListener jNI;
    private CustomMessageListener jNJ;
    private boolean jNk;
    private boolean jNl;
    private boolean jNm;
    private boolean jNn;
    private boolean jNo;
    private boolean jNp;
    private boolean jNq;
    private boolean jNr;
    private int jNs;
    private int jNt;
    private int jNu;
    private int jNv;
    private boolean jNw;
    private boolean jNx;
    private boolean jNy;
    private boolean jNz;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0557a {
        private static final a jNL = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jNk = false;
        this.jNl = false;
        this.jNm = false;
        this.jNn = false;
        this.jNo = false;
        this.jNp = false;
        this.jNq = false;
        this.jNr = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jNs = 0;
        this.jNt = 0;
        this.jNu = 0;
        this.jNv = 0;
        this.jNw = false;
        this.mHasNewVersion = false;
        this.jNx = false;
        this.jNy = false;
        this.jNz = false;
        this.jNA = false;
        this.jNB = false;
        this.jNC = false;
        this.jND = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jNE = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jNv >= responseUnreadPointNum.getNum()) {
                        a.this.jNv = responseUnreadPointNum.getNum();
                        a.this.jNw = false;
                    } else {
                        a.this.jNw = true;
                        a.this.jNn = a.this.jNw ? true : a.this.jNn;
                        a.this.jNv = responseUnreadPointNum.getNum();
                        a.this.cCo();
                    }
                    a.this.cCn();
                }
            }
        };
        this.jNF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jNr = booleanValue;
                    a.this.jNC = booleanValue;
                    a.this.cCo();
                }
            }
        };
        this.jNG = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.jNA = booleanValue;
                    a.this.jNp = booleanValue;
                    a.this.cCo();
                }
            }
        };
        this.jNH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jNo = a.this.mHasNewVersion ? true : a.this.jNo;
                    a.this.cCo();
                }
            }
        };
        this.gWS = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cCq();
                    }
                }
            }
        };
        this.jNI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cCs();
                }
            }
        };
        this.jNJ = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.jNq = true;
                            a.this.jNB = true;
                            a.this.cCo();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cCk() {
        return C0557a.jNL;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.jND);
        MessageManager.getInstance().registerListener(this.jNE);
        MessageManager.getInstance().registerListener(this.jNH);
        MessageManager.getInstance().registerListener(this.jNI);
        MessageManager.getInstance().registerListener(this.jNG);
        MessageManager.getInstance().registerListener(this.gWS);
        MessageManager.getInstance().registerListener(this.jNF);
        MessageManager.getInstance().registerListener(this.jNJ);
    }

    private void cCl() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jNo = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hfE = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cCm() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jNo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jNz = newsNotifyMessage.getMsgBookmark() > this.jNu;
            this.jNx = newsNotifyMessage.getMsgFans() > this.jNs;
            this.jNy = newsNotifyMessage.getMsgGiftNum() > this.jNt;
            this.jNu = newsNotifyMessage.getMsgBookmark();
            this.jNs = newsNotifyMessage.getMsgFans();
            this.jNt = newsNotifyMessage.getMsgGiftNum();
            if (this.jNz || this.jNx || this.jNy || this.mHasNewVersion) {
                this.jNk = this.jNx ? true : this.jNk;
                this.jNl = this.jNz ? true : this.jNl;
                this.jNm = this.jNy ? true : this.jNm;
                this.jNo = this.mHasNewVersion ? true : this.jNo;
                cCo();
            }
        }
    }

    public void cCn() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jNw);
    }

    public void sf(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCo() {
        SparseArray sparseArray = new SparseArray();
        if (this.jNw) {
            sparseArray.append(4, new b.a(this.jNn, this.jNv));
        }
        if (this.jNx) {
            sparseArray.append(2, new b.a(this.jNk, this.jNs));
        }
        if (this.jNy) {
            sparseArray.append(1, new b.a(this.jNm, this.jNt));
        }
        if (this.jNz) {
            sparseArray.append(3, new b.a(this.jNl, this.jNu));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jNo, 0));
        }
        if (this.jNA) {
            sparseArray.append(7, new b.a(this.jNp, 0));
        }
        if (this.jNB) {
            sparseArray.append(9, new b.a(this.jNq, 0));
        }
        if (this.jNC) {
            sparseArray.append(10, new b.a(this.jNr, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cCp();
    }

    public void sg(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jNn, this.jNv));
            sparseArray.append(2, new b.a(this.jNk, this.jNs));
            sparseArray.append(1, new b.a(this.jNm, this.jNt));
            sparseArray.append(3, new b.a(this.jNl, this.jNu));
            sparseArray.append(5, new b.a(this.jNo, 0));
            sparseArray.append(7, new b.a(this.jNp, 0));
            sparseArray.append(9, new b.a(this.jNq, 0));
            sparseArray.append(10, new b.a(this.jNr, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cCp() {
        if (((this.jNs > 0 && this.jNx) || (this.jNu > 0 && this.jNz) || this.mHasNewVersion || this.jNB || this.jNC) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jNC) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cCq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jNm = z;
                    break;
                case 2:
                    this.jNk = z;
                    break;
                case 3:
                    this.jNl = z;
                    break;
                case 4:
                    this.jNn = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jNo = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jNp = z;
                    break;
                case 9:
                    this.jNq = z;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jNr = z;
                    break;
            }
            sg(true);
            cCr();
        }
    }

    private void cCr() {
        boolean z = this.jNm || this.jNl || this.jNk || this.jNn || this.jNo || this.jNp || this.jNq;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cCs() {
        this.jNk = false;
        this.jNl = false;
        this.jNm = false;
        this.jNn = false;
        this.jNo = false;
        this.jNp = false;
        this.jNq = false;
        this.jNs = 0;
        this.jNt = 0;
        this.jNu = 0;
        this.jNv = 0;
        this.jNw = false;
        this.mHasNewVersion = false;
        this.jNx = false;
        this.jNy = false;
        this.jNz = false;
        this.jNA = false;
        this.jNB = false;
        cCl();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hfE) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cCm();
    }
}
