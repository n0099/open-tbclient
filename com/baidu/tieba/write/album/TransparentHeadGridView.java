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
import com.baidu.adp.lib.util.l;
/* loaded from: classes13.dex */
public class TransparentHeadGridView extends GridView {
    private float aDd;
    private boolean aDe;
    private int aDf;
    private View aDg;
    private Interpolator aDh;
    private int aDj;
    private AbsListView.OnScrollListener aDm;
    private int aDn;
    private boolean aDo;
    private Animation.AnimationListener aDp;
    private d kNG;
    private a kNH;
    private b kNI;
    private c kNJ;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes13.dex */
    public interface a {
        void cT(int i);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void AS();

        void cU(int i);
    }

    /* loaded from: classes13.dex */
    public interface c {
        void AR();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNJ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNI != null) {
                    TransparentHeadGridView.this.kNI.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNH != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNH.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNH != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.kNH.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNJ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNI != null) {
                    TransparentHeadGridView.this.kNI.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNH != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNH.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNH != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.kNH.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNJ = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNI != null) {
                    TransparentHeadGridView.this.kNI.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNH != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNH.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNH != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.kNH.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aDj = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aDd = 0.0f;
                if (this.aDo && getPaddingTop() > this.aDj) {
                    a(getHeight(), 200L, 0L, this.kNJ);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aDd == 0.0f) {
                    this.aDd = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aDd && getPaddingTop() == 0 && this.aDe) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aDd) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.kNI != null && i >= 0 && this.aDj > 0 && i <= this.aDj) {
                        this.kNI.cU((i * 100) / this.aDj);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void AQ() {
        setPadding(0, (int) ((10.0f - this.aDd) / 2.0f), 0, 0);
        this.mState = 0;
        this.aDd = 0.0f;
        if (this.aDo && getPaddingTop() > this.aDj) {
            a(getHeight(), 200L, 0L, this.kNJ);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aDm = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aDg = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.kNG != null) {
            this.kNG.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aDh == null) {
                this.aDh = new DecelerateInterpolator();
            }
            this.kNG = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.kNG, j2);
            } else {
                post(this.kNG);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements Runnable {
        private final int aDs;
        private final int aDt;
        private c kNL;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aDt = i;
            this.aDs = i2;
            this.mInterpolator = TransparentHeadGridView.this.aDh;
            this.mDuration = j;
            this.kNL = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDt - this.aDs));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.kNI != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.aDj > 0 && this.mCurrentY <= TransparentHeadGridView.this.aDj) {
                    TransparentHeadGridView.this.kNI.cU((this.mCurrentY * 100) / TransparentHeadGridView.this.aDj);
                }
            }
            if (this.aDv && this.aDs != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.kNL != null) {
                this.kNL.AR();
            }
        }

        public void stop() {
            this.aDv = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.kNH = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.kNI = bVar;
    }
}
