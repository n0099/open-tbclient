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
    private CustomMessageListener dfr;
    private boolean fPU;
    private boolean fPV;
    private boolean fPW;
    private boolean fPX;
    private boolean fPY;
    private boolean fPZ;
    private int fQa;
    private int fQb;
    private int fQc;
    private int fQd;
    private boolean fQe;
    private boolean fQf;
    private boolean fQg;
    private boolean fQh;
    private boolean fQi;
    private boolean fQj;
    private final CustomMessageListener fQk;
    CustomMessageListener fQl;
    private CustomMessageListener fQm;
    private CustomMessageListener fQn;
    private CustomMessageListener fQo;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0102a {
        private static final a fQq = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fPU = false;
        this.fPV = false;
        this.fPW = false;
        this.fPX = false;
        this.fPY = false;
        this.fPZ = false;
        this.fQa = 0;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = 0;
        this.fQe = false;
        this.mHasNewVersion = false;
        this.fQf = false;
        this.fQg = false;
        this.fQh = false;
        this.fQi = false;
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fQl = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fQd >= responseUnreadPointNum.getNum()) {
                        a.this.fQd = responseUnreadPointNum.getNum();
                        a.this.fQe = false;
                    } else {
                        a.this.fQe = true;
                        a.this.fPX = a.this.fQe ? true : a.this.fPX;
                        a.this.fQd = responseUnreadPointNum.getNum();
                        a.this.bka();
                    }
                    a.this.bjZ();
                }
            }
        };
        this.fQm = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fQi = booleanValue;
                    a.this.fPZ = booleanValue;
                    a.this.bka();
                }
            }
        };
        this.fQn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fPY = a.this.mHasNewVersion ? true : a.this.fPY;
                    a.this.bka();
                }
            }
        };
        this.dfr = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bkc();
                    }
                }
            }
        };
        this.fQo = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bke();
                }
            }
        };
        initListener();
    }

    public static final a bjW() {
        return C0102a.fQq;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fQk);
        MessageManager.getInstance().registerListener(this.fQl);
        MessageManager.getInstance().registerListener(this.fQn);
        MessageManager.getInstance().registerListener(this.fQo);
        MessageManager.getInstance().registerListener(this.fQm);
        MessageManager.getInstance().registerListener(this.dfr);
    }

    private void bjX() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fPY = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fQj = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bjY() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fPY)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fQh = newsNotifyMessage.getMsgBookmark() > this.fQc;
            this.fQf = newsNotifyMessage.getMsgFans() > this.fQa;
            this.fQg = newsNotifyMessage.getMsgGiftNum() > this.fQb;
            this.fQc = newsNotifyMessage.getMsgBookmark();
            this.fQa = newsNotifyMessage.getMsgFans();
            this.fQb = newsNotifyMessage.getMsgGiftNum();
            if (this.fQh || this.fQf || this.fQg || this.mHasNewVersion) {
                this.fPU = this.fQf ? true : this.fPU;
                this.fPV = this.fQh ? true : this.fPV;
                this.fPW = this.fQg ? true : this.fPW;
                this.fPY = this.mHasNewVersion ? true : this.fPY;
                bka();
            }
        }
    }

    public void bjZ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.fQe);
    }

    public void lC(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bka() {
        SparseArray sparseArray = new SparseArray();
        if (this.fQe) {
            sparseArray.append(4, new b.a(this.fPX, this.fQd));
        }
        if (this.fQf) {
            sparseArray.append(2, new b.a(this.fPU, this.fQa));
        }
        if (this.fQg) {
            sparseArray.append(1, new b.a(this.fPW, this.fQb));
        }
        if (this.fQh) {
            sparseArray.append(3, new b.a(this.fPV, this.fQc));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fPY, 0));
        }
        if (this.fQi) {
            sparseArray.append(7, new b.a(this.fPZ, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bkb();
    }

    public void lD(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fPX, this.fQd));
            sparseArray.append(2, new b.a(this.fPU, this.fQa));
            sparseArray.append(1, new b.a(this.fPW, this.fQb));
            sparseArray.append(3, new b.a(this.fPV, this.fQc));
            sparseArray.append(5, new b.a(this.fPY, 0));
            sparseArray.append(7, new b.a(this.fPZ, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bkb() {
        boolean z = (this.fQa > 0 && this.fQf) || (this.fQc > 0 && this.fQh) || this.mHasNewVersion;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fPW = z;
                    break;
                case 2:
                    this.fPU = z;
                    break;
                case 3:
                    this.fPV = z;
                    break;
                case 4:
                    this.fPX = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fPY = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fPZ = z;
                    break;
            }
            lD(z2);
            bkd();
        }
    }

    private void bkd() {
        boolean z = this.fPW || this.fPV || this.fPU || this.fPX || this.fPY || this.fPZ;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bke() {
        this.fPU = false;
        this.fPV = false;
        this.fPW = false;
        this.fPX = false;
        this.fPY = false;
        this.fPZ = false;
        this.fQa = 0;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = 0;
        this.fQe = false;
        this.mHasNewVersion = false;
        this.fQf = false;
        this.fQg = false;
        this.fQh = false;
        this.fQi = false;
        bjX();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fQj) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bjY();
    }
}
