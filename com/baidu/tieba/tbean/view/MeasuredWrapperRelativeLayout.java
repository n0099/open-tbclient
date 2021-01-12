package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class MeasuredWrapperRelativeLayout extends RelativeLayout {
    private int lastHeight;
    private a nsS;
    private boolean nsT;

    /* loaded from: classes8.dex */
    public interface a {
        void H(boolean z, int i);
    }

    public MeasuredWrapperRelativeLayout(Context context) {
        this(context, null);
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeasuredWrapperRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        R(getContext(), i2);
        super.onMeasure(i, i2);
    }

    private void R(Context context, int i) {
        int size = View.MeasureSpec.getSize(i);
        if (this.lastHeight == 0) {
            this.lastHeight = size;
        } else if (this.lastHeight != size) {
            int i2 = this.lastHeight - size;
            if (Math.abs(i2) >= context.getResources().getDimensionPixelSize(R.dimen.ds200)) {
                if (i2 > 0) {
                    this.nsT = true;
                } else {
                    this.nsT = false;
                }
                G(this.nsT, Math.abs(i2));
                this.lastHeight = size;
            }
        }
    }

    private void G(boolean z, int i) {
        if (this.nsS != null) {
            this.nsS.H(z, i);
        }
    }

    public void setKeyBoardListener(a aVar) {
        this.nsS = aVar;
    }
}
