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
    public final p f67367a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f67368b;

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
        this.f67367a = o.f();
        this.f67368b = context;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f67372a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67373b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67374c;

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
                    this.f67374c = this;
                    this.f67372a = aVar;
                    this.f67373b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67374c.a(this.f67372a)) {
                                return;
                            }
                            this.f67374c.c(this.f67373b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67374c.f67368b, this.f67373b, this.f67372a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67374c;
                            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.f67372a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67397a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67398b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67399c;

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
                    this.f67399c = this;
                    this.f67397a = gVar;
                    this.f67398b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67399c.a(this.f67397a)) {
                                return;
                            }
                            if (!this.f67399c.a(this.f67398b, false)) {
                                this.f67397a.onError(110, g.a(110));
                                return;
                            }
                            this.f67398b.setNativeAdType(1);
                            this.f67398b.setDurationSlotType(1);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67399c.f67368b).a(this.f67398b, 1, this.f67397a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67399c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67397a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f67406a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67407b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67408c;

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
                    this.f67408c = this;
                    this.f67406a = bVar;
                    this.f67407b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67408c.a(this.f67406a)) {
                                return;
                            }
                            this.f67408c.a(this.f67407b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67408c.f67368b, this.f67407b, this.f67406a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67408c;
                            com.bytedance.sdk.openadsdk.core.a.b bVar2 = this.f67406a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67394a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67395b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67396c;

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
                    this.f67396c = this;
                    this.f67394a = gVar;
                    this.f67395b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67396c.a(this.f67394a)) {
                                return;
                            }
                            if (!this.f67396c.a(this.f67395b, false)) {
                                this.f67394a.onError(110, g.a(110));
                                return;
                            }
                            this.f67395b.setDurationSlotType(9);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67396c.f67368b).a(this.f67395b, 9, this.f67394a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67396c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67394a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67369a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67370b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67371c;

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
                    this.f67371c = this;
                    this.f67369a = cVar;
                    this.f67370b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67371c.a(this.f67369a)) {
                                return;
                            }
                            this.f67371c.c(this.f67370b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67371c.f67368b, this.f67370b, this.f67369a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67371c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67369a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f67388a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67389b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67390c;

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
                    this.f67390c = this;
                    this.f67388a = dVar;
                    this.f67389b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67390c.a(this.f67388a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67390c.f67368b, this.f67389b, this.f67388a);
                        } catch (Throwable th) {
                            v vVar = this.f67390c;
                            com.bytedance.sdk.openadsdk.core.a.d dVar2 = this.f67388a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f67375a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67376b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67377c;

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
                    this.f67377c = this;
                    this.f67375a = eVar;
                    this.f67376b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67377c.a(this.f67375a)) {
                                return;
                            }
                            this.f67377c.c(this.f67376b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67377c.f67368b, this.f67376b, this.f67375a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67377c;
                            com.bytedance.sdk.openadsdk.core.a.e eVar2 = this.f67375a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67400a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67401b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67402c;

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
                    this.f67402c = this;
                    this.f67400a = gVar;
                    this.f67401b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67402c.a(this.f67400a)) {
                                return;
                            }
                            if (!this.f67402c.a(this.f67401b, false)) {
                                this.f67400a.onError(110, g.a(110));
                                return;
                            }
                            this.f67401b.setNativeAdType(2);
                            this.f67401b.setDurationSlotType(2);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67402c.f67368b).a(this.f67401b, 2, this.f67400a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67402c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67400a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f67409a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67410b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f67411c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67412d;

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
                    this.f67412d = this;
                    this.f67409a = fVar;
                    this.f67410b = adSlot;
                    this.f67411c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67412d.a(this.f67409a)) {
                                return;
                            }
                            this.f67412d.b(this.f67410b);
                            this.f67412d.f67367a.a(this.f67410b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f67410b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f67413a;

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
                                    this.f67413a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.p.b
                                public void a(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                        this.f67413a.f67409a.onError(i2, str);
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
                                                    arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f67413a.f67412d.f67368b, mVar, this.f67413a.f67410b.getNativeAdType(), this.f67413a.f67410b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;

                                                        /* renamed from: a  reason: collision with root package name */
                                                        public final /* synthetic */ AnonymousClass1 f67414a;

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
                                                            this.f67414a = this;
                                                        }
                                                    });
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f67413a.f67412d.f67368b, c2.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f67413a.f67410b.getDurationSlotType()), this.f67413a.f67411c);
                                                this.f67413a.f67409a.onNativeAdLoad(arrayList);
                                                return;
                                            }
                                            this.f67413a.f67409a.onError(-4, g.a(-4));
                                            return;
                                        }
                                        this.f67413a.f67409a.onError(-3, g.a(-3));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            v vVar = this.f67412d;
                            com.bytedance.sdk.openadsdk.core.a.f fVar2 = this.f67409a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67391a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67392b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67393c;

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
                    this.f67393c = this;
                    this.f67391a = gVar;
                    this.f67392b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67393c.a(this.f67391a)) {
                                return;
                            }
                            if (this.f67393c.a(this.f67392b, false)) {
                                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67393c.f67368b).a(this.f67392b, 5, this.f67391a, 5000);
                            } else {
                                this.f67391a.onError(110, g.a(110));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67393c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67391a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f67385a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67386b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67387c;

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
                    this.f67387c = this;
                    this.f67385a = hVar;
                    this.f67386b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67387c.a(this.f67385a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67387c.f67368b, this.f67386b, this.f67385a);
                        } catch (Throwable th) {
                            v vVar = this.f67387c;
                            com.bytedance.sdk.openadsdk.core.a.h hVar2 = this.f67385a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67378a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67379b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f67380c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67381d;

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
                    this.f67381d = this;
                    this.f67378a = iVar;
                    this.f67379b = adSlot;
                    this.f67380c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67381d.a(this.f67378a)) {
                                return;
                            }
                            this.f67381d.c(this.f67379b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67381d.f67368b, this.f67379b, this.f67378a, Integer.valueOf(this.f67380c));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67381d;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67378a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67403a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67404b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67405c;

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
                    this.f67405c = this;
                    this.f67403a = cVar;
                    this.f67404b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67405c.a(this.f67403a)) {
                                return;
                            }
                            this.f67405c.c(this.f67404b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67405c.f67368b, this.f67404b, this.f67403a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67405c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67403a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67382a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67383b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67384c;

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
                    this.f67384c = this;
                    this.f67382a = iVar;
                    this.f67383b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67384c.a(this.f67382a)) {
                                return;
                            }
                            this.f67384c.c(this.f67383b);
                            if (!this.f67384c.a(this.f67383b, true)) {
                                this.f67382a.onError(110, g.a(110));
                                return;
                            }
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67384c.f67368b, this.f67383b, this.f67382a, -1);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67384c;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67382a;
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
            if (!l.f67087c) {
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
