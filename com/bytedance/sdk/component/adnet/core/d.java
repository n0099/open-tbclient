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
/* loaded from: classes9.dex */
public class d extends Thread {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f63912a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f63913b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f63914c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.a f63915d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.c f63916e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f63917f;

    /* renamed from: g  reason: collision with root package name */
    public final a f63918g;

    /* loaded from: classes9.dex */
    public static class a implements Request.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f63921a;

        /* renamed from: b  reason: collision with root package name */
        public final d f63922b;

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
            this.f63921a = new HashMap();
            this.f63922b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, request)) == null) {
                synchronized (this) {
                    String cacheKey = request.getCacheKey();
                    if (this.f63921a.containsKey(cacheKey)) {
                        List<Request<?>> list = this.f63921a.get(cacheKey);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        request.addMarker("waiting-for-response");
                        list.add(request);
                        this.f63921a.put(cacheKey, list);
                        if (o.f63980a) {
                            o.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                        }
                        return true;
                    }
                    this.f63921a.put(cacheKey, null);
                    request.a(this);
                    if (o.f63980a) {
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
                a.C1878a c1878a = mVar.f63973b;
                if (c1878a != null && !c1878a.a()) {
                    String cacheKey = request.getCacheKey();
                    synchronized (this) {
                        remove = this.f63921a.remove(cacheKey);
                    }
                    if (remove != null) {
                        if (o.f63980a) {
                            o.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                        }
                        for (Request<?> request2 : remove) {
                            this.f63922b.f63916e.a(request2, mVar);
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
                    List<Request<?>> remove = this.f63921a.remove(cacheKey);
                    if (remove != null && !remove.isEmpty()) {
                        if (o.f63980a) {
                            o.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                        }
                        Request<?> remove2 = remove.remove(0);
                        this.f63921a.put(cacheKey, remove);
                        remove2.a(this);
                        try {
                            this.f63922b.f63914c.put(remove2);
                        } catch (InterruptedException e2) {
                            o.c("Couldn't add request to queue. %s", e2.toString());
                            Thread.currentThread().interrupt();
                            this.f63922b.a();
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
        f63912a = o.f63980a;
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
        this.f63917f = false;
        this.f63913b = blockingQueue;
        this.f63914c = blockingQueue2;
        this.f63915d = aVar;
        this.f63916e = cVar;
        this.f63918g = new a(this);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        if (f63912a) {
            o.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f63915d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f63917f) {
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
            a(this.f63913b.take());
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63917f = true;
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
            a.C1878a a2 = this.f63915d.a(request.getCacheKey());
            if (a2 == null) {
                request.addMarker("cache-miss");
                if (!this.f63918g.b(request)) {
                    this.f63914c.put(request);
                }
            } else if (a2.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a2);
                if (!this.f63918g.b(request)) {
                    this.f63914c.put(request);
                }
            } else {
                request.addMarker("cache-hit");
                m<?> a3 = request.a(new i(a2.f64004b, a2.f64010h));
                request.addMarker("cache-hit-parsed");
                if (!a2.b()) {
                    this.f63916e.a(request, a3);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(a2);
                    a3.f63975d = true;
                    if (!this.f63918g.b(request)) {
                        this.f63916e.a(request, a3, new Runnable(this, request) { // from class: com.bytedance.sdk.component.adnet.core.d.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Request f63919a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ d f63920b;

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
                                this.f63920b = this;
                                this.f63919a = request;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.f63920b.f63914c.put(this.f63919a);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            }
                        });
                    } else {
                        this.f63916e.a(request, a3);
                    }
                }
            }
        }
    }
}
