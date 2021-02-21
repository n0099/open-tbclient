package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Scroller;
/* loaded from: classes8.dex */
public class ExpandGridView extends GridView {
    private Scroller mScroller;
    private boolean nMe;
    private a nMf;
    private boolean nMg;

    /* loaded from: classes8.dex */
    public interface a {
        void bb(float f);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.nMe = false;
        this.nMg = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nMe = false;
        this.nMg = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nMe = false;
        this.nMg = false;
        this.mScroller = new Scroller(context);
    }

    public void setScrollCallBack(a aVar) {
        this.nMf = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.nMe = false;
        } else {
            this.nMe = true;
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
            this.nMg = true;
            int currY = this.mScroller.getCurrY();
            if (this.nMf != null) {
                this.nMf.bb(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        } else {
            this.nMg = false;
        }
        super.computeScroll();
    }
}
