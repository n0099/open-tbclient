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
    private boolean MA;
    private float MB;
    private final int MC;
    private final int MD;
    private View Mw;
    private float My;
    private final Scroller icL;
    private View icM;
    private b icN;
    private b icO;
    public a icP;
    private boolean icQ;
    private boolean icR;
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
        this.MA = false;
        this.icQ = true;
        this.icR = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.icL = new Scroller(this.mContext);
        this.MC = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.MD = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Mw = view;
    }

    public void setOuterExpandView(View view) {
        this.icM = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Mw == null || !this.icQ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.My = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Mw.getHeight();
                    this.startY = this.My;
                    this.startX = this.MB;
                    this.icN = new b(0, height, 0, this.MD + height);
                    int height2 = this.icM.getHeight();
                    this.icO = new b(0, height2, 0, this.MD + height2);
                    break;
                case 1:
                case 3:
                    if (this.MA) {
                        nD();
                        if (this.icR) {
                            return true;
                        }
                    } else {
                        this.icP.nF();
                        break;
                    }
                    break;
                case 2:
                    float f = this.MB - this.startX;
                    float f2 = this.My - this.startY;
                    this.startX = this.MB;
                    if (this.Mw.getParent() == this && this.icN != null && this.Mw.isShown() && this.Mw.getTop() >= 0 && Math.abs(f2) >= this.MC && Math.abs(f) < this.MC) {
                        int O = this.icN.O(this.My - this.startY);
                        if (O > this.icN.startY && O <= this.icN.endY) {
                            this.MA = true;
                            this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), O));
                            if (this.icM != null) {
                                int O2 = this.icO.O(this.My - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.icM.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.icM.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.icN.startY);
                            break;
                        } else if (O <= this.icN.startY) {
                            this.MA = false;
                            break;
                        } else if (O > this.icN.endY) {
                            this.MA = true;
                            break;
                        } else {
                            this.MA = false;
                            break;
                        }
                    } else {
                        this.MA = false;
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
        if (this.MA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nD() {
        if (this.icN != null) {
            if (this.Mw.getHeight() >= this.icN.endY - (this.MD / 2)) {
                nE();
            } else {
                this.icP.nF();
            }
            this.mScroller.startScroll(0, this.Mw.getHeight(), 0, this.icN.startY - this.Mw.getHeight(), 200);
            this.icL.startScroll(0, this.icM.getHeight(), 0, this.icO.startY - this.icM.getHeight(), 200);
            invalidate();
            this.MA = false;
        }
    }

    public void nE() {
        if (this.icP != null) {
            this.icP.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.icP = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Mw.setLayoutParams(new AbsListView.LayoutParams(this.Mw.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.icL.computeScrollOffset()) {
            int currY = this.icL.getCurrY();
            if (this.icM != null && (layoutParams = this.icM.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.icM.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.icP.N(360.0f - ((f * 360.0f) / this.MD));
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
