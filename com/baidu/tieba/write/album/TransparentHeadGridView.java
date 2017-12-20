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
    private Interpolator aTv;
    private Animation.AnimationListener bOJ;
    private float gQX;
    private boolean hgm;
    private int hgn;
    private View hgo;
    private d hgp;
    private int hgq;
    private a hgr;
    private b hgs;
    private AbsListView.OnScrollListener hgt;
    private int hgu;
    private boolean hgv;
    private c hgw;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void vW(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bug();

        void vX(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Jj();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gQX = 0.0f;
        this.hgm = true;
        this.hgn = -1;
        this.hgu = -1;
        this.hgv = false;
        this.bOJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgs != null) {
                    TransparentHeadGridView.this.hgs.bug();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgr != null && TransparentHeadGridView.this.hgu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgr.vW(100);
                        TransparentHeadGridView.this.hgu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgn < 0) {
                        TransparentHeadGridView.this.hgn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgn);
                    TransparentHeadGridView.this.hgm = i4 == 0;
                    if (TransparentHeadGridView.this.hgo != null) {
                        TransparentHeadGridView.this.hgo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgr != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgu) {
                        TransparentHeadGridView.this.hgr.vW(height);
                        TransparentHeadGridView.this.hgu = height;
                    }
                }
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gQX = 0.0f;
        this.hgm = true;
        this.hgn = -1;
        this.hgu = -1;
        this.hgv = false;
        this.bOJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgs != null) {
                    TransparentHeadGridView.this.hgs.bug();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgr != null && TransparentHeadGridView.this.hgu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgr.vW(100);
                        TransparentHeadGridView.this.hgu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgn < 0) {
                        TransparentHeadGridView.this.hgn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgn);
                    TransparentHeadGridView.this.hgm = i4 == 0;
                    if (TransparentHeadGridView.this.hgo != null) {
                        TransparentHeadGridView.this.hgo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgr != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgu) {
                        TransparentHeadGridView.this.hgr.vW(height);
                        TransparentHeadGridView.this.hgu = height;
                    }
                }
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gQX = 0.0f;
        this.hgm = true;
        this.hgn = -1;
        this.hgu = -1;
        this.hgv = false;
        this.bOJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hgw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jj() {
                if (TransparentHeadGridView.this.hgv) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hgs != null) {
                    TransparentHeadGridView.this.hgs.bug();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hgr != null && TransparentHeadGridView.this.hgu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hgr.vW(100);
                        TransparentHeadGridView.this.hgu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hgn < 0) {
                        TransparentHeadGridView.this.hgn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hgn);
                    TransparentHeadGridView.this.hgm = i4 == 0;
                    if (TransparentHeadGridView.this.hgo != null) {
                        TransparentHeadGridView.this.hgo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hgr != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hgu) {
                        TransparentHeadGridView.this.hgr.vW(height);
                        TransparentHeadGridView.this.hgu = height;
                    }
                }
                if (TransparentHeadGridView.this.hgt != null) {
                    TransparentHeadGridView.this.hgt.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hgq = (int) (com.baidu.adp.lib.util.l.ae(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gQX = 0.0f;
                if (this.hgv && getPaddingTop() > this.hgq) {
                    a(getHeight(), 200L, 0L, this.hgw);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.gQX == 0.0f) {
                    this.gQX = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gQX && getPaddingTop() == 0 && this.hgm) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gQX) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hgs != null && i >= 0 && this.hgq > 0 && i <= this.hgq) {
                        this.hgs.vX((i * 100) / this.hgq);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGC() {
        setPadding(0, (int) ((10.0f - this.gQX) / 2.0f), 0, 0);
        this.mState = 0;
        this.gQX = 0.0f;
        if (this.hgv && getPaddingTop() > this.hgq) {
            a(getHeight(), 200L, 0L, this.hgw);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hgt = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hgo = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hgp != null) {
            this.hgp.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aTv == null) {
                this.aTv = new DecelerateInterpolator();
            }
            this.hgp = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hgp, j2);
            } else {
                post(this.hgp);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aTK;
        private final int aTL;
        private c hgy;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aTN = true;
        private long mStartTime = -1;
        private int aTO = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aTL = i;
            this.aTK = i2;
            this.mInterpolator = TransparentHeadGridView.this.aTv;
            this.mDuration = j;
            this.hgy = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aTO = this.aTL - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aTL - this.aTK));
                TransparentHeadGridView.this.setPadding(0, this.aTO, 0, 0);
                if (TransparentHeadGridView.this.hgs != null && this.aTO >= 0 && TransparentHeadGridView.this.hgq > 0 && this.aTO <= TransparentHeadGridView.this.hgq) {
                    TransparentHeadGridView.this.hgs.vX((this.aTO * 100) / TransparentHeadGridView.this.hgq);
                }
            }
            if (this.aTN && this.aTK != this.aTO) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hgy != null) {
                this.hgy.Jj();
            }
        }

        public void stop() {
            this.aTN = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hgr = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hgs = bVar;
    }
}
