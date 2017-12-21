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
    private CustomMessageListener dpA;
    private boolean gdA;
    private boolean gdB;
    private final CustomMessageListener gdC;
    CustomMessageListener gdD;
    private CustomMessageListener gdE;
    private CustomMessageListener gdF;
    private CustomMessageListener gdG;
    private CustomMessageListener gdH;
    private boolean gdk;
    private boolean gdl;
    private boolean gdm;
    private boolean gdn;
    private boolean gdo;
    private boolean gdp;
    private boolean gdq;
    private int gdr;
    private int gds;
    private int gdt;
    private int gdu;
    private boolean gdv;
    private boolean gdw;
    private boolean gdx;
    private boolean gdy;
    private boolean gdz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0121a {
        private static final a gdJ = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gdk = false;
        this.gdl = false;
        this.gdm = false;
        this.gdn = false;
        this.gdo = false;
        this.gdp = false;
        this.gdq = false;
        this.gdr = 0;
        this.gds = 0;
        this.gdt = 0;
        this.gdu = 0;
        this.gdv = false;
        this.mHasNewVersion = false;
        this.gdw = false;
        this.gdx = false;
        this.gdy = false;
        this.gdz = false;
        this.gdA = false;
        this.gdC = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gdD = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gdu >= responseUnreadPointNum.getNum()) {
                        a.this.gdu = responseUnreadPointNum.getNum();
                        a.this.gdv = false;
                    } else {
                        a.this.gdv = true;
                        a.this.gdn = a.this.gdv ? true : a.this.gdn;
                        a.this.gdu = responseUnreadPointNum.getNum();
                        a.this.bmR();
                    }
                    a.this.bmQ();
                }
            }
        };
        this.gdE = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.3
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
                    a.this.gdz = booleanValue;
                    a.this.gdp = booleanValue;
                    a.this.bmR();
                }
            }
        };
        this.gdF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gdo = a.this.mHasNewVersion ? true : a.this.gdo;
                    a.this.bmR();
                }
            }
        };
        this.dpA = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bmT();
                    }
                }
            }
        };
        this.gdG = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bmV();
                }
            }
        };
        this.gdH = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xv()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String xA = activityPrizeData.xA();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(xA) && !xA.equals(string)) {
                            a.this.gdq = true;
                            a.this.gdA = true;
                            a.this.bmR();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bmN() {
        return C0121a.gdJ;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gdC);
        MessageManager.getInstance().registerListener(this.gdD);
        MessageManager.getInstance().registerListener(this.gdF);
        MessageManager.getInstance().registerListener(this.gdG);
        MessageManager.getInstance().registerListener(this.gdE);
        MessageManager.getInstance().registerListener(this.dpA);
        MessageManager.getInstance().registerListener(this.gdH);
    }

    private void bmO() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gdo = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gdB = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bmP() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gdo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gdy = newsNotifyMessage.getMsgBookmark() > this.gdt;
            this.gdw = newsNotifyMessage.getMsgFans() > this.gdr;
            this.gdx = newsNotifyMessage.getMsgGiftNum() > this.gds;
            this.gdt = newsNotifyMessage.getMsgBookmark();
            this.gdr = newsNotifyMessage.getMsgFans();
            this.gds = newsNotifyMessage.getMsgGiftNum();
            if (this.gdy || this.gdw || this.gdx || this.mHasNewVersion) {
                this.gdk = this.gdw ? true : this.gdk;
                this.gdl = this.gdy ? true : this.gdl;
                this.gdm = this.gdx ? true : this.gdm;
                this.gdo = this.mHasNewVersion ? true : this.gdo;
                bmR();
            }
        }
    }

    public void bmQ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gdv);
    }

    public void ml(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmR() {
        SparseArray sparseArray = new SparseArray();
        if (this.gdv) {
            sparseArray.append(4, new b.a(this.gdn, this.gdu));
        }
        if (this.gdw) {
            sparseArray.append(2, new b.a(this.gdk, this.gdr));
        }
        if (this.gdx) {
            sparseArray.append(1, new b.a(this.gdm, this.gds));
        }
        if (this.gdy) {
            sparseArray.append(3, new b.a(this.gdl, this.gdt));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gdo, 0));
        }
        if (this.gdz) {
            sparseArray.append(7, new b.a(this.gdp, 0));
        }
        if (this.gdA) {
            sparseArray.append(9, new b.a(this.gdq, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bmS();
    }

    public void mm(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gdn, this.gdu));
            sparseArray.append(2, new b.a(this.gdk, this.gdr));
            sparseArray.append(1, new b.a(this.gdm, this.gds));
            sparseArray.append(3, new b.a(this.gdl, this.gdt));
            sparseArray.append(5, new b.a(this.gdo, 0));
            sparseArray.append(7, new b.a(this.gdp, 0));
            sparseArray.append(9, new b.a(this.gdq, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bmS() {
        boolean z = (this.gdr > 0 && this.gdw) || (this.gdt > 0 && this.gdy) || this.mHasNewVersion || this.gdA;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gdm = z;
                    break;
                case 2:
                    this.gdk = z;
                    break;
                case 3:
                    this.gdl = z;
                    break;
                case 4:
                    this.gdn = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gdo = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gdp = z;
                    break;
                case 9:
                    this.gdq = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().xA());
                    break;
            }
            mm(z2);
            bmU();
        }
    }

    private void bmU() {
        boolean z = this.gdm || this.gdl || this.gdk || this.gdn || this.gdo || this.gdp || this.gdq;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmV() {
        this.gdk = false;
        this.gdl = false;
        this.gdm = false;
        this.gdn = false;
        this.gdo = false;
        this.gdp = false;
        this.gdq = false;
        this.gdr = 0;
        this.gds = 0;
        this.gdt = 0;
        this.gdu = 0;
        this.gdv = false;
        this.mHasNewVersion = false;
        this.gdw = false;
        this.gdx = false;
        this.gdy = false;
        this.gdz = false;
        this.gdA = false;
        bmO();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.m.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gdB) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bmP();
    }
}
