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
    private Interpolator aPK;
    private float fCT;
    private boolean gBG;
    private int gBH;
    private View gBI;
    private d gBJ;
    private int gBK;
    private Animation gBL;
    private Animation gBM;
    private AbsListView.OnScrollListener gBN;
    private int gBO;
    private c gBP;
    private b gBu;
    private a gBw;
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
        void bpP();

        void uj(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void If();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.fCT = 0.0f;
        this.gBG = true;
        this.gBH = -1;
        this.gBO = -1;
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
        this.gBP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBu != null) {
                    TransparentHeadGridView.this.gBu.bpP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gBw != null && TransparentHeadGridView.this.gBO != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gBw.ui(100);
                        TransparentHeadGridView.this.gBO = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gBH < 0) {
                        TransparentHeadGridView.this.gBH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gBH);
                    TransparentHeadGridView.this.gBG = i4 == 0;
                    if (TransparentHeadGridView.this.gBI != null) {
                        TransparentHeadGridView.this.gBI.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gBw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gBO) {
                        TransparentHeadGridView.this.gBw.ui(height);
                        TransparentHeadGridView.this.gBO = height;
                    }
                }
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.fCT = 0.0f;
        this.gBG = true;
        this.gBH = -1;
        this.gBO = -1;
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
        this.gBP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBu != null) {
                    TransparentHeadGridView.this.gBu.bpP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gBw != null && TransparentHeadGridView.this.gBO != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gBw.ui(100);
                        TransparentHeadGridView.this.gBO = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gBH < 0) {
                        TransparentHeadGridView.this.gBH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gBH);
                    TransparentHeadGridView.this.gBG = i4 == 0;
                    if (TransparentHeadGridView.this.gBI != null) {
                        TransparentHeadGridView.this.gBI.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gBw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gBO) {
                        TransparentHeadGridView.this.gBw.ui(height);
                        TransparentHeadGridView.this.gBO = height;
                    }
                }
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.fCT = 0.0f;
        this.gBG = true;
        this.gBH = -1;
        this.gBO = -1;
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
        this.gBP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void If() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gBu != null) {
                    TransparentHeadGridView.this.gBu.bpP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gBw != null && TransparentHeadGridView.this.gBO != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gBw.ui(100);
                        TransparentHeadGridView.this.gBO = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gBH < 0) {
                        TransparentHeadGridView.this.gBH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gBH);
                    TransparentHeadGridView.this.gBG = i4 == 0;
                    if (TransparentHeadGridView.this.gBI != null) {
                        TransparentHeadGridView.this.gBI.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gBw != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gBO) {
                        TransparentHeadGridView.this.gBw.ui(height);
                        TransparentHeadGridView.this.gBO = height;
                    }
                }
                if (TransparentHeadGridView.this.gBN != null) {
                    TransparentHeadGridView.this.gBN.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gBK = (int) (com.baidu.adp.lib.util.k.ah(context) * 0.22f);
    }

    public void byw() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gBL == null) {
            this.gBL = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gBL);
    }

    public void byx() {
        this.mState = 0;
        if (this.gBM == null) {
            this.gBM = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gBM.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.gBM);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.fCT = 0.0f;
                if (getPaddingTop() > this.gBK) {
                    a(getHeight(), 200L, 0L, this.gBP);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.fCT == 0.0f) {
                    this.fCT = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.fCT && getPaddingTop() == 0 && this.gBG) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.fCT) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gBu != null && i >= 0 && this.gBK > 0 && i <= this.gBK) {
                        this.gBu.uj((i * 100) / this.gBK);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gBN = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gBI = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gBJ != null) {
            this.gBJ.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aPK == null) {
                this.aPK = new DecelerateInterpolator();
            }
            this.gBJ = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gBJ, j2);
            } else {
                post(this.gBJ);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aPZ;
        private final int aQa;
        private final long aQb;
        private c gBR;
        private final Interpolator mInterpolator;
        private boolean aQd = true;
        private long mStartTime = -1;
        private int aQe = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQa = i;
            this.aPZ = i2;
            this.mInterpolator = TransparentHeadGridView.this.aPK;
            this.aQb = j;
            this.gBR = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQe = this.aQa - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aQb, 1000L), 0L)) / 1000.0f) * (this.aQa - this.aPZ));
                TransparentHeadGridView.this.setPadding(0, this.aQe, 0, 0);
                if (TransparentHeadGridView.this.gBu != null && this.aQe >= 0 && TransparentHeadGridView.this.gBK > 0 && this.aQe <= TransparentHeadGridView.this.gBK) {
                    TransparentHeadGridView.this.gBu.uj((this.aQe * 100) / TransparentHeadGridView.this.gBK);
                }
            }
            if (this.aQd && this.aPZ != this.aQe) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gBR != null) {
                this.gBR.If();
            }
        }

        public void stop() {
            this.aQd = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gBw = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gBu = bVar;
    }
}
