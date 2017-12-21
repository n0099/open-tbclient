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
    private View GO;
    private int GP;
    private float GQ;
    private float GR;
    private boolean GU;
    private final int GX;
    private final int GY;
    private long gwa;
    private boolean haA;
    private Runnable haB;
    private int haC;
    private b hax;
    public a hay;
    private long haz;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public void setStarForum(boolean z) {
        this.haA = z;
    }

    public boolean bwc() {
        return this.haA;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = false;
        this.haz = 0L;
        this.gwa = 0L;
        this.mHandler = new Handler();
        this.haA = false;
        this.haB = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.GP > 0) {
                    BdExpandListView.this.GO.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.GO.getWidth(), BdExpandListView.this.GP));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.haC = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.GX = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GY = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.GO = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.haA) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.GO == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.GR = motionEvent.getY();
            switch (action) {
                case 0:
                    this.haz = System.currentTimeMillis() - this.gwa;
                    this.gwa = System.currentTimeMillis();
                    this.GU = false;
                    setClickEventEnabled(true);
                    if (this.GP == 0) {
                        this.GP = this.GO.getHeight();
                    }
                    int height = this.GO.getHeight();
                    this.GQ = this.GR;
                    this.hax = new b(0, height, 0, this.GY + height);
                    break;
                case 1:
                case 3:
                    if (this.GU) {
                        setClickEventEnabled(false);
                        kT();
                        this.GU = false;
                    } else if (this.hay != null) {
                        this.hay.kV();
                    }
                    this.mHandler.removeCallbacks(this.haB);
                    this.mHandler.postDelayed(this.haB, 200L);
                    break;
                case 2:
                    float f = this.GR - this.GQ;
                    if (this.GO.getParent() == this && this.hax != null && this.GO.isShown() && this.GO.getTop() >= 0 && Math.abs(f) >= this.GX && this.haz > 400) {
                        int w = this.hax.w(this.GR - this.GQ);
                        if (w > this.hax.startY && w <= this.hax.Hb) {
                            this.GU = true;
                            setClickEventEnabled(false);
                            this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), w));
                            u(w - this.hax.startY);
                            break;
                        } else if (w <= this.hax.startY) {
                            this.GU = false;
                            break;
                        } else if (w > this.hax.Hb) {
                            this.GU = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.GU = false;
                            break;
                        }
                    } else {
                        this.GU = false;
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
        if (this.GU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kT() {
        if (this.hax != null) {
            if (this.GO.getHeight() >= this.hax.Hb - (this.GY / 2)) {
                kU();
            } else if (this.hay != null) {
                this.hay.kV();
            }
            this.mScroller.startScroll(0, this.GO.getHeight(), 0, this.hax.startY - this.GO.getHeight(), 200);
            invalidate();
        }
    }

    public void kU() {
        if (this.hay != null) {
            this.hay.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hay = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.haA) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.GO != null && !this.GU) {
            this.GU = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.GY, 0, -this.GY, 200);
            kU();
            invalidate();
            this.mHandler.removeCallbacks(this.haB);
            this.mHandler.postDelayed(this.haB, 200L);
            this.GU = false;
        }
    }

    private int getOriginalHeight() {
        if (this.GP <= 0) {
            this.GP = this.GO.getHeight();
        }
        return this.GP;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.haA) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.haC - currY) > this.GX * 2) {
                this.haC = currY;
                this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void u(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.GY);
        if (this.hay != null) {
            this.hay.v(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hb;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Hb = i4;
        }

        public int w(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
