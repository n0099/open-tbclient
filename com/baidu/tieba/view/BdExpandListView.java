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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View On;
    private int Oo;
    private float Op;
    private boolean Or;
    private final int Ot;
    private final int Ou;
    private long brG;
    private b hFn;
    public a hFo;
    private long hFp;
    private boolean hFq;
    private Runnable hFr;
    private int hFs;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;
    private float startY;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void oD();

        void onRefresh();
    }

    public void setStarForum(boolean z) {
        this.hFq = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Or = false;
        this.hFp = 0L;
        this.brG = 0L;
        this.mHandler = new Handler();
        this.hFq = false;
        this.hFr = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Oo > 0) {
                    BdExpandListView.this.On.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.On.getWidth(), BdExpandListView.this.Oo));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hFs = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Ou = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.On = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hFq) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.On == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Op = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hFp = System.currentTimeMillis() - this.brG;
                    this.brG = System.currentTimeMillis();
                    this.Or = false;
                    setClickEventEnabled(true);
                    if (this.Oo == 0) {
                        this.Oo = this.On.getHeight();
                    }
                    int height = this.On.getHeight();
                    this.startY = this.Op;
                    this.hFn = new b(0, height, 0, this.Ou + height);
                    break;
                case 1:
                case 3:
                    if (this.Or) {
                        setClickEventEnabled(false);
                        oB();
                        this.Or = false;
                    } else if (this.hFo != null) {
                        this.hFo.oD();
                    }
                    this.mHandler.removeCallbacks(this.hFr);
                    this.mHandler.postDelayed(this.hFr, 200L);
                    break;
                case 2:
                    float f = this.Op - this.startY;
                    if (this.On.getParent() == this && this.hFn != null && this.On.isShown() && this.On.getTop() >= 0 && Math.abs(f) >= this.Ot && this.hFp > 400) {
                        int O = this.hFn.O(this.Op - this.startY);
                        if (O > this.hFn.startY && O <= this.hFn.endY) {
                            this.Or = true;
                            setClickEventEnabled(false);
                            this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), O));
                            M(O - this.hFn.startY);
                            break;
                        } else if (O <= this.hFn.startY) {
                            this.Or = false;
                            break;
                        } else if (O > this.hFn.endY) {
                            this.Or = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Or = false;
                            break;
                        }
                    } else {
                        this.Or = false;
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
        if (this.Or) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Or) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oB() {
        if (this.hFn != null) {
            if (this.On.getHeight() >= this.hFn.endY - (this.Ou / 2)) {
                oC();
            } else if (this.hFo != null) {
                this.hFo.oD();
            }
            this.mScroller.startScroll(0, this.On.getHeight(), 0, this.hFn.startY - this.On.getHeight(), 200);
            invalidate();
        }
    }

    public void oC() {
        if (this.hFo != null) {
            this.hFo.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hFo = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hFq) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.On != null && !this.Or) {
            this.Or = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Ou, 0, -this.Ou, 200);
            oC();
            invalidate();
            this.mHandler.removeCallbacks(this.hFr);
            this.mHandler.postDelayed(this.hFr, 200L);
            this.Or = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Oo <= 0) {
            this.Oo = this.On.getHeight();
        }
        return this.Oo;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hFq) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hFs - currY) > this.Ot * 2) {
                this.hFs = currY;
                this.On.setLayoutParams(new AbsListView.LayoutParams(this.On.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Ou);
        if (this.hFo != null) {
            this.hFo.N(f2);
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

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
