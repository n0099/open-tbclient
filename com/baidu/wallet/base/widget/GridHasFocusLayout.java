package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class GridHasFocusLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23595a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23596b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23597c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f23598d;

    /* renamed from: e  reason: collision with root package name */
    public int f23599e;

    /* renamed from: f  reason: collision with root package name */
    public int f23600f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f23601g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f23602h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f23603i;
    public int j;
    public boolean k;
    public Paint l;

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f23604a;

        /* renamed from: b  reason: collision with root package name */
        public int f23605b;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public GridHasFocusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23603i = null;
        this.j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a() {
        this.f23598d = 3;
        this.f23599e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23600f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23601g = new RectF();
        this.f23602h = new Paint();
        this.l.setColor(SupportMenu.CATEGORY_MASK);
    }

    private void b() {
        this.j = -1;
        invalidate();
    }

    public void addSelectionView(View view) {
    }

    public void configFocusPaintColor(int i2) {
        this.l.setColor(i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        if (getChildCount() % this.f23598d == 0 || this.f23603i == null) {
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        this.f23601g.set(childAt.getLeft() + childAt.getWidth() + this.f23599e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
        this.f23602h.setColor(this.f23603i.intValue());
        canvas.drawRect(this.f23601g, this.f23602h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = layoutParams.f23604a;
                int i8 = layoutParams.f23605b;
                childAt.layout(i7, i8, ((ViewGroup.LayoutParams) layoutParams).width + i7, ((ViewGroup.LayoutParams) layoutParams).height + i8);
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i4 = size - (this.k ? this.f23599e * 2 : 0);
        int i5 = this.f23599e;
        int i6 = this.f23598d;
        int i7 = (i4 - (i5 * (i6 - 1))) / i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, makeMeasureSpec);
                i9 = childAt.getMeasuredHeight();
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
                if ((i10 - i8) % this.f23598d == 0) {
                    paddingLeft = getPaddingLeft() + (this.k ? this.f23599e : 0);
                    if (i10 != 0) {
                        paddingTop += this.f23600f + i9;
                    } else {
                        paddingTop = this.k ? this.f23600f : 0;
                    }
                } else {
                    paddingLeft += this.f23599e + i7;
                }
                if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                } else {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                }
                layoutParams.f23604a = paddingLeft;
                layoutParams.f23605b = paddingTop;
                ((ViewGroup.LayoutParams) layoutParams).width = i7;
                ((ViewGroup.LayoutParams) layoutParams).height = i9;
            } else {
                i8++;
            }
        }
        int i11 = childCount - i8;
        int i12 = this.f23598d;
        int i13 = (i11 / i12) + (i11 % i12 == 0 ? 0 : 1);
        int i14 = this.f23600f;
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (i9 * i13) + ((i13 - 1) * i14) + (this.k ? i14 * 2 : 0));
    }

    public void setColumnCount(int i2) {
        this.f23598d = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f23603i = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.f23599e = i2;
    }

    public void setSelection(int i2) {
        this.j = i2;
        invalidate();
    }

    public void setVerticalSpacing(int i2) {
        this.f23600f = i2;
    }

    public void showSideLine(boolean z) {
        this.k = z;
    }

    public GridHasFocusLayout(Context context) {
        super(context);
        this.f23603i = null;
        this.j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a(Canvas canvas) {
        this.l.setStrokeWidth(this.f23599e);
        int i2 = this.j;
        if (i2 < 0 || i2 >= getChildCount()) {
            return;
        }
        View childAt = getChildAt(this.j);
        float left = childAt.getLeft() - (this.k ? this.f23600f : 0);
        float top = childAt.getTop() - (this.k ? this.f23599e : 0);
        float left2 = ((childAt.getLeft() + childAt.getWidth()) + (this.k ? this.f23600f : 0)) - 1;
        float top2 = ((childAt.getTop() + childAt.getHeight()) + 0) - 1;
        canvas.drawLine(left, top, left, top2, this.l);
        canvas.drawLine(left, top2, left2, top2, this.l);
        canvas.drawLine(left, top, left2, top, this.l);
        canvas.drawLine(left2, top, left2, top2, this.l);
    }
}
