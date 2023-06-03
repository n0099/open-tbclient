package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tieba.m72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class l72<V extends View, M extends m72> extends n72<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppComponentContainerView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ m72 c;

        public a(l72 l72Var, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l72Var, swanAppComponentContainerView, Boolean.valueOf(z), m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppComponentContainerView;
            this.b = z;
            this.c = m72Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.b) {
                        marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    } else {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    }
                    this.c.h.l(marginLayoutParams.leftMargin);
                    this.c.h.m(marginLayoutParams.topMargin);
                    this.a.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l72(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (o72) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n72
    @NonNull
    /* renamed from: I */
    public q82 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m, m2)) == null) {
            q82 k = super.k(m, m2);
            if (m2.j != null && ((jSONObject = m.j) == null || !TextUtils.equals(jSONObject.toString(), m2.j.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (q82) invokeLL.objValue;
    }

    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, v, m) != null) || m.j == null) {
            return;
        }
        if (n72.h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.k);
        gradientDrawable.setCornerRadius(m.n);
        gradientDrawable.setStroke(m.l, m.m);
        v.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n72
    /* renamed from: O */
    public void C(@NonNull V v, @NonNull M m, @NonNull q82 q82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, v, m, q82Var) == null) {
            super.C(v, m, q82Var);
            if (q82Var.a(4)) {
                R(v, m);
                Q(v, m);
                P(v, m);
            }
        }
    }

    @Nullable
    public final ValueAnimator F(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull m72 m72Var, @NonNull m72 m72Var2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, m72Var, m72Var2)) == null) {
            if (m72Var2.j != null) {
                float b = yo3.b(m72Var.j, NativeConstants.OPACITY, 1.0f);
                float b2 = yo3.b(m72Var2.j, NativeConstants.OPACITY, b);
                if (b != b2) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, Key.ALPHA, b, b2);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet G(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), interpolator, list})) == null) {
            if (j <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Animator animator : list) {
                if (animator != null) {
                    arrayList.add(animator);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @Nullable
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull m72 m72Var, @NonNull m72 m72Var2, boolean z) {
        InterceptResult invokeCommon;
        int e;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, m72Var, m72Var2, Boolean.valueOf(z)})) == null) {
            e23 e23Var = m72Var.h;
            if (e23Var == null || m72Var2.h == null) {
                return null;
            }
            if (z) {
                e = e23Var.d();
            } else {
                e = e23Var.e();
            }
            e23 e23Var2 = m72Var2.h;
            if (z) {
                e2 = e23Var2.d();
            } else {
                e2 = e23Var2.e();
            }
            if (e == e2) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(e, e2);
            ofInt.addUpdateListener(new a(this, swanAppComponentContainerView, z, m72Var2));
            return ofInt;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!s(4) || !t() || (jSONObject = ((m72) n()).q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator K(@NonNull String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            switch (str.hashCode()) {
                case -1965120668:
                    if (str.equals("ease-in")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1102672091:
                    if (str.equals(Easing.LINEAR_NAME)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -789192465:
                    if (str.equals("ease-out")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -361990811:
                    if (str.equals("ease-in-out")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3105774:
                    if (str.equals("ease")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                        }
                        return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                    }
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        }
        return (Interpolator) invokeL.objValue;
    }

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            SwanAppComponentContainerView m = m();
            m72 m72Var = (m72) p();
            m72 m72Var2 = (m72) n();
            if (m == null || m72Var == null || (jSONObject = m72Var2.q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(H(m, m72Var, m72Var2, false));
                arrayList.add(H(m, m72Var, m72Var2, true));
            } else {
                arrayList.add(F(m, m72Var, m72Var2));
            }
            AnimatorSet G = G(m72Var2.r, K(m72Var2.s), arrayList);
            if (G != null) {
                G.start();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return N(false);
        }
        return invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return N(true);
        }
        return invokeV.booleanValue;
    }

    public void P(@NonNull View view2, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, view2, m) != null) || m.j == null) {
            return;
        }
        if (n72.h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (J()) {
            if (n72.h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (!L()) {
                y82.o("Component-View", "performAlphaUpdateAnimation fail");
                return;
            }
            return;
        }
        float f = m.p;
        if (f >= 0.0f && f <= 1.0f) {
            view2.setAlpha(f);
            return;
        }
        y82.o("Component-View", "alpha invalid: " + m.p);
    }

    public void R(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, v, m) != null) || m.j == null) {
            return;
        }
        if (n72.h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = m.o;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(pp3.g((float) jSONArray.optDouble(3, 0.0d)), pp3.g((float) jSONArray.optDouble(0, 0.0d)), pp3.g((float) jSONArray.optDouble(1, 0.0d)), pp3.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        y82.c("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
