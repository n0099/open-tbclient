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
    private Interpolator bHt;
    private Animation.AnimationListener cDC;
    private boolean hEa;
    private int hEb;
    private View hEc;
    private d hEd;
    private int hEe;
    private a hEf;
    private b hEg;
    private AbsListView.OnScrollListener hEh;
    private int hEi;
    private boolean hEj;
    private c hEk;
    private float hnH;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void xq(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bFQ();

        void xr(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Qu();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hnH = 0.0f;
        this.hEa = true;
        this.hEb = -1;
        this.hEi = -1;
        this.hEj = false;
        this.cDC = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qu() {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEg != null) {
                    TransparentHeadGridView.this.hEg.bFQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEf != null && TransparentHeadGridView.this.hEi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEf.xq(100);
                        TransparentHeadGridView.this.hEi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEb < 0) {
                        TransparentHeadGridView.this.hEb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEb);
                    TransparentHeadGridView.this.hEa = i4 == 0;
                    if (TransparentHeadGridView.this.hEc != null) {
                        TransparentHeadGridView.this.hEc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEi) {
                        TransparentHeadGridView.this.hEf.xq(height);
                        TransparentHeadGridView.this.hEi = height;
                    }
                }
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hnH = 0.0f;
        this.hEa = true;
        this.hEb = -1;
        this.hEi = -1;
        this.hEj = false;
        this.cDC = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qu() {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEg != null) {
                    TransparentHeadGridView.this.hEg.bFQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEf != null && TransparentHeadGridView.this.hEi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEf.xq(100);
                        TransparentHeadGridView.this.hEi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEb < 0) {
                        TransparentHeadGridView.this.hEb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEb);
                    TransparentHeadGridView.this.hEa = i4 == 0;
                    if (TransparentHeadGridView.this.hEc != null) {
                        TransparentHeadGridView.this.hEc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEi) {
                        TransparentHeadGridView.this.hEf.xq(height);
                        TransparentHeadGridView.this.hEi = height;
                    }
                }
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hnH = 0.0f;
        this.hEa = true;
        this.hEb = -1;
        this.hEi = -1;
        this.hEj = false;
        this.cDC = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qu() {
                if (TransparentHeadGridView.this.hEj) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEg != null) {
                    TransparentHeadGridView.this.hEg.bFQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEf != null && TransparentHeadGridView.this.hEi != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEf.xq(100);
                        TransparentHeadGridView.this.hEi = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEb < 0) {
                        TransparentHeadGridView.this.hEb = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEb);
                    TransparentHeadGridView.this.hEa = i4 == 0;
                    if (TransparentHeadGridView.this.hEc != null) {
                        TransparentHeadGridView.this.hEc.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEf != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEi) {
                        TransparentHeadGridView.this.hEf.xq(height);
                        TransparentHeadGridView.this.hEi = height;
                    }
                }
                if (TransparentHeadGridView.this.hEh != null) {
                    TransparentHeadGridView.this.hEh.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hEe = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hnH = 0.0f;
                if (this.hEj && getPaddingTop() > this.hEe) {
                    a(getHeight(), 200L, 0L, this.hEk);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hnH == 0.0f) {
                    this.hnH = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hnH && getPaddingTop() == 0 && this.hEa) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hnH) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hEg != null && i >= 0 && this.hEe > 0 && i <= this.hEe) {
                        this.hEg.xr((i * 100) / this.hEe);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bFP() {
        setPadding(0, (int) ((10.0f - this.hnH) / 2.0f), 0, 0);
        this.mState = 0;
        this.hnH = 0.0f;
        if (this.hEj && getPaddingTop() > this.hEe) {
            a(getHeight(), 200L, 0L, this.hEk);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hEh = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hEc = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hEd != null) {
            this.hEd.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bHt == null) {
                this.bHt = new DecelerateInterpolator();
            }
            this.hEd = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hEd, j2);
            } else {
                post(this.hEd);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bHI;
        private final int bHJ;
        private c hEm;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bHL = true;
        private long mStartTime = -1;
        private int bHM = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bHJ = i;
            this.bHI = i2;
            this.mInterpolator = TransparentHeadGridView.this.bHt;
            this.mDuration = j;
            this.hEm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bHM = this.bHJ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bHJ - this.bHI));
                TransparentHeadGridView.this.setPadding(0, this.bHM, 0, 0);
                if (TransparentHeadGridView.this.hEg != null && this.bHM >= 0 && TransparentHeadGridView.this.hEe > 0 && this.bHM <= TransparentHeadGridView.this.hEe) {
                    TransparentHeadGridView.this.hEg.xr((this.bHM * 100) / TransparentHeadGridView.this.hEe);
                }
            }
            if (this.bHL && this.bHI != this.bHM) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hEm != null) {
                this.hEm.Qu();
            }
        }

        public void stop() {
            this.bHL = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hEf = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hEg = bVar;
    }
}
