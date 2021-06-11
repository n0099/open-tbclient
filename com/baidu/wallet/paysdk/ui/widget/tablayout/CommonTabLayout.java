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
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.ICustomTabEntity;
import com.baidu.wallet.paysdk.ui.widget.tablayout.callback.OnTabSelectListener;
import com.baidu.wallet.paysdk.ui.widget.tablayout.utils.ResUtils;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class CommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, View.OnClickListener {
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
    public Context f26309a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ICustomTabEntity> f26310b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f26311c;

    /* renamed from: d  reason: collision with root package name */
    public int f26312d;

    /* renamed from: e  reason: collision with root package name */
    public int f26313e;

    /* renamed from: f  reason: collision with root package name */
    public int f26314f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f26315g;

    /* renamed from: h  reason: collision with root package name */
    public GradientDrawable f26316h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f26317i;
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

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public float f26318a;

        /* renamed from: b  reason: collision with root package name */
        public float f26319b;

        public a() {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TypeEvaluator<a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public a evaluate(float f2, a aVar, a aVar2) {
            float f3 = aVar.f26318a;
            float f4 = aVar.f26319b;
            float f5 = f4 + (f2 * (aVar2.f26319b - f4));
            a aVar3 = new a();
            aVar3.f26318a = f3 + ((aVar2.f26318a - f3) * f2);
            aVar3.f26319b = f5;
            return aVar3;
        }
    }

    public CommonTabLayout(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f2;
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

    private void b() {
        int i2 = 0;
        while (i2 < this.f26314f) {
            View childAt = this.f26311c.getChildAt(i2);
            float f2 = this.n;
            childAt.setPadding((int) f2, 0, (int) f2, 0);
            TextView textView = (TextView) childAt.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_tab_title"));
            textView.setTextColor(i2 == this.f26312d ? this.J : this.K);
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

    private void c() {
        View childAt = this.f26311c.getChildAt(this.f26312d);
        this.P.f26318a = childAt.getLeft();
        this.P.f26319b = childAt.getRight();
        View childAt2 = this.f26311c.getChildAt(this.f26313e);
        this.Q.f26318a = childAt2.getLeft();
        this.Q.f26319b = childAt2.getRight();
        a aVar = this.Q;
        float f2 = aVar.f26318a;
        a aVar2 = this.P;
        if (f2 == aVar2.f26318a && aVar.f26319b == aVar2.f26319b) {
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

    private void d() {
        View childAt = this.f26311c.getChildAt(this.f26312d);
        Rect rect = this.f26315g;
        rect.left = childAt.getLeft();
        rect.right = childAt.getRight();
        if (this.s >= 0.0f) {
            float f2 = this.s;
            float left = childAt.getLeft() + ((childAt.getWidth() - f2) / 2.0f);
            Rect rect2 = this.f26315g;
            int i2 = (int) left;
            rect2.left = i2;
            rect2.right = (int) (i2 + f2);
        }
    }

    private void setCurrentTab(int i2) {
        this.f26313e = this.f26312d;
        this.f26312d = i2;
        a(i2);
        if (this.z) {
            c();
        } else {
            invalidate();
        }
    }

    public int getCurrentTab() {
        return this.f26312d;
    }

    public int getDividerColor() {
        return this.F;
    }

    public float getDividerPadding() {
        return this.H;
    }

    public float getDividerWidth() {
        return this.G;
    }

    public long getIndicatorAnimDuration() {
        return this.y;
    }

    public int getIndicatorColor() {
        return this.q;
    }

    public float getIndicatorCornerRadius() {
        return this.t;
    }

    public float getIndicatorHeight() {
        return this.r;
    }

    public float getIndicatorMarginBottom() {
        return this.x;
    }

    public float getIndicatorMarginLeft() {
        return this.u;
    }

    public float getIndicatorMarginRight() {
        return this.w;
    }

    public float getIndicatorMarginTop() {
        return this.v;
    }

    public int getIndicatorStyle() {
        return this.m;
    }

    public float getIndicatorWidth() {
        return this.s;
    }

    public int getTabCount() {
        return this.f26314f;
    }

    public float getTabPadding() {
        return this.n;
    }

    public float getTabWidth() {
        return this.p;
    }

    public int getTextBold() {
        return this.L;
    }

    public int getTextSelectColor() {
        return this.J;
    }

    public float getTextSize() {
        return this.I;
    }

    public int getTextUnselectColor() {
        return this.K;
    }

    public TextView getTitleView(int i2) {
        return (TextView) this.f26311c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_tab_title"));
    }

    public int getUnderlineColor() {
        return this.C;
    }

    public float getUnderlineHeight() {
        return this.D;
    }

    public boolean isIndicatorAnimEnable() {
        return this.z;
    }

    public boolean isIndicatorBounceEnable() {
        return this.A;
    }

    public boolean isMsgTipsShowing(int i2) {
        return ((TextView) this.f26311c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_msg_tips"))).getVisibility() == 0;
    }

    public boolean isTabSpaceEqual() {
        return this.o;
    }

    public boolean isTextAllCaps() {
        return this.M;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.f26311c.getChildAt(this.f26312d);
        a aVar = (a) valueAnimator.getAnimatedValue();
        Rect rect = this.f26315g;
        float f2 = aVar.f26318a;
        rect.left = (int) f2;
        rect.right = (int) aVar.f26319b;
        if (this.s >= 0.0f) {
            float f3 = this.s;
            float width = f2 + ((childAt.getWidth() - f3) / 2.0f);
            Rect rect2 = this.f26315g;
            int i2 = (int) width;
            rect2.left = i2;
            rect2.right = (int) (i2 + f3);
        }
        invalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.f26312d != intValue) {
            setCurrentTab(intValue);
            OnTabSelectListener onTabSelectListener = this.S;
            if (onTabSelectListener != null) {
                onTabSelectListener.onTabSelect(intValue);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        super.onDraw(canvas);
        if (isInEditMode() || this.f26314f <= 0) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        float f2 = this.G;
        if (f2 > 0.0f) {
            this.j.setStrokeWidth(f2);
            this.j.setColor(this.F);
            for (int i2 = 0; i2 < this.f26314f - 1; i2++) {
                View childAt = this.f26311c.getChildAt(i2);
                canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.j);
            }
        }
        if (this.D > 0.0f) {
            this.f26317i.setColor(this.C);
            if (this.E == 80) {
                float f3 = height;
                canvas.drawRect(paddingLeft, f3 - this.D, this.f26311c.getWidth() + paddingLeft, f3, this.f26317i);
            } else {
                canvas.drawRect(paddingLeft, 0.0f, this.f26311c.getWidth() + paddingLeft, this.D, this.f26317i);
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
                this.l.moveTo(this.f26315g.left + paddingLeft, f4);
                Path path = this.l;
                Rect rect2 = this.f26315g;
                path.lineTo((rect2.left >> 1) + paddingLeft + (rect2.right >> 1), f4 - this.r);
                this.l.lineTo(paddingLeft + this.f26315g.right, f4);
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
                this.f26316h.setColor(this.q);
                GradientDrawable gradientDrawable = this.f26316h;
                int i4 = ((int) this.u) + paddingLeft + this.f26315g.left;
                float f7 = this.v;
                gradientDrawable.setBounds(i4, (int) f7, (int) ((paddingLeft + rect.right) - this.w), (int) (f7 + this.r));
                this.f26316h.setCornerRadius(this.t);
                this.f26316h.draw(canvas);
            }
        } else if (this.r > 0.0f) {
            this.f26316h.setColor(this.q);
            if (this.B == 80) {
                GradientDrawable gradientDrawable2 = this.f26316h;
                Rect rect3 = this.f26315g;
                float f8 = this.x;
                gradientDrawable2.setBounds(((int) this.u) + paddingLeft + rect3.left, (height - ((int) this.r)) - ((int) f8), (paddingLeft + rect3.right) - ((int) this.w), height - ((int) f8));
            } else {
                GradientDrawable gradientDrawable3 = this.f26316h;
                Rect rect4 = this.f26315g;
                int i5 = ((int) this.u) + paddingLeft + rect4.left;
                float f9 = this.v;
                gradientDrawable3.setBounds(i5, (int) f9, (paddingLeft + rect4.right) - ((int) this.w), ((int) this.r) + ((int) f9));
            }
            this.f26316h.setCornerRadius(this.t);
            this.f26316h.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f26312d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f26312d != 0 && this.f26311c.getChildCount() > 0) {
                a(this.f26312d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f26312d);
        return bundle;
    }

    public void setDividerColor(int i2) {
        this.F = i2;
        invalidate();
    }

    public void setDividerPadding(float f2) {
        this.H = a(f2);
        invalidate();
    }

    public void setDividerWidth(float f2) {
        this.G = a(f2);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j) {
        this.y = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.z = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.A = z;
    }

    public void setIndicatorColor(int i2) {
        this.q = i2;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.t = a(f2);
        invalidate();
    }

    public void setIndicatorGravity(int i2) {
        this.B = i2;
        invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.r = a(f2);
        invalidate();
    }

    public void setIndicatorMargin(float f2, float f3, float f4, float f5) {
        this.u = a(f2);
        this.v = a(f3);
        this.w = a(f4);
        this.x = a(f5);
        invalidate();
    }

    public void setIndicatorStyle(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.s = a(f2);
        invalidate();
    }

    public void setIsFirstDraw(boolean z) {
        this.R = z;
    }

    public void setOnTabSelectListener(OnTabSelectListener onTabSelectListener) {
        this.S = onTabSelectListener;
    }

    public void setTabData(ArrayList<ICustomTabEntity> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.f26310b.clear();
            this.f26310b.addAll(arrayList);
            a();
            return;
        }
        throw new IllegalStateException("TabEntities can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f2) {
        this.n = a(f2);
        b();
    }

    public void setTabSpaceEqual(boolean z) {
        this.o = z;
        b();
    }

    public void setTabTitleTipMsg(int i2, boolean z, String str) {
        TextView textView = (TextView) this.f26311c.getChildAt(i2).findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_msg_tips"));
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (z) {
            ((RelativeLayout.LayoutParams) textView.getLayoutParams()).leftMargin = (DisplayUtils.getDisplayWidth(this.f26309a) / this.f26314f) / 2;
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void setTabWidth(float f2) {
        this.p = a(f2);
        b();
    }

    public void setTextAllCaps(boolean z) {
        this.M = z;
        b();
    }

    public void setTextBold(int i2) {
        this.L = i2;
        b();
    }

    public void setTextSelectColor(int i2) {
        this.J = i2;
        b();
    }

    public void setTextSize(float f2) {
        this.I = b(f2);
        b();
    }

    public void setTextUnselectColor(int i2) {
        this.K = i2;
        b();
    }

    public void setUnderlineColor(int i2) {
        this.C = i2;
        invalidate();
    }

    public void setUnderlineGravity(int i2) {
        this.E = i2;
        invalidate();
    }

    public void setUnderlineHeight(float f2) {
        this.D = a(f2);
        invalidate();
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26310b = new ArrayList<>();
        this.f26315g = new Rect();
        this.f26316h = new GradientDrawable();
        this.f26317i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new Path();
        this.m = 0;
        this.O = new OvershootInterpolator(1.5f);
        this.P = new a();
        this.Q = new a();
        this.R = true;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f26309a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26311c = linearLayout;
        addView(linearLayout);
        a(context, attributeSet);
        ValueAnimator ofObject = ValueAnimator.ofObject(new b(), this.Q, this.P);
        this.N = ofObject;
        ofObject.addUpdateListener(this);
    }

    private int b(float f2) {
        return (int) ((f2 * this.f26309a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void a() {
        this.f26311c.removeAllViews();
        this.f26314f = this.f26310b.size();
        for (int i2 = 0; i2 < this.f26314f; i2++) {
            Context context = this.f26309a;
            View inflate = View.inflate(context, com.baidu.apollon.utils.ResUtils.layout(context, "wallet_custom_tab_layout"), null);
            inflate.setTag(Integer.valueOf(i2));
            a(i2, inflate);
        }
        b();
    }

    private void a(int i2, View view) {
        ((TextView) view.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_tab_title"))).setText(this.f26310b.get(i2).getTabTitle());
        ((TextView) view.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_msg_tips"))).setVisibility(8);
        view.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = this.o ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.p > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.p, -1);
        }
        this.f26311c.addView(view, i2, layoutParams);
    }

    private void a(int i2) {
        int i3 = 0;
        while (i3 < this.f26314f) {
            View childAt = this.f26311c.getChildAt(i3);
            boolean z = i3 == i2;
            TextView textView = (TextView) childAt.findViewById(com.baidu.apollon.utils.ResUtils.id(this.f26309a, "tv_tab_title"));
            textView.setTextColor(z ? this.J : this.K);
            if (this.L == 1) {
                textView.getPaint().setFakeBoldText(z);
            }
            i3++;
        }
    }

    private int a(float f2) {
        return (int) ((f2 * this.f26309a.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
