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
    public final p f67332a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f67333b;

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
        this.f67332a = o.f();
        this.f67333b = context;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f67337a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67338b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67339c;

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
                    this.f67339c = this;
                    this.f67337a = aVar;
                    this.f67338b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67339c.a(this.f67337a)) {
                                return;
                            }
                            this.f67339c.c(this.f67338b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67339c.f67333b, this.f67338b, this.f67337a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67339c;
                            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.f67337a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67362a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67363b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67364c;

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
                    this.f67364c = this;
                    this.f67362a = gVar;
                    this.f67363b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67364c.a(this.f67362a)) {
                                return;
                            }
                            if (!this.f67364c.a(this.f67363b, false)) {
                                this.f67362a.onError(110, g.a(110));
                                return;
                            }
                            this.f67363b.setNativeAdType(1);
                            this.f67363b.setDurationSlotType(1);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67364c.f67333b).a(this.f67363b, 1, this.f67362a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67364c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67362a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f67371a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67372b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67373c;

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
                    this.f67373c = this;
                    this.f67371a = bVar;
                    this.f67372b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67373c.a(this.f67371a)) {
                                return;
                            }
                            this.f67373c.a(this.f67372b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67373c.f67333b, this.f67372b, this.f67371a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67373c;
                            com.bytedance.sdk.openadsdk.core.a.b bVar2 = this.f67371a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67359a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67360b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67361c;

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
                    this.f67361c = this;
                    this.f67359a = gVar;
                    this.f67360b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67361c.a(this.f67359a)) {
                                return;
                            }
                            if (!this.f67361c.a(this.f67360b, false)) {
                                this.f67359a.onError(110, g.a(110));
                                return;
                            }
                            this.f67360b.setDurationSlotType(9);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67361c.f67333b).a(this.f67360b, 9, this.f67359a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67361c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67359a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67334a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67335b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67336c;

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
                    this.f67336c = this;
                    this.f67334a = cVar;
                    this.f67335b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67336c.a(this.f67334a)) {
                                return;
                            }
                            this.f67336c.c(this.f67335b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67336c.f67333b, this.f67335b, this.f67334a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67336c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67334a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f67353a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67354b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67355c;

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
                    this.f67355c = this;
                    this.f67353a = dVar;
                    this.f67354b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67355c.a(this.f67353a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67355c.f67333b, this.f67354b, this.f67353a);
                        } catch (Throwable th) {
                            v vVar = this.f67355c;
                            com.bytedance.sdk.openadsdk.core.a.d dVar2 = this.f67353a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f67340a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67341b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67342c;

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
                    this.f67342c = this;
                    this.f67340a = eVar;
                    this.f67341b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67342c.a(this.f67340a)) {
                                return;
                            }
                            this.f67342c.c(this.f67341b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67342c.f67333b, this.f67341b, this.f67340a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67342c;
                            com.bytedance.sdk.openadsdk.core.a.e eVar2 = this.f67340a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67365a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67366b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67367c;

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
                    this.f67367c = this;
                    this.f67365a = gVar;
                    this.f67366b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67367c.a(this.f67365a)) {
                                return;
                            }
                            if (!this.f67367c.a(this.f67366b, false)) {
                                this.f67365a.onError(110, g.a(110));
                                return;
                            }
                            this.f67366b.setNativeAdType(2);
                            this.f67366b.setDurationSlotType(2);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67367c.f67333b).a(this.f67366b, 2, this.f67365a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f67367c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67365a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f67374a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67375b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f67376c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67377d;

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
                    this.f67377d = this;
                    this.f67374a = fVar;
                    this.f67375b = adSlot;
                    this.f67376c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67377d.a(this.f67374a)) {
                                return;
                            }
                            this.f67377d.b(this.f67375b);
                            this.f67377d.f67332a.a(this.f67375b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f67375b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f67378a;

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
                                    this.f67378a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.p.b
                                public void a(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                        this.f67378a.f67374a.onError(i2, str);
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
                                                    arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f67378a.f67377d.f67333b, mVar, this.f67378a.f67375b.getNativeAdType(), this.f67378a.f67375b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;

                                                        /* renamed from: a  reason: collision with root package name */
                                                        public final /* synthetic */ AnonymousClass1 f67379a;

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
                                                            this.f67379a = this;
                                                        }
                                                    });
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f67378a.f67377d.f67333b, c2.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f67378a.f67375b.getDurationSlotType()), this.f67378a.f67376c);
                                                this.f67378a.f67374a.onNativeAdLoad(arrayList);
                                                return;
                                            }
                                            this.f67378a.f67374a.onError(-4, g.a(-4));
                                            return;
                                        }
                                        this.f67378a.f67374a.onError(-3, g.a(-3));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            v vVar = this.f67377d;
                            com.bytedance.sdk.openadsdk.core.a.f fVar2 = this.f67374a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f67356a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67357b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67358c;

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
                    this.f67358c = this;
                    this.f67356a = gVar;
                    this.f67357b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67358c.a(this.f67356a)) {
                                return;
                            }
                            if (this.f67358c.a(this.f67357b, false)) {
                                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f67358c.f67333b).a(this.f67357b, 5, this.f67356a, 5000);
                            } else {
                                this.f67356a.onError(110, g.a(110));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67358c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f67356a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f67350a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67351b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67352c;

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
                    this.f67352c = this;
                    this.f67350a = hVar;
                    this.f67351b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67352c.a(this.f67350a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f67352c.f67333b, this.f67351b, this.f67350a);
                        } catch (Throwable th) {
                            v vVar = this.f67352c;
                            com.bytedance.sdk.openadsdk.core.a.h hVar2 = this.f67350a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67343a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67344b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f67345c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f67346d;

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
                    this.f67346d = this;
                    this.f67343a = iVar;
                    this.f67344b = adSlot;
                    this.f67345c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67346d.a(this.f67343a)) {
                                return;
                            }
                            this.f67346d.c(this.f67344b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67346d.f67333b, this.f67344b, this.f67343a, Integer.valueOf(this.f67345c));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67346d;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67343a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f67368a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67369b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67370c;

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
                    this.f67370c = this;
                    this.f67368a = cVar;
                    this.f67369b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67370c.a(this.f67368a)) {
                                return;
                            }
                            this.f67370c.c(this.f67369b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f67370c.f67333b, this.f67369b, this.f67368a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67370c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f67368a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f67347a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f67348b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f67349c;

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
                    this.f67349c = this;
                    this.f67347a = iVar;
                    this.f67348b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f67349c.a(this.f67347a)) {
                                return;
                            }
                            this.f67349c.c(this.f67348b);
                            if (!this.f67349c.a(this.f67348b, true)) {
                                this.f67347a.onError(110, g.a(110));
                                return;
                            }
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f67349c.f67333b, this.f67348b, this.f67347a, -1);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f67349c;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f67347a;
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
            if (!l.f67052c) {
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
