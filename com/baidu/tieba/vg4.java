package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public boolean d;
    public b e;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ vg4 c;

        public a(vg4 vg4Var, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg4Var, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vg4Var;
            this.a = z;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                animator.removeAllListeners();
                if (!this.a) {
                    this.c.c(this.b);
                }
                if (this.c.e != null) {
                    this.c.e.a(this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948239814, "Lcom/baidu/tieba/vg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948239814, "Lcom/baidu/tieba/vg4;");
                return;
            }
        }
        f = yo3.g(58.0f);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public vg4(View view2, FrameLayout frameLayout, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, frameLayout, view3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = frameLayout;
        this.c = view3;
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = this.a.getHeight() - (i * 2);
            this.a.setLayoutParams(layoutParams);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.b(z);
            }
            this.d = z;
            int i = f;
            if (z) {
                i = -i;
            }
            float[] fArr = new float[2];
            if (z) {
                fArr[0] = 0.0f;
                fArr[1] = i;
            } else {
                fArr[0] = -i;
                fArr[1] = 0.0f;
            }
            float[] fArr2 = new float[2];
            if (z) {
                fArr2[0] = 0.0f;
                fArr2[1] = i * 2;
            } else {
                fArr2[0] = (-i) * 2;
                fArr2[1] = 0.0f;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, Key.TRANSLATION_Y, fArr), ObjectAnimator.ofFloat(this.a, Key.TRANSLATION_Y, fArr2), ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, fArr2));
            animatorSet.setDuration(200L);
            animatorSet.start();
            animatorSet.addListener(new a(this, z, i));
            if (z) {
                c(i);
            }
        }
    }
}
