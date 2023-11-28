package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
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
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes8.dex */
public class tr0 extends lr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public FrameLayout.LayoutParams c;
    public boolean d;
    public Animator e;
    public Animator f;
    public String g;
    public int h;
    public int i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr0 a;

        public a(tr0 tr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    public tr0() {
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

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f.isRunning() && this.b.getAlpha() != 0.0f) {
            this.f.start();
            D(false);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.e.isRunning() && this.b.getAlpha() != 1.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.bringToFront();
            this.e.start();
            z();
            D(true);
        }
    }

    @Override // com.baidu.tieba.mr0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.postDelayed(new a(this), 3000L);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 0.0f, 1.0f).setDuration(250L);
            this.f = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.0f).setDuration(250L);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.b.setBackground(f().getResources().getDrawable(R.drawable.nad_videoplayer_immersive_video_next_bg));
            this.b.setText(f().getResources().getText(R.string.nad_videoplayer_video_next_tip));
            this.b.setPadding(38, 14, 38, 14);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i31.b(35.0f);
            this.b.setPadding(0, 0, i31.b(15.0f), 0);
            this.b.setText(f().getResources().getString(R.string.nad_videoplayer_half_video_next_tip));
            this.b.setBackground(f().getResources().getDrawable(R.drawable.nad_videoplayer_control_panel_background));
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ks0 x = as0.x(LayerEvent.ACTION_POPUP_SHOW);
            x.o(28, Boolean.valueOf(z));
            s().o0(x);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.h = R.string.nad_videoplayer_video_next_tip;
                this.i = R.string.nad_videoplayer_full_after_ad_play_next_tip;
                return;
            }
            this.h = R.string.nad_videoplayer_half_video_next_tip;
            this.i = R.string.nad_videoplayer_after_ad_play_next_tip;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (s().Q0()) {
                this.c.bottomMargin = i31.b(7.0f);
            } else {
                this.c.bottomMargin = 2;
                this.b.setBackground(f().getResources().getDrawable(R.drawable.nad_videoplayer_control_panel_background));
            }
            this.b.setLayoutParams(this.c);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (s().Q0()) {
                this.c.bottomMargin = i31.b(81.0f);
            } else {
                this.c.bottomMargin = i31.b(32.0f);
                this.b.setBackgroundColor(0);
                this.c.height = i31.b(32.0f);
            }
            this.b.setLayoutParams(this.c);
        }
    }

    @Override // com.baidu.tieba.fr0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(f());
            this.b = textView;
            textView.setText(f().getResources().getString(R.string.nad_videoplayer_half_video_next_tip));
            this.b.setTextSize(0, f().getResources().getDimensionPixelSize(R.dimen.nad_videoplayer_immersive_video_next_text_size));
            this.b.setShadowLayer(0.0f, 0.0f, 1.0f, Color.parseColor("#80000000"));
            this.b.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i31.b(35.0f));
            this.c = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            this.b.setLayoutParams(layoutParams);
            this.b.setBackground(ContextCompat.getDrawable(f(), R.drawable.nad_videoplayer_next_play_tips_background));
            this.b.setGravity(8388629);
            this.b.setAlpha(0.0f);
            this.b.setPadding(0, 0, i31.b(15.0f), 0);
            B();
            E(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.fr0
    public void l(@NonNull ks0 ks0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ks0Var) == null) {
            super.l(ks0Var);
            String c2 = ks0Var.c();
            switch (c2.hashCode()) {
                case -1244137507:
                    if (c2.equals(PlayerEvent.ACTION_SEEK_COMPLETE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 723345051:
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1933234291:
                    if (c2.equals(ControlEvent.ACTION_CONTINUE_TIPS_SHOW)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0 && c != 1 && c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        if (c == 5) {
                            G();
                            E(false);
                            return;
                        }
                        return;
                    }
                    F();
                    E(true);
                    return;
                } else if (s().n1()) {
                    return;
                } else {
                    boolean e = ks0Var.e(8, false);
                    boolean e2 = ks0Var.e(9, false);
                    if (e) {
                        this.b.setText(f().getResources().getString(this.i));
                    } else if (e2) {
                        if (!TextUtils.isEmpty(this.g)) {
                            this.b.setText(this.g);
                            this.b.setBackground(f().getResources().getDrawable(R.drawable.nad_videoplayer_control_panel_background));
                        }
                    } else {
                        this.b.setText(f().getResources().getString(this.h));
                    }
                    if (this.d) {
                        I();
                    } else {
                        H();
                    }
                    J();
                    return;
                }
            }
            A();
        }
    }

    @Override // com.baidu.tieba.lr0
    public void u(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.u(z, z2);
            this.d = z;
            A();
        }
    }
}
