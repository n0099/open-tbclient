package com.baidu.tieba;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.ArrowView;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.nadcore.widget.bubble.shadow.MaskViewGroup;
import com.baidu.tieba.ld1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public View b;
    public View c;
    public ViewGroup d;
    public TextView e;
    public MaskViewGroup f;
    public ArrowView g;
    public ArrowView h;
    public ArrowView i;
    public ArrowView j;
    public ArrowView k;
    public View l;
    public View m;
    @ColorInt
    public int n;
    public kd1 o;

    public abstract int e();

    public void x(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ld1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Resources a;
        public final /* synthetic */ xc1 b;

        @Override // com.baidu.tieba.ld1.a
        public void a(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, textView, motionEvent) == null) {
            }
        }

        public a(xc1 xc1Var, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc1Var, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xc1Var;
            this.a = resources;
        }

        @Override // com.baidu.tieba.ld1.a
        public void b(TextView textView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.b.e.setLinkTextColor(this.a.getColor(R.color.nad_bubble_link_text_color));
                } else {
                    this.b.e.setLinkTextColor(this.a.getColorStateList(R.color.nad_home_tab_bubble_tips_text_color));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-293823963, "Lcom/baidu/tieba/xc1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-293823963, "Lcom/baidu/tieba/xc1$b;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            a = iArr;
            try {
                iArr[BubblePosition.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubblePosition.UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubblePosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubblePosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BubblePosition.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public xc1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.c;
            if (view2 != null) {
                return view2.getClass().getSimpleName();
            }
            return "NULL";
        }
        return (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.n;
            if (i != -1) {
                return i;
            }
            return rj0.b().getResources().getColor(R.color.NAD_UC29);
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c != null && this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.c != null && this.a != null && this.b != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (viewGroup = this.a) != null && this.b != null && this.l != null) {
            viewGroup.removeView(this.m);
        }
    }

    public void l() {
        ViewGroup viewGroup;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (viewGroup = this.a) != null && this.b != null && (view2 = this.l) != null) {
            viewGroup.removeView(view2);
        }
    }

    public void m() {
        ViewGroup viewGroup;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (viewGroup = this.a) != null && (view2 = this.b) != null && this.l != null) {
            viewGroup.removeView(view2);
        }
    }

    public void o() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (view2 = this.m) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.height = 0;
            this.m.setLayoutParams(layoutParams);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.m != null) {
            oc1.a().b("——>checksafe anchor layer begin");
            a(this.m);
            oc1.a().b("——>checksafe anchor layer end");
            this.a.addView(this.m);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.l != null) {
            oc1.a().b("——>check bg view begin");
            a(this.l);
            oc1.a().b("——>check bg view end");
            this.a.addView(this.l);
        }
    }

    public void A(int[] iArr) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) && (view2 = this.b) != null) {
            view2.setX(iArr[0]);
            this.b.setY(iArr[1]);
            this.d.setVisibility(0);
            this.b.setVisibility(0);
            this.g.setVisibility(0);
            this.l.setVisibility(0);
            MaskViewGroup maskViewGroup = this.f;
            if (maskViewGroup != null) {
                maskViewGroup.setVisibility(0);
            }
        }
    }

    public void a(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
            oc1.a().b("——>checkSafe remove view end");
        }
    }

    public void j(Runnable runnable) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) && (view2 = this.c) != null) {
            view2.post(runnable);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) && (view2 = this.m) != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) && (view2 = this.l) != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void v(View.OnClickListener onClickListener) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) && (view2 = this.b) != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public void w(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.n = i;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Resources resources = rj0.b().getResources();
            this.e.setLinkTextColor(resources.getColorStateList(R.color.nad_home_tab_bubble_tips_text_color));
            this.e.setHighlightColor(0);
            ld1 ld1Var = new ld1();
            ld1Var.a(new a(this, resources));
            this.e.setMovementMethod(ld1Var);
            if (this.o == null) {
                this.o = new kd1(this.e);
            }
            this.e.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        }
    }

    public void y() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (view2 = this.m) != null && this.c != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = this.c.getMeasuredWidth();
            layoutParams.height = this.c.getMeasuredHeight();
            this.m.setLayoutParams(layoutParams);
            int[] iArr = new int[2];
            this.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.a.getLocationOnScreen(iArr2);
            this.m.setX(iArr[0] - iArr2[0]);
            this.m.setY(iArr[1] - iArr2[1]);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b != null) {
                return false;
            }
            View inflate = LayoutInflater.from(this.c.getContext()).inflate(e(), this.a, false);
            this.b = inflate;
            inflate.setVisibility(4);
            this.d = (ViewGroup) this.b.findViewById(R.id.bubble_content);
            this.f = (MaskViewGroup) this.b.findViewById(R.id.shadowLayout);
            this.h = (ArrowView) this.b.findViewById(R.id.bubble_arrow_up);
            this.i = (ArrowView) this.b.findViewById(R.id.bubble_arrow_down);
            this.j = (ArrowView) this.b.findViewById(R.id.bubble_arrow_left);
            this.k = (ArrowView) this.b.findViewById(R.id.bubble_arrow_right);
            int d = d();
            MaskViewGroup maskViewGroup = this.f;
            if (maskViewGroup != null) {
                maskViewGroup.setShadowColor(d);
            }
            if (this.d.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.d.getBackground()).setColor(d);
            }
            this.d.setVisibility(4);
            this.h.setArrowViewColor(d);
            this.i.setArrowViewColor(d);
            this.j.setArrowViewColor(d);
            this.k.setArrowViewColor(d);
            View view2 = new View(this.c.getContext());
            this.l = view2;
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.l.setVisibility(4);
            this.m = new View(this.c.getContext());
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.o != null && (textView = this.e) != null) {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this.o);
                this.o = null;
            }
            this.a = null;
            this.b = null;
            this.d = null;
            this.g = null;
            this.e = null;
            this.c = null;
            this.h = null;
            this.i = null;
            this.l = null;
            this.m = null;
            this.f = null;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.b != null) {
            oc1.a().b("——>check bubble view begin");
            a(this.b);
            oc1.a().b("——>check bubble view end");
            this.b.setVisibility(4);
            this.a.addView(this.b);
        }
    }

    public void s(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view2, viewGroup) == null) {
            if (view2 != null) {
                this.c = view2;
                this.a = viewGroup;
                if (viewGroup == null && view2 != null) {
                    ViewGroup viewGroup2 = (ViewGroup) view2.getRootView().findViewById(16908290);
                    this.a = viewGroup2;
                    if (viewGroup2 == null) {
                        throw new IllegalArgumentException("root view must be a child of android.R.id.content");
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("anchor view must not be null !!!");
        }
    }

    public void z(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bubblePosition) == null) {
            b();
            int i = b.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.k.setDirection(3);
                            this.g = this.k;
                            return;
                        }
                        return;
                    }
                    this.j.setDirection(1);
                    ArrowView arrowView = this.j;
                    this.g = arrowView;
                    if (Build.VERSION.SDK_INT <= 25) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin - ((int) arrowView.a(1.0f)), marginLayoutParams.bottomMargin);
                        this.g.setLayoutParams(marginLayoutParams);
                        return;
                    }
                    return;
                }
                this.i.setDirection(4);
                this.g = this.i;
                return;
            }
            this.h.setDirection(2);
            ArrowView arrowView2 = this.h;
            this.g = arrowView2;
            if (Build.VERSION.SDK_INT <= 25) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin - ((int) arrowView2.a(1.0f)));
                this.g.setLayoutParams(marginLayoutParams2);
            }
        }
    }
}
