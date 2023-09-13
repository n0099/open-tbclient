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
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.a90;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.u90;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes8.dex */
public class y80 implements u90.a, Observer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x80 e;
    public static int f;
    public static volatile y80 g;
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
        public final /* synthetic */ y80 this$0;

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

        public b(y80 y80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = y80Var;
        }

        public /* synthetic */ b(y80 y80Var, a aVar) {
            this(y80Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (z90.a) {
                    aa0.a("LCPClientManager", "NetStatusReceiver changed");
                }
                if (RequsetNetworkUtils.isNetworkAvailable(context) && y80.e.a == -1) {
                    if (z90.a) {
                        aa0.b("LCPClientManager", "NetStatusReceiver, current net status is available, LCP reconnect start");
                    }
                    x90.a(context).b(new a(this));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283896, "Lcom/baidu/tieba/y80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283896, "Lcom/baidu/tieba/y80;");
                return;
            }
        }
        e = new x80();
        new LinkedHashMap();
        f = -1;
    }

    public y80() {
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

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return i90.Z(this.a).c0();
        }
        return (String) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", e.a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && RequsetNetworkUtils.isConnected(this.a)) {
            i90.Z(this.a).p0();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Context context = this.a;
            if (context == null || i90.Z(context).d0().a != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static synchronized y80 g() {
        InterceptResult invokeV;
        y80 y80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (y80.class) {
                if (g == null) {
                    synchronized (y80.class) {
                        if (g == null) {
                            g = new y80();
                        }
                    }
                }
                y80Var = g;
            }
            return y80Var;
        }
        return (y80) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u90.a
    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            if (f != i) {
                if (z90.a) {
                    aa0.b("LCPClientManager", "getToken success, but requestMark not equal, sTokenRequestMark is " + f + " mark is " + i);
                    return;
                }
                return;
            }
            if (z90.a) {
                aa0.b("LCPClientManager", "getToken success, cost: " + (System.currentTimeMillis() - this.d) + "ms");
            }
            r80 g2 = q80.h(this.a).g(601110);
            g2.d("P3", "accessToken success");
            g2.d("con_err_code", "P3");
            this.b = -1;
            o(0);
        }
    }

    @Override // com.baidu.tieba.u90.a
    public void b(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            if (f != i2) {
                if (z90.a) {
                    aa0.b("LCPClientManager", "getToken onFailure, but requestMark not equal, sTokenRequestMark is " + f + " mark is " + i2);
                    return;
                }
                return;
            }
            if (z90.a) {
                aa0.b("LCPClientManager", "getToken failure:" + str + "\r\n + cost: " + (System.currentTimeMillis() - this.d) + "ms");
            }
            r80 g2 = q80.h(this.a).g(601110);
            g2.d("P4", "getToken errCode:" + i + ",errMsg:" + str);
            g2.d("con_err_code", "P4");
            if (this.b == 2) {
                r80 g3 = q80.h(this.a).g(601110);
                g3.c("flow_end_time", System.currentTimeMillis());
                g3.d("P5", "token request count is max:" + this.b);
                g3.d("con_err_code", "P5");
                g3.e();
                this.b = -1;
                e.a = -1;
                l();
                return;
            }
            q();
        }
    }

    public void d(Context context, String str, String str2, int i, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            if (e.a != -2 && e.a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    s80.h(context).f();
                }
                e(context, str, str2, i, str3);
            } else if (z90.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("LCP start connect, SocketConnect state is ");
                if (e.a == 0) {
                    str4 = "connected";
                } else {
                    str4 = "connecting";
                }
                sb.append(str4);
                aa0.a("LCPClientManager", sb.toString());
            }
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
                        if (z90.a) {
                            aa0.a("LCPClientManager", "LCP start connectImpl, SocketConnect state change unConnect to connecting");
                        }
                        this.a = context.getApplicationContext();
                        ba0.y(context, str);
                        ba0.A(context, str2);
                        u80.k(context, i);
                        u80.c(context);
                        u80.b(context);
                        i90.Z(context).addObserver(g);
                        l();
                        if (this.c == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                            b bVar = new b(this, null);
                            this.c = bVar;
                            this.a.registerReceiver(bVar, intentFilter);
                        }
                        if (u80.f(context)) {
                            if (!s80.i(String.valueOf(601110)).booleanValue()) {
                                s80.h(context).e(context, String.valueOf(601110), 10);
                            }
                            if (!s80.i(String.valueOf(601111)).booleanValue()) {
                                s80.h(context).e(context, String.valueOf(601111), 10);
                            }
                            if (!s80.i(String.valueOf(601112)).booleanValue()) {
                                s80.h(context).e(context, String.valueOf(601112), 10);
                            }
                        }
                        r80 b2 = q80.h(context).b(601110);
                        b2.c("flow_start_time", System.currentTimeMillis());
                        b2.d("source", str3);
                        if (!ba0.r(context)) {
                            if (this.b == -1) {
                                if (z90.a) {
                                    aa0.a("LCPClientManager", "no local token and tokenRequestCount is -1, start request token flow");
                                }
                                q80.h(context).b(601110).c("token_begin", System.currentTimeMillis());
                                q();
                            } else {
                                this.b = -1;
                                e.a = -1;
                                if (z90.a) {
                                    aa0.a("LCPClientManager", "no local token and tokenRequestCount not -1, request token flow exception");
                                }
                                r80 g2 = q80.h(context).g(601110);
                                g2.c("flow_end_time", System.currentTimeMillis());
                                g2.d("P6", "token request count exception");
                                g2.d("con_err_code", "P6");
                                g2.e();
                                f(str3);
                            }
                        } else {
                            if (z90.a) {
                                aa0.b("LCPClientManager", "token is not null, use local token");
                            }
                            o(0);
                            e90.f(context);
                        }
                        return;
                    }
                    if (z90.a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("LCP start connectImpl, SocketConnect state is ");
                        if (e.a == 0) {
                            str4 = "connected";
                        } else {
                            str4 = "connecting";
                        }
                        sb.append(str4);
                        aa0.a("LCPClientManager", sb.toString());
                    }
                    return;
                }
                if (z90.a) {
                    aa0.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                }
                r80 b3 = q80.h(context).b(601110);
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
            if (z90.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("LCP start connectInner, SocketConnect state is ");
                if (e.a == 0) {
                    str2 = "connected";
                } else {
                    str2 = "connecting";
                }
                sb.append(str2);
                aa0.a("LCPClientManager", sb.toString());
            }
            Context context = this.a;
            d(context, ba0.b(context), ba0.e(this.a), u80.d(this.a), str);
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || this.a == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                if (z90.a) {
                    aa0.a("LCPClientManager", "socketAction closeSocket");
                }
                i90.Z(this.a).x0("socketAction closeSocket:", i90.Z(this.a).D);
                return;
            }
            return;
        }
        if (z90.a) {
            aa0.a("LCPClientManager", "socketAction createSocket");
        }
        r80 g2 = q80.h(this.a).g(601110);
        g2.d("P8", "socketAction createSocket");
        g2.d("con_err_code", "P8");
        i90.Z(this.a).w0();
    }

    public void j(@NonNull BLCPRequest bLCPRequest, @Nullable c90 c90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bLCPRequest, c90Var) == null) {
            if (this.a == null) {
                if (c90Var != null) {
                    if (c90Var instanceof a90) {
                        a90.a aVar = new a90.a();
                        long j = bLCPRequest.a;
                        aVar.a = bLCPRequest.b;
                        aVar.b = bLCPRequest.d;
                        aVar.c = new byte[0];
                        aVar.d.add(new z80(z80.a(false), System.currentTimeMillis()));
                        ((a90) c90Var).onResponse(8008, "param exception :", aVar);
                    } else {
                        c90Var.onResponse(8008, "param exception :", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                    }
                    k(bLCPRequest, 8008, "param exception :");
                }
            } else if (e.a != 0) {
                if (!(bLCPRequest instanceof b90)) {
                    if (c90Var != null) {
                        if (c90Var instanceof a90) {
                            a90.a aVar2 = new a90.a();
                            long j2 = bLCPRequest.a;
                            aVar2.a = bLCPRequest.b;
                            aVar2.b = bLCPRequest.d;
                            aVar2.c = new byte[0];
                            aVar2.d.add(new z80(z80.a(false), System.currentTimeMillis()));
                            ((a90) c90Var).onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", aVar2);
                        } else {
                            c90Var.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                        }
                        k(bLCPRequest, ResponseCode.LCP_STATE_CONNECTING, "unconnected");
                    }
                } else {
                    i90.Z(this.a).O(bLCPRequest, c90Var);
                }
                if (e.a == -1 || !p()) {
                    f(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST);
                }
            } else {
                i90.Z(this.a).O(bLCPRequest, c90Var);
            }
        }
    }

    public final void k(BLCPRequest bLCPRequest, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, bLCPRequest, i, str) == null) {
            r80 b2 = q80.h(this.a).b(601111);
            b2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, bLCPRequest.d);
            b2.c("service_id", bLCPRequest.a);
            b2.c("method_id", bLCPRequest.b);
            b2.b("error_code", i);
            b2.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str);
            b2.c("request_time", System.currentTimeMillis());
            b2.c("response_time", System.currentTimeMillis());
            b2.d("ext", "");
            b2.d(ProbeTB.PROTOCOL, "");
            b2.d("ip", "");
            b2.d("domain", "");
            b2.d(ClientCookie.PORT_ATTR, "");
            b2.d("server_info", "");
            b2.e();
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            this.a = context.getApplicationContext();
        }
    }

    public void q() {
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Context context = this.a;
            if (context != null && RequsetNetworkUtils.isConnected(context)) {
                int i = this.b + 1;
                this.b = i;
                f = i;
                q80.h(this.a).g(601110).b("token_count", this.b);
                if (z90.a) {
                    aa0.a("LCPClientManager", "no token, so request token, and tryCount = " + this.b);
                }
                if (this.b < 3) {
                    this.d = System.currentTimeMillis();
                    u90 u90Var = new u90(this.a, this, this.b);
                    v90.d().e(u90Var, u90Var);
                    return;
                }
                return;
            }
            if (z90.a) {
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
                aa0.a("LCPClientManager", sb.toString());
            }
            this.b = -1;
            e.a = -1;
            l();
            r80 g2 = q80.h(this.a).g(601110);
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
        if ((interceptable == null || interceptable.invokeLL(1048592, this, observable, obj) == null) && (obj instanceof x80)) {
            e.a = ((x80) obj).a;
            if (z90.a) {
                aa0.a("LCPClientManager", "Manager update connectState :" + e.a);
            }
        }
    }
}
