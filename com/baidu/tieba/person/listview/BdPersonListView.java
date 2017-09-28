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
    private View Hr;
    private float Ht;
    private float Hu;
    private boolean Hw;
    private float Hx;
    private float Hy;
    private final int Hz;
    private final Scroller eZM;
    private View eZN;
    private b eZO;
    private b eZP;
    public a eZQ;
    private boolean eZR;
    private boolean eZS;
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
        this.Hw = false;
        this.eZR = true;
        this.eZS = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.eZM = new Scroller(this.mContext);
        this.Hz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HA = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Hr = view;
    }

    public void setOuterExpandView(View view) {
        this.eZN = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.eZR = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Hr == null || !this.eZR) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hu = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hr.getHeight();
                    this.Ht = this.Hu;
                    this.Hx = this.Hy;
                    this.eZO = new b(0, height, 0, this.HA + height);
                    int height2 = this.eZN.getHeight();
                    this.eZP = new b(0, height2, 0, this.HA + height2);
                    break;
                case 1:
                case 3:
                    if (this.Hw) {
                        kZ();
                        if (this.eZS) {
                            return true;
                        }
                    } else {
                        this.eZQ.lb();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Hy - this.Hx;
                    float f2 = this.Hu - this.Ht;
                    this.Hx = this.Hy;
                    if (this.Hr.getParent() == this && this.eZO != null && this.Hr.isShown() && this.Hr.getTop() >= 0 && Math.abs(f2) >= this.Hz && Math.abs(f) < this.Hz) {
                        int x = this.eZO.x(this.Hu - this.Ht);
                        if (x > this.eZO.HE && x <= this.eZO.HG) {
                            this.Hw = true;
                            this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), x));
                            if (this.eZN != null) {
                                int x2 = this.eZP.x(this.Hu - this.Ht);
                                ViewGroup.LayoutParams layoutParams = this.eZN.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = x2;
                                    this.eZN.setLayoutParams(layoutParams);
                                }
                            }
                            v(x - this.eZO.HE);
                            break;
                        } else if (x <= this.eZO.HE) {
                            this.Hw = false;
                            break;
                        } else if (x > this.eZO.HG) {
                            this.Hw = true;
                            break;
                        } else {
                            this.Hw = false;
                            break;
                        }
                    } else {
                        this.Hw = false;
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
        if (this.Hw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kZ() {
        if (this.eZO != null) {
            if (this.Hr.getHeight() >= this.eZO.HG - (this.HA / 2)) {
                la();
            } else {
                this.eZQ.lb();
            }
            this.mScroller.startScroll(0, this.Hr.getHeight(), 0, this.eZO.HE - this.Hr.getHeight(), 200);
            this.eZM.startScroll(0, this.eZN.getHeight(), 0, this.eZP.HE - this.eZN.getHeight(), 200);
            invalidate();
            this.Hw = false;
        }
    }

    public void la() {
        if (this.eZQ != null) {
            this.eZQ.lc();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eZQ = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.eZM.computeScrollOffset()) {
            int currY = this.eZM.getCurrY();
            if (this.eZN != null && (layoutParams = this.eZN.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.eZN.setLayoutParams(layoutParams);
            }
        }
    }

    private void v(float f) {
        this.eZQ.w(360.0f - ((f * 360.0f) / this.HA));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HD;
        public int HE;
        public int HF;
        public int HG;

        public b(int i, int i2, int i3, int i4) {
            this.HD = i;
            this.HE = i2;
            this.HF = i3;
            this.HG = i4;
        }

        public int x(float f) {
            return (int) (this.HE + (f / 2.5f));
        }
    }
}
