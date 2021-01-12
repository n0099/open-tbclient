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
    private CustomMessageListener jVo;
    private boolean khR;
    private boolean mHasNewVersion;
    private boolean mRL;
    private boolean mRM;
    private boolean mRN;
    private boolean mRO;
    private boolean mRP;
    private boolean mRQ;
    private boolean mRR;
    private boolean mRS;
    private boolean mRT;
    private int mRU;
    private int mRV;
    private int mRW;
    private int mRX;
    private boolean mRY;
    private boolean mRZ;
    private boolean mSa;
    private boolean mSb;
    private boolean mSc;
    private boolean mSd;
    private boolean mSe;
    CustomMessageListener mSf;
    private CustomMessageListener mSg;
    private CustomMessageListener mSh;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean dCI() {
        return this.mRL;
    }

    public boolean dCJ() {
        return this.mRM;
    }

    public boolean dCK() {
        return this.mRQ;
    }

    public boolean dCL() {
        return this.mRR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0820a {
        private static final a mSj = new a();
    }

    private a() {
        this.isPrimary = false;
        this.mRL = false;
        this.mRM = false;
        this.mRN = false;
        this.mRO = false;
        this.mRP = false;
        this.mRQ = false;
        this.mRR = false;
        this.mRS = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.mRT = false;
        this.mRU = 0;
        this.mRV = 0;
        this.mRW = 0;
        this.mRX = 0;
        this.mRY = false;
        this.mHasNewVersion = false;
        this.mRZ = false;
        this.mSa = false;
        this.mSb = false;
        this.mSc = false;
        this.mSd = false;
        this.mSe = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.mSf = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.mRX >= responseUnreadPointNum.getNum()) {
                        a.this.mRX = responseUnreadPointNum.getNum();
                        a.this.mRY = false;
                    } else {
                        a.this.mRY = true;
                        a.this.mRO = a.this.mRY ? true : a.this.mRO;
                        a.this.mRX = responseUnreadPointNum.getNum();
                        a.this.dCQ();
                    }
                    a.this.dCP();
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
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.mRS = booleanValue;
                    a.this.mSe = booleanValue;
                    a.this.dCQ();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.mSc = booleanValue;
                    a.this.mRQ = booleanValue;
                    a.this.dCQ();
                }
            }
        };
        this.mSg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.mRP = a.this.mHasNewVersion ? true : a.this.mRP;
                    a.this.dCQ();
                }
            }
        };
        this.jVo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dCS();
                        if (a.this.mRT) {
                            TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_locate", 1));
                            a.this.mRT = false;
                        }
                    }
                }
            }
        };
        this.mSh = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dCU();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.mRR = true;
                            a.this.mSd = true;
                            a.this.dCQ();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dCM() {
        return C0820a.mSj;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.mSf);
        MessageManager.getInstance().registerListener(this.mSg);
        MessageManager.getInstance().registerListener(this.mSh);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.jVo);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dCN() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.mRP = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.khR = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dCO() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.mRP)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.mSb = newsNotifyMessage.getMsgBookmark() > this.mRW;
            this.mRZ = newsNotifyMessage.getMsgFans() > this.mRU;
            this.mSa = newsNotifyMessage.getMsgGiftNum() > this.mRV;
            this.mRW = newsNotifyMessage.getMsgBookmark();
            this.mRU = newsNotifyMessage.getMsgFans();
            this.mRV = newsNotifyMessage.getMsgGiftNum();
            if (this.mSb || this.mRZ || this.mSa || this.mHasNewVersion) {
                this.mRL = this.mRZ ? true : this.mRL;
                this.mRM = this.mSb ? true : this.mRM;
                this.mRN = this.mSa ? true : this.mRN;
                this.mRP = this.mHasNewVersion ? true : this.mRP;
                dCQ();
            }
        }
    }

    public void dCP() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.mRY);
    }

    public void xq(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCQ() {
        SparseArray sparseArray = new SparseArray();
        if (this.mRY) {
            sparseArray.append(4, new b.a(this.mRO, this.mRX));
        }
        if (this.mRZ) {
            sparseArray.append(2, new b.a(this.mRL, this.mRU));
        }
        if (this.mSa) {
            sparseArray.append(1, new b.a(this.mRN, this.mRV));
        }
        if (this.mSb) {
            sparseArray.append(3, new b.a(this.mRM, this.mRW));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.mRP, 0));
        }
        if (this.mSc) {
            sparseArray.append(7, new b.a(this.mRQ, 0));
        }
        if (this.mSd) {
            sparseArray.append(9, new b.a(this.mRR, 0));
        }
        if (this.mSe) {
            sparseArray.append(10, new b.a(this.mRS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dCR();
    }

    public void xr(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.mRO, this.mRX));
            sparseArray.append(2, new b.a(this.mRL, this.mRU));
            sparseArray.append(1, new b.a(this.mRN, this.mRV));
            sparseArray.append(3, new b.a(this.mRM, this.mRW));
            sparseArray.append(5, new b.a(this.mRP, 0));
            sparseArray.append(7, new b.a(this.mRQ, 0));
            sparseArray.append(9, new b.a(this.mRR, 0));
            sparseArray.append(10, new b.a(this.mRS, 0));
            sparseArray.append(11, new b.a(this.mRT, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dCR() {
        if (((this.mRU > 0 && this.mRZ) || (this.mRW > 0 && this.mSb) || this.mHasNewVersion || this.mSd || this.mSe) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.mSe) {
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dCS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.mRN = z;
                    break;
                case 2:
                    this.mRL = z;
                    break;
                case 3:
                    this.mRM = z;
                    break;
                case 4:
                    this.mRO = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.mRP = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.mRQ = z;
                    break;
                case 9:
                    this.mRR = z;
                    com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.mRS = z;
                    break;
                case 11:
                    this.mRT = z;
                    break;
            }
            xr(true);
            dCT();
        }
    }

    private void dCT() {
        boolean z = this.mRN || this.mRM || this.mRL || this.mRO || this.mRP || this.mRQ || this.mRR || this.mRT;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dCU() {
        this.mRL = false;
        this.mRM = false;
        this.mRN = false;
        this.mRO = false;
        this.mRP = false;
        this.mRQ = false;
        this.mRR = false;
        this.mRU = 0;
        this.mRV = 0;
        this.mRW = 0;
        this.mRX = 0;
        this.mRY = false;
        this.mHasNewVersion = false;
        this.mRZ = false;
        this.mSa = false;
        this.mSb = false;
        this.mSc = false;
        this.mSd = false;
        dCN();
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.khR) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dCO();
    }
}
