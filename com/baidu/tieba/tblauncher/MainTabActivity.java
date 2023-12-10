package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
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
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.pyramid.runtime.service.ServiceManager;
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
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.MaintabAddResponedData;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.a1b;
import com.baidu.tieba.a2b;
import com.baidu.tieba.ax9;
import com.baidu.tieba.aza;
import com.baidu.tieba.b1b;
import com.baidu.tieba.bi5;
import com.baidu.tieba.br6;
import com.baidu.tieba.c1b;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cza;
import com.baidu.tieba.d1b;
import com.baidu.tieba.dh;
import com.baidu.tieba.dp4;
import com.baidu.tieba.dza;
import com.baidu.tieba.e05;
import com.baidu.tieba.e1b;
import com.baidu.tieba.eh;
import com.baidu.tieba.eza;
import com.baidu.tieba.f06;
import com.baidu.tieba.f16;
import com.baidu.tieba.f1b;
import com.baidu.tieba.fh;
import com.baidu.tieba.fza;
import com.baidu.tieba.g0b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.ga5;
import com.baidu.tieba.gg;
import com.baidu.tieba.h0b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.j1b;
import com.baidu.tieba.jv4;
import com.baidu.tieba.jza;
import com.baidu.tieba.k0b;
import com.baidu.tieba.k1b;
import com.baidu.tieba.kza;
import com.baidu.tieba.l1b;
import com.baidu.tieba.le0;
import com.baidu.tieba.le9;
import com.baidu.tieba.m0b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.me0;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mr4;
import com.baidu.tieba.n0b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.nu5;
import com.baidu.tieba.nza;
import com.baidu.tieba.o0b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.p0b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.pb;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.po4;
import com.baidu.tieba.pr6;
import com.baidu.tieba.q0b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.q88;
import com.baidu.tieba.r0b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.ru5;
import com.baidu.tieba.s0b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.s4b;
import com.baidu.tieba.sdb;
import com.baidu.tieba.sta;
import com.baidu.tieba.t0b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.td5;
import com.baidu.tieba.ti;
import com.baidu.tieba.tza;
import com.baidu.tieba.u0b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u4b;
import com.baidu.tieba.v0b;
import com.baidu.tieba.v1b;
import com.baidu.tieba.v45;
import com.baidu.tieba.vp5;
import com.baidu.tieba.w0b;
import com.baidu.tieba.w1b;
import com.baidu.tieba.w88;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.ws5;
import com.baidu.tieba.x0b;
import com.baidu.tieba.x1b;
import com.baidu.tieba.xk6;
import com.baidu.tieba.xoa;
import com.baidu.tieba.xya;
import com.baidu.tieba.y0b;
import com.baidu.tieba.ye9;
import com.baidu.tieba.yya;
import com.baidu.tieba.z0b;
import com.baidu.tieba.zh5;
import com.baidu.tieba.zw9;
import com.baidu.tieba.zx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class MainTabActivity extends BaseFragmentActivity implements xya, VoiceManager.j, VoiceManager.i, UserIconBox.c, le0, FrsCommonImageLayout.e, IVideoNeedPreload, k0b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean W;
    public transient /* synthetic */ FieldHolder $fh;
    public jza A;
    public boolean B;
    public boolean C;
    @Nullable
    public TiePlusEventController D;
    public sta E;
    public boolean F;
    public int G;
    public int H;
    public long I;
    public boolean J;
    public boolean K;
    public int L;
    public final me0 M;
    public boolean N;
    @NonNull
    public final PriorityOrganizer O;
    public x1b P;
    public ax9 Q;
    public final ComponentCallbacks R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1158T;
    public CheckRealNameModel.b U;
    public String V;
    public boolean a;
    public int b;
    public boolean c;
    public fza d;
    public tza e;
    public h0b f;
    public g0b g;
    public m h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public VoiceManager l;
    public pb<TbImageView> m;
    public pb<TbImageView> n;
    public boolean o;
    public f06 p;
    public ViewGroup q;
    public sdb r;
    public CheckRealNameModel s;
    public String t;
    public f16 u;
    public ShareSuccessReplyToServerModel v;
    public dza w;
    public s4b x;
    public int y;
    public Integer z;

    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
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
                    gg.b();
                }
            }
        }

        public l(MainTabActivity mainTabActivity) {
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
                pr6.a(new a(this), "fetchBundleInfo", 3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements CheckRealNameModel.b {
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

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) && CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                this.a.d.S(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f043e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public b(MainTabActivity mainTabActivity) {
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
            tza tzaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tzaVar = this.a.e) != null && tzaVar.b() != null) {
                this.a.e.b().a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean canStat(PageStayDurationItem pageStayDurationItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pageStayDurationItem)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return PageStayDurationStat.getInstance().getMaxCostFromServer();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ComponentCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) && SharedPrefHelper.getInstance().getBoolean("key_is_follow_system_mode", false)) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MainTabActivity mainTabActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r0 != 21) goto L15;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                int intValue = num.intValue();
                boolean z = false;
                if (intValue != 1 && intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 8) {
                        }
                    } else {
                        TbSingleton.getInstance().setChatTabPage(true);
                    }
                    if (this.a.Q != null) {
                        return;
                    }
                    ax9 ax9Var = this.a.Q;
                    if (num.intValue() == 2) {
                        z = true;
                    }
                    ax9Var.b(z);
                    return;
                }
                TbSingleton.getInstance().setChatTabPage(false);
                this.a.H1(true);
                if (this.a.Q != null) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ MainTabActivity b;

        public g(MainTabActivity mainTabActivity, Bundle bundle) {
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
                this.b.E1(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

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
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ MainTabActivity b;

        public i(MainTabActivity mainTabActivity, Bundle bundle) {
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
                this.b.E1(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public j(MainTabActivity mainTabActivity) {
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

        @Override // com.baidu.tieba.nu5
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

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        public k(MainTabActivity mainTabActivity) {
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
                mr4.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity this$0;

        public m(MainTabActivity mainTabActivity) {
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

        public /* synthetic */ m(MainTabActivity mainTabActivity, d dVar) {
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
        this.o = false;
        this.t = "";
        this.z = -1;
        this.B = false;
        this.C = false;
        this.I = 0L;
        this.M = new me0();
        this.O = PriorityOrganizer.create();
        this.Q = null;
        this.R = new d(this);
        this.S = false;
        this.f1158T = new e(this, 2001384);
        this.U = new a(this);
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately() || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        profileRequestMessage.set_uid(Long.valueOf(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
        profileRequestMessage.setNeedUsergrowthTask(1);
        profileRequestMessage.setHistoryForumIds(zx6.o().l());
        profileRequestMessage.setHistoryForumNames(zx6.o().m());
        sendMessage(profileRequestMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i2, keyEvent)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, configuration) != null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (J1()) {
            return;
        }
        kza.a().b(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        fza fzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (fzaVar = this.d) != null) {
            fzaVar.H(z);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (Throwable th) {
                BdLog.e(th, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            super.onUserChanged(z);
            this.o = true;
            if (z) {
                bi5.d().h();
                s1();
                P1();
            }
            A1();
            SharedPrefHelper.getInstance().putBoolean("key_member_auto_ban_renewal_show", false);
        }
    }

    public final boolean y1(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new MaintabAddResponedData(getPageContext().getPageActivity())));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            fza fzaVar = this.d;
            if (fzaVar != null && fzaVar.A() != null) {
                Fragment currentFragment = this.d.A().getCurrentFragment();
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
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (D1()) {
                return;
            }
            this.k = d1();
            this.l = M0();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onStop();
            if (J1()) {
                return;
            }
            VoiceManager d1 = d1();
            this.k = d1;
            if (d1 != null) {
                d1.onStop(getPageContext());
            }
            VoiceManager M0 = M0();
            this.l = M0;
            if (M0 != null) {
                M0.onStop(getPageContext());
            }
            I1(false);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0632);
            this.q = (ViewGroup) findViewById(16908290);
        }
    }

    public final boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.L == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isTaskRoot() && ((PermissionUtil.isAgreePrivacyPolicy() || PermissionUtil.isBrowseMode()) && !D1())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.le0
    @NonNull
    public me0 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.M;
        }
        return (me0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.l == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.l = voiceManager;
                voiceManager.setIsUseMediaPlayer(true);
                this.l.onCreate(getPageContext());
            }
            return this.l;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m mVar = this.h;
            if (mVar != null) {
                unregisterReceiver(mVar);
            }
            PackageChangedReceiver packageChangedReceiver = this.i;
            if (packageChangedReceiver != null) {
                unregisterReceiver(packageChangedReceiver);
            }
        }
    }

    @Override // com.baidu.tieba.xya
    @NonNull
    public PriorityOrganizer a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.O;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.m == null) {
                this.m = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.m;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (J1()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.q;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
            if (this.o && currentPageSourceKeyList != null) {
                currentPageSourceKeyList.clear();
                this.o = false;
                return null;
            }
            return currentPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xya
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            fza fzaVar = this.d;
            if (fzaVar != null && fzaVar.A() != null) {
                return this.d.A().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return new c(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            fza fzaVar = this.d;
            if (fzaVar == null) {
                return true;
            }
            return fzaVar.P();
        }
        return invokeV.booleanValue;
    }

    public final void u1() {
        xk6 xk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (xk6Var = (xk6) ServiceManager.getService(xk6.a)) != null) {
            xk6Var.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return VideoAudioHelper.checkNeedAutoPlay(1);
        }
        return invokeV.booleanValue;
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k0b
    /* renamed from: x1 */
    public x1b N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.P;
        }
        return (x1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public pb<TbImageView> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.n == null) {
                this.n = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.n;
        }
        return (pb) invokeV.objValue;
    }

    public final void E1(Bundle bundle) {
        int i2;
        boolean z;
        tza tzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                ru5.b(new j(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.D == null) {
                this.D = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.D);
            if (y1(getIntent())) {
                return;
            }
            MainEntrance.ENTER_BAR_DEFAULT_INDEX = MainEntrance.ENTER_BAR_DEFAULT_INDEX_MY_BAR;
            if (getIntent() != null) {
                jza jzaVar = new jza(getPageContext());
                this.A = jzaVar;
                if (!jzaVar.b(getIntent()) && (tzaVar = this.e) != null && tzaVar.e() != null) {
                    this.e.e().b(getIntent());
                }
                if (getIntent().getIntExtra(MainEntrance.GOTO_TYPE, 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            yya yyaVar = new yya();
            MainEntrance.setMainTabInst(yyaVar);
            yyaVar.g(this);
            if (w1()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.w = new dza(this);
            this.d.J(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            G1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            nza.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            po4.w().q();
            this.p = new f06();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            A1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new c1b(this, this.d));
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra(MainEntrance.GOTO_TYPE, bundle.getInt(MainEntrance.GOTO_TYPE, 1));
            }
            this.V = UtilHelper.getCurrentDay();
            this.j = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
            if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().registerStickyMode(2001404);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
            v1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            registerListener(new f1b(this, this.d));
            this.k = d1();
            this.l = M0();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            registerListener(new m0b(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                vp5.a().e();
            }
            if (TbadkCoreApplication.isLogin()) {
                bi5.d().h();
            }
            int i3 = SharedPrefHelper.getInstance().getInt("app_restart_times", 0);
            SharedPrefHelper.getInstance().putInt("app_restart_times", ((i3 > 100 || i3 < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.s = checkRealNameModel;
            checkRealNameModel.S(this.U);
            s1();
            this.u = new f16(getPageContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            this.v = new ShareSuccessReplyToServerModel();
            new u4b(getPageContext());
            BdTokenController.E();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            StatisticItem param = new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (skinType == 4) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param.param("obj_type", i2));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                SafeHandler.getInst().postDelayed(new k(this), 5000L);
            }
            registerListener(new t1b(this, this.d));
            TbSingleton.getInstance().startOneGame();
            t1();
            jza jzaVar2 = this.A;
            if (jzaVar2 != null && jzaVar2.b(intent)) {
                this.A.a(getIntent(), this.d);
            }
            zx6.o().C(true);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                q88.m().I(this, q88.g(), q88.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && ws5.r()) {
                q88.m().J(this, w88.e().d("frs_feed"), q88.b("frs", "1"), "", ws5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().startLoad();
            TbSingleton.getInstance().setActiveTimeStamp();
            tza tzaVar2 = this.e;
            if (tzaVar2 != null && tzaVar2.e() != null) {
                this.e.e().c();
            }
            SafeHandler.getInst().postDelayed(new l(this), 1000L);
            int i4 = SharedPrefHelper.getInstance().getInt("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(eh.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new dh("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((i4 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(i4 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(new n0b(this, this.d));
            registerListener(new i1b(this, this.d));
            registerListener(new w0b(this, this.d));
            registerListener(new g1b(this, this.d));
            registerListener(new n1b(this, this.d));
            registerListener(new r0b(this, this.d));
            this.h = new m(this, null);
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
            registerListener(new m1b(this, this.d));
            registerListener(new s1b(this, this.d));
            registerListener(new d1b(this, this.d));
            registerListener(new q0b(this));
            registerListener(new v0b(this, this.d));
            registerListener(new w1b(this, this.d));
            registerListener(new v1b(this));
            registerListener(new t0b(this, this.d));
            registerListener(new k1b(this, this.d));
            registerListener(new e1b(this, this.d));
            registerListener(new z0b(this, this.d));
            registerListener(new u0b(this, this.d));
            registerListener(new h1b(this, this.d));
            registerListener(new s0b(this, this.d));
            registerListener(new u1b(this, this.d));
            registerListener(new l1b(this, this.d));
            registerListener(new q1b(this, this.d));
            registerListener(new p1b(this));
            registerListener(new b1b(this));
            registerListener(new o0b(this, this.d));
            registerListener(new x0b(this, this.d));
            registerListener(new y0b(this));
            registerListener(new p0b(this));
            registerListener(new a1b(this));
            registerListener(new r1b(this));
            registerListener(this.f1158T);
            registerListener(new j1b(this));
            if (this.Q == null) {
                this.Q = new ax9(zw9.class);
                br6.b().b(this, this.Q);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TbadkCoreApplication.getInst().setMainActivity(null);
            WriteWebViewCacheManager.g().d();
            unregisterComponentCallbacks(this.R);
            getLifecycle().removeObserver(this.O);
            if (J1()) {
                try {
                    super.onDestroy();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
            O1();
            ga5.p0().n();
            ga5.p0().p();
            ga5.p0().b0(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            BlueCircleProgressDialog blueCircleProgressDialog = this.mWaitingDialog;
            if (blueCircleProgressDialog != null) {
                blueCircleProgressDialog.setDialogVisiable(false);
                this.mWaitingDialog = null;
            }
            r1();
            fza fzaVar = this.d;
            if (fzaVar != null) {
                fzaVar.F();
            }
            dza dzaVar = this.w;
            if (dzaVar != null) {
                dzaVar.i();
            }
            tza tzaVar = this.e;
            if (tzaVar != null && tzaVar.i() != null) {
                this.e.i().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            MainEntrance.setMainTabInst(null);
            zh5.h().l();
            VoiceManager d1 = d1();
            this.k = d1;
            if (d1 != null) {
                d1.onDestory(getPageContext());
            }
            VoiceManager M0 = M0();
            this.l = M0;
            if (M0 != null) {
                M0.onDestory(getPageContext());
            }
            sdb sdbVar = this.r;
            if (sdbVar != null) {
                sdbVar.e();
            }
            f16 f16Var = this.u;
            if (f16Var != null) {
                f16Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            s4b s4bVar = this.x;
            if (s4bVar != null) {
                s4bVar.f();
            }
            fza fzaVar2 = this.d;
            if (fzaVar2 != null && fzaVar2.y() != null) {
                this.d.y().m();
            }
            q88.m().c(q88.s());
            if (this.D != null) {
                getLifecycle().removeObserver(this.D);
            }
            ye9.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof fh) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            tza tzaVar2 = this.e;
            if (tzaVar2 != null && tzaVar2.c() != null) {
                this.e.c().c();
            }
            tza tzaVar3 = this.e;
            if (tzaVar3 != null && tzaVar3.g() != null) {
                this.e.g().c();
            }
            tza tzaVar4 = this.e;
            if (tzaVar4 != null && tzaVar4.f() != null) {
                this.e.f().b();
            }
            tza tzaVar5 = this.e;
            if (tzaVar5 != null && tzaVar5.k() != null) {
                this.e.k().d();
            }
            le9.n(this).A();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        tza tzaVar;
        fza fzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (J1()) {
                return;
            }
            kza.a().d();
            this.B = true;
            int i2 = this.G;
            if (i2 <= 1) {
                this.G = i2 + 1;
            }
            int i3 = this.H;
            if (i3 <= 1) {
                this.H = i3 + 1;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && this.G > 1 && TbSingleton.getInstance().mIsSplashClick) {
                SafeHandler.getInst().postDelayed(new b(this), 500L);
                TbSingleton.getInstance().mIsSplashClick = false;
                this.G = 2;
            }
            tza tzaVar2 = this.e;
            if (tzaVar2 != null && tzaVar2.a() != null) {
                I1(true);
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (fzaVar = this.d) != null && fzaVar.y() != null) {
                this.d.y().setLottieView(true);
            }
            fza fzaVar2 = this.d;
            if (fzaVar2 != null && fzaVar2.A() != null) {
                this.b = this.d.A().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            zh5.h().i(true);
            if (TbadkCoreApplication.isLogin() && vp5.a().d()) {
                vp5.a().e();
            }
            VoiceManager d1 = d1();
            this.k = d1;
            if (d1 != null) {
                d1.onResume(getPageContext());
            }
            VoiceManager M0 = M0();
            this.l = M0;
            if (M0 != null) {
                M0.onResume(getPageContext());
            }
            fza fzaVar3 = this.d;
            if (fzaVar3 != null) {
                fzaVar3.I();
            }
            vp5.a().e();
            if (dp4.f().b() != null && dp4.f().h() != null && dp4.f().b().getCurTaskType() == 6) {
                dp4.f().h().a();
            }
            tza tzaVar3 = this.e;
            if (tzaVar3 != null && tzaVar3.a() != null) {
                this.e.a().f();
                if (this.z.intValue() != 1) {
                    this.e.a().f();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (tzaVar = this.e) != null && tzaVar.c() != null) {
                this.e.c().d();
            }
            M1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                td5.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                SharedPrefHelper.getInstance().putBoolean("key_post_thread_has_request_location", false);
                SharedPrefHelper.getInstance().putBoolean("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    public final void H1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                if (!this.S) {
                    this.S = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
                    return;
                }
                return;
            }
            this.S = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.FALSE));
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.f == null) {
                    this.f = new h0b(this, this.d);
                }
                return this.f.f(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() && !PermissionUtil.isBrowseMode()) {
                return;
            }
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            fza fzaVar = this.d;
            if (fzaVar != null) {
                fzaVar.E(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            sdb sdbVar = this.r;
            if (sdbVar != null) {
                sdbVar.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.z4
    public void onPreLoad(ti tiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, tiVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(tiVar);
                PreLoadImageHelper.load(tiVar, getUniqueId());
                PreLoadVideoHelper.load(tiVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            super.onScreenShot(str);
            fza fzaVar = this.d;
            if (fzaVar != null && fzaVar.A() != null && this.d.A().getCurrentTabType() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
            }
        }
    }

    public final void K1(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("page", "applet/swanApp");
            jSONObject2.put(YunDialogManager.PAGE_PARAMS_KEY, jSONObject);
            hashMap.put("params", jSONObject2.toString());
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{UrlUtils.appendParams("tiebaapp://router/portal", hashMap)});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int currentTabType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (!this.N) {
                return false;
            }
            fza fzaVar = this.d;
            if (fzaVar != null && fzaVar.A() != null && this.d.A().getCurrentTabType() == 1 && motionEvent.getPointerCount() > 1 && this.d.C()) {
                return true;
            }
            fza fzaVar2 = this.d;
            if (fzaVar2 != null && fzaVar2.A() != null && ((currentTabType = this.d.A().getCurrentTabType()) == 2 || currentTabType == 22)) {
                this.M.a(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i2, i3, intent) == null) {
            if (J1()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.g == null) {
                this.g = new g0b(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            getLifecycle().addObserver(this.O);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            xoa.b("main");
            vp5.a().v(System.currentTimeMillis());
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (PermissionUtil.isBrowseMode()) {
                B1();
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                fza fzaVar = new fza(this);
                this.d = fzaVar;
                this.P = new x1b(this, fzaVar);
                this.e = new tza(this, this.d);
                this.mHandler.post(new f(this));
                aza.b(new g(this, bundle), 0);
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                TbadkCoreApplication.getInst().setMainActivity(this);
                this.L = v45.q().i(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
                if (D1()) {
                    return;
                }
                if (!isTaskRoot()) {
                    if (GlobalBuildConfig.isDebug()) {
                        BdLog.e("MainTabActivity没有放在task根，请排查");
                    }
                    TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", BdActivityStack.getInst().getAllActivityName()));
                    finish();
                    return;
                }
                eza.a(this, getIntent());
                if (AccountLoginCoreHelper.getInstance() != null) {
                    AccountLoginCoreHelper.getInstance().reLoginByCacheAccount();
                }
                if (!a2b.b().f()) {
                    u1();
                }
                B1();
                z1();
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                fza fzaVar2 = new fza(this);
                this.d = fzaVar2;
                this.P = new x1b(this, fzaVar2);
                this.e = new tza(this, this.d);
                this.mHandler.post(new h(this));
                registerComponentCallbacks(this.R);
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt == 1) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(4);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
                } else if (SharedPrefHelper.getInstance().getBoolean("key_is_follow_system_mode", false)) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                aza.b(new i(this, bundle), 0);
                a2b.b().l(false);
                vp5.a().w(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        fza fzaVar;
        fza fzaVar2;
        FragmentTabHost.c h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, intent) == null) {
            super.onNewIntent(intent);
            if (J1() || y1(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            jza jzaVar = this.A;
            if (jzaVar != null && jzaVar.b(intent)) {
                this.A.a(intent, this.d);
            } else {
                tza tzaVar = this.e;
                if (tzaVar != null && tzaVar.e() != null) {
                    this.e.e().b(intent);
                }
            }
            if (!StringUtils.isNull(stringExtra)) {
                return;
            }
            bi5.d().h();
            if (intent.getBooleanExtra("refresh_all", false)) {
                a2b.b().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                A1();
            }
            intent.getStringExtra("from");
            int intExtra = intent.getIntExtra(MainEntrance.GOTO_TYPE, 0);
            boolean booleanExtra = intent.getBooleanExtra(MainEntrance.KEY_IS_FROM_SCHEME, false);
            if (intExtra == 200) {
                finish();
            } else if (intExtra == 11) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
                finish();
            } else if (intExtra == 12) {
                TbadkCoreApplication.getInst().notifyAppEnterBackground();
                finish();
            } else if (intExtra != 1 && intExtra != 20 && intExtra != 3 && intExtra != 2 && intExtra != 4 && intExtra != 8 && intExtra != 15 && intExtra != 22) {
                if ((intExtra == 17 || intExtra == 18) && (fzaVar = this.d) != null && fzaVar.A() != null) {
                    this.d.A().setCurrentTab(0);
                }
            } else {
                if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                    if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        intExtra = 2;
                    } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                        intExtra = this.p.a();
                    }
                }
                fza fzaVar3 = this.d;
                if (fzaVar3 != null && fzaVar3.A() != null) {
                    this.d.M(intExtra);
                }
            }
            fza fzaVar4 = this.d;
            if (fzaVar4 != null && fzaVar4.A() != null && (h2 = this.d.A().h(intExtra)) != null) {
                Fragment fragment = h2.c;
                if (fragment instanceof jv4) {
                    ((jv4) fragment).o2(intent);
                }
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (fzaVar2 = this.d) != null && fzaVar2.A() != null) {
                this.d.M(2);
            }
            v1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i2, keyEvent)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onPause();
            if (J1()) {
                return;
            }
            kza.a().c();
            this.B = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010075, R.anim.obfuscated_res_0x7f0100a9);
            }
            VoiceManager d1 = d1();
            this.k = d1;
            if (d1 != null) {
                d1.onPause();
            }
            VoiceManager M0 = M0();
            this.l = M0;
            if (M0 != null) {
                M0.onPause();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            dza dzaVar = this.w;
            if (dzaVar != null) {
                dzaVar.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            zh5.h().i(true);
            tza tzaVar = this.e;
            if (tzaVar != null && tzaVar.a() != null) {
                this.e.a().a();
            }
            tza tzaVar2 = this.e;
            if (tzaVar2 != null && tzaVar2.c() != null) {
                this.e.c().c();
            }
            fza fzaVar = this.d;
            if (fzaVar != null) {
                fzaVar.L();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (J1()) {
                return;
            }
            fza fzaVar = this.d;
            if (fzaVar != null && fzaVar.A() != null) {
                bundle.putInt(MainEntrance.GOTO_TYPE, this.d.A().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.proxy.c.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager d1 = d1();
            this.k = d1;
            if (d1 != null) {
                d1.onSaveInstanceState(getPageContext().getPageActivity());
            }
            VoiceManager M0 = M0();
            this.l = M0;
            if (M0 != null) {
                M0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void r1() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048623, this) != null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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

    public void s1() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (SharedPrefHelper.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && BdUtilHelper.isNetOk() && (checkRealNameModel = this.s) != null) {
                checkRealNameModel.P(CheckRealNameModel.TYPE_APP_FIRST_START);
                SharedPrefHelper.getInstance().putBoolean(str, false);
            }
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            String str = SharedPrefHelper.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (!SharedPrefHelper.getInstance().getBoolean(str, false)) {
                e05.k();
                try {
                    e05.j("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                    SharedPrefHelper.getInstance().putBoolean(str, true);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            DefaultLog.getInstance().i("MainTabActivity", "开屏广告：initSplash, 初始化开屏广告");
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = cza.a(getIntent());
            registerListener(new o1b(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                aza.a(MainTabScheduleStrategy.SCHEDULE);
                kza.a().e(this);
            } else if (!TbSingleton.getInstance().getIsPushOrSchemeLog()) {
                BaseVM.m(1);
            } else {
                TbSingleton.getInstance().setPushOrSchemeLog(false);
            }
        }
    }

    public final void v1(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                TbSingleton.getInstance().mIsSplashClick = true;
            } else if (intent != null && intent.getData() != null && (intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN_GAME))) {
                try {
                    K1(intent.getData().toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            TbadkCoreApplication.setIntent(null);
        }
    }
}
