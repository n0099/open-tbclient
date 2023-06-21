package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.oa0;
import com.baidu.tieba.x90;
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
/* loaded from: classes8.dex */
public class v90 implements oa0.a, Observer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u90 e;
    public static int f;
    public static volatile v90 g;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public b c;
    public long d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v90 this$0;

        /* loaded from: classes8.dex */
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
                    this.a.this$0.f("netchange");
                }
            }
        }

        public b(v90 v90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = v90Var;
        }

        public /* synthetic */ b(v90 v90Var, a aVar) {
            this(v90Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                ua0.a("LCPClientManager", "NetStatusReceiver changed");
                if (RequsetNetworkUtils.isNetworkAvailable(context) && v90.e.a == -1) {
                    ua0.b("LCPClientManager", "NetStatusReceiver, current net status is available, LCP reconnect start");
                    ra0.a(context).b(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195484, "Lcom/baidu/tieba/v90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195484, "Lcom/baidu/tieba/v90;");
                return;
            }
        }
        e = new u90();
        new LinkedHashMap();
        f = -1;
    }

    public v90() {
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
        this.d = 0L;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return e.a;
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", e.a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        }
    }

    public void k() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (context = this.a) != null && RequsetNetworkUtils.isConnected(context)) {
            ea0.V(this.a).h0();
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.a;
            if (context == null || ea0.V(context).X().a != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static synchronized v90 g() {
        InterceptResult invokeV;
        v90 v90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (v90.class) {
                if (g == null) {
                    synchronized (v90.class) {
                        if (g == null) {
                            g = new v90();
                        }
                    }
                }
                v90Var = g;
            }
            return v90Var;
        }
        return (v90) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oa0.a
    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            if (f != i) {
                ua0.b("LCPClientManager", "getToken success, but requestMark not equal, sTokenRequestMark is " + f + " mark is " + i);
                return;
            }
            ua0.b("LCPClientManager", "getToken success, cost: " + (System.currentTimeMillis() - this.d) + "ms");
            n90 g2 = m90.h(this.a).g(601110);
            g2.d("P3", "accessToken success");
            g2.d("con_err_code", "P3");
            this.b = -1;
            m(0);
        }
    }

    @Override // com.baidu.tieba.oa0.a
    public void b(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (f != i2) {
                ua0.b("LCPClientManager", "getToken onFailure, but requestMark not equal, sTokenRequestMark is " + f + " mark is " + i2);
                return;
            }
            ua0.b("LCPClientManager", "getToken failure:" + str + "\r\n + cost: " + (System.currentTimeMillis() - this.d) + "ms");
            n90 g2 = m90.h(this.a).g(601110);
            g2.d("P4", "getToken errCode:" + i + ",errMsg:" + str);
            g2.d("con_err_code", "P4");
            if (this.b == 2) {
                n90 g3 = m90.h(this.a).g(601110);
                g3.c("flow_end_time", System.currentTimeMillis());
                g3.d("P5", "token request count is max:" + this.b);
                g3.d("con_err_code", "P5");
                g3.e();
                this.b = -1;
                e.a = -1;
                j();
                return;
            }
            o();
        }
    }

    public void d(Context context, String str, String str2, int i, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            if (e.a != -2 && e.a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    o90.h(context).f();
                }
                e(context, str, str2, i, str3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("LCP start connect, SocketConnect state is ");
            if (e.a == 0) {
                str4 = "connected";
            } else {
                str4 = "connecting";
            }
            sb.append(str4);
            ua0.a("LCPClientManager", sb.toString());
        }
    }

    public synchronized void e(Context context, String str, String str2, int i, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                    if (e.a != -2 && e.a != 0) {
                        e.a = -2;
                        ua0.a("LCPClientManager", "LCP start connectImpl, SocketConnect state change unConnect to connecting");
                        this.a = context.getApplicationContext();
                        va0.p(context, str);
                        va0.r(context, str2);
                        r90.m(context, i);
                        ea0.V(context).addObserver(g);
                        j();
                        if (this.c == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                            b bVar = new b(this, null);
                            this.c = bVar;
                            context.registerReceiver(bVar, intentFilter);
                        }
                        if (r90.f(context)) {
                            if (!o90.i(String.valueOf(601110)).booleanValue()) {
                                o90.h(context).e(context, String.valueOf(601110), 10);
                            }
                            if (!o90.i(String.valueOf(601111)).booleanValue()) {
                                o90.h(context).e(context, String.valueOf(601111), 10);
                            }
                        }
                        n90 b2 = m90.h(context).b(601110);
                        b2.c("flow_start_time", System.currentTimeMillis());
                        b2.d("source", str3);
                        if (!va0.k(context)) {
                            if (this.b == -1) {
                                ua0.a("LCPClientManager", "no local token and tokenRequestCount is -1, start request token flow");
                                m90.h(context).b(601110).c("token_begin", System.currentTimeMillis());
                                o();
                            } else {
                                this.b = -1;
                                e.a = -1;
                                ua0.a("LCPClientManager", "no local token and tokenRequestCount not -1, request token flow exception");
                                n90 g2 = m90.h(context).g(601110);
                                g2.c("flow_end_time", System.currentTimeMillis());
                                g2.d("P6", "token request count exception");
                                g2.d("con_err_code", "P6");
                                g2.e();
                                f(str3);
                            }
                        } else {
                            ua0.b("LCPClientManager", "token is not null, use local token");
                            m(0);
                        }
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("LCP start connectImpl, SocketConnect state is ");
                    if (e.a == 0) {
                        str4 = "connected";
                    } else {
                        str4 = "connecting";
                    }
                    sb.append(str4);
                    ua0.a("LCPClientManager", sb.toString());
                    return;
                }
                ua0.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                n90 b3 = m90.h(context).b(601110);
                b3.c("flow_start_time", System.currentTimeMillis());
                b3.d("P0", "connect param not correct or net unconnected");
                b3.d("con_err_code", "P0");
                b3.c("flow_end_time", System.currentTimeMillis());
                b3.b("connect_state", -1);
                b3.d("source", str3);
                b3.e();
            }
        }
    }

    public void f(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("LCP start connectInner, SocketConnect state is ");
            if (e.a == 0) {
                str2 = "connected";
            } else {
                str2 = "connecting";
            }
            sb.append(str2);
            ua0.a("LCPClientManager", sb.toString());
            Context context = this.a;
            d(context, va0.b(context), va0.e(this.a), r90.c(this.a), str);
        }
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || this.a == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                ua0.a("LCPClientManager", "socketAction closeSocket");
                ea0.V(this.a).o0("socketAction closeSocket:", ea0.V(this.a).C);
                return;
            }
            return;
        }
        ua0.a("LCPClientManager", "socketAction createSocket");
        n90 g2 = m90.h(this.a).g(601110);
        g2.d("P8", "socketAction createSocket");
        g2.d("con_err_code", "P8");
        ea0.V(this.a).n0();
    }

    public void i(@NonNull BLCPRequest bLCPRequest, @Nullable z90 z90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bLCPRequest, z90Var) == null) {
            if (this.a == null) {
                if (z90Var != null) {
                    if (z90Var instanceof x90) {
                        x90.a aVar = new x90.a();
                        long j = bLCPRequest.a;
                        aVar.a = bLCPRequest.b;
                        aVar.b = bLCPRequest.d;
                        aVar.c = new byte[0];
                        aVar.d.add(new w90(w90.a(false), System.currentTimeMillis()));
                        ((x90) z90Var).onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", aVar);
                        return;
                    }
                    z90Var.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                }
            } else if (e.a != 0) {
                if (!(bLCPRequest instanceof y90)) {
                    if (z90Var != null) {
                        if (z90Var instanceof x90) {
                            x90.a aVar2 = new x90.a();
                            long j2 = bLCPRequest.a;
                            aVar2.a = bLCPRequest.b;
                            aVar2.b = bLCPRequest.d;
                            aVar2.c = new byte[0];
                            aVar2.d.add(new w90(w90.a(false), System.currentTimeMillis()));
                            ((x90) z90Var).onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", aVar2);
                        } else {
                            z90Var.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                        }
                    }
                } else {
                    ea0.V(this.a).K(bLCPRequest, z90Var);
                }
                if (e.a == -1 || !n()) {
                    f(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST);
                }
            } else {
                ea0.V(this.a).K(bLCPRequest, z90Var);
                if (bLCPRequest.b == 1 && bLCPRequest.a == 4) {
                    ua0.a("LCPClientManager", "云控登录打点");
                    Context context = this.a;
                    sa0.a(context, 1L, DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, bLCPRequest.d + "");
                }
                if (bLCPRequest.b == 50 && bLCPRequest.a == 2) {
                    Context context2 = this.a;
                    sa0.a(context2, 50L, DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, bLCPRequest.d + "");
                }
            }
        }
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.a = context.getApplicationContext();
        }
    }

    public void o() {
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Context context = this.a;
            if (context != null && RequsetNetworkUtils.isConnected(context)) {
                int i = this.b + 1;
                this.b = i;
                f = i;
                m90.h(this.a).g(601110).b("token_count", this.b);
                ua0.a("LCPClientManager", "no token, so request token, and tryCount = " + this.b);
                if (this.b < 3) {
                    this.d = System.currentTimeMillis();
                    oa0 oa0Var = new oa0(this.a, this, this.b);
                    pa0.d().e(oa0Var, oa0Var);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.a);
            sb.append(", net :");
            Context context2 = this.a;
            if (context2 == null) {
                valueOf = "";
            } else {
                valueOf = Boolean.valueOf(!RequsetNetworkUtils.isConnected(context2));
            }
            sb.append(valueOf);
            ua0.a("LCPClientManager", sb.toString());
            this.b = -1;
            e.a = -1;
            j();
            n90 g2 = m90.h(this.a).g(601110);
            g2.d("P1", "token request net unconnected");
            g2.d("con_err_code", "P1");
            g2.c("flow_end_time", System.currentTimeMillis());
            g2.b("connect_state", -1);
            g2.e();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, observable, obj) == null) && (obj instanceof u90)) {
            e.a = ((u90) obj).a;
            ua0.a("LCPClientManager", "Manager update connectState :" + e.a);
        }
    }
}
