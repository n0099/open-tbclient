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
    private final Scroller fDf;
    private View fDg;
    private b fDh;
    private b fDi;
    public a fDj;
    private boolean fDk;
    private boolean fDl;
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
        this.fDk = true;
        this.fDl = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fDf = new Scroller(this.mContext);
        this.Fy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.Fz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2) {
        this.Fq = view2;
    }

    public void setOuterExpandView(View view2) {
        this.fDg = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Fq == null || !this.fDk) {
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
                    this.fDh = new b(0, height, 0, this.Fz + height);
                    int height2 = this.fDg.getHeight();
                    this.fDi = new b(0, height2, 0, this.Fz + height2);
                    break;
                case 1:
                case 3:
                    if (this.Fv) {
                        kx();
                        if (this.fDl) {
                            return true;
                        }
                    } else {
                        this.fDj.kz();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Fx - this.Fw;
                    float f2 = this.Ft - this.Fs;
                    this.Fw = this.Fx;
                    if (this.Fq.getParent() == this && this.fDh != null && this.Fq.isShown() && this.Fq.getTop() >= 0 && Math.abs(f2) >= this.Fy && Math.abs(f) < this.Fy) {
                        int E = this.fDh.E(this.Ft - this.Fs);
                        if (E > this.fDh.startY && E <= this.fDh.endY) {
                            this.Fv = true;
                            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), E));
                            if (this.fDg != null) {
                                int E2 = this.fDi.E(this.Ft - this.Fs);
                                ViewGroup.LayoutParams layoutParams = this.fDg.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = E2;
                                    this.fDg.setLayoutParams(layoutParams);
                                }
                            }
                            C(E - this.fDh.startY);
                            break;
                        } else if (E <= this.fDh.startY) {
                            this.Fv = false;
                            break;
                        } else if (E > this.fDh.endY) {
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
        if (this.fDh != null) {
            if (this.Fq.getHeight() >= this.fDh.endY - (this.Fz / 2)) {
                ky();
            } else {
                this.fDj.kz();
            }
            this.mScroller.startScroll(0, this.Fq.getHeight(), 0, this.fDh.startY - this.Fq.getHeight(), 200);
            this.fDf.startScroll(0, this.fDg.getHeight(), 0, this.fDi.startY - this.fDg.getHeight(), 200);
            invalidate();
            this.Fv = false;
        }
    }

    public void ky() {
        if (this.fDj != null) {
            this.fDj.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fDj = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fDf.computeScrollOffset()) {
            int currY = this.fDf.getCurrY();
            if (this.fDg != null && (layoutParams = this.fDg.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fDg.setLayoutParams(layoutParams);
            }
        }
    }

    private void C(float f) {
        this.fDj.D(360.0f - ((f * 360.0f) / this.Fz));
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
