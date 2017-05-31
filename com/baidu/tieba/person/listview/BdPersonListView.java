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
    private View HG;
    private float HI;
    private float HJ;
    private boolean HL;
    private float HM;
    private float HN;
    private final int HO;
    private final int HP;
    private b eHe;
    public a eHf;
    private boolean eHg;
    private boolean eHh;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void lc();

        void ld();
    }

    public void aPY() {
        this.eHh = true;
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HL = false;
        this.eHg = true;
        this.eHh = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HO = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.HP = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.HG = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.eHg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.HG == null || !this.eHg) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.HJ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.HG.getHeight();
                    this.HI = this.HJ;
                    this.HM = this.HN;
                    this.eHe = new b(0, height, 0, this.HP + height);
                    break;
                case 1:
                case 3:
                    if (this.HL) {
                        la();
                        if (this.eHh) {
                            return true;
                        }
                    } else {
                        this.eHf.lc();
                        break;
                    }
                    break;
                case 2:
                    float f = this.HN - this.HM;
                    float f2 = this.HJ - this.HI;
                    this.HM = this.HN;
                    if (this.HG.getParent() == this && this.eHe != null && this.HG.isShown() && this.HG.getTop() >= 0 && Math.abs(f2) >= this.HO && Math.abs(f) < this.HO) {
                        int H = this.eHe.H(this.HJ - this.HI);
                        if (H > this.eHe.HT && H <= this.eHe.HV) {
                            this.HL = true;
                            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), H));
                            F(H - this.eHe.HT);
                            break;
                        } else if (H <= this.eHe.HT) {
                            this.HL = false;
                            break;
                        } else if (H > this.eHe.HV) {
                            this.HL = true;
                            break;
                        } else {
                            this.HL = false;
                            break;
                        }
                    } else {
                        this.HL = false;
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
        if (this.HL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HL) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void la() {
        if (this.eHe != null) {
            if (this.HG.getHeight() >= this.eHe.HV - (this.HP / 2)) {
                lb();
            } else {
                this.eHf.lc();
            }
            this.mScroller.startScroll(0, this.HG.getHeight(), 0, this.eHe.HT - this.HG.getHeight(), 200);
            invalidate();
            this.HL = false;
        }
    }

    public void lb() {
        if (this.eHf != null) {
            this.eHf.ld();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eHf = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eHf.G(360.0f - ((f * 360.0f) / this.HP));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HS;
        public int HT;
        public int HU;
        public int HV;

        public b(int i, int i2, int i3, int i4) {
            this.HS = i;
            this.HT = i2;
            this.HU = i3;
            this.HV = i4;
        }

        public int H(float f) {
            return (int) (this.HT + (f / 2.5f));
        }
    }
}
