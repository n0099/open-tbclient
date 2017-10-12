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
    private final int HA;
    private View Hr;
    private int Hs;
    private float Ht;
    private float Hu;
    private boolean Hw;
    private final int Hz;
    private b gCj;
    public a gCk;
    private long gCl;
    private boolean gCm;
    private boolean gCn;
    private Runnable gCo;
    private int gCp;
    private long gaW;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void lb();

        void lc();

        void w(float f);
    }

    public void setStarForum(boolean z) {
        this.gCn = z;
    }

    public boolean bqC() {
        return this.gCn;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hw = false;
        this.gCl = 0L;
        this.gaW = 0L;
        this.mHandler = new Handler();
        this.gCm = false;
        this.gCn = false;
        this.gCo = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Hs > 0) {
                    BdExpandListView.this.Hr.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Hr.getWidth(), BdExpandListView.this.Hs));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gCp = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hz = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.HA = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Hr = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gCn) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Hr == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Hu = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gCl = System.currentTimeMillis() - this.gaW;
                    this.gaW = System.currentTimeMillis();
                    this.Hw = false;
                    setClickEventEnabled(true);
                    if (this.Hs == 0) {
                        this.Hs = this.Hr.getHeight();
                    }
                    int height = this.Hr.getHeight();
                    this.Ht = this.Hu;
                    this.gCj = new b(0, height, 0, this.HA + height);
                    break;
                case 1:
                case 3:
                    if (this.Hw) {
                        setClickEventEnabled(false);
                        kZ();
                        this.Hw = false;
                    } else if (this.gCk != null) {
                        this.gCk.lb();
                    }
                    this.mHandler.removeCallbacks(this.gCo);
                    this.mHandler.postDelayed(this.gCo, 200L);
                    break;
                case 2:
                    float f = this.Hu - this.Ht;
                    if (this.Hr.getParent() == this && this.gCj != null && this.Hr.isShown() && this.Hr.getTop() >= 0 && Math.abs(f) >= this.Hz && this.gCl > 400) {
                        int x = this.gCj.x(this.Hu - this.Ht);
                        if (x > this.gCj.HE && x <= this.gCj.HG) {
                            this.Hw = true;
                            setClickEventEnabled(false);
                            this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), x));
                            v(x - this.gCj.HE);
                            break;
                        } else if (x <= this.gCj.HE) {
                            this.Hw = false;
                            break;
                        } else if (x > this.gCj.HG) {
                            this.Hw = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Hw = false;
                            break;
                        }
                    } else {
                        this.Hw = false;
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
        if (this.Hw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hw) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kZ() {
        if (this.gCj != null) {
            if (this.Hr.getHeight() >= this.gCj.HG - (this.HA / 2)) {
                la();
            } else if (this.gCk != null) {
                this.gCk.lb();
            }
            this.mScroller.startScroll(0, this.Hr.getHeight(), 0, this.gCj.HE - this.Hr.getHeight(), 200);
            invalidate();
        }
    }

    public void la() {
        if (this.gCk != null) {
            this.gCk.lc();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gCk = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gCn) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Hr != null && !this.Hw) {
            this.Hw = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.HA, 0, -this.HA, 200);
            la();
            invalidate();
            this.mHandler.removeCallbacks(this.gCo);
            this.mHandler.postDelayed(this.gCo, 200L);
            this.Hw = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Hs <= 0) {
            this.Hs = this.Hr.getHeight();
        }
        return this.Hs;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gCn) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gCp - currY) > this.Hz * 2) {
                this.gCp = currY;
                this.Hr.setLayoutParams(new AbsListView.LayoutParams(this.Hr.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void v(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.HA);
        if (this.gCk != null) {
            this.gCk.w(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int HD;
        public int HE;
        public int HF;
        public int HG;

        public b(int i, int i2, int i3, int i4) {
            this.HD = i;
            this.HE = i2;
            this.HF = i3;
            this.HG = i4;
        }

        public int x(float f) {
            return (int) (this.HE + (f / 2.5f));
        }
    }
}
