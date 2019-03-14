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
    private CustomMessageListener fIZ;
    private boolean fPX;
    private boolean ioL;
    private boolean ioM;
    private boolean ioN;
    private boolean ioO;
    private boolean ioP;
    private boolean ioQ;
    private boolean ioR;
    private boolean ioS;
    private int ioT;
    private int ioU;
    private int ioV;
    private int ioW;
    private boolean ioX;
    private boolean ioY;
    private boolean ioZ;
    private boolean ipa;
    private boolean ipb;
    private boolean ipc;
    private boolean ipd;
    private final CustomMessageListener ipe;
    CustomMessageListener ipf;
    private CustomMessageListener ipg;
    private CustomMessageListener iph;
    private CustomMessageListener ipi;
    private CustomMessageListener ipj;
    private CustomMessageListener ipk;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0344a {
        private static final a ipm = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ioL = false;
        this.ioM = false;
        this.ioN = false;
        this.ioO = false;
        this.ioP = false;
        this.ioQ = false;
        this.ioR = false;
        this.ioS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.ioT = 0;
        this.ioU = 0;
        this.ioV = 0;
        this.ioW = 0;
        this.ioX = false;
        this.mHasNewVersion = false;
        this.ioY = false;
        this.ioZ = false;
        this.ipa = false;
        this.ipb = false;
        this.ipc = false;
        this.ipd = false;
        this.ipe = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.ipf = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.ioW >= responseUnreadPointNum.getNum()) {
                        a.this.ioW = responseUnreadPointNum.getNum();
                        a.this.ioX = false;
                    } else {
                        a.this.ioX = true;
                        a.this.ioO = a.this.ioX ? true : a.this.ioO;
                        a.this.ioW = responseUnreadPointNum.getNum();
                        a.this.bYa();
                    }
                    a.this.bXZ();
                }
            }
        };
        this.ipg = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.ioS = booleanValue;
                    a.this.ipd = booleanValue;
                    a.this.bYa();
                }
            }
        };
        this.iph = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.ipb = booleanValue;
                    a.this.ioQ = booleanValue;
                    a.this.bYa();
                }
            }
        };
        this.ipi = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ioP = a.this.mHasNewVersion ? true : a.this.ioP;
                    a.this.bYa();
                }
            }
        };
        this.fIZ = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bYc();
                    }
                }
            }
        };
        this.ipj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bYe();
                }
            }
        };
        this.ipk = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.afP()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String afU = activityPrizeData.afU();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(afU) && !afU.equals(string)) {
                            a.this.ioR = true;
                            a.this.ipc = true;
                            a.this.bYa();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bXW() {
        return C0344a.ipm;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ipe);
        MessageManager.getInstance().registerListener(this.ipf);
        MessageManager.getInstance().registerListener(this.ipi);
        MessageManager.getInstance().registerListener(this.ipj);
        MessageManager.getInstance().registerListener(this.iph);
        MessageManager.getInstance().registerListener(this.fIZ);
        MessageManager.getInstance().registerListener(this.ipg);
        MessageManager.getInstance().registerListener(this.ipk);
    }

    private void bXX() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ioP = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fPX = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bXY() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.ioP)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.ipa = newsNotifyMessage.getMsgBookmark() > this.ioV;
            this.ioY = newsNotifyMessage.getMsgFans() > this.ioT;
            this.ioZ = newsNotifyMessage.getMsgGiftNum() > this.ioU;
            this.ioV = newsNotifyMessage.getMsgBookmark();
            this.ioT = newsNotifyMessage.getMsgFans();
            this.ioU = newsNotifyMessage.getMsgGiftNum();
            if (this.ipa || this.ioY || this.ioZ || this.mHasNewVersion) {
                this.ioL = this.ioY ? true : this.ioL;
                this.ioM = this.ipa ? true : this.ioM;
                this.ioN = this.ioZ ? true : this.ioN;
                this.ioP = this.mHasNewVersion ? true : this.ioP;
                bYa();
            }
        }
    }

    public void bXZ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.ioX);
    }

    public void ps(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYa() {
        SparseArray sparseArray = new SparseArray();
        if (this.ioX) {
            sparseArray.append(4, new b.a(this.ioO, this.ioW));
        }
        if (this.ioY) {
            sparseArray.append(2, new b.a(this.ioL, this.ioT));
        }
        if (this.ioZ) {
            sparseArray.append(1, new b.a(this.ioN, this.ioU));
        }
        if (this.ipa) {
            sparseArray.append(3, new b.a(this.ioM, this.ioV));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ioP, 0));
        }
        if (this.ipb) {
            sparseArray.append(7, new b.a(this.ioQ, 0));
        }
        if (this.ipc) {
            sparseArray.append(9, new b.a(this.ioR, 0));
        }
        if (this.ipd) {
            sparseArray.append(10, new b.a(this.ioS, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bYb();
    }

    public void pt(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ioO, this.ioW));
            sparseArray.append(2, new b.a(this.ioL, this.ioT));
            sparseArray.append(1, new b.a(this.ioN, this.ioU));
            sparseArray.append(3, new b.a(this.ioM, this.ioV));
            sparseArray.append(5, new b.a(this.ioP, 0));
            sparseArray.append(7, new b.a(this.ioQ, 0));
            sparseArray.append(9, new b.a(this.ioR, 0));
            sparseArray.append(10, new b.a(this.ioS, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bYb() {
        if (((this.ioT > 0 && this.ioY) || (this.ioV > 0 && this.ipa) || this.mHasNewVersion || this.ipc || this.ipd) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.ipd) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bYc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.ioN = z;
                    break;
                case 2:
                    this.ioL = z;
                    break;
                case 3:
                    this.ioM = z;
                    break;
                case 4:
                    this.ioO = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.ioP = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.ioQ = z;
                    break;
                case 9:
                    this.ioR = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().afU());
                    break;
                case 10:
                    this.ioS = z;
                    break;
            }
            pt(true);
            bYd();
        }
    }

    private void bYd() {
        boolean z = this.ioN || this.ioM || this.ioL || this.ioO || this.ioP || this.ioQ || this.ioR;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bYe() {
        this.ioL = false;
        this.ioM = false;
        this.ioN = false;
        this.ioO = false;
        this.ioP = false;
        this.ioQ = false;
        this.ioR = false;
        this.ioT = 0;
        this.ioU = 0;
        this.ioV = 0;
        this.ioW = 0;
        this.ioX = false;
        this.mHasNewVersion = false;
        this.ioY = false;
        this.ioZ = false;
        this.ipa = false;
        this.ipb = false;
        this.ipc = false;
        bXX();
        e.jH().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fPX) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bXY();
    }
}
