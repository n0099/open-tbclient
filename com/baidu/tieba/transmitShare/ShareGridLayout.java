package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int jsz = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int bQX;
    private int cJo;
    private int jsA;
    private Context mContext;
    private int mItemHeight;

    public ShareGridLayout(Context context) {
        super(context);
        init(context);
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ShareGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setItemParams(int i, int i2) {
        this.bQX = i;
        this.mItemHeight = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        cE(0, l.af(this.mContext) - (jsz * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.bQX, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.jsA) {
            setMeasuredDimension(resolveSize((this.bQX * this.jsA) + (this.cJo * 2 * this.jsA), i), resolveSize(this.mItemHeight, i2));
            return;
        }
        int i4 = childCount / this.jsA;
        if (childCount % this.jsA > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.bQX * this.jsA) + (this.cJo * 2 * this.jsA), i), resolveSize(i4 * this.mItemHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        cE(i, i3);
        int i5 = this.cJo;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i8, i9, this.bQX + i8, this.mItemHeight + i9);
            i7++;
            int i10 = this.bQX + i8 + (this.cJo * 2);
            if (i7 >= this.jsA) {
                i10 = this.cJo;
                i7 = 0;
            }
            int i11 = ((i6 + 1) / this.jsA) * this.mItemHeight;
            i6++;
            i8 = i10;
            i9 = i11;
        }
    }

    private void cE(int i, int i2) {
        int i3 = i2 - i;
        if (l.af(TbadkCoreApplication.getInst()) > 800 && this.bQX * 5 <= i3) {
            this.jsA = 5;
        } else {
            this.jsA = 4;
        }
        double d = i3 - (this.bQX * this.jsA);
        if (d > 0.0d) {
            if (this.jsA == 5) {
                this.cJo = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.cJo = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.cJo = 0;
    }
}
