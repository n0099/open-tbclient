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
/* loaded from: classes7.dex */
public class pr0 extends nr0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public boolean D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? z : invokeZ.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public pr0() {
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Animation a = jx0.a();
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                this.b.startAnimation(a);
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.h && !G()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return sp0.S();
        }
        return invokeV.booleanValue;
    }

    public final void I() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (s().a1() == 0) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            E();
        }
    }

    @Override // com.baidu.tieba.or0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public int A(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                this.b.setVisibility(0);
                return 4;
            }
            E();
            return 0;
        }
        return invokeZ.intValue;
    }

    public final void H(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ms0Var) == null) {
            P(ms0Var.d(16));
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            Q(z, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, view2) != null) || !view2.equals(this.b) || this.f) {
            return;
        }
        L();
        E();
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!s().i1().c()) {
                this.b.setVisibility(4);
                return;
            }
            if (!G() && ox0.c(f()) != 0) {
                if (this.c && !F()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
            } else if (J()) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(4);
            }
            ImageView imageView = this.b;
            if (imageView != null && imageView.getVisibility() != 0) {
                B();
            }
        }
    }

    @Override // com.baidu.tieba.hr0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ImageView imageView = new ImageView(f());
            this.b = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.b.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_width), (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_height));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            if (this.d == -1) {
                this.d = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_leftmargin);
            }
            layoutParams.leftMargin = this.d;
            this.b.setLayoutParams(layoutParams);
            this.b.setVisibility(8);
            if (this.a.B() != null) {
                M();
            }
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            tp0 s = s();
            cv0 a = px0.a(s().w().getLayerList());
            if (!s.P() && !s.Q() && !s.Y() && (a == null || a.getContentView().getVisibility() != 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean G = G();
            if (G && ox0.c(f()) == 0) {
                ox0.d(f(), (int) (ox0.b(f()) * 0.35d));
            }
            N(G);
            boolean z = !G;
            O(z);
            s().q0(z);
            bx0.c().d(cs0.x(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void M() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int c = ox0.c(f());
            if (!s().V() && c > 0) {
                z = false;
            } else {
                z = true;
            }
            D(z);
            s().u0(z);
            O(z);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.g) {
                if (!z) {
                    if (!this.f) {
                        this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_selector_full));
                    } else {
                        this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_full));
                    }
                } else if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_selector_full));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_full));
                }
                B();
            } else if (!z && ox0.c(f()) != 0) {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_selector));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_half));
                }
                B();
            } else {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_selector));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_half));
                }
                K();
            }
        }
    }

    public void Q(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            boolean z3 = true;
            if (!((s().Q0() && s().a1() == 1) ? false : false) && !z) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_leftmargin);
            } else if (z2) {
                int i = this.e;
                if (i == -1) {
                    i = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_buttomargin);
                }
                layoutParams.bottomMargin = i;
                layoutParams.leftMargin = this.d;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) f().getResources().getDimension(R.dimen.nad_videoplayer_bd_video_mute_leftmargin);
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.hr0
    public void l(@NonNull ms0 ms0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ms0Var) == null) {
            String c2 = ms0Var.c();
            boolean z = true;
            int i = 4;
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
                    if (s().Q0() && s().a1() == 1) {
                        ImageView imageView = this.b;
                        if (J() && !F()) {
                            i = 0;
                        }
                        imageView.setVisibility(i);
                        return;
                    }
                    E();
                    return;
                case 5:
                    if (G()) {
                        if (fq0.R0()) {
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
                    ImageView imageView2 = this.b;
                    if (!F()) {
                        i = 0;
                    }
                    imageView2.setVisibility(i);
                    return;
                case 7:
                case '\b':
                    if (G()) {
                        this.b.setVisibility(0);
                        return;
                    } else {
                        this.b.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.g = true;
                    O(G());
                    I();
                    return;
                case '\n':
                    this.g = false;
                    O(G());
                    this.c = false;
                    P(false);
                    E();
                    return;
                case 11:
                    H(ms0Var);
                    return;
                case '\f':
                    if (!s().Y() && !s().P()) {
                        int g = ms0Var.g(5);
                        if (g > 0) {
                            z = false;
                        }
                        O(z);
                        E();
                        boolean G = G();
                        if ((G && g > 0) || (!G && g == 0)) {
                            L();
                            E();
                            return;
                        }
                        return;
                    }
                    return;
                case '\r':
                    if (ms0Var.d(4)) {
                        M();
                        E();
                        return;
                    }
                    return;
                case 14:
                    P(ms0Var.d(11));
                    return;
                case 15:
                case 16:
                    M();
                    return;
                case 17:
                    this.f = true;
                    O(G());
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f = false;
                    O(G());
                    if (this.b.getVisibility() == 0) {
                        if ((!this.c || F()) && !G()) {
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

    @Override // com.baidu.tieba.hr0
    public void p(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, playerStatus, playerStatus2) == null) {
            super.p(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.c && this.b.getVisibility() != 0 && !F()) {
                this.b.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.nr0
    public void u(boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z4 = false;
            if (fq0.R0() && s().Q0()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3 && z) {
                z4 = true;
            }
            this.c = z4;
            if (s().Q0()) {
                z(this.c);
            } else {
                A(this.c);
            }
        }
    }

    public int z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            int i = 0;
            if (s().Q0() && s().a1() == 1) {
                if (z) {
                    this.b.setVisibility((!J() || F()) ? 8 : 8);
                    return 4;
                }
                if ((G() || ox0.c(f()) == 0) && J()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            } else if (z) {
                C();
                return 4;
            } else {
                if (G() && J()) {
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
}
