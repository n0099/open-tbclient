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
    private Interpolator aQn;
    private Animation.AnimationListener bGs;
    private float gDz;
    private a gRA;
    private boolean gRK;
    private int gRL;
    private View gRM;
    private d gRN;
    private int gRO;
    private Animation gRP;
    private Animation gRQ;
    private AbsListView.OnScrollListener gRR;
    private int gRS;
    private c gRT;
    private b gRy;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void vl(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void brJ();

        void vm(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void IA();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gDz = 0.0f;
        this.gRK = true;
        this.gRL = -1;
        this.gRS = -1;
        this.bGs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gRT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IA() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gRy != null) {
                    TransparentHeadGridView.this.gRy.brJ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gRA != null && TransparentHeadGridView.this.gRS != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gRA.vl(100);
                        TransparentHeadGridView.this.gRS = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gRL < 0) {
                        TransparentHeadGridView.this.gRL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gRL);
                    TransparentHeadGridView.this.gRK = i4 == 0;
                    if (TransparentHeadGridView.this.gRM != null) {
                        TransparentHeadGridView.this.gRM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gRA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gRS) {
                        TransparentHeadGridView.this.gRA.vl(height);
                        TransparentHeadGridView.this.gRS = height;
                    }
                }
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gDz = 0.0f;
        this.gRK = true;
        this.gRL = -1;
        this.gRS = -1;
        this.bGs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gRT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IA() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gRy != null) {
                    TransparentHeadGridView.this.gRy.brJ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gRA != null && TransparentHeadGridView.this.gRS != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gRA.vl(100);
                        TransparentHeadGridView.this.gRS = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gRL < 0) {
                        TransparentHeadGridView.this.gRL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gRL);
                    TransparentHeadGridView.this.gRK = i4 == 0;
                    if (TransparentHeadGridView.this.gRM != null) {
                        TransparentHeadGridView.this.gRM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gRA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gRS) {
                        TransparentHeadGridView.this.gRA.vl(height);
                        TransparentHeadGridView.this.gRS = height;
                    }
                }
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gDz = 0.0f;
        this.gRK = true;
        this.gRL = -1;
        this.gRS = -1;
        this.bGs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gRT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IA() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gRy != null) {
                    TransparentHeadGridView.this.gRy.brJ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gRA != null && TransparentHeadGridView.this.gRS != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gRA.vl(100);
                        TransparentHeadGridView.this.gRS = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gRL < 0) {
                        TransparentHeadGridView.this.gRL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gRL);
                    TransparentHeadGridView.this.gRK = i4 == 0;
                    if (TransparentHeadGridView.this.gRM != null) {
                        TransparentHeadGridView.this.gRM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gRA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gRS) {
                        TransparentHeadGridView.this.gRA.vl(height);
                        TransparentHeadGridView.this.gRS = height;
                    }
                }
                if (TransparentHeadGridView.this.gRR != null) {
                    TransparentHeadGridView.this.gRR.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gRO = (int) (com.baidu.adp.lib.util.l.ae(context) * 0.22f);
    }

    public void bDf() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gRP == null) {
            this.gRP = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gRP);
    }

    public void bDg() {
        this.mState = 0;
        if (this.gRQ == null) {
            this.gRQ = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gRQ.setAnimationListener(this.bGs);
        }
        startAnimation(this.gRQ);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gDz = 0.0f;
                if (getPaddingTop() > this.gRO) {
                    a(getHeight(), 200L, 0L, this.gRT);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.gDz == 0.0f) {
                    this.gDz = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gDz && getPaddingTop() == 0 && this.gRK) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gDz) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gRy != null && i >= 0 && this.gRO > 0 && i <= this.gRO) {
                        this.gRy.vm((i * 100) / this.gRO);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gRR = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gRM = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gRN != null) {
            this.gRN.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aQn == null) {
                this.aQn = new DecelerateInterpolator();
            }
            this.gRN = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gRN, j2);
            } else {
                post(this.gRN);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aQC;
        private final int aQD;
        private c gRV;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQF = true;
        private long mStartTime = -1;
        private int aQG = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQD = i;
            this.aQC = i2;
            this.mInterpolator = TransparentHeadGridView.this.aQn;
            this.mDuration = j;
            this.gRV = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQG = this.aQD - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQD - this.aQC));
                TransparentHeadGridView.this.setPadding(0, this.aQG, 0, 0);
                if (TransparentHeadGridView.this.gRy != null && this.aQG >= 0 && TransparentHeadGridView.this.gRO > 0 && this.aQG <= TransparentHeadGridView.this.gRO) {
                    TransparentHeadGridView.this.gRy.vm((this.aQG * 100) / TransparentHeadGridView.this.gRO);
                }
            }
            if (this.aQF && this.aQC != this.aQG) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gRV != null) {
                this.gRV.IA();
            }
        }

        public void stop() {
            this.aQF = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gRA = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gRy = bVar;
    }
}
