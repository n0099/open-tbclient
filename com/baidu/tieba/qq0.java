package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.BdLayerSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class qq0 extends rq0 implements View.OnClickListener, us0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup e;
    public BdLayerSeekBar f;
    public int g;

    public abstract boolean D();

    @Override // com.baidu.tieba.us0
    public void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bdThumbSeekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.tieba.tq0
    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public qq0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.setDuration(r().s());
        }
    }

    @Override // com.baidu.tieba.uq0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nq0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.m();
        }
    }

    @Override // com.baidu.tieba.tq0
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.u();
            this.f.setVisibility(0);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f.e();
            } else {
                this.f.f();
            }
        }
    }

    @Override // com.baidu.tieba.us0
    public void c(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdThumbSeekBar) == null) {
            this.g = r().D();
            s().V();
        }
    }

    public void F(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            this.f.g(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.us0
    public void b(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdThumbSeekBar) == null) {
            if (D()) {
                rw0.a("seek action has been intercepted");
                return;
            }
            sr0 x = ir0.x(LayerEvent.ACTION_SEEK);
            x.o(1, Integer.valueOf(bdThumbSeekBar.getProgress()));
            p(x);
            r().z().F(this.g, bdThumbSeekBar.getProgress());
            s().W(3000);
            this.g = 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.rq0, com.baidu.tieba.nq0
    public void l(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sr0Var) == null) {
            super.l(sr0Var);
            String c2 = sr0Var.c();
            switch (c2.hashCode()) {
                case -1530009462:
                    if (c2.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -525235558:
                    if (c2.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -461848373:
                    if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1610373035:
                    if (c2.equals(LayerEvent.ACTION_WAKE_UP_END)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 0;
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
                    t(false, false);
                    this.f.setPosition(sr0Var.g(2) + sr0Var.g(3));
                    return;
                case 1:
                    E(false);
                    return;
                case 2:
                    E(true);
                    return;
                case 3:
                    C();
                    return;
                case 4:
                case 5:
                    t(false, false);
                    return;
                case 6:
                default:
                    return;
                case 7:
                    F(sr0Var.g(1), sr0Var.g(2), sr0Var.g(3));
                    return;
                case '\b':
                    this.f.setVisibility(0);
                    return;
            }
        }
    }
}
