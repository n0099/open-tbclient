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
    public static final int jmm = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int bPW;
    private int cHT;
    private int jmn;
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
        this.bPW = i;
        this.mItemHeight = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        cz(0, l.af(this.mContext) - (jmm * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.bPW, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.jmn) {
            setMeasuredDimension(resolveSize((this.bPW * this.jmn) + (this.cHT * 2 * this.jmn), i), resolveSize(this.mItemHeight, i2));
            return;
        }
        int i4 = childCount / this.jmn;
        if (childCount % this.jmn > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.bPW * this.jmn) + (this.cHT * 2 * this.jmn), i), resolveSize(i4 * this.mItemHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        cz(i, i3);
        int i5 = this.cHT;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i8, i9, this.bPW + i8, this.mItemHeight + i9);
            i7++;
            int i10 = this.bPW + i8 + (this.cHT * 2);
            if (i7 >= this.jmn) {
                i10 = this.cHT;
                i7 = 0;
            }
            int i11 = ((i6 + 1) / this.jmn) * this.mItemHeight;
            i6++;
            i8 = i10;
            i9 = i11;
        }
    }

    private void cz(int i, int i2) {
        int i3 = i2 - i;
        if (l.af(TbadkCoreApplication.getInst()) > 800 && this.bPW * 5 <= i3) {
            this.jmn = 5;
        } else {
            this.jmn = 4;
        }
        double d = i3 - (this.bPW * this.jmn);
        if (d > 0.0d) {
            if (this.jmn == 5) {
                this.cHT = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.cHT = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.cHT = 0;
    }
}
