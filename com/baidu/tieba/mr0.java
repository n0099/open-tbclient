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
/* loaded from: classes7.dex */
public class mr0 extends kr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView h;
    public View i;
    public FrameLayout.LayoutParams j;

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public mr0() {
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

    @Override // com.baidu.tieba.lr0
    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.findViewById(R.id.obfuscated_res_0x7f0902b5);
        }
        return (View) invokeV.objValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            M(false);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (s().Q0() && s().a1() == 0) {
                I(true);
            } else {
                I(false);
            }
        }
    }

    @Override // com.baidu.tieba.hr0
    @Nullable
    public ViewGroup.LayoutParams g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lr0, com.baidu.tieba.hr0
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.o();
            this.f.setSeekBarHolderListener(null);
        }
    }

    @Override // com.baidu.tieba.kr0, com.baidu.tieba.nr0
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.x();
            O(true);
        }
    }

    @Override // com.baidu.tieba.kr0
    public boolean E() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cv0 a = px0.a(s().w().getLayerList());
            if (a != null) {
                z = a.P();
            } else {
                z = false;
            }
            if (!s().P() && !z) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (s().Q0() && s().a1() == 0 && this.i.getVisibility() != 4) {
                H(true);
            } else {
                H(false);
            }
        }
    }

    @Override // com.baidu.tieba.kr0
    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.F(z);
            if (z) {
                this.h.setImageDrawable(f().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_half_selector));
                return;
            }
            M(false);
            this.h.setImageDrawable(f().getResources().getDrawable(R.drawable.nad_videoplayer_new_player_full_selector));
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.i.startAnimation(jx0.b());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(4);
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.i.startAnimation(jx0.a());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(0);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.h.setVisibility(i);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (s().i1().g() && z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, view2) == null) && view2.equals(this.h)) {
            ((hv0) this.a).k0(!s().Q0());
        }
    }

    @Override // com.baidu.tieba.hr0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.j = layoutParams;
            layoutParams.gravity = 80;
            ViewGroup viewGroup = (ViewGroup) View.inflate(f(), R.layout.nad_videoplayer_bd_layer_control_bottom_view, null);
            this.e = viewGroup;
            this.i = viewGroup.findViewById(R.id.bd_layer_bottom);
            BdLayerSeekBar bdLayerSeekBar = (BdLayerSeekBar) this.e.findViewById(R.id.layer_seekbar);
            this.f = bdLayerSeekBar;
            bdLayerSeekBar.setSeekBarHolderListener(this);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.expand_full_button);
            this.h = imageView;
            imageView.setOnClickListener(this);
            H(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.kr0, com.baidu.tieba.lr0, com.baidu.tieba.hr0
    public void l(@NonNull ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ms0Var) == null) {
            super.l(ms0Var);
            String c2 = ms0Var.c();
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
                    if (c == 6 && s().n1()) {
                        J();
                        return;
                    }
                    return;
                }
                F(s().Q0());
                return;
            }
            O(true);
        }
    }

    @Override // com.baidu.tieba.kr0, com.baidu.tieba.nr0
    public void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.u(z, z2);
            if (z) {
                L();
                return;
            }
            K();
            z();
        }
    }
}
