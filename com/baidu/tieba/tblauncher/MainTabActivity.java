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
import com.baidu.tieba.ag5;
import com.baidu.tieba.aja;
import com.baidu.tieba.bha;
import com.baidu.tieba.bja;
import com.baidu.tieba.bka;
import com.baidu.tieba.bt7;
import com.baidu.tieba.cg5;
import com.baidu.tieba.ci;
import com.baidu.tieba.cja;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d95;
import com.baidu.tieba.dha;
import com.baidu.tieba.dja;
import com.baidu.tieba.eha;
import com.baidu.tieba.eja;
import com.baidu.tieba.fha;
import com.baidu.tieba.fja;
import com.baidu.tieba.gha;
import com.baidu.tieba.gja;
import com.baidu.tieba.gs5;
import com.baidu.tieba.gz4;
import com.baidu.tieba.hia;
import com.baidu.tieba.hja;
import com.baidu.tieba.iia;
import com.baidu.tieba.ija;
import com.baidu.tieba.io4;
import com.baidu.tieba.jja;
import com.baidu.tieba.kha;
import com.baidu.tieba.kja;
import com.baidu.tieba.kp6;
import com.baidu.tieba.ks5;
import com.baidu.tieba.lha;
import com.baidu.tieba.lia;
import com.baidu.tieba.lja;
import com.baidu.tieba.lx8;
import com.baidu.tieba.mg;
import com.baidu.tieba.mja;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.ng;
import com.baidu.tieba.ni6;
import com.baidu.tieba.nia;
import com.baidu.tieba.nja;
import com.baidu.tieba.nu4;
import com.baidu.tieba.oc5;
import com.baidu.tieba.og;
import com.baidu.tieba.oha;
import com.baidu.tieba.oia;
import com.baidu.tieba.oja;
import com.baidu.tieba.on5;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.pf;
import com.baidu.tieba.pia;
import com.baidu.tieba.pja;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qia;
import com.baidu.tieba.qja;
import com.baidu.tieba.ria;
import com.baidu.tieba.rja;
import com.baidu.tieba.rq4;
import com.baidu.tieba.sia;
import com.baidu.tieba.sja;
import com.baidu.tieba.t6a;
import com.baidu.tieba.tba;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.td0;
import com.baidu.tieba.tia;
import com.baidu.tieba.tja;
import com.baidu.tieba.u35;
import com.baidu.tieba.ud0;
import com.baidu.tieba.uha;
import com.baidu.tieba.uia;
import com.baidu.tieba.uja;
import com.baidu.tieba.un4;
import com.baidu.tieba.uv6;
import com.baidu.tieba.uva;
import com.baidu.tieba.via;
import com.baidu.tieba.vja;
import com.baidu.tieba.vma;
import com.baidu.tieba.vs7;
import com.baidu.tieba.wia;
import com.baidu.tieba.wja;
import com.baidu.tieba.wo6;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.xia;
import com.baidu.tieba.xja;
import com.baidu.tieba.xma;
import com.baidu.tieba.ya;
import com.baidu.tieba.yf9;
import com.baidu.tieba.yga;
import com.baidu.tieba.yia;
import com.baidu.tieba.yja;
import com.baidu.tieba.yx8;
import com.baidu.tieba.zf9;
import com.baidu.tieba.zga;
import com.baidu.tieba.zia;
import com.baidu.tieba.zx5;
import com.baidu.tieba.zy5;
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
public class MainTabActivity extends BaseFragmentActivity implements yga, VoiceManager.j, VoiceManager.i, UserIconBox.c, td0, FrsCommonImageLayout.e, IVideoNeedPreload, lia {
    public static /* synthetic */ Interceptable $ic;
    public static boolean W;
    public transient /* synthetic */ FieldHolder $fh;
    public kha A;
    public boolean B;
    public boolean C;
    @Nullable
    public TiePlusEventController D;
    public tba E;
    public boolean F;
    public int G;
    public int H;
    public long I;
    public boolean J;
    public boolean K;
    public int L;
    public final ud0 M;
    public boolean N;
    @NonNull
    public final PriorityOrganizer O;
    public yja P;
    public zf9 Q;
    public final ComponentCallbacks R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1162T;
    public CheckRealNameModel.b U;
    public String V;
    public boolean a;
    public int b;
    public boolean c;
    public gha d;
    public uha e;
    public iia f;
    public hia g;
    public m h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public VoiceManager l;
    public ya<TbImageView> m;
    public ya<TbImageView> n;
    public boolean o;
    public zx5 p;
    public ViewGroup q;
    public uva r;
    public CheckRealNameModel s;
    public String t;
    public zy5 u;
    public ShareSuccessReplyToServerModel v;
    public eha w;
    public vma x;
    public int y;
    public Integer z;

    public void O1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, voiceModel)) == null) {
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
                    pf.b();
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
                kp6.a(new a(this), "fetchBundleInfo", 3);
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
                this.a.d.S(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0435));
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
            uha uhaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (uhaVar = this.a.e) != null && uhaVar.b() != null) {
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
                    zf9 zf9Var = this.a.Q;
                    if (num.intValue() == 2) {
                        z = true;
                    }
                    zf9Var.b(z);
                    return;
                }
                TbSingleton.getInstance().setChatTabPage(false);
                this.a.N1(true);
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
                this.b.L1(this.a);
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
                this.b.L1(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends gs5<Object> {
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

        @Override // com.baidu.tieba.gs5
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
                rq4.a();
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
        this.M = new ud0();
        this.O = PriorityOrganizer.create();
        this.Q = null;
        this.R = new d(this);
        this.S = false;
        this.f1162T = new e(this, 2001384);
        this.U = new a(this);
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately() || TbadkCoreApplication.getCurrentAccount() == null) {
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
        profileRequestMessage.setHistoryForumIds(uv6.o().l());
        profileRequestMessage.setHistoryForumNames(uv6.o().m());
        sendMessage(profileRequestMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i2, keyEvent)) == null) {
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

    public final boolean G1(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, configuration) != null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (P1()) {
            return;
        }
        lha.a().b(configuration);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        gha ghaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z) == null) && (ghaVar = this.d) != null) {
            ghaVar.H(z);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            super.onUserChanged(z);
            this.o = true;
            if (z) {
                cg5.d().h();
                z1();
                T1();
            }
            I1();
            SharedPrefHelper.getInstance().putBoolean("key_member_auto_ban_renewal_show", false);
        }
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = SharedPrefHelper.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (!SharedPrefHelper.getInstance().getBoolean(str, false)) {
                gz4.k();
                try {
                    gz4.j("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                    SharedPrefHelper.getInstance().putBoolean(str, true);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            DefaultLog.getInstance().i("MainTabActivity", "开屏广告：initSplash, 初始化开屏广告");
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = dha.a(getIntent());
            registerListener(new pja(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                bha.a(MainTabScheduleStrategy.SCHEDULE);
                lha.a().e(this);
            } else if (!TbSingleton.getInstance().getIsPushOrSchemeLog()) {
                BaseVM.m(1);
            } else {
                TbSingleton.getInstance().setPushOrSchemeLog(false);
            }
        }
    }

    public final void y1() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048633, this) != null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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

    public void z1() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (SharedPrefHelper.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && BdUtilHelper.isNetOk() && (checkRealNameModel = this.s) != null) {
                checkRealNameModel.O(CheckRealNameModel.TYPE_APP_FIRST_START);
                SharedPrefHelper.getInstance().putBoolean(str, false);
            }
        }
    }

    public final void B1() {
        ni6 ni6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ni6Var = (ni6) ServiceManager.getService(ni6.a)) != null) {
            ni6Var.a();
        }
    }

    public final boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lia
    /* renamed from: F1 */
    public yja O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.P;
        }
        return (yja) invokeV.objValue;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0604);
            this.q = (ViewGroup) findViewById(16908290);
        }
    }

    public final boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.L == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.td0
    @NonNull
    public ud0 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.M;
        }
        return (ud0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (isTaskRoot() && ((PermissionUtil.isAgreePrivacyPolicy() || PermissionUtil.isBrowseMode()) && !K1())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ya<TbImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.m == null) {
                this.m = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.m;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.yga
    @NonNull
    public PriorityOrganizer e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.O;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (P1()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.q;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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

    @Override // com.baidu.tieba.yga
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            gha ghaVar = this.d;
            if (ghaVar != null && ghaVar.A() != null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new c(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ya<TbImageView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.n == null) {
                this.n = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.n;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            gha ghaVar = this.d;
            if (ghaVar == null) {
                return true;
            }
            return ghaVar.P();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return VideoAudioHelper.checkNeedAutoPlay(1);
        }
        return invokeV.booleanValue;
    }

    public final void D1(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                TbSingleton.getInstance().mIsSplashClick = true;
            } else if (intent != null && intent.getData() != null && (intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN_GAME))) {
                try {
                    Q1(intent.getData().toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            TbadkCoreApplication.setIntent(null);
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            gha ghaVar = this.d;
            if (ghaVar != null && ghaVar.A() != null) {
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
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (K1()) {
                return;
            }
            this.k = O0();
            this.l = N0();
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
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onStop();
            if (P1()) {
                return;
            }
            VoiceManager O0 = O0();
            this.k = O0;
            if (O0 != null) {
                O0.onStop(getPageContext());
            }
            VoiceManager N0 = N0();
            this.l = N0;
            if (N0 != null) {
                N0.onStop(getPageContext());
            }
            O1(false);
        }
    }

    public final void L1(Bundle bundle) {
        int i2;
        boolean z;
        uha uhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                ks5.b(new j(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.D == null) {
                this.D = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.D);
            if (G1(getIntent())) {
                return;
            }
            MainEntrance.ENTER_BAR_DEFAULT_INDEX = MainEntrance.ENTER_BAR_DEFAULT_INDEX_MY_BAR;
            if (getIntent() != null) {
                kha khaVar = new kha(getPageContext());
                this.A = khaVar;
                if (!khaVar.b(getIntent()) && (uhaVar = this.e) != null && uhaVar.e() != null) {
                    this.e.e().b(getIntent());
                }
                if (getIntent().getIntExtra(MainEntrance.GOTO_TYPE, 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            zga zgaVar = new zga();
            MainEntrance.setMainTabInst(zgaVar);
            zgaVar.g(this);
            if (E1()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.w = new eha(this);
            this.d.J(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            M1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            oha.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            un4.w().q();
            this.p = new zx5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            I1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new dja(this, this.d));
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
            D1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            registerListener(new gja(this, this.d));
            this.k = O0();
            this.l = N0();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            registerListener(new nia(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                on5.a().e();
            }
            if (TbadkCoreApplication.isLogin()) {
                cg5.d().h();
            }
            int i3 = SharedPrefHelper.getInstance().getInt("app_restart_times", 0);
            SharedPrefHelper.getInstance().putInt("app_restart_times", ((i3 > 100 || i3 < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.s = checkRealNameModel;
            checkRealNameModel.R(this.U);
            z1();
            this.u = new zy5(getPageContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            this.v = new ShareSuccessReplyToServerModel();
            new xma(getPageContext());
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
            registerListener(new uja(this, this.d));
            TbSingleton.getInstance().startOneGame();
            A1();
            kha khaVar2 = this.A;
            if (khaVar2 != null && khaVar2.b(intent)) {
                this.A.a(getIntent(), this.d);
            }
            uv6.o().B(true);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                vs7.m().I(this, vs7.g(), vs7.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && pq5.q()) {
                vs7.m().J(this, bt7.e().d("frs_feed"), vs7.b("frs", "1"), "", pq5.e());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().startLoad();
            TbSingleton.getInstance().setActiveTimeStamp();
            uha uhaVar2 = this.e;
            if (uhaVar2 != null && uhaVar2.e() != null) {
                this.e.e().c();
            }
            SafeHandler.getInst().postDelayed(new l(this), 1000L);
            int i4 = SharedPrefHelper.getInstance().getInt("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(ng.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new mg("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((i4 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(i4 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            registerListener(new oia(this, this.d));
            registerListener(new jja(this, this.d));
            registerListener(new xia(this, this.d));
            registerListener(new hja(this, this.d));
            registerListener(new oja(this, this.d));
            registerListener(new sia(this, this.d));
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
            registerListener(new nja(this, this.d));
            registerListener(new tja(this, this.d));
            registerListener(new eja(this, this.d));
            registerListener(new ria(this));
            registerListener(new wia(this, this.d));
            registerListener(new xja(this, this.d));
            registerListener(new wja(this));
            registerListener(new uia(this, this.d));
            registerListener(new lja(this, this.d));
            registerListener(new fja(this, this.d));
            registerListener(new aja(this, this.d));
            registerListener(new via(this, this.d));
            registerListener(new ija(this, this.d));
            registerListener(new tia(this, this.d));
            registerListener(new vja(this, this.d));
            registerListener(new mja(this, this.d));
            registerListener(new rja(this, this.d));
            registerListener(new qja(this));
            registerListener(new cja(this));
            registerListener(new pia(this, this.d));
            registerListener(new yia(this, this.d));
            registerListener(new zia(this));
            registerListener(new qia(this));
            registerListener(new bja(this));
            registerListener(new sja(this));
            registerListener(this.f1162T);
            registerListener(new kja(this));
            if (this.Q == null) {
                this.Q = new zf9(yf9.class);
                wo6.b().b(this, this.Q);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            TbadkCoreApplication.getInst().setMainActivity(null);
            WriteWebViewCacheManager.g().d();
            unregisterComponentCallbacks(this.R);
            getLifecycle().removeObserver(this.O);
            if (P1()) {
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
            S1();
            d95.p0().n();
            d95.p0().p();
            d95.p0().b0(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            BlueCircleProgressDialog blueCircleProgressDialog = this.mWaitingDialog;
            if (blueCircleProgressDialog != null) {
                blueCircleProgressDialog.setDialogVisiable(false);
                this.mWaitingDialog = null;
            }
            y1();
            gha ghaVar = this.d;
            if (ghaVar != null) {
                ghaVar.F();
            }
            eha ehaVar = this.w;
            if (ehaVar != null) {
                ehaVar.i();
            }
            uha uhaVar = this.e;
            if (uhaVar != null && uhaVar.i() != null) {
                this.e.i().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            MainEntrance.setMainTabInst(null);
            ag5.h().l();
            VoiceManager O0 = O0();
            this.k = O0;
            if (O0 != null) {
                O0.onDestory(getPageContext());
            }
            VoiceManager N0 = N0();
            this.l = N0;
            if (N0 != null) {
                N0.onDestory(getPageContext());
            }
            uva uvaVar = this.r;
            if (uvaVar != null) {
                uvaVar.e();
            }
            zy5 zy5Var = this.u;
            if (zy5Var != null) {
                zy5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            vma vmaVar = this.x;
            if (vmaVar != null) {
                vmaVar.f();
            }
            gha ghaVar2 = this.d;
            if (ghaVar2 != null && ghaVar2.y() != null) {
                this.d.y().m();
            }
            vs7.m().c(vs7.s());
            if (this.D != null) {
                getLifecycle().removeObserver(this.D);
            }
            yx8.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof og) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            uha uhaVar2 = this.e;
            if (uhaVar2 != null && uhaVar2.c() != null) {
                this.e.c().c();
            }
            uha uhaVar3 = this.e;
            if (uhaVar3 != null && uhaVar3.g() != null) {
                this.e.g().c();
            }
            uha uhaVar4 = this.e;
            if (uhaVar4 != null && uhaVar4.f() != null) {
                this.e.f().b();
            }
            uha uhaVar5 = this.e;
            if (uhaVar5 != null && uhaVar5.k() != null) {
                this.e.k().d();
            }
            lx8.n(this).A();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        uha uhaVar;
        gha ghaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (P1()) {
                return;
            }
            lha.a().d();
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
            uha uhaVar2 = this.e;
            if (uhaVar2 != null && uhaVar2.a() != null) {
                O1(true);
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (ghaVar = this.d) != null && ghaVar.y() != null) {
                this.d.y().setLottieView(true);
            }
            gha ghaVar2 = this.d;
            if (ghaVar2 != null && ghaVar2.A() != null) {
                this.b = this.d.A().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            ag5.h().i(true);
            if (TbadkCoreApplication.isLogin() && on5.a().d()) {
                on5.a().e();
            }
            VoiceManager O0 = O0();
            this.k = O0;
            if (O0 != null) {
                O0.onResume(getPageContext());
            }
            VoiceManager N0 = N0();
            this.l = N0;
            if (N0 != null) {
                N0.onResume(getPageContext());
            }
            gha ghaVar3 = this.d;
            if (ghaVar3 != null) {
                ghaVar3.I();
            }
            on5.a().e();
            if (io4.f().b() != null && io4.f().h() != null && io4.f().b().getCurTaskType() == 6) {
                io4.f().h().a();
            }
            uha uhaVar3 = this.e;
            if (uhaVar3 != null && uhaVar3.a() != null) {
                this.e.a().f();
                if (this.z.intValue() != 1) {
                    this.e.a().f();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (uhaVar = this.e) != null && uhaVar.c() != null) {
                this.e.c().d();
            }
            R1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                oc5.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                SharedPrefHelper.getInstance().putBoolean("key_post_thread_has_request_location", false);
                SharedPrefHelper.getInstance().putBoolean("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    public final void N1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.f == null) {
                    this.f = new iia(this, this.d);
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
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() && !PermissionUtil.isBrowseMode()) {
                return;
            }
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            gha ghaVar = this.d;
            if (ghaVar != null) {
                ghaVar.E(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            uva uvaVar = this.r;
            if (uvaVar != null) {
                uvaVar.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.j4
    public void onPreLoad(ci ciVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, ciVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(ciVar);
                PreLoadImageHelper.load(ciVar, getUniqueId());
                PreLoadVideoHelper.load(ciVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            super.onScreenShot(str);
            gha ghaVar = this.d;
            if (ghaVar != null && ghaVar.A() != null && this.d.A().getCurrentTabType() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
            }
        }
    }

    public final void Q1(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            if (!this.N) {
                return false;
            }
            gha ghaVar = this.d;
            if (ghaVar != null && ghaVar.A() != null && this.d.A().getCurrentTabType() == 1 && motionEvent.getPointerCount() > 1 && this.d.C()) {
                return true;
            }
            gha ghaVar2 = this.d;
            if (ghaVar2 != null && ghaVar2.A() != null && ((currentTabType = this.d.A().getCurrentTabType()) == 2 || currentTabType == 22)) {
                this.M.a(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            if (P1()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.g == null) {
                this.g = new hia(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            getLifecycle().addObserver(this.O);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            t6a.b("main");
            on5.a().v(System.currentTimeMillis());
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (PermissionUtil.isBrowseMode()) {
                J1();
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                gha ghaVar = new gha(this);
                this.d = ghaVar;
                this.P = new yja(this, ghaVar);
                this.e = new uha(this, this.d);
                this.mHandler.post(new f(this));
                bha.b(new g(this, bundle), 0);
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                TbadkCoreApplication.getInst().setMainActivity(this);
                this.L = u35.q().i(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
                if (K1()) {
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
                fha.a(this, getIntent());
                if (AccountLoginCoreHelper.getInstance() != null) {
                    AccountLoginCoreHelper.getInstance().reLoginByCacheAccount();
                }
                if (!bka.a().e()) {
                    B1();
                }
                J1();
                H1();
                LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                gha ghaVar2 = new gha(this);
                this.d = ghaVar2;
                this.P = new yja(this, ghaVar2);
                this.e = new uha(this, this.d);
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
                bha.b(new i(this, bundle), 0);
                bka.a().k(false);
                on5.a().w(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        gha ghaVar;
        gha ghaVar2;
        FragmentTabHost.c h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, intent) == null) {
            super.onNewIntent(intent);
            if (P1() || G1(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            kha khaVar = this.A;
            if (khaVar != null && khaVar.b(intent)) {
                this.A.a(intent, this.d);
            } else {
                uha uhaVar = this.e;
                if (uhaVar != null && uhaVar.e() != null) {
                    this.e.e().b(intent);
                }
            }
            if (!StringUtils.isNull(stringExtra)) {
                return;
            }
            cg5.d().h();
            if (intent.getBooleanExtra("refresh_all", false)) {
                bka.a().m(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                I1();
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
                if ((intExtra == 17 || intExtra == 18) && (ghaVar = this.d) != null && ghaVar.A() != null) {
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
                gha ghaVar3 = this.d;
                if (ghaVar3 != null && ghaVar3.A() != null) {
                    this.d.M(intExtra);
                }
            }
            gha ghaVar4 = this.d;
            if (ghaVar4 != null && ghaVar4.A() != null && (h2 = this.d.A().h(intExtra)) != null) {
                Fragment fragment = h2.c;
                if (fragment instanceof nu4) {
                    ((nu4) fragment).L1(intent);
                }
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (ghaVar2 = this.d) != null && ghaVar2.A() != null) {
                this.d.M(2);
            }
            D1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onPause();
            if (P1()) {
                return;
            }
            lha.a().c();
            this.B = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010075, R.anim.obfuscated_res_0x7f0100a9);
            }
            VoiceManager O0 = O0();
            this.k = O0;
            if (O0 != null) {
                O0.onPause();
            }
            VoiceManager N0 = N0();
            this.l = N0;
            if (N0 != null) {
                N0.onPause();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            eha ehaVar = this.w;
            if (ehaVar != null) {
                ehaVar.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            ag5.h().i(true);
            uha uhaVar = this.e;
            if (uhaVar != null && uhaVar.a() != null) {
                this.e.a().a();
            }
            uha uhaVar2 = this.e;
            if (uhaVar2 != null && uhaVar2.c() != null) {
                this.e.c().c();
            }
            gha ghaVar = this.d;
            if (ghaVar != null) {
                ghaVar.L();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (P1()) {
                return;
            }
            gha ghaVar = this.d;
            if (ghaVar != null && ghaVar.A() != null) {
                bundle.putInt(MainEntrance.GOTO_TYPE, this.d.A().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.i.a.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager O0 = O0();
            this.k = O0;
            if (O0 != null) {
                O0.onSaveInstanceState(getPageContext().getPageActivity());
            }
            VoiceManager N0 = N0();
            this.l = N0;
            if (N0 != null) {
                N0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }
}
