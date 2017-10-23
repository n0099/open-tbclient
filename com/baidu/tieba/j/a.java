package com.baidu.tieba.j;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
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
    private CustomMessageListener cWZ;
    private boolean fHc;
    private boolean fHd;
    private boolean fHe;
    private boolean fHf;
    private boolean fHg;
    private boolean fHh;
    private int fHi;
    private int fHj;
    private int fHk;
    private int fHl;
    private int fHm;
    private boolean fHn;
    private boolean fHo;
    private boolean fHp;
    private boolean fHq;
    private boolean fHr;
    private boolean fHs;
    private boolean fHt;
    private boolean fHu;
    private final CustomMessageListener fHv;
    CustomMessageListener fHw;
    private CustomMessageListener fHx;
    private CustomMessageListener fHy;
    private CustomMessageListener fHz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0104a {
        private static final a fHB = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fHc = false;
        this.fHd = false;
        this.fHe = false;
        this.fHf = false;
        this.fHg = false;
        this.fHh = false;
        this.fHi = 0;
        this.fHj = 0;
        this.fHk = 0;
        this.fHl = 0;
        this.fHm = 0;
        this.fHn = false;
        this.mHasNewVersion = false;
        this.fHo = false;
        this.fHp = false;
        this.fHq = false;
        this.fHr = false;
        this.fHs = false;
        this.fHu = false;
        this.fHv = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fHw = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fHm >= responseUnreadPointNum.getNum()) {
                        a.this.fHm = responseUnreadPointNum.getNum();
                        a.this.fHn = false;
                    } else {
                        a.this.fHn = true;
                        a.this.fHf = a.this.fHn ? true : a.this.fHf;
                        a.this.fHm = responseUnreadPointNum.getNum();
                        a.this.bgN();
                    }
                    a.this.bgM();
                }
            }
        };
        this.fHx = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fHr = booleanValue;
                    a.this.fHh = booleanValue;
                    a.this.bgN();
                }
            }
        };
        this.fHy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fHg = a.this.mHasNewVersion ? true : a.this.fHg;
                    a.this.bgN();
                }
            }
        };
        this.cWZ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bgP();
                    }
                }
            }
        };
        this.fHz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bgR();
                }
            }
        };
        initListener();
    }

    public static final a bgJ() {
        return C0104a.fHB;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fHv);
        MessageManager.getInstance().registerListener(this.fHw);
        MessageManager.getInstance().registerListener(this.fHy);
        MessageManager.getInstance().registerListener(this.fHz);
        MessageManager.getInstance().registerListener(this.fHx);
        MessageManager.getInstance().registerListener(this.cWZ);
    }

    private void bgK() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fHg = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fHt = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bgL() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fHg)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fHq = newsNotifyMessage.getMsgBookmark() > this.fHl;
            this.fHo = newsNotifyMessage.getMsgFans() > this.fHi;
            this.fHp = newsNotifyMessage.getMsgGiftNum() > this.fHj;
            this.fHl = newsNotifyMessage.getMsgBookmark();
            this.fHi = newsNotifyMessage.getMsgFans();
            this.fHj = newsNotifyMessage.getMsgGiftNum();
            this.fHk = newsNotifyMessage.getMsgLiveVip();
            if (this.fHq || this.fHo || this.fHp || this.mHasNewVersion) {
                this.fHc = this.fHo ? true : this.fHc;
                this.fHd = this.fHq ? true : this.fHd;
                this.fHe = this.fHp ? true : this.fHe;
                this.fHg = this.mHasNewVersion ? true : this.fHg;
                bgN();
            }
        }
    }

    public void bgM() {
        if (this.fHn) {
            TbadkSettings inst = TbadkSettings.getInst();
            StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
            TbadkCoreApplication.getInst();
            inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
            return;
        }
        TbadkSettings inst2 = TbadkSettings.getInst();
        StringBuilder append2 = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst2.saveBoolean(append2.append(TbadkCoreApplication.getCurrentAccount()).toString(), true);
    }

    public void lH(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgN() {
        SparseArray sparseArray = new SparseArray();
        if (this.fHn) {
            sparseArray.append(4, new b.a(this.fHf, this.fHm));
        }
        if (this.fHo) {
            sparseArray.append(2, new b.a(this.fHc, this.fHi));
        }
        if (this.fHp) {
            sparseArray.append(1, new b.a(this.fHe, this.fHj));
        }
        if (this.fHq) {
            sparseArray.append(3, new b.a(this.fHd, this.fHl));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fHg, 0));
        }
        if (this.fHr) {
            sparseArray.append(7, new b.a(this.fHh, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bgO();
    }

    public void lI(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fHf, this.fHm));
            sparseArray.append(2, new b.a(this.fHc, this.fHi));
            sparseArray.append(1, new b.a(this.fHe, this.fHj));
            sparseArray.append(3, new b.a(this.fHd, this.fHl));
            sparseArray.append(5, new b.a(this.fHg, 0));
            sparseArray.append(7, new b.a(this.fHh, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bgO() {
        boolean z = (this.fHi > 0 && this.fHo) || (this.fHl > 0 && this.fHq) || this.mHasNewVersion;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bgP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fHe = z;
                    break;
                case 2:
                    this.fHc = z;
                    break;
                case 3:
                    this.fHd = z;
                    break;
                case 4:
                    this.fHf = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fHu = true;
                    this.fHg = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fHh = z;
                    break;
            }
            lI(z2);
            bgQ();
        }
    }

    private void bgQ() {
        boolean z = this.fHe || this.fHd || this.fHc || this.fHf || this.fHg || this.fHh;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bgR() {
        this.fHc = false;
        this.fHd = false;
        this.fHe = false;
        this.fHf = false;
        this.fHg = false;
        this.fHh = false;
        this.fHi = 0;
        this.fHj = 0;
        this.fHk = 0;
        this.fHl = 0;
        this.fHm = 0;
        this.fHn = false;
        this.mHasNewVersion = false;
        this.fHo = false;
        this.fHp = false;
        this.fHq = false;
        this.fHs = false;
        this.fHr = false;
        bgK();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fHt) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bgL();
    }
}
