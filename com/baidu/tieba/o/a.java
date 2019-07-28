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
    private CustomMessageListener geJ;
    private boolean gnj;
    private boolean iNI;
    private boolean iNJ;
    private boolean iNK;
    private boolean iNL;
    private boolean iNM;
    private boolean iNN;
    private boolean iNO;
    private boolean iNP;
    private int iNQ;
    private int iNR;
    private int iNS;
    private int iNT;
    private boolean iNU;
    private boolean iNV;
    private boolean iNW;
    private boolean iNX;
    private boolean iNY;
    private boolean iNZ;
    private boolean iOa;
    private final CustomMessageListener iOb;
    CustomMessageListener iOc;
    private CustomMessageListener iOd;
    private CustomMessageListener iOe;
    private CustomMessageListener iOf;
    private CustomMessageListener iOg;
    private CustomMessageListener iOh;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0367a {
        private static final a iOj = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iNI = false;
        this.iNJ = false;
        this.iNK = false;
        this.iNL = false;
        this.iNM = false;
        this.iNN = false;
        this.iNO = false;
        this.iNP = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_feedback_tip_show", false);
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = 0;
        this.iNU = false;
        this.mHasNewVersion = false;
        this.iNV = false;
        this.iNW = false;
        this.iNX = false;
        this.iNY = false;
        this.iNZ = false;
        this.iOa = false;
        this.iOb = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iOc = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iNT >= responseUnreadPointNum.getNum()) {
                        a.this.iNT = responseUnreadPointNum.getNum();
                        a.this.iNU = false;
                    } else {
                        a.this.iNU = true;
                        a.this.iNL = a.this.iNU ? true : a.this.iNL;
                        a.this.iNT = responseUnreadPointNum.getNum();
                        a.this.ciV();
                    }
                    a.this.ciU();
                }
            }
        };
        this.iOd = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iNP = booleanValue;
                    a.this.iOa = booleanValue;
                    a.this.ciV();
                }
            }
        };
        this.iOe = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.ahO().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iNY = booleanValue;
                    a.this.iNN = booleanValue;
                    a.this.ciV();
                }
            }
        };
        this.iOf = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iNM = a.this.mHasNewVersion ? true : a.this.iNM;
                    a.this.ciV();
                }
            }
        };
        this.geJ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.ciX();
                    }
                }
            }
        };
        this.iOg = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.ciZ();
                }
            }
        };
        this.iOh = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.alQ()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String alV = activityPrizeData.alV();
                        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(alV) && !alV.equals(string)) {
                            a.this.iNO = true;
                            a.this.iNZ = true;
                            a.this.ciV();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a ciR() {
        return C0367a.iOj;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iOb);
        MessageManager.getInstance().registerListener(this.iOc);
        MessageManager.getInstance().registerListener(this.iOf);
        MessageManager.getInstance().registerListener(this.iOg);
        MessageManager.getInstance().registerListener(this.iOe);
        MessageManager.getInstance().registerListener(this.geJ);
        MessageManager.getInstance().registerListener(this.iOd);
        MessageManager.getInstance().registerListener(this.iOh);
    }

    private void ciS() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iNM = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gnj = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void ciT() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iNM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iNX = newsNotifyMessage.getMsgBookmark() > this.iNS;
            this.iNV = newsNotifyMessage.getMsgFans() > this.iNQ;
            this.iNW = newsNotifyMessage.getMsgGiftNum() > this.iNR;
            this.iNS = newsNotifyMessage.getMsgBookmark();
            this.iNQ = newsNotifyMessage.getMsgFans();
            this.iNR = newsNotifyMessage.getMsgGiftNum();
            if (this.iNX || this.iNV || this.iNW || this.mHasNewVersion) {
                this.iNI = this.iNV ? true : this.iNI;
                this.iNJ = this.iNX ? true : this.iNJ;
                this.iNK = this.iNW ? true : this.iNK;
                this.iNM = this.mHasNewVersion ? true : this.iNM;
                ciV();
            }
        }
    }

    public void ciU() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iNU);
    }

    public void qx(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciV() {
        SparseArray sparseArray = new SparseArray();
        if (this.iNU) {
            sparseArray.append(4, new b.a(this.iNL, this.iNT));
        }
        if (this.iNV) {
            sparseArray.append(2, new b.a(this.iNI, this.iNQ));
        }
        if (this.iNW) {
            sparseArray.append(1, new b.a(this.iNK, this.iNR));
        }
        if (this.iNX) {
            sparseArray.append(3, new b.a(this.iNJ, this.iNS));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iNM, 0));
        }
        if (this.iNY) {
            sparseArray.append(7, new b.a(this.iNN, 0));
        }
        if (this.iNZ) {
            sparseArray.append(9, new b.a(this.iNO, 0));
        }
        if (this.iOa) {
            sparseArray.append(10, new b.a(this.iNP, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        ciW();
    }

    public void qy(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iNL, this.iNT));
            sparseArray.append(2, new b.a(this.iNI, this.iNQ));
            sparseArray.append(1, new b.a(this.iNK, this.iNR));
            sparseArray.append(3, new b.a(this.iNJ, this.iNS));
            sparseArray.append(5, new b.a(this.iNM, 0));
            sparseArray.append(7, new b.a(this.iNN, 0));
            sparseArray.append(9, new b.a(this.iNO, 0));
            sparseArray.append(10, new b.a(this.iNP, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void ciW() {
        if (((this.iNQ > 0 && this.iNV) || (this.iNS > 0 && this.iNX) || this.mHasNewVersion || this.iNZ || this.iOa) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iOa) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void ciX() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void e(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iNK = z;
                    break;
                case 2:
                    this.iNI = z;
                    break;
                case 3:
                    this.iNJ = z;
                    break;
                case 4:
                    this.iNL = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iNM = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahO().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iNN = z;
                    break;
                case 9:
                    this.iNO = z;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().alV());
                    break;
                case 10:
                    this.iNP = z;
                    break;
            }
            qy(true);
            ciY();
        }
    }

    private void ciY() {
        boolean z = this.iNK || this.iNJ || this.iNI || this.iNL || this.iNM || this.iNN || this.iNO;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void ciZ() {
        this.iNI = false;
        this.iNJ = false;
        this.iNK = false;
        this.iNL = false;
        this.iNM = false;
        this.iNN = false;
        this.iNO = false;
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = 0;
        this.iNU = false;
        this.mHasNewVersion = false;
        this.iNV = false;
        this.iNW = false;
        this.iNX = false;
        this.iNY = false;
        this.iNZ = false;
        ciS();
        e.iK().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gnj) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        ciT();
    }
}
