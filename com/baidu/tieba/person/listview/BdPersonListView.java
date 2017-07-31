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
    private View Jg;
    private float Ji;
    private float Jj;
    private boolean Jl;
    private float Jm;
    private float Jn;
    private final int Jo;
    private final int Jp;
    private b feD;
    public a feE;
    private boolean feF;
    private boolean feG;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void li();

        void lj();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jl = false;
        this.feF = true;
        this.feG = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Jp = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Jg = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.feF = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Jg == null || !this.feF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Jj = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Jg.getHeight();
                    this.Ji = this.Jj;
                    this.Jm = this.Jn;
                    this.feD = new b(0, height, 0, this.Jp + height);
                    break;
                case 1:
                case 3:
                    if (this.Jl) {
                        lg();
                        if (this.feG) {
                            return true;
                        }
                    } else {
                        this.feE.li();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Jn - this.Jm;
                    float f2 = this.Jj - this.Ji;
                    this.Jm = this.Jn;
                    if (this.Jg.getParent() == this && this.feD != null && this.Jg.isShown() && this.Jg.getTop() >= 0 && Math.abs(f2) >= this.Jo && Math.abs(f) < this.Jo) {
                        int H = this.feD.H(this.Jj - this.Ji);
                        if (H > this.feD.Jt && H <= this.feD.Jv) {
                            this.Jl = true;
                            this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), H));
                            F(H - this.feD.Jt);
                            break;
                        } else if (H <= this.feD.Jt) {
                            this.Jl = false;
                            break;
                        } else if (H > this.feD.Jv) {
                            this.Jl = true;
                            break;
                        } else {
                            this.Jl = false;
                            break;
                        }
                    } else {
                        this.Jl = false;
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
        if (this.Jl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lg() {
        if (this.feD != null) {
            if (this.Jg.getHeight() >= this.feD.Jv - (this.Jp / 2)) {
                lh();
            } else {
                this.feE.li();
            }
            this.mScroller.startScroll(0, this.Jg.getHeight(), 0, this.feD.Jt - this.Jg.getHeight(), 200);
            invalidate();
            this.Jl = false;
        }
    }

    public void lh() {
        if (this.feE != null) {
            this.feE.lj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.feE = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.feE.G(360.0f - ((f * 360.0f) / this.Jp));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Js;
        public int Jt;
        public int Ju;
        public int Jv;

        public b(int i, int i2, int i3, int i4) {
            this.Js = i;
            this.Jt = i2;
            this.Ju = i3;
            this.Jv = i4;
        }

        public int H(float f) {
            return (int) (this.Jt + (f / 2.5f));
        }
    }
}
