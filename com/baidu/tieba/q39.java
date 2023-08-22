package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class q39 implements ILoginListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile q39 e = null;
    public static boolean f = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public b b;
    @Nullable
    public String c;
    public BroadcastReceiver d;

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948041042, "Lcom/baidu/tieba/q39;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948041042, "Lcom/baidu/tieba/q39;");
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q39 this$0;

        /* renamed from: com.baidu.tieba.q39$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0457a extends bx5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0457a(a aVar) {
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

            @Override // com.baidu.tieba.bx5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive doInBackground");
                    this.a.this$0.e(null);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        public a(q39 q39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = q39Var;
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
                    v39.l(z);
                    if (z) {
                        v39.m("login_lcp");
                        v39.c("login_lcp");
                        fx5.b(new C0457a(this), null);
                    }
                }
            }
        }
    }

    public q39() {
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
        this.d = new a(this);
    }

    public static q39 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (q39.class) {
                    if (e == null) {
                        e = new q39();
                    }
                }
            }
            return e;
        }
        return (q39) invokeV.objValue;
    }

    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = TbadkCoreApplication.getInst().getCuidGalaxy2();
            }
            String str = this.c;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            v39.c("login_lcp");
            v39.c("login_im");
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init context=" + context);
            int i = 0;
            this.a = false;
            String version = TbConfig.getVersion();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(context).registerReceiver(this.d, intentFilter);
            String a2 = a();
            if (d()) {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init debug");
                BIMManager.init(context, 10773430L, 1, a2);
                BIMManager.enableDebugMode(true);
                BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
                y90.d(context, 1);
                y90.c(context, true);
                aa0.O(context, "");
                i = 1;
            } else {
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init online");
                BIMManager.init(context, 10773430L, 0, a2);
                BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
            }
            BIMManager.setProductLine(context, 3, version);
            LogUtils.d("imlog", "BIMManager init env:" + i);
            f(context, a2);
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
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
            String a2 = a();
            BIMManager.login(null, a2, 6, from, currentFrom, this);
            LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + a2 + ", from = " + from + ", cfrom = " + currentFrom);
        }
    }

    public final void f(Context context, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP context=" + context);
            if (f) {
                i = 1;
            } else {
                i = 2;
            }
            f = false;
            v80.a(context, "10773430", str, i);
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP connect end");
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            v39.k(0L, i, str);
            if (i == 0) {
                v39.m("login_im");
                v39.c("login_im");
            }
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
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLogoutResult errno=" + i + ", errMsg=" + str + ", type=" + i2);
            if (!this.a) {
                e(null);
            }
        }
    }
}
