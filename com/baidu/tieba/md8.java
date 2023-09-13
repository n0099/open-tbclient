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
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public final class md8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a l;
    @JvmField
    public static int m;
    @JvmField
    public static int n;
    @JvmField
    public static int o;
    @JvmField
    public static int p;
    @JvmField
    public static boolean q;
    @JvmField
    public static int r;
    @JvmField
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ViewGroup c;
    public ld8 d;
    public id8 e;
    public id8 f;
    public nd8 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public pd8 k;

    /* loaded from: classes7.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607612566, "Lcom/baidu/tieba/md8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-607612566, "Lcom/baidu/tieba/md8$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947968936, "Lcom/baidu/tieba/md8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947968936, "Lcom/baidu/tieba/md8;");
                return;
            }
        }
        l = new a(null);
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static final class c implements od8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(md8 md8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md8Var};
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

    /* loaded from: classes7.dex */
    public static final class d implements pd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md8 a;

        public d(md8 md8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md8Var;
        }

        @Override // com.baidu.tieba.pd8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                a aVar = md8.l;
                md8.q = true;
                a aVar2 = md8.l;
                md8.m = i;
                this.a.j = true;
                ld8 ld8Var = this.a.d;
                if (ld8Var != null) {
                    ld8Var.g0();
                }
                pd8 pd8Var = this.a.k;
                if (pd8Var != null) {
                    pd8Var.a(i);
                }
                ld8 ld8Var2 = this.a.d;
                if (ld8Var2 != null) {
                    a aVar3 = md8.l;
                    md8.n = ld8Var2.K0();
                    a aVar4 = md8.l;
                    md8.s = ld8Var2.N();
                }
                id8 id8Var = this.a.e;
                if (id8Var != null) {
                    a aVar5 = md8.l;
                    md8.o = id8Var.K0();
                }
                id8 id8Var2 = this.a.f;
                if (id8Var2 != null) {
                    a aVar6 = md8.l;
                    md8.p = id8Var2.K0();
                }
            }
        }

        @Override // com.baidu.tieba.pd8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = md8.l;
                md8.q = false;
                ld8 ld8Var = this.a.d;
                if (ld8Var != null) {
                    ld8Var.n1();
                }
                ld8 ld8Var2 = this.a.d;
                if (ld8Var2 != null) {
                    a aVar2 = md8.l;
                    md8.n = ld8Var2.K0();
                    a aVar3 = md8.l;
                    md8.s = ld8Var2.N();
                }
                pd8 pd8Var = this.a.k;
                if (pd8Var != null) {
                    pd8Var.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md8 a;

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

        public e(md8 md8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md8Var;
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
                id8 id8Var = this.a.e;
                if (id8Var != null) {
                    ((ViewGroup) id8Var).requestLayout();
                }
                id8 id8Var2 = this.a.f;
                if (id8Var2 != null) {
                    ((ViewGroup) id8Var2).requestLayout();
                }
            }
        }
    }

    public md8() {
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

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = false;
            nd8 nd8Var = this.g;
            if (nd8Var != null) {
                nd8Var.b();
            }
        }
    }

    public final md8 g(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (md8) invokeL.objValue;
    }

    public final <P extends ld8> md8 h(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            n = panel.K0();
            panel.x1(new c(this));
            panel.p1(new ibc() { // from class: com.baidu.tieba.gd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ibc
                public final void call(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        md8.i(md8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (md8) invokeL.objValue;
    }

    public final md8 l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (md8) invokeL.objValue;
    }

    public final md8 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            m = i;
            if (n == 0) {
                n = i;
            }
            return this;
        }
        return (md8) invokeI.objValue;
    }

    public final md8 p(pd8 pd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pd8Var)) == null) {
            this.k = pd8Var;
            return this;
        }
        return (md8) invokeL.objValue;
    }

    public final md8 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (md8) invokeZ.objValue;
    }

    public static final void i(md8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, this$0, panelType, lastPanelType, fromValue, toValue) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(panelType, "panelType");
            Intrinsics.checkNotNullExpressionValue(lastPanelType, "lastPanelType");
            Intrinsics.checkNotNullExpressionValue(fromValue, "fromValue");
            float floatValue = fromValue.floatValue();
            Intrinsics.checkNotNullExpressionValue(toValue, "toValue");
            this$0.k(panelType, lastPanelType, floatValue, toValue.floatValue());
        }
    }

    public final md8 j(View rootLayout) {
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
            nd8 nd8Var = new nd8(context, rootLayout);
            this.g = nd8Var;
            if (nd8Var != null) {
                nd8Var.c(new d(this));
            }
            return this;
        }
        return (md8) invokeL.objValue;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void k(PanelType panelType, PanelType panelType2, float f, float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(bodyLayout, \"tra…onY\", fromValue, toValue)");
            ld8 ld8Var = this.d;
            ObjectAnimator objectAnimator = null;
            if (ld8Var != null) {
                view2 = ld8Var.D1();
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
                            id8 id8Var = this.e;
                            if (id8Var != null) {
                                id8Var.reset();
                            }
                            objectAnimator = ObjectAnimator.ofFloat(this.f, Key.TRANSLATION_Y, f, f2);
                        }
                    } else {
                        id8 id8Var2 = this.f;
                        if (id8Var2 != null) {
                            id8Var2.reset();
                        }
                        objectAnimator = ObjectAnimator.ofFloat(this.e, Key.TRANSLATION_Y, f, f2);
                    }
                } else {
                    id8 id8Var3 = this.e;
                    if (id8Var3 != null) {
                        id8Var3.reset();
                    }
                    id8 id8Var4 = this.f;
                    if (id8Var4 != null) {
                        id8Var4.reset();
                    }
                }
            } else {
                id8 id8Var5 = this.e;
                if (id8Var5 != null) {
                    id8Var5.reset();
                }
                id8 id8Var6 = this.f;
                if (id8Var6 != null) {
                    id8Var6.reset();
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(0L);
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
