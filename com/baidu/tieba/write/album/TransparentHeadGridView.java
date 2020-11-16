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
    private View bDA;
    private Interpolator bDB;
    private int bDD;
    private AbsListView.OnScrollListener bDG;
    private int bDH;
    private boolean bDI;
    private Animation.AnimationListener bDJ;
    private float bDx;
    private boolean bDy;
    private int bDz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d nHQ;
    private a nHR;
    private b nHS;
    private c nHT;

    /* loaded from: classes3.dex */
    public interface a {
        void fX(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void TC();

        void fY(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void TB();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bDx = 0.0f;
        this.bDy = true;
        this.bDz = -1;
        this.bDH = -1;
        this.bDI = false;
        this.bDJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nHT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void TB() {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nHS != null) {
                    TransparentHeadGridView.this.nHS.TC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nHR != null && TransparentHeadGridView.this.bDH != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nHR.fX(100);
                        TransparentHeadGridView.this.bDH = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bDz < 0) {
                        TransparentHeadGridView.this.bDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bDz);
                    TransparentHeadGridView.this.bDy = i4 == 0;
                    if (TransparentHeadGridView.this.bDA != null) {
                        TransparentHeadGridView.this.bDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bDH) {
                        TransparentHeadGridView.this.nHR.fX(height);
                        TransparentHeadGridView.this.bDH = height;
                    }
                }
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bDx = 0.0f;
        this.bDy = true;
        this.bDz = -1;
        this.bDH = -1;
        this.bDI = false;
        this.bDJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nHT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void TB() {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nHS != null) {
                    TransparentHeadGridView.this.nHS.TC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nHR != null && TransparentHeadGridView.this.bDH != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nHR.fX(100);
                        TransparentHeadGridView.this.bDH = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bDz < 0) {
                        TransparentHeadGridView.this.bDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bDz);
                    TransparentHeadGridView.this.bDy = i4 == 0;
                    if (TransparentHeadGridView.this.bDA != null) {
                        TransparentHeadGridView.this.bDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bDH) {
                        TransparentHeadGridView.this.nHR.fX(height);
                        TransparentHeadGridView.this.bDH = height;
                    }
                }
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bDx = 0.0f;
        this.bDy = true;
        this.bDz = -1;
        this.bDH = -1;
        this.bDI = false;
        this.bDJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nHT = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void TB() {
                if (TransparentHeadGridView.this.bDI) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nHS != null) {
                    TransparentHeadGridView.this.nHS.TC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nHR != null && TransparentHeadGridView.this.bDH != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nHR.fX(100);
                        TransparentHeadGridView.this.bDH = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bDz < 0) {
                        TransparentHeadGridView.this.bDz = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bDz);
                    TransparentHeadGridView.this.bDy = i4 == 0;
                    if (TransparentHeadGridView.this.bDA != null) {
                        TransparentHeadGridView.this.bDA.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bDH) {
                        TransparentHeadGridView.this.nHR.fX(height);
                        TransparentHeadGridView.this.bDH = height;
                    }
                }
                if (TransparentHeadGridView.this.bDG != null) {
                    TransparentHeadGridView.this.bDG.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bDD = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bDx = 0.0f;
                if (this.bDI && getPaddingTop() > this.bDD) {
                    a(getHeight(), 200L, 0L, this.nHT);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bDx == 0.0f) {
                    this.bDx = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bDx && getPaddingTop() == 0 && this.bDy) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bDx) / 2.0f);
                    if (this.nHS != null && i >= 0 && this.bDD > 0 && i <= this.bDD) {
                        this.nHS.fY((i * 100) / this.bDD);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void TA() {
        setPadding(0, (int) ((10.0f - this.bDx) / 2.0f), 0, 0);
        this.mState = 0;
        this.bDx = 0.0f;
        if (this.bDI && getPaddingTop() > this.bDD) {
            a(getHeight(), 200L, 0L, this.nHT);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bDG = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bDA = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.nHQ != null) {
            this.nHQ.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bDB == null) {
                this.bDB = new DecelerateInterpolator();
            }
            this.nHQ = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.nHQ, j2);
            } else {
                post(this.nHQ);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bDM;
        private final int bDN;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c nHV;
        private boolean bDP = true;
        private long mStartTime = -1;
        private int bDQ = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bDN = i;
            this.bDM = i2;
            this.mInterpolator = TransparentHeadGridView.this.bDB;
            this.mDuration = j;
            this.nHV = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bDQ = this.bDN - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bDN - this.bDM));
                TransparentHeadGridView.this.setPadding(0, this.bDQ, 0, 0);
                if (TransparentHeadGridView.this.nHS != null && this.bDQ >= 0 && TransparentHeadGridView.this.bDD > 0 && this.bDQ <= TransparentHeadGridView.this.bDD) {
                    TransparentHeadGridView.this.nHS.fY((this.bDQ * 100) / TransparentHeadGridView.this.bDD);
                }
            }
            if (this.bDP && this.bDM != this.bDQ) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.nHV != null) {
                this.nHV.TB();
            }
        }

        public void stop() {
            this.bDP = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.nHR = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.nHS = bVar;
    }
}
