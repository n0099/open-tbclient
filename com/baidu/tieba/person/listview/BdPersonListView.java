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
    private View Fq;
    private float Fs;
    private float Ft;
    private boolean Fv;
    private float Fw;
    private float Fx;
    private final int Fy;
    private final int Fz;
    private final Scroller fDc;
    private View fDd;
    private b fDe;
    private b fDf;
    public a fDg;
    private boolean fDh;
    private boolean fDi;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetStart, R.attr.contentInsetEnd};

    /* loaded from: classes2.dex */
    public interface a {
        void D(float f);

        void kz();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fv = false;
        this.fDh = true;
        this.fDi = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fDc = new Scroller(this.mContext);
        this.Fy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.Fz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2) {
        this.Fq = view2;
    }

    public void setOuterExpandView(View view2) {
        this.fDd = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Fq == null || !this.fDh) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Ft = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Fq.getHeight();
                    this.Fs = this.Ft;
                    this.Fw = this.Fx;
                    this.fDe = new b(0, height, 0, this.Fz + height);
                    int height2 = this.fDd.getHeight();
                    this.fDf = new b(0, height2, 0, this.Fz + height2);
                    break;
                case 1:
                case 3:
                    if (this.Fv) {
                        kx();
                        if (this.fDi) {
                            return true;
                        }
                    } else {
                        this.fDg.kz();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Fx - this.Fw;
                    float f2 = this.Ft - this.Fs;
                    this.Fw = this.Fx;
                    if (this.Fq.getParent() == this && this.fDe != null && this.Fq.isShown() && this.Fq.getTop() >= 0 && Math.abs(f2) >= this.Fy && Math.abs(f) < this.Fy) {
                        int E = this.fDe.E(this.Ft - this.Fs);
                        if (E > this.fDe.startY && E <= this.fDe.endY) {
                            this.Fv = true;
                            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), E));
                            if (this.fDd != null) {
                                int E2 = this.fDf.E(this.Ft - this.Fs);
                                ViewGroup.LayoutParams layoutParams = this.fDd.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = E2;
                                    this.fDd.setLayoutParams(layoutParams);
                                }
                            }
                            C(E - this.fDe.startY);
                            break;
                        } else if (E <= this.fDe.startY) {
                            this.Fv = false;
                            break;
                        } else if (E > this.fDe.endY) {
                            this.Fv = true;
                            break;
                        } else {
                            this.Fv = false;
                            break;
                        }
                    } else {
                        this.Fv = false;
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
        if (this.Fv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Fv) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kx() {
        if (this.fDe != null) {
            if (this.Fq.getHeight() >= this.fDe.endY - (this.Fz / 2)) {
                ky();
            } else {
                this.fDg.kz();
            }
            this.mScroller.startScroll(0, this.Fq.getHeight(), 0, this.fDe.startY - this.Fq.getHeight(), 200);
            this.fDc.startScroll(0, this.fDd.getHeight(), 0, this.fDf.startY - this.fDd.getHeight(), 200);
            invalidate();
            this.Fv = false;
        }
    }

    public void ky() {
        if (this.fDg != null) {
            this.fDg.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fDg = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fDc.computeScrollOffset()) {
            int currY = this.fDc.getCurrY();
            if (this.fDd != null && (layoutParams = this.fDd.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fDd.setLayoutParams(layoutParams);
            }
        }
    }

    private void C(float f) {
        this.fDg.D(360.0f - ((f * 360.0f) / this.Fz));
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

        public int E(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
