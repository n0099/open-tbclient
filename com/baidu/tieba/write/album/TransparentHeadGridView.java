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
    private Interpolator bqD;
    private Animation.AnimationListener cFr;
    private AbsListView.OnScrollListener hXA;
    private int hXB;
    private boolean hXC;
    private c hXD;
    private boolean hXt;
    private int hXu;
    private View hXv;
    private d hXw;
    private int hXx;
    private a hXy;
    private b hXz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private float mStartY;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void xv(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bPw();

        void xw(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void Su();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hXt = true;
        this.hXu = -1;
        this.hXB = -1;
        this.hXC = false;
        this.cFr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hXD = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Su() {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hXz != null) {
                    TransparentHeadGridView.this.hXz.bPw();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hXy != null && TransparentHeadGridView.this.hXB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hXy.xv(100);
                        TransparentHeadGridView.this.hXB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hXu < 0) {
                        TransparentHeadGridView.this.hXu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hXu);
                    TransparentHeadGridView.this.hXt = i4 == 0;
                    if (TransparentHeadGridView.this.hXv != null) {
                        TransparentHeadGridView.this.hXv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hXy != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hXB) {
                        TransparentHeadGridView.this.hXy.xv(height);
                        TransparentHeadGridView.this.hXB = height;
                    }
                }
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hXt = true;
        this.hXu = -1;
        this.hXB = -1;
        this.hXC = false;
        this.cFr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hXD = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Su() {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hXz != null) {
                    TransparentHeadGridView.this.hXz.bPw();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hXy != null && TransparentHeadGridView.this.hXB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hXy.xv(100);
                        TransparentHeadGridView.this.hXB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hXu < 0) {
                        TransparentHeadGridView.this.hXu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hXu);
                    TransparentHeadGridView.this.hXt = i4 == 0;
                    if (TransparentHeadGridView.this.hXv != null) {
                        TransparentHeadGridView.this.hXv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hXy != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hXB) {
                        TransparentHeadGridView.this.hXy.xv(height);
                        TransparentHeadGridView.this.hXB = height;
                    }
                }
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hXt = true;
        this.hXu = -1;
        this.hXB = -1;
        this.hXC = false;
        this.cFr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hXD = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Su() {
                if (TransparentHeadGridView.this.hXC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hXz != null) {
                    TransparentHeadGridView.this.hXz.bPw();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hXy != null && TransparentHeadGridView.this.hXB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hXy.xv(100);
                        TransparentHeadGridView.this.hXB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hXu < 0) {
                        TransparentHeadGridView.this.hXu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hXu);
                    TransparentHeadGridView.this.hXt = i4 == 0;
                    if (TransparentHeadGridView.this.hXv != null) {
                        TransparentHeadGridView.this.hXv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hXy != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hXB) {
                        TransparentHeadGridView.this.hXy.xv(height);
                        TransparentHeadGridView.this.hXB = height;
                    }
                }
                if (TransparentHeadGridView.this.hXA != null) {
                    TransparentHeadGridView.this.hXA.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hXx = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.mStartY = 0.0f;
                if (this.hXC && getPaddingTop() > this.hXx) {
                    a(getHeight(), 200L, 0L, this.hXD);
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
                if (y > this.mStartY && getPaddingTop() == 0 && this.hXt) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.mStartY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hXz != null && i >= 0 && this.hXx > 0 && i <= this.hXx) {
                        this.hXz.xw((i * 100) / this.hXx);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bPv() {
        setPadding(0, (int) ((10.0f - this.mStartY) / 2.0f), 0, 0);
        this.mState = 0;
        this.mStartY = 0.0f;
        if (this.hXC && getPaddingTop() > this.hXx) {
            a(getHeight(), 200L, 0L, this.hXD);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hXA = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hXv = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hXw != null) {
            this.hXw.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bqD == null) {
                this.bqD = new DecelerateInterpolator();
            }
            this.hXw = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hXw, j2);
            } else {
                post(this.hXw);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private c hXF;
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
            this.mInterpolator = TransparentHeadGridView.this.bqD;
            this.mDuration = j;
            this.hXF = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.hXz != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.hXx > 0 && this.mCurrentY <= TransparentHeadGridView.this.hXx) {
                    TransparentHeadGridView.this.hXz.xw((this.mCurrentY * 100) / TransparentHeadGridView.this.hXx);
                }
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hXF != null) {
                this.hXF.Su();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hXy = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hXz = bVar;
    }
}
