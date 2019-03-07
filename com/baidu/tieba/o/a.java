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
    private boolean fPX;
    private boolean ioR;
    private boolean ioS;
    private boolean ioT;
    private boolean ioU;
    private boolean ioV;
    private boolean ioW;
    private boolean ioX;
    private boolean ioY;
    private int ioZ;
    private int ipa;
    private int ipb;
    private int ipc;
    private boolean ipd;
    private boolean ipe;
    private boolean ipf;
    private boolean ipg;
    private boolean iph;
    private boolean ipi;
    private boolean ipj;
    private final CustomMessageListener ipk;
    CustomMessageListener ipl;
    private CustomMessageListener ipm;
    private CustomMessageListener ipn;
    private CustomMessageListener ipo;
    private CustomMessageListener ipp;
    private CustomMessageListener ipq;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0272a {
        private static final a ips = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ioR = false;
        this.ioS = false;
        this.ioT = false;
        this.ioU = false;
        this.ioV = false;
        this.ioW = false;
        this.ioX = false;
        this.ioY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.ioZ = 0;
        this.ipa = 0;
        this.ipb = 0;
        this.ipc = 0;
        this.ipd = false;
        this.mHasNewVersion = false;
        this.ipe = false;
        this.ipf = false;
        this.ipg = false;
        this.iph = false;
        this.ipi = false;
        this.ipj = false;
        this.ipk = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.ipl = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.ipc >= responseUnreadPointNum.getNum()) {
                        a.this.ipc = responseUnreadPointNum.getNum();
                        a.this.ipd = false;
                    } else {
                        a.this.ipd = true;
                        a.this.ioU = a.this.ipd ? true : a.this.ioU;
                        a.this.ipc = responseUnreadPointNum.getNum();
                        a.this.bXX();
                    }
                    a.this.bXW();
                }
            }
        };
        this.ipm = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.ioY = booleanValue;
                    a.this.ipj = booleanValue;
                    a.this.bXX();
                }
            }
        };
        this.ipn = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
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
                    a.this.iph = booleanValue;
                    a.this.ioW = booleanValue;
                    a.this.bXX();
                }
            }
        };
        this.ipo = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ioV = a.this.mHasNewVersion ? true : a.this.ioV;
                    a.this.bXX();
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
                        a.this.bXZ();
                    }
                }
            }
        };
        this.ipp = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bYb();
                }
            }
        };
        this.ipq = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
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
                            a.this.ioX = true;
                            a.this.ipi = true;
                            a.this.bXX();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bXT() {
        return C0272a.ips;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.ipk);
        MessageManager.getInstance().registerListener(this.ipl);
        MessageManager.getInstance().registerListener(this.ipo);
        MessageManager.getInstance().registerListener(this.ipp);
        MessageManager.getInstance().registerListener(this.ipn);
        MessageManager.getInstance().registerListener(this.fJa);
        MessageManager.getInstance().registerListener(this.ipm);
        MessageManager.getInstance().registerListener(this.ipq);
    }

    private void bXU() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ioV = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.fPX = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bXV() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.ioV)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.ipg = newsNotifyMessage.getMsgBookmark() > this.ipb;
            this.ipe = newsNotifyMessage.getMsgFans() > this.ioZ;
            this.ipf = newsNotifyMessage.getMsgGiftNum() > this.ipa;
            this.ipb = newsNotifyMessage.getMsgBookmark();
            this.ioZ = newsNotifyMessage.getMsgFans();
            this.ipa = newsNotifyMessage.getMsgGiftNum();
            if (this.ipg || this.ipe || this.ipf || this.mHasNewVersion) {
                this.ioR = this.ipe ? true : this.ioR;
                this.ioS = this.ipg ? true : this.ioS;
                this.ioT = this.ipf ? true : this.ioT;
                this.ioV = this.mHasNewVersion ? true : this.ioV;
                bXX();
            }
        }
    }

    public void bXW() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.ipd);
    }

    public void ps(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXX() {
        SparseArray sparseArray = new SparseArray();
        if (this.ipd) {
            sparseArray.append(4, new b.a(this.ioU, this.ipc));
        }
        if (this.ipe) {
            sparseArray.append(2, new b.a(this.ioR, this.ioZ));
        }
        if (this.ipf) {
            sparseArray.append(1, new b.a(this.ioT, this.ipa));
        }
        if (this.ipg) {
            sparseArray.append(3, new b.a(this.ioS, this.ipb));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ioV, 0));
        }
        if (this.iph) {
            sparseArray.append(7, new b.a(this.ioW, 0));
        }
        if (this.ipi) {
            sparseArray.append(9, new b.a(this.ioX, 0));
        }
        if (this.ipj) {
            sparseArray.append(10, new b.a(this.ioY, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bXY();
    }

    public void pt(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ioU, this.ipc));
            sparseArray.append(2, new b.a(this.ioR, this.ioZ));
            sparseArray.append(1, new b.a(this.ioT, this.ipa));
            sparseArray.append(3, new b.a(this.ioS, this.ipb));
            sparseArray.append(5, new b.a(this.ioV, 0));
            sparseArray.append(7, new b.a(this.ioW, 0));
            sparseArray.append(9, new b.a(this.ioX, 0));
            sparseArray.append(10, new b.a(this.ioY, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bXY() {
        if (((this.ioZ > 0 && this.ipe) || (this.ipb > 0 && this.ipg) || this.mHasNewVersion || this.ipi || this.ipj) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.ipj) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bXZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.ioT = z;
                    break;
                case 2:
                    this.ioR = z;
                    break;
                case 3:
                    this.ioS = z;
                    break;
                case 4:
                    this.ioU = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.ioV = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.ioW = z;
                    break;
                case 9:
                    this.ioX = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().afU());
                    break;
                case 10:
                    this.ioY = z;
                    break;
            }
            pt(true);
            bYa();
        }
    }

    private void bYa() {
        boolean z = this.ioT || this.ioS || this.ioR || this.ioU || this.ioV || this.ioW || this.ioX;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bYb() {
        this.ioR = false;
        this.ioS = false;
        this.ioT = false;
        this.ioU = false;
        this.ioV = false;
        this.ioW = false;
        this.ioX = false;
        this.ioZ = 0;
        this.ipa = 0;
        this.ipb = 0;
        this.ipc = 0;
        this.ipd = false;
        this.mHasNewVersion = false;
        this.ipe = false;
        this.ipf = false;
        this.ipg = false;
        this.iph = false;
        this.ipi = false;
        bXU();
        e.jH().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.fPX) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bXV();
    }
}
