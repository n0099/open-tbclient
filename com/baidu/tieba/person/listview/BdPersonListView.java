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
    private final Scroller hKI;
    private View hKJ;
    private b hKK;
    private b hKL;
    public a hKM;
    private boolean hKN;
    private boolean hKO;
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
        this.hKN = true;
        this.hKO = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.hKI = new Scroller(this.mContext);
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.OX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.OP = view;
    }

    public void setOuterExpandView(View view) {
        this.hKJ = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.OP == null || !this.hKN) {
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
                    this.hKK = new b(0, height, 0, this.OX + height);
                    int height2 = this.hKJ.getHeight();
                    this.hKL = new b(0, height2, 0, this.OX + height2);
                    break;
                case 1:
                case 3:
                    if (this.OU) {
                        oJ();
                        if (this.hKO) {
                            return true;
                        }
                    } else {
                        this.hKM.oL();
                        break;
                    }
                    break;
                case 2:
                    float f = this.OV - this.startX;
                    float f2 = this.OR - this.startY;
                    this.startX = this.OV;
                    if (this.OP.getParent() == this && this.hKK != null && this.OP.isShown() && this.OP.getTop() >= 0 && Math.abs(f2) >= this.OW && Math.abs(f) < this.OW) {
                        int O = this.hKK.O(this.OR - this.startY);
                        if (O > this.hKK.startY && O <= this.hKK.endY) {
                            this.OU = true;
                            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), O));
                            if (this.hKJ != null) {
                                int O2 = this.hKL.O(this.OR - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.hKJ.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.hKJ.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.hKK.startY);
                            break;
                        } else if (O <= this.hKK.startY) {
                            this.OU = false;
                            break;
                        } else if (O > this.hKK.endY) {
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
        if (this.hKK != null) {
            if (this.OP.getHeight() >= this.hKK.endY - (this.OX / 2)) {
                oK();
            } else {
                this.hKM.oL();
            }
            this.mScroller.startScroll(0, this.OP.getHeight(), 0, this.hKK.startY - this.OP.getHeight(), 200);
            this.hKI.startScroll(0, this.hKJ.getHeight(), 0, this.hKL.startY - this.hKJ.getHeight(), 200);
            invalidate();
            this.OU = false;
        }
    }

    public void oK() {
        if (this.hKM != null) {
            this.hKM.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hKM = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.OP.setLayoutParams(new AbsListView.LayoutParams(this.OP.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.hKI.computeScrollOffset()) {
            int currY = this.hKI.getCurrY();
            if (this.hKJ != null && (layoutParams = this.hKJ.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.hKJ.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.hKM.N(360.0f - ((f * 360.0f) / this.OX));
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
