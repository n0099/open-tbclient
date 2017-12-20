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
    private CustomMessageListener dpw;
    private CustomMessageListener gdA;
    private CustomMessageListener gdB;
    private CustomMessageListener gdC;
    private boolean gdf;
    private boolean gdg;
    private boolean gdh;
    private boolean gdi;
    private boolean gdj;
    private boolean gdk;
    private boolean gdl;
    private int gdm;
    private int gdn;
    private int gdo;
    private int gdp;
    private boolean gdq;
    private boolean gdr;
    private boolean gds;
    private boolean gdt;
    private boolean gdu;
    private boolean gdv;
    private boolean gdw;
    private final CustomMessageListener gdx;
    CustomMessageListener gdy;
    private CustomMessageListener gdz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0122a {
        private static final a gdE = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gdf = false;
        this.gdg = false;
        this.gdh = false;
        this.gdi = false;
        this.gdj = false;
        this.gdk = false;
        this.gdl = false;
        this.gdm = 0;
        this.gdn = 0;
        this.gdo = 0;
        this.gdp = 0;
        this.gdq = false;
        this.mHasNewVersion = false;
        this.gdr = false;
        this.gds = false;
        this.gdt = false;
        this.gdu = false;
        this.gdv = false;
        this.gdx = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.gdy = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gdp >= responseUnreadPointNum.getNum()) {
                        a.this.gdp = responseUnreadPointNum.getNum();
                        a.this.gdq = false;
                    } else {
                        a.this.gdq = true;
                        a.this.gdi = a.this.gdq ? true : a.this.gdi;
                        a.this.gdp = responseUnreadPointNum.getNum();
                        a.this.bmQ();
                    }
                    a.this.bmP();
                }
            }
        };
        this.gdz = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.m.a.3
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
                    a.this.gdu = booleanValue;
                    a.this.gdk = booleanValue;
                    a.this.bmQ();
                }
            }
        };
        this.gdA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.m.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gdj = a.this.mHasNewVersion ? true : a.this.gdj;
                    a.this.bmQ();
                }
            }
        };
        this.dpw = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bmS();
                    }
                }
            }
        };
        this.gdB = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bmU();
                }
            }
        };
        this.gdC = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.m.a.7
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
                            a.this.gdl = true;
                            a.this.gdv = true;
                            a.this.bmQ();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bmM() {
        return C0122a.gdE;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gdx);
        MessageManager.getInstance().registerListener(this.gdy);
        MessageManager.getInstance().registerListener(this.gdA);
        MessageManager.getInstance().registerListener(this.gdB);
        MessageManager.getInstance().registerListener(this.gdz);
        MessageManager.getInstance().registerListener(this.dpw);
        MessageManager.getInstance().registerListener(this.gdC);
    }

    private void bmN() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gdj = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gdw = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bmO() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.gdj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gdt = newsNotifyMessage.getMsgBookmark() > this.gdo;
            this.gdr = newsNotifyMessage.getMsgFans() > this.gdm;
            this.gds = newsNotifyMessage.getMsgGiftNum() > this.gdn;
            this.gdo = newsNotifyMessage.getMsgBookmark();
            this.gdm = newsNotifyMessage.getMsgFans();
            this.gdn = newsNotifyMessage.getMsgGiftNum();
            if (this.gdt || this.gdr || this.gds || this.mHasNewVersion) {
                this.gdf = this.gdr ? true : this.gdf;
                this.gdg = this.gdt ? true : this.gdg;
                this.gdh = this.gds ? true : this.gdh;
                this.gdj = this.mHasNewVersion ? true : this.gdj;
                bmQ();
            }
        }
    }

    public void bmP() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gdq);
    }

    public void ml(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmQ() {
        SparseArray sparseArray = new SparseArray();
        if (this.gdq) {
            sparseArray.append(4, new b.a(this.gdi, this.gdp));
        }
        if (this.gdr) {
            sparseArray.append(2, new b.a(this.gdf, this.gdm));
        }
        if (this.gds) {
            sparseArray.append(1, new b.a(this.gdh, this.gdn));
        }
        if (this.gdt) {
            sparseArray.append(3, new b.a(this.gdg, this.gdo));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gdj, 0));
        }
        if (this.gdu) {
            sparseArray.append(7, new b.a(this.gdk, 0));
        }
        if (this.gdv) {
            sparseArray.append(9, new b.a(this.gdl, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bmR();
    }

    public void mm(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gdi, this.gdp));
            sparseArray.append(2, new b.a(this.gdf, this.gdm));
            sparseArray.append(1, new b.a(this.gdh, this.gdn));
            sparseArray.append(3, new b.a(this.gdg, this.gdo));
            sparseArray.append(5, new b.a(this.gdj, 0));
            sparseArray.append(7, new b.a(this.gdk, 0));
            sparseArray.append(9, new b.a(this.gdl, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bmR() {
        boolean z = (this.gdm > 0 && this.gdr) || (this.gdo > 0 && this.gdt) || this.mHasNewVersion || this.gdv;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gdh = z;
                    break;
                case 2:
                    this.gdf = z;
                    break;
                case 3:
                    this.gdg = z;
                    break;
                case 4:
                    this.gdi = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gdj = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gdk = z;
                    break;
                case 9:
                    this.gdl = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().xA());
                    break;
            }
            mm(z2);
            bmT();
        }
    }

    private void bmT() {
        boolean z = this.gdh || this.gdg || this.gdf || this.gdi || this.gdj || this.gdk || this.gdl;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bmU() {
        this.gdf = false;
        this.gdg = false;
        this.gdh = false;
        this.gdi = false;
        this.gdj = false;
        this.gdk = false;
        this.gdl = false;
        this.gdm = 0;
        this.gdn = 0;
        this.gdo = 0;
        this.gdp = 0;
        this.gdq = false;
        this.mHasNewVersion = false;
        this.gdr = false;
        this.gds = false;
        this.gdt = false;
        this.gdu = false;
        this.gdv = false;
        bmN();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.m.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gdw) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bmO();
    }
}
