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
    private Interpolator bHB;
    private Animation.AnimationListener cDP;
    private b hEA;
    private AbsListView.OnScrollListener hEB;
    private int hEC;
    private boolean hED;
    private c hEE;
    private boolean hEu;
    private int hEv;
    private View hEw;
    private d hEx;
    private int hEy;
    private a hEz;
    private float hob;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void xq(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bFS();

        void xr(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Qw();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hob = 0.0f;
        this.hEu = true;
        this.hEv = -1;
        this.hEC = -1;
        this.hED = false;
        this.cDP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qw() {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEA != null) {
                    TransparentHeadGridView.this.hEA.bFS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEz != null && TransparentHeadGridView.this.hEC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEz.xq(100);
                        TransparentHeadGridView.this.hEC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEv < 0) {
                        TransparentHeadGridView.this.hEv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEv);
                    TransparentHeadGridView.this.hEu = i4 == 0;
                    if (TransparentHeadGridView.this.hEw != null) {
                        TransparentHeadGridView.this.hEw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEC) {
                        TransparentHeadGridView.this.hEz.xq(height);
                        TransparentHeadGridView.this.hEC = height;
                    }
                }
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hob = 0.0f;
        this.hEu = true;
        this.hEv = -1;
        this.hEC = -1;
        this.hED = false;
        this.cDP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qw() {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEA != null) {
                    TransparentHeadGridView.this.hEA.bFS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEz != null && TransparentHeadGridView.this.hEC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEz.xq(100);
                        TransparentHeadGridView.this.hEC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEv < 0) {
                        TransparentHeadGridView.this.hEv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEv);
                    TransparentHeadGridView.this.hEu = i4 == 0;
                    if (TransparentHeadGridView.this.hEw != null) {
                        TransparentHeadGridView.this.hEw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEC) {
                        TransparentHeadGridView.this.hEz.xq(height);
                        TransparentHeadGridView.this.hEC = height;
                    }
                }
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hob = 0.0f;
        this.hEu = true;
        this.hEv = -1;
        this.hEC = -1;
        this.hED = false;
        this.cDP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hEE = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Qw() {
                if (TransparentHeadGridView.this.hED) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hEA != null) {
                    TransparentHeadGridView.this.hEA.bFS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hEz != null && TransparentHeadGridView.this.hEC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hEz.xq(100);
                        TransparentHeadGridView.this.hEC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hEv < 0) {
                        TransparentHeadGridView.this.hEv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hEv);
                    TransparentHeadGridView.this.hEu = i4 == 0;
                    if (TransparentHeadGridView.this.hEw != null) {
                        TransparentHeadGridView.this.hEw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hEz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hEC) {
                        TransparentHeadGridView.this.hEz.xq(height);
                        TransparentHeadGridView.this.hEC = height;
                    }
                }
                if (TransparentHeadGridView.this.hEB != null) {
                    TransparentHeadGridView.this.hEB.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hEy = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hob = 0.0f;
                if (this.hED && getPaddingTop() > this.hEy) {
                    a(getHeight(), 200L, 0L, this.hEE);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hob == 0.0f) {
                    this.hob = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hob && getPaddingTop() == 0 && this.hEu) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hob) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hEA != null && i >= 0 && this.hEy > 0 && i <= this.hEy) {
                        this.hEA.xr((i * 100) / this.hEy);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bFR() {
        setPadding(0, (int) ((10.0f - this.hob) / 2.0f), 0, 0);
        this.mState = 0;
        this.hob = 0.0f;
        if (this.hED && getPaddingTop() > this.hEy) {
            a(getHeight(), 200L, 0L, this.hEE);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hEB = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hEw = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hEx != null) {
            this.hEx.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bHB == null) {
                this.bHB = new DecelerateInterpolator();
            }
            this.hEx = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hEx, j2);
            } else {
                post(this.hEx);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bHQ;
        private final int bHR;
        private c hEG;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bHT = true;
        private long mStartTime = -1;
        private int bHU = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bHR = i;
            this.bHQ = i2;
            this.mInterpolator = TransparentHeadGridView.this.bHB;
            this.mDuration = j;
            this.hEG = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bHU = this.bHR - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bHR - this.bHQ));
                TransparentHeadGridView.this.setPadding(0, this.bHU, 0, 0);
                if (TransparentHeadGridView.this.hEA != null && this.bHU >= 0 && TransparentHeadGridView.this.hEy > 0 && this.bHU <= TransparentHeadGridView.this.hEy) {
                    TransparentHeadGridView.this.hEA.xr((this.bHU * 100) / TransparentHeadGridView.this.hEy);
                }
            }
            if (this.bHT && this.bHQ != this.bHU) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hEG != null) {
                this.hEG.Qw();
            }
        }

        public void stop() {
            this.bHT = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hEz = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hEA = bVar;
    }
}
