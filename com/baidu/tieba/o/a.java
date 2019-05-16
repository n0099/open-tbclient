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
    private CustomMessageListener fZI;
    private boolean ggT;
    private boolean iHA;
    private boolean iHB;
    private boolean iHC;
    private final CustomMessageListener iHD;
    CustomMessageListener iHE;
    private CustomMessageListener iHF;
    private CustomMessageListener iHG;
    private CustomMessageListener iHH;
    private CustomMessageListener iHI;
    private CustomMessageListener iHJ;
    private boolean iHk;
    private boolean iHl;
    private boolean iHm;
    private boolean iHn;
    private boolean iHo;
    private boolean iHp;
    private boolean iHq;
    private boolean iHr;
    private int iHs;
    private int iHt;
    private int iHu;
    private int iHv;
    private boolean iHw;
    private boolean iHx;
    private boolean iHy;
    private boolean iHz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0362a {
        private static final a iHL = new a();
    }

    private a() {
        this.isPrimary = false;
        this.iHk = false;
        this.iHl = false;
        this.iHm = false;
        this.iHn = false;
        this.iHo = false;
        this.iHp = false;
        this.iHq = false;
        this.iHr = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_feedback_tip_show", false);
        this.iHs = 0;
        this.iHt = 0;
        this.iHu = 0;
        this.iHv = 0;
        this.iHw = false;
        this.mHasNewVersion = false;
        this.iHx = false;
        this.iHy = false;
        this.iHz = false;
        this.iHA = false;
        this.iHB = false;
        this.iHC = false;
        this.iHD = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.iHE = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.o.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.iHv >= responseUnreadPointNum.getNum()) {
                        a.this.iHv = responseUnreadPointNum.getNum();
                        a.this.iHw = false;
                    } else {
                        a.this.iHw = true;
                        a.this.iHn = a.this.iHw ? true : a.this.iHn;
                        a.this.iHv = responseUnreadPointNum.getNum();
                        a.this.cgb();
                    }
                    a.this.cga();
                }
            }
        };
        this.iHF = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.o.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.iHr = booleanValue;
                    a.this.iHC = booleanValue;
                    a.this.cgb();
                }
            }
        };
        this.iHG = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.o.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.agM().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.iHA = booleanValue;
                    a.this.iHp = booleanValue;
                    a.this.cgb();
                }
            }
        };
        this.iHH = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.o.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.iHo = a.this.mHasNewVersion ? true : a.this.iHo;
                    a.this.cgb();
                }
            }
        };
        this.fZI = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.o.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.cgd();
                    }
                }
            }
        };
        this.iHI = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.o.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.cgf();
                }
            }
        };
        this.iHJ = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.o.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.akL()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String akQ = activityPrizeData.akQ();
                        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(akQ) && !akQ.equals(string)) {
                            a.this.iHq = true;
                            a.this.iHB = true;
                            a.this.cgb();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a cfX() {
        return C0362a.iHL;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.iHD);
        MessageManager.getInstance().registerListener(this.iHE);
        MessageManager.getInstance().registerListener(this.iHH);
        MessageManager.getInstance().registerListener(this.iHI);
        MessageManager.getInstance().registerListener(this.iHG);
        MessageManager.getInstance().registerListener(this.fZI);
        MessageManager.getInstance().registerListener(this.iHF);
        MessageManager.getInstance().registerListener(this.iHJ);
    }

    private void cfY() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.iHo = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.ggT = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void cfZ() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.iHo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.iHz = newsNotifyMessage.getMsgBookmark() > this.iHu;
            this.iHx = newsNotifyMessage.getMsgFans() > this.iHs;
            this.iHy = newsNotifyMessage.getMsgGiftNum() > this.iHt;
            this.iHu = newsNotifyMessage.getMsgBookmark();
            this.iHs = newsNotifyMessage.getMsgFans();
            this.iHt = newsNotifyMessage.getMsgGiftNum();
            if (this.iHz || this.iHx || this.iHy || this.mHasNewVersion) {
                this.iHk = this.iHx ? true : this.iHk;
                this.iHl = this.iHz ? true : this.iHl;
                this.iHm = this.iHy ? true : this.iHm;
                this.iHo = this.mHasNewVersion ? true : this.iHo;
                cgb();
            }
        }
    }

    public void cga() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.iHw);
    }

    public void qh(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        SparseArray sparseArray = new SparseArray();
        if (this.iHw) {
            sparseArray.append(4, new b.a(this.iHn, this.iHv));
        }
        if (this.iHx) {
            sparseArray.append(2, new b.a(this.iHk, this.iHs));
        }
        if (this.iHy) {
            sparseArray.append(1, new b.a(this.iHm, this.iHt));
        }
        if (this.iHz) {
            sparseArray.append(3, new b.a(this.iHl, this.iHu));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.iHo, 0));
        }
        if (this.iHA) {
            sparseArray.append(7, new b.a(this.iHp, 0));
        }
        if (this.iHB) {
            sparseArray.append(9, new b.a(this.iHq, 0));
        }
        if (this.iHC) {
            sparseArray.append(10, new b.a(this.iHr, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        cgc();
    }

    public void qi(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.iHn, this.iHv));
            sparseArray.append(2, new b.a(this.iHk, this.iHs));
            sparseArray.append(1, new b.a(this.iHm, this.iHt));
            sparseArray.append(3, new b.a(this.iHl, this.iHu));
            sparseArray.append(5, new b.a(this.iHo, 0));
            sparseArray.append(7, new b.a(this.iHp, 0));
            sparseArray.append(9, new b.a(this.iHq, 0));
            sparseArray.append(10, new b.a(this.iHr, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void cgc() {
        if (((this.iHs > 0 && this.iHx) || (this.iHu > 0 && this.iHz) || this.mHasNewVersion || this.iHB || this.iHC) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.iHC) {
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void cgd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void d(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.iHm = z;
                    break;
                case 2:
                    this.iHk = z;
                    break;
                case 3:
                    this.iHl = z;
                    break;
                case 4:
                    this.iHn = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.iHo = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.iHp = z;
                    break;
                case 9:
                    this.iHq = z;
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().akQ());
                    break;
                case 10:
                    this.iHr = z;
                    break;
            }
            qi(true);
            cge();
        }
    }

    private void cge() {
        boolean z = this.iHm || this.iHl || this.iHk || this.iHn || this.iHo || this.iHp || this.iHq;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void cgf() {
        this.iHk = false;
        this.iHl = false;
        this.iHm = false;
        this.iHn = false;
        this.iHo = false;
        this.iHp = false;
        this.iHq = false;
        this.iHs = 0;
        this.iHt = 0;
        this.iHu = 0;
        this.iHv = 0;
        this.iHw = false;
        this.mHasNewVersion = false;
        this.iHx = false;
        this.iHy = false;
        this.iHz = false;
        this.iHA = false;
        this.iHB = false;
        cfY();
        e.iB().post(new Runnable() { // from class: com.baidu.tieba.o.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.ggT) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        cfZ();
    }
}
