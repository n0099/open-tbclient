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
    private final Scroller frh;
    private View fri;
    private b frj;
    private b frk;
    public a frl;
    private boolean frm;
    private boolean frn;
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
        this.frm = true;
        this.frn = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.frh = new Scroller(this.mContext);
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.GN = view;
    }

    public void setOuterExpandView(View view) {
        this.fri = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GN == null || !this.frm) {
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
                    this.frj = new b(0, height, 0, this.GW + height);
                    int height2 = this.fri.getHeight();
                    this.frk = new b(0, height2, 0, this.GW + height2);
                    break;
                case 1:
                case 3:
                    if (this.GS) {
                        kT();
                        if (this.frn) {
                            return true;
                        }
                    } else {
                        this.frl.kV();
                        break;
                    }
                    break;
                case 2:
                    float f = this.GU - this.GT;
                    float f2 = this.GQ - this.GP;
                    this.GT = this.GU;
                    if (this.GN.getParent() == this && this.frj != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f2) >= this.GV && Math.abs(f) < this.GV) {
                        int w = this.frj.w(this.GQ - this.GP);
                        if (w > this.frj.Ha && w <= this.frj.Hc) {
                            this.GS = true;
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            if (this.fri != null) {
                                int w2 = this.frk.w(this.GQ - this.GP);
                                ViewGroup.LayoutParams layoutParams = this.fri.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = w2;
                                    this.fri.setLayoutParams(layoutParams);
                                }
                            }
                            u(w - this.frj.Ha);
                            break;
                        } else if (w <= this.frj.Ha) {
                            this.GS = false;
                            break;
                        } else if (w > this.frj.Hc) {
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
        if (this.frj != null) {
            if (this.GN.getHeight() >= this.frj.Hc - (this.GW / 2)) {
                kU();
            } else {
                this.frl.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.frj.Ha - this.GN.getHeight(), 200);
            this.frh.startScroll(0, this.fri.getHeight(), 0, this.frk.Ha - this.fri.getHeight(), 200);
            invalidate();
            this.GS = false;
        }
    }

    public void kU() {
        if (this.frl != null) {
            this.frl.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.frl = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.frh.computeScrollOffset()) {
            int currY = this.frh.getCurrY();
            if (this.fri != null && (layoutParams = this.fri.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fri.setLayoutParams(layoutParams);
            }
        }
    }

    private void u(float f) {
        this.frl.v(360.0f - ((f * 360.0f) / this.GW));
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
