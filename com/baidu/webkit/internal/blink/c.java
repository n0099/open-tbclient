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
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f54840b;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f54841e;

    /* renamed from: f  reason: collision with root package name */
    public static final Object f54842f;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: c  reason: collision with root package name */
    public b f54843c;

    /* renamed from: d  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f54844d;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Context f54845b;

        /* renamed from: c  reason: collision with root package name */
        public String f54846c;

        /* renamed from: d  reason: collision with root package name */
        public String f54847d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54848e;

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
                    z = this.f54848e;
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
                    if (this.f54848e) {
                        this.f54848e = false;
                    }
                    if (this.f54848e) {
                        if (this.f54845b.getFilesDir() == null) {
                            sb2 = null;
                        } else {
                            if (this.f54845b.getApplicationInfo().nativeLibraryDir != null) {
                                sb = new StringBuilder();
                                sb.append(this.f54845b.getApplicationInfo().nativeLibraryDir);
                                sb.append("/libzeuswebviewchromium.so");
                            } else {
                                sb = new StringBuilder();
                                sb.append(this.f54845b.getFilesDir().getParent());
                                sb.append("/lib/libzeuswebviewchromium.so");
                            }
                            sb2 = sb.toString();
                        }
                        this.f54846c = sb2;
                        this.f54847d = this.a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f54849b;

        /* renamed from: c  reason: collision with root package name */
        public Context f54850c;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, this) == null) {
                this.a = true;
                synchronized (c.f54842f) {
                    if (this.f54849b.f54844d != null) {
                        this.f54849b.f54844d.unzipFinished();
                        this.f54849b.f54844d = null;
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
                    if (this.f54850c != null && SevenZipUtils.getInstance().prepare(this.f54850c, this.f54849b.a.f54846c, this.f54849b.a.f54847d)) {
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                        SevenZipUtils.getInstance().hook(true);
                        SevenZipUtils.getInstance().unzipWithMeta(this.f54849b.a.f54846c, this.f54849b.a.f54847d);
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
                    if (this.f54850c != null) {
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
        f54841e = new Object();
        f54842f = new Object();
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
            aVar.f54845b = applicationContext;
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
                if (f54840b == null) {
                    f54840b = new c(context);
                }
                cVar = f54840b;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f54843c.isAlive() || this.f54843c.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f54843c.start();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (f54841e) {
                if (this.f54843c != null && this.a != null) {
                    d();
                }
            }
        }
    }

    public final void b() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f54841e) {
                try {
                    try {
                        if (this.a.a() && this.f54843c != null) {
                            d();
                            this.f54843c.join(15000L);
                            if (this.f54843c.a) {
                                this.f54843c = null;
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
