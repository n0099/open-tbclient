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
/* loaded from: classes6.dex */
public class us0 extends ss0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView h;
    public View i;
    public FrameLayout.LayoutParams j;

    public us0() {
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

    @Override // com.baidu.tieba.ss0
    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            lw0 a = iz0.a(q().v().getLayerList());
            return q().Q() || (a != null ? a.M() : false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss0
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.B(z);
            if (z) {
                this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e15));
                return;
            }
            I(false);
            this.h.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e12));
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.i.startAnimation(bz0.b());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(4);
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.i.startAnimation(bz0.a());
            } else {
                this.i.clearAnimation();
            }
            this.i.setVisibility(0);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I(false);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (q().V0() && q().f1() == 0 && this.i.getVisibility() != 4) {
                D(true);
            } else {
                D(false);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q().V0() && q().f1() == 0) {
                E(true);
            } else {
                E(false);
            }
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.h.setVisibility(i);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (q().n1().g() && z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.tieba.ps0
    @Nullable
    public ViewGroup.LayoutParams f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ps0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.j = layoutParams;
            layoutParams.gravity = 80;
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d061a, null);
            this.e = viewGroup;
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f090360);
            BdLayerSeekBar bdLayerSeekBar = (BdLayerSeekBar) this.e.findViewById(R.id.obfuscated_res_0x7f091270);
            this.f = bdLayerSeekBar;
            bdLayerSeekBar.setSeekBarHolderListener(this);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090954);
            this.h = imageView;
            imageView.setOnClickListener(this);
            D(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.ss0, com.baidu.tieba.ts0, com.baidu.tieba.ps0
    public void k(@NonNull ut0 ut0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ut0Var) == null) {
            super.k(ut0Var);
            String c2 = ut0Var.c();
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
            if (c == 3) {
                L(true);
            } else if (c != 4) {
                if (c == 6 && q().r1()) {
                    F();
                }
            } else {
                B(q().V0());
            }
        }
    }

    @Override // com.baidu.tieba.ts0, com.baidu.tieba.ps0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.m();
            this.f.setSeekBarHolderListener(null);
        }
    }

    @Override // com.baidu.tieba.ss0, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2.equals(this.h)) {
            ((qw0) this.a).h0(!q().V0());
        }
    }

    @Override // com.baidu.tieba.ss0, com.baidu.tieba.vs0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (z) {
                H();
                return;
            }
            G();
            v();
        }
    }

    @Override // com.baidu.tieba.ss0, com.baidu.tieba.vs0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.t();
            L(true);
        }
    }

    @Override // com.baidu.tieba.ts0
    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.e.findViewById(R.id.obfuscated_res_0x7f09027b) : (View) invokeV.objValue;
    }
}
