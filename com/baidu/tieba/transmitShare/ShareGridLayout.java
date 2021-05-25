package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);

    /* renamed from: e  reason: collision with root package name */
    public Context f21157e;

    /* renamed from: f  reason: collision with root package name */
    public int f21158f;

    /* renamed from: g  reason: collision with root package name */
    public int f21159g;

    /* renamed from: h  reason: collision with root package name */
    public int f21160h;

    /* renamed from: i  reason: collision with root package name */
    public int f21161i;

    public ShareGridLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f21157e = context;
        b(0, l.k(context) - (j * 2));
    }

    public final void b(int i2, int i3) {
        int i4 = i3 - i2;
        if (l.k(TbadkCoreApplication.getInst()) > 800 && this.f21158f * 5 <= i4) {
            this.f21160h = 5;
        } else {
            this.f21160h = 4;
        }
        int i5 = this.f21158f;
        int i6 = this.f21160h;
        double d2 = i4 - (i5 * i6);
        if (d2 <= 0.0d) {
            this.f21161i = 0;
        } else if (i6 == 5) {
            this.f21161i = (int) Math.floor(d2 / 10.0d);
        } else {
            this.f21161i = (int) Math.floor(d2 / 8.0d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b(i2, i4);
        int i6 = this.f21161i;
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < childCount) {
            getChildAt(i7).layout(i6, i8, this.f21158f + i6, this.f21159g + i8);
            i9++;
            int i10 = i6 + this.f21158f;
            int i11 = this.f21161i;
            i6 = i10 + (i11 * 2);
            if (i9 >= this.f21160h) {
                i6 = i11;
                i9 = 0;
            }
            i7++;
            i8 = (i7 / this.f21160h) * this.f21159g;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f21158f, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f21159g, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        int i5 = this.f21160h;
        if (childCount <= i5) {
            setMeasuredDimension(ViewGroup.resolveSize((this.f21158f * i5) + (this.f21161i * 2 * i5), i2), ViewGroup.resolveSize(this.f21159g, i3));
            return;
        }
        int i6 = childCount / i5;
        if (childCount % i5 > 0) {
            i6++;
        }
        int i7 = this.f21158f;
        int i8 = this.f21160h;
        setMeasuredDimension(ViewGroup.resolveSize((i7 * i8) + (this.f21161i * 2 * i8), i2), ViewGroup.resolveSize(this.f21159g * i6, i3));
    }

    public void setItemParams(int i2, int i3) {
        this.f21158f = i2;
        this.f21159g = i3;
        requestLayout();
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
