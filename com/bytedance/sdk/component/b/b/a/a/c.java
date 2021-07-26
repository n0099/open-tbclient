package com.bytedance.sdk.component.b.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final z f28247a;

    /* renamed from: b  reason: collision with root package name */
    public final ab f28248b;

    public c(z zVar, ab abVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar, abVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28247a = zVar;
        this.f28248b = abVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r4.k().d() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(ab abVar, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, abVar, zVar)) == null) {
            int c2 = abVar.c();
            if (c2 != 200 && c2 != 410 && c2 != 414 && c2 != 501 && c2 != 203 && c2 != 204) {
                if (c2 != 307) {
                    if (c2 != 308 && c2 != 404 && c2 != 405) {
                        switch (c2) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (abVar.a("Expires") == null) {
                    if (abVar.k().c() == -1) {
                        if (!abVar.k().e()) {
                        }
                    }
                }
            }
            return (abVar.k().b() || zVar.g().b()) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f28249a;

        /* renamed from: b  reason: collision with root package name */
        public final z f28250b;

        /* renamed from: c  reason: collision with root package name */
        public final ab f28251c;

        /* renamed from: d  reason: collision with root package name */
        public Date f28252d;

        /* renamed from: e  reason: collision with root package name */
        public String f28253e;

        /* renamed from: f  reason: collision with root package name */
        public Date f28254f;

        /* renamed from: g  reason: collision with root package name */
        public String f28255g;

        /* renamed from: h  reason: collision with root package name */
        public Date f28256h;

        /* renamed from: i  reason: collision with root package name */
        public long f28257i;
        public long j;
        public String k;
        public int l;

        public a(long j, z zVar, ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), zVar, abVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = -1;
            this.f28249a = j;
            this.f28250b = zVar;
            this.f28251c = abVar;
            if (abVar != null) {
                this.f28257i = abVar.l();
                this.j = abVar.m();
                s g2 = abVar.g();
                int a2 = g2.a();
                for (int i4 = 0; i4 < a2; i4++) {
                    String a3 = g2.a(i4);
                    String b2 = g2.b(i4);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.f28252d = com.bytedance.sdk.component.b.b.a.c.d.a(b2);
                        this.f28253e = b2;
                    } else if ("Expires".equalsIgnoreCase(a3)) {
                        this.f28256h = com.bytedance.sdk.component.b.b.a.c.d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                        this.f28254f = com.bytedance.sdk.component.b.b.a.c.d.a(b2);
                        this.f28255g = b2;
                    } else if ("ETag".equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.component.b.b.a.c.e.b(b2, -1);
                    }
                }
            }
        }

        private c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.f28251c == null) {
                    return new c(this.f28250b, null);
                }
                if (this.f28250b.h() && this.f28251c.f() == null) {
                    return new c(this.f28250b, null);
                }
                if (!c.a(this.f28251c, this.f28250b)) {
                    return new c(this.f28250b, null);
                }
                com.bytedance.sdk.component.b.b.d g2 = this.f28250b.g();
                if (!g2.a() && !a(this.f28250b)) {
                    com.bytedance.sdk.component.b.b.d k = this.f28251c.k();
                    if (k.j()) {
                        return new c(null, this.f28251c);
                    }
                    long d2 = d();
                    long c2 = c();
                    if (g2.c() != -1) {
                        c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(g2.c()));
                    }
                    long j = 0;
                    long millis = g2.h() != -1 ? TimeUnit.SECONDS.toMillis(g2.h()) : 0L;
                    if (!k.f() && g2.g() != -1) {
                        j = TimeUnit.SECONDS.toMillis(g2.g());
                    }
                    if (!k.a()) {
                        long j2 = millis + d2;
                        if (j2 < j + c2) {
                            ab.a i2 = this.f28251c.i();
                            if (j2 >= c2) {
                                i2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (d2 > 86400000 && e()) {
                                i2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new c(null, i2.a());
                        }
                    }
                    String str = this.k;
                    String str2 = "If-Modified-Since";
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else if (this.f28254f != null) {
                        str = this.f28255g;
                    } else if (this.f28252d != null) {
                        str = this.f28253e;
                    } else {
                        return new c(this.f28250b, null);
                    }
                    s.a c3 = this.f28250b.c().c();
                    com.bytedance.sdk.component.b.b.a.a.f28240a.a(c3, str2, str);
                    return new c(this.f28250b.f().a(c3.a()).d(), this.f28251c);
                }
                return new c(this.f28250b, null);
            }
            return (c) invokeV.objValue;
        }

        private long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                com.bytedance.sdk.component.b.b.d k = this.f28251c.k();
                if (k.c() != -1) {
                    return TimeUnit.SECONDS.toMillis(k.c());
                }
                if (this.f28256h != null) {
                    Date date = this.f28252d;
                    long time = this.f28256h.getTime() - (date != null ? date.getTime() : this.j);
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.f28254f == null || this.f28251c.a().a().l() != null) {
                    return 0L;
                } else {
                    Date date2 = this.f28252d;
                    long time2 = (date2 != null ? date2.getTime() : this.f28257i) - this.f28254f.getTime();
                    if (time2 > 0) {
                        return time2 / 10;
                    }
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        private long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                Date date = this.f28252d;
                long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
                int i2 = this.l;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j = this.j;
                return max + (j - this.f28257i) + (this.f28249a - j);
            }
            return invokeV.longValue;
        }

        private boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.f28251c.k().c() == -1 && this.f28256h == null : invokeV.booleanValue;
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c b2 = b();
                return (b2.f28247a == null || !this.f28250b.g().i()) ? b2 : new c(null, null);
            }
            return (c) invokeV.objValue;
        }

        public static boolean a(z zVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zVar)) == null) ? (zVar.a("If-Modified-Since") == null && zVar.a("If-None-Match") == null) ? false : true : invokeL.booleanValue;
        }
    }
}
