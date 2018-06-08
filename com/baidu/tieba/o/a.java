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
    private CustomMessageListener dOz;
    private boolean gqO;
    private boolean gqP;
    private boolean gqQ;
    private boolean gqR;
    private boolean gqS;
    private boolean gqT;
    private boolean gqU;
    private boolean gqV;
    private int gqW;
    private int gqX;
    private int gqY;
    private int gqZ;
    private boolean gra;
    private boolean grb;
    private boolean grc;
    private boolean grd;
    private boolean gre;
    private boolean grf;
    private boolean grg;
    private boolean grh;
    private final CustomMessageListener gri;
    CustomMessageListener grj;
    private CustomMessageListener grk;
    private CustomMessageListener grl;
    private CustomMessageListener grm;
    private CustomMessageListener grn;
    private CustomMessageListener gro;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0200a {
        private static final a grq = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gqO = false;
        this.gqP = false;
        this.gqQ = false;
        this.gqR = false;
        this.gqS = false;
        this.gqT = false;
        this.gqU = false;
        this.gqV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gqW = 0;
        this.gqX = 0;
        this.gqY = 0;
        this.gqZ = 0;
        this.gra = false;
        this.mHasNewVersion = false;
        this.grb = false;
        this.grc = false;
        this.grd = false;
        this.gre = false;
        this.grf = false;
        this.grg = false;
        this.gri = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.grj = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gqZ >= responseUnreadPointNum.getNum()) {
                        a.this.gqZ = responseUnreadPointNum.getNum();
                        a.this.gra = false;
                    } else {
                        a.this.gra = true;
                        a.this.gqR = a.this.gra ? true : a.this.gqR;
                        a.this.gqZ = responseUnreadPointNum.getNum();
                        a.this.bpu();
                    }
                    a.this.bpt();
                }
            }
        };
        this.grk = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gqV = booleanValue;
                    a.this.grg = booleanValue;
                    a.this.bpu();
                }
            }
        };
        this.grl = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.gre = booleanValue;
                    a.this.gqT = booleanValue;
                    a.this.bpu();
                }
            }
        };
        this.grm = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gqS = a.this.mHasNewVersion ? true : a.this.gqS;
                    a.this.bpu();
                }
            }
        };
        this.dOz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bpw();
                    }
                }
            }
        };
        this.grn = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bpy();
                }
            }
        };
        this.gro = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Bu()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Bz = activityPrizeData.Bz();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Bz) && !Bz.equals(string)) {
                            a.this.gqU = true;
                            a.this.grf = true;
                            a.this.bpu();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bpq() {
        return C0200a.grq;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gri);
        MessageManager.getInstance().registerListener(this.grj);
        MessageManager.getInstance().registerListener(this.grm);
        MessageManager.getInstance().registerListener(this.grn);
        MessageManager.getInstance().registerListener(this.grl);
        MessageManager.getInstance().registerListener(this.dOz);
        MessageManager.getInstance().registerListener(this.grk);
        MessageManager.getInstance().registerListener(this.gro);
    }

    private void bpr() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gqS = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.grh = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bps() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gqS)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.grd = newsNotifyMessage.getMsgBookmark() > this.gqY;
            this.grb = newsNotifyMessage.getMsgFans() > this.gqW;
            this.grc = newsNotifyMessage.getMsgGiftNum() > this.gqX;
            this.gqY = newsNotifyMessage.getMsgBookmark();
            this.gqW = newsNotifyMessage.getMsgFans();
            this.gqX = newsNotifyMessage.getMsgGiftNum();
            if (this.grd || this.grb || this.grc || this.mHasNewVersion) {
                this.gqO = this.grb ? true : this.gqO;
                this.gqP = this.grd ? true : this.gqP;
                this.gqQ = this.grc ? true : this.gqQ;
                this.gqS = this.mHasNewVersion ? true : this.gqS;
                bpu();
            }
        }
    }

    public void bpt() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gra);
    }

    public void lP(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpu() {
        SparseArray sparseArray = new SparseArray();
        if (this.gra) {
            sparseArray.append(4, new b.a(this.gqR, this.gqZ));
        }
        if (this.grb) {
            sparseArray.append(2, new b.a(this.gqO, this.gqW));
        }
        if (this.grc) {
            sparseArray.append(1, new b.a(this.gqQ, this.gqX));
        }
        if (this.grd) {
            sparseArray.append(3, new b.a(this.gqP, this.gqY));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gqS, 0));
        }
        if (this.gre) {
            sparseArray.append(7, new b.a(this.gqT, 0));
        }
        if (this.grf) {
            sparseArray.append(9, new b.a(this.gqU, 0));
        }
        if (this.grg) {
            sparseArray.append(10, new b.a(this.gqV, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bpv();
    }

    public void lQ(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gqR, this.gqZ));
            sparseArray.append(2, new b.a(this.gqO, this.gqW));
            sparseArray.append(1, new b.a(this.gqQ, this.gqX));
            sparseArray.append(3, new b.a(this.gqP, this.gqY));
            sparseArray.append(5, new b.a(this.gqS, 0));
            sparseArray.append(7, new b.a(this.gqT, 0));
            sparseArray.append(9, new b.a(this.gqU, 0));
            sparseArray.append(10, new b.a(this.gqV, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bpv() {
        if (((this.gqW > 0 && this.grb) || (this.gqY > 0 && this.grd) || this.mHasNewVersion || this.grf || this.grg) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.grg) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bpw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gqQ = z;
                    break;
                case 2:
                    this.gqO = z;
                    break;
                case 3:
                    this.gqP = z;
                    break;
                case 4:
                    this.gqR = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gqS = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gqT = z;
                    break;
                case 9:
                    this.gqU = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Bz());
                    break;
                case 10:
                    this.gqV = z;
                    break;
            }
            lQ(true);
            bpx();
        }
    }

    private void bpx() {
        boolean z = this.gqQ || this.gqP || this.gqO || this.gqR || this.gqS || this.gqT || this.gqU;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bpy() {
        this.gqO = false;
        this.gqP = false;
        this.gqQ = false;
        this.gqR = false;
        this.gqS = false;
        this.gqT = false;
        this.gqU = false;
        this.gqW = 0;
        this.gqX = 0;
        this.gqY = 0;
        this.gqZ = 0;
        this.gra = false;
        this.mHasNewVersion = false;
        this.grb = false;
        this.grc = false;
        this.grd = false;
        this.gre = false;
        this.grf = false;
        bpr();
        e.im().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.grh) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bps();
    }
}
