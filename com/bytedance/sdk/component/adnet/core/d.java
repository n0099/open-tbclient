package com.bytedance.sdk.component.adnet.core;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
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
/* loaded from: classes6.dex */
public class d extends Thread {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f27862a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f27863b;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<Request<?>> f27864c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.a f27865d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.c f27866e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f27867f;

    /* renamed from: g  reason: collision with root package name */
    public final a f27868g;

    /* loaded from: classes6.dex */
    public static class a implements Request.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<Request<?>>> f27871a;

        /* renamed from: b  reason: collision with root package name */
        public final d f27872b;

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
            this.f27871a = new HashMap();
            this.f27872b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, request)) == null) {
                synchronized (this) {
                    String cacheKey = request.getCacheKey();
                    if (this.f27871a.containsKey(cacheKey)) {
                        List<Request<?>> list = this.f27871a.get(cacheKey);
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        request.addMarker("waiting-for-response");
                        list.add(request);
                        this.f27871a.put(cacheKey, list);
                        if (o.f27929a) {
                            o.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                        }
                        return true;
                    }
                    this.f27871a.put(cacheKey, null);
                    request.a(this);
                    if (o.f27929a) {
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
                a.C0316a c0316a = mVar.f27922b;
                if (c0316a != null && !c0316a.a()) {
                    String cacheKey = request.getCacheKey();
                    synchronized (this) {
                        remove = this.f27871a.remove(cacheKey);
                    }
                    if (remove != null) {
                        if (o.f27929a) {
                            o.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                        }
                        for (Request<?> request2 : remove) {
                            this.f27872b.f27866e.a(request2, mVar);
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
                    List<Request<?>> remove = this.f27871a.remove(cacheKey);
                    if (remove != null && !remove.isEmpty()) {
                        if (o.f27929a) {
                            o.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                        }
                        Request<?> remove2 = remove.remove(0);
                        this.f27871a.put(cacheKey, remove);
                        remove2.a(this);
                        try {
                            this.f27872b.f27864c.put(remove2);
                        } catch (InterruptedException e2) {
                            o.c("Couldn't add request to queue. %s", e2.toString());
                            Thread.currentThread().interrupt();
                            this.f27872b.a();
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
        f27862a = o.f27929a;
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
        this.f27867f = false;
        this.f27863b = blockingQueue;
        this.f27864c = blockingQueue2;
        this.f27865d = aVar;
        this.f27866e = cVar;
        this.f27868g = new a(this);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        if (f27862a) {
            o.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f27865d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f27867f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            a(this.f27863b.take());
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27867f = true;
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
            a.C0316a a2 = this.f27865d.a(request.getCacheKey());
            if (a2 == null) {
                request.addMarker("cache-miss");
                if (!this.f27868g.b(request)) {
                    this.f27864c.put(request);
                }
            } else if (a2.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(a2);
                if (!this.f27868g.b(request)) {
                    this.f27864c.put(request);
                }
            } else {
                request.addMarker("cache-hit");
                m<?> a3 = request.a(new i(a2.f27957b, a2.f27963h));
                request.addMarker("cache-hit-parsed");
                if (!a2.b()) {
                    this.f27866e.a(request, a3);
                } else {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(a2);
                    a3.f27924d = true;
                    if (!this.f27868g.b(request)) {
                        this.f27866e.a(request, a3, new Runnable(this, request) { // from class: com.bytedance.sdk.component.adnet.core.d.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Request f27869a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ d f27870b;

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
                                this.f27870b = this;
                                this.f27869a = request;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.f27870b.f27864c.put(this.f27869a);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            }
                        });
                    } else {
                        this.f27866e.a(request, a3);
                    }
                }
            }
        }
    }
}
