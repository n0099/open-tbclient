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
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View auR;
    private float auT;
    private float auU;
    private boolean auW;
    private float auX;
    private float auY;
    private final int auZ;
    private final int ava;
    private final Scroller ggT;
    private View ggU;
    private b ggV;
    private b ggW;
    public a ggX;
    private boolean ggY;
    private boolean ggZ;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.expandActivityOverflowButtonDrawable, R.attr.adpMode};

    /* loaded from: classes.dex */
    public interface a {
        void L(float f);

        void onRefresh();

        void su();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auW = false;
        this.ggY = true;
        this.ggZ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.ggT = new Scroller(this.mContext);
        this.auZ = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.ava = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auR = view;
    }

    public void setOuterExpandView(View view) {
        this.ggU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auR == null || !this.ggY) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auU = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auR.getHeight();
                    this.auT = this.auU;
                    this.auX = this.auY;
                    this.ggV = new b(0, height, 0, this.ava + height);
                    int height2 = this.ggU.getHeight();
                    this.ggW = new b(0, height2, 0, this.ava + height2);
                    break;
                case 1:
                case 3:
                    if (this.auW) {
                        ss();
                        if (this.ggZ) {
                            return true;
                        }
                    } else {
                        this.ggX.su();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auY - this.auX;
                    float f2 = this.auU - this.auT;
                    this.auX = this.auY;
                    if (this.auR.getParent() == this && this.ggV != null && this.auR.isShown() && this.auR.getTop() >= 0 && Math.abs(f2) >= this.auZ && Math.abs(f) < this.auZ) {
                        int M = this.ggV.M(this.auU - this.auT);
                        if (M > this.ggV.startY && M <= this.ggV.endY) {
                            this.auW = true;
                            this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), M));
                            if (this.ggU != null) {
                                int M2 = this.ggW.M(this.auU - this.auT);
                                ViewGroup.LayoutParams layoutParams = this.ggU.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = M2;
                                    this.ggU.setLayoutParams(layoutParams);
                                }
                            }
                            K(M - this.ggV.startY);
                            break;
                        } else if (M <= this.ggV.startY) {
                            this.auW = false;
                            break;
                        } else if (M > this.ggV.endY) {
                            this.auW = true;
                            break;
                        } else {
                            this.auW = false;
                            break;
                        }
                    } else {
                        this.auW = false;
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
        if (this.auW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auW) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void ss() {
        if (this.ggV != null) {
            if (this.auR.getHeight() >= this.ggV.endY - (this.ava / 2)) {
                st();
            } else {
                this.ggX.su();
            }
            this.mScroller.startScroll(0, this.auR.getHeight(), 0, this.ggV.startY - this.auR.getHeight(), 200);
            this.ggT.startScroll(0, this.ggU.getHeight(), 0, this.ggW.startY - this.ggU.getHeight(), 200);
            invalidate();
            this.auW = false;
        }
    }

    public void st() {
        if (this.ggX != null) {
            this.ggX.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.ggX = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auR.setLayoutParams(new AbsListView.LayoutParams(this.auR.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.ggT.computeScrollOffset()) {
            int currY = this.ggT.getCurrY();
            if (this.ggU != null && (layoutParams = this.ggU.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.ggU.setLayoutParams(layoutParams);
            }
        }
    }

    private void K(float f) {
        this.ggX.L(360.0f - ((f * 360.0f) / this.ava));
    }

    /* loaded from: classes.dex */
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

        public int M(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
