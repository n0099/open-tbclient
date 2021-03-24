package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes5.dex */
public class ImageOverlayView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f22120e;

    /* renamed from: f  reason: collision with root package name */
    public int f22121f;

    /* renamed from: g  reason: collision with root package name */
    public int f22122g;

    /* renamed from: h  reason: collision with root package name */
    public int f22123h;
    public int i;
    public int j;
    public int k;
    public a l;
    public int m;
    public boolean n;
    public Paint o;
    public int p;
    public RectF q;
    public int r;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f22120e = i;
        this.f22121f = i;
        this.f22122g = i2;
        this.f22123h = i3;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        b();
    }

    public final void b() {
        for (int i = 0; i < this.f22120e; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f22122g, this.f22123h));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
            addView(headImageView);
        }
    }

    public final void c() {
        Paint paint = new Paint();
        this.o = paint;
        paint.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
    }

    public void d() {
        this.o.setColor(SkinManager.getColor(this.j));
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof HeadImageView) {
                ((HeadImageView) childAt).setPlaceHolder(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        this.o.setColor(SkinManager.getColor(this.j));
        this.o.setStrokeWidth(this.i);
        int i = this.r;
        if (i == 0) {
            for (int i2 = 1; i2 < this.f22121f && i2 < getChildCount() && (childAt = getChildAt(i2)) != null; i2++) {
                float f2 = this.i * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.q.set(childAt.getLeft() - f2, childAt.getTop() - f2, childAt.getRight() + f2, childAt.getBottom() + f2);
                    canvas.drawArc(this.q, -90.0f, 180.0f, false, this.o);
                }
            }
        } else if (i == 1) {
            int i3 = this.p;
            if (i3 <= 0) {
                i3 = this.j;
            }
            this.p = i3;
            float f3 = this.i * 0.5f;
            float f4 = this.f22122g / 2.0f;
            float acos = ((float) ((Math.acos((((f4 * 2.0f) - this.k) / 2.0f) / f4) / 3.141592653589793d) * 180.0d)) - 180.0f;
            float abs = Math.abs(2.0f * acos);
            int i4 = 0;
            int i5 = this.n ? 0 : this.f22121f - 1;
            while (i4 < this.f22121f) {
                View childAt2 = getChildAt(i4);
                if (childAt2 instanceof HeadImageView) {
                    this.q.set(childAt2.getLeft() - f3, childAt2.getTop() - f3, childAt2.getRight() + f3, childAt2.getBottom() + f3);
                    if (i4 == i5) {
                        this.o.setColor(SkinManager.getColor(this.p));
                    } else {
                        this.o.setColor(SkinManager.getColor(this.j));
                    }
                    canvas.drawArc(this.q, i4 == i5 ? 0.0f : acos, i4 == i5 ? 360.0f : abs, false, this.o);
                }
                i4++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        int i5;
        View childAt;
        View childAt2;
        if (this.n) {
            paddingLeft = getPaddingLeft() + this.i;
            paddingTop = getPaddingTop();
            i5 = this.i;
        } else {
            paddingLeft = getPaddingLeft() + ((this.f22121f - 1) * (this.f22122g - this.k)) + this.i;
            paddingTop = getPaddingTop();
            i5 = this.i;
        }
        int i6 = paddingTop + i5;
        int i7 = 0;
        while (true) {
            int i8 = this.f22121f;
            if (i7 < i8) {
                if (i7 >= getChildCount() || (childAt2 = getChildAt(i7)) == null) {
                    return;
                }
                childAt2.setVisibility(0);
                if (this.n) {
                    childAt2.layout(paddingLeft, i6, this.f22122g + paddingLeft, this.f22123h + i6);
                    paddingLeft += this.f22122g - this.k;
                } else {
                    childAt2.layout(paddingLeft, i6, this.f22122g + paddingLeft, this.f22123h + i6);
                    paddingLeft -= this.f22122g - this.k;
                }
                i7++;
            } else {
                while (i8 < this.f22120e && i8 < getChildCount() && (childAt = getChildAt(i8)) != null) {
                    childAt.setVisibility(8);
                    i8++;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.i;
        if (this.r == 1) {
            i3 *= 2;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
        int i4 = this.f22121f;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f22122g * i4)) - ((i4 - 1) * this.k), i), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f22123h + (this.i * 2), i2));
    }

    public void setData(List<String> list) {
        String str;
        this.f22121f = Math.min(this.f22120e, ListUtils.getCount(list));
        for (int i = 0; i < this.f22121f; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) ListUtils.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.m == 12) {
                    headImageView.T(str, 12, this.f22122g, this.f22123h, false);
                } else {
                    headImageView.T(str, 10, this.f22122g, this.f22123h, false);
                }
            }
        }
        requestLayout();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.p = i;
    }

    public void setImageClickListener(a aVar) {
        this.l = aVar;
    }

    public void setLoadImageType(int i) {
        this.m = i;
    }

    public void setOrientation(boolean z) {
        this.n = z;
    }

    public void setStrokeStyle(int i) {
        this.r = i;
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 10;
        this.n = false;
        this.r = 0;
        c();
        this.q = new RectF();
    }
}
