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
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class BdPersonListView extends BdTypeListView {
    private View Ok;
    private float Om;
    private float On;
    private boolean Op;
    private float Oq;
    private float Or;
    private final int Os;
    private final int Ot;
    private final Scroller giB;
    private View giC;
    private b giD;
    private b giE;
    public a giF;
    private boolean giG;
    private boolean giH;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes5.dex */
    public interface a {
        void N(float f);

        void oF();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Op = false;
        this.giG = true;
        this.giH = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.giB = new Scroller(this.mContext);
        this.Os = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Ot = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Ok = view;
    }

    public void setOuterExpandView(View view) {
        this.giC = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ok == null || !this.giG) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.On = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ok.getHeight();
                    this.Om = this.On;
                    this.Oq = this.Or;
                    this.giD = new b(0, height, 0, this.Ot + height);
                    int height2 = this.giC.getHeight();
                    this.giE = new b(0, height2, 0, this.Ot + height2);
                    break;
                case 1:
                case 3:
                    if (this.Op) {
                        oD();
                        if (this.giH) {
                            return true;
                        }
                    } else {
                        this.giF.oF();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Or - this.Oq;
                    float f2 = this.On - this.Om;
                    this.Oq = this.Or;
                    if (this.Ok.getParent() == this && this.giD != null && this.Ok.isShown() && this.Ok.getTop() >= 0 && Math.abs(f2) >= this.Os && Math.abs(f) < this.Os) {
                        int O = this.giD.O(this.On - this.Om);
                        if (O > this.giD.startY && O <= this.giD.endY) {
                            this.Op = true;
                            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), O));
                            if (this.giC != null) {
                                int O2 = this.giE.O(this.On - this.Om);
                                ViewGroup.LayoutParams layoutParams = this.giC.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.giC.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.giD.startY);
                            break;
                        } else if (O <= this.giD.startY) {
                            this.Op = false;
                            break;
                        } else if (O > this.giD.endY) {
                            this.Op = true;
                            break;
                        } else {
                            this.Op = false;
                            break;
                        }
                    } else {
                        this.Op = false;
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
        if (this.Op) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Op) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void oD() {
        if (this.giD != null) {
            if (this.Ok.getHeight() >= this.giD.endY - (this.Ot / 2)) {
                oE();
            } else {
                this.giF.oF();
            }
            this.mScroller.startScroll(0, this.Ok.getHeight(), 0, this.giD.startY - this.Ok.getHeight(), 200);
            this.giB.startScroll(0, this.giC.getHeight(), 0, this.giE.startY - this.giC.getHeight(), 200);
            invalidate();
            this.Op = false;
        }
    }

    public void oE() {
        if (this.giF != null) {
            this.giF.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.giF = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.giB.computeScrollOffset()) {
            int currY = this.giB.getCurrY();
            if (this.giC != null && (layoutParams = this.giC.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.giC.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.giF.N(360.0f - ((f * 360.0f) / this.Ot));
    }

    /* loaded from: classes5.dex */
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
