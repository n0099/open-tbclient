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
import com.baidu.tieba.t41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vu0 extends mu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VerticalVolumeBar b;
    public AudioManager c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public final Runnable h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu0 a;

        public a(vu0 vu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    public vu0() {
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

    public final void A() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (verticalVolumeBar = this.b) != null && verticalVolumeBar.getVisibility() == 0) {
            this.b.setVisibility(8);
            e(bv0.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    @Override // com.baidu.tieba.nu0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gu0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.j();
            A();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && r() != null && r().X()) {
            r().Y(false);
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (this.b == null) {
                i();
            }
            this.b.setLayoutParams(y(z));
            A();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Activity activity = q().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!q().Y() && !q().W()) || this.e) {
                    A();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.b;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    lv0 w = bv0.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    e(w);
                    o(w);
                }
                z();
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
                r().y().removeCallbacks(this.h);
                r().y().postDelayed(this.h, 1000L);
                return;
            }
            A();
        }
    }

    @Override // com.baidu.tieba.gu0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.b = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(y(false));
            this.b.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nad_videoplayer_video_volume_bar_color));
            this.b.setBackgroundResource(R.drawable.nad_videoplayer_video_volume_bar_shadow_bg);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int i = dimension / 2;
            this.b.setPadding(i, dimension, i, dimension);
            this.b.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.gu0
    public void k(@NonNull lv0 lv0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lv0Var) == null) {
            String c2 = lv0Var.c();
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
                    B();
                    return;
                case 1:
                    if (!this.d) {
                        A();
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                    A();
                    return;
                case 5:
                    C(true);
                    return;
                case 6:
                    C(false);
                    return;
                case 7:
                    this.f = true;
                    this.g = lv0Var.g(20);
                    B();
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

    @Override // com.baidu.tieba.mu0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d = z;
            if (z) {
                A();
            }
        }
    }

    public FrameLayout.LayoutParams y(boolean z) {
        InterceptResult invokeZ;
        int i;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            int dimension3 = (int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int min = Math.min(t41.c.e(getContext()), t41.c.c(getContext()));
            if (!z) {
                i = ((min / 16) * 9) / 2;
            } else {
                i = min / 2;
            }
            int i2 = i + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_height));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, dimension4);
            }
            layoutParams.width = i2;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_leftmargin);
            } else {
                dimension = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_leftmargin);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_bottomargin);
            } else {
                dimension2 = getContext().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_bottomargin);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }
}
