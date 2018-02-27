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
    private Interpolator bJt;
    private Animation.AnimationListener cHw;
    private boolean hFF;
    private int hFG;
    private View hFH;
    private d hFI;
    private int hFJ;
    private a hFK;
    private b hFL;
    private AbsListView.OnScrollListener hFM;
    private int hFN;
    private boolean hFO;
    private c hFP;
    private float hpd;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void xq(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bGF();

        void xr(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Ra();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hpd = 0.0f;
        this.hFF = true;
        this.hFG = -1;
        this.hFN = -1;
        this.hFO = false;
        this.cHw = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hFP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ra() {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFL != null) {
                    TransparentHeadGridView.this.hFL.bGF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFK != null && TransparentHeadGridView.this.hFN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFK.xq(100);
                        TransparentHeadGridView.this.hFN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFG < 0) {
                        TransparentHeadGridView.this.hFG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFG);
                    TransparentHeadGridView.this.hFF = i4 == 0;
                    if (TransparentHeadGridView.this.hFH != null) {
                        TransparentHeadGridView.this.hFH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hFN) {
                        TransparentHeadGridView.this.hFK.xq(height);
                        TransparentHeadGridView.this.hFN = height;
                    }
                }
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hpd = 0.0f;
        this.hFF = true;
        this.hFG = -1;
        this.hFN = -1;
        this.hFO = false;
        this.cHw = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hFP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ra() {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFL != null) {
                    TransparentHeadGridView.this.hFL.bGF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFK != null && TransparentHeadGridView.this.hFN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFK.xq(100);
                        TransparentHeadGridView.this.hFN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFG < 0) {
                        TransparentHeadGridView.this.hFG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFG);
                    TransparentHeadGridView.this.hFF = i4 == 0;
                    if (TransparentHeadGridView.this.hFH != null) {
                        TransparentHeadGridView.this.hFH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hFN) {
                        TransparentHeadGridView.this.hFK.xq(height);
                        TransparentHeadGridView.this.hFN = height;
                    }
                }
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hpd = 0.0f;
        this.hFF = true;
        this.hFG = -1;
        this.hFN = -1;
        this.hFO = false;
        this.cHw = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hFP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Ra() {
                if (TransparentHeadGridView.this.hFO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFL != null) {
                    TransparentHeadGridView.this.hFL.bGF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFK != null && TransparentHeadGridView.this.hFN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFK.xq(100);
                        TransparentHeadGridView.this.hFN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFG < 0) {
                        TransparentHeadGridView.this.hFG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFG);
                    TransparentHeadGridView.this.hFF = i4 == 0;
                    if (TransparentHeadGridView.this.hFH != null) {
                        TransparentHeadGridView.this.hFH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hFN) {
                        TransparentHeadGridView.this.hFK.xq(height);
                        TransparentHeadGridView.this.hFN = height;
                    }
                }
                if (TransparentHeadGridView.this.hFM != null) {
                    TransparentHeadGridView.this.hFM.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hFJ = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hpd = 0.0f;
                if (this.hFO && getPaddingTop() > this.hFJ) {
                    a(getHeight(), 200L, 0L, this.hFP);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hpd == 0.0f) {
                    this.hpd = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hpd && getPaddingTop() == 0 && this.hFF) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hpd) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hFL != null && i >= 0 && this.hFJ > 0 && i <= this.hFJ) {
                        this.hFL.xr((i * 100) / this.hFJ);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGE() {
        setPadding(0, (int) ((10.0f - this.hpd) / 2.0f), 0, 0);
        this.mState = 0;
        this.hpd = 0.0f;
        if (this.hFO && getPaddingTop() > this.hFJ) {
            a(getHeight(), 200L, 0L, this.hFP);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hFM = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hFH = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hFI != null) {
            this.hFI.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bJt == null) {
                this.bJt = new DecelerateInterpolator();
            }
            this.hFI = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hFI, j2);
            } else {
                post(this.hFI);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bJI;
        private final int bJJ;
        private c hFR;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bJL = true;
        private long mStartTime = -1;
        private int bJM = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bJJ = i;
            this.bJI = i2;
            this.mInterpolator = TransparentHeadGridView.this.bJt;
            this.mDuration = j;
            this.hFR = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJM = this.bJJ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bJJ - this.bJI));
                TransparentHeadGridView.this.setPadding(0, this.bJM, 0, 0);
                if (TransparentHeadGridView.this.hFL != null && this.bJM >= 0 && TransparentHeadGridView.this.hFJ > 0 && this.bJM <= TransparentHeadGridView.this.hFJ) {
                    TransparentHeadGridView.this.hFL.xr((this.bJM * 100) / TransparentHeadGridView.this.hFJ);
                }
            }
            if (this.bJL && this.bJI != this.bJM) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hFR != null) {
                this.hFR.Ra();
            }
        }

        public void stop() {
            this.bJL = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hFK = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hFL = bVar;
    }
}
