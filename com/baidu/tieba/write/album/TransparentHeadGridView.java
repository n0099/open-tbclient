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
/* loaded from: classes.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator aOw;
    private float fBH;
    private Animation gAA;
    private Animation gAB;
    private AbsListView.OnScrollListener gAC;
    private int gAD;
    private c gAE;
    private b gAj;
    private a gAl;
    private boolean gAv;
    private int gAw;
    private View gAx;
    private d gAy;
    private int gAz;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes.dex */
    public interface a {
        void ui(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bpI();

        void uj(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void HX();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.fBH = 0.0f;
        this.gAv = true;
        this.gAw = -1;
        this.gAD = -1;
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
        this.gAE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void HX() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gAj != null) {
                    TransparentHeadGridView.this.gAj.bpI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gAl != null && TransparentHeadGridView.this.gAD != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gAl.ui(100);
                        TransparentHeadGridView.this.gAD = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gAw < 0) {
                        TransparentHeadGridView.this.gAw = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gAw);
                    TransparentHeadGridView.this.gAv = i4 == 0;
                    if (TransparentHeadGridView.this.gAx != null) {
                        TransparentHeadGridView.this.gAx.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gAl != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gAD) {
                        TransparentHeadGridView.this.gAl.ui(height);
                        TransparentHeadGridView.this.gAD = height;
                    }
                }
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.fBH = 0.0f;
        this.gAv = true;
        this.gAw = -1;
        this.gAD = -1;
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
        this.gAE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void HX() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gAj != null) {
                    TransparentHeadGridView.this.gAj.bpI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gAl != null && TransparentHeadGridView.this.gAD != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gAl.ui(100);
                        TransparentHeadGridView.this.gAD = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gAw < 0) {
                        TransparentHeadGridView.this.gAw = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gAw);
                    TransparentHeadGridView.this.gAv = i4 == 0;
                    if (TransparentHeadGridView.this.gAx != null) {
                        TransparentHeadGridView.this.gAx.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gAl != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gAD) {
                        TransparentHeadGridView.this.gAl.ui(height);
                        TransparentHeadGridView.this.gAD = height;
                    }
                }
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.fBH = 0.0f;
        this.gAv = true;
        this.gAw = -1;
        this.gAD = -1;
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
        this.gAE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void HX() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gAj != null) {
                    TransparentHeadGridView.this.gAj.bpI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gAl != null && TransparentHeadGridView.this.gAD != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gAl.ui(100);
                        TransparentHeadGridView.this.gAD = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gAw < 0) {
                        TransparentHeadGridView.this.gAw = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gAw);
                    TransparentHeadGridView.this.gAv = i4 == 0;
                    if (TransparentHeadGridView.this.gAx != null) {
                        TransparentHeadGridView.this.gAx.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gAl != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gAD) {
                        TransparentHeadGridView.this.gAl.ui(height);
                        TransparentHeadGridView.this.gAD = height;
                    }
                }
                if (TransparentHeadGridView.this.gAC != null) {
                    TransparentHeadGridView.this.gAC.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gAz = (int) (com.baidu.adp.lib.util.k.ag(context) * 0.22f);
    }

    public void byp() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gAA == null) {
            this.gAA = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gAA);
    }

    public void byq() {
        this.mState = 0;
        if (this.gAB == null) {
            this.gAB = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gAB.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.gAB);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.fBH = 0.0f;
                if (getPaddingTop() > this.gAz) {
                    a(getHeight(), 200L, 0L, this.gAE);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.fBH == 0.0f) {
                    this.fBH = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.fBH && getPaddingTop() == 0 && this.gAv) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.fBH) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gAj != null && i >= 0 && this.gAz > 0 && i <= this.gAz) {
                        this.gAj.uj((i * 100) / this.gAz);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gAC = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gAx = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gAy != null) {
            this.gAy.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aOw == null) {
                this.aOw = new DecelerateInterpolator();
            }
            this.gAy = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gAy, j2);
            } else {
                post(this.gAy);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aOL;
        private final int aOM;
        private final long aON;
        private c gAG;
        private final Interpolator mInterpolator;
        private boolean aOP = true;
        private long mStartTime = -1;
        private int aOQ = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aOM = i;
            this.aOL = i2;
            this.mInterpolator = TransparentHeadGridView.this.aOw;
            this.aON = j;
            this.gAG = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aOQ = this.aOM - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aON, 1000L), 0L)) / 1000.0f) * (this.aOM - this.aOL));
                TransparentHeadGridView.this.setPadding(0, this.aOQ, 0, 0);
                if (TransparentHeadGridView.this.gAj != null && this.aOQ >= 0 && TransparentHeadGridView.this.gAz > 0 && this.aOQ <= TransparentHeadGridView.this.gAz) {
                    TransparentHeadGridView.this.gAj.uj((this.aOQ * 100) / TransparentHeadGridView.this.gAz);
                }
            }
            if (this.aOP && this.aOL != this.aOQ) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gAG != null) {
                this.gAG.HX();
            }
        }

        public void stop() {
            this.aOP = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gAl = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gAj = bVar;
    }
}
