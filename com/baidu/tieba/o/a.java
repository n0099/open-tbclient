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
    private CustomMessageListener fIN;
    private boolean fPL;
    private boolean ioA;
    private boolean ioB;
    private boolean ioC;
    private int ioD;
    private int ioE;
    private int ioF;
    private int ioG;
    private boolean ioH;
    private boolean ioI;
    private boolean ioJ;
    private boolean ioK;
    private boolean ioL;
    private boolean ioM;
    private boolean ioN;
    private final CustomMessageListener ioO;
    CustomMessageListener ioP;
    private CustomMessageListener ioQ;
    private CustomMessageListener ioR;
    private CustomMessageListener ioS;
    private CustomMessageListener ioT;
    private CustomMessageListener ioU;
    private boolean iov;
    private boolean iow;
    private boolean iox;
    private boolean ioy;
    private boolean ioz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0344a {
        private static final a ioW = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iov = false;
        this.iow = false;
        this.iox = false;
        this.ioy = false;
        this.ioz = false;
        this.ioA = false;
        this.ioB = false;
        this.ioC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.ioD = 0;
        this.ioE = 0;
        this.ioF = 0;
        this.ioG = 0;
        this.ioH = false;
        this.mHasNewVersion = false;
        this.ioI = false;
        this.ioJ = false;
        this.ioK = false;
        this.ioL = false;
        this.ioM = false;
        this.ioN = false;
        this.ioO = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.ioP = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.ioG >= responseUnreadPointNum.getNum()) {
                        a.this.ioG = responseUnreadPointNum.getNum();
                        a.this.ioH = false;
                    } else {
                        a.this.ioH = true;
                        a.this.ioy = a.this.ioH ? true : a.this.ioy;
                        a.this.ioG = responseUnreadPointNum.getNum();
                        a.this.bXW();
                    }
                    a.this.bXV();
                }
            }
        };
        this.ioQ = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.ioC = booleanValue;
                    a.this.ioN = booleanValue;
                    a.this.bXW();
                }
            }
        };
        this.ioR = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.ioL = booleanValue;
                    a.this.ioA = booleanValue;
                    a.this.bXW();
                }
            }
        };
        this.ioS = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ioz = a.this.mHasNewVersion ? true : a.this.ioz;
                    a.this.bXW();
                }
            }
        };
        this.fIN = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bXY();
                    }
                }
            }
        };
        this.ioT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bYa();
                }
            }
        };
        this.ioU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.afM()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String afR = activityPrizeData.afR();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(afR) && !afR.equals(string)) {
                            a.this.ioB = true;
                            a.this.ioM = true;
                            a.this.bXW();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bXS() {
        return C0344a.ioW;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ioO);
        MessageManager.getInstance().registerListener(this.ioP);
        MessageManager.getInstance().registerListener(this.ioS);
        MessageManager.getInstance().registerListener(this.ioT);
        MessageManager.getInstance().registerListener(this.ioR);
        MessageManager.getInstance().registerListener(this.fIN);
        MessageManager.getInstance().registerListener(this.ioQ);
        MessageManager.getInstance().registerListener(this.ioU);
    }

    private void bXT() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ioz = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fPL = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bXU() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.ioz)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.ioK = newsNotifyMessage.getMsgBookmark() > this.ioF;
            this.ioI = newsNotifyMessage.getMsgFans() > this.ioD;
            this.ioJ = newsNotifyMessage.getMsgGiftNum() > this.ioE;
            this.ioF = newsNotifyMessage.getMsgBookmark();
            this.ioD = newsNotifyMessage.getMsgFans();
            this.ioE = newsNotifyMessage.getMsgGiftNum();
            if (this.ioK || this.ioI || this.ioJ || this.mHasNewVersion) {
                this.iov = this.ioI ? true : this.iov;
                this.iow = this.ioK ? true : this.iow;
                this.iox = this.ioJ ? true : this.iox;
                this.ioz = this.mHasNewVersion ? true : this.ioz;
                bXW();
            }
        }
    }

    public void bXV() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.ioH);
    }

    public void ps(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXW() {
        SparseArray sparseArray = new SparseArray();
        if (this.ioH) {
            sparseArray.append(4, new b.a(this.ioy, this.ioG));
        }
        if (this.ioI) {
            sparseArray.append(2, new b.a(this.iov, this.ioD));
        }
        if (this.ioJ) {
            sparseArray.append(1, new b.a(this.iox, this.ioE));
        }
        if (this.ioK) {
            sparseArray.append(3, new b.a(this.iow, this.ioF));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ioz, 0));
        }
        if (this.ioL) {
            sparseArray.append(7, new b.a(this.ioA, 0));
        }
        if (this.ioM) {
            sparseArray.append(9, new b.a(this.ioB, 0));
        }
        if (this.ioN) {
            sparseArray.append(10, new b.a(this.ioC, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bXX();
    }

    public void pt(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ioy, this.ioG));
            sparseArray.append(2, new b.a(this.iov, this.ioD));
            sparseArray.append(1, new b.a(this.iox, this.ioE));
            sparseArray.append(3, new b.a(this.iow, this.ioF));
            sparseArray.append(5, new b.a(this.ioz, 0));
            sparseArray.append(7, new b.a(this.ioA, 0));
            sparseArray.append(9, new b.a(this.ioB, 0));
            sparseArray.append(10, new b.a(this.ioC, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bXX() {
        if (((this.ioD > 0 && this.ioI) || (this.ioF > 0 && this.ioK) || this.mHasNewVersion || this.ioM || this.ioN) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.ioN) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bXY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iox = z;
                    break;
                case 2:
                    this.iov = z;
                    break;
                case 3:
                    this.iow = z;
                    break;
                case 4:
                    this.ioy = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.ioz = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.ioA = z;
                    break;
                case 9:
                    this.ioB = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().afR());
                    break;
                case 10:
                    this.ioC = z;
                    break;
            }
            pt(true);
            bXZ();
        }
    }

    private void bXZ() {
        boolean z = this.iox || this.iow || this.iov || this.ioy || this.ioz || this.ioA || this.ioB;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bYa() {
        this.iov = false;
        this.iow = false;
        this.iox = false;
        this.ioy = false;
        this.ioz = false;
        this.ioA = false;
        this.ioB = false;
        this.ioD = 0;
        this.ioE = 0;
        this.ioF = 0;
        this.ioG = 0;
        this.ioH = false;
        this.mHasNewVersion = false;
        this.ioI = false;
        this.ioJ = false;
        this.ioK = false;
        this.ioL = false;
        this.ioM = false;
        bXT();
        e.jH().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fPL) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bXU();
    }
}
