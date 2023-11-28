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
import com.baidu.tieba.jo8;
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
public final class io8 {
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
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ViewGroup c;
    public ho8 d;
    public fo8 e;
    public fo8 f;
    public jo8 g;
    public boolean h;
    public boolean i;
    public mo8 j;

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-711970439, "Lcom/baidu/tieba/io8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-711970439, "Lcom/baidu/tieba/io8$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860343, "Lcom/baidu/tieba/io8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860343, "Lcom/baidu/tieba/io8;");
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
    public static final class c implements ko8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(io8 io8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io8Var};
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
    public static final class d implements jo8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io8 a;

        public d(io8 io8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = io8Var;
        }

        @Override // com.baidu.tieba.jo8.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i = false;
            ho8 ho8Var = this.a.d;
            if (ho8Var != null) {
                ho8Var.h();
            }
            mo8 mo8Var = this.a.j;
            if (mo8Var != null) {
                mo8Var.f();
            }
        }

        @Override // com.baidu.tieba.jo8.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.i = true;
                if (TbSingleton.getInstance().getKeyboardHeight() != 0) {
                    Context context = this.a.a;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    }
                    if (i > go8.b(context) / 2) {
                        i = TbSingleton.getInstance().getKeyboardHeight();
                    }
                }
                a aVar = io8.k;
                io8.l = i;
                ho8 ho8Var = this.a.d;
                if (ho8Var != null) {
                    ho8Var.e();
                }
                mo8 mo8Var = this.a.j;
                if (mo8Var != null) {
                    mo8Var.b(i);
                }
                ho8 ho8Var2 = this.a.d;
                if (ho8Var2 != null) {
                    a aVar2 = io8.k;
                    io8.m = ho8Var2.s();
                }
                fo8 fo8Var = this.a.e;
                if (fo8Var != null) {
                    a aVar3 = io8.k;
                    io8.n = fo8Var.s();
                }
                fo8 fo8Var2 = this.a.f;
                if (fo8Var2 != null) {
                    a aVar4 = io8.k;
                    io8.o = fo8Var2.s();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    public io8() {
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

    public final io8 g(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (io8) invokeL.objValue;
    }

    public final <P extends ho8> io8 h(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            m = panel.s();
            panel.p2(new c(this));
            panel.y(new uoc() { // from class: com.baidu.tieba.do8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.uoc
                public final void b(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        io8.i(io8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (io8) invokeL.objValue;
    }

    public final io8 l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (io8) invokeL.objValue;
    }

    public final io8 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            l = i;
            if (m == 0) {
                m = i;
            }
            return this;
        }
        return (io8) invokeI.objValue;
    }

    public final io8 n(mo8 mo8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mo8Var)) == null) {
            this.j = mo8Var;
            return this;
        }
        return (io8) invokeL.objValue;
    }

    public final io8 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (io8) invokeZ.objValue;
    }

    public static final void i(io8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
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

    public final io8 j(View rootLayout) {
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
            jo8 jo8Var = new jo8(context, rootLayout);
            this.g = jo8Var;
            if (jo8Var != null) {
                jo8Var.b(new d(this));
            }
            return this;
        }
        return (io8) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    @SuppressLint({"ObjectAnimatorBinding"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(PanelType panelType, PanelType panelType2, float f, float f2) {
        int i;
        boolean z;
        boolean z2;
        float f3;
        float f4;
        PanelType panelType3;
        View view2;
        ObjectAnimator ofFloat;
        ho8 ho8Var;
        View view3;
        View view4;
        View view5;
        ho8 ho8Var2;
        Integer num;
        boolean z3;
        Integer num2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ho8 ho8Var3 = this.d;
            if (ho8Var3 != null) {
                i = ho8Var3.A();
            } else {
                i = 0;
            }
            ho8 ho8Var4 = this.d;
            if (ho8Var4 != null) {
                ho8Var4.w2(panelType);
            }
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            View view6 = null;
            if (z) {
                if (f2 == 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ho8 ho8Var5 = this.d;
                    if (ho8Var5 != null) {
                        num2 = Integer.valueOf(ho8Var5.k());
                    } else {
                        num2 = null;
                    }
                    Intrinsics.checkNotNull(num2);
                    if (num2.intValue() == 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        f4 = f;
                        f3 = f2;
                        panelType3 = PanelType.VOICE;
                        if (panelType != panelType3 && (panelType2 != panelType3 || panelType != PanelType.NONE)) {
                            ho8Var2 = this.d;
                            if (ho8Var2 == null) {
                                num = Integer.valueOf(ho8Var2.k());
                            } else {
                                num = null;
                            }
                            Intrinsics.checkNotNull(num);
                            f3 -= num.intValue();
                        }
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
                        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
                        if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
                            if (panelType2 != PanelType.INPUT_KEYBOARD && !this.i) {
                                if (panelType2 != PanelType.NONE && panelType2 != PanelType.VOICE) {
                                    if (panelType2 == PanelType.INPUTCHANGE) {
                                        ho8 ho8Var6 = this.d;
                                        if (ho8Var6 != null) {
                                            view5 = ho8Var6.C();
                                        } else {
                                            view5 = null;
                                        }
                                        ofFloat = ObjectAnimator.ofFloat(view5, Key.TRANSLATION_Y, f, 0.0f);
                                    } else {
                                        ofFloat = null;
                                    }
                                } else {
                                    ho8 ho8Var7 = this.d;
                                    if (ho8Var7 != null) {
                                        view4 = ho8Var7.C();
                                    } else {
                                        view4 = null;
                                    }
                                    ofFloat = ObjectAnimator.ofFloat(view4, Key.TRANSLATION_Y, f, f);
                                }
                            } else {
                                ho8 ho8Var8 = this.d;
                                if (ho8Var8 != null) {
                                    view3 = ho8Var8.C();
                                } else {
                                    view3 = null;
                                }
                                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, Key.TRANSLATION_Y, f, 0.0f);
                                ofFloat2 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3 + i);
                                Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(bodyLayout,\n    …lue\n                    )");
                                ofFloat = ofFloat3;
                            }
                        } else {
                            ho8 ho8Var9 = this.d;
                            if (ho8Var9 != null) {
                                view2 = ho8Var9.C();
                            } else {
                                view2 = null;
                            }
                            ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f, f2);
                        }
                        ho8Var = this.d;
                        if (ho8Var != null) {
                            view6 = ho8Var.A2();
                        }
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
                        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(0L);
                        animatorSet.setInterpolator(new DecelerateInterpolator());
                        if (this.h) {
                            if (panelType == PanelType.INPUT_KEYBOARD) {
                                if (panelType2 == PanelType.EXPRESSION) {
                                    animatorSet.play(ofFloat).with(ofFloat4).with(ofFloat2);
                                } else {
                                    animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat4);
                                }
                            } else if (panelType == PanelType.INPUTCHANGE) {
                                animatorSet.play(ofFloat2);
                            } else if (panelType == PanelType.EXPRESSION) {
                                animatorSet.play(ofFloat2).with(ofFloat);
                            } else {
                                animatorSet.play(ofFloat).with(ofFloat2);
                            }
                        } else {
                            animatorSet.play(ofFloat);
                        }
                        animatorSet.addListener(new e());
                        animatorSet.start();
                    }
                }
            }
            if (i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((z2 || panelType == PanelType.INPUTCHANGE) && panelType != PanelType.VOICE) {
                f3 = f2 + i;
                f4 = f;
                panelType3 = PanelType.VOICE;
                if (panelType != panelType3) {
                    ho8Var2 = this.d;
                    if (ho8Var2 == null) {
                    }
                    Intrinsics.checkNotNull(num);
                    f3 -= num.intValue();
                }
                ObjectAnimator ofFloat22 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
                Intrinsics.checkNotNullExpressionValue(ofFloat22, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
                if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
                }
                ho8Var = this.d;
                if (ho8Var != null) {
                }
                ObjectAnimator ofFloat42 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
                Intrinsics.checkNotNullExpressionValue(ofFloat42, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(0L);
                animatorSet2.setInterpolator(new DecelerateInterpolator());
                if (this.h) {
                }
                animatorSet2.addListener(new e());
                animatorSet2.start();
            }
            f4 = f + i;
            f3 = f2;
            panelType3 = PanelType.VOICE;
            if (panelType != panelType3) {
            }
            ObjectAnimator ofFloat222 = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f4, f3);
            Intrinsics.checkNotNullExpressionValue(ofFloat222, "ofFloat(bodyLayout,\n    …rollBodyToValue\n        )");
            if (b.$EnumSwitchMapping$0[panelType.ordinal()] == 1) {
            }
            ho8Var = this.d;
            if (ho8Var != null) {
            }
            ObjectAnimator ofFloat422 = ObjectAnimator.ofFloat(view6, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat422, "ofFloat(inputPanel?.getS…onY\", fromValue, toValue)");
            AnimatorSet animatorSet22 = new AnimatorSet();
            animatorSet22.setDuration(0L);
            animatorSet22.setInterpolator(new DecelerateInterpolator());
            if (this.h) {
            }
            animatorSet22.addListener(new e());
            animatorSet22.start();
        }
    }
}
