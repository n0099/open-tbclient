package com.baidu.tts;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.v8engine.DiskCodeCacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.g2;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o1 extends WebSocketListener {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<String, o1> m;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final OkHttpClient c;
    public WebSocket d;
    public String e;
    public k1 f;
    public Handler g;
    public h2 h;
    public String i;
    public boolean j;
    public Runnable k;
    public Runnable l;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1 a;

        public a(o1 o1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(w0.a(3, 0, new byte[0]));
                o1 o1Var = this.a;
                o1Var.g.postDelayed(o1Var.k, 10000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o1 a;

        public b(o1 o1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o1 o1Var = this.a;
                synchronized (o1Var) {
                    LoggerProxy.d(o1Var.a, "start cancel.");
                    WebSocket webSocket = o1Var.d;
                    if (webSocket != null) {
                        webSocket.cancel();
                    }
                    o1.m.remove(o1Var.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722263023, "Lcom/baidu/tts/o1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722263023, "Lcom/baidu/tts/o1;");
                return;
            }
        }
        m = new ConcurrentHashMap<>();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.removeCallbacks(this.l);
            LoggerProxy.d(this.a, "resetAliveTimer 360000");
            this.g.postDelayed(this.l, 360000L);
        }
    }

    public o1(String str) {
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
        this.k = new a(this);
        this.l = new b(this);
        String a2 = w0.a("OkWsClient", str);
        this.a = a2;
        this.b = str;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.c = builder.connectTimeout(LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, timeUnit).readTimeout(2000L, timeUnit).writeTimeout(2000L, timeUnit).retryOnConnectionFailure(false).hostnameVerifier(w0.b()).pingInterval(10000L, timeUnit).build();
        LoggerProxy.d(a2, "build OkHttpClient.");
    }

    public final synchronized d a(byte[] bArr) {
        InterceptResult invokeL;
        k1 k1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (this.j) {
                        boolean send = this.d.send(ByteString.of(bArr, 0, bArr.length));
                        if (bArr[7] == 1 && (k1Var = this.f) != null) {
                            g2 g2Var = k1Var.a.k;
                            g2.b bVar = g2Var.a;
                            if (bVar == null) {
                                bVar = new g2.b();
                                g2Var.a = bVar;
                            }
                            bVar.c = System.currentTimeMillis();
                        }
                        if (!send) {
                            d a2 = z0.a().a(u0.A);
                            LoggerProxy.d(this.a, "send failed.");
                            return a2;
                        }
                        String str = this.a;
                        LoggerProxy.d(str, "send ok type = " + ((int) bArr[7]));
                    }
                }
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public static o1 a(String str) {
        InterceptResult invokeL;
        o1 o1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (o1.class) {
                ConcurrentHashMap<String, o1> concurrentHashMap = m;
                if (!concurrentHashMap.containsKey(str)) {
                    concurrentHashMap.put(str, new o1(str));
                }
                o1Var = concurrentHashMap.get(str);
            }
            return o1Var;
        }
        return (o1) invokeL.objValue;
    }

    public synchronized d a(k1 k1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k1Var)) == null) {
            synchronized (this) {
                h2 h2Var = this.h;
                if (h2Var == null || !h2Var.isAlive()) {
                    Integer num = k2.b;
                    String str = "bds-okTimer-" + this.b;
                    if (num != null) {
                        this.h = new h2(str, num.intValue());
                    } else {
                        this.h = new h2(str);
                    }
                    this.h.start();
                    this.g = new Handler(this.h.getLooper());
                }
                if (this.d == null) {
                    if (k1Var != null) {
                        g2.b bVar = new g2.b();
                        bVar.a = System.currentTimeMillis();
                        k1Var.a.k.a = bVar;
                    }
                    LoggerProxy.d(this.a, "start send data." + this.e + " , " + this.i);
                    try {
                        Request.Builder builder = new Request.Builder();
                        builder.url(this.e);
                        String str2 = this.i;
                        if (str2 != null) {
                            builder.addHeader("Host", str2);
                        }
                        this.d = this.c.newWebSocket(builder.build(), this);
                        this.f = k1Var;
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        return z0.a().a(u0.z);
                    }
                } else {
                    this.f = k1Var;
                    if (k1Var != null) {
                        return a(k1Var.b);
                    }
                }
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.removeCallbacksAndMessages(null);
            h2 h2Var = this.h;
            if (h2Var != null && h2Var.isAlive()) {
                boolean quit = this.h.quit();
                String str = this.a;
                LoggerProxy.d(str, "heartBeatThread quit " + quit);
            }
            this.d = null;
            this.f = null;
            this.j = false;
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onClosed(WebSocket webSocket, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, webSocket, i, str) == null) {
            synchronized (this) {
                super.onClosed(webSocket, i, str);
                String str2 = this.a;
                LoggerProxy.d(str2, "onClosed code = " + i + " , reason = " + str);
                a();
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onClosing(WebSocket webSocket, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, webSocket, i, str) == null) {
            synchronized (this) {
                super.onClosing(webSocket, i, str);
                String str2 = this.a;
                LoggerProxy.d(str2, "onClosing code = " + i + " , reason = " + str);
                if (webSocket == this.d) {
                    a();
                    a((k1) null);
                }
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onFailure(WebSocket webSocket, Throwable th, Response response) {
        String str;
        d a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webSocket, th, response) == null) {
            synchronized (this) {
                super.onFailure(webSocket, th, response);
                String str2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure ");
                sb.append(th.toString());
                sb.append(" response ");
                if (response != null) {
                    str = response.toString();
                } else {
                    str = StringUtil.NULL_STRING;
                }
                sb.append(str);
                LoggerProxy.d(str2, sb.toString());
                if (webSocket == this.d) {
                    k1 k1Var = this.f;
                    a();
                    if (k1Var != null) {
                        f1 f1Var = k1Var.c;
                        if (th instanceof SocketTimeoutException) {
                            a2 = z0.a().a(u0.q);
                            a2.a = th;
                        } else if (th instanceof UnknownHostException) {
                            a2 = z0.a().a(u0.t);
                            a2.a = th;
                        } else if (th instanceof SSLException) {
                            a2 = z0.a().a(u0.u);
                            a2.a = th;
                        } else if (th instanceof ConnectException) {
                            a2 = z0.a().a(u0.v);
                            a2.a = th;
                        } else if (th instanceof SocketException) {
                            a2 = z0.a().a(u0.w);
                            a2.a = th;
                        } else {
                            a2 = z0.a().a(u0.H);
                            a2.a = th;
                        }
                        ((n1) f1Var).a(a2, true);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x022a, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0017, B:12:0x001d, B:15:0x004c, B:17:0x0074, B:18:0x0077, B:78:0x01ec, B:19:0x007b, B:21:0x007f, B:23:0x0087, B:25:0x008d, B:35:0x00e6, B:36:0x0102, B:38:0x010d, B:40:0x0115, B:43:0x0125, B:70:0x01d0, B:72:0x01d4, B:74:0x01d8, B:75:0x01e0, B:77:0x01e4, B:45:0x014d, B:47:0x0151, B:48:0x0160, B:50:0x016b, B:52:0x0175, B:54:0x017f, B:56:0x0189, B:58:0x0193, B:59:0x0195, B:61:0x01a3, B:63:0x01b0, B:65:0x01b4, B:62:0x01ae, B:68:0x01c2, B:27:0x009c, B:29:0x00a9, B:31:0x00b7, B:33:0x00c5, B:86:0x0225, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:13:0x003d), top: B:95:0x0005, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6 A[Catch: all -> 0x022a, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0017, B:12:0x001d, B:15:0x004c, B:17:0x0074, B:18:0x0077, B:78:0x01ec, B:19:0x007b, B:21:0x007f, B:23:0x0087, B:25:0x008d, B:35:0x00e6, B:36:0x0102, B:38:0x010d, B:40:0x0115, B:43:0x0125, B:70:0x01d0, B:72:0x01d4, B:74:0x01d8, B:75:0x01e0, B:77:0x01e4, B:45:0x014d, B:47:0x0151, B:48:0x0160, B:50:0x016b, B:52:0x0175, B:54:0x017f, B:56:0x0189, B:58:0x0193, B:59:0x0195, B:61:0x01a3, B:63:0x01b0, B:65:0x01b4, B:62:0x01ae, B:68:0x01c2, B:27:0x009c, B:29:0x00a9, B:31:0x00b7, B:33:0x00c5, B:86:0x0225, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:13:0x003d), top: B:95:0x0005, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0225 A[Catch: all -> 0x022a, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0017, B:12:0x001d, B:15:0x004c, B:17:0x0074, B:18:0x0077, B:78:0x01ec, B:19:0x007b, B:21:0x007f, B:23:0x0087, B:25:0x008d, B:35:0x00e6, B:36:0x0102, B:38:0x010d, B:40:0x0115, B:43:0x0125, B:70:0x01d0, B:72:0x01d4, B:74:0x01d8, B:75:0x01e0, B:77:0x01e4, B:45:0x014d, B:47:0x0151, B:48:0x0160, B:50:0x016b, B:52:0x0175, B:54:0x017f, B:56:0x0189, B:58:0x0193, B:59:0x0195, B:61:0x01a3, B:63:0x01b0, B:65:0x01b4, B:62:0x01ae, B:68:0x01c2, B:27:0x009c, B:29:0x00a9, B:31:0x00b7, B:33:0x00c5, B:86:0x0225, B:79:0x0204, B:81:0x0208, B:83:0x0210, B:13:0x003d), top: B:95:0x0005, inners: #1, #2 }] */
    @Override // okhttp3.WebSocketListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onMessage(WebSocket webSocket, ByteString byteString) {
        j1 j1Var;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, webSocket, byteString) == null) {
            synchronized (this) {
                super.onMessage(webSocket, byteString);
                if (webSocket == this.d) {
                    String str = this.b;
                    byte[] byteArray = byteString.toByteArray();
                    v1 v1Var = null;
                    boolean z = false;
                    if (byteArray != null && byteArray.length >= 8) {
                        j1Var = new j1();
                        int a2 = w0.a(byteArray, 0) - 4;
                        j1Var.a = a2;
                        byte b2 = byteArray[4];
                        j1Var.d = byteArray[5];
                        j1Var.e = byteArray[7];
                        byte[] bArr2 = new byte[a2];
                        j1Var.f = bArr2;
                        System.arraycopy(byteArray, 8, bArr2, 0, a2);
                        if (j1Var != null) {
                            LoggerProxy.d(this.a, "onMessage type = " + ((int) j1Var.e) + " , sessionIndex = " + ((int) j1Var.d));
                            byte b3 = j1Var.e;
                            if (b3 == 95) {
                                k1 k1Var = this.f;
                                if (k1Var != null) {
                                    byte b4 = j1Var.d;
                                    w1 w1Var = k1Var.a;
                                    if (b4 == w1Var.n) {
                                        v1 v1Var2 = new v1(l0.b, w1Var, null);
                                        v1Var2.g = new byte[0];
                                        ((n1) k1Var.c).a(v1Var2);
                                    }
                                }
                            } else {
                                switch (b3) {
                                    case 79:
                                    case 81:
                                        if (z) {
                                            b();
                                            break;
                                        }
                                        break;
                                    case 80:
                                        k1 k1Var2 = this.f;
                                        if (k1Var2 != null && j1Var.d == k1Var2.a.n) {
                                            String str2 = this.b;
                                            if (j1Var.a < 4) {
                                                String a3 = w0.a("LVTVCodec", str2);
                                                u0 u0Var = u0.E;
                                                LoggerProxy.d(a3, "online synthesize field miss error");
                                            } else {
                                                int a4 = w0.a(j1Var.f, 0);
                                                j1Var.b = a4;
                                                if (j1Var.a < a4 + 4) {
                                                    String a5 = w0.a("LVTVCodec", str2);
                                                    u0 u0Var2 = u0.F;
                                                    LoggerProxy.d(a5, "online synthesize need more data error");
                                                } else {
                                                    try {
                                                        j1Var.c = new String(j1Var.f, 4, j1Var.b, StandardCharsets.UTF_8);
                                                    } catch (Exception unused) {
                                                        String a6 = w0.a("LVTVCodec", str2);
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append("setTtsError = ");
                                                        u0 u0Var3 = u0.i;
                                                        sb.append("request result contains error message");
                                                        LoggerProxy.d(a6, sb.toString());
                                                    }
                                                    if (j1Var != null) {
                                                        w1 w1Var2 = this.f.a;
                                                        LoggerProxy.d("ChunkDataHandler", "responseStr=" + j1Var.c);
                                                        try {
                                                            JSONObject jSONObject = new JSONObject(j1Var.c);
                                                            n0 n0Var = n0.B;
                                                            int optInt = jSONObject.optInt("err_no");
                                                            n0 n0Var2 = n0.m0;
                                                            String optString = jSONObject.optString(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, "");
                                                            String str3 = w1Var2.g;
                                                            if (!TextUtils.equals(optString, str3)) {
                                                                LoggerProxy.d("ChunkDataHandler", "the response sn = " + optString + " , current request sn = " + str3 + " , errNo = " + optInt);
                                                            } else if (optInt != 0) {
                                                                n0 n0Var3 = n0.C;
                                                                v1Var = w0.a(jSONObject.optBoolean("convert_offline"), optInt, jSONObject.getString(PmsConstant.Statistic.STATISTIC_ERRMSG), w1Var2);
                                                            } else {
                                                                v1 v1Var3 = new v1(l0.c, w1Var2, null);
                                                                n0 n0Var4 = n0.n0;
                                                                v1Var3.c = jSONObject.optInt(DiskCodeCacheManager.DISK_CODE_CACHE_INDEX_SUFFIX);
                                                                n0 n0Var5 = n0.G;
                                                                v1Var3.d = jSONObject.optInt("percent");
                                                                n0 n0Var6 = n0.H;
                                                                v1Var3.e = jSONObject.optInt("audio_len");
                                                                n0 n0Var7 = n0.J0;
                                                                r0 a7 = r0.a(jSONObject.optInt("samplerate"));
                                                                if (a7 != null) {
                                                                    v1Var3.k = a7;
                                                                }
                                                                int optInt2 = jSONObject.optInt("audio_len");
                                                                int optInt3 = jSONObject.optInt("lip_len");
                                                                if (optInt2 > 0) {
                                                                    bArr = new byte[optInt2];
                                                                    System.arraycopy(j1Var.f, j1Var.b + 4, bArr, 0, optInt2);
                                                                } else {
                                                                    bArr = new byte[0];
                                                                }
                                                                v1Var3.g = bArr;
                                                                if (optInt3 > 0) {
                                                                    System.arraycopy(j1Var.f, j1Var.b + 4 + optInt2, new byte[optInt3], 0, optInt3);
                                                                }
                                                                v1Var = v1Var3;
                                                            }
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            u0 u0Var4 = u0.n;
                                                            LoggerProxy.d("ChunkDataHandler", "request result parse error may responsebag is null");
                                                        }
                                                        if (v1Var != null) {
                                                            d dVar = v1Var.j;
                                                            if (dVar != null) {
                                                                k1 k1Var3 = this.f;
                                                                if (k1Var3 != null) {
                                                                    ((n1) k1Var3.c).a(dVar, false);
                                                                    break;
                                                                }
                                                            } else {
                                                                k1 k1Var4 = this.f;
                                                                if (k1Var4 != null) {
                                                                    ((n1) k1Var4.c).a(v1Var);
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            j1Var = null;
                                            if (j1Var != null) {
                                            }
                                        }
                                        break;
                                    default:
                                        LoggerProxy.d(this.a, "unsupported type=" + ((int) j1Var.e));
                                        if (z) {
                                        }
                                        break;
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        }
                    }
                    LoggerProxy.d(w0.a("LVTVCodec", str), "tts-ws-ltv receive empty message");
                    j1Var = null;
                    if (j1Var != null) {
                    }
                }
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onOpen(WebSocket webSocket, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webSocket, response) == null) {
            synchronized (this) {
                super.onOpen(webSocket, response);
                LoggerProxy.d(this.a, "onOpen");
                if (webSocket == this.d) {
                    this.g.removeCallbacks(this.k);
                    this.g.postDelayed(this.k, 10000L);
                    b();
                    this.j = true;
                    k1 k1Var = this.f;
                    if (k1Var != null) {
                        g2 g2Var = k1Var.a.k;
                        g2.b bVar = g2Var.a;
                        if (bVar == null) {
                            bVar = new g2.b();
                            g2Var.a = bVar;
                        }
                        bVar.b = System.currentTimeMillis();
                    }
                    k1 k1Var2 = this.f;
                    if (k1Var2 != null) {
                        a(k1Var2.b);
                    }
                }
            }
        }
    }
}
