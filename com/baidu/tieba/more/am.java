package com.baidu.tieba.more;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class am {
    private int bsR;
    private Runnable bsS = new an(this);
    private int height;
    private boolean iC;
    private Scroller mScroller;
    private View mView;
    private int vu;

    public am(View view, int i) {
        this.mView = view;
        this.mScroller = new Scroller(view.getContext(), new DecelerateInterpolator());
        this.bsR = view.getPaddingTop();
        this.height = -view.getMeasuredHeight();
        this.vu = i;
        if (view.getVisibility() != 0) {
            this.iC = false;
        } else {
            this.iC = true;
        }
    }

    public void show() {
        if (!this.iC) {
            this.iC = true;
            int paddingLeft = this.mView.getPaddingLeft();
            int paddingTop = this.mView.getPaddingTop() == this.bsR ? -this.mView.getMeasuredHeight() : this.mView.getPaddingTop();
            int paddingRight = this.mView.getPaddingRight();
            int paddingBottom = this.mView.getPaddingBottom();
            this.mView.setVisibility(0);
            this.mView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
                this.mView.removeCallbacks(this.bsS);
            }
            int paddingTop2 = this.mView.getPaddingTop();
            this.mScroller.startScroll(paddingTop2, 0, this.bsR - paddingTop2, 0, this.vu);
            this.mView.post(this.bsS);
        }
    }

    public void hide() {
        if (this.iC) {
            this.iC = false;
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
                this.mView.removeCallbacks(this.bsS);
            }
            int paddingTop = this.mView.getPaddingTop();
            this.mScroller.startScroll(paddingTop, 0, this.height - paddingTop, 0, this.vu);
            this.mView.post(this.bsS);
        }
    }
}
