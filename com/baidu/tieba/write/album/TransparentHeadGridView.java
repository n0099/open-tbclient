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
    private Interpolator aPM;
    private float fEO;
    private View gDA;
    private d gDB;
    private int gDC;
    private Animation gDD;
    private Animation gDE;
    private AbsListView.OnScrollListener gDF;
    private int gDG;
    private c gDH;
    private b gDm;
    private a gDo;
    private boolean gDy;
    private int gDz;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes.dex */
    public interface a {
        void ur(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bqq();

        void us(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void If();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.fEO = 0.0f;
        this.gDy = true;
        this.gDz = -1;
        this.gDG = -1;
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
        this.gDH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.bqq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gDo != null && TransparentHeadGridView.this.gDG != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gDo.ur(100);
                        TransparentHeadGridView.this.gDG = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDz < 0) {
                        TransparentHeadGridView.this.gDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDz);
                    TransparentHeadGridView.this.gDy = i4 == 0;
                    if (TransparentHeadGridView.this.gDA != null) {
                        TransparentHeadGridView.this.gDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gDo != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDG) {
                        TransparentHeadGridView.this.gDo.ur(height);
                        TransparentHeadGridView.this.gDG = height;
                    }
                }
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.fEO = 0.0f;
        this.gDy = true;
        this.gDz = -1;
        this.gDG = -1;
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
        this.gDH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.bqq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gDo != null && TransparentHeadGridView.this.gDG != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gDo.ur(100);
                        TransparentHeadGridView.this.gDG = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDz < 0) {
                        TransparentHeadGridView.this.gDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDz);
                    TransparentHeadGridView.this.gDy = i4 == 0;
                    if (TransparentHeadGridView.this.gDA != null) {
                        TransparentHeadGridView.this.gDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gDo != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDG) {
                        TransparentHeadGridView.this.gDo.ur(height);
                        TransparentHeadGridView.this.gDG = height;
                    }
                }
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.fEO = 0.0f;
        this.gDy = true;
        this.gDz = -1;
        this.gDG = -1;
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
        this.gDH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.bqq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gDo != null && TransparentHeadGridView.this.gDG != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gDo.ur(100);
                        TransparentHeadGridView.this.gDG = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDz < 0) {
                        TransparentHeadGridView.this.gDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDz);
                    TransparentHeadGridView.this.gDy = i4 == 0;
                    if (TransparentHeadGridView.this.gDA != null) {
                        TransparentHeadGridView.this.gDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gDo != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDG) {
                        TransparentHeadGridView.this.gDo.ur(height);
                        TransparentHeadGridView.this.gDG = height;
                    }
                }
                if (TransparentHeadGridView.this.gDF != null) {
                    TransparentHeadGridView.this.gDF.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gDC = (int) (com.baidu.adp.lib.util.k.ah(context) * 0.22f);
    }

    public void byV() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gDD == null) {
            this.gDD = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gDD);
    }

    public void byW() {
        this.mState = 0;
        if (this.gDE == null) {
            this.gDE = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gDE.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.gDE);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.fEO = 0.0f;
                if (getPaddingTop() > this.gDC) {
                    a(getHeight(), 200L, 0L, this.gDH);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.fEO == 0.0f) {
                    this.fEO = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.fEO && getPaddingTop() == 0 && this.gDy) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.fEO) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gDm != null && i >= 0 && this.gDC > 0 && i <= this.gDC) {
                        this.gDm.us((i * 100) / this.gDC);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gDF = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gDA = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gDB != null) {
            this.gDB.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aPM == null) {
                this.aPM = new DecelerateInterpolator();
            }
            this.gDB = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gDB, j2);
            } else {
                post(this.gDB);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aQb;
        private final int aQc;
        private final long aQd;
        private c gDJ;
        private final Interpolator mInterpolator;
        private boolean aQf = true;
        private long mStartTime = -1;
        private int aQg = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQc = i;
            this.aQb = i2;
            this.mInterpolator = TransparentHeadGridView.this.aPM;
            this.aQd = j;
            this.gDJ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQg = this.aQc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aQd, 1000L), 0L)) / 1000.0f) * (this.aQc - this.aQb));
                TransparentHeadGridView.this.setPadding(0, this.aQg, 0, 0);
                if (TransparentHeadGridView.this.gDm != null && this.aQg >= 0 && TransparentHeadGridView.this.gDC > 0 && this.aQg <= TransparentHeadGridView.this.gDC) {
                    TransparentHeadGridView.this.gDm.us((this.aQg * 100) / TransparentHeadGridView.this.gDC);
                }
            }
            if (this.aQf && this.aQb != this.aQg) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gDJ != null) {
                this.gDJ.If();
            }
        }

        public void stop() {
            this.aQf = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gDo = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gDm = bVar;
    }
}
