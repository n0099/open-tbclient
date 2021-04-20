package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);

    /* renamed from: e  reason: collision with root package name */
    public Context f21360e;

    /* renamed from: f  reason: collision with root package name */
    public int f21361f;

    /* renamed from: g  reason: collision with root package name */
    public int f21362g;

    /* renamed from: h  reason: collision with root package name */
    public int f21363h;
    public int i;

    public ShareGridLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f21360e = context;
        b(0, l.k(context) - (j * 2));
    }

    public final void b(int i, int i2) {
        int i3 = i2 - i;
        if (l.k(TbadkCoreApplication.getInst()) > 800 && this.f21361f * 5 <= i3) {
            this.f21363h = 5;
        } else {
            this.f21363h = 4;
        }
        int i4 = this.f21361f;
        int i5 = this.f21363h;
        double d2 = i3 - (i4 * i5);
        if (d2 <= 0.0d) {
            this.i = 0;
        } else if (i5 == 5) {
            this.i = (int) Math.floor(d2 / 10.0d);
        } else {
            this.i = (int) Math.floor(d2 / 8.0d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b(i, i3);
        int i5 = this.i;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i5, i7, this.f21361f + i5, this.f21362g + i7);
            i8++;
            int i9 = i5 + this.f21361f;
            int i10 = this.i;
            i5 = i9 + (i10 * 2);
            if (i8 >= this.f21363h) {
                i5 = i10;
                i8 = 0;
            }
            i6++;
            i7 = (i6 / this.f21363h) * this.f21362g;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f21361f, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f21362g, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        int i4 = this.f21363h;
        if (childCount <= i4) {
            setMeasuredDimension(ViewGroup.resolveSize((this.f21361f * i4) + (this.i * 2 * i4), i), ViewGroup.resolveSize(this.f21362g, i2));
            return;
        }
        int i5 = childCount / i4;
        if (childCount % i4 > 0) {
            i5++;
        }
        int i6 = this.f21361f;
        int i7 = this.f21363h;
        setMeasuredDimension(ViewGroup.resolveSize((i6 * i7) + (this.i * 2 * i7), i), ViewGroup.resolveSize(this.f21362g * i5, i2));
    }

    public void setItemParams(int i, int i2) {
        this.f21361f = i;
        this.f21362g = i2;
        requestLayout();
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
