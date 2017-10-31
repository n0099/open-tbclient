package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View GN;
    private float GP;
    private float GQ;
    private boolean GS;
    private float GT;
    private float GU;
    private final int GV;
    private final int GW;
    private final Scroller fhN;
    private View fhO;
    private b fhP;
    private b fhQ;
    public a fhR;
    private boolean fhS;
    private boolean fhT;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = false;
        this.fhS = true;
        this.fhT = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fhN = new Scroller(this.mContext);
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.GN = view;
    }

    public void setOuterExpandView(View view) {
        this.fhO = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GN == null || !this.fhS) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GQ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.GT = this.GU;
                    this.fhP = new b(0, height, 0, this.GW + height);
                    int height2 = this.fhO.getHeight();
                    this.fhQ = new b(0, height2, 0, this.GW + height2);
                    break;
                case 1:
                case 3:
                    if (this.GS) {
                        kT();
                        if (this.fhT) {
                            return true;
                        }
                    } else {
                        this.fhR.kV();
                        break;
                    }
                    break;
                case 2:
                    float f = this.GU - this.GT;
                    float f2 = this.GQ - this.GP;
                    this.GT = this.GU;
                    if (this.GN.getParent() == this && this.fhP != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f2) >= this.GV && Math.abs(f) < this.GV) {
                        int w = this.fhP.w(this.GQ - this.GP);
                        if (w > this.fhP.Ha && w <= this.fhP.Hc) {
                            this.GS = true;
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            if (this.fhO != null) {
                                int w2 = this.fhQ.w(this.GQ - this.GP);
                                ViewGroup.LayoutParams layoutParams = this.fhO.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = w2;
                                    this.fhO.setLayoutParams(layoutParams);
                                }
                            }
                            u(w - this.fhP.Ha);
                            break;
                        } else if (w <= this.fhP.Ha) {
                            this.GS = false;
                            break;
                        } else if (w > this.fhP.Hc) {
                            this.GS = true;
                            break;
                        } else {
                            this.GS = false;
                            break;
                        }
                    } else {
                        this.GS = false;
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
        if (this.GS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GS) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kT() {
        if (this.fhP != null) {
            if (this.GN.getHeight() >= this.fhP.Hc - (this.GW / 2)) {
                kU();
            } else {
                this.fhR.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.fhP.Ha - this.GN.getHeight(), 200);
            this.fhN.startScroll(0, this.fhO.getHeight(), 0, this.fhQ.Ha - this.fhO.getHeight(), 200);
            invalidate();
            this.GS = false;
        }
    }

    public void kU() {
        if (this.fhR != null) {
            this.fhR.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fhR = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fhN.computeScrollOffset()) {
            int currY = this.fhN.getCurrY();
            if (this.fhO != null && (layoutParams = this.fhO.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fhO.setLayoutParams(layoutParams);
            }
        }
    }

    private void u(float f) {
        this.fhR.v(360.0f - ((f * 360.0f) / this.GW));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int GZ;
        public int Ha;
        public int Hb;
        public int Hc;

        public b(int i, int i2, int i3, int i4) {
            this.GZ = i;
            this.Ha = i2;
            this.Hb = i3;
            this.Hc = i4;
        }

        public int w(float f) {
            return (int) (this.Ha + (f / 2.5f));
        }
    }
}
