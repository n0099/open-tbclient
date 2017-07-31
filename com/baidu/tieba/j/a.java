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
    private CustomMessageListener cRl;
    private boolean fJR;
    private boolean fJS;
    private boolean fJT;
    private boolean fJU;
    private boolean fJV;
    private boolean fJW;
    private boolean fJX;
    private int fJY;
    private int fJZ;
    private int fKa;
    private int fKb;
    private int fKc;
    private boolean fKd;
    private boolean fKe;
    private boolean fKf;
    private boolean fKg;
    private boolean fKh;
    private boolean fKi;
    private boolean fKj;
    private boolean fKk;
    private boolean fKl;
    private final CustomMessageListener fKm;
    CustomMessageListener fKn;
    private CustomMessageListener fKo;
    private CustomMessageListener fKp;
    private CustomMessageListener fKq;
    private CustomMessageListener fKr;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0102a {
        private static final a fKt = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fJR = false;
        this.fJS = false;
        this.fJT = false;
        this.fJU = false;
        this.fJV = false;
        this.fJW = false;
        this.fJX = false;
        this.fJY = 0;
        this.fJZ = 0;
        this.fKa = 0;
        this.fKb = 0;
        this.fKc = 0;
        this.fKd = false;
        this.mHasNewVersion = false;
        this.fKe = false;
        this.fKf = false;
        this.fKg = false;
        this.fKh = false;
        this.fKi = false;
        this.fKj = false;
        this.fKl = false;
        this.fKm = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fKn = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fKc >= responseUnreadPointNum.getNum()) {
                        a.this.fKc = responseUnreadPointNum.getNum();
                        a.this.fKd = false;
                    } else {
                        a.this.fKd = true;
                        a.this.fJU = a.this.fKd ? true : a.this.fJU;
                        a.this.fKc = responseUnreadPointNum.getNum();
                        a.this.biC();
                    }
                    a.this.biB();
                }
            }
        };
        this.fKo = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fKi = true;
                    a.this.fJX = booleanValue;
                    a.this.biC();
                }
            }
        };
        this.fKp = new CustomMessageListener(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.getInst().getLastUpdateThemeTime()) {
                    a.this.fKe = true;
                    a.this.fJW = a.this.fKe ? true : a.this.fJW;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                    a.this.biC();
                }
            }
        };
        this.fKq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fJV = a.this.mHasNewVersion ? true : a.this.fJV;
                    a.this.biC();
                }
            }
        };
        this.cRl = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.biF();
                    }
                }
            }
        };
        this.fKr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.biL();
                }
            }
        };
        initListener();
    }

    public static final a biy() {
        return C0102a.fKt;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fKm);
        MessageManager.getInstance().registerListener(this.fKn);
        MessageManager.getInstance().registerListener(this.fKp);
        MessageManager.getInstance().registerListener(this.fKq);
        MessageManager.getInstance().registerListener(this.fKr);
        MessageManager.getInstance().registerListener(this.fKo);
        MessageManager.getInstance().registerListener(this.cRl);
    }

    private void biz() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fJV = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fKk = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void biA() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fJV || this.fJW)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fKh = newsNotifyMessage.getMsgBookmark() > this.fKb;
            this.fKf = newsNotifyMessage.getMsgFans() > this.fJY;
            this.fKg = newsNotifyMessage.getMsgGiftNum() > this.fJZ;
            this.fKb = newsNotifyMessage.getMsgBookmark();
            this.fJY = newsNotifyMessage.getMsgFans();
            this.fJZ = newsNotifyMessage.getMsgGiftNum();
            this.fKa = newsNotifyMessage.getMsgLiveVip();
            if (this.fKh || this.fKf || this.fKg || this.mHasNewVersion) {
                this.fJR = this.fKf ? true : this.fJR;
                this.fJS = this.fKh ? true : this.fJS;
                this.fJT = this.fKg ? true : this.fJT;
                this.fJV = this.mHasNewVersion ? true : this.fJV;
                biC();
            }
        }
    }

    public void biB() {
        if (this.fKd) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void biC() {
        SparseArray sparseArray = new SparseArray();
        if (this.fKd) {
            sparseArray.append(4, new b.a(this.fJU, this.fKc));
        }
        if (this.fKf) {
            sparseArray.append(2, new b.a(this.fJR, this.fJY));
        }
        if (this.fKg) {
            sparseArray.append(1, new b.a(this.fJT, this.fJZ));
        }
        if (this.fKh) {
            sparseArray.append(3, new b.a(this.fJS, this.fKb));
        }
        if (this.fKe) {
            sparseArray.append(6, new b.a(this.fJW, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fJV, 0));
        }
        if (this.fKi) {
            sparseArray.append(7, new b.a(this.fJX, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        biE();
    }

    public void biD() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new b.a(this.fJU, this.fKc));
        sparseArray.append(2, new b.a(this.fJR, this.fJY));
        sparseArray.append(1, new b.a(this.fJT, this.fJZ));
        sparseArray.append(3, new b.a(this.fJS, this.fKb));
        sparseArray.append(6, new b.a(this.fJW, 0));
        sparseArray.append(5, new b.a(this.fJV, 0));
        sparseArray.append(7, new b.a(this.fJX, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
    }

    private void biE() {
        boolean z = (this.fJY > 0 && this.fKf) || (this.fKc > 0 && this.fKd) || ((this.fKb > 0 && this.fKh) || this.mHasNewVersion || this.fKe || this.fKi);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void biF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void E(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fJT = z;
                break;
            case 2:
                this.fJR = z;
                break;
            case 3:
                this.fJS = z;
                break;
            case 4:
                this.fJU = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fKl = true;
                this.fJV = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fJW = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                this.fJX = z;
                break;
        }
        biD();
        biG();
    }

    private void biG() {
        boolean z = this.fJT || this.fJS || this.fJR || this.fJU || this.fJV || this.fJW || this.fJX;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean biH() {
        return this.fJR;
    }

    public boolean biI() {
        return this.fJS;
    }

    public boolean biJ() {
        return this.fJU;
    }

    public boolean biK() {
        return this.fJT;
    }

    public void biL() {
        this.fJR = false;
        this.fJS = false;
        this.fJT = false;
        this.fJU = false;
        this.fJV = false;
        this.fJW = false;
        this.fJX = false;
        this.fJY = 0;
        this.fJZ = 0;
        this.fKa = 0;
        this.fKb = 0;
        this.fKc = 0;
        this.fKd = false;
        this.mHasNewVersion = false;
        this.fKf = false;
        this.fKg = false;
        this.fKh = false;
        this.fKj = false;
        this.fKi = false;
        biz();
        e.ga().post(new Runnable() { // from class: com.baidu.tieba.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fKk) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        biA();
    }
}
