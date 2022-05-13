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
import com.repackage.aj4;
import com.repackage.am4;
import com.repackage.ao8;
import com.repackage.ap8;
import com.repackage.bg;
import com.repackage.bl;
import com.repackage.bo8;
import com.repackage.cn8;
import com.repackage.co8;
import com.repackage.de5;
import com.repackage.dn;
import com.repackage.do8;
import com.repackage.du4;
import com.repackage.en;
import com.repackage.eo8;
import com.repackage.er6;
import com.repackage.ey8;
import com.repackage.f55;
import com.repackage.fn;
import com.repackage.fn4;
import com.repackage.fo8;
import com.repackage.fu4;
import com.repackage.gh8;
import com.repackage.gn8;
import com.repackage.go8;
import com.repackage.hn4;
import com.repackage.ho8;
import com.repackage.io8;
import com.repackage.iu4;
import com.repackage.j55;
import com.repackage.j95;
import com.repackage.jc7;
import com.repackage.jo8;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.ko8;
import com.repackage.kr6;
import com.repackage.ku4;
import com.repackage.ky4;
import com.repackage.lc5;
import com.repackage.lh5;
import com.repackage.lh8;
import com.repackage.li5;
import com.repackage.lo8;
import com.repackage.mi;
import com.repackage.mm8;
import com.repackage.mn4;
import com.repackage.mo8;
import com.repackage.mr4;
import com.repackage.n85;
import com.repackage.ng;
import com.repackage.nj4;
import com.repackage.nm8;
import com.repackage.no8;
import com.repackage.oh0;
import com.repackage.om8;
import com.repackage.oo8;
import com.repackage.p05;
import com.repackage.p35;
import com.repackage.p85;
import com.repackage.ph0;
import com.repackage.pn8;
import com.repackage.po8;
import com.repackage.pq8;
import com.repackage.q85;
import com.repackage.qm8;
import com.repackage.qn8;
import com.repackage.qo8;
import com.repackage.rm8;
import com.repackage.rn8;
import com.repackage.ro8;
import com.repackage.rq8;
import com.repackage.s35;
import com.repackage.sd5;
import com.repackage.sm8;
import com.repackage.sn8;
import com.repackage.so8;
import com.repackage.tm8;
import com.repackage.tn8;
import com.repackage.to8;
import com.repackage.un8;
import com.repackage.uo8;
import com.repackage.vd5;
import com.repackage.vn8;
import com.repackage.vo;
import com.repackage.vo8;
import com.repackage.wn8;
import com.repackage.wo8;
import com.repackage.x8;
import com.repackage.xb7;
import com.repackage.xm8;
import com.repackage.xn8;
import com.repackage.xo8;
import com.repackage.yn8;
import com.repackage.yo8;
import com.repackage.zi4;
import com.repackage.zm8;
import com.repackage.zn8;
import com.repackage.zo8;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes4.dex */
public class MainTabActivity extends BaseFragmentActivity implements mm8, VoiceManager.j, UserIconBox.c, oh0, FrsCommonImageLayout.e, IVideoNeedPreload {
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
    public gh8 fetchStampController;
    public RelativeLayout homePreShowView;
    public boolean isAccountStatChanged;
    public boolean isAutoPay;
    public boolean isEnterImageViewActivity;
    public boolean isPermanentBan;
    public boolean isResumed;
    public boolean isShowedNewStyleStampDialog;
    public boolean isUseCurrType;
    public String lastDay;
    public pn8 mActivityResultDelegate;
    public long mAppBackgroundTime;
    public lh5 mAppEntranceModel;
    public aj4 mBdTokenController;
    public pq8 mCancelController;
    public CheckRealNameModel mCheckRealNameModel;
    public bg<TbImageView> mCommonImagePool;
    public Integer mCurrentTabIndex;
    public String mFrom;
    public boolean mIsSplashClick;
    public qn8 mKeyEventDelegate;
    public long mLastSyncTime;
    public int mLikeForumNum;
    public gn8 mLogicController;
    public rm8 mMainTabTopicTipController;
    public li5 mNEGFeedBackManager;
    public boolean mNeedToRouteLogoActivity;
    public int mOnResumeExecuteForSplashCount;
    public int mOnResumeHotForSplashCount;
    public String mPreUserId;
    public xm8 mPushInsertThreadController;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public boolean mTouchable;
    public int mTriggerSafeModeStatus;
    public rq8 mUegForwardCheckController;
    public i mUpdateReceiver;
    public bg<TbImageView> mUserIconPool;
    public tm8 mViewController;
    public VoiceManager mVoiceManager;
    public WeakReference<Context> mWeakContext;
    public ey8 mWriteTab;
    public boolean needAnim;
    public PackageChangedReceiver packageChangedReceiver;
    public int reloginGotoType;
    public ViewGroup rootView;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public final ph0 touchInfoCollector;

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
    public class c extends sd5<Object> {
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

        @Override // com.repackage.sd5
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
                am4.a();
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
                    bl.b();
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
                this.a.mViewController.P(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03b5));
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
            gn8 gn8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gn8Var = this.a.mLogicController) == null || gn8Var.c() == null) {
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
    public class h extends n85 {
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

        @Override // com.repackage.n85
        public boolean a(p85 p85Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p85Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.n85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? q85.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.n85
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
        this.touchInfoCollector = new ph0();
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
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = qm8.b(getIntent());
            boolean a2 = qm8.a(getIntent());
            this.mNeedToRouteLogoActivity = a2;
            if (a2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this)));
                finish();
                return;
            }
            registerListener(new so8(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                om8.a(MainTabScheduleStrategy.SCHEDULE);
                zm8.a().e(this);
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0527);
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
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                vd5.b(new c(this), null);
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
            du4.c = du4.d;
            if (getIntent() != null) {
                xm8 xm8Var = new xm8(getPageContext());
                this.mPushInsertThreadController = xm8Var;
                if (!xm8Var.b(getIntent()) && (gn8Var = this.mLogicController) != null && gn8Var.f() != null) {
                    this.mLogicController.f().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            nm8 nm8Var = new nm8();
            du4.h(nm8Var);
            nm8Var.g(this);
            if (getGpuSwich()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.mMainTabTopicTipController = new rm8(this);
            this.mViewController.I(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            regReceiver();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            cn8.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_START_STAMP_KEY);
            zi4.y().q();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_END_STAMP_KEY);
            this.mAppEntranceModel = new lh5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            initTabsOnActivityCreated();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new go8(this, this.mViewController));
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
            registerListener(new jo8(this, this.mViewController));
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            registerListener(new rn8(this, this.mViewController));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                j95.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                s35.d().h();
            }
            int l = iu4.k().l("app_restart_times", 0);
            iu4.k().w("app_restart_times", ((l > 100 || l < 0) ? 100 : 100) + 1);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_START_STAMP_KEY);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.mCheckRealNameModel = checkRealNameModel;
            checkRealNameModel.C(this.checkRealNameCallBack);
            checkRealName();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY);
            this.mNEGFeedBackManager = new li5(getPageContext(), "homepage");
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
            this.mUegForwardCheckController = new rq8(getPageContext());
            this.mBdTokenController = aj4.C();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TiebaStatic.log(new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", skinType == 4 ? 2 : skinType == 1 ? 1 : 0));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                ng.a().postDelayed(new d(this), 5000L);
            }
            registerListener(new vo8(this, this.mViewController));
            TbSingleton.getInstance().startOneGame();
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_START_STAMP_KEY);
            clearConcernCacheWhenVersionUpdate();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_END_STAMP_KEY);
            xm8 xm8Var2 = this.mPushInsertThreadController;
            if (xm8Var2 != null && xm8Var2.b(intent)) {
                this.mPushInsertThreadController.a(getIntent(), this.mViewController);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY);
            updateProfileInfo();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                er6.j().D(this, "6051001980-1210572494", er6.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest() && lc5.r()) {
                er6.j().E(this, kr6.e().d("frs_feed"), er6.b("frs", "1"), "", lc5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            gn8 gn8Var2 = this.mLogicController;
            if (gn8Var2 != null && gn8Var2.f() != null) {
                this.mLogicController.f().c();
            }
            ng.a().postDelayed(new e(this), 1000L);
            int l2 = iu4.k().l("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(en.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new dn("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
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
            registerListener(new sn8(this, this.mViewController));
            registerListener(new yo8(this, this.mViewController));
            registerListener(new mo8(this, this.mViewController));
            registerListener(new ao8(this, this.mViewController));
            registerListener(new ko8(this, this.mViewController));
            registerListener(new ro8(this, this.mViewController));
            registerListener(new vn8(this, this.mViewController));
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
            registerListener(new po8(this, this.mViewController));
            registerListener(new uo8(this));
            registerListener(new ho8(this, this.mViewController));
            registerListener(new un8(this));
            registerListener(new zn8(this, this.mViewController));
            registerListener(new ap8(this, this.mViewController));
            registerListener(new zo8(this));
            registerListener(new xn8(this, this.mViewController));
            registerListener(new no8(this, this.mViewController));
            registerListener(new io8(this, this.mViewController));
            registerListener(new qo8(this, this.mViewController));
            registerListener(new do8(this, this.mViewController));
            registerListener(new yn8(this, this.mViewController));
            registerListener(new lo8(this, this.mViewController));
            registerListener(new wn8(this, this.mViewController));
            registerListener(new xo8(this, this.mViewController));
            registerListener(new fo8(this, this.mViewController));
            registerListener(new wo8(this, this.mViewController));
            registerListener(new oo8(this, this.mViewController));
            registerListener(new to8(this, this.mViewController));
            registerListener(new eo8(this));
            registerListener(new tn8(this, this.mViewController));
            registerListener(new bo8(this, this.mViewController));
            registerListener(new co8(this, this.mViewController));
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
            if (!iu4.k().h(str, true) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !mi.C() || (checkRealNameModel = this.mCheckRealNameModel) == null) {
                return;
            }
            checkRealNameModel.z(CheckRealNameModel.TYPE_APP_FIRST_START);
            iu4.k().u(str, false);
        }
    }

    public void clearConcernCacheWhenVersionUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = iu4.o("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (iu4.k().h(str, false)) {
                return;
            }
            mr4.f();
            try {
                mr4.e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                iu4.k().u(str, true);
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
                    this.mKeyEventDelegate = new qn8(this, this.mViewController);
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
                tm8 tm8Var = this.mViewController;
                if (tm8Var == null || tm8Var.z() == null || this.mViewController.z().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mViewController.C()) {
                    tm8 tm8Var2 = this.mViewController;
                    if (tm8Var2 != null && tm8Var2.z() != null && ((currentTabType = this.mViewController.z().getCurrentTabType()) == 2 || currentTabType == 22 || currentTabType == 23)) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
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

    @Override // com.repackage.mm8
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            tm8 tm8Var = this.mViewController;
            if (tm8Var == null || tm8Var.z() == null) {
                return -1;
            }
            return this.mViewController.z().getCurrentTabType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public bg<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mCommonImagePool == null) {
                this.mCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.mCommonImagePool;
        }
        return (bg) invokeV.objValue;
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public n85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new h(this) : (n85) invokeV.objValue;
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
        tm8 tm8Var = this.mViewController;
        if (tm8Var != null && tm8Var.z() != null) {
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

    @Override // com.repackage.oh0
    @NonNull
    public ph0 getTouchInfoCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.touchInfoCollector : (ph0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public bg<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (bg) invokeV.objValue;
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new f55(getPageContext().getPageActivity())));
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
                this.mActivityResultDelegate = new pn8(this, this.mViewController);
            }
            this.mActivityResultDelegate.f(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            tm8 tm8Var = this.mViewController;
            if (tm8Var != null) {
                tm8Var.D(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            ey8 ey8Var = this.mWriteTab;
            if (ey8Var != null) {
                ey8Var.t(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (shouldCloseDirectly()) {
            return;
        }
        zm8.a().b(configuration);
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
        if (TbSingleton.getInstance().isFromFeedVideoClick() && configuration.orientation == 1 && (tm8Var = this.mViewController) != null) {
            tm8Var.D(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            this.mTriggerSafeModeStatus = fu4.q().i(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            j95.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
            if (isTriggerSafeMode()) {
                return;
            }
            if (!isTaskRoot()) {
                if (fn4.e()) {
                    BdLog.e("MainTabActivity没有放在task根，请排查");
                }
                TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", x8.g().e()));
                finish();
            } else if (PermissionUtil.isAgreePrivacyPolicy()) {
                sm8.a(this, getIntent());
                if (mn4.b() != null) {
                    mn4.b().d();
                }
                initUI();
                initSplash();
                if (this.mNeedToRouteLogoActivity) {
                    return;
                }
                if (TbadkCoreApplication.getInst().getStartType() == 2) {
                    if (!TbadkCoreApplication.isLogin()) {
                        lh8.r().E(true);
                    } else {
                        TbSingleton.getInstance().accountWhenColdStart = TbadkCoreApplication.getCurrentAccount();
                    }
                }
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                tm8 tm8Var = new tm8(this);
                this.mViewController = tm8Var;
                this.mLogicController = new gn8(this, tm8Var);
                this.mHandler.post(new a(this));
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt != 1) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                om8.b(new b(this, bundle), 0);
                j95.b().x(System.currentTimeMillis());
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
            ky4.h0().o();
            ky4.h0().q();
            ky4.h0().Y(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            ku4 ku4Var = this.mWaitingDialog;
            if (ku4Var != null) {
                ku4Var.h(false);
                this.mWaitingDialog = null;
            }
            callWindowMissed();
            tm8 tm8Var = this.mViewController;
            if (tm8Var != null) {
                tm8Var.E();
            }
            rm8 rm8Var = this.mMainTabTopicTipController;
            if (rm8Var != null) {
                rm8Var.i();
            }
            gn8 gn8Var = this.mLogicController;
            if (gn8Var != null && gn8Var.j() != null) {
                this.mLogicController.j().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            du4.h(null);
            p35.h().l();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ey8 ey8Var = this.mWriteTab;
            if (ey8Var != null) {
                ey8Var.v();
            }
            li5 li5Var = this.mNEGFeedBackManager;
            if (li5Var != null) {
                li5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            pq8 pq8Var = this.mCancelController;
            if (pq8Var != null) {
                pq8Var.f();
            }
            tm8 tm8Var2 = this.mViewController;
            if (tm8Var2 != null && tm8Var2.y() != null) {
                this.mViewController.y().t();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                er6.j().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                er6.j().c("6061002410-390177882");
            }
            if (this.tiePlusEventController != null) {
                getLifecycle().removeObserver(this.tiePlusEventController);
            }
            jc7.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof fn) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            gn8 gn8Var2 = this.mLogicController;
            if (gn8Var2 != null && gn8Var2.d() != null) {
                this.mLogicController.d().c();
            }
            gn8 gn8Var3 = this.mLogicController;
            if (gn8Var3 != null && gn8Var3.h() != null) {
                this.mLogicController.h().c();
            }
            xb7.k(this).z();
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
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (tm8Var = this.mViewController) == null) {
            return;
        }
        tm8Var.G(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        tm8 tm8Var;
        FragmentTabHost.b j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
            super.onNewIntent(intent);
            if (shouldCloseDirectly() || handlerExitApp(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            xm8 xm8Var = this.mPushInsertThreadController;
            if (xm8Var != null && xm8Var.b(intent)) {
                this.mPushInsertThreadController.a(intent, this.mViewController);
            } else {
                gn8 gn8Var = this.mLogicController;
                if (gn8Var != null && gn8Var.f() != null) {
                    this.mLogicController.f().b(intent);
                }
            }
            if (StringUtils.isNull(stringExtra)) {
                s35.d().h();
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
                    tm8 tm8Var2 = this.mViewController;
                    if (tm8Var2 != null && tm8Var2.z() != null) {
                        this.mViewController.K(intExtra);
                    }
                } else if ((intExtra == 17 || intExtra == 18) && (tm8Var = this.mViewController) != null && tm8Var.z() != null) {
                    this.mViewController.z().setCurrentTab(0);
                }
                tm8 tm8Var3 = this.mViewController;
                if (tm8Var3 != null && tm8Var3.z() != null && (j = this.mViewController.z().j(intExtra)) != null) {
                    Fragment fragment = j.c;
                    if (fragment instanceof hn4) {
                        ((hn4) fragment).r0(intent);
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
            zm8.a().c();
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
            rm8 rm8Var = this.mMainTabTopicTipController;
            if (rm8Var != null) {
                rm8Var.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            p35.h().i(true);
            gn8 gn8Var = this.mLogicController;
            if (gn8Var != null && gn8Var.a() != null) {
                this.mLogicController.a().a();
            }
            gn8 gn8Var2 = this.mLogicController;
            if (gn8Var2 != null && gn8Var2.d() != null) {
                this.mLogicController.d().c();
            }
            tm8 tm8Var = this.mViewController;
            if (tm8Var != null) {
                tm8Var.J();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.repackage.e9
    public void onPreLoad(vo voVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, voVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(voVar);
                PreLoadImageHelper.load(voVar, getUniqueId());
                PreLoadVideoHelper.load(voVar, getUniqueId(), this);
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
        gn8 gn8Var;
        tm8 tm8Var;
        gn8 gn8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (shouldCloseDirectly()) {
                return;
            }
            zm8.a().d();
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
                ng.a().postDelayed(new g(this), 500L);
                gn8 gn8Var3 = this.mLogicController;
                if (gn8Var3 != null && gn8Var3.b() != null) {
                    this.mLogicController.b().b();
                }
                gn8 gn8Var4 = this.mLogicController;
                if (gn8Var4 != null && gn8Var4.g() != null) {
                    this.mLogicController.g().a();
                }
                this.mIsSplashClick = false;
                this.mOnResumeExecuteForSplashCount = 2;
            }
            if (!TbSingleton.getInstance().isCanShowHotSplash && !xb7.m && !this.mIsSplashClick && (gn8Var2 = this.mLogicController) != null && gn8Var2.b() != null) {
                this.mLogicController.b().b();
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (this.doRefresh) {
                de5.g(this.mWeakContext);
                this.doRefresh = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (tm8Var = this.mViewController) != null && tm8Var.y() != null) {
                this.mViewController.y().setLottieView(true);
            }
            tm8 tm8Var2 = this.mViewController;
            if (tm8Var2 != null && tm8Var2.z() != null) {
                this.reloginGotoType = this.mViewController.z().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            p35.h().i(true);
            if (TbadkCoreApplication.isLogin() && j95.b().e()) {
                j95.b().f();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            tm8 tm8Var3 = this.mViewController;
            if (tm8Var3 != null) {
                tm8Var3.H();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            j95.b().f();
            if (nj4.g().c() != null && nj4.g().i() != null && nj4.g().c().getCurTaskType() == 6) {
                nj4.g().i().a();
            }
            gn8 gn8Var5 = this.mLogicController;
            if (gn8Var5 != null && gn8Var5.a() != null) {
                this.mLogicController.a().h();
                if (this.mCurrentTabIndex.intValue() != 1) {
                    this.mLogicController.a().h();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (gn8Var = this.mLogicController) != null && gn8Var.d() != null) {
                this.mLogicController.d().d();
            }
            statisticDynamicIconExposure();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                p05.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                iu4.k().u("key_post_thread_has_request_location", false);
                iu4.k().u("key_home_common_tab_fragment_has_request_location_local", false);
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
            tm8 tm8Var = this.mViewController;
            if (tm8Var != null && tm8Var.z() != null) {
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
            tm8 tm8Var = this.mViewController;
            if (tm8Var == null || tm8Var.z() == null || this.mViewController.z().getCurrentTabType() != 2) {
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
                s35.d().h();
                checkRealName();
                updateProfileInfo();
            }
            this.mViewController.B();
            initTabsOnActivityCreated();
            iu4.k().u("key_member_auto_ban_renewal_show", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            tm8 tm8Var = this.mViewController;
            if (tm8Var == null) {
                return true;
            }
            return tm8Var.M();
        }
        return invokeV.booleanValue;
    }

    public void statisticDynamicIconExposure() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && j55.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void updateProfileInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && ki.A() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(kg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
            return de5.a(1);
        }
        return invokeV.booleanValue;
    }
}
