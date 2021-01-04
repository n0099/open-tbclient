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
    private a nGA;
    private boolean nGB;
    private boolean nGz;

    /* loaded from: classes8.dex */
    public interface a {
        void aY(float f);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.nGz = false;
        this.nGB = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nGz = false;
        this.nGB = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nGz = false;
        this.nGB = false;
        this.mScroller = new Scroller(context);
    }

    public void setScrollCallBack(a aVar) {
        this.nGA = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.nGz = false;
        } else {
            this.nGz = true;
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
            this.nGB = true;
            int currY = this.mScroller.getCurrY();
            if (this.nGA != null) {
                this.nGA.aY(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        } else {
            this.nGB = false;
        }
        super.computeScroll();
    }
}
