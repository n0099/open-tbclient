package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View Fq;
    private int Fr;
    private float Fs;
    private float Ft;
    private boolean Fv;
    private final int Fy;
    private final int Fz;
    private b gWH;
    public a gWI;
    private long gWJ;
    private boolean gWK;
    private Runnable gWL;
    private int gWM;
    private long gWi;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void D(float f);

        void kz();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.gWK = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fv = false;
        this.gWJ = 0L;
        this.gWi = 0L;
        this.mHandler = new Handler();
        this.gWK = false;
        this.gWL = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Fr > 0) {
                    BdExpandListView.this.Fq.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Fq.getWidth(), BdExpandListView.this.Fr));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gWM = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Fy = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.Fz = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2, int i) {
        this.Fq = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gWK) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Fq == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Ft = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gWJ = System.currentTimeMillis() - this.gWi;
                    this.gWi = System.currentTimeMillis();
                    this.Fv = false;
                    setClickEventEnabled(true);
                    if (this.Fr == 0) {
                        this.Fr = this.Fq.getHeight();
                    }
                    int height = this.Fq.getHeight();
                    this.Fs = this.Ft;
                    this.gWH = new b(0, height, 0, this.Fz + height);
                    break;
                case 1:
                case 3:
                    if (this.Fv) {
                        setClickEventEnabled(false);
                        kx();
                        this.Fv = false;
                    } else if (this.gWI != null) {
                        this.gWI.kz();
                    }
                    this.mHandler.removeCallbacks(this.gWL);
                    this.mHandler.postDelayed(this.gWL, 200L);
                    break;
                case 2:
                    float f = this.Ft - this.Fs;
                    if (this.Fq.getParent() == this && this.gWH != null && this.Fq.isShown() && this.Fq.getTop() >= 0 && Math.abs(f) >= this.Fy && this.gWJ > 400) {
                        int E = this.gWH.E(this.Ft - this.Fs);
                        if (E > this.gWH.startY && E <= this.gWH.endY) {
                            this.Fv = true;
                            setClickEventEnabled(false);
                            this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), E));
                            C(E - this.gWH.startY);
                            break;
                        } else if (E <= this.gWH.startY) {
                            this.Fv = false;
                            break;
                        } else if (E > this.gWH.endY) {
                            this.Fv = true;
                            setClickEventEnabled(false);
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

    private void setClickEventEnabled(boolean z) {
        setClickable(z);
        setLongClickable(z);
        setEnabled(z);
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

    public void kx() {
        if (this.gWH != null) {
            if (this.Fq.getHeight() >= this.gWH.endY - (this.Fz / 2)) {
                ky();
            } else if (this.gWI != null) {
                this.gWI.kz();
            }
            this.mScroller.startScroll(0, this.Fq.getHeight(), 0, this.gWH.startY - this.Fq.getHeight(), 200);
            invalidate();
        }
    }

    public void ky() {
        if (this.gWI != null) {
            this.gWI.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gWI = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gWK) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Fq != null && !this.Fv) {
            this.Fv = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Fz, 0, -this.Fz, 200);
            ky();
            invalidate();
            this.mHandler.removeCallbacks(this.gWL);
            this.mHandler.postDelayed(this.gWL, 200L);
            this.Fv = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Fr <= 0) {
            this.Fr = this.Fq.getHeight();
        }
        return this.Fr;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gWK) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gWM - currY) > this.Fy * 2) {
                this.gWM = currY;
                this.Fq.setLayoutParams(new AbsListView.LayoutParams(this.Fq.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void C(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Fz);
        if (this.gWI != null) {
            this.gWI.D(f2);
        }
    }

    /* loaded from: classes.dex */
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
