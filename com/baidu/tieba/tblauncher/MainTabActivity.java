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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.b {
    private com.baidu.adp.lib.e.b<TbImageView> ams;
    VoiceManager bTZ;
    private CheckRealNameModel bgv;
    private FrameLayout eDu;
    private TextView fGA;
    private TbImageView fGB;
    private a fGC;
    private boolean fGI;
    private ak fGm;
    private b fGn;
    private com.baidu.adp.lib.e.b<TbImageView> fGp;
    private com.baidu.tieba.a fGr;
    private View fGs;
    private TbImageView fGt;
    private TextView fGu;
    private TbImageView fGv;
    private TextView fGw;
    private TbImageView fGx;
    private TextView fGy;
    private TbImageView fGz;
    private boolean isFirstGoMaintab;
    private boolean fGg = false;
    private int fGh = -1;
    private boolean fGi = false;
    private boolean fGj = false;
    private long fGk = 0;
    private long fGl = 0;
    private long fGo = -1;
    private boolean fGq = false;
    private int dVd = -1;
    private boolean fGD = false;
    private final CustomMessageListener fGE = new c(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener skinTypeChangeListener = new n(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final CustomMessageListener fGF = new v(this, CmdConfigCustom.CMD_MAINTAB_FRS_DATA_RECEIVE);
    private final com.baidu.adp.framework.listener.e dcV = new w(this, 1001);
    private final CustomMessageListener fGG = new x(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener eTU = new y(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener fGH = new z(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener fGJ = new aa(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener fGK = new ab(this, CmdConfigCustom.CMD_HOME_WRITE_THREAD);
    private CheckRealNameModel.a fGL = new d(this);
    private CustomMessageListener fGM = new e(this, 2000994);
    private CustomMessageListener dmy = new f(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fGN = new g(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private final CustomMessageListener fGO = new h(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);

    /* JADX INFO: Access modifiers changed from: private */
    public void qE(String str) {
        if (str != null && TbadkCoreApplication.m9getInst().getConfigVersion() != null && bjI()) {
            this.fGo = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bjI() {
        if (-1 == this.fGo) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.fGo;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        if (com.baidu.adp.lib.b.e.eZ().Y("android_game_enter_switch") == 1 && com.baidu.tbadk.core.util.p.adB) {
            this.fGm.lA(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.fGm.lA(false);
        this.fGm.lC(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && hVar != null) {
            if ((hVar.BG() == 1 || hVar.BG() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long pg = hVar.pg() * 1000;
                if (pg < System.currentTimeMillis()) {
                    if (StringUtils.isNull(hVar.BH())) {
                        hVar.eQ(getPageContext().getString(w.l.member));
                    } else {
                        hVar.eQ(String.valueOf(hVar.BH()) + getPageContext().getString(w.l.member_already_Expire));
                    }
                    this.fGm.a(hVar, 0);
                } else if (pg - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(hVar.BH())) {
                        hVar.eQ(getPageContext().getString(w.l.member));
                    } else {
                        hVar.eQ(String.valueOf(hVar.BH()) + getPageContext().getString(w.l.member_will_Expire));
                    }
                    this.fGm.a(hVar, 1);
                }
            }
        }
    }

    public void bjK() {
        this.dVd = this.fGm.bka().getCurrentTabType();
        this.fGD = true;
    }

    private void bjL() {
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.MAINTAB_SHOW_LAST_TAB, new i(this)));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.fGI) {
            return false;
        }
        if (this.fGm.bka() == null || this.fGm.bka().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.fGm.aEt()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjM() {
        if (!this.fGj) {
            this.fGj = true;
            if (this.fGs == null) {
                this.fGs = LayoutInflater.from(getBaseContext()).inflate(w.j.bottom_write_thread, (ViewGroup) null);
                this.fGt = (TbImageView) this.fGs.findViewById(w.h.home_write_PL_icon);
                this.fGu = (TextView) this.fGs.findViewById(w.h.home_write_PL_title);
                this.fGv = (TbImageView) this.fGs.findViewById(w.h.home_write_video_icon);
                this.fGw = (TextView) this.fGs.findViewById(w.h.home_write_video_title);
                this.fGx = (TbImageView) this.fGs.findViewById(w.h.home_write_live_icon);
                this.fGy = (TextView) this.fGs.findViewById(w.h.home_write_live_title);
                this.fGz = (TbImageView) this.fGs.findViewById(w.h.home_write_url_icon);
                this.fGA = (TextView) this.fGs.findViewById(w.h.home_write_url_title);
                this.fGB = (TbImageView) this.fGs.findViewById(w.h.write_switch);
                bjS();
            }
            if (this.fGs.getParent() == null) {
                this.eDu.addView(this.fGs);
            }
            GridLayout gridLayout = (GridLayout) this.fGs.findViewById(w.h.type_container);
            gridLayout.setMeasureAllChild(true);
            gridLayout.setVerNum(2);
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            a(gridLayout, showXiaoyingTool);
            boolean fV = com.baidu.tbadk.n.ac.fV();
            b(gridLayout, fV);
            com.baidu.adp.lib.g.h.fS().postDelayed(new j(this, gridLayout), 100L);
            this.fGs.setOnClickListener(new k(this, gridLayout));
            this.fGs.findViewById(w.h.home_write_live).setOnClickListener(new l(this, gridLayout));
            this.fGs.findViewById(w.h.home_write_PL).setOnClickListener(new m(this, gridLayout));
            if (fV) {
                this.fGs.findViewById(w.h.home_write_url).setOnClickListener(new o(this, gridLayout));
            }
            if (showXiaoyingTool) {
                this.fGs.findViewById(w.h.home_write_video).setOnClickListener(new p(this, gridLayout));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12052").Z("obj_locate", "1"));
        }
    }

    private void a(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(w.h.home_write_video).setVisibility(8);
            gridLayout.setVerNum(1);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds180);
            }
        }
    }

    private void b(GridLayout gridLayout, boolean z) {
        if (!z) {
            gridLayout.findViewById(w.h.home_write_url).setVisibility(8);
            gridLayout.setVerNum(1);
            if (gridLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) gridLayout.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds180);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private View mView;

        public a(View view) {
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mView != null) {
                this.mView.setVisibility(8);
            }
            if (MainTabActivity.this.fGs.getParent() == MainTabActivity.this.eDu) {
                MainTabActivity.this.eDu.removeView(MainTabActivity.this.fGs);
            }
            MainTabActivity.this.fGj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view, View view2) {
        if (this.fGC != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fGC);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getBaseContext(), w.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getBaseContext(), w.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        this.fGC = new a(view);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fGC, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aEp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.j.ab.FK().ad(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        int i = -1;
        if (getIntent() != null) {
            X(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m9getInst().isFirstGoMaintab();
        aj ajVar = new aj();
        com.baidu.tbadk.core.f.b.a(ajVar);
        ajVar.a(this);
        if (bjO()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(w.j.maintabs_activity);
        this.eDu = (FrameLayout) findViewById(w.h.maintabContainer);
        com.baidu.tbadk.core.a.a.oV().oW();
        this.fGm = new ak(this);
        this.fGm.lz(this.mIsLogin);
        bjJ();
        alM();
        com.baidu.tieba.tblauncher.alarmRemind.b.bkj().g(this);
        this.fGr = new com.baidu.tieba.a();
        aEp();
        aEJ();
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
        com.baidu.tbadk.browser.f.ar(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.m9getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m9getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m9getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new q(this));
        registerListener(this.dcV);
        if (i2 == 1) {
            this.fGm.lB(true);
        } else {
            this.fGm.lB(false);
        }
        this.fGm.bkb();
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onCreate(getPageContext());
        }
        registerListener(this.dmy);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        com.baidu.tbadk.j.ab.FK().ae(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.j.ab.FK().FL();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Dz().DB();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        registerListener(this.fGK);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.fGj = false;
        this.bgv = new CheckRealNameModel(getPageContext());
        this.bgv.a(this.fGL);
        bjN();
        bjL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjN() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.k.hB()) {
            this.bgv.mN(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void X(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").r("obj_locate", 1).r("obj_type", 1));
                    return;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)").matcher(decode);
                if (matcher.find() && !"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").r("obj_locate", 1).r("obj_type", 1));
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
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onStart(getPageContext());
        }
    }

    public boolean bjO() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        alN();
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().yA();
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().yt();
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().aR(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.MAINTAB_SHOW_LAST_TAB);
        bjP();
        if (this.fGm != null) {
            this.fGm.bjX();
            if (this.fGm.bka() != null) {
                this.fGm.bka().reset();
            }
            this.fGm.bkc();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.f.b.a(null);
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onDestory(getPageContext());
        }
        if (this.fGC != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fGC);
            this.fGC = null;
        }
        System.gc();
    }

    private void bjP() {
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

    private void alM() {
        registerListener(this.fGE);
        this.eTU.setPriority(100);
        registerListener(this.eTU);
        registerListener(this.fGH);
        registerListener(this.fGJ);
        registerListener(this.fGN);
        registerListener(this.fGO);
        registerListener(this.fGG);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.fGF);
        registerListener(this.fGM);
        this.fGn = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.fGn, intentFilter);
    }

    private void alN() {
        if (this.fGn != null) {
            unregisterReceiver(this.fGn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(MainTabActivity mainTabActivity, b bVar) {
            this();
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
        this.fGh = this.fGm.bka().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.j.ab.FK().FJ()) {
            com.baidu.tbadk.j.ab.FK().FL();
        }
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onResume(getPageContext());
        }
        if (this.fGm != null) {
            this.fGm.bkb();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fGq = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Dz().DB();
            bjJ();
            bjN();
        }
        this.fGm.switchNaviBarStatus(z);
        aEp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.fGg) {
            this.fGg = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), w.a.down, w.a.hold);
        }
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.fGm != null) {
            this.fGm.bkc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.fGm.bka().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        X(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.Dz().DB();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aEp();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.m9getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8) {
            if (intExtra != 8 && intExtra != 3) {
                intExtra = this.fGr.It();
            }
            this.fGm.bka().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.fGm != null) {
            this.fGm.bkb();
        }
    }

    protected void z(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bX(w.l.confirm_title).ar(false).bY(w.l.background_process_permission).a(w.l.now_goto_setting, new r(this)).b(w.l.next_time, new s(this)).b(com.baidu.adp.base.k.Z(activity)).tc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjQ() {
        com.baidu.adp.lib.f.c.fM().d(getUniqueId());
        bjT();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.j
    public void onPreLoad(com.baidu.adp.widget.ListView.w wVar) {
        super.onPreLoad(wVar);
        com.baidu.tbadk.core.util.ag.a(wVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.fGs != null && this.fGs.getParent() != null) {
                    d(this.fGs.findViewById(w.h.type_container), this.fGs.findViewById(w.h.write_switch));
                    return true;
                } else if (this.fGm.aEt()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.fGk > 2000) {
                        showToast(w.l.double_back_quit);
                        this.fGk = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        z(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bjQ();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        try {
            this.fGm.bka().setCurrentTabByType(this.fGr.It());
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

    private void aEJ() {
        registerListener(new t(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    protected void bjR() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
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
                TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(w.l.login_home_tab), 11003)));
            }
            if (this.fGm.bka().getCurrentFragment() != null) {
                this.fGm.bka().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bjR();
        } else if (this.fGm.bka().getCurrentFragment() != null) {
            this.fGm.bka().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fGm.onChangeSkinType(i);
        bt(i);
        bjS();
    }

    private void bjS() {
        if (this.fGs != null) {
            com.baidu.tbadk.core.util.aq.k(this.fGs, w.e.cp_bg_line_d);
        }
        if (this.fGt != null) {
            com.baidu.tbadk.core.util.aq.c(this.fGt, w.g.icon_posts_photo_n);
        }
        if (this.fGv != null) {
            com.baidu.tbadk.core.util.aq.c(this.fGv, w.g.icon_posts_video_n);
        }
        if (this.fGx != null) {
            com.baidu.tbadk.core.util.aq.c(this.fGx, w.g.icon_posts_live_n);
        }
        if (this.fGB != null) {
            com.baidu.tbadk.core.util.aq.c(this.fGB, w.g.home_write_s);
        }
        if (this.fGu != null) {
            com.baidu.tbadk.core.util.aq.i(this.fGu, w.e.cp_cont_f);
        }
        if (this.fGw != null) {
            com.baidu.tbadk.core.util.aq.i(this.fGw, w.e.cp_cont_f);
        }
        if (this.fGy != null) {
            com.baidu.tbadk.core.util.aq.i(this.fGy, w.e.cp_cont_f);
        }
        if (this.fGz != null) {
            com.baidu.tbadk.core.util.aq.c(this.fGz, w.g.icon_posts_url_n);
        }
        if (this.fGA != null) {
            com.baidu.tbadk.core.util.aq.i(this.fGA, w.e.cp_cont_f);
        }
    }

    private void bjT() {
        if (System.currentTimeMillis() - this.fGl >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fGl = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.fGm.bka() != null) {
            return this.fGm.bka().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bTZ == null) {
            this.bTZ = VoiceManager.instance();
        }
        return this.bTZ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wC() {
        if (this.ams == null) {
            this.ams = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.ams;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> acv() {
        if (this.fGp == null) {
            this.fGp = FrsCommonImageLayout.r(getPageContext().getPageActivity(), 12);
        }
        return this.fGp;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new u(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.fGq && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.fGq = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
