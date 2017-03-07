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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View Ie;
    private int If;
    private float Ig;
    private float Ih;
    private boolean Ij;
    private float Ik;
    private float Il;
    private final int Im;
    private final int In;
    private b eCs;
    public a eCt;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void kY();

        void kZ();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ij = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Im = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.In = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ie = view;
        this.If = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ie == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ih = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ie.getHeight();
                    this.Ig = this.Ih;
                    this.Ik = this.Il;
                    this.eCs = new b(0, height, 0, this.In + height);
                    break;
                case 1:
                case 3:
                    if (this.Ij) {
                        kW();
                        break;
                    } else {
                        this.eCt.kY();
                        break;
                    }
                case 2:
                    float f = this.Il - this.Ik;
                    float f2 = this.Ih - this.Ig;
                    this.Ik = this.Il;
                    if (this.Ie.getParent() == this && this.eCs != null && this.Ie.isShown() && this.Ie.getTop() >= 0 && Math.abs(f2) >= this.Im && Math.abs(f) < this.Im) {
                        int H = this.eCs.H(this.Ih - this.Ig);
                        if (H > this.eCs.Ir && H <= this.eCs.It) {
                            this.Ij = true;
                            this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), H));
                            F(H - this.eCs.Ir);
                            break;
                        } else if (H <= this.eCs.Ir) {
                            this.Ij = false;
                            break;
                        } else if (H > this.eCs.It) {
                            this.Ij = true;
                            break;
                        } else {
                            this.Ij = false;
                            break;
                        }
                    } else {
                        this.Ij = false;
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
        if (this.Ij) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ij) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kW() {
        if (this.eCs != null) {
            if (this.Ie.getHeight() >= this.eCs.It - (this.In / 2)) {
                kX();
            } else {
                this.eCt.kY();
            }
            this.mScroller.startScroll(0, this.Ie.getHeight(), 0, this.eCs.Ir - this.Ie.getHeight(), 200);
            invalidate();
            this.Ij = false;
        }
    }

    public void kX() {
        if (this.eCt != null) {
            this.eCt.kZ();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eCt = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ie.setLayoutParams(new AbsListView.LayoutParams(this.Ie.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eCt.G(360.0f - ((f * 360.0f) / this.In));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Iq;
        public int Ir;
        public int Is;
        public int It;

        public b(int i, int i2, int i3, int i4) {
            this.Iq = i;
            this.Ir = i2;
            this.Is = i3;
            this.It = i4;
        }

        public int H(float f) {
            return (int) (this.Ir + (f / 2.5f));
        }
    }
}
