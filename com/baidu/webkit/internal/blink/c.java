package com.baidu.webkit.internal.blink;

import android.content.Context;
import android.os.Handler;
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
/* loaded from: classes11.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f60966e;

    /* renamed from: f  reason: collision with root package name */
    public static c f60967f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f60968g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f60969a;

    /* renamed from: b  reason: collision with root package name */
    public b f60970b;

    /* renamed from: c  reason: collision with root package name */
    public WebViewFactory.WebKitUnzipCallback f60971c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f60972d;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f60974a;

        /* renamed from: b  reason: collision with root package name */
        public Context f60975b;

        /* renamed from: c  reason: collision with root package name */
        public String f60976c;

        /* renamed from: d  reason: collision with root package name */
        public String f60977d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f60978e;

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

        public final synchronized void a(boolean z) {
            StringBuilder sb;
            String sb2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this) {
                    if (z != this.f60978e) {
                        this.f60978e = z;
                    }
                    if (this.f60978e) {
                        if (this.f60975b.getFilesDir() == null) {
                            sb2 = null;
                        } else {
                            if (this.f60975b.getApplicationInfo().nativeLibraryDir != null) {
                                sb = new StringBuilder();
                                sb.append(this.f60975b.getApplicationInfo().nativeLibraryDir);
                                sb.append("/libzeuswebviewchromium.so");
                            } else {
                                sb = new StringBuilder();
                                sb.append(this.f60975b.getFilesDir().getParent());
                                sb.append("/lib/libzeuswebviewchromium.so");
                            }
                            sb2 = sb.toString();
                        }
                        this.f60976c = sb2;
                        this.f60977d = this.f60974a + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
                    }
                }
            }
        }

        public final synchronized boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    z = this.f60978e;
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f60979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f60980b;

        /* renamed from: c  reason: collision with root package name */
        public Context f60981c;

        public b(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60980b = cVar;
            this.f60981c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f60979a = true;
                synchronized (c.f60968g) {
                    if (this.f60980b.f60971c != null) {
                        this.f60980b.f60971c.unzipFinished();
                        this.f60980b.f60971c = null;
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
                    if (this.f60981c != null && SevenZipUtils.getInstance().prepare(this.f60981c, this.f60980b.f60969a.f60976c, this.f60980b.f60969a.f60977d)) {
                        ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.Start, ZeusPerformanceTiming.KEY_UNZIP);
                        SevenZipUtils.getInstance().hook(true);
                        SevenZipUtils.getInstance().unzipWithMeta(this.f60980b.f60969a.f60976c, this.f60980b.f60969a.f60977d);
                        Log.i("BlinkUnzipManager", "[perf][startup][unzip] finish.");
                        this.f60979a = true;
                        int errorCode = SevenZipUtils.getInstance().getErrorCode();
                        if (errorCode != 0) {
                            LoadErrorCode.getInstance().set(100, "res=".concat(String.valueOf(errorCode)));
                        }
                        Thread thread = new Thread(new Runnable(this) { // from class: com.baidu.webkit.internal.blink.c.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ b f60982a;

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
                                this.f60982a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    WebViewFactory.getProvider();
                                    this.f60982a.a();
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
                    if (this.f60981c != null) {
                        z = false;
                    }
                    sb.append(z);
                    loadErrorCode.trace(sb.toString());
                    ZeusWebViewPreloadClass.getInstance().setIsWebkitNeedUnzipSO(false);
                    a();
                } catch (Throwable unused) {
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
        f60966e = new Object();
        f60968g = new Object();
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
        this.f60969a = aVar;
        try {
            Context applicationContext = context.getApplicationContext();
            aVar.f60975b = applicationContext;
            aVar.f60974a = applicationContext.getFilesDir().toString();
        } catch (Exception unused) {
        }
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (c.class) {
                if (f60967f == null) {
                    f60967f = new c(context);
                }
                cVar = f60967f;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f60970b.isAlive() || this.f60970b.getState() == Thread.State.TERMINATED) {
            return;
        }
        Log.i("BlinkUnzipManager", "[perf][startup][unzip] start task");
        this.f60970b.start();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (f60966e) {
                if (this.f60970b != null && this.f60969a != null) {
                    d();
                }
            }
        }
    }

    public final void b() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f60966e) {
                try {
                    try {
                        if (this.f60969a.a() && this.f60970b != null) {
                            d();
                            this.f60970b.join(15000L);
                            if (this.f60970b.f60979a) {
                                this.f60970b = null;
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
