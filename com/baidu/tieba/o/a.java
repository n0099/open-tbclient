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
/* loaded from: classes6.dex */
public class a {
    private CustomMessageListener gTy;
    private boolean hcb;
    private boolean isPrimary;
    private boolean jJI;
    private boolean jJJ;
    private boolean jJK;
    private boolean jJL;
    private boolean jJM;
    private boolean jJN;
    private boolean jJO;
    private boolean jJP;
    private int jJQ;
    private int jJR;
    private int jJS;
    private int jJT;
    private boolean jJU;
    private boolean jJV;
    private boolean jJW;
    private boolean jJX;
    private boolean jJY;
    private boolean jJZ;
    private boolean jKa;
    private final CustomMessageListener jKb;
    CustomMessageListener jKc;
    private CustomMessageListener jKd;
    private CustomMessageListener jKe;
    private CustomMessageListener jKf;
    private CustomMessageListener jKg;
    private CustomMessageListener jKh;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0552a {
        private static final a jKj = new a();
    }

    private a() {
        this.isPrimary = false;
        this.jJI = false;
        this.jJJ = false;
        this.jJK = false;
        this.jJL = false;
        this.jJM = false;
        this.jJN = false;
        this.jJO = false;
        this.jJP = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.jJQ = 0;
        this.jJR = 0;
        this.jJS = 0;
        this.jJT = 0;
        this.jJU = false;
        this.mHasNewVersion = false;
        this.jJV = false;
        this.jJW = false;
        this.jJX = false;
        this.jJY = false;
        this.jJZ = false;
        this.jKa = false;
        this.jKb = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.jKc = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.jJT >= responseUnreadPointNum.getNum()) {
                        a.this.jJT = responseUnreadPointNum.getNum();
                        a.this.jJU = false;
                    } else {
                        a.this.jJU = true;
                        a.this.jJL = a.this.jJU ? true : a.this.jJL;
                        a.this.jJT = responseUnreadPointNum.getNum();
                        a.this.cBi();
                    }
                    a.this.cBh();
                }
            }
        };
        this.jKd = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.jJP = booleanValue;
                    a.this.jKa = booleanValue;
                    a.this.cBi();
                }
            }
        };
        this.jKe = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.jJY = booleanValue;
                    a.this.jJN = booleanValue;
                    a.this.cBi();
                }
            }
        };
        this.jKf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.jJM = a.this.mHasNewVersion ? true : a.this.jJM;
                    a.this.cBi();
                }
            }
        };
        this.gTy = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cBk();
                    }
                }
            }
        };
        this.jKg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cBm();
                }
            }
        };
        this.jKh = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.jJO = true;
                            a.this.jJZ = true;
                            a.this.cBi();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cBe() {
        return C0552a.jKj;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.jKb);
        MessageManager.getInstance().registerListener(this.jKc);
        MessageManager.getInstance().registerListener(this.jKf);
        MessageManager.getInstance().registerListener(this.jKg);
        MessageManager.getInstance().registerListener(this.jKe);
        MessageManager.getInstance().registerListener(this.gTy);
        MessageManager.getInstance().registerListener(this.jKd);
        MessageManager.getInstance().registerListener(this.jKh);
    }

    private void cBf() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.jJM = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.hcb = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cBg() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.jJM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.jJX = newsNotifyMessage.getMsgBookmark() > this.jJS;
            this.jJV = newsNotifyMessage.getMsgFans() > this.jJQ;
            this.jJW = newsNotifyMessage.getMsgGiftNum() > this.jJR;
            this.jJS = newsNotifyMessage.getMsgBookmark();
            this.jJQ = newsNotifyMessage.getMsgFans();
            this.jJR = newsNotifyMessage.getMsgGiftNum();
            if (this.jJX || this.jJV || this.jJW || this.mHasNewVersion) {
                this.jJI = this.jJV ? true : this.jJI;
                this.jJJ = this.jJX ? true : this.jJJ;
                this.jJK = this.jJW ? true : this.jJK;
                this.jJM = this.mHasNewVersion ? true : this.jJM;
                cBi();
            }
        }
    }

    public void cBh() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.jJU);
    }

    public void rT(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBi() {
        SparseArray sparseArray = new SparseArray();
        if (this.jJU) {
            sparseArray.append(4, new b.a(this.jJL, this.jJT));
        }
        if (this.jJV) {
            sparseArray.append(2, new b.a(this.jJI, this.jJQ));
        }
        if (this.jJW) {
            sparseArray.append(1, new b.a(this.jJK, this.jJR));
        }
        if (this.jJX) {
            sparseArray.append(3, new b.a(this.jJJ, this.jJS));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.jJM, 0));
        }
        if (this.jJY) {
            sparseArray.append(7, new b.a(this.jJN, 0));
        }
        if (this.jJZ) {
            sparseArray.append(9, new b.a(this.jJO, 0));
        }
        if (this.jKa) {
            sparseArray.append(10, new b.a(this.jJP, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        cBj();
    }

    public void rU(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.jJL, this.jJT));
            sparseArray.append(2, new b.a(this.jJI, this.jJQ));
            sparseArray.append(1, new b.a(this.jJK, this.jJR));
            sparseArray.append(3, new b.a(this.jJJ, this.jJS));
            sparseArray.append(5, new b.a(this.jJM, 0));
            sparseArray.append(7, new b.a(this.jJN, 0));
            sparseArray.append(9, new b.a(this.jJO, 0));
            sparseArray.append(10, new b.a(this.jJP, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void cBj() {
        if (((this.jJQ > 0 && this.jJV) || (this.jJS > 0 && this.jJX) || this.mHasNewVersion || this.jJZ || this.jKa) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.jKa) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cBk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.jJK = z;
                    break;
                case 2:
                    this.jJI = z;
                    break;
                case 3:
                    this.jJJ = z;
                    break;
                case 4:
                    this.jJL = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.jJM = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.jJN = z;
                    break;
                case 9:
                    this.jJO = z;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.jJP = z;
                    break;
            }
            rU(true);
            cBl();
        }
    }

    private void cBl() {
        boolean z = this.jJK || this.jJJ || this.jJI || this.jJL || this.jJM || this.jJN || this.jJO;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cBm() {
        this.jJI = false;
        this.jJJ = false;
        this.jJK = false;
        this.jJL = false;
        this.jJM = false;
        this.jJN = false;
        this.jJO = false;
        this.jJQ = 0;
        this.jJR = 0;
        this.jJS = 0;
        this.jJT = 0;
        this.jJU = false;
        this.mHasNewVersion = false;
        this.jJV = false;
        this.jJW = false;
        this.jJX = false;
        this.jJY = false;
        this.jJZ = false;
        cBf();
        e.gy().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.hcb) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cBg();
    }
}
