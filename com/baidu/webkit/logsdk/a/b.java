package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static b f61035d;
    public static final List<Message> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f61036a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f61037b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61038c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61039e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61040f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b f61041g;

    /* renamed from: h  reason: collision with root package name */
    public HandlerThread f61042h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.webkit.logsdk.b.b f61043i;
    public com.baidu.webkit.logsdk.upload.b j;
    public a k;
    public com.baidu.webkit.logsdk.c.c l;
    public ConcurrentHashMap<String, String> n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1207420033, "Lcom/baidu/webkit/logsdk/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1207420033, "Lcom/baidu/webkit/logsdk/a/b;");
                return;
            }
        }
        m = new ArrayList();
    }

    public b() {
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
        this.n = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("BdLogSDK");
        this.f61042h = handlerThread;
        handlerThread.start();
        this.f61037b = new Handler(this.f61042h.getLooper(), this);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b.class) {
                if (f61035d == null) {
                    f61035d = new b();
                }
            }
            return f61035d;
        }
        return (b) invokeV.objValue;
    }

    public static Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (a().f61038c != null) {
                return a().f61038c;
            }
            throw new RuntimeException("LogSDK getContext null! please init first.");
        }
        return (Context) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x007d, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:9:0x0017, B:13:0x0022, B:15:0x0033, B:17:0x003d, B:21:0x0047, B:23:0x0058, B:25:0x0064, B:27:0x006a, B:29:0x0075, B:28:0x0070), top: B:39:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            synchronized (this) {
                z = true;
                if (!this.f61039e) {
                    com.baidu.webkit.logsdk.c.c h2 = h();
                    boolean z2 = h2.f61075a.isEmpty() && h2.f61077c.isEmpty();
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = ".concat(String.valueOf(z2)));
                    if (z2 && f().a() && this.n.isEmpty()) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = ".concat(String.valueOf(z)));
                        if (z) {
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                            if (f61035d != null) {
                                if (Build.VERSION.SDK_INT >= 18) {
                                    this.f61042h.quitSafely();
                                } else {
                                    this.f61042h.quit();
                                }
                                this.f61040f = false;
                                this.f61038c = null;
                                f61035d = null;
                            }
                        }
                    }
                }
                z = false;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = ".concat(String.valueOf(z)));
                if (z) {
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) != null) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "sendPendingMessages");
        while (true) {
            Message message = null;
            synchronized (m) {
                if (m.size() > 0) {
                    message = m.get(0);
                    m.remove(0);
                }
            }
            if (message == null) {
                return;
            }
            this.f61037b.sendMessage(message);
        }
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || i()) {
            return;
        }
        this.f61037b.sendEmptyMessageDelayed(3, j);
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Runnable runnable = new Runnable(this, aVar, j, z) { // from class: com.baidu.webkit.logsdk.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.baidu.webkit.logsdk.upload.a f61049a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f61050b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f61051c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f61052d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, Long.valueOf(j), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61052d = this;
                    this.f61049a = aVar;
                    this.f61050b = j;
                    this.f61051c = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.baidu.webkit.logsdk.c.c h2 = this.f61052d.h();
                        com.baidu.webkit.logsdk.upload.a aVar2 = this.f61049a;
                        long j2 = this.f61050b;
                        boolean z2 = this.f61051c;
                        int i2 = aVar2.f61091e.f61057b;
                        String str = aVar2.f61094h;
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile oldFileName = ".concat(String.valueOf(str)));
                        String l = (i2 == 1 || i2 == 2) ? Long.toString(j2) : i2 == 3 ? "upload" : null;
                        if (!TextUtils.isEmpty(l)) {
                            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar2.f61091e.f61056a, l);
                            String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile path = ".concat(String.valueOf(b2)));
                            StringBuilder sb = new StringBuilder();
                            int i3 = aVar2.f61088b;
                            if (z2) {
                                i3++;
                            } else if (c2.equals(str)) {
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToFile file not change, return ");
                                return;
                            }
                            sb.append(i3);
                            sb.append(Part.CRLF);
                            sb.append(aVar2.f61092f);
                            sb.append(Part.CRLF);
                            sb.append(aVar2.f61095i);
                            sb.append(Part.CRLF);
                            sb.append(aVar2.f61087a);
                            com.baidu.webkit.logsdk.d.c.b(b2, sb.toString());
                            if (!TextUtils.isEmpty(str)) {
                                b.a().h().b(str);
                                if (i2 != 3) {
                                    new File(com.baidu.webkit.logsdk.d.c.b(str)).delete();
                                }
                            }
                            try {
                                h2.c();
                            } catch (Exception e2) {
                                com.baidu.webkit.logsdk.d.c.a(e2);
                            }
                        }
                        b.a().f().a(aVar2.f61090d);
                    }
                }
            };
            Handler handler = this.f61037b;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(4);
                obtainMessage.obj = runnable;
                this.f61037b.sendMessage(obtainMessage);
            }
        }
    }

    public final void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            String c2 = com.baidu.webkit.logsdk.d.c.c(str2 + j);
            if (!TextUtils.isEmpty(c2)) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog put key = ".concat(String.valueOf(c2)));
                this.n.put(c2, c2);
            }
            Runnable runnable = new Runnable(this, str, str2, j, c2) { // from class: com.baidu.webkit.logsdk.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61044a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61045b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f61046c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f61047d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f61048e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Long.valueOf(j), c2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61048e = this;
                    this.f61044a = str;
                    this.f61045b = str2;
                    this.f61046c = j;
                    this.f61047d = c2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.baidu.webkit.logsdk.c.c h2 = this.f61048e.h();
                        String str3 = this.f61044a;
                        String str4 = this.f61045b;
                        long j2 = this.f61046c;
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor addLog = ".concat(String.valueOf(str3)));
                        com.baidu.webkit.logsdk.b.a a2 = b.a().e().a(str3);
                        int i2 = a2.f61057b;
                        if (i2 == 1) {
                            if (com.baidu.webkit.logsdk.a.f61025b) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewRealTimeLog", str4);
                            }
                            String a3 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                            if (!TextUtils.isEmpty(a3)) {
                                h2.f61075a.add(new com.baidu.webkit.logsdk.upload.a(a2, a3));
                                com.baidu.webkit.logsdk.c.c.a(a2);
                                if ("frame_app".equals(a2.f61056a) && "app_pause".equals(str4)) {
                                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkAppPause");
                                    if (!h2.f61076b.isEmpty()) {
                                        for (String str5 : h2.f61076b.keySet()) {
                                            com.baidu.webkit.logsdk.c.a aVar = h2.f61076b.get(str5);
                                            if (!aVar.f61071b.isEmpty()) {
                                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor destroy type = ".concat(String.valueOf(str5)));
                                                com.baidu.webkit.logsdk.b.a a4 = b.a().e().a(str5);
                                                int i3 = a4.f61057b;
                                                if (i3 == 2) {
                                                    h2.f61075a.add(new com.baidu.webkit.logsdk.upload.a(a4, aVar.a()));
                                                    aVar.f61071b.clear();
                                                } else if (i3 == 3) {
                                                    h2.c(com.baidu.webkit.logsdk.d.c.c(aVar.f61070a, SapiOptions.KEY_CACHE));
                                                    h2.f61078d.a(aVar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (i2 == 2) {
                            if (com.baidu.webkit.logsdk.a.f61024a) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog", str4);
                            }
                            String a5 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                            if (!TextUtils.isEmpty(a5)) {
                                com.baidu.webkit.logsdk.c.a a6 = h2.a(a2.f61056a);
                                int a7 = a6.a(a5);
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor handleNewShortTimeLog current = ".concat(String.valueOf(a7)));
                                long j3 = a7;
                                b.a().e();
                                if (j3 >= com.baidu.webkit.logsdk.b.b.a().getLong("threshold", 10L)) {
                                    h2.f61075a.add(new com.baidu.webkit.logsdk.upload.a(a2, a6.a()));
                                    a6.f61071b.clear();
                                    h2.a(2);
                                    com.baidu.webkit.logsdk.c.c.a(a2);
                                }
                            }
                        } else if (i2 == 3) {
                            if (com.baidu.webkit.logsdk.a.f61024a) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor handleNewLongTimeLog", str4);
                            }
                            String a8 = com.baidu.webkit.logsdk.c.c.a(str4, j2);
                            if (!TextUtils.isEmpty(a8)) {
                                com.baidu.webkit.logsdk.c.a a9 = h2.a(a2.f61056a);
                                if (a9.a(a8) >= com.baidu.webkit.logsdk.d.a.f61081a) {
                                    b a10 = b.a();
                                    Runnable runnable2 = new Runnable(a10, a9) { // from class: com.baidu.webkit.logsdk.a.b.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ com.baidu.webkit.logsdk.c.a f61053a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ b f61054b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {a10, a9};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f61054b = a10;
                                            this.f61053a = a9;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f61054b.h().b().a(this.f61053a);
                                            }
                                        }
                                    };
                                    Handler handler = a10.f61037b;
                                    if (handler != null) {
                                        Message obtainMessage = handler.obtainMessage(4);
                                        obtainMessage.obj = runnable2;
                                        a10.f61037b.sendMessage(obtainMessage);
                                    }
                                }
                            }
                        }
                        if (TextUtils.isEmpty(this.f61047d)) {
                            return;
                        }
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addLog remove key = " + this.f61047d);
                        this.f61048e.n.remove(this.f61047d);
                    }
                }
            };
            Handler handler = this.f61037b;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(1);
                obtainMessage.obj = runnable;
                if (b()) {
                    this.f61037b.sendMessage(obtainMessage);
                    return;
                }
                synchronized (m) {
                    m.add(obtainMessage);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014a A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0172 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0187 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:14:0x004f, B:16:0x0062, B:18:0x006c, B:22:0x0077, B:24:0x007c, B:26:0x0082, B:28:0x008c, B:32:0x0096, B:33:0x0099, B:35:0x00a9, B:37:0x00b3, B:42:0x00cb, B:43:0x00d1, B:45:0x00d7, B:47:0x00e1, B:52:0x00f8, B:53:0x00fc, B:55:0x0102, B:57:0x010c, B:62:0x0124, B:63:0x0128, B:65:0x012e, B:67:0x0138, B:70:0x0140, B:71:0x0144, B:73:0x014a, B:75:0x0154, B:76:0x0159, B:78:0x015f, B:80:0x0169, B:81:0x016c, B:83:0x0172, B:85:0x017c, B:86:0x0181, B:88:0x0187, B:90:0x0191, B:91:0x0194), top: B:122:0x004f, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeLL;
        com.baidu.webkit.logsdk.b.b e2;
        b a2;
        String a3;
        JSONObject jSONObject;
        SharedPreferences.Editor edit;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, bVar)) == null) {
            b bVar2 = this;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
            if (!bVar2.f61039e) {
                if (context == null) {
                    throw new RuntimeException("LogSDK init: Context null!");
                }
                if (bVar == null) {
                    throw new RuntimeException("LogSDK init: ILogSDKListener null!");
                }
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
                try {
                    bVar2.f61036a = null;
                    bVar2.f61041g = bVar;
                    bVar2.f61038c = context;
                    e2 = e();
                    String b2 = bVar.b();
                    if (TextUtils.isEmpty(b2)) {
                        b2 = "https://browserkernel.baidu.com/log/config_browser.json";
                    }
                    e2.f61063a = b2;
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    try {
                        jSONObject = new JSONObject("{    \"master\": \"1\",    \"net_level\": 3,    \"timeout\":\"30\",    \"filesize\":\"10\",    \"timeup\":\"1\",    \"threshold\":\"3\",    \"f1\":\"1_0\",    \"f2\":\"0_1\",    \"f3\":\"2_3\",    \"publickey\":\"test\",     \"array\": [        {\"log_type\": \"frame_event\", \"master\": \"0\", \"log_level\": 3},        {\"log_type\": \"frame_pv\", \"master\": \"0\", \"log_level\": 2},        {\"log_type\": \"frame_record\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_anr\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_app\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_reportinfo\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_t5timing\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_safe\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_sailor\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_sailorStat\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_whiteScreen\", \"master\": \"0\", \"log_level\": 1}    ],    \"params\": {        \"kernel\": {\"body\":[],                   \"url\": [] }    }}");
                        edit = com.baidu.webkit.logsdk.b.b.a().edit();
                    } catch (Exception e4) {
                        com.baidu.webkit.logsdk.d.c.a(e4);
                    }
                    if (jSONObject.has("master")) {
                        String string = jSONObject.getString("master");
                        if (!TextUtils.isEmpty(string)) {
                            z = !string.equals("0");
                            edit.putBoolean("master", z);
                            if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                                String string2 = jSONObject.getString(DpStatConstants.KEY_NET_LEVEL);
                                if (!TextUtils.isEmpty(string2)) {
                                    int parseInt = Integer.parseInt(string2);
                                    edit.putInt(DpStatConstants.KEY_NET_LEVEL, (parseInt < 0 || parseInt > 3) ? 3 : 3);
                                }
                            }
                            if (jSONObject.has("timeout")) {
                                String string3 = jSONObject.getString("timeout");
                                if (!TextUtils.isEmpty(string3)) {
                                    double parseDouble = Double.parseDouble(string3) * 8.64E7d;
                                    edit.putLong("timeout", (long) ((parseDouble < 3.456E8d || parseDouble > 2.592E9d) ? 6.048E8d : 6.048E8d));
                                }
                            }
                            if (jSONObject.has("filesize")) {
                                String string4 = jSONObject.getString("filesize");
                                if (!TextUtils.isEmpty(string4)) {
                                    double parseDouble2 = Double.parseDouble(string4) * 1024.0d;
                                    edit.putLong("filesize", (long) ((parseDouble2 < 1024.0d || parseDouble2 > 307200.0d) ? 10240.0d : 10240.0d));
                                }
                            }
                            if (jSONObject.has("timeup")) {
                                String string5 = jSONObject.getString("timeup");
                                if (!TextUtils.isEmpty(string5)) {
                                    double parseDouble3 = Double.parseDouble(string5) * 8.64E7d;
                                    edit.putLong("timeup", (long) ((parseDouble3 < 8.64E7d || parseDouble3 > 3.456E8d) ? 1.728E8d : 1.728E8d));
                                }
                            }
                            if (jSONObject.has("threshold")) {
                                String string6 = jSONObject.getString("threshold");
                                if (!TextUtils.isEmpty(string6)) {
                                    int parseInt2 = Integer.parseInt(string6);
                                    if (parseInt2 <= 0) {
                                        parseInt2 = 10;
                                    }
                                    edit.putLong("threshold", parseInt2);
                                }
                            }
                            if (jSONObject.has("publickey")) {
                                String string7 = jSONObject.getString("publickey");
                                if (!TextUtils.isEmpty(string7)) {
                                    edit.putString("publickey", string7);
                                    com.baidu.webkit.logsdk.b.b.f61061b = string7;
                                }
                            }
                            if (jSONObject.has("f1")) {
                                String string8 = jSONObject.getString("f1");
                                if (!TextUtils.isEmpty(string8)) {
                                    edit.putString("f1", string8);
                                }
                            }
                            if (jSONObject.has("f2")) {
                                String string9 = jSONObject.getString("f2");
                                if (!TextUtils.isEmpty(string9)) {
                                    edit.putString("f2", string9);
                                    com.baidu.webkit.logsdk.b.b.f61062c = string9;
                                }
                            }
                            if (jSONObject.has("f3")) {
                                String string10 = jSONObject.getString("f3");
                                if (!TextUtils.isEmpty(string10)) {
                                    edit.putString("f3", string10);
                                }
                            }
                            e2.a(jSONObject, edit);
                            e2.a(jSONObject, z, edit);
                            edit.apply();
                            a2 = a();
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                            a2.f61040f = true;
                            if (1 != 0 && a2.f61037b != null) {
                                a2.f61037b.sendMessage(a2.f61037b.obtainMessage(2));
                            }
                            com.baidu.webkit.logsdk.upload.b f2 = f();
                            a3 = bVar.a();
                            if (TextUtils.isEmpty(a3)) {
                                a3 = "https://browserkernel.baidu.com/logstat/stat/log";
                            }
                            f2.f61096a = a3;
                            g();
                            h();
                            bVar2 = this;
                            bVar2.f61039e = true;
                        }
                    }
                    z = true;
                    if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                    }
                    if (jSONObject.has("timeout")) {
                    }
                    if (jSONObject.has("filesize")) {
                    }
                    if (jSONObject.has("timeup")) {
                    }
                    if (jSONObject.has("threshold")) {
                    }
                    if (jSONObject.has("publickey")) {
                    }
                    if (jSONObject.has("f1")) {
                    }
                    if (jSONObject.has("f2")) {
                    }
                    if (jSONObject.has("f3")) {
                    }
                    e2.a(jSONObject, edit);
                    e2.a(jSONObject, z, edit);
                    edit.apply();
                    a2 = a();
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                    a2.f61040f = true;
                    if (1 != 0) {
                        a2.f61037b.sendMessage(a2.f61037b.obtainMessage(2));
                    }
                    com.baidu.webkit.logsdk.upload.b f22 = f();
                    a3 = bVar.a();
                    if (TextUtils.isEmpty(a3)) {
                    }
                    f22.f61096a = a3;
                    g();
                    h();
                    bVar2 = this;
                    bVar2.f61039e = true;
                } catch (Exception e5) {
                    e = e5;
                    bVar2 = this;
                    com.baidu.webkit.logsdk.d.c.a(e);
                    return bVar2.f61039e;
                }
            }
            return bVar2.f61039e;
        }
        return invokeLL.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61039e && this.f61041g != null && this.f61038c != null && this.f61040f : invokeV.booleanValue;
    }

    public final com.baidu.webkit.logsdk.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.baidu.webkit.logsdk.b bVar = this.f61041g;
            if (bVar != null) {
                return bVar;
            }
            throw new RuntimeException("LogSDK getListener null! please init first.");
        }
        return (com.baidu.webkit.logsdk.b) invokeV.objValue;
    }

    public final com.baidu.webkit.logsdk.b.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f61043i == null) {
                this.f61043i = new com.baidu.webkit.logsdk.b.b();
            }
            return this.f61043i;
        }
        return (com.baidu.webkit.logsdk.b.b) invokeV.objValue;
    }

    public final com.baidu.webkit.logsdk.upload.b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.j == null) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "new BdLogUploadWorker");
                this.j = new com.baidu.webkit.logsdk.upload.b();
            }
            return this.j;
        }
        return (com.baidu.webkit.logsdk.upload.b) invokeV.objValue;
    }

    public final a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.k == null) {
                this.k = new a(this.f61038c);
            }
            return this.k;
        }
        return (a) invokeV.objValue;
    }

    public final com.baidu.webkit.logsdk.c.c h() {
        InterceptResult invokeV;
        com.baidu.webkit.logsdk.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (b.class) {
                if (this.l == null) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor getProcessor");
                    this.l = new com.baidu.webkit.logsdk.c.c();
                }
                cVar = this.l;
            }
            return cVar;
        }
        return (com.baidu.webkit.logsdk.c.c) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0 != 5) goto L11;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleMessage " + message.what);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    j();
                    h().a(3);
                    h().b().a();
                    Runnable runnable = new Runnable(this) { // from class: com.baidu.webkit.logsdk.a.b.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f61055a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61055a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f61055a.b()) {
                                com.baidu.webkit.logsdk.c.b b2 = this.f61055a.h().b();
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleUploadLongTimeLog");
                                for (String str : b2.f61073a.keySet()) {
                                    if (b2.f61073a.get(str).booleanValue()) {
                                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createUploadTask: ".concat(String.valueOf(str)));
                                        try {
                                            String c2 = com.baidu.webkit.logsdk.d.c.c(str, "upload");
                                            File file = new File(com.baidu.webkit.logsdk.d.c.b(c2));
                                            if (file.exists()) {
                                                com.baidu.webkit.logsdk.upload.a a2 = com.baidu.webkit.logsdk.c.c.a(file, b.a().e().a(str));
                                                if (a2 != null) {
                                                    a2.f61094h = c2;
                                                    b2.f61074b.c(c2);
                                                    b2.f61074b.a(a2);
                                                }
                                            } else {
                                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createFromCache: ".concat(String.valueOf(str)));
                                                b2.a(str);
                                            }
                                        } catch (Exception e2) {
                                            com.baidu.webkit.logsdk.d.c.a(e2);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    Handler handler = this.f61037b;
                    if (handler != null) {
                        Message obtainMessage = handler.obtainMessage(5);
                        obtainMessage.obj = runnable;
                        this.f61037b.sendMessageDelayed(obtainMessage, 3000L);
                    }
                } else if (i2 != 3) {
                    if (i2 != 4) {
                    }
                } else if (h().a()) {
                    j = 500;
                    a(j);
                }
                return true;
            }
            Object obj = message.obj;
            if (obj instanceof Runnable) {
                ((Runnable) obj).run();
            }
            j = 0;
            a(j);
            return true;
        }
        return invokeL.booleanValue;
    }
}
