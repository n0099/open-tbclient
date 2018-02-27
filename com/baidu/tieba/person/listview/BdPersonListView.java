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
    private View auD;
    private float auF;
    private float auG;
    private boolean auI;
    private float auJ;
    private float auK;
    private final int auL;
    private final int auM;
    private final Scroller gis;
    private View git;
    private b giu;
    private b giv;
    public a giw;
    private boolean gix;
    private boolean giy;
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
        this.auI = false;
        this.gix = true;
        this.giy = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.gis = new Scroller(this.mContext);
        this.auL = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.auM = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auD = view;
    }

    public void setOuterExpandView(View view) {
        this.git = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auD == null || !this.gix) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auG = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auD.getHeight();
                    this.auF = this.auG;
                    this.auJ = this.auK;
                    this.giu = new b(0, height, 0, this.auM + height);
                    int height2 = this.git.getHeight();
                    this.giv = new b(0, height2, 0, this.auM + height2);
                    break;
                case 1:
                case 3:
                    if (this.auI) {
                        sq();
                        if (this.giy) {
                            return true;
                        }
                    } else {
                        this.giw.ss();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auK - this.auJ;
                    float f2 = this.auG - this.auF;
                    this.auJ = this.auK;
                    if (this.auD.getParent() == this && this.giu != null && this.auD.isShown() && this.auD.getTop() >= 0 && Math.abs(f2) >= this.auL && Math.abs(f) < this.auL) {
                        int Q = this.giu.Q(this.auG - this.auF);
                        if (Q > this.giu.startY && Q <= this.giu.endY) {
                            this.auI = true;
                            this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), Q));
                            if (this.git != null) {
                                int Q2 = this.giv.Q(this.auG - this.auF);
                                ViewGroup.LayoutParams layoutParams = this.git.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = Q2;
                                    this.git.setLayoutParams(layoutParams);
                                }
                            }
                            O(Q - this.giu.startY);
                            break;
                        } else if (Q <= this.giu.startY) {
                            this.auI = false;
                            break;
                        } else if (Q > this.giu.endY) {
                            this.auI = true;
                            break;
                        } else {
                            this.auI = false;
                            break;
                        }
                    } else {
                        this.auI = false;
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
        if (this.auI) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auI) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void sq() {
        if (this.giu != null) {
            if (this.auD.getHeight() >= this.giu.endY - (this.auM / 2)) {
                sr();
            } else {
                this.giw.ss();
            }
            this.mScroller.startScroll(0, this.auD.getHeight(), 0, this.giu.startY - this.auD.getHeight(), 200);
            this.gis.startScroll(0, this.git.getHeight(), 0, this.giv.startY - this.git.getHeight(), 200);
            invalidate();
            this.auI = false;
        }
    }

    public void sr() {
        if (this.giw != null) {
            this.giw.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.giw = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auD.setLayoutParams(new AbsListView.LayoutParams(this.auD.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.gis.computeScrollOffset()) {
            int currY = this.gis.getCurrY();
            if (this.git != null && (layoutParams = this.git.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.git.setLayoutParams(layoutParams);
            }
        }
    }

    private void O(float f) {
        this.giw.P(360.0f - ((f * 360.0f) / this.auM));
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
