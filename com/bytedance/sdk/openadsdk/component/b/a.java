package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f29414a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f29415b;

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
                return;
            }
        }
        this.f29415b = o.f();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f29414a == null) {
                synchronized (a.class) {
                    if (f29414a == null) {
                        f29414a = new a();
                    }
                }
            }
            return f29414a;
        }
        return (a) invokeV.objValue;
    }

    public void b(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, adSlot, feedAdListener) == null) {
            this.f29415b.a(adSlot, new n(), 6, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f29421a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29422b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29423c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29424d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29425e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, feedAdListener, context, adSlot, Long.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29425e = this;
                    this.f29421a = feedAdListener;
                    this.f29422b = context;
                    this.f29423c = adSlot;
                    this.f29424d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29421a.onError(i2, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            List<m> c2 = aVar.c();
                            ArrayList arrayList = new ArrayList(c2.size());
                            for (m mVar : c2) {
                                if (mVar.aK()) {
                                    arrayList.add(new c(this.f29422b, mVar, 6, this.f29423c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f29423c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f29423c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29422b, c2.get(0), q.b(this.f29423c.getDurationSlotType()), this.f29424d);
                                this.f29421a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29421a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29421a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adSlot, feedAdListener) == null) {
            this.f29415b.a(adSlot, new n(), 5, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f29416a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29417b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29418c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29419d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29420e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, feedAdListener, context, adSlot, Long.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29420e = this;
                    this.f29416a = feedAdListener;
                    this.f29417b = context;
                    this.f29418c = adSlot;
                    this.f29419d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29416a.onError(i2, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            List<m> c2 = aVar.c();
                            ArrayList arrayList = new ArrayList(c2.size());
                            for (m mVar : c2) {
                                if (mVar.aK()) {
                                    arrayList.add(new c(this.f29417b, mVar, 5, this.f29418c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f29418c);
                                        bVar.a(mVar);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f29418c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29417b, c2.get(0), q.b(this.f29418c.getDurationSlotType()), this.f29419d);
                                this.f29416a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29416a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29416a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adSlot, drawFeedAdListener) == null) {
            this.f29415b.a(adSlot, new n(), 9, new p.b(this, drawFeedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.DrawFeedAdListener f29426a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29427b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29428c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29429d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29430e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, drawFeedAdListener, context, adSlot, Long.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29430e = this;
                    this.f29426a = drawFeedAdListener;
                    this.f29427b = context;
                    this.f29428c = adSlot;
                    this.f29429d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29426a.onError(i2, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            List<m> c2 = aVar.c();
                            ArrayList arrayList = new ArrayList(c2.size());
                            for (m mVar : c2) {
                                if (mVar.aK()) {
                                    arrayList.add(new b(this.f29427b, mVar, 9, this.f29428c));
                                }
                                if (m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(mVar);
                                        bVar.a(this.f29428c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f29428c);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29427b, c2.get(0), q.b(this.f29428c.getDurationSlotType()), this.f29429d);
                                this.f29426a.onDrawFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29426a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29426a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }
}
