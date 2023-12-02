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
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wr0 extends nr0 {
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
        public final /* synthetic */ wr0 a;

        public a(wr0 wr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    public wr0() {
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

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && t() != null && t().Y()) {
            t().Z(false);
        }
    }

    public final void C() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (verticalVolumeBar = this.b) != null && verticalVolumeBar.getVisibility() == 0) {
            this.b.setVisibility(8);
            e(cs0.x(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }

    @Override // com.baidu.tieba.or0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr0
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k();
            C();
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.b == null) {
                j();
            }
            this.b.setLayoutParams(A(z));
            C();
        }
    }

    public FrameLayout.LayoutParams A(boolean z) {
        InterceptResult invokeZ;
        int i;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            int dimension3 = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int min = Math.min(w11.c.e(f()), w11.c.c(f()));
            if (!z) {
                i = ((min / 16) * 9) / 2;
            } else {
                i = min / 2;
            }
            int i2 = i + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_height));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, dimension4);
            }
            layoutParams.width = i2;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_leftmargin);
            } else {
                dimension = f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_leftmargin);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_bottomargin);
            } else {
                dimension2 = f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_full_bottomargin);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Activity m = s().m();
            if (m != null && m.hasWindowFocus()) {
                if ((!s().W() && !s().U()) || this.e) {
                    C();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.b;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    ms0 x = cs0.x(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    e(x);
                    q(x);
                }
                B();
                if (this.c == null) {
                    this.c = (AudioManager) f().getApplicationContext().getSystemService("audio");
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
                t().A().removeCallbacks(this.h);
                t().A().postDelayed(this.h, 1000L);
                return;
            }
            C();
        }
    }

    @Override // com.baidu.tieba.hr0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(f(), null, 16842872);
            this.b = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(A(false));
            this.b.setProgressDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_video_volume_bar_color));
            this.b.setBackgroundResource(R.drawable.nad_videoplayer_video_volume_bar_shadow_bg);
            int dimension = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_volume_shadow_width);
            int i = dimension / 2;
            this.b.setPadding(i, dimension, i, dimension);
            this.b.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hr0
    public void l(@NonNull ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ms0Var) == null) {
            String c2 = ms0Var.c();
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
                    D();
                    return;
                case 1:
                    if (!this.d) {
                        C();
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                    C();
                    return;
                case 5:
                    E(true);
                    return;
                case 6:
                    E(false);
                    return;
                case 7:
                    this.f = true;
                    this.g = ms0Var.g(20);
                    D();
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

    @Override // com.baidu.tieba.nr0
    public void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d = z;
            if (z) {
                C();
            }
        }
    }
}
