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
    private final int LA;
    private View Lr;
    private float Lt;
    private float Lu;
    private boolean Lw;
    private float Lx;
    private float Ly;
    private final int Lz;
    private final Scroller fTR;
    private View fTS;
    private b fTT;
    private b fTU;
    public a fTV;
    private boolean fTW;
    private boolean fTX;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.expandActivityOverflowButtonDrawable, R.attr.adpMode};

    /* loaded from: classes2.dex */
    public interface a {
        void N(float f);

        void no();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lw = false;
        this.fTW = true;
        this.fTX = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fTR = new Scroller(this.mContext);
        this.Lz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.LA = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Lr = view;
    }

    public void setOuterExpandView(View view) {
        this.fTS = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Lr == null || !this.fTW) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Lu = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lr.getHeight();
                    this.Lt = this.Lu;
                    this.Lx = this.Ly;
                    this.fTT = new b(0, height, 0, this.LA + height);
                    int height2 = this.fTS.getHeight();
                    this.fTU = new b(0, height2, 0, this.LA + height2);
                    break;
                case 1:
                case 3:
                    if (this.Lw) {
                        nm();
                        if (this.fTX) {
                            return true;
                        }
                    } else {
                        this.fTV.no();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Ly - this.Lx;
                    float f2 = this.Lu - this.Lt;
                    this.Lx = this.Ly;
                    if (this.Lr.getParent() == this && this.fTT != null && this.Lr.isShown() && this.Lr.getTop() >= 0 && Math.abs(f2) >= this.Lz && Math.abs(f) < this.Lz) {
                        int O = this.fTT.O(this.Lu - this.Lt);
                        if (O > this.fTT.startY && O <= this.fTT.endY) {
                            this.Lw = true;
                            this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), O));
                            if (this.fTS != null) {
                                int O2 = this.fTU.O(this.Lu - this.Lt);
                                ViewGroup.LayoutParams layoutParams = this.fTS.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.fTS.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.fTT.startY);
                            break;
                        } else if (O <= this.fTT.startY) {
                            this.Lw = false;
                            break;
                        } else if (O > this.fTT.endY) {
                            this.Lw = true;
                            break;
                        } else {
                            this.Lw = false;
                            break;
                        }
                    } else {
                        this.Lw = false;
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
        if (this.Lw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Lw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nm() {
        if (this.fTT != null) {
            if (this.Lr.getHeight() >= this.fTT.endY - (this.LA / 2)) {
                nn();
            } else {
                this.fTV.no();
            }
            this.mScroller.startScroll(0, this.Lr.getHeight(), 0, this.fTT.startY - this.Lr.getHeight(), 200);
            this.fTR.startScroll(0, this.fTS.getHeight(), 0, this.fTU.startY - this.fTS.getHeight(), 200);
            invalidate();
            this.Lw = false;
        }
    }

    public void nn() {
        if (this.fTV != null) {
            this.fTV.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fTV = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Lr.setLayoutParams(new AbsListView.LayoutParams(this.Lr.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fTR.computeScrollOffset()) {
            int currY = this.fTR.getCurrY();
            if (this.fTS != null && (layoutParams = this.fTS.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fTS.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.fTV.N(360.0f - ((f * 360.0f) / this.LA));
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
