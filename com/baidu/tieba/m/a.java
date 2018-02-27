package com.baidu.tieba.m;

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
import com.baidu.tieba.m.b;
/* loaded from: classes.dex */
public class a {
    private CustomMessageListener ehq;
    private CustomMessageListener gJA;
    private CustomMessageListener gJB;
    private boolean gJb;
    private boolean gJc;
    private boolean gJd;
    private boolean gJe;
    private boolean gJf;
    private boolean gJg;
    private boolean gJh;
    private boolean gJi;
    private int gJj;
    private int gJk;
    private int gJl;
    private int gJm;
    private boolean gJn;
    private boolean gJo;
    private boolean gJp;
    private boolean gJq;
    private boolean gJr;
    private boolean gJs;
    private boolean gJt;
    private boolean gJu;
    private final CustomMessageListener gJv;
    CustomMessageListener gJw;
    private CustomMessageListener gJx;
    private CustomMessageListener gJy;
    private CustomMessageListener gJz;
    private boolean isPrimary;
    private boolean mHasNewVersion;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0196a {
        private static final a gJD = new a();
    }

    private a() {
        this.isPrimary = false;
        this.gJb = false;
        this.gJc = false;
        this.gJd = false;
        this.gJe = false;
        this.gJf = false;
        this.gJg = false;
        this.gJh = false;
        this.gJi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_show", false);
        this.gJj = 0;
        this.gJk = 0;
        this.gJl = 0;
        this.gJm = 0;
        this.gJn = false;
        this.mHasNewVersion = false;
        this.gJo = false;
        this.gJp = false;
        this.gJq = false;
        this.gJr = false;
        this.gJs = false;
        this.gJt = false;
        this.gJv = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.c(customResponsedMessage);
                }
            }
        };
        this.gJw = new CustomMessageListener(2001176) { // from class: com.baidu.tieba.m.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.gJm >= responseUnreadPointNum.getNum()) {
                        a.this.gJm = responseUnreadPointNum.getNum();
                        a.this.gJn = false;
                    } else {
                        a.this.gJn = true;
                        a.this.gJe = a.this.gJn ? true : a.this.gJe;
                        a.this.gJm = responseUnreadPointNum.getNum();
                        a.this.bpp();
                    }
                    a.this.bpo();
                }
            }
        };
        this.gJx = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.m.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", true);
                    }
                    a.this.gJi = booleanValue;
                    a.this.gJt = booleanValue;
                    a.this.bpp();
                }
            }
        };
        this.gJy = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.m.a.4
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
                    a.this.gJr = booleanValue;
                    a.this.gJg = booleanValue;
                    a.this.bpp();
                }
            }
        };
        this.gJz = new CustomMessageListener(2001436) { // from class: com.baidu.tieba.m.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.gJf = a.this.mHasNewVersion ? true : a.this.gJf;
                    a.this.bpp();
                }
            }
        };
        this.ehq = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.m.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.bpr();
                    }
                }
            }
        };
        this.gJA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.m.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.bpt();
                }
            }
        };
        this.gJB = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.m.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Fh()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String Fm = activityPrizeData.Fm();
                        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("person_item_activity_prize_red_tip" + currentAccount, "");
                        if (!StringUtils.isNull(Fm) && !Fm.equals(string)) {
                            a.this.gJh = true;
                            a.this.gJs = true;
                            a.this.bpp();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a bpl() {
        return C0196a.gJD;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gJv);
        MessageManager.getInstance().registerListener(this.gJw);
        MessageManager.getInstance().registerListener(this.gJz);
        MessageManager.getInstance().registerListener(this.gJA);
        MessageManager.getInstance().registerListener(this.gJy);
        MessageManager.getInstance().registerListener(this.ehq);
        MessageManager.getInstance().registerListener(this.gJx);
        MessageManager.getInstance().registerListener(this.gJB);
    }

    private void bpm() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("member_close_ad_setting_clicked", false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.gJf = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        this.gJu = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void bpn() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(this.gJf)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.gJq = newsNotifyMessage.getMsgBookmark() > this.gJl;
            this.gJo = newsNotifyMessage.getMsgFans() > this.gJj;
            this.gJp = newsNotifyMessage.getMsgGiftNum() > this.gJk;
            this.gJl = newsNotifyMessage.getMsgBookmark();
            this.gJj = newsNotifyMessage.getMsgFans();
            this.gJk = newsNotifyMessage.getMsgGiftNum();
            if (this.gJq || this.gJo || this.gJp || this.mHasNewVersion) {
                this.gJb = this.gJo ? true : this.gJb;
                this.gJc = this.gJq ? true : this.gJc;
                this.gJd = this.gJp ? true : this.gJd;
                this.gJf = this.mHasNewVersion ? true : this.gJf;
                bpp();
            }
        }
    }

    public void bpo() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append("has_clicked_addresslist_item_in_leftnavi");
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.gJn);
    }

    public void mc(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpp() {
        SparseArray sparseArray = new SparseArray();
        if (this.gJn) {
            sparseArray.append(4, new b.a(this.gJe, this.gJm));
        }
        if (this.gJo) {
            sparseArray.append(2, new b.a(this.gJb, this.gJj));
        }
        if (this.gJp) {
            sparseArray.append(1, new b.a(this.gJd, this.gJk));
        }
        if (this.gJq) {
            sparseArray.append(3, new b.a(this.gJc, this.gJl));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.gJf, 0));
        }
        if (this.gJr) {
            sparseArray.append(7, new b.a(this.gJg, 0));
        }
        if (this.gJs) {
            sparseArray.append(9, new b.a(this.gJh, 0));
        }
        if (this.gJt) {
            sparseArray.append(10, new b.a(this.gJi, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        bpq();
    }

    public void md(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.gJe, this.gJm));
            sparseArray.append(2, new b.a(this.gJb, this.gJj));
            sparseArray.append(1, new b.a(this.gJd, this.gJk));
            sparseArray.append(3, new b.a(this.gJc, this.gJl));
            sparseArray.append(5, new b.a(this.gJf, 0));
            sparseArray.append(7, new b.a(this.gJg, 0));
            sparseArray.append(9, new b.a(this.gJh, 0));
            sparseArray.append(10, new b.a(this.gJi, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001435, new b(sparseArray)));
        }
    }

    private void bpq() {
        if (((this.gJj > 0 && this.gJo) || (this.gJl > 0 && this.gJq) || this.mHasNewVersion || this.gJs || this.gJt) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.gJt) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_tab_show", true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void bpr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void c(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.gJd = z;
                    break;
                case 2:
                    this.gJb = z;
                    break;
                case 3:
                    this.gJc = z;
                    break;
                case 4:
                    this.gJe = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_setting_clicked", true);
                    }
                    this.gJf = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.gJg = z;
                    break;
                case 9:
                    this.gJh = z;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("person_item_activity_prize_red_tip" + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().Fm());
                    break;
                case 10:
                    this.gJi = z;
                    break;
            }
            md(true);
            bps();
        }
    }

    private void bps() {
        boolean z = this.gJd || this.gJc || this.gJb || this.gJe || this.gJf || this.gJg || this.gJh;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007014, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void bpt() {
        this.gJb = false;
        this.gJc = false;
        this.gJd = false;
        this.gJe = false;
        this.gJf = false;
        this.gJg = false;
        this.gJh = false;
        this.gJj = 0;
        this.gJk = 0;
        this.gJl = 0;
        this.gJm = 0;
        this.gJn = false;
        this.mHasNewVersion = false;
        this.gJo = false;
        this.gJp = false;
        this.gJq = false;
        this.gJr = false;
        this.gJs = false;
        bpm();
        e.ns().post(new Runnable() { // from class: com.baidu.tieba.m.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.gJu) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        bpn();
    }
}
