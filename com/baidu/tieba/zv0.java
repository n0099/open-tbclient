package com.baidu.tieba;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.m61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zv0 extends tv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public zv0() {
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

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdVideoSeries o1 = q().o1();
            if (o1 != null && o1.getSelectedVideo() != null && o1.getSelectedVideo().getShowTitle()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && z()) {
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.uv0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tv0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.t();
            y();
        }
    }

    @Override // com.baidu.tieba.tv0
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.u();
            C();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            y();
            this.b.setText((CharSequence) null);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setVisibility(8);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdVideoSeries o1 = q().o1();
            if (o1 != null && o1.getSelectedVideo() != null) {
                if (o1.getSelectedVideo().getShowTitle()) {
                    C();
                    this.b.setText(o1.getSelectedVideo().getTitle());
                    this.b.setTextSize(0, o1.getTitleSizePx());
                    this.b.setTypeface(Typeface.DEFAULT_BOLD);
                    return;
                }
                x();
                return;
            }
            y();
        }
    }

    @Override // com.baidu.tieba.nv0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TextView textView = new TextView(getContext());
            this.b = textView;
            textView.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setMaxLines(2);
            this.b.setLineSpacing(z71.b(1.33f), 1.0f);
            this.b.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = m61.c.a(getContext(), 9.0f);
            layoutParams.rightMargin = m61.c.a(getContext(), 15.0f);
            layoutParams.leftMargin = m61.c.a(getContext(), 15.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.nv0
    public void k(@NonNull sw0 sw0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sw0Var) == null) {
            String c2 = sw0Var.c();
            switch (c2.hashCode()) {
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1393368882:
                    if (c2.equals(LayerEvent.ACTION_WAKE_UP_START)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3) {
                            C();
                            return;
                        }
                        return;
                    } else if (A()) {
                        C();
                        return;
                    } else {
                        return;
                    }
                }
                y();
                return;
            }
            B();
        }
    }

    @Override // com.baidu.tieba.tv0
    public void s(boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (!q().V0() && z) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                y();
            } else {
                C();
            }
        }
    }
}
