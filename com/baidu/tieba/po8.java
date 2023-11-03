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
public final class po8 {
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
    public oo8 d;
    public lo8 e;
    public lo8 f;
    public qo8 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public so8 k;

    /* loaded from: classes7.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-511566382, "Lcom/baidu/tieba/po8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-511566382, "Lcom/baidu/tieba/po8$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068880, "Lcom/baidu/tieba/po8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068880, "Lcom/baidu/tieba/po8;");
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
    public static final class c implements ro8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(po8 po8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po8Var};
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
    public static final class d implements so8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po8 a;

        public d(po8 po8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po8Var;
        }

        @Override // com.baidu.tieba.so8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = po8.l;
                po8.q = false;
                oo8 oo8Var = this.a.d;
                if (oo8Var != null) {
                    oo8Var.x();
                }
                oo8 oo8Var2 = this.a.d;
                if (oo8Var2 != null) {
                    a aVar2 = po8.l;
                    po8.n = oo8Var2.q();
                    a aVar3 = po8.l;
                    po8.s = oo8Var2.h();
                }
                so8 so8Var = this.a.k;
                if (so8Var != null) {
                    so8Var.a();
                }
            }
        }

        @Override // com.baidu.tieba.so8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a aVar = po8.l;
                po8.q = true;
                a aVar2 = po8.l;
                po8.m = i;
                this.a.j = true;
                oo8 oo8Var = this.a.d;
                if (oo8Var != null) {
                    oo8Var.n();
                }
                so8 so8Var = this.a.k;
                if (so8Var != null) {
                    so8Var.b(i);
                }
                oo8 oo8Var2 = this.a.d;
                if (oo8Var2 != null) {
                    a aVar3 = po8.l;
                    po8.n = oo8Var2.q();
                    a aVar4 = po8.l;
                    po8.s = oo8Var2.h();
                }
                lo8 lo8Var = this.a.e;
                if (lo8Var != null) {
                    a aVar5 = po8.l;
                    po8.o = lo8Var.q();
                }
                lo8 lo8Var2 = this.a.f;
                if (lo8Var2 != null) {
                    a aVar6 = po8.l;
                    po8.p = lo8Var2.q();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po8 a;

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

        public e(po8 po8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po8Var;
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
                lo8 lo8Var = this.a.e;
                if (lo8Var != null) {
                    ((ViewGroup) lo8Var).requestLayout();
                }
                lo8 lo8Var2 = this.a.f;
                if (lo8Var2 != null) {
                    ((ViewGroup) lo8Var2).requestLayout();
                }
            }
        }
    }

    public po8() {
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
            qo8 qo8Var = this.g;
            if (qo8Var != null) {
                qo8Var.b();
            }
        }
    }

    public final po8 g(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (po8) invokeL.objValue;
    }

    public final <P extends oo8> po8 h(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            n = panel.q();
            panel.P1(new c(this));
            panel.y(new yjc() { // from class: com.baidu.tieba.jo8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.yjc
                public final void b(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        po8.i(po8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (po8) invokeL.objValue;
    }

    public final po8 l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (po8) invokeL.objValue;
    }

    public final po8 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            m = i;
            if (n == 0) {
                n = i;
            }
            return this;
        }
        return (po8) invokeI.objValue;
    }

    public final po8 p(so8 so8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, so8Var)) == null) {
            this.k = so8Var;
            return this;
        }
        return (po8) invokeL.objValue;
    }

    public final po8 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (po8) invokeZ.objValue;
    }

    public static final void i(po8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
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

    public final po8 j(View rootLayout) {
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
            qo8 qo8Var = new qo8(context, rootLayout);
            this.g = qo8Var;
            if (qo8Var != null) {
                qo8Var.c(new d(this));
            }
            return this;
        }
        return (po8) invokeL.objValue;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void k(PanelType panelType, PanelType panelType2, float f, float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(bodyLayout, \"tra…onY\", fromValue, toValue)");
            oo8 oo8Var = this.d;
            ObjectAnimator objectAnimator = null;
            if (oo8Var != null) {
                view2 = oo8Var.C();
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
                            lo8 lo8Var = this.e;
                            if (lo8Var != null) {
                                lo8Var.reset();
                            }
                            objectAnimator = ObjectAnimator.ofFloat(this.f, Key.TRANSLATION_Y, f, f2);
                        }
                    } else {
                        lo8 lo8Var2 = this.f;
                        if (lo8Var2 != null) {
                            lo8Var2.reset();
                        }
                        objectAnimator = ObjectAnimator.ofFloat(this.e, Key.TRANSLATION_Y, f, f2);
                    }
                } else {
                    lo8 lo8Var3 = this.e;
                    if (lo8Var3 != null) {
                        lo8Var3.reset();
                    }
                    lo8 lo8Var4 = this.f;
                    if (lo8Var4 != null) {
                        lo8Var4.reset();
                    }
                }
            } else {
                lo8 lo8Var5 = this.e;
                if (lo8Var5 != null) {
                    lo8Var5.reset();
                }
                lo8 lo8Var6 = this.f;
                if (lo8Var6 != null) {
                    lo8Var6.reset();
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
