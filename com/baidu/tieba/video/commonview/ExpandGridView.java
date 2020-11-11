package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Scroller;
/* loaded from: classes23.dex */
public class ExpandGridView extends GridView {
    private Scroller mScroller;
    private boolean nng;
    private a nnh;
    private boolean nni;

    /* loaded from: classes23.dex */
    public interface a {
        void aO(float f);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.nng = false;
        this.nni = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nng = false;
        this.nni = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nng = false;
        this.nni = false;
        this.mScroller = new Scroller(context);
    }

    public void setScrollCallBack(a aVar) {
        this.nnh = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.nng = false;
        } else {
            this.nng = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.nni = true;
            int currY = this.mScroller.getCurrY();
            if (this.nnh != null) {
                this.nnh.aO(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        } else {
            this.nni = false;
        }
        super.computeScroll();
    }
}
