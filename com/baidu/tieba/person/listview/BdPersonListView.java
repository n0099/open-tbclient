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
    private final Scroller giC;
    private View giD;
    private b giE;
    private b giF;
    public a giG;
    private boolean giH;
    private boolean giI;
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
        this.giH = true;
        this.giI = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.giC = new Scroller(this.mContext);
        this.Os = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Ot = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Ok = view;
    }

    public void setOuterExpandView(View view) {
        this.giD = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ok == null || !this.giH) {
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
                    this.giE = new b(0, height, 0, this.Ot + height);
                    int height2 = this.giD.getHeight();
                    this.giF = new b(0, height2, 0, this.Ot + height2);
                    break;
                case 1:
                case 3:
                    if (this.Op) {
                        oD();
                        if (this.giI) {
                            return true;
                        }
                    } else {
                        this.giG.oF();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Or - this.Oq;
                    float f2 = this.On - this.Om;
                    this.Oq = this.Or;
                    if (this.Ok.getParent() == this && this.giE != null && this.Ok.isShown() && this.Ok.getTop() >= 0 && Math.abs(f2) >= this.Os && Math.abs(f) < this.Os) {
                        int O = this.giE.O(this.On - this.Om);
                        if (O > this.giE.startY && O <= this.giE.endY) {
                            this.Op = true;
                            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), O));
                            if (this.giD != null) {
                                int O2 = this.giF.O(this.On - this.Om);
                                ViewGroup.LayoutParams layoutParams = this.giD.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.giD.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.giE.startY);
                            break;
                        } else if (O <= this.giE.startY) {
                            this.Op = false;
                            break;
                        } else if (O > this.giE.endY) {
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
        if (this.giE != null) {
            if (this.Ok.getHeight() >= this.giE.endY - (this.Ot / 2)) {
                oE();
            } else {
                this.giG.oF();
            }
            this.mScroller.startScroll(0, this.Ok.getHeight(), 0, this.giE.startY - this.Ok.getHeight(), 200);
            this.giC.startScroll(0, this.giD.getHeight(), 0, this.giF.startY - this.giD.getHeight(), 200);
            invalidate();
            this.Op = false;
        }
    }

    public void oE() {
        if (this.giG != null) {
            this.giG.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.giG = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Ok.setLayoutParams(new AbsListView.LayoutParams(this.Ok.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.giC.computeScrollOffset()) {
            int currY = this.giC.getCurrY();
            if (this.giD != null && (layoutParams = this.giD.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.giD.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.giG.N(360.0f - ((f * 360.0f) / this.Ot));
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
