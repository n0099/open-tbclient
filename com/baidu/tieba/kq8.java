package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.jq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kq8 implements IConnectListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static String e = "imlog";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public c b;
    public CustomMessageListener c;
    public boolean d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947921847, "Lcom/baidu/tieba/kq8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947921847, "Lcom/baidu/tieba/kq8;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kq8 kq8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var, Integer.valueOf(i)};
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
            this.a = kq8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jq8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq8 a;

        public b(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq8Var;
        }

        @Override // com.baidu.tieba.jq8.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
                StringBuilder sb = new StringBuilder();
                sb.append(kq8.e);
                sb.append("LiveIMManager");
                String sb2 = sb.toString();
                LogUtils.d(sb2, "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + this.a.a);
                if (i == 0 && !this.a.a) {
                    this.a.onResult(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsDestroy;
        public boolean mIsInit;
        public final /* synthetic */ kq8 this$0;

        public c(kq8 kq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kq8Var;
        }

        public /* synthetic */ c(kq8 kq8Var, a aVar) {
            this(kq8Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
                if (this.mIsInit) {
                    this.mIsInit = false;
                } else if (BdNetTypeUtil.isNetWorkAvailable() && !this.mIsDestroy) {
                    BIMManager.tryConnection(context);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.mIsDestroy = true;
                try {
                    TbadkCoreApplication.getInst().unregisterReceiver(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.mIsInit = true;
                this.mIsDestroy = false;
            }
        }

        public void register() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                init();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                TbadkCoreApplication.getInst().registerReceiver(this, intentFilter);
            }
        }
    }

    public kq8() {
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
        this.a = false;
        this.c = new a(this, 2005016);
        this.d = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            jq8.b().e(new b(this));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogUtils.d(e + "LiveIMManager", "registerIMConnectListener");
            this.a = false;
            BIMManager.unregisterConnectListener();
            BIMManager.registerConnectListener(this);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
            if (this.d) {
                return;
            }
            this.d = true;
            jq8.b().c(TbadkCoreApplication.getInst());
            d();
            c();
            if (this.b == null) {
                this.b = new c(this, null);
            }
            this.b.register();
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i);
            LogUtils.d(e + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
            this.a = true;
            if (i == 0) {
                LogUtils.d(e + "LiveIMManager", "IConnectListener net connect");
            } else if (i == 1) {
                LogUtils.d(e + "LiveIMManager", "IConnectListener net disconnect");
            }
        }
    }
}
