package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f29162a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Context> f29163b;

    /* renamed from: c  reason: collision with root package name */
    public final p f29164c;

    /* loaded from: classes6.dex */
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
        this.f29163b = new WeakReference<>(context);
        this.f29164c = o.f();
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f29163b = new WeakReference<>(context);
        }
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f29162a == null) {
                synchronized (b.class) {
                    if (f29162a == null) {
                        f29162a = new b(context);
                    }
                }
            } else {
                f29162a.b(context);
            }
            return f29162a;
        }
        return (b) invokeL.objValue;
    }

    public void a(@NonNull AdSlot adSlot, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, aVar) == null) {
            this.f29164c.a(adSlot, new n(), 1, new p.b(this, aVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29165a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29166b;

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
                    this.f29166b = this;
                    this.f29165a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        j.b("BannerAdManager", str + GlideException.IndentedAppendable.INDENT + i2);
                        a aVar2 = this.f29165a;
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
                        this.f29166b.a(mVar, this.f29165a);
                        return;
                    }
                    j.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    a aVar3 = this.f29165a;
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
            this.f29164c.a(adSlot, new n(), 1, new p.b(this, bannerAdListener, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.BannerAdListener f29167a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29168b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f29169c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f29170d;

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
                    this.f29170d = this;
                    this.f29167a = bannerAdListener;
                    this.f29168b = adSlot;
                    this.f29169c = r9;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29167a.onError(i2, str);
                        j.b("BannerAdManager", str + " " + i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            m mVar = aVar.c().get(0);
                            if (mVar.aK()) {
                                this.f29170d.a(mVar, new a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ m f29171a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f29172b;

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
                                        this.f29172b = this;
                                        this.f29171a = mVar;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) || this.f29172b.f29170d.f29163b.get() == null) {
                                            return;
                                        }
                                        e eVar = new e((Context) this.f29172b.f29170d.f29163b.get(), aVar2, this.f29172b.f29168b);
                                        com.bytedance.sdk.openadsdk.e.d.a((Context) this.f29172b.f29170d.f29163b.get(), this.f29171a, com.bytedance.sdk.openadsdk.r.o.b(this.f29172b.f29168b.getDurationSlotType()), this.f29172b.f29169c);
                                        this.f29172b.f29167a.onBannerAdLoad(eVar);
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f29172b.f29167a.onError(-5, g.a(-5));
                                        }
                                    }
                                });
                                return;
                            }
                            j.b("BannerAdManager", "Banner广告解析失败");
                            this.f29167a.onError(-4, g.a(-4));
                            return;
                        }
                        j.b("BannerAdManager", "Banner广告解析失败/广告为空");
                        this.f29167a.onError(-4, g.a(-4));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull m mVar, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, this, mVar, aVar) == null) {
            com.bytedance.sdk.openadsdk.g.a.a(mVar.ad().get(0)).a(new com.bytedance.sdk.component.d.g<Bitmap>(this, aVar, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29173a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ m f29174b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f29175c;

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
                    this.f29175c = this;
                    this.f29173a = aVar;
                    this.f29174b = mVar;
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(com.bytedance.sdk.component.d.m<Bitmap> mVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar2) == null) {
                        if (mVar2 != null && mVar2.a() != null) {
                            a aVar2 = this.f29173a;
                            if (aVar2 != null) {
                                aVar2.a(new com.bytedance.sdk.openadsdk.component.a.a(mVar2.a(), this.f29174b));
                                return;
                            }
                            return;
                        }
                        a aVar3 = this.f29173a;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(int i2, String str, @Nullable Throwable th) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) || (aVar2 = this.f29173a) == null) {
                        return;
                    }
                    aVar2.a();
                }
            });
        }
    }
}
