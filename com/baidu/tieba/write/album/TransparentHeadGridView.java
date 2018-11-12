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
    private Interpolator bmn;
    private Animation.AnimationListener czN;
    private boolean hLP;
    private int hLQ;
    private View hLR;
    private d hLS;
    private int hLT;
    private a hLU;
    private b hLV;
    private AbsListView.OnScrollListener hLW;
    private int hLX;
    private boolean hLY;
    private c hLZ;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private float mStartY;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void wJ(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bLS();

        void wK(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void QQ();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hLP = true;
        this.hLQ = -1;
        this.hLX = -1;
        this.hLY = false;
        this.czN = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hLZ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QQ() {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hLV != null) {
                    TransparentHeadGridView.this.hLV.bLS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hLU != null && TransparentHeadGridView.this.hLX != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hLU.wJ(100);
                        TransparentHeadGridView.this.hLX = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hLQ < 0) {
                        TransparentHeadGridView.this.hLQ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hLQ);
                    TransparentHeadGridView.this.hLP = i4 == 0;
                    if (TransparentHeadGridView.this.hLR != null) {
                        TransparentHeadGridView.this.hLR.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hLU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hLX) {
                        TransparentHeadGridView.this.hLU.wJ(height);
                        TransparentHeadGridView.this.hLX = height;
                    }
                }
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hLP = true;
        this.hLQ = -1;
        this.hLX = -1;
        this.hLY = false;
        this.czN = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hLZ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QQ() {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hLV != null) {
                    TransparentHeadGridView.this.hLV.bLS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hLU != null && TransparentHeadGridView.this.hLX != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hLU.wJ(100);
                        TransparentHeadGridView.this.hLX = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hLQ < 0) {
                        TransparentHeadGridView.this.hLQ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hLQ);
                    TransparentHeadGridView.this.hLP = i4 == 0;
                    if (TransparentHeadGridView.this.hLR != null) {
                        TransparentHeadGridView.this.hLR.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hLU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hLX) {
                        TransparentHeadGridView.this.hLU.wJ(height);
                        TransparentHeadGridView.this.hLX = height;
                    }
                }
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hLP = true;
        this.hLQ = -1;
        this.hLX = -1;
        this.hLY = false;
        this.czN = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hLZ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QQ() {
                if (TransparentHeadGridView.this.hLY) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hLV != null) {
                    TransparentHeadGridView.this.hLV.bLS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hLU != null && TransparentHeadGridView.this.hLX != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hLU.wJ(100);
                        TransparentHeadGridView.this.hLX = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hLQ < 0) {
                        TransparentHeadGridView.this.hLQ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hLQ);
                    TransparentHeadGridView.this.hLP = i4 == 0;
                    if (TransparentHeadGridView.this.hLR != null) {
                        TransparentHeadGridView.this.hLR.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hLU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hLX) {
                        TransparentHeadGridView.this.hLU.wJ(height);
                        TransparentHeadGridView.this.hLX = height;
                    }
                }
                if (TransparentHeadGridView.this.hLW != null) {
                    TransparentHeadGridView.this.hLW.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hLT = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.mStartY = 0.0f;
                if (this.hLY && getPaddingTop() > this.hLT) {
                    a(getHeight(), 200L, 0L, this.hLZ);
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
                if (y > this.mStartY && getPaddingTop() == 0 && this.hLP) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.mStartY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hLV != null && i >= 0 && this.hLT > 0 && i <= this.hLT) {
                        this.hLV.wK((i * 100) / this.hLT);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bLR() {
        setPadding(0, (int) ((10.0f - this.mStartY) / 2.0f), 0, 0);
        this.mState = 0;
        this.mStartY = 0.0f;
        if (this.hLY && getPaddingTop() > this.hLT) {
            a(getHeight(), 200L, 0L, this.hLZ);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hLW = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hLR = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hLS != null) {
            this.hLS.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bmn == null) {
                this.bmn = new DecelerateInterpolator();
            }
            this.hLS = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hLS, j2);
            } else {
                post(this.hLS);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private c hMb;
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
            this.mInterpolator = TransparentHeadGridView.this.bmn;
            this.mDuration = j;
            this.hMb = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.hLV != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.hLT > 0 && this.mCurrentY <= TransparentHeadGridView.this.hLT) {
                    TransparentHeadGridView.this.hLV.wK((this.mCurrentY * 100) / TransparentHeadGridView.this.hLT);
                }
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hMb != null) {
                this.hMb.QQ();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hLU = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hLV = bVar;
    }
}
