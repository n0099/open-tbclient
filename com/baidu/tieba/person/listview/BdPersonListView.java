package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private b dDV;
    public a dDW;
    private final Context mContext;
    private final Scroller mScroller;
    private View yq;
    private int yr;
    private float ys;
    private float yt;
    private boolean yv;
    private float yw;
    private float yx;
    private final int yy;
    private final int yz;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void jl();

        void jm();

        void k(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yv = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.yy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ExpandListView);
        this.yz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yq = view;
        this.yr = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.yt = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.yq.getHeight();
                    this.ys = this.yt;
                    this.yw = this.yx;
                    this.dDV = new b(0, height, 0, this.yz + height);
                    break;
                case 1:
                case 3:
                    if (this.yv) {
                        jj();
                        break;
                    } else {
                        this.dDW.jl();
                        break;
                    }
                case 2:
                    float f = this.yx - this.yw;
                    float f2 = this.yt - this.ys;
                    this.yw = this.yx;
                    if (this.yq.getParent() == this && this.dDV != null && this.yq.isShown() && this.yq.getTop() >= 0 && Math.abs(f2) >= this.yy && Math.abs(f) < this.yy) {
                        int l = this.dDV.l(this.yt - this.ys);
                        if (l > this.dDV.yD && l <= this.dDV.yF) {
                            this.yv = true;
                            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), l));
                            j(l - this.dDV.yD);
                            break;
                        } else if (l <= this.dDV.yD) {
                            this.yv = false;
                            break;
                        } else if (l > this.dDV.yF) {
                            this.yv = true;
                            break;
                        } else {
                            this.yv = false;
                            break;
                        }
                    } else {
                        this.yv = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.yv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jj() {
        if (this.dDV != null) {
            if (this.yq.getHeight() >= this.dDV.yF - (this.yz / 2)) {
                jk();
            } else {
                this.dDW.jl();
            }
            this.mScroller.startScroll(0, this.yq.getHeight(), 0, this.dDV.yD - this.yq.getHeight(), 200);
            invalidate();
            this.yv = false;
        }
    }

    public void jk() {
        if (this.dDW != null) {
            this.dDW.jm();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.dDW = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.yq.setLayoutParams(new AbsListView.LayoutParams(this.yq.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.dDW.k(360.0f - ((f * 360.0f) / this.yz));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int yC;
        public int yD;
        public int yE;
        public int yF;

        public b(int i, int i2, int i3, int i4) {
            this.yC = i;
            this.yD = i2;
            this.yE = i3;
            this.yF = i4;
        }

        public int l(float f) {
            return (int) (this.yD + (f / 2.5f));
        }
    }
}
