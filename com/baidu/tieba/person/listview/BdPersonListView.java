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
    private View Fm;
    private float Fo;
    private float Fp;
    private boolean Fr;
    private float Fs;
    private float Ft;
    private final int Fu;
    private final int Fv;
    private final Scroller fEi;
    private View fEj;
    private b fEk;
    private b fEl;
    public a fEm;
    private boolean fEn;
    private boolean fEo;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetStart, R.attr.contentInsetEnd};

    /* loaded from: classes2.dex */
    public interface a {
        void D(float f);

        void ky();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fr = false;
        this.fEn = true;
        this.fEo = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fEi = new Scroller(this.mContext);
        this.Fu = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.Fv = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2) {
        this.Fm = view2;
    }

    public void setOuterExpandView(View view2) {
        this.fEj = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Fm == null || !this.fEn) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Fp = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Fm.getHeight();
                    this.Fo = this.Fp;
                    this.Fs = this.Ft;
                    this.fEk = new b(0, height, 0, this.Fv + height);
                    int height2 = this.fEj.getHeight();
                    this.fEl = new b(0, height2, 0, this.Fv + height2);
                    break;
                case 1:
                case 3:
                    if (this.Fr) {
                        kw();
                        if (this.fEo) {
                            return true;
                        }
                    } else {
                        this.fEm.ky();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Ft - this.Fs;
                    float f2 = this.Fp - this.Fo;
                    this.Fs = this.Ft;
                    if (this.Fm.getParent() == this && this.fEk != null && this.Fm.isShown() && this.Fm.getTop() >= 0 && Math.abs(f2) >= this.Fu && Math.abs(f) < this.Fu) {
                        int E = this.fEk.E(this.Fp - this.Fo);
                        if (E > this.fEk.startY && E <= this.fEk.endY) {
                            this.Fr = true;
                            this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), E));
                            if (this.fEj != null) {
                                int E2 = this.fEl.E(this.Fp - this.Fo);
                                ViewGroup.LayoutParams layoutParams = this.fEj.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = E2;
                                    this.fEj.setLayoutParams(layoutParams);
                                }
                            }
                            C(E - this.fEk.startY);
                            break;
                        } else if (E <= this.fEk.startY) {
                            this.Fr = false;
                            break;
                        } else if (E > this.fEk.endY) {
                            this.Fr = true;
                            break;
                        } else {
                            this.Fr = false;
                            break;
                        }
                    } else {
                        this.Fr = false;
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
        if (this.Fr) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Fr) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kw() {
        if (this.fEk != null) {
            if (this.Fm.getHeight() >= this.fEk.endY - (this.Fv / 2)) {
                kx();
            } else {
                this.fEm.ky();
            }
            this.mScroller.startScroll(0, this.Fm.getHeight(), 0, this.fEk.startY - this.Fm.getHeight(), 200);
            this.fEi.startScroll(0, this.fEj.getHeight(), 0, this.fEl.startY - this.fEj.getHeight(), 200);
            invalidate();
            this.Fr = false;
        }
    }

    public void kx() {
        if (this.fEm != null) {
            this.fEm.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fEm = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fEi.computeScrollOffset()) {
            int currY = this.fEi.getCurrY();
            if (this.fEj != null && (layoutParams = this.fEj.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fEj.setLayoutParams(layoutParams);
            }
        }
    }

    private void C(float f) {
        this.fEm.D(360.0f - ((f * 360.0f) / this.Fv));
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
