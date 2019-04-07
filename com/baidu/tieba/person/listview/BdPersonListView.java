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
    private View OP;
    private float OR;
    private boolean OU;
    private float OV;
    private final int OW;
    private final int OX;
    private final Scroller hKH;
    private View hKI;
    private b hKJ;
    private b hKK;
    public a hKL;
    private boolean hKM;
    private boolean hKN;
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
        this.OU = false;
        this.hKM = true;
        this.hKN = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.hKH = new Scroller(this.mContext);
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.OP = view;
    }

    public void setOuterExpandView(View view) {
        this.hKI = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.OP == null || !this.hKM) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.OR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.OP.getHeight();
                    this.startY = this.OR;
                    this.startX = this.OV;
                    this.hKJ = new b(0, height, 0, this.OX + height);
                    int height2 = this.hKI.getHeight();
                    this.hKK = new b(0, height2, 0, this.OX + height2);
                    break;
                case 1:
                case 3:
                    if (this.OU) {
                        oJ();
                        if (this.hKN) {
                            return true;
                        }
                    } else {
                        this.hKL.oL();
                        break;
                    }
                    break;
                case 2:
                    float f = this.OV - this.startX;
                    float f2 = this.OR - this.startY;
                    this.startX = this.OV;
                    if (this.OP.getParent() == this && this.hKJ != null && this.OP.isShown() && this.OP.getTop() >= 0 && Math.abs(f2) >= this.OW && Math.abs(f) < this.OW) {
                        int O = this.hKJ.O(this.OR - this.startY);
                        if (O > this.hKJ.startY && O <= this.hKJ.endY) {
                            this.OU = true;
                            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), O));
                            if (this.hKI != null) {
                                int O2 = this.hKK.O(this.OR - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.hKI.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.hKI.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.hKJ.startY);
                            break;
                        } else if (O <= this.hKJ.startY) {
                            this.OU = false;
                            break;
                        } else if (O > this.hKJ.endY) {
                            this.OU = true;
                            break;
                        } else {
                            this.OU = false;
                            break;
                        }
                    } else {
                        this.OU = false;
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
        if (this.OU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.OU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void oJ() {
        if (this.hKJ != null) {
            if (this.OP.getHeight() >= this.hKJ.endY - (this.OX / 2)) {
                oK();
            } else {
                this.hKL.oL();
            }
            this.mScroller.startScroll(0, this.OP.getHeight(), 0, this.hKJ.startY - this.OP.getHeight(), 200);
            this.hKH.startScroll(0, this.hKI.getHeight(), 0, this.hKK.startY - this.hKI.getHeight(), 200);
            invalidate();
            this.OU = false;
        }
    }

    public void oK() {
        if (this.hKL != null) {
            this.hKL.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hKL = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.hKH.computeScrollOffset()) {
            int currY = this.hKH.getCurrY();
            if (this.hKI != null && (layoutParams = this.hKI.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.hKI.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.hKL.N(360.0f - ((f * 360.0f) / this.OX));
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
