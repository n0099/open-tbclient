package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.g2;
import com.baidu.tts.h1;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class n1 implements f1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final o1 c;
    public final byte d;
    public String e;
    public w1 f;
    public final u1 g;
    public final Semaphore h;
    public ScheduledThreadPoolExecutor i;
    public d j;
    public long k;
    public String l;
    public long m;
    public r0 n;
    public ScheduledFuture<?> o;
    public Runnable p;

    /* loaded from: classes9.dex */
    public class a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;
        public final /* synthetic */ n1 b;

        public a(n1 n1Var, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n1Var, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n1Var;
            this.a = mVar;
        }

        @Override // com.baidu.tts.m
        public void a(v1 v1Var) {
            m mVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v1Var) == null) {
                l0 l0Var = v1Var.a;
                if (l0Var == l0.b) {
                    LoggerProxy.d(this.b.a, "onDataEnd");
                    this.b.h.release();
                } else if (l0Var == l0.c && (mVar = this.a) != null) {
                    mVar.a(v1Var);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n1 a;

        public b(n1 n1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
                long currentTimeMillis = System.currentTimeMillis();
                n1 n1Var = this.a;
                long j = currentTimeMillis - n1Var.k;
                String str = n1Var.a;
                LoggerProxy.d(str, "Channel[" + ((int) this.a.d) + "], connect timeout, cost " + j + "ms");
                this.a.a(z0.a().a(u0.q), true);
            }
        }
    }

    public n1(String str, m mVar, byte b2, u1 u1Var, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mVar, Byte.valueOf(b2), u1Var, scheduledThreadPoolExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new Semaphore(0);
        this.n = r0.c;
        this.p = new b(this);
        this.b = str;
        this.a = w0.a("SynthesizeChunkWork", str);
        this.d = b2;
        this.g = u1Var;
        this.i = scheduledThreadPoolExecutor;
        this.c = o1.a(str);
        c();
        d0.a(str).a(new a(this, mVar));
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            byte[] a2 = w0.a(14, this.d, new byte[0]);
            o1 o1Var = this.c;
            synchronized (o1Var) {
                if (o1Var.d != null) {
                    o1Var.f = null;
                    o1Var.a(a2);
                }
            }
        }
    }

    public final void b() {
        ScheduledFuture<?> scheduledFuture;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (scheduledFuture = this.o) != null && !scheduledFuture.isDone()) {
            this.o.cancel(true);
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            ScheduledFuture<?> scheduledFuture = this.o;
            if (scheduledFuture == null) {
                this.o = this.i.schedule(this.p, i, TimeUnit.MILLISECONDS);
                String str = this.a;
                LoggerProxy.d(str, "Channel[" + ((int) this.d) + "], new timer after " + i);
            } else if (!scheduledFuture.isDone()) {
                this.o.cancel(true);
                this.o = this.i.schedule(this.p, i, TimeUnit.MILLISECONDS);
                String str2 = this.a;
                LoggerProxy.d(str2, "Channel[" + ((int) this.d) + "], new timer after " + i);
            }
        }
    }

    public final void a(d dVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            String str = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("sn = ");
            sb.append(this.e);
            sb.append("ErrorCode = ");
            sb.append(dVar.getDetailCode());
            sb.append(", ErrorMsg = ");
            sb.append(dVar.getDetailMessage());
            sb.append(" , firstError = ");
            if (this.j == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            LoggerProxy.d(str, sb.toString());
            if (this.j == null) {
                this.j = dVar;
            }
        }
    }

    public void a(d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, dVar, z) == null) {
            this.f.a("url", this.c.e);
            int i = dVar.b;
            if (i != 0) {
                this.f.a("status_code", Integer.valueOf(i));
            }
            a(dVar);
            String str = this.a;
            LoggerProxy.d(str, "onError isLast = " + z);
            if (z) {
                this.h.release();
            }
        }
    }

    public void a(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v1Var) == null) {
            a(this.g.o);
            int i = v1Var.c;
            this.f.j = i;
            String str = this.a;
            LoggerProxy.d(str, "receive " + v1Var.c + " package");
            if (Math.abs(i) == 1) {
                long currentTimeMillis = System.currentTimeMillis() - this.m;
                g2 g2Var = this.f.k;
                g2.b bVar = g2Var.a;
                if (bVar == null) {
                    bVar = new g2.b();
                    g2Var.a = bVar;
                }
                bVar.d = System.currentTimeMillis();
                this.f.a("time_first_bag", Long.valueOf(currentTimeMillis));
                this.n = v1Var.k;
            }
            r0 r0Var = this.n;
            v1Var.k = r0Var;
            w1 w1Var = this.f;
            w1Var.l = r0Var;
            synchronized (w1Var) {
                JSONObject jSONObject = new JSONObject();
                w1Var.f = jSONObject;
                try {
                    jSONObject.put("tts_idx", i);
                    w1Var.f.put("query_etime", System.currentTimeMillis());
                    w1Var.e.put(w1Var.f);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            j0 j0Var = this.g.i;
            if (j0Var == j0.c) {
                v1Var.h = i0.a;
            } else {
                j0 a2 = j0.a(j0Var.a);
                String str2 = this.g.j.a;
                double d = 0.0d;
                if (a2 != null) {
                    k0[] a3 = a2.a();
                    int length = a3.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        k0 k0Var = a3[i2];
                        if (k0Var.a.equalsIgnoreCase(str2)) {
                            d = k0Var.b;
                            break;
                        }
                        i2++;
                    }
                }
                v1Var.l = d;
                String str3 = this.a;
                LoggerProxy.d(str3, "Decoder mBitRate : " + d);
            }
            int a4 = d0.a(this.b).a(v1Var);
            String str4 = this.a;
            LoggerProxy.d(str4, "Decoder ret : " + a4);
            if (a4 == -3) {
                a(z0.a().a(u0.G));
            } else if (a4 == 0) {
                this.f.h = v1Var.d;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x011b A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #0 {Exception -> 0x015b, blocks: (B:8:0x0013, B:10:0x0017, B:12:0x0020, B:14:0x0029, B:16:0x0038, B:18:0x003c, B:19:0x003f, B:21:0x0044, B:23:0x004b, B:25:0x0056, B:27:0x005a, B:28:0x005d, B:30:0x0061, B:32:0x006b, B:34:0x0076, B:36:0x0080, B:38:0x0089, B:40:0x0099, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:48:0x00b9, B:50:0x00c3, B:52:0x00d2, B:59:0x00f0, B:61:0x00f4, B:63:0x00fb, B:65:0x0104, B:69:0x0115, B:71:0x011b, B:73:0x011f, B:74:0x0122, B:76:0x0126, B:78:0x012a, B:79:0x012d, B:81:0x0131, B:83:0x0135, B:84:0x0138, B:86:0x013c, B:88:0x0142, B:90:0x0146, B:91:0x0149, B:93:0x014d, B:95:0x0153, B:97:0x0157, B:68:0x0113, B:58:0x00eb, B:57:0x00e2, B:54:0x00db), top: B:107:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0126 A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #0 {Exception -> 0x015b, blocks: (B:8:0x0013, B:10:0x0017, B:12:0x0020, B:14:0x0029, B:16:0x0038, B:18:0x003c, B:19:0x003f, B:21:0x0044, B:23:0x004b, B:25:0x0056, B:27:0x005a, B:28:0x005d, B:30:0x0061, B:32:0x006b, B:34:0x0076, B:36:0x0080, B:38:0x0089, B:40:0x0099, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:48:0x00b9, B:50:0x00c3, B:52:0x00d2, B:59:0x00f0, B:61:0x00f4, B:63:0x00fb, B:65:0x0104, B:69:0x0115, B:71:0x011b, B:73:0x011f, B:74:0x0122, B:76:0x0126, B:78:0x012a, B:79:0x012d, B:81:0x0131, B:83:0x0135, B:84:0x0138, B:86:0x013c, B:88:0x0142, B:90:0x0146, B:91:0x0149, B:93:0x014d, B:95:0x0153, B:97:0x0157, B:68:0x0113, B:58:0x00eb, B:57:0x00e2, B:54:0x00db), top: B:107:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0131 A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #0 {Exception -> 0x015b, blocks: (B:8:0x0013, B:10:0x0017, B:12:0x0020, B:14:0x0029, B:16:0x0038, B:18:0x003c, B:19:0x003f, B:21:0x0044, B:23:0x004b, B:25:0x0056, B:27:0x005a, B:28:0x005d, B:30:0x0061, B:32:0x006b, B:34:0x0076, B:36:0x0080, B:38:0x0089, B:40:0x0099, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:48:0x00b9, B:50:0x00c3, B:52:0x00d2, B:59:0x00f0, B:61:0x00f4, B:63:0x00fb, B:65:0x0104, B:69:0x0115, B:71:0x011b, B:73:0x011f, B:74:0x0122, B:76:0x0126, B:78:0x012a, B:79:0x012d, B:81:0x0131, B:83:0x0135, B:84:0x0138, B:86:0x013c, B:88:0x0142, B:90:0x0146, B:91:0x0149, B:93:0x014d, B:95:0x0153, B:97:0x0157, B:68:0x0113, B:58:0x00eb, B:57:0x00e2, B:54:0x00db), top: B:107:0x0013, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(String str, w1 w1Var, u1 u1Var) throws j2 {
        InterceptResult invokeLLL;
        int i;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, w1Var, u1Var)) == null) {
            if (u1Var == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            b1 d = b1.d();
            HashMap<String, String> hashMap = w1Var.m;
            try {
                n0 n0Var = n0.m0;
                jSONObject2.put(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, str);
                n0 n0Var2 = n0.p0;
                jSONObject2.put("ctp", 10);
                String str7 = u1Var.h;
                n0 n0Var3 = n0.Z;
                jSONObject2.put("pdt", Integer.parseInt(str7));
                String str8 = u1Var.n;
                if (!w0.b(str8)) {
                    n0 n0Var4 = n0.z0;
                    jSONObject2.put("key", str8);
                }
                n0 n0Var5 = n0.Y0;
                jSONObject2.put("multiplex", 1);
                n0 n0Var6 = n0.o0;
                jSONObject2.put("tex", w1Var.a);
                String c = d.c();
                if (c != null) {
                    n0 n0Var7 = n0.q0;
                    jSONObject2.put("cuid", c);
                }
                n0 n0Var8 = n0.M;
                jSONObject2.put("spd", u1Var.a);
                n0 n0Var9 = n0.R;
                jSONObject2.put("pit", u1Var.b);
                n0 n0Var10 = n0.Q;
                jSONObject2.put("vol", u1Var.c);
                n0 n0Var11 = n0.a0;
                jSONObject2.put("per", u1Var.k);
                n0 n0Var12 = n0.f1188T;
                jSONObject2.put("aue", Integer.parseInt(u1Var.i.a));
                n0 n0Var13 = n0.r0;
                jSONObject2.put("ver", "6.0.5.5f65dca");
                String str9 = u1Var.j.a;
                if (!w0.b(str9)) {
                    i = Integer.parseInt(str9);
                } else {
                    i = 1;
                }
                n0 n0Var14 = n0.U;
                jSONObject2.put("rate", i);
                n0 n0Var15 = n0.S;
                jSONObject2.put("lan", u1Var.d);
                n0 n0Var16 = n0.k0;
                jSONObject2.put("xml", u1Var.e);
                jSONObject2.put("mode", 0);
                n0 n0Var17 = n0.L;
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                String str10 = u1Var.r;
                if (str10 != null) {
                    try {
                        jSONObject = new JSONObject(str10);
                    } catch (Exception e) {
                        e.printStackTrace();
                        jSONObject = new JSONObject();
                    }
                } else {
                    jSONObject = new JSONObject();
                }
                n0 n0Var18 = n0.L0;
                jSONObject.put("pack_size_type", 1);
                n0 n0Var19 = n0.K0;
                jSONObject2.put("audio_ctrl", jSONObject.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (hashMap != null) {
                str2 = hashMap.get(SpeechSynthesizer.PARAM_TEXT_CTRL);
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str2)) {
                        n0 n0Var20 = n0.M0;
                        jSONObject2.put("text_ctrl", str2);
                    }
                    str3 = u1Var.s;
                    if (str3 != null) {
                        n0 n0Var21 = n0.N0;
                        jSONObject2.put("lip_ctrl", str3);
                    }
                    str4 = u1Var.t;
                    if (str4 != null) {
                        n0 n0Var22 = n0.O0;
                        jSONObject2.put("lip", str4);
                    }
                    str5 = u1Var.u;
                    if (str5 != null && !str5.isEmpty()) {
                        n0 n0Var23 = n0.Q0;
                        jSONObject2.put("stat_pam", str5);
                    }
                    str6 = u1Var.v;
                    if (str6 != null && !str6.isEmpty()) {
                        n0 n0Var24 = n0.S0;
                        jSONObject2.put("text_pos", str6);
                    }
                    byte[] bytes = jSONObject2.toString().getBytes(StandardCharsets.UTF_8);
                    String str11 = this.a;
                    LoggerProxy.d(str11, "request params: " + new String(bytes));
                    return bytes;
                }
            }
            str2 = u1Var.g;
            if (!TextUtils.isEmpty(str2)) {
            }
            str3 = u1Var.s;
            if (str3 != null) {
            }
            str4 = u1Var.t;
            if (str4 != null) {
            }
            str5 = u1Var.u;
            if (str5 != null) {
                n0 n0Var232 = n0.Q0;
                jSONObject2.put("stat_pam", str5);
            }
            str6 = u1Var.v;
            if (str6 != null) {
                n0 n0Var242 = n0.S0;
                jSONObject2.put("text_pos", str6);
            }
            byte[] bytes2 = jSONObject2.toString().getBytes(StandardCharsets.UTF_8);
            String str112 = this.a;
            LoggerProxy.d(str112, "request params: " + new String(bytes2));
            return bytes2;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            h1 h1Var = h1.d.a;
            String str = this.g.p;
            h1Var.getClass();
            if (!TextUtils.isEmpty(str)) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case 48:
                        if (str.equals("0")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            h1Var.a = h1.c.a;
                        } else {
                            h1Var.a = h1.c.b;
                        }
                    } else {
                        h1Var.a = h1.c.c;
                    }
                } else {
                    h1Var.a = h1.c.d;
                }
            }
            String str2 = this.g.q;
            if (TextUtils.isEmpty(str2)) {
                str2 = "wss://tts.baidu.com/ws/sdktts";
            }
            if (!TextUtils.equals(this.l, str2)) {
                this.l = str2;
                String str3 = null;
                try {
                    str3 = new URL(str2.replaceFirst(SpeechSynthesizer.REQUEST_PROTOCOL_WS, "http")).getHost();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                String a2 = h1.d.a.a(str2, false);
                if (!TextUtils.isEmpty(a2)) {
                    if (str2.startsWith(SpeechSynthesizer.REQUEST_PROTOCOL_WS)) {
                        str2 = a2.replaceFirst("http", SpeechSynthesizer.REQUEST_PROTOCOL_WS);
                    } else {
                        str2 = a2;
                    }
                }
                sb.append(str2);
                sb.append("?sn=");
                sb.append(UUID.randomUUID().toString());
                String sb2 = sb.toString();
                o1 o1Var = this.c;
                o1Var.i = str3;
                o1Var.e = sb2;
            }
        }
    }
}
