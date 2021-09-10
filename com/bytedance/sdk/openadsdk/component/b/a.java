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
    public static volatile a f65673a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final p f65674b;

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
        this.f65674b = o.f();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f65673a == null) {
                synchronized (a.class) {
                    if (f65673a == null) {
                        f65673a = new a();
                    }
                }
            }
            return f65673a;
        }
        return (a) invokeV.objValue;
    }

    public void b(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, adSlot, feedAdListener) == null) {
            this.f65674b.a(adSlot, new n(), 6, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f65680a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65681b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65682c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65683d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f65684e;

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
                    this.f65684e = this;
                    this.f65680a = feedAdListener;
                    this.f65681b = context;
                    this.f65682c = adSlot;
                    this.f65683d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65680a.onError(i2, str);
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
                                    arrayList.add(new c(this.f65681b, mVar, 6, this.f65682c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f65682c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65682c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65681b, c2.get(0), q.b(this.f65682c.getDurationSlotType()), this.f65683d);
                                this.f65680a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65680a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65680a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, adSlot, feedAdListener) == null) {
            this.f65674b.a(adSlot, new n(), 5, new p.b(this, feedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FeedAdListener f65675a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65676b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65677c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65678d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f65679e;

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
                    this.f65679e = this;
                    this.f65675a = feedAdListener;
                    this.f65676b = context;
                    this.f65677c = adSlot;
                    this.f65678d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65675a.onError(i2, str);
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
                                    arrayList.add(new c(this.f65676b, mVar, 5, this.f65677c));
                                }
                                if (!m.a(mVar) && m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(this.f65677c);
                                        bVar.a(mVar);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65677c);
                                        bVar.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65676b, c2.get(0), q.b(this.f65677c.getDurationSlotType()), this.f65678d);
                                this.f65675a.onFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65675a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65675a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }

    public void a(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, adSlot, drawFeedAdListener) == null) {
            this.f65674b.a(adSlot, new n(), 9, new p.b(this, drawFeedAdListener, context, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.DrawFeedAdListener f65685a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f65686b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65687c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65688d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f65689e;

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
                    this.f65689e = this;
                    this.f65685a = drawFeedAdListener;
                    this.f65686b = context;
                    this.f65687c = adSlot;
                    this.f65688d = r10;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65685a.onError(i2, str);
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
                                    arrayList.add(new b(this.f65686b, mVar, 9, this.f65687c));
                                }
                                if (m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                                    if (o.h().a(String.valueOf(q.d(mVar.ao()))) && o.h().M()) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar.a(mVar.V().i());
                                        bVar.a(mVar.V().m());
                                        bVar.b(mVar.V().l());
                                        bVar.c(CacheDirConstants.getFeedCacheDir());
                                        bVar.a(mVar);
                                        bVar.a(this.f65687c);
                                        bVar.b(mVar.V().d());
                                        bVar.a(this.f65687c);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                d.a(this.f65686b, c2.get(0), q.b(this.f65687c.getDurationSlotType()), this.f65688d);
                                this.f65685a.onDrawFeedAdLoad(arrayList);
                                return;
                            }
                            this.f65685a.onError(-4, g.a(-4));
                            return;
                        }
                        this.f65685a.onError(-3, g.a(-3));
                    }
                }
            });
        }
    }
}
