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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f66019a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f66020b;

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
        this.f66020b = o.f();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f66019a == null) {
                synchronized (a.class) {
                    if (f66019a == null) {
                        f66019a = new a();
                    }
                }
            }
            return f66019a;
        }
        return (a) invokeV.objValue;
    }

    public void b(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, adSlot, feedAdListener) == null) {
            this.f66020b.a(adSlot, new n(), 6, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f66026a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f66027b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66028c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f66029d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f66030e;

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
                    this.f66030e = this;
                    this.f66026a = feedAdListener;
                    this.f66027b = context;
                    this.f66028c = adSlot;
                    this.f66029d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f66026a.onError(i2, str);
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
                                    arrayList.add(new c(this.f66027b, mVar, 6, this.f66028c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f66028c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f66028c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f66027b, c2.get(0), q.b(this.f66028c.getDurationSlotType()), this.f66029d);
                                this.f66026a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f66026a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f66026a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adSlot, feedAdListener) == null) {
            this.f66020b.a(adSlot, new n(), 5, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f66021a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f66022b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66023c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f66024d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f66025e;

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
                    this.f66025e = this;
                    this.f66021a = feedAdListener;
                    this.f66022b = context;
                    this.f66023c = adSlot;
                    this.f66024d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f66021a.onError(i2, str);
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
                                    arrayList.add(new c(this.f66022b, mVar, 5, this.f66023c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f66023c);
                                        bVar.a(mVar);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f66023c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f66022b, c2.get(0), q.b(this.f66023c.getDurationSlotType()), this.f66024d);
                                this.f66021a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f66021a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f66021a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adSlot, drawFeedAdListener) == null) {
            this.f66020b.a(adSlot, new n(), 9, new p.b(this, drawFeedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.DrawFeedAdListener f66031a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f66032b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66033c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f66034d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f66035e;

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
                    this.f66035e = this;
                    this.f66031a = drawFeedAdListener;
                    this.f66032b = context;
                    this.f66033c = adSlot;
                    this.f66034d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f66031a.onError(i2, str);
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
                                    arrayList.add(new b(this.f66032b, mVar, 9, this.f66033c));
                                }
                                if (m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(mVar);
                                        bVar.a(this.f66033c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f66033c);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f66032b, c2.get(0), q.b(this.f66033c.getDurationSlotType()), this.f66034d);
                                this.f66031a.onDrawFeedAdLoad(arrayList);
                                return;
                            }
                            this.f66031a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f66031a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }
}
