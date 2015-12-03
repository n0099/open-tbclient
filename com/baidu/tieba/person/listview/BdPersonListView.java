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
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View Hq;
    private int Hr;
    private float Hs;
    private float Ht;
    private boolean Hv;
    private float Hw;
    private float Hx;
    private final int Hy;
    private final int Hz;
    private b cQn;
    public a cQo;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.beforeExpandHeight, R.attr.expandDistance};

    /* loaded from: classes.dex */
    public interface a {
        void k(float f);

        void nt();

        void nu();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hv = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ExpandListView);
        this.Hz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void c(View view, int i) {
        this.Hq = view;
        this.Hr = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ht = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Hq.getHeight();
                    this.Hs = this.Ht;
                    this.Hw = this.Hx;
                    this.cQn = new b(0, height, 0, this.Hz + height);
                    break;
                case 1:
                case 3:
                    if (this.Hv) {
                        nr();
                        break;
                    } else {
                        this.cQo.nt();
                        break;
                    }
                case 2:
                    float f = this.Hx - this.Hw;
                    float f2 = this.Ht - this.Hs;
                    this.Hw = this.Hx;
                    if (this.Hq.getParent() == this && this.cQn != null && this.Hq.isShown() && this.Hq.getTop() >= 0 && Math.abs(f2) >= this.Hy && Math.abs(f) < this.Hy) {
                        int l = this.cQn.l(this.Ht - this.Hs);
                        if (l > this.cQn.startY && l <= this.cQn.HD) {
                            this.Hv = true;
                            this.Hq.setLayoutParams(new AbsListView.LayoutParams(this.Hq.getWidth(), l));
                            j(l - this.cQn.startY);
                            break;
                        } else if (l <= this.cQn.startY) {
                            this.Hv = false;
                            break;
                        } else if (l > this.cQn.HD) {
                            this.Hv = true;
                            break;
                        } else {
                            this.Hv = false;
                            break;
                        }
                    } else {
                        this.Hv = false;
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
        if (this.Hv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nr() {
        if (this.cQn != null) {
            if (this.Hq.getHeight() >= this.cQn.HD - (this.Hz / 2)) {
                ns();
            } else {
                this.cQo.nt();
            }
            this.mScroller.startScroll(0, this.Hq.getHeight(), 0, this.cQn.startY - this.Hq.getHeight(), 200);
            invalidate();
            this.Hv = false;
        }
    }

    public void ns() {
        if (this.cQo != null) {
            this.cQo.nu();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.cQo = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Hq.setLayoutParams(new AbsListView.LayoutParams(this.Hq.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void j(float f) {
        this.cQo.k(360.0f - ((f * 360.0f) / this.Hz));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HC;
        public int HD;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.HC = i3;
            this.HD = i4;
        }

        public int l(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
