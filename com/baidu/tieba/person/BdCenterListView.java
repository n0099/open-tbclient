package com.baidu.tieba.person;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BdCenterListView extends BdListView {
    public e a;
    private final Context b;
    private final Scroller c;
    private int d;
    private final int e;
    private final int f;
    private final int g;
    private View h;
    private BdCenterImageView i;
    private ImageView j;
    private float k;
    private float l;
    private int m;
    private f n;
    private boolean o;
    private float p;
    private float q;
    private float r;
    private final int s;
    private boolean t;
    private RotateAnimation u;

    public BdCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
        this.p = 360.0f;
        this.t = false;
        this.b = context;
        this.c = new Scroller(this.b);
        this.e = (int) TypedValue.applyDimension(1, 370.0f, getResources().getDisplayMetrics());
        this.f = (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics());
        this.g = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
        this.s = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setHeaderView(View view) {
        this.h = view;
        this.i = (BdCenterImageView) this.h.findViewById(R.id.user_info_center_head_cover_im);
        this.j = (ImageView) this.h.findViewById(R.id.user_info_center_head_progress);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.c.isFinished()) {
            if (this.i != null && this.i.getEditable()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.l = motionEvent.getY();
            switch (action) {
                case 0:
                    this.m = this.i.getBottom();
                    this.d = this.i.getHeight();
                    this.k = this.l;
                    this.q = this.r;
                    this.n = new f(this, this.i.getLeft(), this.i.getBottom());
                    break;
                case 1:
                case 3:
                    if (this.o) {
                        this.c.startScroll(this.i.getLeft(), this.i.getBottom(), 0 - this.i.getLeft(), this.d - this.i.getBottom(), 200);
                        invalidate();
                        this.o = false;
                    }
                    this.o = false;
                    break;
                case 2:
                    float f = this.r - this.q;
                    float f2 = this.l - this.k;
                    this.q = this.r;
                    if (this.n != null && this.h.isShown() && this.h.getTop() >= 0 && Math.abs(f2) >= this.s && Math.abs(f) < this.s) {
                        int a = this.n.a(this.l - this.k);
                        if (a > this.m && a <= this.e) {
                            this.o = true;
                            if (!this.j.isShown() && a >= this.i.a + this.g) {
                                this.j.setVisibility(0);
                                this.j.setImageDrawable(getResources().getDrawable(R.drawable.icon_pop_refresh));
                            }
                            this.i.setLayoutParams(new RelativeLayout.LayoutParams(this.i.getWidth(), a));
                            float f3 = 360.0f - ((a - this.i.a) * 1.8f);
                            RotateAnimation rotateAnimation = new RotateAnimation(this.p, f3, 1, 0.5f, 1, 0.5f);
                            rotateAnimation.setFillBefore(true);
                            rotateAnimation.setFillAfter(true);
                            this.j.startAnimation(rotateAnimation);
                            this.p = f3;
                        } else if (a > this.m && a > this.e) {
                            this.o = true;
                        } else {
                            this.o = false;
                        }
                        if (!this.o) {
                            this.j.setImageDrawable(null);
                            this.j.setVisibility(8);
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.j.setImageDrawable(null);
                    this.j.setVisibility(8);
                    this.o = false;
                    break;
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.o) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.o) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void c() {
        if (!this.t) {
            this.t = true;
            if (this.j.getVisibility() == 8) {
                this.j.setVisibility(0);
                this.j.setImageDrawable(getResources().getDrawable(R.drawable.icon_pop_refresh));
            }
            this.u = (RotateAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.user_info_center_head_rotate);
            this.j.startAnimation(this.u);
            if (this.a != null) {
                this.a.a();
            }
        }
    }

    public void setCoverListRefreshListener(e eVar) {
        this.a = eVar;
    }

    public final void d() {
        if (this.u != null) {
            postDelayed(new d(this), 500L);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.c.computeScrollOffset()) {
            int currY = this.c.getCurrY();
            if (currY >= this.e - this.f) {
                c();
            } else if (!this.t) {
                this.j.setImageDrawable(null);
                this.j.setVisibility(8);
            }
            this.i.setLayoutParams(new RelativeLayout.LayoutParams(this.i.getWidth(), currY));
        }
    }
}
