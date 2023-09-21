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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.wd8;
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
/* loaded from: classes8.dex */
public final class vd8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    @JvmField
    public static int k;
    @JvmField
    public static int l;
    @JvmField
    public static int m;
    @JvmField
    public static int n;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ViewGroup c;
    public ud8 d;
    public sd8 e;
    public sd8 f;
    public wd8 g;
    public boolean h;
    public zd8 i;

    /* loaded from: classes8.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-349950207, "Lcom/baidu/tieba/vd8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-349950207, "Lcom/baidu/tieba/vd8$b;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            iArr[PanelType.EXPRESSION.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948237055, "Lcom/baidu/tieba/vd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948237055, "Lcom/baidu/tieba/vd8;");
                return;
            }
        }
        j = new a(null);
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static final class c implements xd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(vd8 vd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd8Var};
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

    /* loaded from: classes8.dex */
    public static final class d implements wd8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd8 a;

        public d(vd8 vd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd8Var;
        }

        @Override // com.baidu.tieba.wd8.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ud8 ud8Var = this.a.d;
                if (ud8Var != null) {
                    ud8Var.r();
                }
                zd8 zd8Var = this.a.i;
                if (zd8Var != null) {
                    zd8Var.g();
                }
            }
        }

        @Override // com.baidu.tieba.wd8.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (TbSingleton.getInstance().getKeyboardHeight() != 0) {
                    Context context = this.a.a;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    }
                    if (i > td8.b(context) / 2) {
                        i = TbSingleton.getInstance().getKeyboardHeight();
                    }
                }
                a aVar = vd8.j;
                vd8.k = i;
                ud8 ud8Var = this.a.d;
                if (ud8Var != null) {
                    ud8Var.l();
                }
                zd8 zd8Var = this.a.i;
                if (zd8Var != null) {
                    zd8Var.b(i);
                }
                ud8 ud8Var2 = this.a.d;
                if (ud8Var2 != null) {
                    a aVar2 = vd8.j;
                    vd8.l = ud8Var2.n();
                }
                sd8 sd8Var = this.a.e;
                if (sd8Var != null) {
                    a aVar3 = vd8.j;
                    vd8.m = sd8Var.n();
                }
                sd8 sd8Var2 = this.a.f;
                if (sd8Var2 != null) {
                    a aVar4 = vd8.j;
                    vd8.n = sd8Var2.n();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
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

        public e() {
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

    public vd8() {
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

    public final vd8 f(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (vd8) invokeL.objValue;
    }

    public final <P extends ud8> vd8 g(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            l = panel.n();
            panel.M1(new c(this));
            panel.s(new adc() { // from class: com.baidu.tieba.qd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.adc
                public final void call(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        vd8.h(vd8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (vd8) invokeL.objValue;
    }

    public final vd8 k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (vd8) invokeL.objValue;
    }

    public final vd8 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            k = i;
            if (l == 0) {
                l = i;
            }
            return this;
        }
        return (vd8) invokeI.objValue;
    }

    public final vd8 m(zd8 zd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zd8Var)) == null) {
            this.i = zd8Var;
            return this;
        }
        return (vd8) invokeL.objValue;
    }

    public final vd8 n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (vd8) invokeZ.objValue;
    }

    public static final void h(vd8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
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

    public final vd8 i(View rootLayout) {
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
            wd8 wd8Var = new wd8(context, rootLayout);
            this.g = wd8Var;
            if (wd8Var != null) {
                wd8Var.b(new d(this));
            }
            return this;
        }
        return (vd8) invokeL.objValue;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void j(PanelType panelType, PanelType panelType2, float f, float f2) {
        int i;
        boolean z;
        float f3;
        float f4;
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ud8 ud8Var = this.d;
            if (ud8Var != null) {
                i = ud8Var.u();
            } else {
                i = 0;
            }
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f4 = i + f2;
                f3 = f;
            } else {
                f3 = i + f;
                f4 = f2;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f3, f4);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(\n               …ToValue\n                )");
            ud8 ud8Var2 = this.d;
            ObjectAnimator objectAnimator = null;
            View view4 = null;
            View view5 = null;
            if (ud8Var2 != null) {
                view2 = ud8Var2.y();
            } else {
                view2 = null;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(inputPanel?.getV…onY\", fromValue, toValue)");
            ud8 ud8Var3 = this.d;
            if (ud8Var3 != null) {
                view3 = ud8Var3.W1();
            } else {
                view3 = null;
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
            if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
                if (panelType2 == PanelType.INPUT_KEYBOARD) {
                    ud8 ud8Var4 = this.d;
                    if (ud8Var4 != null) {
                        view4 = ud8Var4.y();
                    }
                    objectAnimator = ObjectAnimator.ofFloat(view4, Key.TRANSLATION_Y, f2, f);
                } else {
                    ud8 ud8Var5 = this.d;
                    if (ud8Var5 != null) {
                        view5 = ud8Var5.y();
                    }
                    objectAnimator = ObjectAnimator.ofFloat(view5, Key.TRANSLATION_Y, f, f);
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(0L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            if (objectAnimator == null) {
                if (this.h) {
                    if (panelType2 == PanelType.EXPRESSION) {
                        if (panelType == PanelType.INPUT_KEYBOARD) {
                            animatorSet.play(ofFloat2).with(ofFloat3);
                        } else {
                            animatorSet.play(ofFloat2).with(ofFloat).with(ofFloat3);
                        }
                    } else {
                        animatorSet.play(ofFloat2).with(ofFloat).with(ofFloat3);
                    }
                } else {
                    animatorSet.play(ofFloat2);
                }
            } else if (this.h) {
                if (panelType2 == PanelType.NONE) {
                    animatorSet.play(ofFloat).with(objectAnimator);
                } else {
                    animatorSet.play(objectAnimator);
                }
            }
            animatorSet.addListener(new e());
            animatorSet.start();
        }
    }
}
