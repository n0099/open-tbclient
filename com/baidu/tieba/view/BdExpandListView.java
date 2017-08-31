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
    private View Ha;
    private int Hb;
    private float Hc;
    private float Hd;
    private boolean Hf;
    private final int Hi;
    private final int Hj;
    private long gcw;
    private b gvJ;
    public a gvK;
    private long gvL;
    private boolean gvM;
    private boolean gvN;
    private Runnable gvO;
    private int gvP;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kZ();

        void la();

        void v(float f);
    }

    public void setStarForum(boolean z) {
        this.gvN = z;
    }

    public boolean bru() {
        return this.gvN;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hf = false;
        this.gvL = 0L;
        this.gcw = 0L;
        this.mHandler = new Handler();
        this.gvM = false;
        this.gvN = false;
        this.gvO = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Hb > 0) {
                    BdExpandListView.this.Ha.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ha.getWidth(), BdExpandListView.this.Hb));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gvP = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hi = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Hj = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Ha = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gvN) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Ha == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Hd = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gvL = System.currentTimeMillis() - this.gcw;
                    this.gcw = System.currentTimeMillis();
                    this.Hf = false;
                    setClickEventEnabled(true);
                    if (this.Hb == 0) {
                        this.Hb = this.Ha.getHeight();
                    }
                    int height = this.Ha.getHeight();
                    this.Hc = this.Hd;
                    this.gvJ = new b(0, height, 0, this.Hj + height);
                    break;
                case 1:
                case 3:
                    if (this.Hf) {
                        setClickEventEnabled(false);
                        kX();
                        this.Hf = false;
                    } else if (this.gvK != null) {
                        this.gvK.kZ();
                    }
                    this.mHandler.removeCallbacks(this.gvO);
                    this.mHandler.postDelayed(this.gvO, 200L);
                    break;
                case 2:
                    float f = this.Hd - this.Hc;
                    if (this.Ha.getParent() == this && this.gvJ != null && this.Ha.isShown() && this.Ha.getTop() >= 0 && Math.abs(f) >= this.Hi && this.gvL > 400) {
                        int w = this.gvJ.w(this.Hd - this.Hc);
                        if (w > this.gvJ.Hn && w <= this.gvJ.Hp) {
                            this.Hf = true;
                            setClickEventEnabled(false);
                            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), w));
                            u(w - this.gvJ.Hn);
                            break;
                        } else if (w <= this.gvJ.Hn) {
                            this.Hf = false;
                            break;
                        } else if (w > this.gvJ.Hp) {
                            this.Hf = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Hf = false;
                            break;
                        }
                    } else {
                        this.Hf = false;
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
        if (this.Hf) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hf) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kX() {
        if (this.gvJ != null) {
            if (this.Ha.getHeight() >= this.gvJ.Hp - (this.Hj / 2)) {
                kY();
            } else if (this.gvK != null) {
                this.gvK.kZ();
            }
            this.mScroller.startScroll(0, this.Ha.getHeight(), 0, this.gvJ.Hn - this.Ha.getHeight(), 200);
            invalidate();
        }
    }

    public void kY() {
        if (this.gvK != null) {
            this.gvK.la();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gvK = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gvN) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Ha != null && !this.Hf) {
            this.Hf = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Hj, 0, -this.Hj, 200);
            kY();
            invalidate();
            this.mHandler.removeCallbacks(this.gvO);
            this.mHandler.postDelayed(this.gvO, 200L);
            this.Hf = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Hb <= 0) {
            this.Hb = this.Ha.getHeight();
        }
        return this.Hb;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.gvN) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gvP - currY) > this.Hi * 2) {
                this.gvP = currY;
                this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Hj);
        if (this.gvK != null) {
            this.gvK.v(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hm;
        public int Hn;
        public int Ho;
        public int Hp;

        public b(int i, int i2, int i3, int i4) {
            this.Hm = i;
            this.Hn = i2;
            this.Ho = i3;
            this.Hp = i4;
        }

        public int w(float f) {
            return (int) (this.Hn + (f / 2.5f));
        }
    }
}
