package com.baidu.wallet.paysdk.ui.widget.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.OnTabSelectListener;
import com.baidu.wallet.paysdk.ui.widget.tablayout.utils.ResUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class CommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public float D;
    public int E;
    public int F;
    public float G;
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public ValueAnimator N;
    public OvershootInterpolator O;
    public a P;
    public a Q;
    public boolean R;
    public OnTabSelectListener S;

    /* renamed from: a  reason: collision with root package name */
    public Context f26934a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ICustomTabEntity> f26935b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f26936c;

    /* renamed from: d  reason: collision with root package name */
    public int f26937d;

    /* renamed from: e  reason: collision with root package name */
    public int f26938e;

    /* renamed from: f  reason: collision with root package name */
    public int f26939f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f26940g;

    /* renamed from: h  reason: collision with root package name */
    public GradientDrawable f26941h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f26942i;
    public Paint j;
    public Paint k;
    public Path l;
    public int m;
    public float n;
    public boolean o;
    public float p;
    public int q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public long y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f26943a;

        /* renamed from: b  reason: collision with root package name */
        public float f26944b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommonTabLayout f26945c;

        public a(CommonTabLayout commonTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26945c = commonTabLayout;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TypeEvaluator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonTabLayout f26946a;

        public b(CommonTabLayout commonTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26946a = commonTabLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public a evaluate(float f2, a aVar, a aVar2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), aVar, aVar2})) == null) {
                float f3 = aVar.f26943a;
                float f4 = aVar.f26944b;
                float f5 = f4 + (f2 * (aVar2.f26944b - f4));
                a aVar3 = new a(this.f26946a);
                aVar3.f26943a = f3 + ((aVar2.f26943a - f3) * f2);
                aVar3.f26944b = f5;
                return aVar3;
            }
            return (a) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ResUtils.getStyleableIntArray(context, "CommonTabLayout"));
            this.m = obtainStyledAttributes.getInt(ResUtils.styleable(context, "CommonTabLayout", "indicator_style"), 0);
            this.q = obtainStyledAttributes.getColor(ResUtils.styleable(context, "CommonTabLayout", "indicator_color"), Color.parseColor(this.m == 2 ? "#4B6A87" : "#ffffff"));
            int styleable = ResUtils.styleable(context, "CommonTabLayout", "indicator_height");
            int i2 = this.m;
            if (i2 == 1) {
                f2 = 4.0f;
            } else {
                f2 = i2 == 2 ? -1 : 2;
            }
            this.r = obtainStyledAttributes.getDimension(styleable, a(f2));
            this.s = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_width"), a(this.m == 1 ? 10.0f : -1.0f));
            this.t = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_corner_radius"), a(this.m == 2 ? -1.0f : 0.0f));
            this.u = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_margin_left"), a(0.0f));
            this.v = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_margin_top"), a(this.m == 2 ? 7.0f : 0.0f));
            this.w = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_margin_right"), a(0.0f));
            this.x = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "indicator_margin_bottom"), a(this.m != 2 ? 0.0f : 7.0f));
            this.z = obtainStyledAttributes.getBoolean(ResUtils.styleable(context, "CommonTabLayout", "indicator_anim_enable"), true);
            this.A = obtainStyledAttributes.getBoolean(ResUtils.styleable(context, "CommonTabLayout", "indicator_bounce_enable"), true);
            this.y = obtainStyledAttributes.getInt(ResUtils.styleable(context, "CommonTabLayout", "indicator_anim_duration"), -1);
            this.B = obtainStyledAttributes.getInt(ResUtils.styleable(context, "CommonTabLayout", "indicator_gravity"), 80);
            this.C = obtainStyledAttributes.getColor(ResUtils.styleable(context, "CommonTabLayout", "underline_color"), Color.parseColor("#ffffff"));
            this.D = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "underline_height"), a(0.0f));
            this.E = obtainStyledAttributes.getInt(ResUtils.styleable(context, "CommonTabLayout", "underline_gravity"), 80);
            this.F = obtainStyledAttributes.getColor(ResUtils.styleable(context, "CommonTabLayout", "divider_color"), Color.parseColor("#ffffff"));
            this.G = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "divider_width"), a(0.0f));
            this.H = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "divider_padding"), a(12.0f));
            this.I = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "text_size"), b(13.0f));
            this.J = obtainStyledAttributes.getColor(ResUtils.styleable(context, "CommonTabLayout", "text_select_color"), Color.parseColor("#ffffff"));
            this.K = obtainStyledAttributes.getColor(ResUtils.styleable(context, "CommonTabLayout", "text_unselect_color"), Color.parseColor("#AAffffff"));
            this.L = obtainStyledAttributes.getInt(ResUtils.styleable(context, "CommonTabLayout", "text_bold"), 0);
            this.M = obtainStyledAttributes.getBoolean(ResUtils.styleable(context, "CommonTabLayout", "text_all_caps"), false);
            this.o = obtainStyledAttributes.getBoolean(ResUtils.styleable(context, "CommonTabLayout", "tab_space_equal"), true);
            this.p = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "tab_width"), a(-1.0f));
            this.n = obtainStyledAttributes.getDimension(ResUtils.styleable(context, "CommonTabLayout", "tab_padding"), (this.o || this.p > 0.0f) ? a(0.0f) : a(10.0f));
            obtainStyledAttributes.recycle();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int i2 = 0;
            while (i2 < this.f26939f) {
                View childAt = this.f26936c.getChildAt(i2);
                float f2 = this.n;
                childAt.setPadding((int) f2, 0, (int) f2, 0);
                TextView textView = (TextView) childAt.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_tab_title"));
                textView.setTextColor(i2 == this.f26937d ? this.J : this.K);
                textView.setTextSize(0, this.I);
                if (this.M) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i3 = this.L;
                if (i3 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i3 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
                i2++;
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View childAt = this.f26936c.getChildAt(this.f26937d);
            this.P.f26943a = childAt.getLeft();
            this.P.f26944b = childAt.getRight();
            View childAt2 = this.f26936c.getChildAt(this.f26938e);
            this.Q.f26943a = childAt2.getLeft();
            this.Q.f26944b = childAt2.getRight();
            a aVar = this.Q;
            float f2 = aVar.f26943a;
            a aVar2 = this.P;
            if (f2 == aVar2.f26943a && aVar.f26944b == aVar2.f26944b) {
                invalidate();
                return;
            }
            this.N.setObjectValues(this.Q, this.P);
            if (this.A) {
                this.N.setInterpolator(this.O);
            }
            if (this.y < 0) {
                this.y = this.A ? 500L : 250L;
            }
            this.N.setDuration(this.y);
            this.N.start();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View childAt = this.f26936c.getChildAt(this.f26937d);
            Rect rect = this.f26940g;
            rect.left = childAt.getLeft();
            rect.right = childAt.getRight();
            if (this.s >= 0.0f) {
                float f2 = this.s;
                float left = childAt.getLeft() + ((childAt.getWidth() - f2) / 2.0f);
                Rect rect2 = this.f26940g;
                int i2 = (int) left;
                rect2.left = i2;
                rect2.right = (int) (i2 + f2);
            }
        }
    }

    private void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            this.f26938e = this.f26937d;
            this.f26937d = i2;
            a(i2);
            if (this.z) {
                c();
            } else {
                invalidate();
            }
        }
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26937d : invokeV.intValue;
    }

    public int getDividerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.F : invokeV.intValue;
    }

    public float getDividerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.H : invokeV.floatValue;
    }

    public float getDividerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G : invokeV.floatValue;
    }

    public long getIndicatorAnimDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : invokeV.longValue;
    }

    public int getIndicatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    public float getIndicatorCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t : invokeV.floatValue;
    }

    public float getIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : invokeV.floatValue;
    }

    public float getIndicatorMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : invokeV.floatValue;
    }

    public float getIndicatorMarginLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.u : invokeV.floatValue;
    }

    public float getIndicatorMarginRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.w : invokeV.floatValue;
    }

    public float getIndicatorMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.v : invokeV.floatValue;
    }

    public int getIndicatorStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : invokeV.intValue;
    }

    public float getIndicatorWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.s : invokeV.floatValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f26939f : invokeV.intValue;
    }

    public float getTabPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : invokeV.floatValue;
    }

    public float getTabWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.p : invokeV.floatValue;
    }

    public int getTextBold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.L : invokeV.intValue;
    }

    public int getTextSelectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.J : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.I : invokeV.floatValue;
    }

    public int getTextUnselectColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.K : invokeV.intValue;
    }

    public TextView getTitleView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? (TextView) this.f26936c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_tab_title")) : (TextView) invokeI.objValue;
    }

    public int getUnderlineColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : invokeV.intValue;
    }

    public float getUnderlineHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.D : invokeV.floatValue;
    }

    public boolean isIndicatorAnimEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean isIndicatorBounceEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean isMsgTipsShowing(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? ((TextView) this.f26936c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_msg_tips"))).getVisibility() == 0 : invokeI.booleanValue;
    }

    public boolean isTabSpaceEqual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isTextAllCaps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.M : invokeV.booleanValue;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, valueAnimator) == null) {
            View childAt = this.f26936c.getChildAt(this.f26937d);
            a aVar = (a) valueAnimator.getAnimatedValue();
            Rect rect = this.f26940g;
            float f2 = aVar.f26943a;
            rect.left = (int) f2;
            rect.right = (int) aVar.f26944b;
            if (this.s >= 0.0f) {
                float f3 = this.s;
                float width = f2 + ((childAt.getWidth() - f3) / 2.0f);
                Rect rect2 = this.f26940g;
                int i2 = (int) width;
                rect2.left = i2;
                rect2.right = (int) (i2 + f3);
            }
            invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, view) == null) || this.f26937d == (intValue = ((Integer) view.getTag()).intValue())) {
            return;
        }
        setCurrentTab(intValue);
        OnTabSelectListener onTabSelectListener = this.S;
        if (onTabSelectListener != null) {
            onTabSelectListener.onTabSelect(intValue);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.f26939f <= 0) {
                return;
            }
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f2 = this.G;
            if (f2 > 0.0f) {
                this.j.setStrokeWidth(f2);
                this.j.setColor(this.F);
                for (int i2 = 0; i2 < this.f26939f - 1; i2++) {
                    View childAt = this.f26936c.getChildAt(i2);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.j);
                }
            }
            if (this.D > 0.0f) {
                this.f26942i.setColor(this.C);
                if (this.E == 80) {
                    float f3 = height;
                    canvas.drawRect(paddingLeft, f3 - this.D, this.f26936c.getWidth() + paddingLeft, f3, this.f26942i);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, this.f26936c.getWidth() + paddingLeft, this.D, this.f26942i);
                }
            }
            if (this.z) {
                if (this.R) {
                    this.R = false;
                    d();
                }
            } else {
                d();
            }
            int i3 = this.m;
            if (i3 == 1) {
                if (this.r > 0.0f) {
                    this.k.setColor(this.q);
                    this.l.reset();
                    float f4 = height;
                    this.l.moveTo(this.f26940g.left + paddingLeft, f4);
                    Path path = this.l;
                    Rect rect2 = this.f26940g;
                    path.lineTo((rect2.left >> 1) + paddingLeft + (rect2.right >> 1), f4 - this.r);
                    this.l.lineTo(paddingLeft + this.f26940g.right, f4);
                    this.l.close();
                    canvas.drawPath(this.l, this.k);
                }
            } else if (i3 == 2) {
                if (this.r < 0.0f) {
                    this.r = (height - this.v) - this.x;
                }
                float f5 = this.r;
                if (f5 > 0.0f) {
                    float f6 = this.t;
                    if (f6 < 0.0f || f6 > f5 / 2.0f) {
                        this.t = this.r / 2.0f;
                    }
                    this.f26941h.setColor(this.q);
                    GradientDrawable gradientDrawable = this.f26941h;
                    int i4 = ((int) this.u) + paddingLeft + this.f26940g.left;
                    float f7 = this.v;
                    gradientDrawable.setBounds(i4, (int) f7, (int) ((paddingLeft + rect.right) - this.w), (int) (f7 + this.r));
                    this.f26941h.setCornerRadius(this.t);
                    this.f26941h.draw(canvas);
                }
            } else if (this.r > 0.0f) {
                this.f26941h.setColor(this.q);
                if (this.B == 80) {
                    GradientDrawable gradientDrawable2 = this.f26941h;
                    Rect rect3 = this.f26940g;
                    float f8 = this.x;
                    gradientDrawable2.setBounds(((int) this.u) + paddingLeft + rect3.left, (height - ((int) this.r)) - ((int) f8), (paddingLeft + rect3.right) - ((int) this.w), height - ((int) f8));
                } else {
                    GradientDrawable gradientDrawable3 = this.f26941h;
                    Rect rect4 = this.f26940g;
                    int i5 = ((int) this.u) + paddingLeft + rect4.left;
                    float f9 = this.v;
                    gradientDrawable3.setBounds(i5, (int) f9, (paddingLeft + rect4.right) - ((int) this.w), ((int) this.r) + ((int) f9));
                }
                this.f26941h.setCornerRadius(this.t);
                this.f26941h.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                this.f26937d = bundle.getInt("mCurrentTab");
                parcelable = bundle.getParcelable("instanceState");
                if (this.f26937d != 0 && this.f26936c.getChildCount() > 0) {
                    a(this.f26937d);
                }
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            bundle.putInt("mCurrentTab", this.f26937d);
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.F = i2;
            invalidate();
        }
    }

    public void setDividerPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048611, this, f2) == null) {
            this.H = a(f2);
            invalidate();
        }
    }

    public void setDividerWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048612, this, f2) == null) {
            this.G = a(f2);
            invalidate();
        }
    }

    public void setIndicatorAnimDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.y = j;
        }
    }

    public void setIndicatorAnimEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.z = z;
        }
    }

    public void setIndicatorBounceEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.A = z;
        }
    }

    public void setIndicatorColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.q = i2;
            invalidate();
        }
    }

    public void setIndicatorCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            this.t = a(f2);
            invalidate();
        }
    }

    public void setIndicatorGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.B = i2;
            invalidate();
        }
    }

    public void setIndicatorHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            this.r = a(f2);
            invalidate();
        }
    }

    public void setIndicatorMargin(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.u = a(f2);
            this.v = a(f3);
            this.w = a(f4);
            this.x = a(f5);
            invalidate();
        }
    }

    public void setIndicatorStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.m = i2;
            invalidate();
        }
    }

    public void setIndicatorWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            this.s = a(f2);
            invalidate();
        }
    }

    public void setIsFirstDraw(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.R = z;
        }
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onTabSelectListener) == null) {
            this.S = onTabSelectListener;
        }
    }

    public void setTabData(ArrayList<ICustomTabEntity> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                this.f26935b.clear();
                this.f26935b.addAll(arrayList);
                a();
                return;
            }
            throw new IllegalStateException("TabEntities can not be NULL or EMPTY !");
        }
    }

    public void setTabPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
            this.n = a(f2);
            b();
        }
    }

    public void setTabSpaceEqual(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.o = z;
            b();
        }
    }

    public void setTabTitleTipMsg(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            TextView textView = (TextView) this.f26936c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_msg_tips"));
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            if (z) {
                ((RelativeLayout.LayoutParams) textView.getLayoutParams()).leftMargin = (DisplayUtils.getDisplayWidth(this.f26934a) / this.f26939f) / 2;
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void setTabWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f2) == null) {
            this.p = a(f2);
            b();
        }
    }

    public void setTextAllCaps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.M = z;
            b();
        }
    }

    public void setTextBold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.L = i2;
            b();
        }
    }

    public void setTextSelectColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.J = i2;
            b();
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            this.I = b(f2);
            b();
        }
    }

    public void setTextUnselectColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.K = i2;
            b();
        }
    }

    public void setUnderlineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.C = i2;
            invalidate();
        }
    }

    public void setUnderlineGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.E = i2;
            invalidate();
        }
    }

    public void setUnderlineHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048637, this, f2) == null) {
            this.D = a(f2);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f26935b = new ArrayList<>();
        this.f26940g = new Rect();
        this.f26941h = new GradientDrawable();
        this.f26942i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new Path();
        this.m = 0;
        this.O = new OvershootInterpolator(1.5f);
        this.P = new a(this);
        this.Q = new a(this);
        this.R = true;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f26934a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26936c = linearLayout;
        addView(linearLayout);
        a(context, attributeSet);
        ValueAnimator ofObject = ValueAnimator.ofObject(new b(this), this.Q, this.P);
        this.N = ofObject;
        ofObject.addUpdateListener(this);
    }

    private int b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f2)) == null) ? (int) ((f2 * this.f26934a.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeF.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f26936c.removeAllViews();
            this.f26939f = this.f26935b.size();
            for (int i2 = 0; i2 < this.f26939f; i2++) {
                Context context = this.f26934a;
                View inflate = View.inflate(context, com.baidu.apollon.utils.ResUtils.layout(context, "wallet_custom_tab_layout"), null);
                inflate.setTag(Integer.valueOf(i2));
                a(i2, inflate);
            }
            b();
        }
    }

    private void a(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, view) == null) {
            ((TextView) view.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_tab_title"))).setText(this.f26935b.get(i2).getTabTitle());
            ((TextView) view.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_msg_tips"))).setVisibility(8);
            view.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = this.o ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
            if (this.p > 0.0f) {
                layoutParams = new LinearLayout.LayoutParams((int) this.p, -1);
            }
            this.f26936c.addView(view, i2, layoutParams);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            int i3 = 0;
            while (i3 < this.f26939f) {
                View childAt = this.f26936c.getChildAt(i3);
                boolean z = i3 == i2;
                TextView textView = (TextView) childAt.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26934a, "tv_tab_title"));
                textView.setTextColor(z ? this.J : this.K);
                if (this.L == 1) {
                    textView.getPaint().setFakeBoldText(z);
                }
                i3++;
            }
        }
    }

    private int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f2)) == null) ? (int) ((f2 * this.f26934a.getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }
}
