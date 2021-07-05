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
/* loaded from: classes6.dex */
public class v implements TTAdNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p f30434a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30435b;

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
        this.f30434a = o.f();
        this.f30435b = context;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f30439a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30440b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30441c;

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
                    this.f30441c = this;
                    this.f30439a = aVar;
                    this.f30440b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30441c.a(this.f30439a)) {
                        return;
                    }
                    this.f30441c.c(this.f30440b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30441c.f30435b, this.f30440b, this.f30439a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30464a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30465b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30466c;

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
                    this.f30466c = this;
                    this.f30464a = gVar;
                    this.f30465b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30466c.a(this.f30464a)) {
                        return;
                    }
                    if (!this.f30466c.a(this.f30465b, false)) {
                        this.f30464a.onError(110, g.a(110));
                        return;
                    }
                    this.f30465b.setNativeAdType(1);
                    this.f30465b.setDurationSlotType(1);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30466c.f30435b).a(this.f30465b, 1, this.f30464a, 5000);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f30473a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30474b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30475c;

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
                    this.f30475c = this;
                    this.f30473a = bVar;
                    this.f30474b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30475c.a(this.f30473a)) {
                        return;
                    }
                    this.f30475c.a(this.f30474b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30475c.f30435b, this.f30474b, this.f30473a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30461a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30462b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30463c;

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
                    this.f30463c = this;
                    this.f30461a = gVar;
                    this.f30462b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30463c.a(this.f30461a)) {
                        return;
                    }
                    if (!this.f30463c.a(this.f30462b, false)) {
                        this.f30461a.onError(110, g.a(110));
                        return;
                    }
                    this.f30462b.setDurationSlotType(9);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30463c.f30435b).a(this.f30462b, 9, this.f30461a, 5000);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f30436a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30437b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30438c;

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
                    this.f30438c = this;
                    this.f30436a = cVar;
                    this.f30437b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30438c.a(this.f30436a)) {
                        return;
                    }
                    this.f30438c.c(this.f30437b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30438c.f30435b, this.f30437b, this.f30436a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f30455a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30456b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30457c;

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
                    this.f30457c = this;
                    this.f30455a = dVar;
                    this.f30456b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30457c.a(this.f30455a)) {
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30457c.f30435b, this.f30456b, this.f30455a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f30442a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30443b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30444c;

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
                    this.f30444c = this;
                    this.f30442a = eVar;
                    this.f30443b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30444c.a(this.f30442a)) {
                        return;
                    }
                    this.f30444c.c(this.f30443b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30444c.f30435b, this.f30443b, this.f30442a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30467a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30468b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30469c;

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
                    this.f30469c = this;
                    this.f30467a = gVar;
                    this.f30468b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30469c.a(this.f30467a)) {
                        return;
                    }
                    if (!this.f30469c.a(this.f30468b, false)) {
                        this.f30467a.onError(110, g.a(110));
                        return;
                    }
                    this.f30468b.setNativeAdType(2);
                    this.f30468b.setDurationSlotType(2);
                    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30469c.f30435b).a(this.f30468b, 2, this.f30467a, 5000);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f30476a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30477b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f30478c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f30479d;

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
                    this.f30479d = this;
                    this.f30476a = fVar;
                    this.f30477b = adSlot;
                    this.f30478c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30479d.a(this.f30476a)) {
                        return;
                    }
                    this.f30479d.b(this.f30477b);
                    this.f30479d.f30434a.a(this.f30477b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f30477b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass9 f30480a;

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
                            this.f30480a = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.p.b
                        public void a(int i2, String str) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                this.f30480a.f30476a.onError(i2, str);
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
                                            arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f30480a.f30479d.f30435b, mVar, this.f30480a.f30477b.getNativeAdType(), this.f30480a.f30477b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass1 f30481a;

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
                                                    this.f30481a = this;
                                                }
                                            });
                                        }
                                    }
                                    if (!arrayList.isEmpty()) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f30480a.f30479d.f30435b, c2.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f30480a.f30477b.getDurationSlotType()), this.f30480a.f30478c);
                                        this.f30480a.f30476a.onNativeAdLoad(arrayList);
                                        return;
                                    }
                                    this.f30480a.f30476a.onError(-4, g.a(-4));
                                    return;
                                }
                                this.f30480a.f30476a.onError(-3, g.a(-3));
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f30458a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30459b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30460c;

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
                    this.f30460c = this;
                    this.f30458a = gVar;
                    this.f30459b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30460c.a(this.f30458a)) {
                        return;
                    }
                    if (this.f30460c.a(this.f30459b, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f30460c.f30435b).a(this.f30459b, 5, this.f30458a, 5000);
                    } else {
                        this.f30458a.onError(110, g.a(110));
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f30452a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30453b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30454c;

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
                    this.f30454c = this;
                    this.f30452a = hVar;
                    this.f30453b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30454c.a(this.f30452a)) {
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30454c.f30435b, this.f30453b, this.f30452a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f30445a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30446b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f30447c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f30448d;

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
                    this.f30448d = this;
                    this.f30445a = iVar;
                    this.f30446b = adSlot;
                    this.f30447c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30448d.a(this.f30445a)) {
                        return;
                    }
                    this.f30448d.c(this.f30446b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                        if (a2 != null) {
                            a2.invoke(null, this.f30448d.f30435b, this.f30446b, this.f30445a, Integer.valueOf(this.f30447c));
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f30470a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30471b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30472c;

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
                    this.f30472c = this;
                    this.f30470a = cVar;
                    this.f30471b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30472c.a(this.f30470a)) {
                        return;
                    }
                    this.f30472c.c(this.f30471b);
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                        if (a2 != null) {
                            a2.invoke(null, this.f30472c.f30435b, this.f30471b, this.f30470a);
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f30449a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f30450b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f30451c;

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
                    this.f30451c = this;
                    this.f30449a = iVar;
                    this.f30450b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30451c.a(this.f30449a)) {
                        return;
                    }
                    this.f30451c.c(this.f30450b);
                    if (!this.f30451c.a(this.f30450b, true)) {
                        this.f30449a.onError(110, g.a(110));
                        return;
                    }
                    try {
                        Method a2 = com.bytedance.sdk.component.utils.t.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                        if (a2 != null) {
                            a2.invoke(null, this.f30451c.f30435b, this.f30450b, this.f30449a, -1);
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
            if (!l.f30234c) {
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
