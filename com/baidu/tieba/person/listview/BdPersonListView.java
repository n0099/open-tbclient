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
    private View auO;
    private float auQ;
    private float auR;
    private boolean auT;
    private float auU;
    private float auV;
    private final int auW;
    private final int auX;
    private final Scroller ggA;
    private View ggB;
    private b ggC;
    private b ggD;
    public a ggE;
    private boolean ggF;
    private boolean ggG;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.expandActivityOverflowButtonDrawable, R.attr.adpMode};

    /* loaded from: classes.dex */
    public interface a {
        void L(float f);

        void onRefresh();

        void st();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auT = false;
        this.ggF = true;
        this.ggG = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.ggA = new Scroller(this.mContext);
        this.auW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.auX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auO = view;
    }

    public void setOuterExpandView(View view) {
        this.ggB = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auO == null || !this.ggF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auO.getHeight();
                    this.auQ = this.auR;
                    this.auU = this.auV;
                    this.ggC = new b(0, height, 0, this.auX + height);
                    int height2 = this.ggB.getHeight();
                    this.ggD = new b(0, height2, 0, this.auX + height2);
                    break;
                case 1:
                case 3:
                    if (this.auT) {
                        sr();
                        if (this.ggG) {
                            return true;
                        }
                    } else {
                        this.ggE.st();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auV - this.auU;
                    float f2 = this.auR - this.auQ;
                    this.auU = this.auV;
                    if (this.auO.getParent() == this && this.ggC != null && this.auO.isShown() && this.auO.getTop() >= 0 && Math.abs(f2) >= this.auW && Math.abs(f) < this.auW) {
                        int M = this.ggC.M(this.auR - this.auQ);
                        if (M > this.ggC.startY && M <= this.ggC.endY) {
                            this.auT = true;
                            this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), M));
                            if (this.ggB != null) {
                                int M2 = this.ggD.M(this.auR - this.auQ);
                                ViewGroup.LayoutParams layoutParams = this.ggB.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = M2;
                                    this.ggB.setLayoutParams(layoutParams);
                                }
                            }
                            K(M - this.ggC.startY);
                            break;
                        } else if (M <= this.ggC.startY) {
                            this.auT = false;
                            break;
                        } else if (M > this.ggC.endY) {
                            this.auT = true;
                            break;
                        } else {
                            this.auT = false;
                            break;
                        }
                    } else {
                        this.auT = false;
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
        if (this.auT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void sr() {
        if (this.ggC != null) {
            if (this.auO.getHeight() >= this.ggC.endY - (this.auX / 2)) {
                ss();
            } else {
                this.ggE.st();
            }
            this.mScroller.startScroll(0, this.auO.getHeight(), 0, this.ggC.startY - this.auO.getHeight(), 200);
            this.ggA.startScroll(0, this.ggB.getHeight(), 0, this.ggD.startY - this.ggB.getHeight(), 200);
            invalidate();
            this.auT = false;
        }
    }

    public void ss() {
        if (this.ggE != null) {
            this.ggE.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.ggE = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auO.setLayoutParams(new AbsListView.LayoutParams(this.auO.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.ggA.computeScrollOffset()) {
            int currY = this.ggA.getCurrY();
            if (this.ggB != null && (layoutParams = this.ggB.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.ggB.setLayoutParams(layoutParams);
            }
        }
    }

    private void K(float f) {
        this.ggE.L(360.0f - ((f * 360.0f) / this.auX));
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
