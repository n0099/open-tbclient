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
    private View auM;
    private float auO;
    private float auP;
    private boolean auR;
    private float auS;
    private float auT;
    private final int auU;
    private final int auV;
    private final Scroller giD;
    private View giE;
    private b giF;
    private b giG;
    public a giH;
    private boolean giI;
    private boolean giJ;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.closeItemLayout, R.attr.initialActivityCount};

    /* loaded from: classes.dex */
    public interface a {
        void P(float f);

        void onRefresh();

        void ss();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auR = false;
        this.giI = true;
        this.giJ = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.giD = new Scroller(this.mContext);
        this.auU = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.auV = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auM = view;
    }

    public void setOuterExpandView(View view) {
        this.giE = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auM == null || !this.giI) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auP = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auM.getHeight();
                    this.auO = this.auP;
                    this.auS = this.auT;
                    this.giF = new b(0, height, 0, this.auV + height);
                    int height2 = this.giE.getHeight();
                    this.giG = new b(0, height2, 0, this.auV + height2);
                    break;
                case 1:
                case 3:
                    if (this.auR) {
                        sq();
                        if (this.giJ) {
                            return true;
                        }
                    } else {
                        this.giH.ss();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auT - this.auS;
                    float f2 = this.auP - this.auO;
                    this.auS = this.auT;
                    if (this.auM.getParent() == this && this.giF != null && this.auM.isShown() && this.auM.getTop() >= 0 && Math.abs(f2) >= this.auU && Math.abs(f) < this.auU) {
                        int Q = this.giF.Q(this.auP - this.auO);
                        if (Q > this.giF.startY && Q <= this.giF.endY) {
                            this.auR = true;
                            this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), Q));
                            if (this.giE != null) {
                                int Q2 = this.giG.Q(this.auP - this.auO);
                                ViewGroup.LayoutParams layoutParams = this.giE.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = Q2;
                                    this.giE.setLayoutParams(layoutParams);
                                }
                            }
                            O(Q - this.giF.startY);
                            break;
                        } else if (Q <= this.giF.startY) {
                            this.auR = false;
                            break;
                        } else if (Q > this.giF.endY) {
                            this.auR = true;
                            break;
                        } else {
                            this.auR = false;
                            break;
                        }
                    } else {
                        this.auR = false;
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
        if (this.auR) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auR) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void sq() {
        if (this.giF != null) {
            if (this.auM.getHeight() >= this.giF.endY - (this.auV / 2)) {
                sr();
            } else {
                this.giH.ss();
            }
            this.mScroller.startScroll(0, this.auM.getHeight(), 0, this.giF.startY - this.auM.getHeight(), 200);
            this.giD.startScroll(0, this.giE.getHeight(), 0, this.giG.startY - this.giE.getHeight(), 200);
            invalidate();
            this.auR = false;
        }
    }

    public void sr() {
        if (this.giH != null) {
            this.giH.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.giH = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auM.setLayoutParams(new AbsListView.LayoutParams(this.auM.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.giD.computeScrollOffset()) {
            int currY = this.giD.getCurrY();
            if (this.giE != null && (layoutParams = this.giE.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.giE.setLayoutParams(layoutParams);
            }
        }
    }

    private void O(float f) {
        this.giH.P(360.0f - ((f * 360.0f) / this.auV));
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

        public int Q(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
