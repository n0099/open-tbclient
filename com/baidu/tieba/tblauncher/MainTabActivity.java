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
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.l.s;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
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
    private com.baidu.adp.lib.e.b<TbImageView> aoy;
    private CheckRealNameModel byZ;
    private com.baidu.tieba.write.c cMU;
    VoiceManager cxA;
    private com.baidu.tieba.NEGFeedBack.a cyi;
    private FrameLayout fed;
    private com.baidu.tieba.a gtB;
    private boolean gtH;
    private c gtw;
    private a gtx;
    private com.baidu.adp.lib.e.b<TbImageView> gtz;
    private boolean isFirstGoMaintab;
    private boolean gtr = false;
    private int gts = -1;
    private boolean gtt = false;
    private String aiB = null;
    private long gtu = 0;
    private long gtv = 0;
    private long gty = -1;
    private boolean gtA = false;
    private String gtC = "";
    private final CustomMessageListener gtD = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
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
                        MainTabActivity.this.gtw.bwj().cA(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.gtw.bwj().cA(2);
                    } else {
                        MainTabActivity.this.gtw.bwj().cA(1);
                    }
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dHX = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.sO(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener gtE = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
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
    private final CustomMessageListener gtF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData Ea = com.baidu.tbadk.getUserInfo.b.DX().Ea();
                if (TbadkCoreApplication.isLogin() && Ea != null && Ea.getUserId() != null && !Ea.getUserId().equals(MainTabActivity.this.gtC) && Ea.getIsGodInvited()) {
                    MainTabActivity.this.gtC = Ea.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS, true)));
                }
            }
        }
    };
    private CustomMessageListener cyu = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.gtw.b((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener fxX = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> os;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (os = ((d) customResponsedMessage.getData()).os()) != null && os.size() != 0) {
                MainTabActivity.this.gtw.ad(os);
                if (MainTabActivity.this.gtt) {
                    MainTabActivity.this.gtw.bwj().setCurrentTabByType(MainTabActivity.this.gts);
                } else {
                    MainTabActivity.this.X(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.gtt = false;
                MainTabActivity.this.gtw.bwi();
                int size = os.size();
                for (int i = 0; i < size; i++) {
                    if (os.get(i) != null && os.get(i).EG() != null && 15 == os.get(i).EG().type) {
                        if (MainTabActivity.this.gtw != null) {
                            MainTabActivity.this.gtw.bwl();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    };
    final CustomMessageListener gtG = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.aNy();
                if (MainTabActivity.this.gtw != null && MainTabActivity.this.gtw.bwj() != null) {
                    MainTabActivity.this.gts = MainTabActivity.this.gtw.bwj().getCurrentTabType();
                }
                MainTabActivity.this.gtt = true;
            }
        }
    };
    private final CustomMessageListener gtI = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.tV() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CheckRealNameModel.a gtJ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.gtw.sP(MainTabActivity.this.getResources().getString(d.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener gtK = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.hy()) {
                MainTabActivity.this.VF();
            }
        }
    };
    private CustomMessageListener dRz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.gtA = true;
            }
        }
    };
    private CustomMessageListener gtL = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.afa = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bvW();
            }
        }
    };
    private final CustomMessageListener gtM = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.gtw.mG(booleanValue);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void sO(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bvV()) {
            this.gty = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bvV() {
        if (-1 == this.gty) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.gty;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvW() {
        if (com.baidu.adp.lib.b.d.eV().af("android_game_enter_switch") == 1 && n.afa) {
            this.gtw.mE(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.gtw.mE(false);
        this.gtw.mG(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Cc() == 1 || payMemberInfoData.Cc() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long pl = payMemberInfoData.pl() * 1000;
                if (pl < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Cd())) {
                        payMemberInfoData.fs(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fs(payMemberInfoData.Cd() + getPageContext().getString(d.j.member_already_Expire));
                    }
                    this.gtw.a(payMemberInfoData, 0);
                } else if (pl - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Cd())) {
                        payMemberInfoData.fs(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fs(payMemberInfoData.Cd() + getPageContext().getString(d.j.member_will_Expire));
                    }
                    this.gtw.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.gtH) {
            return false;
        }
        if (this.gtw.bwj() == null || this.gtw.bwj().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.gtw.aNC()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void ang() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.cMU == null) {
            this.cMU = new com.baidu.tieba.write.c(getPageContext(), this.fed, "main_tab");
            this.cMU.tJ("1");
        }
        if (this.gtw != null) {
            this.gtw.bwm();
        }
        this.cMU.nk(false);
    }

    protected void aNy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s.Go().af(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int i = -1;
        if (getIntent() != null) {
            Q(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.aiB = getIntent().getStringExtra("from");
            if ("from_tieba_kuang".equals(this.aiB)) {
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
        if (bvY()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(d.h.maintabs_activity);
        this.fed = (FrameLayout) findViewById(d.g.maintabContainer);
        com.baidu.tbadk.core.a.a.pa().pb();
        this.gtw = new c(this);
        this.gtw.mD(this.mIsLogin);
        bvW();
        auL();
        com.baidu.tieba.tblauncher.alarmRemind.b.bwp().g(this);
        this.gtB = new com.baidu.tieba.a();
        aNy();
        aNR();
        bvX();
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
        com.baidu.tbadk.browser.a.ax(getPageContext().getPageActivity());
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
                MainTabActivity.this.gtH = true;
            }
        });
        registerListener(this.dHX);
        if (i2 == 1) {
            this.gtw.mF(true);
        } else {
            this.gtw.mF(false);
        }
        this.gtw.bwk();
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onCreate(getPageContext());
        }
        registerListener(this.dRz);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        s.Go().ag(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            s.Go().Gp();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.DX().DZ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.byZ = new CheckRealNameModel(getPageContext());
        this.byZ.a(this.gtJ);
        VF();
        this.cyi = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
    }

    private void bvX() {
        av.vI().a(new av.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> dY;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String dZ = av.dZ(lowerCase);
                    if (!StringUtils.isNull(dZ) && (dY = av.dY(dZ)) != null) {
                        str = dY.get(VrPlayerActivityConfig.TITLE);
                        if (!StringUtils.isNull(str)) {
                            str = URLDecoder.decode(str);
                        }
                    }
                    if (ax.aT(MainTabActivity.this.getBaseContext())) {
                        f.b(tbPageContext, "", "", str);
                        TiebaStatic.log(new ak("c12292").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup oQ() {
        return this.fed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VF() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.hy()) {
            this.byZ.oD(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void Q(Intent intent) {
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
                Map<String, String> dY = av.dY(decode);
                if (dY != null) {
                    String str = dY.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ak akVar = new ak("c10320");
                        akVar.ac("obj_locate", dY.get("obj_locate"));
                        akVar.r("obj_type", 1);
                        akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dY.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        akVar.ac("obj_param2", dY.get("obj_param2"));
                        akVar.r("obj_to", 1);
                        akVar.ac("obj_id", dY.get("bdid"));
                        if (!am.isEmpty(dY.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(dY.get("ext_log"));
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
                        av.vI().c(getPageContext(), new String[]{dataString2});
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
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    public boolean bvY() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        auM();
        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yP();
        com.baidu.tbadk.coreExtra.messageCenter.a.yC().yI();
        com.baidu.tbadk.coreExtra.messageCenter.a.yC().aQ(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            g.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bvZ();
        if (this.gtw != null) {
            this.gtw.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        if (this.cMU != null) {
            this.cMU.onDestroy();
        }
        if (this.cyi != null) {
            this.cyi.onDestroy();
        }
        System.gc();
    }

    private void bvZ() {
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

    private void auL() {
        registerListener(this.gtD);
        this.fxX.setPriority(100);
        registerListener(this.fxX);
        registerListener(this.gtG);
        registerListener(this.gtI);
        registerListener(this.gtL);
        registerListener(this.gtM);
        registerListener(this.gtF);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.gtK);
        this.gtx = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gtx, intentFilter);
        registerListener(this.cyu);
        registerListener(this.gtE);
    }

    private void auM() {
        if (this.gtx != null) {
            unregisterReceiver(this.gtx);
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
        this.gts = this.gtw.bwj().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && s.Go().Gn()) {
            s.Go().Gp();
        }
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
        }
        if (this.gtw != null) {
            this.gtw.bwk();
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
        this.gtA = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.DX().DZ();
            bvW();
            VF();
        }
        this.gtw.switchNaviBarStatus(z);
        aNy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.gtr) {
            this.gtr = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), d.a.down, d.a.hold);
        }
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.gtw != null) {
            this.gtw.bwm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.gtw.bwj().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
        HomePageStatic.ddm = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Q(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.DX().DZ();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aNy();
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
                intExtra = this.gtB.JF();
            }
            this.gtw.bwj().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.gtw != null) {
            this.gtw.bwk();
        }
        this.aiB = getIntent().getStringExtra("from");
        if ("from_tieba_kuang".equals(this.aiB)) {
            TiebaStatic.log(new ak("c12264").r("obj_type", 3));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    protected void C(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).cb(d.j.confirm_title).ao(false).cc(d.j.background_process_permission).a(d.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
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
                MainTabActivity.this.bwa();
            }
        }).b(i.Y(activity)).th();
    }

    protected void bwa() {
        com.baidu.adp.lib.f.c.fJ().d(getUniqueId());
        bwc();
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
                if (this.cMU != null && this.cMU.isShowing()) {
                    this.cMU.bCj();
                    return true;
                } else if (this.gtw.aNC()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.gtu > 2000) {
                        showToast(d.j.double_back_quit);
                        this.gtu = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        C(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bwa();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        try {
            this.gtw.bwj().setCurrentTabByType(this.gtB.JF());
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

    private void aNR() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.gtw.mF(true);
                        MainTabActivity.this.gtw.ia(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.gtw.mF(true);
                        MainTabActivity.this.gtw.ia(false);
                    } else {
                        MainTabActivity.this.gtw.mF(false);
                        MainTabActivity.this.gtw.ia(false);
                    }
                    MainTabActivity.this.gtw.bwk();
                }
            }
        });
    }

    protected void bwb() {
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
        if (i2 != -1) {
            if (i == 12007) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(d.j.login_home_tab), 11003)));
            }
            if (this.gtw.bwj().getCurrentFragment() != null) {
                this.gtw.bwj().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bwb();
        } else if (i == 13003) {
            Y(intent);
        } else if (i == 23007) {
            K(intent);
        } else if (this.gtw.bwj().getCurrentFragment() != null) {
            this.gtw.bwj().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData anw() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atR == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atR.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.atU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.atP);
        shareFromPBMsgData.setThreadId(shareItem.Xl);
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(anw(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(getPageContext().getPageActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ax() != null) {
                        Bundle Ax = shareItem.Ax();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Ax.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, Ax.getString(ImageViewerConfig.FORUM_ID)).ac("tid", Ax.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gtw.onChangeSkinType(i);
        bw(i);
        if (this.cMU != null) {
            this.cMU.onChangeSkinType();
        }
    }

    private void Y(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            this.gtw.a(postWriteCallBackData);
        }
    }

    private void bwc() {
        if (System.currentTimeMillis() - this.gtv >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.gtv = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.gtw.bwj() != null) {
            return this.gtw.bwj().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cxA == null) {
            this.cxA = VoiceManager.instance();
        }
        return this.cxA;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoy == null) {
            this.aoy = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoy;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aiB() {
        if (this.gtz == null) {
            this.gtz = FrsCommonImageLayout.p(getPageContext().getPageActivity(), 12);
        }
        return this.gtz;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Fx() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Fy() {
                return com.baidu.tbadk.pageStayDuration.e.FD().FF();
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
        if (this.gtA && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.gtA = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
