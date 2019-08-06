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
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener gfz;
    private boolean gob;
    private boolean iOM;
    private boolean iON;
    private boolean iOO;
    private boolean iOP;
    private boolean iOQ;
    private boolean iOR;
    private boolean iOS;
    private boolean iOT;
    private int iOU;
    private int iOV;
    private int iOW;
    private int iOX;
    private boolean iOY;
    private boolean iOZ;
    private boolean iPa;
    private boolean iPb;
    private boolean iPc;
    private boolean iPd;
    private boolean iPe;
    private final CustomMessageListener iPf;
    CustomMessageListener iPg;
    private CustomMessageListener iPh;
    private CustomMessageListener iPi;
    private CustomMessageListener iPj;
    private CustomMessageListener iPk;
    private CustomMessageListener iPl;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0367a {
        private static final a iPn = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iOM = false;
        this.iON = false;
        this.iOO = false;
        this.iOP = false;
        this.iOQ = false;
        this.iOR = false;
        this.iOS = false;
        this.iOT = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_feedback_tip_show", false);
        this.iOU = 0;
        this.iOV = 0;
        this.iOW = 0;
        this.iOX = 0;
        this.iOY = false;
        this.mHasNewVersion = false;
        this.iOZ = false;
        this.iPa = false;
        this.iPb = false;
        this.iPc = false;
        this.iPd = false;
        this.iPe = false;
        this.iPf = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iPg = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iOX >= responseUnreadPointNum.getNum()) {
                        a.this.iOX = responseUnreadPointNum.getNum();
                        a.this.iOY = false;
                    } else {
                        a.this.iOY = true;
                        a.this.iOP = a.this.iOY ? true : a.this.iOP;
                        a.this.iOX = responseUnreadPointNum.getNum();
                        a.this.cjn();
                    }
                    a.this.cjm();
                }
            }
        };
        this.iPh = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iOT = booleanValue;
                    a.this.iPe = booleanValue;
                    a.this.cjn();
                }
            }
        };
        this.iPi = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iPc = booleanValue;
                    a.this.iOR = booleanValue;
                    a.this.cjn();
                }
            }
        };
        this.iPj = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iOQ = a.this.mHasNewVersion ? true : a.this.iOQ;
                    a.this.cjn();
                }
            }
        };
        this.gfz = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cjp();
                    }
                }
            }
        };
        this.iPk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cjr();
                }
            }
        };
        this.iPl = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.alS()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String alX = activityPrizeData.alX();
                        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(alX) && !alX.equals(string)) {
                            a.this.iOS = true;
                            a.this.iPd = true;
                            a.this.cjn();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cjj() {
        return C0367a.iPn;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iPf);
        MessageManager.getInstance().registerListener(this.iPg);
        MessageManager.getInstance().registerListener(this.iPj);
        MessageManager.getInstance().registerListener(this.iPk);
        MessageManager.getInstance().registerListener(this.iPi);
        MessageManager.getInstance().registerListener(this.gfz);
        MessageManager.getInstance().registerListener(this.iPh);
        MessageManager.getInstance().registerListener(this.iPl);
    }

    private void cjk() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iOQ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gob = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cjl() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iOQ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iPb = newsNotifyMessage.getMsgBookmark() > this.iOW;
            this.iOZ = newsNotifyMessage.getMsgFans() > this.iOU;
            this.iPa = newsNotifyMessage.getMsgGiftNum() > this.iOV;
            this.iOW = newsNotifyMessage.getMsgBookmark();
            this.iOU = newsNotifyMessage.getMsgFans();
            this.iOV = newsNotifyMessage.getMsgGiftNum();
            if (this.iPb || this.iOZ || this.iPa || this.mHasNewVersion) {
                this.iOM = this.iOZ ? true : this.iOM;
                this.iON = this.iPb ? true : this.iON;
                this.iOO = this.iPa ? true : this.iOO;
                this.iOQ = this.mHasNewVersion ? true : this.iOQ;
                cjn();
            }
        }
    }

    public void cjm() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iOY);
    }

    public void qy(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjn() {
        SparseArray sparseArray = new SparseArray();
        if (this.iOY) {
            sparseArray.append(4, new b.a(this.iOP, this.iOX));
        }
        if (this.iOZ) {
            sparseArray.append(2, new b.a(this.iOM, this.iOU));
        }
        if (this.iPa) {
            sparseArray.append(1, new b.a(this.iOO, this.iOV));
        }
        if (this.iPb) {
            sparseArray.append(3, new b.a(this.iON, this.iOW));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iOQ, 0));
        }
        if (this.iPc) {
            sparseArray.append(7, new b.a(this.iOR, 0));
        }
        if (this.iPd) {
            sparseArray.append(9, new b.a(this.iOS, 0));
        }
        if (this.iPe) {
            sparseArray.append(10, new b.a(this.iOT, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        cjo();
    }

    public void qz(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iOP, this.iOX));
            sparseArray.append(2, new b.a(this.iOM, this.iOU));
            sparseArray.append(1, new b.a(this.iOO, this.iOV));
            sparseArray.append(3, new b.a(this.iON, this.iOW));
            sparseArray.append(5, new b.a(this.iOQ, 0));
            sparseArray.append(7, new b.a(this.iOR, 0));
            sparseArray.append(9, new b.a(this.iOS, 0));
            sparseArray.append(10, new b.a(this.iOT, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void cjo() {
        if (((this.iOU > 0 && this.iOZ) || (this.iOW > 0 && this.iPb) || this.mHasNewVersion || this.iPd || this.iPe) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iPe) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cjp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void e(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iOO = z;
                    break;
                case 2:
                    this.iOM = z;
                    break;
                case 3:
                    this.iON = z;
                    break;
                case 4:
                    this.iOP = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iOQ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iOR = z;
                    break;
                case 9:
                    this.iOS = z;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().alX());
                    break;
                case 10:
                    this.iOT = z;
                    break;
            }
            qz(true);
            cjq();
        }
    }

    private void cjq() {
        boolean z = this.iOO || this.iON || this.iOM || this.iOP || this.iOQ || this.iOR || this.iOS;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cjr() {
        this.iOM = false;
        this.iON = false;
        this.iOO = false;
        this.iOP = false;
        this.iOQ = false;
        this.iOR = false;
        this.iOS = false;
        this.iOU = 0;
        this.iOV = 0;
        this.iOW = 0;
        this.iOX = 0;
        this.iOY = false;
        this.mHasNewVersion = false;
        this.iOZ = false;
        this.iPa = false;
        this.iPb = false;
        this.iPc = false;
        this.iPd = false;
        cjk();
        e.iK().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gob) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cjl();
    }
}
