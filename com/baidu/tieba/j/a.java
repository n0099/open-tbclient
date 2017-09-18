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
    private CustomMessageListener daJ;
    private boolean fKG;
    private boolean fKH;
    private boolean fKI;
    private boolean fKJ;
    private boolean fKK;
    private boolean fKL;
    private int fKM;
    private int fKN;
    private int fKO;
    private int fKP;
    private int fKQ;
    private boolean fKR;
    private boolean fKS;
    private boolean fKT;
    private boolean fKU;
    private boolean fKV;
    private boolean fKW;
    private boolean fKX;
    private boolean fKY;
    private final CustomMessageListener fKZ;
    CustomMessageListener fLa;
    private CustomMessageListener fLb;
    private CustomMessageListener fLc;
    private CustomMessageListener fLd;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0104a {
        private static final a fLf = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fKG = false;
        this.fKH = false;
        this.fKI = false;
        this.fKJ = false;
        this.fKK = false;
        this.fKL = false;
        this.fKM = 0;
        this.fKN = 0;
        this.fKO = 0;
        this.fKP = 0;
        this.fKQ = 0;
        this.fKR = false;
        this.mHasNewVersion = false;
        this.fKS = false;
        this.fKT = false;
        this.fKU = false;
        this.fKV = false;
        this.fKW = false;
        this.fKY = false;
        this.fKZ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fLa = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fKQ >= responseUnreadPointNum.getNum()) {
                        a.this.fKQ = responseUnreadPointNum.getNum();
                        a.this.fKR = false;
                    } else {
                        a.this.fKR = true;
                        a.this.fKJ = a.this.fKR ? true : a.this.fKJ;
                        a.this.fKQ = responseUnreadPointNum.getNum();
                        a.this.bin();
                    }
                    a.this.bim();
                }
            }
        };
        this.fLb = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fKV = booleanValue;
                    a.this.fKL = booleanValue;
                    a.this.bin();
                }
            }
        };
        this.fLc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fKK = a.this.mHasNewVersion ? true : a.this.fKK;
                    a.this.bin();
                }
            }
        };
        this.daJ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bip();
                    }
                }
            }
        };
        this.fLd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.biv();
                }
            }
        };
        initListener();
    }

    public static final a bij() {
        return C0104a.fLf;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fKZ);
        MessageManager.getInstance().registerListener(this.fLa);
        MessageManager.getInstance().registerListener(this.fLc);
        MessageManager.getInstance().registerListener(this.fLd);
        MessageManager.getInstance().registerListener(this.fLb);
        MessageManager.getInstance().registerListener(this.daJ);
    }

    private void bik() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fKK = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fKX = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bil() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fKK)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fKU = newsNotifyMessage.getMsgBookmark() > this.fKP;
            this.fKS = newsNotifyMessage.getMsgFans() > this.fKM;
            this.fKT = newsNotifyMessage.getMsgGiftNum() > this.fKN;
            this.fKP = newsNotifyMessage.getMsgBookmark();
            this.fKM = newsNotifyMessage.getMsgFans();
            this.fKN = newsNotifyMessage.getMsgGiftNum();
            this.fKO = newsNotifyMessage.getMsgLiveVip();
            if (this.fKU || this.fKS || this.fKT || this.mHasNewVersion) {
                this.fKG = this.fKS ? true : this.fKG;
                this.fKH = this.fKU ? true : this.fKH;
                this.fKI = this.fKT ? true : this.fKI;
                this.fKK = this.mHasNewVersion ? true : this.fKK;
                bin();
            }
        }
    }

    public void bim() {
        if (this.fKR) {
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

    public void lP(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        SparseArray sparseArray = new SparseArray();
        if (this.fKR) {
            sparseArray.append(4, new b.a(this.fKJ, this.fKQ));
        }
        if (this.fKS) {
            sparseArray.append(2, new b.a(this.fKG, this.fKM));
        }
        if (this.fKT) {
            sparseArray.append(1, new b.a(this.fKI, this.fKN));
        }
        if (this.fKU) {
            sparseArray.append(3, new b.a(this.fKH, this.fKP));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fKK, 0));
        }
        if (this.fKV) {
            sparseArray.append(7, new b.a(this.fKL, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bio();
    }

    public void lQ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fKJ, this.fKQ));
            sparseArray.append(2, new b.a(this.fKG, this.fKM));
            sparseArray.append(1, new b.a(this.fKI, this.fKN));
            sparseArray.append(3, new b.a(this.fKH, this.fKP));
            sparseArray.append(5, new b.a(this.fKK, 0));
            sparseArray.append(7, new b.a(this.fKL, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bio() {
        boolean z = (this.fKM > 0 && this.fKS) || (this.fKQ > 0 && this.fKR) || ((this.fKP > 0 && this.fKU) || this.mHasNewVersion || this.fKL);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bip() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fKI = z;
                    break;
                case 2:
                    this.fKG = z;
                    break;
                case 3:
                    this.fKH = z;
                    break;
                case 4:
                    this.fKJ = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fKY = true;
                    this.fKK = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fKL = z;
                    break;
            }
            lQ(z2);
            biq();
        }
    }

    private void biq() {
        boolean z = this.fKI || this.fKH || this.fKG || this.fKJ || this.fKK || this.fKL;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean bir() {
        return this.fKG;
    }

    public boolean bis() {
        return this.fKH;
    }

    public boolean bit() {
        return this.fKJ;
    }

    public boolean biu() {
        return this.fKI;
    }

    public void biv() {
        this.fKG = false;
        this.fKH = false;
        this.fKI = false;
        this.fKJ = false;
        this.fKK = false;
        this.fKL = false;
        this.fKM = 0;
        this.fKN = 0;
        this.fKO = 0;
        this.fKP = 0;
        this.fKQ = 0;
        this.fKR = false;
        this.mHasNewVersion = false;
        this.fKS = false;
        this.fKT = false;
        this.fKU = false;
        this.fKW = false;
        this.fKV = false;
        bik();
        e.fQ().post(new Runnable() { // from class: com.baidu.tieba.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fKX) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bil();
    }
}
