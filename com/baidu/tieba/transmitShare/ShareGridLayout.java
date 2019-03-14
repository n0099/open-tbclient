package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class ShareGridLayout extends ViewGroup {
    public static final int iTE = l.h(TbadkCoreApplication.getInst(), d.e.tbds44);
    private int bIj;
    private int czH;
    private int iTF;
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
        this.bIj = i;
        this.mItemHeight = i2;
        requestLayout();
    }

    private void init(Context context) {
        this.mContext = context;
        cs(0, l.aO(this.mContext) - (iTE * 2));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.bIj, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (childCount <= this.iTF) {
            setMeasuredDimension(resolveSize((this.bIj * this.iTF) + (this.czH * 2 * this.iTF), i), resolveSize(this.mItemHeight, i2));
            return;
        }
        int i4 = childCount / this.iTF;
        if (childCount % this.iTF > 0) {
            i4++;
        }
        setMeasuredDimension(resolveSize((this.bIj * this.iTF) + (this.czH * 2 * this.iTF), i), resolveSize(i4 * this.mItemHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        cs(i, i3);
        int i5 = this.czH;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = i5;
        int i9 = 0;
        while (i6 < childCount) {
            getChildAt(i6).layout(i8, i9, this.bIj + i8, this.mItemHeight + i9);
            i7++;
            int i10 = this.bIj + i8 + (this.czH * 2);
            if (i7 >= this.iTF) {
                i10 = this.czH;
                i7 = 0;
            }
            int i11 = ((i6 + 1) / this.iTF) * this.mItemHeight;
            i6++;
            i8 = i10;
            i9 = i11;
        }
    }

    private void cs(int i, int i2) {
        int i3 = i2 - i;
        if (l.aO(TbadkCoreApplication.getInst()) > 800 && this.bIj * 5 <= i3) {
            this.iTF = 5;
        } else {
            this.iTF = 4;
        }
        double d = i3 - (this.bIj * this.iTF);
        if (d > 0.0d) {
            if (this.iTF == 5) {
                this.czH = (int) Math.floor(d / 10.0d);
                return;
            } else {
                this.czH = (int) Math.floor(d / 8.0d);
                return;
            }
        }
        this.czH = 0;
    }
}
