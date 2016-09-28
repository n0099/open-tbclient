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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View Bi;
    private int Bj;
    private float Bk;
    private float Bl;
    private boolean Bn;
    private float Bo;
    private float Bp;
    private final int Bq;
    private final int Br;
    private b eFd;
    public a eFe;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ki();

        void kj();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bn = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.ExpandListView);
        this.Br = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bi = view;
        this.Bj = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Bi == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Bl = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Bi.getHeight();
                    this.Bk = this.Bl;
                    this.Bo = this.Bp;
                    this.eFd = new b(0, height, 0, this.Br + height);
                    break;
                case 1:
                case 3:
                    if (this.Bn) {
                        kg();
                        break;
                    } else {
                        this.eFe.ki();
                        break;
                    }
                case 2:
                    float f = this.Bp - this.Bo;
                    float f2 = this.Bl - this.Bk;
                    this.Bo = this.Bp;
                    if (this.Bi.getParent() == this && this.eFd != null && this.Bi.isShown() && this.Bi.getTop() >= 0 && Math.abs(f2) >= this.Bq && Math.abs(f) < this.Bq) {
                        int H = this.eFd.H(this.Bl - this.Bk);
                        if (H > this.eFd.startY && H <= this.eFd.Bu) {
                            this.Bn = true;
                            this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), H));
                            F(H - this.eFd.startY);
                            break;
                        } else if (H <= this.eFd.startY) {
                            this.Bn = false;
                            break;
                        } else if (H > this.eFd.Bu) {
                            this.Bn = true;
                            break;
                        } else {
                            this.Bn = false;
                            break;
                        }
                    } else {
                        this.Bn = false;
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
        if (this.Bn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Bn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kg() {
        if (this.eFd != null) {
            if (this.Bi.getHeight() >= this.eFd.Bu - (this.Br / 2)) {
                kh();
            } else {
                this.eFe.ki();
            }
            this.mScroller.startScroll(0, this.Bi.getHeight(), 0, this.eFd.startY - this.Bi.getHeight(), 200);
            invalidate();
            this.Bn = false;
        }
    }

    public void kh() {
        if (this.eFe != null) {
            this.eFe.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eFe = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Bi.setLayoutParams(new AbsListView.LayoutParams(this.Bi.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eFe.G(360.0f - ((f * 360.0f) / this.Br));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bu;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Bu = i4;
        }

        public int H(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
