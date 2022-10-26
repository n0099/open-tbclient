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
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class zy1 extends bz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppComponentContainerView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ az1 c;

        public a(zy1 zy1Var, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, swanAppComponentContainerView, Boolean.valueOf(z), az1Var};
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
            this.c = az1Var;
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
    public zy1(Context context, az1 az1Var) {
        super(context, az1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, az1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (cz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bz1
    /* renamed from: I */
    public e02 k(az1 az1Var, az1 az1Var2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, az1Var, az1Var2)) == null) {
            e02 k = super.k(az1Var, az1Var2);
            if (az1Var2.j != null && ((jSONObject = az1Var.j) == null || !TextUtils.equals(jSONObject.toString(), az1Var2.j.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (e02) invokeLL.objValue;
    }

    public void Q(View view2, az1 az1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, view2, az1Var) != null) || az1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(az1Var.k);
        gradientDrawable.setCornerRadius(az1Var.n);
        gradientDrawable.setStroke(az1Var.l, az1Var.m);
        view2.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bz1
    /* renamed from: O */
    public void C(View view2, az1 az1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, view2, az1Var, e02Var) == null) {
            super.C(view2, az1Var, e02Var);
            if (e02Var.a(4)) {
                R(view2, az1Var);
                Q(view2, az1Var);
                P(view2, az1Var);
            }
        }
    }

    public final ValueAnimator F(SwanAppComponentContainerView swanAppComponentContainerView, az1 az1Var, az1 az1Var2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, az1Var, az1Var2)) == null) {
            if (az1Var2.j != null) {
                float b = mg3.b(az1Var.j, NativeConstants.OPACITY, 1.0f);
                float b2 = mg3.b(az1Var2.j, NativeConstants.OPACITY, b);
                if (b != b2) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, Key.ALPHA, b, b2);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet G(long j, Interpolator interpolator, List list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), interpolator, list})) == null) {
            if (j <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Animator animator = (Animator) it.next();
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

    public final ValueAnimator H(SwanAppComponentContainerView swanAppComponentContainerView, az1 az1Var, az1 az1Var2, boolean z) {
        InterceptResult invokeCommon;
        int e;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, az1Var, az1Var2, Boolean.valueOf(z)})) == null) {
            st2 st2Var = az1Var.h;
            if (st2Var == null || az1Var2.h == null) {
                return null;
            }
            if (z) {
                e = st2Var.d();
            } else {
                e = st2Var.e();
            }
            st2 st2Var2 = az1Var2.h;
            if (z) {
                e2 = st2Var2.d();
            } else {
                e2 = st2Var2.e();
            }
            if (e == e2) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(e, e2);
            ofInt.addUpdateListener(new a(this, swanAppComponentContainerView, z, az1Var2));
            return ofInt;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!s(4) || !t() || (jSONObject = ((az1) n()).q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator K(String str) {
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
            az1 az1Var = (az1) p();
            az1 az1Var2 = (az1) n();
            if (m == null || az1Var == null || (jSONObject = az1Var2.q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(H(m, az1Var, az1Var2, false));
                arrayList.add(H(m, az1Var, az1Var2, true));
            } else {
                arrayList.add(F(m, az1Var, az1Var2));
            }
            AnimatorSet G = G(az1Var2.r, K(az1Var2.s), arrayList);
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

    public void P(View view2, az1 az1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, view2, az1Var) != null) || az1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (J()) {
            if (bz1.h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (!L()) {
                m02.o("Component-View", "performAlphaUpdateAnimation fail");
                return;
            }
            return;
        }
        float f = az1Var.p;
        if (f >= 0.0f && f <= 1.0f) {
            view2.setAlpha(f);
            return;
        }
        m02.o("Component-View", "alpha invalid: " + az1Var.p);
    }

    public void R(View view2, az1 az1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, view2, az1Var) != null) || az1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = az1Var.o;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            view2.setPadding(dh3.g((float) jSONArray.optDouble(3, 0.0d)), dh3.g((float) jSONArray.optDouble(0, 0.0d)), dh3.g((float) jSONArray.optDouble(1, 0.0d)), dh3.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        m02.c("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
