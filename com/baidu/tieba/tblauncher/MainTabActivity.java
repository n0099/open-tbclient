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
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
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
    private com.baidu.adp.lib.e.b<TbImageView> amf;
    VoiceManager bOT;
    private z fCk;
    private a fCl;
    private com.baidu.adp.lib.e.b<TbImageView> fCn;
    private com.baidu.tieba.a fCp;
    private boolean fCu;
    private boolean isFirstGoMaintab;
    private boolean fCf = false;
    private int fCg = -1;
    private boolean fCh = false;
    private long fCi = 0;
    private long fCj = 0;
    private long fCm = -1;
    private boolean fCo = false;
    private final CustomMessageListener fCq = new c(this, CmdConfigCustom.CMD_CLOSE_MATINTAB);
    private final CustomMessageListener fCr = new k(this, CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE);
    private final CustomMessageListener skinTypeChangeListener = new l(this, CmdConfigCustom.CMD_SKIN_TYPE_CHANGE);
    private final com.baidu.adp.framework.listener.e ddw = new m(this, 1001);
    private final CustomMessageListener fCs = new n(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    final CustomMessageListener ePj = new o(this, CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    final CustomMessageListener fCt = new p(this, CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS);
    private final CustomMessageListener fCv = new q(this, CmdConfigCustom.MAINTAB_SET_INST);
    private CustomMessageListener dmY = new r(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener fCw = new d(this, CmdConfigCustom.CMD_GAME_CENTER_INIT);
    private final CustomMessageListener cyq = new e(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);

    /* JADX INFO: Access modifiers changed from: private */
    public void qx(String str) {
        if (str != null && TbadkCoreApplication.m9getInst().getConfigVersion() != null && bkQ()) {
            this.fCm = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bkQ() {
        if (-1 == this.fCm) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.fCm;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    private void aGF() {
        registerListener(new f(this, CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        if (com.baidu.adp.lib.b.e.eZ().Y("android_game_enter_switch") == 1 && com.baidu.tbadk.core.util.p.aer) {
            this.fCk.fc(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.fCk.fc(false);
        this.fCk.fb(false);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("game_is_show_tip", false);
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && hVar != null) {
            if ((hVar.CG() == 1 || hVar.CG() == 2) && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("show_member_deid_line", true)) {
                long pH = hVar.pH() * 1000;
                if (pH < System.currentTimeMillis()) {
                    if (StringUtils.isNull(hVar.CH())) {
                        hVar.eV(getPageContext().getString(w.l.member));
                    } else {
                        hVar.eV(String.valueOf(hVar.CH()) + getPageContext().getString(w.l.member_already_Expire));
                    }
                    this.fCk.a(hVar, 0);
                } else if (pH - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(hVar.CH())) {
                        hVar.eV(getPageContext().getString(w.l.member));
                    } else {
                        hVar.eV(String.valueOf(hVar.CH()) + getPageContext().getString(w.l.member_will_Expire));
                    }
                    this.fCk.a(hVar, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.fCu) {
            return false;
        }
        if (this.fCk.blc() == null || this.fCk.blc().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.fCk.aGp()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.j.ab.GM().ac(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        aGF();
        int i = -1;
        if (getIntent() != null) {
            V(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
        }
        int i2 = i;
        this.isFirstGoMaintab = TbadkCoreApplication.m9getInst().isFirstGoMaintab();
        y yVar = new y();
        com.baidu.tbadk.core.f.b.a(yVar);
        yVar.a(this);
        if (bkR()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(w.j.maintabs_activity);
        com.baidu.tbadk.core.a.a.pw().px();
        this.fCk = new z(this);
        this.fCk.lA(this.mIsLogin);
        ajY();
        anT();
        com.baidu.tieba.tblauncher.alarmRemind.b.blg().g(this);
        this.fCp = new com.baidu.tieba.a();
        aGl();
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
        this.mHandler.post(new g(this));
        registerListener(this.ddw);
        if (i2 == 1) {
            this.fCk.lB(true);
        } else {
            this.fCk.lB(false);
        }
        this.fCk.bld();
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onCreate(getPageContext());
        }
        registerListener(this.dmY);
        adjustResizeForSoftInput();
        com.baidu.tbadk.j.ab.GM().ad(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.j.ab.GM().GN();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.EB().ED();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
    }

    private void V(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new as("c10320").s("obj_locate", 1).s("obj_type", 1));
                    return;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)").matcher(decode);
                if (matcher.find() && !"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                    TiebaStatic.log(new as("c10320").s("obj_locate", 1).s("obj_type", 1));
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
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onStart(getPageContext());
        }
    }

    public boolean bkR() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        anU();
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zw();
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().zp();
        com.baidu.tbadk.coreExtra.messageCenter.a.zj().aU(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            com.baidu.adp.lib.g.j.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bkS();
        if (this.fCk != null) {
            this.fCk.bkZ();
            if (this.fCk.blc() != null) {
                this.fCk.blc().reset();
            }
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.f.b.a(null);
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onDestory(getPageContext());
        }
        System.gc();
    }

    private void bkS() {
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

    private void anT() {
        registerListener(this.fCq);
        this.ePj.setPriority(100);
        registerListener(this.ePj);
        registerListener(this.fCt);
        registerListener(this.fCv);
        registerListener(this.fCw);
        registerListener(this.cyq);
        registerListener(this.fCs);
        registerListener(this.fCr);
        registerListener(this.skinTypeChangeListener);
        this.fCl = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.fCl, intentFilter);
    }

    private void anU() {
        if (this.fCl != null) {
            unregisterReceiver(this.fCl);
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
        this.fCg = this.fCk.blc().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.j.ab.GM().GL()) {
            com.baidu.tbadk.j.ab.GM().GN();
        }
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onResume(getPageContext());
        }
        if (this.fCk != null) {
            this.fCk.bld();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.fCo = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.EB().ED();
            ajY();
        }
        this.fCk.switchNaviBarStatus(z);
        this.fCk.blc().setWidgetLayerVisibleNoAnimation(false);
        aGl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.fCf) {
            this.fCf = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), w.a.down, w.a.hold);
        }
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.fCk.blc().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        V(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.EB().ED();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            this.fCk.blc().setWidgetLayerVisibleNoAnimation(false);
            aGl();
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
                intExtra = this.fCp.Jk();
            }
            this.fCk.blc().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.fCk != null) {
            this.fCk.bld();
        }
    }

    protected void y(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).bY(w.l.confirm_title).av(false).bZ(w.l.background_process_permission).a(w.l.now_goto_setting, new h(this)).b(w.l.next_time, new i(this)).b(com.baidu.adp.base.k.Z(activity)).tQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkT() {
        com.baidu.adp.lib.f.c.fM().d(getUniqueId());
        bkV();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.j
    public void onPreLoad(BdListView bdListView) {
        super.onPreLoad(bdListView);
        com.baidu.tbadk.core.util.ag.a(bdListView, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.fCk.aGp()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    }
                    if (System.currentTimeMillis() - this.fCi > 2000) {
                        showToast(w.l.double_back_quit);
                        this.fCi = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        y(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bkT();
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Intent intent) {
        try {
            this.fCk.blc().setCurrentTabByType(this.fCp.Jk());
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

    protected void bkU() {
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
            if (this.fCk.blc().getCurrentFragment() != null) {
                this.fCk.blc().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bkU();
        } else if (this.fCk.blc().getCurrentFragment() != null) {
            this.fCk.blc().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.fCk.onChangeSkinType(i);
        bv(i);
    }

    private void bkV() {
        if (System.currentTimeMillis() - this.fCj >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.fCj = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.fCk.blc() != null) {
            return this.fCk.blc().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOT == null) {
            this.bOT = VoiceManager.instance();
        }
        return this.bOT;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xt() {
        if (this.amf == null) {
            this.amf = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amf;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> adl() {
        if (this.fCn == null) {
            this.fCn = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.fCn;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new j(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.fCo && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.fCo = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
