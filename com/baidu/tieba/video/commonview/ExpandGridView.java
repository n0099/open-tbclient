package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Scroller;
/* loaded from: classes17.dex */
public class ExpandGridView extends GridView {
    private Scroller mScroller;
    private boolean mdg;
    private a mdh;
    private boolean mdi;

    /* loaded from: classes17.dex */
    public interface a {
        void ay(float f);
    }

    public ExpandGridView(Context context) {
        super(context);
        this.mdg = false;
        this.mdi = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdg = false;
        this.mdi = false;
        this.mScroller = new Scroller(context);
    }

    public ExpandGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdg = false;
        this.mdi = false;
        this.mScroller = new Scroller(context);
    }

    public void setScrollCallBack(a aVar) {
        this.mdh = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.mdg = false;
        } else {
            this.mdg = true;
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
            this.mdi = true;
            int currY = this.mScroller.getCurrY();
            if (this.mdh != null) {
                this.mdh.ay(currY);
            }
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = currY;
                setLayoutParams(layoutParams);
            }
        } else {
            this.mdi = false;
        }
        super.computeScroll();
    }
}
