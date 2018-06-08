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
/* loaded from: classes3.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator bct;
    private Animation.AnimationListener cgu;
    private float gXN;
    private boolean hpE;
    private int hpF;
    private View hpG;
    private d hpH;
    private int hpI;
    private a hpJ;
    private b hpK;
    private AbsListView.OnScrollListener hpL;
    private int hpM;
    private boolean hpN;
    private c hpO;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void vl(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bHb();

        void vm(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void Na();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gXN = 0.0f;
        this.hpE = true;
        this.hpF = -1;
        this.hpM = -1;
        this.hpN = false;
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hpO = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Na() {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hpK != null) {
                    TransparentHeadGridView.this.hpK.bHb();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hpJ != null && TransparentHeadGridView.this.hpM != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hpJ.vl(100);
                        TransparentHeadGridView.this.hpM = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hpF < 0) {
                        TransparentHeadGridView.this.hpF = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hpF);
                    TransparentHeadGridView.this.hpE = i4 == 0;
                    if (TransparentHeadGridView.this.hpG != null) {
                        TransparentHeadGridView.this.hpG.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hpJ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hpM) {
                        TransparentHeadGridView.this.hpJ.vl(height);
                        TransparentHeadGridView.this.hpM = height;
                    }
                }
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gXN = 0.0f;
        this.hpE = true;
        this.hpF = -1;
        this.hpM = -1;
        this.hpN = false;
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hpO = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Na() {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hpK != null) {
                    TransparentHeadGridView.this.hpK.bHb();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hpJ != null && TransparentHeadGridView.this.hpM != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hpJ.vl(100);
                        TransparentHeadGridView.this.hpM = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hpF < 0) {
                        TransparentHeadGridView.this.hpF = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hpF);
                    TransparentHeadGridView.this.hpE = i4 == 0;
                    if (TransparentHeadGridView.this.hpG != null) {
                        TransparentHeadGridView.this.hpG.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hpJ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hpM) {
                        TransparentHeadGridView.this.hpJ.vl(height);
                        TransparentHeadGridView.this.hpM = height;
                    }
                }
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gXN = 0.0f;
        this.hpE = true;
        this.hpF = -1;
        this.hpM = -1;
        this.hpN = false;
        this.cgu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hpO = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Na() {
                if (TransparentHeadGridView.this.hpN) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hpK != null) {
                    TransparentHeadGridView.this.hpK.bHb();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hpJ != null && TransparentHeadGridView.this.hpM != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hpJ.vl(100);
                        TransparentHeadGridView.this.hpM = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hpF < 0) {
                        TransparentHeadGridView.this.hpF = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hpF);
                    TransparentHeadGridView.this.hpE = i4 == 0;
                    if (TransparentHeadGridView.this.hpG != null) {
                        TransparentHeadGridView.this.hpG.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hpJ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hpM) {
                        TransparentHeadGridView.this.hpJ.vl(height);
                        TransparentHeadGridView.this.hpM = height;
                    }
                }
                if (TransparentHeadGridView.this.hpL != null) {
                    TransparentHeadGridView.this.hpL.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hpI = (int) (l.aj(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gXN = 0.0f;
                if (this.hpN && getPaddingTop() > this.hpI) {
                    a(getHeight(), 200L, 0L, this.hpO);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.gXN == 0.0f) {
                    this.gXN = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gXN && getPaddingTop() == 0 && this.hpE) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gXN) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hpK != null && i >= 0 && this.hpI > 0 && i <= this.hpI) {
                        this.hpK.vm((i * 100) / this.hpI);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bHa() {
        setPadding(0, (int) ((10.0f - this.gXN) / 2.0f), 0, 0);
        this.mState = 0;
        this.gXN = 0.0f;
        if (this.hpN && getPaddingTop() > this.hpI) {
            a(getHeight(), 200L, 0L, this.hpO);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hpL = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hpG = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hpH != null) {
            this.hpH.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bct == null) {
                this.bct = new DecelerateInterpolator();
            }
            this.hpH = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hpH, j2);
            } else {
                post(this.hpH);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bcG;
        private final int bcH;
        private c hpQ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bcJ = true;
        private long mStartTime = -1;
        private int bcK = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bcH = i;
            this.bcG = i2;
            this.mInterpolator = TransparentHeadGridView.this.bct;
            this.mDuration = j;
            this.hpQ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bcK = this.bcH - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bcH - this.bcG));
                TransparentHeadGridView.this.setPadding(0, this.bcK, 0, 0);
                if (TransparentHeadGridView.this.hpK != null && this.bcK >= 0 && TransparentHeadGridView.this.hpI > 0 && this.bcK <= TransparentHeadGridView.this.hpI) {
                    TransparentHeadGridView.this.hpK.vm((this.bcK * 100) / TransparentHeadGridView.this.hpI);
                }
            }
            if (this.bcJ && this.bcG != this.bcK) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hpQ != null) {
                this.hpQ.Na();
            }
        }

        public void stop() {
            this.bcJ = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hpJ = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hpK = bVar;
    }
}
