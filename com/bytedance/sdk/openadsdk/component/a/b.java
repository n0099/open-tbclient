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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f29272a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Context> f29273b;

    /* renamed from: c  reason: collision with root package name */
    public final p f29274c;

    /* loaded from: classes5.dex */
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
        this.f29273b = new WeakReference<>(context);
        this.f29274c = o.f();
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            this.f29273b = new WeakReference<>(context);
        }
    }

    public static b a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f29272a == null) {
                synchronized (b.class) {
                    if (f29272a == null) {
                        f29272a = new b(context);
                    }
                }
            } else {
                f29272a.b(context);
            }
            return f29272a;
        }
        return (b) invokeL.objValue;
    }

    public void a(@NonNull AdSlot adSlot, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, aVar) == null) {
            this.f29274c.a(adSlot, new n(), 1, new p.b(this, aVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29275a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29276b;

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
                    this.f29276b = this;
                    this.f29275a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        j.b("BannerAdManager", str + GlideException.IndentedAppendable.INDENT + i2);
                        a aVar2 = this.f29275a;
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
                        this.f29276b.a(mVar, this.f29275a);
                        return;
                    }
                    j.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    a aVar3 = this.f29275a;
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
            this.f29274c.a(adSlot, new n(), 1, new p.b(this, bannerAdListener, adSlot, System.currentTimeMillis()) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.BannerAdListener f29277a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29278b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f29279c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f29280d;

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
                    this.f29280d = this;
                    this.f29277a = bannerAdListener;
                    this.f29278b = adSlot;
                    this.f29279c = r9;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29277a.onError(i2, str);
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
                                this.f29280d.a(mVar, new a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ m f29281a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f29282b;

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
                                        this.f29282b = this;
                                        this.f29281a = mVar;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a(@NonNull com.bytedance.sdk.openadsdk.component.a.a aVar2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) || this.f29282b.f29280d.f29273b.get() == null) {
                                            return;
                                        }
                                        e eVar = new e((Context) this.f29282b.f29280d.f29273b.get(), aVar2, this.f29282b.f29278b);
                                        com.bytedance.sdk.openadsdk.e.d.a((Context) this.f29282b.f29280d.f29273b.get(), this.f29281a, com.bytedance.sdk.openadsdk.r.o.b(this.f29282b.f29278b.getDurationSlotType()), this.f29282b.f29279c);
                                        this.f29282b.f29277a.onBannerAdLoad(eVar);
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f29282b.f29277a.onError(-5, g.a(-5));
                                        }
                                    }
                                });
                                return;
                            }
                            j.b("BannerAdManager", "Banner广告解析失败");
                            this.f29277a.onError(-4, g.a(-4));
                            return;
                        }
                        j.b("BannerAdManager", "Banner广告解析失败/广告为空");
                        this.f29277a.onError(-4, g.a(-4));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull m mVar, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar, aVar) == null) {
            com.bytedance.sdk.openadsdk.g.a.a(mVar.ad().get(0)).a(new com.bytedance.sdk.component.d.g<Bitmap>(this, aVar, mVar) { // from class: com.bytedance.sdk.openadsdk.component.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29283a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ m f29284b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f29285c;

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
                    this.f29285c = this;
                    this.f29283a = aVar;
                    this.f29284b = mVar;
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(com.bytedance.sdk.component.d.m<Bitmap> mVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar2) == null) {
                        if (mVar2 != null && mVar2.a() != null) {
                            a aVar2 = this.f29283a;
                            if (aVar2 != null) {
                                aVar2.a(new com.bytedance.sdk.openadsdk.component.a.a(mVar2.a(), this.f29284b));
                                return;
                            }
                            return;
                        }
                        a aVar3 = this.f29283a;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(int i2, String str, @Nullable Throwable th) {
                    a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) || (aVar2 = this.f29283a) == null) {
                        return;
                    }
                    aVar2.a();
                }
            });
        }
    }
}
