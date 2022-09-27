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
/* loaded from: classes5.dex */
public class qw0 extends iw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public zs0 i;
    public ts0 j;
    public xs0 k;
    @Nullable
    public bt0 l;
    public dt0 m;
    public at0 n;

    public qw0() {
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

    @Override // com.baidu.tieba.rw0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zs0 zs0Var = new zs0();
            this.i = zs0Var;
            K(zs0Var);
            bt0 bt0Var = new bt0();
            this.l = bt0Var;
            K(bt0Var);
            at0 at0Var = new at0();
            this.n = at0Var;
            K(at0Var);
            K(new ct0());
            dt0 dt0Var = new dt0();
            this.m = dt0Var;
            K(dt0Var);
            Y();
            Z();
            K(new et0());
            K(new ys0());
            a0();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            us0 us0Var = new us0();
            this.j = us0Var;
            K(us0Var);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xs0 xs0Var = new xs0();
            this.k = xs0Var;
            K(xs0Var);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void b0() {
        ts0 ts0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ts0Var = this.j) == null) {
            return;
        }
        ts0Var.v();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.rw0, com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void d(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ut0Var) == null) {
            super.d(ut0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(ut0Var.c())) {
                W(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(ut0Var.c())) {
                W(false);
            }
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

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.removeMessages(0);
        }
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && nz0.f()) {
            int a = z ? zy0.a(this.e, 20.0f) : 0;
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), a);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            nz0.k(this);
        }
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.vu0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new int[]{4, 2, 3, 5, 1, 8} : (int[]) invokeV.objValue;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                if (u().V0()) {
                    return;
                }
                u().c1(1);
            } else if (u().V0()) {
                u().d1(1);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void j(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ut0Var) == null) {
            super.j(ut0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(ut0Var.c())) {
                if (ut0Var.d(9)) {
                    i0();
                } else {
                    j0();
                }
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.rw0, com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void k(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ut0Var) == null) {
            super.k(ut0Var);
            String c2 = ut0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == -552621273) {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != -552580917) {
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
            if (c == 0) {
                nz0.i(this);
                W(false);
                ut0 w = kt0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
                w.n(16, Boolean.FALSE);
                F(w);
                if (this.h) {
                    l0();
                    this.d.removeMessages(0);
                    this.d.sendEmptyMessageDelayed(0, 2000L);
                }
                f0(false);
            } else if (c != 1) {
                if (c != 2) {
                    return;
                }
                this.d.removeMessages(0);
                this.h = false;
            } else {
                u().f1();
                g0();
                W(d0());
                b0();
                c0();
                f0(true);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((vs0) it.next()).t();
            }
            this.h = false;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((vs0) it.next()).u();
            }
        }
    }

    @Override // com.baidu.tieba.rw0, com.baidu.tieba.hw0, com.baidu.tieba.uw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.rw0, com.baidu.tieba.hw0, com.baidu.tieba.vu0
    public void q(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ut0Var) == null) {
            super.q(ut0Var);
            String c2 = ut0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == 720027695) {
                if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 723345051) {
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
            if (c == 0) {
                W(false);
                BdVideoSeries o1 = u().o1();
                if (o1 == null || !o1.getSelectedVideo().getShowTitle()) {
                    return;
                }
                this.d.removeMessages(0);
                if (!u().V0()) {
                    l0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            } else if (c != 1) {
                if (c != 2) {
                    return;
                }
                U(3000);
            } else if (ut0Var.g(11) != 2 || u().p1()) {
            } else {
                e0();
                W(true);
                T();
            }
        }
    }

    @Override // com.baidu.tieba.iw0, com.baidu.tieba.rw0, com.baidu.tieba.hw0
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
}
