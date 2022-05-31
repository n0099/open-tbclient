package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.fluency.config.BdTracesConfig;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.searchbox.player.assistant.KernelCacheAssistant;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a45;
import com.repackage.ag;
import com.repackage.ai4;
import com.repackage.ak8;
import com.repackage.al8;
import com.repackage.am8;
import com.repackage.at4;
import com.repackage.bg0;
import com.repackage.bl8;
import com.repackage.bm4;
import com.repackage.bm8;
import com.repackage.cg0;
import com.repackage.cl8;
import com.repackage.cm8;
import com.repackage.cq4;
import com.repackage.cx4;
import com.repackage.d85;
import com.repackage.dk8;
import com.repackage.dl8;
import com.repackage.e45;
import com.repackage.eg5;
import com.repackage.el8;
import com.repackage.fb5;
import com.repackage.fh5;
import com.repackage.fl8;
import com.repackage.g75;
import com.repackage.gl8;
import com.repackage.gv8;
import com.repackage.he8;
import com.repackage.hk8;
import com.repackage.hl8;
import com.repackage.i75;
import com.repackage.il8;
import com.repackage.j75;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.jl8;
import com.repackage.kl8;
import com.repackage.kp6;
import com.repackage.l25;
import com.repackage.l97;
import com.repackage.li;
import com.repackage.ll8;
import com.repackage.lz4;
import com.repackage.mc5;
import com.repackage.me8;
import com.repackage.mg;
import com.repackage.mh4;
import com.repackage.ml8;
import com.repackage.nh4;
import com.repackage.nj8;
import com.repackage.nk4;
import com.repackage.nl8;
import com.repackage.nn;
import com.repackage.o25;
import com.repackage.oj8;
import com.repackage.ol8;
import com.repackage.pc5;
import com.repackage.pj8;
import com.repackage.pl8;
import com.repackage.qk8;
import com.repackage.ql8;
import com.repackage.qp6;
import com.repackage.rj8;
import com.repackage.rk8;
import com.repackage.rl8;
import com.repackage.rn8;
import com.repackage.sj8;
import com.repackage.sk8;
import com.repackage.sl8;
import com.repackage.tj8;
import com.repackage.tk8;
import com.repackage.tl8;
import com.repackage.tn8;
import com.repackage.ts4;
import com.repackage.uj8;
import com.repackage.uk8;
import com.repackage.ul4;
import com.repackage.ul8;
import com.repackage.vk8;
import com.repackage.vl;
import com.repackage.vl8;
import com.repackage.vs4;
import com.repackage.wk8;
import com.repackage.wl;
import com.repackage.wl4;
import com.repackage.wl8;
import com.repackage.x8;
import com.repackage.x97;
import com.repackage.xc5;
import com.repackage.xk8;
import com.repackage.xl;
import com.repackage.xl8;
import com.repackage.yj8;
import com.repackage.yk8;
import com.repackage.yl8;
import com.repackage.ys4;
import com.repackage.zk;
import com.repackage.zk8;
import com.repackage.zl8;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes4.dex */
public class MainTabActivity extends BaseFragmentActivity implements nj8, VoiceManager.j, UserIconBox.c, bg0, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MIN_SYNC_INTERVAL = 300000;
    public static final long SPAN_TIME = 259200000;
    public static final String TAB_CODE_LOCAL = "local";
    public static final int TAB_ENTER_FORUM = 1;
    public static final int TAB_ENTER_HOME = 0;
    public static final int TAB_ENTER_MESSAGE = 3;
    public static final int TAB_ENTER_MY = 4;
    public static final int TAB_ENTER_NEW_CATEGORY = 2;
    public static boolean syncHasFinish;
    public transient /* synthetic */ FieldHolder $fh;
    public CheckRealNameModel.b checkRealNameCallBack;
    public boolean doRefresh;
    public he8 fetchStampController;
    public RelativeLayout homePreShowView;
    public boolean isAccountStatChanged;
    public boolean isAutoPay;
    public boolean isEnterImageViewActivity;
    public boolean isPermanentBan;
    public boolean isResumed;
    public boolean isShowedNewStyleStampDialog;
    public boolean isUseCurrType;
    public String lastDay;
    public qk8 mActivityResultDelegate;
    public long mAppBackgroundTime;
    public eg5 mAppEntranceModel;
    public nh4 mBdTokenController;
    public rn8 mCancelController;
    public CheckRealNameModel mCheckRealNameModel;
    public ag<TbImageView> mCommonImagePool;
    public Integer mCurrentTabIndex;
    public String mFrom;
    public boolean mIsSplashClick;
    public rk8 mKeyEventDelegate;
    public long mLastSyncTime;
    public int mLikeForumNum;
    public hk8 mLogicController;
    public sj8 mMainTabTopicTipController;
    public fh5 mNEGFeedBackManager;
    public boolean mNeedToRouteLogoActivity;
    public int mOnResumeExecuteForSplashCount;
    public int mOnResumeHotForSplashCount;
    public String mPreUserId;
    public yj8 mPushInsertThreadController;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public boolean mTouchable;
    public int mTriggerSafeModeStatus;
    public tn8 mUegForwardCheckController;
    public i mUpdateReceiver;
    public ag<TbImageView> mUserIconPool;
    public uj8 mViewController;
    public VoiceManager mVoiceManager;
    public WeakReference<Context> mWeakContext;
    public gv8 mWriteTab;
    public boolean needAnim;
    public PackageChangedReceiver packageChangedReceiver;
    public int reloginGotoType;
    public ViewGroup rootView;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public final cg0 touchInfoCollector;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public a(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mTouchable = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ MainTabActivity b;

        public b(MainTabActivity mainTabActivity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mainTabActivity;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.onSecondCreate(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public c(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbadkCoreApplication.getInst().setUsed();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public d(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nk4.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    zk.b();
                }
            }
        }

        public e(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new a(this)).start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public f(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) && CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                this.a.mViewController.P(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03b7));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public g(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            hk8 hk8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hk8Var = this.a.mLogicController) == null || hk8Var.c() == null) {
                return;
            }
            if (UbsABTestHelper.isNewInterestShowTestA()) {
                this.a.mLogicController.c().d();
            } else {
                this.a.mLogicController.c().a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends g75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity b;

        public h(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mainTabActivity;
        }

        @Override // com.repackage.g75
        public boolean a(i75 i75Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i75Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.g75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? j75.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.g75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity this$0;

        public i(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mainTabActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }

        public /* synthetic */ i(MainTabActivity mainTabActivity, a aVar) {
            this(mainTabActivity);
        }
    }

    public MainTabActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needAnim = false;
        this.reloginGotoType = -1;
        this.isUseCurrType = false;
        this.mFrom = null;
        this.mLastSyncTime = -1L;
        this.isAccountStatChanged = false;
        this.mPreUserId = "";
        this.doRefresh = true;
        this.mCurrentTabIndex = -1;
        this.isResumed = false;
        this.isEnterImageViewActivity = false;
        this.mAppBackgroundTime = 0L;
        this.touchInfoCollector = new cg0();
        this.checkRealNameCallBack = new f(this);
    }

    private void callWindowMissed() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        Method method = null;
        try {
            method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        if (method == null || currentFocus == null) {
            return;
        }
        method.setAccessible(true);
        try {
            method.invoke(inputMethodManager, currentFocus.getWindowToken());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
        }
    }

    private void dealIntent(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                this.mIsSplashClick = true;
            }
            TbadkCoreApplication.setIntent(null);
        }
    }

    private boolean getGpuSwich() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    private boolean handlerExitApp(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    private void initSplash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            SpeedStatsManager.getInstance().setIsSwitchOn(AdToMainTabActivitySwitch.getIsOn());
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = rj8.b(getIntent());
            boolean a2 = rj8.a(getIntent());
            this.mNeedToRouteLogoActivity = a2;
            if (a2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this)));
                finish();
                return;
            }
            registerListener(new ul8(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                pj8.a(MainTabScheduleStrategy.SCHEDULE);
                ak8.a().e(this);
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d051d);
            this.rootView = (ViewGroup) findViewById(16908290);
        }
    }

    private boolean isTriggerSafeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.mTriggerSafeModeStatus == 2 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSecondCreate(Bundle bundle) {
        boolean z;
        hk8 hk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                pc5.b(new c(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.tiePlusEventController == null) {
                this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.tiePlusEventController);
            if (handlerExitApp(getIntent())) {
                return;
            }
            ts4.c = ts4.d;
            if (getIntent() != null) {
                yj8 yj8Var = new yj8(getPageContext());
                this.mPushInsertThreadController = yj8Var;
                if (!yj8Var.b(getIntent()) && (hk8Var = this.mLogicController) != null && hk8Var.f() != null) {
                    this.mLogicController.f().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            oj8 oj8Var = new oj8();
            ts4.h(oj8Var);
            oj8Var.g(this);
            if (getGpuSwich()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.mMainTabTopicTipController = new sj8(this);
            this.mViewController.I(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            regReceiver();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            dk8.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_START_STAMP_KEY);
            mh4.x().q();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_END_STAMP_KEY);
            this.mAppEntranceModel = new eg5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            initTabsOnActivityCreated();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new il8(this, this.mViewController));
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
            }
            this.lastDay = UtilHelper.getCurrentDay();
            this.mLastSyncTime = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().registerStickyMode(2001404);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
            dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_START_STAMP_KEY);
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_END_STAMP_KEY);
            registerListener(new ll8(this, this.mViewController));
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            registerListener(new sk8(this, this.mViewController));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                d85.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                o25.d().h();
            }
            int l = ys4.k().l("app_restart_times", 0);
            ys4.k().w("app_restart_times", ((l > 100 || l < 0) ? 100 : 100) + 1);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_START_STAMP_KEY);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.mCheckRealNameModel = checkRealNameModel;
            checkRealNameModel.C(this.checkRealNameCallBack);
            checkRealName();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY);
            this.mNEGFeedBackManager = new fh5(getPageContext(), "homepage");
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
            this.mUegForwardCheckController = new tn8(getPageContext());
            this.mBdTokenController = nh4.D();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TiebaStatic.log(new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", skinType == 4 ? 2 : skinType == 1 ? 1 : 0));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                mg.a().postDelayed(new d(this), 5000L);
            }
            registerListener(new xl8(this, this.mViewController));
            TbSingleton.getInstance().startOneGame();
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_START_STAMP_KEY);
            clearConcernCacheWhenVersionUpdate();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_END_STAMP_KEY);
            yj8 yj8Var2 = this.mPushInsertThreadController;
            if (yj8Var2 != null && yj8Var2.b(intent)) {
                this.mPushInsertThreadController.a(getIntent(), this.mViewController);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY);
            updateProfileInfo();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                kp6.j().D(this, "6051001980-1210572494", kp6.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest() && fb5.r()) {
                kp6.j().E(this, qp6.e().d("frs_feed"), kp6.b("frs", "1"), "", fb5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            hk8 hk8Var2 = this.mLogicController;
            if (hk8Var2 != null && hk8Var2.f() != null) {
                this.mLogicController.f().c();
            }
            mg.a().postDelayed(new e(this), 1000L);
            int l2 = ys4.k().l("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(wl.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new vl("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((l2 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(l2 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    private void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            registerListener(new tk8(this, this.mViewController));
            registerListener(new am8(this, this.mViewController));
            registerListener(new ol8(this, this.mViewController));
            registerListener(new bl8(this, this.mViewController));
            registerListener(new ml8(this, this.mViewController));
            registerListener(new tl8(this, this.mViewController));
            registerListener(new wk8(this, this.mViewController));
            this.mUpdateReceiver = new i(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.mUpdateReceiver, intentFilter);
            this.packageChangedReceiver = new PackageChangedReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter2.addDataScheme("package");
            registerReceiver(this.packageChangedReceiver, intentFilter2);
            registerListener(new rl8(this, this.mViewController));
            registerListener(new wl8(this));
            registerListener(new jl8(this, this.mViewController));
            registerListener(new vk8(this));
            registerListener(new al8(this, this.mViewController));
            registerListener(new cm8(this, this.mViewController));
            registerListener(new bm8(this));
            registerListener(new yk8(this, this.mViewController));
            registerListener(new pl8(this, this.mViewController));
            registerListener(new kl8(this, this.mViewController));
            registerListener(new sl8(this, this.mViewController));
            registerListener(new fl8(this, this.mViewController));
            registerListener(new zk8(this, this.mViewController));
            registerListener(new nl8(this, this.mViewController));
            registerListener(new xk8(this, this.mViewController));
            registerListener(new zl8(this, this.mViewController));
            registerListener(new hl8(this, this.mViewController));
            registerListener(new yl8(this, this.mViewController));
            registerListener(new ql8(this, this.mViewController));
            registerListener(new vl8(this, this.mViewController));
            registerListener(new gl8(this));
            registerListener(new uk8(this, this.mViewController));
            registerListener(new cl8(this, this.mViewController));
            registerListener(new el8(this, this.mViewController));
            registerListener(new dl8(this));
        }
    }

    private boolean shouldCloseDirectly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.mNeedToRouteLogoActivity || !isTaskRoot() || !PermissionUtil.isAgreePrivacyPolicy() || isTriggerSafeMode() : invokeV.booleanValue;
    }

    private void unregReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            i iVar = this.mUpdateReceiver;
            if (iVar != null) {
                unregisterReceiver(iVar);
            }
            PackageChangedReceiver packageChangedReceiver = this.packageChangedReceiver;
            if (packageChangedReceiver != null) {
                unregisterReceiver(packageChangedReceiver);
            }
        }
    }

    public void checkRealName() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (!ys4.k().h(str, true) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !li.D() || (checkRealNameModel = this.mCheckRealNameModel) == null) {
                return;
            }
            checkRealNameModel.z(CheckRealNameModel.TYPE_APP_FIRST_START);
            ys4.k().u(str, false);
        }
    }

    public void clearConcernCacheWhenVersionUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = ys4.o("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (ys4.k().h(str, false)) {
                return;
            }
            cq4.f();
            try {
                cq4.e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                ys4.k().u(str, true);
            } catch (Exception e2) {
                BdLog.e(e2, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.mKeyEventDelegate == null) {
                    this.mKeyEventDelegate = new rk8(this, this.mViewController);
                }
                return this.mKeyEventDelegate.d(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int currentTabType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.mTouchable) {
                uj8 uj8Var = this.mViewController;
                if (uj8Var == null || uj8Var.z() == null || this.mViewController.z().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mViewController.C()) {
                    uj8 uj8Var2 = this.mViewController;
                    if (uj8Var2 != null && uj8Var2.z() != null && ((currentTabType = this.mViewController.z().getCurrentTabType()) == 2 || currentTabType == 22 || currentTabType == 23)) {
                        this.touchInfoCollector.a(motionEvent);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (shouldCloseDirectly()) {
                super.finish();
                return;
            }
            TbSingleton.getInstance().clearVideoRecord();
            TbSingleton.getInstance().setHasAgreeToPlay(false);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.rootView : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.f75
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
            if (!this.isAccountStatChanged || currentPageSourceKeyList == null) {
                return currentPageSourceKeyList;
            }
            currentPageSourceKeyList.clear();
            this.isAccountStatChanged = false;
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.nj8
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            uj8 uj8Var = this.mViewController;
            if (uj8Var == null || uj8Var.z() == null) {
                return -1;
            }
            return this.mViewController.z().getCurrentTabType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ag<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mCommonImagePool == null) {
                this.mCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.mCommonImagePool;
        }
        return (ag) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.f75
    public g75 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new h(this) : (g75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return (TbPageTag) invokeV.objValue;
        }
        uj8 uj8Var = this.mViewController;
        if (uj8Var != null && uj8Var.z() != null) {
            Fragment currentFragment = this.mViewController.z().getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                tbPageTag = ((BaseFragment) currentFragment).getTbPageTag();
                if (tbPageTag != null) {
                    TbPageTag tbPageTag2 = super.getTbPageTag();
                    tbPageTag2.locatePage = "";
                    return tbPageTag2;
                }
                return tbPageTag;
            }
        }
        tbPageTag = null;
        if (tbPageTag != null) {
        }
    }

    @Override // com.repackage.bg0
    @NonNull
    public cg0 getTouchInfoCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.touchInfoCollector : (cg0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (ag) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void initTabsOnActivityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new a45(getPageContext().getPageActivity())));
            } finally {
                TTIStats.record("MainTabActivity.initTabsOnActivityCreated", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) {
            if (shouldCloseDirectly()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.mActivityResultDelegate == null) {
                this.mActivityResultDelegate = new qk8(this, this.mViewController);
            }
            this.mActivityResultDelegate.f(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            uj8 uj8Var = this.mViewController;
            if (uj8Var != null) {
                uj8Var.D(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            gv8 gv8Var = this.mWriteTab;
            if (gv8Var != null) {
                gv8Var.t(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (shouldCloseDirectly()) {
            return;
        }
        ak8.a().b(configuration);
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
        if (TbSingleton.getInstance().isFromFeedVideoClick() && configuration.orientation == 1 && (uj8Var = this.mViewController) != null) {
            uj8Var.D(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            this.mTriggerSafeModeStatus = vs4.q().i(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            d85.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
            if (isTriggerSafeMode()) {
                return;
            }
            if (!isTaskRoot()) {
                if (ul4.e()) {
                    BdLog.e("MainTabActivity没有放在task根，请排查");
                }
                TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", x8.g().e()));
                finish();
            } else if (PermissionUtil.isAgreePrivacyPolicy()) {
                tj8.a(this, getIntent());
                if (bm4.b() != null) {
                    bm4.b().d();
                }
                initUI();
                initSplash();
                if (this.mNeedToRouteLogoActivity) {
                    return;
                }
                if (TbadkCoreApplication.getInst().getStartType() == 2) {
                    if (!TbadkCoreApplication.isLogin()) {
                        me8.r().E(true);
                    } else {
                        TbSingleton.getInstance().accountWhenColdStart = TbadkCoreApplication.getCurrentAccount();
                    }
                }
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                uj8 uj8Var = new uj8(this);
                this.mViewController = uj8Var;
                this.mLogicController = new hk8(this, uj8Var);
                this.mHandler.post(new a(this));
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt != 1) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                pj8.b(new b(this, bundle), 0);
                d85.b().x(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (shouldCloseDirectly()) {
                try {
                    super.onDestroy();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            TbadkCoreApplication.getInst().setMainActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
            unregReceiver();
            cx4.f0().n();
            cx4.f0().p();
            cx4.f0().W(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            at4 at4Var = this.mWaitingDialog;
            if (at4Var != null) {
                at4Var.h(false);
                this.mWaitingDialog = null;
            }
            callWindowMissed();
            uj8 uj8Var = this.mViewController;
            if (uj8Var != null) {
                uj8Var.E();
            }
            sj8 sj8Var = this.mMainTabTopicTipController;
            if (sj8Var != null) {
                sj8Var.i();
            }
            hk8 hk8Var = this.mLogicController;
            if (hk8Var != null && hk8Var.j() != null) {
                this.mLogicController.j().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            ts4.h(null);
            l25.h().l();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            gv8 gv8Var = this.mWriteTab;
            if (gv8Var != null) {
                gv8Var.v();
            }
            fh5 fh5Var = this.mNEGFeedBackManager;
            if (fh5Var != null) {
                fh5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            rn8 rn8Var = this.mCancelController;
            if (rn8Var != null) {
                rn8Var.f();
            }
            uj8 uj8Var2 = this.mViewController;
            if (uj8Var2 != null && uj8Var2.y() != null) {
                this.mViewController.y().t();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                kp6.j().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                kp6.j().c("6061002410-390177882");
            }
            if (this.tiePlusEventController != null) {
                getLifecycle().removeObserver(this.tiePlusEventController);
            }
            x97.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof xl) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            hk8 hk8Var2 = this.mLogicController;
            if (hk8Var2 != null && hk8Var2.d() != null) {
                this.mLogicController.d().c();
            }
            hk8 hk8Var3 = this.mLogicController;
            if (hk8Var3 != null && hk8Var3.h() != null) {
                this.mLogicController.h().c();
            }
            l97.k(this).z();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, keyEvent)) == null) {
            try {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                }
                return super.onKeyDown(i2, keyEvent);
            } catch (IllegalStateException unused) {
                if (i2 == 4) {
                    finish();
                    return true;
                }
                return true;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, keyEvent)) == null) {
            try {
                return super.onKeyUp(i2, keyEvent);
            } catch (IllegalStateException unused) {
                if (i2 == 4) {
                    finish();
                    return true;
                }
                return true;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (uj8Var = this.mViewController) == null) {
            return;
        }
        uj8Var.G(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        uj8 uj8Var;
        FragmentTabHost.b j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
            super.onNewIntent(intent);
            if (shouldCloseDirectly() || handlerExitApp(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            yj8 yj8Var = this.mPushInsertThreadController;
            if (yj8Var != null && yj8Var.b(intent)) {
                this.mPushInsertThreadController.a(intent, this.mViewController);
            } else {
                hk8 hk8Var = this.mLogicController;
                if (hk8Var != null && hk8Var.f() != null) {
                    this.mLogicController.f().b(intent);
                }
            }
            if (StringUtils.isNull(stringExtra)) {
                o25.d().h();
                if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                    initTabsOnActivityCreated();
                }
                this.mFrom = intent.getStringExtra("from");
                int intExtra = intent.getIntExtra("locate_type", 0);
                boolean booleanExtra = intent.getBooleanExtra("is_from_scheme", false);
                if (intExtra == 200) {
                    finish();
                } else if (intExtra == 11) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
                    finish();
                } else if (intExtra == 12) {
                    TbadkCoreApplication.getInst().notifyAppEnterBackground();
                    finish();
                } else if (intExtra == 1 || intExtra == 20 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15 || intExtra == 22) {
                    if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                        if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                            intExtra = 2;
                        } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                            intExtra = this.mAppEntranceModel.a();
                        }
                    }
                    uj8 uj8Var2 = this.mViewController;
                    if (uj8Var2 != null && uj8Var2.z() != null) {
                        this.mViewController.K(intExtra);
                    }
                } else if ((intExtra == 17 || intExtra == 18) && (uj8Var = this.mViewController) != null && uj8Var.z() != null) {
                    this.mViewController.z().setCurrentTab(0);
                }
                uj8 uj8Var3 = this.mViewController;
                if (uj8Var3 != null && uj8Var3.z() != null && (j = this.mViewController.z().j(intExtra)) != null) {
                    Fragment fragment = j.c;
                    if (fragment instanceof wl4) {
                        ((wl4) fragment).t0(intent);
                    }
                }
                dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            if (shouldCloseDirectly()) {
                return;
            }
            ak8.a().c();
            this.isResumed = false;
            LogoActivityConfig.isFirst = false;
            if (this.needAnim) {
                this.needAnim = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010061, R.anim.obfuscated_res_0x7f010085);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            sj8 sj8Var = this.mMainTabTopicTipController;
            if (sj8Var != null) {
                sj8Var.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            l25.h().i(true);
            hk8 hk8Var = this.mLogicController;
            if (hk8Var != null && hk8Var.a() != null) {
                this.mLogicController.a().a();
            }
            hk8 hk8Var2 = this.mLogicController;
            if (hk8Var2 != null && hk8Var2.d() != null) {
                this.mLogicController.d().c();
            }
            uj8 uj8Var = this.mViewController;
            if (uj8Var != null) {
                uj8Var.J();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.repackage.e9
    public void onPreLoad(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, nnVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(nnVar);
                PreLoadImageHelper.load(nnVar, getUniqueId());
                PreLoadVideoHelper.load(nnVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (Throwable th) {
                BdLog.e(th, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        hk8 hk8Var;
        uj8 uj8Var;
        hk8 hk8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (shouldCloseDirectly()) {
                return;
            }
            ak8.a().d();
            this.isResumed = true;
            int i2 = this.mOnResumeExecuteForSplashCount;
            if (i2 <= 1) {
                this.mOnResumeExecuteForSplashCount = i2 + 1;
            }
            int i3 = this.mOnResumeHotForSplashCount;
            if (i3 <= 1) {
                this.mOnResumeHotForSplashCount = i3 + 1;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && this.mOnResumeExecuteForSplashCount > 1 && this.mIsSplashClick) {
                mg.a().postDelayed(new g(this), 500L);
                hk8 hk8Var3 = this.mLogicController;
                if (hk8Var3 != null && hk8Var3.b() != null) {
                    this.mLogicController.b().b();
                }
                hk8 hk8Var4 = this.mLogicController;
                if (hk8Var4 != null && hk8Var4.g() != null) {
                    this.mLogicController.g().a();
                }
                this.mIsSplashClick = false;
                this.mOnResumeExecuteForSplashCount = 2;
            }
            if (!TbSingleton.getInstance().isCanShowHotSplash && !l97.m && !this.mIsSplashClick && (hk8Var2 = this.mLogicController) != null && hk8Var2.b() != null) {
                this.mLogicController.b().b();
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (this.doRefresh) {
                xc5.g(this.mWeakContext);
                this.doRefresh = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (uj8Var = this.mViewController) != null && uj8Var.y() != null) {
                this.mViewController.y().setLottieView(true);
            }
            uj8 uj8Var2 = this.mViewController;
            if (uj8Var2 != null && uj8Var2.z() != null) {
                this.reloginGotoType = this.mViewController.z().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            l25.h().i(true);
            if (TbadkCoreApplication.isLogin() && d85.b().e()) {
                d85.b().f();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            uj8 uj8Var3 = this.mViewController;
            if (uj8Var3 != null) {
                uj8Var3.H();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            d85.b().f();
            if (ai4.f().b() != null && ai4.f().h() != null && ai4.f().b().getCurTaskType() == 6) {
                ai4.f().h().a();
            }
            hk8 hk8Var5 = this.mLogicController;
            if (hk8Var5 != null && hk8Var5.a() != null) {
                this.mLogicController.a().h();
                if (this.mCurrentTabIndex.intValue() != 1) {
                    this.mLogicController.a().h();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (hk8Var = this.mLogicController) != null && hk8Var.d() != null) {
                this.mLogicController.d().d();
            }
            statisticDynamicIconExposure();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                lz4.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                ys4.k().u("key_post_thread_has_request_location", false);
                ys4.k().u("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (shouldCloseDirectly()) {
                return;
            }
            uj8 uj8Var = this.mViewController;
            if (uj8Var != null && uj8Var.z() != null) {
                bundle.putInt("locate_type", this.mViewController.z().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.sdk.h.a.FRAGMENTS_TAG, null);
            bundle.putParcelable("android:support:fragments", null);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            super.onScreenShot(str);
            uj8 uj8Var = this.mViewController;
            if (uj8Var == null || uj8Var.z() == null || this.mViewController.z().getCurrentTabType() != 2) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (this.mNeedToRouteLogoActivity || isTriggerSafeMode()) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onStop();
            if (shouldCloseDirectly()) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.doRefresh = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            super.onUserChanged(z);
            this.isAccountStatChanged = true;
            if (z) {
                o25.d().h();
                checkRealName();
                updateProfileInfo();
            }
            this.mViewController.B();
            initTabsOnActivityCreated();
            ys4.k().u("key_member_auto_ban_renewal_show", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            uj8 uj8Var = this.mViewController;
            if (uj8Var == null) {
                return true;
            }
            return uj8Var.M();
        }
        return invokeV.booleanValue;
    }

    public void statisticDynamicIconExposure() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && e45.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void updateProfileInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && ji.A() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(jg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(getUniqueId());
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(1);
            sendMessage(profileRequestMessage);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return xc5.a(1);
        }
        return invokeV.booleanValue;
    }
}
