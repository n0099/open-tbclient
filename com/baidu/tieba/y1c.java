package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class y1c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "y1c";
    public static ConnectivityManager g;
    public static NetworkInfo h;
    public static final Handler i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ExecutorService b;
    public b2c c;
    public AtomicBoolean d;
    public BroadcastReceiver e;

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y1c this$0;

        public a(y1c y1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = y1cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                TLog.h("[tinyvideo]", "[netrecv] NetworkStateService onReceive pid " + Thread.currentThread().getId());
                if (intent.getAction().equals(NetworkMonitor.NET_CHANGE_ACTION)) {
                    TLog.h("[tinyvideo]", "[netrecv]  current network connectivity action begin");
                    this.this$0.j();
                    TLog.h("[tinyvideo]", "[netrecv] current network connectivity action end");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y1c a;

        public b(y1c y1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.d) {
                if (!this.a.d.get()) {
                    return;
                }
                y1c.g(this.a.a, this.a.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y1c a;

        public c(y1c y1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y1cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.shutdownNow();
                this.a.b = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278750, "Lcom/baidu/tieba/y1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278750, "Lcom/baidu/tieba/y1c;");
                return;
            }
        }
        i = new Handler(Looper.getMainLooper());
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TLog.h("[tinyvideo]", "[netrecv]  updateNetInfo");
            ExecutorService executorService = this.b;
            if (executorService != null) {
                executorService.submit(new b(this));
            }
        }
    }

    public y1c(Context context, b2c b2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b2cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = new AtomicBoolean(false);
        this.e = new a(this);
        this.a = context;
        this.c = b2cVar;
    }

    public static void g(Context context, b2c b2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, b2cVar) == null) {
            TLog.h("[tinyvideo]", "[netrecv] doUpdateNetInfo");
            if (context == null) {
                return;
            }
            TLog.h("[tinyvideo]", "[netrecv] doUpdateNetInfo, getActiveNetworkInfo begin");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            g = connectivityManager;
            h = connectivityManager.getActiveNetworkInfo();
            TLog.h("[tinyvideo]", "[netrecv] doUpdateNetInfo, getActiveNetworkInfo end");
            NetworkInfo networkInfo = h;
            if (networkInfo != null && networkInfo.isAvailable()) {
                int type = h.getType();
                if (type == 0) {
                    byte h2 = h(context);
                    b2cVar.e(h2);
                    TLog.h("[tinyvideo]", "[netrecv] current network: " + h.getTypeName() + ", mobileNetType:" + ((int) h2));
                    return;
                } else if (type == 1) {
                    b2cVar.e(0);
                    TLog.h("[tinyvideo]", "[netrecv] current network: " + h.getTypeName());
                    return;
                } else {
                    String str = f;
                    TLog.h(str, "[netrecv] current network: " + h.getTypeName());
                    return;
                }
            }
            TLog.h("[tinyvideo]", "[netrecv] current network No usable network!!");
            b2cVar.e(2);
        }
    }

    public static byte h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                        return (byte) 3;
                    case 3:
                        return (byte) 4;
                    case 4:
                        return (byte) 3;
                    case 5:
                    case 6:
                        return (byte) 4;
                    case 7:
                        return (byte) 3;
                    case 8:
                    case 9:
                    case 10:
                        return (byte) 4;
                    case 11:
                        return (byte) 3;
                    case 12:
                        return (byte) 4;
                    case 13:
                        return (byte) 5;
                    case 14:
                    case 15:
                        return (byte) 4;
                    default:
                        return (byte) 1;
                }
            } catch (SecurityException e) {
                e.printStackTrace();
                return (byte) 1;
            }
        }
        return invokeL.byteValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TLog.h("[tinyvideo]", "[netrecv] NetStatManager deInit ");
            if (this.a != null) {
                synchronized (this.d) {
                    if (this.d.get()) {
                        this.d.set(false);
                        this.a.unregisterReceiver(this.e);
                    }
                }
                i.post(new c(this));
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TLog.h("[tinyvideo]", "[netrecv] NetStatManager.setup");
            if (this.a != null) {
                synchronized (this.d) {
                    if (!this.d.get()) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                        this.a.registerReceiver(this.e, intentFilter);
                        this.b = Executors.newSingleThreadExecutor();
                        this.d.set(true);
                        TLog.h("[tinyvideo]", "[netrecv] NetStatManager.setup done");
                    }
                }
            }
        }
    }
}
