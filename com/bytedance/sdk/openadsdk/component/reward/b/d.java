package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.h;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.i;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f29523a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29524b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29525c;

    /* renamed from: d  reason: collision with root package name */
    public String f29526d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29527e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29528f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f29529g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f29530h;

    /* renamed from: i  reason: collision with root package name */
    public long f29531i;
    public Activity j;
    public m k;
    public FrameLayout l;
    public String m;
    public boolean n;

    public d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29524b = false;
        this.f29525c = false;
        this.f29528f = false;
        this.f29529g = new AtomicBoolean(false);
        this.n = false;
        this.j = activity;
    }

    private void E() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (cVar = this.f29530h) == null || cVar.v() == null) {
            return;
        }
        this.f29523a = this.f29530h.n();
        if (this.f29530h.v().h() || !this.f29530h.v().l()) {
            this.f29530h.i();
            this.f29530h.l();
            this.f29524b = true;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29529g.set(true);
        }
    }

    public double B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.k;
            if (mVar == null || mVar.V() == null) {
                return 0.0d;
            }
            return this.k.V().e();
        }
        return invokeV.doubleValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29531i : invokeV.longValue;
    }

    public i D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.w();
            }
            return null;
        }
        return (i) invokeV.objValue;
    }

    public void a(FrameLayout frameLayout, m mVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{frameLayout, mVar, str, Boolean.valueOf(z)}) == null) || this.n) {
            return;
        }
        this.n = true;
        this.k = mVar;
        this.l = frameLayout;
        this.m = str;
        this.f29527e = z;
        if (z) {
            this.f29530h = new g(this.j, frameLayout, mVar);
        } else {
            this.f29530h = new com.bytedance.sdk.openadsdk.component.reward.b(this.j, frameLayout, mVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            return (cVar == null || cVar.v() == null || !this.f29530h.v().i()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            return cVar != null && cVar.y();
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f29524b : invokeV.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f29523a : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? q.a(this.f29530h, this.f29525c) : invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(Build.MODEL) && !"M5".equals(Build.MODEL) && !"R7t".equals(Build.MODEL)) {
                try {
                    if (a()) {
                        this.f29530h.i();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    k.c("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
                    return;
                }
            }
            E();
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.l();
        this.f29530h = null;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.f29530h != null && a()) {
            this.f29530h.b(true);
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.m();
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.k();
    }

    public void l() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.i();
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.r();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.s();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.n();
            }
            return this.f29523a;
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.o();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.p();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (cVar = this.f29530h) == null || cVar.v() == null) {
            return;
        }
        this.f29530h.v().d();
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.q();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void t() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (cVar = this.f29530h) == null || cVar.v() == null || !this.f29530h.v().g()) {
            return;
        }
        l();
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                return cVar.t();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            if (cVar != null) {
                if (cVar.v() != null) {
                    com.bytedance.sdk.openadsdk.core.video.c.d v = this.f29530h.v();
                    if (v.i() || v.j()) {
                        ((com.bytedance.sdk.openadsdk.core.video.b.a) this.f29530h).z();
                        return true;
                    }
                } else if (d()) {
                    a(false);
                    ((com.bytedance.sdk.openadsdk.core.video.b.a) this.f29530h).z();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f29530h != null : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            return cVar != null && cVar.v() == null;
        }
        return invokeV.booleanValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f29526d : (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            try {
                if (a()) {
                    this.f29528f = true;
                    l();
                }
            } catch (Throwable th) {
                k.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        }
    }

    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.b(z);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            h();
            if (TextUtils.isEmpty(this.f29526d)) {
                if (z) {
                    h.a(o.a()).a();
                } else {
                    com.bytedance.sdk.openadsdk.component.reward.c.a(o.a()).b();
                }
            }
        }
    }

    public void b(boolean z, com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048594, this, z, bVar) == null) || z || this.f29528f) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(Build.MODEL) && !"M5".equals(Build.MODEL) && !"R7t".equals(Build.MODEL)) {
            if (b()) {
                k();
                return;
            }
            return;
        }
        a(bVar);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29530h;
            return (cVar == null || cVar.v() == null || !this.f29530h.v().g()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f29523a = j;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f29524b = z;
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f29530h == null) {
            return;
        }
        o.a aVar = new o.a();
        aVar.b(p());
        aVar.c(s());
        aVar.a(o());
        aVar.c(i2);
        aVar.d(i3);
        com.bytedance.sdk.openadsdk.e.a.a.e(this.j.getApplicationContext(), this.f29530h.w(), aVar);
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.f29531i = j;
        }
    }

    public void a(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, map) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.a(map);
    }

    public void a(c.a aVar) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        cVar.a(aVar);
    }

    public void a(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) || (cVar = this.f29530h) == null) {
            return;
        }
        Map<String, Object> a2 = q.a(this.k, cVar.o(), this.f29530h.v());
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                a2.put(entry.getKey(), entry.getValue());
            }
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.j, this.k, this.m, str, s(), n(), a2);
        k.b("TTBaseVideoActivity", "event tag:" + this.m + ", TotalPlayDuration=" + s() + ",mBasevideoController.getPct()=" + n());
    }

    public boolean a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            k.b("TTBaseVideoActivity", "playVideo start");
            if (this.f29530h != null && this.k.V() != null) {
                File file = new File(CacheDirConstants.getRewardFullCacheDir(), this.k.V().l());
                if (file.exists() && file.length() > 0) {
                    this.f29525c = true;
                }
                com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                bVar.a(this.k.V().i());
                bVar.d(this.k.ak());
                bVar.b(this.l.getWidth());
                bVar.c(this.l.getHeight());
                bVar.e(this.k.ao());
                bVar.a(j);
                bVar.a(z);
                bVar.c(CacheDirConstants.getRewardFullCacheDir());
                bVar.b(this.k.V().l());
                return this.f29530h.a(bVar);
            }
            k.b("TTBaseVideoActivity", "playVideo controller or video is Empty");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f29526d = str;
        }
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, bVar) == null) {
            try {
                this.f29528f = false;
                if (d()) {
                    b(z, bVar);
                }
                if (b()) {
                    k();
                }
            } catch (Throwable th) {
                k.f("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f29529g.getAndSet(false) || !v() || bVar == null) {
            return;
        }
        bVar.a(e(), true);
    }
}
