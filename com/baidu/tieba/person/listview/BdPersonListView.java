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
    private View Ji;
    private float Jk;
    private float Jl;
    private boolean Jn;
    private float Jo;
    private float Jp;
    private final int Jq;
    private final int Jr;
    private b fgw;
    public a fgx;
    private boolean fgy;
    private boolean fgz;
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
        this.Jn = false;
        this.fgy = true;
        this.fgz = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jq = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Jr = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Ji = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.fgy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ji == null || !this.fgy) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Jl = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ji.getHeight();
                    this.Jk = this.Jl;
                    this.Jo = this.Jp;
                    this.fgw = new b(0, height, 0, this.Jr + height);
                    break;
                case 1:
                case 3:
                    if (this.Jn) {
                        lg();
                        if (this.fgz) {
                            return true;
                        }
                    } else {
                        this.fgx.li();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Jp - this.Jo;
                    float f2 = this.Jl - this.Jk;
                    this.Jo = this.Jp;
                    if (this.Ji.getParent() == this && this.fgw != null && this.Ji.isShown() && this.Ji.getTop() >= 0 && Math.abs(f2) >= this.Jq && Math.abs(f) < this.Jq) {
                        int H = this.fgw.H(this.Jl - this.Jk);
                        if (H > this.fgw.Jv && H <= this.fgw.Jx) {
                            this.Jn = true;
                            this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), H));
                            F(H - this.fgw.Jv);
                            break;
                        } else if (H <= this.fgw.Jv) {
                            this.Jn = false;
                            break;
                        } else if (H > this.fgw.Jx) {
                            this.Jn = true;
                            break;
                        } else {
                            this.Jn = false;
                            break;
                        }
                    } else {
                        this.Jn = false;
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
        if (this.Jn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jn) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lg() {
        if (this.fgw != null) {
            if (this.Ji.getHeight() >= this.fgw.Jx - (this.Jr / 2)) {
                lh();
            } else {
                this.fgx.li();
            }
            this.mScroller.startScroll(0, this.Ji.getHeight(), 0, this.fgw.Jv - this.Ji.getHeight(), 200);
            invalidate();
            this.Jn = false;
        }
    }

    public void lh() {
        if (this.fgx != null) {
            this.fgx.lj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fgx = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ji.setLayoutParams(new AbsListView.LayoutParams(this.Ji.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.fgx.G(360.0f - ((f * 360.0f) / this.Jr));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Ju;
        public int Jv;
        public int Jw;
        public int Jx;

        public b(int i, int i2, int i3, int i4) {
            this.Ju = i;
            this.Jv = i2;
            this.Jw = i3;
            this.Jx = i4;
        }

        public int H(float f) {
            return (int) (this.Jv + (f / 2.5f));
        }
    }
}
