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
/* loaded from: classes4.dex */
public class BdPersonListView extends BdTypeListView {
    private View MM;
    private float MO;
    private boolean MQ;
    private float MR;
    private final int MS;
    private final int MT;
    private final Scroller ime;
    private View imf;
    private b imh;
    private b imi;
    public a imj;
    private boolean imk;
    private boolean iml;
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
        this.imk = true;
        this.iml = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.ime = new Scroller(this.mContext);
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.ExpandListView);
        this.MT = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.MM = view;
    }

    public void setOuterExpandView(View view) {
        this.imf = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.MM == null || !this.imk) {
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
                    this.imh = new b(0, height, 0, this.MT + height);
                    int height2 = this.imf.getHeight();
                    this.imi = new b(0, height2, 0, this.MT + height2);
                    break;
                case 1:
                case 3:
                    if (this.MQ) {
                        nW();
                        if (this.iml) {
                            return true;
                        }
                    } else {
                        this.imj.nY();
                        break;
                    }
                    break;
                case 2:
                    float f = this.MR - this.startX;
                    float f2 = this.MO - this.startY;
                    this.startX = this.MR;
                    if (this.MM.getParent() == this && this.imh != null && this.MM.isShown() && this.MM.getTop() >= 0 && Math.abs(f2) >= this.MS && Math.abs(f) < this.MS) {
                        int O = this.imh.O(this.MO - this.startY);
                        if (O > this.imh.startY && O <= this.imh.MW) {
                            this.MQ = true;
                            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), O));
                            if (this.imf != null) {
                                int O2 = this.imi.O(this.MO - this.startY);
                                ViewGroup.LayoutParams layoutParams = this.imf.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.imf.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.imh.startY);
                            break;
                        } else if (O <= this.imh.startY) {
                            this.MQ = false;
                            break;
                        } else if (O > this.imh.MW) {
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
        if (this.imh != null) {
            if (this.MM.getHeight() >= this.imh.MW - (this.MT / 2)) {
                nX();
            } else {
                this.imj.nY();
            }
            this.mScroller.startScroll(0, this.MM.getHeight(), 0, this.imh.startY - this.MM.getHeight(), 200);
            this.ime.startScroll(0, this.imf.getHeight(), 0, this.imi.startY - this.imf.getHeight(), 200);
            invalidate();
            this.MQ = false;
        }
    }

    public void nX() {
        if (this.imj != null) {
            this.imj.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.imj = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.MM.setLayoutParams(new AbsListView.LayoutParams(this.MM.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.ime.computeScrollOffset()) {
            int currY = this.ime.getCurrY();
            if (this.imf != null && (layoutParams = this.imf.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.imf.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.imj.N(360.0f - ((f * 360.0f) / this.MT));
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
