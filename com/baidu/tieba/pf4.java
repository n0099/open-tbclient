package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pf4 extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Q;
    public BaseMenuView R;
    public Context S;
    public View T;
    public MainMenuView U;
    public FrameLayout V;
    public hf4 W;
    public boolean X;
    public int Y;

    /* loaded from: classes7.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf4 a;

        public a(pf4 pf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf4Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Context context = this.a.S;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                pf4.super.r();
                pf4 pf4Var = this.a;
                BaseMenuView baseMenuView = pf4Var.R;
                if (baseMenuView != pf4Var.U) {
                    baseMenuView.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf4(Context context, View view2, @Nullable hf4 hf4Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, hf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = true;
        this.Y = 0;
        this.S = context;
        this.T = view2;
        this.W = hf4Var;
        F(false);
        H(true);
        M(true);
        E(new ColorDrawable(0));
        O(-1);
        I(-1);
        if (Build.VERSION.SDK_INT > 29) {
            J(true);
        }
        W();
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.Y = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090525 || id == R.id.obfuscated_res_0x7f091686) {
                V(true);
            }
        }
    }

    public void U() {
        hf4 hf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hf4Var = this.W) != null) {
            hf4Var.a(this.U);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.U.e();
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V(true);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z) {
                super.r();
            } else if (!z()) {
            } else {
                ObjectAnimator c = jf4.c(this.Q);
                ObjectAnimator e = jf4.e(this.R);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new a(this));
                animatorSet.playTogether(c, e);
                animatorSet.start();
            }
        }
    }

    public final void W() {
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.S).inflate(R.layout.obfuscated_res_0x7f0d0093, (ViewGroup) null);
            this.V = frameLayout;
            this.Q = frameLayout.findViewById(R.id.obfuscated_res_0x7f091686);
            this.U = (MainMenuView) this.V.findViewById(R.id.obfuscated_res_0x7f09019c);
            if (lp4.d() && (this.S instanceof Activity)) {
                FrameLayout frameLayout2 = (FrameLayout) this.V.findViewById(R.id.obfuscated_res_0x7f0916d5);
                if (lp4.e((Activity) this.S)) {
                    b = lp4.a((Activity) this.S);
                } else {
                    b = (int) lp4.b((Activity) this.S);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, -1);
                layoutParams.gravity = 17;
                if (frameLayout2 != null) {
                    frameLayout2.setLayoutParams(layoutParams);
                }
            }
            this.Q.setOnClickListener(this);
            this.U.setClickListener(this);
            this.U.setFitsSystemWindows(true);
            this.V.measure(0, 0);
            G(this.V);
        }
    }

    public void Z(List<List<of4>> list, View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.U.update(list, view2, z, i);
            b0();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.Q.setAlpha(0.0f);
            MainMenuView mainMenuView = this.U;
            mainMenuView.setTranslationY(mainMenuView.getHeight());
            ObjectAnimator d = jf4.d(this.Q, this.U);
            ObjectAnimator b = jf4.b(this.U);
            ArrayList arrayList = new ArrayList();
            arrayList.add(d);
            arrayList.add(b);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || z()) {
            return;
        }
        U();
        this.U.f();
        this.R = this.U;
        if (this.X) {
            H(false);
        }
        Activity activity = (Activity) this.S;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            Q(this.T, 81, 0, 0);
            if (this.X) {
                x().setSystemUiVisibility(this.Y | 1024 | 4096);
                H(true);
                update();
            }
            a0();
        }
    }
}
