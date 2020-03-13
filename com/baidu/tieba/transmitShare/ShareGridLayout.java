package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int kud = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    private int dLM;
    private int kue;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

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
        cO(0, l.getEquipmentWidth(this.mContext) - (kud * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.kue) {
            setMeasuredDimension(resolveSize((this.mItemWidth * this.kue) + (this.dLM * 2 * this.kue), i), resolveSize(this.mItemHeight, i2));
            return;
        }
        int i4 = childCount / this.kue;
        if (childCount % this.kue > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.mItemWidth * this.kue) + (this.dLM * 2 * this.kue), i), resolveSize(i4 * this.mItemHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        cO(i, i3);
        int i5 = this.dLM;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i8, i9, this.mItemWidth + i8, this.mItemHeight + i9);
            i7++;
            int i10 = this.mItemWidth + i8 + (this.dLM * 2);
            if (i7 >= this.kue) {
                i10 = this.dLM;
                i7 = 0;
            }
            int i11 = ((i6 + 1) / this.kue) * this.mItemHeight;
            i6++;
            i8 = i10;
            i9 = i11;
        }
    }

    private void cO(int i, int i2) {
        int i3 = i2 - i;
        if (l.getEquipmentWidth(TbadkCoreApplication.getInst()) > 800 && this.mItemWidth * 5 <= i3) {
            this.kue = 5;
        } else {
            this.kue = 4;
        }
        double d = i3 - (this.mItemWidth * this.kue);
        if (d > 0.0d) {
            if (this.kue == 5) {
                this.dLM = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.dLM = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.dLM = 0;
    }
}
