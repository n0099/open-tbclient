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
    private CustomMessageListener edq;
    private boolean gGL;
    private boolean gGM;
    private boolean gGN;
    private boolean gGO;
    private boolean gGP;
    private boolean gGQ;
    private boolean gGR;
    private boolean gGS;
    private int gGT;
    private int gGU;
    private int gGV;
    private int gGW;
    private boolean gGX;
    private boolean gGY;
    private boolean gGZ;
    private boolean gHa;
    private boolean gHb;
    private boolean gHc;
    private boolean gHd;
    private boolean gHe;
    private final CustomMessageListener gHf;
    CustomMessageListener gHg;
    private CustomMessageListener gHh;
    private CustomMessageListener gHi;
    private CustomMessageListener gHj;
    private CustomMessageListener gHk;
    private CustomMessageListener gHl;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0133a {
        private static final a gHn = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gGL = false;
        this.gGM = false;
        this.gGN = false;
        this.gGO = false;
        this.gGP = false;
        this.gGQ = false;
        this.gGR = false;
        this.gGS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gGT = 0;
        this.gGU = 0;
        this.gGV = 0;
        this.gGW = 0;
        this.gGX = false;
        this.mHasNewVersion = false;
        this.gGY = false;
        this.gGZ = false;
        this.gHa = false;
        this.gHb = false;
        this.gHc = false;
        this.gHd = false;
        this.gHf = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gHg = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gGW >= responseUnreadPointNum.getNum()) {
                        a.this.gGW = responseUnreadPointNum.getNum();
                        a.this.gGX = false;
                    } else {
                        a.this.gGX = true;
                        a.this.gGO = a.this.gGX ? true : a.this.gGO;
                        a.this.gGW = responseUnreadPointNum.getNum();
                        a.this.bnT();
                    }
                    a.this.bnS();
                }
            }
        };
        this.gHh = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gGS = booleanValue;
                    a.this.gHd = booleanValue;
                    a.this.bnT();
                }
            }
        };
        this.gHi = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.4
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
                    a.this.gHb = booleanValue;
                    a.this.gGQ = booleanValue;
                    a.this.bnT();
                }
            }
        };
        this.gHj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gGP = a.this.mHasNewVersion ? true : a.this.gGP;
                    a.this.bnT();
                }
            }
        };
        this.edq = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bnV();
                    }
                }
            }
        };
        this.gHk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bnX();
                }
            }
        };
        this.gHl = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.EN()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String ES = activityPrizeData.ES();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(ES) && !ES.equals(string)) {
                            a.this.gGR = true;
                            a.this.gHc = true;
                            a.this.bnT();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bnP() {
        return C0133a.gHn;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gHf);
        MessageManager.getInstance().registerListener(this.gHg);
        MessageManager.getInstance().registerListener(this.gHj);
        MessageManager.getInstance().registerListener(this.gHk);
        MessageManager.getInstance().registerListener(this.gHi);
        MessageManager.getInstance().registerListener(this.edq);
        MessageManager.getInstance().registerListener(this.gHh);
        MessageManager.getInstance().registerListener(this.gHl);
    }

    private void bnQ() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gGP = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gHe = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bnR() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gGP)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gHa = newsNotifyMessage.getMsgBookmark() > this.gGV;
            this.gGY = newsNotifyMessage.getMsgFans() > this.gGT;
            this.gGZ = newsNotifyMessage.getMsgGiftNum() > this.gGU;
            this.gGV = newsNotifyMessage.getMsgBookmark();
            this.gGT = newsNotifyMessage.getMsgFans();
            this.gGU = newsNotifyMessage.getMsgGiftNum();
            if (this.gHa || this.gGY || this.gGZ || this.mHasNewVersion) {
                this.gGL = this.gGY ? true : this.gGL;
                this.gGM = this.gHa ? true : this.gGM;
                this.gGN = this.gGZ ? true : this.gGN;
                this.gGP = this.mHasNewVersion ? true : this.gGP;
                bnT();
            }
        }
    }

    public void bnS() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gGX);
    }

    public void lV(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnT() {
        SparseArray sparseArray = new SparseArray();
        if (this.gGX) {
            sparseArray.append(4, new b.a(this.gGO, this.gGW));
        }
        if (this.gGY) {
            sparseArray.append(2, new b.a(this.gGL, this.gGT));
        }
        if (this.gGZ) {
            sparseArray.append(1, new b.a(this.gGN, this.gGU));
        }
        if (this.gHa) {
            sparseArray.append(3, new b.a(this.gGM, this.gGV));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gGP, 0));
        }
        if (this.gHb) {
            sparseArray.append(7, new b.a(this.gGQ, 0));
        }
        if (this.gHc) {
            sparseArray.append(9, new b.a(this.gGR, 0));
        }
        if (this.gHd) {
            sparseArray.append(10, new b.a(this.gGS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bnU();
    }

    public void lW(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gGO, this.gGW));
            sparseArray.append(2, new b.a(this.gGL, this.gGT));
            sparseArray.append(1, new b.a(this.gGN, this.gGU));
            sparseArray.append(3, new b.a(this.gGM, this.gGV));
            sparseArray.append(5, new b.a(this.gGP, 0));
            sparseArray.append(7, new b.a(this.gGQ, 0));
            sparseArray.append(9, new b.a(this.gGR, 0));
            sparseArray.append(10, new b.a(this.gGS, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bnU() {
        if (((this.gGT > 0 && this.gGY) || (this.gGV > 0 && this.gHa) || this.mHasNewVersion || this.gHc || this.gHd) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gHd) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bnV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gGN = z;
                    break;
                case 2:
                    this.gGL = z;
                    break;
                case 3:
                    this.gGM = z;
                    break;
                case 4:
                    this.gGO = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gGP = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gGQ = z;
                    break;
                case 9:
                    this.gGR = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().ES());
                    break;
                case 10:
                    this.gGS = z;
                    break;
            }
            lW(true);
            bnW();
        }
    }

    private void bnW() {
        boolean z = this.gGN || this.gGM || this.gGL || this.gGO || this.gGP || this.gGQ || this.gGR;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bnX() {
        this.gGL = false;
        this.gGM = false;
        this.gGN = false;
        this.gGO = false;
        this.gGP = false;
        this.gGQ = false;
        this.gGR = false;
        this.gGT = 0;
        this.gGU = 0;
        this.gGV = 0;
        this.gGW = 0;
        this.gGX = false;
        this.mHasNewVersion = false;
        this.gGY = false;
        this.gGZ = false;
        this.gHa = false;
        this.gHb = false;
        this.gHc = false;
        bnQ();
        e.ns().post(new Runnable() { // from class: com.baidu.tieba.m.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gHe) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bnR();
    }
}
