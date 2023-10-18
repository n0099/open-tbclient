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
public class lu0 extends eu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rt0 e;
    public boolean f;
    public vs0 g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Nullable
    public ps0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ps0) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements vs0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lu0 a;

        @Override // com.baidu.tieba.vs0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        public b(lu0 lu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lu0Var;
        }

        @Override // com.baidu.tieba.vs0
        public void a(sr0 sr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sr0Var) == null) {
                this.a.V().a(sr0Var);
            }
        }

        public /* synthetic */ b(lu0 lu0Var, a aVar) {
            this(lu0Var);
        }
    }

    public lu0(@NonNull String str) {
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
        this.e = ew0.a().b(str);
        E();
    }

    @Override // com.baidu.tieba.eu0
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.E();
        }
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.d();
        }
        return invokeV.intValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.e();
        }
        return invokeV.intValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.f();
        }
        return invokeV.intValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.g();
        }
        return invokeV.intValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e.h();
        }
        return invokeV.intValue;
    }

    public PlayerStatus T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e.i();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public rt0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (rt0) invokeV.objValue;
    }

    public gw0 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e.j();
        }
        return (gw0) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e.k();
        }
        return (String) invokeV.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.s();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e.t();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (this.e instanceof wt0)) {
            return;
        }
        k0(null);
        rt0 rt0Var = this.e;
        this.e = new wt0();
        ew0.a().c(rt0Var);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !x().V()) {
            x().i0();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.w();
        }
    }

    @Override // com.baidu.tieba.ru0
    @Nullable
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.e.c();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new int[]{4, 3, 1, 2};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eu0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (B() != null) {
                B().f(this.g);
            }
            super.s();
            this.e.R();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.e.O();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.e.P();
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.e.Q();
        }
    }

    public void M(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e.b(str);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.e.m(z);
        }
    }

    public void e0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            int e = this.e.e();
            if (e > 1 && i > (i2 = e - 1)) {
                i = i2;
            }
            this.e.x(i * 1000);
        }
    }

    public void g0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bool) == null) {
            this.f = bool.booleanValue();
        }
    }

    public void h0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.e.z(str);
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void j(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, sr0Var) == null) && InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(sr0Var.c())) {
            this.e.p();
        }
    }

    public void j0(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, hashMap) == null) {
            this.e.C(hashMap);
        }
    }

    public void k0(@Nullable zt0 zt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, zt0Var) == null) {
            this.e.D(zt0Var);
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.e.E(z);
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void n(@NonNull sr0 sr0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, sr0Var) == null) && this.f && SystemEvent.ACTION_VOLUME_CHANGED.equals(sr0Var.c())) {
            if (sr0Var.g(5) <= 0) {
                z = true;
            } else {
                z = false;
            }
            Y(z);
        }
    }

    public void n0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.e.G(str);
        }
    }

    public void o0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.e.H(str);
        }
    }

    public void p0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048611, this, f) == null) {
            this.e.J(f);
        }
    }

    @Override // com.baidu.tieba.eu0
    public void r(@NonNull yu0 yu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yu0Var) == null) {
            super.r(yu0Var);
            yu0Var.b(this.g);
            this.e.a(yu0Var);
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.e.M(i);
        }
    }

    public void w0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.e.S(str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void d(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sr0Var) == null) {
            String c2 = sr0Var.c();
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
                            if (c == 4 && (sr0Var.f(3) instanceof iv0)) {
                                iv0 iv0Var = (iv0) sr0Var.f(3);
                                jv0 K = x().K();
                                String str = iv0Var.a;
                                K.b = str;
                                s0(str, iv0Var.c);
                                return;
                            }
                            return;
                        }
                        this.e.q(sr0Var.g(1), sr0Var.g(2), sr0Var.f(3));
                        return;
                    }
                    this.e.p();
                    return;
                }
                this.e.r();
                return;
            }
            this.e.o();
        }
    }

    public void f0(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            int f = this.e.f();
            if (f > 1 && i > (i3 = f - 1)) {
                i = i3;
            }
            this.e.y(i, i2);
        }
    }

    public void i0(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, obj) == null) {
            this.e.B(str, obj);
        }
    }

    public void m0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            this.e.F(str, str2);
        }
    }

    public void q0(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, hashMap) == null) {
            this.e.L(str, hashMap);
        }
    }

    public void s0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, str, z) == null) {
            this.e.N(str, z);
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void k(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, sr0Var) == null) {
            String c2 = sr0Var.c();
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
                        int g = sr0Var.g(19);
                        Object f = sr0Var.f(31);
                        if (f instanceof iv0) {
                            String str = ((iv0) f).a;
                            if (!TextUtils.isEmpty(str)) {
                                M(str);
                                e0(g);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                e0(sr0Var.g(1));
                c0();
                this.e.w();
                return;
            }
            x().l();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void q(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sr0Var) == null) {
            String c2 = sr0Var.c();
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
                    f0(sr0Var.g(5) * 1000, sr0Var.h(12, 3));
                    return;
                case 1:
                    f0(sr0Var.g(5), sr0Var.h(12, 3));
                    return;
                case 2:
                    a0();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    t0();
                    return;
                case 4:
                    Z();
                    return;
                case 5:
                    d0();
                    return;
                case 6:
                    u0();
                    return;
                default:
                    return;
            }
        }
    }
}
