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
/* loaded from: classes9.dex */
public final class zr8 {
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
    public yr8 d;
    public vr8 e;
    public vr8 f;
    public as8 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public cs8 k;

    /* loaded from: classes9.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-222504309, "Lcom/baidu/tieba/zr8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-222504309, "Lcom/baidu/tieba/zr8$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948369673, "Lcom/baidu/tieba/zr8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948369673, "Lcom/baidu/tieba/zr8;");
                return;
            }
        }
        l = new a(null);
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static final class c implements bs8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(zr8 zr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr8Var};
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

    /* loaded from: classes9.dex */
    public static final class d implements cs8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr8 a;

        public d(zr8 zr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr8Var;
        }

        @Override // com.baidu.tieba.cs8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = zr8.l;
                zr8.q = false;
                yr8 yr8Var = this.a.d;
                if (yr8Var != null) {
                    yr8Var.h();
                }
                yr8 yr8Var2 = this.a.d;
                if (yr8Var2 != null) {
                    a aVar2 = zr8.l;
                    zr8.n = yr8Var2.s();
                    a aVar3 = zr8.l;
                    zr8.s = yr8Var2.k();
                }
                cs8 cs8Var = this.a.k;
                if (cs8Var != null) {
                    cs8Var.a();
                }
            }
        }

        @Override // com.baidu.tieba.cs8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a aVar = zr8.l;
                zr8.q = true;
                a aVar2 = zr8.l;
                zr8.m = i;
                this.a.j = true;
                yr8 yr8Var = this.a.d;
                if (yr8Var != null) {
                    yr8Var.e();
                }
                cs8 cs8Var = this.a.k;
                if (cs8Var != null) {
                    cs8Var.b(i);
                }
                yr8 yr8Var2 = this.a.d;
                if (yr8Var2 != null) {
                    a aVar3 = zr8.l;
                    zr8.n = yr8Var2.s();
                    a aVar4 = zr8.l;
                    zr8.s = yr8Var2.k();
                }
                vr8 vr8Var = this.a.e;
                if (vr8Var != null) {
                    a aVar5 = zr8.l;
                    zr8.o = vr8Var.s();
                }
                vr8 vr8Var2 = this.a.f;
                if (vr8Var2 != null) {
                    a aVar6 = zr8.l;
                    zr8.p = vr8Var2.s();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr8 a;

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

        public e(zr8 zr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr8Var;
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
                vr8 vr8Var = this.a.e;
                if (vr8Var != null) {
                    ((ViewGroup) vr8Var).requestLayout();
                }
                vr8 vr8Var2 = this.a.f;
                if (vr8Var2 != null) {
                    ((ViewGroup) vr8Var2).requestLayout();
                }
            }
        }
    }

    public zr8() {
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
            as8 as8Var = this.g;
            if (as8Var != null) {
                as8Var.b();
            }
        }
    }

    public final zr8 g(ViewGroup bodyLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bodyLayout)) == null) {
            Intrinsics.checkNotNullParameter(bodyLayout, "bodyLayout");
            this.c = bodyLayout;
            return this;
        }
        return (zr8) invokeL.objValue;
    }

    public final <P extends yr8> zr8 h(P panel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, panel)) == null) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.d = panel;
            n = panel.s();
            panel.b2(new c(this));
            panel.y(new uoc() { // from class: com.baidu.tieba.tr8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.uoc
                public final void b(Object obj, Object obj2, Object obj3, Object obj4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, obj, obj2, obj3, obj4) == null) {
                        zr8.i(zr8.this, (PanelType) obj, (PanelType) obj2, (Float) obj3, (Float) obj4);
                    }
                }
            });
            return this;
        }
        return (zr8) invokeL.objValue;
    }

    public final zr8 l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
            return this;
        }
        return (zr8) invokeL.objValue;
    }

    public final zr8 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            m = i;
            if (n == 0) {
                n = i;
            }
            return this;
        }
        return (zr8) invokeI.objValue;
    }

    public final zr8 p(cs8 cs8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cs8Var)) == null) {
            this.k = cs8Var;
            return this;
        }
        return (zr8) invokeL.objValue;
    }

    public final zr8 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (zr8) invokeZ.objValue;
    }

    public static final void i(zr8 this$0, PanelType panelType, PanelType lastPanelType, Float fromValue, Float toValue) {
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

    public final zr8 j(View rootLayout) {
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
            as8 as8Var = new as8(context, rootLayout);
            this.g = as8Var;
            if (as8Var != null) {
                as8Var.c(new d(this));
            }
            return this;
        }
        return (zr8) invokeL.objValue;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void k(PanelType panelType, PanelType panelType2, float f, float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{panelType, panelType2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, Key.TRANSLATION_Y, f, f2);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(bodyLayout, \"tra…onY\", fromValue, toValue)");
            yr8 yr8Var = this.d;
            ObjectAnimator objectAnimator = null;
            if (yr8Var != null) {
                view2 = yr8Var.C();
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
                            vr8 vr8Var = this.e;
                            if (vr8Var != null) {
                                vr8Var.reset();
                            }
                            objectAnimator = ObjectAnimator.ofFloat(this.f, Key.TRANSLATION_Y, f, f2);
                        }
                    } else {
                        vr8 vr8Var2 = this.f;
                        if (vr8Var2 != null) {
                            vr8Var2.reset();
                        }
                        objectAnimator = ObjectAnimator.ofFloat(this.e, Key.TRANSLATION_Y, f, f2);
                    }
                } else {
                    vr8 vr8Var3 = this.e;
                    if (vr8Var3 != null) {
                        vr8Var3.reset();
                    }
                    vr8 vr8Var4 = this.f;
                    if (vr8Var4 != null) {
                        vr8Var4.reset();
                    }
                }
            } else {
                vr8 vr8Var5 = this.e;
                if (vr8Var5 != null) {
                    vr8Var5.reset();
                }
                vr8 vr8Var6 = this.f;
                if (vr8Var6 != null) {
                    vr8Var6.reset();
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
