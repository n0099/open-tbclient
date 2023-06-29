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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.util.UrlManager;
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
import com.baidu.tieba.a9a;
import com.baidu.tieba.al5;
import com.baidu.tieba.b7a;
import com.baidu.tieba.b8a;
import com.baidu.tieba.b9a;
import com.baidu.tieba.bo;
import com.baidu.tieba.bw5;
import com.baidu.tieba.c7a;
import com.baidu.tieba.c8a;
import com.baidu.tieba.c9a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.ct5;
import com.baidu.tieba.d7a;
import com.baidu.tieba.d8a;
import com.baidu.tieba.d9a;
import com.baidu.tieba.ds5;
import com.baidu.tieba.dx9;
import com.baidu.tieba.e7a;
import com.baidu.tieba.e9a;
import com.baidu.tieba.f55;
import com.baidu.tieba.f8a;
import com.baidu.tieba.f9a;
import com.baidu.tieba.fs5;
import com.baidu.tieba.ft7;
import com.baidu.tieba.g8a;
import com.baidu.tieba.g9a;
import com.baidu.tieba.gn6;
import com.baidu.tieba.gs5;
import com.baidu.tieba.gs6;
import com.baidu.tieba.h8a;
import com.baidu.tieba.h9;
import com.baidu.tieba.h9a;
import com.baidu.tieba.hy5;
import com.baidu.tieba.i7a;
import com.baidu.tieba.i8a;
import com.baidu.tieba.i9a;
import com.baidu.tieba.iu4;
import com.baidu.tieba.j05;
import com.baidu.tieba.j7a;
import com.baidu.tieba.j8a;
import com.baidu.tieba.j9a;
import com.baidu.tieba.k8a;
import com.baidu.tieba.k9a;
import com.baidu.tieba.km;
import com.baidu.tieba.ks8;
import com.baidu.tieba.kx4;
import com.baidu.tieba.l05;
import com.baidu.tieba.l8a;
import com.baidu.tieba.l9a;
import com.baidu.tieba.lm;
import com.baidu.tieba.ln5;
import com.baidu.tieba.lt7;
import com.baidu.tieba.m7a;
import com.baidu.tieba.m8a;
import com.baidu.tieba.m95;
import com.baidu.tieba.m9a;
import com.baidu.tieba.mg;
import com.baidu.tieba.mm;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n8a;
import com.baidu.tieba.n9a;
import com.baidu.tieba.nl;
import com.baidu.tieba.o8a;
import com.baidu.tieba.o95;
import com.baidu.tieba.o9a;
import com.baidu.tieba.p36;
import com.baidu.tieba.p7a;
import com.baidu.tieba.p8a;
import com.baidu.tieba.p9a;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.q46;
import com.baidu.tieba.q8a;
import com.baidu.tieba.q9a;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qka;
import com.baidu.tieba.r8a;
import com.baidu.tieba.r95;
import com.baidu.tieba.r9a;
import com.baidu.tieba.rn5;
import com.baidu.tieba.s8a;
import com.baidu.tieba.sba;
import com.baidu.tieba.sj0;
import com.baidu.tieba.sx5;
import com.baidu.tieba.t1a;
import com.baidu.tieba.t8a;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tj0;
import com.baidu.tieba.u8a;
import com.baidu.tieba.u95;
import com.baidu.tieba.u99;
import com.baidu.tieba.uba;
import com.baidu.tieba.us6;
import com.baidu.tieba.uy6;
import com.baidu.tieba.v8a;
import com.baidu.tieba.v99;
import com.baidu.tieba.vg;
import com.baidu.tieba.vh5;
import com.baidu.tieba.w6a;
import com.baidu.tieba.w8a;
import com.baidu.tieba.wu4;
import com.baidu.tieba.wx5;
import com.baidu.tieba.x6a;
import com.baidu.tieba.x8a;
import com.baidu.tieba.xi;
import com.baidu.tieba.xs8;
import com.baidu.tieba.y05;
import com.baidu.tieba.y8a;
import com.baidu.tieba.yg;
import com.baidu.tieba.yk5;
import com.baidu.tieba.z6a;
import com.baidu.tieba.z8a;
import com.baidu.tieba.z9a;
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
/* loaded from: classes7.dex */
public class MainTabActivity extends BaseFragmentActivity implements w6a, VoiceManager.j, UserIconBox.c, sj0, FrsCommonImageLayout.e, IVideoNeedPreload, d8a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean W;
    public transient /* synthetic */ FieldHolder $fh;
    public i7a A;
    public boolean B;
    public boolean C;
    @Nullable
    public TiePlusEventController D;
    public t1a E;
    public boolean F;
    public int G;
    public int H;
    public long I;
    public boolean J;
    public boolean K;
    public int L;
    public boolean M;
    public final tj0 N;
    public boolean O;
    @NonNull
    public final PriorityOrganizer P;
    public r9a Q;
    public v99 R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1161T;
    public CheckRealNameModel.b U;
    public String V;
    public boolean a;
    public int b;
    public boolean c;
    public e7a d;
    public p7a e;
    public c8a f;
    public b8a g;
    public l h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public mg<TbImageView> l;
    public mg<TbImageView> m;
    public boolean n;
    public p36 o;
    public ViewGroup p;
    public qka q;
    public CheckRealNameModel r;
    public String s;
    public q46 t;
    public ShareSuccessReplyToServerModel u;
    public c7a v;
    public BdTokenController w;
    public sba x;
    public int y;
    public Integer z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
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
                    nl.b();
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbadkCoreApplication.getInst().isMainProcess(false)) {
                us6.a(new a(this), "fetchBundleInfo", 3);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            p7a p7aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p7aVar = this.a.e) != null && p7aVar.b() != null) {
                this.a.e.b().a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ds5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity b;

        @Override // com.baidu.tieba.ds5
        public boolean a(fs5 fs5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fs5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ds5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

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
            this.b = mainTabActivity;
        }

        @Override // com.baidu.tieba.ds5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return gs5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MainTabActivity mainTabActivity, int i) {
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
                    if (this.a.R != null) {
                        return;
                    }
                    v99 v99Var = this.a.R;
                    if (num.intValue() == 2) {
                        z = true;
                    }
                    v99Var.b(z);
                    return;
                }
                TbSingleton.getInstance().setChatTabPage(false);
                this.a.P1(true);
                if (this.a.R != null) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.O = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ MainTabActivity b;

        public e(MainTabActivity mainTabActivity, Bundle bundle) {
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
                this.b.N1(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.O = true;
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.b.N1(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends sx5<Object> {
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

        @Override // com.baidu.tieba.sx5
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

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

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
            this.a = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kx4.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements CheckRealNameModel.b {
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

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) && CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                this.a.d.N(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f042d));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity this$0;

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
            this.this$0 = mainTabActivity;
        }

        public /* synthetic */ l(MainTabActivity mainTabActivity, c cVar) {
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
        this.z = -1;
        this.B = false;
        this.C = false;
        this.I = 0L;
        this.N = new tj0();
        this.P = PriorityOrganizer.m();
        this.R = null;
        this.S = false;
        this.f1161T = new c(this, 2001384);
        this.U = new k(this);
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately() || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        profileRequestMessage.set_uid(Long.valueOf(vg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
        profileRequestMessage.setHistoryForumIds(uy6.n().k());
        profileRequestMessage.setHistoryForumNames(uy6.n().l());
        sendMessage(profileRequestMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
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

    public final boolean H1(Intent intent) {
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

    public void Q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.M = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        e7a e7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (e7aVar = this.d) != null) {
            e7aVar.E(z);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            super.onUserChanged(z);
            this.n = true;
            if (z) {
                al5.d().h();
                z1();
                V1();
            }
            J1();
            r95.p().A("key_member_auto_ban_renewal_show", false);
        }
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = r95.t("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (!r95.p().l(str, false)) {
                f55.d();
                try {
                    f55.c("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                    r95.p().A(str, true);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = b7a.a(getIntent());
            registerListener(new i9a(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                z6a.a(MainTabScheduleStrategy.SCHEDULE);
                j7a.a().e(this);
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
            if (r95.p().l(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && xi.F() && (checkRealNameModel = this.r) != null) {
                checkRealNameModel.V(CheckRealNameModel.TYPE_APP_FIRST_START);
                r95.p().A(str, false);
            }
        }
    }

    public final void C1() {
        gn6 gn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (gn6Var = (gn6) ServiceManager.getService(gn6.a)) != null) {
            gn6Var.a();
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
    @Override // com.baidu.tieba.d8a
    /* renamed from: F1 */
    public r9a g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.Q;
        }
        return (r9a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public mg<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l == null) {
                this.l = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.l;
        }
        return (mg) invokeV.objValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d05e9);
            this.p = (ViewGroup) findViewById(16908290);
        }
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public final boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.L == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (isTaskRoot() && ((PermissionUtil.isAgreePrivacyPolicy() || PermissionUtil.isBrowseMode()) && !M1())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && rn5.f().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            l lVar = this.h;
            if (lVar != null) {
                unregisterReceiver(lVar);
            }
            PackageChangedReceiver packageChangedReceiver = this.i;
            if (packageChangedReceiver != null) {
                unregisterReceiver(packageChangedReceiver);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public mg<TbImageView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.m == null) {
                this.m = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.m;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.sj0
    @NonNull
    public tj0 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.N;
        }
        return (tj0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (R1()) {
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
            return this.p;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.cs5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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

    @Override // com.baidu.tieba.w6a
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            e7a e7aVar = this.d;
            if (e7aVar != null && e7aVar.y() != null) {
                return this.d.y().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.cs5
    public ds5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return new b(this);
        }
        return (ds5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onStop();
            if (R1()) {
                return;
            }
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onStop(getPageContext());
            }
            Q1(false);
        }
    }

    @Override // com.baidu.tieba.w6a
    @NonNull
    public PriorityOrganizer s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.P;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            e7a e7aVar = this.d;
            if (e7aVar == null) {
                return true;
            }
            return e7aVar.K();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return hy5.a(1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void D1(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                TbSingleton.getInstance().mIsSplashClick = true;
            } else if (intent != null && intent.getData() != null && (intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN_GAME))) {
                try {
                    S1(intent.getData().toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            TbadkCoreApplication.setIntent(null);
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new ln5(getPageContext().getPageActivity())));
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
            e7a e7aVar = this.d;
            if (e7aVar != null && e7aVar.y() != null) {
                Fragment currentFragment = this.d.y().getCurrentFragment();
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
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (M1()) {
                return;
            }
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    public final void N1(Bundle bundle) {
        int i2;
        boolean z;
        p7a p7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                wx5.b(new h(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.D == null) {
                this.D = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.D);
            if (H1(getIntent())) {
                return;
            }
            m95.c = m95.d;
            if (getIntent() != null) {
                i7a i7aVar = new i7a(getPageContext());
                this.A = i7aVar;
                if (!i7aVar.b(getIntent()) && (p7aVar = this.e) != null && p7aVar.e() != null) {
                    this.e.e().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            x6a x6aVar = new x6a();
            m95.h(x6aVar);
            x6aVar.g(this);
            if (E1()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.v = new c7a(this);
            this.d.G(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            O1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            m7a.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            iu4.w().q();
            this.o = new p36();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            J1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new w8a(this, this.d));
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
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
            registerListener(new z8a(this, this.d));
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onCreate(getPageContext());
            }
            registerListener(new f8a(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                ct5.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                al5.d().h();
            }
            int q = r95.p().q("app_restart_times", 0);
            r95.p().F("app_restart_times", ((q > 100 || q < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.r = checkRealNameModel;
            checkRealNameModel.Y(this.U);
            z1();
            this.t = new q46(getPageContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            this.u = new ShareSuccessReplyToServerModel();
            new uba(getPageContext());
            this.w = BdTokenController.J();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            StatisticItem param = new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (skinType == 4) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(param.param("obj_type", i2));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                yg.a().postDelayed(new i(this), 5000L);
            }
            registerListener(new n9a(this, this.d));
            TbSingleton.getInstance().startOneGame();
            A1();
            i7a i7aVar2 = this.A;
            if (i7aVar2 != null && i7aVar2.b(intent)) {
                this.A.a(getIntent(), this.d);
            }
            uy6.n().B(true);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                ft7.m().I(this, ft7.g(), ft7.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && bw5.r()) {
                ft7.m().J(this, lt7.e().d("frs_feed"), ft7.b("frs", "1"), "", bw5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            p7a p7aVar2 = this.e;
            if (p7aVar2 != null && p7aVar2.e() != null) {
                this.e.e().c();
            }
            yg.a().postDelayed(new j(this), 1000L);
            int q2 = r95.p().q("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(lm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new km("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((q2 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(q2 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            registerListener(new g8a(this, this.d));
            registerListener(new c9a(this, this.d));
            registerListener(new p8a(this, this.d));
            registerListener(new a9a(this, this.d));
            registerListener(new h9a(this, this.d));
            registerListener(new k8a(this, this.d));
            registerListener(new v8a(this, this.d));
            this.h = new l(this, null);
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
            registerListener(new g9a(this, this.d));
            registerListener(new m9a(this, this.d));
            registerListener(new x8a(this, this.d));
            registerListener(new j8a(this));
            registerListener(new o8a(this, this.d));
            registerListener(new q9a(this, this.d));
            registerListener(new p9a(this));
            registerListener(new m8a(this, this.d));
            registerListener(new e9a(this, this.d));
            registerListener(new y8a(this, this.d));
            registerListener(new s8a(this, this.d));
            registerListener(new n8a(this, this.d));
            registerListener(new b9a(this, this.d));
            registerListener(new l8a(this, this.d));
            registerListener(new o9a(this, this.d));
            registerListener(new f9a(this, this.d));
            registerListener(new k9a(this, this.d));
            registerListener(new j9a(this));
            registerListener(new u8a(this));
            registerListener(new h8a(this, this.d));
            registerListener(new q8a(this, this.d));
            registerListener(new r8a(this));
            registerListener(new i8a(this));
            registerListener(new t8a(this));
            registerListener(new l9a(this));
            registerListener(this.f1161T);
            registerListener(new d9a(this));
            if (this.R == null) {
                this.R = new v99(u99.class);
                gs6.b().a(this, this.R);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        p7a p7aVar;
        e7a e7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (R1()) {
                return;
            }
            j7a.a().d();
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
                yg.a().postDelayed(new a(this), 500L);
                TbSingleton.getInstance().mIsSplashClick = false;
                this.G = 2;
            }
            p7a p7aVar2 = this.e;
            if (p7aVar2 != null && p7aVar2.a() != null) {
                Q1(true);
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (e7aVar = this.d) != null && e7aVar.x() != null) {
                this.d.x().setLottieView(true);
            }
            e7a e7aVar2 = this.d;
            if (e7aVar2 != null && e7aVar2.y() != null) {
                this.b = this.d.y().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            yk5.h().i(true);
            if (TbadkCoreApplication.isLogin() && ct5.b().e()) {
                ct5.b().f();
            }
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onResume(getPageContext());
            }
            e7a e7aVar3 = this.d;
            if (e7aVar3 != null) {
                e7aVar3.F();
            }
            ct5.b().f();
            if (wu4.f().b() != null && wu4.f().h() != null && wu4.f().b().getCurTaskType() == 6) {
                wu4.f().h().a();
            }
            p7a p7aVar3 = this.e;
            if (p7aVar3 != null && p7aVar3.a() != null) {
                this.e.a().f();
                if (this.z.intValue() != 1) {
                    this.e.a().f();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (p7aVar = this.e) != null && p7aVar.c() != null) {
                this.e.c().d();
            }
            T1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                vh5.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                r95.p().A("key_post_thread_has_request_location", false);
                r95.p().A("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    public final void P1(boolean z) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (this.f == null) {
                    this.f = new c8a(this, this.d);
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
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() && !PermissionUtil.isBrowseMode()) {
                return;
            }
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            e7a e7aVar = this.d;
            if (e7aVar != null) {
                e7aVar.B(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            qka qkaVar = this.q;
            if (qkaVar != null) {
                qkaVar.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, configuration) != null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (R1()) {
            return;
        }
        j7a.a().b(configuration);
        if (r95.p().l("key_is_follow_system_mode", false)) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.q9
    public void onPreLoad(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, boVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(boVar);
                PreLoadImageHelper.load(boVar, getUniqueId());
                PreLoadVideoHelper.load(boVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            super.onScreenShot(str);
            e7a e7aVar = this.d;
            if (e7aVar != null && e7aVar.y() != null && this.d.y().getCurrentTabType() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
            }
        }
    }

    public final void S1(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("page", "applet/swanApp");
            jSONObject2.put("pageParams", jSONObject);
            hashMap.put("params", jSONObject2.toString());
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{UrlUtils.appendParams("tiebaapp://router/portal", hashMap)});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int currentTabType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            if (!this.O) {
                return false;
            }
            e7a e7aVar = this.d;
            if (e7aVar != null && e7aVar.y() != null && this.d.y().getCurrentTabType() == 1 && motionEvent.getPointerCount() > 1 && this.d.A()) {
                return true;
            }
            e7a e7aVar2 = this.d;
            if (e7aVar2 != null && e7aVar2.y() != null && ((currentTabType = this.d.y().getCurrentTabType()) == 2 || currentTabType == 22)) {
                this.N.a(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (R1()) {
                return;
            }
            e7a e7aVar = this.d;
            if (e7aVar != null && e7aVar.y() != null) {
                bundle.putInt("locate_type", this.d.y().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.i.a.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i2, i3, intent) == null) {
            if (R1()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.g == null) {
                this.g = new b8a(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            getLifecycle().addObserver(this.P);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            dx9.b("main");
            ct5.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (PermissionUtil.isBrowseMode()) {
                K1();
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                e7a e7aVar = new e7a(this);
                this.d = e7aVar;
                this.Q = new r9a(this, e7aVar);
                this.e = new p7a(this, this.d);
                this.mHandler.post(new d(this));
                z6a.b(new e(this, bundle), 0);
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                this.L = o95.q().i(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
                if (M1()) {
                    return;
                }
                if (!isTaskRoot()) {
                    if (j05.e()) {
                        BdLog.e("MainTabActivity没有放在task根，请排查");
                    }
                    TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", h9.f().d()));
                    finish();
                    return;
                }
                d7a.a(this, getIntent());
                if (y05.b() != null) {
                    y05.b().d();
                }
                if (!z9a.a().d()) {
                    C1();
                }
                K1();
                I1();
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                e7a e7aVar2 = new e7a(this);
                this.d = e7aVar2;
                this.Q = new r9a(this, e7aVar2);
                this.e = new p7a(this, this.d);
                this.mHandler.post(new f(this));
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt == 1) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(4);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
                } else if (r95.p().l("key_is_follow_system_mode", false)) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                z6a.b(new g(this, bundle), 0);
                z9a.a().h(false);
                ct5.b().x(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        e7a e7aVar;
        e7a e7aVar2;
        FragmentTabHost.c h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            super.onNewIntent(intent);
            if (R1() || H1(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            i7a i7aVar = this.A;
            if (i7aVar != null && i7aVar.b(intent)) {
                this.A.a(intent, this.d);
            } else {
                p7a p7aVar = this.e;
                if (p7aVar != null && p7aVar.e() != null) {
                    this.e.e().b(intent);
                }
            }
            if (!StringUtils.isNull(stringExtra)) {
                return;
            }
            al5.d().h();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                z9a.a().j(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                J1();
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
                if ((intExtra == 17 || intExtra == 18) && (e7aVar = this.d) != null && e7aVar.y() != null) {
                    this.d.y().setCurrentTab(0);
                }
            } else {
                if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                    if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        intExtra = 2;
                    } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                        intExtra = this.o.a();
                    }
                }
                e7a e7aVar3 = this.d;
                if (e7aVar3 != null && e7aVar3.y() != null) {
                    this.d.I(intExtra);
                }
            }
            e7a e7aVar4 = this.d;
            if (e7aVar4 != null && e7aVar4.y() != null && (h2 = this.d.y().h(intExtra)) != null) {
                Fragment fragment = h2.c;
                if (fragment instanceof l05) {
                    ((l05) fragment).t1(intent);
                }
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (e7aVar2 = this.d) != null && e7aVar2.y() != null) {
                this.d.I(2);
            }
            D1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            getLifecycle().removeObserver(this.P);
            if (R1()) {
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
            U1();
            qe5.p0().n();
            qe5.p0().p();
            qe5.p0().b0(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            u95 u95Var = this.mWaitingDialog;
            if (u95Var != null) {
                u95Var.h(false);
                this.mWaitingDialog = null;
            }
            y1();
            e7a e7aVar = this.d;
            if (e7aVar != null) {
                e7aVar.C();
            }
            c7a c7aVar = this.v;
            if (c7aVar != null) {
                c7aVar.i();
            }
            p7a p7aVar = this.e;
            if (p7aVar != null && p7aVar.i() != null) {
                this.e.i().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            m95.h(null);
            yk5.h().l();
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onDestory(getPageContext());
            }
            qka qkaVar = this.q;
            if (qkaVar != null) {
                qkaVar.e();
            }
            q46 q46Var = this.t;
            if (q46Var != null) {
                q46Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.u;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            sba sbaVar = this.x;
            if (sbaVar != null) {
                sbaVar.f();
            }
            e7a e7aVar2 = this.d;
            if (e7aVar2 != null && e7aVar2.x() != null) {
                this.d.x().s();
            }
            ft7.m().c(ft7.s());
            if (this.D != null) {
                getLifecycle().removeObserver(this.D);
            }
            xs8.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof mm) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            p7a p7aVar2 = this.e;
            if (p7aVar2 != null && p7aVar2.c() != null) {
                this.e.c().c();
            }
            p7a p7aVar3 = this.e;
            if (p7aVar3 != null && p7aVar3.g() != null) {
                this.e.g().c();
            }
            p7a p7aVar4 = this.e;
            if (p7aVar4 != null && p7aVar4.f() != null) {
                this.e.f().b();
            }
            p7a p7aVar5 = this.e;
            if (p7aVar5 != null && p7aVar5.k() != null) {
                this.e.k().d();
            }
            ks8.n(this).A();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048616, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onPause();
            if (R1()) {
                return;
            }
            j7a.a().c();
            this.B = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010073, R.anim.obfuscated_res_0x7f0100a5);
            }
            VoiceManager y0 = y0();
            this.k = y0;
            if (y0 != null) {
                y0.onPause();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            c7a c7aVar = this.v;
            if (c7aVar != null) {
                c7aVar.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            yk5.h().i(true);
            p7a p7aVar = this.e;
            if (p7aVar != null && p7aVar.a() != null) {
                this.e.a().a();
            }
            p7a p7aVar2 = this.e;
            if (p7aVar2 != null && p7aVar2.c() != null) {
                this.e.c().c();
            }
            e7a e7aVar = this.d;
            if (e7aVar != null) {
                e7aVar.H();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }
}
