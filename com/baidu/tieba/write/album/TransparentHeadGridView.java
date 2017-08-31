package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator aPv;
    private b gBZ;
    private a gCb;
    private float gCl;
    private boolean gCm;
    private int gCn;
    private View gCo;
    private d gCp;
    private int gCq;
    private Animation gCr;
    private Animation gCs;
    private AbsListView.OnScrollListener gCt;
    private int gCu;
    private c gCv;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void uu(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bpH();

        void uv(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Im();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gCl = 0.0f;
        this.gCm = true;
        this.gCn = -1;
        this.gCu = -1;
        this.mAnimationListener = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gCv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBZ != null) {
                    TransparentHeadGridView.this.gBZ.bpH();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCb != null && TransparentHeadGridView.this.gCu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCb.uu(100);
                        TransparentHeadGridView.this.gCu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gCn < 0) {
                        TransparentHeadGridView.this.gCn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gCn);
                    TransparentHeadGridView.this.gCm = i4 == 0;
                    if (TransparentHeadGridView.this.gCo != null) {
                        TransparentHeadGridView.this.gCo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gCu) {
                        TransparentHeadGridView.this.gCb.uu(height);
                        TransparentHeadGridView.this.gCu = height;
                    }
                }
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gCl = 0.0f;
        this.gCm = true;
        this.gCn = -1;
        this.gCu = -1;
        this.mAnimationListener = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gCv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBZ != null) {
                    TransparentHeadGridView.this.gBZ.bpH();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCb != null && TransparentHeadGridView.this.gCu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCb.uu(100);
                        TransparentHeadGridView.this.gCu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gCn < 0) {
                        TransparentHeadGridView.this.gCn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gCn);
                    TransparentHeadGridView.this.gCm = i4 == 0;
                    if (TransparentHeadGridView.this.gCo != null) {
                        TransparentHeadGridView.this.gCo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gCu) {
                        TransparentHeadGridView.this.gCb.uu(height);
                        TransparentHeadGridView.this.gCu = height;
                    }
                }
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gCl = 0.0f;
        this.gCm = true;
        this.gCn = -1;
        this.gCu = -1;
        this.mAnimationListener = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gCv = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBZ != null) {
                    TransparentHeadGridView.this.gBZ.bpH();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCb != null && TransparentHeadGridView.this.gCu != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCb.uu(100);
                        TransparentHeadGridView.this.gCu = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gCn < 0) {
                        TransparentHeadGridView.this.gCn = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gCn);
                    TransparentHeadGridView.this.gCm = i4 == 0;
                    if (TransparentHeadGridView.this.gCo != null) {
                        TransparentHeadGridView.this.gCo.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gCu) {
                        TransparentHeadGridView.this.gCb.uu(height);
                        TransparentHeadGridView.this.gCu = height;
                    }
                }
                if (TransparentHeadGridView.this.gCt != null) {
                    TransparentHeadGridView.this.gCt.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gCq = (int) (com.baidu.adp.lib.util.k.ae(context) * 0.22f);
    }

    public void bym() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gCr == null) {
            this.gCr = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gCr);
    }

    public void byn() {
        this.mState = 0;
        if (this.gCs == null) {
            this.gCs = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gCs.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.gCs);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gCl = 0.0f;
                if (getPaddingTop() > this.gCq) {
                    a(getHeight(), 200L, 0L, this.gCv);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.gCl == 0.0f) {
                    this.gCl = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gCl && getPaddingTop() == 0 && this.gCm) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gCl) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gBZ != null && i >= 0 && this.gCq > 0 && i <= this.gCq) {
                        this.gBZ.uv((i * 100) / this.gCq);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gCt = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gCo = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gCp != null) {
            this.gCp.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aPv == null) {
                this.aPv = new DecelerateInterpolator();
            }
            this.gCp = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gCp, j2);
            } else {
                post(this.gCp);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aPK;
        private final int aPL;
        private c gCx;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aPN = true;
        private long mStartTime = -1;
        private int aPO = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aPL = i;
            this.aPK = i2;
            this.mInterpolator = TransparentHeadGridView.this.aPv;
            this.mDuration = j;
            this.gCx = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aPO = this.aPL - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aPL - this.aPK));
                TransparentHeadGridView.this.setPadding(0, this.aPO, 0, 0);
                if (TransparentHeadGridView.this.gBZ != null && this.aPO >= 0 && TransparentHeadGridView.this.gCq > 0 && this.aPO <= TransparentHeadGridView.this.gCq) {
                    TransparentHeadGridView.this.gBZ.uv((this.aPO * 100) / TransparentHeadGridView.this.gCq);
                }
            }
            if (this.aPN && this.aPK != this.aPO) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gCx != null) {
                this.gCx.Im();
            }
        }

        public void stop() {
            this.aPN = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gCb = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gBZ = bVar;
    }
}
