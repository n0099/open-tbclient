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
    private CustomMessageListener fJa;
    private boolean fPY;
    private boolean ioS;
    private boolean ioT;
    private boolean ioU;
    private boolean ioV;
    private boolean ioW;
    private boolean ioX;
    private boolean ioY;
    private boolean ioZ;
    private int ipa;
    private int ipb;
    private int ipc;
    private int ipd;
    private boolean ipe;
    private boolean ipf;
    private boolean ipg;
    private boolean iph;
    private boolean ipi;
    private boolean ipj;
    private boolean ipk;
    private final CustomMessageListener ipl;
    CustomMessageListener ipm;
    private CustomMessageListener ipn;
    private CustomMessageListener ipo;
    private CustomMessageListener ipp;
    private CustomMessageListener ipq;
    private CustomMessageListener ipr;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0272a {
        private static final a ipt = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ioS = false;
        this.ioT = false;
        this.ioU = false;
        this.ioV = false;
        this.ioW = false;
        this.ioX = false;
        this.ioY = false;
        this.ioZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.ipa = 0;
        this.ipb = 0;
        this.ipc = 0;
        this.ipd = 0;
        this.ipe = false;
        this.mHasNewVersion = false;
        this.ipf = false;
        this.ipg = false;
        this.iph = false;
        this.ipi = false;
        this.ipj = false;
        this.ipk = false;
        this.ipl = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.ipm = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.ipd >= responseUnreadPointNum.getNum()) {
                        a.this.ipd = responseUnreadPointNum.getNum();
                        a.this.ipe = false;
                    } else {
                        a.this.ipe = true;
                        a.this.ioV = a.this.ipe ? true : a.this.ioV;
                        a.this.ipd = responseUnreadPointNum.getNum();
                        a.this.bXY();
                    }
                    a.this.bXX();
                }
            }
        };
        this.ipn = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.ioZ = booleanValue;
                    a.this.ipk = booleanValue;
                    a.this.bXY();
                }
            }
        };
        this.ipo = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.ipi = booleanValue;
                    a.this.ioX = booleanValue;
                    a.this.bXY();
                }
            }
        };
        this.ipp = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ioW = a.this.mHasNewVersion ? true : a.this.ioW;
                    a.this.bXY();
                }
            }
        };
        this.fJa = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bYa();
                    }
                }
            }
        };
        this.ipq = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bYc();
                }
            }
        };
        this.ipr = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
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
                            a.this.ioY = true;
                            a.this.ipj = true;
                            a.this.bXY();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bXU() {
        return C0272a.ipt;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ipl);
        MessageManager.getInstance().registerListener(this.ipm);
        MessageManager.getInstance().registerListener(this.ipp);
        MessageManager.getInstance().registerListener(this.ipq);
        MessageManager.getInstance().registerListener(this.ipo);
        MessageManager.getInstance().registerListener(this.fJa);
        MessageManager.getInstance().registerListener(this.ipn);
        MessageManager.getInstance().registerListener(this.ipr);
    }

    private void bXV() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ioW = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fPY = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bXW() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.ioW)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iph = newsNotifyMessage.getMsgBookmark() > this.ipc;
            this.ipf = newsNotifyMessage.getMsgFans() > this.ipa;
            this.ipg = newsNotifyMessage.getMsgGiftNum() > this.ipb;
            this.ipc = newsNotifyMessage.getMsgBookmark();
            this.ipa = newsNotifyMessage.getMsgFans();
            this.ipb = newsNotifyMessage.getMsgGiftNum();
            if (this.iph || this.ipf || this.ipg || this.mHasNewVersion) {
                this.ioS = this.ipf ? true : this.ioS;
                this.ioT = this.iph ? true : this.ioT;
                this.ioU = this.ipg ? true : this.ioU;
                this.ioW = this.mHasNewVersion ? true : this.ioW;
                bXY();
            }
        }
    }

    public void bXX() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.ipe);
    }

    public void ps(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXY() {
        SparseArray sparseArray = new SparseArray();
        if (this.ipe) {
            sparseArray.append(4, new b.a(this.ioV, this.ipd));
        }
        if (this.ipf) {
            sparseArray.append(2, new b.a(this.ioS, this.ipa));
        }
        if (this.ipg) {
            sparseArray.append(1, new b.a(this.ioU, this.ipb));
        }
        if (this.iph) {
            sparseArray.append(3, new b.a(this.ioT, this.ipc));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ioW, 0));
        }
        if (this.ipi) {
            sparseArray.append(7, new b.a(this.ioX, 0));
        }
        if (this.ipj) {
            sparseArray.append(9, new b.a(this.ioY, 0));
        }
        if (this.ipk) {
            sparseArray.append(10, new b.a(this.ioZ, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bXZ();
    }

    public void pt(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ioV, this.ipd));
            sparseArray.append(2, new b.a(this.ioS, this.ipa));
            sparseArray.append(1, new b.a(this.ioU, this.ipb));
            sparseArray.append(3, new b.a(this.ioT, this.ipc));
            sparseArray.append(5, new b.a(this.ioW, 0));
            sparseArray.append(7, new b.a(this.ioX, 0));
            sparseArray.append(9, new b.a(this.ioY, 0));
            sparseArray.append(10, new b.a(this.ioZ, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bXZ() {
        if (((this.ipa > 0 && this.ipf) || (this.ipc > 0 && this.iph) || this.mHasNewVersion || this.ipj || this.ipk) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.ipk) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bYa() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.ioU = z;
                    break;
                case 2:
                    this.ioS = z;
                    break;
                case 3:
                    this.ioT = z;
                    break;
                case 4:
                    this.ioV = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.ioW = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.ioX = z;
                    break;
                case 9:
                    this.ioY = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().afU());
                    break;
                case 10:
                    this.ioZ = z;
                    break;
            }
            pt(true);
            bYb();
        }
    }

    private void bYb() {
        boolean z = this.ioU || this.ioT || this.ioS || this.ioV || this.ioW || this.ioX || this.ioY;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bYc() {
        this.ioS = false;
        this.ioT = false;
        this.ioU = false;
        this.ioV = false;
        this.ioW = false;
        this.ioX = false;
        this.ioY = false;
        this.ipa = 0;
        this.ipb = 0;
        this.ipc = 0;
        this.ipd = 0;
        this.ipe = false;
        this.mHasNewVersion = false;
        this.ipf = false;
        this.ipg = false;
        this.iph = false;
        this.ipi = false;
        this.ipj = false;
        bXV();
        e.jH().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fPY) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bXW();
    }
}
