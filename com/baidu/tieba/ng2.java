package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestCallback;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ng2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile ng2 i;
    public static final Map<String, p02> j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<String> a;
    public List<String> b;
    public Map<String, JSONObject> c;
    @Nullable
    public Map<String, String> d;
    public Map<String, String> e;
    public boolean f;
    public AtomicInteger g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ng2 c;

        public a(ng2 ng2Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ng2Var;
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Set<String> g = vb3.g(this.a);
                if (ng2.h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("startPreLink appId=");
                    sb.append(this.a);
                    sb.append(" preLinkSet=");
                    if (g == null) {
                        size = 0;
                    } else {
                        size = g.size();
                    }
                    sb.append(size);
                    sb.append(", hotLaunch=");
                    sb.append(this.b);
                    Log.d("SwanPrelink", sb.toString());
                }
                if (g == null || g.isEmpty()) {
                    this.c.z("校验失败", "请在开发者后台配置 prelink");
                    return;
                }
                this.c.u(true);
                this.c.a.clear();
                this.c.g.set(0);
                ng2.j.clear();
                this.c.b = new ArrayList(g);
                int i = 0;
                for (String str : g) {
                    if (!TextUtils.isEmpty(str)) {
                        if (i < 5) {
                            String e = s02.e(str);
                            if (!TextUtils.isEmpty(e)) {
                                this.c.a.add(e);
                                this.c.j(this.a, i, str, e, true);
                                i++;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ng2 e;

        public b(ng2 ng2Var, String str, long j, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var, str, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng2Var;
            this.a = str;
            this.b = j;
            this.c = z;
            this.d = i;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback, com.baidu.tieba.mk4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && ng2.h) {
                Log.w("SwanPrelink", "doPrelink: onFail: " + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) && ng2.h) {
                Log.i("SwanPrelink", "doPrelink: onSuccess: " + i);
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            int i2;
            Object valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                if (ng2.h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("doPrelink: parseResponse: url: ");
                    sb.append(this.a);
                    sb.append(" response: ");
                    if (response == null) {
                        valueOf = StringUtil.NULL_STRING;
                    } else {
                        valueOf = Integer.valueOf(response.code());
                    }
                    sb.append(valueOf);
                    Log.i("SwanPrelink", sb.toString());
                }
                this.e.t(this.b, System.currentTimeMillis(), this.a, networkStatRecord);
                if (networkStatRecord != null) {
                    long j = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                    long j2 = networkStatRecord.connTs - networkStatRecord.startTs;
                    if (ng2.h) {
                        Log.d("SwanPrelink", "doPrelink: hit: url: " + this.a);
                        Log.d("SwanPrelink", "doPrelink: isConnReused: " + networkStatRecord.isConnReused);
                        Log.d("SwanPrelink", "doPrelink: dnsTime: " + j + " connTime: " + j2);
                    }
                    if (response != null) {
                        i2 = response.code();
                    } else {
                        i2 = 0;
                    }
                    if (this.c) {
                        ng2 ng2Var = this.e;
                        int i3 = this.d;
                        ng2Var.y(i3, "预连接请求返回", "code=" + i2 + " dns解析时长=" + j + "ms 网络连接时长=" + j2 + "ms url=" + this.a);
                    }
                }
                this.e.u(false);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements NetRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ng2 e;

        public c(ng2 ng2Var, long j, String str, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var, Long.valueOf(j), str, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng2Var;
            this.a = j;
            this.b = str;
            this.c = z;
            this.d = i;
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onFailed(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (this.c) {
                    ng2 ng2Var = this.e;
                    int i2 = this.d;
                    ng2Var.y(i2, "预连接请求返回", "code=" + i + " msg=" + str);
                }
                this.e.u(false);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onSucceeded(String str, int i, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, map) == null) {
                this.e.t(this.a, System.currentTimeMillis(), this.b, null);
                if (this.c) {
                    ng2 ng2Var = this.e;
                    int i2 = this.d;
                    ng2Var.y(i2, "预连接请求返回", "code=" + i + " url=" + this.b);
                }
                this.e.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948001424, "Lcom/baidu/tieba/ng2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948001424, "Lcom/baidu/tieba/ng2;");
                return;
            }
        }
        h = nr1.a;
        i = null;
        j = new ConcurrentHashMap();
    }

    public static ng2 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (i == null) {
                synchronized (ng2.class) {
                    if (i == null) {
                        i = new ng2();
                    }
                }
            }
            return i;
        }
        return (ng2) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return !this.a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Map<String, String> map = this.d;
            if (map != null && !map.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                if (h) {
                    Log.d("SwanPrelink", "release");
                }
                if (i == null) {
                    return;
                }
                i = null;
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !h) {
            return;
        }
        this.a.clear();
        j.clear();
        this.d = null;
    }

    public ng2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Collections.synchronizedList(new ArrayList());
        this.c = new HashMap();
        this.e = new LinkedHashMap();
        this.f = false;
        this.g = new AtomicInteger(0);
    }

    public static void D(String str, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            p02 p02Var = j.get(str);
            if (p02Var == null) {
                p02Var = new p02();
            }
            if (j2 > 0) {
                p02Var.a = j2;
            }
            if (j3 > 0) {
                p02Var.b = j3;
            }
            if (j4 > 0) {
                p02Var.c = j4;
            }
            j.put(str, p02Var);
        }
    }

    public synchronized void z(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                y(-1, str, str2);
            }
        }
    }

    public long l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            p02 p02Var = j.get(str);
            if (p02Var != null) {
                return p02Var.a;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public final void u(boolean z) {
        HybridUbcFlow d;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (d = i43.d("startup")) != null) {
            if (z) {
                str = "prelink_request_start";
            } else {
                str = "prelink_request_end";
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(str);
            ubcFlowEvent.h(System.currentTimeMillis());
            d.F(ubcFlowEvent);
        }
    }

    @NonNull
    public final synchronized String A() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("========== prelink start ==========");
                sb2.append("\r\n");
                for (Map.Entry<String, String> entry : this.e.entrySet()) {
                    if (entry != null) {
                        sb2.append("----- ");
                        sb2.append(entry.getKey());
                        sb2.append(": ");
                        sb2.append(entry.getValue());
                        sb2.append("\r\n\r\n");
                    }
                }
                sb2.append("========== prelink end ==========");
                sb2.append("\r\n");
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public void B(@NonNull String str, @NonNull String str2, @NonNull NetInfo netInfo) {
        HybridUbcFlow d;
        long currentTimeMillis;
        NetInfo.SwanExtra.Timing timing;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, netInfo) != null) || !n() || this.d == null || this.g.get() == this.a.size() || !this.d.containsValue(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        sb.append("url=");
        sb.append(str2);
        sb.append("; ");
        if (netInfo.getSocket() != null) {
            z = netInfo.getSocket().mReused;
            sb.append("连接是否复用=");
            sb.append(netInfo.getSocket().mReused);
            sb.append("; ");
        }
        NetInfo.Timing timing2 = netInfo.getTiming();
        if (timing2 != null) {
            sb.append("DNS耗时=");
            sb.append(timing2.mDns / 1000);
            sb.append("ms; ");
            sb.append("连接耗时=");
            sb.append(timing2.mConnect / 1000);
            sb.append("ms; ");
        }
        y(this.g.incrementAndGet() - 1, "业务方第一个同域名请求返回", sb.toString());
        if (this.g.get() == 1 && (d = i43.d("startup")) != null && timing2 != null) {
            long j2 = 0;
            p02 remove = j.remove(str);
            if (remove != null) {
                j2 = remove.a;
            }
            NetInfo.SwanExtra swanExtra = netInfo.getSwanExtra();
            if (swanExtra != null && (timing = swanExtra.mTiming) != null) {
                currentTimeMillis = timing.mConnectTime + j2;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
            ubcFlowEvent.h(j2);
            d.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
            ubcFlowEvent2.h((timing2.mConnect / 1000) + j2);
            d.F(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
            ubcFlowEvent3.h(j2);
            d.F(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
            ubcFlowEvent4.h((timing2.mDns / 1000) + j2);
            d.F(ubcFlowEvent4);
            UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
            ubcFlowEvent5.h(currentTimeMillis);
            d.F(ubcFlowEvent5);
            if (remove != null) {
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_interpret_start");
                ubcFlowEvent6.h(remove.b);
                d.F(ubcFlowEvent6);
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_interpret_end");
                ubcFlowEvent7.h(remove.c);
                d.F(ubcFlowEvent7);
            }
            d.D("connResued", String.valueOf(z));
        }
    }

    public void C(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, httpUrl, networkStatRecord) == null) && n() && networkStatRecord != null && this.d != null && this.g.get() != this.a.size()) {
            synchronized (ng2.class) {
                if (!this.d.containsValue(str)) {
                    return;
                }
                this.g.incrementAndGet();
                long j3 = networkStatRecord.dnsEndTs;
                long j4 = networkStatRecord.dnsStartTs;
                long j5 = networkStatRecord.connTs;
                long j6 = networkStatRecord.startTs;
                long j7 = j3 - j4;
                long j8 = (j5 - j6) - j7;
                if (h) {
                    j2 = j3;
                    Log.i("SwanPrelink", "tryRecordNetworkStat: " + httpUrl);
                    Log.i("SwanPrelink", "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused);
                    Log.i("SwanPrelink", "tryRecordNetworkStat: dnsTime: " + j7 + " connTime: " + j8);
                } else {
                    j2 = j3;
                }
                y(this.g.get() - 1, "业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j7 + "ms 网络连接时长=" + j8 + "ms url=" + httpUrl);
                if (this.g.get() <= 1) {
                    HybridUbcFlow p = i43.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
                    ubcFlowEvent.h(j6);
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
                    ubcFlowEvent2.h(j5);
                    p.F(ubcFlowEvent2);
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
                    ubcFlowEvent3.h(j4);
                    p.F(ubcFlowEvent3);
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
                    ubcFlowEvent4.h(j2);
                    p.F(ubcFlowEvent4);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
                    ubcFlowEvent5.h(networkStatRecord.responseTs);
                    p.F(ubcFlowEvent5);
                    UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_send_header");
                    ubcFlowEvent6.h(networkStatRecord.sendHeaderTs);
                    p.F(ubcFlowEvent6);
                    UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_receive_header");
                    ubcFlowEvent7.h(networkStatRecord.receiveHeaderTs);
                    p.F(ubcFlowEvent7);
                    p.D("connResued", String.valueOf(networkStatRecord.isConnReused));
                }
            }
        }
    }

    public boolean i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !o()) {
                if (h) {
                    Log.d("SwanPrelink", "contains preLink request: " + this.d.containsValue(str));
                }
                return this.d.containsValue(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public final void j(String str, int i2, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Boolean.valueOf(z)}) == null) {
            if (h) {
                Log.d("SwanPrelink", "doPrelink: " + str2);
            }
            if (!mg2.b(null, str, str2)) {
                if (z) {
                    y(i2, "预取阶段已连接", "url=" + str2 + " 不需要再次prelink");
                }
                if (h) {
                    Log.d("SwanPrelink", "预取阶段已连接:, 不需要再连接，url = " + str2);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            mg2.d(str, str2);
            if (n02.d()) {
                p(i2, str2, str3, z);
                return;
            }
            gi4 gi4Var = new gi4();
            gi4Var.b = "HEAD";
            HttpRequestBuilder a2 = ii4.a(gi4Var);
            a2.setHeader("Referer", s02.d());
            gi4Var.a = str2;
            gi4Var.f = true;
            gi4Var.g = false;
            gi4Var.h = true;
            hi4.g().u(a2, gi4Var);
            HttpRequest build = a2.enableStat(true).build();
            if (z) {
                y(i2, "校验通过", "开始向 url=" + str2 + " 发送预连接 HEAD 请求");
            }
            build.executeStat(new b(this, str2, currentTimeMillis, z, i2));
        }
    }

    public Set<String> m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptySet();
            }
            Set<String> g = vb3.g(str);
            if (g == null) {
                return Collections.emptySet();
            }
            if (g.size() > 5 && z) {
                int i2 = 0;
                HashSet hashSet = new HashSet(5);
                for (String str2 : g) {
                    if (!TextUtils.isEmpty(str2)) {
                        int i3 = i2 + 1;
                        if (i2 >= 5) {
                            break;
                        }
                        hashSet.add(str2);
                        i2 = i3;
                    }
                }
                return hashSet;
            }
            return g;
        }
        return (Set) invokeLZ.objValue;
    }

    @AnyThread
    public synchronized void x(@Nullable String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    if (h) {
                        Log.w("SwanPrelink", "startPreLink appId empty");
                    }
                } else if (!z && this.f) {
                    if (h) {
                        Log.d("SwanPrelink", "startPreLink already");
                    }
                } else {
                    this.c.clear();
                    this.f = true;
                    ExecutorUtilsExt.postOnElastic(new a(this, str, z), "SwanPrelink", 0);
                }
            }
        }
    }

    public final void p(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            zc2 W = xh2.U().W();
            if (W != null && (W.d() instanceof li2)) {
                NetRequestParam.Builder builder = new NetRequestParam.Builder();
                builder.setUrl(str);
                builder.setMethod((byte) 2);
                NetRequestParam build = builder.build();
                build.setNetRequestCallback(new c(this, currentTimeMillis, str, z, i2));
                li2 li2Var = (li2) W.d();
                if (li2Var.m0() != null) {
                    if (z) {
                        y(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
                    }
                    li2Var.m0().execute(build);
                }
            }
        }
    }

    public synchronized void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            synchronized (this) {
                if (!n()) {
                    return;
                }
                if (this.g.get() == this.a.size()) {
                    if (h) {
                        Log.d("SwanPrelink", "onBusinessRequest doRequest: " + str2);
                    }
                } else if (this.b != null && this.b.contains(str2)) {
                } else {
                    String e = s02.e(str2);
                    if (e != null && this.a.contains(e)) {
                        if (this.d == null) {
                            this.d = new ArrayMap();
                        } else if (this.d.containsKey(e)) {
                            return;
                        }
                        this.d.put(e, str);
                        if (h) {
                            Log.i("SwanPrelink", "onBusinessRequest hit: " + str2);
                        }
                        y(this.d.size() - 1, "业务方触发第一个同域名请求", "url=" + str2);
                        return;
                    }
                    if (h) {
                        Log.d("SwanPrelink", "onBusinessRequest: miss tag " + str2);
                    }
                }
            }
        }
    }

    public synchronized void r(@NonNull String str, @NonNull HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, httpUrl) == null) {
            synchronized (this) {
                if (!n()) {
                    return;
                }
                if (this.g.get() == this.a.size()) {
                    if (h) {
                        Log.d("SwanPrelink", "onBusinessRequest doRequest: " + httpUrl);
                    }
                    return;
                }
                String host = httpUrl.host();
                if (host != null && this.a.contains(host)) {
                    if (this.d == null) {
                        this.d = new ArrayMap();
                    } else if (this.d.containsKey(host)) {
                        return;
                    }
                    this.d.put(host, str);
                    if (h) {
                        Log.i("SwanPrelink", "onBusinessRequest hit: " + httpUrl);
                    }
                    y(this.d.size() - 1, "业务方触发第一个同域名请求", "url=" + httpUrl);
                    return;
                }
                if (h) {
                    Log.d("SwanPrelink", "onBusinessRequest: miss tag " + httpUrl.toString());
                }
            }
        }
    }

    @WorkerThread
    public void s(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                if (h) {
                    Log.w("SwanPrelink", "prelink url is empty");
                    return;
                }
                return;
            }
            String e = s02.e(str2);
            if (!TextUtils.isEmpty(e)) {
                j(str, -1, str2, e, false);
            }
        }
    }

    public final synchronized void t(long j2, long j3, String str, NetworkStatRecord networkStatRecord) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, networkStatRecord}) == null) {
            synchronized (this) {
                if (this.f && !TextUtils.isEmpty(str)) {
                    db3 b0 = db3.b0();
                    if (b0 != null && !TextUtils.isEmpty(b0.W().V())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            if (networkStatRecord == null) {
                                str2 = "1";
                            } else {
                                str2 = "0";
                            }
                            jSONObject.put("na_request", str2);
                            jSONObject.put("start", j2);
                            jSONObject.put("end", j3);
                            if (networkStatRecord != null) {
                                jSONObject.put("net_type", networkStatRecord.netType);
                                jSONObject.put("start_connect", networkStatRecord.startTs);
                                jSONObject.put("start_dns", networkStatRecord.dnsStartTs);
                                jSONObject.put("end_dns", networkStatRecord.dnsEndTs);
                                jSONObject.put("on_connect", networkStatRecord.connTs);
                                jSONObject.put("send_header", networkStatRecord.sendHeaderTs);
                                jSONObject.put("recv_header", networkStatRecord.receiveHeaderTs);
                                jSONObject.put("response", networkStatRecord.responseTs);
                                jSONObject.put("response_finish", networkStatRecord.finishTs);
                            }
                            this.c.put(str, jSONObject);
                        } catch (JSONException e) {
                            if (h) {
                                e.printStackTrace();
                            }
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : this.c.keySet()) {
                            jSONArray.put(this.c.get(str3));
                        }
                        i43.p("startup").D("prelinks", jSONArray.toString());
                        if (h) {
                            Log.d("SwanPrelink", "in start app process, real prelink url - " + str);
                        }
                    }
                }
            }
        }
    }

    public synchronized void y(@IntRange(from = -1) int i2, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048594, this, i2, str, str2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    str = PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT + str;
                }
                if (this.e.containsKey(str)) {
                    return;
                }
                this.e.put(str, str2);
                zm3.k.update((ym3<String>) A());
            }
        }
    }
}
