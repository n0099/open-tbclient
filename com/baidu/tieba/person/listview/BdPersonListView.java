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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View AR;
    private int AS;
    private float AT;
    private float AU;
    private boolean AW;
    private float AX;
    private float AY;
    private final int AZ;
    private final int Ba;
    private b eyT;
    public a eyU;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ke();

        void kf();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AW = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.AZ = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.ExpandListView);
        this.Ba = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.AR = view;
        this.AS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.AR == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.AU = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.AR.getHeight();
                    this.AT = this.AU;
                    this.AX = this.AY;
                    this.eyT = new b(0, height, 0, this.Ba + height);
                    break;
                case 1:
                case 3:
                    if (this.AW) {
                        kc();
                        break;
                    } else {
                        this.eyU.ke();
                        break;
                    }
                case 2:
                    float f = this.AY - this.AX;
                    float f2 = this.AU - this.AT;
                    this.AX = this.AY;
                    if (this.AR.getParent() == this && this.eyT != null && this.AR.isShown() && this.AR.getTop() >= 0 && Math.abs(f2) >= this.AZ && Math.abs(f) < this.AZ) {
                        int H = this.eyT.H(this.AU - this.AT);
                        if (H > this.eyT.Be && H <= this.eyT.Bg) {
                            this.AW = true;
                            this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), H));
                            F(H - this.eyT.Be);
                            break;
                        } else if (H <= this.eyT.Be) {
                            this.AW = false;
                            break;
                        } else if (H > this.eyT.Bg) {
                            this.AW = true;
                            break;
                        } else {
                            this.AW = false;
                            break;
                        }
                    } else {
                        this.AW = false;
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
        if (this.AW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.AW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kc() {
        if (this.eyT != null) {
            if (this.AR.getHeight() >= this.eyT.Bg - (this.Ba / 2)) {
                kd();
            } else {
                this.eyU.ke();
            }
            this.mScroller.startScroll(0, this.AR.getHeight(), 0, this.eyT.Be - this.AR.getHeight(), 200);
            invalidate();
            this.AW = false;
        }
    }

    public void kd() {
        if (this.eyU != null) {
            this.eyU.kf();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.eyU = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.AR.setLayoutParams(new AbsListView.LayoutParams(this.AR.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void F(float f) {
        this.eyU.G(360.0f - ((f * 360.0f) / this.Ba));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bd;
        public int Be;
        public int Bf;
        public int Bg;

        public b(int i, int i2, int i3, int i4) {
            this.Bd = i;
            this.Be = i2;
            this.Bf = i3;
            this.Bg = i4;
        }

        public int H(float f) {
            return (int) (this.Be + (f / 2.5f));
        }
    }
}
