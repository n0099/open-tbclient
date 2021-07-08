package com.bytedance.sdk.component.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f28022a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Request<?>> f28023b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f28024c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<Request<?>> f28025d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.a f28026e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.b f28027f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.component.adnet.face.c f28028g;

    /* renamed from: h  reason: collision with root package name */
    public final h[] f28029h;

    /* renamed from: i  reason: collision with root package name */
    public d f28030i;
    public final List<b> j;
    public final List<a> k;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Request<?> request, int i2);
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface b<T> {
        void a(Request<T> request);
    }

    public l(com.bytedance.sdk.component.adnet.face.a aVar, com.bytedance.sdk.component.adnet.face.b bVar, int i2, com.bytedance.sdk.component.adnet.face.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, Integer.valueOf(i2), cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28022a = new AtomicInteger();
        this.f28023b = new HashSet();
        this.f28024c = new PriorityBlockingQueue<>();
        this.f28025d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f28026e = aVar;
        this.f28027f = bVar;
        this.f28029h = new h[i2];
        this.f28028g = cVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            d dVar = new d(this.f28024c, this.f28025d, this.f28026e, this.f28028g);
            this.f28030i = dVar;
            dVar.setName("tt_pangle_thread_CacheDispatcher");
            this.f28030i.start();
            for (int i2 = 0; i2 < this.f28029h.length; i2++) {
                h hVar = new h(this.f28025d, this.f28027f, this.f28026e, this.f28028g);
                hVar.setName("tt_pangle_thread_NetworkDispatcher" + i2);
                this.f28029h[i2] = hVar;
                hVar.start();
            }
        }
    }

    public void b() {
        h[] hVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d dVar = this.f28030i;
            if (dVar != null) {
                dVar.a();
            }
            for (h hVar : this.f28029h) {
                if (hVar != null) {
                    hVar.a();
                }
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28022a.incrementAndGet() : invokeV.intValue;
    }

    public <T> void c(Request<T> request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, request) == null) {
            synchronized (this.f28023b) {
                this.f28023b.remove(request);
            }
            synchronized (this.j) {
                for (b bVar : this.j) {
                    bVar.a(request);
                }
            }
            a(request, 5);
        }
    }

    public <T> void b(Request<T> request) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, request) == null) || request == null || TextUtils.isEmpty(request.getUrl())) {
            return;
        }
        String url = request.getUrl();
        if (com.bytedance.sdk.component.adnet.a.c() != null) {
            String a2 = com.bytedance.sdk.component.adnet.a.c().a(url);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            request.setUrl(a2);
        }
    }

    public <T> Request<T> a(Request<T> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            b(request);
            request.setStartTime();
            request.setRequestQueue(this);
            synchronized (this.f28023b) {
                this.f28023b.add(request);
            }
            request.setSequence(c());
            request.addMarker("add-to-queue");
            a(request, 0);
            if (!request.shouldCache()) {
                this.f28025d.add(request);
                return request;
            }
            this.f28024c.add(request);
            return request;
        }
        return (Request) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(com.bytedance.sdk.component.adnet.face.a aVar, com.bytedance.sdk.component.adnet.face.b bVar, int i2) {
        this(aVar, bVar, i2, new g(new Handler(Looper.getMainLooper())));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.bytedance.sdk.component.adnet.face.a) objArr2[0], (com.bytedance.sdk.component.adnet.face.b) objArr2[1], ((Integer) objArr2[2]).intValue(), (com.bytedance.sdk.component.adnet.face.c) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(com.bytedance.sdk.component.adnet.face.a aVar, com.bytedance.sdk.component.adnet.face.b bVar) {
        this(aVar, bVar, 4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.bytedance.sdk.component.adnet.face.a) objArr2[0], (com.bytedance.sdk.component.adnet.face.b) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(Request<?> request, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, request, i2) == null) {
            synchronized (this.k) {
                for (a aVar : this.k) {
                    aVar.a(request, i2);
                }
            }
        }
    }
}
