package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65449a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Context> f65450b;

    /* renamed from: c  reason: collision with root package name */
    public final p f65451c;

    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar);
    }

    public b(Context context) {
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
        this.f65450b = new WeakReference<>(context);
        this.f65451c = o.f();
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f65450b = new WeakReference<>(context);
        }
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f65449a == null) {
                synchronized (b.class) {
                    if (f65449a == null) {
                        f65449a = new b(context);
                    }
                }
            } else {
                f65449a.b(context);
            }
            return f65449a;
        }
        return (b) invokeL.objValue;
    }

    public void a(@NonNull AdSlot adSlot, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, aVar) == null) {
            this.f65451c.a(adSlot, new n(), 1, new p.b(this, aVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65452a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f65453b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65453b = this;
                    this.f65452a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        k.b("BannerAdManager", str + GlideException.IndentedAppendable.INDENT + i2);
                        a aVar2 = this.f65452a;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) || aVar2.c() == null || aVar2.c().isEmpty()) {
                        return;
                    }
                    m mVar = aVar2.c().get(0);
                    if (mVar.aK()) {
                        this.f65453b.a(mVar, this.f65452a);
                        return;
                    }
                    k.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    a aVar3 = this.f65452a;
                    if (aVar3 != null) {
                        aVar3.a();
                    }
                }
            });
        }
    }

    public void a(@NonNull AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adSlot, bannerAdListener) == null) {
            this.f65451c.a(adSlot, new n(), 1, new p.b(this, bannerAdListener, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.BannerAdListener f65454a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65455b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f65456c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f65457d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bannerAdListener, adSlot, Long.valueOf(r9)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65457d = this;
                    this.f65454a = bannerAdListener;
                    this.f65455b = adSlot;
                    this.f65456c = r9;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f65454a.onError(i2, str);
                        k.b("BannerAdManager", str + " " + i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            m mVar = aVar.c().get(0);
                            if (mVar.aK()) {
                                this.f65457d.a(mVar, new a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ m f65458a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f65459b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, mVar};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f65459b = this;
                                        this.f65458a = mVar;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) || this.f65459b.f65457d.f65450b.get() == null) {
                                            return;
                                        }
                                        e eVar = new e((Context) this.f65459b.f65457d.f65450b.get(), aVar2, this.f65459b.f65455b);
                                        com.bytedance.sdk.openadsdk.e.d.a((Context) this.f65459b.f65457d.f65450b.get(), this.f65458a, q.b(this.f65459b.f65455b.getDurationSlotType()), this.f65459b.f65456c);
                                        this.f65459b.f65454a.onBannerAdLoad(eVar);
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f65459b.f65454a.onError(-5, g.a(-5));
                                        }
                                    }
                                });
                                return;
                            }
                            k.b("BannerAdManager", "Banner广告解析失败");
                            this.f65454a.onError(-4, g.a(-4));
                            return;
                        }
                        k.b("BannerAdManager", "Banner广告解析失败/广告为空");
                        this.f65454a.onError(-4, g.a(-4));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull m mVar, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar, aVar) == null) {
            ImageLoaderWrapper.from(mVar.ad().get(0)).to(new ILoaderListener<Bitmap>(this, aVar, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f65460a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ m f65461b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f65462c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65462c = this;
                    this.f65460a = aVar;
                    this.f65461b = mVar;
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onFailed(int i2, String str, @Nullable Throwable th) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) || (aVar2 = this.f65460a) == null) {
                        return;
                    }
                    aVar2.a();
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onSuccess(ImageResponse<Bitmap> imageResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                        if (imageResponse != null && imageResponse.getResult() != null) {
                            a aVar2 = this.f65460a;
                            if (aVar2 != null) {
                                aVar2.a(new com.bytedance.sdk.openadsdk.component.a.a(imageResponse.getResult(), this.f65461b));
                                return;
                            }
                            return;
                        }
                        a aVar3 = this.f65460a;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                    }
                }
            });
        }
    }
}
