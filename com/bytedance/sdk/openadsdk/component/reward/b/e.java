package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f66142a;

    /* renamed from: b  reason: collision with root package name */
    public m f66143b;

    /* renamed from: c  reason: collision with root package name */
    public String f66144c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66145d;

    /* renamed from: e  reason: collision with root package name */
    public String f66146e;

    /* renamed from: f  reason: collision with root package name */
    public c f66147f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.video.b.b f66148g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.a.b f66149h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.a.c f66150i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.a.d f66151j;
    public com.bytedance.sdk.openadsdk.component.reward.a.a k;
    public boolean l;
    public int m;
    public boolean n;

    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void a(int i2);

        void b();

        void c();

        void d();

        c e();
    }

    public e(Activity activity) {
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
        this.m = -1;
        this.n = false;
        this.f66142a = activity;
        this.f66148g = (com.bytedance.sdk.openadsdk.core.video.b.b) activity;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66150i.B();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || o.j(this.f66143b)) {
            return;
        }
        int b2 = b(q.d(this.f66143b.ao()));
        if (b2 == -1) {
            this.f66148g.a(0);
        } else if (b2 >= 0) {
            this.f66148g.a(b2);
            this.m = b2;
            a(0L);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = true;
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                if (!cVar.u()) {
                    u();
                } else {
                    this.f66150i.d(false);
                }
            }
            if (this.f66149h != null) {
                this.k = this.f66150i;
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l = false;
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.f66151j;
            if (dVar != null) {
                dVar.e(false);
                this.f66151j.x();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                cVar.e();
                this.f66150i.b(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar != null) {
                this.k = bVar;
            }
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k instanceof com.bytedance.sdk.openadsdk.component.reward.a.c : invokeV.booleanValue;
    }

    public void F() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (mVar = this.f66143b) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.j.a.c f2 = com.bytedance.sdk.openadsdk.j.a.c.b().a(this.f66145d ? 7 : 8).c(String.valueOf(q.d(mVar.ao()))).f(q.h(this.f66143b.ao()));
        f2.b(g()).g(h());
        f2.h(this.f66143b.ao()).d(this.f66143b.ak());
        com.bytedance.sdk.openadsdk.j.a.a().l(f2);
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar == null) {
                return false;
            }
            return bVar.t();
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a(1000L);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                return aVar.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            return aVar != null ? aVar.i() : "";
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.o();
    }

    public void j() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.p();
    }

    public void k() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.q();
    }

    public void l() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.r();
    }

    public void m() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.s();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            B();
            this.f66147f.d(false);
            this.f66147f.a(0.0f);
            this.f66147f.a(this.f66143b.aM());
            if (this.k instanceof com.bytedance.sdk.openadsdk.component.reward.a.b) {
                this.f66147f.c(false);
            } else {
                this.f66147f.c(true);
            }
            this.k.d();
            this.k.d(true);
        }
    }

    public void o() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.e();
    }

    public void p() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.f();
    }

    public boolean q() {
        InterceptResult invokeV;
        boolean s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            m mVar = this.f66143b;
            if (mVar != null && mVar.V() != null && this.f66143b.V().a() == 1) {
                k.b("RewardFullWebViewManager", "can show end card follow js");
                s = r();
            } else {
                k.b("RewardFullWebViewManager", "can show end card follow js WebViewClient");
                s = s();
            }
            return s || o.a(this.f66143b);
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                return aVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                return aVar.c();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.k != null) {
                return this.f66150i.C();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.k == null) {
            return;
        }
        this.f66151j.e(this.l);
        this.f66151j.v();
        this.f66150i.e();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.k == null) {
            return;
        }
        this.f66150i.x();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.f66150i.y();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar != null) {
                bVar.g();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                cVar.g();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.f66151j;
            if (dVar != null) {
                dVar.g();
            }
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f66150i.z() : invokeV.longValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f66150i.A();
        }
    }

    public void a(c cVar, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{cVar, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2}) == null) || this.n) {
            return;
        }
        this.n = true;
        this.f66143b = mVar;
        this.f66145d = z;
        this.f66144c = str;
        this.f66147f = cVar;
        this.f66146e = str2;
        a(i2, i3, i4, f2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                aVar.j();
            }
            int i2 = this.m;
            if (i2 >= 0) {
                this.f66148g.a(i2);
                a(0L);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                aVar.k();
            }
            if (this.m >= 0) {
                this.f66148g.m();
            }
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.l();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar != null) {
                bVar.m();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                cVar.m();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.f66151j;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public void f() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.n();
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar instanceof com.bytedance.sdk.openadsdk.component.reward.a.b) {
                return com.bytedance.sdk.openadsdk.core.o.h().o(String.valueOf(i2));
            }
            if (aVar instanceof com.bytedance.sdk.openadsdk.component.reward.a.c) {
                return com.bytedance.sdk.openadsdk.core.o.h().p(String.valueOf(i2));
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void a(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            if (o.a(this.f66143b)) {
                this.f66150i = new com.bytedance.sdk.openadsdk.component.reward.a.c(this.f66142a, this.f66143b, this.f66144c, i2, i3, i4, f2, this.f66145d, this.f66146e);
                this.f66151j = new com.bytedance.sdk.openadsdk.component.reward.a.d(this.f66142a, this.f66143b, this.f66144c, i2, i3, i4, f2, this.f66145d, this.f66146e);
                if (this.f66143b.V() != null && !TextUtils.isEmpty(this.f66143b.V().j()) && o.b(this.f66143b)) {
                    this.f66149h = new com.bytedance.sdk.openadsdk.component.reward.a.b(this.f66142a, this.f66143b, this.f66144c, i2, i3, i4, f2, this.f66145d, this.f66146e);
                }
            } else {
                this.f66149h = new com.bytedance.sdk.openadsdk.component.reward.a.b(this.f66142a, this.f66143b, this.f66144c, i2, i3, i4, f2, this.f66145d, this.f66146e);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.f66150i;
            if (aVar == null) {
                aVar = this.f66149h;
            }
            this.k = aVar;
        }
    }

    public void a(long j2, long j3, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(j2, j3, i2);
    }

    public void a(int i2, int i3) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(i2, i3);
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.b(z);
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.i.e eVar, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), eVar, downloadListener}) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f66146e)) {
                hashMap.put("rit_scene", this.f66146e);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                cVar.a(this.f66145d, hashMap, this.f66147f.e(), eVar);
                this.f66151j.a(this.f66145d, null, null, null);
                this.f66150i.a(downloadListener);
                this.f66151j.a(downloadListener);
                this.f66150i.e(z);
                this.f66150i.a(this.f66151j.w());
                this.f66150i.a(new b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f66152a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66152a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (o.j(this.f66152a.f66143b) || this.f66152a.l) {
                                this.f66152a.f66150i.d(false);
                            }
                            this.f66152a.f66151j.e();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f66152a.f66148g == null) {
                            return;
                        }
                        this.f66152a.f66148g.A();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f66152a.f66148g == null) {
                            return;
                        }
                        this.f66152a.f66148g.o();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void d() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.f66152a.f66148g == null) {
                            return;
                        }
                        this.f66152a.f66148g.l();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public c e() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? this.f66152a.f66147f : (c) invokeV.objValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f66152a.f66148g == null) {
                            return;
                        }
                        this.f66152a.f66148g.a(i2);
                    }
                });
                this.f66151j.a(new a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f66153a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66153a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66153a.f66150i.w();
                        }
                    }
                });
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar != null) {
                bVar.a(this.f66145d, hashMap, this.f66147f.e(), eVar);
                this.f66149h.a(downloadListener);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            k.b("RewardFullWebViewManager", "tryLoadEndCard");
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f66150i;
            if (cVar != null) {
                cVar.v();
                this.f66151j.u();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f66149h;
            if (bVar != null) {
                bVar.v();
            }
        }
    }

    public void a(boolean z, int i2, String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(z, i2, str);
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f66151j.a(eVar);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? this.f66150i.a(i2) : invokeI.booleanValue;
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            this.f66147f.f();
            int i2 = this.m / 1000;
            if (i2 > 0) {
                this.f66147f.d(true);
                this.f66147f.f(false);
                this.f66147f.a(String.valueOf(i2), "");
                this.m = (int) (this.m - j2);
                this.f66148g.a(j2);
                return;
            }
            this.f66147f.d(false);
        }
    }
}
