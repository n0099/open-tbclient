package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.ff;
import com.baidu.tieba.pb.databinding.BotGuideViewBinding;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes6.dex */
public final class ji9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ji9 a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947884399, "Lcom/baidu/tieba/ji9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947884399, "Lcom/baidu/tieba/ji9;");
                return;
            }
        }
        a = new ji9();
    }

    /* loaded from: classes6.dex */
    public static final class b implements ff.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<View> a;
        public final /* synthetic */ Ref.ObjectRef<ObjectAnimator> b;
        public final /* synthetic */ float c;

        /* loaded from: classes6.dex */
        public static final class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ref.ObjectRef a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public a(Ref.ObjectRef objectRef) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {objectRef};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = objectRef;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    ((ObjectAnimator) this.a.element).start();
                }
            }
        }

        public b(Ref.ObjectRef<View> objectRef, Ref.ObjectRef<ObjectAnimator> objectRef2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectRef;
            this.b = objectRef2;
            this.c = f;
        }

        @Override // com.baidu.tieba.ff.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji9 ji9Var = ji9.a;
                ji9.b = false;
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, android.animation.ObjectAnimator, java.lang.Object] */
        @Override // com.baidu.tieba.ff.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ji9 ji9Var = ji9.a;
                ji9.b = true;
                View view2 = this.a.element;
                View view3 = view2;
                if (view3 != null) {
                    Ref.ObjectRef<ObjectAnimator> objectRef = this.b;
                    float f = this.c;
                    ?? ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f, 5.0f, 0.0f);
                    Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(contentView, \"translationY\", 0F, 5F, 0F)");
                    objectRef.element = ofFloat;
                    ((ObjectAnimator) ofFloat).setRepeatMode(2);
                    objectRef.element.setDuration(1000L);
                    objectRef.element.setStartDelay(100L);
                    objectRef.element.setInterpolator(new LinearInterpolator());
                    objectRef.element.setRepeatCount(-1);
                    ValueAnimator b = ji9.a.b(view3, 0.0f, 1.0f, f, 0.0f, 250L);
                    b.addListener(new a(objectRef));
                    b.start();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public a(View view2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Float.valueOf(f), Float.valueOf(f2)};
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
            this.b = f;
            this.c = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    View view2 = this.a;
                    view2.setPivotX(view2.getWidth() - this.b);
                    View view3 = this.a;
                    view3.setPivotY(view3.getHeight() - this.c);
                    this.a.setScaleX(floatValue);
                    this.a.setScaleY(floatValue);
                    this.a.setAlpha(floatValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements df {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef<View> b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tieba.df
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 48;
            }
            return invokeV.intValue;
        }

        public c(String str, Ref.ObjectRef<View> objectRef, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, objectRef, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = objectRef;
            this.c = i;
            this.d = i2;
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, android.widget.RelativeLayout, android.view.View, java.lang.Object] */
        @Override // com.baidu.tieba.df
        public View c(LayoutInflater inflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inflater)) == null) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                BotGuideViewBinding c = BotGuideViewBinding.c(inflater, null, false);
                Intrinsics.checkNotNullExpressionValue(c, "inflate(inflater, null, false)");
                c.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e1b);
                EMManager.from(c.c).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0119);
                c.c.setText(this.a);
                Ref.ObjectRef<View> objectRef = this.b;
                ?? r5 = c.b;
                objectRef.element = r5;
                Intrinsics.checkNotNullExpressionValue(r5, "binding.botGuideRoot");
                return r5;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.df
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return -this.c;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef a;
        public final /* synthetic */ gi9 b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public d(ef efVar, gi9 gi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {efVar, gi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = efVar;
            this.b = gi9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ef efVar = this.a;
                if (efVar != null) {
                    efVar.d();
                }
                gi9 gi9Var = this.b;
                if (gi9Var != null) {
                    gi9Var.onDismiss();
                }
            }
        }
    }

    public ji9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            b = false;
        }
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [T, android.animation.ObjectAnimator] */
    @JvmStatic
    public static final void e(String str, View view2, final BaseFragmentActivity baseFragmentActivity, final gi9 gi9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, view2, baseFragmentActivity, gi9Var) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && view2 != null && view2.getVisibility() == 0 && baseFragmentActivity != null) {
                ff ffVar = new ff();
                ffVar.k(view2);
                ffVar.c(0);
                ffVar.j(true);
                ffVar.i(true);
                ffVar.d(false);
                ffVar.g(false);
                int dimens = BdUtilHelper.getDimens(baseFragmentActivity, R.dimen.tbds3);
                int dimens2 = BdUtilHelper.getDimens(baseFragmentActivity, R.dimen.tbds3);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final float abs = Math.abs(view2.getRight() - view2.getLeft()) / 2;
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = new ObjectAnimator();
                ffVar.a(new c(str, objectRef, dimens, dimens2));
                ffVar.h(new b(objectRef, objectRef2, abs));
                final ef b2 = ffVar.b();
                b2.k(false);
                b2.l(true);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ii9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ji9.f(ef.this, baseFragmentActivity, gi9Var, objectRef2, objectRef, abs);
                        }
                    }
                }, 1000L);
            }
        }
    }

    public static final void f(final ef efVar, BaseFragmentActivity baseFragmentActivity, final gi9 gi9Var, final Ref.ObjectRef shakeAnim, final Ref.ObjectRef contentView, final float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{efVar, baseFragmentActivity, gi9Var, shakeAnim, contentView, Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(shakeAnim, "$shakeAnim");
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            efVar.n(baseFragmentActivity, true);
            if (gi9Var != null) {
                gi9Var.onShow();
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.hi9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ji9.g(Ref.ObjectRef.this, contentView, efVar, gi9Var, f);
                    }
                }
            }, 4000L);
        }
    }

    public static final void g(Ref.ObjectRef shakeAnim, Ref.ObjectRef contentView, ef efVar, gi9 gi9Var, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{shakeAnim, contentView, efVar, gi9Var, Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(shakeAnim, "$shakeAnim");
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            ((ObjectAnimator) shakeAnim.element).cancel();
            View view2 = (View) contentView.element;
            if (view2 != null) {
                ValueAnimator b2 = a.b(view2, 1.0f, 0.0f, f, 0.0f, 250L);
                b2.addListener(new d(efVar, gi9Var));
                b2.start();
                return;
            }
            if (efVar != null) {
                efVar.d();
            }
            if (gi9Var != null) {
                gi9Var.onDismiss();
            }
        }
    }

    public final ValueAnimator b(View curView, float f, float f2, float f3, float f4, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{curView, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(curView, "curView");
            ValueAnimator sclevalue = ValueAnimator.ofFloat(f, f2);
            sclevalue.setDuration(j);
            sclevalue.addUpdateListener(new a(curView, f3, f4));
            Intrinsics.checkNotNullExpressionValue(sclevalue, "sclevalue");
            return sclevalue;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }
}
