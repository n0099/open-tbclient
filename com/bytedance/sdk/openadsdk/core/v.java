package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class v implements TTAdNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p f30544a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30545b;

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
        this.f30544a = o.f();
        this.f30545b = context;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadBannerAd(AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adSlot, bannerAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(bannerAdListener);
            a(new com.bytedance.sdk.component.e.g(this, "loadBannerAd", aVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f30549a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30550b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30551c;

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
                    this.f30551c = this;
                    this.f30549a = aVar;
                    this.f30550b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30551c.a(this.f30549a)) {
                        return;
                    }
                    this.f30551c.c(this.f30550b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30551c.f30545b, this.f30550b, this.f30549a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "banner component maybe not exist, pls check", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadBannerExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30574a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30575b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30576c;

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
                    this.f30576c = this;
                    this.f30574a = gVar;
                    this.f30575b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30576c.a(this.f30574a)) {
                        return;
                    }
                    if (!this.f30576c.a(this.f30575b, false)) {
                        this.f30574a.onError(110, g.a(110));
                        return;
                    }
                    this.f30575b.setNativeAdType(1);
                    this.f30575b.setDurationSlotType(1);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30576c.f30545b).a(this.f30575b, 1, this.f30574a, 5000);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadDrawFeedAd", bVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f30583a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30584b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30585c;

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
                    this.f30585c = this;
                    this.f30583a = bVar;
                    this.f30584b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30585c.a(this.f30583a)) {
                        return;
                    }
                    this.f30585c.a(this.f30584b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30585c.f30545b, this.f30584b, this.f30583a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadExpressDrawFeedAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30571a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30572b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30573c;

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
                    this.f30573c = this;
                    this.f30571a = gVar;
                    this.f30572b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30573c.a(this.f30571a)) {
                        return;
                    }
                    if (!this.f30573c.a(this.f30572b, false)) {
                        this.f30571a.onError(110, g.a(110));
                        return;
                    }
                    this.f30572b.setDurationSlotType(9);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30573c.f30545b).a(this.f30572b, 9, this.f30571a, 5000);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadFeedAd", cVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f30546a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30547b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30548c;

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
                    this.f30548c = this;
                    this.f30546a = cVar;
                    this.f30547b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30548c.a(this.f30546a)) {
                        return;
                    }
                    this.f30548c.c(this.f30547b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30548c.f30545b, this.f30547b, this.f30546a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadFullScreenVideoAd", dVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f30565a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30566b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30567c;

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
                    this.f30567c = this;
                    this.f30565a = dVar;
                    this.f30566b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30567c.a(this.f30565a)) {
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30567c.f30545b, this.f30566b, this.f30565a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadInteractionAd", eVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f30552a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30553b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30554c;

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
                    this.f30554c = this;
                    this.f30552a = eVar;
                    this.f30553b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30554c.a(this.f30552a)) {
                        return;
                    }
                    this.f30554c.c(this.f30553b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30554c.f30545b, this.f30553b, this.f30552a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "interaction component maybe not exist, pls check", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadInteractionExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30577a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30578b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30579c;

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
                    this.f30579c = this;
                    this.f30577a = gVar;
                    this.f30578b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30579c.a(this.f30577a)) {
                        return;
                    }
                    if (!this.f30579c.a(this.f30578b, false)) {
                        this.f30577a.onError(110, g.a(110));
                        return;
                    }
                    this.f30578b.setNativeAdType(2);
                    this.f30578b.setDurationSlotType(2);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30579c.f30545b).a(this.f30578b, 2, this.f30577a, 5000);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadNativeAd", fVar, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.core.v.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f30586a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30587b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f30588c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f30589d;

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
                    this.f30589d = this;
                    this.f30586a = fVar;
                    this.f30587b = adSlot;
                    this.f30588c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30589d.a(this.f30586a)) {
                        return;
                    }
                    this.f30589d.b(this.f30587b);
                    this.f30589d.f30544a.a(this.f30587b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f30587b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass9 f30590a;

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
                            this.f30590a = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.p.b
                        public void a(int i2, String str) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                this.f30590a.f30586a.onError(i2, str);
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
                                            arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f30590a.f30589d.f30545b, mVar, this.f30590a.f30587b.getNativeAdType(), this.f30590a.f30587b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass1 f30591a;

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
                                                    this.f30591a = this;
                                                }
                                            });
                                        }
                                    }
                                    if (!arrayList.isEmpty()) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f30590a.f30589d.f30545b, c2.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f30590a.f30587b.getDurationSlotType()), this.f30590a.f30588c);
                                        this.f30590a.f30586a.onNativeAdLoad(arrayList);
                                        return;
                                    }
                                    this.f30590a.f30586a.onError(-4, g.a(-4));
                                    return;
                                }
                                this.f30590a.f30586a.onError(-3, g.a(-3));
                            }
                        }
                    });
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
            a(new com.bytedance.sdk.component.e.g(this, "loadNativeExpressAd", gVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30568a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30569b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30570c;

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
                    this.f30570c = this;
                    this.f30568a = gVar;
                    this.f30569b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30570c.a(this.f30568a)) {
                        return;
                    }
                    if (this.f30570c.a(this.f30569b, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30570c.f30545b).a(this.f30569b, 5, this.f30568a, 5000);
                    } else {
                        this.f30568a.onError(110, g.a(110));
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
            a(new com.bytedance.sdk.component.e.g(this, "loadRewardVideoAd", hVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f30562a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30563b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30564c;

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
                    this.f30564c = this;
                    this.f30562a = hVar;
                    this.f30563b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30564c.a(this.f30562a)) {
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30564c.f30545b, this.f30563b, this.f30562a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "reward component maybe not exist, pls check1", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadSplashAd b", iVar, adSlot, i2) { // from class: com.bytedance.sdk.openadsdk.core.v.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f30555a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30556b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f30557c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f30558d;

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
                    this.f30558d = this;
                    this.f30555a = iVar;
                    this.f30556b = adSlot;
                    this.f30557c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30558d.a(this.f30555a)) {
                        return;
                    }
                    this.f30558d.c(this.f30556b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                        if (a2 != null) {
                            a2.invoke(null, this.f30558d.f30545b, this.f30556b, this.f30555a, Integer.valueOf(this.f30557c));
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
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
            a(new com.bytedance.sdk.component.e.g(this, "loadStream", cVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f30580a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30581b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30582c;

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
                    this.f30582c = this;
                    this.f30580a = cVar;
                    this.f30581b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30582c.a(this.f30580a)) {
                        return;
                    }
                    this.f30582c.c(this.f30581b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30582c.f30545b, this.f30581b, this.f30580a);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                    }
                }
            }, cVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(6, adSlot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, adSlot) == null) {
            a(adSlot);
            com.bytedance.sdk.component.utils.n.a(adSlot.getNativeAdType() == 0, "请求非原生广告的类型，请勿调用setNativeAdType()方法");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, adSlot) == null) {
            a(adSlot);
            com.bytedance.sdk.component.utils.n.a(adSlot.getNativeAdType() > 0, "必须设置请求原生广告的类型， ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, adSlot) == null) {
            com.bytedance.sdk.component.utils.n.a(adSlot.getImgAcceptedWidth() > 0, "必须设置图片素材尺寸");
            com.bytedance.sdk.component.utils.n.a(adSlot.getImgAcceptedHeight() > 0, "必须设置图片素材尺寸");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative
    public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
            com.bytedance.sdk.openadsdk.core.a.i iVar = new com.bytedance.sdk.openadsdk.core.a.i(splashAdListener);
            a(new com.bytedance.sdk.component.e.g(this, "loadSplashAd a", iVar, adSlot) { // from class: com.bytedance.sdk.openadsdk.core.v.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f30559a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30560b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30561c;

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
                    this.f30561c = this;
                    this.f30559a = iVar;
                    this.f30560b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30561c.a(this.f30559a)) {
                        return;
                    }
                    this.f30561c.c(this.f30560b);
                    if (!this.f30561c.a(this.f30560b, true)) {
                        this.f30559a.onError(110, g.a(110));
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                        if (a2 != null) {
                            a2.invoke(null, this.f30561c.f30545b, this.f30560b, this.f30559a, -1);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.b("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                    }
                }
            }, iVar);
            com.bytedance.sdk.openadsdk.b.a.a().a(3, adSlot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.bytedance.sdk.openadsdk.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bVar)) == null) {
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, adSlot, z)) == null) {
            if (adSlot == null) {
                return false;
            }
            return (z && !o.h().i(adSlot.getCodeId())) || adSlot.getExpressViewAcceptedWidth() > 0.0f;
        }
        return invokeLZ.booleanValue;
    }

    private void a(com.bytedance.sdk.component.e.g gVar, com.bytedance.sdk.openadsdk.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, gVar, bVar) == null) {
            if (!l.f30344c) {
                com.bytedance.sdk.component.utils.j.f("TTAdNativeImpl", "please exec TTAdSdk.init before load ad");
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
