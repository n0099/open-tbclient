package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.e90;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class o80 implements e90.a, Observer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n80 d;
    public static volatile o80 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public b c;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o80 this$0;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.this$0.d("netchange");
                }
            }
        }

        public b(o80 o80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = o80Var;
        }

        public /* synthetic */ b(o80 o80Var, a aVar) {
            this(o80Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                m90.a("LCPClientManager", "NetStatusReceiver changed");
                if (RequsetNetworkUtils.isNetworkAvailable(context) && n90.m(context)) {
                    m90.b("LCPClientManager", "NetStatusReceiver reconnect");
                    h90.a(context).b(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985986, "Lcom/baidu/tieba/o80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985986, "Lcom/baidu/tieba/o80;");
                return;
            }
        }
        d = new n80();
        new LinkedHashMap();
    }

    public o80() {
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
        this.b = -1;
        new LinkedBlockingQueue();
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return d.a;
        }
        return invokeV.intValue;
    }

    public void h() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (context = this.a) != null) {
            v80.S(context).b0();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = this.a;
            if (context == null || v80.S(context).R().a != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static synchronized o80 e() {
        InterceptResult invokeV;
        o80 o80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (o80.class) {
                if (e == null) {
                    synchronized (o80.class) {
                        if (e == null) {
                            e = new o80();
                        }
                    }
                }
                o80Var = e;
            }
            return o80Var;
        }
        return (o80) invokeV.objValue;
    }

    public void b(Context context, String str, String str2, int i, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            if (d.a != -2 && d.a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    h80.h(context).f();
                }
                c(context, str, str2, i, str3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            if (d.a == 0) {
                str4 = "connected";
            } else {
                str4 = "connecting";
            }
            sb.append(str4);
            m90.a("LCPClientManager", sb.toString());
        }
    }

    public synchronized void c(Context context, String str, String str2, int i, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                    this.a = context;
                    if (TextUtils.isEmpty(n90.b(context))) {
                        n90.q(context, str);
                    }
                    if (TextUtils.isEmpty(n90.e(context))) {
                        n90.s(context, str2);
                    }
                    v80.S(context).addObserver(e);
                    if (d.a != -2 && d.a != 0) {
                        if (this.c == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                            b bVar = new b(this, null);
                            this.c = bVar;
                            context.registerReceiver(bVar, intentFilter);
                        }
                        if (k80.f(context) && !h80.i().booleanValue()) {
                            h80.h(context).e(context, String.valueOf(601110), 10);
                            k80.m(context, i);
                        }
                        if (!n90.k(context)) {
                            if (this.b < 0) {
                                e80.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3).c("token_begin", System.currentTimeMillis());
                                l();
                            }
                            return;
                        }
                        m90.b("LCPClientManager", "token is not null ");
                        e80.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3);
                        k(0);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("SocketConnect state is ");
                    if (d.a == 0) {
                        str4 = "connected";
                    } else {
                        str4 = "connecting";
                    }
                    sb.append(str4);
                    m90.a("LCPClientManager", sb.toString());
                    return;
                }
                m90.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                e80.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("P0", "connect param not correct or net unconnected").d("con_err_code", "P0").c("flow_end_time", System.currentTimeMillis()).d("source", str3).e();
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Context context = this.a;
            b(context, n90.b(context), n90.e(this.a), k80.c(this.a), str);
        }
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null) {
            this.a = context;
        }
    }

    @Override // com.baidu.tieba.e90.a
    public void onResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            e80.h(this.a).g(601110).d("P3", "accessToken success").d("con_err_code", "P3");
            this.b = -1;
            k(0);
        }
    }

    public void g(BLCPRequest bLCPRequest, q80 q80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bLCPRequest, q80Var) == null) {
            Context context = this.a;
            if (context != null && n90.m(context)) {
                if (d.a != 0) {
                    if (!(bLCPRequest instanceof p80) && q80Var != null) {
                        q80Var.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                    }
                    if (d.a == -1 || !j()) {
                        d("invoke");
                        return;
                    }
                    return;
                }
                v80.S(this.a).H(bLCPRequest, q80Var);
                if (bLCPRequest.b == 1 && bLCPRequest.a == 4) {
                    m90.a("LCPClientManager", "云控登录打点");
                    Context context2 = this.a;
                    j90.a(context2, 1L, "invoke", bLCPRequest.d + "");
                }
                if (bLCPRequest.b == 50 && bLCPRequest.a == 2) {
                    Context context3 = this.a;
                    j90.a(context3, 50L, "invoke", bLCPRequest.d + "");
                }
            } else if (q80Var != null) {
                q80Var.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
            }
        }
    }

    public final void k(int i) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (context = this.a) != null && n90.m(context)) {
            if (i != 0) {
                if (i == 1) {
                    m90.a("LCPClientManager", "socketAction closeSocket");
                    v80.S(this.a).i0("socketAction closeSocket:", v80.S(this.a).x);
                    return;
                }
                return;
            }
            m90.a("LCPClientManager", "socketAction createSocket");
            d.a = -2;
            e80.h(this.a).g(601110).d("P8", "socketAction createSocket").d("con_err_code", "P8");
            v80.S(this.a).h0();
        }
    }

    public void l() {
        Context context;
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Context context2 = this.a;
            if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
                this.b++;
                e80.h(this.a).g(601110).b("token_count", this.b);
                m90.a("LCPClientManager", "no token, so request token, and tryCount = " + this.b);
                if (this.b < 3) {
                    e90 e90Var = new e90(this.a, this);
                    f90.e(e90Var, e90Var);
                    return;
                }
                this.b = -1;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.a);
            sb.append(", net :");
            if (this.a == null) {
                valueOf = "";
            } else {
                valueOf = Boolean.valueOf(!RequsetNetworkUtils.isConnected(context));
            }
            sb.append(valueOf);
            m90.a("LCPClientManager", sb.toString());
            e80.h(this.a).g(601110).d("P1", "token request net unconnected").d("con_err_code", "P1").c("flow_end_time", System.currentTimeMillis()).e();
        }
    }

    @Override // com.baidu.tieba.e90.a
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            m90.b("LCPClientManager", "getToken :" + str);
            g80 g = e80.h(this.a).g(601110);
            g.d("P4", "getToken errCode:" + i + ",errMsg:" + str).d("con_err_code", "P4");
            l();
            if (this.b == 2) {
                g80 c = e80.h(this.a).g(601110).c("flow_end_time", System.currentTimeMillis());
                c.d("P5", "token request count is max:" + this.b).d("con_err_code", "P5").e();
                d.a = -1;
                v80.S(this.a).Z();
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, observable, obj) == null) && (obj instanceof n80)) {
            d.a = ((n80) obj).a;
            m90.a("LCPClientManager", "Manager update connectState :" + d.a);
        }
    }
}
