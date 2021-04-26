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
    public int f22469e;

    /* renamed from: f  reason: collision with root package name */
    public int f22470f;

    /* renamed from: g  reason: collision with root package name */
    public int f22471g;

    /* renamed from: h  reason: collision with root package name */
    public int f22472h;

    /* renamed from: i  reason: collision with root package name */
    public int f22473i;
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

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f22469e = i2;
        this.f22470f = i2;
        this.f22471g = i3;
        this.f22472h = i4;
        this.f22473i = i5;
        this.j = i6;
        this.k = i7;
        b();
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f22469e; i2++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f22471g, this.f22472h));
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
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
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
        this.o.setStrokeWidth(this.f22473i);
        int i2 = this.r;
        if (i2 == 0) {
            for (int i3 = 1; i3 < this.f22470f && i3 < getChildCount() && (childAt = getChildAt(i3)) != null; i3++) {
                float f2 = this.f22473i * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.q.set(childAt.getLeft() - f2, childAt.getTop() - f2, childAt.getRight() + f2, childAt.getBottom() + f2);
                    canvas.drawArc(this.q, -90.0f, 180.0f, false, this.o);
                }
            }
        } else if (i2 == 1) {
            int i4 = this.p;
            if (i4 <= 0) {
                i4 = this.j;
            }
            this.p = i4;
            float f3 = this.f22473i * 0.5f;
            float f4 = this.f22471g / 2.0f;
            float acos = ((float) ((Math.acos((((f4 * 2.0f) - this.k) / 2.0f) / f4) / 3.141592653589793d) * 180.0d)) - 180.0f;
            float abs = Math.abs(2.0f * acos);
            int i5 = 0;
            int i6 = this.n ? 0 : this.f22470f - 1;
            while (i5 < this.f22470f) {
                View childAt2 = getChildAt(i5);
                if (childAt2 instanceof HeadImageView) {
                    this.q.set(childAt2.getLeft() - f3, childAt2.getTop() - f3, childAt2.getRight() + f3, childAt2.getBottom() + f3);
                    if (i5 == i6) {
                        this.o.setColor(SkinManager.getColor(this.p));
                    } else {
                        this.o.setColor(SkinManager.getColor(this.j));
                    }
                    canvas.drawArc(this.q, i5 == i6 ? 0.0f : acos, i5 == i6 ? 360.0f : abs, false, this.o);
                }
                i5++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int paddingTop;
        int i6;
        View childAt;
        View childAt2;
        if (this.n) {
            paddingLeft = getPaddingLeft() + this.f22473i;
            paddingTop = getPaddingTop();
            i6 = this.f22473i;
        } else {
            paddingLeft = getPaddingLeft() + ((this.f22470f - 1) * (this.f22471g - this.k)) + this.f22473i;
            paddingTop = getPaddingTop();
            i6 = this.f22473i;
        }
        int i7 = paddingTop + i6;
        int i8 = 0;
        while (true) {
            int i9 = this.f22470f;
            if (i8 < i9) {
                if (i8 >= getChildCount() || (childAt2 = getChildAt(i8)) == null) {
                    return;
                }
                childAt2.setVisibility(0);
                if (this.n) {
                    childAt2.layout(paddingLeft, i7, this.f22471g + paddingLeft, this.f22472h + i7);
                    paddingLeft += this.f22471g - this.k;
                } else {
                    childAt2.layout(paddingLeft, i7, this.f22471g + paddingLeft, this.f22472h + i7);
                    paddingLeft -= this.f22471g - this.k;
                }
                i8++;
            } else {
                while (i9 < this.f22469e && i9 < getChildCount() && (childAt = getChildAt(i9)) != null) {
                    childAt.setVisibility(8);
                    i9++;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f22473i;
        if (this.r == 1) {
            i4 *= 2;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i4;
        int i5 = this.f22470f;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f22471g * i5)) - ((i5 - 1) * this.k), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f22472h + (this.f22473i * 2), i3));
    }

    public void setData(List<String> list) {
        String str;
        this.f22470f = Math.min(this.f22469e, ListUtils.getCount(list));
        for (int i2 = 0; i2 < this.f22470f; i2++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i2);
            if (headImageView != null && (str = (String) ListUtils.getItem(list, (list.size() - i2) - 1)) != null) {
                if (this.m == 12) {
                    headImageView.R(str, 12, this.f22471g, this.f22472h, false);
                } else {
                    headImageView.R(str, 10, this.f22471g, this.f22472h, false);
                }
            }
        }
        requestLayout();
    }

    public void setFirstImageStrokeColor(@ColorRes int i2) {
        this.p = i2;
    }

    public void setImageClickListener(a aVar) {
        this.l = aVar;
    }

    public void setLoadImageType(int i2) {
        this.m = i2;
    }

    public void setOrientation(boolean z) {
        this.n = z;
    }

    public void setStrokeStyle(int i2) {
        this.r = i2;
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 10;
        this.n = false;
        this.r = 0;
        c();
        this.q = new RectF();
    }
}
