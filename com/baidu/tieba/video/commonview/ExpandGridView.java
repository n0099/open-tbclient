package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Scroller;
/* loaded from: classes2.dex */
public class ExpandGridView extends GridView {
    private boolean hdb;
    private a hdc;
    private boolean hdd;
    private Scroller mScroller;

    /* loaded from: classes2.dex */
    public interface a {
        void aD(float f);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.hdb = false;
        this.hdd = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdb = false;
        this.hdd = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdb = false;
        this.hdd = false;
        this.mScroller = new Scroller(context);
    }

    public void setScrollCallBack(a aVar) {
        this.hdc = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.hdb = false;
        } else {
            this.hdb = true;
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
            this.hdd = true;
            int currY = this.mScroller.getCurrY();
            if (this.hdc != null) {
                this.hdc.aD(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        } else {
            this.hdd = false;
        }
        super.computeScroll();
    }
}
