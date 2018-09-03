package com.baidu.tieba.o;

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
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.o.b;
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener dVx;
    private boolean gvV;
    private boolean gvW;
    private boolean gvX;
    private boolean gvY;
    private boolean gvZ;
    private boolean gwa;
    private boolean gwb;
    private boolean gwc;
    private int gwd;
    private int gwe;
    private int gwf;
    private int gwg;
    private boolean gwh;
    private boolean gwi;
    private boolean gwj;
    private boolean gwk;
    private boolean gwl;
    private boolean gwm;
    private boolean gwn;
    private boolean gwo;
    private final CustomMessageListener gwp;
    CustomMessageListener gwq;
    private CustomMessageListener gwr;
    private CustomMessageListener gws;
    private CustomMessageListener gwt;
    private CustomMessageListener gwu;
    private CustomMessageListener gwv;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0201a {
        private static final a gwx = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gvV = false;
        this.gvW = false;
        this.gvX = false;
        this.gvY = false;
        this.gvZ = false;
        this.gwa = false;
        this.gwb = false;
        this.gwc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gwd = 0;
        this.gwe = 0;
        this.gwf = 0;
        this.gwg = 0;
        this.gwh = false;
        this.mHasNewVersion = false;
        this.gwi = false;
        this.gwj = false;
        this.gwk = false;
        this.gwl = false;
        this.gwm = false;
        this.gwn = false;
        this.gwp = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gwq = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gwg >= responseUnreadPointNum.getNum()) {
                        a.this.gwg = responseUnreadPointNum.getNum();
                        a.this.gwh = false;
                    } else {
                        a.this.gwh = true;
                        a.this.gvY = a.this.gwh ? true : a.this.gvY;
                        a.this.gwg = responseUnreadPointNum.getNum();
                        a.this.boC();
                    }
                    a.this.boB();
                }
            }
        };
        this.gwr = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gwc = booleanValue;
                    a.this.gwn = booleanValue;
                    a.this.boC();
                }
            }
        };
        this.gws = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gwl = booleanValue;
                    a.this.gwa = booleanValue;
                    a.this.boC();
                }
            }
        };
        this.gwt = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gvZ = a.this.mHasNewVersion ? true : a.this.gvZ;
                    a.this.boC();
                }
            }
        };
        this.dVx = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.boE();
                    }
                }
            }
        };
        this.gwu = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.boG();
                }
            }
        };
        this.gwv = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.BA()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String BF = activityPrizeData.BF();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(BF) && !BF.equals(string)) {
                            a.this.gwb = true;
                            a.this.gwm = true;
                            a.this.boC();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a boy() {
        return C0201a.gwx;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gwp);
        MessageManager.getInstance().registerListener(this.gwq);
        MessageManager.getInstance().registerListener(this.gwt);
        MessageManager.getInstance().registerListener(this.gwu);
        MessageManager.getInstance().registerListener(this.gws);
        MessageManager.getInstance().registerListener(this.dVx);
        MessageManager.getInstance().registerListener(this.gwr);
        MessageManager.getInstance().registerListener(this.gwv);
    }

    private void boz() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gvZ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gwo = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void boA() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gvZ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gwk = newsNotifyMessage.getMsgBookmark() > this.gwf;
            this.gwi = newsNotifyMessage.getMsgFans() > this.gwd;
            this.gwj = newsNotifyMessage.getMsgGiftNum() > this.gwe;
            this.gwf = newsNotifyMessage.getMsgBookmark();
            this.gwd = newsNotifyMessage.getMsgFans();
            this.gwe = newsNotifyMessage.getMsgGiftNum();
            if (this.gwk || this.gwi || this.gwj || this.mHasNewVersion) {
                this.gvV = this.gwi ? true : this.gvV;
                this.gvW = this.gwk ? true : this.gvW;
                this.gvX = this.gwj ? true : this.gvX;
                this.gvZ = this.mHasNewVersion ? true : this.gvZ;
                boC();
            }
        }
    }

    public void boB() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gwh);
    }

    public void lK(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
        SparseArray sparseArray = new SparseArray();
        if (this.gwh) {
            sparseArray.append(4, new b.a(this.gvY, this.gwg));
        }
        if (this.gwi) {
            sparseArray.append(2, new b.a(this.gvV, this.gwd));
        }
        if (this.gwj) {
            sparseArray.append(1, new b.a(this.gvX, this.gwe));
        }
        if (this.gwk) {
            sparseArray.append(3, new b.a(this.gvW, this.gwf));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gvZ, 0));
        }
        if (this.gwl) {
            sparseArray.append(7, new b.a(this.gwa, 0));
        }
        if (this.gwm) {
            sparseArray.append(9, new b.a(this.gwb, 0));
        }
        if (this.gwn) {
            sparseArray.append(10, new b.a(this.gwc, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        boD();
    }

    public void lL(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gvY, this.gwg));
            sparseArray.append(2, new b.a(this.gvV, this.gwd));
            sparseArray.append(1, new b.a(this.gvX, this.gwe));
            sparseArray.append(3, new b.a(this.gvW, this.gwf));
            sparseArray.append(5, new b.a(this.gvZ, 0));
            sparseArray.append(7, new b.a(this.gwa, 0));
            sparseArray.append(9, new b.a(this.gwb, 0));
            sparseArray.append(10, new b.a(this.gwc, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void boD() {
        if (((this.gwd > 0 && this.gwi) || (this.gwf > 0 && this.gwk) || this.mHasNewVersion || this.gwm || this.gwn) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gwn) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void boE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gvX = z;
                    break;
                case 2:
                    this.gvV = z;
                    break;
                case 3:
                    this.gvW = z;
                    break;
                case 4:
                    this.gvY = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gvZ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gwa = z;
                    break;
                case 9:
                    this.gwb = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().BF());
                    break;
                case 10:
                    this.gwc = z;
                    break;
            }
            lL(true);
            boF();
        }
    }

    private void boF() {
        boolean z = this.gvX || this.gvW || this.gvV || this.gvY || this.gvZ || this.gwa || this.gwb;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void boG() {
        this.gvV = false;
        this.gvW = false;
        this.gvX = false;
        this.gvY = false;
        this.gvZ = false;
        this.gwa = false;
        this.gwb = false;
        this.gwd = 0;
        this.gwe = 0;
        this.gwf = 0;
        this.gwg = 0;
        this.gwh = false;
        this.mHasNewVersion = false;
        this.gwi = false;
        this.gwj = false;
        this.gwk = false;
        this.gwl = false;
        this.gwm = false;
        boz();
        e.in().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gwo) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        boA();
    }
}
