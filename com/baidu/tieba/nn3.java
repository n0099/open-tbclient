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
/* loaded from: classes7.dex */
public class nn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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

    public static void a(ma2 ma2Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ma2Var, context) == null) {
            b(ma2Var, context, 2);
        }
    }

    public static void b(ma2 ma2Var, Context context, int i) {
        View b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65537, null, ma2Var, context, i) == null) && ma2Var != null && ma2Var.k() >= i) {
            ja2 j = ma2Var.j(ma2Var.k() - i);
            ja2 m = ma2Var.m();
            if (m != null && m.E0) {
                return;
            }
            float o = uo3.o(context) >> 2;
            if (j != null && (b0 = j.b0()) != null) {
                ObjectAnimator.ofFloat(b0, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
            }
        }
    }

    public static void c(ma2 ma2Var, Context context) {
        View b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, ma2Var, context) == null) && ma2Var != null && ma2Var.k() >= 2) {
            ja2 j = ma2Var.j(ma2Var.k() - 2);
            float o = uo3.o(context) >> 2;
            if (j != null && (b0 = j.b0()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b0, Key.TRANSLATION_X, 0.0f, -o);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new a(b0));
            }
        }
    }

    public static void d(@NonNull bp4 bp4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, bp4Var, str, i, i2) != null) || bp4Var == null) {
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
                bp4Var.i(i, i2);
                return;
            }
            return;
        }
        ma2 U = qw2.T().U();
        ja2 j = U.j(U.k() - 1);
        if (j != null && j.E0) {
            return;
        }
        bp4Var.i(i, i2);
    }
}
