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
    private View HH;
    private int HI;
    private float HJ;
    private float HK;
    private boolean HM;
    private float HN;
    private float HO;
    private final int HP;
    private final int HQ;
    private b eCD;
    public a eCE;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ld();

        void le();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HM = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HP = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.HQ = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HH = view;
        this.HI = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.HH == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HK = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HH.getHeight();
                    this.HJ = this.HK;
                    this.HN = this.HO;
                    this.eCD = new b(0, height, 0, this.HQ + height);
                    break;
                case 1:
                case 3:
                    if (this.HM) {
                        lb();
                        break;
                    } else {
                        this.eCE.ld();
                        break;
                    }
                case 2:
                    float f = this.HO - this.HN;
                    float f2 = this.HK - this.HJ;
                    this.HN = this.HO;
                    if (this.HH.getParent() == this && this.eCD != null && this.HH.isShown() && this.HH.getTop() >= 0 && Math.abs(f2) >= this.HP && Math.abs(f) < this.HP) {
                        int H = this.eCD.H(this.HK - this.HJ);
                        if (H > this.eCD.HU && H <= this.eCD.HW) {
                            this.HM = true;
                            this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), H));
                            F(H - this.eCD.HU);
                            break;
                        } else if (H <= this.eCD.HU) {
                            this.HM = false;
                            break;
                        } else if (H > this.eCD.HW) {
                            this.HM = true;
                            break;
                        } else {
                            this.HM = false;
                            break;
                        }
                    } else {
                        this.HM = false;
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
        if (this.HM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HM) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lb() {
        if (this.eCD != null) {
            if (this.HH.getHeight() >= this.eCD.HW - (this.HQ / 2)) {
                lc();
            } else {
                this.eCE.ld();
            }
            this.mScroller.startScroll(0, this.HH.getHeight(), 0, this.eCD.HU - this.HH.getHeight(), 200);
            invalidate();
            this.HM = false;
        }
    }

    public void lc() {
        if (this.eCE != null) {
            this.eCE.le();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eCE = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HH.setLayoutParams(new AbsListView.LayoutParams(this.HH.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eCE.G(360.0f - ((f * 360.0f) / this.HQ));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HT;
        public int HU;
        public int HV;
        public int HW;

        public b(int i, int i2, int i3, int i4) {
            this.HT = i;
            this.HU = i2;
            this.HV = i3;
            this.HW = i4;
        }

        public int H(float f) {
            return (int) (this.HU + (f / 2.5f));
        }
    }
}
