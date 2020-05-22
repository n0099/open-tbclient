package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes9.dex */
public class BlankView extends View {
    private a jYc;
    private Scroller mScroller;

    /* loaded from: classes9.dex */
    public interface a {
        void bZk();
    }

    public void setScrollCallBack(a aVar) {
        this.jYc = aVar;
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

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0);
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
            } else if (this.jYc != null) {
                this.jYc.bZk();
            }
        }
    }
}
