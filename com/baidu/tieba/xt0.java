package com.baidu.tieba;

import android.app.Activity;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.VerticalVolumeBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.n31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xt0 extends ot0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VerticalVolumeBar b;
    public AudioManager c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public final Runnable h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt0 a;

        public a(xt0 xt0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xt0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }
    }

    public xt0() {
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
        this.e = false;
        this.f = false;
        this.h = new a(this);
    }

    @Override // com.baidu.tieba.pt0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.j();
            y();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && r() != null && r().V()) {
            r().W(false);
        }
    }

    public final void y() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (verticalVolumeBar = this.b) != null && verticalVolumeBar.getVisibility() == 0) {
            this.b.setVisibility(8);
            e(du0.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.b == null) {
                i();
            }
            this.b.setLayoutParams(w(z));
            y();
        }
    }

    @Override // com.baidu.tieba.it0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.b = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(w(false));
            this.b.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e6a));
            this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e6b);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07059d);
            int i = dimension / 2;
            this.b.setPadding(i, dimension, i, dimension);
            this.b.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.it0
    public void k(@NonNull nu0 nu0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nu0Var) == null) {
            String c2 = nu0Var.c();
            switch (c2.hashCode()) {
                case -915923721:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -21461611:
                    if (c2.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -14542718:
                    if (c2.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 649538615:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1547354793:
                    if (c2.equals(ControlEvent.ACTION_STOP)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822725860:
                    if (c2.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 3;
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
                    z();
                    return;
                case 1:
                    if (!this.d) {
                        y();
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                    y();
                    return;
                case 5:
                    A(true);
                    return;
                case 6:
                    A(false);
                    return;
                case 7:
                    this.f = true;
                    this.g = nu0Var.g(20);
                    z();
                    return;
                case '\b':
                    this.f = false;
                    return;
                case '\t':
                    VerticalVolumeBar verticalVolumeBar = this.b;
                    if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() == 0) {
                        this.b.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.ot0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d = z;
            if (z) {
                y();
            }
        }
    }

    public FrameLayout.LayoutParams w(boolean z) {
        InterceptResult invokeZ;
        int i;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            int dimension3 = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07059d);
            int min = Math.min(n31.c.e(getContext()), n31.c.c(getContext()));
            if (!z) {
                i = ((min / 16) * 9) / 2;
            } else {
                i = min / 2;
            }
            int i2 = i + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07059b));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, dimension4);
            }
            layoutParams.width = i2;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07059c);
            } else {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07059a);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070598);
            } else {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070599);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Activity activity = q().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!q().Y() && !q().W()) || this.e) {
                    y();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.b;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    nu0 w = du0.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    e(w);
                    o(w);
                }
                x();
                if (this.c == null) {
                    this.c = (AudioManager) getContext().getApplicationContext().getSystemService("audio");
                }
                int streamMaxVolume = this.c.getStreamMaxVolume(3);
                int streamVolume = this.c.getStreamVolume(3);
                VerticalVolumeBar verticalVolumeBar2 = this.b;
                if (verticalVolumeBar2 != null) {
                    if (!this.f) {
                        verticalVolumeBar2.setMax(streamMaxVolume);
                        this.b.setProgress(streamVolume);
                    } else {
                        verticalVolumeBar2.setMax(100);
                        this.b.setProgress(this.g);
                    }
                }
                r().w().removeCallbacks(this.h);
                r().w().postDelayed(this.h, 1000L);
                return;
            }
            y();
        }
    }
}
