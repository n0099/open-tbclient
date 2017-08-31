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
    private CustomMessageListener cZN;
    private boolean fJN;
    private boolean fJO;
    private boolean fJP;
    private boolean fJQ;
    private boolean fJR;
    private boolean fJS;
    private int fJT;
    private int fJU;
    private int fJV;
    private int fJW;
    private int fJX;
    private boolean fJY;
    private boolean fJZ;
    private boolean fKa;
    private boolean fKb;
    private boolean fKc;
    private boolean fKd;
    private boolean fKe;
    private boolean fKf;
    private final CustomMessageListener fKg;
    CustomMessageListener fKh;
    private CustomMessageListener fKi;
    private CustomMessageListener fKj;
    private CustomMessageListener fKk;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0105a {
        private static final a fKm = new a();
    }

    private a() {
        this.isPrimary = false;
        this.fJN = false;
        this.fJO = false;
        this.fJP = false;
        this.fJQ = false;
        this.fJR = false;
        this.fJS = false;
        this.fJT = 0;
        this.fJU = 0;
        this.fJV = 0;
        this.fJW = 0;
        this.fJX = 0;
        this.fJY = false;
        this.mHasNewVersion = false;
        this.fJZ = false;
        this.fKa = false;
        this.fKb = false;
        this.fKc = false;
        this.fKd = false;
        this.fKf = false;
        this.fKg = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.h(customResponsedMessage);
                }
            }
        };
        this.fKh = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.j.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.fJX >= responseUnreadPointNum.getNum()) {
                        a.this.fJX = responseUnreadPointNum.getNum();
                        a.this.fJY = false;
                    } else {
                        a.this.fJY = true;
                        a.this.fJQ = a.this.fJY ? true : a.this.fJQ;
                        a.this.fJX = responseUnreadPointNum.getNum();
                        a.this.bic();
                    }
                    a.this.bib();
                }
            }
        };
        this.fKi = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.j.a.3
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
                    a.this.fKc = booleanValue;
                    a.this.fJS = booleanValue;
                    a.this.bic();
                }
            }
        };
        this.fKj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.j.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.fJR = a.this.mHasNewVersion ? true : a.this.fJR;
                    a.this.bic();
                }
            }
        };
        this.cZN = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.j.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bie();
                    }
                }
            }
        };
        this.fKk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.j.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bik();
                }
            }
        };
        initListener();
    }

    public static final a bhY() {
        return C0105a.fKm;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.fKg);
        MessageManager.getInstance().registerListener(this.fKh);
        MessageManager.getInstance().registerListener(this.fKj);
        MessageManager.getInstance().registerListener(this.fKk);
        MessageManager.getInstance().registerListener(this.fKi);
        MessageManager.getInstance().registerListener(this.cZN);
    }

    private void bhZ() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.fJR = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fKe = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bia() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.fJR)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.fKb = newsNotifyMessage.getMsgBookmark() > this.fJW;
            this.fJZ = newsNotifyMessage.getMsgFans() > this.fJT;
            this.fKa = newsNotifyMessage.getMsgGiftNum() > this.fJU;
            this.fJW = newsNotifyMessage.getMsgBookmark();
            this.fJT = newsNotifyMessage.getMsgFans();
            this.fJU = newsNotifyMessage.getMsgGiftNum();
            this.fJV = newsNotifyMessage.getMsgLiveVip();
            if (this.fKb || this.fJZ || this.fKa || this.mHasNewVersion) {
                this.fJN = this.fJZ ? true : this.fJN;
                this.fJO = this.fKb ? true : this.fJO;
                this.fJP = this.fKa ? true : this.fJP;
                this.fJR = this.mHasNewVersion ? true : this.fJR;
                bic();
            }
        }
    }

    public void bib() {
        if (this.fJY) {
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

    public void lO(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bic() {
        SparseArray sparseArray = new SparseArray();
        if (this.fJY) {
            sparseArray.append(4, new b.a(this.fJQ, this.fJX));
        }
        if (this.fJZ) {
            sparseArray.append(2, new b.a(this.fJN, this.fJT));
        }
        if (this.fKa) {
            sparseArray.append(1, new b.a(this.fJP, this.fJU));
        }
        if (this.fKb) {
            sparseArray.append(3, new b.a(this.fJO, this.fJW));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.fJR, 0));
        }
        if (this.fKc) {
            sparseArray.append(7, new b.a(this.fJS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        bid();
    }

    public void lP(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.fJQ, this.fJX));
            sparseArray.append(2, new b.a(this.fJN, this.fJT));
            sparseArray.append(1, new b.a(this.fJP, this.fJU));
            sparseArray.append(3, new b.a(this.fJO, this.fJW));
            sparseArray.append(5, new b.a(this.fJR, 0));
            sparseArray.append(7, new b.a(this.fJS, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void bid() {
        boolean z = (this.fJT > 0 && this.fJZ) || (this.fJX > 0 && this.fJY) || ((this.fJW > 0 && this.fKb) || this.mHasNewVersion || this.fJS);
        if (z && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bie() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.fJP = z;
                    break;
                case 2:
                    this.fJN = z;
                    break;
                case 3:
                    this.fJO = z;
                    break;
                case 4:
                    this.fJQ = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.fKf = true;
                    this.fJR = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.fJS = z;
                    break;
            }
            lP(z2);
            bif();
        }
    }

    private void bif() {
        boolean z = this.fJP || this.fJO || this.fJN || this.fJQ || this.fJR || this.fJS;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public boolean big() {
        return this.fJN;
    }

    public boolean bih() {
        return this.fJO;
    }

    public boolean bii() {
        return this.fJQ;
    }

    public boolean bij() {
        return this.fJP;
    }

    public void bik() {
        this.fJN = false;
        this.fJO = false;
        this.fJP = false;
        this.fJQ = false;
        this.fJR = false;
        this.fJS = false;
        this.fJT = 0;
        this.fJU = 0;
        this.fJV = 0;
        this.fJW = 0;
        this.fJX = 0;
        this.fJY = false;
        this.mHasNewVersion = false;
        this.fJZ = false;
        this.fKa = false;
        this.fKb = false;
        this.fKd = false;
        this.fKc = false;
        bhZ();
        e.fQ().post(new Runnable() { // from class: com.baidu.tieba.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fKe) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bia();
    }
}
