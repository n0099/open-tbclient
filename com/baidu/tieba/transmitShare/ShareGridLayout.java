package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int nkC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int fEY;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private int nkD;

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
        this.mItemWidth = i;
        this.mItemHeight = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        dx(0, l.getEquipmentWidth(this.mContext) - (nkC * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.nkD) {
            setMeasuredDimension(resolveSize((this.mItemWidth * this.nkD) + (this.fEY * 2 * this.nkD), i), resolveSize(this.mItemHeight, i2));
            return;
        }
        int i4 = childCount / this.nkD;
        if (childCount % this.nkD > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.mItemWidth * this.nkD) + (this.fEY * 2 * this.nkD), i), resolveSize(i4 * this.mItemHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dx(i, i3);
        int i5 = this.fEY;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i8, i9, this.mItemWidth + i8, this.mItemHeight + i9);
            i7++;
            int i10 = this.mItemWidth + i8 + (this.fEY * 2);
            if (i7 >= this.nkD) {
                i10 = this.fEY;
                i7 = 0;
            }
            int i11 = ((i6 + 1) / this.nkD) * this.mItemHeight;
            i6++;
            i8 = i10;
            i9 = i11;
        }
    }

    private void dx(int i, int i2) {
        int i3 = i2 - i;
        if (l.getEquipmentWidth(TbadkCoreApplication.getInst()) > 800 && this.mItemWidth * 5 <= i3) {
            this.nkD = 5;
        } else {
            this.nkD = 4;
        }
        double d = i3 - (this.mItemWidth * this.nkD);
        if (d > 0.0d) {
            if (this.nkD == 5) {
                this.fEY = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.fEY = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.fEY = 0;
    }
}
