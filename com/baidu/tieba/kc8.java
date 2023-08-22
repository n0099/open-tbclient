package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.biz.aibot.keyboardtool.PanelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class kc8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a k;
    @JvmField
    public static int l;
    @JvmField
    public static int m;
    @JvmField
    public static int n;
    @JvmField
    public static int o;
    @JvmField
    public static boolean p;
    @JvmField
    public static int q;
    @JvmField
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ViewGroup c;
    public jc8 d;
    public gc8 e;
    public gc8 f;
    public lc8 g;
    public boolean h;
    public boolean i;
    public nc8 j;

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-665794389, "Lcom/baidu/tieba/kc8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-665794389, "Lcom/baidu/tieba/kc8$b;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            iArr[PanelType.INPUT_KEYBOARD.ordinal()] = 1;
            iArr[PanelType.VOICE.ordinal()] = 2;
            iArr[PanelType.EXPRESSION.ordinal()] = 3;
            iArr[PanelType.PICTURE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908393, "Lcom/baidu/tieba/kc8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908393, "Lcom/baidu/tieba/kc8;");
                return;
            }
        }
        k = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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
    }

    /* loaded from: classes6.dex */
    public static final class c implements mc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements nc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public d(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // com.baidu.tieba.nc8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                a aVar = kc8.k;
                kc8.p = true;
                a aVar2 = kc8.k;
                kc8.l = i;
                jc8 jc8Var = this.a.d;
                if (jc8Var != null) {
                    jc8Var.f0();
                }
                nc8 nc8Var = this.a.j;
                if (nc8Var != null) {
                    nc8Var.a(i);
                }
                jc8 jc8Var2 = this.a.d;
                if (jc8Var2 != null) {
                    a aVar3 = kc8.k;
                    kc8.m = jc8Var2.J0();
                    a aVar4 = kc8.k;
                    kc8.r = jc8Var2.L();
                }
                gc8 gc8Var = this.a.e;
                if (gc8Var != null) {
                    a aVar5 = kc8.k;
                    kc8.n = gc8Var.J0();
                }
                gc8 gc8Var2 = this.a.f;
                if (gc8Var2 != null) {
                    a aVar6 = kc8.k;
                    kc8.o = gc8Var2.J0();
                }
            }
        }

        @Override // com.baidu.tieba.nc8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = kc8.k;
                kc8.p = false;
                jc8 jc8Var = this.a.d;
                if (jc8Var != null) {
                    jc8Var.m1();
                }
                jc8 jc8Var2 = this.a.d;
                if (jc8Var2 != null) {
                    a aVar2 = kc8.k;
                    kc8.m = jc8Var2.J0();
                    a aVar3 = kc8.k;
                    kc8.r = jc8Var2.L();
                }
                nc8 nc8Var = this.a.j;
                if (nc8Var != null) {
                    nc8Var.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public e(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ViewGroup viewGroup = this.a.c;
                if (viewGroup != null) {
                    viewGroup.requestLayout();
                }
                gc8 gc8Var = this.a.e;
                if (gc8Var != null) {
                    ((ViewGroup) gc8Var).requestLayout();
                }
                gc8 gc8Var2 = this.a.f;
                if (gc8Var2 != null) {
                    ((ViewGroup) gc8Var2).requestLayout();
                }
            }
        }
    }

    public kc8() {
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

    public final kc8 f(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (kc8) invokeL.objValue;
    }

    public final <P extends jc8> kc8 g(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            m = panel.J0();
            panel.w1(new c(this));
            panel.o1(new d8c() { // from class: com.baidu.tieba.ec8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.d8c
                public final void call(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        kc8.h(kc8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (kc8) invokeL.objValue;
    }

    public final kc8 k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (kc8) invokeL.objValue;
    }

    public final kc8 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            l = i;
            if (m == 0) {
                m = i;
            }
            return this;
        }
        return (kc8) invokeI.objValue;
    }

    public final kc8 m(nc8 nc8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nc8Var)) == null) {
            this.j = nc8Var;
            return this;
        }
        return (kc8) invokeL.objValue;
    }

    public final kc8 n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (kc8) invokeZ.objValue;
    }

    public static final void h(kc8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, this$0, panelType, lastPanelType, fromValue, toValue) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(panelType, "panelType");
            Intrinsics.checkNotNullExpressionValue(lastPanelType, "lastPanelType");
            Intrinsics.checkNotNullExpressionValue(fromValue, "fromValue");
            float floatValue = fromValue.floatValue();
            Intrinsics.checkNotNullExpressionValue(toValue, "toValue");
            this$0.j(panelType, lastPanelType, floatValue, toValue.floatValue());
        }
    }

    public final kc8 i(View rootLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rootLayout)) == null) {
            Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
            this.b = rootLayout;
            Context context = this.a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            lc8 lc8Var = new lc8(context, rootLayout);
            this.g = lc8Var;
            if (lc8Var != null) {
                lc8Var.b(new d(this));
            }
            return this;
        }
        return (kc8) invokeL.objValue;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void j(PanelType panelType, PanelType panelType2, float f, float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(bodyLayout, \"tra…onY\", fromValue, toValue)");
            jc8 jc8Var = this.d;
            ObjectAnimator objectAnimator = null;
            if (jc8Var != null) {
                view2 = jc8Var.B1();
            } else {
                view2 = null;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(inputPanel?.getV…onY\", fromValue, toValue)");
            int i = b.$EnumSwitchMapping$0[panelType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            gc8 gc8Var = this.e;
                            if (gc8Var != null) {
                                gc8Var.reset();
                            }
                            objectAnimator = ObjectAnimator.ofFloat(this.f, Key.TRANSLATION_Y, f, f2);
                        }
                    } else {
                        gc8 gc8Var2 = this.f;
                        if (gc8Var2 != null) {
                            gc8Var2.reset();
                        }
                        objectAnimator = ObjectAnimator.ofFloat(this.e, Key.TRANSLATION_Y, f, f2);
                    }
                } else {
                    gc8 gc8Var3 = this.e;
                    if (gc8Var3 != null) {
                        gc8Var3.reset();
                    }
                    gc8 gc8Var4 = this.f;
                    if (gc8Var4 != null) {
                        gc8Var4.reset();
                    }
                }
            } else {
                gc8 gc8Var5 = this.e;
                if (gc8Var5 != null) {
                    gc8Var5.reset();
                }
                gc8 gc8Var6 = this.f;
                if (gc8Var6 != null) {
                    gc8Var6.reset();
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(50L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            if (objectAnimator == null) {
                if (this.i) {
                    animatorSet.play(ofFloat);
                } else if (this.h) {
                    animatorSet.play(ofFloat2).with(ofFloat);
                } else {
                    animatorSet.play(ofFloat2);
                }
            } else if (this.h) {
                animatorSet.play(ofFloat2).with(ofFloat).with(objectAnimator);
            } else {
                animatorSet.play(ofFloat2).with(objectAnimator);
            }
            animatorSet.addListener(new e(this));
            animatorSet.start();
        }
    }
}
