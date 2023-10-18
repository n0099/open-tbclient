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
/* loaded from: classes8.dex */
public class vq0 extends tq0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public boolean C(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? z : invokeZ.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public vq0() {
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

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Animation a = pw0.a();
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                this.b.startAnimation(a);
            }
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h && !F()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return yo0.S();
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (r().a1() == 0) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            D();
        }
    }

    @Override // com.baidu.tieba.uq0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!r().i1().c()) {
                this.b.setVisibility(4);
                return;
            }
            if (!F() && uw0.c(f()) != 0) {
                if (this.c && !E()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
            } else if (I()) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(4);
            }
            ImageView imageView = this.b;
            if (imageView != null && imageView.getVisibility() != 0) {
                A();
            }
        }
    }

    @Override // com.baidu.tieba.nq0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
            if (this.a.A() != null) {
                L();
            }
        }
    }

    public final void G(sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sr0Var) == null) {
            O(sr0Var.d(16));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            P(z, true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, view2) != null) || !view2.equals(this.b) || this.f) {
            return;
        }
        K();
        D();
    }

    public int z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            if (z) {
                this.b.setVisibility(0);
                return 4;
            }
            D();
            return 0;
        }
        return invokeZ.intValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            zo0 r = r();
            iu0 a = vw0.a(r().w().getLayerList());
            if (!r.P() && !r.Q() && !r.Y() && (a == null || a.getContentView().getVisibility() != 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean F = F();
            if (F && uw0.c(f()) == 0) {
                uw0.d(f(), (int) (uw0.b(f()) * 0.35d));
            }
            M(F);
            boolean z = !F;
            N(z);
            r().q0(z);
            hw0.c().d(ir0.x(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void L() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int c = uw0.c(f());
            if (!r().V() && c > 0) {
                z = false;
            } else {
                z = true;
            }
            C(z);
            r().u0(z);
            N(z);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
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
                A();
            } else if (!z && uw0.c(f()) != 0) {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_selector));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_close_half));
                }
                A();
            } else {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_selector));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_new_player_mute_open_half));
                }
                J();
            }
        }
    }

    public void P(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            boolean z3 = true;
            if (!((r().Q0() && r().a1() == 1) ? false : false) && !z) {
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
    @Override // com.baidu.tieba.nq0
    public void l(@NonNull sr0 sr0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, sr0Var) == null) {
            String c2 = sr0Var.c();
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
                    if (r().Q0() && r().a1() == 1) {
                        ImageView imageView = this.b;
                        if (I() && !E()) {
                            i = 0;
                        }
                        imageView.setVisibility(i);
                        return;
                    }
                    D();
                    return;
                case 5:
                    if (F()) {
                        if (lp0.R0()) {
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
                    if (!E()) {
                        i = 0;
                    }
                    imageView2.setVisibility(i);
                    return;
                case 7:
                case '\b':
                    if (F()) {
                        this.b.setVisibility(0);
                        return;
                    } else {
                        this.b.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.g = true;
                    N(F());
                    H();
                    return;
                case '\n':
                    this.g = false;
                    N(F());
                    this.c = false;
                    O(false);
                    D();
                    return;
                case 11:
                    G(sr0Var);
                    return;
                case '\f':
                    if (!r().Y() && !r().P()) {
                        int g = sr0Var.g(5);
                        if (g > 0) {
                            z = false;
                        }
                        N(z);
                        D();
                        boolean F = F();
                        if ((F && g > 0) || (!F && g == 0)) {
                            K();
                            D();
                            return;
                        }
                        return;
                    }
                    return;
                case '\r':
                    if (sr0Var.d(4)) {
                        L();
                        D();
                        return;
                    }
                    return;
                case 14:
                    O(sr0Var.d(11));
                    return;
                case 15:
                case 16:
                    L();
                    return;
                case 17:
                    this.f = true;
                    N(F());
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f = false;
                    N(F());
                    if (this.b.getVisibility() == 0) {
                        if ((!this.c || E()) && !F()) {
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

    @Override // com.baidu.tieba.nq0
    public void o(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, playerStatus, playerStatus2) == null) {
            super.o(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.c && this.b.getVisibility() != 0 && !E()) {
                this.b.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.tq0
    public void t(boolean z, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z4 = false;
            if (lp0.R0() && r().Q0()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3 && z) {
                z4 = true;
            }
            this.c = z4;
            if (r().Q0()) {
                y(this.c);
            } else {
                z(this.c);
            }
        }
    }

    public int y(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            int i = 0;
            if (r().Q0() && r().a1() == 1) {
                if (z) {
                    this.b.setVisibility((!I() || E()) ? 8 : 8);
                    return 4;
                }
                if ((F() || uw0.c(f()) == 0) && I()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            } else if (z) {
                B();
                return 4;
            } else {
                if (F() && I()) {
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
