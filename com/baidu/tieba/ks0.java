package com.baidu.tieba;

import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes4.dex */
public class ks0 extends is0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public ks0() {
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
        this.d = -1;
        this.e = -1;
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!q().n1().c()) {
                this.b.setVisibility(4);
                return;
            }
            if (!C() && ty0.c(getContext()) != 0) {
                if (this.c && !B()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
            } else if (F()) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(4);
            }
            ImageView imageView = this.b;
            if (imageView == null || imageView.getVisibility() == 0) {
                return;
            }
            x();
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h && !C() : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? nq0.T() : invokeV.booleanValue;
    }

    public final void D(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ht0Var) == null) {
            M(ht0Var.d(16));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = q().f1() == 0;
            A();
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            oq0 q = q();
            yv0 a = vy0.a(q().v().getLayerList());
            return (q.Q() || q.R() || q.a0() || (a != null && a.getContentView().getVisibility() == 0)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean C = C();
            if (C && ty0.c(getContext()) == 0) {
                ty0.d(getContext(), (int) (ty0.b(getContext()) * 0.35d));
            }
            K(C);
            boolean z = !C;
            L(z);
            q().s0(z);
            cy0.c().d(xs0.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean z = q().X() || ty0.c(getContext()) <= 0;
            z(z);
            q().w0(z);
            L(z);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.g) {
                if (!z) {
                    if (!this.f) {
                        this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1e));
                    } else {
                        this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1b));
                    }
                } else if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e18));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e15));
                }
                x();
            } else if (!z && ty0.c(getContext()) != 0) {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e17));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e16));
                }
                x();
            } else {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1d));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1c));
                }
                G();
            }
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            N(z, true);
        }
    }

    public void N(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            boolean z3 = true;
            if (!((q().V0() && q().f1() == 1) ? false : false) && !z) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070595);
            } else if (z2) {
                int i = this.e;
                if (i == -1) {
                    i = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070592);
                }
                layoutParams.bottomMargin = i;
                layoutParams.leftMargin = this.d;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070595);
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.js0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.b = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.b.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070596), (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070593));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            if (this.d == -1) {
                this.d = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070595);
            }
            layoutParams.leftMargin = this.d;
            this.b.setLayoutParams(layoutParams);
            this.b.setVisibility(8);
            if (this.a.x() != null) {
                I();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.cs0
    public void k(@NonNull ht0 ht0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ht0Var) == null) {
            String c2 = ht0Var.c();
            switch (c2.hashCode()) {
                case -1759675333:
                    if (c2.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1009727513:
                    if (c2.equals(LayerEvent.ACTION_SHOW_VOLUME_BAR)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -849541738:
                    if (c2.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -461848373:
                    if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -333704320:
                    if (c2.equals(ControlEvent.ACTION_SHOW_TIP)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -150198673:
                    if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -14542718:
                    if (c2.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 14382657:
                    if (c2.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 250537257:
                    if (c2.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 723345051:
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1231554669:
                    if (c2.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1586388829:
                    if (c2.equals(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1673877948:
                    if (c2.equals(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822725860:
                    if (c2.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 7;
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
                case 1:
                case 2:
                case 3:
                    this.b.setVisibility(4);
                    return;
                case 4:
                    if (q().V0() && q().f1() == 1) {
                        ImageView imageView = this.b;
                        if (F() && !B()) {
                            r6 = 0;
                        }
                        imageView.setVisibility(r6);
                        return;
                    }
                    A();
                    return;
                case 5:
                    if (C()) {
                        if (ar0.W0()) {
                            if (this.b.getVisibility() == 0) {
                                this.b.setVisibility(4);
                                return;
                            }
                            return;
                        } else if (this.b.getVisibility() != 0) {
                            this.b.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.b.setVisibility(4);
                    return;
                case 6:
                    this.b.setVisibility(B() ? 4 : 0);
                    return;
                case 7:
                case '\b':
                    if (C()) {
                        this.b.setVisibility(0);
                        return;
                    } else {
                        this.b.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.g = true;
                    L(C());
                    E();
                    return;
                case '\n':
                    this.g = false;
                    L(C());
                    this.c = false;
                    M(false);
                    A();
                    return;
                case 11:
                    D(ht0Var);
                    return;
                case '\f':
                    if (q().a0() || q().Q()) {
                        return;
                    }
                    int g = ht0Var.g(5);
                    L(g <= 0);
                    A();
                    boolean C = C();
                    if ((!C || g <= 0) && (C || g != 0)) {
                        return;
                    }
                    H();
                    A();
                    return;
                case '\r':
                    if (ht0Var.d(4)) {
                        I();
                        A();
                        return;
                    }
                    return;
                case 14:
                    M(ht0Var.d(11));
                    return;
                case 15:
                case 16:
                    I();
                    return;
                case 17:
                    this.f = true;
                    L(C());
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f = false;
                    L(C());
                    if (this.b.getVisibility() == 0) {
                        if ((!this.c || B()) && !C()) {
                            this.b.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.cs0
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, playerStatus, playerStatus2) == null) {
            super.n(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.c && this.b.getVisibility() != 0 && !B()) {
                this.b.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view2) == null) && view2.equals(this.b) && !this.f) {
            H();
            A();
        }
    }

    @Override // com.baidu.tieba.is0
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = false;
            if (((ar0.W0() && q().V0()) ? false : true) && z) {
                z3 = true;
            }
            this.c = z3;
            if (q().V0()) {
                v(this.c);
            } else {
                w(this.c);
            }
        }
    }

    public int v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            int i = 0;
            if (!q().V0() || q().f1() != 1) {
                if (z) {
                    y();
                    return 4;
                }
                if (C() && F()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            } else if (z) {
                this.b.setVisibility((!F() || B()) ? 8 : 8);
                return 4;
            } else {
                if ((C() || ty0.c(getContext()) == 0) && F()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            }
        }
        return invokeZ.intValue;
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            if (z) {
                this.b.setVisibility(0);
                return 4;
            }
            A();
            return 0;
        }
        return invokeZ.intValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Animation a = oy0.a();
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                this.b.startAnimation(a);
            }
        }
    }

    public boolean z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) ? z : invokeZ.booleanValue;
    }
}
