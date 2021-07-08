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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f29314a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f29315b;

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
        this.f29315b = o.f();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f29314a == null) {
                synchronized (a.class) {
                    if (f29314a == null) {
                        f29314a = new a();
                    }
                }
            }
            return f29314a;
        }
        return (a) invokeV.objValue;
    }

    public void b(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, adSlot, feedAdListener) == null) {
            this.f29315b.a(adSlot, new n(), 6, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f29321a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29322b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29323c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29324d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29325e;

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
                    this.f29325e = this;
                    this.f29321a = feedAdListener;
                    this.f29322b = context;
                    this.f29323c = adSlot;
                    this.f29324d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29321a.onError(i2, str);
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
                                    arrayList.add(new c(this.f29322b, mVar, 6, this.f29323c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()))) && o.h().N()) {
                                        com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.b(mVar.V().d());
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29322b, c2.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f29323c.getDurationSlotType()), this.f29324d);
                                this.f29321a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29321a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29321a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adSlot, feedAdListener) == null) {
            this.f29315b.a(adSlot, new n(), 5, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f29316a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29317b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29318c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29319d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29320e;

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
                    this.f29320e = this;
                    this.f29316a = feedAdListener;
                    this.f29317b = context;
                    this.f29318c = adSlot;
                    this.f29319d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29316a.onError(i2, str);
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
                                    arrayList.add(new c(this.f29317b, mVar, 5, this.f29318c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()))) && o.h().N()) {
                                        com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.b(mVar.V().d());
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29317b, c2.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f29318c.getDurationSlotType()), this.f29319d);
                                this.f29316a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29316a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29316a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adSlot, drawFeedAdListener) == null) {
            this.f29315b.a(adSlot, new n(), 9, new p.b(this, drawFeedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.DrawFeedAdListener f29326a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f29327b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29328c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29329d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f29330e;

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
                    this.f29330e = this;
                    this.f29326a = drawFeedAdListener;
                    this.f29327b = context;
                    this.f29328c = adSlot;
                    this.f29329d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29326a.onError(i2, str);
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
                                    arrayList.add(new b(this.f29327b, mVar, 9, this.f29328c));
                                }
                                if (m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()))) && o.h().N()) {
                                        com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.b(mVar.V().d());
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f29327b, c2.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f29328c.getDurationSlotType()), this.f29329d);
                                this.f29326a.onDrawFeedAdLoad(arrayList);
                                return;
                            }
                            this.f29326a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f29326a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }
}
