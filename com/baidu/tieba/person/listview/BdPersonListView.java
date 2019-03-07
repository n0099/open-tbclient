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
/* loaded from: classes4.dex */
public class BdPersonListView extends BdTypeListView {
    private View OO;
    private float OQ;
    private boolean OT;
    private float OU;
    private final int OV;
    private final int OW;
    private final Scroller hLa;
    private View hLb;
    private b hLc;
    private b hLd;
    public a hLe;
    private boolean hLf;
    private boolean hLg;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes4.dex */
    public interface a {
        void N(float f);

        void oL();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OT = false;
        this.hLf = true;
        this.hLg = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.hLa = new Scroller(this.mContext);
        this.OV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.OO = view;
    }

    public void setOuterExpandView(View view) {
        this.hLb = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.OO == null || !this.hLf) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.OQ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.OO.getHeight();
                    this.startY = this.OQ;
                    this.startX = this.OU;
                    this.hLc = new b(0, height, 0, this.OW + height);
                    int height2 = this.hLb.getHeight();
                    this.hLd = new b(0, height2, 0, this.OW + height2);
                    break;
                case 1:
                case 3:
                    if (this.OT) {
                        oJ();
                        if (this.hLg) {
                            return true;
                        }
                    } else {
                        this.hLe.oL();
                        break;
                    }
                    break;
                case 2:
                    float f = this.OU - this.startX;
                    float f2 = this.OQ - this.startY;
                    this.startX = this.OU;
                    if (this.OO.getParent() == this && this.hLc != null && this.OO.isShown() && this.OO.getTop() >= 0 && Math.abs(f2) >= this.OV && Math.abs(f) < this.OV) {
                        int O = this.hLc.O(this.OQ - this.startY);
                        if (O > this.hLc.startY && O <= this.hLc.endY) {
                            this.OT = true;
                            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), O));
                            if (this.hLb != null) {
                                int O2 = this.hLd.O(this.OQ - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.hLb.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.hLb.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.hLc.startY);
                            break;
                        } else if (O <= this.hLc.startY) {
                            this.OT = false;
                            break;
                        } else if (O > this.hLc.endY) {
                            this.OT = true;
                            break;
                        } else {
                            this.OT = false;
                            break;
                        }
                    } else {
                        this.OT = false;
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
        if (this.OT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void oJ() {
        if (this.hLc != null) {
            if (this.OO.getHeight() >= this.hLc.endY - (this.OW / 2)) {
                oK();
            } else {
                this.hLe.oL();
            }
            this.mScroller.startScroll(0, this.OO.getHeight(), 0, this.hLc.startY - this.OO.getHeight(), 200);
            this.hLa.startScroll(0, this.hLb.getHeight(), 0, this.hLd.startY - this.hLb.getHeight(), 200);
            invalidate();
            this.OT = false;
        }
    }

    public void oK() {
        if (this.hLe != null) {
            this.hLe.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hLe = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.hLa.computeScrollOffset()) {
            int currY = this.hLa.getCurrY();
            if (this.hLb != null && (layoutParams = this.hLb.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.hLb.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.hLe.N(360.0f - ((f * 360.0f) / this.OW));
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
