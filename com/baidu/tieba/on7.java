package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class on7 implements ILoginListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile on7 d = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public b b;
    public BroadcastReceiver c;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948038097, "Lcom/baidu/tieba/on7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948038097, "Lcom/baidu/tieba/on7;");
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on7 this$0;

        /* renamed from: com.baidu.tieba.on7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0382a extends ik5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0382a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.ik5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive doInBackground");
                    this.a.this$0.d(null);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        public a(on7 on7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = on7Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive context=" + context + ", intent=" + intent);
                if (intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                    if (intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive connect=" + z);
                    Log.d("ImSdkManager", "registerConnectListener connect ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
                    if (z) {
                        mk5.b(new C0382a(this), null);
                    }
                }
            }
        }
    }

    public on7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    public static on7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (on7.class) {
                    if (d == null) {
                        d = new on7();
                    }
                }
            }
            return d;
        }
        return (on7) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init context=" + context);
            int i = 0;
            this.a = false;
            String version = TbConfig.getVersion();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(context).registerReceiver(this.c, intentFilter);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (c()) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init debug");
                BIMManager.init(context, Constants.APPID_TIEBA, 1, cuidGalaxy2);
                BIMManager.enableDebugMode(true);
                BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
                k90.d(context, 1);
                k90.c(context, true);
                i = 1;
            } else {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init online");
                BIMManager.init(context, Constants.APPID_TIEBA, 0, cuidGalaxy2);
                BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
            }
            BIMManager.setProductLine(context, 3, version);
            LogUtils.d("imlog", "BIMManager init env:" + i);
            e(context);
        }
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM listener=" + bVar);
            this.b = bVar;
            String from = TbConfig.getFrom();
            String currentFrom = TbConfig.getCurrentFrom();
            if (TbadkCoreApplication.isLogin()) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM login");
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String currentBduss = TbadkCoreApplication.getCurrentBduss();
                BIMManager.login(currentAccount, currentBduss, 1, from, currentFrom, this);
                LogUtils.d("imlog", "IMSdkManager PassIsLogin loginToIM uid = " + currentAccount + ", bduss = " + currentBduss + ", from = " + from + ", cfrom = " + currentFrom);
                return;
            }
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM cuid");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            BIMManager.login(null, cuidGalaxy2, 6, from, currentFrom, this);
            LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + cuidGalaxy2 + ", from = " + from + ", cfrom = " + currentFrom);
        }
    }

    public final void e(Context context) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP context=" + context);
            if (e) {
                i = 1;
            } else {
                i = 2;
            }
            e = false;
            k80.a(context, "10773430", TbadkCoreApplication.getInst().getCuidGalaxy2(), i);
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP connect end");
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLoginResult errno=" + i + ", errMsg=" + str);
            b bVar = this.b;
            if (bVar != null) {
                bVar.a(i, str);
                this.b = null;
            }
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLogoutResult(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLogoutResult errno=" + i + ", errMsg=" + str + ", type=" + i2);
            if (!this.a) {
                d(null);
            }
        }
    }
}
