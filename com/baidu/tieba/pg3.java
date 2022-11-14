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
/* loaded from: classes5.dex */
public class pg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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

    public static void a(o32 o32Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, o32Var, context) == null) {
            b(o32Var, context, 2);
        }
    }

    public static void b(o32 o32Var, Context context, int i) {
        View V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65537, null, o32Var, context, i) == null) && o32Var != null && o32Var.k() >= i) {
            l32 j = o32Var.j(o32Var.k() - i);
            l32 m = o32Var.m();
            if (m != null && m.D0) {
                return;
            }
            float o = wh3.o(context) >> 2;
            if (j != null && (V = j.V()) != null) {
                ObjectAnimator.ofFloat(V, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
            }
        }
    }

    public static void c(o32 o32Var, Context context) {
        View V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, o32Var, context) == null) && o32Var != null && o32Var.k() >= 2) {
            l32 j = o32Var.j(o32Var.k() - 2);
            float o = wh3.o(context) >> 2;
            if (j != null && (V = j.V()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(V, Key.TRANSLATION_X, 0.0f, -o);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new a(V));
            }
        }
    }

    public static void d(@NonNull di4 di4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, di4Var, str, i, i2) != null) || di4Var == null) {
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
                di4Var.i(i, i2);
                return;
            }
            return;
        }
        o32 V = sp2.U().V();
        l32 j = V.j(V.k() - 1);
        if (j != null && j.D0) {
            return;
        }
        di4Var.i(i, i2);
    }
}
