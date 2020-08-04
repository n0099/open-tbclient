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
    private boolean iFP;
    private boolean isPrimary;
    private CustomMessageListener itZ;
    private boolean ltX;
    private boolean ltY;
    private boolean ltZ;
    private boolean lua;
    private boolean lub;
    private boolean luc;
    private boolean lud;
    private boolean lue;
    private boolean luf;
    private int lug;
    private int luh;
    private int lui;
    private int luj;
    private boolean luk;
    private boolean lul;
    private boolean lum;
    private boolean lun;
    private boolean luo;
    private boolean lup;
    private boolean luq;
    CustomMessageListener lur;
    private CustomMessageListener lus;
    private CustomMessageListener lut;
    private boolean mHasNewVersion;
    private CustomMessageListener memberCenterRedTipListener;
    private CustomMessageListener syncFinishListener;

    public boolean ddu() {
        return this.ltX;
    }

    public boolean ddv() {
        return this.ltY;
    }

    public boolean ddw() {
        return this.luc;
    }

    public boolean ddx() {
        return this.lud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0706a {
        private static final a luv = new a();
    }

    private a() {
        this.isPrimary = false;
        this.ltX = false;
        this.ltY = false;
        this.ltZ = false;
        this.lua = false;
        this.lub = false;
        this.luc = false;
        this.lud = false;
        this.lue = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
        this.luf = false;
        this.lug = 0;
        this.luh = 0;
        this.lui = 0;
        this.luj = 0;
        this.luk = false;
        this.mHasNewVersion = false;
        this.lul = false;
        this.lum = false;
        this.lun = false;
        this.luo = false;
        this.lup = false;
        this.luq = false;
        this.bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.p.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    a.this.d(customResponsedMessage);
                }
            }
        };
        this.lur = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM) { // from class: com.baidu.tieba.p.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                    ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
                    if (responseUnreadPointNum.getNum() <= 0 || a.this.luj >= responseUnreadPointNum.getNum()) {
                        a.this.luj = responseUnreadPointNum.getNum();
                        a.this.luk = false;
                    } else {
                        a.this.luk = true;
                        a.this.lua = a.this.luk ? true : a.this.lua;
                        a.this.luj = responseUnreadPointNum.getNum();
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
                    a.this.lue = booleanValue;
                    a.this.luq = booleanValue;
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
                    a.this.luo = booleanValue;
                    a.this.luc = booleanValue;
                    a.this.ddC();
                }
            }
        };
        this.lus = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_VERSION_MSG) { // from class: com.baidu.tieba.p.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    a.this.mHasNewVersion = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    a.this.lub = a.this.mHasNewVersion ? true : a.this.lub;
                    a.this.ddC();
                }
            }
        };
        this.itZ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.p.a.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof Integer) && ((Integer) data).intValue() == 4) {
                        a.this.ddE();
                        if (a.this.luf) {
                            TiebaStatic.log(new ap("c13688").t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_locate", 1));
                            a.this.luf = false;
                        }
                    }
                }
            }
        };
        this.lut = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.7
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
                            a.this.lud = true;
                            a.this.lup = true;
                            a.this.ddC();
                        }
                    }
                }
            }
        };
        initListener();
    }

    public static final a ddy() {
        return C0706a.luv;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bookMarksGiftAndFansListener);
        MessageManager.getInstance().registerListener(this.lur);
        MessageManager.getInstance().registerListener(this.lus);
        MessageManager.getInstance().registerListener(this.lut);
        MessageManager.getInstance().registerListener(this.memberCenterRedTipListener);
        MessageManager.getInstance().registerListener(this.itZ);
        MessageManager.getInstance().registerListener(this.feedBackRedTipListener);
        MessageManager.getInstance().registerListener(this.syncFinishListener);
    }

    private void ddz() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, false) && currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
            this.lub = true;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        this.iFP = inst.loadBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), false);
    }

    private void ddA() {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(this.lub)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            this.lun = newsNotifyMessage.getMsgBookmark() > this.lui;
            this.lul = newsNotifyMessage.getMsgFans() > this.lug;
            this.lum = newsNotifyMessage.getMsgGiftNum() > this.luh;
            this.lui = newsNotifyMessage.getMsgBookmark();
            this.lug = newsNotifyMessage.getMsgFans();
            this.luh = newsNotifyMessage.getMsgGiftNum();
            if (this.lun || this.lul || this.lum || this.mHasNewVersion) {
                this.ltX = this.lul ? true : this.ltX;
                this.ltY = this.lun ? true : this.ltY;
                this.ltZ = this.lum ? true : this.ltZ;
                this.lub = this.mHasNewVersion ? true : this.lub;
                ddC();
            }
        }
    }

    public void ddB() {
        TbadkSettings inst = TbadkSettings.getInst();
        StringBuilder append = new StringBuilder().append(SharedPrefConfig.HAS_CLICKED_ADDRESSLIST_ITEM_IN_LEFTNAVI);
        TbadkCoreApplication.getInst();
        inst.saveBoolean(append.append(TbadkCoreApplication.getCurrentAccount()).toString(), !this.luk);
    }

    public void uG(boolean z) {
        this.isPrimary = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddC() {
        SparseArray sparseArray = new SparseArray();
        if (this.luk) {
            sparseArray.append(4, new b.a(this.lua, this.luj));
        }
        if (this.lul) {
            sparseArray.append(2, new b.a(this.ltX, this.lug));
        }
        if (this.lum) {
            sparseArray.append(1, new b.a(this.ltZ, this.luh));
        }
        if (this.lun) {
            sparseArray.append(3, new b.a(this.ltY, this.lui));
        }
        if (this.mHasNewVersion) {
            sparseArray.append(5, new b.a(this.lub, 0));
        }
        if (this.luo) {
            sparseArray.append(7, new b.a(this.luc, 0));
        }
        if (this.lup) {
            sparseArray.append(9, new b.a(this.lud, 0));
        }
        if (this.luq) {
            sparseArray.append(10, new b.a(this.lue, 0));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        ddD();
    }

    public void uH(boolean z) {
        if (z) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.append(4, new b.a(this.lua, this.luj));
            sparseArray.append(2, new b.a(this.ltX, this.lug));
            sparseArray.append(1, new b.a(this.ltZ, this.luh));
            sparseArray.append(3, new b.a(this.ltY, this.lui));
            sparseArray.append(5, new b.a(this.lub, 0));
            sparseArray.append(7, new b.a(this.luc, 0));
            sparseArray.append(9, new b.a(this.lud, 0));
            sparseArray.append(10, new b.a(this.lue, 0));
            sparseArray.append(11, new b.a(this.luf, 0));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_RED_TIP, new b(sparseArray)));
        }
    }

    private void ddD() {
        if (((this.lug > 0 && this.lul) || (this.lui > 0 && this.lun) || this.mHasNewVersion || this.lup || this.luq) && !this.isPrimary && TbadkCoreApplication.isLogin()) {
            if (this.luq) {
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
                    this.ltZ = z;
                    break;
                case 2:
                    this.ltX = z;
                    break;
                case 3:
                    this.ltY = z;
                    break;
                case 4:
                    this.lua = z;
                    break;
                case 5:
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_SETTING_CLICKED, true);
                    }
                    this.lub = z;
                    break;
                case 7:
                    if (!TbadkCoreApplication.isLogin()) {
                        currentAccount = "temp";
                    } else {
                        currentAccount = TbadkCoreApplication.getCurrentAccount();
                    }
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + currentAccount, TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime());
                    this.luc = z;
                    break;
                case 9:
                    this.lud = z;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.PERSON_ITEM_ACTIVITY_PRIZE_RED_TIP + TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getInst().getActivityPrizeData().getDotTimestamp());
                    break;
                case 10:
                    this.lue = z;
                    break;
                case 11:
                    this.luf = z;
                    break;
            }
            uH(true);
            ddF();
        }
    }

    private void ddF() {
        boolean z = this.ltZ || this.ltY || this.ltX || this.lua || this.lub || this.luc || this.lud || this.luf;
        if (!this.isPrimary && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(z, 0)));
        }
    }

    public void ddG() {
        this.ltX = false;
        this.ltY = false;
        this.ltZ = false;
        this.lua = false;
        this.lub = false;
        this.luc = false;
        this.lud = false;
        this.lug = 0;
        this.luh = 0;
        this.lui = 0;
        this.luj = 0;
        this.luk = false;
        this.mHasNewVersion = false;
        this.lul = false;
        this.lum = false;
        this.lun = false;
        this.luo = false;
        this.lup = false;
        ddz();
        e.lt().post(new Runnable() { // from class: com.baidu.tieba.p.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.iFP) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
                }
            }
        });
        ddA();
    }
}
