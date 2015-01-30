package com.baidu.tieba.more;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class ax {
    private int bxZ;
    private Runnable bya = new ay(this);
    private int height;
    private boolean isShow;
    private int mDuration;
    private Scroller mScroller;
    private View mView;

    public ax(View view, int i) {
        this.mView = view;
        this.mScroller = new Scroller(view.getContext(), new DecelerateInterpolator());
        this.bxZ = view.getPaddingTop();
        this.height = -view.getMeasuredHeight();
        this.mDuration = i;
        if (view.getVisibility() != 0) {
            this.isShow = false;
        } else {
            this.isShow = true;
        }
    }

    public void show() {
        if (!this.isShow) {
            this.isShow = true;
            int paddingLeft = this.mView.getPaddingLeft();
            int paddingTop = this.mView.getPaddingTop() == this.bxZ ? -this.mView.getMeasuredHeight() : this.mView.getPaddingTop();
            int paddingRight = this.mView.getPaddingRight();
            int paddingBottom = this.mView.getPaddingBottom();
            this.mView.setVisibility(0);
            this.mView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
                this.mView.removeCallbacks(this.bya);
            }
            int paddingTop2 = this.mView.getPaddingTop();
            this.mScroller.startScroll(paddingTop2, 0, this.bxZ - paddingTop2, 0, this.mDuration);
            this.mView.post(this.bya);
        }
    }

    public void hide() {
        if (this.isShow) {
            this.isShow = false;
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
                this.mView.removeCallbacks(this.bya);
            }
            int paddingTop = this.mView.getPaddingTop();
            this.mScroller.startScroll(paddingTop, 0, this.height - paddingTop, 0, this.mDuration);
            this.mView.post(this.bya);
        }
    }
}
