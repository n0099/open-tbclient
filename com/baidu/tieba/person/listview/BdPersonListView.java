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
    private final int HA;
    private final int HB;
    private View Hs;
    private float Hu;
    private float Hv;
    private boolean Hx;
    private float Hy;
    private float Hz;
    private b eZA;
    private b eZB;
    public a eZC;
    private boolean eZD;
    private boolean eZE;
    private final Scroller eZy;
    private View eZz;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void lb();

        void lc();

        void w(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = false;
        this.eZD = true;
        this.eZE = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.eZy = new Scroller(this.mContext);
        this.HA = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HB = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Hs = view;
    }

    public void setOuterExpandView(View view) {
        this.eZz = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.eZD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Hs == null || !this.eZD) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hv = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hs.getHeight();
                    this.Hu = this.Hv;
                    this.Hy = this.Hz;
                    this.eZA = new b(0, height, 0, this.HB + height);
                    int height2 = this.eZz.getHeight();
                    this.eZB = new b(0, height2, 0, this.HB + height2);
                    break;
                case 1:
                case 3:
                    if (this.Hx) {
                        kZ();
                        if (this.eZE) {
                            return true;
                        }
                    } else {
                        this.eZC.lb();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Hz - this.Hy;
                    float f2 = this.Hv - this.Hu;
                    this.Hy = this.Hz;
                    if (this.Hs.getParent() == this && this.eZA != null && this.Hs.isShown() && this.Hs.getTop() >= 0 && Math.abs(f2) >= this.HA && Math.abs(f) < this.HA) {
                        int x = this.eZA.x(this.Hv - this.Hu);
                        if (x > this.eZA.HF && x <= this.eZA.HH) {
                            this.Hx = true;
                            this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), x));
                            if (this.eZz != null) {
                                int x2 = this.eZB.x(this.Hv - this.Hu);
                                ViewGroup.LayoutParams layoutParams = this.eZz.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = x2;
                                    this.eZz.setLayoutParams(layoutParams);
                                }
                            }
                            v(x - this.eZA.HF);
                            break;
                        } else if (x <= this.eZA.HF) {
                            this.Hx = false;
                            break;
                        } else if (x > this.eZA.HH) {
                            this.Hx = true;
                            break;
                        } else {
                            this.Hx = false;
                            break;
                        }
                    } else {
                        this.Hx = false;
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
        if (this.Hx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hx) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kZ() {
        if (this.eZA != null) {
            if (this.Hs.getHeight() >= this.eZA.HH - (this.HB / 2)) {
                la();
            } else {
                this.eZC.lb();
            }
            this.mScroller.startScroll(0, this.Hs.getHeight(), 0, this.eZA.HF - this.Hs.getHeight(), 200);
            this.eZy.startScroll(0, this.eZz.getHeight(), 0, this.eZB.HF - this.eZz.getHeight(), 200);
            invalidate();
            this.Hx = false;
        }
    }

    public void la() {
        if (this.eZC != null) {
            this.eZC.lc();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eZC = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Hs.setLayoutParams(new AbsListView.LayoutParams(this.Hs.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.eZy.computeScrollOffset()) {
            int currY = this.eZy.getCurrY();
            if (this.eZz != null && (layoutParams = this.eZz.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.eZz.setLayoutParams(layoutParams);
            }
        }
    }

    private void v(float f) {
        this.eZC.w(360.0f - ((f * 360.0f) / this.HB));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HE;
        public int HF;
        public int HG;
        public int HH;

        public b(int i, int i2, int i3, int i4) {
            this.HE = i;
            this.HF = i2;
            this.HG = i3;
            this.HH = i4;
        }

        public int x(float f) {
            return (int) (this.HF + (f / 2.5f));
        }
    }
}
