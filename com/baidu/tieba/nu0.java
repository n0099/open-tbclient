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
/* loaded from: classes7.dex */
public class nu0 extends fu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public xq0 i;
    public rq0 j;
    public vq0 k;
    @Nullable
    public zq0 l;
    public br0 m;
    public yq0 n;

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public nu0() {
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

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sq0 sq0Var = new sq0();
            this.j = sq0Var;
            M(sq0Var);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vq0 vq0Var = new vq0();
            this.k = vq0Var;
            M(vq0Var);
        }
    }

    public void e0() {
        rq0 rq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rq0Var = this.j) != null) {
            rq0Var.y();
        }
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new int[]{4, 2, 3, 5, 1, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.removeMessages(0);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ax0.k(this);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((tq0) it.next()).u();
            }
            this.h = false;
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((tq0) it.next()).x();
            }
        }
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.eu0, com.baidu.tieba.ru0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.ou0, com.baidu.tieba.eu0
    public void C(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.C(message);
            if (message.what == 0) {
                n0();
                Z(false);
            }
        }
    }

    @Override // com.baidu.tieba.ou0, com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void j(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sr0Var) == null) {
            super.j(sr0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(sr0Var.c())) {
                if (sr0Var.d(9)) {
                    l0();
                } else {
                    m0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ou0
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xq0 xq0Var = new xq0();
            this.i = xq0Var;
            M(xq0Var);
            zq0 zq0Var = new zq0();
            this.l = zq0Var;
            M(zq0Var);
            yq0 yq0Var = new yq0();
            this.n = yq0Var;
            M(yq0Var);
            M(new ar0());
            br0 br0Var = new br0();
            this.m = br0Var;
            M(br0Var);
            b0();
            c0();
            M(new cr0());
            M(new wq0());
            d0();
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void d(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sr0Var) == null) {
            super.d(sr0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(sr0Var.c())) {
                Z(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(sr0Var.c())) {
                Z(false);
            }
        }
    }

    public final void i0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && ax0.f()) {
            if (z) {
                i = nw0.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                if (!x().Q0()) {
                    x().X0(1);
                }
            } else if (x().Q0()) {
                x().Y0(1);
            }
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void k(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sr0Var) == null) {
            super.k(sr0Var);
            String c2 = sr0Var.c();
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
                x().a1();
                j0();
                Z(g0());
                e0();
                f0();
                i0(true);
                return;
            }
            ax0.i(this);
            Z(false);
            sr0 x = ir0.x(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
            x.o(16, Boolean.FALSE);
            I(x);
            if (this.h) {
                o0();
                this.d.removeMessages(0);
                this.d.sendEmptyMessageDelayed(0, 2000L);
            }
            i0(false);
        }
    }

    @Override // com.baidu.tieba.fu0, com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void q(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sr0Var) == null) {
            super.q(sr0Var);
            String c2 = sr0Var.c();
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
                        W(3000);
                        return;
                    }
                    return;
                } else if (sr0Var.g(11) == 2 && !x().l1()) {
                    h0();
                    Z(true);
                    V();
                    return;
                } else {
                    return;
                }
            }
            Z(false);
            BdVideoSeries j1 = x().j1();
            if (j1 != null && j1.getSelectedVideo().getShowTitle()) {
                this.d.removeMessages(0);
                if (!x().Q0()) {
                    o0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            }
        }
    }
}
