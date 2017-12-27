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
    private Interpolator bHl;
    private Animation.AnimationListener cDs;
    private int hOA;
    private boolean hOB;
    private c hOC;
    private boolean hOs;
    private int hOt;
    private View hOu;
    private d hOv;
    private int hOw;
    private a hOx;
    private b hOy;
    private AbsListView.OnScrollListener hOz;
    private float hye;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void yN(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bMq();

        void yO(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void QG();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hye = 0.0f;
        this.hOs = true;
        this.hOt = -1;
        this.hOA = -1;
        this.hOB = false;
        this.cDs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOC = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QG() {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hOy != null) {
                    TransparentHeadGridView.this.hOy.bMq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hOx != null && TransparentHeadGridView.this.hOA != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hOx.yN(100);
                        TransparentHeadGridView.this.hOA = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hOt < 0) {
                        TransparentHeadGridView.this.hOt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hOt);
                    TransparentHeadGridView.this.hOs = i4 == 0;
                    if (TransparentHeadGridView.this.hOu != null) {
                        TransparentHeadGridView.this.hOu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hOx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hOA) {
                        TransparentHeadGridView.this.hOx.yN(height);
                        TransparentHeadGridView.this.hOA = height;
                    }
                }
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hye = 0.0f;
        this.hOs = true;
        this.hOt = -1;
        this.hOA = -1;
        this.hOB = false;
        this.cDs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOC = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QG() {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hOy != null) {
                    TransparentHeadGridView.this.hOy.bMq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hOx != null && TransparentHeadGridView.this.hOA != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hOx.yN(100);
                        TransparentHeadGridView.this.hOA = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hOt < 0) {
                        TransparentHeadGridView.this.hOt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hOt);
                    TransparentHeadGridView.this.hOs = i4 == 0;
                    if (TransparentHeadGridView.this.hOu != null) {
                        TransparentHeadGridView.this.hOu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hOx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hOA) {
                        TransparentHeadGridView.this.hOx.yN(height);
                        TransparentHeadGridView.this.hOA = height;
                    }
                }
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hye = 0.0f;
        this.hOs = true;
        this.hOt = -1;
        this.hOA = -1;
        this.hOB = false;
        this.cDs = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hOC = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QG() {
                if (TransparentHeadGridView.this.hOB) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hOy != null) {
                    TransparentHeadGridView.this.hOy.bMq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hOx != null && TransparentHeadGridView.this.hOA != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hOx.yN(100);
                        TransparentHeadGridView.this.hOA = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hOt < 0) {
                        TransparentHeadGridView.this.hOt = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hOt);
                    TransparentHeadGridView.this.hOs = i4 == 0;
                    if (TransparentHeadGridView.this.hOu != null) {
                        TransparentHeadGridView.this.hOu.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hOx != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hOA) {
                        TransparentHeadGridView.this.hOx.yN(height);
                        TransparentHeadGridView.this.hOA = height;
                    }
                }
                if (TransparentHeadGridView.this.hOz != null) {
                    TransparentHeadGridView.this.hOz.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hOw = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hye = 0.0f;
                if (this.hOB && getPaddingTop() > this.hOw) {
                    a(getHeight(), 200L, 0L, this.hOC);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hye == 0.0f) {
                    this.hye = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hye && getPaddingTop() == 0 && this.hOs) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hye) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hOy != null && i >= 0 && this.hOw > 0 && i <= this.hOw) {
                        this.hOy.yO((i * 100) / this.hOw);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bMp() {
        setPadding(0, (int) ((10.0f - this.hye) / 2.0f), 0, 0);
        this.mState = 0;
        this.hye = 0.0f;
        if (this.hOB && getPaddingTop() > this.hOw) {
            a(getHeight(), 200L, 0L, this.hOC);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hOz = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hOu = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hOv != null) {
            this.hOv.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bHl == null) {
                this.bHl = new DecelerateInterpolator();
            }
            this.hOv = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hOv, j2);
            } else {
                post(this.hOv);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bHA;
        private final int bHB;
        private c hOE;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bHD = true;
        private long mStartTime = -1;
        private int bHE = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bHB = i;
            this.bHA = i2;
            this.mInterpolator = TransparentHeadGridView.this.bHl;
            this.mDuration = j;
            this.hOE = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bHE = this.bHB - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bHB - this.bHA));
                TransparentHeadGridView.this.setPadding(0, this.bHE, 0, 0);
                if (TransparentHeadGridView.this.hOy != null && this.bHE >= 0 && TransparentHeadGridView.this.hOw > 0 && this.bHE <= TransparentHeadGridView.this.hOw) {
                    TransparentHeadGridView.this.hOy.yO((this.bHE * 100) / TransparentHeadGridView.this.hOw);
                }
            }
            if (this.bHD && this.bHA != this.bHE) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hOE != null) {
                this.hOE.QG();
            }
        }

        public void stop() {
            this.bHD = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hOx = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hOy = bVar;
    }
}
