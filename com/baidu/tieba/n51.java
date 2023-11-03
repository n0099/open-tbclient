package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.data.NadPageType;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.searchbox.playerserver.PlayerPolicyCfgManager;
import com.baidu.tieba.s51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class n51 extends e51 implements AbsNadBrowserView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public long b;
    public long c;
    public final t51 d;
    public boolean e;
    public long f;
    public final i51 g;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.f = "";
            this.g = "";
            this.h = "0";
            this.i = "-1";
            this.j = "-1";
            this.k = "-1";
            this.l = "-1";
            this.m = "";
            this.n = "";
            this.o = "";
            this.p = "-1";
            this.q = "-1";
            this.r = "";
            this.s = "0";
        }

        public final void A(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.a = str;
            }
        }

        public final void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.b = str;
            }
        }

        public final void C(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.q = str;
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.s = str;
            }
        }

        public final void E(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.f = str;
            }
        }

        public final void F(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.p = str;
            }
        }

        public final void G(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.d = str;
            }
        }

        public final void H(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.e = z;
            }
        }

        public final void I(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.o = str;
            }
        }

        public final void t(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.j = str;
            }
        }

        public final void u(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.i = str;
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.l = str;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.k = str;
            }
        }

        public final void x(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.r = str;
            }
        }

        public final void y(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.c = str;
            }
        }

        public final void z(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.h = str;
            }
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.j;
            }
            return (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.l;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.n;
            }
            return (String) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.k;
            }
            return (String) invokeV.objValue;
        }

        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.r;
            }
            return (String) invokeV.objValue;
        }

        public final String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.q;
            }
            return (String) invokeV.objValue;
        }

        public final String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.s;
            }
            return (String) invokeV.objValue;
        }

        public final String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.p;
            }
            return (String) invokeV.objValue;
        }

        public final String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public final String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public final String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.m;
            }
            return (String) invokeV.objValue;
        }

        public final String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.o;
            }
            return (String) invokeV.objValue;
        }

        public final boolean s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.e;
            }
            return invokeV.booleanValue;
        }
    }

    public n51(i51 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.g = container;
        this.a = new a();
        this.b = -1L;
        this.c = -1L;
        this.d = new t51();
    }

    @Override // com.baidu.tieba.e51
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.u(String.valueOf(System.currentTimeMillis()));
            this.d.f(System.currentTimeMillis());
            o();
            super.c();
        }
    }

    @Override // com.baidu.tieba.e51
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q();
            this.d.e();
            super.d();
        }
    }

    @Override // com.baidu.tieba.e51
    public void e(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            this.a.u(String.valueOf(System.currentTimeMillis()));
            this.d.f(System.currentTimeMillis());
            o();
            super.e(intent);
        }
    }

    @Override // com.baidu.tieba.e51
    public void g(AbsNadBrowserView webView, String str) {
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            this.b = System.currentTimeMillis();
            Object tag = webView.getTag(R.id.nad_webcontent_error_code);
            a aVar = this.a;
            if (tag == null) {
                obj = "0";
            } else {
                obj = tag.toString();
            }
            aVar.w(obj);
            super.g(webView, str);
        }
    }

    @Override // com.baidu.tieba.e51
    public void h(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f;
            if (j != 0 && currentTimeMillis - j > 1000) {
                this.a.D("1");
            }
            this.f = currentTimeMillis;
            super.h(webView, str, bitmap);
        }
    }

    @Override // com.baidu.tieba.e51
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.h(System.currentTimeMillis());
            long c = this.d.c() - this.d.d();
            if (c < 0) {
                c = 0;
            }
            t51 t51Var = this.d;
            t51Var.g(t51Var.b() + c);
            super.i();
            p();
        }
    }

    @Override // com.baidu.tieba.e51
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.i(System.currentTimeMillis());
            if (!this.e) {
                long d = this.d.d() - this.d.a();
                if (d < 0) {
                    d = 0;
                }
                this.d.g(d);
                this.e = true;
            }
            super.l();
        }
    }

    @Override // com.baidu.tieba.e51
    public void j(AbsNadBrowserView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048582, this, webView, i, str, str2) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            this.a.w(String.valueOf(i));
            super.j(webView, i, str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        String str;
        boolean z;
        String str2;
        String jSONObject;
        JSONObject jSONObject2;
        AbsNadBrowserView m;
        Object obj;
        AbsNadBrowserView m2;
        Object obj2;
        Object obj3;
        s51.f k;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a aVar = this.a;
            s51.d l = this.g.l();
            Long l2 = null;
            if (l == null || (str = l.h()) == null) {
                s51.d l3 = this.g.l();
                if (l3 != null) {
                    str = l3.l();
                } else {
                    str = null;
                }
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            aVar.B(str);
            a aVar2 = this.a;
            s51.d l4 = this.g.l();
            if (l4 != null && (k = l4.k()) != null && (b = k.b()) != null) {
                str3 = b;
            }
            aVar2.G(str3);
            a aVar3 = this.a;
            s51.d l5 = this.g.l();
            if (l5 != null) {
                z = l5.n();
            } else {
                z = false;
            }
            aVar3.H(z);
            AbsNadBrowserView m3 = this.g.m();
            if (m3 != null && m3.v()) {
                a aVar4 = this.a;
                AbsNadBrowserView m4 = this.g.m();
                if (m4 != null) {
                    l2 = Long.valueOf(m4.getPreRenderArrival());
                }
                aVar4.t(String.valueOf(l2));
                this.a.z("5");
                this.a.C("14");
            } else {
                this.a.t(String.valueOf(this.b));
            }
            this.a.v(String.valueOf((((float) ((System.currentTimeMillis() - this.d.c()) + this.d.b())) * 1.0f) / ((float) 1000)));
            a aVar5 = this.a;
            String str4 = "0";
            if (!kp0.a()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            aVar5.I(str2);
            a aVar6 = this.a;
            try {
                jSONObject2 = new JSONObject();
                jSONObject2.put("Nairobi", "1");
                m = this.g.m();
            } catch (JSONException e) {
                m61.d(e);
                jSONObject = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            }
            if (m != null && !m.w()) {
                obj = "0";
                jSONObject2.put("Sailor", obj);
                m2 = this.g.m();
                if (m2 != null && !m2.A()) {
                    obj2 = "0";
                    jSONObject2.put("Zeus", obj2);
                    if (this.g.c()) {
                        obj3 = "0";
                    } else {
                        obj3 = "1";
                    }
                    jSONObject2.put("ClickedCloseBtn", obj3);
                    if (this.g.h()) {
                        str4 = "1";
                    }
                    jSONObject2.put("KernelDowngrade", str4);
                    jSONObject2.put("FspTime", String.valueOf(this.c));
                    Unit unit = Unit.INSTANCE;
                    jSONObject = jSONObject2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …\n            }.toString()");
                    aVar6.x(jSONObject);
                }
                obj2 = "1";
                jSONObject2.put("Zeus", obj2);
                if (this.g.c()) {
                }
                jSONObject2.put("ClickedCloseBtn", obj3);
                if (this.g.h()) {
                }
                jSONObject2.put("KernelDowngrade", str4);
                jSONObject2.put("FspTime", String.valueOf(this.c));
                Unit unit2 = Unit.INSTANCE;
                jSONObject = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …\n            }.toString()");
                aVar6.x(jSONObject);
            }
            obj = "1";
            jSONObject2.put("Sailor", obj);
            m2 = this.g.m();
            if (m2 != null) {
                obj2 = "0";
                jSONObject2.put("Zeus", obj2);
                if (this.g.c()) {
                }
                jSONObject2.put("ClickedCloseBtn", obj3);
                if (this.g.h()) {
                }
                jSONObject2.put("KernelDowngrade", str4);
                jSONObject2.put("FspTime", String.valueOf(this.c));
                Unit unit22 = Unit.INSTANCE;
                jSONObject = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …\n            }.toString()");
                aVar6.x(jSONObject);
            }
            obj2 = "1";
            jSONObject2.put("Zeus", obj2);
            if (this.g.c()) {
            }
            jSONObject2.put("ClickedCloseBtn", obj3);
            if (this.g.h()) {
            }
            jSONObject2.put("KernelDowngrade", str4);
            jSONObject2.put("FspTime", String.valueOf(this.c));
            Unit unit222 = Unit.INSTANCE;
            jSONObject = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …\n            }.toString()");
            aVar6.x(jSONObject);
        }
    }

    public final void o() {
        Long l;
        s51.f k;
        s51.f k2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a aVar = this.a;
            s51.d l2 = this.g.l();
            aVar.A((l2 == null || (r1 = l2.g()) == null) ? "ad" : "ad");
            a aVar2 = this.a;
            s51.d l3 = this.g.l();
            String str = "";
            aVar2.y((l3 == null || (r1 = l3.f()) == null) ? "" : "");
            a aVar3 = this.a;
            s51.d l4 = this.g.l();
            if (l4 != null && (k2 = l4.k()) != null && (a2 = k2.a()) != null) {
                str = a2;
            }
            aVar3.E(str);
            a aVar4 = this.a;
            s51.d l5 = this.g.l();
            if (l5 != null && (k = l5.k()) != null) {
                l = Long.valueOf(k.d());
            } else {
                l = null;
            }
            aVar4.F(String.valueOf(l));
        }
    }

    public final void p() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n();
            if (TextUtils.isEmpty(this.a.g())) {
                m61.c(this.g.b(), "ext为空，性能日志发送失败");
            }
            hz0 g = new hz0().g("1029");
            Intrinsics.checkNotNullExpressionValue(g, "PlogBuilder().setCID(Plo…lder.C_ID_LP_PERFORMANCE)");
            g.b("f1", this.a.i());
            g.b("f2", this.a.j());
            g.b("f14", this.a.g());
            if (TextUtils.equals(this.a.i(), "xuzhang")) {
                g.b("f16", this.a.o());
                g.b("f17", this.a.m());
                g.b("f20", this.a.p());
                g.b("ef13", this.a.n());
            } else {
                if (this.a.s()) {
                    str = HlsPlaylistParser.TYPE_VIDEO;
                } else {
                    str = "H5";
                }
                g.b("f16", str);
            }
            g.b("ef1", this.a.h());
            g.b("ef2", this.a.b());
            g.b("ef3", this.a.a());
            g.b("ef4", this.a.e());
            g.b("ef5", this.a.c());
            g.b("ef9", this.a.q());
            g.b("ef10", this.a.d());
            g.b("ef12", this.a.r());
            g.b("ef14", this.a.k());
            g.b("ef15", this.a.f());
            g.b("ef17", this.a.l());
            az0.e(g);
        }
    }

    public final void q() {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            JSONObject jSONObject = new JSONObject();
            String i2 = this.a.i();
            if (Intrinsics.areEqual(i2, NadPageType.PAGE_NAD_FEED.getValue())) {
                str = PlayerPolicyCfgManager.GROUP_FEED_AD;
            } else if (Intrinsics.areEqual(i2, NadPageType.PAGE_NAD_SPLASH.getValue())) {
                str = "feed_launch_screen_ad";
            } else if (Intrinsics.areEqual(i2, NadPageType.PAGE_NAD_POP_WEB.getValue())) {
                str = "feed_pop_web";
            } else if (Intrinsics.areEqual(i2, NadPageType.PAGE_FENGCHAO.getValue())) {
                str = "fc_ad";
            } else {
                str = "";
            }
            try {
                jSONObject.put("page_type", str);
                if (TextUtils.equals(this.a.h(), "5")) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_prerender", i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_click_time", this.a.b());
                jSONObject2.put("ad_ext", this.a.g());
                jSONObject2.put("trigger", this.a.m());
                jSONObject2.put("ad_real_click_time", this.a.n());
                jSONObject.put("feed_ext_dict", jSONObject2);
            } catch (JSONException e) {
                m61.d(e);
            }
            AbsNadBrowserView m = this.g.m();
            if (m != null) {
                m.Q(jSONObject);
            }
        }
    }
}
