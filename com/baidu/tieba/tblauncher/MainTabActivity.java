package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
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
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.ao;
import com.baidu.tieba.ap5;
import com.baidu.tieba.at8;
import com.baidu.tieba.bt8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cr4;
import com.baidu.tieba.ct8;
import com.baidu.tieba.dh7;
import com.baidu.tieba.di0;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ei0;
import com.baidu.tieba.et8;
import com.baidu.tieba.ft8;
import com.baidu.tieba.fy4;
import com.baidu.tieba.g35;
import com.baidu.tieba.gj5;
import com.baidu.tieba.gt8;
import com.baidu.tieba.hr8;
import com.baidu.tieba.ht8;
import com.baidu.tieba.hv4;
import com.baidu.tieba.hy4;
import com.baidu.tieba.im;
import com.baidu.tieba.ir8;
import com.baidu.tieba.is8;
import com.baidu.tieba.it8;
import com.baidu.tieba.jm;
import com.baidu.tieba.jr8;
import com.baidu.tieba.js8;
import com.baidu.tieba.jt8;
import com.baidu.tieba.k39;
import com.baidu.tieba.ka5;
import com.baidu.tieba.kj5;
import com.baidu.tieba.km;
import com.baidu.tieba.km4;
import com.baidu.tieba.ks8;
import com.baidu.tieba.kt8;
import com.baidu.tieba.ky4;
import com.baidu.tieba.lm4;
import com.baidu.tieba.lr8;
import com.baidu.tieba.ls8;
import com.baidu.tieba.lt8;
import com.baidu.tieba.ml;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mp4;
import com.baidu.tieba.mr8;
import com.baidu.tieba.ms8;
import com.baidu.tieba.mt8;
import com.baidu.tieba.mw6;
import com.baidu.tieba.n9;
import com.baidu.tieba.ng;
import com.baidu.tieba.nr8;
import com.baidu.tieba.ns8;
import com.baidu.tieba.nt8;
import com.baidu.tieba.oa5;
import com.baidu.tieba.or8;
import com.baidu.tieba.os8;
import com.baidu.tieba.ot8;
import com.baidu.tieba.oy4;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.ph7;
import com.baidu.tieba.ps8;
import com.baidu.tieba.pt8;
import com.baidu.tieba.qs8;
import com.baidu.tieba.qt8;
import com.baidu.tieba.rs8;
import com.baidu.tieba.rt8;
import com.baidu.tieba.rv8;
import com.baidu.tieba.sq4;
import com.baidu.tieba.sr8;
import com.baidu.tieba.ss8;
import com.baidu.tieba.st8;
import com.baidu.tieba.sw6;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.th5;
import com.baidu.tieba.tj5;
import com.baidu.tieba.tr8;
import com.baidu.tieba.ts8;
import com.baidu.tieba.tt8;
import com.baidu.tieba.tv8;
import com.baidu.tieba.ue5;
import com.baidu.tieba.uq4;
import com.baidu.tieba.us8;
import com.baidu.tieba.ut8;
import com.baidu.tieba.v85;
import com.baidu.tieba.vs8;
import com.baidu.tieba.vt8;
import com.baidu.tieba.wd5;
import com.baidu.tieba.wg;
import com.baidu.tieba.wm8;
import com.baidu.tieba.wr8;
import com.baidu.tieba.ws8;
import com.baidu.tieba.x55;
import com.baidu.tieba.xi;
import com.baidu.tieba.xs8;
import com.baidu.tieba.y85;
import com.baidu.tieba.yd5;
import com.baidu.tieba.ym4;
import com.baidu.tieba.ys8;
import com.baidu.tieba.zd5;
import com.baidu.tieba.zg;
import com.baidu.tieba.zn5;
import com.baidu.tieba.zr8;
import com.baidu.tieba.zs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes6.dex */
public class MainTabActivity extends BaseFragmentActivity implements hr8, VoiceManager.j, UserIconBox.c, di0, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static /* synthetic */ Interceptable $ic;
    public static boolean W;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Integer B;
    public sr8 C;
    public boolean D;
    public boolean E;
    @Nullable
    public TiePlusEventController F;
    public wm8 G;
    public boolean H;
    public int I;
    public int J;
    public long K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public final ei0 P;
    public boolean Q;
    public tr8 R;
    @NonNull
    public final PriorityOrganizer S;
    public vt8 T;
    public CheckRealNameModel.b U;
    public String V;
    public boolean a;
    public int b;
    public boolean c;
    public or8 d;
    public zr8 e;
    public js8 f;
    public is8 g;
    public i h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public ng<TbImageView> l;
    public ng<TbImageView> m;
    public boolean n;
    public zn5 o;
    public ViewGroup p;
    public k39 q;
    public CheckRealNameModel r;
    public String s;
    public ap5 t;
    public ShareSuccessReplyToServerModel u;
    public mr8 v;
    public lm4 w;
    public rv8 x;
    public boolean y;
    public WeakReference<Context> z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes6.dex */
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
                    ml.b();
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

    /* loaded from: classes6.dex */
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
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.b.h1(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends gj5<Object> {
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

        @Override // com.baidu.tieba.gj5
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

    /* loaded from: classes6.dex */
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
                mp4.a();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.d.R(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03c3));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            zr8 zr8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zr8Var = this.a.e) != null && zr8Var.b() != null) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.a.e.b().d();
                } else {
                    this.a.e.b().a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends wd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity b;

        @Override // com.baidu.tieba.wd5
        public boolean a(yd5 yd5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yd5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.wd5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tieba.wd5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return zd5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
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

        public /* synthetic */ i(MainTabActivity mainTabActivity, a aVar) {
            this(mainTabActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
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
        this.a = false;
        this.b = -1;
        this.c = false;
        this.j = -1L;
        this.n = false;
        this.s = "";
        this.y = true;
        this.B = -1;
        this.D = false;
        this.E = false;
        this.K = 0L;
        this.P = new ei0();
        this.S = PriorityOrganizer.n();
        this.U = new f(this);
    }

    public final void R0() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        Method method = null;
        try {
            method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        if (method != null && currentFocus != null) {
            method.setAccessible(true);
            try {
                method.invoke(inputMethodManager, currentFocus.getWindowToken());
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
    }

    public void S0() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (ky4.k().h(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && xi.F() && (checkRealNameModel = this.r) != null) {
                checkRealNameModel.A(CheckRealNameModel.TYPE_APP_FIRST_START);
                ky4.k().u(str, false);
            }
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String str = ky4.o("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (!ky4.k().h(str, false)) {
                hv4.f();
                try {
                    hv4.e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                    ky4.k().u(str, true);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = lr8.a(getIntent());
            registerListener(new nt8(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                jr8.a(MainTabScheduleStrategy.SCHEDULE);
                tr8.a().e(this);
            } else if (!TbSingleton.getInstance().getIsPushOrSchemeLog()) {
                BaseVM.m(1);
            } else {
                TbSingleton.getInstance().setPushOrSchemeLog(false);
            }
        }
    }

    public final void U0(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                TbSingleton.getInstance().mIsSplashClick = true;
            }
            TbadkCoreApplication.setIntent(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048616, this, i2, keyEvent)) == null) {
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

    public final boolean Z0(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.O = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048611, this, i2) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        TbSingleton.getInstance().mIsForceLayoutMaintab = true;
        or8 or8Var = this.d;
        if (or8Var != null) {
            or8Var.F(i2);
        }
        adjustResizeForSoftInputOnSkinTypeChanged(i2);
        k39 k39Var = this.q;
        if (k39Var != null) {
            k39Var.d(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        or8 or8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (or8Var = this.d) != null) {
            or8Var.I(z);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (Throwable th) {
                BdLog.e(th, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l == null) {
                this.l = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.l;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.P;
        }
        return (ei0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ng<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.m == null) {
                this.m = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.m;
        }
        return (ng) invokeV.objValue;
    }

    public final boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public vt8 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.T;
        }
        return (vt8) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.hr8
    @NonNull
    public PriorityOrganizer d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.S;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0582);
            this.p = (ViewGroup) findViewById(16908290);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.O;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (k1()) {
                super.finish();
                return;
            }
            TbSingleton.getInstance().clearVideoRecord();
            TbSingleton.getInstance().setHasAgreeToPlay(false);
            super.finish();
        }
    }

    public final boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.N == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vd5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
            if (this.n && currentPageSourceKeyList != null) {
                currentPageSourceKeyList.clear();
                this.n = false;
                return null;
            }
            return currentPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr8
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            or8 or8Var = this.d;
            if (or8Var != null && or8Var.B() != null) {
                return this.d.B().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vd5
    public wd5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return new h(this);
        }
        return (wd5) invokeV.objValue;
    }

    public final boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (isTaskRoot() && PermissionUtil.isAgreePrivacyPolicy() && !g1()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && oa5.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            i iVar = this.h;
            if (iVar != null) {
                unregisterReceiver(iVar);
            }
            PackageChangedReceiver packageChangedReceiver = this.i;
            if (packageChangedReceiver != null) {
                unregisterReceiver(packageChangedReceiver);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onStop();
            if (k1()) {
                return;
            }
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onStop(getPageContext());
            }
            j1(false);
            this.y = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            or8 or8Var = this.d;
            if (or8Var == null) {
                return true;
            }
            return or8Var.O();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return tj5.a(1);
        }
        return invokeV.booleanValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new ka5(getPageContext().getPageActivity())));
            } finally {
                TTIStats.record("MainTabActivity.initTabsOnActivityCreated", System.currentTimeMillis() - currentTimeMillis);
            }
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            or8 or8Var = this.d;
            if (or8Var != null && or8Var.B() != null) {
                Fragment currentFragment = this.d.B().getCurrentFragment();
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
        } else {
            return (TbPageTag) invokeV.objValue;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (g1()) {
                return;
            }
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.f == null) {
                    this.f = new js8(this, this.d);
                }
                return this.f.f(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, configuration) != null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (k1()) {
            return;
        }
        tr8 tr8Var = this.R;
        if (tr8Var != null) {
            tr8Var.b(configuration);
        }
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.v9
    public void onPreLoad(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, aoVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(aoVar);
                PreLoadImageHelper.load(aoVar, getUniqueId());
                PreLoadVideoHelper.load(aoVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            super.onScreenShot(str);
            or8 or8Var = this.d;
            if (or8Var != null && or8Var.B() != null && this.d.B().getCurrentTabType() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.onUserChanged(z);
            this.n = true;
            if (z) {
                y85.d().h();
                S0();
                n1();
            }
            this.d.D();
            b1();
            ky4.k().u("key_member_auto_ban_renewal_show", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int currentTabType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (!this.Q) {
                return false;
            }
            or8 or8Var = this.d;
            if (or8Var != null && or8Var.B() != null && this.d.B().getCurrentTabType() == 1 && motionEvent.getPointerCount() > 1 && this.d.E()) {
                return true;
            }
            or8 or8Var2 = this.d;
            if (or8Var2 != null && or8Var2.B() != null && ((currentTabType = this.d.B().getCurrentTabType()) == 2 || currentTabType == 22)) {
                this.P.a(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (k1()) {
                return;
            }
            or8 or8Var = this.d;
            if (or8Var != null && or8Var.B() != null) {
                bundle.putInt("locate_type", this.d.B().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.i.a.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void h1(Bundle bundle) {
        int i2;
        boolean z;
        zr8 zr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                kj5.b(new c(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.F == null) {
                this.F = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.F);
            if (Z0(getIntent())) {
                return;
            }
            fy4.c = fy4.d;
            if (getIntent() != null) {
                sr8 sr8Var = new sr8(getPageContext());
                this.C = sr8Var;
                if (!sr8Var.b(getIntent()) && (zr8Var = this.e) != null && zr8Var.e() != null) {
                    this.e.e().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            ir8 ir8Var = new ir8();
            fy4.h(ir8Var);
            ir8Var.g(this);
            if (X0()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.v = new mr8(this);
            this.d.K(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            i1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            wr8.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            km4.w().q();
            this.o = new zn5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            b1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new ct8(this, this.d));
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
            }
            this.V = UtilHelper.getCurrentDay();
            this.j = System.currentTimeMillis();
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
            U0(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            registerListener(new ft8(this, this.d));
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onCreate(getPageContext());
            }
            registerListener(new ks8(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                ue5.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                y85.d().h();
            }
            int l = ky4.k().l("app_restart_times", 0);
            ky4.k().w("app_restart_times", ((l > 100 || l < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.r = checkRealNameModel;
            checkRealNameModel.D(this.U);
            S0();
            this.t = new ap5(getPageContext(), "homepage");
            this.u = new ShareSuccessReplyToServerModel();
            new tv8(getPageContext());
            this.w = lm4.E();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            StatisticItem param = new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (skinType == 4) {
                i2 = 2;
            } else if (skinType == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param.param("obj_type", i2));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                zg.a().postDelayed(new d(this), 5000L);
            }
            registerListener(new rt8(this, this.d));
            TbSingleton.getInstance().startOneGame();
            this.z = new WeakReference<>(TbadkCoreApplication.getInst());
            T0();
            sr8 sr8Var2 = this.C;
            if (sr8Var2 != null && sr8Var2.b(intent)) {
                this.C.a(getIntent(), this.d);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY);
            n1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                mw6.m().J(this, mw6.g(), mw6.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest() && th5.r()) {
                mw6.m().K(this, sw6.e().d("frs_feed"), mw6.b("frs", "1"), "", th5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            zr8 zr8Var2 = this.e;
            if (zr8Var2 != null && zr8Var2.e() != null) {
                this.e.e().c();
            }
            zg.a().postDelayed(new e(this), 1000L);
            int l2 = ky4.k().l("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(jm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new im("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((l2 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(l2 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            registerListener(new ls8(this, this.d));
            registerListener(new it8(this, this.d));
            registerListener(new us8(this, this.d));
            registerListener(new gt8(this, this.d));
            registerListener(new mt8(this, this.d));
            registerListener(new ps8(this, this.d));
            registerListener(new bt8(this, this.d));
            this.h = new i(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.h, intentFilter);
            this.i = new PackageChangedReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter2.addDataScheme("package");
            registerReceiver(this.i, intentFilter2);
            registerListener(new lt8(this, this.d));
            registerListener(new qt8(this, this.d));
            registerListener(new dt8(this, this.d));
            registerListener(new os8(this));
            registerListener(new ts8(this, this.d));
            registerListener(new ut8(this, this.d));
            registerListener(new tt8(this));
            registerListener(new rs8(this, this.d));
            registerListener(new jt8(this, this.d));
            registerListener(new et8(this, this.d));
            registerListener(new ys8(this, this.d));
            registerListener(new ss8(this, this.d));
            registerListener(new ht8(this, this.d));
            registerListener(new qs8(this, this.d));
            registerListener(new st8(this, this.d));
            registerListener(new kt8(this, this.d));
            registerListener(new pt8(this, this.d));
            registerListener(new ot8(this));
            registerListener(new at8(this));
            registerListener(new ms8(this, this.d));
            registerListener(new vs8(this, this.d));
            registerListener(new xs8(this, this.d));
            registerListener(new ws8(this));
            registerListener(new ns8(this));
            registerListener(new zs8(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            getLifecycle().removeObserver(this.S);
            if (k1()) {
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
            m1();
            g35.h0().n();
            g35.h0().p();
            g35.h0().X(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            oy4 oy4Var = this.mWaitingDialog;
            if (oy4Var != null) {
                oy4Var.h(false);
                this.mWaitingDialog = null;
            }
            R0();
            or8 or8Var = this.d;
            if (or8Var != null) {
                or8Var.G();
            }
            mr8 mr8Var = this.v;
            if (mr8Var != null) {
                mr8Var.i();
            }
            zr8 zr8Var = this.e;
            if (zr8Var != null && zr8Var.i() != null) {
                this.e.i().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            fy4.h(null);
            v85.h().l();
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onDestory(getPageContext());
            }
            k39 k39Var = this.q;
            if (k39Var != null) {
                k39Var.e();
            }
            ap5 ap5Var = this.t;
            if (ap5Var != null) {
                ap5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.u;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            rv8 rv8Var = this.x;
            if (rv8Var != null) {
                rv8Var.f();
            }
            or8 or8Var2 = this.d;
            if (or8Var2 != null && or8Var2.A() != null) {
                this.d.A().t();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                mw6.m().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                mw6.m().c(mw6.s());
            }
            if (this.F != null) {
                getLifecycle().removeObserver(this.F);
            }
            ph7.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof km) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            zr8 zr8Var2 = this.e;
            if (zr8Var2 != null && zr8Var2.c() != null) {
                this.e.c().c();
            }
            zr8 zr8Var3 = this.e;
            if (zr8Var3 != null && zr8Var3.g() != null) {
                this.e.g().c();
            }
            zr8 zr8Var4 = this.e;
            if (zr8Var4 != null && zr8Var4.f() != null) {
                this.e.f().b();
            }
            dh7.n(this).B();
            System.gc();
        }
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately() || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        profileRequestMessage.set_uid(Long.valueOf(wg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i2, i3, intent) == null) {
            if (k1()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.g == null) {
                this.g = new is8(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            getLifecycle().addObserver(this.S);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            ue5.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                return;
            }
            this.N = hy4.q().i(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
            if (g1()) {
                return;
            }
            if (!isTaskRoot()) {
                if (sq4.e()) {
                    BdLog.e("MainTabActivity没有放在task根，请排查");
                }
                TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", n9.g().e()));
                finish();
                return;
            }
            nr8.a(this, getIntent());
            if (cr4.b() != null) {
                cr4.b().d();
            }
            d1();
            a1();
            if (PreInitMainTabViewSwitch.getIsOn()) {
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
            }
            or8 or8Var = new or8(this);
            this.d = or8Var;
            this.T = new vt8(this, or8Var);
            this.e = new zr8(this, this.d);
            this.mHandler.post(new a(this));
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
            jr8.b(new b(this, bundle), 0);
            ue5.b().x(System.currentTimeMillis());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, keyEvent)) == null) {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        or8 or8Var;
        or8 or8Var2;
        FragmentTabHost.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            super.onNewIntent(intent);
            if (k1() || Z0(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            sr8 sr8Var = this.C;
            if (sr8Var != null && sr8Var.b(intent)) {
                this.C.a(intent, this.d);
            } else {
                zr8 zr8Var = this.e;
                if (zr8Var != null && zr8Var.e() != null) {
                    this.e.e().b(intent);
                }
            }
            if (!StringUtils.isNull(stringExtra)) {
                return;
            }
            y85.d().h();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                b1();
            }
            intent.getStringExtra("from");
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
            } else if (intExtra != 1 && intExtra != 20 && intExtra != 3 && intExtra != 2 && intExtra != 4 && intExtra != 8 && intExtra != 15 && intExtra != 22) {
                if ((intExtra == 17 || intExtra == 18) && (or8Var = this.d) != null && or8Var.B() != null) {
                    this.d.B().setCurrentTab(0);
                }
            } else {
                if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                    if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        intExtra = 2;
                    } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                        intExtra = this.o.a();
                    }
                }
                or8 or8Var3 = this.d;
                if (or8Var3 != null && or8Var3.B() != null) {
                    this.d.M(intExtra);
                }
            }
            or8 or8Var4 = this.d;
            if (or8Var4 != null && or8Var4.B() != null && (g2 = this.d.B().g(intExtra)) != null) {
                Fragment fragment = g2.c;
                if (fragment instanceof uq4) {
                    ((uq4) fragment).d1(intent);
                }
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (or8Var2 = this.d) != null && or8Var2.B() != null) {
                this.d.M(2);
            }
            U0(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPause();
            if (k1()) {
                return;
            }
            tr8 tr8Var = this.R;
            if (tr8Var != null) {
                tr8Var.c();
            }
            this.D = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010061, R.anim.obfuscated_res_0x7f01008b);
            }
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onPause(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            mr8 mr8Var = this.v;
            if (mr8Var != null) {
                mr8Var.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            v85.h().i(true);
            zr8 zr8Var = this.e;
            if (zr8Var != null && zr8Var.a() != null) {
                this.e.a().a();
            }
            zr8 zr8Var2 = this.e;
            if (zr8Var2 != null && zr8Var2.c() != null) {
                this.e.c().c();
            }
            or8 or8Var = this.d;
            if (or8Var != null) {
                or8Var.L();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        zr8 zr8Var;
        or8 or8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (k1()) {
                return;
            }
            tr8 tr8Var = this.R;
            if (tr8Var != null) {
                tr8Var.d();
            }
            this.D = true;
            int i2 = this.I;
            if (i2 <= 1) {
                this.I = i2 + 1;
            }
            int i3 = this.J;
            if (i3 <= 1) {
                this.J = i3 + 1;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && this.I > 1 && TbSingleton.getInstance().mIsSplashClick) {
                zg.a().postDelayed(new g(this), 500L);
                TbSingleton.getInstance().mIsSplashClick = false;
                this.I = 2;
            }
            zr8 zr8Var2 = this.e;
            if (zr8Var2 != null && zr8Var2.a() != null) {
                j1(true);
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (this.y) {
                tj5.f(this.z);
                this.y = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (or8Var = this.d) != null && or8Var.A() != null) {
                this.d.A().setLottieView(true);
            }
            or8 or8Var2 = this.d;
            if (or8Var2 != null && or8Var2.B() != null) {
                this.b = this.d.B().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            v85.h().i(true);
            if (TbadkCoreApplication.isLogin() && ue5.b().e()) {
                ue5.b().f();
            }
            VoiceManager s0 = s0();
            this.k = s0;
            if (s0 != null) {
                s0.onResume(getPageContext());
            }
            or8 or8Var3 = this.d;
            if (or8Var3 != null) {
                or8Var3.J();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            ue5.b().f();
            if (ym4.f().b() != null && ym4.f().h() != null && ym4.f().b().getCurTaskType() == 6) {
                ym4.f().h().a();
            }
            zr8 zr8Var3 = this.e;
            if (zr8Var3 != null && zr8Var3.a() != null) {
                this.e.a().f();
                if (this.B.intValue() != 1) {
                    this.e.a().f();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (zr8Var = this.e) != null && zr8Var.c() != null) {
                this.e.c().d();
            }
            l1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                x55.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                ky4.k().u("key_post_thread_has_request_location", false);
                ky4.k().u("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }
}
