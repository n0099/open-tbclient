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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f29433a;

    /* renamed from: b  reason: collision with root package name */
    public m f29434b;

    /* renamed from: c  reason: collision with root package name */
    public String f29435c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29436d;

    /* renamed from: e  reason: collision with root package name */
    public String f29437e;

    /* renamed from: f  reason: collision with root package name */
    public c f29438f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.video.b.b f29439g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.a.b f29440h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.a.c f29441i;
    public com.bytedance.sdk.openadsdk.component.reward.a.d j;
    public com.bytedance.sdk.openadsdk.component.reward.a.a k;
    public boolean l;
    public int m;
    public boolean n;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
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
        this.f29433a = activity;
        this.f29439g = (com.bytedance.sdk.openadsdk.core.video.b.b) activity;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29441i.C();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29441i.z();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || o.j(this.f29434b)) {
            return;
        }
        int b2 = b(com.bytedance.sdk.openadsdk.r.o.d(this.f29434b.ao()));
        if (b2 == -1) {
            this.f29439g.a(0);
        } else if (b2 >= 0) {
            this.f29439g.a(b2);
            this.m = b2;
            a(0L);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l = true;
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                if (!cVar.u()) {
                    u();
                } else {
                    this.f29441i.d(false);
                }
            }
            if (this.f29440h != null) {
                this.k = this.f29441i;
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.j;
            if (dVar != null) {
                dVar.x();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                cVar.e();
                this.f29441i.b(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar != null) {
                this.k = bVar;
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k instanceof com.bytedance.sdk.openadsdk.component.reward.a.c : invokeV.booleanValue;
    }

    public void G() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (mVar = this.f29434b) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.k.a.c g2 = com.bytedance.sdk.openadsdk.k.a.c.b().a(this.f29436d ? 7 : 8).c(String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()))).g(com.bytedance.sdk.openadsdk.r.o.h(this.f29434b.ao()));
        g2.b(g()).h(h());
        g2.i(this.f29434b.ao()).d(this.f29434b.ak());
        com.bytedance.sdk.openadsdk.k.a.a().l(g2);
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar == null) {
                return false;
            }
            return bVar.t();
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a(1000L);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            return aVar != null ? aVar.i() : "";
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.o();
    }

    public void j() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.p();
    }

    public void k() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.q();
    }

    public void l() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.r();
    }

    public void m() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.s();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            C();
            this.f29438f.d(false);
            this.f29438f.a(0.0f);
            this.f29438f.a(this.f29434b.aM());
            if (this.k instanceof com.bytedance.sdk.openadsdk.component.reward.a.b) {
                this.f29438f.c(false);
            } else {
                this.f29438f.c(true);
            }
            this.k.d();
            this.k.d(true);
        }
    }

    public void o() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.e();
    }

    public void p() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.f();
    }

    public boolean q() {
        InterceptResult invokeV;
        boolean s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            m mVar = this.f29434b;
            if (mVar != null && mVar.V() != null && this.f29434b.V().a() == 1) {
                j.b("RewardFullWebViewManager", "can show end card follow js");
                s = r();
            } else {
                j.b("RewardFullWebViewManager", "can show end card follow js WebViewClient");
                s = s();
            }
            return s || o.a(this.f29434b);
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.k != null) {
                return this.f29441i.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.k == null) {
            return;
        }
        this.j.v();
        this.f29441i.e();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.k == null) {
            return;
        }
        this.f29441i.x();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f29441i.y();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar != null) {
                bVar.g();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                cVar.g();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.j;
            if (dVar != null) {
                dVar.g();
            }
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f29441i.A() : invokeV.longValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f29441i.B();
        }
    }

    public void a(c cVar, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{cVar, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2}) == null) || this.n) {
            return;
        }
        this.n = true;
        this.f29434b = mVar;
        this.f29436d = z;
        this.f29435c = str;
        this.f29438f = cVar;
        this.f29437e = str2;
        a(i2, i3, i4, f2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                aVar.j();
            }
            int i2 = this.m;
            if (i2 >= 0) {
                this.f29439g.a(i2);
                a(0L);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.k;
            if (aVar != null) {
                aVar.k();
            }
            if (this.m >= 0) {
                this.f29439g.m();
            }
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.l();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar != null) {
                bVar.m();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                cVar.m();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.j;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public void f() {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (aVar = this.k) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            if (o.a(this.f29434b)) {
                this.f29441i = new com.bytedance.sdk.openadsdk.component.reward.a.c(this.f29433a, this.f29434b, this.f29435c, i2, i3, i4, f2, this.f29436d, this.f29437e);
                this.j = new com.bytedance.sdk.openadsdk.component.reward.a.d(this.f29433a, this.f29434b, this.f29435c, i2, i3, i4, f2, this.f29436d, this.f29437e);
                if (this.f29434b.V() != null && !TextUtils.isEmpty(this.f29434b.V().j()) && o.b(this.f29434b)) {
                    this.f29440h = new com.bytedance.sdk.openadsdk.component.reward.a.b(this.f29433a, this.f29434b, this.f29435c, i2, i3, i4, f2, this.f29436d, this.f29437e);
                }
            } else {
                this.f29440h = new com.bytedance.sdk.openadsdk.component.reward.a.b(this.f29433a, this.f29434b, this.f29435c, i2, i3, i4, f2, this.f29436d, this.f29437e);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.a aVar = this.f29441i;
            if (aVar == null) {
                aVar = this.f29440h;
            }
            this.k = aVar;
        }
    }

    public void a(long j, long j2, int i2) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(j, j2, i2);
    }

    public void a(int i2, int i3) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(i2, i3);
    }

    public void a(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.b(z);
    }

    public void a(boolean z, com.bytedance.sdk.openadsdk.j.e eVar, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), eVar, downloadListener}) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f29437e)) {
                hashMap.put("rit_scene", this.f29437e);
            }
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                cVar.a(this.f29436d, hashMap, this.f29438f.e(), eVar);
                this.j.a(this.f29436d, null, null, null);
                this.f29441i.a(downloadListener);
                this.j.a(downloadListener);
                this.f29441i.e(z);
                this.f29441i.a(this.j.w());
                this.f29441i.a(new b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f29442a;

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
                        this.f29442a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (o.j(this.f29442a.f29434b) || this.f29442a.l) {
                                this.f29442a.f29441i.d(false);
                            }
                            this.f29442a.j.e();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f29442a.f29439g == null) {
                            return;
                        }
                        this.f29442a.f29439g.A();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f29442a.f29439g == null) {
                            return;
                        }
                        this.f29442a.f29439g.o();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void d() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.f29442a.f29439g == null) {
                            return;
                        }
                        this.f29442a.f29439g.l();
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public c e() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? this.f29442a.f29438f : (c) invokeV.objValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.b
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f29442a.f29439g == null) {
                            return;
                        }
                        this.f29442a.f29439g.a(i2);
                    }
                });
                this.j.a(new a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.b.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f29443a;

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
                        this.f29443a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.b.e.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f29443a.f29441i.w();
                        }
                    }
                });
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar != null) {
                bVar.a(this.f29436d, hashMap, this.f29438f.e(), eVar);
                this.f29440h.a(downloadListener);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            j.b("RewardFullWebViewManager", "tryLoadEndCard");
            com.bytedance.sdk.openadsdk.component.reward.a.c cVar = this.f29441i;
            if (cVar != null) {
                cVar.v();
                this.j.u();
            }
            com.bytedance.sdk.openadsdk.component.reward.a.b bVar = this.f29440h;
            if (bVar != null) {
                bVar.v();
            }
        }
    }

    public void a(boolean z, int i2, String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.a(z, i2, str);
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.j.a(eVar);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f29441i.a(i2) : invokeI.booleanValue;
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            this.f29438f.f();
            int i2 = this.m / 1000;
            if (i2 > 0) {
                this.f29438f.d(true);
                this.f29438f.f(false);
                this.f29438f.a(String.valueOf(i2), "");
                this.m = (int) (this.m - j);
                this.f29439g.a(j);
                return;
            }
            this.f29438f.d(false);
        }
    }
}
