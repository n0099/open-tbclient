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
    public static final int nLB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
    private int dlK;
    private int fUZ;
    private Context mContext;
    private int mItemWidth;
    private int nLC;

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
        this.dlK = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        dx(0, l.getEquipmentWidth(this.mContext) - (nLB * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.dlK, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.nLC) {
            setMeasuredDimension(resolveSize((this.mItemWidth * this.nLC) + (this.fUZ * 2 * this.nLC), i), resolveSize(this.dlK, i2));
            return;
        }
        int i4 = childCount / this.nLC;
        if (childCount % this.nLC > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.mItemWidth * this.nLC) + (this.fUZ * 2 * this.nLC), i), resolveSize(i4 * this.dlK, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dx(i, i3);
        int i5 = this.fUZ;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            getChildAt(i8).layout(i5, i7, this.mItemWidth + i5, this.dlK + i7);
            i6++;
            i5 = i5 + this.mItemWidth + (this.fUZ * 2);
            if (i6 >= this.nLC) {
                i5 = this.fUZ;
                i6 = 0;
            }
            i7 = ((i8 + 1) / this.nLC) * this.dlK;
        }
    }

    private void dx(int i, int i2) {
        int i3 = i2 - i;
        if (l.getEquipmentWidth(TbadkCoreApplication.getInst()) > 800 && this.mItemWidth * 5 <= i3) {
            this.nLC = 5;
        } else {
            this.nLC = 4;
        }
        double d = i3 - (this.mItemWidth * this.nLC);
        if (d > 0.0d) {
            if (this.nLC == 5) {
                this.fUZ = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.fUZ = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.fUZ = 0;
    }
}
