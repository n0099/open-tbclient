package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.ui.BdLayerTitleBarView;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ns0 extends is0 implements BdLayerTitleBarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdLayerTitleBarView b;

    public ns0() {
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

    @Override // com.baidu.tieba.js0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = new BdLayerTitleBarView(getContext());
            this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.b.setVisibility(4);
            this.b.setListener(this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.cs0
    public void k(@NonNull ht0 ht0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ht0Var) == null) {
            String c2 = ht0Var.c();
            switch (c2.hashCode()) {
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -745690976:
                    if (c2.equals(InteractiveEvent.ACTION_INTERACTIVE_START)) {
                        c = 5;
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
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -461848373:
                    if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 250537257:
                    if (c2.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1 || c == 2) {
                if (q().V0()) {
                    this.b.e(false, true, q().r1());
                }
            } else if (c != 4 && c != 5) {
                if (c == 6 && !q().Y()) {
                    s(true, false);
                }
            } else {
                this.b.a(false);
            }
        }
    }

    @Override // com.baidu.tieba.cs0
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, playerStatus, playerStatus2) == null) {
            super.n(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING && q().V0()) {
                ew0 ew0Var = this.a;
                if (!(ew0Var instanceof vv0) || ((vv0) ew0Var).V()) {
                    return;
                }
                this.b.a(true);
            }
        }
    }

    @Override // com.baidu.nadcore.player.ui.BdLayerTitleBarView.a
    public void onBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q().d1(2);
        }
    }

    @Override // com.baidu.tieba.is0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.s(z, z2);
            if (z) {
                if (q().V0() && q().f1() == 0) {
                    this.b.e(true, !q().Y(), q().r1());
                }
            } else if (q().V0() && q().f1() == 0 && this.b.getVisibility() != 4 && q().Y()) {
                this.b.a(true);
            }
        }
    }
}
