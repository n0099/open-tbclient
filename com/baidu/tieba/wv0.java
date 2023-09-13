package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.BdLayerSeekBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wv0 extends uv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView h;
    public View i;
    public FrameLayout.LayoutParams j;

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public wv0() {
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
        this.j = null;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            K(false);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q().V0() && q().f1() == 0) {
                G(true);
            } else {
                G(false);
            }
        }
    }

    @Override // com.baidu.tieba.rv0
    @Nullable
    public ViewGroup.LayoutParams f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv0, com.baidu.tieba.rv0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.m();
            this.f.setSeekBarHolderListener(null);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.xv0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.t();
            M(true);
        }
    }

    @Override // com.baidu.tieba.vv0
    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e.findViewById(R.id.obfuscated_res_0x7f09028d);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0
    public boolean C() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nz0 a = j21.a(q().v().getLayerList());
            if (a != null) {
                z = a.N();
            } else {
                z = false;
            }
            if (!q().Q() && !z) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q().V0() && q().f1() == 0 && this.i.getVisibility() != 4) {
                F(true);
            } else {
                F(false);
            }
        }
    }

    @Override // com.baidu.tieba.uv0
    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.D(z);
            if (z) {
                this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_half_selector));
                return;
            }
            K(false);
            this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_full_selector));
        }
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.i.startAnimation(d21.b());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(4);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.i.startAnimation(d21.a());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(0);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.h.setVisibility(i);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (q().n1().g() && z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.tieba.uv0, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2.equals(this.h)) {
            ((sz0) this.a).j0(!q().V0());
        }
    }

    @Override // com.baidu.tieba.rv0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.j = layoutParams;
            layoutParams.gravity = 80;
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.nad_videoplayer_bd_layer_control_bottom_view, null);
            this.e = viewGroup;
            this.i = viewGroup.findViewById(R.id.bd_layer_bottom);
            BdLayerSeekBar bdLayerSeekBar = (BdLayerSeekBar) this.e.findViewById(R.id.layer_seekbar);
            this.f = bdLayerSeekBar;
            bdLayerSeekBar.setSeekBarHolderListener(this);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.expand_full_button);
            this.h = imageView;
            imageView.setOnClickListener(this);
            F(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.uv0, com.baidu.tieba.vv0, com.baidu.tieba.rv0
    public void k(@NonNull ww0 ww0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ww0Var) == null) {
            super.k(ww0Var);
            String c2 = ww0Var.c();
            switch (c2.hashCode()) {
                case -1532215489:
                    if (c2.equals(LayerEvent.ACTION_SET_BARRAGE_HOT_LIST)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -849541738:
                    if (c2.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -503058442:
                    if (c2.equals(LayerEvent.ACTION_SET_BARRAGE_HINT)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 14382657:
                    if (c2.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1610373035:
                    if (c2.equals(LayerEvent.ACTION_WAKE_UP_END)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 2124623197:
                    if (c2.equals(PlayerEvent.ACTION_UPDATE_DATA_SOURCE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 3) {
                if (c != 4) {
                    if (c == 6 && q().r1()) {
                        H();
                        return;
                    }
                    return;
                }
                D(q().V0());
                return;
            }
            M(true);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.xv0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (z) {
                J();
                return;
            }
            I();
            x();
        }
    }
}
