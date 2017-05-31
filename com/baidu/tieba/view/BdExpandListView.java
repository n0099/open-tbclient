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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View HG;
    private int HH;
    private float HI;
    private float HJ;
    private boolean HL;
    private final int HO;
    private final int HP;
    private b fPT;
    public a fPU;
    private long fPV;
    private long fPW;
    private boolean fPX;
    private boolean fPY;
    private Runnable fPZ;
    private int fQa;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void lc();

        void ld();
    }

    public void setStarForum(boolean z) {
        this.fPY = z;
    }

    public boolean bhm() {
        return this.fPY;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HL = false;
        this.fPV = 0L;
        this.fPW = 0L;
        this.mHandler = new Handler();
        this.fPX = false;
        this.fPY = false;
        this.fPZ = new com.baidu.tieba.view.b(this);
        this.fQa = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.HO = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.ExpandListView);
        this.HP = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.HG = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fPY) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.HG == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.HJ = motionEvent.getY();
            switch (action) {
                case 0:
                    this.fPV = System.currentTimeMillis() - this.fPW;
                    this.fPW = System.currentTimeMillis();
                    this.HL = false;
                    setClickEventEnabled(true);
                    if (this.HH == 0) {
                        this.HH = this.HG.getHeight();
                    }
                    int height = this.HG.getHeight();
                    this.HI = this.HJ;
                    this.fPT = new b(0, height, 0, this.HP + height);
                    break;
                case 1:
                case 3:
                    if (this.HL) {
                        setClickEventEnabled(false);
                        la();
                        this.HL = false;
                    } else if (this.fPU != null) {
                        this.fPU.lc();
                    }
                    this.mHandler.removeCallbacks(this.fPZ);
                    this.mHandler.postDelayed(this.fPZ, 200L);
                    break;
                case 2:
                    float f = this.HJ - this.HI;
                    if (this.HG.getParent() == this && this.fPT != null && this.HG.isShown() && this.HG.getTop() >= 0 && Math.abs(f) >= this.HO && this.fPV > 400) {
                        int H = this.fPT.H(this.HJ - this.HI);
                        if (H > this.fPT.HT && H <= this.fPT.HV) {
                            this.HL = true;
                            setClickEventEnabled(false);
                            this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), H));
                            F(H - this.fPT.HT);
                            break;
                        } else if (H <= this.fPT.HT) {
                            this.HL = false;
                            break;
                        } else if (H > this.fPT.HV) {
                            this.HL = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.HL = false;
                            break;
                        }
                    } else {
                        this.HL = false;
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
        if (this.HL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.HL) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void la() {
        if (this.fPT != null) {
            if (this.HG.getHeight() >= this.fPT.HV - (this.HP / 2)) {
                lb();
            } else if (this.fPU != null) {
                this.fPU.lc();
            }
            this.mScroller.startScroll(0, this.HG.getHeight(), 0, this.fPT.HT - this.HG.getHeight(), 200);
            invalidate();
        }
    }

    public void lb() {
        if (this.fPU != null) {
            this.fPU.ld();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fPU = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.fPY) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.HG != null && !this.HL) {
            this.HL = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.HP, 0, -this.HP, 200);
            lb();
            invalidate();
            this.mHandler.removeCallbacks(this.fPZ);
            this.mHandler.postDelayed(this.fPZ, 200L);
            this.HL = false;
        }
    }

    private int getOriginalHeight() {
        if (this.HH <= 0) {
            this.HH = this.HG.getHeight();
        }
        return this.HH;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fPY) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fQa - currY) > this.HO * 2) {
                this.fQa = currY;
                this.HG.setLayoutParams(new AbsListView.LayoutParams(this.HG.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HP);
        if (this.fPU != null) {
            this.fPU.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HS;
        public int HT;
        public int HU;
        public int HV;

        public b(int i, int i2, int i3, int i4) {
            this.HS = i;
            this.HT = i2;
            this.HU = i3;
            this.HV = i4;
        }

        public int H(float f) {
            return (int) (this.HT + (f / 2.5f));
        }
    }
}
