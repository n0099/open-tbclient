package com.baidu.webkit.internal.blink;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f52967b;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f52968e;

    /* renamed from: f  reason: collision with root package name */
    public static final Object f52969f;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: c  reason: collision with root package name */
    public b f52970c;

    /* renamed from: d  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f52971d;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Context f52972b;

        /* renamed from: c  reason: collision with root package name */
        public String f52973c;

        /* renamed from: d  reason: collision with root package name */
        public String f52974d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52975e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final synchronized boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    z = this.f52975e;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public final synchronized void b() {
            StringBuilder sb;
            String sb2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.f52975e) {
                        this.f52975e = false;
                    }
                    if (this.f52975e) {
                        if (this.f52972b.getFilesDir() == null) {
                            sb2 = null;
                        } else {
                            if (this.f52972b.getApplicationInfo().nativeLibraryDir != null) {
                                sb = new StringBuilder();
                                sb.append(this.f52972b.getApplicationInfo().nativeLibraryDir);
                                sb.append("/libzeuswebviewchromium.so");
                            } else {
                                sb = new StringBuilder();
                                sb.append(this.f52972b.getFilesDir().getParent());
                                sb.append("/lib/libzeuswebviewchromium.so");
                            }
                            sb2 = sb.toString();
                        }
                        this.f52973c = sb2;
                        this.f52974d = this.a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f52976b;

        /* renamed from: c  reason: collision with root package name */
        public Context f52977c;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, this) == null) {
                this.a = true;
                synchronized (c.f52969f) {
                    if (this.f52976b.f52971d != null) {
                        this.f52976b.f52971d.unzipFinished();
                        this.f52976b.f52971d = null;
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    boolean z = true;
                    if (this.f52977c != null && SevenZipUtils.getInstance().prepare(this.f52977c, this.f52976b.a.f52973c, this.f52976b.a.f52974d)) {
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                        SevenZipUtils.getInstance().hook(true);
                        SevenZipUtils.getInstance().unzipWithMeta(this.f52976b.a.f52973c, this.f52976b.a.f52974d);
                        Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                        this.a = true;
                        int errorCode = SevenZipUtils.getInstance().getErrorCode();
                        if (errorCode != 0) {
                            LoadErrorCode.getInstance().set(100, "res=".concat(String.valueOf(errorCode)));
                        }
                        Thread thread = new Thread(new Runnable(this) { // from class: com.baidu.webkit.internal.blink.c.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    WebViewFactory.getProvider();
                                    this.a.a();
                                }
                            }
                        });
                        thread.setName("T7@BlinkUnzip");
                        thread.start();
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_UNZIP);
                        return;
                    }
                    LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                    StringBuilder sb = new StringBuilder("502:");
                    if (this.f52977c != null) {
                        z = false;
                    }
                    sb.append(z);
                    loadErrorCode.trace(sb.toString());
                    ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                    a();
                } catch (Throwable th) {
                    LoadErrorCode loadErrorCode2 = LoadErrorCode.getInstance();
                    loadErrorCode2.trace("518:" + th.toString());
                    a();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303841822, "Lcom/baidu/webkit/internal/blink/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(303841822, "Lcom/baidu/webkit/internal/blink/c;");
                return;
            }
        }
        f52968e = new Object();
        f52969f = new Object();
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a();
        this.a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f52972b = applicationContext;
            aVar.a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (c.class) {
                if (f52967b == null) {
                    f52967b = new c(context);
                }
                cVar = f52967b;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f52970c.isAlive() || this.f52970c.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f52970c.start();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (f52968e) {
                if (this.f52970c != null && this.a != null) {
                    d();
                }
            }
        }
    }

    public final void b() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f52968e) {
                try {
                    try {
                        if (this.a.a() && this.f52970c != null) {
                            d();
                            this.f52970c.join(15000L);
                            if (this.f52970c.a) {
                                this.f52970c = null;
                            } else {
                                LoadErrorCode.getInstance().set(102);
                                throw new TimeoutException("unzip task not finished.");
                            }
                        }
                    } catch (Exception e2) {
                        LoadErrorCode.getInstance().set(103);
                        throw e2;
                    }
                } finally {
                }
            }
        }
    }
}
