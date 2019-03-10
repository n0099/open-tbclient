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
    private final Scroller hLb;
    private View hLc;
    private b hLd;
    private b hLe;
    public a hLf;
    private boolean hLg;
    private boolean hLh;
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
        this.hLg = true;
        this.hLh = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.hLb = new Scroller(this.mContext);
        this.OV = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OW = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.OO = view;
    }

    public void setOuterExpandView(View view) {
        this.hLc = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.OO == null || !this.hLg) {
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
                    this.hLd = new b(0, height, 0, this.OW + height);
                    int height2 = this.hLc.getHeight();
                    this.hLe = new b(0, height2, 0, this.OW + height2);
                    break;
                case 1:
                case 3:
                    if (this.OT) {
                        oJ();
                        if (this.hLh) {
                            return true;
                        }
                    } else {
                        this.hLf.oL();
                        break;
                    }
                    break;
                case 2:
                    float f = this.OU - this.startX;
                    float f2 = this.OQ - this.startY;
                    this.startX = this.OU;
                    if (this.OO.getParent() == this && this.hLd != null && this.OO.isShown() && this.OO.getTop() >= 0 && Math.abs(f2) >= this.OV && Math.abs(f) < this.OV) {
                        int O = this.hLd.O(this.OQ - this.startY);
                        if (O > this.hLd.startY && O <= this.hLd.endY) {
                            this.OT = true;
                            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), O));
                            if (this.hLc != null) {
                                int O2 = this.hLe.O(this.OQ - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.hLc.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.hLc.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.hLd.startY);
                            break;
                        } else if (O <= this.hLd.startY) {
                            this.OT = false;
                            break;
                        } else if (O > this.hLd.endY) {
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
        if (this.hLd != null) {
            if (this.OO.getHeight() >= this.hLd.endY - (this.OW / 2)) {
                oK();
            } else {
                this.hLf.oL();
            }
            this.mScroller.startScroll(0, this.OO.getHeight(), 0, this.hLd.startY - this.OO.getHeight(), 200);
            this.hLb.startScroll(0, this.hLc.getHeight(), 0, this.hLe.startY - this.hLc.getHeight(), 200);
            invalidate();
            this.OT = false;
        }
    }

    public void oK() {
        if (this.hLf != null) {
            this.hLf.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hLf = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.OO.setLayoutParams(new AbsListView.LayoutParams(this.OO.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.hLb.computeScrollOffset()) {
            int currY = this.hLb.getCurrY();
            if (this.hLc != null && (layoutParams = this.hLc.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.hLc.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.hLf.N(360.0f - ((f * 360.0f) / this.OW));
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
