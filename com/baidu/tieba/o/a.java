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
    private int jNA;
    private boolean jNB;
    private boolean jNC;
    private boolean jND;
    private boolean jNE;
    private boolean jNF;
    private boolean jNG;
    private boolean jNH;
    private final CustomMessageListener jNI;
    CustomMessageListener jNJ;
    private CustomMessageListener jNK;
    private CustomMessageListener jNL;
    private CustomMessageListener jNM;
    private CustomMessageListener jNN;
    private CustomMessageListener jNO;
    private boolean jNp;
    private boolean jNq;
    private boolean jNr;
    private boolean jNs;
    private boolean jNt;
    private boolean jNu;
    private boolean jNv;
    private boolean jNw;
    private int jNx;
    private int jNy;
    private int jNz;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0557a {
        private static final a jNQ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jNp = false;
        this.jNq = false;
        this.jNr = false;
        this.jNs = false;
        this.jNt = false;
        this.jNu = false;
        this.jNv = false;
        this.jNw = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jNx = 0;
        this.jNy = 0;
        this.jNz = 0;
        this.jNA = 0;
        this.jNB = false;
        this.mHasNewVersion = false;
        this.jNC = false;
        this.jND = false;
        this.jNE = false;
        this.jNF = false;
        this.jNG = false;
        this.jNH = false;
        this.jNI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jNJ = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jNA >= responseUnreadPointNum.getNum()) {
                        a.this.jNA = responseUnreadPointNum.getNum();
                        a.this.jNB = false;
                    } else {
                        a.this.jNB = true;
                        a.this.jNs = a.this.jNB ? true : a.this.jNs;
                        a.this.jNA = responseUnreadPointNum.getNum();
                        a.this.cCq();
                    }
                    a.this.cCp();
                }
            }
        };
        this.jNK = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jNw = booleanValue;
                    a.this.jNH = booleanValue;
                    a.this.cCq();
                }
            }
        };
        this.jNL = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.jNF = booleanValue;
                    a.this.jNu = booleanValue;
                    a.this.cCq();
                }
            }
        };
        this.jNM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jNt = a.this.mHasNewVersion ? true : a.this.jNt;
                    a.this.cCq();
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
                        a.this.cCs();
                    }
                }
            }
        };
        this.jNN = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cCu();
                }
            }
        };
        this.jNO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.o.a.8
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
                            a.this.jNv = true;
                            a.this.jNG = true;
                            a.this.cCq();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cCm() {
        return C0557a.jNQ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.jNI);
        MessageManager.getInstance().registerListener(this.jNJ);
        MessageManager.getInstance().registerListener(this.jNM);
        MessageManager.getInstance().registerListener(this.jNN);
        MessageManager.getInstance().registerListener(this.jNL);
        MessageManager.getInstance().registerListener(this.gWS);
        MessageManager.getInstance().registerListener(this.jNK);
        MessageManager.getInstance().registerListener(this.jNO);
    }

    private void cCn() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jNt = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hfE = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cCo() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jNt)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jNE = newsNotifyMessage.getMsgBookmark() > this.jNz;
            this.jNC = newsNotifyMessage.getMsgFans() > this.jNx;
            this.jND = newsNotifyMessage.getMsgGiftNum() > this.jNy;
            this.jNz = newsNotifyMessage.getMsgBookmark();
            this.jNx = newsNotifyMessage.getMsgFans();
            this.jNy = newsNotifyMessage.getMsgGiftNum();
            if (this.jNE || this.jNC || this.jND || this.mHasNewVersion) {
                this.jNp = this.jNC ? true : this.jNp;
                this.jNq = this.jNE ? true : this.jNq;
                this.jNr = this.jND ? true : this.jNr;
                this.jNt = this.mHasNewVersion ? true : this.jNt;
                cCq();
            }
        }
    }

    public void cCp() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jNB);
    }

    public void sf(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        SparseArray sparseArray = new SparseArray();
        if (this.jNB) {
            sparseArray.append(4, new b.a(this.jNs, this.jNA));
        }
        if (this.jNC) {
            sparseArray.append(2, new b.a(this.jNp, this.jNx));
        }
        if (this.jND) {
            sparseArray.append(1, new b.a(this.jNr, this.jNy));
        }
        if (this.jNE) {
            sparseArray.append(3, new b.a(this.jNq, this.jNz));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jNt, 0));
        }
        if (this.jNF) {
            sparseArray.append(7, new b.a(this.jNu, 0));
        }
        if (this.jNG) {
            sparseArray.append(9, new b.a(this.jNv, 0));
        }
        if (this.jNH) {
            sparseArray.append(10, new b.a(this.jNw, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cCr();
    }

    public void sg(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jNs, this.jNA));
            sparseArray.append(2, new b.a(this.jNp, this.jNx));
            sparseArray.append(1, new b.a(this.jNr, this.jNy));
            sparseArray.append(3, new b.a(this.jNq, this.jNz));
            sparseArray.append(5, new b.a(this.jNt, 0));
            sparseArray.append(7, new b.a(this.jNu, 0));
            sparseArray.append(9, new b.a(this.jNv, 0));
            sparseArray.append(10, new b.a(this.jNw, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cCr() {
        if (((this.jNx > 0 && this.jNC) || (this.jNz > 0 && this.jNE) || this.mHasNewVersion || this.jNG || this.jNH) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jNH) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cCs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jNr = z;
                    break;
                case 2:
                    this.jNp = z;
                    break;
                case 3:
                    this.jNq = z;
                    break;
                case 4:
                    this.jNs = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jNt = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jNu = z;
                    break;
                case 9:
                    this.jNv = z;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jNw = z;
                    break;
            }
            sg(true);
            cCt();
        }
    }

    private void cCt() {
        boolean z = this.jNr || this.jNq || this.jNp || this.jNs || this.jNt || this.jNu || this.jNv;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cCu() {
        this.jNp = false;
        this.jNq = false;
        this.jNr = false;
        this.jNs = false;
        this.jNt = false;
        this.jNu = false;
        this.jNv = false;
        this.jNx = 0;
        this.jNy = 0;
        this.jNz = 0;
        this.jNA = 0;
        this.jNB = false;
        this.mHasNewVersion = false;
        this.jNC = false;
        this.jND = false;
        this.jNE = false;
        this.jNF = false;
        this.jNG = false;
        cCn();
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hfE) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cCo();
    }
}
