package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public abstract class zu0 extends ev0<FrameLayout, nr0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu0 a;

        public a(zu0 zu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Z(false);
            }
        }
    }

    public zu0() {
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

    @Override // com.baidu.tieba.iv0
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = new FrameLayout(this.c);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.removeMessages(1);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iv0, com.baidu.tieba.yu0, com.baidu.tieba.lv0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onContainerDetach();
            Z(false);
        }
    }

    @Override // com.baidu.tieba.iv0, com.baidu.tieba.yu0
    public void D(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.D(message);
            if (message.what == 1) {
                Z(false);
            }
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            W();
            this.d.sendMessageDelayed(this.d.obtainMessage(1), i);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            a0(z, false);
        }
    }

    @Override // com.baidu.tieba.yu0, com.baidu.tieba.mt0
    @SuppressLint({"WrongConstant"})
    public void r(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ms0Var) == null) {
            if (ControlEvent.ACTION_SHOW_TIP.equals(ms0Var.c())) {
                Z(false);
            }
            Q(ms0Var);
        }
    }

    public void a0(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d.removeMessages(2);
            if (fq0.R0() && y().Q0()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z && z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                X(3000);
                this.g = true;
            } else {
                W();
                this.g = false;
            }
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((nr0) it.next()).u(z4, z2);
            }
            ms0 x = cs0.x(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
            x.o(9, Boolean.valueOf(z4));
            J(x);
            if (y().Q0() && nx0.i(u())) {
                nx0.o(nx0.e(u()), true);
            }
            y().z().y(z4);
        }
    }

    @Override // com.baidu.tieba.yu0, com.baidu.tieba.mt0
    public void d(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ms0Var) == null) {
            if (PlayerEvent.ACTION_ON_COMPLETE.equals(ms0Var.c())) {
                Z(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(ms0Var.c())) {
                Z(false);
            }
            Q(ms0Var);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.yu0, com.baidu.tieba.mt0
    public void k(@NonNull ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ms0Var) == null) {
            String c2 = ms0Var.c();
            switch (c2.hashCode()) {
                case -1814572281:
                    if (c2.equals(LayerEvent.ACTION_SPEED_CLICK)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225548796:
                    if (c2.equals(LayerEvent.ACTION_PRAISE_ANIM_START)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -915923721:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -361192620:
                    if (c2.equals(LayerEvent.ACTION_CLARITY_CLICK)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -150198673:
                    if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c = 3;
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
                case 555655894:
                    if (c2.equals(LayerEvent.ACTION_GOODS_CLICK)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1231554669:
                    if (c2.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1249368243:
                    if (c2.equals(LayerEvent.ACTION_LONG_PRESS)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1626817018:
                    if (c2.equals(LayerEvent.ACTION_SHOW_FACE_AI_HEAD_BOX)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 5;
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
                    W();
                    break;
                case 1:
                    Z(!this.g);
                    break;
                case 2:
                    this.d.postDelayed(new a(this), 100L);
                    break;
                case 3:
                    Z(true);
                    z().h();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                    Z(false);
                    break;
            }
            Q(ms0Var);
        }
    }
}
