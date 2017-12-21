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
    private Interpolator aTy;
    private Animation.AnimationListener bON;
    private float gRc;
    private boolean hgA;
    private c hgB;
    private boolean hgr;
    private int hgs;
    private View hgt;
    private d hgu;
    private int hgv;
    private a hgw;
    private b hgx;
    private AbsListView.OnScrollListener hgy;
    private int hgz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void vW(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void buh();

        void vX(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Jj();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gRc = 0.0f;
        this.hgr = true;
        this.hgs = -1;
        this.hgz = -1;
        this.hgA = false;
        this.bON = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgB = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgx != null) {
                    TransparentHeadGridView.this.hgx.buh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgw != null && TransparentHeadGridView.this.hgz != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgw.vW(100);
                        TransparentHeadGridView.this.hgz = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgs < 0) {
                        TransparentHeadGridView.this.hgs = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgs);
                    TransparentHeadGridView.this.hgr = i4 == 0;
                    if (TransparentHeadGridView.this.hgt != null) {
                        TransparentHeadGridView.this.hgt.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgz) {
                        TransparentHeadGridView.this.hgw.vW(height);
                        TransparentHeadGridView.this.hgz = height;
                    }
                }
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gRc = 0.0f;
        this.hgr = true;
        this.hgs = -1;
        this.hgz = -1;
        this.hgA = false;
        this.bON = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgB = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgx != null) {
                    TransparentHeadGridView.this.hgx.buh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgw != null && TransparentHeadGridView.this.hgz != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgw.vW(100);
                        TransparentHeadGridView.this.hgz = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgs < 0) {
                        TransparentHeadGridView.this.hgs = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgs);
                    TransparentHeadGridView.this.hgr = i4 == 0;
                    if (TransparentHeadGridView.this.hgt != null) {
                        TransparentHeadGridView.this.hgt.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgz) {
                        TransparentHeadGridView.this.hgw.vW(height);
                        TransparentHeadGridView.this.hgz = height;
                    }
                }
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gRc = 0.0f;
        this.hgr = true;
        this.hgs = -1;
        this.hgz = -1;
        this.hgA = false;
        this.bON = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgB = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgA) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgx != null) {
                    TransparentHeadGridView.this.hgx.buh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgw != null && TransparentHeadGridView.this.hgz != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgw.vW(100);
                        TransparentHeadGridView.this.hgz = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgs < 0) {
                        TransparentHeadGridView.this.hgs = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgs);
                    TransparentHeadGridView.this.hgr = i4 == 0;
                    if (TransparentHeadGridView.this.hgt != null) {
                        TransparentHeadGridView.this.hgt.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgz) {
                        TransparentHeadGridView.this.hgw.vW(height);
                        TransparentHeadGridView.this.hgz = height;
                    }
                }
                if (TransparentHeadGridView.this.hgy != null) {
                    TransparentHeadGridView.this.hgy.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hgv = (int) (com.baidu.adp.lib.util.l.ae(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gRc = 0.0f;
                if (this.hgA && getPaddingTop() > this.hgv) {
                    a(getHeight(), 200L, 0L, this.hgB);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.gRc == 0.0f) {
                    this.gRc = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gRc && getPaddingTop() == 0 && this.hgr) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gRc) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hgx != null && i >= 0 && this.hgv > 0 && i <= this.hgv) {
                        this.hgx.vX((i * 100) / this.hgv);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGD() {
        setPadding(0, (int) ((10.0f - this.gRc) / 2.0f), 0, 0);
        this.mState = 0;
        this.gRc = 0.0f;
        if (this.hgA && getPaddingTop() > this.hgv) {
            a(getHeight(), 200L, 0L, this.hgB);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hgy = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hgt = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hgu != null) {
            this.hgu.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aTy == null) {
                this.aTy = new DecelerateInterpolator();
            }
            this.hgu = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hgu, j2);
            } else {
                post(this.hgu);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aTN;
        private final int aTO;
        private c hgD;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aTQ = true;
        private long mStartTime = -1;
        private int aTR = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aTO = i;
            this.aTN = i2;
            this.mInterpolator = TransparentHeadGridView.this.aTy;
            this.mDuration = j;
            this.hgD = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aTR = this.aTO - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aTO - this.aTN));
                TransparentHeadGridView.this.setPadding(0, this.aTR, 0, 0);
                if (TransparentHeadGridView.this.hgx != null && this.aTR >= 0 && TransparentHeadGridView.this.hgv > 0 && this.aTR <= TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.hgx.vX((this.aTR * 100) / TransparentHeadGridView.this.hgv);
                }
            }
            if (this.aTQ && this.aTN != this.aTR) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hgD != null) {
                this.hgD.Jj();
            }
        }

        public void stop() {
            this.aTQ = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hgw = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hgx = bVar;
    }
}
