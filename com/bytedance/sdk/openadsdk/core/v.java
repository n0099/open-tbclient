package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class v implements TTAdNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p f67021a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f67022b;

    public v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67021a = o.f();
        this.f67022b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adSlot, bannerAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(bannerAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadBannerAd", aVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f67026a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67027b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67028c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, aVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67028c = this;
                    this.f67026a = aVar;
                    this.f67027b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67028c.a(this.f67026a)) {
                                return;
                            }
                            this.f67028c.c(this.f67027b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67028c.f67022b, this.f67027b, this.f67026a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67028c;
                            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.f67026a;
                            vVar.a(aVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
                        }
                    }
                }
            }, aVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(1, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, nativeExpressAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.g gVar = new com.bytedance.sdk.openadsdk.core.a.g(nativeExpressAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadBannerExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67051a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67052b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67053c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, gVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67053c = this;
                    this.f67051a = gVar;
                    this.f67052b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67053c.a(this.f67051a)) {
                                return;
                            }
                            if (!this.f67053c.a(this.f67052b, false)) {
                                this.f67051a.onError(110, g.a(110));
                                return;
                            }
                            this.f67052b.setNativeAdType(1);
                            this.f67052b.setDurationSlotType(1);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67053c.f67022b).a(this.f67052b, 1, this.f67051a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67053c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67051a;
                            vVar.a(gVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "Banner express error, pls check", th);
                        }
                    }
                }
            }, gVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(1, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadDrawFeedAd(AdSlot adSlot, @NonNull TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, drawFeedAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(drawFeedAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadDrawFeedAd", bVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f67060a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67061b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67062c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, bVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67062c = this;
                    this.f67060a = bVar;
                    this.f67061b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67062c.a(this.f67060a)) {
                                return;
                            }
                            this.f67062c.a(this.f67061b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67062c.f67022b, this.f67061b, this.f67060a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67062c;
                            com.bytedance.sdk.openadsdk.core.a.b bVar2 = this.f67060a;
                            vVar.a(bVar2, 4000, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                        }
                    }
                }
            }, bVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(9, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadExpressDrawFeedAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adSlot, nativeExpressAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.g gVar = new com.bytedance.sdk.openadsdk.core.a.g(nativeExpressAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadExpressDrawFeedAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67048a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67049b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67050c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, gVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67050c = this;
                    this.f67048a = gVar;
                    this.f67049b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67050c.a(this.f67048a)) {
                                return;
                            }
                            if (!this.f67050c.a(this.f67049b, false)) {
                                this.f67048a.onError(110, g.a(110));
                                return;
                            }
                            this.f67049b.setDurationSlotType(9);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67050c.f67022b).a(this.f67049b, 9, this.f67048a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67050c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67048a;
                            vVar.a(gVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "Error msg =", th);
                        }
                    }
                }
            }, gVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(9, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFeedAd(AdSlot adSlot, @NonNull TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, feedAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.c cVar = new com.bytedance.sdk.openadsdk.core.a.c(feedAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadFeedAd", cVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67023a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67024b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67025c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, cVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67025c = this;
                    this.f67023a = cVar;
                    this.f67024b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67025c.a(this.f67023a)) {
                                return;
                            }
                            this.f67025c.c(this.f67024b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67025c.f67022b, this.f67024b, this.f67023a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67025c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67023a;
                            vVar.a(cVar2, 4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, cVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(5, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadFullScreenVideoAd(AdSlot adSlot, @NonNull TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, adSlot, fullScreenVideoAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.d dVar = new com.bytedance.sdk.openadsdk.core.a.d(fullScreenVideoAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadFullScreenVideoAd", dVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f67042a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67043b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67044c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, dVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67044c = this;
                    this.f67042a = dVar;
                    this.f67043b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67044c.a(this.f67042a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67044c.f67022b, this.f67043b, this.f67042a);
                        } catch (Throwable th) {
                            v vVar = this.f67044c;
                            com.bytedance.sdk.openadsdk.core.a.d dVar2 = this.f67042a;
                            vVar.a(dVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                        }
                    }
                }
            }, dVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(8, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionAd(AdSlot adSlot, @NonNull TTAdNative.InteractionAdListener interactionAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, adSlot, interactionAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.e eVar = new com.bytedance.sdk.openadsdk.core.a.e(interactionAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadInteractionAd", eVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f67029a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67030b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67031c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, eVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67031c = this;
                    this.f67029a = eVar;
                    this.f67030b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67031c.a(this.f67029a)) {
                                return;
                            }
                            this.f67031c.c(this.f67030b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67031c.f67022b, this.f67030b, this.f67029a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67031c;
                            com.bytedance.sdk.openadsdk.core.a.e eVar2 = this.f67029a;
                            vVar.a(eVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
                        }
                    }
                }
            }, eVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(2, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadInteractionExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, adSlot, nativeExpressAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.g gVar = new com.bytedance.sdk.openadsdk.core.a.g(nativeExpressAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadInteractionExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67054a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67055b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67056c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, gVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67056c = this;
                    this.f67054a = gVar;
                    this.f67055b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67056c.a(this.f67054a)) {
                                return;
                            }
                            if (!this.f67056c.a(this.f67055b, false)) {
                                this.f67054a.onError(110, g.a(110));
                                return;
                            }
                            this.f67055b.setNativeAdType(2);
                            this.f67055b.setDurationSlotType(2);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67056c.f67022b).a(this.f67055b, 2, this.f67054a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67056c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67054a;
                            vVar.a(gVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "Interaction express Ad error, pls check", th);
                        }
                    }
                }
            }, gVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(2, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeAd(AdSlot adSlot, @NonNull TTAdNative.NativeAdListener nativeAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adSlot, nativeAdListener) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            adSlot.setDurationSlotType(adSlot.getNativeAdType());
            com.bytedance.sdk.openadsdk.core.a.f fVar = new com.bytedance.sdk.openadsdk.core.a.f(nativeAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadNativeAd", fVar, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.core.v.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f67063a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67064b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f67065c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67066d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, fVar, adSlot, Long.valueOf(currentTimeMillis)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67066d = this;
                    this.f67063a = fVar;
                    this.f67064b = adSlot;
                    this.f67065c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67066d.a(this.f67063a)) {
                                return;
                            }
                            this.f67066d.b(this.f67064b);
                            this.f67066d.f67021a.a(this.f67064b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f67064b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f67067a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f67067a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.p.b
                                public void a(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                        this.f67067a.f67063a.onError(i2, str);
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.p.b
                                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                                            List<com.bytedance.sdk.openadsdk.core.e.m> c2 = aVar.c();
                                            ArrayList arrayList = new ArrayList(c2.size());
                                            for (com.bytedance.sdk.openadsdk.core.e.m mVar : c2) {
                                                if (mVar.aK()) {
                                                    arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f67067a.f67066d.f67022b, mVar, this.f67067a.f67064b.getNativeAdType(), this.f67067a.f67064b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;

                                                        /* renamed from: a  reason: collision with root package name */
                                                        public final /* synthetic */ AnonymousClass1 f67068a;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(r11, mVar, r13, r14);
                                                            Interceptable interceptable4 = $ic;
                                                            if (interceptable4 != null) {
                                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                                newInitContext.initArgs = r2;
                                                                Object[] objArr = {this, r11, mVar, Integer.valueOf(r13), r14};
                                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                                int i2 = newInitContext.flag;
                                                                if ((i2 & 1) != 0) {
                                                                    int i3 = i2 & 2;
                                                                    Object[] objArr2 = newInitContext.callArgs;
                                                                    super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], ((Integer) objArr2[2]).intValue(), (AdSlot) objArr2[3]);
                                                                    newInitContext.thisArg = this;
                                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                                    return;
                                                                }
                                                            }
                                                            this.f67068a = this;
                                                        }
                                                    });
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f67067a.f67066d.f67022b, c2.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f67067a.f67064b.getDurationSlotType()), this.f67067a.f67065c);
                                                this.f67067a.f67063a.onNativeAdLoad(arrayList);
                                                return;
                                            }
                                            this.f67067a.f67063a.onError(-4, g.a(-4));
                                            return;
                                        }
                                        this.f67067a.f67063a.onError(-3, g.a(-3));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            v vVar = this.f67066d;
                            com.bytedance.sdk.openadsdk.core.a.f fVar2 = this.f67063a;
                            vVar.a(fVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "Error msg = ", th.getMessage());
                        }
                    }
                }
            }, fVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadNativeExpressAd(AdSlot adSlot, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, adSlot, nativeExpressAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.g gVar = new com.bytedance.sdk.openadsdk.core.a.g(nativeExpressAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadNativeExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67045a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67046b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67047c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, gVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67047c = this;
                    this.f67045a = gVar;
                    this.f67046b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67047c.a(this.f67045a)) {
                                return;
                            }
                            if (this.f67047c.a(this.f67046b, false)) {
                                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67047c.f67022b).a(this.f67046b, 5, this.f67045a, 5000);
                            } else {
                                this.f67045a.onError(110, g.a(110));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67047c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67045a;
                            vVar.a(gVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "Error msg = ", th);
                        }
                    }
                }
            }, gVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(5, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadRewardVideoAd(AdSlot adSlot, @NonNull TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, adSlot, rewardVideoAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.h hVar = new com.bytedance.sdk.openadsdk.core.a.h(rewardVideoAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadRewardVideoAd", hVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f67039a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67040b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67041c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, hVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67041c = this;
                    this.f67039a = hVar;
                    this.f67040b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67041c.a(this.f67039a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67041c.f67022b, this.f67040b, this.f67039a);
                        } catch (Throwable th) {
                            v vVar = this.f67041c;
                            com.bytedance.sdk.openadsdk.core.a.h hVar2 = this.f67039a;
                            vVar.a(hVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, hVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(7, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, adSlot, splashAdListener, i2) == null) {
            com.bytedance.sdk.openadsdk.core.a.i iVar = new com.bytedance.sdk.openadsdk.core.a.i(splashAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadSplashAd b", iVar, adSlot, i2) { // from class: com.bytedance.sdk.openadsdk.core.v.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67032a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67033b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f67034c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67035d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, iVar, adSlot, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67035d = this;
                    this.f67032a = iVar;
                    this.f67033b = adSlot;
                    this.f67034c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67035d.a(this.f67032a)) {
                                return;
                            }
                            this.f67035d.c(this.f67033b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67035d.f67022b, this.f67033b, this.f67032a, Integer.valueOf(this.f67034c));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67035d;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67032a;
                            vVar.a(iVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, iVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(3, adSlot);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadStream(AdSlot adSlot, @NonNull TTAdNative.FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, adSlot, feedAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.c cVar = new com.bytedance.sdk.openadsdk.core.a.c(feedAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadStream", cVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67057a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67058b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67059c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, cVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67059c = this;
                    this.f67057a = cVar;
                    this.f67058b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67059c.a(this.f67057a)) {
                                return;
                            }
                            this.f67059c.c(this.f67058b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67059c.f67022b, this.f67058b, this.f67057a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67059c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67057a;
                            vVar.a(cVar2, 4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, cVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(6, adSlot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, adSlot) == null) {
            a(adSlot);
            com.bytedance.sdk.component.utils.p.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, adSlot) == null) {
            a(adSlot);
            com.bytedance.sdk.component.utils.p.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型， ");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.i iVar = new com.bytedance.sdk.openadsdk.core.a.i(splashAdListener);
            a(new com.bytedance.sdk.component.d.g(this, "loadSplashAd a", iVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67036a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67037b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67038c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, iVar, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67038c = this;
                    this.f67036a = iVar;
                    this.f67037b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67038c.a(this.f67036a)) {
                                return;
                            }
                            this.f67038c.c(this.f67037b);
                            if (!this.f67038c.a(this.f67037b, true)) {
                                this.f67036a.onError(110, g.a(110));
                                return;
                            }
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67038c.f67022b, this.f67037b, this.f67036a, -1);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67038c;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67036a;
                            vVar.a(iVar2, 4000, " msg = " + th.getMessage());
                            com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, iVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(3, adSlot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, adSlot) == null) {
            com.bytedance.sdk.component.utils.p.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
            com.bytedance.sdk.component.utils.p.a(adSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.bytedance.sdk.openadsdk.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bVar)) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return false;
            }
            if (bVar != null) {
                bVar.onError(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdSlot adSlot, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, adSlot, z)) == null) {
            if (adSlot == null) {
                return false;
            }
            return (z && !o.h().i(adSlot.getCodeId())) || adSlot.getExpressViewAcceptedWidth() > 0.0f;
        }
        return invokeLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.c.b bVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, i2, str) == null) || bVar == null) {
            return;
        }
        bVar.onError(i2, str);
        com.bytedance.sdk.component.utils.k.c("TTAdNativeImpl", " msg = ", str);
    }

    private void a(com.bytedance.sdk.component.d.g gVar, com.bytedance.sdk.openadsdk.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, gVar, bVar) == null) {
            if (!l.f66741c) {
                com.bytedance.sdk.component.utils.k.f("TTAdNativeImpl", "please exec TTAdSdk.init before load ad");
                if (bVar != null) {
                    bVar.onError(10000, "Please exec TTAdSdk.init before load ad");
                    return;
                }
                return;
            }
            l.c().post(gVar);
        }
    }
}
