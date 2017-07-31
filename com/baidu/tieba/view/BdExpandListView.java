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
    private View Jg;
    private int Jh;
    private float Ji;
    private float Jj;
    private boolean Jl;
    private final int Jo;
    private final int Jp;
    private long gbU;
    private b gvp;
    public a gvq;
    private long gvr;
    private boolean gvs;
    private boolean gvt;
    private Runnable gvu;
    private int gvv;
    private final Context mContext;
    private Handler mHandler;
    private final Scroller mScroller;

    /* loaded from: classes.dex */
    public interface a {
        void G(float f);

        void li();

        void lj();
    }

    public void setStarForum(boolean z) {
        this.gvt = z;
    }

    public boolean brE() {
        return this.gvt;
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jl = false;
        this.gvr = 0L;
        this.gbU = 0L;
        this.mHandler = new Handler();
        this.gvs = false;
        this.gvt = false;
        this.gvu = new Runnable() { // from class: com.baidu.tieba.view.BdExpandListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdExpandListView.this.Jh > 0) {
                    BdExpandListView.this.Jg.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.Jg.getWidth(), BdExpandListView.this.Jh));
                    BdExpandListView.this.invalidate();
                }
            }
        };
        this.gvv = 0;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Jo = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Jp = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void e(View view, int i) {
        this.Jg = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            if (this.Jg == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Jj = motionEvent.getY();
            switch (action) {
                case 0:
                    this.gvr = System.currentTimeMillis() - this.gbU;
                    this.gbU = System.currentTimeMillis();
                    this.Jl = false;
                    setClickEventEnabled(true);
                    if (this.Jh == 0) {
                        this.Jh = this.Jg.getHeight();
                    }
                    int height = this.Jg.getHeight();
                    this.Ji = this.Jj;
                    this.gvp = new b(0, height, 0, this.Jp + height);
                    break;
                case 1:
                case 3:
                    if (this.Jl) {
                        setClickEventEnabled(false);
                        lg();
                        this.Jl = false;
                    } else if (this.gvq != null) {
                        this.gvq.li();
                    }
                    this.mHandler.removeCallbacks(this.gvu);
                    this.mHandler.postDelayed(this.gvu, 200L);
                    break;
                case 2:
                    float f = this.Jj - this.Ji;
                    if (this.Jg.getParent() == this && this.gvp != null && this.Jg.isShown() && this.Jg.getTop() >= 0 && Math.abs(f) >= this.Jo && this.gvr > 400) {
                        int H = this.gvp.H(this.Jj - this.Ji);
                        if (H > this.gvp.Jt && H <= this.gvp.Jv) {
                            this.Jl = true;
                            setClickEventEnabled(false);
                            this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), H));
                            F(H - this.gvp.Jt);
                            break;
                        } else if (H <= this.gvp.Jt) {
                            this.Jl = false;
                            break;
                        } else if (H > this.gvp.Jv) {
                            this.Jl = true;
                            setClickEventEnabled(false);
                            break;
                        } else {
                            this.Jl = false;
                            break;
                        }
                    } else {
                        this.Jl = false;
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
        if (this.Jl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Jl) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lg() {
        if (this.gvp != null) {
            if (this.Jg.getHeight() >= this.gvp.Jv - (this.Jp / 2)) {
                lh();
            } else if (this.gvq != null) {
                this.gvq.li();
            }
            this.mScroller.startScroll(0, this.Jg.getHeight(), 0, this.gvp.Jt - this.Jg.getHeight(), 200);
            invalidate();
        }
    }

    public void lh() {
        if (this.gvq != null) {
            this.gvq.lj();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gvq = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void startPullRefresh() {
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.Jg != null && !this.Jl) {
            this.Jl = true;
            lh();
            invalidate();
            this.mHandler.removeCallbacks(this.gvu);
            this.mHandler.postDelayed(this.gvu, 200L);
            this.Jl = false;
        }
    }

    private int getOriginalHeight() {
        if (this.Jh <= 0) {
            this.Jh = this.Jg.getHeight();
        }
        return this.Jh;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            if (Math.abs(this.gvv - currY) > this.Jo * 2) {
                this.gvv = currY;
                this.Jg.setLayoutParams(new AbsListView.LayoutParams(this.Jg.getWidth(), currY));
                return;
            }
            return;
        }
        scrollTo(0, 0);
        super.computeScroll();
    }

    private void F(float f) {
        float f2 = 360.0f - ((f * 360.0f) / this.Jp);
        if (this.gvq != null) {
            this.gvq.G(f2);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Js;
        public int Jt;
        public int Ju;
        public int Jv;

        public b(int i, int i2, int i3, int i4) {
            this.Js = i;
            this.Jt = i2;
            this.Ju = i3;
            this.Jv = i4;
        }

        public int H(float f) {
            return (int) (this.Jt + (f / 2.5f));
        }
    }
}
