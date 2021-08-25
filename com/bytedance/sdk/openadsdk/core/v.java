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
    public final p f66841a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66842b;

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
        this.f66841a = o.f();
        this.f66842b = context;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.a f66846a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66847b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66848c;

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
                    this.f66848c = this;
                    this.f66846a = aVar;
                    this.f66847b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66848c.a(this.f66846a)) {
                                return;
                            }
                            this.f66848c.c(this.f66847b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC1Proxy", "load", Context.class, AdSlot.class, TTAdNative.BannerAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f66848c.f66842b, this.f66847b, this.f66846a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66848c;
                            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.f66846a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f66871a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66872b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66873c;

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
                    this.f66873c = this;
                    this.f66871a = gVar;
                    this.f66872b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66873c.a(this.f66871a)) {
                                return;
                            }
                            if (!this.f66873c.a(this.f66872b, false)) {
                                this.f66871a.onError(110, g.a(110));
                                return;
                            }
                            this.f66872b.setNativeAdType(1);
                            this.f66872b.setDurationSlotType(1);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f66873c.f66842b).a(this.f66872b, 1, this.f66871a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f66873c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f66871a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.b f66880a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66881b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66882c;

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
                    this.f66882c = this;
                    this.f66880a = bVar;
                    this.f66881b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66882c.a(this.f66880a)) {
                                return;
                            }
                            this.f66882c.a(this.f66881b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadDraw", Context.class, AdSlot.class, TTAdNative.DrawFeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f66882c.f66842b, this.f66881b, this.f66880a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66882c;
                            com.bytedance.sdk.openadsdk.core.a.b bVar2 = this.f66880a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f66868a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66869b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66870c;

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
                    this.f66870c = this;
                    this.f66868a = gVar;
                    this.f66869b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66870c.a(this.f66868a)) {
                                return;
                            }
                            if (!this.f66870c.a(this.f66869b, false)) {
                                this.f66868a.onError(110, g.a(110));
                                return;
                            }
                            this.f66869b.setDurationSlotType(9);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f66870c.f66842b).a(this.f66869b, 9, this.f66868a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f66870c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f66868a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f66843a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66844b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66845c;

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
                    this.f66845c = this;
                    this.f66843a = cVar;
                    this.f66844b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66845c.a(this.f66843a)) {
                                return;
                            }
                            this.f66845c.c(this.f66844b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f66845c.f66842b, this.f66844b, this.f66843a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66845c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f66843a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.d f66862a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66863b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66864c;

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
                    this.f66864c = this;
                    this.f66862a = dVar;
                    this.f66863b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66864c.a(this.f66862a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f66864c.f66842b, this.f66863b, this.f66862a);
                        } catch (Throwable th) {
                            v vVar = this.f66864c;
                            com.bytedance.sdk.openadsdk.core.a.d dVar2 = this.f66862a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.e f66849a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66850b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66851c;

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
                    this.f66851c = this;
                    this.f66849a = eVar;
                    this.f66850b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66851c.a(this.f66849a)) {
                                return;
                            }
                            this.f66851c.c(this.f66850b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC4Proxy", "load", Context.class, AdSlot.class, TTAdNative.InteractionAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f66851c.f66842b, this.f66850b, this.f66849a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66851c;
                            com.bytedance.sdk.openadsdk.core.a.e eVar2 = this.f66849a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f66874a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66875b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66876c;

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
                    this.f66876c = this;
                    this.f66874a = gVar;
                    this.f66875b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66876c.a(this.f66874a)) {
                                return;
                            }
                            if (!this.f66876c.a(this.f66875b, false)) {
                                this.f66874a.onError(110, g.a(110));
                                return;
                            }
                            this.f66875b.setNativeAdType(2);
                            this.f66875b.setDurationSlotType(2);
                            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f66876c.f66842b).a(this.f66875b, 2, this.f66874a, 5000);
                        } catch (Throwable th) {
                            v vVar = this.f66876c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f66874a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.f f66883a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66884b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f66885c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f66886d;

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
                    this.f66886d = this;
                    this.f66883a = fVar;
                    this.f66884b = adSlot;
                    this.f66885c = currentTimeMillis;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66886d.a(this.f66883a)) {
                                return;
                            }
                            this.f66886d.b(this.f66884b);
                            this.f66886d.f66841a.a(this.f66884b, new com.bytedance.sdk.openadsdk.core.e.n(), this.f66884b.getNativeAdType(), new p.b(this) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass9 f66887a;

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
                                    this.f66887a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.p.b
                                public void a(int i2, String str) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str) == null) {
                                        this.f66887a.f66883a.onError(i2, str);
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
                                                    arrayList.add(new com.bytedance.sdk.openadsdk.core.f.a(this, this.f66887a.f66886d.f66842b, mVar, this.f66887a.f66884b.getNativeAdType(), this.f66887a.f66884b) { // from class: com.bytedance.sdk.openadsdk.core.v.9.1.1
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;

                                                        /* renamed from: a  reason: collision with root package name */
                                                        public final /* synthetic */ AnonymousClass1 f66888a;

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
                                                            this.f66888a = this;
                                                        }
                                                    });
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f66887a.f66886d.f66842b, c2.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f66887a.f66884b.getDurationSlotType()), this.f66887a.f66885c);
                                                this.f66887a.f66883a.onNativeAdLoad(arrayList);
                                                return;
                                            }
                                            this.f66887a.f66883a.onError(-4, g.a(-4));
                                            return;
                                        }
                                        this.f66887a.f66883a.onError(-3, g.a(-3));
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            v vVar = this.f66886d;
                            com.bytedance.sdk.openadsdk.core.a.f fVar2 = this.f66883a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.g f66865a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66866b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66867c;

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
                    this.f66867c = this;
                    this.f66865a = gVar;
                    this.f66866b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66867c.a(this.f66865a)) {
                                return;
                            }
                            if (this.f66867c.a(this.f66866b, false)) {
                                com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f66867c.f66842b).a(this.f66866b, 5, this.f66865a, 5000);
                            } else {
                                this.f66865a.onError(110, g.a(110));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66867c;
                            com.bytedance.sdk.openadsdk.core.a.g gVar2 = this.f66865a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.h f66859a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66860b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66861c;

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
                    this.f66861c = this;
                    this.f66859a = hVar;
                    this.f66860b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Method a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66861c.a(this.f66859a) || (a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class)) == null) {
                                return;
                            }
                            a2.invoke(null, this.f66861c.f66842b, this.f66860b, this.f66859a);
                        } catch (Throwable th) {
                            v vVar = this.f66861c;
                            com.bytedance.sdk.openadsdk.core.a.h hVar2 = this.f66859a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f66852a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66853b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f66854c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ v f66855d;

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
                    this.f66855d = this;
                    this.f66852a = iVar;
                    this.f66853b = adSlot;
                    this.f66854c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66855d.a(this.f66852a)) {
                                return;
                            }
                            this.f66855d.c(this.f66853b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f66855d.f66842b, this.f66853b, this.f66852a, Integer.valueOf(this.f66854c));
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66855d;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f66852a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.c f66877a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66878b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66879c;

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
                    this.f66879c = this;
                    this.f66877a = cVar;
                    this.f66878b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66879c.a(this.f66877a)) {
                                return;
                            }
                            this.f66879c.c(this.f66878b);
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadStream", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke(null, this.f66879c.f66842b, this.f66878b, this.f66877a);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66879c;
                            com.bytedance.sdk.openadsdk.core.a.c cVar2 = this.f66877a;
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
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.a.i f66856a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66857b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f66858c;

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
                    this.f66858c = this;
                    this.f66856a = iVar;
                    this.f66857b = adSlot;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.f66858c.a(this.f66856a)) {
                                return;
                            }
                            this.f66858c.c(this.f66857b);
                            if (!this.f66858c.a(this.f66857b, true)) {
                                this.f66856a.onError(110, g.a(110));
                                return;
                            }
                            Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.SplashAdListener.class, Integer.TYPE);
                            if (a2 != null) {
                                a2.invoke(null, this.f66858c.f66842b, this.f66857b, this.f66856a, -1);
                            }
                        } catch (Throwable th) {
                            v vVar = this.f66858c;
                            com.bytedance.sdk.openadsdk.core.a.i iVar2 = this.f66856a;
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
            if (!l.f66561c) {
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
