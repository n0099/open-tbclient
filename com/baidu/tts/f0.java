package com.baidu.tts;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.e2;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.TtsLogLoad;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long[] p;
    public static long q;
    public static boolean r;
    public static final ConcurrentHashMap<String, f0> s;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final ThreadPoolExecutor c;
    public h0 d;
    public int e;
    public int f;
    public String g;
    public String h;
    public boolean i;
    public long j;
    public long k;
    public int l;
    public int m;
    public long n;
    public long o;

    /* loaded from: classes9.dex */
    public interface b {
    }

    /* loaded from: classes9.dex */
    public class a implements Callable<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ f0 c;

        public a(f0 f0Var, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0Var, bArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f0Var;
            this.a = bArr;
            this.b = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.lang.Integer] */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int dataCollectStat = TtsLogLoad.getInstance().dataCollectStat(this.a, new e0(this), this.c.g);
                String str = this.c.a;
                LoggerProxy.d(str, "pid = " + this.c.g + " , result = " + dataCollectStat);
                return Integer.valueOf(dataCollectStat);
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722254343, "Lcom/baidu/tts/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722254343, "Lcom/baidu/tts/f0;");
                return;
            }
        }
        p = new long[1];
        s = new ConcurrentHashMap<>();
    }

    public f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = 0;
        this.i = true;
        this.a = w0.a("TtsStatsInterceptor", str);
        this.b = str;
        this.c = new c0(20, new x0(str, "bds-stats"), new ThreadPoolExecutor.AbortPolicy());
    }

    public static f0 a(String str) {
        InterceptResult invokeL;
        f0 f0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (f0.class) {
                ConcurrentHashMap<String, f0> concurrentHashMap = s;
                if (!concurrentHashMap.containsKey(str)) {
                    concurrentHashMap.put(str, new f0(str));
                }
                f0Var = concurrentHashMap.get(str);
            }
            return f0Var;
        }
        return (f0) invokeL.objValue;
    }

    public final g0 a(m0 m0Var, q1 q1Var, d dVar, d dVar2) {
        InterceptResult invokeLLLL;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, m0Var, q1Var, dVar, dVar2)) == null) {
            g0 g0Var = new g0();
            g0Var.o = System.currentTimeMillis();
            g0Var.i = Build.MODEL;
            g0Var.c = this.e;
            g0Var.a = 0;
            g0Var.d = m0Var.a;
            g0Var.g = q1Var.b.f;
            int i = e2.j;
            g0Var.b = e2.b.a.b.b;
            if (!w0.b(this.g)) {
                g0Var.e = Integer.parseInt(this.g);
            }
            u1 u1Var = q1Var.a;
            String str = "";
            if (u1Var == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(u1Var.k);
            }
            g0Var.l = valueOf;
            t1 t1Var = q1Var.b;
            if (t1Var != null) {
                str = t1Var.m;
            }
            if (!w0.b(str)) {
                g0Var.f = EmbeddedSynthesizerEngine.getSpeechInfo(str);
            }
            if (dVar != null) {
                g0Var.m = dVar.getDetailCode();
                g0Var.j = dVar.getDetailMessage();
            }
            if (dVar2 != null) {
                g0Var.k = dVar2.getDetailCode();
            }
            return g0Var;
        }
        return (g0) invokeLLLL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("etts_version", new JSONObject(EmbeddedSynthesizerEngine.bdTTSGetEngineParam()).optString("version", ""));
                jSONObject.put("appid", this.h);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            TtsLogLoad.getInstance().setLogHeadSring(jSONObject.toString(), i, q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:6:0x000a, B:8:0x000e, B:9:0x0015, B:13:0x0026, B:15:0x003f, B:17:0x0045, B:19:0x004b, B:21:0x0058, B:23:0x005c, B:25:0x0062, B:27:0x006f, B:26:0x006b, B:20:0x0054, B:14:0x002b), top: B:35:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar, String str) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, str) == null) && a()) {
            try {
                if (this.d == null) {
                    this.d = new h0();
                }
                int i2 = this.f + 1;
                this.f = i2;
                h0 h0Var = this.d;
                h0Var.b = i2;
                h0Var.e = str;
                if (dVar == null) {
                    h0Var.c = "";
                    h0Var.d = 0;
                } else {
                    h0Var.e = str;
                    h0Var.c = dVar.a().b;
                    this.d.d = dVar.a().a;
                }
                int i3 = this.l;
                if (i3 != 0) {
                    long j = this.j;
                    if (j > 0) {
                        this.d.f = j / (i3 / 500);
                        i = this.m;
                        if (i != 0) {
                            long j2 = this.k;
                            if (j2 > 0) {
                                this.d.g = j2 / (i / 500);
                                this.j = 0L;
                                this.k = 0L;
                                this.d.a = 0;
                                JSONObject jSONObject = new JSONObject(this.d.a());
                                a(5);
                                this.d.h = null;
                                String str2 = this.a;
                                LoggerProxy.d(str2, "Writes data to the file 2:" + jSONObject.toString());
                                TtsLogLoad.getInstance().writeLocalFile(jSONObject.toString(), jSONObject.toString().getBytes(StandardCharsets.UTF_8).length, 5, q);
                            }
                        }
                        this.d.g = 0L;
                        this.j = 0L;
                        this.k = 0L;
                        this.d.a = 0;
                        JSONObject jSONObject2 = new JSONObject(this.d.a());
                        a(5);
                        this.d.h = null;
                        String str22 = this.a;
                        LoggerProxy.d(str22, "Writes data to the file 2:" + jSONObject2.toString());
                        TtsLogLoad.getInstance().writeLocalFile(jSONObject2.toString(), jSONObject2.toString().getBytes(StandardCharsets.UTF_8).length, 5, q);
                    }
                }
                this.d.f = 0L;
                i = this.m;
                if (i != 0) {
                }
                this.d.g = 0L;
                this.j = 0L;
                this.k = 0L;
                this.d.a = 0;
                JSONObject jSONObject22 = new JSONObject(this.d.a());
                a(5);
                this.d.h = null;
                String str222 = this.a;
                LoggerProxy.d(str222, "Writes data to the file 2:" + jSONObject22.toString());
                TtsLogLoad.getInstance().writeLocalFile(jSONObject22.toString(), jSONObject22.toString().getBytes(StandardCharsets.UTF_8).length, 5, q);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(g0 g0Var, w1 w1Var) {
        String jSONObject;
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, g0Var, w1Var) == null) && w1Var != null) {
            g0Var.n = w1Var.g;
            synchronized (w1Var) {
                jSONObject = w1Var.d.toString();
            }
            if (jSONObject == null) {
                return;
            }
            try {
                g0Var.o = new JSONObject(jSONObject).getLong("syn_stime");
                synchronized (w1Var) {
                    jSONObject2 = w1Var.d.toString();
                }
                if (!jSONObject2.isEmpty()) {
                    g0Var.p = jSONObject2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(m0 m0Var, d dVar, d dVar2, q1 q1Var, w1 w1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048580, this, m0Var, dVar, dVar2, q1Var, w1Var) == null) && a()) {
            try {
                this.e++;
                g0 a2 = a(m0Var, q1Var, dVar, dVar2);
                a(a2, w1Var);
                if (this.n == 0) {
                    this.n = a2.o;
                }
                long j = a2.o;
                a2.h = j - this.n;
                this.n = j;
                JSONObject jSONObject = new JSONObject(a2.a());
                a(4);
                LoggerProxy.d(this.a, "Writes data to the file:" + jSONObject.toString());
                TtsLogLoad.getInstance().writeLocalFile(jSONObject.toString(), jSONObject.toString().getBytes(StandardCharsets.UTF_8).length, 4, q);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.i) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = w0.a("AndroidTTS", this.g);
            if (currentTimeMillis - this.o >= 3600000) {
                int i = e2.j;
                boolean a3 = e2.b.a.a();
                if (a3) {
                    a aVar = new a(this, new byte[]{0, 5, 0, 0, 0}, a2);
                    this.o = System.currentTimeMillis();
                    try {
                        ThreadPoolExecutor threadPoolExecutor = this.c;
                        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                            this.c.submit(aVar);
                        }
                    } catch (Exception e) {
                        LoggerProxy.d(this.a, e.toString());
                    }
                }
                String str = this.a;
                LoggerProxy.d(str, "network is connected " + a3);
            } else {
                String str2 = this.a;
                LoggerProxy.d(str2, "mLastGetSwitchTime = " + this.o + " , currentTime = " + currentTimeMillis);
            }
            boolean z = b1.d().b().getSharedPreferences(a2, 0).getBoolean("get_log_switch_status", true);
            String str3 = this.a;
            LoggerProxy.d(str3, "tableName = " + a2 + " , switchStatus = " + z + " , isInitTtsLog = " + r);
            synchronized (f0.class) {
                if (z) {
                    if (!r) {
                        b();
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TtsLogLoad ttsLogLoad = TtsLogLoad.getInstance();
            String str = this.b;
            String path = b1.d().b().getCacheDir().getPath();
            long[] jArr = p;
            int initLocalTtsWpData = ttsLogLoad.initLocalTtsWpData(str, path, 30000, true, true, true, jArr);
            String str2 = this.a;
            LoggerProxy.d(str2, "pLogHandle[0] = " + jArr[0] + " , result = " + initLocalTtsWpData);
            q = jArr[0];
            r = true;
        }
    }
}
