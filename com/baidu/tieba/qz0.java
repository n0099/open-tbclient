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
/* loaded from: classes7.dex */
public class qz0 extends jz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wy0 e;
    public boolean f;
    public ay0 g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Nullable
    public ux0 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ux0) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements ay0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz0 a;

        @Override // com.baidu.tieba.ay0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public b(qz0 qz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz0Var;
        }

        @Override // com.baidu.tieba.ay0
        public void a(ww0 ww0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww0Var) == null) {
                this.a.W().a(ww0Var);
            }
        }

        public /* synthetic */ b(qz0 qz0Var, a aVar) {
            this(qz0Var);
        }
    }

    public qz0(@NonNull String str) {
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
        this.e = o11.a().b(str);
        D();
    }

    @Override // com.baidu.tieba.jz0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.D();
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.d();
        }
        return invokeV.intValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.e();
        }
        return invokeV.intValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.f();
        }
        return invokeV.intValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.g();
        }
        return invokeV.intValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e.h();
        }
        return invokeV.intValue;
    }

    public PlayerStatus S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e.i();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e.j();
        }
        return invokeV.intValue;
    }

    public wy0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (wy0) invokeV.objValue;
    }

    public q11 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e.k();
        }
        return (q11) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e.l();
        }
        return (String) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e.m();
        }
        return invokeV.intValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.u();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.e.v();
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (this.e instanceof bz0)) {
            return;
        }
        l0(null);
        wy0 wy0Var = this.e;
        this.e = new bz0();
        o11.a().c(wy0Var);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && !u().X()) {
            u().k0();
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.e.y();
        }
    }

    @Override // com.baidu.tieba.wz0
    @Nullable
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.e.c();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return new int[]{4, 3, 1, 2};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jz0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (A() != null) {
                A().f(this.g);
            }
            super.s();
            this.e.T();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.e.Q();
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.e.R();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.e.S();
        }
    }

    public void L(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e.b(str);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.e.o(z);
        }
    }

    public void f0(int i) {
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

    public void h0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bool) == null) {
            this.f = bool.booleanValue();
        }
    }

    public void i0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.e.B(str);
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void j(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, ww0Var) == null) && InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(ww0Var.c())) {
            this.e.r();
        }
    }

    public void k0(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, hashMap) == null) {
            this.e.E(hashMap);
        }
    }

    public void l0(@Nullable ez0 ez0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ez0Var) == null) {
            this.e.F(ez0Var);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.e.G(z);
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void n(@NonNull ww0 ww0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, ww0Var) == null) && this.f && SystemEvent.ACTION_VOLUME_CHANGED.equals(ww0Var.c())) {
            if (ww0Var.g(5) <= 0) {
                z = true;
            } else {
                z = false;
            }
            Z(z);
        }
    }

    public void o0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.e.I(str);
        }
    }

    public void p0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.e.J(str);
        }
    }

    public void q0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f) == null) {
            this.e.L(f);
        }
    }

    @Override // com.baidu.tieba.jz0
    public void r(@NonNull d01 d01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, d01Var) == null) {
            super.r(d01Var);
            d01Var.b(this.g);
            this.e.a(d01Var);
        }
    }

    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.e.O(i);
        }
    }

    public void x0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.e.U(str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void d(@NonNull ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ww0Var) == null) {
            String c2 = ww0Var.c();
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c == 4 && (ww0Var.f(3) instanceof r01)) {
                                r01 r01Var = (r01) ww0Var.f(3);
                                s01 K = u().K();
                                String str = r01Var.a;
                                K.b = str;
                                t0(str, r01Var.c);
                                return;
                            }
                            return;
                        }
                        this.e.s(ww0Var.g(1), ww0Var.g(2), ww0Var.f(3));
                        return;
                    }
                    this.e.r();
                    return;
                }
                this.e.t();
                return;
            }
            this.e.q();
        }
    }

    public void g0(int i, int i2) {
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

    public void j0(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, obj) == null) {
            this.e.D(str, obj);
        }
    }

    public void n0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            this.e.H(str, str2);
        }
    }

    public void r0(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, hashMap) == null) {
            this.e.N(str, hashMap);
        }
    }

    public void t0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048619, this, str, z) == null) {
            this.e.P(str, z);
        }
    }

    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void k(@NonNull ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, ww0Var) == null) {
            String c2 = ww0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -150198673) {
                if (hashCode != -103262037) {
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
            } else {
                if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        int g = ww0Var.g(19);
                        Object f = ww0Var.f(31);
                        if (f instanceof r01) {
                            String str = ((r01) f).a;
                            if (!TextUtils.isEmpty(str)) {
                                L(str);
                                f0(g);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                f0(ww0Var.g(1));
                d0();
                this.e.y();
                return;
            }
            u().l();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.jz0, com.baidu.tieba.xx0
    public void q(@NonNull ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, ww0Var) == null) {
            String c2 = ww0Var.c();
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
                    g0(ww0Var.g(5) * 1000, ww0Var.h(12, 3));
                    return;
                case 1:
                    g0(ww0Var.g(5), ww0Var.h(12, 3));
                    return;
                case 2:
                    b0();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    u0();
                    return;
                case 4:
                    a0();
                    return;
                case 5:
                    e0();
                    return;
                case 6:
                    v0();
                    return;
                default:
                    return;
            }
        }
    }
}
