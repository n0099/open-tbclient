package com.baidu.tieba.more;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
/* loaded from: classes.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private View f1988a;
    private Scroller b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private Runnable g = new an(this);

    public am(View view, int i) {
        this.f1988a = view;
        this.b = new Scroller(view.getContext(), new DecelerateInterpolator());
        this.c = view.getPaddingTop();
        this.d = -view.getMeasuredHeight();
        this.e = i;
        if (view.getVisibility() != 0) {
            this.f = false;
        } else {
            this.f = true;
        }
    }

    public void a() {
        if (!this.f) {
            this.f = true;
            int paddingLeft = this.f1988a.getPaddingLeft();
            int paddingTop = this.f1988a.getPaddingTop() == this.c ? -this.f1988a.getMeasuredHeight() : this.f1988a.getPaddingTop();
            int paddingRight = this.f1988a.getPaddingRight();
            int paddingBottom = this.f1988a.getPaddingBottom();
            this.f1988a.setVisibility(0);
            this.f1988a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (!this.b.isFinished()) {
                this.b.forceFinished(true);
                this.f1988a.removeCallbacks(this.g);
            }
            int paddingTop2 = this.f1988a.getPaddingTop();
            this.b.startScroll(paddingTop2, 0, this.c - paddingTop2, 0, this.e);
            this.f1988a.post(this.g);
        }
    }

    public void b() {
        if (this.f) {
            this.f = false;
            if (!this.b.isFinished()) {
                this.b.forceFinished(true);
                this.f1988a.removeCallbacks(this.g);
            }
            int paddingTop = this.f1988a.getPaddingTop();
            this.b.startScroll(paddingTop, 0, this.d - paddingTop, 0, this.e);
            this.f1988a.post(this.g);
        }
    }
}
