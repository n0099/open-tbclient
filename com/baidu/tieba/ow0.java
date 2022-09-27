package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.InternalSyncControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ow0 extends hw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv0 e;
    public boolean f;
    public yu0 g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements yu0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow0 a;

        public b(ow0 ow0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow0Var;
        }

        @Override // com.baidu.tieba.yu0
        public void a(ut0 ut0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ut0Var) == null) {
                this.a.U().a(ut0Var);
            }
        }

        @Override // com.baidu.tieba.yu0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public /* synthetic */ b(ow0 ow0Var, a aVar) {
            this(ow0Var);
        }
    }

    public ow0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = true;
        this.g = new b(this, null);
        this.e = my0.a().b(str);
        B();
    }

    @Override // com.baidu.tieba.hw0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B();
        }
    }

    public void K(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e.b(str);
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e.d() : invokeV.intValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e.e() : invokeV.intValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e.f() : invokeV.intValue;
    }

    @Nullable
    public su0 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (su0) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e.g() : invokeV.intValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e.h() : invokeV.intValue;
    }

    public PlayerStatus R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e.i() : (PlayerStatus) invokeV.objValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e.j() : invokeV.intValue;
    }

    public uv0 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (uv0) invokeV.objValue;
    }

    public oy0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e.k() : (oy0) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e.l() : (String) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e.m() : invokeV.intValue;
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.e.o(z);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.u();
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.e.v();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (this.e instanceof zv0)) {
            return;
        }
        j0(null);
        uv0 uv0Var = this.e;
        this.e = new zv0();
        my0.a().c(uv0Var);
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || u().X()) {
            return;
        }
        u().k0();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.e.y();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void d(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ut0Var) == null) {
            String c2 = ut0Var.c();
            switch (c2.hashCode()) {
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -525235558:
                    if (c2.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -461848373:
                    if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1370689931:
                    if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                this.e.q();
            } else if (c == 1) {
                this.e.t();
            } else if (c == 2) {
                this.e.r();
            } else if (c != 3) {
                if (c == 4 && (ut0Var.f(3) instanceof px0)) {
                    px0 px0Var = (px0) ut0Var.f(3);
                    qx0 K = u().K();
                    String str = px0Var.a;
                    K.b = str;
                    r0(str, px0Var.c);
                }
            } else {
                this.e.s(ut0Var.g(1), ut0Var.g(2), ut0Var.f(3));
            }
        }
    }

    public void d0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            int e = this.e.e();
            if (e > 1 && i > (i2 = e - 1)) {
                i = i2;
            }
            this.e.z(i * 1000);
        }
    }

    public void e0(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            int f = this.e.f();
            if (f > 1 && i > (i3 = f - 1)) {
                i = i3;
            }
            this.e.A(i, i2);
        }
    }

    public void f0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bool) == null) {
            this.f = bool.booleanValue();
        }
    }

    public void g0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.e.B(str);
        }
    }

    @Override // com.baidu.tieba.uw0
    @Nullable
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.e.c() : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new int[]{4, 3, 1, 2} : (int[]) invokeV.objValue;
    }

    public void h0(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, obj) == null) {
            this.e.D(str, obj);
        }
    }

    public void i0(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, hashMap) == null) {
            this.e.E(hashMap);
        }
    }

    @Override // com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void j(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, ut0Var) == null) && InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(ut0Var.c())) {
            this.e.r();
        }
    }

    public void j0(@Nullable cw0 cw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, cw0Var) == null) {
            this.e.F(cw0Var);
        }
    }

    @Override // com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void k(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ut0Var) == null) {
            String c2 = ut0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == -150198673) {
                if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != -103262037) {
                if (hashCode == 1939755256 && c2.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (c2.equals(LayerEvent.ACTION_SEEK)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                u().l();
            } else if (c == 1) {
                d0(ut0Var.g(1));
                b0();
                this.e.y();
            } else if (c != 2) {
            } else {
                int g = ut0Var.g(19);
                Object f = ut0Var.f(31);
                if (f instanceof px0) {
                    String str = ((px0) f).a;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    K(str);
                    d0(g);
                }
            }
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.e.G(z);
        }
    }

    public void l0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            this.e.H(str, str2);
        }
    }

    public void m0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.e.I(str);
        }
    }

    @Override // com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void n(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, ut0Var) == null) && this.f && SystemEvent.ACTION_VOLUME_CHANGED.equals(ut0Var.c())) {
            X(ut0Var.g(5) <= 0);
        }
    }

    public void n0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.e.J(str);
        }
    }

    public void o0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f) == null) {
            this.e.L(f);
        }
    }

    public void p0(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, str, hashMap) == null) {
            this.e.N(str, hashMap);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void q(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, ut0Var) == null) {
            String c2 = ut0Var.c();
            switch (c2.hashCode()) {
                case -1929694922:
                    if (c2.equals(InternalSyncControlEvent.INTERNAL_ACTION_RESUME)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1106918114:
                    if (c2.equals(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1076076346:
                    if (c2.equals(ControlEvent.ACTION_SEEK_MS)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -502522037:
                    if (c2.equals(InternalSyncControlEvent.INTERNAL_ACTION_STOP)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 745698331:
                    if (c2.equals(InternalSyncControlEvent.INTERNAL_ACTION_START)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1547340063:
                    if (c2.equals(ControlEvent.ACTION_SEEK)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1598355405:
                    if (c2.equals(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    e0(ut0Var.g(5) * 1000, ut0Var.h(12, 3));
                    return;
                case 1:
                    e0(ut0Var.g(5), ut0Var.h(12, 3));
                    return;
                case 2:
                    Z();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    s0();
                    return;
                case 4:
                    Y();
                    return;
                case 5:
                    c0();
                    return;
                case 6:
                    t0();
                    return;
                default:
                    return;
            }
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.e.O(i);
        }
    }

    @Override // com.baidu.tieba.hw0
    public void r(@NonNull bx0 bx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bx0Var) == null) {
            super.r(bx0Var);
            bx0Var.b(this.g);
            this.e.a(bx0Var);
        }
    }

    public void r0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048618, this, str, z) == null) {
            this.e.P(str, z);
        }
    }

    @Override // com.baidu.tieba.hw0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (y() != null) {
                y().f(this.g);
            }
            super.s();
            this.e.T();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.e.Q();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.e.R();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.e.S();
        }
    }

    public void v0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.e.U(str);
        }
    }
}
