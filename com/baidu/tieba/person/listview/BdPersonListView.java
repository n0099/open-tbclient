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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private b exn;
    public a exo;
    private final Context mContext;
    private final Scroller mScroller;
    private View yT;
    private int yU;
    private float yV;
    private float yW;
    private boolean yY;
    private float yZ;
    private float za;
    private final int zb;
    private final int zc;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.leftOffset, R.attr.rightOffset};

    /* loaded from: classes.dex */
    public interface a {
        void jn();

        void jo();

        void u(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yY = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.zb = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.ExpandListView);
        this.zc = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.yT = view;
        this.yU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.yT == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.yW = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.yT.getHeight();
                    this.yV = this.yW;
                    this.yZ = this.za;
                    this.exn = new b(0, height, 0, this.zc + height);
                    break;
                case 1:
                case 3:
                    if (this.yY) {
                        jl();
                        break;
                    } else {
                        this.exo.jn();
                        break;
                    }
                case 2:
                    float f = this.za - this.yZ;
                    float f2 = this.yW - this.yV;
                    this.yZ = this.za;
                    if (this.yT.getParent() == this && this.exn != null && this.yT.isShown() && this.yT.getTop() >= 0 && Math.abs(f2) >= this.zb && Math.abs(f) < this.zb) {
                        int v = this.exn.v(this.yW - this.yV);
                        if (v > this.exn.startY && v <= this.exn.zf) {
                            this.yY = true;
                            this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), v));
                            t(v - this.exn.startY);
                            break;
                        } else if (v <= this.exn.startY) {
                            this.yY = false;
                            break;
                        } else if (v > this.exn.zf) {
                            this.yY = true;
                            break;
                        } else {
                            this.yY = false;
                            break;
                        }
                    } else {
                        this.yY = false;
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
        if (this.yY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yY) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jl() {
        if (this.exn != null) {
            if (this.yT.getHeight() >= this.exn.zf - (this.zc / 2)) {
                jm();
            } else {
                this.exo.jn();
            }
            this.mScroller.startScroll(0, this.yT.getHeight(), 0, this.exn.startY - this.yT.getHeight(), 200);
            invalidate();
            this.yY = false;
        }
    }

    public void jm() {
        if (this.exo != null) {
            this.exo.jo();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.exo = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.yT.setLayoutParams(new AbsListView.LayoutParams(this.yT.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void t(float f) {
        this.exo.u(360.0f - ((f * 360.0f) / this.zc));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int startX;
        public int startY;
        public int zf;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.zf = i4;
        }

        public int v(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
