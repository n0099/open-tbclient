package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public class BlankView extends View {
    private a fFY;
    private Scroller mScroller;

    /* loaded from: classes2.dex */
    public interface a {
        void axh();
    }

    public void setScrollCallBack(a aVar) {
        this.fFY = aVar;
    }

    public BlankView(Context context) {
        super(context);
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void axl() {
        if (this.mScroller == null) {
            this.mScroller = new Scroller(getContext());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.mScroller.startScroll(0, layoutParams.height, 0, 0 - layoutParams.height);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller != null) {
            if (this.mScroller.computeScrollOffset()) {
                int currY = this.mScroller.getCurrY();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = currY;
                    setLayoutParams(layoutParams);
                }
            } else if (this.fFY != null) {
                this.fFY.axh();
            }
        }
    }
}
