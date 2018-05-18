package com.baidu.tieba.n;

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
import com.baidu.tieba.n.b;
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener dDp;
    private boolean gfA;
    private boolean gfB;
    private int gfC;
    private int gfD;
    private int gfE;
    private int gfF;
    private boolean gfG;
    private boolean gfH;
    private boolean gfI;
    private boolean gfJ;
    private boolean gfK;
    private boolean gfL;
    private boolean gfM;
    private boolean gfN;
    private final CustomMessageListener gfO;
    CustomMessageListener gfP;
    private CustomMessageListener gfQ;
    private CustomMessageListener gfR;
    private CustomMessageListener gfS;
    private CustomMessageListener gfT;
    private CustomMessageListener gfU;
    private boolean gfu;
    private boolean gfv;
    private boolean gfw;
    private boolean gfx;
    private boolean gfy;
    private boolean gfz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0184a {
        private static final a gfW = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gfu = false;
        this.gfv = false;
        this.gfw = false;
        this.gfx = false;
        this.gfy = false;
        this.gfz = false;
        this.gfA = false;
        this.gfB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gfC = 0;
        this.gfD = 0;
        this.gfE = 0;
        this.gfF = 0;
        this.gfG = false;
        this.mHasNewVersion = false;
        this.gfH = false;
        this.gfI = false;
        this.gfJ = false;
        this.gfK = false;
        this.gfL = false;
        this.gfM = false;
        this.gfO = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.n.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gfP = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.n.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gfF >= responseUnreadPointNum.getNum()) {
                        a.this.gfF = responseUnreadPointNum.getNum();
                        a.this.gfG = false;
                    } else {
                        a.this.gfG = true;
                        a.this.gfx = a.this.gfG ? true : a.this.gfx;
                        a.this.gfF = responseUnreadPointNum.getNum();
                        a.this.bkw();
                    }
                    a.this.bkv();
                }
            }
        };
        this.gfQ = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.n.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gfB = booleanValue;
                    a.this.gfM = booleanValue;
                    a.this.bkw();
                }
            }
        };
        this.gfR = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.n.a.4
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
                    a.this.gfK = booleanValue;
                    a.this.gfz = booleanValue;
                    a.this.bkw();
                }
            }
        };
        this.gfS = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.n.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gfy = a.this.mHasNewVersion ? true : a.this.gfy;
                    a.this.bkw();
                }
            }
        };
        this.dDp = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.n.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bky();
                    }
                }
            }
        };
        this.gfT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.n.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bkA();
                }
            }
        };
        this.gfU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.n.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xU()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String xZ = activityPrizeData.xZ();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(xZ) && !xZ.equals(string)) {
                            a.this.gfA = true;
                            a.this.gfL = true;
                            a.this.bkw();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bks() {
        return C0184a.gfW;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gfO);
        MessageManager.getInstance().registerListener(this.gfP);
        MessageManager.getInstance().registerListener(this.gfS);
        MessageManager.getInstance().registerListener(this.gfT);
        MessageManager.getInstance().registerListener(this.gfR);
        MessageManager.getInstance().registerListener(this.dDp);
        MessageManager.getInstance().registerListener(this.gfQ);
        MessageManager.getInstance().registerListener(this.gfU);
    }

    private void bkt() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gfy = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gfN = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bku() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gfy)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gfJ = newsNotifyMessage.getMsgBookmark() > this.gfE;
            this.gfH = newsNotifyMessage.getMsgFans() > this.gfC;
            this.gfI = newsNotifyMessage.getMsgGiftNum() > this.gfD;
            this.gfE = newsNotifyMessage.getMsgBookmark();
            this.gfC = newsNotifyMessage.getMsgFans();
            this.gfD = newsNotifyMessage.getMsgGiftNum();
            if (this.gfJ || this.gfH || this.gfI || this.mHasNewVersion) {
                this.gfu = this.gfH ? true : this.gfu;
                this.gfv = this.gfJ ? true : this.gfv;
                this.gfw = this.gfI ? true : this.gfw;
                this.gfy = this.mHasNewVersion ? true : this.gfy;
                bkw();
            }
        }
    }

    public void bkv() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gfG);
    }

    public void lJ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkw() {
        SparseArray sparseArray = new SparseArray();
        if (this.gfG) {
            sparseArray.append(4, new b.a(this.gfx, this.gfF));
        }
        if (this.gfH) {
            sparseArray.append(2, new b.a(this.gfu, this.gfC));
        }
        if (this.gfI) {
            sparseArray.append(1, new b.a(this.gfw, this.gfD));
        }
        if (this.gfJ) {
            sparseArray.append(3, new b.a(this.gfv, this.gfE));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gfy, 0));
        }
        if (this.gfK) {
            sparseArray.append(7, new b.a(this.gfz, 0));
        }
        if (this.gfL) {
            sparseArray.append(9, new b.a(this.gfA, 0));
        }
        if (this.gfM) {
            sparseArray.append(10, new b.a(this.gfB, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bkx();
    }

    public void lK(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gfx, this.gfF));
            sparseArray.append(2, new b.a(this.gfu, this.gfC));
            sparseArray.append(1, new b.a(this.gfw, this.gfD));
            sparseArray.append(3, new b.a(this.gfv, this.gfE));
            sparseArray.append(5, new b.a(this.gfy, 0));
            sparseArray.append(7, new b.a(this.gfz, 0));
            sparseArray.append(9, new b.a(this.gfA, 0));
            sparseArray.append(10, new b.a(this.gfB, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bkx() {
        if (((this.gfC > 0 && this.gfH) || (this.gfE > 0 && this.gfJ) || this.mHasNewVersion || this.gfL || this.gfM) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gfM) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bky() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void b(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gfw = z;
                    break;
                case 2:
                    this.gfu = z;
                    break;
                case 3:
                    this.gfv = z;
                    break;
                case 4:
                    this.gfx = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gfy = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gfz = z;
                    break;
                case 9:
                    this.gfA = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().xZ());
                    break;
                case 10:
                    this.gfB = z;
                    break;
            }
            lK(true);
            bkz();
        }
    }

    private void bkz() {
        boolean z = this.gfw || this.gfv || this.gfu || this.gfx || this.gfy || this.gfz || this.gfA;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bkA() {
        this.gfu = false;
        this.gfv = false;
        this.gfw = false;
        this.gfx = false;
        this.gfy = false;
        this.gfz = false;
        this.gfA = false;
        this.gfC = 0;
        this.gfD = 0;
        this.gfE = 0;
        this.gfF = 0;
        this.gfG = false;
        this.mHasNewVersion = false;
        this.gfH = false;
        this.gfI = false;
        this.gfJ = false;
        this.gfK = false;
        this.gfL = false;
        bkt();
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.n.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gfN) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bku();
    }
}
