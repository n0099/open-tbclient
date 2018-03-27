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
    private View auE;
    private float auG;
    private float auH;
    private boolean auJ;
    private float auK;
    private float auL;
    private final int auM;
    private final int auN;
    private final Scroller giI;
    private View giJ;
    private b giK;
    private b giL;
    public a giM;
    private boolean giN;
    private boolean giO;
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
        this.auJ = false;
        this.giN = true;
        this.giO = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.giI = new Scroller(this.mContext);
        this.auM = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.auN = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auE = view;
    }

    public void setOuterExpandView(View view) {
        this.giJ = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auE == null || !this.giN) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auH = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auE.getHeight();
                    this.auG = this.auH;
                    this.auK = this.auL;
                    this.giK = new b(0, height, 0, this.auN + height);
                    int height2 = this.giJ.getHeight();
                    this.giL = new b(0, height2, 0, this.auN + height2);
                    break;
                case 1:
                case 3:
                    if (this.auJ) {
                        sq();
                        if (this.giO) {
                            return true;
                        }
                    } else {
                        this.giM.ss();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auL - this.auK;
                    float f2 = this.auH - this.auG;
                    this.auK = this.auL;
                    if (this.auE.getParent() == this && this.giK != null && this.auE.isShown() && this.auE.getTop() >= 0 && Math.abs(f2) >= this.auM && Math.abs(f) < this.auM) {
                        int Q = this.giK.Q(this.auH - this.auG);
                        if (Q > this.giK.startY && Q <= this.giK.endY) {
                            this.auJ = true;
                            this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), Q));
                            if (this.giJ != null) {
                                int Q2 = this.giL.Q(this.auH - this.auG);
                                ViewGroup.LayoutParams layoutParams = this.giJ.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = Q2;
                                    this.giJ.setLayoutParams(layoutParams);
                                }
                            }
                            O(Q - this.giK.startY);
                            break;
                        } else if (Q <= this.giK.startY) {
                            this.auJ = false;
                            break;
                        } else if (Q > this.giK.endY) {
                            this.auJ = true;
                            break;
                        } else {
                            this.auJ = false;
                            break;
                        }
                    } else {
                        this.auJ = false;
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
        if (this.auJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auJ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void sq() {
        if (this.giK != null) {
            if (this.auE.getHeight() >= this.giK.endY - (this.auN / 2)) {
                sr();
            } else {
                this.giM.ss();
            }
            this.mScroller.startScroll(0, this.auE.getHeight(), 0, this.giK.startY - this.auE.getHeight(), 200);
            this.giI.startScroll(0, this.giJ.getHeight(), 0, this.giL.startY - this.giJ.getHeight(), 200);
            invalidate();
            this.auJ = false;
        }
    }

    public void sr() {
        if (this.giM != null) {
            this.giM.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.giM = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auE.setLayoutParams(new AbsListView.LayoutParams(this.auE.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.giI.computeScrollOffset()) {
            int currY = this.giI.getCurrY();
            if (this.giJ != null && (layoutParams = this.giJ.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.giJ.setLayoutParams(layoutParams);
            }
        }
    }

    private void O(float f) {
        this.giM.P(360.0f - ((f * 360.0f) / this.auN));
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
