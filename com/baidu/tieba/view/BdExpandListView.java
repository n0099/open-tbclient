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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BdExpandListView extends BdTypeListView {
    public static int ExpandListView_expandDistance = 1;
    private View Bg;
    private int Bh;
    private float Bi;
    private float Bj;
    private boolean Bl;
    private final int Bo;
    private final int Bp;
    private b ftV;
    public a ftW;
    private long ftX;
    private long ftY;
    private boolean ftZ;
    private boolean fua;
    private Runnable fub;
    private int fuc;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void ki();

        void kj();
    }

    public void setStarForum(boolean z) {
        this.fua = z;
    }

    public boolean bfd() {
        return this.fua;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bl = false;
        this.ftX = 0L;
        this.ftY = 0L;
        this.mHandler = new Handler();
        this.ftZ = false;
        this.fua = false;
        this.fub = new com.baidu.tieba.view.b(this);
        this.fuc = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Bo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.ExpandListView);
        this.Bp = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Bg = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fua) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Bg == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Bj = motionEvent.getY();
            switch (action) {
                case 0:
                    this.ftX = System.currentTimeMillis() - this.ftY;
                    this.ftY = System.currentTimeMillis();
                    this.Bl = false;
                    setClickEventEnabled(true);
                    if (this.Bh == 0) {
                        this.Bh = this.Bg.getHeight();
                    }
                    int height = this.Bg.getHeight();
                    this.Bi = this.Bj;
                    this.ftV = new b(0, height, 0, this.Bp + height);
                    break;
                case 1:
                case 3:
                    if (this.Bl) {
                        setClickEventEnabled(false);
                        kg();
                        this.Bl = false;
                    } else if (this.ftW != null) {
                        this.ftW.ki();
                    }
                    this.mHandler.removeCallbacks(this.fub);
                    this.mHandler.postDelayed(this.fub, 200L);
                    break;
                case 2:
                    float f = this.Bj - this.Bi;
                    if (this.Bg.getParent() == this && this.ftV != null && this.Bg.isShown() && this.Bg.getTop() >= 0 && Math.abs(f) >= this.Bo && this.ftX > 400) {
                        int H = this.ftV.H(this.Bj - this.Bi);
                        if (H > this.ftV.Bt && H <= this.ftV.Bv) {
                            this.Bl = true;
                            setClickEventEnabled(false);
                            this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), H));
                            F(H - this.ftV.Bt);
                            break;
                        } else if (H <= this.ftV.Bt) {
                            this.Bl = false;
                            break;
                        } else if (H > this.ftV.Bv) {
                            this.Bl = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Bl = false;
                            break;
                        }
                    } else {
                        this.Bl = false;
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
        if (this.Bl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Bl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kg() {
        if (this.ftV != null) {
            if (this.Bg.getHeight() >= this.ftV.Bv - (this.Bp / 2)) {
                kh();
            } else if (this.ftW != null) {
                this.ftW.ki();
            }
            this.mScroller.startScroll(0, this.Bg.getHeight(), 0, this.ftV.Bt - this.Bg.getHeight(), 200);
            invalidate();
        }
    }

    public void kh() {
        if (this.ftW != null) {
            this.ftW.kj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.ftW = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void kv() {
        if (this.fua) {
            super.kv();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Bg != null && !this.Bl) {
            this.Bl = true;
            this.mScroller.startScroll(0, getOriginalHeight() + this.Bp, 0, -this.Bp, 200);
            kh();
            invalidate();
            this.mHandler.removeCallbacks(this.fub);
            this.mHandler.postDelayed(this.fub, 200L);
            this.Bl = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Bh <= 0) {
            this.Bh = this.Bg.getHeight();
        }
        return this.Bh;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.fua) {
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.fuc - currY) > this.Bo * 2) {
                this.fuc = currY;
                this.Bg.setLayoutParams(new AbsListView.LayoutParams(this.Bg.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Bp);
        if (this.ftW != null) {
            this.ftW.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Bs;
        public int Bt;
        public int Bu;
        public int Bv;

        public b(int i, int i2, int i3, int i4) {
            this.Bs = i;
            this.Bt = i2;
            this.Bu = i3;
            this.Bv = i4;
        }

        public int H(float f) {
            return (int) (this.Bt + (f / 2.5f));
        }
    }
}
