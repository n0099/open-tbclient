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
/* loaded from: classes12.dex */
public final class a implements TTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f54707b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TTAdNative a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f54708b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f54709c;

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
            this.f54709c = aVar;
            this.f54708b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(InterfaceC1960a<TTAdNative> interfaceC1960a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1960a) == null) {
                TTAdNative tTAdNative = this.a;
                if (tTAdNative != null) {
                    interfaceC1960a.a(tTAdNative);
                } else {
                    this.f54709c.call(new InterfaceC1960a<TTAdManager>(this, interfaceC1960a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InterfaceC1960a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f54710b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC1960a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f54710b = this;
                            this.a = interfaceC1960a;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                        public void a(TTAdManager tTAdManager) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                                AnonymousClass1 anonymousClass1 = this.f54710b;
                                anonymousClass1.a = tTAdManager.createAdNative(anonymousClass1.f54708b);
                                this.a.a(this.f54710b.a);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC1960a<T> {
        void a(T t);
    }

    /* loaded from: classes12.dex */
    public interface b<T> {
        void a(InterfaceC1960a<T> interfaceC1960a);
    }

    /* loaded from: classes12.dex */
    public interface c<T> extends InterfaceC1960a<T> {
        void a();
    }

    /* loaded from: classes12.dex */
    public static final class d implements TTAdNative {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<TTAdNative> a;

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
            this.a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC1960a<TTAdNative> interfaceC1960a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, commonListener, interfaceC1960a) == null) {
                try {
                    this.a.a(interfaceC1960a);
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
                a(bannerAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, bannerAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.BannerAdListener f54723b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54724c;

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
                        this.f54724c = this;
                        this.a = adSlot;
                        this.f54723b = bannerAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerAd(this.a, this.f54723b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f54740b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54741c;

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
                        this.f54741c = this;
                        this.a = adSlot;
                        this.f54740b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerExpressAd(this.a, this.f54740b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, drawFeedAdListener) == null) {
                a(drawFeedAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, drawFeedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.DrawFeedAdListener f54746b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54747c;

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
                        this.f54747c = this;
                        this.a = adSlot;
                        this.f54746b = drawFeedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadDrawFeedAd(this.a, this.f54746b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f54738b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54739c;

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
                        this.f54739c = this;
                        this.a = adSlot;
                        this.f54738b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadExpressDrawFeedAd(this.a, this.f54738b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f54721b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54722c;

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
                        this.f54722c = this;
                        this.a = adSlot;
                        this.f54721b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFeedAd(this.a, this.f54721b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, adSlot, fullScreenVideoAdListener) == null) {
                a(fullScreenVideoAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, fullScreenVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f54734b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54735c;

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
                        this.f54735c = this;
                        this.a = adSlot;
                        this.f54734b = fullScreenVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFullScreenVideoAd(this.a, this.f54734b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, adSlot, interactionAdListener) == null) {
                a(interactionAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, interactionAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.InteractionAdListener f54725b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54726c;

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
                        this.f54726c = this;
                        this.a = adSlot;
                        this.f54725b = interactionAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionAd(this.a, this.f54725b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f54742b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54743c;

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
                        this.f54743c = this;
                        this.a = adSlot;
                        this.f54742b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionExpressAd(this.a, this.f54742b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adSlot, nativeAdListener) == null) {
                a(nativeAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, nativeAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeAdListener f54748b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54749c;

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
                        this.f54749c = this;
                        this.a = adSlot;
                        this.f54748b = nativeAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeAd(this.a, this.f54748b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f54736b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54737c;

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
                        this.f54737c = this;
                        this.a = adSlot;
                        this.f54736b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeExpressAd(this.a, this.f54736b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, adSlot, rewardVideoAdListener) == null) {
                a(rewardVideoAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, rewardVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f54732b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54733c;

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
                        this.f54733c = this;
                        this.a = adSlot;
                        this.f54732b = rewardVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadRewardVideoAd(this.a, this.f54732b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048588, this, adSlot, splashAdListener, i2) == null) {
                a(splashAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, splashAdListener, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f54727b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f54728c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f54729d;

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
                        this.f54729d = this;
                        this.a = adSlot;
                        this.f54727b = splashAdListener;
                        this.f54728c = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.a, this.f54727b, this.f54728c);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f54744b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54745c;

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
                        this.f54745c = this;
                        this.a = adSlot;
                        this.f54744b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadStream(this.a, this.f54744b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
                a(splashAdListener, new InterfaceC1960a<TTAdNative>(this, adSlot, splashAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f54730b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f54731c;

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
                        this.f54731c = this;
                        this.a = adSlot;
                        this.f54730b = splashAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.a, this.f54730b);
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
        a = new a();
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
    public final void call(InterfaceC1960a<TTAdManager> interfaceC1960a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, interfaceC1960a) == null) {
            if (this.f54707b != null) {
                try {
                    interfaceC1960a.a(this.f54707b);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                    return;
                }
            }
            ScheduledExecutorService scheduledExecutorService = g.a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable(this, interfaceC1960a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InterfaceC1960a a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f54720b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC1960a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54720b = this;
                        this.a = interfaceC1960a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f54720b.f54707b != null) {
                                    this.a.a(this.f54720b.f54707b);
                                    return;
                                }
                                if (this.a instanceof c) {
                                    ((c) this.a).a();
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
            if (this.f54707b != null) {
                return this.f54707b.getBiddingToken(adSlot);
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
            if (this.f54707b != null) {
                return (T) this.f54707b.getExtra(cls, bundle);
            }
            if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
                call(new c<TTAdManager>(this, bundle, cls) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Bundle a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Class f54714b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f54715c;

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
                        this.f54715c = this;
                        this.a = bundle;
                        this.f54714b = cls;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.a(this.a);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                    public void a(TTAdManager tTAdManager) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAdManager) == null) {
                            tTAdManager.getExtra(this.f54714b, this.a);
                        }
                    }
                });
                return null;
            }
            call(new InterfaceC1960a<TTAdManager>(this, cls, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Class a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Bundle f54716b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f54717c;

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
                    this.f54717c = this;
                    this.a = cls;
                    this.f54716b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.getExtra(this.a, this.f54716b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54707b != null ? this.f54707b.getPluginVersion() : "" : (String) invokeV.objValue;
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
            if (this.f54707b != null) {
                return this.f54707b.getThemeStatus();
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
            if (this.f54707b != null) {
                return this.f54707b.onlyVerityPlayable(str, i2, str2, str3, str4);
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
            call(new InterfaceC1960a<TTAdManager>(this, obj, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f54711b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f54712c;

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
                    this.f54712c = this;
                    this.a = obj;
                    this.f54711b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        if (this.a instanceof TTPluginListener) {
                            f.a(TTAppContextHolder.getContext()).a((TTPluginListener) this.a);
                        }
                        tTAdManager.register(this.f54711b);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            call(new InterfaceC1960a<TTAdManager>(this, context) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f54718b;

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
                    this.f54718b = this;
                    this.a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.requestPermissionIfNecessary(this.a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            call(new InterfaceC1960a<TTAdManager>(this, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f54719b;

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
                    this.f54719b = this;
                    this.a = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        this.f54719b.f54707b.setThemeStatus(this.a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, exitInstallListener)) == null) ? this.f54707b != null && this.f54707b.tryShowInstallDialogWhenExit(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            call(new InterfaceC1960a<TTAdManager>(this, obj) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f54713b;

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
                    this.f54713b = this;
                    this.a = obj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1960a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.unregister(this.a);
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
            if (this.f54707b != null) {
                return this.f54707b.getBiddingToken(adSlot, z, i2);
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(TTAdManager tTAdManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTAdManager) == null) {
            this.f54707b = tTAdManager;
        }
    }
}
