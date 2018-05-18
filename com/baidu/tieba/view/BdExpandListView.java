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
    private View Fm;
    private int Fn;
    private float Fo;
    private float Fp;
    private boolean Fr;
    private final int Fu;
    private final int Fv;
    private b gXI;
    public a gXJ;
    private long gXK;
    private boolean gXL;
    private Runnable gXM;
    private int gXN;
    private long gXj;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void D(float f);

        void ky();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.gXL = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fr = false;
        this.gXK = 0L;
        this.gXj = 0L;
        this.mHandler = new Handler();
        this.gXL = false;
        this.gXM = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Fn > 0) {
                    BdExpandListView.this.Fm.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Fm.getWidth(), BdExpandListView.this.Fn));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gXN = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Fu = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.Fv = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view2, int i) {
        this.Fm = view2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gXL) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Fm == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Fp = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gXK = System.currentTimeMillis() - this.gXj;
                    this.gXj = System.currentTimeMillis();
                    this.Fr = false;
                    setClickEventEnabled(true);
                    if (this.Fn == 0) {
                        this.Fn = this.Fm.getHeight();
                    }
                    int height = this.Fm.getHeight();
                    this.Fo = this.Fp;
                    this.gXI = new b(0, height, 0, this.Fv + height);
                    break;
                case 1:
                case 3:
                    if (this.Fr) {
                        setClickEventEnabled(false);
                        kw();
                        this.Fr = false;
                    } else if (this.gXJ != null) {
                        this.gXJ.ky();
                    }
                    this.mHandler.removeCallbacks(this.gXM);
                    this.mHandler.postDelayed(this.gXM, 200L);
                    break;
                case 2:
                    float f = this.Fp - this.Fo;
                    if (this.Fm.getParent() == this && this.gXI != null && this.Fm.isShown() && this.Fm.getTop() >= 0 && Math.abs(f) >= this.Fu && this.gXK > 400) {
                        int E = this.gXI.E(this.Fp - this.Fo);
                        if (E > this.gXI.startY && E <= this.gXI.endY) {
                            this.Fr = true;
                            setClickEventEnabled(false);
                            this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), E));
                            C(E - this.gXI.startY);
                            break;
                        } else if (E <= this.gXI.startY) {
                            this.Fr = false;
                            break;
                        } else if (E > this.gXI.endY) {
                            this.Fr = true;
                            setClickEventEnabled(false);
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

    private void setClickEventEnabled(boolean z) {
        setClickable(z);
        setLongClickable(z);
        setEnabled(z);
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

    public void kw() {
        if (this.gXI != null) {
            if (this.Fm.getHeight() >= this.gXI.endY - (this.Fv / 2)) {
                kx();
            } else if (this.gXJ != null) {
                this.gXJ.ky();
            }
            this.mScroller.startScroll(0, this.Fm.getHeight(), 0, this.gXI.startY - this.Fm.getHeight(), 200);
            invalidate();
        }
    }

    public void kx() {
        if (this.gXJ != null) {
            this.gXJ.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gXJ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gXL) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Fm != null && !this.Fr) {
            this.Fr = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Fv, 0, -this.Fv, 200);
            kx();
            invalidate();
            this.mHandler.removeCallbacks(this.gXM);
            this.mHandler.postDelayed(this.gXM, 200L);
            this.Fr = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Fn <= 0) {
            this.Fn = this.Fm.getHeight();
        }
        return this.Fn;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gXL) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gXN - currY) > this.Fu * 2) {
                this.gXN = currY;
                this.Fm.setLayoutParams(new AbsListView.LayoutParams(this.Fm.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void C(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Fv);
        if (this.gXJ != null) {
            this.gXJ.D(f2);
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
