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
/* loaded from: classes2.dex */
public final class a implements TTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile TTAdManager f55287b;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements b<TTAdNative> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TTAdNative a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f55288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f55289c;

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
            this.f55289c = aVar;
            this.f55288b = context;
        }

        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.b
        public void a(InterfaceC2021a<TTAdNative> interfaceC2021a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC2021a) == null) {
                TTAdNative tTAdNative = this.a;
                if (tTAdNative != null) {
                    interfaceC2021a.a(tTAdNative);
                } else {
                    this.f55289c.call(new InterfaceC2021a<TTAdManager>(this, interfaceC2021a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InterfaceC2021a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f55290b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC2021a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f55290b = this;
                            this.a = interfaceC2021a;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                        public void a(TTAdManager tTAdManager) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                                AnonymousClass1 anonymousClass1 = this.f55290b;
                                anonymousClass1.a = tTAdManager.createAdNative(anonymousClass1.f55288b);
                                this.a.a(this.f55290b.a);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2021a<T> {
        void a(T t);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(InterfaceC2021a<T> interfaceC2021a);
    }

    /* loaded from: classes2.dex */
    public interface c<T> extends InterfaceC2021a<T> {
        void a();
    }

    /* loaded from: classes2.dex */
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

        private final void a(CommonListener commonListener, InterfaceC2021a<TTAdNative> interfaceC2021a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, commonListener, interfaceC2021a) == null) {
                try {
                    this.a.a(interfaceC2021a);
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
                a(bannerAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, bannerAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.BannerAdListener f55303b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55304c;

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
                        this.f55304c = this;
                        this.a = adSlot;
                        this.f55303b = bannerAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerAd(this.a, this.f55303b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f55320b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55321c;

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
                        this.f55321c = this;
                        this.a = adSlot;
                        this.f55320b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadBannerExpressAd(this.a, this.f55320b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, drawFeedAdListener) == null) {
                a(drawFeedAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, drawFeedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.DrawFeedAdListener f55326b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55327c;

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
                        this.f55327c = this;
                        this.a = adSlot;
                        this.f55326b = drawFeedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadDrawFeedAd(this.a, this.f55326b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f55318b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55319c;

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
                        this.f55319c = this;
                        this.a = adSlot;
                        this.f55318b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadExpressDrawFeedAd(this.a, this.f55318b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f55301b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55302c;

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
                        this.f55302c = this;
                        this.a = adSlot;
                        this.f55301b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFeedAd(this.a, this.f55301b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, adSlot, fullScreenVideoAdListener) == null) {
                a(fullScreenVideoAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, fullScreenVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f55314b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55315c;

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
                        this.f55315c = this;
                        this.a = adSlot;
                        this.f55314b = fullScreenVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadFullScreenVideoAd(this.a, this.f55314b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionAd(AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, adSlot, interactionAdListener) == null) {
                a(interactionAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, interactionAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.InteractionAdListener f55305b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55306c;

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
                        this.f55306c = this;
                        this.a = adSlot;
                        this.f55305b = interactionAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionAd(this.a, this.f55305b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f55322b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55323c;

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
                        this.f55323c = this;
                        this.a = adSlot;
                        this.f55322b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadInteractionExpressAd(this.a, this.f55322b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adSlot, nativeAdListener) == null) {
                a(nativeAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, nativeAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeAdListener f55328b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55329c;

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
                        this.f55329c = this;
                        this.a = adSlot;
                        this.f55328b = nativeAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeAd(this.a, this.f55328b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, adSlot, nativeExpressAdListener) == null) {
                a(nativeExpressAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, nativeExpressAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.NativeExpressAdListener f55316b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55317c;

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
                        this.f55317c = this;
                        this.a = adSlot;
                        this.f55316b = nativeExpressAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadNativeExpressAd(this.a, this.f55316b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, adSlot, rewardVideoAdListener) == null) {
                a(rewardVideoAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, rewardVideoAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f55312b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55313c;

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
                        this.f55313c = this;
                        this.a = adSlot;
                        this.f55312b = rewardVideoAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadRewardVideoAd(this.a, this.f55312b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048588, this, adSlot, splashAdListener, i2) == null) {
                a(splashAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, splashAdListener, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f55307b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f55308c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f55309d;

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
                        this.f55309d = this;
                        this.a = adSlot;
                        this.f55307b = splashAdListener;
                        this.f55308c = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.a, this.f55307b, this.f55308c);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, adSlot, feedAdListener) == null) {
                a(feedAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, feedAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FeedAdListener f55324b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55325c;

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
                        this.f55325c = this;
                        this.a = adSlot;
                        this.f55324b = feedAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadStream(this.a, this.f55324b);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, adSlot, splashAdListener) == null) {
                a(splashAdListener, new InterfaceC2021a<TTAdNative>(this, adSlot, splashAdListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.d.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdSlot a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.SplashAdListener f55310b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f55311c;

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
                        this.f55311c = this;
                        this.a = adSlot;
                        this.f55310b = splashAdListener;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdNative tTAdNative) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdNative) == null) {
                            tTAdNative.loadSplashAd(this.a, this.f55310b);
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
    public final void call(InterfaceC2021a<TTAdManager> interfaceC2021a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, interfaceC2021a) == null) {
            if (this.f55287b != null) {
                try {
                    interfaceC2021a.a(this.f55287b);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("PluginDefaultAdManager", "Unexpected manager call error: " + th.getMessage());
                    return;
                }
            }
            ScheduledExecutorService scheduledExecutorService = g.a;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.submit(new Runnable(this, interfaceC2021a) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InterfaceC2021a a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f55300b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC2021a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f55300b = this;
                        this.a = interfaceC2021a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f55300b.f55287b != null) {
                                    this.a.a(this.f55300b.f55287b);
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
            if (this.f55287b != null) {
                return this.f55287b.getBiddingToken(adSlot);
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
            if (this.f55287b != null) {
                return (T) this.f55287b.getExtra(cls, bundle);
            }
            if (cls == Bundle.class && bundle != null && bundle.getInt("action", 0) == 1) {
                call(new c<TTAdManager>(this, bundle, cls) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Bundle a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Class f55294b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f55295c;

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
                        this.f55295c = this;
                        this.a = bundle;
                        this.f55294b = cls;
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e.a(this.a);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                    public void a(TTAdManager tTAdManager) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTAdManager) == null) {
                            tTAdManager.getExtra(this.f55294b, this.a);
                        }
                    }
                });
                return null;
            }
            call(new InterfaceC2021a<TTAdManager>(this, cls, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Class a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Bundle f55296b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f55297c;

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
                    this.f55297c = this;
                    this.a = cls;
                    this.f55296b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        tTAdManager.getExtra(this.a, this.f55296b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55287b != null ? this.f55287b.getPluginVersion() : "" : (String) invokeV.objValue;
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
            if (this.f55287b != null) {
                return this.f55287b.getThemeStatus();
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
            if (this.f55287b != null) {
                return this.f55287b.onlyVerityPlayable(str, i2, str2, str3, str4);
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
            call(new InterfaceC2021a<TTAdManager>(this, obj, bundle) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f55291b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f55292c;

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
                    this.f55292c = this;
                    this.a = obj;
                    this.f55291b = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        if (this.a instanceof TTPluginListener) {
                            f.a(TTAppContextHolder.getContext()).a((TTPluginListener) this.a);
                        }
                        tTAdManager.register(this.f55291b);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            call(new InterfaceC2021a<TTAdManager>(this, context) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f55298b;

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
                    this.f55298b = this;
                    this.a = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
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
            call(new InterfaceC2021a<TTAdManager>(this, i2) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f55299b;

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
                    this.f55299b = this;
                    this.a = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
                public void a(TTAdManager tTAdManager) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, tTAdManager) == null) {
                        this.f55299b.f55287b.setThemeStatus(this.a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, activity, exitInstallListener)) == null) ? this.f55287b != null && this.f55287b.tryShowInstallDialogWhenExit(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            call(new InterfaceC2021a<TTAdManager>(this, obj) { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f55293b;

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
                    this.f55293b = this;
                    this.a = obj;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.api.plugin.a.InterfaceC2021a
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
            if (this.f55287b != null) {
                return this.f55287b.getBiddingToken(adSlot, z, i2);
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public void a(TTAdManager tTAdManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTAdManager) == null) {
            this.f55287b = tTAdManager;
        }
    }
}
