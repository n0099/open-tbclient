package com.baidu.tieba;

import android.app.Application;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer;
import com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher;
import com.baidu.tieba.bv1;
import com.baidu.tieba.ew1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.gx1;
import com.baidu.tieba.mw1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes6.dex */
public final class ku2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static tu1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new rw3();
        }
        return (tu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static dx1 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new mu1();
        }
        return (dx1) invokeV.objValue;
    }

    @Inject
    public static pf2 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new zw3();
        }
        return (pf2) invokeV.objValue;
    }

    @Inject(force = false)
    public static oi2 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new gj2();
        }
        return (oi2) invokeV.objValue;
    }

    @Inject(force = false)
    public static xv1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return ix3.a();
        }
        return (xv1) invokeV.objValue;
    }

    @Inject
    public static jv2 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new ps4();
        }
        return (jv2) invokeV.objValue;
    }

    @Inject
    public static yv1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new fs4();
        }
        return (yv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static vw1 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new iu1();
        }
        return (vw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static uu1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new zs1();
        }
        return (uu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ww1 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new ow3();
        }
        return (ww1) invokeV.objValue;
    }

    @Inject(force = false)
    public static vu1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return i96.a();
        }
        return (vu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ex1 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new sx1();
        }
        return (ex1) invokeV.objValue;
    }

    @Inject(force = false)
    public static zv1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return new ex3();
        }
        return (zv1) invokeV.objValue;
    }

    @Inject
    public static kv2 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return ca6.a();
        }
        return (kv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static aw1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return w86.a();
        }
        return (aw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static l33 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return l33.a;
        }
        return (l33) invokeV.objValue;
    }

    @Inject
    public static dv2 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return jf4.a();
        }
        return (dv2) invokeV.objValue;
    }

    @Inject
    public static ev2 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return of4.a();
        }
        return (ev2) invokeV.objValue;
    }

    @Inject(force = false)
    public static fh4 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return nw3.a();
        }
        return (fh4) invokeV.objValue;
    }

    @Inject(force = false)
    public static ew1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return new ew1.a();
        }
        return (ew1) invokeV.objValue;
    }

    @Inject(force = false)
    public static nu1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return v96.a();
        }
        return (nu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static fw1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return new fw1.a();
        }
        return (fw1) invokeV.objValue;
    }

    @Inject
    public static gw1 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return sx3.a();
        }
        return (gw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static xu1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return new at1();
        }
        return (xu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static hw1 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return new ax3();
        }
        return (hw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static iw1 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return new xt1();
        }
        return (iw1) invokeV.objValue;
    }

    @Inject
    public static fv2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return b96.a();
        }
        return (fv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static gv2 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return z96.a();
        }
        return (gv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static jw1 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return new zt1();
        }
        return (jw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static kw1 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return f96.a();
        }
        return (kw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static lw1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return new au1();
        }
        return (lw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static cv1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return new et1();
        }
        return (cv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static mw1 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return new mw1.a();
        }
        return (mw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ax1 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return new ku1();
        }
        return (ax1) invokeV.objValue;
    }

    @Inject(force = false)
    public static zw1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return new ju1();
        }
        return (zw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ow1 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return new bu1();
        }
        return (ow1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ISwanApkFetcher b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return new ISwanApkFetcher.b();
        }
        return (ISwanApkFetcher) invokeV.objValue;
    }

    @Inject
    public static hv2 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return s86.a();
        }
        return (hv2) invokeV.objValue;
    }

    public static Application c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return AppRuntime.getApplication();
        }
        return (Application) invokeV.objValue;
    }

    @Inject(force = false)
    public static rw1 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return new eu1();
        }
        return (rw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static bv1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return new bv1.b();
        }
        return (bv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static yu1 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return new bt1();
        }
        return (yu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qu1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return new bu3();
        }
        return (qu1) invokeV.objValue;
    }

    @Inject(force = false)
    public static tw1 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return new fu1();
        }
        return (tw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static fv1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return DefaultSwanAppBgMusicPlayer.j();
        }
        return (fv1) invokeV.objValue;
    }

    @Inject
    public static iv2 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            return s96.a();
        }
        return (iv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static gv1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return new ys1();
        }
        return (gv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static zu1 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return new xx3();
        }
        return (zu1) invokeV.objValue;
    }

    @Inject
    public static fn3 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            return jy3.a();
        }
        return (fn3) invokeV.objValue;
    }

    @Inject(force = false)
    public static av1 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return bs3.a();
        }
        return (av1) invokeV.objValue;
    }

    @Inject(force = false)
    public static hv1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return lw3.a();
        }
        return (hv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ev1 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            return new eg3();
        }
        return (ev1) invokeV.objValue;
    }

    @Inject(force = false)
    public static iv1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return new ft1();
        }
        return (iv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static jv1 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return js3.a();
        }
        return (jv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static kv1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            return new gt1();
        }
        return (kv1) invokeV.objValue;
    }

    @Inject
    public static av2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            return yt3.a();
        }
        return (av2) invokeV.objValue;
    }

    @Inject(force = false)
    public static lv1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            return new ht1();
        }
        return (lv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static sv1 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            return new nt1();
        }
        return (sv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static mv1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            return new it1();
        }
        return (mv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static wv1 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) {
            return new rt1();
        }
        return (wv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static pw1 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            return new cu1();
        }
        return (pw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static cv2 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            return new st1();
        }
        return (cv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static nv1 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            return u86.a();
        }
        return (nv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static bw1 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            return new tt1();
        }
        return (bw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ru1 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            return ly3.a();
        }
        return (ru1) invokeV.objValue;
    }

    @Inject(force = false)
    public static cw1 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            return new ut1();
        }
        return (cw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ov1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            return new qs3();
        }
        return (ov1) invokeV.objValue;
    }

    @Inject(force = false)
    public static dw1 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            return new wt1();
        }
        return (dw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static pv1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            return new kt1();
        }
        return (pv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static nl4 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            return qw3.a();
        }
        return (nl4) invokeV.objValue;
    }

    @Inject(force = false)
    public static bv2 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            return xw3.a();
        }
        return (bv2) invokeV.objValue;
    }

    @Inject(force = false)
    public static nw1 s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            return ot3.a();
        }
        return (nw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qv1 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            return new lt1();
        }
        return (qv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qw1 t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            return new du1();
        }
        return (qw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static rv1 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            return new mt1();
        }
        return (rv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static xw1 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            return new yt1();
        }
        return (xw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static gx1 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            return new gx1.b();
        }
        return (gx1) invokeV.objValue;
    }

    @Inject(force = false)
    public static yw1 v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            return n34.a();
        }
        return (yw1) invokeV.objValue;
    }

    @Inject(force = false)
    public static su1 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            return new xs1();
        }
        return (su1) invokeV.objValue;
    }

    @Inject(force = false)
    public static bx1 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            return new zx3();
        }
        return (bx1) invokeV.objValue;
    }

    @Inject(force = false)
    public static tv1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            return new ot1();
        }
        return (tv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static cx1 x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            return new lu1();
        }
        return (cx1) invokeV.objValue;
    }

    @Inject(force = false)
    public static uv1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) {
            return new pt1();
        }
        return (uv1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ou1 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            return new gu1();
        }
        return (ou1) invokeV.objValue;
    }

    @Inject(force = false)
    public static vv1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            return new qt1();
        }
        return (vv1) invokeV.objValue;
    }

    @Inject(force = false)
    @Deprecated
    public static uw1 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            return new hu1();
        }
        return (uw1) invokeV.objValue;
    }
}
