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
    public static volatile a f65984a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f65985b;

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
        this.f65985b = o.f();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f65984a == null) {
                synchronized (a.class) {
                    if (f65984a == null) {
                        f65984a = new a();
                    }
                }
            }
            return f65984a;
        }
        return (a) invokeV.objValue;
    }

    public void b(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, adSlot, feedAdListener) == null) {
            this.f65985b.a(adSlot, new n(), 6, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f65991a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65992b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65993c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65994d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f65995e;

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
                    this.f65995e = this;
                    this.f65991a = feedAdListener;
                    this.f65992b = context;
                    this.f65993c = adSlot;
                    this.f65994d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65991a.onError(i2, str);
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
                                    arrayList.add(new c(this.f65992b, mVar, 6, this.f65993c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f65993c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65993c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65992b, c2.get(0), q.b(this.f65993c.getDurationSlotType()), this.f65994d);
                                this.f65991a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65991a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65991a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adSlot, feedAdListener) == null) {
            this.f65985b.a(adSlot, new n(), 5, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f65986a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65987b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65988c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65989d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f65990e;

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
                    this.f65990e = this;
                    this.f65986a = feedAdListener;
                    this.f65987b = context;
                    this.f65988c = adSlot;
                    this.f65989d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65986a.onError(i2, str);
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
                                    arrayList.add(new c(this.f65987b, mVar, 5, this.f65988c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f65988c);
                                        bVar.a(mVar);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65988c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65987b, c2.get(0), q.b(this.f65988c.getDurationSlotType()), this.f65989d);
                                this.f65986a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65986a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65986a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adSlot, drawFeedAdListener) == null) {
            this.f65985b.a(adSlot, new n(), 9, new p.b(this, drawFeedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.DrawFeedAdListener f65996a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65997b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65998c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65999d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f66000e;

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
                    this.f66000e = this;
                    this.f65996a = drawFeedAdListener;
                    this.f65997b = context;
                    this.f65998c = adSlot;
                    this.f65999d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65996a.onError(i2, str);
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
                                    arrayList.add(new b(this.f65997b, mVar, 9, this.f65998c));
                                }
                                if (m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(mVar);
                                        bVar.a(this.f65998c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65998c);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65997b, c2.get(0), q.b(this.f65998c.getDurationSlotType()), this.f65999d);
                                this.f65996a.onDrawFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65996a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65996a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }
}
