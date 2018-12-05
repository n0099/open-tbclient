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
    private View On;
    private float Op;
    private boolean Or;
    private float Os;
    private final int Ot;
    private final int Ou;
    private final Scroller gqO;
    private View gqP;
    private b gqQ;
    private b gqR;
    public a gqS;
    private boolean gqT;
    private boolean gqU;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes5.dex */
    public interface a {
        void N(float f);

        void oC();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Or = false;
        this.gqT = true;
        this.gqU = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.gqO = new Scroller(this.mContext);
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Ou = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.On = view;
    }

    public void setOuterExpandView(View view) {
        this.gqP = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.On == null || !this.gqT) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Op = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.On.getHeight();
                    this.startY = this.Op;
                    this.startX = this.Os;
                    this.gqQ = new b(0, height, 0, this.Ou + height);
                    int height2 = this.gqP.getHeight();
                    this.gqR = new b(0, height2, 0, this.Ou + height2);
                    break;
                case 1:
                case 3:
                    if (this.Or) {
                        oA();
                        if (this.gqU) {
                            return true;
                        }
                    } else {
                        this.gqS.oC();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Os - this.startX;
                    float f2 = this.Op - this.startY;
                    this.startX = this.Os;
                    if (this.On.getParent() == this && this.gqQ != null && this.On.isShown() && this.On.getTop() >= 0 && Math.abs(f2) >= this.Ot && Math.abs(f) < this.Ot) {
                        int O = this.gqQ.O(this.Op - this.startY);
                        if (O > this.gqQ.startY && O <= this.gqQ.endY) {
                            this.Or = true;
                            this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), O));
                            if (this.gqP != null) {
                                int O2 = this.gqR.O(this.Op - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.gqP.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.gqP.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.gqQ.startY);
                            break;
                        } else if (O <= this.gqQ.startY) {
                            this.Or = false;
                            break;
                        } else if (O > this.gqQ.endY) {
                            this.Or = true;
                            break;
                        } else {
                            this.Or = false;
                            break;
                        }
                    } else {
                        this.Or = false;
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
        if (this.Or) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Or) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void oA() {
        if (this.gqQ != null) {
            if (this.On.getHeight() >= this.gqQ.endY - (this.Ou / 2)) {
                oB();
            } else {
                this.gqS.oC();
            }
            this.mScroller.startScroll(0, this.On.getHeight(), 0, this.gqQ.startY - this.On.getHeight(), 200);
            this.gqO.startScroll(0, this.gqP.getHeight(), 0, this.gqR.startY - this.gqP.getHeight(), 200);
            invalidate();
            this.Or = false;
        }
    }

    public void oB() {
        if (this.gqS != null) {
            this.gqS.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gqS = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.gqO.computeScrollOffset()) {
            int currY = this.gqO.getCurrY();
            if (this.gqP != null && (layoutParams = this.gqP.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.gqP.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.gqS.N(360.0f - ((f * 360.0f) / this.Ou));
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
