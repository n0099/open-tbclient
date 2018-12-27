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
    private Interpolator bpO;
    private Animation.AnimationListener cEF;
    private boolean hWl;
    private int hWm;
    private View hWn;
    private d hWo;
    private int hWp;
    private a hWq;
    private b hWr;
    private AbsListView.OnScrollListener hWs;
    private int hWt;
    private boolean hWu;
    private c hWv;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private float mStartY;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void xt(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bOO();

        void xu(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void RY();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hWl = true;
        this.hWm = -1;
        this.hWt = -1;
        this.hWu = false;
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hWv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RY() {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hWr != null) {
                    TransparentHeadGridView.this.hWr.bOO();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hWq != null && TransparentHeadGridView.this.hWt != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hWq.xt(100);
                        TransparentHeadGridView.this.hWt = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hWm < 0) {
                        TransparentHeadGridView.this.hWm = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hWm);
                    TransparentHeadGridView.this.hWl = i4 == 0;
                    if (TransparentHeadGridView.this.hWn != null) {
                        TransparentHeadGridView.this.hWn.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hWq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hWt) {
                        TransparentHeadGridView.this.hWq.xt(height);
                        TransparentHeadGridView.this.hWt = height;
                    }
                }
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hWl = true;
        this.hWm = -1;
        this.hWt = -1;
        this.hWu = false;
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hWv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RY() {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hWr != null) {
                    TransparentHeadGridView.this.hWr.bOO();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hWq != null && TransparentHeadGridView.this.hWt != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hWq.xt(100);
                        TransparentHeadGridView.this.hWt = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hWm < 0) {
                        TransparentHeadGridView.this.hWm = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hWm);
                    TransparentHeadGridView.this.hWl = i4 == 0;
                    if (TransparentHeadGridView.this.hWn != null) {
                        TransparentHeadGridView.this.hWn.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hWq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hWt) {
                        TransparentHeadGridView.this.hWq.xt(height);
                        TransparentHeadGridView.this.hWt = height;
                    }
                }
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.mStartY = 0.0f;
        this.hWl = true;
        this.hWm = -1;
        this.hWt = -1;
        this.hWu = false;
        this.cEF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hWv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void RY() {
                if (TransparentHeadGridView.this.hWu) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hWr != null) {
                    TransparentHeadGridView.this.hWr.bOO();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hWq != null && TransparentHeadGridView.this.hWt != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hWq.xt(100);
                        TransparentHeadGridView.this.hWt = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hWm < 0) {
                        TransparentHeadGridView.this.hWm = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hWm);
                    TransparentHeadGridView.this.hWl = i4 == 0;
                    if (TransparentHeadGridView.this.hWn != null) {
                        TransparentHeadGridView.this.hWn.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hWq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hWt) {
                        TransparentHeadGridView.this.hWq.xt(height);
                        TransparentHeadGridView.this.hWt = height;
                    }
                }
                if (TransparentHeadGridView.this.hWs != null) {
                    TransparentHeadGridView.this.hWs.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hWp = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.mStartY = 0.0f;
                if (this.hWu && getPaddingTop() > this.hWp) {
                    a(getHeight(), 200L, 0L, this.hWv);
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
                if (y > this.mStartY && getPaddingTop() == 0 && this.hWl) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.mStartY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hWr != null && i >= 0 && this.hWp > 0 && i <= this.hWp) {
                        this.hWr.xu((i * 100) / this.hWp);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bON() {
        setPadding(0, (int) ((10.0f - this.mStartY) / 2.0f), 0, 0);
        this.mState = 0;
        this.mStartY = 0.0f;
        if (this.hWu && getPaddingTop() > this.hWp) {
            a(getHeight(), 200L, 0L, this.hWv);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hWs = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hWn = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hWo != null) {
            this.hWo.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bpO == null) {
                this.bpO = new DecelerateInterpolator();
            }
            this.hWo = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hWo, j2);
            } else {
                post(this.hWo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private c hWx;
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
            this.mInterpolator = TransparentHeadGridView.this.bpO;
            this.mDuration = j;
            this.hWx = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.hWr != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.hWp > 0 && this.mCurrentY <= TransparentHeadGridView.this.hWp) {
                    TransparentHeadGridView.this.hWr.xu((this.mCurrentY * 100) / TransparentHeadGridView.this.hWp);
                }
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hWx != null) {
                this.hWx.RY();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hWq = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hWr = bVar;
    }
}
