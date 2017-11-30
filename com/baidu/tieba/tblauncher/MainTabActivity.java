package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.k.s;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean gDy;
    private com.baidu.adp.lib.e.b<TbImageView> aoO;
    private CheckRealNameModel bHh;
    VoiceManager cGZ;
    private com.baidu.tieba.NEGFeedBack.a cHG;
    private ShareSuccessReplyToServerModel cWG;
    private com.baidu.tieba.write.c cWz;
    private FrameLayout flz;
    private com.baidu.adp.lib.e.b<TbImageView> gDA;
    private com.baidu.tieba.a gDC;
    private boolean gDI;
    private String gDO;
    private c gDw;
    private a gDx;
    private boolean isFirstGoMaintab;
    private boolean gDr = false;
    private int gDs = -1;
    private boolean gDt = false;
    private String mFrom = null;
    private long gDu = 0;
    private long gDv = 0;
    private long gDz = -1;
    private boolean gDB = false;
    private String gDD = "";
    private final CustomMessageListener gDE = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                MainTabActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
                if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                    if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                        MainTabActivity.this.gDw.byh().cA(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.gDw.byh().cA(2);
                    } else {
                        MainTabActivity.this.gDw.byh().cA(1);
                    }
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dPS = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.tr(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener gDF = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int indexOf = str.indexOf("?pid=");
                int indexOf2 = str.indexOf("&tid=");
                int indexOf3 = str.indexOf("&threadtype=");
                int indexOf4 = str.indexOf("&jump_type=");
                String substring = str.substring(indexOf + 5, indexOf2);
                String substring2 = str.substring(indexOf2 + 5, indexOf3);
                String substring3 = str.substring(indexOf3 + 12, indexOf4);
                String substring4 = str.substring(indexOf4 + 11, str.indexOf("&jump_tieba_native"));
                if (!StringUtils.isNull(substring3)) {
                    k.a(substring2, substring, substring4, new Integer(substring3).intValue(), MainTabActivity.this.getPageContext());
                }
            }
        }
    };
    private final CustomMessageListener gDG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData Et = com.baidu.tbadk.getUserInfo.b.Er().Et();
                if (TbadkCoreApplication.isLogin() && Et != null && Et.getUserId() != null && !Et.getUserId().equals(MainTabActivity.this.gDD) && Et.getIsGodInvited()) {
                    MainTabActivity.this.gDD = Et.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS, true)));
                }
            }
        }
    };
    private CustomMessageListener cHS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.gDw.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener fHc = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> oz;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (oz = ((d) customResponsedMessage.getData()).oz()) != null && oz.size() != 0) {
                MainTabActivity.this.gDw.ad(oz);
                if (MainTabActivity.this.gDt) {
                    MainTabActivity.this.gDw.byh().setCurrentTabByType(MainTabActivity.this.gDs);
                } else {
                    MainTabActivity.this.ab(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.gDt = false;
                MainTabActivity.this.gDw.byg();
                int size = oz.size();
                for (int i = 0; i < size; i++) {
                    if (oz.get(i) != null && oz.get(i).EZ() != null && 15 == oz.get(i).EZ().type) {
                        if (MainTabActivity.this.gDw != null) {
                            MainTabActivity.this.gDw.byj();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    };
    final CustomMessageListener gDH = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.aOr();
                if (MainTabActivity.this.gDw != null && MainTabActivity.this.gDw.byh() != null) {
                    MainTabActivity.this.gDs = MainTabActivity.this.gDw.byh().getCurrentTabType();
                }
                MainTabActivity.this.gDt = true;
            }
        }
    };
    private final CustomMessageListener gDJ = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.tY() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CheckRealNameModel.a gDK = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.gDw.tt(MainTabActivity.this.getResources().getString(d.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener gDL = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.hy()) {
                MainTabActivity.this.XA();
                if (!MainTabActivity.gDy) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener cWV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.gDB = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            }
        }
    };
    private CustomMessageListener gDM = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.afx = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bxT();
            }
        }
    };
    private final CustomMessageListener gDN = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.gDw.nm(booleanValue);
            }
        }
    };
    private CustomMessageListener ctd = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.gDy = true;
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().xw()) {
                    MainTabActivity.this.gDw.ts(null);
                    return;
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().xz()) {
                    String xy = TbadkCoreApplication.getInst().getActivityPrizeData().xy();
                    if (!StringUtils.isNull(xy) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                        av.vL().a(MainTabActivity.this.getPageContext(), new String[]{xy}, true);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                    }
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    MainTabActivity.this.gDw.ts(null);
                    return;
                }
                String xB = TbadkCoreApplication.getInst().getActivityPrizeData().xB();
                if (!StringUtils.isNull(xB)) {
                    MainTabActivity.this.gDw.ts(xB);
                } else {
                    MainTabActivity.this.gDw.ts(null);
                }
            }
        }
    };
    private CustomMessageListener gDP = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.gDO = UtilHelper.getCurrentDay();
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.gDO)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bxS()) {
            this.gDz = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bxS() {
        if (-1 == this.gDz) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.gDz;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        if (com.baidu.adp.lib.b.d.eV().af("android_game_enter_switch") == 1 && n.afx) {
            this.gDw.nk(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.gDw.nk(false);
        this.gDw.nm(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Cy() == 1 || payMemberInfoData.Cy() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long ps = payMemberInfoData.ps() * 1000;
                if (ps < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Cz())) {
                        payMemberInfoData.fz(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fz(payMemberInfoData.Cz() + getPageContext().getString(d.j.member_already_Expire));
                    }
                    this.gDw.a(payMemberInfoData, 0);
                } else if (ps - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Cz())) {
                        payMemberInfoData.fz(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fz(payMemberInfoData.Cz() + getPageContext().getString(d.j.member_will_Expire));
                    }
                    this.gDw.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.gDI) {
            return false;
        }
        if (this.gDw.byh() == null || this.gDw.byh().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.gDw.aOv()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void apr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.cWz == null) {
            this.cWz = new com.baidu.tieba.write.c(getPageContext(), this.flz, "main_tab");
            this.cWz.ux("1");
        }
        if (this.gDw != null) {
            this.gDw.byk();
        }
        this.cWz.nU(false);
    }

    protected void aOr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s.GG().ai(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int i = -1;
        if (getIntent() != null) {
            R(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
            if ("from_tieba_kuang".equals(this.mFrom)) {
                TiebaStatic.log(new ak("c12264").r("obj_type", 3));
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.getInst().isFirstGoMaintab();
        b bVar = new b();
        com.baidu.tbadk.core.e.b.a(bVar);
        bVar.a(this);
        if (bxV()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(d.h.maintabs_activity);
        this.flz = (FrameLayout) findViewById(d.g.maintabContainer);
        com.baidu.tbadk.core.a.a.ph().pi();
        this.gDw = new c(this);
        this.gDw.nj(this.mIsLogin);
        bxT();
        awC();
        com.baidu.tieba.tblauncher.alarmRemind.b.byn().g(this);
        this.gDC = new com.baidu.tieba.a();
        aOr();
        aOO();
        bxU();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.az(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.gDI = true;
            }
        });
        registerListener(this.dPS);
        if (i2 == 1) {
            this.gDw.nl(true);
        } else {
            this.gDw.nl(false);
        }
        this.gDw.byi();
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onCreate(getPageContext());
        }
        registerListener(this.cWV);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        s.GG().aj(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            s.GG().GH();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Er().Es();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.bHh = new CheckRealNameModel(getPageContext());
        this.bHh.a(this.gDK);
        XA();
        this.cHG = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.cWG = new ShareSuccessReplyToServerModel();
    }

    private void bxU() {
        av.vL().a(new av.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> ea;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    String eb = av.eb(lowerCase);
                    if (!StringUtils.isNull(eb) && (ea = av.ea(eb)) != null) {
                        String str4 = ea.get(VrPlayerActivityConfig.TITLE);
                        str = !StringUtils.isNull(str4) ? URLDecoder.decode(str4) : str4;
                        str2 = ea.get(ImageViewerConfig.FORUM_ID);
                        str3 = ea.get(ImageViewerConfig.FORUM_NAME);
                        if (!StringUtils.isNull(str3)) {
                            str3 = URLDecoder.decode(str3);
                        }
                    }
                    if (ax.aV(MainTabActivity.this.getBaseContext())) {
                        if (!StringUtils.isNull(str3) && !StringUtils.isNull(str2)) {
                            f.a(tbPageContext, "", new ForumWriteData(str2, str3, null, null));
                        } else {
                            f.a(tbPageContext, str, new ForumWriteData("", "", null, null));
                        }
                        TiebaStatic.log(new ak("c12611").r("obj_locate", 4).r("obj_type", 2));
                        TiebaStatic.log(new ak("c12292").ac("obj_locate", "3"));
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup oX() {
        return this.flz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.hy()) {
            this.bHh.oO(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void R(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new ak("c10320").r("obj_type", 1).r("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> ea = av.ea(decode);
                if (ea != null) {
                    String str = ea.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ak akVar = new ak("c10320");
                        akVar.ac("obj_locate", ea.get("obj_locate"));
                        akVar.r("obj_type", 1);
                        akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ea.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        akVar.ac("obj_param2", ea.get("obj_param2"));
                        akVar.r("obj_to", 1);
                        akVar.ac("obj_id", ea.get("bdid"));
                        if (!am.isEmpty(ea.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(ea.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    akVar.ac(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(akVar);
                    }
                }
            } else if (!StringUtils.isNull(dataString)) {
                if (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://")) {
                    String dataString2 = intent.getDataString();
                    if (!StringUtils.isNull(dataString2)) {
                        av.vL().c(getPageContext(), new String[]{dataString2});
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    public boolean bxV() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        awD();
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().yZ();
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().yS();
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().aR(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            g.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bxW();
        if (this.gDw != null) {
            this.gDw.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        if (this.cWz != null) {
            this.cWz.onDestroy();
        }
        if (this.cHG != null) {
            this.cHG.onDestroy();
        }
        if (this.cWG != null) {
            this.cWG.cancelLoadData();
        }
        System.gc();
    }

    private void bxW() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && currentFocus.getWindowToken() != null && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            Method method = null;
            try {
                method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
            }
            if (method != null && currentFocus != null) {
                method.setAccessible(true);
                try {
                    method.invoke(inputMethodManager, currentFocus.getWindowToken());
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private void i(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void awC() {
        registerListener(this.gDE);
        this.fHc.setPriority(100);
        registerListener(this.fHc);
        registerListener(this.gDH);
        registerListener(this.gDJ);
        registerListener(this.gDM);
        registerListener(this.gDN);
        registerListener(this.gDG);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.gDL);
        this.gDx = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gDx, intentFilter);
        registerListener(this.cHS);
        registerListener(this.gDF);
        registerListener(this.ctd);
        registerListener(this.gDL);
        registerListener(this.gDP);
    }

    private void awD() {
        if (this.gDx != null) {
            unregisterReceiver(this.gDx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.gDs = this.gDw.byh().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && s.GG().GF()) {
            s.GG().GH();
        }
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
        }
        if (this.gDw != null) {
            this.gDw.byi();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        KuangFloatingViewController.getInstance().showFloatingView();
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.gDB = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Er().Es();
            bxT();
            XA();
        }
        this.gDw.switchNaviBarStatus(z);
        aOr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.gDr) {
            this.gDr = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), d.a.down, d.a.hold);
        }
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.gDw != null) {
            this.gDw.byk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.gDw.byh().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
        HomePageStatic.dmm = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        R(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.Er().Es();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aOr();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
            if (intExtra != 8 && intExtra != 3 && intExtra != 15) {
                intExtra = this.gDC.Kn();
            }
            this.gDw.byh().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.gDw != null) {
            this.gDw.byi();
        }
        this.mFrom = getIntent().getStringExtra("from");
        if ("from_tieba_kuang".equals(this.mFrom)) {
            TiebaStatic.log(new ak("c12264").r("obj_type", 3));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    protected void C(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).cc(d.j.confirm_title).ao(false).cd(d.j.background_process_permission).a(d.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(d.j.goto_developActivity_error_toast);
                }
            }
        }).b(d.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.bxX();
            }
        }).b(i.Y(activity)).tk();
    }

    protected void bxX() {
        com.baidu.adp.lib.f.c.fJ().d(getUniqueId());
        bxZ();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.g gVar) {
        super.onPreLoad(gVar);
        ad.a(gVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.cWz != null && this.cWz.isShowing()) {
                    this.cWz.bEZ();
                    return true;
                } else if (this.gDw.aOv()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.gDu > 2000) {
                        showToast(d.j.double_back_quit);
                        this.gDu = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        C(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bxX();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Intent intent) {
        try {
            this.gDw.byh().setCurrentTabByType(this.gDC.Kn());
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    private void aOO() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.gDw.nl(true);
                        MainTabActivity.this.gDw.iv(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.gDw.nl(true);
                        MainTabActivity.this.gDw.iv(false);
                    } else {
                        MainTabActivity.this.gDw.nl(false);
                        MainTabActivity.this.gDw.iv(false);
                    }
                    MainTabActivity.this.gDw.byi();
                }
            }
        });
    }

    protected void bxY() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (i2 != -1) {
            if (i == 12007) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(d.j.login_home_tab), 11003)));
            }
            if (this.gDw.byh().getCurrentFragment() != null) {
                this.gDw.byh().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bxY();
        } else if (i == 13003) {
            ac(intent);
        } else if (i == 23007) {
            K(intent);
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.cWG != null) {
                this.cWG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void zL() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                            }
                        }, 1000L);
                    }
                });
            }
        } else if (this.gDw.byh().getCurrentFragment() != null) {
            this.gDw.byh().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData apF() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.auz == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.auz.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.auC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aux);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(apF(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.AT() != null) {
                        Bundle AT = shareItem.AT();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", AT.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, AT.getString(ImageViewerConfig.FORUM_ID)).ac("tid", AT.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(getPageContext()).tk();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.H(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gDw.onChangeSkinType(i);
        bx(i);
        if (this.cWz != null) {
            this.cWz.onChangeSkinType();
        }
    }

    private void ac(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            this.gDw.b(postWriteCallBackData);
        }
    }

    private void bxZ() {
        if (System.currentTimeMillis() - this.gDv >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.gDv = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.gDw.byh() != null) {
            return this.gDw.byh().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cGZ == null) {
            this.cGZ = VoiceManager.instance();
        }
        return this.cGZ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wO() {
        if (this.aoO == null) {
            this.aoO = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoO;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> akJ() {
        if (this.gDA == null) {
            this.gDA = FrsCommonImageLayout.p(getPageContext().getPageActivity(), 12);
        }
        return this.gDA;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FQ() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FR() {
                return com.baidu.tbadk.pageStayDuration.e.FV().FX();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.gDB && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.gDB = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
