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
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator aTs;
    private Animation.AnimationListener bOF;
    private float gOp;
    private int hdA;
    private a hdB;
    private b hdC;
    private AbsListView.OnScrollListener hdD;
    private int hdE;
    private boolean hdF;
    private c hdG;
    private boolean hdw;
    private int hdx;
    private View hdy;
    private d hdz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void vK(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void btB();

        void vL(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Ji();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gOp = 0.0f;
        this.hdw = true;
        this.hdx = -1;
        this.hdE = -1;
        this.hdF = false;
        this.bOF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hdG = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ji() {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hdC != null) {
                    TransparentHeadGridView.this.hdC.btB();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hdB != null && TransparentHeadGridView.this.hdE != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hdB.vK(100);
                        TransparentHeadGridView.this.hdE = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hdx < 0) {
                        TransparentHeadGridView.this.hdx = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hdx);
                    TransparentHeadGridView.this.hdw = i4 == 0;
                    if (TransparentHeadGridView.this.hdy != null) {
                        TransparentHeadGridView.this.hdy.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hdB != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hdE) {
                        TransparentHeadGridView.this.hdB.vK(height);
                        TransparentHeadGridView.this.hdE = height;
                    }
                }
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gOp = 0.0f;
        this.hdw = true;
        this.hdx = -1;
        this.hdE = -1;
        this.hdF = false;
        this.bOF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hdG = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ji() {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hdC != null) {
                    TransparentHeadGridView.this.hdC.btB();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hdB != null && TransparentHeadGridView.this.hdE != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hdB.vK(100);
                        TransparentHeadGridView.this.hdE = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hdx < 0) {
                        TransparentHeadGridView.this.hdx = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hdx);
                    TransparentHeadGridView.this.hdw = i4 == 0;
                    if (TransparentHeadGridView.this.hdy != null) {
                        TransparentHeadGridView.this.hdy.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hdB != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hdE) {
                        TransparentHeadGridView.this.hdB.vK(height);
                        TransparentHeadGridView.this.hdE = height;
                    }
                }
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gOp = 0.0f;
        this.hdw = true;
        this.hdx = -1;
        this.hdE = -1;
        this.hdF = false;
        this.bOF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hdG = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ji() {
                if (TransparentHeadGridView.this.hdF) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hdC != null) {
                    TransparentHeadGridView.this.hdC.btB();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hdB != null && TransparentHeadGridView.this.hdE != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hdB.vK(100);
                        TransparentHeadGridView.this.hdE = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hdx < 0) {
                        TransparentHeadGridView.this.hdx = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hdx);
                    TransparentHeadGridView.this.hdw = i4 == 0;
                    if (TransparentHeadGridView.this.hdy != null) {
                        TransparentHeadGridView.this.hdy.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hdB != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hdE) {
                        TransparentHeadGridView.this.hdB.vK(height);
                        TransparentHeadGridView.this.hdE = height;
                    }
                }
                if (TransparentHeadGridView.this.hdD != null) {
                    TransparentHeadGridView.this.hdD.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hdA = (int) (com.baidu.adp.lib.util.l.ae(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gOp = 0.0f;
                if (this.hdF && getPaddingTop() > this.hdA) {
                    a(getHeight(), 200L, 0L, this.hdG);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.gOp == 0.0f) {
                    this.gOp = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gOp && getPaddingTop() == 0 && this.hdw) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gOp) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hdC != null && i >= 0 && this.hdA > 0 && i <= this.hdA) {
                        this.hdC.vL((i * 100) / this.hdA);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bFR() {
        setPadding(0, (int) ((10.0f - this.gOp) / 2.0f), 0, 0);
        this.mState = 0;
        this.gOp = 0.0f;
        if (this.hdF && getPaddingTop() > this.hdA) {
            a(getHeight(), 200L, 0L, this.hdG);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hdD = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hdy = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hdz != null) {
            this.hdz.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aTs == null) {
                this.aTs = new DecelerateInterpolator();
            }
            this.hdz = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hdz, j2);
            } else {
                post(this.hdz);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aTH;
        private final int aTI;
        private c hdI;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aTK = true;
        private long mStartTime = -1;
        private int aTL = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aTI = i;
            this.aTH = i2;
            this.mInterpolator = TransparentHeadGridView.this.aTs;
            this.mDuration = j;
            this.hdI = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aTL = this.aTI - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aTI - this.aTH));
                TransparentHeadGridView.this.setPadding(0, this.aTL, 0, 0);
                if (TransparentHeadGridView.this.hdC != null && this.aTL >= 0 && TransparentHeadGridView.this.hdA > 0 && this.aTL <= TransparentHeadGridView.this.hdA) {
                    TransparentHeadGridView.this.hdC.vL((this.aTL * 100) / TransparentHeadGridView.this.hdA);
                }
            }
            if (this.aTK && this.aTH != this.aTL) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hdI != null) {
                this.hdI.Ji();
            }
        }

        public void stop() {
            this.aTK = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hdB = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hdC = bVar;
    }
}
