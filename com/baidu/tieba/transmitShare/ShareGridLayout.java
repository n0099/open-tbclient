package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int nzm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
    private int dhV;
    private int fRk;
    private Context mContext;
    private int mItemWidth;
    private int nzn;

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
        this.dhV = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        dz(0, l.getEquipmentWidth(this.mContext) - (nzm * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dhV, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.nzn) {
            setMeasuredDimension(resolveSize((this.mItemWidth * this.nzn) + (this.fRk * 2 * this.nzn), i), resolveSize(this.dhV, i2));
            return;
        }
        int i4 = childCount / this.nzn;
        if (childCount % this.nzn > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.mItemWidth * this.nzn) + (this.fRk * 2 * this.nzn), i), resolveSize(i4 * this.dhV, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dz(i, i3);
        int i5 = this.fRk;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            getChildAt(i8).layout(i5, i7, this.mItemWidth + i5, this.dhV + i7);
            i6++;
            i5 = i5 + this.mItemWidth + (this.fRk * 2);
            if (i6 >= this.nzn) {
                i5 = this.fRk;
                i6 = 0;
            }
            i7 = ((i8 + 1) / this.nzn) * this.dhV;
        }
    }

    private void dz(int i, int i2) {
        int i3 = i2 - i;
        if (l.getEquipmentWidth(TbadkCoreApplication.getInst()) > 800 && this.mItemWidth * 5 <= i3) {
            this.nzn = 5;
        } else {
            this.nzn = 4;
        }
        double d = i3 - (this.mItemWidth * this.nzn);
        if (d > 0.0d) {
            if (this.nzn == 5) {
                this.fRk = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.fRk = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.fRk = 0;
    }
}
