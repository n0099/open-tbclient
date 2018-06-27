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
/* loaded from: classes2.dex */
public class BdPersonListView extends BdTypeListView {
    private boolean LA;
    private float LB;
    private float LC;
    private final int LD;
    private final int LE;
    private View Lv;
    private float Lx;
    private float Ly;
    private final Scroller fTE;
    private View fTF;
    private b fTG;
    private b fTH;
    public a fTI;
    private boolean fTJ;
    private boolean fTK;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes2.dex */
    public interface a {
        void N(float f);

        void nm();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LA = false;
        this.fTJ = true;
        this.fTK = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fTE = new Scroller(this.mContext);
        this.LD = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.LE = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Lv = view;
    }

    public void setOuterExpandView(View view) {
        this.fTF = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Lv == null || !this.fTJ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ly = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lv.getHeight();
                    this.Lx = this.Ly;
                    this.LB = this.LC;
                    this.fTG = new b(0, height, 0, this.LE + height);
                    int height2 = this.fTF.getHeight();
                    this.fTH = new b(0, height2, 0, this.LE + height2);
                    break;
                case 1:
                case 3:
                    if (this.LA) {
                        nk();
                        if (this.fTK) {
                            return true;
                        }
                    } else {
                        this.fTI.nm();
                        break;
                    }
                    break;
                case 2:
                    float f = this.LC - this.LB;
                    float f2 = this.Ly - this.Lx;
                    this.LB = this.LC;
                    if (this.Lv.getParent() == this && this.fTG != null && this.Lv.isShown() && this.Lv.getTop() >= 0 && Math.abs(f2) >= this.LD && Math.abs(f) < this.LD) {
                        int O = this.fTG.O(this.Ly - this.Lx);
                        if (O > this.fTG.startY && O <= this.fTG.endY) {
                            this.LA = true;
                            this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), O));
                            if (this.fTF != null) {
                                int O2 = this.fTH.O(this.Ly - this.Lx);
                                ViewGroup.LayoutParams layoutParams = this.fTF.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.fTF.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.fTG.startY);
                            break;
                        } else if (O <= this.fTG.startY) {
                            this.LA = false;
                            break;
                        } else if (O > this.fTG.endY) {
                            this.LA = true;
                            break;
                        } else {
                            this.LA = false;
                            break;
                        }
                    } else {
                        this.LA = false;
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
        if (this.LA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.LA) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nk() {
        if (this.fTG != null) {
            if (this.Lv.getHeight() >= this.fTG.endY - (this.LE / 2)) {
                nl();
            } else {
                this.fTI.nm();
            }
            this.mScroller.startScroll(0, this.Lv.getHeight(), 0, this.fTG.startY - this.Lv.getHeight(), 200);
            this.fTE.startScroll(0, this.fTF.getHeight(), 0, this.fTH.startY - this.fTF.getHeight(), 200);
            invalidate();
            this.LA = false;
        }
    }

    public void nl() {
        if (this.fTI != null) {
            this.fTI.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fTI = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Lv.setLayoutParams(new AbsListView.LayoutParams(this.Lv.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fTE.computeScrollOffset()) {
            int currY = this.fTE.getCurrY();
            if (this.fTF != null && (layoutParams = this.fTF.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fTF.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.fTI.N(360.0f - ((f * 360.0f) / this.LE));
    }

    /* loaded from: classes2.dex */
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
