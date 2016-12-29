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
    private View Bg;
    private int Bh;
    private float Bi;
    private float Bj;
    private boolean Bl;
    private float Bm;
    private float Bn;
    private final int Bo;
    private final int Bp;
    private b eoY;
    public a eoZ;
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
        this.Bl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.ExpandListView);
        this.Bp = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bg = view;
        this.Bh = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Bg == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Bj = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Bg.getHeight();
                    this.Bi = this.Bj;
                    this.Bm = this.Bn;
                    this.eoY = new b(0, height, 0, this.Bp + height);
                    break;
                case 1:
                case 3:
                    if (this.Bl) {
                        kg();
                        break;
                    } else {
                        this.eoZ.ki();
                        break;
                    }
                case 2:
                    float f = this.Bn - this.Bm;
                    float f2 = this.Bj - this.Bi;
                    this.Bm = this.Bn;
                    if (this.Bg.getParent() == this && this.eoY != null && this.Bg.isShown() && this.Bg.getTop() >= 0 && Math.abs(f2) >= this.Bo && Math.abs(f) < this.Bo) {
                        int H = this.eoY.H(this.Bj - this.Bi);
                        if (H > this.eoY.Bt && H <= this.eoY.Bv) {
                            this.Bl = true;
                            this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), H));
                            F(H - this.eoY.Bt);
                            break;
                        } else if (H <= this.eoY.Bt) {
                            this.Bl = false;
                            break;
                        } else if (H > this.eoY.Bv) {
                            this.Bl = true;
                            break;
                        } else {
                            this.Bl = false;
                            break;
                        }
                    } else {
                        this.Bl = false;
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
        if (this.Bl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Bl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kg() {
        if (this.eoY != null) {
            if (this.Bg.getHeight() >= this.eoY.Bv - (this.Bp / 2)) {
                kh();
            } else {
                this.eoZ.ki();
            }
            this.mScroller.startScroll(0, this.Bg.getHeight(), 0, this.eoY.Bt - this.Bg.getHeight(), 200);
            invalidate();
            this.Bl = false;
        }
    }

    public void kh() {
        if (this.eoZ != null) {
            this.eoZ.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eoZ = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eoZ.G(360.0f - ((f * 360.0f) / this.Bp));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bs;
        public int Bt;
        public int Bu;
        public int Bv;

        public b(int i, int i2, int i3, int i4) {
            this.Bs = i;
            this.Bt = i2;
            this.Bu = i3;
            this.Bv = i4;
        }

        public int H(float f) {
            return (int) (this.Bt + (f / 2.5f));
        }
    }
}
