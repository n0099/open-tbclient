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
import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class qr0 extends kr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public qr0() {
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setVisibility(8);
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdVideoSeries j1 = s().j1();
            if (j1 != null && j1.getSelectedVideo() != null && j1.getSelectedVideo().getShowTitle()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && B()) {
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.lr0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kr0
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.x();
            A();
        }
    }

    @Override // com.baidu.tieba.kr0
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.y();
            E();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            A();
            this.b.setText((CharSequence) null);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries j1 = s().j1();
            if (j1 != null && j1.getSelectedVideo() != null) {
                if (j1.getSelectedVideo().getShowTitle()) {
                    E();
                    this.b.setText(j1.getSelectedVideo().getTitle());
                    this.b.setTextSize(0, j1.getTitleSizePx());
                    this.b.setTypeface(Typeface.DEFAULT_BOLD);
                    return;
                }
                z();
                return;
            }
            A();
        }
    }

    @Override // com.baidu.tieba.er0
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TextView textView = new TextView(f());
            this.b = textView;
            textView.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setMaxLines(2);
            this.b.setLineSpacing(h31.b(1.33f), 1.0f);
            this.b.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = t11.c.a(f(), 9.0f);
            layoutParams.rightMargin = t11.c.a(f(), 15.0f);
            layoutParams.leftMargin = t11.c.a(f(), 15.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.er0
    public void m(@NonNull js0 js0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, js0Var) == null) {
            String c2 = js0Var.c();
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
                            E();
                            return;
                        }
                        return;
                    } else if (C()) {
                        E();
                        return;
                    } else {
                        return;
                    }
                }
                A();
                return;
            }
            D();
        }
    }

    @Override // com.baidu.tieba.kr0
    public void u(boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.u(z, z2);
            if (!s().Q0() && z) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                A();
            } else {
                E();
            }
        }
    }
}
