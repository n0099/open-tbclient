package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.adp.lib.util.l;
/* loaded from: classes3.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator bpL;
    private Animation.AnimationListener cDF;
    private boolean hTa;
    private int hTb;
    private View hTc;
    private d hTd;
    private int hTe;
    private a hTf;
    private b hTg;
    private AbsListView.OnScrollListener hTh;
    private int hTi;
    private boolean hTj;
    private c hTk;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private float mStartY;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void xg(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bNY();

        void xh(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void RW();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hTa = true;
        this.hTb = -1;
        this.hTi = -1;
        this.hTj = false;
        this.cDF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hTk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RW() {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hTg != null) {
                    TransparentHeadGridView.this.hTg.bNY();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hTf != null && TransparentHeadGridView.this.hTi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hTf.xg(100);
                        TransparentHeadGridView.this.hTi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hTb < 0) {
                        TransparentHeadGridView.this.hTb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hTb);
                    TransparentHeadGridView.this.hTa = i4 == 0;
                    if (TransparentHeadGridView.this.hTc != null) {
                        TransparentHeadGridView.this.hTc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hTf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hTi) {
                        TransparentHeadGridView.this.hTf.xg(height);
                        TransparentHeadGridView.this.hTi = height;
                    }
                }
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hTa = true;
        this.hTb = -1;
        this.hTi = -1;
        this.hTj = false;
        this.cDF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hTk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RW() {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hTg != null) {
                    TransparentHeadGridView.this.hTg.bNY();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hTf != null && TransparentHeadGridView.this.hTi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hTf.xg(100);
                        TransparentHeadGridView.this.hTi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hTb < 0) {
                        TransparentHeadGridView.this.hTb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hTb);
                    TransparentHeadGridView.this.hTa = i4 == 0;
                    if (TransparentHeadGridView.this.hTc != null) {
                        TransparentHeadGridView.this.hTc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hTf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hTi) {
                        TransparentHeadGridView.this.hTf.xg(height);
                        TransparentHeadGridView.this.hTi = height;
                    }
                }
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hTa = true;
        this.hTb = -1;
        this.hTi = -1;
        this.hTj = false;
        this.cDF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hTk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RW() {
                if (TransparentHeadGridView.this.hTj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hTg != null) {
                    TransparentHeadGridView.this.hTg.bNY();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hTf != null && TransparentHeadGridView.this.hTi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hTf.xg(100);
                        TransparentHeadGridView.this.hTi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hTb < 0) {
                        TransparentHeadGridView.this.hTb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hTb);
                    TransparentHeadGridView.this.hTa = i4 == 0;
                    if (TransparentHeadGridView.this.hTc != null) {
                        TransparentHeadGridView.this.hTc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hTf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hTi) {
                        TransparentHeadGridView.this.hTf.xg(height);
                        TransparentHeadGridView.this.hTi = height;
                    }
                }
                if (TransparentHeadGridView.this.hTh != null) {
                    TransparentHeadGridView.this.hTh.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hTe = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.mStartY = 0.0f;
                if (this.hTj && getPaddingTop() > this.hTe) {
                    a(getHeight(), 200L, 0L, this.hTk);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.mStartY == 0.0f) {
                    this.mStartY = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.mStartY && getPaddingTop() == 0 && this.hTa) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.mStartY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hTg != null && i >= 0 && this.hTe > 0 && i <= this.hTe) {
                        this.hTg.xh((i * 100) / this.hTe);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bNX() {
        setPadding(0, (int) ((10.0f - this.mStartY) / 2.0f), 0, 0);
        this.mState = 0;
        this.mStartY = 0.0f;
        if (this.hTj && getPaddingTop() > this.hTe) {
            a(getHeight(), 200L, 0L, this.hTk);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hTh = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hTc = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hTd != null) {
            this.hTd.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bpL == null) {
                this.bpL = new DecelerateInterpolator();
            }
            this.hTd = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hTd, j2);
            } else {
                post(this.hTd);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private c hTm;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private final int mScrollFromY;
        private final int mScrollToY;
        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mInterpolator = TransparentHeadGridView.this.bpL;
            this.mDuration = j;
            this.hTm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.hTg != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.hTe > 0 && this.mCurrentY <= TransparentHeadGridView.this.hTe) {
                    TransparentHeadGridView.this.hTg.xh((this.mCurrentY * 100) / TransparentHeadGridView.this.hTe);
                }
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hTm != null) {
                this.hTm.RW();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hTf = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hTg = bVar;
    }
}
