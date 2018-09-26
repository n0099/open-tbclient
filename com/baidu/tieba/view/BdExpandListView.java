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
    private View NU;
    private int NV;
    private float NW;
    private float NX;
    private boolean NZ;
    private final int Oc;
    private final int Od;
    private long bmS;
    private b hwq;
    public a hwr;
    private long hws;
    private boolean hwt;
    private Runnable hwu;
    private int hwv;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void N(float f);

        void onRefresh();

        void ou();
    }

    public void setStarForum(boolean z) {
        this.hwt = z;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NZ = false;
        this.hws = 0L;
        this.bmS = 0L;
        this.mHandler = new Handler();
        this.hwt = false;
        this.hwu = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.NV > 0) {
                    BdExpandListView.this.NU.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.NU.getWidth(), BdExpandListView.this.NV));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.hwv = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Oc = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Od = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.NU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hwt) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.NU == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.NX = motionEvent.getY();
            switch (action) {
                case 0:
                    this.hws = System.currentTimeMillis() - this.bmS;
                    this.bmS = System.currentTimeMillis();
                    this.NZ = false;
                    setClickEventEnabled(true);
                    if (this.NV == 0) {
                        this.NV = this.NU.getHeight();
                    }
                    int height = this.NU.getHeight();
                    this.NW = this.NX;
                    this.hwq = new b(0, height, 0, this.Od + height);
                    break;
                case 1:
                case 3:
                    if (this.NZ) {
                        setClickEventEnabled(false);
                        os();
                        this.NZ = false;
                    } else if (this.hwr != null) {
                        this.hwr.ou();
                    }
                    this.mHandler.removeCallbacks(this.hwu);
                    this.mHandler.postDelayed(this.hwu, 200L);
                    break;
                case 2:
                    float f = this.NX - this.NW;
                    if (this.NU.getParent() == this && this.hwq != null && this.NU.isShown() && this.NU.getTop() >= 0 && Math.abs(f) >= this.Oc && this.hws > 400) {
                        int O = this.hwq.O(this.NX - this.NW);
                        if (O > this.hwq.startY && O <= this.hwq.endY) {
                            this.NZ = true;
                            setClickEventEnabled(false);
                            this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), O));
                            M(O - this.hwq.startY);
                            break;
                        } else if (O <= this.hwq.startY) {
                            this.NZ = false;
                            break;
                        } else if (O > this.hwq.endY) {
                            this.NZ = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.NZ = false;
                            break;
                        }
                    } else {
                        this.NZ = false;
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
        if (this.NZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.NZ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void os() {
        if (this.hwq != null) {
            if (this.NU.getHeight() >= this.hwq.endY - (this.Od / 2)) {
                ot();
            } else if (this.hwr != null) {
                this.hwr.ou();
            }
            this.mScroller.startScroll(0, this.NU.getHeight(), 0, this.hwq.startY - this.NU.getHeight(), 200);
            invalidate();
        }
    }

    public void ot() {
        if (this.hwr != null) {
            this.hwr.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.hwr = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (this.hwt) {
            super.startPullRefresh();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.NU != null && !this.NZ) {
            this.NZ = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Od, 0, -this.Od, 200);
            ot();
            invalidate();
            this.mHandler.removeCallbacks(this.hwu);
            this.mHandler.postDelayed(this.hwu, 200L);
            this.NZ = false;
        }
    }

    private int getOriginalHeight() {
        if (this.NV <= 0) {
            this.NV = this.NU.getHeight();
        }
        return this.NV;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.hwt) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.hwv - currY) > this.Oc * 2) {
                this.hwv = currY;
                this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void M(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Od);
        if (this.hwr != null) {
            this.hwr.N(f2);
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
