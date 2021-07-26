package com.bytedance.sdk.component.adnet.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes5.dex */
public class f implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static f f28028c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f28029a;

    /* renamed from: b  reason: collision with root package name */
    public long f28030b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28031d;

    /* renamed from: e  reason: collision with root package name */
    public Context f28032e;

    /* renamed from: f  reason: collision with root package name */
    public e f28033f;

    /* renamed from: g  reason: collision with root package name */
    public int f28034g;

    /* renamed from: h  reason: collision with root package name */
    public long f28035h;

    /* renamed from: i  reason: collision with root package name */
    public int f28036i;
    public HashMap<String, Integer> j;
    public HashMap<String, Integer> k;
    public int l;
    public HashMap<String, Integer> m;
    public HashMap<String, Integer> n;
    public boolean o;
    public Map<String, Integer> p;

    public f() {
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
        this.f28030b = 0L;
        this.f28031d = false;
        this.f28034g = 0;
        this.f28035h = TNCManager.TNC_DATA_VERSION_DEFAULT;
        this.f28036i = 0;
        this.j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = 0;
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = true;
        this.p = new HashMap();
        this.f28029a = new Handler(this, Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.adnet.c.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f28037a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f28037a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 10000) {
                    this.f28037a.a(message.arg1 != 0);
                }
            }
        };
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) ? i2 >= 200 && i2 < 400 : invokeI.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "resetTNCControlState");
            this.f28036i = 0;
            this.j.clear();
            this.k.clear();
            this.l = 0;
            this.m.clear();
            this.n.clear();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.p.clear();
        }
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.f28033f;
            if (eVar != null) {
                return eVar.c();
            }
            return null;
        }
        return (d) invokeV.objValue;
    }

    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d c2 = c();
            if (c2 != null) {
                return c2.f28018d;
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28033f : (e) invokeV.objValue;
    }

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (f.class) {
                if (f28028c == null) {
                    f28028c = new f();
                }
                fVar = f28028c;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    private void b(String str) {
        Map<String, String> d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, str) == null) || TextUtils.isEmpty(str) || (d2 = d()) == null || !d2.containsValue(str)) {
            return;
        }
        if (this.p.get(str) == null) {
            this.p.put(str, 1);
        } else {
            this.p.put(str, Integer.valueOf(this.p.get(str).intValue() + 1));
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, str) == null) && !TextUtils.isEmpty(str) && this.p.containsKey(str)) {
            this.p.put(str, 0);
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            Map<String, String> d2 = d();
            if (d2 == null) {
                return false;
            }
            String str2 = d2.get(str);
            if (TextUtils.isEmpty(str2) || this.p.get(str2) == null || this.p.get(str2).intValue() < 3) {
                return false;
            }
            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleHostMapping, TNC host faild num over limit: " + str);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
                String str3 = null;
                try {
                    URL url = new URL(str);
                    str2 = url.getProtocol();
                    try {
                        str3 = url.getHost();
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (!TextUtils.isEmpty(str2)) {
                            if (!d(str3)) {
                            }
                        }
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2) && (("http".equals(str2) || "https".equals(str2)) && !TextUtils.isEmpty(str3))) {
                    if (!d(str3)) {
                        com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleHostMapping, TNC host faild num over limit: " + str3);
                        return str;
                    }
                    Map<String, String> d2 = d();
                    if (d2 != null && d2.containsKey(str3)) {
                        String str4 = d2.get(str3);
                        if (TextUtils.isEmpty(str4)) {
                            return str;
                        }
                        com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleHostMapping, match, origin: " + str);
                        String str5 = str2 + "://" + str3;
                        String str6 = str2 + "://" + str4;
                        if (str.startsWith(str5)) {
                            str = str.replaceFirst(str5, str6);
                        }
                        com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleHostMapping, target: " + str);
                        return str;
                    }
                    com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleHostMapping, nomatch: " + str3);
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            if (i2 < 100 || i2 >= 1000) {
                return true;
            }
            d c2 = c();
            if (c2 == null || TextUtils.isEmpty(c2.m)) {
                return false;
            }
            String str = c2.m;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
            return str.contains(sb.toString());
        }
        return invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.component.adnet.c.c
    public synchronized void a(Request request, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, mVar) == null) {
            synchronized (this) {
                if (request == null || mVar == null) {
                    return;
                }
                if (this.o) {
                    if (com.bytedance.sdk.component.adnet.d.e.a(this.f28032e)) {
                        URL url = null;
                        try {
                            url = new URL(request.getUrl());
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String ipAddrStr = request.getIpAddrStr();
                        int i2 = (int) mVar.f28136h;
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            if (TextUtils.isEmpty(ipAddrStr)) {
                                return;
                            }
                            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "onResponse, url: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                            d c2 = c();
                            if (c2 != null && c2.f28016b) {
                                a(mVar, host);
                            }
                            if (c2 == null) {
                                return;
                            }
                            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "onResponse, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2 + " " + this.f28036i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                            if (i2 > 0) {
                                if (a(i2)) {
                                    if (this.f28036i > 0 || this.l > 0) {
                                        f();
                                    }
                                    c(host);
                                } else if (!b(i2)) {
                                    this.l++;
                                    this.m.put(path, 0);
                                    this.n.put(ipAddrStr, 0);
                                    if (this.l >= c2.f28022h && this.m.size() >= c2.f28023i && this.n.size() >= c2.j) {
                                        com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "onResponse, url doUpdate: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                                        a(false, 0L);
                                        f();
                                    }
                                    b(host);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.c.c
    public synchronized void a(Request request, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, request, exc) == null) {
            synchronized (this) {
                if (request == null || exc == null) {
                    return;
                }
                if (this.o) {
                    if (com.bytedance.sdk.component.adnet.d.e.a(this.f28032e)) {
                        URL url = null;
                        try {
                            url = new URL(request.getUrl());
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String ipAddrStr = request.getIpAddrStr();
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            d c2 = c();
                            if (c2 == null) {
                                return;
                            }
                            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "onError, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "# " + this.f28036i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                            this.f28036i = this.f28036i + 1;
                            this.j.put(path, 0);
                            this.k.put(ipAddrStr, 0);
                            if (this.f28036i >= c2.f28019e && this.j.size() >= c2.f28020f && this.k.size() >= c2.f28021g) {
                                com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "onError, url doUpate: " + protocol + "://" + host + "#" + ipAddrStr);
                                a(false, 0L);
                                f();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(m mVar, String str) {
        int i2;
        long j;
        d c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, mVar, str) == null) && mVar != null && this.o) {
            String a2 = mVar.a(TNCManager.TNC_PROBE_HEADER, (String) null);
            if (TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] split = a2.split(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
            if (split != null && split.length == 2) {
                try {
                    i2 = Integer.parseInt(split[0]);
                } catch (Throwable th) {
                    th = th;
                    i2 = 0;
                }
                try {
                    j = Long.parseLong(split[1]);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, probeProto except, " + str);
                    j = 0L;
                    com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, local: " + this.f28034g + TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f28035h + " svr: " + i2 + TNCManager.TNC_PROBE_HEADER_SECEPTOR + j + " " + str);
                    if (j > this.f28035h) {
                    }
                }
                com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, local: " + this.f28034g + TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f28035h + " svr: " + i2 + TNCManager.TNC_PROBE_HEADER_SECEPTOR + j + " " + str);
                if (j > this.f28035h) {
                    return;
                }
                this.f28034g = i2;
                this.f28035h = j;
                this.f28032e.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putInt("tnc_probe_cmd", i2).putLong("tnc_probe_version", j).apply();
                if (this.f28034g != 10000 || (c2 = c()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i3 = c2.l;
                long nextInt = i3 > 0 ? random.nextInt(i3) * 1000 : 0L;
                com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, updateConfig delay: " + nextInt + " " + str);
                a(true, nextInt);
                return;
            }
            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "handleTncProbe, probeProto err, " + str);
        }
    }

    private void a(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || this.f28029a.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.f28029a.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.f28029a.sendMessageDelayed(obtainMessage, j);
        } else {
            this.f28029a.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        d c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) || (c2 = c()) == null) {
            return;
        }
        com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.f28030b + (c2.k * 1000) > elapsedRealtime) {
            com.bytedance.sdk.component.adnet.d.c.b(TNCManager.TAG, "doUpdateRemote, time limit");
            return;
        }
        this.f28030b = elapsedRealtime;
        com.bytedance.sdk.component.adnet.a.a.a(this.f28032e).b(com.bytedance.sdk.component.adnet.d.e.a(this.f28032e));
    }
}
