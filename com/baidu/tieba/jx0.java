package com.baidu.tieba;

import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class jx0 extends bx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public st0 i;
    public mt0 j;
    public qt0 k;
    @Nullable
    public ut0 l;
    public wt0 m;
    public tt0 n;

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public jx0() {
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
        this.h = false;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nt0 nt0Var = new nt0();
            this.j = nt0Var;
            K(nt0Var);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qt0 qt0Var = new qt0();
            this.k = qt0Var;
            K(qt0Var);
        }
    }

    public void b0() {
        mt0 mt0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (mt0Var = this.j) != null) {
            mt0Var.v();
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.removeMessages(0);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g01.k(this);
        }
    }

    @Override // com.baidu.tieba.kx0, com.baidu.tieba.ov0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new int[]{4, 2, 3, 5, 1, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((ot0) it.next()).t();
            }
            this.h = false;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((ot0) it.next()).u();
            }
        }
    }

    @Override // com.baidu.tieba.kx0, com.baidu.tieba.ax0, com.baidu.tieba.nx0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.kx0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            st0 st0Var = new st0();
            this.i = st0Var;
            K(st0Var);
            ut0 ut0Var = new ut0();
            this.l = ut0Var;
            K(ut0Var);
            tt0 tt0Var = new tt0();
            this.n = tt0Var;
            K(tt0Var);
            K(new vt0());
            wt0 wt0Var = new wt0();
            this.m = wt0Var;
            K(wt0Var);
            Y();
            Z();
            K(new xt0());
            K(new rt0());
            a0();
        }
    }

    @Override // com.baidu.tieba.bx0, com.baidu.tieba.kx0, com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void d(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nu0Var) == null) {
            super.d(nu0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(nu0Var.c())) {
                W(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(nu0Var.c())) {
                W(false);
            }
        }
    }

    public final void f0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && g01.f()) {
            if (z) {
                i = sz0.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                if (!u().V0()) {
                    u().c1(1);
                }
            } else if (u().V0()) {
                u().d1(1);
            }
        }
    }

    @Override // com.baidu.tieba.kx0, com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void j(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, nu0Var) == null) {
            super.j(nu0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(nu0Var.c())) {
                if (nu0Var.d(9)) {
                    i0();
                } else {
                    j0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bx0, com.baidu.tieba.kx0, com.baidu.tieba.ax0
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            super.z(message);
            if (message.what == 0) {
                k0();
                W(false);
            }
        }
    }

    @Override // com.baidu.tieba.bx0, com.baidu.tieba.kx0, com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void k(@NonNull nu0 nu0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nu0Var) == null) {
            super.k(nu0Var);
            String c2 = nu0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -552621273) {
                if (hashCode != -552580917) {
                    if (hashCode == -21461611 && c2.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        this.d.removeMessages(0);
                        this.h = false;
                        return;
                    }
                    return;
                }
                u().f1();
                g0();
                W(d0());
                b0();
                c0();
                f0(true);
                return;
            }
            g01.i(this);
            W(false);
            nu0 w = du0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
            w.n(16, Boolean.FALSE);
            F(w);
            if (this.h) {
                l0();
                this.d.removeMessages(0);
                this.d.sendEmptyMessageDelayed(0, 2000L);
            }
            f0(false);
        }
    }

    @Override // com.baidu.tieba.bx0, com.baidu.tieba.kx0, com.baidu.tieba.ax0, com.baidu.tieba.ov0
    public void q(@NonNull nu0 nu0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, nu0Var) == null) {
            super.q(nu0Var);
            String c2 = nu0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != 720027695) {
                if (hashCode != 723345051) {
                    if (hashCode == 906917140 && c2.equals(ControlEvent.ACTION_RESUME)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 0;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        U(3000);
                        return;
                    }
                    return;
                } else if (nu0Var.g(11) == 2 && !u().p1()) {
                    e0();
                    W(true);
                    T();
                    return;
                } else {
                    return;
                }
            }
            W(false);
            BdVideoSeries o1 = u().o1();
            if (o1 != null && o1.getSelectedVideo().getShowTitle()) {
                this.d.removeMessages(0);
                if (!u().V0()) {
                    l0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            }
        }
    }
}
