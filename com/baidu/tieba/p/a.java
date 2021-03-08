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
    private CustomMessageListener kfg;
    private boolean ksp;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private boolean ndM;
    private boolean ndN;
    private boolean ndO;
    private boolean ndP;
    private boolean ndQ;
    private boolean ndR;
    private boolean ndS;
    private boolean ndT;
    private boolean ndU;
    private int ndV;
    private int ndW;
    private int ndX;
    private int ndY;
    private boolean ndZ;
    private boolean nea;
    private boolean neb;
    private boolean nec;
    private boolean ned;
    private boolean nee;
    private boolean nef;
    CustomMessageListener neg;
    private CustomMessageListener neh;
    private CustomMessageListener nei;
    private CustomMessageListener syncFinishListener;

    public boolean dFi() {
        return this.ndM;
    }

    public boolean dFj() {
        return this.ndN;
    }

    public boolean dFk() {
        return this.ndR;
    }

    public boolean dFl() {
        return this.ndS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0828a {
        private static final a nek = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ndM = false;
        this.ndN = false;
        this.ndO = false;
        this.ndP = false;
        this.ndQ = false;
        this.ndR = false;
        this.ndS = false;
        this.ndT = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.ndU = false;
        this.ndV = 0;
        this.ndW = 0;
        this.ndX = 0;
        this.ndY = 0;
        this.ndZ = false;
        this.mHasNewVersion = false;
        this.nea = false;
        this.neb = false;
        this.nec = false;
        this.ned = false;
        this.nee = false;
        this.nef = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.neg = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.ndY >= responseUnreadPointNum.getNum()) {
                        a.this.ndY = responseUnreadPointNum.getNum();
                        a.this.ndZ = false;
                    } else {
                        a.this.ndZ = true;
                        a.this.ndP = a.this.ndZ ? true : a.this.ndP;
                        a.this.ndY = responseUnreadPointNum.getNum();
                        a.this.dFq();
                    }
                    a.this.dFp();
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
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.ndT = booleanValue;
                    a.this.nef = booleanValue;
                    a.this.dFq();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.ned = booleanValue;
                    a.this.ndR = booleanValue;
                    a.this.dFq();
                }
            }
        };
        this.neh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ndQ = a.this.mHasNewVersion ? true : a.this.ndQ;
                    a.this.dFq();
                }
            }
        };
        this.kfg = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dFs();
                        if (a.this.ndU) {
                            TiebaStatic.log(new ar("c13688").v("uid", TbadkCoreApplication.getCurrentAccountId()).aq("obj_locate", 1));
                            a.this.ndU = false;
                        }
                    }
                }
            }
        };
        this.nei = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dFu();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.ndS = true;
                            a.this.nee = true;
                            a.this.dFq();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dFm() {
        return C0828a.nek;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.neg);
        MessageManager.getInstance().registerListener(this.neh);
        MessageManager.getInstance().registerListener(this.nei);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.kfg);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dFn() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ndQ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.ksp = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dFo() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.ndQ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.nec = newsNotifyMessage.getMsgBookmark() > this.ndX;
            this.nea = newsNotifyMessage.getMsgFans() > this.ndV;
            this.neb = newsNotifyMessage.getMsgGiftNum() > this.ndW;
            this.ndX = newsNotifyMessage.getMsgBookmark();
            this.ndV = newsNotifyMessage.getMsgFans();
            this.ndW = newsNotifyMessage.getMsgGiftNum();
            if (this.nec || this.nea || this.neb || this.mHasNewVersion) {
                this.ndM = this.nea ? true : this.ndM;
                this.ndN = this.nec ? true : this.ndN;
                this.ndO = this.neb ? true : this.ndO;
                this.ndQ = this.mHasNewVersion ? true : this.ndQ;
                dFq();
            }
        }
    }

    public void dFp() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.ndZ);
    }

    public void xJ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFq() {
        SparseArray sparseArray = new SparseArray();
        if (this.ndZ) {
            sparseArray.append(4, new b.a(this.ndP, this.ndY));
        }
        if (this.nea) {
            sparseArray.append(2, new b.a(this.ndM, this.ndV));
        }
        if (this.neb) {
            sparseArray.append(1, new b.a(this.ndO, this.ndW));
        }
        if (this.nec) {
            sparseArray.append(3, new b.a(this.ndN, this.ndX));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ndQ, 0));
        }
        if (this.ned) {
            sparseArray.append(7, new b.a(this.ndR, 0));
        }
        if (this.nee) {
            sparseArray.append(9, new b.a(this.ndS, 0));
        }
        if (this.nef) {
            sparseArray.append(10, new b.a(this.ndT, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dFr();
    }

    public void xK(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ndP, this.ndY));
            sparseArray.append(2, new b.a(this.ndM, this.ndV));
            sparseArray.append(1, new b.a(this.ndO, this.ndW));
            sparseArray.append(3, new b.a(this.ndN, this.ndX));
            sparseArray.append(5, new b.a(this.ndQ, 0));
            sparseArray.append(7, new b.a(this.ndR, 0));
            sparseArray.append(9, new b.a(this.ndS, 0));
            sparseArray.append(10, new b.a(this.ndT, 0));
            sparseArray.append(11, new b.a(this.ndU, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dFr() {
        if (((this.ndV > 0 && this.nea) || (this.ndX > 0 && this.nec) || this.mHasNewVersion || this.nee || this.nef) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.nef) {
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dFs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.ndO = z;
                    break;
                case 2:
                    this.ndM = z;
                    break;
                case 3:
                    this.ndN = z;
                    break;
                case 4:
                    this.ndP = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.ndQ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.ndR = z;
                    break;
                case 9:
                    this.ndS = z;
                    com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.ndT = z;
                    break;
                case 11:
                    this.ndU = z;
                    break;
            }
            xK(true);
            dFt();
        }
    }

    private void dFt() {
        boolean z = this.ndO || this.ndN || this.ndM || this.ndP || this.ndQ || this.ndR || this.ndS || this.ndU;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dFu() {
        this.ndM = false;
        this.ndN = false;
        this.ndO = false;
        this.ndP = false;
        this.ndQ = false;
        this.ndR = false;
        this.ndS = false;
        this.ndV = 0;
        this.ndW = 0;
        this.ndX = 0;
        this.ndY = 0;
        this.ndZ = false;
        this.mHasNewVersion = false;
        this.nea = false;
        this.neb = false;
        this.nec = false;
        this.ned = false;
        this.nee = false;
        dFn();
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ksp) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dFo();
    }
}
