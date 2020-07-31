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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.p.b;
/* loaded from: classes.dex */
public class a {
    private final CustomMessageListener bookMarksGiftAndFansListener;
    private CustomMessageListener feedBackRedTipListener;
    private boolean iFN;
    private boolean isPrimary;
    private CustomMessageListener itX;
    private boolean ltV;
    private boolean ltW;
    private boolean ltX;
    private boolean ltY;
    private boolean ltZ;
    private boolean lua;
    private boolean lub;
    private boolean luc;
    private boolean lud;
    private int lue;
    private int luf;
    private int lug;
    private int luh;
    private boolean lui;
    private boolean luj;
    private boolean luk;
    private boolean lul;
    private boolean lum;
    private boolean lun;
    private boolean luo;
    CustomMessageListener lup;
    private CustomMessageListener luq;
    private CustomMessageListener lur;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean ddu() {
        return this.ltV;
    }

    public boolean ddv() {
        return this.ltW;
    }

    public boolean ddw() {
        return this.lua;
    }

    public boolean ddx() {
        return this.lub;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0706a {
        private static final a lut = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ltV = false;
        this.ltW = false;
        this.ltX = false;
        this.ltY = false;
        this.ltZ = false;
        this.lua = false;
        this.lub = false;
        this.luc = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.lud = false;
        this.lue = 0;
        this.luf = 0;
        this.lug = 0;
        this.luh = 0;
        this.lui = false;
        this.mHasNewVersion = false;
        this.luj = false;
        this.luk = false;
        this.lul = false;
        this.lum = false;
        this.lun = false;
        this.luo = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lup = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.luh >= responseUnreadPointNum.getNum()) {
                        a.this.luh = responseUnreadPointNum.getNum();
                        a.this.lui = false;
                    } else {
                        a.this.lui = true;
                        a.this.ltY = a.this.lui ? true : a.this.ltY;
                        a.this.luh = responseUnreadPointNum.getNum();
                        a.this.ddC();
                    }
                    a.this.ddB();
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
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, true);
                    }
                    a.this.luc = booleanValue;
                    a.this.luo = booleanValue;
                    a.this.ddC();
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
                            if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = false;
                        }
                    }
                    a.this.lum = booleanValue;
                    a.this.lua = booleanValue;
                    a.this.ddC();
                }
            }
        };
        this.luq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.ltZ = a.this.mHasNewVersion ? true : a.this.ltZ;
                    a.this.ddC();
                }
            }
        };
        this.itX = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.ddE();
                        if (a.this.lud) {
                            TiebaStatic.log(new ap("c13688").t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_locate", 1));
                            a.this.lud = false;
                        }
                    }
                }
            }
        };
        this.lur = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.ddG();
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
                        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + currentAccount, "");
                        if (!StringUtils.isNull(dotTimestamp) && !dotTimestamp.equals(string)) {
                            a.this.lub = true;
                            a.this.lun = true;
                            a.this.ddC();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a ddy() {
        return C0706a.lut;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lup);
        MessageManager.getInstance().registerListener(this.luq);
        MessageManager.getInstance().registerListener(this.lur);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.itX);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void ddz() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.ltZ = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.iFN = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void ddA() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.ltZ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lul = newsNotifyMessage.getMsgBookmark() > this.lug;
            this.luj = newsNotifyMessage.getMsgFans() > this.lue;
            this.luk = newsNotifyMessage.getMsgGiftNum() > this.luf;
            this.lug = newsNotifyMessage.getMsgBookmark();
            this.lue = newsNotifyMessage.getMsgFans();
            this.luf = newsNotifyMessage.getMsgGiftNum();
            if (this.lul || this.luj || this.luk || this.mHasNewVersion) {
                this.ltV = this.luj ? true : this.ltV;
                this.ltW = this.lul ? true : this.ltW;
                this.ltX = this.luk ? true : this.ltX;
                this.ltZ = this.mHasNewVersion ? true : this.ltZ;
                ddC();
            }
        }
    }

    public void ddB() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.lui);
    }

    public void uG(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddC() {
        SparseArray sparseArray = new SparseArray();
        if (this.lui) {
            sparseArray.append(4, new b.a(this.ltY, this.luh));
        }
        if (this.luj) {
            sparseArray.append(2, new b.a(this.ltV, this.lue));
        }
        if (this.luk) {
            sparseArray.append(1, new b.a(this.ltX, this.luf));
        }
        if (this.lul) {
            sparseArray.append(3, new b.a(this.ltW, this.lug));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.ltZ, 0));
        }
        if (this.lum) {
            sparseArray.append(7, new b.a(this.lua, 0));
        }
        if (this.lun) {
            sparseArray.append(9, new b.a(this.lub, 0));
        }
        if (this.luo) {
            sparseArray.append(10, new b.a(this.luc, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        ddD();
    }

    public void uH(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.ltY, this.luh));
            sparseArray.append(2, new b.a(this.ltV, this.lue));
            sparseArray.append(1, new b.a(this.ltX, this.luf));
            sparseArray.append(3, new b.a(this.ltW, this.lug));
            sparseArray.append(5, new b.a(this.ltZ, 0));
            sparseArray.append(7, new b.a(this.lua, 0));
            sparseArray.append(9, new b.a(this.lub, 0));
            sparseArray.append(10, new b.a(this.luc, 0));
            sparseArray.append(11, new b.a(this.lud, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void ddD() {
        if (((this.lue > 0 && this.luj) || (this.lug > 0 && this.lul) || this.mHasNewVersion || this.lun || this.luo) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.luo) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true, 0)));
        }
    }

    public void ddE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(false)));
    }

    public void g(int i, boolean z, boolean z2) {
        String currentAccount;
        if (z2) {
            switch (i) {
                case 1:
                    this.ltX = z;
                    break;
                case 2:
                    this.ltV = z;
                    break;
                case 3:
                    this.ltW = z;
                    break;
                case 4:
                    this.ltY = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.ltZ = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.lua = z;
                    break;
                case 9:
                    this.lub = z;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.luc = z;
                    break;
                case 11:
                    this.lud = z;
                    break;
            }
            uH(true);
            ddF();
        }
    }

    private void ddF() {
        boolean z = this.ltX || this.ltW || this.ltV || this.ltY || this.ltZ || this.lua || this.lub || this.lud;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void ddG() {
        this.ltV = false;
        this.ltW = false;
        this.ltX = false;
        this.ltY = false;
        this.ltZ = false;
        this.lua = false;
        this.lub = false;
        this.lue = 0;
        this.luf = 0;
        this.lug = 0;
        this.luh = 0;
        this.lui = false;
        this.mHasNewVersion = false;
        this.luj = false;
        this.luk = false;
        this.lul = false;
        this.lum = false;
        this.lun = false;
        ddz();
        e.lt().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iFN) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        ddA();
    }
}
