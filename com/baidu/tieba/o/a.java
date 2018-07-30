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
    private CustomMessageListener dVC;
    private boolean gvS;
    private boolean gvT;
    private boolean gvU;
    private boolean gvV;
    private boolean gvW;
    private boolean gvX;
    private boolean gvY;
    private boolean gvZ;
    private int gwa;
    private int gwb;
    private int gwc;
    private int gwd;
    private boolean gwe;
    private boolean gwf;
    private boolean gwg;
    private boolean gwh;
    private boolean gwi;
    private boolean gwj;
    private boolean gwk;
    private boolean gwl;
    private final CustomMessageListener gwm;
    CustomMessageListener gwn;
    private CustomMessageListener gwo;
    private CustomMessageListener gwp;
    private CustomMessageListener gwq;
    private CustomMessageListener gwr;
    private CustomMessageListener gws;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0201a {
        private static final a gwu = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gvS = false;
        this.gvT = false;
        this.gvU = false;
        this.gvV = false;
        this.gvW = false;
        this.gvX = false;
        this.gvY = false;
        this.gvZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gwa = 0;
        this.gwb = 0;
        this.gwc = 0;
        this.gwd = 0;
        this.gwe = false;
        this.mHasNewVersion = false;
        this.gwf = false;
        this.gwg = false;
        this.gwh = false;
        this.gwi = false;
        this.gwj = false;
        this.gwk = false;
        this.gwm = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gwn = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gwd >= responseUnreadPointNum.getNum()) {
                        a.this.gwd = responseUnreadPointNum.getNum();
                        a.this.gwe = false;
                    } else {
                        a.this.gwe = true;
                        a.this.gvV = a.this.gwe ? true : a.this.gvV;
                        a.this.gwd = responseUnreadPointNum.getNum();
                        a.this.boB();
                    }
                    a.this.boA();
                }
            }
        };
        this.gwo = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gvZ = booleanValue;
                    a.this.gwk = booleanValue;
                    a.this.boB();
                }
            }
        };
        this.gwp = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gwi = booleanValue;
                    a.this.gvX = booleanValue;
                    a.this.boB();
                }
            }
        };
        this.gwq = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gvW = a.this.mHasNewVersion ? true : a.this.gvW;
                    a.this.boB();
                }
            }
        };
        this.dVC = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.boD();
                    }
                }
            }
        };
        this.gwr = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.boF();
                }
            }
        };
        this.gws = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.BD()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String BI = activityPrizeData.BI();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(BI) && !BI.equals(string)) {
                            a.this.gvY = true;
                            a.this.gwj = true;
                            a.this.boB();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a box() {
        return C0201a.gwu;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gwm);
        MessageManager.getInstance().registerListener(this.gwn);
        MessageManager.getInstance().registerListener(this.gwq);
        MessageManager.getInstance().registerListener(this.gwr);
        MessageManager.getInstance().registerListener(this.gwp);
        MessageManager.getInstance().registerListener(this.dVC);
        MessageManager.getInstance().registerListener(this.gwo);
        MessageManager.getInstance().registerListener(this.gws);
    }

    private void boy() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gvW = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gwl = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void boz() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gvW)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gwh = newsNotifyMessage.getMsgBookmark() > this.gwc;
            this.gwf = newsNotifyMessage.getMsgFans() > this.gwa;
            this.gwg = newsNotifyMessage.getMsgGiftNum() > this.gwb;
            this.gwc = newsNotifyMessage.getMsgBookmark();
            this.gwa = newsNotifyMessage.getMsgFans();
            this.gwb = newsNotifyMessage.getMsgGiftNum();
            if (this.gwh || this.gwf || this.gwg || this.mHasNewVersion) {
                this.gvS = this.gwf ? true : this.gvS;
                this.gvT = this.gwh ? true : this.gvT;
                this.gvU = this.gwg ? true : this.gvU;
                this.gvW = this.mHasNewVersion ? true : this.gvW;
                boB();
            }
        }
    }

    public void boA() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gwe);
    }

    public void lK(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boB() {
        SparseArray sparseArray = new SparseArray();
        if (this.gwe) {
            sparseArray.append(4, new b.a(this.gvV, this.gwd));
        }
        if (this.gwf) {
            sparseArray.append(2, new b.a(this.gvS, this.gwa));
        }
        if (this.gwg) {
            sparseArray.append(1, new b.a(this.gvU, this.gwb));
        }
        if (this.gwh) {
            sparseArray.append(3, new b.a(this.gvT, this.gwc));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gvW, 0));
        }
        if (this.gwi) {
            sparseArray.append(7, new b.a(this.gvX, 0));
        }
        if (this.gwj) {
            sparseArray.append(9, new b.a(this.gvY, 0));
        }
        if (this.gwk) {
            sparseArray.append(10, new b.a(this.gvZ, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        boC();
    }

    public void lL(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gvV, this.gwd));
            sparseArray.append(2, new b.a(this.gvS, this.gwa));
            sparseArray.append(1, new b.a(this.gvU, this.gwb));
            sparseArray.append(3, new b.a(this.gvT, this.gwc));
            sparseArray.append(5, new b.a(this.gvW, 0));
            sparseArray.append(7, new b.a(this.gvX, 0));
            sparseArray.append(9, new b.a(this.gvY, 0));
            sparseArray.append(10, new b.a(this.gvZ, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void boC() {
        if (((this.gwa > 0 && this.gwf) || (this.gwc > 0 && this.gwh) || this.mHasNewVersion || this.gwj || this.gwk) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gwk) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void boD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gvU = z;
                    break;
                case 2:
                    this.gvS = z;
                    break;
                case 3:
                    this.gvT = z;
                    break;
                case 4:
                    this.gvV = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gvW = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gvX = z;
                    break;
                case 9:
                    this.gvY = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().BI());
                    break;
                case 10:
                    this.gvZ = z;
                    break;
            }
            lL(true);
            boE();
        }
    }

    private void boE() {
        boolean z = this.gvU || this.gvT || this.gvS || this.gvV || this.gvW || this.gvX || this.gvY;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void boF() {
        this.gvS = false;
        this.gvT = false;
        this.gvU = false;
        this.gvV = false;
        this.gvW = false;
        this.gvX = false;
        this.gvY = false;
        this.gwa = 0;
        this.gwb = 0;
        this.gwc = 0;
        this.gwd = 0;
        this.gwe = false;
        this.mHasNewVersion = false;
        this.gwf = false;
        this.gwg = false;
        this.gwh = false;
        this.gwi = false;
        this.gwj = false;
        boy();
        e.in().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gwl) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        boz();
    }
}
