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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tieba.compatible.CompatibleUtile;
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
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, b {
    private PopupWindow ajs;
    private com.baidu.adp.lib.e.b<TbImageView> amv;
    VoiceManager bOm;
    private com.baidu.tieba.a fyA;
    private View fyB;
    private TbImageView fyC;
    private TextView fyD;
    private TbImageView fyE;
    private TextView fyF;
    private TbImageView fyG;
    private TextView fyH;
    private TbImageView fyI;
    private boolean fyN;
    private ah fyv;
    private a fyw;
    private com.baidu.adp.lib.e.b<TbImageView> fyy;
    private boolean isFirstGoMaintab;
    private View rootView;
    private boolean fyp = false;
    private int fyq = -1;
    private boolean fyr = false;
    private boolean fys = false;
    private long fyt = 0;
    private long fyu = 0;
    private long fyx = -1;
    private boolean fyz = false;
    private final CustomMessageListener fyJ = new c(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener skinTypeChangeListener = new n(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final CustomMessageListener fyK = new s(this, CmdConfigCustom.CMD_MAINTAB_FRS_DATA_RECEIVE);
    private final com.baidu.adp.framework.listener.e cXw = new t(this, 1001);
    private final CustomMessageListener fyL = new u(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener eLj = new v(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener fyM = new w(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener fyO = new x(this, CmdConfigCustom.MAINTAB_SET_INST);
    private final CustomMessageListener fyP = new y(this, CmdConfigCustom.CMD_HOME_WRITE_THREAD);
    private CustomMessageListener dhc = new d(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fyQ = new e(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private final CustomMessageListener fyR = new f(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(String str) {
        if (str != null && TbadkCoreApplication.m9getInst().getConfigVersion() != null && bin()) {
            this.fyx = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bin() {
        if (-1 == this.fyx) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.fyx;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bio() {
        if (com.baidu.adp.lib.b.e.eZ().Y("android_game_enter_switch") == 1 && com.baidu.tbadk.core.util.p.adJ) {
            this.fyv.lf(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.fyv.lf(false);
        this.fyv.lh(false);
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("game_is_show_tip", false);
    }

    public void a(com.baidu.tbadk.data.g gVar) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && gVar != null) {
            if ((gVar.BN() == 1 || gVar.BN() == 2) && com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("show_member_deid_line", true)) {
                long po = gVar.po() * 1000;
                if (po < System.currentTimeMillis()) {
                    if (StringUtils.isNull(gVar.BO())) {
                        gVar.eS(getPageContext().getString(w.l.member));
                    } else {
                        gVar.eS(String.valueOf(gVar.BO()) + getPageContext().getString(w.l.member_already_Expire));
                    }
                    this.fyv.a(gVar, 0);
                } else if (po - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(gVar.BO())) {
                        gVar.eS(getPageContext().getString(w.l.member));
                    } else {
                        gVar.eS(String.valueOf(gVar.BO()) + getPageContext().getString(w.l.member_will_Expire));
                    }
                    this.fyv.a(gVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.fyN) {
            return false;
        }
        if (this.fyv.biC() == null || this.fyv.biC().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.fyv.aDw()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bip() {
        if (!this.fys) {
            this.fys = true;
            if (this.fyB == null) {
                this.fyB = LayoutInflater.from(getBaseContext()).inflate(w.j.bottom_write_thread, (ViewGroup) null);
                this.fyC = (TbImageView) this.fyB.findViewById(w.h.home_write_PL_icon);
                this.fyD = (TextView) this.fyB.findViewById(w.h.home_write_PL_title);
                this.fyE = (TbImageView) this.fyB.findViewById(w.h.home_write_video_icon);
                this.fyF = (TextView) this.fyB.findViewById(w.h.home_write_video_title);
                this.fyG = (TbImageView) this.fyB.findViewById(w.h.home_write_live_icon);
                this.fyH = (TextView) this.fyB.findViewById(w.h.home_write_live_title);
                this.fyI = (TbImageView) this.fyB.findViewById(w.h.write_switch);
                biu();
            }
            this.ajs = new PopupWindow(-1, -1);
            this.ajs.setContentView(this.fyB);
            this.ajs.setSoftInputMode(16);
            this.ajs.setAnimationStyle(w.m.HomeBottomWrite);
            this.ajs.setFocusable(false);
            this.ajs.showAtLocation(this.rootView, 80, 0, 0);
            LinearLayout linearLayout = (LinearLayout) this.fyB.findViewById(w.h.type_container);
            TbImageView tbImageView = (TbImageView) this.fyB.findViewById(w.h.write_switch);
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            a(linearLayout, showXiaoyingTool);
            com.baidu.adp.lib.g.h.fS().postDelayed(new g(this, linearLayout, tbImageView), 100L);
            this.fyB.setOnClickListener(new h(this, linearLayout, tbImageView));
            this.fyB.findViewById(w.h.home_write_live).setOnClickListener(new i(this, linearLayout, tbImageView));
            this.fyB.findViewById(w.h.home_write_PL).setOnClickListener(new j(this, linearLayout, tbImageView));
            if (showXiaoyingTool) {
                this.fyB.findViewById(w.h.home_write_video).setOnClickListener(new k(this, linearLayout, tbImageView));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12052").aa("obj_locate", "1"));
        }
    }

    private void a(LinearLayout linearLayout, boolean z) {
        if (!z) {
            linearLayout.findViewById(w.h.home_write_video).setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.leftMargin = (int) getResources().getDimension(w.f.ds150);
            layoutParams.rightMargin = (int) getResources().getDimension(w.f.ds150);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PopupWindow popupWindow, View view, View view2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getBaseContext(), w.a.home_write_bgout);
        loadAnimation.setFillAfter(true);
        view.startAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getBaseContext(), w.a.home_write_out);
        loadAnimation2.setFillAfter(true);
        view2.startAnimation(loadAnimation2);
        com.baidu.adp.lib.g.h.fS().postDelayed(new l(this, view, popupWindow), 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.j.ab.FQ().ad(System.currentTimeMillis());
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
        ag agVar = new ag();
        com.baidu.tbadk.core.f.b.a(agVar);
        agVar.a(this);
        if (biq()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(w.j.maintabs_activity);
        this.rootView = findViewById(w.h.maintabContainer);
        com.baidu.tbadk.core.a.a.pd().pe();
        this.fyv = new ah(this);
        this.fyv.le(this.mIsLogin);
        bio();
        akM();
        com.baidu.tieba.tblauncher.alarmRemind.b.biL().g(this);
        this.fyA = new com.baidu.tieba.a();
        aDs();
        aDM();
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
        String installOtherApp = TbadkCoreApplication.m9getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), installOtherApp);
            TbadkCoreApplication.m9getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.m9getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new m(this));
        registerListener(this.cXw);
        if (i2 == 1) {
            this.fyv.lg(true);
        } else {
            this.fyv.lg(false);
        }
        this.fyv.biD();
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onCreate(getPageContext());
        }
        registerListener(this.dhc);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        com.baidu.tbadk.j.ab.FQ().ae(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.j.ab.FQ().FR();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.DF().DH();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        registerListener(this.fyP);
        com.baidu.tbadk.core.sharedPref.b.tX().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.tX().getInt("app_restart_times", 0) + 1);
        this.fys = false;
    }

    private void X(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").s("obj_locate", 1).s("obj_type", 1));
                    return;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)").matcher(decode);
                if (matcher.find() && !"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").s("obj_locate", 1).s("obj_type", 1));
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
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onStart(getPageContext());
        }
    }

    public boolean biq() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        akN();
        com.baidu.tbadk.coreExtra.messageCenter.a.yu().yH();
        com.baidu.tbadk.coreExtra.messageCenter.a.yu().yA();
        com.baidu.tbadk.coreExtra.messageCenter.a.yu().aU(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bir();
        if (this.fyv != null) {
            this.fyv.biz();
            if (this.fyv.biC() != null) {
                this.fyv.biC().reset();
            }
            this.fyv.biE();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.f.b.a(null);
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onDestory(getPageContext());
        }
        System.gc();
    }

    private void bir() {
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

    private void akM() {
        registerListener(this.fyJ);
        this.eLj.setPriority(100);
        registerListener(this.eLj);
        registerListener(this.fyM);
        registerListener(this.fyO);
        registerListener(this.fyQ);
        registerListener(this.fyR);
        registerListener(this.fyL);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.fyK);
        this.fyw = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.fyw, intentFilter);
    }

    private void akN() {
        if (this.fyw != null) {
            unregisterReceiver(this.fyw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(MainTabActivity mainTabActivity, a aVar) {
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
        this.fyq = this.fyv.biC().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.j.ab.FQ().FP()) {
            com.baidu.tbadk.j.ab.FQ().FR();
        }
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onResume(getPageContext());
        }
        if (this.fyv != null) {
            this.fyv.biD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fyz = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.DF().DH();
            bio();
        }
        this.fyv.switchNaviBarStatus(z);
        aDs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.fyp) {
            this.fyp = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), w.a.down, w.a.hold);
        }
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.fyv != null) {
            this.fyv.biE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.fyv.biC().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        X(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.DF().DH();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aDs();
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
                intExtra = this.fyA.Iy();
            }
            this.fyv.biC().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.fyv != null) {
            this.fyv.biD();
        }
    }

    protected void x(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bW(w.l.confirm_title).as(false).bX(w.l.background_process_permission).a(w.l.now_goto_setting, new o(this)).b(w.l.next_time, new p(this)).b(com.baidu.adp.base.k.Z(activity)).td();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bis() {
        com.baidu.adp.lib.f.c.fM().d(getUniqueId());
        biv();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.j
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        com.baidu.tbadk.core.util.ag.a(bdListView, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View contentView;
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.ajs != null && this.ajs.isShowing() && (contentView = this.ajs.getContentView()) != null) {
                    a(this.ajs, (LinearLayout) contentView.findViewById(w.h.type_container), (TbImageView) contentView.findViewById(w.h.write_switch));
                    return true;
                } else if (this.fyv.aDw()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.fyt > 2000) {
                        showToast(w.l.double_back_quit);
                        this.fyt = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        x(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bis();
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
            this.fyv.biC().setCurrentTabByType(this.fyA.Iy());
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

    private void aDM() {
        registerListener(new q(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    protected void bit() {
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
            if (this.fyv.biC().getCurrentFragment() != null) {
                this.fyv.biC().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bit();
        } else if (this.fyv.biC().getCurrentFragment() != null) {
            this.fyv.biC().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fyv.onChangeSkinType(i);
        bs(i);
        biu();
    }

    private void biu() {
        if (this.fyB != null) {
            com.baidu.tbadk.core.util.aq.k(this.fyB, w.e.cp_bg_line_d);
        }
        if (this.fyC != null) {
            com.baidu.tbadk.core.util.aq.c(this.fyC, w.g.icon_posts_photo_n);
        }
        if (this.fyE != null) {
            com.baidu.tbadk.core.util.aq.c(this.fyE, w.g.icon_posts_video_n);
        }
        if (this.fyG != null) {
            com.baidu.tbadk.core.util.aq.c(this.fyG, w.g.icon_posts_live_n);
        }
        if (this.fyI != null) {
            com.baidu.tbadk.core.util.aq.c(this.fyI, w.g.home_write_s);
        }
        if (this.fyD != null) {
            com.baidu.tbadk.core.util.aq.i(this.fyD, w.e.cp_cont_f);
        }
        if (this.fyF != null) {
            com.baidu.tbadk.core.util.aq.i(this.fyF, w.e.cp_cont_f);
        }
        if (this.fyH != null) {
            com.baidu.tbadk.core.util.aq.i(this.fyH, w.e.cp_cont_f);
        }
    }

    private void biv() {
        if (System.currentTimeMillis() - this.fyu >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fyu = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.fyv.biC() != null) {
            return this.fyv.biC().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOm == null) {
            this.bOm = VoiceManager.instance();
        }
        return this.bOm;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wG() {
        if (this.amv == null) {
            this.amv = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amv;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> abr() {
        if (this.fyy == null) {
            this.fyy = FrsCommonImageLayout.r(getPageContext().getPageActivity(), 12);
        }
        return this.fyy;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new r(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.fyz && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.fyz = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
