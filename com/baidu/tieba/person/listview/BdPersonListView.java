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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View HF;
    private float HH;
    private float HI;
    private boolean HK;
    private float HL;
    private float HM;
    private final int HN;
    private final int HO;
    private b fdr;
    public a fds;
    private boolean fdt;
    private boolean fdu;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void kY();

        void kZ();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HK = false;
        this.fdt = true;
        this.fdu = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HO = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.HF = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.fdt = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.HF == null || !this.fdt) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HI = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HF.getHeight();
                    this.HH = this.HI;
                    this.HL = this.HM;
                    this.fdr = new b(0, height, 0, this.HO + height);
                    break;
                case 1:
                case 3:
                    if (this.HK) {
                        kW();
                        if (this.fdu) {
                            return true;
                        }
                    } else {
                        this.fds.kY();
                        break;
                    }
                    break;
                case 2:
                    float f = this.HM - this.HL;
                    float f2 = this.HI - this.HH;
                    this.HL = this.HM;
                    if (this.HF.getParent() == this && this.fdr != null && this.HF.isShown() && this.HF.getTop() >= 0 && Math.abs(f2) >= this.HN && Math.abs(f) < this.HN) {
                        int H = this.fdr.H(this.HI - this.HH);
                        if (H > this.fdr.HS && H <= this.fdr.HU) {
                            this.HK = true;
                            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), H));
                            F(H - this.fdr.HS);
                            break;
                        } else if (H <= this.fdr.HS) {
                            this.HK = false;
                            break;
                        } else if (H > this.fdr.HU) {
                            this.HK = true;
                            break;
                        } else {
                            this.HK = false;
                            break;
                        }
                    } else {
                        this.HK = false;
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
        if (this.HK) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HK) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kW() {
        if (this.fdr != null) {
            if (this.HF.getHeight() >= this.fdr.HU - (this.HO / 2)) {
                kX();
            } else {
                this.fds.kY();
            }
            this.mScroller.startScroll(0, this.HF.getHeight(), 0, this.fdr.HS - this.HF.getHeight(), 200);
            invalidate();
            this.HK = false;
        }
    }

    public void kX() {
        if (this.fds != null) {
            this.fds.kZ();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fds = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HF.setLayoutParams(new AbsListView.LayoutParams(this.HF.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.fds.G(360.0f - ((f * 360.0f) / this.HO));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HR;
        public int HS;
        public int HT;
        public int HU;

        public b(int i, int i2, int i3, int i4) {
            this.HR = i;
            this.HS = i2;
            this.HT = i3;
            this.HU = i4;
        }

        public int H(float f) {
            return (int) (this.HS + (f / 2.5f));
        }
    }
}
