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
    private final Scroller icK;
    private View icL;
    private b icM;
    private b icN;
    public a icO;
    private boolean icP;
    private boolean icQ;
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
        this.icP = true;
        this.icQ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.icK = new Scroller(this.mContext);
        this.MD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.ME = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Mx = view;
    }

    public void setOuterExpandView(View view) {
        this.icL = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Mx == null || !this.icP) {
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
                    this.icM = new b(0, height, 0, this.ME + height);
                    int height2 = this.icL.getHeight();
                    this.icN = new b(0, height2, 0, this.ME + height2);
                    break;
                case 1:
                case 3:
                    if (this.MB) {
                        nD();
                        if (this.icQ) {
                            return true;
                        }
                    } else {
                        this.icO.nF();
                        break;
                    }
                    break;
                case 2:
                    float f = this.MC - this.startX;
                    float f2 = this.Mz - this.startY;
                    this.startX = this.MC;
                    if (this.Mx.getParent() == this && this.icM != null && this.Mx.isShown() && this.Mx.getTop() >= 0 && Math.abs(f2) >= this.MD && Math.abs(f) < this.MD) {
                        int O = this.icM.O(this.Mz - this.startY);
                        if (O > this.icM.startY && O <= this.icM.endY) {
                            this.MB = true;
                            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), O));
                            if (this.icL != null) {
                                int O2 = this.icN.O(this.Mz - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.icL.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.icL.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.icM.startY);
                            break;
                        } else if (O <= this.icM.startY) {
                            this.MB = false;
                            break;
                        } else if (O > this.icM.endY) {
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
        if (this.icM != null) {
            if (this.Mx.getHeight() >= this.icM.endY - (this.ME / 2)) {
                nE();
            } else {
                this.icO.nF();
            }
            this.mScroller.startScroll(0, this.Mx.getHeight(), 0, this.icM.startY - this.Mx.getHeight(), 200);
            this.icK.startScroll(0, this.icL.getHeight(), 0, this.icN.startY - this.icL.getHeight(), 200);
            invalidate();
            this.MB = false;
        }
    }

    public void nE() {
        if (this.icO != null) {
            this.icO.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.icO = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Mx.setLayoutParams(new AbsListView.LayoutParams(this.Mx.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.icK.computeScrollOffset()) {
            int currY = this.icK.getCurrY();
            if (this.icL != null && (layoutParams = this.icL.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.icL.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.icO.N(360.0f - ((f * 360.0f) / this.ME));
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
