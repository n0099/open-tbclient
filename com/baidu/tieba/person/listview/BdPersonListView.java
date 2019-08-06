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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class BdPersonListView extends BdTypeListView {
    private View MM;
    private float MO;
    private boolean MQ;
    private float MR;
    private final int MS;
    private final int MT;
    private final Scroller ikf;
    private View ikg;
    private b ikh;
    private b iki;
    public a ikj;
    private boolean ikk;
    private boolean ikl;
    private final Context mContext;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes4.dex */
    public interface a {
        void N(float f);

        void nY();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MQ = false;
        this.ikk = true;
        this.ikl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.ikf = new Scroller(this.mContext);
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandListView);
        this.MT = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.MM = view;
    }

    public void setOuterExpandView(View view) {
        this.ikg = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.MM == null || !this.ikk) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.MO = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.MM.getHeight();
                    this.startY = this.MO;
                    this.startX = this.MR;
                    this.ikh = new b(0, height, 0, this.MT + height);
                    int height2 = this.ikg.getHeight();
                    this.iki = new b(0, height2, 0, this.MT + height2);
                    break;
                case 1:
                case 3:
                    if (this.MQ) {
                        nW();
                        if (this.ikl) {
                            return true;
                        }
                    } else {
                        this.ikj.nY();
                        break;
                    }
                    break;
                case 2:
                    float f = this.MR - this.startX;
                    float f2 = this.MO - this.startY;
                    this.startX = this.MR;
                    if (this.MM.getParent() == this && this.ikh != null && this.MM.isShown() && this.MM.getTop() >= 0 && Math.abs(f2) >= this.MS && Math.abs(f) < this.MS) {
                        int O = this.ikh.O(this.MO - this.startY);
                        if (O > this.ikh.startY && O <= this.ikh.MW) {
                            this.MQ = true;
                            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), O));
                            if (this.ikg != null) {
                                int O2 = this.iki.O(this.MO - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.ikg.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.ikg.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.ikh.startY);
                            break;
                        } else if (O <= this.ikh.startY) {
                            this.MQ = false;
                            break;
                        } else if (O > this.ikh.MW) {
                            this.MQ = true;
                            break;
                        } else {
                            this.MQ = false;
                            break;
                        }
                    } else {
                        this.MQ = false;
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
        if (this.MQ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.MQ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nW() {
        if (this.ikh != null) {
            if (this.MM.getHeight() >= this.ikh.MW - (this.MT / 2)) {
                nX();
            } else {
                this.ikj.nY();
            }
            this.mScroller.startScroll(0, this.MM.getHeight(), 0, this.ikh.startY - this.MM.getHeight(), 200);
            this.ikf.startScroll(0, this.ikg.getHeight(), 0, this.iki.startY - this.ikg.getHeight(), 200);
            invalidate();
            this.MQ = false;
        }
    }

    public void nX() {
        if (this.ikj != null) {
            this.ikj.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.ikj = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.ikf.computeScrollOffset()) {
            int currY = this.ikf.getCurrY();
            if (this.ikg != null && (layoutParams = this.ikg.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.ikg.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.ikj.N(360.0f - ((f * 360.0f) / this.MT));
    }

    /* loaded from: classes4.dex */
    public static class b {
        public int MW;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.MW = i4;
        }

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
