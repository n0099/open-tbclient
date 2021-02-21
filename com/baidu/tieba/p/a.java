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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private boolean isPrimary;
    private CustomMessageListener kdd;
    private boolean kqn;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private boolean nbI;
    private boolean nbJ;
    private boolean nbK;
    private boolean nbL;
    private boolean nbM;
    private boolean nbN;
    private boolean nbO;
    private boolean nbP;
    private boolean nbQ;
    private int nbR;
    private int nbS;
    private int nbT;
    private int nbU;
    private boolean nbV;
    private boolean nbW;
    private boolean nbX;
    private boolean nbY;
    private boolean nbZ;
    private boolean nca;
    private boolean ncb;
    CustomMessageListener ncc;
    private CustomMessageListener ncd;
    private CustomMessageListener nce;
    private CustomMessageListener syncFinishListener;

    public boolean dFa() {
        return this.nbI;
    }

    public boolean dFb() {
        return this.nbJ;
    }

    public boolean dFc() {
        return this.nbN;
    }

    public boolean dFd() {
        return this.nbO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0822a {
        private static final a ncg = new a();
    }

    private a() {
        this.isPrimary = false;
        this.nbI = false;
        this.nbJ = false;
        this.nbK = false;
        this.nbL = false;
        this.nbM = false;
        this.nbN = false;
        this.nbO = false;
        this.nbP = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.nbQ = false;
        this.nbR = 0;
        this.nbS = 0;
        this.nbT = 0;
        this.nbU = 0;
        this.nbV = false;
        this.mHasNewVersion = false;
        this.nbW = false;
        this.nbX = false;
        this.nbY = false;
        this.nbZ = false;
        this.nca = false;
        this.ncb = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.ncc = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.nbU >= responseUnreadPointNum.getNum()) {
                        a.this.nbU = responseUnreadPointNum.getNum();
                        a.this.nbV = false;
                    } else {
                        a.this.nbV = true;
                        a.this.nbL = a.this.nbV ? true : a.this.nbL;
                        a.this.nbU = responseUnreadPointNum.getNum();
                        a.this.dFi();
                    }
                    a.this.dFh();
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
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.nbP = booleanValue;
                    a.this.ncb = booleanValue;
                    a.this.dFi();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.nbZ = booleanValue;
                    a.this.nbN = booleanValue;
                    a.this.dFi();
                }
            }
        };
        this.ncd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.nbM = a.this.mHasNewVersion ? true : a.this.nbM;
                    a.this.dFi();
                }
            }
        };
        this.kdd = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dFk();
                        if (a.this.nbQ) {
                            TiebaStatic.log(new ar("c13688").v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_locate", 1));
                            a.this.nbQ = false;
                        }
                    }
                }
            }
        };
        this.nce = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dFm();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.nbO = true;
                            a.this.nca = true;
                            a.this.dFi();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dFe() {
        return C0822a.ncg;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.ncc);
        MessageManager.getInstance().registerListener(this.ncd);
        MessageManager.getInstance().registerListener(this.nce);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.kdd);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dFf() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.nbM = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.kqn = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dFg() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.nbM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.nbY = newsNotifyMessage.getMsgBookmark() > this.nbT;
            this.nbW = newsNotifyMessage.getMsgFans() > this.nbR;
            this.nbX = newsNotifyMessage.getMsgGiftNum() > this.nbS;
            this.nbT = newsNotifyMessage.getMsgBookmark();
            this.nbR = newsNotifyMessage.getMsgFans();
            this.nbS = newsNotifyMessage.getMsgGiftNum();
            if (this.nbY || this.nbW || this.nbX || this.mHasNewVersion) {
                this.nbI = this.nbW ? true : this.nbI;
                this.nbJ = this.nbY ? true : this.nbJ;
                this.nbK = this.nbX ? true : this.nbK;
                this.nbM = this.mHasNewVersion ? true : this.nbM;
                dFi();
            }
        }
    }

    public void dFh() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.nbV);
    }

    public void xJ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFi() {
        SparseArray sparseArray = new SparseArray();
        if (this.nbV) {
            sparseArray.append(4, new b.a(this.nbL, this.nbU));
        }
        if (this.nbW) {
            sparseArray.append(2, new b.a(this.nbI, this.nbR));
        }
        if (this.nbX) {
            sparseArray.append(1, new b.a(this.nbK, this.nbS));
        }
        if (this.nbY) {
            sparseArray.append(3, new b.a(this.nbJ, this.nbT));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.nbM, 0));
        }
        if (this.nbZ) {
            sparseArray.append(7, new b.a(this.nbN, 0));
        }
        if (this.nca) {
            sparseArray.append(9, new b.a(this.nbO, 0));
        }
        if (this.ncb) {
            sparseArray.append(10, new b.a(this.nbP, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dFj();
    }

    public void xK(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.nbL, this.nbU));
            sparseArray.append(2, new b.a(this.nbI, this.nbR));
            sparseArray.append(1, new b.a(this.nbK, this.nbS));
            sparseArray.append(3, new b.a(this.nbJ, this.nbT));
            sparseArray.append(5, new b.a(this.nbM, 0));
            sparseArray.append(7, new b.a(this.nbN, 0));
            sparseArray.append(9, new b.a(this.nbO, 0));
            sparseArray.append(10, new b.a(this.nbP, 0));
            sparseArray.append(11, new b.a(this.nbQ, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dFj() {
        if (((this.nbR > 0 && this.nbW) || (this.nbT > 0 && this.nbY) || this.mHasNewVersion || this.nca || this.ncb) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.ncb) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dFk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.nbK = z;
                    break;
                case 2:
                    this.nbI = z;
                    break;
                case 3:
                    this.nbJ = z;
                    break;
                case 4:
                    this.nbL = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.nbM = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.nbN = z;
                    break;
                case 9:
                    this.nbO = z;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.nbP = z;
                    break;
                case 11:
                    this.nbQ = z;
                    break;
            }
            xK(true);
            dFl();
        }
    }

    private void dFl() {
        boolean z = this.nbK || this.nbJ || this.nbI || this.nbL || this.nbM || this.nbN || this.nbO || this.nbQ;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dFm() {
        this.nbI = false;
        this.nbJ = false;
        this.nbK = false;
        this.nbL = false;
        this.nbM = false;
        this.nbN = false;
        this.nbO = false;
        this.nbR = 0;
        this.nbS = 0;
        this.nbT = 0;
        this.nbU = 0;
        this.nbV = false;
        this.mHasNewVersion = false;
        this.nbW = false;
        this.nbX = false;
        this.nbY = false;
        this.nbZ = false;
        this.nca = false;
        dFf();
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kqn) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dFg();
    }
}
