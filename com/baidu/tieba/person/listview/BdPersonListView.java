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
    private View GN;
    private float GP;
    private float GQ;
    private boolean GT;
    private float GU;
    private float GV;
    private final int GW;
    private final int GX;
    private final Scroller fsc;
    private View fsd;
    private b fse;
    private b fsf;
    public a fsg;
    private boolean fsh;
    private boolean fsi;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GT = false;
        this.fsh = true;
        this.fsi = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fsc = new Scroller(this.mContext);
        this.GW = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GX = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.GN = view;
    }

    public void setOuterExpandView(View view) {
        this.fsd = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GN == null || !this.fsh) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GQ = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GN.getHeight();
                    this.GP = this.GQ;
                    this.GU = this.GV;
                    this.fse = new b(0, height, 0, this.GX + height);
                    int height2 = this.fsd.getHeight();
                    this.fsf = new b(0, height2, 0, this.GX + height2);
                    break;
                case 1:
                case 3:
                    if (this.GT) {
                        kT();
                        if (this.fsi) {
                            return true;
                        }
                    } else {
                        this.fsg.kV();
                        break;
                    }
                    break;
                case 2:
                    float f = this.GV - this.GU;
                    float f2 = this.GQ - this.GP;
                    this.GU = this.GV;
                    if (this.GN.getParent() == this && this.fse != null && this.GN.isShown() && this.GN.getTop() >= 0 && Math.abs(f2) >= this.GW && Math.abs(f) < this.GW) {
                        int w = this.fse.w(this.GQ - this.GP);
                        if (w > this.fse.startY && w <= this.fse.Ha) {
                            this.GT = true;
                            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), w));
                            if (this.fsd != null) {
                                int w2 = this.fsf.w(this.GQ - this.GP);
                                ViewGroup.LayoutParams layoutParams = this.fsd.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = w2;
                                    this.fsd.setLayoutParams(layoutParams);
                                }
                            }
                            u(w - this.fse.startY);
                            break;
                        } else if (w <= this.fse.startY) {
                            this.GT = false;
                            break;
                        } else if (w > this.fse.Ha) {
                            this.GT = true;
                            break;
                        } else {
                            this.GT = false;
                            break;
                        }
                    } else {
                        this.GT = false;
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
        if (this.GT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GT) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kT() {
        if (this.fse != null) {
            if (this.GN.getHeight() >= this.fse.Ha - (this.GX / 2)) {
                kU();
            } else {
                this.fsg.kV();
            }
            this.mScroller.startScroll(0, this.GN.getHeight(), 0, this.fse.startY - this.GN.getHeight(), 200);
            this.fsc.startScroll(0, this.fsd.getHeight(), 0, this.fsf.startY - this.fsd.getHeight(), 200);
            invalidate();
            this.GT = false;
        }
    }

    public void kU() {
        if (this.fsg != null) {
            this.fsg.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fsg = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.GN.setLayoutParams(new AbsListView.LayoutParams(this.GN.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fsc.computeScrollOffset()) {
            int currY = this.fsc.getCurrY();
            if (this.fsd != null && (layoutParams = this.fsd.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fsd.setLayoutParams(layoutParams);
            }
        }
    }

    private void u(float f) {
        this.fsg.v(360.0f - ((f * 360.0f) / this.GX));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Ha;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Ha = i4;
        }

        public int w(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
