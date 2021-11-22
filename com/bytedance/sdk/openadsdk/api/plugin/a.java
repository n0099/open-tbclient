package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.common.CommonListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes11.dex */
public final class a implements TTAdManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f62493a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f62494b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TTAdNative f62495a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f62496b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f62497c;

        public AnonymousClass1(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62497c = aVar;
            this.f62496b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(InterfaceC1888a<TTAdNative> interfaceC1888a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1888a) == null) {
                TTAdNative tTAdNative = this.f62495a;
                if (tTAdNative != null) {
                    interfaceC1888a.a(tTAdNative);
                } else {
                    this.f62497c.call(new InterfaceC1888a<TTAdManager>(this, interfaceC1888a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC1888a f62498a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f62499b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC1888a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f62499b = this;
                            this.f62498a = interfaceC1888a;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                        public void a(TTAdManager tTAdManager) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                                AnonymousClass1 anonymousClass1 = this.f62499b;
                                anonymousClass1.f62495a = tTAdManager.createAdNative(anonymousClass1.f62496b);
                                this.f62498a.a(this.f62499b.f62495a);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC1888a<T> {
        void a(T t);
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        void a(InterfaceC1888a<T> interfaceC1888a);
    }

    /* loaded from: classes11.dex */
    public interface c<T> extends InterfaceC1888a<T> {
        void a();
    }

    /* loaded from: classes11.dex */
    public static final class d implements TTAdNative {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b<TTAdNative> f62517a;

        public d(b<TTAdNative> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62517a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC1888a<TTAdNative> interfaceC1888a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, commonListener, interfaceC1888a) == null) {
                try {
                    this.f62517a.a(interfaceC1888a);
                } catch (Throwable th) {
                    if (commonListener != null) {
                        commonListener.onError(4202, "Load ad failed: " + th.getMessage());
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerAd(AdSlot adSlot, TTAdNative.BannerAdListener bannerAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, adSlot, bannerAdListener) == null) {
                a(bannerAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, bannerAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62521a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.BannerAdListener f62522b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62523c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, bannerAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62523c = this;
                        this.f62521a = adSlot;
                        this.f62522b = bannerAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerAd(this.f62521a, this.f62522b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62546a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f62547b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62548c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nativeExpressAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62548c = this;
                        this.f62546a = adSlot;
                        this.f62547b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerExpressAd(this.f62546a, this.f62547b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, drawFeedAdListener) == null) {
                a(drawFeedAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, drawFeedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62555a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.DrawFeedAdListener f62556b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62557c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, drawFeedAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62557c = this;
                        this.f62555a = adSlot;
                        this.f62556b = drawFeedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadDrawFeedAd(this.f62555a, this.f62556b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62543a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f62544b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62545c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nativeExpressAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62545c = this;
                        this.f62543a = adSlot;
                        this.f62544b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadExpressDrawFeedAd(this.f62543a, this.f62544b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62518a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f62519b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62520c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, feedAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62520c = this;
                        this.f62518a = adSlot;
                        this.f62519b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFeedAd(this.f62518a, this.f62519b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, adSlot, fullScreenVideoAdListener) == null) {
                a(fullScreenVideoAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, fullScreenVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62537a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f62538b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62539c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, fullScreenVideoAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62539c = this;
                        this.f62537a = adSlot;
                        this.f62538b = fullScreenVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFullScreenVideoAd(this.f62537a, this.f62538b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, adSlot, interactionAdListener) == null) {
                a(interactionAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, interactionAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62524a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.InteractionAdListener f62525b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62526c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, interactionAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62526c = this;
                        this.f62524a = adSlot;
                        this.f62525b = interactionAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionAd(this.f62524a, this.f62525b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62549a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f62550b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62551c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nativeExpressAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62551c = this;
                        this.f62549a = adSlot;
                        this.f62550b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionExpressAd(this.f62549a, this.f62550b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adSlot, nativeAdListener) == null) {
                a(nativeAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, nativeAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62558a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeAdListener f62559b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62560c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nativeAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62560c = this;
                        this.f62558a = adSlot;
                        this.f62559b = nativeAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeAd(this.f62558a, this.f62559b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62540a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f62541b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62542c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, nativeExpressAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62542c = this;
                        this.f62540a = adSlot;
                        this.f62541b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeExpressAd(this.f62540a, this.f62541b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, adSlot, rewardVideoAdListener) == null) {
                a(rewardVideoAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, rewardVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62534a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f62535b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62536c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, rewardVideoAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62536c = this;
                        this.f62534a = adSlot;
                        this.f62535b = rewardVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadRewardVideoAd(this.f62534a, this.f62535b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048588, this, adSlot, splashAdListener, i2) == null) {
                a(splashAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, splashAdListener, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62527a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f62528b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f62529c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f62530d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, splashAdListener, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62530d = this;
                        this.f62527a = adSlot;
                        this.f62528b = splashAdListener;
                        this.f62529c = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f62527a, this.f62528b, this.f62529c);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62552a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f62553b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62554c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, feedAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62554c = this;
                        this.f62552a = adSlot;
                        this.f62553b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadStream(this.f62552a, this.f62553b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
                a(splashAdListener, new InterfaceC1888a<TTAdNative>(this, adSlot, splashAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f62531a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f62532b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62533c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adSlot, splashAdListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62533c = this;
                        this.f62531a = adSlot;
                        this.f62532b = splashAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f62531a, this.f62532b);
                        }
                    }
                });
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462304044, "Lcom/bytedance/sdk/openadsdk/api/plugin/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462304044, "Lcom/bytedance/sdk/openadsdk/api/plugin/a;");
                return;
            }
        }
        f62493a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void call(InterfaceC1888a<TTAdManager> interfaceC1888a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, interfaceC1888a) == null) {
            if (this.f62494b != null) {
                try {
                    interfaceC1888a.a(this.f62494b);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                    return;
                }
            }
            ScheduledExecutorService scheduledExecutorService = g.f62588a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable(this, interfaceC1888a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1888a f62515a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f62516b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC1888a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62516b = this;
                        this.f62515a = interfaceC1888a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f62516b.f62494b != null) {
                                    this.f62515a.a(this.f62516b.f62494b);
                                    return;
                                }
                                if (this.f62515a instanceof c) {
                                    ((c) this.f62515a).a();
                                }
                                com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no manager");
                            } catch (Throwable th2) {
                                com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th2.getMessage());
                            }
                        }
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Not ready, no executor");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new d(new AnonymousClass1(this, context)) : (TTAdNative) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adSlot)) == null) {
            if (this.f62494b != null) {
                return this.f62494b.getBiddingToken(adSlot);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public <T> T getExtra(Class<T> cls, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, cls, bundle)) == null) {
            if (this.f62494b != null) {
                return (T) this.f62494b.getExtra(cls, bundle);
            }
            if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
                call(new c<TTAdManager>(this, bundle, cls) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bundle f62505a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Class f62506b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f62507c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bundle, cls};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62507c = this;
                        this.f62505a = bundle;
                        this.f62506b = cls;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.a(this.f62505a);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                    public void a(TTAdManager tTAdManager) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAdManager) == null) {
                            tTAdManager.getExtra(this.f62506b, this.f62505a);
                        }
                    }
                });
                return null;
            }
            call(new InterfaceC1888a<TTAdManager>(this, cls, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Class f62508a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Bundle f62509b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f62510c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cls, bundle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62510c = this;
                    this.f62508a = cls;
                    this.f62509b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.getExtra(this.f62508a, this.f62509b);
                    }
                }
            });
            return null;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getPluginVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62494b != null ? this.f62494b.getPluginVersion() : "" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "4.0.1.1" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f62494b != null) {
                return this.f62494b.getThemeStatus();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i2), str2, str3, str4})) == null) {
            if (this.f62494b != null) {
                return this.f62494b.onlyVerityPlayable(str, i2, str2, str3, str4);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void register(Object obj) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            if (obj instanceof TTPluginListener) {
                TTPluginListener tTPluginListener = (TTPluginListener) obj;
                bundle = f.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
            } else {
                bundle = obj;
            }
            call(new InterfaceC1888a<TTAdManager>(this, obj, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f62500a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f62501b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f62502c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj, bundle};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62502c = this;
                    this.f62500a = obj;
                    this.f62501b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        if (this.f62500a instanceof TTPluginListener) {
                            f.a(TTAppContextHolder.getContext()).a((TTPluginListener) this.f62500a);
                        }
                        tTAdManager.register(this.f62501b);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            call(new InterfaceC1888a<TTAdManager>(this, context) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f62511a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f62512b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62512b = this;
                    this.f62511a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.requestPermissionIfNecessary(this.f62511a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            call(new InterfaceC1888a<TTAdManager>(this, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f62513a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f62514b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62514b = this;
                    this.f62513a = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        this.f62514b.f62494b.setThemeStatus(this.f62513a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, exitInstallListener)) == null) ? this.f62494b != null && this.f62494b.tryShowInstallDialogWhenExit(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            call(new InterfaceC1888a<TTAdManager>(this, obj) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f62503a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f62504b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62504b = this;
                    this.f62503a = obj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1888a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.unregister(this.f62503a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{adSlot, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (this.f62494b != null) {
                return this.f62494b.getBiddingToken(adSlot, z, i2);
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(TTAdManager tTAdManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTAdManager) == null) {
            this.f62494b = tTAdManager;
        }
    }
}
