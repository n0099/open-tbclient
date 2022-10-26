package com.baidu.tieba;

import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public class rw0 extends jw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public at0 i;
    public us0 j;
    public ys0 k;
    public ct0 l;
    public et0 m;
    public bt0 n;

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

    public rw0() {
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
            vs0 vs0Var = new vs0();
            this.j = vs0Var;
            K(vs0Var);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ys0 ys0Var = new ys0();
            this.k = ys0Var;
            K(ys0Var);
        }
    }

    public void b0() {
        us0 us0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (us0Var = this.j) != null) {
            us0Var.v();
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
            oz0.k(this);
        }
    }

    @Override // com.baidu.tieba.sw0, com.baidu.tieba.wu0
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
                ((ws0) it.next()).t();
            }
            this.h = false;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((ws0) it.next()).u();
            }
        }
    }

    @Override // com.baidu.tieba.sw0, com.baidu.tieba.iw0, com.baidu.tieba.vw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.sw0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            at0 at0Var = new at0();
            this.i = at0Var;
            K(at0Var);
            ct0 ct0Var = new ct0();
            this.l = ct0Var;
            K(ct0Var);
            bt0 bt0Var = new bt0();
            this.n = bt0Var;
            K(bt0Var);
            K(new dt0());
            et0 et0Var = new et0();
            this.m = et0Var;
            K(et0Var);
            Y();
            Z();
            K(new ft0());
            K(new zs0());
            a0();
        }
    }

    @Override // com.baidu.tieba.jw0, com.baidu.tieba.sw0, com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void d(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vt0Var) == null) {
            super.d(vt0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(vt0Var.c())) {
                W(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(vt0Var.c())) {
                W(false);
            }
        }
    }

    public final void f0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && oz0.f()) {
            if (z) {
                i = az0.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            ViewGroup viewGroup = this.e;
            ((FrameLayout) viewGroup).setPadding(((FrameLayout) viewGroup).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
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

    @Override // com.baidu.tieba.sw0, com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void j(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vt0Var) == null) {
            super.j(vt0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(vt0Var.c())) {
                if (vt0Var.d(9)) {
                    i0();
                } else {
                    j0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.jw0, com.baidu.tieba.sw0, com.baidu.tieba.iw0
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

    @Override // com.baidu.tieba.jw0, com.baidu.tieba.sw0, com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void k(vt0 vt0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vt0Var) == null) {
            super.k(vt0Var);
            String c2 = vt0Var.c();
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
            oz0.i(this);
            W(false);
            vt0 w = lt0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
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

    @Override // com.baidu.tieba.jw0, com.baidu.tieba.sw0, com.baidu.tieba.iw0, com.baidu.tieba.wu0
    public void q(vt0 vt0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, vt0Var) == null) {
            super.q(vt0Var);
            String c2 = vt0Var.c();
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
                } else if (vt0Var.g(11) == 2 && !u().p1()) {
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
