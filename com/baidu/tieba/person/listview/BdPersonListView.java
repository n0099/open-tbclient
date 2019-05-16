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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class BdPersonListView extends BdTypeListView {
    private boolean MB;
    private float MC;
    private final int MD;
    private final int ME;
    private View Mx;
    private float Mz;
    private final Scroller icH;
    private View icI;
    private b icJ;
    private b icK;
    public a icL;
    private boolean icM;
    private boolean icN;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes4.dex */
    public interface a {
        void N(float f);

        void nF();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MB = false;
        this.icM = true;
        this.icN = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.icH = new Scroller(this.mContext);
        this.MD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.ME = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Mx = view;
    }

    public void setOuterExpandView(View view) {
        this.icI = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Mx == null || !this.icM) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Mz = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Mx.getHeight();
                    this.startY = this.Mz;
                    this.startX = this.MC;
                    this.icJ = new b(0, height, 0, this.ME + height);
                    int height2 = this.icI.getHeight();
                    this.icK = new b(0, height2, 0, this.ME + height2);
                    break;
                case 1:
                case 3:
                    if (this.MB) {
                        nD();
                        if (this.icN) {
                            return true;
                        }
                    } else {
                        this.icL.nF();
                        break;
                    }
                    break;
                case 2:
                    float f = this.MC - this.startX;
                    float f2 = this.Mz - this.startY;
                    this.startX = this.MC;
                    if (this.Mx.getParent() == this && this.icJ != null && this.Mx.isShown() && this.Mx.getTop() >= 0 && Math.abs(f2) >= this.MD && Math.abs(f) < this.MD) {
                        int O = this.icJ.O(this.Mz - this.startY);
                        if (O > this.icJ.startY && O <= this.icJ.endY) {
                            this.MB = true;
                            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), O));
                            if (this.icI != null) {
                                int O2 = this.icK.O(this.Mz - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.icI.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.icI.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.icJ.startY);
                            break;
                        } else if (O <= this.icJ.startY) {
                            this.MB = false;
                            break;
                        } else if (O > this.icJ.endY) {
                            this.MB = true;
                            break;
                        } else {
                            this.MB = false;
                            break;
                        }
                    } else {
                        this.MB = false;
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
        if (this.MB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MB) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nD() {
        if (this.icJ != null) {
            if (this.Mx.getHeight() >= this.icJ.endY - (this.ME / 2)) {
                nE();
            } else {
                this.icL.nF();
            }
            this.mScroller.startScroll(0, this.Mx.getHeight(), 0, this.icJ.startY - this.Mx.getHeight(), 200);
            this.icH.startScroll(0, this.icI.getHeight(), 0, this.icK.startY - this.icI.getHeight(), 200);
            invalidate();
            this.MB = false;
        }
    }

    public void nE() {
        if (this.icL != null) {
            this.icL.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.icL = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.icH.computeScrollOffset()) {
            int currY = this.icH.getCurrY();
            if (this.icI != null && (layoutParams = this.icI.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.icI.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.icL.N(360.0f - ((f * 360.0f) / this.ME));
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
