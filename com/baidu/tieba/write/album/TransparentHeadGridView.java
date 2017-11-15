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
    private Interpolator aQv;
    private Animation.AnimationListener bGF;
    private float gEH;
    private b gSG;
    private a gSI;
    private boolean gSS;
    private int gST;
    private View gSU;
    private d gSV;
    private int gSW;
    private Animation gSX;
    private Animation gSY;
    private AbsListView.OnScrollListener gSZ;
    private int gTa;
    private c gTb;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void vp(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void brU();

        void vq(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void IL();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gEH = 0.0f;
        this.gSS = true;
        this.gST = -1;
        this.gTa = -1;
        this.bGF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gTb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IL() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gSG != null) {
                    TransparentHeadGridView.this.gSG.brU();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gSI != null && TransparentHeadGridView.this.gTa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gSI.vp(100);
                        TransparentHeadGridView.this.gTa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gST < 0) {
                        TransparentHeadGridView.this.gST = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gST);
                    TransparentHeadGridView.this.gSS = i4 == 0;
                    if (TransparentHeadGridView.this.gSU != null) {
                        TransparentHeadGridView.this.gSU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gSI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gTa) {
                        TransparentHeadGridView.this.gSI.vp(height);
                        TransparentHeadGridView.this.gTa = height;
                    }
                }
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gEH = 0.0f;
        this.gSS = true;
        this.gST = -1;
        this.gTa = -1;
        this.bGF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gTb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IL() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gSG != null) {
                    TransparentHeadGridView.this.gSG.brU();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gSI != null && TransparentHeadGridView.this.gTa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gSI.vp(100);
                        TransparentHeadGridView.this.gTa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gST < 0) {
                        TransparentHeadGridView.this.gST = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gST);
                    TransparentHeadGridView.this.gSS = i4 == 0;
                    if (TransparentHeadGridView.this.gSU != null) {
                        TransparentHeadGridView.this.gSU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gSI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gTa) {
                        TransparentHeadGridView.this.gSI.vp(height);
                        TransparentHeadGridView.this.gTa = height;
                    }
                }
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gEH = 0.0f;
        this.gSS = true;
        this.gST = -1;
        this.gTa = -1;
        this.bGF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gTb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void IL() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gSG != null) {
                    TransparentHeadGridView.this.gSG.brU();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gSI != null && TransparentHeadGridView.this.gTa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gSI.vp(100);
                        TransparentHeadGridView.this.gTa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gST < 0) {
                        TransparentHeadGridView.this.gST = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gST);
                    TransparentHeadGridView.this.gSS = i4 == 0;
                    if (TransparentHeadGridView.this.gSU != null) {
                        TransparentHeadGridView.this.gSU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gSI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gTa) {
                        TransparentHeadGridView.this.gSI.vp(height);
                        TransparentHeadGridView.this.gTa = height;
                    }
                }
                if (TransparentHeadGridView.this.gSZ != null) {
                    TransparentHeadGridView.this.gSZ.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gSW = (int) (com.baidu.adp.lib.util.l.ae(context) * 0.22f);
    }

    public void bDr() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gSX == null) {
            this.gSX = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gSX);
    }

    public void bDs() {
        this.mState = 0;
        if (this.gSY == null) {
            this.gSY = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gSY.setAnimationListener(this.bGF);
        }
        startAnimation(this.gSY);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gEH = 0.0f;
                if (getPaddingTop() > this.gSW) {
                    a(getHeight(), 200L, 0L, this.gTb);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.gEH == 0.0f) {
                    this.gEH = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gEH && getPaddingTop() == 0 && this.gSS) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gEH) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gSG != null && i >= 0 && this.gSW > 0 && i <= this.gSW) {
                        this.gSG.vq((i * 100) / this.gSW);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gSZ = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gSU = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gSV != null) {
            this.gSV.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aQv == null) {
                this.aQv = new DecelerateInterpolator();
            }
            this.gSV = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gSV, j2);
            } else {
                post(this.gSV);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aQK;
        private final int aQL;
        private c gTd;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQN = true;
        private long mStartTime = -1;
        private int aQO = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQL = i;
            this.aQK = i2;
            this.mInterpolator = TransparentHeadGridView.this.aQv;
            this.mDuration = j;
            this.gTd = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQO = this.aQL - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQL - this.aQK));
                TransparentHeadGridView.this.setPadding(0, this.aQO, 0, 0);
                if (TransparentHeadGridView.this.gSG != null && this.aQO >= 0 && TransparentHeadGridView.this.gSW > 0 && this.aQO <= TransparentHeadGridView.this.gSW) {
                    TransparentHeadGridView.this.gSG.vq((this.aQO * 100) / TransparentHeadGridView.this.gSW);
                }
            }
            if (this.aQN && this.aQK != this.aQO) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gTd != null) {
                this.gTd.IL();
            }
        }

        public void stop() {
            this.aQN = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gSI = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gSG = bVar;
    }
}
