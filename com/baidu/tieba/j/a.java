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
    private CustomMessageListener cPS;
    private boolean fIF;
    private boolean fIG;
    private boolean fIH;
    private boolean fII;
    private boolean fIJ;
    private boolean fIK;
    private boolean fIL;
    private int fIM;
    private int fIN;
    private int fIO;
    private int fIP;
    private int fIQ;
    private boolean fIR;
    private boolean fIS;
    private boolean fIT;
    private boolean fIU;
    private boolean fIV;
    private boolean fIW;
    private boolean fIX;
    private boolean fIY;
    private boolean fIZ;
    private final CustomMessageListener fJa;
    CustomMessageListener fJb;
    private CustomMessageListener fJc;
    private CustomMessageListener fJd;
    private CustomMessageListener fJe;
    private CustomMessageListener fJf;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0103a {
        private static final a fJh = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fIF = false;
        this.fIG = false;
        this.fIH = false;
        this.fII = false;
        this.fIJ = false;
        this.fIK = false;
        this.fIL = false;
        this.fIM = 0;
        this.fIN = 0;
        this.fIO = 0;
        this.fIP = 0;
        this.fIQ = 0;
        this.fIR = false;
        this.mHasNewVersion = false;
        this.fIS = false;
        this.fIT = false;
        this.fIU = false;
        this.fIV = false;
        this.fIW = false;
        this.fIX = false;
        this.fIZ = false;
        this.fJa = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fJb = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fIQ >= responseUnreadPointNum.getNum()) {
                        a.this.fIQ = responseUnreadPointNum.getNum();
                        a.this.fIR = false;
                    } else {
                        a.this.fIR = true;
                        a.this.fII = a.this.fIR ? true : a.this.fII;
                        a.this.fIQ = responseUnreadPointNum.getNum();
                        a.this.bis();
                    }
                    a.this.bir();
                }
            }
        };
        this.fJc = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fIW = true;
                    a.this.fIL = booleanValue;
                    a.this.bis();
                }
            }
        };
        this.fJd = new CustomMessageListener(CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.getInst().getLastUpdateThemeTime()) {
                    a.this.fIS = true;
                    a.this.fIK = a.this.fIS ? true : a.this.fIK;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                    a.this.bis();
                }
            }
        };
        this.fJe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fIJ = a.this.mHasNewVersion ? true : a.this.fIJ;
                    a.this.bis();
                }
            }
        };
        this.cPS = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.biv();
                    }
                }
            }
        };
        this.fJf = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.biB();
                }
            }
        };
        initListener();
    }

    public static final a bio() {
        return C0103a.fJh;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fJa);
        MessageManager.getInstance().registerListener(this.fJb);
        MessageManager.getInstance().registerListener(this.fJd);
        MessageManager.getInstance().registerListener(this.fJe);
        MessageManager.getInstance().registerListener(this.fJf);
        MessageManager.getInstance().registerListener(this.fJc);
        MessageManager.getInstance().registerListener(this.cPS);
    }

    private void bip() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fIJ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fIY = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void biq() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fIJ || this.fIK)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fIV = newsNotifyMessage.getMsgBookmark() > this.fIP;
            this.fIT = newsNotifyMessage.getMsgFans() > this.fIM;
            this.fIU = newsNotifyMessage.getMsgGiftNum() > this.fIN;
            this.fIP = newsNotifyMessage.getMsgBookmark();
            this.fIM = newsNotifyMessage.getMsgFans();
            this.fIN = newsNotifyMessage.getMsgGiftNum();
            this.fIO = newsNotifyMessage.getMsgLiveVip();
            if (this.fIV || this.fIT || this.fIU || this.mHasNewVersion) {
                this.fIF = this.fIT ? true : this.fIF;
                this.fIG = this.fIV ? true : this.fIG;
                this.fIH = this.fIU ? true : this.fIH;
                this.fIJ = this.mHasNewVersion ? true : this.fIJ;
                bis();
            }
        }
    }

    public void bir() {
        if (this.fIR) {
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
    public void bis() {
        SparseArray sparseArray = new SparseArray();
        if (this.fIR) {
            sparseArray.append(4, new b.a(this.fII, this.fIQ));
        }
        if (this.fIT) {
            sparseArray.append(2, new b.a(this.fIF, this.fIM));
        }
        if (this.fIU) {
            sparseArray.append(1, new b.a(this.fIH, this.fIN));
        }
        if (this.fIV) {
            sparseArray.append(3, new b.a(this.fIG, this.fIP));
        }
        if (this.fIS) {
            sparseArray.append(6, new b.a(this.fIK, 0));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fIJ, 0));
        }
        if (this.fIW) {
            sparseArray.append(7, new b.a(this.fIL, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        biu();
    }

    public void bit() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.append(4, new b.a(this.fII, this.fIQ));
        sparseArray.append(2, new b.a(this.fIF, this.fIM));
        sparseArray.append(1, new b.a(this.fIH, this.fIN));
        sparseArray.append(3, new b.a(this.fIG, this.fIP));
        sparseArray.append(6, new b.a(this.fIK, 0));
        sparseArray.append(5, new b.a(this.fIJ, 0));
        sparseArray.append(7, new b.a(this.fIL, 0));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
    }

    private void biu() {
        boolean z = (this.fIM > 0 && this.fIT) || (this.fIQ > 0 && this.fIR) || ((this.fIP > 0 && this.fIV) || this.mHasNewVersion || this.fIS || this.fIW);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void biv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void D(int i, boolean z) {
        String currentAccount;
        switch (i) {
            case 1:
                this.fIH = z;
                break;
            case 2:
                this.fIF = z;
                break;
            case 3:
                this.fIG = z;
                break;
            case 4:
                this.fII = z;
                break;
            case 5:
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                }
                this.fIZ = true;
                this.fIJ = z;
                break;
            case 6:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                this.fIK = z;
                break;
            case 7:
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                this.fIL = z;
                break;
        }
        bit();
        biw();
    }

    private void biw() {
        boolean z = this.fIH || this.fIG || this.fIF || this.fII || this.fIJ || this.fIK || this.fIL;
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean bix() {
        return this.fIF;
    }

    public boolean biy() {
        return this.fIG;
    }

    public boolean biz() {
        return this.fII;
    }

    public boolean biA() {
        return this.fIH;
    }

    public void biB() {
        this.fIF = false;
        this.fIG = false;
        this.fIH = false;
        this.fII = false;
        this.fIJ = false;
        this.fIK = false;
        this.fIL = false;
        this.fIM = 0;
        this.fIN = 0;
        this.fIO = 0;
        this.fIP = 0;
        this.fIQ = 0;
        this.fIR = false;
        this.mHasNewVersion = false;
        this.fIT = false;
        this.fIU = false;
        this.fIV = false;
        this.fIX = false;
        this.fIW = false;
        bip();
        e.fP().post(new Runnable() { // from class: com.baidu.tieba.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fIY) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        biq();
    }
}
