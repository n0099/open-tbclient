package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.core.e.f;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66032a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66033b;

    /* renamed from: c  reason: collision with root package name */
    public final m f66034c;

    /* renamed from: d  reason: collision with root package name */
    public final String f66035d;

    /* renamed from: e  reason: collision with root package name */
    public final int f66036e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<View> f66037f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f66038g;

    /* renamed from: h  reason: collision with root package name */
    public f f66039h;

    /* renamed from: i  reason: collision with root package name */
    public a f66040i;

    /* renamed from: j  reason: collision with root package name */
    public TTNativeAd f66041j;
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c k;
    public boolean l;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a m;
    public Map<String, Object> n;
    public TTNativeExpressAd o;
    public TTSplashAd p;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
    public boolean r;
    public InterfaceC1902b s;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view, int i2);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1902b {
        void a();

        void b();
    }

    public b(@NonNull Context context, @NonNull m mVar, @NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.r = false;
        this.f66033b = context;
        this.f66034c = mVar;
        this.f66035d = str;
        this.f66036e = i2;
        this.n = new HashMap();
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.f66038g = new WeakReference<>(view);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.r = z;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l = z;
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f66032a : (String) invokeV.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page") : invokeL.booleanValue;
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public void e() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (mVar = this.f66034c) == null) {
            return;
        }
        boolean a2 = o.a(mVar);
        z.a(this.f66033b, this.f66034c, this.f66036e, this.f66041j, this.o, this.p, a2 ? this.f66035d : q.a(this.f66036e), this.m, a2, this.n, this.r, b(this.f66035d));
    }

    public void a(TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tTNativeAd) == null) {
            this.f66041j = tTNativeAd;
        }
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tTNativeExpressAd) == null) {
            this.o = tTNativeExpressAd;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void a(TTSplashAd tTSplashAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tTSplashAd) == null) {
            this.p = tTSplashAd;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f66040i = aVar;
        }
    }

    public void a(InterfaceC1902b interfaceC1902b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC1902b) == null) {
            this.s = interfaceC1902b;
        }
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f66037f = new WeakReference<>(view);
        }
    }

    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            Map<String, Object> map2 = this.n;
            if (map2 == null) {
                this.n = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || a(1)) {
            return;
        }
        if (this.f66033b == null) {
            this.f66033b = com.bytedance.sdk.openadsdk.core.o.a();
        }
        if (this.f66033b == null) {
            return;
        }
        long j2 = this.x;
        long j3 = this.y;
        WeakReference<View> weakReference = this.f66037f;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f66038g;
        this.f66039h = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get(), f());
        a aVar = this.f66040i;
        if (aVar != null) {
            aVar.a(view, -1);
        }
        boolean a2 = o.a(this.f66034c);
        boolean a3 = z.a(this.f66033b, this.f66034c, this.f66036e, this.f66041j, this.o, this.p, a2 ? this.f66035d : q.a(this.f66036e), this.m, a2, this.n, this.r, b(this.f66035d));
        if (a3 || (mVar = this.f66034c) == null || mVar.an() == null || this.f66034c.an().c() != 2) {
            com.bytedance.sdk.openadsdk.e.d.a(this.f66033b, PrefetchEvent.STATE_CLICK, this.f66034c, this.f66039h, this.f66035d, a3, this.n);
        }
    }

    public f a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Long.valueOf(j3), view, view2, str})) == null) {
            return new f.a().e(i2).d(i3).c(i4).b(i5).b(j2).a(j3).b(s.a(view)).a(s.a(view2)).c(s.c(view)).d(s.c(view2)).f(this.z).g(this.A).h(this.B).a(this.D).a(h.d().b() ? 1 : 2).a(str).a();
        }
        return (f) invokeCommon.objValue;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.q != null) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                WeakReference<View> weakReference = this.f66038g;
                if (weakReference != null) {
                    iArr = s.a(weakReference.get());
                    iArr2 = s.c(this.f66038g.get());
                }
                this.q.a(i2, new k.a().d(this.t).c(this.u).b(this.v).a(this.w).b(this.x).a(this.y).e(iArr[0]).f(iArr[1]).g(iArr2[0]).h(iArr2[1]).a());
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f66032a = str;
        }
    }
}
