package com.baidu.tieba.j;

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
import com.baidu.tieba.j.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener dfL;
    private boolean fQT;
    private boolean fQU;
    private boolean fQV;
    private boolean fQW;
    private boolean fQX;
    private boolean fQY;
    private boolean fQZ;
    private int fRa;
    private int fRb;
    private int fRc;
    private int fRd;
    private boolean fRe;
    private boolean fRf;
    private boolean fRg;
    private boolean fRh;
    private boolean fRi;
    private boolean fRj;
    private boolean fRk;
    private final CustomMessageListener fRl;
    CustomMessageListener fRm;
    private CustomMessageListener fRn;
    private CustomMessageListener fRo;
    private CustomMessageListener fRp;
    private CustomMessageListener fRq;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0102a {
        private static final a fRs = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fQT = false;
        this.fQU = false;
        this.fQV = false;
        this.fQW = false;
        this.fQX = false;
        this.fQY = false;
        this.fQZ = false;
        this.fRa = 0;
        this.fRb = 0;
        this.fRc = 0;
        this.fRd = 0;
        this.fRe = false;
        this.mHasNewVersion = false;
        this.fRf = false;
        this.fRg = false;
        this.fRh = false;
        this.fRi = false;
        this.fRj = false;
        this.fRl = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fRm = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fRd >= responseUnreadPointNum.getNum()) {
                        a.this.fRd = responseUnreadPointNum.getNum();
                        a.this.fRe = false;
                    } else {
                        a.this.fRe = true;
                        a.this.fQW = a.this.fRe ? true : a.this.fQW;
                        a.this.fRd = responseUnreadPointNum.getNum();
                        a.this.bkl();
                    }
                    a.this.bkk();
                }
            }
        };
        this.fRn = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fRi = booleanValue;
                    a.this.fQY = booleanValue;
                    a.this.bkl();
                }
            }
        };
        this.fRo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fQX = a.this.mHasNewVersion ? true : a.this.fQX;
                    a.this.bkl();
                }
            }
        };
        this.dfL = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bkn();
                    }
                }
            }
        };
        this.fRp = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bkp();
                }
            }
        };
        this.fRq = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.j.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xv()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String xz = activityPrizeData.xz();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(xz) && !xz.equals(string)) {
                            a.this.fQZ = true;
                            a.this.fRj = true;
                            a.this.bkl();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bkh() {
        return C0102a.fRs;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fRl);
        MessageManager.getInstance().registerListener(this.fRm);
        MessageManager.getInstance().registerListener(this.fRo);
        MessageManager.getInstance().registerListener(this.fRp);
        MessageManager.getInstance().registerListener(this.fRn);
        MessageManager.getInstance().registerListener(this.dfL);
        MessageManager.getInstance().registerListener(this.fRq);
    }

    private void bki() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fQX = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fRk = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bkj() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fQX)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fRh = newsNotifyMessage.getMsgBookmark() > this.fRc;
            this.fRf = newsNotifyMessage.getMsgFans() > this.fRa;
            this.fRg = newsNotifyMessage.getMsgGiftNum() > this.fRb;
            this.fRc = newsNotifyMessage.getMsgBookmark();
            this.fRa = newsNotifyMessage.getMsgFans();
            this.fRb = newsNotifyMessage.getMsgGiftNum();
            if (this.fRh || this.fRf || this.fRg || this.mHasNewVersion) {
                this.fQT = this.fRf ? true : this.fQT;
                this.fQU = this.fRh ? true : this.fQU;
                this.fQV = this.fRg ? true : this.fQV;
                this.fQX = this.mHasNewVersion ? true : this.fQX;
                bkl();
            }
        }
    }

    public void bkk() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.fRe);
    }

    public void lK(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkl() {
        SparseArray sparseArray = new SparseArray();
        if (this.fRe) {
            sparseArray.append(4, new b.a(this.fQW, this.fRd));
        }
        if (this.fRf) {
            sparseArray.append(2, new b.a(this.fQT, this.fRa));
        }
        if (this.fRg) {
            sparseArray.append(1, new b.a(this.fQV, this.fRb));
        }
        if (this.fRh) {
            sparseArray.append(3, new b.a(this.fQU, this.fRc));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fQX, 0));
        }
        if (this.fRi) {
            sparseArray.append(7, new b.a(this.fQY, 0));
        }
        if (this.fRj) {
            sparseArray.append(9, new b.a(this.fQZ, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bkm();
    }

    public void lL(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fQW, this.fRd));
            sparseArray.append(2, new b.a(this.fQT, this.fRa));
            sparseArray.append(1, new b.a(this.fQV, this.fRb));
            sparseArray.append(3, new b.a(this.fQU, this.fRc));
            sparseArray.append(5, new b.a(this.fQX, 0));
            sparseArray.append(7, new b.a(this.fQY, 0));
            sparseArray.append(9, new b.a(this.fQZ, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bkm() {
        boolean z = (this.fRa > 0 && this.fRf) || (this.fRc > 0 && this.fRh) || this.mHasNewVersion || this.fRj;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fQV = z;
                    break;
                case 2:
                    this.fQT = z;
                    break;
                case 3:
                    this.fQU = z;
                    break;
                case 4:
                    this.fQW = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fQX = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fQY = z;
                    break;
                case 9:
                    this.fQZ = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().xz());
                    break;
            }
            lL(z2);
            bko();
        }
    }

    private void bko() {
        boolean z = this.fQV || this.fQU || this.fQT || this.fQW || this.fQX || this.fQY || this.fQZ;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkp() {
        this.fQT = false;
        this.fQU = false;
        this.fQV = false;
        this.fQW = false;
        this.fQX = false;
        this.fQY = false;
        this.fQZ = false;
        this.fRa = 0;
        this.fRb = 0;
        this.fRc = 0;
        this.fRd = 0;
        this.fRe = false;
        this.mHasNewVersion = false;
        this.fRf = false;
        this.fRg = false;
        this.fRh = false;
        this.fRi = false;
        this.fRj = false;
        bki();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fRk) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bkj();
    }
}
