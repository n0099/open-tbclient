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
/* loaded from: classes8.dex */
public class TransparentHeadGridView extends GridView {
    private AbsListView.OnScrollListener bMA;
    private int bMB;
    private boolean bMC;
    private Animation.AnimationListener bMD;
    private float bMr;
    private boolean bMs;
    private int bMt;
    private View bMu;
    private Interpolator bMv;
    private int bMx;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d ofw;
    private a ofx;
    private b ofy;
    private c ofz;

    /* loaded from: classes8.dex */
    public interface a {
        void eU(int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void UT();

        void eV(int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void US();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bMr = 0.0f;
        this.bMs = true;
        this.bMt = -1;
        this.bMB = -1;
        this.bMC = false;
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ofz = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void US() {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ofy != null) {
                    TransparentHeadGridView.this.ofy.UT();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ofx != null && TransparentHeadGridView.this.bMB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ofx.eU(100);
                        TransparentHeadGridView.this.bMB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bMt < 0) {
                        TransparentHeadGridView.this.bMt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bMt);
                    TransparentHeadGridView.this.bMs = i4 == 0;
                    if (TransparentHeadGridView.this.bMu != null) {
                        TransparentHeadGridView.this.bMu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ofx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bMB) {
                        TransparentHeadGridView.this.ofx.eU(height);
                        TransparentHeadGridView.this.bMB = height;
                    }
                }
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bMr = 0.0f;
        this.bMs = true;
        this.bMt = -1;
        this.bMB = -1;
        this.bMC = false;
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ofz = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void US() {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ofy != null) {
                    TransparentHeadGridView.this.ofy.UT();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ofx != null && TransparentHeadGridView.this.bMB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ofx.eU(100);
                        TransparentHeadGridView.this.bMB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bMt < 0) {
                        TransparentHeadGridView.this.bMt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bMt);
                    TransparentHeadGridView.this.bMs = i4 == 0;
                    if (TransparentHeadGridView.this.bMu != null) {
                        TransparentHeadGridView.this.bMu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ofx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bMB) {
                        TransparentHeadGridView.this.ofx.eU(height);
                        TransparentHeadGridView.this.bMB = height;
                    }
                }
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bMr = 0.0f;
        this.bMs = true;
        this.bMt = -1;
        this.bMB = -1;
        this.bMC = false;
        this.bMD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ofz = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void US() {
                if (TransparentHeadGridView.this.bMC) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ofy != null) {
                    TransparentHeadGridView.this.ofy.UT();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ofx != null && TransparentHeadGridView.this.bMB != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ofx.eU(100);
                        TransparentHeadGridView.this.bMB = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bMt < 0) {
                        TransparentHeadGridView.this.bMt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bMt);
                    TransparentHeadGridView.this.bMs = i4 == 0;
                    if (TransparentHeadGridView.this.bMu != null) {
                        TransparentHeadGridView.this.bMu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ofx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bMB) {
                        TransparentHeadGridView.this.ofx.eU(height);
                        TransparentHeadGridView.this.bMB = height;
                    }
                }
                if (TransparentHeadGridView.this.bMA != null) {
                    TransparentHeadGridView.this.bMA.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bMx = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bMr = 0.0f;
                if (this.bMC && getPaddingTop() > this.bMx) {
                    a(getHeight(), 200L, 0L, this.ofz);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bMr == 0.0f) {
                    this.bMr = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bMr && getPaddingTop() == 0 && this.bMs) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bMr) / 2.0f);
                    if (this.ofy != null && i >= 0 && this.bMx > 0 && i <= this.bMx) {
                        this.ofy.eV((i * 100) / this.bMx);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void UR() {
        setPadding(0, (int) ((10.0f - this.bMr) / 2.0f), 0, 0);
        this.mState = 0;
        this.bMr = 0.0f;
        if (this.bMC && getPaddingTop() > this.bMx) {
            a(getHeight(), 200L, 0L, this.ofz);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bMA = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bMu = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.ofw != null) {
            this.ofw.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bMv == null) {
                this.bMv = new DecelerateInterpolator();
            }
            this.ofw = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.ofw, j2);
            } else {
                post(this.ofw);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        private final int bMG;
        private final int bMH;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c ofB;
        private boolean bMJ = true;
        private long mStartTime = -1;
        private int bMK = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bMH = i;
            this.bMG = i2;
            this.mInterpolator = TransparentHeadGridView.this.bMv;
            this.mDuration = j;
            this.ofB = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bMK = this.bMH - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bMH - this.bMG));
                TransparentHeadGridView.this.setPadding(0, this.bMK, 0, 0);
                if (TransparentHeadGridView.this.ofy != null && this.bMK >= 0 && TransparentHeadGridView.this.bMx > 0 && this.bMK <= TransparentHeadGridView.this.bMx) {
                    TransparentHeadGridView.this.ofy.eV((this.bMK * 100) / TransparentHeadGridView.this.bMx);
                }
            }
            if (this.bMJ && this.bMG != this.bMK) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.ofB != null) {
                this.ofB.US();
            }
        }

        public void stop() {
            this.bMJ = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.ofx = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.ofy = bVar;
    }
}
