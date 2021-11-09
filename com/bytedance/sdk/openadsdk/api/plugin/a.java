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
    public static final a f61594a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f61595b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TTAdNative f61596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f61597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f61598c;

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
            this.f61598c = aVar;
            this.f61597b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(InterfaceC1849a<TTAdNative> interfaceC1849a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1849a) == null) {
                TTAdNative tTAdNative = this.f61596a;
                if (tTAdNative != null) {
                    interfaceC1849a.a(tTAdNative);
                } else {
                    this.f61598c.call(new InterfaceC1849a<TTAdManager>(this, interfaceC1849a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC1849a f61599a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f61600b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC1849a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61600b = this;
                            this.f61599a = interfaceC1849a;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                        public void a(TTAdManager tTAdManager) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                                AnonymousClass1 anonymousClass1 = this.f61600b;
                                anonymousClass1.f61596a = tTAdManager.createAdNative(anonymousClass1.f61597b);
                                this.f61599a.a(this.f61600b.f61596a);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC1849a<T> {
        void a(T t);
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        void a(InterfaceC1849a<T> interfaceC1849a);
    }

    /* loaded from: classes11.dex */
    public interface c<T> extends InterfaceC1849a<T> {
        void a();
    }

    /* loaded from: classes11.dex */
    public static final class d implements TTAdNative {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b<TTAdNative> f61618a;

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
            this.f61618a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC1849a<TTAdNative> interfaceC1849a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, commonListener, interfaceC1849a) == null) {
                try {
                    this.f61618a.a(interfaceC1849a);
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
                a(bannerAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, bannerAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61622a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.BannerAdListener f61623b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61624c;

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
                        this.f61624c = this;
                        this.f61622a = adSlot;
                        this.f61623b = bannerAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerAd(this.f61622a, this.f61623b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61647a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61648b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61649c;

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
                        this.f61649c = this;
                        this.f61647a = adSlot;
                        this.f61648b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerExpressAd(this.f61647a, this.f61648b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, drawFeedAdListener) == null) {
                a(drawFeedAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, drawFeedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61656a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.DrawFeedAdListener f61657b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61658c;

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
                        this.f61658c = this;
                        this.f61656a = adSlot;
                        this.f61657b = drawFeedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadDrawFeedAd(this.f61656a, this.f61657b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61644a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61645b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61646c;

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
                        this.f61646c = this;
                        this.f61644a = adSlot;
                        this.f61645b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadExpressDrawFeedAd(this.f61644a, this.f61645b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61619a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f61620b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61621c;

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
                        this.f61621c = this;
                        this.f61619a = adSlot;
                        this.f61620b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFeedAd(this.f61619a, this.f61620b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, adSlot, fullScreenVideoAdListener) == null) {
                a(fullScreenVideoAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, fullScreenVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61638a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f61639b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61640c;

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
                        this.f61640c = this;
                        this.f61638a = adSlot;
                        this.f61639b = fullScreenVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFullScreenVideoAd(this.f61638a, this.f61639b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, adSlot, interactionAdListener) == null) {
                a(interactionAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, interactionAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61625a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.InteractionAdListener f61626b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61627c;

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
                        this.f61627c = this;
                        this.f61625a = adSlot;
                        this.f61626b = interactionAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionAd(this.f61625a, this.f61626b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61650a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61651b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61652c;

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
                        this.f61652c = this;
                        this.f61650a = adSlot;
                        this.f61651b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionExpressAd(this.f61650a, this.f61651b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adSlot, nativeAdListener) == null) {
                a(nativeAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, nativeAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61659a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeAdListener f61660b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61661c;

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
                        this.f61661c = this;
                        this.f61659a = adSlot;
                        this.f61660b = nativeAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeAd(this.f61659a, this.f61660b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61641a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61642b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61643c;

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
                        this.f61643c = this;
                        this.f61641a = adSlot;
                        this.f61642b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeExpressAd(this.f61641a, this.f61642b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, adSlot, rewardVideoAdListener) == null) {
                a(rewardVideoAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, rewardVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61635a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f61636b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61637c;

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
                        this.f61637c = this;
                        this.f61635a = adSlot;
                        this.f61636b = rewardVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadRewardVideoAd(this.f61635a, this.f61636b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048588, this, adSlot, splashAdListener, i2) == null) {
                a(splashAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, splashAdListener, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61628a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f61629b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f61630c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f61631d;

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
                        this.f61631d = this;
                        this.f61628a = adSlot;
                        this.f61629b = splashAdListener;
                        this.f61630c = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f61628a, this.f61629b, this.f61630c);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61653a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f61654b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61655c;

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
                        this.f61655c = this;
                        this.f61653a = adSlot;
                        this.f61654b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadStream(this.f61653a, this.f61654b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
                a(splashAdListener, new InterfaceC1849a<TTAdNative>(this, adSlot, splashAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f61632a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f61633b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61634c;

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
                        this.f61634c = this;
                        this.f61632a = adSlot;
                        this.f61633b = splashAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f61632a, this.f61633b);
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
        f61594a = new a();
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
    public final void call(InterfaceC1849a<TTAdManager> interfaceC1849a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, interfaceC1849a) == null) {
            if (this.f61595b != null) {
                try {
                    interfaceC1849a.a(this.f61595b);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                    return;
                }
            }
            ScheduledExecutorService scheduledExecutorService = g.f61689a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable(this, interfaceC1849a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1849a f61616a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f61617b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC1849a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61617b = this;
                        this.f61616a = interfaceC1849a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f61617b.f61595b != null) {
                                    this.f61616a.a(this.f61617b.f61595b);
                                    return;
                                }
                                if (this.f61616a instanceof c) {
                                    ((c) this.f61616a).a();
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
            if (this.f61595b != null) {
                return this.f61595b.getBiddingToken(adSlot);
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
            if (this.f61595b != null) {
                return (T) this.f61595b.getExtra(cls, bundle);
            }
            if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
                call(new c<TTAdManager>(this, bundle, cls) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bundle f61606a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Class f61607b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61608c;

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
                        this.f61608c = this;
                        this.f61606a = bundle;
                        this.f61607b = cls;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.a(this.f61606a);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdManager tTAdManager) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAdManager) == null) {
                            tTAdManager.getExtra(this.f61607b, this.f61606a);
                        }
                    }
                });
                return null;
            }
            call(new InterfaceC1849a<TTAdManager>(this, cls, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Class f61609a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Bundle f61610b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61611c;

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
                    this.f61611c = this;
                    this.f61609a = cls;
                    this.f61610b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.getExtra(this.f61609a, this.f61610b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61595b != null ? this.f61595b.getPluginVersion() : "" : (String) invokeV.objValue;
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
            if (this.f61595b != null) {
                return this.f61595b.getThemeStatus();
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
            if (this.f61595b != null) {
                return this.f61595b.onlyVerityPlayable(str, i2, str2, str3, str4);
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
            call(new InterfaceC1849a<TTAdManager>(this, obj, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f61601a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f61602b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61603c;

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
                    this.f61603c = this;
                    this.f61601a = obj;
                    this.f61602b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        if (this.f61601a instanceof TTPluginListener) {
                            f.a(TTAppContextHolder.getContext()).a((TTPluginListener) this.f61601a);
                        }
                        tTAdManager.register(this.f61602b);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            call(new InterfaceC1849a<TTAdManager>(this, context) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f61612a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61613b;

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
                    this.f61613b = this;
                    this.f61612a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.requestPermissionIfNecessary(this.f61612a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            call(new InterfaceC1849a<TTAdManager>(this, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f61614a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61615b;

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
                    this.f61615b = this;
                    this.f61614a = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        this.f61615b.f61595b.setThemeStatus(this.f61614a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, exitInstallListener)) == null) ? this.f61595b != null && this.f61595b.tryShowInstallDialogWhenExit(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            call(new InterfaceC1849a<TTAdManager>(this, obj) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f61604a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61605b;

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
                    this.f61605b = this;
                    this.f61604a = obj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.unregister(this.f61604a);
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
            if (this.f61595b != null) {
                return this.f61595b.getBiddingToken(adSlot, z, i2);
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(TTAdManager tTAdManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTAdManager) == null) {
            this.f61595b = tTAdManager;
        }
    }
}
