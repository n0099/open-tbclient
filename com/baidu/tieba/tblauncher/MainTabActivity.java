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
import com.baidu.tieba.a55;
import com.baidu.tieba.aq4;
import com.baidu.tieba.ar8;
import com.baidu.tieba.as8;
import com.baidu.tieba.au8;
import com.baidu.tieba.b85;
import com.baidu.tieba.bq8;
import com.baidu.tieba.br8;
import com.baidu.tieba.bs8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cq4;
import com.baidu.tieba.cr8;
import com.baidu.tieba.cs8;
import com.baidu.tieba.cv6;
import com.baidu.tieba.dh;
import com.baidu.tieba.di0;
import com.baidu.tieba.di5;
import com.baidu.tieba.dr8;
import com.baidu.tieba.ds8;
import com.baidu.tieba.dv4;
import com.baidu.tieba.ei0;
import com.baidu.tieba.ej;
import com.baidu.tieba.eq8;
import com.baidu.tieba.er8;
import com.baidu.tieba.es8;
import com.baidu.tieba.fl8;
import com.baidu.tieba.fm4;
import com.baidu.tieba.fr8;
import com.baidu.tieba.fs8;
import com.baidu.tieba.gh;
import com.baidu.tieba.gr8;
import com.baidu.tieba.gs8;
import com.baidu.tieba.hi5;
import com.baidu.tieba.ho;
import com.baidu.tieba.hq8;
import com.baidu.tieba.hr8;
import com.baidu.tieba.i25;
import com.baidu.tieba.if7;
import com.baidu.tieba.ir8;
import com.baidu.tieba.jq4;
import com.baidu.tieba.jr8;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kr8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.lr8;
import com.baidu.tieba.lx4;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mr8;
import com.baidu.tieba.mu4;
import com.baidu.tieba.n9;
import com.baidu.tieba.n95;
import com.baidu.tieba.nr8;
import com.baidu.tieba.or8;
import com.baidu.tieba.ox4;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.pi5;
import com.baidu.tieba.pm;
import com.baidu.tieba.pr8;
import com.baidu.tieba.qm;
import com.baidu.tieba.qp8;
import com.baidu.tieba.qr8;
import com.baidu.tieba.r95;
import com.baidu.tieba.rg5;
import com.baidu.tieba.rl4;
import com.baidu.tieba.rm;
import com.baidu.tieba.rp8;
import com.baidu.tieba.rr8;
import com.baidu.tieba.sd5;
import com.baidu.tieba.sl4;
import com.baidu.tieba.sp8;
import com.baidu.tieba.sr8;
import com.baidu.tieba.sx4;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tl;
import com.baidu.tieba.to4;
import com.baidu.tieba.tr8;
import com.baidu.tieba.u19;
import com.baidu.tieba.uf7;
import com.baidu.tieba.ug;
import com.baidu.tieba.um5;
import com.baidu.tieba.un5;
import com.baidu.tieba.up8;
import com.baidu.tieba.uq8;
import com.baidu.tieba.ur8;
import com.baidu.tieba.vc5;
import com.baidu.tieba.vp8;
import com.baidu.tieba.vq8;
import com.baidu.tieba.vr8;
import com.baidu.tieba.wp8;
import com.baidu.tieba.wq8;
import com.baidu.tieba.wr8;
import com.baidu.tieba.wu6;
import com.baidu.tieba.xc5;
import com.baidu.tieba.xp8;
import com.baidu.tieba.xq8;
import com.baidu.tieba.xr8;
import com.baidu.tieba.y75;
import com.baidu.tieba.yc5;
import com.baidu.tieba.yq8;
import com.baidu.tieba.yr8;
import com.baidu.tieba.yt8;
import com.baidu.tieba.zq8;
import com.baidu.tieba.zr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes5.dex */
public class MainTabActivity extends BaseFragmentActivity implements qp8, VoiceManager.j, UserIconBox.c, di0, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static /* synthetic */ Interceptable $ic;
    public static boolean W;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> A;
    public int B;
    public Integer C;
    public bq8 D;
    public boolean E;
    public boolean F;
    @Nullable
    public TiePlusEventController G;
    public fl8 H;
    public boolean I;
    public int J;
    public int K;
    public long L;
    public boolean M;
    public boolean N;
    public int O;
    public boolean P;
    public final ei0 Q;
    public boolean R;
    public eq8 S;
    @NonNull
    public final PriorityOrganizer T;
    public CheckRealNameModel.b U;
    public String V;
    public boolean a;
    public int b;
    public boolean c;
    public xp8 d;
    public lq8 e;
    public vq8 f;
    public uq8 g;
    public i h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public ug<TbImageView> l;
    public ug<TbImageView> m;
    public boolean n;
    public um5 o;
    public ViewGroup p;
    public u19 q;
    public CheckRealNameModel r;
    public String s;
    public un5 t;
    public ShareSuccessReplyToServerModel u;
    public au8 v;
    public vp8 w;
    public sl4 x;
    public yt8 y;
    public boolean z;

    /* loaded from: classes5.dex */
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
                this.a.R = true;
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class c extends di5<Object> {
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

        @Override // com.baidu.tieba.di5
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

    /* loaded from: classes5.dex */
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
                to4.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes5.dex */
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
                    tl.b();
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

    /* loaded from: classes5.dex */
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
                this.a.d.R(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03ba));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            lq8 lq8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lq8Var = this.a.e) == null || lq8Var.c() == null) {
                return;
            }
            if (UbsABTestHelper.isNewInterestShowTestA()) {
                this.a.e.c().d();
            } else {
                this.a.e.c().a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends vc5 {
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

        @Override // com.baidu.tieba.vc5
        public boolean a(xc5 xc5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xc5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.vc5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? yc5.b().c() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.vc5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
        this.a = false;
        this.b = -1;
        this.c = false;
        this.j = -1L;
        this.n = false;
        this.s = "";
        this.z = true;
        this.C = -1;
        this.E = false;
        this.F = false;
        this.L = 0L;
        this.Q = new ei0();
        this.T = PriorityOrganizer.n();
        this.U = new f(this);
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ug<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l == null) {
                this.l = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.l;
        }
        return (ug) invokeV.objValue;
    }

    public final void R0() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ug<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.m;
        }
        return (ug) invokeV.objValue;
    }

    public void S0() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (!ox4.k().h(str, true) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !ej.D() || (checkRealNameModel = this.r) == null) {
                return;
            }
            checkRealNameModel.A(CheckRealNameModel.TYPE_APP_FIRST_START);
            ox4.k().u(str, false);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str = ox4.o("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (ox4.k().h(str, false)) {
                return;
            }
            mu4.f();
            try {
                mu4.e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                ox4.k().u(str, true);
            } catch (Exception e2) {
                BdLog.e(e2, true);
            }
        }
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Q : (ei0) invokeV.objValue;
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

    public final boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @NonNull
    public lq8 W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (lq8) invokeV.objValue;
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

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = up8.a(getIntent());
            registerListener(new zr8(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                sp8.a(MainTabScheduleStrategy.SCHEDULE);
                eq8 eq8Var = new eq8(this);
                this.S = eq8Var;
                dv4.d(eq8Var);
            } else if (!TbSingleton.getInstance().getIsPushOrSchemeLog()) {
                BaseVM.m(1);
            } else {
                TbSingleton.getInstance().setPushOrSchemeLog(false);
            }
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new n95(getPageContext().getPageActivity())));
            } finally {
                TTIStats.record("MainTabActivity.initTabsOnActivityCreated", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0572);
            this.p = (ViewGroup) findViewById(16908290);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.qp8
    @NonNull
    public PriorityOrganizer d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.T : (PriorityOrganizer) invokeV.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.P : invokeV.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.f == null) {
                    this.f = new vq8(this, this.d);
                }
                return this.f.f(keyEvent);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (this.R) {
                xp8 xp8Var = this.d;
                if (xp8Var == null || xp8Var.B() == null || this.d.B().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.d.E()) {
                    xp8 xp8Var2 = this.d;
                    if (xp8Var2 != null && xp8Var2.B() != null && ((currentTabType = this.d.B().getCurrentTabType()) == 2 || currentTabType == 22)) {
                        this.Q.a(motionEvent);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public final boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.O == 2 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (k1()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.uc5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
            if (!this.n || currentPageSourceKeyList == null) {
                return currentPageSourceKeyList;
            }
            currentPageSourceKeyList.clear();
            this.n = false;
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qp8
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            xp8 xp8Var = this.d;
            if (xp8Var == null || xp8Var.B() == null) {
                return -1;
            }
            return this.d.B().getCurrentTabType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.uc5
    public vc5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? new h(this) : (vc5) invokeV.objValue;
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
        if (interceptable != null && (invokeV = interceptable.invokeV(1048602, this)) != null) {
            return (TbPageTag) invokeV.objValue;
        }
        xp8 xp8Var = this.d;
        if (xp8Var != null && xp8Var.B() != null) {
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
    }

    public final void h1(Bundle bundle) {
        boolean z;
        lq8 lq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                hi5.b(new c(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.G == null) {
                this.G = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.G);
            if (Z0(getIntent())) {
                return;
            }
            jx4.c = jx4.d;
            if (getIntent() != null) {
                bq8 bq8Var = new bq8(getPageContext());
                this.D = bq8Var;
                if (!bq8Var.b(getIntent()) && (lq8Var = this.e) != null && lq8Var.f() != null) {
                    this.e.f().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            rp8 rp8Var = new rp8();
            jx4.h(rp8Var);
            rp8Var.g(this);
            if (V0()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.w = new vp8(this);
            this.d.K(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            i1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            hq8.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            rl4.w().q();
            this.o = new um5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            b1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new nr8(this, this.d));
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
            registerListener(new qr8(this, this.d));
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onCreate(getPageContext());
            }
            registerListener(new wq8(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                sd5.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                b85.d().h();
            }
            int l = ox4.k().l("app_restart_times", 0);
            ox4.k().w("app_restart_times", ((l > 100 || l < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.r = checkRealNameModel;
            checkRealNameModel.D(this.U);
            S0();
            this.t = new un5(getPageContext(), "homepage");
            this.u = new ShareSuccessReplyToServerModel();
            this.v = new au8(getPageContext());
            this.x = sl4.D();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TiebaStatic.log(new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", skinType == 4 ? 2 : skinType == 1 ? 1 : 0));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                gh.a().postDelayed(new d(this), 5000L);
            }
            registerListener(new ds8(this, this.d));
            TbSingleton.getInstance().startOneGame();
            this.A = new WeakReference<>(TbadkCoreApplication.getInst());
            T0();
            bq8 bq8Var2 = this.D;
            if (bq8Var2 != null && bq8Var2.b(intent)) {
                this.D.a(getIntent(), this.d);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY);
            n1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                wu6.m().J(this, wu6.g(), wu6.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest() && rg5.r()) {
                wu6.m().K(this, cv6.e().d("frs_feed"), wu6.b("frs", "1"), "", rg5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            lq8 lq8Var2 = this.e;
            if (lq8Var2 != null && lq8Var2.f() != null) {
                this.e.f().c();
            }
            gh.a().postDelayed(new e(this), 1000L);
            int l2 = ox4.k().l("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(qm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new pm("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
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
            registerListener(new xq8(this, this.d));
            registerListener(new tr8(this, this.d));
            registerListener(new gr8(this, this.d));
            registerListener(new rr8(this, this.d));
            registerListener(new yr8(this, this.d));
            registerListener(new br8(this, this.d));
            registerListener(new mr8(this, this.d));
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
            registerListener(new wr8(this, this.d));
            registerListener(new cs8(this, this.d));
            registerListener(new or8(this, this.d));
            registerListener(new ar8(this));
            registerListener(new fr8(this, this.d));
            registerListener(new gs8(this, this.d));
            registerListener(new fs8(this));
            registerListener(new dr8(this, this.d));
            registerListener(new ur8(this, this.d));
            registerListener(new pr8(this, this.d));
            registerListener(new xr8(this, this.d));
            registerListener(new kr8(this, this.d));
            registerListener(new er8(this, this.d));
            registerListener(new sr8(this, this.d));
            registerListener(new cr8(this, this.d));
            registerListener(new es8(this, this.d));
            registerListener(new vr8(this, this.d));
            registerListener(new bs8(this, this.d));
            registerListener(new as8(this));
            registerListener(new lr8(this));
            registerListener(new yq8(this, this.d));
            registerListener(new hr8(this, this.d));
            registerListener(new jr8(this, this.d));
            registerListener(new ir8(this));
            registerListener(new zq8(this));
        }
    }

    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.P = z;
        }
    }

    public final boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (isTaskRoot() && PermissionUtil.isAgreePrivacyPolicy() && !f1()) ? false : true : invokeV.booleanValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && r95.d().b()) {
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

    public void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(dh.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
                this.g = new uq8(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i2) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            xp8 xp8Var = this.d;
            if (xp8Var != null) {
                xp8Var.F(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            u19 u19Var = this.q;
            if (u19Var != null) {
                u19Var.s(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, configuration) == null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (k1()) {
            return;
        }
        eq8 eq8Var = this.S;
        if (eq8Var != null) {
            eq8Var.d(configuration);
        }
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            getLifecycle().addObserver(this.T);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            sd5.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                this.O = lx4.q().i(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
                if (f1()) {
                    return;
                }
                if (!isTaskRoot()) {
                    if (aq4.e()) {
                        BdLog.e("MainTabActivity没有放在task根，请排查");
                    }
                    TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", n9.g().e()));
                    finish();
                    return;
                }
                wp8.a(this, getIntent());
                if (jq4.b() != null) {
                    jq4.b().d();
                }
                c1();
                a1();
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                xp8 xp8Var = new xp8(this);
                this.d = xp8Var;
                this.e = new lq8(this, xp8Var);
                this.mHandler.post(new a(this));
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt != 1) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                sp8.b(new b(this, bundle), 0);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    this.e.a().l();
                }
                sd5.b().x(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            getLifecycle().removeObserver(this.T);
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
            i25.h0().n();
            i25.h0().p();
            i25.h0().X(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            sx4 sx4Var = this.mWaitingDialog;
            if (sx4Var != null) {
                sx4Var.h(false);
                this.mWaitingDialog = null;
            }
            R0();
            xp8 xp8Var = this.d;
            if (xp8Var != null) {
                xp8Var.G();
            }
            vp8 vp8Var = this.w;
            if (vp8Var != null) {
                vp8Var.i();
            }
            lq8 lq8Var = this.e;
            if (lq8Var != null && lq8Var.j() != null) {
                this.e.j().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            jx4.h(null);
            y75.h().l();
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onDestory(getPageContext());
            }
            u19 u19Var = this.q;
            if (u19Var != null) {
                u19Var.u();
            }
            un5 un5Var = this.t;
            if (un5Var != null) {
                un5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.u;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            yt8 yt8Var = this.y;
            if (yt8Var != null) {
                yt8Var.f();
            }
            xp8 xp8Var2 = this.d;
            if (xp8Var2 != null && xp8Var2.A() != null) {
                this.d.A().t();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                wu6.m().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                wu6.m().c(wu6.s());
            }
            if (this.G != null) {
                getLifecycle().removeObserver(this.G);
            }
            uf7.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof rm) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            lq8 lq8Var2 = this.e;
            if (lq8Var2 != null && lq8Var2.d() != null) {
                this.e.d().c();
            }
            lq8 lq8Var3 = this.e;
            if (lq8Var3 != null && lq8Var3.h() != null) {
                this.e.h().c();
            }
            lq8 lq8Var4 = this.e;
            if (lq8Var4 != null && lq8Var4.g() != null) {
                this.e.g().b();
            }
            if7.m(this).B();
            System.gc();
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (xp8Var = this.d) == null) {
            return;
        }
        xp8Var.I(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        xp8 xp8Var;
        xp8 xp8Var2;
        FragmentTabHost.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            super.onNewIntent(intent);
            if (k1() || Z0(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            bq8 bq8Var = this.D;
            if (bq8Var != null && bq8Var.b(intent)) {
                this.D.a(intent, this.d);
            } else {
                lq8 lq8Var = this.e;
                if (lq8Var != null && lq8Var.f() != null) {
                    this.e.f().b(intent);
                }
            }
            if (StringUtils.isNull(stringExtra)) {
                b85.d().h();
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
                } else if (intExtra == 1 || intExtra == 20 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15 || intExtra == 22) {
                    if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                        if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                            intExtra = 2;
                        } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                            intExtra = this.o.a();
                        }
                    }
                    xp8 xp8Var3 = this.d;
                    if (xp8Var3 != null && xp8Var3.B() != null) {
                        this.d.M(intExtra);
                    }
                } else if ((intExtra == 17 || intExtra == 18) && (xp8Var = this.d) != null && xp8Var.B() != null) {
                    this.d.B().setCurrentTab(0);
                }
                xp8 xp8Var4 = this.d;
                if (xp8Var4 != null && xp8Var4.B() != null && (g2 = this.d.B().g(intExtra)) != null) {
                    Fragment fragment = g2.c;
                    if (fragment instanceof cq4) {
                        ((cq4) fragment).c1(intent);
                    }
                }
                if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (xp8Var2 = this.d) != null && xp8Var2.B() != null) {
                    this.d.M(2);
                }
                U0(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            }
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
            eq8 eq8Var = this.S;
            if (eq8Var != null) {
                eq8Var.e();
            }
            this.E = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010061, R.anim.obfuscated_res_0x7f01008b);
            }
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onPause(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            vp8 vp8Var = this.w;
            if (vp8Var != null) {
                vp8Var.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            y75.h().i(true);
            lq8 lq8Var = this.e;
            if (lq8Var != null && lq8Var.a() != null) {
                this.e.a().c();
            }
            lq8 lq8Var2 = this.e;
            if (lq8Var2 != null && lq8Var2.d() != null) {
                this.e.d().c();
            }
            xp8 xp8Var = this.d;
            if (xp8Var != null) {
                xp8Var.L();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.v9
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, hoVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(hoVar);
                PreLoadImageHelper.load(hoVar, getUniqueId());
                PreLoadVideoHelper.load(hoVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        lq8 lq8Var;
        xp8 xp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (k1()) {
                return;
            }
            eq8 eq8Var = this.S;
            if (eq8Var != null) {
                eq8Var.f();
            }
            this.E = true;
            int i2 = this.J;
            if (i2 <= 1) {
                this.J = i2 + 1;
            }
            int i3 = this.K;
            if (i3 <= 1) {
                this.K = i3 + 1;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && this.J > 1 && TbSingleton.getInstance().mIsSplashClick) {
                gh.a().postDelayed(new g(this), 500L);
                lq8 lq8Var2 = this.e;
                if (lq8Var2 != null && lq8Var2.b() != null) {
                    this.e.b().b();
                }
                TbSingleton.getInstance().mIsSplashClick = false;
                this.J = 2;
            }
            lq8 lq8Var3 = this.e;
            if (lq8Var3 != null && lq8Var3.a() != null) {
                j1(true);
                this.e.a().m();
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (this.z) {
                pi5.f(this.A);
                this.z = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (xp8Var = this.d) != null && xp8Var.A() != null) {
                this.d.A().setLottieView(true);
            }
            xp8 xp8Var2 = this.d;
            if (xp8Var2 != null && xp8Var2.B() != null) {
                this.b = this.d.B().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            y75.h().i(true);
            if (TbadkCoreApplication.isLogin() && sd5.b().e()) {
                sd5.b().f();
            }
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onResume(getPageContext());
            }
            xp8 xp8Var3 = this.d;
            if (xp8Var3 != null) {
                xp8Var3.J();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            sd5.b().f();
            if (fm4.f().b() != null && fm4.f().h() != null && fm4.f().b().getCurTaskType() == 6) {
                fm4.f().h().a();
            }
            lq8 lq8Var4 = this.e;
            if (lq8Var4 != null && lq8Var4.a() != null) {
                this.e.a().k();
                if (this.C.intValue() != 1) {
                    this.e.a().k();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (lq8Var = this.e) != null && lq8Var.d() != null) {
                this.e.d().d();
            }
            l1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                a55.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                ox4.k().u("key_post_thread_has_request_location", false);
                ox4.k().u("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
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
            xp8 xp8Var = this.d;
            if (xp8Var != null && xp8Var.B() != null) {
                bundle.putInt("locate_type", this.d.B().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.i.a.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            super.onScreenShot(str);
            xp8 xp8Var = this.d;
            if (xp8Var == null || xp8Var.B() == null || this.d.B().getCurrentTabType() != 2) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (f1()) {
                return;
            }
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
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
            VoiceManager t0 = t0();
            this.k = t0;
            if (t0 != null) {
                t0.onStop(getPageContext());
            }
            j1(false);
            this.z = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.onUserChanged(z);
            this.n = true;
            if (z) {
                b85.d().h();
                S0();
                n1();
            }
            this.d.D();
            b1();
            ox4.k().u("key_member_auto_ban_renewal_show", false);
        }
    }

    @Override // com.baidu.tieba.qp8
    @NonNull
    public qp8.a q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.e.a().h() : (qp8.a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            xp8 xp8Var = this.d;
            if (xp8Var == null) {
                return true;
            }
            return xp8Var.O();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return pi5.a(1);
        }
        return invokeV.booleanValue;
    }
}
