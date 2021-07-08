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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.h;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.r.o;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f29424a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29425b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29426c;

    /* renamed from: d  reason: collision with root package name */
    public String f29427d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29428e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29429f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f29430g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f29431h;

    /* renamed from: i  reason: collision with root package name */
    public long f29432i;
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
        this.f29425b = false;
        this.f29426c = false;
        this.f29429f = false;
        this.f29430g = new AtomicBoolean(false);
        this.n = false;
        this.j = activity;
    }

    private void B() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (cVar = this.f29431h) == null || cVar.u() == null) {
            return;
        }
        this.f29424a = this.f29431h.n();
        if (this.f29431h.u().h() || !this.f29431h.u().l()) {
            this.f29431h.i();
            this.f29431h.l();
            this.f29425b = true;
        }
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29432i : invokeV.longValue;
    }

    public void a(FrameLayout frameLayout, m mVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{frameLayout, mVar, str, Boolean.valueOf(z)}) == null) || this.n) {
            return;
        }
        this.n = true;
        this.k = mVar;
        this.l = frameLayout;
        this.m = str;
        this.f29428e = z;
        if (z) {
            this.f29431h = new g(this.j, frameLayout, mVar);
        } else {
            this.f29431h = new com.bytedance.sdk.openadsdk.component.reward.b(this.j, frameLayout, mVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            return (cVar == null || cVar.u() == null || !this.f29431h.u().i()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            return cVar != null && cVar.x();
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f29425b : invokeV.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f29424a : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? o.a(this.f29431h, this.f29426c) : invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(Build.MODEL) && !"M5".equals(Build.MODEL) && !"R7t".equals(Build.MODEL)) {
                try {
                    if (a()) {
                        this.f29431h.i();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    j.b("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage());
                    return;
                }
            }
            B();
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.l();
        this.f29431h = null;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.f29431h != null && a()) {
            this.f29431h.c(true);
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.m();
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.k();
    }

    public void l() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.i();
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                return cVar.q();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                return cVar.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                return cVar.n();
            }
            return this.f29424a;
        }
        return invokeV.longValue;
    }

    public void p() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (cVar = this.f29431h) == null || cVar.u() == null) {
            return;
        }
        this.f29431h.u().d();
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                return cVar.p();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (cVar = this.f29431h) == null || cVar.u() == null || !this.f29431h.u().g()) {
            return;
        }
        l();
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                return cVar.s();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                if (cVar.u() != null) {
                    com.bytedance.sdk.openadsdk.core.video.c.d u = this.f29431h.u();
                    if (u.i() || u.j()) {
                        ((com.bytedance.sdk.openadsdk.core.video.b.a) this.f29431h).y();
                        return true;
                    }
                } else if (d()) {
                    a(false);
                    ((com.bytedance.sdk.openadsdk.core.video.b.a) this.f29431h).y();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f29431h != null : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            return cVar != null && cVar.u() == null;
        }
        return invokeV.booleanValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f29427d : (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            try {
                if (a()) {
                    this.f29429f = true;
                    l();
                }
            } catch (Throwable th) {
                j.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f29430g.set(true);
        }
    }

    public double z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            m mVar = this.k;
            if (mVar == null || mVar.V() == null) {
                return 0.0d;
            }
            return this.k.V().e();
        }
        return invokeV.doubleValue;
    }

    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.c(z);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            h();
            if (TextUtils.isEmpty(this.f29427d)) {
                if (z) {
                    h.a(com.bytedance.sdk.openadsdk.core.o.a()).a();
                } else {
                    com.bytedance.sdk.openadsdk.component.reward.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b();
                }
            }
        }
    }

    public void b(boolean z, com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048591, this, z, bVar) == null) || z || this.f29429f) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            return (cVar == null || cVar.u() == null || !this.f29431h.u().g()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f29424a = j;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f29425b = z;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: java.util.Map<java.lang.String, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("vbtt_skip_type", Integer.valueOf(i2));
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29431h;
            if (cVar != null) {
                Map<String, Object> a2 = o.a(this.k, cVar.o(), this.f29431h.u());
                for (Map.Entry entry : hashMap.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
                a2.put("play_type", Integer.valueOf(o.a(this.f29431h, this.f29426c)));
                com.bytedance.sdk.openadsdk.e.d.a(this.j, this.k, this.m, "endcard_skip", this.f29431h.p(), this.f29431h.r(), a2);
            }
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.f29432i = j;
        }
    }

    public void a(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.a(map);
    }

    public void a(c.a aVar) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        cVar.a(aVar);
    }

    public void a(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, map) == null) || (cVar = this.f29431h) == null) {
            return;
        }
        Map<String, Object> a2 = o.a(this.k, cVar.o(), this.f29431h.u());
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                a2.put(entry.getKey(), entry.getValue());
            }
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.j, this.k, this.m, str, q(), n(), a2);
        j.b("TTBaseVideoActivity", "event tag:" + this.m + ", TotalPlayDuration=" + q() + ",mBasevideoController.getPct()=" + n());
    }

    public boolean a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            j.b("TTBaseVideoActivity", "playVideo start");
            if (this.f29431h != null && this.k.V() != null) {
                File file = new File(CacheDirConstants.getRewardFullCacheDir(), this.k.V().l());
                if (file.exists() && file.length() > 0) {
                    this.f29426c = true;
                }
                com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                bVar.a(this.k.V().i());
                bVar.d(this.k.ak());
                bVar.b(this.l.getWidth());
                bVar.c(this.l.getHeight());
                bVar.e(this.k.ao());
                bVar.a(j);
                bVar.a(z);
                bVar.c(CacheDirConstants.getRewardFullCacheDir());
                bVar.b(this.k.V().l());
                return this.f29431h.a(bVar);
            }
            j.b("TTBaseVideoActivity", "playVideo controller or video is Empty");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f29427d = str;
        }
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, bVar) == null) {
            try {
                this.f29429f = false;
                if (d()) {
                    b(z, bVar);
                }
                if (b()) {
                    k();
                }
            } catch (Throwable th) {
                j.f("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f29430g.getAndSet(false) || !t() || bVar == null) {
            return;
        }
        bVar.a(e(), true);
    }
}
