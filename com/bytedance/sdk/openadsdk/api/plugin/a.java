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
    public static final a f61595a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f61596b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TTAdNative f61597a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f61598b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f61599c;

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
            this.f61599c = aVar;
            this.f61598b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(InterfaceC1849a<TTAdNative> interfaceC1849a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1849a) == null) {
                TTAdNative tTAdNative = this.f61597a;
                if (tTAdNative != null) {
                    interfaceC1849a.a(tTAdNative);
                } else {
                    this.f61599c.call(new InterfaceC1849a<TTAdManager>(this, interfaceC1849a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC1849a f61600a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f61601b;

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
                            this.f61601b = this;
                            this.f61600a = interfaceC1849a;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                        public void a(TTAdManager tTAdManager) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                                AnonymousClass1 anonymousClass1 = this.f61601b;
                                anonymousClass1.f61597a = tTAdManager.createAdNative(anonymousClass1.f61598b);
                                this.f61600a.a(this.f61601b.f61597a);
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
        public b<TTAdNative> f61619a;

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
            this.f61619a = bVar;
        }

        private final void a(CommonListener commonListener, InterfaceC1849a<TTAdNative> interfaceC1849a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, commonListener, interfaceC1849a) == null) {
                try {
                    this.f61619a.a(interfaceC1849a);
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
                    public final /* synthetic */ AdSlot f61623a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.BannerAdListener f61624b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61625c;

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
                        this.f61625c = this;
                        this.f61623a = adSlot;
                        this.f61624b = bannerAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerAd(this.f61623a, this.f61624b);
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
                    public final /* synthetic */ AdSlot f61648a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61649b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61650c;

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
                        this.f61650c = this;
                        this.f61648a = adSlot;
                        this.f61649b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerExpressAd(this.f61648a, this.f61649b);
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
                    public final /* synthetic */ AdSlot f61657a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.DrawFeedAdListener f61658b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61659c;

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
                        this.f61659c = this;
                        this.f61657a = adSlot;
                        this.f61658b = drawFeedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadDrawFeedAd(this.f61657a, this.f61658b);
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
                    public final /* synthetic */ AdSlot f61645a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61646b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61647c;

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
                        this.f61647c = this;
                        this.f61645a = adSlot;
                        this.f61646b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadExpressDrawFeedAd(this.f61645a, this.f61646b);
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
                    public final /* synthetic */ AdSlot f61620a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f61621b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61622c;

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
                        this.f61622c = this;
                        this.f61620a = adSlot;
                        this.f61621b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFeedAd(this.f61620a, this.f61621b);
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
                    public final /* synthetic */ AdSlot f61639a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f61640b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61641c;

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
                        this.f61641c = this;
                        this.f61639a = adSlot;
                        this.f61640b = fullScreenVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFullScreenVideoAd(this.f61639a, this.f61640b);
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
                    public final /* synthetic */ AdSlot f61626a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.InteractionAdListener f61627b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61628c;

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
                        this.f61628c = this;
                        this.f61626a = adSlot;
                        this.f61627b = interactionAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionAd(this.f61626a, this.f61627b);
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
                    public final /* synthetic */ AdSlot f61651a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61652b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61653c;

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
                        this.f61653c = this;
                        this.f61651a = adSlot;
                        this.f61652b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionExpressAd(this.f61651a, this.f61652b);
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
                    public final /* synthetic */ AdSlot f61660a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeAdListener f61661b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61662c;

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
                        this.f61662c = this;
                        this.f61660a = adSlot;
                        this.f61661b = nativeAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeAd(this.f61660a, this.f61661b);
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
                    public final /* synthetic */ AdSlot f61642a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f61643b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61644c;

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
                        this.f61644c = this;
                        this.f61642a = adSlot;
                        this.f61643b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeExpressAd(this.f61642a, this.f61643b);
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
                    public final /* synthetic */ AdSlot f61636a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f61637b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61638c;

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
                        this.f61638c = this;
                        this.f61636a = adSlot;
                        this.f61637b = rewardVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadRewardVideoAd(this.f61636a, this.f61637b);
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
                    public final /* synthetic */ AdSlot f61629a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f61630b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f61631c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f61632d;

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
                        this.f61632d = this;
                        this.f61629a = adSlot;
                        this.f61630b = splashAdListener;
                        this.f61631c = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f61629a, this.f61630b, this.f61631c);
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
                    public final /* synthetic */ AdSlot f61654a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f61655b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61656c;

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
                        this.f61656c = this;
                        this.f61654a = adSlot;
                        this.f61655b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadStream(this.f61654a, this.f61655b);
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
                    public final /* synthetic */ AdSlot f61633a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f61634b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f61635c;

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
                        this.f61635c = this;
                        this.f61633a = adSlot;
                        this.f61634b = splashAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.f61633a, this.f61634b);
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
        f61595a = new a();
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
            if (this.f61596b != null) {
                try {
                    interfaceC1849a.a(this.f61596b);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                    return;
                }
            }
            ScheduledExecutorService scheduledExecutorService = g.f61690a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable(this, interfaceC1849a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC1849a f61617a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f61618b;

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
                        this.f61618b = this;
                        this.f61617a = interfaceC1849a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f61618b.f61596b != null) {
                                    this.f61617a.a(this.f61618b.f61596b);
                                    return;
                                }
                                if (this.f61617a instanceof c) {
                                    ((c) this.f61617a).a();
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
            if (this.f61596b != null) {
                return this.f61596b.getBiddingToken(adSlot);
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
            if (this.f61596b != null) {
                return (T) this.f61596b.getExtra(cls, bundle);
            }
            if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
                call(new c<TTAdManager>(this, bundle, cls) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Bundle f61607a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Class f61608b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61609c;

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
                        this.f61609c = this;
                        this.f61607a = bundle;
                        this.f61608b = cls;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.a(this.f61607a);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                    public void a(TTAdManager tTAdManager) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAdManager) == null) {
                            tTAdManager.getExtra(this.f61608b, this.f61607a);
                        }
                    }
                });
                return null;
            }
            call(new InterfaceC1849a<TTAdManager>(this, cls, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Class f61610a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Bundle f61611b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61612c;

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
                    this.f61612c = this;
                    this.f61610a = cls;
                    this.f61611b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.getExtra(this.f61610a, this.f61611b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61596b != null ? this.f61596b.getPluginVersion() : "" : (String) invokeV.objValue;
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
            if (this.f61596b != null) {
                return this.f61596b.getThemeStatus();
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
            if (this.f61596b != null) {
                return this.f61596b.onlyVerityPlayable(str, i2, str2, str3, str4);
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
                public final /* synthetic */ Object f61602a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f61603b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61604c;

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
                    this.f61604c = this;
                    this.f61602a = obj;
                    this.f61603b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        if (this.f61602a instanceof TTPluginListener) {
                            f.a(TTAppContextHolder.getContext()).a((TTPluginListener) this.f61602a);
                        }
                        tTAdManager.register(this.f61603b);
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
                public final /* synthetic */ Context f61613a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61614b;

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
                    this.f61614b = this;
                    this.f61613a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.requestPermissionIfNecessary(this.f61613a);
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
                public final /* synthetic */ int f61615a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61616b;

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
                    this.f61616b = this;
                    this.f61615a = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        this.f61616b.f61596b.setThemeStatus(this.f61615a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, exitInstallListener)) == null) ? this.f61596b != null && this.f61596b.tryShowInstallDialogWhenExit(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            call(new InterfaceC1849a<TTAdManager>(this, obj) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object f61605a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61606b;

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
                    this.f61606b = this;
                    this.f61605a = obj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC1849a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.unregister(this.f61605a);
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
            if (this.f61596b != null) {
                return this.f61596b.getBiddingToken(adSlot, z, i2);
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(TTAdManager tTAdManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTAdManager) == null) {
            this.f61596b = tTAdManager;
        }
    }
}
