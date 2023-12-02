package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ui3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setTranslationX(0.0f);
            }
        }
    }

    public static void a(t52 t52Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, t52Var, context) == null) {
            b(t52Var, context, 2);
        }
    }

    public static void b(t52 t52Var, Context context, int i) {
        View i0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65537, null, t52Var, context, i) == null) && t52Var != null && t52Var.k() >= i) {
            q52 j = t52Var.j(t52Var.k() - i);
            q52 m = t52Var.m();
            if (m != null && m.E0) {
                return;
            }
            float o = bk3.o(context) >> 2;
            if (j != null && (i0 = j.i0()) != null) {
                ObjectAnimator.ofFloat(i0, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
            }
        }
    }

    public static void c(t52 t52Var, Context context) {
        View i0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, t52Var, context) == null) && t52Var != null && t52Var.k() >= 2) {
            q52 j = t52Var.j(t52Var.k() - 2);
            float o = bk3.o(context) >> 2;
            if (j != null && (i0 = j.i0()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(i0, Key.TRANSLATION_X, 0.0f, -o);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new a(i0));
            }
        }
    }

    public static void d(@NonNull hk4 hk4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, hk4Var, str, i, i2) != null) || hk4Var == null) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1876181062) {
            if (hashCode != -983638536) {
                if (hashCode == 1528366175 && str.equals("showModalPage")) {
                    c = 1;
                }
            } else if (str.equals("navigateBack")) {
                c = 0;
            }
        } else if (str.equals("hideModalPage")) {
            c = 2;
        }
        if (c != 0) {
            if (c != 1 && c != 2) {
                hk4Var.i(i, i2);
                return;
            }
            return;
        }
        t52 W = xr2.V().W();
        q52 j = W.j(W.k() - 1);
        if (j != null && j.E0) {
            return;
        }
        hk4Var.i(i, i2);
    }
}
