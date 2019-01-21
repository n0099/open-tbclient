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
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class BdPersonListView extends BdTypeListView {
    private boolean OA;
    private float OB;
    private final int OC;
    private final int OD;
    private View Ow;
    private float Oy;
    private final Scroller guK;
    private View guL;
    private b guM;
    private b guN;
    public a guO;
    private boolean guP;
    private boolean guQ;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes5.dex */
    public interface a {
        void N(float f);

        void oG();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OA = false;
        this.guP = true;
        this.guQ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.guK = new Scroller(this.mContext);
        this.OC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.OD = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Ow = view;
    }

    public void setOuterExpandView(View view) {
        this.guL = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ow == null || !this.guP) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Oy = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ow.getHeight();
                    this.startY = this.Oy;
                    this.startX = this.OB;
                    this.guM = new b(0, height, 0, this.OD + height);
                    int height2 = this.guL.getHeight();
                    this.guN = new b(0, height2, 0, this.OD + height2);
                    break;
                case 1:
                case 3:
                    if (this.OA) {
                        oE();
                        if (this.guQ) {
                            return true;
                        }
                    } else {
                        this.guO.oG();
                        break;
                    }
                    break;
                case 2:
                    float f = this.OB - this.startX;
                    float f2 = this.Oy - this.startY;
                    this.startX = this.OB;
                    if (this.Ow.getParent() == this && this.guM != null && this.Ow.isShown() && this.Ow.getTop() >= 0 && Math.abs(f2) >= this.OC && Math.abs(f) < this.OC) {
                        int O = this.guM.O(this.Oy - this.startY);
                        if (O > this.guM.startY && O <= this.guM.endY) {
                            this.OA = true;
                            this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), O));
                            if (this.guL != null) {
                                int O2 = this.guN.O(this.Oy - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.guL.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.guL.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.guM.startY);
                            break;
                        } else if (O <= this.guM.startY) {
                            this.OA = false;
                            break;
                        } else if (O > this.guM.endY) {
                            this.OA = true;
                            break;
                        } else {
                            this.OA = false;
                            break;
                        }
                    } else {
                        this.OA = false;
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
        if (this.OA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void oE() {
        if (this.guM != null) {
            if (this.Ow.getHeight() >= this.guM.endY - (this.OD / 2)) {
                oF();
            } else {
                this.guO.oG();
            }
            this.mScroller.startScroll(0, this.Ow.getHeight(), 0, this.guM.startY - this.Ow.getHeight(), 200);
            this.guK.startScroll(0, this.guL.getHeight(), 0, this.guN.startY - this.guL.getHeight(), 200);
            invalidate();
            this.OA = false;
        }
    }

    public void oF() {
        if (this.guO != null) {
            this.guO.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.guO = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Ow.setLayoutParams(new AbsListView.LayoutParams(this.Ow.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.guK.computeScrollOffset()) {
            int currY = this.guK.getCurrY();
            if (this.guL != null && (layoutParams = this.guL.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.guL.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.guO.N(360.0f - ((f * 360.0f) / this.OD));
    }

    /* loaded from: classes5.dex */
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
