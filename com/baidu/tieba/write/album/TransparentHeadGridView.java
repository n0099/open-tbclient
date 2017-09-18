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
    private Interpolator aPs;
    private Animation.AnimationListener byD;
    private b gCS;
    private a gCU;
    private float gDe;
    private boolean gDf;
    private int gDg;
    private View gDh;
    private d gDi;
    private int gDj;
    private Animation gDk;
    private Animation gDl;
    private AbsListView.OnScrollListener gDm;
    private int gDn;
    private c gDo;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void uw(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bpS();

        void ux(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Im();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gDe = 0.0f;
        this.gDf = true;
        this.gDg = -1;
        this.gDn = -1;
        this.byD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gDo = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gCS != null) {
                    TransparentHeadGridView.this.gCS.bpS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCU != null && TransparentHeadGridView.this.gDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCU.uw(100);
                        TransparentHeadGridView.this.gDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDg < 0) {
                        TransparentHeadGridView.this.gDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDg);
                    TransparentHeadGridView.this.gDf = i4 == 0;
                    if (TransparentHeadGridView.this.gDh != null) {
                        TransparentHeadGridView.this.gDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDn) {
                        TransparentHeadGridView.this.gCU.uw(height);
                        TransparentHeadGridView.this.gDn = height;
                    }
                }
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gDe = 0.0f;
        this.gDf = true;
        this.gDg = -1;
        this.gDn = -1;
        this.byD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gDo = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gCS != null) {
                    TransparentHeadGridView.this.gCS.bpS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCU != null && TransparentHeadGridView.this.gDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCU.uw(100);
                        TransparentHeadGridView.this.gDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDg < 0) {
                        TransparentHeadGridView.this.gDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDg);
                    TransparentHeadGridView.this.gDf = i4 == 0;
                    if (TransparentHeadGridView.this.gDh != null) {
                        TransparentHeadGridView.this.gDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDn) {
                        TransparentHeadGridView.this.gCU.uw(height);
                        TransparentHeadGridView.this.gDn = height;
                    }
                }
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gDe = 0.0f;
        this.gDf = true;
        this.gDg = -1;
        this.gDn = -1;
        this.byD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gDo = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Im() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gCS != null) {
                    TransparentHeadGridView.this.gCS.bpS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gCU != null && TransparentHeadGridView.this.gDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gCU.uw(100);
                        TransparentHeadGridView.this.gDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gDg < 0) {
                        TransparentHeadGridView.this.gDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gDg);
                    TransparentHeadGridView.this.gDf = i4 == 0;
                    if (TransparentHeadGridView.this.gDh != null) {
                        TransparentHeadGridView.this.gDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gCU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gDn) {
                        TransparentHeadGridView.this.gCU.uw(height);
                        TransparentHeadGridView.this.gDn = height;
                    }
                }
                if (TransparentHeadGridView.this.gDm != null) {
                    TransparentHeadGridView.this.gDm.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gDj = (int) (com.baidu.adp.lib.util.k.af(context) * 0.22f);
    }

    public void byx() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gDk == null) {
            this.gDk = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gDk);
    }

    public void byy() {
        this.mState = 0;
        if (this.gDl == null) {
            this.gDl = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gDl.setAnimationListener(this.byD);
        }
        startAnimation(this.gDl);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gDe = 0.0f;
                if (getPaddingTop() > this.gDj) {
                    a(getHeight(), 200L, 0L, this.gDo);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.gDe == 0.0f) {
                    this.gDe = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gDe && getPaddingTop() == 0 && this.gDf) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gDe) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gCS != null && i >= 0 && this.gDj > 0 && i <= this.gDj) {
                        this.gCS.ux((i * 100) / this.gDj);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gDm = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gDh = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gDi != null) {
            this.gDi.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aPs == null) {
                this.aPs = new DecelerateInterpolator();
            }
            this.gDi = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gDi, j2);
            } else {
                post(this.gDi);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aPH;
        private final int aPI;
        private c gDq;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aPK = true;
        private long mStartTime = -1;
        private int aPL = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aPI = i;
            this.aPH = i2;
            this.mInterpolator = TransparentHeadGridView.this.aPs;
            this.mDuration = j;
            this.gDq = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aPL = this.aPI - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aPI - this.aPH));
                TransparentHeadGridView.this.setPadding(0, this.aPL, 0, 0);
                if (TransparentHeadGridView.this.gCS != null && this.aPL >= 0 && TransparentHeadGridView.this.gDj > 0 && this.aPL <= TransparentHeadGridView.this.gDj) {
                    TransparentHeadGridView.this.gCS.ux((this.aPL * 100) / TransparentHeadGridView.this.gDj);
                }
            }
            if (this.aPK && this.aPH != this.aPL) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gDq != null) {
                this.gDq.Im();
            }
        }

        public void stop() {
            this.aPK = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gCU = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gCS = bVar;
    }
}
