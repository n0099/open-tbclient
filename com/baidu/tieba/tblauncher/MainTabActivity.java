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
import com.baidu.tieba.af9;
import com.baidu.tieba.ag9;
import com.baidu.tieba.ah9;
import com.baidu.tieba.aq5;
import com.baidu.tieba.at4;
import com.baidu.tieba.bg9;
import com.baidu.tieba.bh9;
import com.baidu.tieba.bj9;
import com.baidu.tieba.cg9;
import com.baidu.tieba.ch9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.df9;
import com.baidu.tieba.dg9;
import com.baidu.tieba.dj9;
import com.baidu.tieba.eb5;
import com.baidu.tieba.eg9;
import com.baidu.tieba.eo5;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fg9;
import com.baidu.tieba.fl5;
import com.baidu.tieba.ga7;
import com.baidu.tieba.gg;
import com.baidu.tieba.gg9;
import com.baidu.tieba.gk5;
import com.baidu.tieba.h35;
import com.baidu.tieba.he5;
import com.baidu.tieba.hg9;
import com.baidu.tieba.hi;
import com.baidu.tieba.hv4;
import com.baidu.tieba.i85;
import com.baidu.tieba.ig9;
import com.baidu.tieba.ik5;
import com.baidu.tieba.j35;
import com.baidu.tieba.jg;
import com.baidu.tieba.jg9;
import com.baidu.tieba.jk5;
import com.baidu.tieba.jv4;
import com.baidu.tieba.jv5;
import com.baidu.tieba.ke9;
import com.baidu.tieba.kg9;
import com.baidu.tieba.kn;
import com.baidu.tieba.kq5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.le9;
import com.baidu.tieba.lg9;
import com.baidu.tieba.lh0;
import com.baidu.tieba.m35;
import com.baidu.tieba.m59;
import com.baidu.tieba.ma7;
import com.baidu.tieba.mg9;
import com.baidu.tieba.mh0;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mq4;
import com.baidu.tieba.ne9;
import com.baidu.tieba.nf9;
import com.baidu.tieba.ng9;
import com.baidu.tieba.of9;
import com.baidu.tieba.og9;
import com.baidu.tieba.p28;
import com.baidu.tieba.p35;
import com.baidu.tieba.pe9;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.pf9;
import com.baidu.tieba.pg9;
import com.baidu.tieba.qe9;
import com.baidu.tieba.qf9;
import com.baidu.tieba.qg9;
import com.baidu.tieba.re9;
import com.baidu.tieba.rf9;
import com.baidu.tieba.rg9;
import com.baidu.tieba.rr9;
import com.baidu.tieba.se9;
import com.baidu.tieba.sf5;
import com.baidu.tieba.sf9;
import com.baidu.tieba.sg9;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tf9;
import com.baidu.tieba.tg9;
import com.baidu.tieba.tl;
import com.baidu.tieba.uf9;
import com.baidu.tieba.ug9;
import com.baidu.tieba.ul;
import com.baidu.tieba.uv4;
import com.baidu.tieba.vf9;
import com.baidu.tieba.vg9;
import com.baidu.tieba.vl;
import com.baidu.tieba.w8;
import com.baidu.tieba.we9;
import com.baidu.tieba.wf9;
import com.baidu.tieba.wg9;
import com.baidu.tieba.wp5;
import com.baidu.tieba.x99;
import com.baidu.tieba.xe9;
import com.baidu.tieba.xf;
import com.baidu.tieba.xf9;
import com.baidu.tieba.xg9;
import com.baidu.tieba.xk;
import com.baidu.tieba.yf5;
import com.baidu.tieba.yf9;
import com.baidu.tieba.yg9;
import com.baidu.tieba.ym6;
import com.baidu.tieba.yz4;
import com.baidu.tieba.z18;
import com.baidu.tieba.zf9;
import com.baidu.tieba.zg9;
import com.baidu.tieba.zp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MainTabActivity extends BaseFragmentActivity implements ke9, VoiceManager.j, UserIconBox.e, lh0, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static /* synthetic */ Interceptable $ic;
    public static boolean Y;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Integer B;
    public we9 C;
    public boolean D;
    public boolean E;
    @Nullable
    public TiePlusEventController F;
    public x99 G;
    public boolean H;
    public int I;
    public int J;
    public long K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public final mh0 P;
    public boolean Q;
    public xe9 R;
    @NonNull
    public final PriorityOrganizer S;
    public ch9 T;
    public boolean U;
    public CustomMessageListener V;
    public CheckRealNameModel.b W;
    public String X;
    public boolean a;
    public int b;
    public boolean c;
    public se9 d;
    public df9 e;
    public of9 f;
    public nf9 g;
    public l h;
    public PackageChangedReceiver i;
    public long j;
    public VoiceManager k;
    public xf<TbImageView> l;
    public xf<TbImageView> m;
    public boolean n;
    public jv5 o;
    public ViewGroup p;
    public rr9 q;
    public CheckRealNameModel r;
    public String s;
    public kw5 t;
    public ShareSuccessReplyToServerModel u;
    public qe9 v;
    public BdTokenController w;
    public bj9 x;
    public boolean y;
    public WeakReference<Context> z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity a;

        /* loaded from: classes6.dex */
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
                    xk.b();
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
            df9 df9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (df9Var = this.a.e) != null && df9Var.b() != null) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.a.e.b().d();
                } else {
                    this.a.e.b().a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends gk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity b;

        @Override // com.baidu.tieba.gk5
        public boolean a(ik5 ik5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gk5
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

        @Override // com.baidu.tieba.gk5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return jk5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
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
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue != 1 && intValue != 2) {
                    if (intValue != 3) {
                        if (intValue != 8 && intValue != 21) {
                            return;
                        }
                    } else {
                        TbSingleton.getInstance().setChatTabPage(true);
                        return;
                    }
                }
                TbSingleton.getInstance().setChatTabPage(false);
                this.a.L1(true);
            }
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
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.b.J1(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.b.J1(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends wp5<Object> {
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

        @Override // com.baidu.tieba.wp5
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
                at4.a();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.d.N(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e4));
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.y = true;
        this.B = -1;
        this.D = false;
        this.E = false;
        this.K = 0L;
        this.P = new mh0();
        this.S = PriorityOrganizer.h();
        this.U = false;
        this.V = new c(this, 2001384);
        this.W = new k(this);
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately() || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
        profileRequestMessage.set_uid(Long.valueOf(gg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
        profileRequestMessage.setHistoryForumIds(ym6.n().k());
        profileRequestMessage.setHistoryForumNames(ym6.n().l());
        sendMessage(profileRequestMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i2, keyEvent)) == null) {
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

    public final boolean C1(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void M1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.O = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        se9 se9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (se9Var = this.d) != null) {
            se9Var.E(z);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.onUserChanged(z);
            this.n = true;
            if (z) {
                he5.d().h();
                w1();
                R1();
            }
            F1();
            m35.m().w("key_member_auto_ban_renewal_show", false);
        }
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public ch9 B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.T;
        }
        return (ch9) invokeV.objValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d05b5);
            this.p = (ViewGroup) findViewById(16908290);
        }
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.O;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.e
    public xf<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l == null) {
                this.l = UserIconBox.d(getPageContext().getPageActivity(), 8);
            }
            return this.l;
        }
        return (xf) invokeV.objValue;
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.N == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (isTaskRoot() && ((PermissionUtil.isAgreePrivacyPolicy() || PermissionUtil.isBrowseMode()) && !I1())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && yf5.f().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
    public xf<TbImageView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.m == null) {
                this.m = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.m;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.lh0
    @NonNull
    public mh0 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.P;
        }
        return (mh0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (N1()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.p;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.fk5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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

    @Override // com.baidu.tieba.ke9
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            se9 se9Var = this.d;
            if (se9Var != null && se9Var.y() != null) {
                return this.d.y().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.fk5
    public gk5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new b(this);
        }
        return (gk5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onStop();
            if (N1()) {
                return;
            }
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onStop(getPageContext());
            }
            M1(false);
            this.y = true;
        }
    }

    @Override // com.baidu.tieba.ke9
    @NonNull
    public PriorityOrganizer r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.S;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            se9 se9Var = this.d;
            if (se9Var == null) {
                return true;
            }
            return se9Var.K();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return kq5.a(1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.k == null) {
                this.k = VoiceManager.instance();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SpeedStatsManager.getInstance().setIsSwitchOn(true);
            MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = pe9.a(getIntent());
            registerListener(new tg9(this));
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                ne9.a(MainTabScheduleStrategy.SCHEDULE);
                xe9.a().e(this);
            } else if (!TbSingleton.getInstance().getIsPushOrSchemeLog()) {
                BaseVM.m(1);
            } else {
                TbSingleton.getInstance().setPushOrSchemeLog(false);
            }
        }
    }

    public final void v1() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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

    public void w1() {
        CheckRealNameModel checkRealNameModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (m35.m().i(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && hi.F() && (checkRealNameModel = this.r) != null) {
                checkRealNameModel.S(CheckRealNameModel.TYPE_APP_FIRST_START);
                m35.m().w(str, false);
            }
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            String str = m35.q("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (!m35.m().i(str, false)) {
                yz4.d();
                try {
                    yz4.c("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                    m35.m().w(str, true);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new sf5(getPageContext().getPageActivity())));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            se9 se9Var = this.d;
            if (se9Var != null && se9Var.y() != null) {
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
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            if (I1()) {
                return;
            }
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    public final void J1(Bundle bundle) {
        int i2;
        boolean z;
        df9 df9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_START_STAMP_KEY);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                aq5.b(new h(this), null);
            }
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            if (this.F == null) {
                this.F = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.F);
            if (C1(getIntent())) {
                return;
            }
            h35.c = h35.d;
            if (getIntent() != null) {
                we9 we9Var = new we9(getPageContext());
                this.C = we9Var;
                if (!we9Var.b(getIntent()) && (df9Var = this.e) != null && df9Var.e() != null) {
                    this.e.e().b(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                getIntent().getStringExtra("from");
            }
            le9 le9Var = new le9();
            h35.h(le9Var);
            le9Var.g(this);
            if (A1()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.v = new qe9(this);
            this.d.G(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            K1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            af9.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            zp4.w().q();
            this.o = new jv5();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            F1();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerListener(new hg9(this, this.d));
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
            }
            this.X = UtilHelper.getCurrentDay();
            this.j = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
            if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().registerStickyMode(2001404);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
            z1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            registerListener(new kg9(this, this.d));
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onCreate(getPageContext());
            }
            registerListener(new pf9(this, this.d));
            addNoAdjustSoftInputHeightListener();
            if (TbadkCoreApplication.isLogin()) {
                fl5.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                he5.d().h();
            }
            int n = m35.m().n("app_restart_times", 0);
            m35.m().z("app_restart_times", ((n > 100 || n < 0) ? 100 : 100) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.r = checkRealNameModel;
            checkRealNameModel.V(this.W);
            w1();
            this.t = new kw5(getPageContext(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            this.u = new ShareSuccessReplyToServerModel();
            new dj9(getPageContext());
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
                jg.a().postDelayed(new i(this), 5000L);
            }
            registerListener(new yg9(this, this.d));
            TbSingleton.getInstance().startOneGame();
            this.z = new WeakReference<>(TbadkCoreApplication.getInst());
            x1();
            we9 we9Var2 = this.C;
            if (we9Var2 != null && we9Var2.b(intent)) {
                this.C.a(getIntent(), this.d);
            }
            ym6.n().A(true);
            if (UbsABTestHelper.isPersonalizeFunAdABTest()) {
                ga7.m().J(this, ga7.g(), ga7.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest() && eo5.r()) {
                ga7.m().K(this, ma7.e().d("frs_feed"), ga7.b("frs", "1"), "", eo5.f());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().d();
            TbSingleton.getInstance().setActiveTimeStamp();
            df9 df9Var2 = this.e;
            if (df9Var2 != null && df9Var2.e() != null) {
                this.e.e().c();
            }
            jg.a().postDelayed(new j(this), 1000L);
            int n2 = m35.m().n("key_fps_time", 2);
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libai-entry.so"))) {
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(ul.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new tl("com.baidu.tieba.resloader.libai-entry", (DefaultDownloadCallback) null));
                PmsManager.getInstance().execute(requestParams);
                z = false;
            } else {
                z = true;
            }
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((n2 > 0 && BdTracesManager.INSTANCE.isActiveUploadType() && z) ? false : false).debug(false).timeSliceMs(n2 * 1000).build());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SECONDCREATE_END_STAMP_KEY);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            registerListener(new qf9(this, this.d));
            registerListener(new ng9(this, this.d));
            registerListener(new zf9(this, this.d));
            registerListener(new lg9(this, this.d));
            registerListener(new sg9(this, this.d));
            registerListener(new uf9(this, this.d));
            registerListener(new gg9(this, this.d));
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
            registerListener(new rg9(this, this.d));
            registerListener(new xg9(this, this.d));
            registerListener(new ig9(this, this.d));
            registerListener(new tf9(this));
            registerListener(new yf9(this, this.d));
            registerListener(new bh9(this, this.d));
            registerListener(new ah9(this));
            registerListener(new wf9(this, this.d));
            registerListener(new pg9(this, this.d));
            registerListener(new jg9(this, this.d));
            registerListener(new dg9(this, this.d));
            registerListener(new xf9(this, this.d));
            registerListener(new mg9(this, this.d));
            registerListener(new vf9(this, this.d));
            registerListener(new zg9(this, this.d));
            registerListener(new qg9(this, this.d));
            registerListener(new vg9(this, this.d));
            registerListener(new ug9(this));
            registerListener(new fg9(this));
            registerListener(new rf9(this, this.d));
            registerListener(new ag9(this, this.d));
            registerListener(new cg9(this, this.d));
            registerListener(new bg9(this));
            registerListener(new sf9(this));
            registerListener(new eg9(this));
            registerListener(new wg9(this));
            registerListener(this.V);
            registerListener(new og9(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            getLifecycle().removeObserver(this.S);
            if (N1()) {
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
            Q1();
            i85.h0().n();
            i85.h0().p();
            i85.h0().X(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            p35 p35Var = this.mWaitingDialog;
            if (p35Var != null) {
                p35Var.h(false);
                this.mWaitingDialog = null;
            }
            v1();
            se9 se9Var = this.d;
            if (se9Var != null) {
                se9Var.C();
            }
            qe9 qe9Var = this.v;
            if (qe9Var != null) {
                qe9Var.i();
            }
            df9 df9Var = this.e;
            if (df9Var != null && df9Var.i() != null) {
                this.e.i().b();
            }
            try {
                super.onDestroy();
            } catch (Exception unused2) {
            }
            h35.h(null);
            fe5.h().l();
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onDestory(getPageContext());
            }
            rr9 rr9Var = this.q;
            if (rr9Var != null) {
                rr9Var.e();
            }
            kw5 kw5Var = this.t;
            if (kw5Var != null) {
                kw5Var.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.u;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            bj9 bj9Var = this.x;
            if (bj9Var != null) {
                bj9Var.f();
            }
            se9 se9Var2 = this.d;
            if (se9Var2 != null && se9Var2.x() != null) {
                this.d.x().s();
            }
            if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                ga7.m().d("6061002332-203360688");
            }
            if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                ga7.m().c(ga7.s());
            }
            if (this.F != null) {
                getLifecycle().removeObserver(this.F);
            }
            p28.b().c();
            BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
            if (searchTask instanceof vl) {
                searchTask.cancel();
            }
            KernelCacheAssistant.get().release();
            df9 df9Var2 = this.e;
            if (df9Var2 != null && df9Var2.c() != null) {
                this.e.c().c();
            }
            df9 df9Var3 = this.e;
            if (df9Var3 != null && df9Var3.g() != null) {
                this.e.g().c();
            }
            df9 df9Var4 = this.e;
            if (df9Var4 != null && df9Var4.f() != null) {
                this.e.f().b();
            }
            df9 df9Var5 = this.e;
            if (df9Var5 != null && df9Var5.k() != null) {
                this.e.k().d();
            }
            z18.n(this).A();
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        df9 df9Var;
        se9 se9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            if (N1()) {
                return;
            }
            xe9 xe9Var = this.R;
            if (xe9Var != null) {
                xe9Var.d();
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
                jg.a().postDelayed(new a(this), 500L);
                TbSingleton.getInstance().mIsSplashClick = false;
                this.I = 2;
            }
            df9 df9Var2 = this.e;
            if (df9Var2 != null && df9Var2.a() != null) {
                M1(true);
            }
            TbSingleton.getInstance().isCanShowHotSplash = false;
            if (this.y) {
                kq5.f(this.z);
                this.y = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (se9Var = this.d) != null && se9Var.x() != null) {
                this.d.x().setLottieView(true);
            }
            se9 se9Var2 = this.d;
            if (se9Var2 != null && se9Var2.y() != null) {
                this.b = this.d.y().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            fe5.h().i(true);
            if (TbadkCoreApplication.isLogin() && fl5.b().e()) {
                fl5.b().f();
            }
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onResume(getPageContext());
            }
            se9 se9Var3 = this.d;
            if (se9Var3 != null) {
                se9Var3.F();
            }
            fl5.b().f();
            if (mq4.f().b() != null && mq4.f().h() != null && mq4.f().b().getCurTaskType() == 6) {
                mq4.f().h().a();
            }
            df9 df9Var3 = this.e;
            if (df9Var3 != null && df9Var3.a() != null) {
                this.e.a().f();
                if (this.B.intValue() != 1) {
                    this.e.a().f();
                }
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest() && (df9Var = this.e) != null && df9Var.c() != null) {
                this.e.c().d();
            }
            P1();
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                eb5.q().w(downloadData);
            }
            if (!PermissionUtil.checkLocationForTieba(this)) {
                m35.m().w("key_post_thread_has_request_location", false);
                m35.m().w("key_home_common_tab_fragment_has_request_location_local", false);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    public final void L1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                if (!this.U) {
                    this.U = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
                    return;
                }
                return;
            }
            this.U = false;
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
                    this.f = new of9(this, this.d);
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
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() && !PermissionUtil.isBrowseMode()) {
                return;
            }
            TbSingleton.getInstance().mIsForceLayoutMaintab = true;
            se9 se9Var = this.d;
            if (se9Var != null) {
                se9Var.B(i2);
            }
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            rr9 rr9Var = this.q;
            if (rr9Var != null) {
                rr9Var.d(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, configuration) != null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (N1()) {
            return;
        }
        xe9 xe9Var = this.R;
        if (xe9Var != null) {
            xe9Var.b(configuration);
        }
        if (m35.m().i("key_is_follow_system_mode", false)) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.f9
    public void onPreLoad(kn knVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, knVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(knVar);
                PreLoadImageHelper.load(knVar, getUniqueId());
                PreLoadVideoHelper.load(knVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            super.onScreenShot(str);
            se9 se9Var = this.d;
            if (se9Var != null && se9Var.y() != null && this.d.y().getCurrentTabType() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
            }
        }
    }

    public final void O1(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (!this.Q) {
                return false;
            }
            se9 se9Var = this.d;
            if (se9Var != null && se9Var.y() != null && this.d.y().getCurrentTabType() == 1 && motionEvent.getPointerCount() > 1 && this.d.A()) {
                return true;
            }
            se9 se9Var2 = this.d;
            if (se9Var2 != null && se9Var2.y() != null && ((currentTabType = this.d.y().getCurrentTabType()) == 2 || currentTabType == 22)) {
                this.P.a(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            if (N1()) {
                return;
            }
            se9 se9Var = this.d;
            if (se9Var != null && se9Var.y() != null) {
                bundle.putInt("locate_type", this.d.y().getCurrentTabType());
            }
            bundle.putParcelable(com.kwad.components.core.i.a.FRAGMENTS_TAG, null);
            bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            if (N1()) {
                super.onActivityResult(i2, i3, intent);
                return;
            }
            super.onActivityResult(i2, i3, intent);
            if (this.g == null) {
                this.g = new nf9(this, this.d);
            }
            this.g.e(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            getLifecycle().addObserver(this.S);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            m59.b("main");
            fl5.b().w(System.currentTimeMillis());
            TbadkCoreApplication.getInst().setMainActivity(this);
            setIsAddSwipeBackLayout(false);
            try {
                super.onCreate(bundle);
            } catch (ArrayIndexOutOfBoundsException e2) {
                TiebaStatic.log(new StatisticItem("crashInMainActivity").param("obj_source", e2.toString()));
            }
            if (PermissionUtil.isBrowseMode()) {
                G1();
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                se9 se9Var = new se9(this);
                this.d = se9Var;
                this.T = new ch9(this, se9Var);
                this.e = new df9(this, this.d);
                this.mHandler.post(new d(this));
                ne9.b(new e(this, bundle), 0);
            } else if (!PermissionUtil.isAgreePrivacyPolicy()) {
            } else {
                this.N = j35.q().i(this);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
                if (I1()) {
                    return;
                }
                if (!isTaskRoot()) {
                    if (hv4.e()) {
                        BdLog.e("MainTabActivity没有放在task根，请排查");
                    }
                    TiebaStatic.log(new StatisticItem("MainTab_isTaskRoot").param("obj_param1", w8.f().d()));
                    finish();
                    return;
                }
                re9.a(this, getIntent());
                if (uv4.b() != null) {
                    uv4.b().d();
                }
                G1();
                E1();
                if (PreInitMainTabViewSwitch.getIsOn()) {
                    LaunchTaskSchedule.getInstance().startTaskInSingleThread(5);
                }
                se9 se9Var2 = new se9(this);
                this.d = se9Var2;
                this.T = new ch9(this, se9Var2);
                this.e = new df9(this, this.d);
                this.mHandler.post(new f(this));
                int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
                if (loadInt == 1) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(4);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(4);
                } else if (m35.m().i("key_is_follow_system_mode", false)) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                } else {
                    TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
                }
                ne9.b(new g(this, bundle), 0);
                fl5.b().x(System.currentTimeMillis());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i2, keyEvent)) == null) {
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
        se9 se9Var;
        se9 se9Var2;
        FragmentTabHost.c h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, intent) == null) {
            super.onNewIntent(intent);
            if (N1() || C1(intent)) {
                return;
            }
            setIntent(intent);
            String stringExtra = intent.getStringExtra("target_scheme");
            we9 we9Var = this.C;
            if (we9Var != null && we9Var.b(intent)) {
                this.C.a(intent, this.d);
            } else {
                df9 df9Var = this.e;
                if (df9Var != null && df9Var.e() != null) {
                    this.e.e().b(intent);
                }
            }
            if (!StringUtils.isNull(stringExtra)) {
                return;
            }
            he5.d().h();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                F1();
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
                if ((intExtra == 17 || intExtra == 18) && (se9Var = this.d) != null && se9Var.y() != null) {
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
                se9 se9Var3 = this.d;
                if (se9Var3 != null && se9Var3.y() != null) {
                    this.d.I(intExtra);
                }
            }
            se9 se9Var4 = this.d;
            if (se9Var4 != null && se9Var4.y() != null && (h2 = this.d.y().h(intExtra)) != null) {
                Fragment fragment = h2.c;
                if (fragment instanceof jv4) {
                    ((jv4) fragment).p1(intent);
                }
            }
            if (!TextUtils.isEmpty(intent.getStringExtra(MainTabActivityConfig.PUSH_TID)) && (se9Var2 = this.d) != null && se9Var2.y() != null) {
                this.d.I(2);
            }
            z1(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPause();
            if (N1()) {
                return;
            }
            xe9 xe9Var = this.R;
            if (xe9Var != null) {
                xe9Var.c();
            }
            this.D = false;
            LogoActivityConfig.isFirst = false;
            if (this.a) {
                this.a = false;
                CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010068, R.anim.obfuscated_res_0x7f010094);
            }
            VoiceManager w0 = w0();
            this.k = w0;
            if (w0 != null) {
                w0.onPause();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
            qe9 qe9Var = this.v;
            if (qe9Var != null) {
                qe9Var.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            fe5.h().i(true);
            df9 df9Var = this.e;
            if (df9Var != null && df9Var.a() != null) {
                this.e.a().a();
            }
            df9 df9Var2 = this.e;
            if (df9Var2 != null && df9Var2.c() != null) {
                this.e.c().c();
            }
            se9 se9Var = this.d;
            if (se9Var != null) {
                se9Var.H();
            }
            SpeedStatsManager.getInstance().setStatsFlag(-1);
        }
    }

    public final void z1(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, context, intent) == null) {
            if (UtilHelper.commenDealIntent(context, intent)) {
                TbSingleton.getInstance().mIsSplashClick = true;
            } else if (intent != null && intent.getData() != null && (intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN) || intent.getData().toString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_SWAN_GAME))) {
                try {
                    O1(intent.getData().toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            TbadkCoreApplication.setIntent(null);
        }
    }
}
