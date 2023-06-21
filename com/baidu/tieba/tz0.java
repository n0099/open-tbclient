package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tz0 extends qz0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public LinearLayout f;
    public TextView g;
    public Button h;
    public LinearLayout i;
    public TextView j;
    public boolean k;

    public tz0() {
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
        this.k = true;
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.e = frameLayout;
        frameLayout.setVisibility(4);
    }

    public final void N() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (linearLayout = this.i) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void O() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (linearLayout = this.f) != null) {
            linearLayout.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.vz0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new int[]{4, 5, 2, 3, 8};
        }
        return (int[]) invokeV.objValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.i == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.nad_bdvideoplayer_layout_kernel_error, null);
                this.i = linearLayout;
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091c13);
                this.j = textView;
                textView.setOnClickListener(this);
                this.e.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
            }
            this.j.setText(R.string.nad_bdvideoplayer_tip_kernel_error);
            R(u().V0());
            this.i.setVisibility(0);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.k) {
            return;
        }
        if (this.f == null) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.nad_bdvideoplayer_layout_net_error, null);
            this.f = linearLayout;
            this.g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092646);
            Button button = (Button) this.f.findViewById(R.id.obfuscated_res_0x7f09048a);
            this.h = button;
            button.setOnClickListener(this);
            this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        }
        S(u().V0());
        H(lw0.w(LayerEvent.ACTION_NET_ERROR_SHOW));
        this.f.setVisibility(0);
        u().y().y(true);
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Drawable[] compoundDrawables = this.j.getCompoundDrawables();
            if (z) {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_14dp));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_47dp), this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_47dp));
            } else {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_12dp));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_42dp), this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_42dp));
            }
            this.j.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void k(@NonNull vw0 vw0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vw0Var) == null) {
            String c2 = vw0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode != -552621273) {
                if (hashCode != -552580917) {
                    if (hashCode == 1409909918 && c2.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        N();
                        O();
                        return;
                    }
                    return;
                }
                if (this.f != null) {
                    S(false);
                }
                if (this.i != null) {
                    R(false);
                    return;
                }
                return;
            }
            if (this.f != null) {
                S(true);
            }
            if (this.i != null) {
                R(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09048a || view2.getId() == R.id.obfuscated_res_0x7f091c13) {
                if (!BdNetUtils.f()) {
                    ViewGroup n = u().n();
                    if (n != null && u().n1().a()) {
                        h51.a().a(n.getContext(), R.string.nad_bdvideoplayer_tip_net_error);
                        return;
                    }
                    return;
                }
                N();
                O();
                this.e.setVisibility(4);
                u().m0();
                H(lw0.w(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            if (z) {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_14dp));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_14dp));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_102dp);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_32dp);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_31dp);
            } else {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_12dp));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_12dp));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_66dp);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_24_33dp);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.nad_bdvideoplayer_dimens_24dp);
            }
            this.h.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void d(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, vw0Var) == null) && PlayerEvent.ACTION_ON_ERROR.equals(vw0Var.c()) && !u().U0()) {
            this.e.setVisibility(0);
            u().y().j(this);
            if (!BdNetUtils.f()) {
                Q();
                N();
                return;
            }
            P();
            O();
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
                u().y().i(this);
                O();
                N();
            }
        }
    }

    @Override // com.baidu.tieba.iz0, com.baidu.tieba.wx0
    public void q(@NonNull vw0 vw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, vw0Var) == null) {
            if (ControlEvent.ACTION_RESUME.equals(vw0Var.c()) || ControlEvent.ACTION_SHOW_TIP.equals(vw0Var.c()) || ControlEvent.ACTION_START.equals(vw0Var.c())) {
                u().y().i(this);
                N();
                O();
            }
        }
    }
}
