package com.baidu.tieba.p;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private boolean isPrimary;
    private CustomMessageListener kcP;
    private boolean kpZ;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private boolean nbA;
    private boolean nbB;
    CustomMessageListener nbC;
    private CustomMessageListener nbD;
    private CustomMessageListener nbE;
    private boolean nbi;
    private boolean nbj;
    private boolean nbk;
    private boolean nbl;
    private boolean nbm;
    private boolean nbn;
    private boolean nbo;
    private boolean nbp;
    private boolean nbq;
    private int nbr;
    private int nbs;
    private int nbt;
    private int nbu;
    private boolean nbv;
    private boolean nbw;
    private boolean nbx;
    private boolean nby;
    private boolean nbz;
    private CustomMessageListener syncFinishListener;

    public boolean dES() {
        return this.nbi;
    }

    public boolean dET() {
        return this.nbj;
    }

    public boolean dEU() {
        return this.nbn;
    }

    public boolean dEV() {
        return this.nbo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0821a {
        private static final a nbG = new a();
    }

    private a() {
        this.isPrimary = false;
        this.nbi = false;
        this.nbj = false;
        this.nbk = false;
        this.nbl = false;
        this.nbm = false;
        this.nbn = false;
        this.nbo = false;
        this.nbp = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.nbq = false;
        this.nbr = 0;
        this.nbs = 0;
        this.nbt = 0;
        this.nbu = 0;
        this.nbv = false;
        this.mHasNewVersion = false;
        this.nbw = false;
        this.nbx = false;
        this.nby = false;
        this.nbz = false;
        this.nbA = false;
        this.nbB = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.nbC = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.nbu >= responseUnreadPointNum.getNum()) {
                        a.this.nbu = responseUnreadPointNum.getNum();
                        a.this.nbv = false;
                    } else {
                        a.this.nbv = true;
                        a.this.nbl = a.this.nbv ? true : a.this.nbl;
                        a.this.nbu = responseUnreadPointNum.getNum();
                        a.this.dFa();
                    }
                    a.this.dEZ();
                }
            }
        };
        this.feedBackRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.baidu.tieba.p.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.nbp = booleanValue;
                    a.this.nbB = booleanValue;
                    a.this.dFa();
                }
            }
        };
        this.memberCenterRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.p.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (booleanValue) {
                        if (TbadkCoreApplication.isLogin()) {
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.nbz = booleanValue;
                    a.this.nbn = booleanValue;
                    a.this.dFa();
                }
            }
        };
        this.nbD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.nbm = a.this.mHasNewVersion ? true : a.this.nbm;
                    a.this.dFa();
                }
            }
        };
        this.kcP = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.dFc();
                        if (a.this.nbq) {
                            TiebaStatic.log(new ar("c13688").v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_locate", 1));
                            a.this.nbq = false;
                        }
                    }
                }
            }
        };
        this.nbE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.dFe();
                }
            }
        };
        this.syncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.p.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isSwitchTurn()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (!StringUtils.isNull(currentAccount)) {
                        String dotTimestamp = activityPrizeData.getDotTimestamp();
                        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.nbo = true;
                            a.this.nbA = true;
                            a.this.dFa();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a dEW() {
        return C0821a.nbG;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.nbC);
        MessageManager.getInstance().registerListener(this.nbD);
        MessageManager.getInstance().registerListener(this.nbE);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.kcP);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void dEX() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.nbm = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.kpZ = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void dEY() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.nbm)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.nby = newsNotifyMessage.getMsgBookmark() > this.nbt;
            this.nbw = newsNotifyMessage.getMsgFans() > this.nbr;
            this.nbx = newsNotifyMessage.getMsgGiftNum() > this.nbs;
            this.nbt = newsNotifyMessage.getMsgBookmark();
            this.nbr = newsNotifyMessage.getMsgFans();
            this.nbs = newsNotifyMessage.getMsgGiftNum();
            if (this.nby || this.nbw || this.nbx || this.mHasNewVersion) {
                this.nbi = this.nbw ? true : this.nbi;
                this.nbj = this.nby ? true : this.nbj;
                this.nbk = this.nbx ? true : this.nbk;
                this.nbm = this.mHasNewVersion ? true : this.nbm;
                dFa();
            }
        }
    }

    public void dEZ() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.nbv);
    }

    public void xJ(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFa() {
        SparseArray sparseArray = new SparseArray();
        if (this.nbv) {
            sparseArray.append(4, new b.a(this.nbl, this.nbu));
        }
        if (this.nbw) {
            sparseArray.append(2, new b.a(this.nbi, this.nbr));
        }
        if (this.nbx) {
            sparseArray.append(1, new b.a(this.nbk, this.nbs));
        }
        if (this.nby) {
            sparseArray.append(3, new b.a(this.nbj, this.nbt));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.nbm, 0));
        }
        if (this.nbz) {
            sparseArray.append(7, new b.a(this.nbn, 0));
        }
        if (this.nbA) {
            sparseArray.append(9, new b.a(this.nbo, 0));
        }
        if (this.nbB) {
            sparseArray.append(10, new b.a(this.nbp, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        dFb();
    }

    public void xK(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.nbl, this.nbu));
            sparseArray.append(2, new b.a(this.nbi, this.nbr));
            sparseArray.append(1, new b.a(this.nbk, this.nbs));
            sparseArray.append(3, new b.a(this.nbj, this.nbt));
            sparseArray.append(5, new b.a(this.nbm, 0));
            sparseArray.append(7, new b.a(this.nbn, 0));
            sparseArray.append(9, new b.a(this.nbo, 0));
            sparseArray.append(10, new b.a(this.nbp, 0));
            sparseArray.append(11, new b.a(this.nbq, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void dFb() {
        if (((this.nbr > 0 && this.nbw) || (this.nbt > 0 && this.nby) || this.mHasNewVersion || this.nbA || this.nbB) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.nbB) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void dFc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void h(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.nbk = z;
                    break;
                case 2:
                    this.nbi = z;
                    break;
                case 3:
                    this.nbj = z;
                    break;
                case 4:
                    this.nbl = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.nbm = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.nbn = z;
                    break;
                case 9:
                    this.nbo = z;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.nbp = z;
                    break;
                case 11:
                    this.nbq = z;
                    break;
            }
            xK(true);
            dFd();
        }
    }

    private void dFd() {
        boolean z = this.nbk || this.nbj || this.nbi || this.nbl || this.nbm || this.nbn || this.nbo || this.nbq;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void dFe() {
        this.nbi = false;
        this.nbj = false;
        this.nbk = false;
        this.nbl = false;
        this.nbm = false;
        this.nbn = false;
        this.nbo = false;
        this.nbr = 0;
        this.nbs = 0;
        this.nbt = 0;
        this.nbu = 0;
        this.nbv = false;
        this.mHasNewVersion = false;
        this.nbw = false;
        this.nbx = false;
        this.nby = false;
        this.nbz = false;
        this.nbA = false;
        dEX();
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.kpZ) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        dEY();
    }
}
