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
    private Interpolator blC;
    private Animation.AnimationListener cyE;
    private boolean hKf;
    private int hKg;
    private View hKh;
    private d hKi;
    private int hKj;
    private a hKk;
    private b hKl;
    private AbsListView.OnScrollListener hKm;
    private int hKn;
    private boolean hKo;
    private c hKp;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private float mStartY;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void wq(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bMt();

        void wr(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void QH();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hKf = true;
        this.hKg = -1;
        this.hKn = -1;
        this.hKo = false;
        this.cyE = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hKp = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hKl != null) {
                    TransparentHeadGridView.this.hKl.bMt();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hKk != null && TransparentHeadGridView.this.hKn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hKk.wq(100);
                        TransparentHeadGridView.this.hKn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hKg < 0) {
                        TransparentHeadGridView.this.hKg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hKg);
                    TransparentHeadGridView.this.hKf = i4 == 0;
                    if (TransparentHeadGridView.this.hKh != null) {
                        TransparentHeadGridView.this.hKh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hKk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hKn) {
                        TransparentHeadGridView.this.hKk.wq(height);
                        TransparentHeadGridView.this.hKn = height;
                    }
                }
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hKf = true;
        this.hKg = -1;
        this.hKn = -1;
        this.hKo = false;
        this.cyE = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hKp = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hKl != null) {
                    TransparentHeadGridView.this.hKl.bMt();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hKk != null && TransparentHeadGridView.this.hKn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hKk.wq(100);
                        TransparentHeadGridView.this.hKn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hKg < 0) {
                        TransparentHeadGridView.this.hKg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hKg);
                    TransparentHeadGridView.this.hKf = i4 == 0;
                    if (TransparentHeadGridView.this.hKh != null) {
                        TransparentHeadGridView.this.hKh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hKk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hKn) {
                        TransparentHeadGridView.this.hKk.wq(height);
                        TransparentHeadGridView.this.hKn = height;
                    }
                }
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hKf = true;
        this.hKg = -1;
        this.hKn = -1;
        this.hKo = false;
        this.cyE = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hKp = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.hKo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hKl != null) {
                    TransparentHeadGridView.this.hKl.bMt();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hKk != null && TransparentHeadGridView.this.hKn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hKk.wq(100);
                        TransparentHeadGridView.this.hKn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hKg < 0) {
                        TransparentHeadGridView.this.hKg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hKg);
                    TransparentHeadGridView.this.hKf = i4 == 0;
                    if (TransparentHeadGridView.this.hKh != null) {
                        TransparentHeadGridView.this.hKh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hKk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hKn) {
                        TransparentHeadGridView.this.hKk.wq(height);
                        TransparentHeadGridView.this.hKn = height;
                    }
                }
                if (TransparentHeadGridView.this.hKm != null) {
                    TransparentHeadGridView.this.hKm.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hKj = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.mStartY = 0.0f;
                if (this.hKo && getPaddingTop() > this.hKj) {
                    a(getHeight(), 200L, 0L, this.hKp);
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
                if (y > this.mStartY && getPaddingTop() == 0 && this.hKf) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.mStartY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hKl != null && i >= 0 && this.hKj > 0 && i <= this.hKj) {
                        this.hKl.wr((i * 100) / this.hKj);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bMs() {
        setPadding(0, (int) ((10.0f - this.mStartY) / 2.0f), 0, 0);
        this.mState = 0;
        this.mStartY = 0.0f;
        if (this.hKo && getPaddingTop() > this.hKj) {
            a(getHeight(), 200L, 0L, this.hKp);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hKm = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hKh = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hKi != null) {
            this.hKi.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.blC == null) {
                this.blC = new DecelerateInterpolator();
            }
            this.hKi = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hKi, j2);
            } else {
                post(this.hKi);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private c hKr;
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
            this.mInterpolator = TransparentHeadGridView.this.blC;
            this.mDuration = j;
            this.hKr = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.hKl != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.hKj > 0 && this.mCurrentY <= TransparentHeadGridView.this.hKj) {
                    TransparentHeadGridView.this.hKl.wr((this.mCurrentY * 100) / TransparentHeadGridView.this.hKj);
                }
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hKr != null) {
                this.hKr.QH();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hKk = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hKl = bVar;
    }
}
