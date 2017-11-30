package com.baidu.tieba.m;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.m.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener dor;
    private boolean gaA;
    private boolean gaB;
    private boolean gaC;
    private boolean gaD;
    private boolean gaE;
    private boolean gaF;
    private int gaG;
    private int gaH;
    private int gaI;
    private int gaJ;
    private boolean gaK;
    private boolean gaL;
    private boolean gaM;
    private boolean gaN;
    private boolean gaO;
    private boolean gaP;
    private boolean gaQ;
    private final CustomMessageListener gaR;
    CustomMessageListener gaS;
    private CustomMessageListener gaT;
    private CustomMessageListener gaU;
    private CustomMessageListener gaV;
    private CustomMessageListener gaW;
    private boolean gaz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0107a {
        private static final a gaY = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gaz = false;
        this.gaA = false;
        this.gaB = false;
        this.gaC = false;
        this.gaD = false;
        this.gaE = false;
        this.gaF = false;
        this.gaG = 0;
        this.gaH = 0;
        this.gaI = 0;
        this.gaJ = 0;
        this.gaK = false;
        this.mHasNewVersion = false;
        this.gaL = false;
        this.gaM = false;
        this.gaN = false;
        this.gaO = false;
        this.gaP = false;
        this.gaR = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gaS = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gaJ >= responseUnreadPointNum.getNum()) {
                        a.this.gaJ = responseUnreadPointNum.getNum();
                        a.this.gaK = false;
                    } else {
                        a.this.gaK = true;
                        a.this.gaC = a.this.gaK ? true : a.this.gaC;
                        a.this.gaJ = responseUnreadPointNum.getNum();
                        a.this.bml();
                    }
                    a.this.bmk();
                }
            }
        };
        this.gaT = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.gaO = booleanValue;
                    a.this.gaE = booleanValue;
                    a.this.bml();
                }
            }
        };
        this.gaU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gaD = a.this.mHasNewVersion ? true : a.this.gaD;
                    a.this.bml();
                }
            }
        };
        this.dor = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bmn();
                    }
                }
            }
        };
        this.gaV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bmp();
                }
            }
        };
        this.gaW = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xw()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String xA = activityPrizeData.xA();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(xA) && !xA.equals(string)) {
                            a.this.gaF = true;
                            a.this.gaP = true;
                            a.this.bml();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bmh() {
        return C0107a.gaY;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gaR);
        MessageManager.getInstance().registerListener(this.gaS);
        MessageManager.getInstance().registerListener(this.gaU);
        MessageManager.getInstance().registerListener(this.gaV);
        MessageManager.getInstance().registerListener(this.gaT);
        MessageManager.getInstance().registerListener(this.dor);
        MessageManager.getInstance().registerListener(this.gaW);
    }

    private void bmi() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gaD = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gaQ = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bmj() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gaD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gaN = newsNotifyMessage.getMsgBookmark() > this.gaI;
            this.gaL = newsNotifyMessage.getMsgFans() > this.gaG;
            this.gaM = newsNotifyMessage.getMsgGiftNum() > this.gaH;
            this.gaI = newsNotifyMessage.getMsgBookmark();
            this.gaG = newsNotifyMessage.getMsgFans();
            this.gaH = newsNotifyMessage.getMsgGiftNum();
            if (this.gaN || this.gaL || this.gaM || this.mHasNewVersion) {
                this.gaz = this.gaL ? true : this.gaz;
                this.gaA = this.gaN ? true : this.gaA;
                this.gaB = this.gaM ? true : this.gaB;
                this.gaD = this.mHasNewVersion ? true : this.gaD;
                bml();
            }
        }
    }

    public void bmk() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gaK);
    }

    public void mj(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bml() {
        SparseArray sparseArray = new SparseArray();
        if (this.gaK) {
            sparseArray.append(4, new b.a(this.gaC, this.gaJ));
        }
        if (this.gaL) {
            sparseArray.append(2, new b.a(this.gaz, this.gaG));
        }
        if (this.gaM) {
            sparseArray.append(1, new b.a(this.gaB, this.gaH));
        }
        if (this.gaN) {
            sparseArray.append(3, new b.a(this.gaA, this.gaI));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gaD, 0));
        }
        if (this.gaO) {
            sparseArray.append(7, new b.a(this.gaE, 0));
        }
        if (this.gaP) {
            sparseArray.append(9, new b.a(this.gaF, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bmm();
    }

    public void mk(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gaC, this.gaJ));
            sparseArray.append(2, new b.a(this.gaz, this.gaG));
            sparseArray.append(1, new b.a(this.gaB, this.gaH));
            sparseArray.append(3, new b.a(this.gaA, this.gaI));
            sparseArray.append(5, new b.a(this.gaD, 0));
            sparseArray.append(7, new b.a(this.gaE, 0));
            sparseArray.append(9, new b.a(this.gaF, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bmm() {
        boolean z = (this.gaG > 0 && this.gaL) || (this.gaI > 0 && this.gaN) || this.mHasNewVersion || this.gaP;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gaB = z;
                    break;
                case 2:
                    this.gaz = z;
                    break;
                case 3:
                    this.gaA = z;
                    break;
                case 4:
                    this.gaC = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gaD = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gaE = z;
                    break;
                case 9:
                    this.gaF = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().xA());
                    break;
            }
            mk(z2);
            bmo();
        }
    }

    private void bmo() {
        boolean z = this.gaB || this.gaA || this.gaz || this.gaC || this.gaD || this.gaE || this.gaF;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmp() {
        this.gaz = false;
        this.gaA = false;
        this.gaB = false;
        this.gaC = false;
        this.gaD = false;
        this.gaE = false;
        this.gaF = false;
        this.gaG = 0;
        this.gaH = 0;
        this.gaI = 0;
        this.gaJ = 0;
        this.gaK = false;
        this.mHasNewVersion = false;
        this.gaL = false;
        this.gaM = false;
        this.gaN = false;
        this.gaO = false;
        this.gaP = false;
        bmi();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.m.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gaQ) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bmj();
    }
}
