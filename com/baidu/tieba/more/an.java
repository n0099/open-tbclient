package com.baidu.tieba.more;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
/* loaded from: classes.dex */
public final class an {
    private View a;
    private Scroller b;
    private int c;
    private int d;
    private boolean f;
    private Runnable g = new ao(this);
    private int e = 500;

    public an(View view, int i) {
        this.a = view;
        this.b = new Scroller(view.getContext(), new DecelerateInterpolator());
        this.c = view.getPaddingTop();
        this.d = -view.getMeasuredHeight();
        if (view.getVisibility() != 0) {
            this.f = false;
        } else {
            this.f = true;
        }
    }

    public final void a() {
        if (!this.f) {
            this.f = true;
            int paddingLeft = this.a.getPaddingLeft();
            int paddingTop = this.a.getPaddingTop() == this.c ? -this.a.getMeasuredHeight() : this.a.getPaddingTop();
            int paddingRight = this.a.getPaddingRight();
            int paddingBottom = this.a.getPaddingBottom();
            this.a.setVisibility(0);
            this.a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (!this.b.isFinished()) {
                this.b.forceFinished(true);
                this.a.removeCallbacks(this.g);
            }
            int paddingTop2 = this.a.getPaddingTop();
            this.b.startScroll(paddingTop2, 0, this.c - paddingTop2, 0, this.e);
            this.a.post(this.g);
        }
    }

    public final void b() {
        if (this.f) {
            this.f = false;
            if (!this.b.isFinished()) {
                this.b.forceFinished(true);
                this.a.removeCallbacks(this.g);
            }
            int paddingTop = this.a.getPaddingTop();
            this.b.startScroll(paddingTop, 0, this.d - paddingTop, 0, this.e);
            this.a.post(this.g);
        }
    }
}
