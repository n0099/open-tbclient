package com.bytedance.sdk.component.adnet.core;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.face.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes5.dex */
public class d extends Thread {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f28070a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f28071b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f28072c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.a f28073d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.c f28074e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f28075f;

    /* renamed from: g  reason: collision with root package name */
    public final a f28076g;

    /* loaded from: classes5.dex */
    public static class a implements Request.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f28079a;

        /* renamed from: b  reason: collision with root package name */
        public final d f28080b;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28079a = new HashMap();
            this.f28080b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, request)) == null) {
                synchronized (this) {
                    String cacheKey = request.getCacheKey();
                    if (this.f28079a.containsKey(cacheKey)) {
                        List<Request<?>> list = this.f28079a.get(cacheKey);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        request.addMarker("waiting-for-response");
                        list.add(request);
                        this.f28079a.put(cacheKey, list);
                        if (o.f28137a) {
                            o.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                        }
                        return true;
                    }
                    this.f28079a.put(cacheKey, null);
                    request.a(this);
                    if (o.f28137a) {
                        o.b("new request, sending to network %s", cacheKey);
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // com.bytedance.sdk.component.adnet.core.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, mVar) == null) {
                a.C0318a c0318a = mVar.f28130b;
                if (c0318a != null && !c0318a.a()) {
                    String cacheKey = request.getCacheKey();
                    synchronized (this) {
                        remove = this.f28079a.remove(cacheKey);
                    }
                    if (remove != null) {
                        if (o.f28137a) {
                            o.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                        }
                        for (Request<?> request2 : remove) {
                            this.f28080b.f28074e.a(request2, mVar);
                        }
                        return;
                    }
                    return;
                }
                a(request);
            }
        }

        @Override // com.bytedance.sdk.component.adnet.core.Request.a
        public synchronized void a(Request<?> request) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, request) == null) {
                synchronized (this) {
                    String cacheKey = request.getCacheKey();
                    List<Request<?>> remove = this.f28079a.remove(cacheKey);
                    if (remove != null && !remove.isEmpty()) {
                        if (o.f28137a) {
                            o.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                        }
                        Request<?> remove2 = remove.remove(0);
                        this.f28079a.put(cacheKey, remove);
                        remove2.a(this);
                        try {
                            this.f28080b.f28072c.put(remove2);
                        } catch (InterruptedException e2) {
                            o.c("Couldn't add request to queue. %s", e2.toString());
                            Thread.currentThread().interrupt();
                            this.f28080b.a();
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8116397, "Lcom/bytedance/sdk/component/adnet/core/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(8116397, "Lcom/bytedance/sdk/component/adnet/core/d;");
                return;
            }
        }
        f28070a = o.f28137a;
    }

    public d(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.component.adnet.face.a aVar, com.bytedance.sdk.component.adnet.face.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {blockingQueue, blockingQueue2, aVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28075f = false;
        this.f28071b = blockingQueue;
        this.f28072c = blockingQueue2;
        this.f28073d = aVar;
        this.f28074e = cVar;
        this.f28076g = new a(this);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        if (f28070a) {
            o.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f28073d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f28075f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            a(this.f28071b.take());
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28075f = true;
            interrupt();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, NEW_ARRAY, CONST, INVOKE, APUT, INVOKE, CONST, CONSTRUCTOR, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @VisibleForTesting
    public void a(Request<?> request) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request) == null) {
            request.addMarker("cache-queue-take");
            request.a(1);
            try {
            } finally {
                try {
                } finally {
                }
            }
            if (request.isCanceled()) {
                request.a("cache-discard-canceled");
                return;
            }
            a.C0318a a2 = this.f28073d.a(request.getCacheKey());
            if (a2 == null) {
                request.addMarker("cache-miss");
                if (!this.f28076g.b(request)) {
                    this.f28072c.put(request);
                }
            } else if (a2.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a2);
                if (!this.f28076g.b(request)) {
                    this.f28072c.put(request);
                }
            } else {
                request.addMarker("cache-hit");
                m<?> a3 = request.a(new i(a2.f28161b, a2.f28167h));
                request.addMarker("cache-hit-parsed");
                if (!a2.b()) {
                    this.f28074e.a(request, a3);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(a2);
                    a3.f28132d = true;
                    if (!this.f28076g.b(request)) {
                        this.f28074e.a(request, a3, new Runnable(this, request) { // from class: com.bytedance.sdk.component.adnet.core.d.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Request f28077a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ d f28078b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, request};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f28078b = this;
                                this.f28077a = request;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.f28078b.f28072c.put(this.f28077a);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            }
                        });
                    } else {
                        this.f28074e.a(request, a3);
                    }
                }
            }
        }
    }
}
