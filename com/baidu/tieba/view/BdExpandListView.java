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
    private long gdq;
    private b gwD;
    public a gwE;
    private long gwF;
    private boolean gwG;
    private boolean gwH;
    private Runnable gwI;
    private int gwJ;
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
        this.gwH = z;
    }

    public boolean brF() {
        return this.gwH;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hf = false;
        this.gwF = 0L;
        this.gdq = 0L;
        this.mHandler = new Handler();
        this.gwG = false;
        this.gwH = false;
        this.gwI = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Hb > 0) {
                    BdExpandListView.this.Ha.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Ha.getWidth(), BdExpandListView.this.Hb));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gwJ = 0;
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
        if (this.gwH) {
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
                    this.gwF = System.currentTimeMillis() - this.gdq;
                    this.gdq = System.currentTimeMillis();
                    this.Hf = false;
                    setClickEventEnabled(true);
                    if (this.Hb == 0) {
                        this.Hb = this.Ha.getHeight();
                    }
                    int height = this.Ha.getHeight();
                    this.Hc = this.Hd;
                    this.gwD = new b(0, height, 0, this.Hj + height);
                    break;
                case 1:
                case 3:
                    if (this.Hf) {
                        setClickEventEnabled(false);
                        kX();
                        this.Hf = false;
                    } else if (this.gwE != null) {
                        this.gwE.kZ();
                    }
                    this.mHandler.removeCallbacks(this.gwI);
                    this.mHandler.postDelayed(this.gwI, 200L);
                    break;
                case 2:
                    float f = this.Hd - this.Hc;
                    if (this.Ha.getParent() == this && this.gwD != null && this.Ha.isShown() && this.Ha.getTop() >= 0 && Math.abs(f) >= this.Hi && this.gwF > 400) {
                        int w = this.gwD.w(this.Hd - this.Hc);
                        if (w > this.gwD.Hn && w <= this.gwD.Hp) {
                            this.Hf = true;
                            setClickEventEnabled(false);
                            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), w));
                            u(w - this.gwD.Hn);
                            break;
                        } else if (w <= this.gwD.Hn) {
                            this.Hf = false;
                            break;
                        } else if (w > this.gwD.Hp) {
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
        if (this.gwD != null) {
            if (this.Ha.getHeight() >= this.gwD.Hp - (this.Hj / 2)) {
                kY();
            } else if (this.gwE != null) {
                this.gwE.kZ();
            }
            this.mScroller.startScroll(0, this.Ha.getHeight(), 0, this.gwD.Hn - this.Ha.getHeight(), 200);
            invalidate();
        }
    }

    public void kY() {
        if (this.gwE != null) {
            this.gwE.la();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gwE = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.gwH) {
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
            this.mHandler.removeCallbacks(this.gwI);
            this.mHandler.postDelayed(this.gwI, 200L);
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
        if (this.gwH) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gwJ - currY) > this.Hi * 2) {
                this.gwJ = currY;
                this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Hj);
        if (this.gwE != null) {
            this.gwE.v(f2);
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
