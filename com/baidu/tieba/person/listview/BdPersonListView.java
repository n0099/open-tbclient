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
    private b emO;
    public a emP;
    private final Context mContext;
    private final Scroller mScroller;
    private final int yA;
    private final int yB;
    private View ys;
    private int yt;
    private float yu;
    private float yv;
    private boolean yx;
    private float yy;
    private float yz;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void jo();

        void jp();

        void k(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yx = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.yA = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ExpandListView);
        this.yB = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.ys = view;
        this.yt = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.yv = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.ys.getHeight();
                    this.yu = this.yv;
                    this.yy = this.yz;
                    this.emO = new b(0, height, 0, this.yB + height);
                    break;
                case 1:
                case 3:
                    if (this.yx) {
                        jm();
                        break;
                    } else {
                        this.emP.jo();
                        break;
                    }
                case 2:
                    float f = this.yz - this.yy;
                    float f2 = this.yv - this.yu;
                    this.yy = this.yz;
                    if (this.ys.getParent() == this && this.emO != null && this.ys.isShown() && this.ys.getTop() >= 0 && Math.abs(f2) >= this.yA && Math.abs(f) < this.yA) {
                        int l = this.emO.l(this.yv - this.yu);
                        if (l > this.emO.startY && l <= this.emO.yE) {
                            this.yx = true;
                            this.ys.setLayoutParams(new AbsListView.LayoutParams(this.ys.getWidth(), l));
                            j(l - this.emO.startY);
                            break;
                        } else if (l <= this.emO.startY) {
                            this.yx = false;
                            break;
                        } else if (l > this.emO.yE) {
                            this.yx = true;
                            break;
                        } else {
                            this.yx = false;
                            break;
                        }
                    } else {
                        this.yx = false;
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
        if (this.yx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.yx) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jm() {
        if (this.emO != null) {
            if (this.ys.getHeight() >= this.emO.yE - (this.yB / 2)) {
                jn();
            } else {
                this.emP.jo();
            }
            this.mScroller.startScroll(0, this.ys.getHeight(), 0, this.emO.startY - this.ys.getHeight(), 200);
            invalidate();
            this.yx = false;
        }
    }

    public void jn() {
        if (this.emP != null) {
            this.emP.jp();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.emP = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.ys.setLayoutParams(new AbsListView.LayoutParams(this.ys.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.emP.k(360.0f - ((f * 360.0f) / this.yB));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int startX;
        public int startY;
        public int yE;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.yE = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
