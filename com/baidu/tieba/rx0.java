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
/* loaded from: classes6.dex */
public class rx0 extends jx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public au0 i;
    public ut0 j;
    public yt0 k;
    @Nullable
    public cu0 l;
    public eu0 m;
    public bu0 n;

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public rx0() {
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

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vt0 vt0Var = new vt0();
            this.j = vt0Var;
            M(vt0Var);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yt0 yt0Var = new yt0();
            this.k = yt0Var;
            M(yt0Var);
        }
    }

    public void d0() {
        ut0 ut0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ut0Var = this.j) != null) {
            ut0Var.x();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.removeMessages(0);
        }
    }

    @Override // com.baidu.tieba.sx0, com.baidu.tieba.wv0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new int[]{4, 2, 3, 5, 1, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p01.k(this);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((wt0) it.next()).t();
            }
            this.h = false;
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((wt0) it.next()).u();
            }
        }
    }

    @Override // com.baidu.tieba.sx0, com.baidu.tieba.ix0, com.baidu.tieba.vx0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.jx0, com.baidu.tieba.sx0, com.baidu.tieba.ix0
    public void B(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.B(message);
            if (message.what == 0) {
                m0();
                Y(false);
            }
        }
    }

    @Override // com.baidu.tieba.sx0, com.baidu.tieba.ix0, com.baidu.tieba.wv0
    public void j(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vu0Var) == null) {
            super.j(vu0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(vu0Var.c())) {
                if (vu0Var.d(9)) {
                    k0();
                } else {
                    l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.sx0
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            au0 au0Var = new au0();
            this.i = au0Var;
            M(au0Var);
            cu0 cu0Var = new cu0();
            this.l = cu0Var;
            M(cu0Var);
            bu0 bu0Var = new bu0();
            this.n = bu0Var;
            M(bu0Var);
            M(new du0());
            eu0 eu0Var = new eu0();
            this.m = eu0Var;
            M(eu0Var);
            a0();
            b0();
            M(new fu0());
            M(new zt0());
            c0();
        }
    }

    @Override // com.baidu.tieba.jx0, com.baidu.tieba.sx0, com.baidu.tieba.ix0, com.baidu.tieba.wv0
    public void d(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vu0Var) == null) {
            super.d(vu0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(vu0Var.c())) {
                Y(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(vu0Var.c())) {
                Y(false);
            }
        }
    }

    public final void h0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && p01.f()) {
            if (z) {
                i = b01.a(this.e, 20.0f);
            } else {
                i = 0;
            }
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), i);
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                if (!u().V0()) {
                    u().c1(1);
                }
            } else if (u().V0()) {
                u().d1(1);
            }
        }
    }

    @Override // com.baidu.tieba.jx0, com.baidu.tieba.sx0, com.baidu.tieba.ix0, com.baidu.tieba.wv0
    public void k(@NonNull vu0 vu0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, vu0Var) == null) {
            super.k(vu0Var);
            String c2 = vu0Var.c();
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
                i0();
                Y(f0());
                d0();
                e0();
                h0(true);
                return;
            }
            p01.i(this);
            Y(false);
            vu0 w = lu0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
            w.n(16, Boolean.FALSE);
            H(w);
            if (this.h) {
                n0();
                this.d.removeMessages(0);
                this.d.sendEmptyMessageDelayed(0, 2000L);
            }
            h0(false);
        }
    }

    @Override // com.baidu.tieba.jx0, com.baidu.tieba.sx0, com.baidu.tieba.ix0, com.baidu.tieba.wv0
    public void q(@NonNull vu0 vu0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, vu0Var) == null) {
            super.q(vu0Var);
            String c2 = vu0Var.c();
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
                } else if (vu0Var.g(11) == 2 && !u().p1()) {
                    g0();
                    Y(true);
                    V();
                    return;
                } else {
                    return;
                }
            }
            Y(false);
            BdVideoSeries o1 = u().o1();
            if (o1 != null && o1.getSelectedVideo().getShowTitle()) {
                this.d.removeMessages(0);
                if (!u().V0()) {
                    n0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            }
        }
    }
}
